package Y0;

import g0.AbstractC0535a;

/* loaded from: classes.dex */
public final class g implements J2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final g f2903a = new g();

    /* renamed from: b, reason: collision with root package name */
    public static final J2.c f2904b = new J2.c("startMs", AbstractC0535a.o(AbstractC0535a.n(M2.e.class, new M2.a(1))));

    /* renamed from: c, reason: collision with root package name */
    public static final J2.c f2905c = new J2.c("endMs", AbstractC0535a.o(AbstractC0535a.n(M2.e.class, new M2.a(2))));

    @Override // J2.a
    public final void a(Object obj, Object obj2) {
        b1.g gVar = (b1.g) obj;
        J2.e eVar = (J2.e) obj2;
        eVar.a(f2904b, gVar.f4534a);
        eVar.a(f2905c, gVar.f4535b);
    }
}
