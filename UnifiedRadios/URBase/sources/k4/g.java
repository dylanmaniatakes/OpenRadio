package k4;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class g implements k, Iterable {

    /* renamed from: j, reason: collision with root package name */
    public int f8272j;

    /* renamed from: k, reason: collision with root package name */
    public int f8273k;

    /* renamed from: l, reason: collision with root package name */
    public int f8274l;

    /* renamed from: m, reason: collision with root package name */
    public int f8275m;
    public int n;

    /* renamed from: o, reason: collision with root package name */
    public int f8276o;

    @Override // k4.k
    public final boolean a(long j5) {
        if (((int) (j5 >> 58)) != this.f8272j) {
            return false;
        }
        int iG = l.g(j5);
        int i5 = this.f8273k;
        int i6 = this.f8275m;
        while (iG < i5) {
            iG += this.f8276o;
        }
        if (iG >= i5 + i6) {
            return false;
        }
        int iH = l.h(j5);
        int i7 = this.f8274l;
        int i8 = this.n;
        while (iH < i7) {
            iH += this.f8276o;
        }
        return iH < i7 + i8;
    }

    public final void b(int i5, int i6, int i7, int i8, int i9) {
        this.f8272j = i5;
        this.f8276o = 1 << i5;
        while (i6 > i8) {
            i8 += this.f8276o;
        }
        this.f8275m = Math.min(this.f8276o, (i8 - i6) + 1);
        while (i7 > i9) {
            i9 += this.f8276o;
        }
        this.n = Math.min(this.f8276o, (i9 - i7) + 1);
        while (i6 < 0) {
            i6 += this.f8276o;
        }
        while (true) {
            int i10 = this.f8276o;
            if (i6 < i10) {
                break;
            } else {
                i6 -= i10;
            }
        }
        this.f8273k = i6;
        while (i7 < 0) {
            i7 += this.f8276o;
        }
        while (true) {
            int i11 = this.f8276o;
            if (i7 < i11) {
                this.f8274l = i7;
                return;
            }
            i7 -= i11;
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new e(this, 1);
    }

    public final int size() {
        return this.f8275m * this.n;
    }

    public final String toString() {
        if (this.f8275m == 0) {
            return "MapTileArea:empty";
        }
        return "MapTileArea:zoom=" + this.f8272j + ",left=" + this.f8273k + ",top=" + this.f8274l + ",width=" + this.f8275m + ",height=" + this.n;
    }
}
