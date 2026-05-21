package E1;

import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class y extends AbstractC0047u {
    public static final y n = new y(0, new Object[0]);

    /* renamed from: l, reason: collision with root package name */
    public final transient Object[] f484l;

    /* renamed from: m, reason: collision with root package name */
    public final transient int f485m;

    public y(int i5, Object[] objArr) {
        this.f484l = objArr;
        this.f485m = i5;
    }

    @Override // E1.AbstractC0047u, E1.r
    public final int a(Object[] objArr) {
        Object[] objArr2 = this.f484l;
        int i5 = this.f485m;
        System.arraycopy(objArr2, 0, objArr, 0, i5);
        return i5;
    }

    @Override // E1.r
    public final int b() {
        return this.f485m;
    }

    @Override // E1.r
    public final int d() {
        return 0;
    }

    @Override // E1.r
    public final Object[] e() {
        return this.f484l;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        AbstractC0930a.r(i5, this.f485m);
        Object obj = this.f484l[i5];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f485m;
    }
}
