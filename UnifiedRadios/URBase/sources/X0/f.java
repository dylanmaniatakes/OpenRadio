package X0;

/* loaded from: classes.dex */
public final class f implements J2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final f f2701a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static final J2.c f2702b = J2.c.a("requestTimeMs");

    /* renamed from: c, reason: collision with root package name */
    public static final J2.c f2703c = J2.c.a("requestUptimeMs");

    /* renamed from: d, reason: collision with root package name */
    public static final J2.c f2704d = J2.c.a("clientInfo");

    /* renamed from: e, reason: collision with root package name */
    public static final J2.c f2705e = J2.c.a("logSource");

    /* renamed from: f, reason: collision with root package name */
    public static final J2.c f2706f = J2.c.a("logSourceName");
    public static final J2.c g = J2.c.a("logEvent");
    public static final J2.c h = J2.c.a("qosTier");

    @Override // J2.a
    public final void a(Object obj, Object obj2) {
        J2.e eVar = (J2.e) obj2;
        m mVar = (m) ((t) obj);
        eVar.a(f2702b, mVar.f2730a);
        eVar.a(f2703c, mVar.f2731b);
        eVar.e(f2704d, mVar.f2732c);
        eVar.e(f2705e, mVar.f2733d);
        eVar.e(f2706f, mVar.f2734e);
        eVar.e(g, mVar.f2735f);
        eVar.e(h, mVar.g);
    }
}
