package J1;

import r1.AbstractC0873a;

/* renamed from: J1.s1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0105s1 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1385j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ b2 f1386k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f1387l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ C0120x1 f1388m;
    public final /* synthetic */ AbstractC0873a n;

    public /* synthetic */ RunnableC0105s1(C0120x1 c0120x1, b2 b2Var, boolean z4, AbstractC0873a abstractC0873a, int i5) {
        this.f1385j = i5;
        this.f1386k = b2Var;
        this.f1387l = z4;
        this.n = abstractC0873a;
        this.f1388m = c0120x1;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f1385j) {
            case 0:
                C0120x1 c0120x1 = this.f1388m;
                J j5 = c0120x1.f1451f;
                if (j5 != null) {
                    b2 b2Var = this.f1386k;
                    q1.E.i(b2Var);
                    c0120x1.q(j5, this.f1387l ? null : (Y1) this.n, b2Var);
                    c0120x1.z();
                    break;
                } else {
                    Z z4 = ((C0113v0) c0120x1.f84c).f1417k;
                    C0113v0.k(z4);
                    z4.h.a("Discarding data. Failed to set user property");
                    break;
                }
            case 1:
                C0120x1 c0120x12 = this.f1388m;
                J j6 = c0120x12.f1451f;
                if (j6 != null) {
                    b2 b2Var2 = this.f1386k;
                    q1.E.i(b2Var2);
                    c0120x12.q(j6, this.f1387l ? null : (C0112v) this.n, b2Var2);
                    c0120x12.z();
                    break;
                } else {
                    Z z5 = ((C0113v0) c0120x12.f84c).f1417k;
                    C0113v0.k(z5);
                    z5.h.a("Discarding data. Failed to send event to service");
                    break;
                }
            default:
                C0120x1 c0120x13 = this.f1388m;
                J j7 = c0120x13.f1451f;
                if (j7 != null) {
                    b2 b2Var3 = this.f1386k;
                    q1.E.i(b2Var3);
                    c0120x13.q(j7, this.f1387l ? null : (C0062e) this.n, b2Var3);
                    c0120x13.z();
                    break;
                } else {
                    Z z6 = ((C0113v0) c0120x13.f84c).f1417k;
                    C0113v0.k(z6);
                    z6.h.a("Discarding data. Failed to send conditional user property to service");
                    break;
                }
        }
    }
}
