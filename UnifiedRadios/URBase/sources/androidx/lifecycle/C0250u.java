package androidx.lifecycle;

/* renamed from: androidx.lifecycle.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0250u {

    /* renamed from: a, reason: collision with root package name */
    public EnumC0244n f3967a;

    /* renamed from: b, reason: collision with root package name */
    public r f3968b;

    public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) {
        EnumC0244n enumC0244nA = enumC0243m.a();
        EnumC0244n enumC0244n = this.f3967a;
        F3.i.f(enumC0244n, "state1");
        if (enumC0244nA.compareTo(enumC0244n) < 0) {
            enumC0244n = enumC0244nA;
        }
        this.f3967a = enumC0244n;
        this.f3968b.a(interfaceC0249t, enumC0243m);
        this.f3967a = enumC0244nA;
    }
}
