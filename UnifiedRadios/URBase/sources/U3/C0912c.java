package u3;

import F3.i;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: u3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0912c implements Iterator, G3.a {

    /* renamed from: j, reason: collision with root package name */
    public final C0914e f9942j;

    /* renamed from: k, reason: collision with root package name */
    public int f9943k;

    /* renamed from: l, reason: collision with root package name */
    public int f9944l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f9945m;

    public C0912c(C0914e c0914e, int i5) {
        this.f9945m = i5;
        i.f(c0914e, "map");
        this.f9942j = c0914e;
        this.f9944l = -1;
        a();
    }

    public final void a() {
        while (true) {
            int i5 = this.f9943k;
            C0914e c0914e = this.f9942j;
            if (i5 >= c0914e.f9953o || c0914e.f9951l[i5] >= 0) {
                return;
            } else {
                this.f9943k = i5 + 1;
            }
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9943k < this.f9942j.f9953o;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f9945m) {
            case 0:
                int i5 = this.f9943k;
                C0914e c0914e = this.f9942j;
                if (i5 >= c0914e.f9953o) {
                    throw new NoSuchElementException();
                }
                this.f9943k = i5 + 1;
                this.f9944l = i5;
                C0913d c0913d = new C0913d(c0914e, i5);
                a();
                return c0913d;
            case 1:
                int i6 = this.f9943k;
                C0914e c0914e2 = this.f9942j;
                if (i6 >= c0914e2.f9953o) {
                    throw new NoSuchElementException();
                }
                this.f9943k = i6 + 1;
                this.f9944l = i6;
                Object obj = c0914e2.f9949j[i6];
                a();
                return obj;
            default:
                int i7 = this.f9943k;
                C0914e c0914e3 = this.f9942j;
                if (i7 >= c0914e3.f9953o) {
                    throw new NoSuchElementException();
                }
                this.f9943k = i7 + 1;
                this.f9944l = i7;
                Object[] objArr = c0914e3.f9950k;
                i.c(objArr);
                Object obj2 = objArr[this.f9944l];
                a();
                return obj2;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.f9944l == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
        C0914e c0914e = this.f9942j;
        c0914e.c();
        c0914e.k(this.f9944l);
        this.f9944l = -1;
    }
}
