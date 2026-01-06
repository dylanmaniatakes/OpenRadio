package E1;

import w1.AbstractC0930a;

/* renamed from: E1.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0046t extends AbstractC0047u {

    /* renamed from: l, reason: collision with root package name */
    public final transient int f477l;

    /* renamed from: m, reason: collision with root package name */
    public final transient int f478m;
    public final /* synthetic */ AbstractC0047u n;

    public C0046t(AbstractC0047u abstractC0047u, int i5, int i6) {
        this.n = abstractC0047u;
        this.f477l = i5;
        this.f478m = i6;
    }

    @Override // E1.r
    public final int b() {
        return this.n.d() + this.f477l + this.f478m;
    }

    @Override // E1.r
    public final int d() {
        return this.n.d() + this.f477l;
    }

    @Override // E1.r
    public final Object[] e() {
        return this.n.e();
    }

    @Override // E1.AbstractC0047u, java.util.List
    /* renamed from: f */
    public final AbstractC0047u subList(int i5, int i6) {
        AbstractC0930a.s(i5, i6, this.f478m);
        int i7 = this.f477l;
        return this.n.subList(i5 + i7, i6 + i7);
    }

    @Override // java.util.List
    public final Object get(int i5) {
        AbstractC0930a.r(i5, this.f478m);
        return this.n.get(i5 + this.f477l);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f478m;
    }
}
