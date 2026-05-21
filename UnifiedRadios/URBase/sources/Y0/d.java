package Y0;

import g0.AbstractC0535a;

/* loaded from: classes.dex */
public final class d implements J2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f2896a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final J2.c f2897b = new J2.c("logSource", AbstractC0535a.o(AbstractC0535a.n(M2.e.class, new M2.a(1))));

    /* renamed from: c, reason: collision with root package name */
    public static final J2.c f2898c = new J2.c("logEventDropped", AbstractC0535a.o(AbstractC0535a.n(M2.e.class, new M2.a(2))));

    @Override // J2.a
    public final void a(Object obj, Object obj2) {
        b1.e eVar = (b1.e) obj;
        J2.e eVar2 = (J2.e) obj2;
        eVar2.e(f2897b, eVar.f4530a);
        eVar2.e(f2898c, eVar.f4531b);
    }
}
