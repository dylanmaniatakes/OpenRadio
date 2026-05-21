package W3;

import g0.AbstractC0535a;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class t implements F {

    /* renamed from: j, reason: collision with root package name */
    public byte f2657j;

    /* renamed from: k, reason: collision with root package name */
    public final z f2658k;

    /* renamed from: l, reason: collision with root package name */
    public final Inflater f2659l;

    /* renamed from: m, reason: collision with root package name */
    public final u f2660m;
    public final CRC32 n;

    public t(F f5) {
        F3.i.f(f5, "source");
        z zVar = new z(f5);
        this.f2658k = zVar;
        Inflater inflater = new Inflater(true);
        this.f2659l = inflater;
        this.f2660m = new u(zVar, inflater);
        this.n = new CRC32();
    }

    public static void a(int i5, int i6, String str) throws IOException {
        if (i6 != i5) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i6), Integer.valueOf(i5)}, 3)));
        }
    }

    public final void c(long j5, l lVar, long j6) {
        A a2 = lVar.f2647j;
        F3.i.c(a2);
        while (true) {
            int i5 = a2.f2619c;
            int i6 = a2.f2618b;
            if (j5 < i5 - i6) {
                break;
            }
            j5 -= i5 - i6;
            a2 = a2.f2622f;
            F3.i.c(a2);
        }
        while (j6 > 0) {
            int iMin = (int) Math.min(a2.f2619c - r5, j6);
            this.n.update(a2.f2617a, (int) (a2.f2618b + j5), iMin);
            j6 -= iMin;
            a2 = a2.f2622f;
            F3.i.c(a2);
            j5 = 0;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f2660m.close();
    }

    @Override // W3.F
    public final long read(l lVar, long j5) throws DataFormatException, IOException {
        z zVar;
        l lVar2;
        long j6;
        F3.i.f(lVar, "sink");
        if (j5 < 0) {
            throw new IllegalArgumentException(AbstractC0535a.h(j5, "byteCount < 0: ").toString());
        }
        if (j5 == 0) {
            return 0L;
        }
        byte b5 = this.f2657j;
        CRC32 crc32 = this.n;
        z zVar2 = this.f2658k;
        if (b5 == 0) {
            zVar2.N(10L);
            l lVar3 = zVar2.f2677k;
            byte bX = lVar3.x(3L);
            boolean z4 = ((bX >> 1) & 1) == 1;
            if (z4) {
                c(0L, zVar2.f2677k, 10L);
            }
            a(8075, zVar2.K(), "ID1ID2");
            zVar2.i(8L);
            if (((bX >> 2) & 1) == 1) {
                zVar2.N(2L);
                if (z4) {
                    c(0L, zVar2.f2677k, 2L);
                }
                short sK = lVar3.K();
                long j7 = ((short) (((sK & 255) << 8) | ((sK & 65280) >>> 8))) & 65535;
                zVar2.N(j7);
                if (z4) {
                    c(0L, zVar2.f2677k, j7);
                    j6 = j7;
                } else {
                    j6 = j7;
                }
                zVar2.i(j6);
            }
            if (((bX >> 3) & 1) == 1) {
                lVar2 = lVar3;
                long jA = zVar2.a((byte) 0, 0L, Long.MAX_VALUE);
                if (jA == -1) {
                    throw new EOFException();
                }
                if (z4) {
                    zVar = zVar2;
                    c(0L, zVar2.f2677k, jA + 1);
                } else {
                    zVar = zVar2;
                }
                zVar.i(jA + 1);
            } else {
                lVar2 = lVar3;
                zVar = zVar2;
            }
            if (((bX >> 4) & 1) == 1) {
                long jA2 = zVar.a((byte) 0, 0L, Long.MAX_VALUE);
                if (jA2 == -1) {
                    throw new EOFException();
                }
                if (z4) {
                    c(0L, zVar.f2677k, jA2 + 1);
                }
                zVar.i(jA2 + 1);
            }
            if (z4) {
                zVar.N(2L);
                short sK2 = lVar2.K();
                a((short) (((sK2 & 255) << 8) | ((sK2 & 65280) >>> 8)), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            this.f2657j = (byte) 1;
        } else {
            zVar = zVar2;
        }
        if (this.f2657j == 1) {
            long j8 = lVar.f2648k;
            long j9 = this.f2660m.read(lVar, j5);
            if (j9 != -1) {
                c(j8, lVar, j9);
                return j9;
            }
            this.f2657j = (byte) 2;
        }
        if (this.f2657j != 2) {
            return -1L;
        }
        a(zVar.c(), (int) crc32.getValue(), "CRC");
        a(zVar.c(), (int) this.f2659l.getBytesWritten(), "ISIZE");
        this.f2657j = (byte) 3;
        if (zVar.y()) {
            return -1L;
        }
        throw new IOException("gzip finished without exhausting source");
    }

    @Override // W3.F
    public final I timeout() {
        return this.f2658k.f2676j.timeout();
    }
}
