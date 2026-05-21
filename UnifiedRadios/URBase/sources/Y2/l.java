package y2;

import java.util.Objects;

/* loaded from: classes.dex */
public final class l extends AbstractC0985d {

    /* renamed from: l, reason: collision with root package name */
    public final transient Object[] f10508l;

    /* renamed from: m, reason: collision with root package name */
    public final transient int f10509m;
    public final transient int n;

    public l(Object[] objArr, int i5, int i6) {
        this.f10508l = objArr;
        this.f10509m = i5;
        this.n = i6;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        L0.f.c(i5, this.n);
        Object obj = this.f10508l[(i5 * 2) + this.f10509m];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.n;
    }
}
