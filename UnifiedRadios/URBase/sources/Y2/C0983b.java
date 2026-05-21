package y2;

import D1.S;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* renamed from: y2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0983b extends S implements ListIterator {

    /* renamed from: k, reason: collision with root package name */
    public final int f10488k;

    /* renamed from: l, reason: collision with root package name */
    public int f10489l;

    /* renamed from: m, reason: collision with root package name */
    public final AbstractC0985d f10490m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0983b(AbstractC0985d abstractC0985d, int i5) {
        super(2);
        int size = abstractC0985d.size();
        L0.f.d(i5, size);
        this.f10488k = size;
        this.f10489l = i5;
        this.f10490m = abstractC0985d;
    }

    public final Object a(int i5) {
        return this.f10490m.get(i5);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f10489l < this.f10488k;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f10489l > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i5 = this.f10489l;
        this.f10489l = i5 + 1;
        return a(i5);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f10489l;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i5 = this.f10489l - 1;
        this.f10489l = i5;
        return a(i5);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f10489l - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
