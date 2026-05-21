package J1;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.C0414y1;
import com.google.android.gms.internal.measurement.C0419z1;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import u1.C0906a;
import x2.C0970e;
import x2.C0971f;
import x2.InterfaceC0969d;
import z2.RunnableC0999a;

/* renamed from: J1.v0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0113v0 implements G0 {

    /* renamed from: J, reason: collision with root package name */
    public static volatile C0113v0 f1402J;

    /* renamed from: B, reason: collision with root package name */
    public Boolean f1404B;

    /* renamed from: C, reason: collision with root package name */
    public long f1405C;

    /* renamed from: D, reason: collision with root package name */
    public volatile Boolean f1406D;

    /* renamed from: E, reason: collision with root package name */
    public volatile boolean f1407E;

    /* renamed from: F, reason: collision with root package name */
    public int f1408F;

    /* renamed from: G, reason: collision with root package name */
    public int f1409G;
    public final long I;

    /* renamed from: c, reason: collision with root package name */
    public final Context f1411c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1412d;

    /* renamed from: e, reason: collision with root package name */
    public final String f1413e;

    /* renamed from: f, reason: collision with root package name */
    public final String f1414f;
    public final boolean g;
    public final O2.e h;

    /* renamed from: i, reason: collision with root package name */
    public final C0068g f1415i;

    /* renamed from: j, reason: collision with root package name */
    public final C0072h0 f1416j;

    /* renamed from: k, reason: collision with root package name */
    public final Z f1417k;

    /* renamed from: l, reason: collision with root package name */
    public final C0104s0 f1418l;

    /* renamed from: m, reason: collision with root package name */
    public final G1 f1419m;
    public final a2 n;

    /* renamed from: o, reason: collision with root package name */
    public final S f1420o;

    /* renamed from: p, reason: collision with root package name */
    public final C0906a f1421p;

    /* renamed from: q, reason: collision with root package name */
    public final C0091n1 f1422q;

    /* renamed from: r, reason: collision with root package name */
    public final C0058c1 f1423r;

    /* renamed from: s, reason: collision with root package name */
    public final A f1424s;

    /* renamed from: t, reason: collision with root package name */
    public final C0070g1 f1425t;

    /* renamed from: u, reason: collision with root package name */
    public final String f1426u;

    /* renamed from: v, reason: collision with root package name */
    public Q f1427v;

    /* renamed from: w, reason: collision with root package name */
    public C0120x1 f1428w;

    /* renamed from: x, reason: collision with root package name */
    public C0098q f1429x;

    /* renamed from: y, reason: collision with root package name */
    public O f1430y;

    /* renamed from: z, reason: collision with root package name */
    public C0073h1 f1431z;

    /* renamed from: A, reason: collision with root package name */
    public boolean f1403A = false;

    /* renamed from: H, reason: collision with root package name */
    public final AtomicInteger f1410H = new AtomicInteger(0);

    /* JADX WARN: Type inference failed for: r4v8, types: [com.google.android.gms.internal.measurement.H1, x2.d] */
    public C0113v0(M0 m02) {
        InterfaceC0969d c0970e;
        Context context;
        Context context2 = m02.f894a;
        O2.e eVar = new O2.e(12);
        this.h = eVar;
        L0.f892k = eVar;
        this.f1411c = context2;
        this.f1412d = m02.f895b;
        this.f1413e = m02.f896c;
        this.f1414f = m02.f897d;
        this.g = m02.h;
        this.f1406D = m02.f898e;
        this.f1426u = m02.f901j;
        this.f1407E = true;
        if (com.google.android.gms.internal.measurement.J1.h == null && context2 != null) {
            Object obj = com.google.android.gms.internal.measurement.J1.g;
            synchronized (obj) {
                try {
                    if (com.google.android.gms.internal.measurement.J1.h == null) {
                        synchronized (obj) {
                            C0414y1 c0414y1 = com.google.android.gms.internal.measurement.J1.h;
                            final Context applicationContext = context2.getApplicationContext();
                            if (applicationContext == null) {
                                applicationContext = context2;
                            }
                            if (c0414y1 == null || c0414y1.f5139a != applicationContext) {
                                if (c0414y1 != null) {
                                    C0419z1.d();
                                    com.google.android.gms.internal.measurement.K1.a();
                                    synchronized (com.google.android.gms.internal.measurement.C1.class) {
                                        try {
                                            com.google.android.gms.internal.measurement.C1 c1 = com.google.android.gms.internal.measurement.C1.f4661d;
                                            if (c1 != null && (context = (Context) c1.f4663b) != null && ((com.google.android.gms.internal.measurement.B1) c1.f4664c) != null && c1.f4662a) {
                                                context.getContentResolver().unregisterContentObserver((com.google.android.gms.internal.measurement.B1) com.google.android.gms.internal.measurement.C1.f4661d.f4664c);
                                            }
                                            com.google.android.gms.internal.measurement.C1.f4661d = null;
                                        } finally {
                                        }
                                    }
                                }
                                ?? r4 = new InterfaceC0969d() { // from class: com.google.android.gms.internal.measurement.H1
                                    /* JADX WARN: Removed duplicated region for block: B:20:0x003a A[Catch: all -> 0x0026, TryCatch #2 {all -> 0x0026, all -> 0x006c, blocks: (B:6:0x000b, B:8:0x000f, B:10:0x001d, B:20:0x003a, B:73:0x015e, B:15:0x0029, B:17:0x0031, B:21:0x003e, B:23:0x0044, B:24:0x0048, B:72:0x015b, B:74:0x0162, B:75:0x0165, B:76:0x0166, B:25:0x004c, B:27:0x0050, B:28:0x005d, B:30:0x0063, B:36:0x0079, B:38:0x007f, B:39:0x0085, B:59:0x013e, B:60:0x0141, B:68:0x0152, B:67:0x014f, B:69:0x0153, B:70:0x0158, B:71:0x0159, B:31:0x0069, B:35:0x0070), top: B:84:0x000b }] */
                                    @Override // x2.InterfaceC0969d
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                        To view partially-correct add '--show-bad-code' argument
                                    */
                                    public final java.lang.Object get() {
                                        /*
                                            Method dump skipped, instructions count: 363
                                            To view this dump add '--comments-level debug' option
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.H1.get():java.lang.Object");
                                    }
                                };
                                if (r4 instanceof Serializable) {
                                    c0970e = new C0970e(r4);
                                } else {
                                    C0971f c0971f = new C0971f();
                                    c0971f.f10444j = r4;
                                    c0970e = c0971f;
                                }
                                com.google.android.gms.internal.measurement.J1.h = new C0414y1(applicationContext, c0970e);
                                com.google.android.gms.internal.measurement.J1.f4703i.incrementAndGet();
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                } finally {
                }
            }
        }
        this.f1421p = C0906a.f9918a;
        Long l5 = m02.f900i;
        this.I = l5 != null ? l5.longValue() : System.currentTimeMillis();
        C0068g c0068g = new C0068g(this);
        c0068g.f1215f = new n2.e(12);
        this.f1415i = c0068g;
        C0072h0 c0072h0 = new C0072h0(this);
        c0072h0.m();
        this.f1416j = c0072h0;
        Z z4 = new Z(this);
        z4.m();
        this.f1417k = z4;
        a2 a2Var = new a2(this);
        a2Var.m();
        this.n = a2Var;
        this.f1420o = new S(new C0078j0(this));
        this.f1424s = new A(this);
        C0091n1 c0091n1 = new C0091n1(this);
        c0091n1.l();
        this.f1422q = c0091n1;
        C0058c1 c0058c1 = new C0058c1(this);
        c0058c1.l();
        this.f1423r = c0058c1;
        G1 g12 = new G1(this);
        g12.l();
        this.f1419m = g12;
        C0070g1 c0070g1 = new C0070g1(this);
        c0070g1.m();
        this.f1425t = c0070g1;
        C0104s0 c0104s0 = new C0104s0(this);
        c0104s0.m();
        this.f1418l = c0104s0;
        com.google.android.gms.internal.measurement.V v4 = m02.g;
        boolean z5 = v4 == null || v4.f4780k == 0;
        if (context2.getApplicationContext() instanceof Application) {
            j(c0058c1);
            if (((C0113v0) c0058c1.f84c).f1411c.getApplicationContext() instanceof Application) {
                Application application = (Application) ((C0113v0) c0058c1.f84c).f1411c.getApplicationContext();
                if (c0058c1.f1163e == null) {
                    c0058c1.f1163e = new C0055b1(c0058c1);
                }
                if (z5) {
                    application.unregisterActivityLifecycleCallbacks(c0058c1.f1163e);
                    application.registerActivityLifecycleCallbacks(c0058c1.f1163e);
                    Z z6 = ((C0113v0) c0058c1.f84c).f1417k;
                    k(z6);
                    z6.f1084p.a("Registered activity lifecycle callback");
                }
            }
        } else {
            k(z4);
            z4.f1080k.a("Application context is not an Application");
        }
        c0104s0.t(new RunnableC0999a(8, this, m02, false));
    }

    public static final void h(B b5) {
        if (b5 == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static final void i(B.u uVar) {
        if (uVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public static final void j(E e5) {
        if (e5 == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!e5.f727d) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(e5.getClass())));
        }
    }

    public static final void k(F0 f02) {
        if (f02 == null) {
            throw new IllegalStateException("Component not created");
        }
        if (!f02.f733d) {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(f02.getClass())));
        }
    }

    public static C0113v0 q(Context context, com.google.android.gms.internal.measurement.V v4, Long l5) {
        Bundle bundle;
        if (v4 != null && (v4.n == null || v4.f4783o == null)) {
            v4 = new com.google.android.gms.internal.measurement.V(v4.f4779j, v4.f4780k, v4.f4781l, v4.f4782m, null, null, v4.f4784p, null);
        }
        q1.E.i(context);
        q1.E.i(context.getApplicationContext());
        if (f1402J == null) {
            synchronized (C0113v0.class) {
                try {
                    if (f1402J == null) {
                        f1402J = new C0113v0(new M0(context, v4, l5));
                    }
                } finally {
                }
            }
        } else if (v4 != null && (bundle = v4.f4784p) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            q1.E.i(f1402J);
            f1402J.f1406D = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled"));
        }
        q1.E.i(f1402J);
        return f1402J;
    }

    @Override // J1.G0
    public final O2.e a() {
        return this.h;
    }

    public final boolean b() {
        return l() == 0;
    }

    @Override // J1.G0
    public final Z c() {
        Z z4 = this.f1417k;
        k(z4);
        return z4;
    }

    @Override // J1.G0
    public final Context d() {
        return this.f1411c;
    }

    @Override // J1.G0
    public final C0104s0 e() {
        C0104s0 c0104s0 = this.f1418l;
        k(c0104s0);
        return c0104s0;
    }

    @Override // J1.G0
    public final C0906a f() {
        return this.f1421p;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g() {
        /*
            r6 = this;
            boolean r0 = r6.f1403A
            if (r0 == 0) goto Lbb
            J1.s0 r0 = r6.f1418l
            k(r0)
            r0.j()
            java.lang.Boolean r0 = r6.f1404B
            u1.a r1 = r6.f1421p
            if (r0 == 0) goto L34
            long r2 = r6.f1405C
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L34
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto Lb4
            r1.getClass()
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = r6.f1405C
            long r2 = r2 - r4
            long r2 = java.lang.Math.abs(r2)
            r4 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto Lb4
        L34:
            r1.getClass()
            long r0 = android.os.SystemClock.elapsedRealtime()
            r6.f1405C = r0
            J1.a2 r0 = r6.n
            i(r0)
            java.lang.String r1 = "android.permission.INTERNET"
            boolean r1 = r0.Z(r1)
            J1.g r2 = r6.f1415i
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L76
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r1 = r0.Z(r1)
            if (r1 == 0) goto L76
            android.content.Context r1 = r6.f1411c
            J1.B1 r5 = w1.C0931b.a(r1)
            boolean r5 = r5.c()
            if (r5 != 0) goto L74
            boolean r5 = r2.m()
            if (r5 != 0) goto L74
            boolean r5 = J1.a2.g0(r1)
            if (r5 == 0) goto L76
            boolean r1 = J1.a2.h0(r1)
            if (r1 == 0) goto L76
        L74:
            r1 = r3
            goto L77
        L76:
            r1 = r4
        L77:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            r6.f1404B = r5
            if (r1 == 0) goto Lb4
            J1.O r1 = r6.n()
            java.lang.String r1 = r1.r()
            J1.O r5 = r6.n()
            java.lang.String r5 = r5.p()
            boolean r0 = r0.T(r1, r5)
            if (r0 != 0) goto Lae
            r0 = 0
            J1.G r1 = J1.H.f838p1
            boolean r0 = r2.w(r0, r1)
            if (r0 != 0) goto Lad
            J1.O r0 = r6.n()
            java.lang.String r0 = r0.p()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lad
            goto Lae
        Lad:
            r3 = r4
        Lae:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            r6.f1404B = r0
        Lb4:
            java.lang.Boolean r0 = r6.f1404B
            boolean r0 = r0.booleanValue()
            return r0
        Lbb:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "AppMeasurement is not initialized"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0113v0.g():boolean");
    }

    public final int l() {
        C0104s0 c0104s0 = this.f1418l;
        k(c0104s0);
        c0104s0.j();
        C0068g c0068g = this.f1415i;
        if (c0068g.k()) {
            return 1;
        }
        k(c0104s0);
        c0104s0.j();
        if (!this.f1407E) {
            return 8;
        }
        C0072h0 c0072h0 = this.f1416j;
        i(c0072h0);
        c0072h0.j();
        Boolean boolValueOf = c0072h0.p().contains("measurement_enabled") ? Boolean.valueOf(c0072h0.p().getBoolean("measurement_enabled", true)) : null;
        if (boolValueOf != null) {
            return boolValueOf.booleanValue() ? 0 : 3;
        }
        O2.e eVar = ((C0113v0) c0068g.f84c).h;
        Boolean boolU = c0068g.u("firebase_analytics_collection_enabled");
        return boolU != null ? boolU.booleanValue() ? 0 : 4 : (this.f1406D == null || this.f1406D.booleanValue()) ? 0 : 7;
    }

    public final C0098q m() {
        k(this.f1429x);
        return this.f1429x;
    }

    public final O n() {
        j(this.f1430y);
        return this.f1430y;
    }

    public final Q o() {
        j(this.f1427v);
        return this.f1427v;
    }

    public final S p() {
        return this.f1420o;
    }

    public final C0120x1 r() {
        j(this.f1428w);
        return this.f1428w;
    }

    public final String s() {
        if (this.f1415i.w(null, H.f838p1)) {
            return null;
        }
        return this.f1412d;
    }
}
