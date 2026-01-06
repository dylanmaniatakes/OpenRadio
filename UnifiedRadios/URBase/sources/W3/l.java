package W3;

import com.google.android.gms.location.DeviceOrientationRequest;
import g0.AbstractC0535a;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import okhttp3.internal.connection.RealConnection;

/* loaded from: classes.dex */
public final class l implements n, m, Cloneable, ByteChannel {

    /* renamed from: j, reason: collision with root package name */
    public A f2647j;

    /* renamed from: k, reason: collision with root package name */
    public long f2648k;

    @Override // W3.m
    public final /* bridge */ /* synthetic */ m A(int i5) {
        e0(i5);
        return this;
    }

    @Override // W3.m
    public final /* bridge */ /* synthetic */ m B(o oVar) {
        c0(oVar);
        return this;
    }

    @Override // W3.m
    public final /* bridge */ /* synthetic */ m C(byte[] bArr) {
        d0(bArr);
        return this;
    }

    public final long D(byte b5, long j5, long j6) {
        A a2;
        long j7 = 0;
        if (0 > j5 || j5 > j6) {
            throw new IllegalArgumentException(("size=" + this.f2648k + " fromIndex=" + j5 + " toIndex=" + j6).toString());
        }
        long j8 = this.f2648k;
        if (j6 > j8) {
            j6 = j8;
        }
        if (j5 == j6 || (a2 = this.f2647j) == null) {
            return -1L;
        }
        if (j8 - j5 < j5) {
            while (j8 > j5) {
                a2 = a2.g;
                F3.i.c(a2);
                j8 -= a2.f2619c - a2.f2618b;
            }
            while (j8 < j6) {
                int iMin = (int) Math.min(a2.f2619c, (a2.f2618b + j6) - j8);
                for (int i5 = (int) ((a2.f2618b + j5) - j8); i5 < iMin; i5++) {
                    if (a2.f2617a[i5] == b5) {
                        return (i5 - a2.f2618b) + j8;
                    }
                }
                j8 += a2.f2619c - a2.f2618b;
                a2 = a2.f2622f;
                F3.i.c(a2);
                j5 = j8;
            }
            return -1L;
        }
        while (true) {
            long j9 = (a2.f2619c - a2.f2618b) + j7;
            if (j9 > j5) {
                break;
            }
            a2 = a2.f2622f;
            F3.i.c(a2);
            j7 = j9;
        }
        while (j7 < j6) {
            int iMin2 = (int) Math.min(a2.f2619c, (a2.f2618b + j6) - j7);
            for (int i6 = (int) ((a2.f2618b + j5) - j7); i6 < iMin2; i6++) {
                if (a2.f2617a[i6] == b5) {
                    return (i6 - a2.f2618b) + j7;
                }
            }
            j7 += a2.f2619c - a2.f2618b;
            a2 = a2.f2622f;
            F3.i.c(a2);
            j5 = j7;
        }
        return -1L;
    }

    @Override // W3.m
    public final m E() {
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        r2 = new W3.l();
        r2.f0(r9);
        r2.e0(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
    
        if (r12 != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        r2.U();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0062, code lost:
    
        throw new java.lang.NumberFormatException("Number too large: ".concat(r2.Z()));
     */
    @Override // W3.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long F() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.l.F():long");
    }

    @Override // W3.n
    public final String G(long j5) throws EOFException {
        if (j5 < 0) {
            throw new IllegalArgumentException(AbstractC0535a.h(j5, "limit < 0: ").toString());
        }
        long j6 = j5 != Long.MAX_VALUE ? j5 + 1 : Long.MAX_VALUE;
        long jD = D((byte) 10, 0L, j6);
        if (jD != -1) {
            return X3.a.b(this, jD);
        }
        if (j6 < this.f2648k && x(j6 - 1) == 13 && x(j6) == 10) {
            return X3.a.b(this, j6);
        }
        l lVar = new l();
        s(0L, lVar, Math.min(32, this.f2648k));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f2648k, j5) + " content=" + lVar.g(lVar.f2648k).d() + (char) 8230);
    }

    @Override // W3.n
    public final void H(l lVar, long j5) throws EOFException {
        F3.i.f(lVar, "sink");
        long j6 = this.f2648k;
        if (j6 >= j5) {
            lVar.write(this, j5);
        } else {
            lVar.write(this, j6);
            throw new EOFException();
        }
    }

    @Override // W3.n
    public final boolean J(long j5, o oVar) {
        F3.i.f(oVar, "bytes");
        int iC = oVar.c();
        if (j5 < 0 || iC < 0 || this.f2648k - j5 < iC || oVar.c() < iC) {
            return false;
        }
        for (int i5 = 0; i5 < iC; i5++) {
            if (x(i5 + j5) != oVar.f(i5)) {
                return false;
            }
        }
        return true;
    }

    @Override // W3.n
    public final short K() throws EOFException {
        if (this.f2648k < 2) {
            throw new EOFException();
        }
        A a2 = this.f2647j;
        F3.i.c(a2);
        int i5 = a2.f2618b;
        int i6 = a2.f2619c;
        if (i6 - i5 < 2) {
            return (short) (((U() & 255) << 8) | (U() & 255));
        }
        int i7 = i5 + 1;
        byte[] bArr = a2.f2617a;
        int i8 = (bArr[i5] & 255) << 8;
        int i9 = i5 + 2;
        int i10 = (bArr[i7] & 255) | i8;
        this.f2648k -= 2;
        if (i9 == i6) {
            this.f2647j = a2.a();
            B.a(a2);
        } else {
            a2.f2618b = i9;
        }
        return (short) i10;
    }

