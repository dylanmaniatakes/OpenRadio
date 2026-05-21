package okhttp3.internal.publicsuffix;

import F3.f;
import F3.i;
import L3.b;
import L3.c;
import L3.g;
import M3.e;
import W3.AbstractC0189b;
import W3.C0193f;
import W3.I;
import W3.t;
import W3.v;
import W3.z;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import g0.AbstractC0535a;
import h4.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import t3.j;
import t3.q;

/* loaded from: classes.dex */
public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    public static final Companion Companion = new Companion(null);
    private static final byte[] WILDCARD_LABEL = {42};
    private static final List<String> PREVAILING_RULE = AbstractC0296a2.i("*");
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i5) {
            int i6;
            int iAnd;
            boolean z4;
            int iAnd2;
            int length = bArr.length;
            int i7 = 0;
            while (i7 < length) {
                int i8 = (i7 + length) / 2;
                while (i8 > -1 && bArr[i8] != 10) {
                    i8--;
                }
                int i9 = i8 + 1;
                int i10 = 1;
                while (true) {
                    i6 = i9 + i10;
                    if (bArr[i6] == 10) {
                        break;
                    }
                    i10++;
                }
                int i11 = i6 - i9;
                int i12 = i5;
                boolean z5 = false;
                int i13 = 0;
                int i14 = 0;
                while (true) {
                    if (z5) {
                        iAnd = 46;
                        z4 = false;
                    } else {
                        boolean z6 = z5;
                        iAnd = Util.and(bArr2[i12][i13], 255);
                        z4 = z6;
                    }
                    iAnd2 = iAnd - Util.and(bArr[i9 + i14], 255);
                    if (iAnd2 != 0) {
                        break;
                    }
                    i14++;
                    i13++;
                    if (i14 == i11) {
                        break;
                    }
                    if (bArr2[i12].length != i13) {
                        z5 = z4;
                    } else {
                        if (i12 == bArr2.length - 1) {
                            break;
                        }
                        i12++;
                        z5 = true;
                        i13 = -1;
                    }
                }
                if (iAnd2 >= 0) {
                    if (iAnd2 <= 0) {
                        int i15 = i11 - i14;
                        int length2 = bArr2[i12].length - i13;
                        int length3 = bArr2.length;
                        for (int i16 = i12 + 1; i16 < length3; i16++) {
                            length2 += bArr2[i16].length;
                        }
                        if (length2 >= i15) {
                            if (length2 <= i15) {
                                Charset charset = StandardCharsets.UTF_8;
                                i.e(charset, "UTF_8");
                                return new String(bArr, i9, i11, charset);
                            }
                        }
                    }
                    i7 = i6 + 1;
                }
                length = i8;
            }
            return null;
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    private final List<String> findMatchingRule(List<String> list) throws InterruptedException {
        String str;
        String strBinarySearch;
        String strBinarySearch2;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (this.publicSuffixListBytes == null) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
        int size = list.size();
        byte[][] bArr = new byte[size][];
        for (int i5 = 0; i5 < size; i5++) {
            String str2 = list.get(i5);
            Charset charset = StandardCharsets.UTF_8;
            i.e(charset, "UTF_8");
            byte[] bytes = str2.getBytes(charset);
            i.e(bytes, "this as java.lang.String).getBytes(charset)");
            bArr[i5] = bytes;
        }
        int i6 = 0;
        while (true) {
            str = null;
            if (i6 >= size) {
                strBinarySearch = null;
                break;
            }
            Companion companion = Companion;
            byte[] bArr2 = this.publicSuffixListBytes;
            if (bArr2 == null) {
                i.k("publicSuffixListBytes");
                throw null;
            }
            strBinarySearch = companion.binarySearch(bArr2, bArr, i6);
            if (strBinarySearch != null) {
                break;
            }
            i6++;
        }
        if (size > 1) {
            byte[][] bArr3 = (byte[][]) bArr.clone();
            int length = bArr3.length - 1;
            for (int i7 = 0; i7 < length; i7++) {
                bArr3[i7] = WILDCARD_LABEL;
                Companion companion2 = Companion;
                byte[] bArr4 = this.publicSuffixListBytes;
                if (bArr4 == null) {
                    i.k("publicSuffixListBytes");
                    throw null;
                }
                strBinarySearch2 = companion2.binarySearch(bArr4, bArr3, i7);
                if (strBinarySearch2 != null) {
                    break;
                }
            }
            strBinarySearch2 = null;
        } else {
            strBinarySearch2 = null;
        }
        if (strBinarySearch2 != null) {
            int i8 = size - 1;
            int i9 = 0;
            while (true) {
                if (i9 >= i8) {
                    break;
                }
                Companion companion3 = Companion;
                byte[] bArr5 = this.publicSuffixExceptionListBytes;
                if (bArr5 == null) {
                    i.k("publicSuffixExceptionListBytes");
                    throw null;
                }
                String strBinarySearch3 = companion3.binarySearch(bArr5, bArr, i9);
                if (strBinarySearch3 != null) {
                    str = strBinarySearch3;
                    break;
                }
                i9++;
            }
        }
        if (str != null) {
            return e.K("!".concat(str), new char[]{'.'});
        }
        if (strBinarySearch == null && strBinarySearch2 == null) {
            return PREVAILING_RULE;
        }
        List<String> listK = q.f9711j;
        List<String> listK2 = strBinarySearch != null ? e.K(strBinarySearch, new char[]{'.'}) : listK;
        if (strBinarySearch2 != null) {
            listK = e.K(strBinarySearch2, new char[]{'.'});
        }
        return listK2.size() > listK.size() ? listK2 : listK;
    }

    private final void readTheList() throws IOException {
        try {
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
            if (resourceAsStream == null) {
                return;
            }
            Logger logger = v.f2665a;
            z zVarC = AbstractC0189b.c(new t(new C0193f(resourceAsStream, new I())));
            try {
                long jM = zVarC.m();
                zVarC.N(jM);
                byte[] bArrX = zVarC.f2677k.X(jM);
                long jM2 = zVarC.m();
                zVarC.N(jM2);
                byte[] bArrX2 = zVarC.f2677k.X(jM2);
                AbstractC0399v1.b(zVarC, null);
                synchronized (this) {
                    this.publicSuffixListBytes = bArrX;
                    this.publicSuffixExceptionListBytes = bArrX2;
                }
            } finally {
            }
        } finally {
            this.readCompleteLatch.countDown();
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z4 = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z4 = true;
                } catch (IOException e5) {
                    Platform.Companion.get().log("Failed to read public suffix list", 5, e5);
                    if (z4) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z4) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z4) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<String> splitDomain(String str) {
        List<String> listK = e.K(str, new char[]{'.'});
        if (listK.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        if (!i.a(listK.get(j.x(listK)), "")) {
            return listK;
        }
        int size = listK.size() - 1;
        if (size < 0) {
            size = 0;
        }
        if (size < 0) {
            throw new IllegalArgumentException(AbstractC0535a.j("Requested element count ", size, " is less than zero.").toString());
        }
        q qVar = q.f9711j;
        if (size == 0) {
            return qVar;
        }
        if (size >= listK.size()) {
            return t3.i.H(listK);
        }
        if (size == 1) {
            if (listK.isEmpty()) {
                throw new NoSuchElementException("List is empty.");
            }
            return AbstractC0296a2.i(listK.get(0));
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator<T> it = listK.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i5++;
            if (i5 == size) {
                break;
            }
        }
        int size2 = arrayList.size();
        return size2 != 0 ? size2 != 1 ? arrayList : AbstractC0296a2.i(arrayList.get(0)) : qVar;
    }

    public final String getEffectiveTldPlusOne(String str) throws InterruptedException {
        int size;
        int size2;
        i.f(str, "domain");
        String unicode = IDN.toUnicode(str);
        i.e(unicode, "unicodeDomain");
        List<String> listSplitDomain = splitDomain(unicode);
        List<String> listFindMatchingRule = findMatchingRule(listSplitDomain);
        int i5 = 0;
        if (listSplitDomain.size() == listFindMatchingRule.size() && listFindMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (listFindMatchingRule.get(0).charAt(0) == '!') {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size();
        } else {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size() + 1;
        }
        int i6 = size - size2;
        List<String> listSplitDomain2 = splitDomain(str);
        i.f(listSplitDomain2, "<this>");
        c gVar = new g(1, listSplitDomain2);
        if (i6 < 0) {
            throw new IllegalArgumentException(AbstractC0535a.j("Requested element count ", i6, " is less than zero.").toString());
        }
        if (i6 != 0) {
            gVar = new b(gVar, i6);
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        for (Object obj : gVar) {
            i5++;
            if (i5 > 1) {
                sb.append((CharSequence) ".");
            }
            d.a(sb, obj, null);
        }
        sb.append((CharSequence) "");
        String string = sb.toString();
        i.e(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public final void setListBytes(byte[] bArr, byte[] bArr2) {
        i.f(bArr, "publicSuffixListBytes");
        i.f(bArr2, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
