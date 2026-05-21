package E1;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import w1.AbstractC0930a;

/* renamed from: E1.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0045s extends D1.S implements ListIterator {

    /* renamed from: k, reason: collision with root package name */
    public final int f474k;

    /* renamed from: l, reason: collision with root package name */
    public int f475l;

    /* renamed from: m, reason: collision with root package name */
    public final AbstractC0047u f476m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0045s(AbstractC0047u abstractC0047u, int i5) {
        super(1);
        int size = abstractC0047u.size();
        if (i5 < 0 || i5 > size) {
            throw new IndexOutOfBoundsException(AbstractC0930a.t(i5, size, "index"));
        }
        this.f474k = size;
        this.f475l = i5;
        this.f476m = abstractC0047u;
    }

    public final Object a(int i5) {
        return this.f476m.get(i5);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f475l < this.f474k;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f475l > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i5 = this.f475l;
        this.f475l = i5 + 1;
        return a(i5);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f475l;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i5 = this.f475l - 1;
        this.f475l = i5;
        return a(i5);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f475l - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
