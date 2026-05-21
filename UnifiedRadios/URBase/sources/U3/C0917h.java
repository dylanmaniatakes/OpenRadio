package u3;

import F3.i;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: u3.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0917h extends t3.e implements Serializable {

    /* renamed from: k, reason: collision with root package name */
    public static final C0917h f9963k;

    /* renamed from: j, reason: collision with root package name */
    public final C0914e f9964j;

    static {
        C0914e c0914e = C0914e.f9948v;
        f9963k = new C0917h(C0914e.f9948v);
    }

    public C0917h(C0914e c0914e) {
        i.f(c0914e, "backing");
        this.f9964j = c0914e;
    }

    @Override // t3.e
    public final int a() {
        return this.f9964j.f9955q;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        return this.f9964j.a(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        i.f(collection, "elements");
        this.f9964j.c();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f9964j.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f9964j.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f9964j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        C0914e c0914e = this.f9964j;
        c0914e.getClass();
        return new C0912c(c0914e, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        C0914e c0914e = this.f9964j;
        c0914e.c();
        int iG = c0914e.g(obj);
        if (iG < 0) {
            iG = -1;
        } else {
            c0914e.k(iG);
        }
        return iG >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        i.f(collection, "elements");
        this.f9964j.c();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        i.f(collection, "elements");
        this.f9964j.c();
        return super.retainAll(collection);
    }

    public C0917h() {
        this(new C0914e());
    }
}