    @Override // W3.n
    public final z L() {
        return AbstractC0189b.c(new x(this));
    }

    @Override // W3.n
    public final void N(long j5) throws EOFException {
        if (this.f2648k < j5) {
            throw new EOFException();
        }
    }

    @Override // W3.m
    public final /* bridge */ /* synthetic */ m O(String str) {
        m0(str);
        return this;
    }

    @Override // W3.m
    public final /* bridge */ /* synthetic */ m P(long j5) {
        f0(j5);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a4 A[EDGE_INSN: B:43:0x00a4->B:37:0x00a4 BREAK  A[LOOP:0: B:5:0x0012->B:45:?], SYNTHETIC] */
    @Override // W3.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long R() throws java.io.EOFException {
        /*
            r18 = this;
            r0 = r18
            r1 = 4
            r2 = 48
            r3 = 0
            r4 = 1
            long r5 = r0.f2648k
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto Lab
            r9 = r3
            r10 = r9
            r5 = r7
        L12:
            W3.A r11 = r0.f2647j
            F3.i.c(r11)
            int r12 = r11.f2618b
            int r13 = r11.f2619c
        L1b:
            if (r12 >= r13) goto L90
            byte[] r14 = r11.f2617a
            r14 = r14[r12]
            if (r14 < r2) goto L2a
            r15 = 57
            if (r14 > r15) goto L2a
            int r15 = r14 + (-48)
            goto L3f
        L2a:
            r15 = 97
            if (r14 < r15) goto L35
            r15 = 102(0x66, float:1.43E-43)
            if (r14 > r15) goto L35
            int r15 = r14 + (-87)
            goto L3f
        L35:
            r15 = 65
            if (r14 < r15) goto L68
            r15 = 70
            if (r14 > r15) goto L68
            int r15 = r14 + (-55)
        L3f:
            r16 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r16 = r5 & r16
            int r16 = (r16 > r7 ? 1 : (r16 == r7 ? 0 : -1))
            if (r16 != 0) goto L4d
            long r5 = r5 << r1
            long r14 = (long) r15
            long r5 = r5 | r14
            int r12 = r12 + r4
            int r9 = r9 + r4
            goto L1b
        L4d:
            W3.l r1 = new W3.l
            r1.<init>()
            r1.g0(r5)
            r1.e0(r14)
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.String r1 = r1.Z()
            java.lang.String r3 = "Number too large: "
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1)
            throw r2
        L68:
            if (r9 == 0) goto L6c
            r10 = r4
            goto L90
        L6c:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            char[] r5 = X3.b.f2864a
            int r1 = r14 >> 4
            r1 = r1 & 15
            char r1 = r5[r1]
            r6 = r14 & 15
            char r5 = r5[r6]
            r6 = 2
            char[] r6 = new char[r6]
            r6[r3] = r1
            r6[r4] = r5
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6)
            java.lang.String r3 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1)
            throw r2
        L90:
            if (r12 != r13) goto L9c
            W3.A r12 = r11.a()
            r0.f2647j = r12
            W3.B.a(r11)
            goto L9e
        L9c:
            r11.f2618b = r12
        L9e:
            if (r10 != 0) goto La4
            W3.A r11 = r0.f2647j
            if (r11 != 0) goto L12
        La4:
            long r1 = r0.f2648k
            long r3 = (long) r9
            long r1 = r1 - r3
            r0.f2648k = r1
            return r5
        Lab:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.l.R():long");
    }

    @Override // W3.n
    public final String S(Charset charset) {
        F3.i.f(charset, "charset");
        return Y(this.f2648k, charset);
    }

    @Override // W3.n
    public final InputStream T() {
        return new j(this, 0);
    }

    @Override // W3.n
    public final byte U() throws EOFException {
        if (this.f2648k == 0) {
            throw new EOFException();
        }
        A a2 = this.f2647j;
        F3.i.c(a2);
        int i5 = a2.f2618b;
        int i6 = a2.f2619c;
        int i7 = i5 + 1;
        byte b5 = a2.f2617a[i5];
        this.f2648k--;
        if (i7 == i6) {
            this.f2647j = a2.a();
            B.a(a2);
        } else {
            a2.f2618b = i7;
        }
        return b5;
    }

    public final long V(o oVar) {
        int i5;
        int i6;
        F3.i.f(oVar, "targetBytes");
        A a2 = this.f2647j;
        if (a2 == null) {
            return -1L;
        }
        long j5 = this.f2648k;
        long j6 = 0;
        if (j5 < 0) {
            while (j5 > 0) {
                a2 = a2.g;
                F3.i.c(a2);
                j5 -= a2.f2619c - a2.f2618b;
            }
            if (oVar.c() == 2) {
                byte bF = oVar.f(0);
                byte bF2 = oVar.f(1);
                while (j5 < this.f2648k) {
                    i5 = (int) ((a2.f2618b + j6) - j5);
                    int i7 = a2.f2619c;
                    while (i5 < i7) {
                        byte b5 = a2.f2617a[i5];
                        if (b5 == bF || b5 == bF2) {
                            i6 = a2.f2618b;
                        } else {
                            i5++;
                        }
                    }
                    j6 = (a2.f2619c - a2.f2618b) + j5;
                    a2 = a2.f2622f;
                    F3.i.c(a2);
                    j5 = j6;
                }
                return -1L;
            }
            byte[] bArrE = oVar.e();
            while (j5 < this.f2648k) {
                i5 = (int) ((a2.f2618b + j6) - j5);
                int i8 = a2.f2619c;
                while (i5 < i8) {
                    byte b6 = a2.f2617a[i5];
                    for (byte b7 : bArrE) {
                        if (b6 == b7) {
                            i6 = a2.f2618b;
                        }
                    }
                    i5++;
                }
                j6 = (a2.f2619c - a2.f2618b) + j5;
                a2 = a2.f2622f;
                F3.i.c(a2);
                j5 = j6;
            }
            return -1L;
        }
        j5 = 0;
        while (true) {
            long j7 = (a2.f2619c - a2.f2618b) + j5;
            if (j7 > 0) {
                break;
            }
            a2 = a2.f2622f;
            F3.i.c(a2);
            j5 = j7;
        }
        if (oVar.c() == 2) {
            byte bF3 = oVar.f(0);
            byte bF4 = oVar.f(1);
            while (j5 < this.f2648k) {
                i5 = (int) ((a2.f2618b + j6) - j5);
                int i9 = a2.f2619c;
                while (i5 < i9) {
                    byte b8 = a2.f2617a[i5];
                    if (b8 == bF3 || b8 == bF4) {
                        i6 = a2.f2618b;
                    } else {
                        i5++;
                    }
                }
                j6 = (a2.f2619c - a2.f2618b) + j5;
                a2 = a2.f2622f;
                F3.i.c(a2);
                j5 = j6;
            }
            return -1L;
        }
        byte[] bArrE2 = oVar.e();
        while (j5 < this.f2648k) {
            i5 = (int) ((a2.f2618b + j6) - j5);
            int i10 = a2.f2619c;
            while (i5 < i10) {
                byte b9 = a2.f2617a[i5];
                for (byte b10 : bArrE2) {
                    if (b9 == b10) {
                        i6 = a2.f2618b;
                    }
                }
                i5++;
            }
            j6 = (a2.f2619c - a2.f2618b) + j5;
            a2 = a2.f2622f;
            F3.i.c(a2);
            j5 = j6;
        }
        return -1L;
        return (i5 - i6) + j5;
    }

    public final C0196i W(C0196i c0196i) {
        F3.i.f(c0196i, "unsafeCursor");
        byte[] bArr = X3.a.f2863a;
        if (c0196i == AbstractC0189b.f2629a) {
            c0196i = new C0196i();
        }
        if (c0196i.f2637j != null) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        c0196i.f2637j = this;
        c0196i.f2638k = true;
        return c0196i;
    }

    public final byte[] X(long j5) throws EOFException {
        if (j5 < 0 || j5 > 2147483647L) {
            throw new IllegalArgumentException(AbstractC0535a.h(j5, "byteCount: ").toString());
        }
        if (this.f2648k < j5) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j5];
        d(bArr);
        return bArr;
    }

    public final String Y(long j5, Charset charset) throws EOFException {
        F3.i.f(charset, "charset");
        if (j5 < 0 || j5 > 2147483647L) {
            throw new IllegalArgumentException(AbstractC0535a.h(j5, "byteCount: ").toString());
        }
        if (this.f2648k < j5) {
            throw new EOFException();
        }
        if (j5 == 0) {
            return "";
        }
        A a2 = this.f2647j;
        F3.i.c(a2);
        int i5 = a2.f2618b;
        if (i5 + j5 > a2.f2619c) {
            return new String(X(j5), charset);
        }
        int i6 = (int) j5;
        String str = new String(a2.f2617a, i5, i6, charset);
        int i7 = a2.f2618b + i6;
        a2.f2618b = i7;
        this.f2648k -= j5;
        if (i7 == a2.f2619c) {
            this.f2647j = a2.a();
            B.a(a2);
        }
        return str;
    }

    public final String Z() {
        return Y(this.f2648k, M3.a.f1740a);
    }

    public final void a() throws EOFException {
        i(this.f2648k);
    }

    public final o a0(int i5) {
        if (i5 == 0) {
            return o.f2649m;
        }
        AbstractC0189b.e(this.f2648k, 0L, i5);
        A a2 = this.f2647j;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            F3.i.c(a2);
            int i9 = a2.f2619c;
            int i10 = a2.f2618b;
            if (i9 == i10) {
                throw new AssertionError("s.limit == s.pos");
            }
            i7 += i9 - i10;
            i8++;
            a2 = a2.f2622f;
        }
        byte[][] bArr = new byte[i8][];
        int[] iArr = new int[i8 * 2];
        A a3 = this.f2647j;
        int i11 = 0;
        while (i6 < i5) {
            F3.i.c(a3);
            bArr[i11] = a3.f2617a;
            i6 += a3.f2619c - a3.f2618b;
            iArr[i11] = Math.min(i6, i5);
            iArr[i11 + i8] = a3.f2618b;
            a3.f2620d = true;
            i11++;
            a3 = a3.f2622f;
        }
        return new C(bArr, iArr);
    }

    @Override // W3.n, W3.m
    public final l b() {
        return this;
    }

    public final A b0(int i5) {
        if (i5 < 1 || i5 > 8192) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        A a2 = this.f2647j;
        if (a2 == null) {
            A aB = B.b();
            this.f2647j = aB;
            aB.g = aB;
            aB.f2622f = aB;
            return aB;
        }
        A a3 = a2.g;
        F3.i.c(a3);
        if (a3.f2619c + i5 <= 8192 && a3.f2621e) {
            return a3;
        }
        A aB2 = B.b();
        a3.b(aB2);
        return aB2;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final l clone() {
        l lVar = new l();
        if (this.f2648k != 0) {
            A a2 = this.f2647j;
            F3.i.c(a2);
            A aC = a2.c();
            lVar.f2647j = aC;
            aC.g = aC;
            aC.f2622f = aC;
            for (A a3 = a2.f2622f; a3 != a2; a3 = a3.f2622f) {
                A a4 = aC.g;
                F3.i.c(a4);
                F3.i.c(a3);
                a4.b(a3.c());
            }
            lVar.f2648k = this.f2648k;
        }
        return lVar;
    }

    public final void c0(o oVar) {
        F3.i.f(oVar, "byteString");
        oVar.k(oVar.c(), this);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, W3.D
    public final void close() {
    }

    @Override // W3.n
    public final void d(byte[] bArr) throws EOFException {
        F3.i.f(bArr, "sink");
        int i5 = 0;
        while (i5 < bArr.length) {
            int i6 = read(bArr, i5, bArr.length - i5);
            if (i6 == -1) {
                throw new EOFException();
            }
            i5 += i6;
        }
    }

    public final void d0(byte[] bArr) {
        F3.i.f(bArr, "source");
        m0write(bArr, 0, bArr.length);
    }

    @Override // W3.m
    public final /* bridge */ /* synthetic */ m e(long j5) {
        g0(j5);
        return this;
    }

    public final void e0(int i5) {
        A aB0 = b0(1);
        int i6 = aB0.f2619c;
        aB0.f2619c = i6 + 1;
        aB0.f2617a[i6] = (byte) i5;
        this.f2648k++;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof l) {
                long j5 = this.f2648k;
                l lVar = (l) obj;
                if (j5 == lVar.f2648k) {
                    if (j5 != 0) {
                        A a2 = this.f2647j;
                        F3.i.c(a2);
                        A a3 = lVar.f2647j;
                        F3.i.c(a3);
                        int i5 = a2.f2618b;
                        int i6 = a3.f2618b;
                        long j6 = 0;
                        while (j6 < this.f2648k) {
                            long jMin = Math.min(a2.f2619c - i5, a3.f2619c - i6);
                            long j7 = 0;
                            while (j7 < jMin) {
                                int i7 = i5 + 1;
                                byte b5 = a2.f2617a[i5];
                                int i8 = i6 + 1;
                                if (b5 == a3.f2617a[i6]) {
                                    j7++;
                                    i6 = i8;
                                    i5 = i7;
                                }
                            }
                            if (i5 == a2.f2619c) {
                                A a4 = a2.f2622f;
                                F3.i.c(a4);
                                i5 = a4.f2618b;
                                a2 = a4;
                            }
                            if (i6 == a3.f2619c) {
                                a3 = a3.f2622f;
                                F3.i.c(a3);
                                i6 = a3.f2618b;
                            }
                            j6 += jMin;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // W3.n
    public final o f() {
        return g(this.f2648k);
    }

    public final void f0(long j5) {
        boolean z4;
        byte[] bArr;
        if (j5 == 0) {
            e0(48);
            return;
        }
        int i5 = 1;
        if (j5 < 0) {
            j5 = -j5;
            if (j5 < 0) {
                m0("-9223372036854775808");
                return;
            }
            z4 = true;
        } else {
            z4 = false;
        }
        if (j5 >= 100000000) {
            i5 = j5 < 1000000000000L ? j5 < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j5 < 1000000000 ? 9 : 10 : j5 < 100000000000L ? 11 : 12 : j5 < 1000000000000000L ? j5 < 10000000000000L ? 13 : j5 < 100000000000000L ? 14 : 15 : j5 < 100000000000000000L ? j5 < 10000000000000000L ? 16 : 17 : j5 < 1000000000000000000L ? 18 : 19;
        } else if (j5 >= DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM) {
            i5 = j5 < 1000000 ? j5 < 100000 ? 5 : 6 : j5 < 10000000 ? 7 : 8;
        } else if (j5 >= 100) {
            i5 = j5 < 1000 ? 3 : 4;
        } else if (j5 >= 10) {
            i5 = 2;
        }
        if (z4) {
            i5++;
        }
        A aB0 = b0(i5);
        int i6 = aB0.f2619c + i5;
        while (true) {
            bArr = aB0.f2617a;
            if (j5 == 0) {
                break;
            }
            long j6 = 10;
            i6--;
            bArr[i6] = X3.a.f2863a[(int) (j5 % j6)];
            j5 /= j6;
        }
        if (z4) {
            bArr[i6 - 1] = 45;
        }
        aB0.f2619c += i5;
        this.f2648k += i5;
    }

    @Override // W3.m, W3.D, java.io.Flushable
    public final void flush() {
    }

    @Override // W3.n
    public final o g(long j5) throws EOFException {
        if (j5 < 0 || j5 > 2147483647L) {
            throw new IllegalArgumentException(AbstractC0535a.h(j5, "byteCount: ").toString());
        }
        if (this.f2648k < j5) {
            throw new EOFException();
        }
        if (j5 < 4096) {
            return new o(X(j5));
        }
        o oVarA0 = a0((int) j5);
        i(j5);
        return oVarA0;
    }

    public final void g0(long j5) {
        if (j5 == 0) {
            e0(48);
            return;
        }
        long j6 = (j5 >>> 1) | j5;
        long j7 = j6 | (j6 >>> 2);
        long j8 = j7 | (j7 >>> 4);
        long j9 = j8 | (j8 >>> 8);
        long j10 = j9 | (j9 >>> 16);
        long j11 = j10 | (j10 >>> 32);
        long j12 = j11 - ((j11 >>> 1) & 6148914691236517205L);
        long j13 = ((j12 >>> 2) & 3689348814741910323L) + (j12 & 3689348814741910323L);
        long j14 = ((j13 >>> 4) + j13) & 1085102592571150095L;
        long j15 = j14 + (j14 >>> 8);
        long j16 = j15 + (j15 >>> 16);
        int i5 = (int) ((((j16 & 63) + ((j16 >>> 32) & 63)) + 3) / 4);
        A aB0 = b0(i5);
        int i6 = aB0.f2619c;
        for (int i7 = (i6 + i5) - 1; i7 >= i6; i7--) {
            aB0.f2617a[i7] = X3.a.f2863a[(int) (15 & j5)];
            j5 >>>= 4;
        }
        aB0.f2619c += i5;
        this.f2648k += i5;
    }

    public final void h0(int i5) {
        A aB0 = b0(4);
        int i6 = aB0.f2619c;
        byte[] bArr = aB0.f2617a;
        bArr[i6] = (byte) ((i5 >>> 24) & 255);
        bArr[i6 + 1] = (byte) ((i5 >>> 16) & 255);
        bArr[i6 + 2] = (byte) ((i5 >>> 8) & 255);
        bArr[i6 + 3] = (byte) (i5 & 255);
        aB0.f2619c = i6 + 4;
        this.f2648k += 4;
    }

    public final int hashCode() {
        A a2 = this.f2647j;
        if (a2 == null) {
            return 0;
        }
        int i5 = 1;
        do {
            int i6 = a2.f2619c;
            for (int i7 = a2.f2618b; i7 < i6; i7++) {
                i5 = (i5 * 31) + a2.f2617a[i7];
            }
            a2 = a2.f2622f;
            F3.i.c(a2);
        } while (a2 != this.f2647j);
        return i5;
    }

    @Override // W3.n
    public final void i(long j5) throws EOFException {
        while (j5 > 0) {
            A a2 = this.f2647j;
            if (a2 == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j5, a2.f2619c - a2.f2618b);
            long j6 = iMin;
            this.f2648k -= j6;
            j5 -= j6;
            int i5 = a2.f2618b + iMin;
            a2.f2618b = i5;
            if (i5 == a2.f2619c) {
                this.f2647j = a2.a();
                B.a(a2);
            }
        }
    }

    public final void i0(long j5) {
        A aB0 = b0(8);
        int i5 = aB0.f2619c;
        byte[] bArr = aB0.f2617a;
        bArr[i5] = (byte) ((j5 >>> 56) & 255);
        bArr[i5 + 1] = (byte) ((j5 >>> 48) & 255);
        bArr[i5 + 2] = (byte) ((j5 >>> 40) & 255);
        bArr[i5 + 3] = (byte) ((j5 >>> 32) & 255);
        bArr[i5 + 4] = (byte) ((j5 >>> 24) & 255);
        bArr[i5 + 5] = (byte) ((j5 >>> 16) & 255);
        bArr[i5 + 6] = (byte) ((j5 >>> 8) & 255);
        bArr[i5 + 7] = (byte) (j5 & 255);
        aB0.f2619c = i5 + 8;
        this.f2648k += 8;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // W3.m
    public final m j() {
        return this;
    }

    public final void j0(int i5) {
        A aB0 = b0(2);
        int i6 = aB0.f2619c;
        byte[] bArr = aB0.f2617a;
        bArr[i6] = (byte) ((i5 >>> 8) & 255);
        bArr[i6 + 1] = (byte) (i5 & 255);
        aB0.f2619c = i6 + 2;
        this.f2648k += 2;
    }

    @Override // W3.m
    public final /* bridge */ /* synthetic */ m k(int i5) {
        j0(i5);
        return this;
    }

    public final void k0(String str, int i5, int i6, Charset charset) {
        F3.i.f(str, "string");
        F3.i.f(charset, "charset");
        if (i5 < 0) {
            throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.a(i5, "beginIndex < 0: ").toString());
        }
        if (i6 < i5) {
            throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.c("endIndex < beginIndex: ", " < ", i6, i5).toString());
        }
        if (i6 > str.length()) {
            StringBuilder sbF = com.unified.ur1.SatelliteTracker.h.f("endIndex > string.length: ", i6, " > ");
            sbF.append(str.length());
            throw new IllegalArgumentException(sbF.toString().toString());
        }
        if (charset.equals(M3.a.f1740a)) {
            l0(i5, i6, str);
            return;
        }
        String strSubstring = str.substring(i5, i6);
        F3.i.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] bytes = strSubstring.getBytes(charset);
        F3.i.e(bytes, "this as java.lang.String).getBytes(charset)");
        m0write(bytes, 0, bytes.length);
    }

    @Override // W3.n
    public final boolean l(long j5) {
        return this.f2648k >= j5;
    }

    public final void l0(int i5, int i6, String str) {
        char cCharAt;
        F3.i.f(str, "string");
        if (i5 < 0) {
            throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.a(i5, "beginIndex < 0: ").toString());
        }
        if (i6 < i5) {
            throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.c("endIndex < beginIndex: ", " < ", i6, i5).toString());
        }
        if (i6 > str.length()) {
            StringBuilder sbF = com.unified.ur1.SatelliteTracker.h.f("endIndex > string.length: ", i6, " > ");
            sbF.append(str.length());
            throw new IllegalArgumentException(sbF.toString().toString());
        }
        while (i5 < i6) {
            char cCharAt2 = str.charAt(i5);
            if (cCharAt2 < 128) {
                A aB0 = b0(1);
                int i7 = aB0.f2619c - i5;
                int iMin = Math.min(i6, 8192 - i7);
                int i8 = i5 + 1;
                byte[] bArr = aB0.f2617a;
                bArr[i5 + i7] = (byte) cCharAt2;
                while (true) {
                    i5 = i8;
                    if (i5 >= iMin || (cCharAt = str.charAt(i5)) >= 128) {
                        break;
                    }
                    i8 = i5 + 1;
                    bArr[i5 + i7] = (byte) cCharAt;
                }
                int i9 = aB0.f2619c;
                int i10 = (i7 + i5) - i9;
                aB0.f2619c = i9 + i10;
                this.f2648k += i10;
            } else {
                if (cCharAt2 < 2048) {
                    A aB02 = b0(2);
                    int i11 = aB02.f2619c;
                    byte[] bArr2 = aB02.f2617a;
                    bArr2[i11] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i11 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    aB02.f2619c = i11 + 2;
                    this.f2648k += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    A aB03 = b0(3);
                    int i12 = aB03.f2619c;
                    byte[] bArr3 = aB03.f2617a;
                    bArr3[i12] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i12 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i12 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    aB03.f2619c = i12 + 3;
                    this.f2648k += 3;
                } else {
                    int i13 = i5 + 1;
                    char cCharAt3 = i13 < i6 ? str.charAt(i13) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        e0(63);
                        i5 = i13;
                    } else {
                        int i14 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        A aB04 = b0(4);
                        int i15 = aB04.f2619c;
                        byte[] bArr4 = aB04.f2617a;
                        bArr4[i15] = (byte) ((i14 >> 18) | 240);
                        bArr4[i15 + 1] = (byte) (((i14 >> 12) & 63) | 128);
                        bArr4[i15 + 2] = (byte) (((i14 >> 6) & 63) | 128);
                        bArr4[i15 + 3] = (byte) ((i14 & 63) | 128);
                        aB04.f2619c = i15 + 4;
                        this.f2648k += 4;
                        i5 += 2;
                    }
                }
                i5++;
            }
        }
    }

