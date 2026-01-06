package W3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public final class C extends o {
    public final transient byte[][] n;

    /* renamed from: o, reason: collision with root package name */
    public final transient int[] f2626o;

    public C(byte[][] bArr, int[] iArr) {
        super(o.f2649m.f2650j);
        this.n = bArr;
        this.f2626o = iArr;
    }

    @Override // W3.o
    public final String a() {
        return new o(l()).a();
    }

    @Override // W3.o
    public final o b(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.n;
        int length = bArr.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int[] iArr = this.f2626o;
            int i7 = iArr[length + i5];
            int i8 = iArr[i5];
            messageDigest.update(bArr[i5], i7, i8 - i6);
            i5++;
            i6 = i8;
        }
        byte[] bArrDigest = messageDigest.digest();
        F3.i.c(bArrDigest);
        return new o(bArrDigest);
    }

    @Override // W3.o
    public final int c() {
        return this.f2626o[this.n.length - 1];
    }

    @Override // W3.o
    public final String d() {
        return new o(l()).d();
    }

    @Override // W3.o
    public final byte[] e() {
        return l();
    }

    @Override // W3.o
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (oVar.c() == c() && h(oVar, c())) {
                return true;
            }
        }
        return false;
    }

    @Override // W3.o
    public final byte f(int i5) {
        byte[][] bArr = this.n;
        int length = bArr.length - 1;
        int[] iArr = this.f2626o;
        AbstractC0189b.e(iArr[length], i5, 1L);
        int iB = X3.b.b(this, i5);
        return bArr[iB][(i5 - (iB == 0 ? 0 : iArr[iB - 1])) + iArr[bArr.length + iB]];
    }

    @Override // W3.o
    public final boolean g(int i5, int i6, int i7, byte[] bArr) {
        F3.i.f(bArr, "other");
        if (i5 < 0 || i5 > c() - i7 || i6 < 0 || i6 > bArr.length - i7) {
            return false;
        }
        int i8 = i7 + i5;
        int iB = X3.b.b(this, i5);
        while (i5 < i8) {
            int[] iArr = this.f2626o;
            int i9 = iB == 0 ? 0 : iArr[iB - 1];
            int i10 = iArr[iB] - i9;
            byte[][] bArr2 = this.n;
            int i11 = iArr[bArr2.length + iB];
            int iMin = Math.min(i8, i10 + i9) - i5;
            if (!AbstractC0189b.a(bArr2[iB], (i5 - i9) + i11, i6, bArr, iMin)) {
                return false;
            }
            i6 += iMin;
            i5 += iMin;
            iB++;
        }
        return true;
    }

    @Override // W3.o
    public final boolean h(o oVar, int i5) {
        F3.i.f(oVar, "other");
        if (c() - i5 < 0) {
            return false;
        }
        int iB = X3.b.b(this, 0);
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5) {
            int[] iArr = this.f2626o;
            int i8 = iB == 0 ? 0 : iArr[iB - 1];
            int i9 = iArr[iB] - i8;
            byte[][] bArr = this.n;
            int i10 = iArr[bArr.length + iB];
            int iMin = Math.min(i5, i9 + i8) - i6;
            if (!oVar.g(i7, (i6 - i8) + i10, iMin, bArr[iB])) {
                return false;
            }
            i7 += iMin;
            i6 += iMin;
            iB++;
        }
        return true;
    }

    @Override // W3.o
    public final int hashCode() {
        int i5 = this.f2651k;
        if (i5 != 0) {
            return i5;
        }
        byte[][] bArr = this.n;
        int length = bArr.length;
        int i6 = 0;
        int i7 = 1;
        int i8 = 0;
        while (i6 < length) {
            int[] iArr = this.f2626o;
            int i9 = iArr[length + i6];
            int i10 = iArr[i6];
            byte[] bArr2 = bArr[i6];
            int i11 = (i10 - i8) + i9;
            while (i9 < i11) {
                i7 = (i7 * 31) + bArr2[i9];
                i9++;
            }
            i6++;
            i8 = i10;
        }
        this.f2651k = i7;
        return i7;
    }

    @Override // W3.o
    public final o i() {
        return new o(l()).i();
    }

    @Override // W3.o
    public final void k(int i5, l lVar) {
        F3.i.f(lVar, "buffer");
        int iB = X3.b.b(this, 0);
        int i6 = 0;
        while (i6 < i5) {
            int[] iArr = this.f2626o;
            int i7 = iB == 0 ? 0 : iArr[iB - 1];
            int i8 = iArr[iB] - i7;
            byte[][] bArr = this.n;
            int i9 = iArr[bArr.length + iB];
            int iMin = Math.min(i5, i8 + i7) - i6;
            int i10 = (i6 - i7) + i9;
            A a2 = new A(bArr[iB], i10, i10 + iMin, true, false);
            A a3 = lVar.f2647j;
            if (a3 == null) {
                a2.g = a2;
                a2.f2622f = a2;
                lVar.f2647j = a2;
            } else {
                A a4 = a3.g;
                F3.i.c(a4);
                a4.b(a2);
            }
            i6 += iMin;
            iB++;
        }
        lVar.f2648k += i5;
    }

    public final byte[] l() {
        byte[] bArr = new byte[c()];
        byte[][] bArr2 = this.n;
        int length = bArr2.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < length) {
            int[] iArr = this.f2626o;
            int i8 = iArr[length + i5];
            int i9 = iArr[i5];
            int i10 = i9 - i6;
            t3.h.t(bArr2[i5], i7, i8, bArr, i8 + i10);
            i7 += i10;
            i5++;
            i6 = i9;
        }
        return bArr;
    }

    @Override // W3.o
    public final String toString() {
        return new o(l()).toString();
    }
}
