package okhttp3.internal.http2;

import F3.f;
import F3.i;
import W3.AbstractC0189b;
import W3.F;
import W3.l;
import W3.n;
import W3.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.Util;
import t3.h;

/* loaded from: classes.dex */
public final class Hpack {
    public static final Hpack INSTANCE;
    private static final Map<o, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    private static final Header[] STATIC_HEADER_TABLE;

    public static final class Reader {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final n source;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Reader(F f5, int i5) {
            this(f5, i5, 0, 4, null);
            i.f(f5, "source");
        }

        private final void adjustDynamicTableByteCount() {
            int i5 = this.maxDynamicTableByteCount;
            int i6 = this.dynamicTableByteCount;
            if (i5 < i6) {
                if (i5 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i6 - i5);
                }
            }
        }

        private final void clearDynamicTable() {
            Header[] headerArr = this.dynamicTable;
            h.u(headerArr, null, 0, headerArr.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int i5) {
            return this.nextHeaderIndex + 1 + i5;
        }

        private final int evictToRecoverBytes(int i5) {
            int i6;
            int i7 = 0;
            if (i5 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i6 = this.nextHeaderIndex;
                    if (length < i6 || i5 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    i.c(header);
                    int i8 = header.hpackSize;
                    i5 -= i8;
                    this.dynamicTableByteCount -= i8;
                    this.headerCount--;
                    i7++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i6 + 1, headerArr, i6 + 1 + i7, this.headerCount);
                this.nextHeaderIndex += i7;
            }
            return i7;
        }

        private final o getName(int i5) throws IOException {
            if (isStaticHeader(i5)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i5].name;
            }
            int iDynamicTableIndex = dynamicTableIndex(i5 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    Header header = headerArr[iDynamicTableIndex];
                    i.c(header);
                    return header.name;
                }
            }
            throw new IOException("Header index too large " + (i5 + 1));
        }

        private final void insertIntoDynamicTable(int i5, Header header) {
            this.headerList.add(header);
            int i6 = header.hpackSize;
            if (i5 != -1) {
                Header header2 = this.dynamicTable[dynamicTableIndex(i5)];
                i.c(header2);
                i6 -= header2.hpackSize;
            }
            int i7 = this.maxDynamicTableByteCount;
            if (i6 > i7) {
                clearDynamicTable();
                return;
            }
            int iEvictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i6) - i7);
            if (i5 == -1) {
                int i8 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i8 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i9 = this.nextHeaderIndex;
                this.nextHeaderIndex = i9 - 1;
                this.dynamicTable[i9] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[dynamicTableIndex(i5) + iEvictToRecoverBytes + i5] = header;
            }
            this.dynamicTableByteCount += i6;
        }

        private final boolean isStaticHeader(int i5) {
            return i5 >= 0 && i5 <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        private final int readByte() throws IOException {
            return Util.and(this.source.U(), 255);
        }

        private final void readIndexedHeader(int i5) throws IOException {
            if (isStaticHeader(i5)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i5]);
                return;
            }
            int iDynamicTableIndex = dynamicTableIndex(i5 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    List<Header> list = this.headerList;
                    Header header = headerArr[iDynamicTableIndex];
                    i.c(header);
                    list.add(header);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i5 + 1));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int i5) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i5), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int i5) throws IOException {
            this.headerList.add(new Header(getName(i5), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        public final List<Header> getAndResetHeaderList() {
            List<Header> listH = t3.i.H(this.headerList);
            this.headerList.clear();
            return listH;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public final o readByteString() throws IOException {
            int i5 = readByte();
            boolean z4 = (i5 & 128) == 128;
            long j5 = readInt(i5, 127);
            if (!z4) {
                return this.source.g(j5);
            }
            l lVar = new l();
            Huffman.INSTANCE.decode(this.source, j5, lVar);
            return lVar.g(lVar.f2648k);
        }

        public final void readHeaders() throws IOException {
            while (!this.source.y()) {
                int iAnd = Util.and(this.source.U(), 255);
                if (iAnd == 128) {
                    throw new IOException("index == 0");
                }
                if ((iAnd & 128) == 128) {
                    readIndexedHeader(readInt(iAnd, 127) - 1);
                } else if (iAnd == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((iAnd & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(iAnd, Hpack.PREFIX_6_BITS) - 1);
                } else if ((iAnd & 32) == 32) {
                    int i5 = readInt(iAnd, Hpack.PREFIX_5_BITS);
                    this.maxDynamicTableByteCount = i5;
                    if (i5 < 0 || i5 > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (iAnd == 16 || iAnd == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(iAnd, 15) - 1);
                }
            }
        }

        public final int readInt(int i5, int i6) throws IOException {
            int i7 = i5 & i6;
            if (i7 < i6) {
                return i7;
            }
            int i8 = 0;
            while (true) {
                int i9 = readByte();
                if ((i9 & 128) == 0) {
                    return i6 + (i9 << i8);
                }
                i6 += (i9 & 127) << i8;
                i8 += 7;
            }
        }

        public Reader(F f5, int i5, int i6) {
            i.f(f5, "source");
            this.headerTableSizeSetting = i5;
            this.maxDynamicTableByteCount = i6;
            this.headerList = new ArrayList();
            this.source = AbstractC0189b.c(f5);
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = 7;
        }

        public /* synthetic */ Reader(F f5, int i5, int i6, int i7, f fVar) {
            this(f5, i5, (i7 & 4) != 0 ? i5 : i6);
        }
    }

    public static final class Writer {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final l out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Writer(int i5, l lVar) {
            this(i5, false, lVar, 2, null);
            i.f(lVar, "out");
        }

        private final void adjustDynamicTableByteCount() {
            int i5 = this.maxDynamicTableByteCount;
            int i6 = this.dynamicTableByteCount;
            if (i5 < i6) {
                if (i5 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i6 - i5);
                }
            }
        }

        private final void clearDynamicTable() {
            Header[] headerArr = this.dynamicTable;
            h.u(headerArr, null, 0, headerArr.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int i5) {
            int i6;
            int i7 = 0;
            if (i5 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i6 = this.nextHeaderIndex;
                    if (length < i6 || i5 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    i.c(header);
                    i5 -= header.hpackSize;
                    int i8 = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[length];
                    i.c(header2);
                    this.dynamicTableByteCount = i8 - header2.hpackSize;
                    this.headerCount--;
                    i7++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i6 + 1, headerArr, i6 + 1 + i7, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i9 = this.nextHeaderIndex;
                Arrays.fill(headerArr2, i9 + 1, i9 + 1 + i7, (Object) null);
                this.nextHeaderIndex += i7;
            }
            return i7;
        }

        private final void insertIntoDynamicTable(Header header) {
            int i5 = header.hpackSize;
            int i6 = this.maxDynamicTableByteCount;
            if (i5 > i6) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i5) - i6);
            int i7 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i7 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i8 = this.nextHeaderIndex;
            this.nextHeaderIndex = i8 - 1;
            this.dynamicTable[i8] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i5;
        }

        public final void resizeHeaderTable(int i5) {
            this.headerTableSizeSetting = i5;
            int iMin = Math.min(i5, 16384);
            int i6 = this.maxDynamicTableByteCount;
            if (i6 == iMin) {
                return;
            }
            if (iMin < i6) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, iMin);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = iMin;
            adjustDynamicTableByteCount();
        }

        public final void writeByteString(o oVar) throws IOException {
            i.f(oVar, "data");
            if (this.useCompression) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(oVar) < oVar.c()) {
                    l lVar = new l();
                    huffman.encode(oVar, lVar);
                    o oVarG = lVar.g(lVar.f2648k);
                    writeInt(oVarG.c(), 127, 128);
                    this.out.c0(oVarG);
                    return;
                }
            }
            writeInt(oVar.c(), 127, 0);
            this.out.c0(oVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void writeHeaders(java.util.List<okhttp3.internal.http2.Header> r13) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 276
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Hpack.Writer.writeHeaders(java.util.List):void");
        }

        public final void writeInt(int i5, int i6, int i7) {
            if (i5 < i6) {
                this.out.e0(i5 | i7);
                return;
            }
            this.out.e0(i7 | i6);
            int i8 = i5 - i6;
            while (i8 >= 128) {
                this.out.e0(128 | (i8 & 127));
                i8 >>>= 7;
            }
            this.out.e0(i8);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Writer(l lVar) {
            this(0, false, lVar, 3, null);
            i.f(lVar, "out");
        }

        public Writer(int i5, boolean z4, l lVar) {
            i.f(lVar, "out");
            this.headerTableSizeSetting = i5;
            this.useCompression = z4;
            this.out = lVar;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i5;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = r2.length - 1;
        }

        public /* synthetic */ Writer(int i5, boolean z4, l lVar, int i6, f fVar) {
            this((i6 & 1) != 0 ? Hpack.SETTINGS_HEADER_TABLE_SIZE : i5, (i6 & 2) != 0 ? true : z4, lVar);
        }
    }

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        Header header = new Header(Header.TARGET_AUTHORITY, "");
        o oVar = Header.TARGET_METHOD;
        Header header2 = new Header(oVar, "GET");
        Header header3 = new Header(oVar, "POST");
        o oVar2 = Header.TARGET_PATH;
        Header header4 = new Header(oVar2, "/");
        Header header5 = new Header(oVar2, "/index.html");
        o oVar3 = Header.TARGET_SCHEME;
        Header header6 = new Header(oVar3, "http");
        Header header7 = new Header(oVar3, "https");
        o oVar4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{header, header2, header3, header4, header5, header6, header7, new Header(oVar4, "200"), new Header(oVar4, "204"), new Header(oVar4, "206"), new Header(oVar4, "304"), new Header(oVar4, "400"), new Header(oVar4, "404"), new Header(oVar4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    private Hpack() {
    }

    private final Map<o, Integer> nameToFirstIndex() {
        Header[] headerArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length);
        int length = headerArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            Header[] headerArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(headerArr2[i5].name)) {
                linkedHashMap.put(headerArr2[i5].name, Integer.valueOf(i5));
            }
        }
        Map<o, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        i.e(mapUnmodifiableMap, "unmodifiableMap(result)");
        return mapUnmodifiableMap;
    }

    public final o checkLowercase(o oVar) throws IOException {
        i.f(oVar, "name");
        int iC = oVar.c();
        for (int i5 = 0; i5 < iC; i5++) {
            byte bF = oVar.f(i5);
            if (65 <= bF && bF < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(oVar.j()));
            }
        }
        return oVar;
    }

    public final Map<o, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }
}
