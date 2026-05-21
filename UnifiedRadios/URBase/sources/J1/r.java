package J1;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final String f1357a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1358b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1359c;

    /* renamed from: d, reason: collision with root package name */
    public final long f1360d;

    /* renamed from: e, reason: collision with root package name */
    public final long f1361e;

    /* renamed from: f, reason: collision with root package name */
    public final C0109u f1362f;

    public r(C0113v0 c0113v0, String str, String str2, String str3, long j5, long j6, Bundle bundle) {
        C0109u c0109u;
        q1.E.f(str2);
        q1.E.f(str3);
        this.f1357a = str2;
        this.f1358b = str3;
        this.f1359c = true == TextUtils.isEmpty(str) ? null : str;
        this.f1360d = j5;
        this.f1361e = j6;
        if (j6 != 0 && j6 > j5) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.f1080k.b(Z.q(str2), "Event created with reverse previous/current timestamps. appId");
        }
        if (bundle == null || bundle.isEmpty()) {
            c0109u = new C0109u(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    Z z5 = c0113v0.f1417k;
                    C0113v0.k(z5);
                    z5.h.a("Param name can't be null");
                    it.remove();
                } else {
                    a2 a2Var = c0113v0.n;
                    C0113v0.i(a2Var);
                    Object objQ = a2Var.q(bundle2.get(next), next);
                    if (objQ == null) {
                        Z z6 = c0113v0.f1417k;
                        C0113v0.k(z6);
                        z6.f1080k.b(c0113v0.f1420o.e(next), "Param value can't be null");
                        it.remove();
                    } else {
                        a2 a2Var2 = c0113v0.n;
                        C0113v0.i(a2Var2);
                        a2Var2.E(bundle2, next, objQ);
                    }
                }
            }
            c0109u = new C0109u(bundle2);
        }
        this.f1362f = c0109u;
    }

    public final r a(C0113v0 c0113v0, long j5) {
        return new r(c0113v0, this.f1359c, this.f1357a, this.f1358b, this.f1360d, j5, this.f1362f);
    }

    public final String toString() {
        return "Event{appId='" + this.f1357a + "', name='" + this.f1358b + "', params=" + this.f1362f.toString() + "}";
    }

    public r(C0113v0 c0113v0, String str, String str2, String str3, long j5, long j6, C0109u c0109u) {
        q1.E.f(str2);
        q1.E.f(str3);
        q1.E.i(c0109u);
        this.f1357a = str2;
        this.f1358b = str3;
        this.f1359c = true == TextUtils.isEmpty(str) ? null : str;
        this.f1360d = j5;
        this.f1361e = j6;
        if (j6 != 0 && j6 > j5) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.f1080k.c(Z.q(str2), Z.q(str3), "Event created with reverse previous/current timestamps. appId, name");
        }
        this.f1362f = c0109u;
    }
}
