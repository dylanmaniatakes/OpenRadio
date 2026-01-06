package y2;

import java.util.Objects;

/* loaded from: classes.dex */
public final class h extends AbstractC0985d {
    public static final h n = new h(0, new Object[0]);

    /* renamed from: l, reason: collision with root package name */
    public final transient Object[] f10501l;

    /* renamed from: m, reason: collision with root package name */
    public final transient int f10502m;

    public h(int i5, Object[] objArr) {
        this.f10501l = objArr;
        this.f10502m = i5;
    }

    @Override // y2.AbstractC0985d, y2.AbstractC0982a
    public final int a(Object[] objArr) {
        Object[] objArr2 = this.f10501l;
        int i5 = this.f10502m;
        System.arraycopy(objArr2, 0, objArr, 0, i5);
        return i5;
    }

    @Override // y2.AbstractC0982a
    public final Object[] b() {
        return this.f10501l;
    }

    @Override // y2.AbstractC0982a
    public final int d() {
        return this.f10502m;
    }

    @Override // y2.AbstractC0982a
    public final int e() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        L0.f.c(i5, this.f10502m);
        Object obj = this.f10501l[i5];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f10502m;
    }
}
