package J1;

import a.AbstractC0203a;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.measurement.C0354m0;
import java.util.ArrayDeque;
import java.util.Objects;

/* renamed from: J1.b1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0055b1 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1121c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1122d;

    public C0055b1(C0058c1 c0058c1) {
        this.f1121c = 0;
        this.f1122d = c0058c1;
    }

    private final void a(Activity activity) {
    }

    private final void b(Activity activity) {
    }

    private final void c(Activity activity) {
    }

    private final void d(Activity activity, Bundle bundle) {
    }

    private final void e(Activity activity) {
    }

    private final void f(Activity activity) {
    }

    private final void g(Activity activity) {
    }

    private final void h(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0048 A[Catch: all -> 0x0027, RuntimeException -> 0x002a, TryCatch #1 {RuntimeException -> 0x002a, blocks: (B:3:0x0004, B:5:0x0018, B:7:0x001e, B:22:0x0048, B:25:0x004f, B:27:0x0062, B:29:0x006a, B:35:0x007a, B:40:0x0087, B:15:0x002d, B:17:0x0034, B:19:0x0040), top: B:49:0x0004, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(com.google.android.gms.internal.measurement.X r10, android.os.Bundle r11) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f1122d
            J1.c1 r0 = (J1.C0058c1) r0
            java.lang.Object r1 = r0.f84c     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            J1.v0 r1 = (J1.C0113v0) r1     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            J1.Z r2 = r1.f1417k     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            J1.C0113v0.k(r2)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            J1.X r2 = r2.f1084p     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            java.lang.String r3 = "onActivityCreated"
            r2.a(r3)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            android.content.Intent r2 = r10.f4799l     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            if (r2 == 0) goto L97
            android.net.Uri r3 = r2.getData()     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            if (r3 == 0) goto L2d
            boolean r4 = r3.isHierarchical()     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            if (r4 != 0) goto L25
            goto L2d
        L25:
            r5 = r3
            goto L46
        L27:
            r1 = move-exception
            goto Lc1
        L2a:
            r1 = move-exception
            goto La4
        L2d:
            android.os.Bundle r3 = r2.getExtras()     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            r4 = 0
            if (r3 == 0) goto L45
            java.lang.String r5 = "com.android.vending.referral_url"
            java.lang.String r3 = r3.getString(r5)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            if (r5 != 0) goto L45
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            goto L25
        L45:
            r5 = r4
        L46:
            if (r5 == 0) goto L97
            boolean r3 = r5.isHierarchical()     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            if (r3 != 0) goto L4f
            goto L97
        L4f:
            J1.a2 r3 = r1.n     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            J1.C0113v0.i(r3)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            java.lang.String r3 = "android.intent.extra.REFERRER_NAME"
            java.lang.String r2 = r2.getStringExtra(r3)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            java.lang.String r3 = "android-app://com.google.android.googlequicksearchbox/https/www.google.com"
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            if (r3 != 0) goto L77
            java.lang.String r3 = "https://www.google.com"
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            if (r3 != 0) goto L77
            java.lang.String r3 = "android-app://com.google.appcrawler"
            boolean r2 = r3.equals(r2)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            if (r2 == 0) goto L73
            goto L77
        L73:
            java.lang.String r2 = "auto"
        L75:
            r6 = r2
            goto L7a
        L77:
            java.lang.String r2 = "gs"
            goto L75
        L7a:
            java.lang.String r2 = "referrer"
            java.lang.String r7 = r5.getQueryParameter(r2)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            if (r11 != 0) goto L85
            r2 = 1
        L83:
            r4 = r2
            goto L87
        L85:
            r2 = 0
            goto L83
        L87:
            J1.s0 r1 = r1.f1418l     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            J1.C0113v0.k(r1)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            J1.Z0 r8 = new J1.Z0     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            r2 = r8
            r3 = r9
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            r1.t(r8)     // Catch: java.lang.Throwable -> L27 java.lang.RuntimeException -> L2a
            goto Lb4
        L97:
            java.lang.Object r0 = r0.f84c
            J1.v0 r0 = (J1.C0113v0) r0
            J1.n1 r0 = r0.f1422q
            J1.C0113v0.j(r0)
            r0.s(r10, r11)
            return
        La4:
            java.lang.Object r2 = r0.f84c     // Catch: java.lang.Throwable -> L27
            J1.v0 r2 = (J1.C0113v0) r2     // Catch: java.lang.Throwable -> L27
            J1.Z r2 = r2.f1417k     // Catch: java.lang.Throwable -> L27
            J1.C0113v0.k(r2)     // Catch: java.lang.Throwable -> L27
            J1.X r2 = r2.h     // Catch: java.lang.Throwable -> L27
            java.lang.String r3 = "Throwable caught in onActivityCreated"
            r2.b(r1, r3)     // Catch: java.lang.Throwable -> L27
        Lb4:
            java.lang.Object r0 = r0.f84c
            J1.v0 r0 = (J1.C0113v0) r0
            J1.n1 r0 = r0.f1422q
            J1.C0113v0.j(r0)
            r0.s(r10, r11)
            return
        Lc1:
            java.lang.Object r0 = r0.f84c
            J1.v0 r0 = (J1.C0113v0) r0
            J1.n1 r0 = r0.f1422q
            J1.C0113v0.j(r0)
            r0.s(r10, r11)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0055b1.i(com.google.android.gms.internal.measurement.X, android.os.Bundle):void");
    }

    public void j(com.google.android.gms.internal.measurement.X x4) {
        C0091n1 c0091n1 = ((C0113v0) ((C0058c1) this.f1122d).f84c).f1422q;
        C0113v0.j(c0091n1);
        synchronized (c0091n1.n) {
            try {
                if (Objects.equals(c0091n1.f1317i, x4)) {
                    c0091n1.f1317i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (((C0113v0) c0091n1.f84c).f1415i.x()) {
            c0091n1.h.remove(Integer.valueOf(x4.f4797j));
        }
    }

    public void k(com.google.android.gms.internal.measurement.X x4) {
        C0113v0 c0113v0 = (C0113v0) ((C0058c1) this.f1122d).f84c;
        C0091n1 c0091n1 = c0113v0.f1422q;
        C0113v0.j(c0091n1);
        synchronized (c0091n1.n) {
            c0091n1.f1321m = false;
            c0091n1.f1318j = true;
        }
        C0113v0 c0113v02 = (C0113v0) c0091n1.f84c;
        c0113v02.f1421p.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (c0113v02.f1415i.x()) {
            C0082k1 c0082k1T = c0091n1.t(x4);
            c0091n1.f1316f = c0091n1.f1315e;
            c0091n1.f1315e = null;
            C0104s0 c0104s0 = c0113v02.f1418l;
            C0113v0.k(c0104s0);
            c0104s0.t(new R0(c0091n1, c0082k1T, jElapsedRealtime, 1));
        } else {
            c0091n1.f1315e = null;
            C0104s0 c0104s02 = c0113v02.f1418l;
            C0113v0.k(c0104s02);
            c0104s02.t(new RunnableC0118x(c0091n1, jElapsedRealtime, 1));
        }
        G1 g12 = c0113v0.f1419m;
        C0113v0.j(g12);
        C0113v0 c0113v03 = (C0113v0) g12.f84c;
        c0113v03.f1421p.getClass();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        C0104s0 c0104s03 = c0113v03.f1418l;
        C0113v0.k(c0104s03);
        c0104s03.t(new C1(g12, jElapsedRealtime2, 1));
    }

    public void l(com.google.android.gms.internal.measurement.X x4) {
        C0113v0 c0113v0 = (C0113v0) ((C0058c1) this.f1122d).f84c;
        G1 g12 = c0113v0.f1419m;
        C0113v0.j(g12);
        C0113v0 c0113v02 = (C0113v0) g12.f84c;
        c0113v02.f1421p.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C0104s0 c0104s0 = c0113v02.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.t(new C1(g12, jElapsedRealtime, 0));
        C0091n1 c0091n1 = c0113v0.f1422q;
        C0113v0.j(c0091n1);
        Object obj = c0091n1.n;
        synchronized (obj) {
            c0091n1.f1321m = true;
            if (!Objects.equals(x4, c0091n1.f1317i)) {
                synchronized (obj) {
                    c0091n1.f1317i = x4;
                    c0091n1.f1318j = false;
                    C0113v0 c0113v03 = (C0113v0) c0091n1.f84c;
                    if (c0113v03.f1415i.x()) {
                        c0091n1.f1319k = null;
                        C0104s0 c0104s02 = c0113v03.f1418l;
                        C0113v0.k(c0104s02);
                        c0104s02.t(new RunnableC0088m1(c0091n1, 1));
                    }
                }
            }
        }
        C0113v0 c0113v04 = (C0113v0) c0091n1.f84c;
        if (!c0113v04.f1415i.x()) {
            c0091n1.f1315e = c0091n1.f1319k;
            C0104s0 c0104s03 = c0113v04.f1418l;
            C0113v0.k(c0104s03);
            c0104s03.t(new RunnableC0088m1(c0091n1, 0));
            return;
        }
        c0091n1.n(x4.f4798k, c0091n1.t(x4), false);
        A a2 = ((C0113v0) c0091n1.f84c).f1424s;
        C0113v0.h(a2);
        C0113v0 c0113v05 = (C0113v0) a2.f84c;
        c0113v05.f1421p.getClass();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        C0104s0 c0104s04 = c0113v05.f1418l;
        C0113v0.k(c0104s04);
        c0104s04.t(new RunnableC0118x(a2, jElapsedRealtime2, 0));
    }

    public void m(com.google.android.gms.internal.measurement.X x4, Bundle bundle) {
        C0082k1 c0082k1;
        C0091n1 c0091n1 = ((C0113v0) ((C0058c1) this.f1122d).f84c).f1422q;
        C0113v0.j(c0091n1);
        if (!((C0113v0) c0091n1.f84c).f1415i.x() || bundle == null || (c0082k1 = (C0082k1) c0091n1.h.get(Integer.valueOf(x4.f4797j))) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", c0082k1.f1284c);
        bundle2.putString("name", c0082k1.f1282a);
        bundle2.putString("referrer_name", c0082k1.f1283b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        switch (this.f1121c) {
            case 0:
                i(com.google.android.gms.internal.measurement.X.a(activity), bundle);
                break;
            default:
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Bundle bundle2 = null;
                    try {
                        Bundle extras = intent.getExtras();
                        if (extras != null) {
                            String string = extras.getString("google.message_id");
                            if (string == null) {
                                string = extras.getString("message_id");
                            }
                            if (!TextUtils.isEmpty(string)) {
                                ArrayDeque arrayDeque = (ArrayDeque) this.f1122d;
                                if (arrayDeque.contains(string)) {
                                    break;
                                } else {
                                    arrayDeque.add(string);
                                }
                            }
                            bundle2 = extras.getBundle("gcm.n.analytics_data");
                        }
                    } catch (RuntimeException e5) {
                        Log.w("FirebaseMessaging", "Failed trying to get analytics data from Intent extras.", e5);
                    }
                    if (bundle2 == null ? false : "1".equals(bundle2.getString("google.c.a.e"))) {
                        if (bundle2 != null) {
                            if ("1".equals(bundle2.getString("google.c.a.tc"))) {
                                A2.g gVarB = A2.g.b();
                                gVarB.a();
                                C2.a aVar = (C2.a) gVarB.f29d.a(C2.a.class);
                                if (Log.isLoggable("FirebaseMessaging", 3)) {
                                    Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                                }
                                if (aVar != null) {
                                    String string2 = bundle2.getString("google.c.a.c_id");
                                    C2.b bVar = (C2.b) aVar;
                                    if (!D2.a.f415b.contains("fcm")) {
                                        C0354m0 c0354m0 = (C0354m0) bVar.f184a.f1554d;
                                        c0354m0.getClass();
                                        c0354m0.b(new com.google.android.gms.internal.measurement.Y(c0354m0, string2));
                                    }
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putString("source", "Firebase");
                                    bundle3.putString("medium", "notification");
                                    bundle3.putString("campaign", string2);
                                    bVar.a(bundle3, "_cmp");
                                } else {
                                    Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                                }
                            } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                                Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
                            }
                        }
                        AbstractC0203a.j(bundle2, "_no");
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        switch (this.f1121c) {
            case 0:
                j(com.google.android.gms.internal.measurement.X.a(activity));
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        switch (this.f1121c) {
            case 0:
                k(com.google.android.gms.internal.measurement.X.a(activity));
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        switch (this.f1121c) {
            case 0:
                l(com.google.android.gms.internal.measurement.X.a(activity));
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        switch (this.f1121c) {
            case 0:
                m(com.google.android.gms.internal.measurement.X.a(activity), bundle);
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        int i5 = this.f1121c;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        int i5 = this.f1121c;
    }

    public C0055b1() {
        this.f1121c = 1;
        this.f1122d = new ArrayDeque(10);
    }
}
