package u3;

import F3.i;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: u3.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0916g extends AbstractCollection implements Collection, G3.a {

    /* renamed from: j, reason: collision with root package name */
    public final C0914e f9962j;

    public C0916g(C0914e c0914e) {
        i.f(c0914e, "backing");
        this.f9962j = c0914e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        i.f(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f9962j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f9962j.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.f9962j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        C0914e c0914e = this.f9962j;
        c0914e.getClass();
        return new C0912c(c0914e, 2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        C0914e c0914e = this.f9962j;
        c0914e.c();
        int iH = c0914e.h(obj);
        if (iH < 0) {
            return false;
        }
        c0914e.k(iH);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        i.f(collection, "elements");
        this.f9962j.c();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        i.f(collection, "elements");
        this.f9962j.c();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f9962j.f9955q;
    }
}
