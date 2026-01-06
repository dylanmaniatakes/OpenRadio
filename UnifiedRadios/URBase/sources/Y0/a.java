package Y0;

import b1.C0284a;
import g0.AbstractC0535a;

/* loaded from: classes.dex */
public final class a implements J2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final a f2886a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final J2.c f2887b = new J2.c("window", AbstractC0535a.o(AbstractC0535a.n(M2.e.class, new M2.a(1))));

    /* renamed from: c, reason: collision with root package name */
    public static final J2.c f2888c = new J2.c("logSourceMetrics", AbstractC0535a.o(AbstractC0535a.n(M2.e.class, new M2.a(2))));

    /* renamed from: d, reason: collision with root package name */
    public static final J2.c f2889d = new J2.c("globalMetrics", AbstractC0535a.o(AbstractC0535a.n(M2.e.class, new M2.a(3))));

    /* renamed from: e, reason: collision with root package name */
    public static final J2.c f2890e = new J2.c("appNamespace", AbstractC0535a.o(AbstractC0535a.n(M2.e.class, new M2.a(4))));

    @Override // J2.a
    public final void a(Object obj, Object obj2) {
        C0284a c0284a = (C0284a) obj;
        J2.e eVar = (J2.e) obj2;
        eVar.e(f2887b, c0284a.f4514a);
        eVar.e(f2888c, c0284a.f4515b);
        eVar.e(f2889d, c0284a.f4516c);
        eVar.e(f2890e, c0284a.f4517d);
    }
}
