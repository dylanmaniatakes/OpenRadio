package J1;

import D1.C0016n;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;

/* renamed from: J1.h0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0072h0 extends F0 {

    /* renamed from: C, reason: collision with root package name */
    public static final Pair f1231C = new Pair("", 0L);

    /* renamed from: A, reason: collision with root package name */
    public final C0069g0 f1232A;

    /* renamed from: B, reason: collision with root package name */
    public final X2.t f1233B;

    /* renamed from: e, reason: collision with root package name */
    public SharedPreferences f1234e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f1235f;
    public SharedPreferences g;
    public E0.d h;

    /* renamed from: i, reason: collision with root package name */
    public final C0069g0 f1236i;

    /* renamed from: j, reason: collision with root package name */
    public final C0016n f1237j;

    /* renamed from: k, reason: collision with root package name */
    public String f1238k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1239l;

    /* renamed from: m, reason: collision with root package name */
    public long f1240m;
    public final C0069g0 n;

    /* renamed from: o, reason: collision with root package name */
    public final C0066f0 f1241o;

    /* renamed from: p, reason: collision with root package name */
    public final C0016n f1242p;

    /* renamed from: q, reason: collision with root package name */
    public final X2.t f1243q;

    /* renamed from: r, reason: collision with root package name */
    public final C0066f0 f1244r;

    /* renamed from: s, reason: collision with root package name */
    public final C0069g0 f1245s;

    /* renamed from: t, reason: collision with root package name */
    public final C0069g0 f1246t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1247u;

    /* renamed from: v, reason: collision with root package name */
    public final C0066f0 f1248v;

    /* renamed from: w, reason: collision with root package name */
    public final C0066f0 f1249w;

    /* renamed from: x, reason: collision with root package name */
    public final C0069g0 f1250x;

    /* renamed from: y, reason: collision with root package name */
    public final C0016n f1251y;

    /* renamed from: z, reason: collision with root package name */
    public final C0016n f1252z;

    public C0072h0(C0113v0 c0113v0) {
        super(c0113v0);
        this.f1235f = new Object();
        this.n = new C0069g0(this, "session_timeout", 1800000L);
        this.f1241o = new C0066f0(this, "start_new_session", true);
        this.f1245s = new C0069g0(this, "last_pause_time", 0L);
        this.f1246t = new C0069g0(this, "session_id", 0L);
        this.f1242p = new C0016n(this, "non_personalized_ads");
        this.f1243q = new X2.t(this, "last_received_uri_timestamps_by_source");
        this.f1244r = new C0066f0(this, "allow_remote_dynamite", false);
        this.f1236i = new C0069g0(this, "first_open_time", 0L);
        q1.E.f("app_install_time");
        this.f1237j = new C0016n(this, "app_instance_id");
        this.f1248v = new C0066f0(this, "app_backgrounded", false);
        this.f1249w = new C0066f0(this, "deep_link_retrieval_complete", false);
        this.f1250x = new C0069g0(this, "deep_link_retrieval_attempts", 0L);
        this.f1251y = new C0016n(this, "firebase_feature_rollouts");
        this.f1252z = new C0016n(this, "deferred_attribution_cache");
        this.f1232A = new C0069g0(this, "deferred_attribution_cache_timestamp", 0L);
        this.f1233B = new X2.t(this, "default_event_parameters");
    }

    @Override // J1.F0
    public final boolean k() {
        return true;
    }

    public final SharedPreferences n() {
        j();
        l();
        if (this.g == null) {
            synchronized (this.f1235f) {
                try {
                    if (this.g == null) {
                        C0113v0 c0113v0 = (C0113v0) this.f84c;
                        String str = c0113v0.f1411c.getPackageName() + "_preferences";
                        Z z4 = c0113v0.f1417k;
                        C0113v0.k(z4);
                        z4.f1084p.b(str, "Default prefs file");
                        this.g = c0113v0.f1411c.getSharedPreferences(str, 0);
                    }
                } finally {
                }
            }
        }
        return this.g;
    }

    public final void o() {
        SharedPreferences sharedPreferences = ((C0113v0) this.f84c).f1411c.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f1234e = sharedPreferences;
        boolean z4 = sharedPreferences.getBoolean("has_been_opened", false);
        this.f1247u = z4;
        if (!z4) {
            SharedPreferences.Editor editorEdit = this.f1234e.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        this.h = new E0.d(this, Math.max(0L, ((Long) H.f804d.a(null)).longValue()));
    }

    public final SharedPreferences p() {
        j();
        l();
        q1.E.i(this.f1234e);
        return this.f1234e;
    }

    public final SparseArray q() {
        Bundle bundleQ = this.f1243q.q();
        int[] intArray = bundleQ.getIntArray("uriSources");
        long[] longArray = bundleQ.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray();
        }
        if (intArray.length != longArray.length) {
            Z z4 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z4);
            z4.h.a("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray();
        }
        SparseArray sparseArray = new SparseArray();
        for (int i5 = 0; i5 < intArray.length; i5++) {
            sparseArray.put(intArray[i5], Long.valueOf(longArray[i5]));
        }
        return sparseArray;
    }

    public final K0 r() {
        j();
        return K0.e(p().getInt("consent_source", 100), p().getString("consent_settings", "G1"));
    }

    public final void s(boolean z4) {
        j();
        Z z5 = ((C0113v0) this.f84c).f1417k;
        C0113v0.k(z5);
        z5.f1084p.b(Boolean.valueOf(z4), "App measurement setting deferred collection");
        SharedPreferences.Editor editorEdit = p().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z4);
        editorEdit.apply();
    }

    public final boolean t(long j5) {
        return j5 - this.n.a() > this.f1245s.a();
    }

    public final boolean u(H1 h12) {
        j();
        String string = p().getString("stored_tcf_param", "");
        String strC = h12.c();
        if (strC.equals(string)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = p().edit();
        editorEdit.putString("stored_tcf_param", strC);
        editorEdit.apply();
        return true;
    }
}