    @Override // W3.n
    public final int m() throws EOFException {
        if (this.f2648k < 4) {
            throw new EOFException();
        }
        A a2 = this.f2647j;
        F3.i.c(a2);
        int i5 = a2.f2618b;
        int i6 = a2.f2619c;
        if (i6 - i5 < 4) {
            return ((U() & 255) << 24) | ((U() & 255) << 16) | ((U() & 255) << 8) | (U() & 255);
        }
        byte[] bArr = a2.f2617a;
        int i7 = i5 + 3;
        int i8 = ((bArr[i5 + 1] & 255) << 16) | ((bArr[i5] & 255) << 24) | ((bArr[i5 + 2] & 255) << 8);
        int i9 = i5 + 4;
        int i10 = i8 | (bArr[i7] & 255);
        this.f2648k -= 4;
        if (i9 == i6) {
            this.f2647j = a2.a();
            B.a(a2);
        } else {
            a2.f2618b = i9;
        }
        return i10;
    }

    public final void m0(String str) {
        F3.i.f(str, "string");
        l0(0, str.length(), str);
    }

    @Override // W3.m
    public final /* bridge */ /* synthetic */ m n(int i5) {
        h0(i5);
        return this;
    }

    public final void n0(int i5) {
        String str;
        int i6 = 0;
        if (i5 < 128) {
            e0(i5);
            return;
        }
        if (i5 < 2048) {
            A aB0 = b0(2);
            int i7 = aB0.f2619c;
            byte[] bArr = aB0.f2617a;
            bArr[i7] = (byte) ((i5 >> 6) | 192);
            bArr[1 + i7] = (byte) ((i5 & 63) | 128);
            aB0.f2619c = i7 + 2;
            this.f2648k += 2;
            return;
        }
        if (55296 <= i5 && i5 < 57344) {
            e0(63);
            return;
        }
        if (i5 < 65536) {
            A aB02 = b0(3);
            int i8 = aB02.f2619c;
            byte[] bArr2 = aB02.f2617a;
            bArr2[i8] = (byte) ((i5 >> 12) | 224);
            bArr2[1 + i8] = (byte) (((i5 >> 6) & 63) | 128);
            bArr2[2 + i8] = (byte) ((i5 & 63) | 128);
            aB02.f2619c = i8 + 3;
            this.f2648k += 3;
            return;
        }
        if (i5 <= 1114111) {
            A aB03 = b0(4);
            int i9 = aB03.f2619c;
            byte[] bArr3 = aB03.f2617a;
            bArr3[i9] = (byte) ((i5 >> 18) | 240);
            bArr3[1 + i9] = (byte) (((i5 >> 12) & 63) | 128);
            bArr3[2 + i9] = (byte) (((i5 >> 6) & 63) | 128);
            bArr3[3 + i9] = (byte) ((i5 & 63) | 128);
            aB03.f2619c = i9 + 4;
            this.f2648k += 4;
            return;
        }
        StringBuilder sb = new StringBuilder("Unexpected code point: 0x");
        if (i5 != 0) {
            char[] cArr = X3.b.f2864a;
            char[] cArr2 = {cArr[(i5 >> 28) & 15], cArr[(i5 >> 24) & 15], cArr[(i5 >> 20) & 15], cArr[(i5 >> 16) & 15], cArr[(i5 >> 12) & 15], cArr[(i5 >> 8) & 15], cArr[(i5 >> 4) & 15], cArr[i5 & 15]};
            while (i6 < 8 && cArr2[i6] == '0') {
                i6++;
            }
            if (i6 < 0) {
                throw new IndexOutOfBoundsException(AbstractC0535a.j("startIndex: ", i6, ", endIndex: 8, size: 8"));
            }
            if (i6 > 8) {
                throw new IllegalArgumentException(AbstractC0535a.j("startIndex: ", i6, " > endIndex: 8"));
            }
            str = new String(cArr2, i6, 8 - i6);
        } else {
            str = "0";
        }
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public final long o() {
        long j5 = this.f2648k;
        if (j5 == 0) {
            return 0L;
        }
        A a2 = this.f2647j;
        F3.i.c(a2);
        A a3 = a2.g;
        F3.i.c(a3);
        if (a3.f2619c < 8192 && a3.f2621e) {
            j5 -= r3 - a3.f2618b;
        }
        return j5;
    }

    @Override // W3.n
    public final long p(l lVar) {
        long j5 = this.f2648k;
        if (j5 > 0) {
            lVar.write(this, j5);
        }
        return j5;
    }

    @Override // W3.n
    public final long q() throws EOFException {
        if (this.f2648k < 8) {
            throw new EOFException();
        }
        A a2 = this.f2647j;
        F3.i.c(a2);
        int i5 = a2.f2618b;
        int i6 = a2.f2619c;
        if (i6 - i5 < 8) {
            return ((m() & 4294967295L) << 32) | (4294967295L & m());
        }
        byte[] bArr = a2.f2617a;
        int i7 = i5 + 7;
        long j5 = ((bArr[i5 + 3] & 255) << 32) | ((bArr[i5] & 255) << 56) | ((bArr[i5 + 1] & 255) << 48) | ((bArr[i5 + 2] & 255) << 40) | ((bArr[i5 + 4] & 255) << 24) | ((bArr[i5 + 5] & 255) << 16) | ((bArr[i5 + 6] & 255) << 8);
        int i8 = i5 + 8;
        long j6 = j5 | (bArr[i7] & 255);
        this.f2648k -= 8;
        if (i8 == i6) {
            this.f2647j = a2.a();
            B.a(a2);
        } else {
            a2.f2618b = i8;
        }
        return j6;
    }

    @Override // W3.n
    public final int r(w wVar) throws EOFException {
        F3.i.f(wVar, "options");
        int iC = X3.a.c(this, wVar, false);
        if (iC == -1) {
            return -1;
        }
        i(wVar.f2666j[iC].c());
        return iC;
    }

    @Override // W3.F
    public final long read(l lVar, long j5) {
        F3.i.f(lVar, "sink");
        if (j5 < 0) {
            throw new IllegalArgumentException(AbstractC0535a.h(j5, "byteCount < 0: ").toString());
        }
        long j6 = this.f2648k;
        if (j6 == 0) {
            return -1L;
        }
        if (j5 > j6) {
            j5 = j6;
        }
        lVar.write(this, j5);
        return j5;
    }

    public final void s(long j5, l lVar, long j6) {
        F3.i.f(lVar, "out");
        AbstractC0189b.e(this.f2648k, j5, j6);
        if (j6 == 0) {
            return;
        }
        lVar.f2648k += j6;
        A a2 = this.f2647j;
        while (true) {
            F3.i.c(a2);
            long j7 = a2.f2619c - a2.f2618b;
            if (j5 < j7) {
                break;
            }
            j5 -= j7;
            a2 = a2.f2622f;
        }
        while (j6 > 0) {
            F3.i.c(a2);
            A aC = a2.c();
            int i5 = aC.f2618b + ((int) j5);
            aC.f2618b = i5;
            aC.f2619c = Math.min(i5 + ((int) j6), aC.f2619c);
            A a3 = lVar.f2647j;
            if (a3 == null) {
                aC.g = aC;
                aC.f2622f = aC;
                lVar.f2647j = aC;
            } else {
                A a4 = a3.g;
                F3.i.c(a4);
                a4.b(aC);
            }
            j6 -= aC.f2619c - aC.f2618b;
            a2 = a2.f2622f;
            j5 = 0;
        }
    }

    @Override // W3.F
    public final I timeout() {
        return I.NONE;
    }

    public final String toString() {
        long j5 = this.f2648k;
        if (j5 <= 2147483647L) {
            return a0((int) j5).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f2648k).toString());
    }

