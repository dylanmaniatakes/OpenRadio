package y2;

import D1.S;

/* loaded from: classes.dex */
public final class k extends f {

    /* renamed from: m, reason: collision with root package name */
    public final transient m f10507m;
    public final transient AbstractC0985d n;

    public k(m mVar, l lVar) {
        this.f10507m = mVar;
        this.n = lVar;
    }

    @Override // y2.AbstractC0982a
    public final int a(Object[] objArr) {
        return this.n.a(objArr);
    }

    @Override // y2.AbstractC0982a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f10507m.get(obj) != null;
    }

    @Override // y2.f
    public final AbstractC0985d f() {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final S iterator() {
        return this.n.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f10507m.f10515o;
    }
}
