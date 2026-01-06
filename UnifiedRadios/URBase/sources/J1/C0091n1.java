package J1;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: J1.n1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0091n1 extends E {

    /* renamed from: e, reason: collision with root package name */
    public volatile C0082k1 f1315e;

    /* renamed from: f, reason: collision with root package name */
    public volatile C0082k1 f1316f;
    public C0082k1 g;
    public final ConcurrentHashMap h;

    /* renamed from: i, reason: collision with root package name */
    public com.google.android.gms.internal.measurement.X f1317i;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f1318j;

    /* renamed from: k, reason: collision with root package name */
    public volatile C0082k1 f1319k;

    /* renamed from: l, reason: collision with root package name */
    public C0082k1 f1320l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1321m;
    public final Object n;

    public C0091n1(C0113v0 c0113v0) {
        super(c0113v0);
        this.n = new Object();
        this.h = new ConcurrentHashMap();
    }

    @Override // J1.E
    public final boolean m() {
        return false;
    }

    public final void n(String str, C0082k1 c0082k1, boolean z4) {
        C0082k1 c0082k12;
        C0082k1 c0082k13 = this.f1315e == null ? this.f1316f : this.f1315e;
        if (c0082k1.f1283b == null) {
            c0082k12 = new C0082k1(c0082k1.f1282a, str != null ? r(str) : null, c0082k1.f1284c, c0082k1.f1286e, c0082k1.f1287f);
        } else {
            c0082k12 = c0082k1;
        }
        this.f1316f = this.f1315e;
        this.f1315e = c0082k12;
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        c0113v0.f1421p.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C0104s0 c0104s0 = c0113v0.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.t(new RunnableC0085l1(this, c0082k12, c0082k13, jElapsedRealtime, z4));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(J1.C0082k1 r18, J1.C0082k1 r19, long r20, boolean r22, android.os.Bundle r23) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0091n1.o(J1.k1, J1.k1, long, boolean, android.os.Bundle):void");
    }

    public final void p(C0082k1 c0082k1, boolean z4, long j5) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        A a2 = c0113v0.f1424s;
        C0113v0.h(a2);
        c0113v0.f1421p.getClass();
        a2.m(SystemClock.elapsedRealtime());
        boolean z5 = c0082k1 != null && c0082k1.f1285d;
        G1 g12 = c0113v0.f1419m;
        C0113v0.j(g12);
        if (!g12.h.a(j5, z5, z4) || c0082k1 == null) {
            return;
        }
        c0082k1.f1285d = false;
    }

    public final C0082k1 q(boolean z4) {
        k();
        j();
        if (!z4) {
            return this.g;
        }
        C0082k1 c0082k1 = this.g;
        return c0082k1 != null ? c0082k1 : this.f1320l;
    }

    public final String r(String str) {
        if (str == null) {
            return "Activity";
        }
        String[] strArrSplit = str.split("\\.");
        int length = strArrSplit.length;
        String str2 = length > 0 ? strArrSplit[length - 1] : "";
        int length2 = str2.length();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        c0113v0.f1415i.getClass();
        if (length2 <= 500) {
            return str2;
        }
        c0113v0.f1415i.getClass();
        return str2.substring(0, 500);
    }

    public final void s(com.google.android.gms.internal.measurement.X x4, Bundle bundle) {
        Bundle bundle2;
        if (!((C0113v0) this.f84c).f1415i.x() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.h.put(Integer.valueOf(x4.f4797j), new C0082k1(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final C0082k1 t(com.google.android.gms.internal.measurement.X x4) {
        q1.E.i(x4);
        Integer numValueOf = Integer.valueOf(x4.f4797j);
        ConcurrentHashMap concurrentHashMap = this.h;
        C0082k1 c0082k1 = (C0082k1) concurrentHashMap.get(numValueOf);
        if (c0082k1 == null) {
            String strR = r(x4.f4798k);
            a2 a2Var = ((C0113v0) this.f84c).n;
            C0113v0.i(a2Var);
            C0082k1 c0082k12 = new C0082k1(null, strR, a2Var.u0());
            concurrentHashMap.put(numValueOf, c0082k12);
            c0082k1 = c0082k12;
        }
        return this.f1319k != null ? this.f1319k : c0082k1;
    }
}
