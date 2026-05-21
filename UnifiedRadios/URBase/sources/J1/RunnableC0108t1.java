package J1;

import android.os.RemoteException;

/* renamed from: J1.t1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0108t1 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1392j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ b2 f1393k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0120x1 f1394l;

    public /* synthetic */ RunnableC0108t1(C0120x1 c0120x1, b2 b2Var, int i5) {
        this.f1392j = i5;
        this.f1393k = b2Var;
        this.f1394l = c0120x1;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f1392j) {
            case 0:
                C0120x1 c0120x1 = this.f1394l;
                J j5 = c0120x1.f1451f;
                C0113v0 c0113v0 = (C0113v0) c0120x1.f84c;
                if (j5 != null) {
                    try {
                        b2 b2Var = this.f1393k;
                        q1.E.i(b2Var);
                        j5.k(b2Var);
                    } catch (RemoteException e5) {
                        Z z4 = c0113v0.f1417k;
                        C0113v0.k(z4);
                        z4.h.b(e5, "Failed to reset data on the service: remote exception");
                    }
                    c0120x1.z();
                    break;
                } else {
                    Z z5 = c0113v0.f1417k;
                    C0113v0.k(z5);
                    z5.h.a("Failed to reset data on the service: not connected to service");
                    break;
                }
            case 1:
                C0120x1 c0120x12 = this.f1394l;
                J j6 = c0120x12.f1451f;
                C0113v0 c0113v02 = (C0113v0) c0120x12.f84c;
                if (j6 == null) {
                    Z z6 = c0113v02.f1417k;
                    C0113v0.k(z6);
                    z6.h.a("Discarding data. Failed to send app launch");
                    break;
                } else {
                    try {
                        b2 b2Var2 = this.f1393k;
                        q1.E.i(b2Var2);
                        C0068g c0068g = c0113v02.f1415i;
                        G g = H.f827l1;
                        if (c0068g.w(null, g)) {
                            c0120x12.q(j6, null, b2Var2);
                        }
                        j6.n(b2Var2);
                        c0113v02.o().p();
                        c0113v02.f1415i.w(null, g);
                        c0120x12.q(j6, null, b2Var2);
                        c0120x12.z();
                        break;
                    } catch (RemoteException e6) {
                        Z z7 = c0113v02.f1417k;
                        C0113v0.k(z7);
                        z7.h.b(e6, "Failed to send app launch to the service");
                        return;
                    }
                }
            case 2:
                C0120x1 c0120x13 = this.f1394l;
                J j7 = c0120x13.f1451f;
                C0113v0 c0113v03 = (C0113v0) c0120x13.f84c;
                if (j7 == null) {
                    Z z8 = c0113v03.f1417k;
                    C0113v0.k(z8);
                    z8.f1080k.a("Failed to send app backgrounded");
                    break;
                } else {
                    try {
                        b2 b2Var3 = this.f1393k;
                        q1.E.i(b2Var3);
                        j7.x(b2Var3);
                        c0120x13.z();
                        break;
                    } catch (RemoteException e7) {
                        Z z9 = c0113v03.f1417k;
                        C0113v0.k(z9);
                        z9.h.b(e7, "Failed to send app backgrounded to the service");
                        return;
                    }
                }
            case 3:
                C0120x1 c0120x14 = this.f1394l;
                J j8 = c0120x14.f1451f;
                C0113v0 c0113v04 = (C0113v0) c0120x14.f84c;
                if (j8 == null) {
                    Z z10 = c0113v04.f1417k;
                    C0113v0.k(z10);
                    z10.h.a("Failed to send measurementEnabled to service");
                    break;
                } else {
                    try {
                        b2 b2Var4 = this.f1393k;
                        q1.E.i(b2Var4);
                        j8.w(b2Var4);
                        c0120x14.z();
                        break;
                    } catch (RemoteException e8) {
                        Z z11 = c0113v04.f1417k;
                        C0113v0.k(z11);
                        z11.h.b(e8, "Failed to send measurementEnabled to the service");
                        return;
                    }
                }
            default:
                C0120x1 c0120x15 = this.f1394l;
                J j9 = c0120x15.f1451f;
                C0113v0 c0113v05 = (C0113v0) c0120x15.f84c;
                if (j9 == null) {
                    Z z12 = c0113v05.f1417k;
                    C0113v0.k(z12);
                    z12.h.a("Failed to send consent settings to service");
                    break;
                } else {
                    try {
                        b2 b2Var5 = this.f1393k;
                        q1.E.i(b2Var5);
                        j9.r(b2Var5);
                        c0120x15.z();
                        break;
                    } catch (RemoteException e9) {
                        Z z13 = c0113v05.f1417k;
                        C0113v0.k(z13);
                        z13.h.b(e9, "Failed to send consent settings to the service");
                    }
                }
        }
    }
}
