package k4;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class e implements Iterator {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8267j;

    /* renamed from: k, reason: collision with root package name */
    public int f8268k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Iterable f8269l;

    public /* synthetic */ e(Iterable iterable, int i5) {
        this.f8267j = i5;
        this.f8269l = iterable;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f8267j) {
            case 0:
                if (this.f8268k < ((f) this.f8269l).f8271k) {
                }
                break;
            default:
                if (this.f8268k < ((g) this.f8269l).size()) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f8267j) {
            case 0:
                int i5 = this.f8268k;
                this.f8268k = i5 + 1;
                return (o) ((f) this.f8269l).f8270j.get(i5);
            default:
                if (!hasNext()) {
                    return null;
                }
                g gVar = (g) this.f8269l;
                int i6 = gVar.f8273k;
                int i7 = this.f8268k;
                int i8 = gVar.f8275m;
                int i9 = (i7 % i8) + i6;
                int i10 = (i7 / i8) + gVar.f8274l;
                this.f8268k = i7 + 1;
                while (true) {
                    int i11 = gVar.f8276o;
                    if (i9 >= i11) {
                        i9 -= i11;
                    } else {
                        while (true) {
                            int i12 = gVar.f8276o;
                            if (i10 < i12) {
                                return Long.valueOf(l.f(gVar.f8272j, i9, i10));
                            }
                            i10 -= i12;
                        }
                    }
                }
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f8267j) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
