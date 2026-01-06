package Y0;

import g0.AbstractC0535a;

/* loaded from: classes.dex */
public final class f implements J2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final f f2900a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static final J2.c f2901b = new J2.c("currentCacheSizeBytes", AbstractC0535a.o(AbstractC0535a.n(M2.e.class, new M2.a(1))));

    /* renamed from: c, reason: collision with root package name */
    public static final J2.c f2902c = new J2.c("maxCacheSizeBytes", AbstractC0535a.o(AbstractC0535a.n(M2.e.class, new M2.a(2))));

    @Override // J2.a
    public final void a(Object obj, Object obj2) {
        b1.f fVar = (b1.f) obj;
        J2.e eVar = (J2.e) obj2;
        eVar.a(f2901b, fVar.f4532a);
        eVar.a(f2902c, fVar.f4533b);
    }
}
