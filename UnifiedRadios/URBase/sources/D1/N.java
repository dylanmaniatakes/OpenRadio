package D1;

import com.google.android.gms.internal.measurement.AbstractC0296a2;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class N extends S implements ListIterator {

    /* renamed from: k, reason: collision with root package name */
    public final int f367k;

    /* renamed from: l, reason: collision with root package name */
    public int f368l;

    /* renamed from: m, reason: collision with root package name */
    public final P f369m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(P p4, int i5) {
        super(0);
        int size = p4.size();
        if (i5 < 0 || i5 > size) {
            throw new IndexOutOfBoundsException(AbstractC0296a2.w(i5, size, "index"));
        }
        this.f367k = size;
        this.f368l = i5;
        this.f369m = p4;
    }

    public final Object a(int i5) {
        return this.f369m.get(i5);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f368l < this.f367k;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f368l > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i5 = this.f368l;
        this.f368l = i5 + 1;
        return a(i5);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f368l;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i5 = this.f368l - 1;
        this.f368l = i5;
        return a(i5);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f368l - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
