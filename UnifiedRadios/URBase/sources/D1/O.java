package D1;

import com.google.android.gms.internal.measurement.AbstractC0296a2;

/* loaded from: classes.dex */
public final class O extends P {

    /* renamed from: l, reason: collision with root package name */
    public final transient int f370l;

    /* renamed from: m, reason: collision with root package name */
    public final transient int f371m;
    public final /* synthetic */ P n;

    public O(P p4, int i5, int i6) {
        this.n = p4;
        this.f370l = i5;
        this.f371m = i6;
    }

    @Override // D1.M
    public final Object[] a() {
        return this.n.a();
    }

    @Override // D1.M
    public final int b() {
        return this.n.b() + this.f370l;
    }

    @Override // D1.M
    public final int d() {
        return this.n.b() + this.f370l + this.f371m;
    }

    @Override // D1.M
    public final boolean e() {
        return true;
    }

    @Override // D1.P, java.util.List
    /* renamed from: g */
    public final P subList(int i5, int i6) {
        AbstractC0296a2.u(i5, i6, this.f371m);
        int i7 = this.f370l;
        return this.n.subList(i5 + i7, i6 + i7);
    }

    @Override // java.util.List
    public final Object get(int i5) {
        AbstractC0296a2.s(i5, this.f371m);
        return this.n.get(i5 + this.f370l);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f371m;
    }
}
