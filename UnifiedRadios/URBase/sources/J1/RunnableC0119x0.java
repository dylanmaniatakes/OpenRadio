package J1;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import g0.AbstractC0535a;
import java.util.ArrayList;

/* renamed from: J1.x0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0119x0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1447j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ E0 f1448k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ b2 f1449l;

    public /* synthetic */ RunnableC0119x0(E0 e02, b2 b2Var, int i5) {
        this.f1447j = i5;
        this.f1448k = e02;
        this.f1449l = b2Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f1447j) {
            case 0:
                V1 v12 = this.f1448k.f728c;
                v12.j();
                v12.P(this.f1449l);
                break;
            case 1:
                V1 v13 = this.f1448k.f728c;
                v13.j();
                v13.O(this.f1449l);
                break;
            case 2:
                E0 e02 = this.f1448k;
                e02.f728c.j();
                e02.f728c.L(this.f1449l);
                break;
            case 3:
                E0 e03 = this.f1448k;
                e03.f728c.j();
                V1 v14 = e03.f728c;
                AbstractC0535a.q(v14);
                b2 b2Var = this.f1449l;
                q1.E.i(b2Var);
                String str = b2Var.f1138j;
                q1.E.f(str);
                int i5 = 0;
                if (v14.d0().w(null, H.f857y0)) {
                    v14.f().getClass();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int iP = v14.d0().p(null, H.f815h0);
                    v14.d0();
                    long jLongValue = jCurrentTimeMillis - ((Long) H.f807e.a(null)).longValue();
                    while (i5 < iP && v14.E(jLongValue, null)) {
                        i5++;
                    }
                } else {
                    v14.d0();
                    long jIntValue = ((Integer) H.f825l.a(null)).intValue();
                    while (i5 < jIntValue && v14.E(0L, str)) {
                        i5++;
                    }
                }
                if (v14.d0().w(null, H.z0)) {
                    v14.e().j();
                    v14.C();
                }
                if (v14.d0().w(null, H.f778Q0)) {
                    int iE = AbstractC0535a.e(b2Var.f1137P);
                    S1 s12 = v14.f1024l;
                    s12.j();
                    if (((C0113v0) s12.f84c).f1415i.w(null, H.f776P0) && iE == 2 && !S1.m(str)) {
                        C0093o0 c0093o0 = s12.f902d.f1017c;
                        V1.J(c0093o0);
                        com.google.android.gms.internal.measurement.H0 h0Y = c0093o0.y(str);
                        if (h0Y != null && h0Y.I() && !h0Y.w().s().isEmpty()) {
                            v14.c().f1084p.b(str, "[sgtm] Going background, trigger client side upload. appId");
                            v14.f().getClass();
                            v14.V(System.currentTimeMillis(), str);
                            break;
                        }
                    }
                }
                break;
            case 4:
                E0 e04 = this.f1448k;
                e04.f728c.j();
                V1 v15 = e04.f728c;
                AbstractC0535a.q(v15);
                b2 b2Var2 = this.f1449l;
                q1.E.f(b2Var2.f1138j);
                v15.c0(b2Var2);
                break;
            case 5:
                E0 e05 = this.f1448k;
                e05.f728c.j();
                V1 v16 = e05.f728c;
                if (v16.f1006A != null) {
                    ArrayList arrayList = new ArrayList();
                    v16.f1007B = arrayList;
                    arrayList.addAll(v16.f1006A);
                }
                C0089n c0089n = v16.f1019e;
                V1.J(c0089n);
                C0113v0 c0113v0 = (C0113v0) c0089n.f84c;
                b2 b2Var3 = this.f1449l;
                String str2 = b2Var3.f1138j;
                q1.E.i(str2);
                q1.E.f(str2);
                c0089n.j();
                c0089n.k();
                try {
                    SQLiteDatabase sQLiteDatabaseF0 = c0089n.f0();
                    String[] strArr = {str2};
                    int iDelete = sQLiteDatabaseF0.delete("apps", "app_id=?", strArr) + sQLiteDatabaseF0.delete("events", "app_id=?", strArr) + sQLiteDatabaseF0.delete("events_snapshot", "app_id=?", strArr) + sQLiteDatabaseF0.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseF0.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseF0.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseF0.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseF0.delete("queue", "app_id=?", strArr) + sQLiteDatabaseF0.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseF0.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseF0.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseF0.delete("trigger_uris", "app_id=?", strArr) + sQLiteDatabaseF0.delete("upload_queue", "app_id=?", strArr);
                    if (iDelete > 0) {
                        Z z4 = c0113v0.f1417k;
                        C0113v0.k(z4);
                        z4.f1084p.c(str2, Integer.valueOf(iDelete), "Reset analytics data. app, records");
                    }
                } catch (SQLiteException e5) {
                    Z z5 = c0113v0.f1417k;
                    C0113v0.k(z5);
                    z5.h.c(Z.q(str2), e5, "Error resetting analytics data. appId, error");
                }
                if (b2Var3.f1144q) {
                    v16.L(b2Var3);
                    break;
                }
                break;
            default:
                E0 e06 = this.f1448k;
                e06.f728c.j();
                V1 v17 = e06.f728c;
                AbstractC0535a.q(v17);
                b2 b2Var4 = this.f1449l;
                q1.E.f(b2Var4.f1138j);
                v17.P(b2Var4);
                v17.O(b2Var4);
                break;
        }
    }
}
