package J1;

import android.os.Bundle;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class A extends B {

    /* renamed from: d, reason: collision with root package name */
    public final q.b f696d;

    /* renamed from: e, reason: collision with root package name */
    public final q.b f697e;

    /* renamed from: f, reason: collision with root package name */
    public long f698f;

    public A(C0113v0 c0113v0) {
        super(c0113v0);
        this.f697e = new q.b();
        this.f696d = new q.b();
    }

    public final void k(long j5, String str) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (str == null || str.length() == 0) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.h.a("Ad unit id must be a non-empty string");
        } else {
            C0104s0 c0104s0 = c0113v0.f1418l;
            C0113v0.k(c0104s0);
            c0104s0.t(new RunnableC0050a(this, str, j5, 0));
        }
    }

    public final void l(long j5, String str) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (str == null || str.length() == 0) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.h.a("Ad unit id must be a non-empty string");
        } else {
            C0104s0 c0104s0 = c0113v0.f1418l;
            C0113v0.k(c0104s0);
            c0104s0.t(new RunnableC0050a(this, str, j5, 1));
        }
    }

    public final void m(long j5) {
        C0091n1 c0091n1 = ((C0113v0) this.f84c).f1422q;
        C0113v0.j(c0091n1);
        C0082k1 c0082k1Q = c0091n1.q(false);
        q.b bVar = this.f696d;
        Iterator it = ((q.h) bVar.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            o(str, j5 - ((Long) bVar.getOrDefault(str, null)).longValue(), c0082k1Q);
        }
        if (!bVar.isEmpty()) {
            n(j5 - this.f698f, c0082k1Q);
        }
        p(j5);
    }

    public final void n(long j5, C0082k1 c0082k1) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (c0082k1 == null) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.f1084p.a("Not logging ad exposure. No active activity");
        } else {
            if (j5 < 1000) {
                Z z5 = c0113v0.f1417k;
                C0113v0.k(z5);
                z5.f1084p.b(Long.valueOf(j5), "Not logging ad exposure. Less than 1000 ms. exposure");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j5);
            a2.z(c0082k1, bundle, true);
            C0058c1 c0058c1 = c0113v0.f1423r;
            C0113v0.j(c0058c1);
            c0058c1.u("am", "_xa", bundle);
        }
    }

    public final void o(String str, long j5, C0082k1 c0082k1) {
        C0113v0 c0113v0 = (C0113v0) this.f84c;
        if (c0082k1 == null) {
            Z z4 = c0113v0.f1417k;
            C0113v0.k(z4);
            z4.f1084p.a("Not logging ad unit exposure. No active activity");
        } else {
            if (j5 < 1000) {
                Z z5 = c0113v0.f1417k;
                C0113v0.k(z5);
                z5.f1084p.b(Long.valueOf(j5), "Not logging ad unit exposure. Less than 1000 ms. exposure");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j5);
            a2.z(c0082k1, bundle, true);
            C0058c1 c0058c1 = c0113v0.f1423r;
            C0113v0.j(c0058c1);
            c0058c1.u("am", "_xu", bundle);
        }
    }

    public final void p(long j5) {
        q.b bVar = this.f696d;
        Iterator it = ((q.h) bVar.keySet()).iterator();
        while (it.hasNext()) {
            bVar.put((String) it.next(), Long.valueOf(j5));
        }
        if (bVar.isEmpty()) {
            return;
        }
        this.f698f = j5;
    }
}
