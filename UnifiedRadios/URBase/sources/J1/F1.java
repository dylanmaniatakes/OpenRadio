package J1;

import android.os.Bundle;
import android.os.SystemClock;

/* loaded from: classes.dex */
public final class F1 {

    /* renamed from: a, reason: collision with root package name */
    public long f734a;

    /* renamed from: b, reason: collision with root package name */
    public long f735b;

    /* renamed from: c, reason: collision with root package name */
    public final E1 f736c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ G1 f737d;

    public F1(G1 g12) {
        this.f737d = g12;
        this.f736c = new E1(this, (C0113v0) g12.f84c, 0);
        ((C0113v0) g12.f84c).f1421p.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f734a = jElapsedRealtime;
        this.f735b = jElapsedRealtime;
    }

    public final boolean a(long j5, boolean z4, boolean z5) {
        G1 g12 = this.f737d;
        g12.j();
        g12.k();
        C0113v0 c0113v0 = (C0113v0) g12.f84c;
        if (c0113v0.b()) {
            C0072h0 c0072h0 = c0113v0.f1416j;
            C0113v0.i(c0072h0);
            c0113v0.f1421p.getClass();
            c0072h0.f1245s.b(System.currentTimeMillis());
        }
        long j6 = j5 - this.f734a;
        Z z6 = c0113v0.f1417k;
        if (!z4 && j6 < 1000) {
            C0113v0.k(z6);
            z6.f1084p.b(Long.valueOf(j6), "Screen exposed for less than 1000 ms. Event not sent. time");
            return false;
        }
        if (!z5) {
            j6 = j5 - this.f735b;
            this.f735b = j5;
        }
        C0113v0.k(z6);
        z6.f1084p.b(Long.valueOf(j6), "Recording user engagement, ms");
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j6);
        boolean z7 = !c0113v0.f1415i.x();
        C0091n1 c0091n1 = c0113v0.f1422q;
        C0113v0.j(c0091n1);
        a2.z(c0091n1.q(z7), bundle, true);
        if (!z5) {
            C0058c1 c0058c1 = c0113v0.f1423r;
            C0113v0.j(c0058c1);
            c0058c1.u("auto", "_e", bundle);
        }
        this.f734a = j5;
        E1 e12 = this.f736c;
        e12.a();
        e12.c(((Long) H.f837p0.a(null)).longValue());
        return true;
    }
}
