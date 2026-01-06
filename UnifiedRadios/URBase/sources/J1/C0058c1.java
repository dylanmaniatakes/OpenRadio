package J1;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.M3;
import com.google.android.gms.location.DeviceOrientationRequest;
import h0.C0556d;
import i3.C0573b;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import u1.C0906a;
import z2.InterfaceFutureC1000b;
import z2.RunnableC0999a;

/* renamed from: J1.c1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0058c1 extends E {

    /* renamed from: e, reason: collision with root package name */
    public C0055b1 f1163e;

    /* renamed from: f, reason: collision with root package name */
    public L0.e f1164f;
    public final CopyOnWriteArraySet g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicReference f1165i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f1166j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1167k;

    /* renamed from: l, reason: collision with root package name */
    public int f1168l;

    /* renamed from: m, reason: collision with root package name */
    public U0 f1169m;
    public U0 n;

    /* renamed from: o, reason: collision with root package name */
    public PriorityQueue f1170o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1171p;

    /* renamed from: q, reason: collision with root package name */
    public K0 f1172q;

    /* renamed from: r, reason: collision with root package name */
    public final AtomicLong f1173r;

    /* renamed from: s, reason: collision with root package name */
    public long f1174s;

    /* renamed from: t, reason: collision with root package name */
    public final C0107t0 f1175t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1176u;

    /* renamed from: v, reason: collision with root package name */
    public U0 f1177v;

    /* renamed from: w, reason: collision with root package name */
    public T0 f1178w;

    /* renamed from: x, reason: collision with root package name */
    public U0 f1179x;

    /* renamed from: y, reason: collision with root package name */
    public final L0.l f1180y;

    public C0058c1(C0113v0 c0113v0) {
        super(c0113v0);
        this.g = new CopyOnWriteArraySet();
        this.f1166j = new Object();
        this.f1167k = false;
        this.f1168l = 1;
        this.f1176u = true;
        this.f1180y = new L0.l(10, this);
        this.f1165i = new AtomicReference();
        this.f1172q = K0.f878c;
        this.f1174s = -1L;
        this.f1173r = new AtomicLong(0L);
        this.f1175t = new C0107t0(c0113v0);
    }

    public static void n(C0058c1 c0058c1, K0 k02, long j5, boolean z4, boolean z5) {
        c0058c1.j();
        c0058c1.k();
        C0113v0 c0113v0 = (C0113v0) c0058c1.f84c;
        C0072h0 c0072h0 = c0113v0.f1416j;
        C0113v0.i(c0072h0);
        K0 k0R = c0072h0.r();
        long j6 = c0058c1.f1174s;
        int i5 = k02.f880b;
        Z z6 = c0113v0.f1417k;
        if (j5 <= j6 && K0.l(k0R.f880b, i5)) {
            C0113v0.k(z6);
            z6.n.b(k02, "Dropped out-of-date consent setting, proposed settings");
            return;
        }
        C0072h0 c0072h02 = c0113v0.f1416j;
        C0113v0.i(c0072h02);
        c0072h02.j();
        if (!K0.l(i5, c0072h02.p().getInt("consent_source", 100))) {
            C0113v0.k(z6);
            z6.n.b(Integer.valueOf(i5), "Lower precedence consent source ignored, proposed source");
            return;
        }
        SharedPreferences.Editor editorEdit = c0072h02.p().edit();
        editorEdit.putString("consent_settings", k02.j());
        editorEdit.putInt("consent_source", i5);
        editorEdit.apply();
        C0113v0.k(z6);
        z6.f1084p.b(k02, "Setting storage consent(FE)");
        c0058c1.f1174s = j5;
        if (c0113v0.r().v()) {
            C0120x1 c0120x1R = c0113v0.r();
            c0120x1R.j();
            c0120x1R.k();
            c0120x1R.A(new RunnableC0094o1(c0120x1R, 0));
        } else {
            C0120x1 c0120x1R2 = c0113v0.r();
            c0120x1R2.j();
            c0120x1R2.k();
            if (c0120x1R2.u()) {
                c0120x1R2.A(new RunnableC0108t1(c0120x1R2, c0120x1R2.x(false), 4));
            }
        }
        if (z5) {
            c0113v0.r().p(new AtomicReference());
        }
    }

    public final void A(C0095p c0095p, boolean z4) {
        RunnableC0999a runnableC0999a = new RunnableC0999a(14, this, c0095p, false);
        if (z4) {
            j();
            runnableC0999a.run();
        } else {
            C0104s0 c0104s0 = ((C0113v0) this.f84c).f1418l;
            C0113v0.k(c0104s0);
            c0104s0.t(runnableC0999a);
        }
    }

    public final void B(K0 k02) {
        j();
        boolean z4 = (k02.k(J0.ANALYTICS_STORAGE) && k02.k(J0.AD_STORAGE)) || ((C0113v0) this.f84c).r().u();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        C0104s0 c0104s0 = c0113v0.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        if (z4 != c0113v0.f1407E) {
            C0104s0 c0104s02 = c0113v0.f1418l;
            C0113v0.k(c0104s02);
            c0104s02.j();
            c0113v0.f1407E = z4;
            C0072h0 c0072h0 = ((C0113v0) this.f84c).f1416j;
            C0113v0.i(c0072h0);
            c0072h0.j();
            Boolean boolValueOf = c0072h0.p().contains("measurement_enabled_from_api") ? Boolean.valueOf(c0072h0.p().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z4 || boolValueOf == null || boolValueOf.booleanValue()) {
                F(Boolean.valueOf(z4), false);
            }
        }
    }

    public final void C(K0 k02, boolean z4) {
        boolean z5;
        K0 k03;
        boolean z6;
        boolean z7;
        k();
        int i5 = k02.f880b;
        if (i5 != -10) {
            H0 h02 = (H0) k02.f879a.get(J0.AD_STORAGE);
            if (h02 == null) {
                h02 = H0.UNINITIALIZED;
            }
            H0 h03 = H0.UNINITIALIZED;
            if (h02 == h03) {
                H0 h04 = (H0) k02.f879a.get(J0.ANALYTICS_STORAGE);
                if (h04 == null) {
                    h04 = h03;
                }
                if (h04 == h03) {
                    Z z8 = ((C0113v0) this.f84c).f1417k;
                    C0113v0.k(z8);
                    z8.f1082m.a("Ignoring empty consent settings");
                    return;
                }
            }
        }
        synchronized (this.f1166j) {
            try {
                z5 = false;
                if (K0.l(i5, this.f1172q.f880b)) {
                    K0 k04 = this.f1172q;
                    EnumMap enumMap = k02.f879a;
                    J0[] j0Arr = (J0[]) enumMap.keySet().toArray(new J0[0]);
                    int length = j0Arr.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            z6 = false;
                            break;
                        }
                        J0 j02 = j0Arr[i6];
                        H0 h05 = (H0) enumMap.get(j02);
                        H0 h06 = (H0) k04.f879a.get(j02);
                        H0 h07 = H0.DENIED;
                        if (h05 == h07 && h06 != h07) {
                            z6 = true;
                            break;
                        }
                        i6++;
                    }
                    J0 j03 = J0.ANALYTICS_STORAGE;
                    if (k02.k(j03) && !this.f1172q.k(j03)) {
                        z5 = true;
                    }
                    K0 k0G = k02.g(this.f1172q);
                    this.f1172q = k0G;
                    k03 = k0G;
                    z7 = z5;
                    z5 = true;
                } else {
                    k03 = k02;
                    z6 = false;
                    z7 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z5) {
            Z z9 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z9);
            z9.n.b(k03, "Ignoring lower-priority consent settings, proposed settings");
            return;
        }
        long andIncrement = this.f1173r.getAndIncrement();
        if (z6) {
            this.f1165i.set(null);
            RunnableC0052a1 runnableC0052a1 = new RunnableC0052a1(this, k03, andIncrement, z7, 0);
            if (z4) {
                j();
                runnableC0052a1.run();
                return;
            } else {
                C0104s0 c0104s0 = ((C0113v0) this.f84c).f1418l;
                C0113v0.k(c0104s0);
                c0104s0.u(runnableC0052a1);
                return;
            }
        }
        RunnableC0052a1 runnableC0052a12 = new RunnableC0052a1(this, k03, andIncrement, z7, 1);
        if (z4) {
            j();
            runnableC0052a12.run();
        } else if (i5 == 30 || i5 == -10) {
            C0104s0 c0104s02 = ((C0113v0) this.f84c).f1418l;
            C0113v0.k(c0104s02);
            c0104s02.u(runnableC0052a12);
        } else {
            C0104s0 c0104s03 = ((C0113v0) this.f84c).f1418l;
            C0113v0.k(c0104s03);
            c0104s03.t(runnableC0052a12);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D(java.lang.String r13, java.lang.String r14, java.lang.Object r15, boolean r16, long r17) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0058c1.D(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(long r20, java.lang.Object r22, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0058c1.E(long, java.lang.Object, java.lang.String, java.lang.String):void");
    }

    public final void F(Boolean bool, boolean z4) {
        j();
        k();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        Z z5 = c0113v0.f1417k;
        C0113v0.k(z5);
        z5.f1083o.b(bool, "Setting app measurement enabled (FE)");
        C0072h0 c0072h0 = c0113v0.f1416j;
        C0113v0.i(c0072h0);
        c0072h0.j();
        SharedPreferences.Editor editorEdit = c0072h0.p().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
        if (z4) {
            c0072h0.j();
            SharedPreferences.Editor editorEdit2 = c0072h0.p().edit();
            if (bool != null) {
                editorEdit2.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                editorEdit2.remove("measurement_enabled_from_api");
            }
            editorEdit2.apply();
        }
        C0104s0 c0104s0 = c0113v0.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
        if (c0113v0.f1407E || !(bool == null || bool.booleanValue())) {
            G();
        }
    }

    public final void G() {
        j();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        C0072h0 c0072h0 = c0113v0.f1416j;
        C0113v0.i(c0072h0);
        String strG = c0072h0.f1242p.g();
        if (strG != null) {
            boolean zEquals = "unset".equals(strG);
            C0906a c0906a = c0113v0.f1421p;
            if (zEquals) {
                c0906a.getClass();
                E(System.currentTimeMillis(), null, "app", "_npa");
            } else {
                Long lValueOf = Long.valueOf(true != "true".equals(strG) ? 0L : 1L);
                c0906a.getClass();
                E(System.currentTimeMillis(), lValueOf, "app", "_npa");
            }
        }
        boolean zB = c0113v0.b();
        Z z4 = c0113v0.f1417k;
        if (!zB || !this.f1176u) {
            C0113v0.k(z4);
            z4.f1083o.a("Updating Scion state (FE)");
            C0120x1 c0120x1R = c0113v0.r();
            c0120x1R.j();
            c0120x1R.k();
            c0120x1R.A(new RunnableC0108t1(c0120x1R, c0120x1R.x(true), 3));
            return;
        }
        C0113v0.k(z4);
        z4.f1083o.a("Recording app launch after enabling measurement for the first time (FE)");
        o();
        G1 g12 = c0113v0.f1419m;
        C0113v0.j(g12);
        g12.g.A();
        C0104s0 c0104s0 = c0113v0.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.t(new S0(this, 2));
    }

    public final PriorityQueue H() {
        if (this.f1170o == null) {
            this.f1170o = new PriorityQueue(Comparator.comparing(new N0(), new B0.a(1)));
        }
        return this.f1170o;
    }

    @Override // J1.E
    public final boolean m() {
        return false;
    }

    public final void o() {
        j();
        k();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (c0113v0.g()) {
            C0068g c0068g = c0113v0.f1415i;
            ((C0113v0) c0068g.f84c).getClass();
            Boolean boolU = c0068g.u("google_analytics_deferred_deep_link_enabled");
            if (boolU != null && boolU.booleanValue()) {
                Z z4 = c0113v0.f1417k;
                C0113v0.k(z4);
                z4.f1083o.a("Deferred Deep Link feature enabled.");
                C0104s0 c0104s0 = c0113v0.f1418l;
                C0113v0.k(c0104s0);
                c0104s0.t(new S0(this, 0));
            }
            C0120x1 c0120x1R = c0113v0.r();
            c0120x1R.j();
            c0120x1R.k();
            b2 b2VarX = c0120x1R.x(true);
            c0120x1R.B();
            C0113v0 c0113v02 = (C0113v0) c0120x1R.f84c;
            c0113v02.f1415i.w(null, H.f827l1);
            c0113v02.o().q(3, new byte[0]);
            c0120x1R.A(new RunnableC0108t1(c0120x1R, b2VarX, 1));
            this.f1176u = false;
            C0072h0 c0072h0 = c0113v0.f1416j;
            C0113v0.i(c0072h0);
            c0072h0.j();
            String string = c0072h0.p().getString("previous_os_version", null);
            ((C0113v0) c0072h0.f84c).m().l();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor editorEdit = c0072h0.p().edit();
                editorEdit.putString("previous_os_version", str);
                editorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            c0113v0.m().l();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            u("auto", "_ou", bundle);
        }
    }

    public final void p(String str, String str2, Bundle bundle) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        c0113v0.f1421p.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        q1.E.f(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        C0104s0 c0104s0 = c0113v0.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.t(new Q0(this, bundle2, 2));
    }

    public final void q() {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (!(c0113v0.f1411c.getApplicationContext() instanceof Application) || this.f1163e == null) {
            return;
        }
        ((Application) c0113v0.f1411c.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f1163e);
    }

    public final void r() {
        M3.b();
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (c0113v0.f1415i.w(null, H.f789W0)) {
            C0104s0 c0104s0 = c0113v0.f1418l;
            C0113v0.k(c0104s0);
            boolean zV = c0104s0.v();
            Z z4 = c0113v0.f1417k;
            if (zV) {
                C0113v0.k(z4);
                z4.h.a("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (O2.e.e()) {
                C0113v0.k(z4);
                z4.h.a("Cannot get trigger URIs from main thread");
                return;
            }
            k();
            C0113v0.k(z4);
            z4.f1084p.a("Getting trigger URIs (FE)");
            AtomicReference atomicReference = new AtomicReference();
            C0113v0.k(c0104s0);
            c0104s0.o(atomicReference, DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM, "get trigger URIs", new O0(this, atomicReference, 0));
            List list = (List) atomicReference.get();
            if (list == null) {
                C0113v0.k(z4);
                z4.h.a("Timed out waiting for get trigger URIs");
            } else {
                C0113v0.k(c0104s0);
                c0104s0.t(new RunnableC0999a(this, 11, list));
            }
        }
    }

    public final void s() {
        Object obj;
        String str;
        H1 h12;
        C0113v0 c0113v0;
        H1 h13;
        int i5;
        C0058c1 c0058c1;
        y2.o oVar;
        com.google.android.gms.internal.measurement.M1 m12;
        Object obj2;
        boolean z4;
        Object obj3;
        j();
        C0113v0 c0113v02 = (C0113v0) this.f84c;
        Z z5 = c0113v02.f1417k;
        C0113v0.k(z5);
        z5.f1083o.a("Handle tcf update.");
        C0072h0 c0072h0 = c0113v02.f1416j;
        C0113v0.i(c0072h0);
        SharedPreferences sharedPreferencesN = c0072h0.n();
        HashMap map = new HashMap();
        G g = H.f822j1;
        if (((Boolean) g.a(null)).booleanValue()) {
            y2.h hVar = J1.f877a;
            com.google.android.gms.internal.measurement.L1 l12 = com.google.android.gms.internal.measurement.L1.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
            I1 i12 = I1.f869j;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(l12, i12);
            com.google.android.gms.internal.measurement.L1 l13 = com.google.android.gms.internal.measurement.L1.IAB_TCF_PURPOSE_SELECT_BASIC_ADS;
            I1 i13 = I1.f870k;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry2 = new AbstractMap.SimpleImmutableEntry(l13, i13);
            com.google.android.gms.internal.measurement.L1 l14 = com.google.android.gms.internal.measurement.L1.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry3 = new AbstractMap.SimpleImmutableEntry(l14, i12);
            com.google.android.gms.internal.measurement.L1 l15 = com.google.android.gms.internal.measurement.L1.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry4 = new AbstractMap.SimpleImmutableEntry(l15, i12);
            com.google.android.gms.internal.measurement.L1 l16 = com.google.android.gms.internal.measurement.L1.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
            List listAsList = Arrays.asList(simpleImmutableEntry, simpleImmutableEntry2, simpleImmutableEntry3, simpleImmutableEntry4, new AbstractMap.SimpleImmutableEntry(l16, i13), new AbstractMap.SimpleImmutableEntry(com.google.android.gms.internal.measurement.L1.IAB_TCF_PURPOSE_APPLY_MARKET_RESEARCH_TO_GENERATE_AUDIENCE_INSIGHTS, i13), new AbstractMap.SimpleImmutableEntry(com.google.android.gms.internal.measurement.L1.IAB_TCF_PURPOSE_DEVELOP_AND_IMPROVE_PRODUCTS, i13));
            C0573b c0573b = new C0573b(listAsList instanceof Collection ? listAsList.size() : 4);
            c0573b.k(listAsList);
            y2.m mVarD = c0573b.d();
            int i6 = y2.f.f10497l;
            y2.o oVar2 = new y2.o("CH");
            char[] cArr = new char[5];
            int iA = J1.a(sharedPreferencesN, "IABTCF_CmpSdkID");
            int iA2 = J1.a(sharedPreferencesN, "IABTCF_PolicyVersion");
            int iA3 = J1.a(sharedPreferencesN, "IABTCF_gdprApplies");
            int iA4 = J1.a(sharedPreferencesN, "IABTCF_PurposeOneTreatment");
            int iA5 = J1.a(sharedPreferencesN, "IABTCF_EnableAdvertiserConsentMode");
            String strB = J1.b(sharedPreferencesN, "IABTCF_PublisherCC");
            C0573b c0573b2 = new C0573b(4);
            y2.k kVar = mVarD.f10512k;
            if (kVar == null) {
                oVar = oVar2;
                y2.k kVar2 = new y2.k(mVarD, new y2.l(mVarD.n, 0, mVarD.f10515o));
                mVarD.f10512k = kVar2;
                kVar = kVar2;
            } else {
                oVar = oVar2;
            }
            D1.S sJ = kVar.iterator();
            while (true) {
                boolean zHasNext = sJ.hasNext();
                m12 = com.google.android.gms.internal.measurement.M1.PURPOSE_RESTRICTION_UNDEFINED;
                if (!zHasNext) {
                    break;
                }
                com.google.android.gms.internal.measurement.L1 l17 = (com.google.android.gms.internal.measurement.L1) sJ.next();
                D1.S s4 = sJ;
                y2.m mVar = mVarD;
                String strB2 = J1.b(sharedPreferencesN, "IABTCF_PublisherRestrictions" + l17.a());
                if (!TextUtils.isEmpty(strB2) && strB2.length() >= 755) {
                    int iDigit = Character.digit(strB2.charAt(754), 10);
                    com.google.android.gms.internal.measurement.M1 m13 = com.google.android.gms.internal.measurement.M1.PURPOSE_RESTRICTION_NOT_ALLOWED;
                    if (iDigit < 0 || iDigit > com.google.android.gms.internal.measurement.M1.values().length || iDigit == 0) {
                        m12 = m13;
                    } else if (iDigit == 1) {
                        m12 = com.google.android.gms.internal.measurement.M1.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                    } else if (iDigit == 2) {
                        m12 = com.google.android.gms.internal.measurement.M1.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST;
                    }
                }
                c0573b2.j(l17, m12);
                sJ = s4;
                mVarD = mVar;
            }
            y2.m mVar2 = mVarD;
            y2.m mVarD2 = c0573b2.d();
            String strB3 = J1.b(sharedPreferencesN, "IABTCF_PurposeConsents");
            String strB4 = J1.b(sharedPreferencesN, "IABTCF_VendorConsents");
            boolean z6 = !TextUtils.isEmpty(strB4) && strB4.length() >= 755 && strB4.charAt(754) == '1';
            String strB5 = J1.b(sharedPreferencesN, "IABTCF_PurposeLegitimateInterests");
            String strB6 = J1.b(sharedPreferencesN, "IABTCF_VendorLegitimateInterests");
            boolean z7 = !TextUtils.isEmpty(strB6) && strB6.length() >= 755 && strB6.charAt(754) == '1';
            cArr[0] = '2';
            com.google.android.gms.internal.measurement.M1 m14 = (com.google.android.gms.internal.measurement.M1) mVarD2.get(l12);
            com.google.android.gms.internal.measurement.M1 m15 = (com.google.android.gms.internal.measurement.M1) mVarD2.get(l14);
            com.google.android.gms.internal.measurement.M1 m16 = (com.google.android.gms.internal.measurement.M1) mVarD2.get(l15);
            com.google.android.gms.internal.measurement.M1 m17 = (com.google.android.gms.internal.measurement.M1) mVarD2.get(l16);
            C0573b c0573b3 = new C0573b(4);
            c0573b3.j("Version", "2");
            if (true != z6) {
                obj = "Version";
                obj2 = "0";
            } else {
                obj = "Version";
                obj2 = "1";
            }
            c0573b3.j("VendorConsent", obj2);
            if (true != z7) {
                z4 = z7;
                obj3 = "0";
            } else {
                z4 = z7;
                obj3 = "1";
            }
            c0573b3.j("VendorLegitimateInterest", obj3);
            c0573b3.j("gdprApplies", iA3 != 1 ? "0" : "1");
            c0573b3.j("EnableAdvertiserConsentMode", iA5 != 1 ? "0" : "1");
            c0573b3.j("PolicyVersion", String.valueOf(iA2));
            c0573b3.j("CmpSdkID", String.valueOf(iA));
            c0573b3.j("PurposeOneTreatment", iA4 != 1 ? "0" : "1");
            c0573b3.j("PublisherCC", strB);
            c0573b3.j("PublisherRestrictions1", String.valueOf(m14 != null ? m14.a() : m12.a()));
            c0573b3.j("PublisherRestrictions3", String.valueOf(m15 != null ? m15.a() : m12.a()));
            c0573b3.j("PublisherRestrictions4", String.valueOf(m16 != null ? m16.a() : m12.a()));
            c0573b3.j("PublisherRestrictions7", String.valueOf(m17 != null ? m17.a() : m12.a()));
            String strF = J1.f(l12, strB3, strB5);
            String strF2 = J1.f(l14, strB3, strB5);
            String strF3 = J1.f(l15, strB3, strB5);
            String strF4 = J1.f(l16, strB3, strB5);
            android.support.v4.media.session.b.c("Purpose1", strF);
            boolean z8 = z6;
            android.support.v4.media.session.b.c("Purpose3", strF2);
            android.support.v4.media.session.b.c("Purpose4", strF3);
            android.support.v4.media.session.b.c("Purpose7", strF4);
            c0573b3.k(y2.m.a(4, new Object[]{"Purpose1", strF, "Purpose3", strF2, "Purpose4", strF3, "Purpose7", strF4}, null).entrySet());
            c0573b3.k(y2.m.a(5, new Object[]{"AuthorizePurpose1", true != J1.c(l12, mVar2, mVarD2, oVar, cArr, iA, iA5, iA3, iA2, iA4, strB, strB3, strB5, z8, z4) ? "0" : "1", "AuthorizePurpose3", true != J1.c(l14, mVar2, mVarD2, oVar, cArr, iA, iA5, iA3, iA2, iA4, strB, strB3, strB5, z8, z4) ? "0" : "1", "AuthorizePurpose4", true != J1.c(l15, mVar2, mVarD2, oVar, cArr, iA, iA5, iA3, iA2, iA4, strB, strB3, strB5, z8, z4) ? "0" : "1", "AuthorizePurpose7", true != J1.c(l16, mVar2, mVarD2, oVar, cArr, iA, iA5, iA3, iA2, iA4, strB, strB3, strB5, z8, z4) ? "0" : "1", "PurposeDiagnostics", new String(cArr)}, null).entrySet());
            h12 = new H1(c0573b3.d());
            c0113v0 = c0113v02;
            str = "";
        } else {
            obj = "Version";
            String strB7 = J1.b(sharedPreferencesN, "IABTCF_VendorConsents");
            str = "";
            if (!str.equals(strB7) && strB7.length() > 754) {
                map.put("GoogleConsent", String.valueOf(strB7.charAt(754)));
            }
            int iA6 = J1.a(sharedPreferencesN, "IABTCF_gdprApplies");
            if (iA6 != -1) {
                map.put("gdprApplies", String.valueOf(iA6));
            }
            int iA7 = J1.a(sharedPreferencesN, "IABTCF_EnableAdvertiserConsentMode");
            if (iA7 != -1) {
                map.put("EnableAdvertiserConsentMode", String.valueOf(iA7));
            }
            int iA8 = J1.a(sharedPreferencesN, "IABTCF_PolicyVersion");
            if (iA8 != -1) {
                map.put("PolicyVersion", String.valueOf(iA8));
            }
            String strB8 = J1.b(sharedPreferencesN, "IABTCF_PurposeConsents");
            if (!str.equals(strB8)) {
                map.put("PurposeConsents", strB8);
            }
            int iA9 = J1.a(sharedPreferencesN, "IABTCF_CmpSdkID");
            if (iA9 != -1) {
                map.put("CmpSdkID", String.valueOf(iA9));
            }
            h12 = new H1(map);
            c0113v0 = c0113v02;
        }
        Z z9 = c0113v0.f1417k;
        C0113v0.k(z9);
        X x4 = z9.f1084p;
        x4.b(h12, "Tcf preferences read");
        boolean zW = c0113v0.f1415i.w(null, g);
        C0906a c0906a = c0113v0.f1421p;
        if (!zW) {
            if (c0072h0.u(h12)) {
                Bundle bundleA = h12.a();
                C0113v0.k(z9);
                x4.b(bundleA, "Consent generated from Tcf");
                if (bundleA != Bundle.EMPTY) {
                    c0906a.getClass();
                    z(bundleA, -30, System.currentTimeMillis());
                }
                Bundle bundle = new Bundle();
                bundle.putString("_tcfd", h12.b());
                u("auto", "_tcf", bundle);
                return;
            }
            return;
        }
        c0072h0.j();
        String string = c0072h0.p().getString("stored_tcf_param", str);
        HashMap map2 = new HashMap();
        if (TextUtils.isEmpty(string)) {
            h13 = new H1(map2);
        } else {
            String[] strArrSplit = string.split(";");
            int length = strArrSplit.length;
            int i7 = 0;
            while (i7 < length) {
                String[] strArrSplit2 = strArrSplit[i7].split("=");
                if (strArrSplit2.length < 2) {
                    i5 = 1;
                } else if (J1.f877a.contains(strArrSplit2[0])) {
                    i5 = 1;
                    map2.put(strArrSplit2[0], strArrSplit2[1]);
                } else {
                    i5 = 1;
                }
                i7 += i5;
            }
            h13 = new H1(map2);
        }
        if (c0072h0.u(h12)) {
            Bundle bundleA2 = h12.a();
            C0113v0.k(z9);
            x4.b(bundleA2, "Consent generated from Tcf");
            if (bundleA2 != Bundle.EMPTY) {
                c0906a.getClass();
                c0058c1 = this;
                c0058c1.z(bundleA2, -30, System.currentTimeMillis());
            } else {
                c0058c1 = this;
            }
            Bundle bundle2 = new Bundle();
            HashMap map3 = h13.f864a;
            String str2 = (map3.isEmpty() || ((String) map3.get(obj)) != null) ? "0" : "1";
            Bundle bundleA3 = h12.a();
            Bundle bundleA4 = h13.a();
            bundle2.putString("_tcfm", str2.concat((bundleA3.size() == bundleA4.size() && Objects.equals(bundleA3.getString("ad_storage"), bundleA4.getString("ad_storage")) && Objects.equals(bundleA3.getString("ad_personalization"), bundleA4.getString("ad_personalization")) && Objects.equals(bundleA3.getString("ad_user_data"), bundleA4.getString("ad_user_data"))) ? "0" : "1"));
            String str3 = (String) h12.f864a.get("PurposeDiagnostics");
            if (TextUtils.isEmpty(str3)) {
                str3 = "200000";
            }
            bundle2.putString("_tcfd2", str3);
            bundle2.putString("_tcfd", h12.b());
            c0058c1.u("auto", "_tcf", bundle2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
    
        if (r4 > 500) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0093, code lost:
    
        if (r6 > 500) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(java.lang.String r21, java.lang.String r22, android.os.Bundle r23, boolean r24, boolean r25, long r26) {
        /*
            Method dump skipped, instructions count: 489
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0058c1.t(java.lang.String, java.lang.String, android.os.Bundle, boolean, boolean, long):void");
    }

    public final void u(String str, String str2, Bundle bundle) {
        j();
        ((C0113v0) this.f84c).f1421p.getClass();
        v(System.currentTimeMillis(), bundle, str, str2);
    }

    public final void v(long j5, Bundle bundle, String str, String str2) {
        j();
        w(str, str2, j5, bundle, true, this.f1164f == null || a2.e0(str2), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:225:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(java.lang.String r31, java.lang.String r32, long r33, android.os.Bundle r35, boolean r36, boolean r37, boolean r38) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C0058c1.w(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean):void");
    }

    public final void x() {
        K1 k1;
        j();
        this.f1171p = false;
        if (H().isEmpty() || this.f1167k || (k1 = (K1) H().poll()) == null) {
            return;
        }
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        a2 a2Var = c0113v0.n;
        C0113v0.i(a2Var);
        C0556d c0556dO = a2Var.o();
        if (c0556dO != null) {
            this.f1167k = true;
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            X x4 = z4.f1084p;
            String str = k1.f881j;
            x4.b(str, "Registering trigger URI");
            InterfaceFutureC1000b interfaceFutureC1000bE = c0556dO.e(Uri.parse(str));
            if (interfaceFutureC1000bE != null) {
                interfaceFutureC1000bE.a(new RunnableC0999a(interfaceFutureC1000bE, 0, new L0.s(6, this, k1, false)), new V0(0, this));
            } else {
                this.f1167k = false;
                H().add(k1);
            }
        }
    }

    public final void y(Bundle bundle, long j5) {
        q1.E.i(bundle);
        Bundle bundle2 = new Bundle(bundle);
        boolean zIsEmpty = TextUtils.isEmpty(bundle2.getString("app_id"));
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (!zIsEmpty) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.f1080k.a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        L0.a(bundle2, "app_id", String.class, null);
        L0.a(bundle2, "origin", String.class, null);
        L0.a(bundle2, "name", String.class, null);
        L0.a(bundle2, "value", Object.class, null);
        L0.a(bundle2, "trigger_event_name", String.class, null);
        L0.a(bundle2, "trigger_timeout", Long.class, 0L);
        L0.a(bundle2, "timed_out_event_name", String.class, null);
        L0.a(bundle2, "timed_out_event_params", Bundle.class, null);
        L0.a(bundle2, "triggered_event_name", String.class, null);
        L0.a(bundle2, "triggered_event_params", Bundle.class, null);
        L0.a(bundle2, "time_to_live", Long.class, 0L);
        L0.a(bundle2, "expired_event_name", String.class, null);
        L0.a(bundle2, "expired_event_params", Bundle.class, null);
        q1.E.f(bundle2.getString("name"));
        q1.E.f(bundle2.getString("origin"));
        q1.E.i(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j5);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        a2 a2Var = c0113v0.n;
        C0113v0.i(a2Var);
        int iQ0 = a2Var.q0(string);
        S s4 = c0113v0.f1420o;
        Z z5 = c0113v0.f1417k;
        if (iQ0 != 0) {
            C0113v0.k(z5);
            z5.h.b(s4.f(string), "Invalid conditional user property name");
            return;
        }
        a2 a2Var2 = c0113v0.n;
        C0113v0.i(a2Var2);
        if (a2Var2.m0(obj, string) != 0) {
            C0113v0.k(z5);
            z5.h.c(s4.f(string), obj, "Invalid conditional user property value");
            return;
        }
        Object objR = a2Var2.r(obj, string);
        if (objR == null) {
            C0113v0.k(z5);
            z5.h.c(s4.f(string), obj, "Unable to normalize conditional user property value");
            return;
        }
        L0.f(bundle2, objR);
        long j6 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name")) && (j6 > 15552000000L || j6 < 1)) {
            C0113v0.k(z5);
            z5.h.c(s4.f(string), Long.valueOf(j6), "Invalid conditional user property timeout");
            return;
        }
        long j7 = bundle2.getLong("time_to_live");
        if (j7 <= 15552000000L && j7 >= 1) {
            C0104s0 c0104s0 = c0113v0.f1418l;
            C0113v0.k(c0104s0);
            c0104s0.t(new Q0(this, bundle2, 1));
        } else {
            C0113v0.k(z5);
            z5.h.c(s4.f(string), Long.valueOf(j7), "Invalid conditional user property time to live");
        }
    }

    public final void z(Bundle bundle, int i5, long j5) {
        Object obj;
        H0 h02;
        String string;
        k();
        K0 k02 = K0.f878c;
        J0[] j0Arr = I0.STORAGE.f868j;
        int length = j0Arr.length;
        int i6 = 0;
        while (true) {
            obj = null;
            if (i6 >= length) {
                break;
            }
            String str = j0Arr[i6].f876j;
            if (bundle.containsKey(str) && (string = bundle.getString(str)) != null) {
                if (string.equals("granted")) {
                    obj = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    obj = Boolean.FALSE;
                }
                if (obj == null) {
                    obj = string;
                    break;
                }
            }
            i6++;
        }
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (obj != null) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.f1082m.b(obj, "Ignoring invalid consent setting");
            Z z5 = c0113v0.f1417k;
            C0113v0.k(z5);
            z5.f1082m.a("Valid consent values are 'granted', 'denied'");
        }
        C0104s0 c0104s0 = c0113v0.f1418l;
        C0113v0.k(c0104s0);
        boolean zV = c0104s0.v();
        K0 k0D = K0.d(i5, bundle);
        Iterator it = k0D.f879a.values().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            h02 = H0.UNINITIALIZED;
            if (!zHasNext) {
                break;
            } else if (((H0) it.next()) != h02) {
                C(k0D, zV);
                break;
            }
        }
        C0095p c0095pA = C0095p.a(i5, bundle);
        Iterator it2 = c0095pA.f1341e.values().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            } else if (((H0) it2.next()) != h02) {
                A(c0095pA, zV);
                break;
            }
        }
        Boolean boolD = C0095p.d(bundle);
        if (boolD != null) {
            String str2 = i5 == -30 ? "tcf" : "app";
            if (zV) {
                E(j5, boolD.toString(), str2, "allow_personalized_ads");
            } else {
                D(str2, "allow_personalized_ads", boolD.toString(), false, j5);
            }
        }
    }
}
