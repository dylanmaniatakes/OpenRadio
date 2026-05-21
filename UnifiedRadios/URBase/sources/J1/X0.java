package J1;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class X0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1057j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ long f1058k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0058c1 f1059l;

    public /* synthetic */ X0(C0058c1 c0058c1, long j5, int i5) {
        this.f1057j = i5;
        this.f1058k = j5;
        this.f1059l = c0058c1;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        long jElapsedRealtime;
        switch (this.f1057j) {
            case 0:
                C0113v0 c0113v0 = (C0113v0) this.f1059l.f84c;
                C0072h0 c0072h0 = c0113v0.f1416j;
                C0113v0.i(c0072h0);
                C0069g0 c0069g0 = c0072h0.n;
                long j5 = this.f1058k;
                c0069g0.b(j5);
                Z z4 = c0113v0.f1417k;
                C0113v0.k(z4);
                z4.f1083o.b(Long.valueOf(j5), "Session timeout duration set");
                break;
            default:
                C0058c1 c0058c1 = this.f1059l;
                c0058c1.j();
                c0058c1.k();
                C0113v0 c0113v02 = (C0113v0) c0058c1.f84c;
                Z z5 = c0113v02.f1417k;
                C0113v0.k(z5);
                z5.f1083o.a("Resetting analytics data (FE)");
                G1 g12 = c0113v02.f1419m;
                C0113v0.j(g12);
                g12.j();
                F1 f12 = g12.h;
                f12.f736c.a();
                C0113v0 c0113v03 = (C0113v0) f12.f737d.f84c;
                if (c0113v03.f1415i.w(null, H.f801b1)) {
                    c0113v03.f1421p.getClass();
                    jElapsedRealtime = SystemClock.elapsedRealtime();
                    f12.f734a = jElapsedRealtime;
                } else {
                    f12.f734a = 0L;
                    jElapsedRealtime = 0;
                }
                f12.f735b = jElapsedRealtime;
                c0113v02.n().s();
                boolean z6 = !c0113v02.b();
                C0072h0 c0072h02 = c0113v02.f1416j;
                C0113v0.i(c0072h02);
                c0072h02.f1236i.b(this.f1058k);
                C0113v0 c0113v04 = (C0113v0) c0072h02.f84c;
                C0072h0 c0072h03 = c0113v04.f1416j;
                C0113v0.i(c0072h03);
                if (!TextUtils.isEmpty(c0072h03.f1251y.g())) {
                    c0072h02.f1251y.h(null);
                }
                c0072h02.f1245s.b(0L);
                c0072h02.f1246t.b(0L);
                if (!c0113v04.f1415i.k()) {
                    c0072h02.s(z6);
                }
                c0072h02.f1252z.h(null);
                c0072h02.f1232A.b(0L);
                c0072h02.f1233B.s(null);
                C0120x1 c0120x1R = c0113v02.r();
                c0120x1R.j();
                c0120x1R.k();
                b2 b2VarX = c0120x1R.x(false);
                c0120x1R.B();
                ((C0113v0) c0120x1R.f84c).o().o();
                c0120x1R.A(new RunnableC0108t1(c0120x1R, b2VarX, 0));
                C0113v0.j(g12);
                g12.g.A();
                c0058c1.f1176u = z6;
                c0113v02.r().p(new AtomicReference());
                break;
        }
    }
}
