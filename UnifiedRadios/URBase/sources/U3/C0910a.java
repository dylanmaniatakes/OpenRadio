package u3;

import F3.i;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* renamed from: u3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0910a implements ListIterator, G3.a {

    /* renamed from: j, reason: collision with root package name */
    public final C0911b f9933j;

    /* renamed from: k, reason: collision with root package name */
    public int f9934k;

    /* renamed from: l, reason: collision with root package name */
    public int f9935l;

    public C0910a(C0911b c0911b, int i5) {
        i.f(c0911b, "list");
        this.f9933j = c0911b;
        this.f9934k = i5;
        this.f9935l = -1;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        int i5 = this.f9934k;
        this.f9934k = i5 + 1;
        this.f9933j.add(i5, obj);
        this.f9935l = -1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f9934k < this.f9933j.f9939l;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f9934k > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        int i5 = this.f9934k;
        C0911b c0911b = this.f9933j;
        if (i5 >= c0911b.f9939l) {
            throw new NoSuchElementException();
        }
        this.f9934k = i5 + 1;
        this.f9935l = i5;
        return c0911b.f9937j[c0911b.f9938k + i5];
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f9934k;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        int i5 = this.f9934k;
        if (i5 <= 0) {
            throw new NoSuchElementException();
        }
        int i6 = i5 - 1;
        this.f9934k = i6;
        this.f9935l = i6;
        C0911b c0911b = this.f9933j;
        return c0911b.f9937j[c0911b.f9938k + i6];
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f9934k - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i5 = this.f9935l;
        if (i5 == -1) {
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }
        this.f9933j.b(i5);
        this.f9934k = this.f9935l;
        this.f9935l = -1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        int i5 = this.f9935l;
        if (i5 == -1) {
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
        this.f9933j.set(i5, obj);
    }
}
