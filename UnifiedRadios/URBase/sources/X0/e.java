package X0;

/* loaded from: classes.dex */
public final class e implements J2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final e f2695a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final J2.c f2696b = J2.c.a("eventTimeMs");

    /* renamed from: c, reason: collision with root package name */
    public static final J2.c f2697c = J2.c.a("eventCode");

    /* renamed from: d, reason: collision with root package name */
    public static final J2.c f2698d = J2.c.a("eventUptimeMs");

    /* renamed from: e, reason: collision with root package name */
    public static final J2.c f2699e = J2.c.a("sourceExtension");

    /* renamed from: f, reason: collision with root package name */
    public static final J2.c f2700f = J2.c.a("sourceExtensionJsonProto3");
    public static final J2.c g = J2.c.a("timezoneOffsetSeconds");
    public static final J2.c h = J2.c.a("networkConnectionInfo");

    @Override // J2.a
    public final void a(Object obj, Object obj2) {
        J2.e eVar = (J2.e) obj2;
        l lVar = (l) ((s) obj);
        eVar.a(f2696b, lVar.f2724a);
        eVar.e(f2697c, lVar.f2725b);
        eVar.a(f2698d, lVar.f2726c);
        eVar.e(f2699e, lVar.f2727d);
        eVar.e(f2700f, lVar.f2728e);
        eVar.a(g, lVar.f2729f);
        eVar.e(h, lVar.g);
    }
}