    @Override // W3.n
    public final String u() {
        return G(Long.MAX_VALUE);
    }

    @Override // W3.n
    public final byte[] w() {
        return X(this.f2648k);
    }

    @Override // W3.m
    public final /* bridge */ /* synthetic */ m write(byte[] bArr, int i5, int i6) {
        m0write(bArr, i5, i6);
        return this;
    }

    public final byte x(long j5) {
        AbstractC0189b.e(this.f2648k, j5, 1L);
        A a2 = this.f2647j;
        if (a2 == null) {
            F3.i.c(null);
            throw null;
        }
        long j6 = this.f2648k;
        if (j6 - j5 < j5) {
            while (j6 > j5) {
                a2 = a2.g;
                F3.i.c(a2);
                j6 -= a2.f2619c - a2.f2618b;
            }
            return a2.f2617a[(int) ((a2.f2618b + j5) - j6)];
        }
        long j7 = 0;
        while (true) {
            int i5 = a2.f2619c;
            int i6 = a2.f2618b;
            long j8 = (i5 - i6) + j7;
            if (j8 > j5) {
                return a2.f2617a[(int) ((i6 + j5) - j7)];
            }
            a2 = a2.f2622f;
            F3.i.c(a2);
            j7 = j8;
        }
    }

    @Override // W3.n
    public final boolean y() {
        return this.f2648k == 0;
    }

