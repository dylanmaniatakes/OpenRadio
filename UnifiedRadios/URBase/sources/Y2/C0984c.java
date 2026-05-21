package y2;

import java.util.Iterator;
import java.util.ListIterator;

/* renamed from: y2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0984c extends AbstractC0985d {

    /* renamed from: l, reason: collision with root package name */
    public final transient int f10491l;

    /* renamed from: m, reason: collision with root package name */
    public final transient int f10492m;
    public final /* synthetic */ AbstractC0985d n;

    public C0984c(AbstractC0985d abstractC0985d, int i5, int i6) {
        this.n = abstractC0985d;
        this.f10491l = i5;
        this.f10492m = i6;
    }

    @Override // y2.AbstractC0982a
    public final Object[] b() {
        return this.n.b();
    }

    @Override // y2.AbstractC0982a
    public final int d() {
        return this.n.e() + this.f10491l + this.f10492m;
    }

    @Override // y2.AbstractC0982a
    public final int e() {
        return this.n.e() + this.f10491l;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        L0.f.c(i5, this.f10492m);
        return this.n.get(i5 + this.f10491l);
    }

    @Override // y2.AbstractC0985d, java.util.List
    /* renamed from: h */
    public final AbstractC0985d subList(int i5, int i6) {
        L0.f.e(i5, i6, this.f10492m);
        int i7 = this.f10491l;
        return this.n.subList(i5 + i7, i6 + i7);
    }

    @Override // y2.AbstractC0985d, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // y2.AbstractC0985d, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f10492m;
    }

    @Override // y2.AbstractC0985d, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i5) {
        return listIterator(i5);
    }
}
