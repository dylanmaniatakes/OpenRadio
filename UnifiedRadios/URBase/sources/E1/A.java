package E1;

import g0.AbstractC0535a;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class A extends AbstractC0049w {

    /* renamed from: m, reason: collision with root package name */
    public final transient Object f461m;

    public A(Object obj) {
        this.f461m = obj;
    }

    @Override // E1.r
    public final int a(Object[] objArr) {
        objArr[0] = this.f461m;
        return 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f461m.equals(obj);
    }

    @Override // E1.AbstractC0049w, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f461m.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return new x(this.f461m);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return AbstractC0535a.l("[", this.f461m.toString(), "]");
    }
}