    @Override // W3.m
    public final long z(F f5) {
        F3.i.f(f5, "source");
        long j5 = 0;
        while (true) {
            long j6 = f5.read(this, 8192L);
            if (j6 == -1) {
                return j5;
            }
            j5 += j6;
        }
    }

    @Override // W3.D
    public final void write(l lVar, long j5) {
        A aB;
        F3.i.f(lVar, "source");
        if (lVar == this) {
            throw new IllegalArgumentException("source == this".toString());
        }
        AbstractC0189b.e(lVar.f2648k, 0L, j5);
        while (j5 > 0) {
            A a2 = lVar.f2647j;
            F3.i.c(a2);
            int i5 = a2.f2619c;
            A a3 = lVar.f2647j;
            F3.i.c(a3);
            long j6 = i5 - a3.f2618b;
            int i6 = 0;
            if (j5 < j6) {
                A a4 = this.f2647j;
                A a5 = a4 != null ? a4.g : null;
                if (a5 != null && a5.f2621e) {
                    if ((a5.f2619c + j5) - (a5.f2620d ? 0 : a5.f2618b) <= 8192) {
                        A a6 = lVar.f2647j;
                        F3.i.c(a6);
                        a6.d(a5, (int) j5);
                        lVar.f2648k -= j5;
                        this.f2648k += j5;
                        return;
                    }
                }
                A a7 = lVar.f2647j;
                F3.i.c(a7);
                int i7 = (int) j5;
                if (i7 <= 0 || i7 > a7.f2619c - a7.f2618b) {
                    throw new IllegalArgumentException("byteCount out of range".toString());
                }
                if (i7 >= 1024) {
                    aB = a7.c();
                } else {
                    aB = B.b();
                    int i8 = a7.f2618b;
                    t3.h.t(a7.f2617a, 0, i8, aB.f2617a, i8 + i7);
                }
                aB.f2619c = aB.f2618b + i7;
                a7.f2618b += i7;
                A a8 = a7.g;
                F3.i.c(a8);
                a8.b(aB);
                lVar.f2647j = aB;
            }
            A a9 = lVar.f2647j;
            F3.i.c(a9);
            long j7 = a9.f2619c - a9.f2618b;
            lVar.f2647j = a9.a();
            A a10 = this.f2647j;
            if (a10 == null) {
                this.f2647j = a9;
                a9.g = a9;
                a9.f2622f = a9;
            } else {
                A a11 = a10.g;
                F3.i.c(a11);
                a11.b(a9);
                A a12 = a9.g;
                if (a12 == a9) {
                    throw new IllegalStateException("cannot compact".toString());
                }
                F3.i.c(a12);
                if (a12.f2621e) {
                    int i9 = a9.f2619c - a9.f2618b;
                    A a13 = a9.g;
                    F3.i.c(a13);
                    int i10 = 8192 - a13.f2619c;
                    A a14 = a9.g;
                    F3.i.c(a14);
                    if (!a14.f2620d) {
                        A a15 = a9.g;
                        F3.i.c(a15);
                        i6 = a15.f2618b;
                    }
                    if (i9 <= i10 + i6) {
                        A a16 = a9.g;
                        F3.i.c(a16);
                        a9.d(a16, i9);
                        a9.a();
                        B.a(a9);
                    }
                }
            }
            lVar.f2648k -= j7;
            this.f2648k += j7;
            j5 -= j7;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        F3.i.f(byteBuffer, "sink");
        A a2 = this.f2647j;
        if (a2 == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), a2.f2619c - a2.f2618b);
        byteBuffer.put(a2.f2617a, a2.f2618b, iMin);
        int i5 = a2.f2618b + iMin;
        a2.f2618b = i5;
        this.f2648k -= iMin;
        if (i5 == a2.f2619c) {
            this.f2647j = a2.a();
            B.a(a2);
        }
        return iMin;
    }

