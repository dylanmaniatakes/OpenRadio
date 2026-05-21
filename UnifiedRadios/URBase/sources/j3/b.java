package J3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b implements Iterator, G3.a {

    /* renamed from: j, reason: collision with root package name */
    public final int f1478j;

    /* renamed from: k, reason: collision with root package name */
    public final int f1479k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1480l;

    /* renamed from: m, reason: collision with root package name */
    public int f1481m;

    public b(int i5, int i6, int i7) {
        this.f1478j = i7;
        this.f1479k = i6;
        boolean z4 = false;
        if (i7 <= 0 ? i5 >= i6 : i5 <= i6) {
            z4 = true;
        }
        this.f1480l = z4;
        this.f1481m = z4 ? i5 : i6;
    }

    public final int a() {
        int i5 = this.f1481m;
        if (i5 != this.f1479k) {
            this.f1481m = this.f1478j + i5;
        } else {
            if (!this.f1480l) {
                throw new NoSuchElementException();
            }
            this.f1480l = false;
        }
        return i5;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1480l;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(a());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
