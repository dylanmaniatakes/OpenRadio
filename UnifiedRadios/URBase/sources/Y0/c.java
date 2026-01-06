package Y0;

import g0.AbstractC0535a;

/* loaded from: classes.dex */
public final class c implements J2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final c f2893a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final J2.c f2894b = new J2.c("eventsDroppedCount", AbstractC0535a.o(AbstractC0535a.n(M2.e.class, new M2.a(1))));

    /* renamed from: c, reason: collision with root package name */
    public static final J2.c f2895c = new J2.c("reason", AbstractC0535a.o(AbstractC0535a.n(M2.e.class, new M2.a(3))));

    @Override // J2.a
    public final void a(Object obj, Object obj2) {
        b1.d dVar = (b1.d) obj;
        J2.e eVar = (J2.e) obj2;
        eVar.a(f2894b, dVar.f4527a);
        eVar.e(f2895c, dVar.f4528b);
    }
}