    public final int read(byte[] bArr, int i5, int i6) {
        F3.i.f(bArr, "sink");
        AbstractC0189b.e(bArr.length, i5, i6);
        A a2 = this.f2647j;
        if (a2 == null) {
            return -1;
        }
        int iMin = Math.min(i6, a2.f2619c - a2.f2618b);
        int i7 = a2.f2618b;
        t3.h.t(a2.f2617a, i5, i7, bArr, i7 + iMin);
        int i8 = a2.f2618b + iMin;
        a2.f2618b = i8;
        this.f2648k -= iMin;
        if (i8 == a2.f2619c) {
            this.f2647j = a2.a();
            B.a(a2);
        }
        return iMin;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        F3.i.f(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i5 = iRemaining;
        while (i5 > 0) {
            A aB0 = b0(1);
            int iMin = Math.min(i5, 8192 - aB0.f2619c);
            byteBuffer.get(aB0.f2617a, aB0.f2619c, iMin);
            i5 -= iMin;
            aB0.f2619c += iMin;
        }
        this.f2648k += iRemaining;
        return iRemaining;
    }

    /* renamed from: write, reason: collision with other method in class */
    public final void m0write(byte[] bArr, int i5, int i6) {
        F3.i.f(bArr, "source");
        long j5 = i6;
        AbstractC0189b.e(bArr.length, i5, j5);
        int i7 = i6 + i5;
        while (i5 < i7) {
            A aB0 = b0(1);
            int iMin = Math.min(i7 - i5, 8192 - aB0.f2619c);
            int i8 = i5 + iMin;
            t3.h.t(bArr, aB0.f2619c, i5, aB0.f2617a, i8);
            aB0.f2619c += iMin;
            i5 = i8;
        }
        this.f2648k += j5;
    }
}
