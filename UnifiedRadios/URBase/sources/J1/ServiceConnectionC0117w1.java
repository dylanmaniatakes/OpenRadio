package J1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import n1.C0785b;
import q1.InterfaceC0851b;
import q1.InterfaceC0852c;
import t1.C0902a;
import z2.RunnableC0999a;

/* renamed from: J1.w1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ServiceConnectionC0117w1 implements ServiceConnection, InterfaceC0851b, InterfaceC0852c {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f1441a;

    /* renamed from: b, reason: collision with root package name */
    public volatile T f1442b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0120x1 f1443c;

    public ServiceConnectionC0117w1(C0120x1 c0120x1) {
        this.f1443c = c0120x1;
    }

    @Override // q1.InterfaceC0851b
    public final void a(int i5) {
        C0113v0 c0113v0 = (C0113v0) this.f1443c.f84c;
        C0104s0 c0104s0 = c0113v0.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.r();
        Z z4 = c0113v0.f1417k;
        C0113v0.k(z4);
        z4.f1083o.a("Service connection suspended");
        C0104s0 c0104s02 = c0113v0.f1418l;
        C0113v0.k(c0104s02);
        c0104s02.t(new C0.A(2, this));
    }

    @Override // q1.InterfaceC0852c
    public final void b(C0785b c0785b) {
        C0120x1 c0120x1 = this.f1443c;
        C0104s0 c0104s0 = ((C0113v0) c0120x1.f84c).f1418l;
        C0113v0.k(c0104s0);
        c0104s0.r();
        Z z4 = ((C0113v0) c0120x1.f84c).f1417k;
        if (z4 == null || !z4.f733d) {
            z4 = null;
        }
        if (z4 != null) {
            z4.f1080k.b(c0785b, "Service connection failed");
        }
        synchronized (this) {
            this.f1441a = false;
            this.f1442b = null;
        }
        C0104s0 c0104s02 = ((C0113v0) this.f1443c.f84c).f1418l;
        C0113v0.k(c0104s02);
        c0104s02.t(new RunnableC0999a(18, this, c0785b, false));
    }

    @Override // q1.InterfaceC0851b
    public final void c() {
        C0104s0 c0104s0 = ((C0113v0) this.f1443c.f84c).f1418l;
        C0113v0.k(c0104s0);
        c0104s0.r();
        synchronized (this) {
            try {
                q1.E.i(this.f1442b);
                J j5 = (J) this.f1442b.t();
                C0104s0 c0104s02 = ((C0113v0) this.f1443c.f84c).f1418l;
                C0113v0.k(c0104s02);
                c0104s02.t(new RunnableC0114v1(this, j5, 1));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f1442b = null;
                this.f1441a = false;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C0104s0 c0104s0 = ((C0113v0) this.f1443c.f84c).f1418l;
        C0113v0.k(c0104s0);
        c0104s0.r();
        synchronized (this) {
            if (iBinder == null) {
                this.f1441a = false;
                Z z4 = ((C0113v0) this.f1443c.f84c).f1417k;
                C0113v0.k(z4);
                z4.h.a("Service connected with null binder");
                return;
            }
            J i5 = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    i5 = iInterfaceQueryLocalInterface instanceof J ? (J) iInterfaceQueryLocalInterface : new I(iBinder);
                    Z z5 = ((C0113v0) this.f1443c.f84c).f1417k;
                    C0113v0.k(z5);
                    z5.f1084p.a("Bound to IMeasurementService interface");
                } else {
                    Z z6 = ((C0113v0) this.f1443c.f84c).f1417k;
                    C0113v0.k(z6);
                    z6.h.b(interfaceDescriptor, "Got binder with a wrong descriptor");
                }
            } catch (RemoteException unused) {
                Z z7 = ((C0113v0) this.f1443c.f84c).f1417k;
                C0113v0.k(z7);
                z7.h.a("Service connect failed to get IMeasurementService");
            }
            if (i5 == null) {
                this.f1441a = false;
                try {
                    C0902a c0902aB = C0902a.b();
                    C0120x1 c0120x1 = this.f1443c;
                    c0902aB.c(((C0113v0) c0120x1.f84c).f1411c, c0120x1.f1450e);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                C0104s0 c0104s02 = ((C0113v0) this.f1443c.f84c).f1418l;
                C0113v0.k(c0104s02);
                c0104s02.t(new RunnableC0114v1(this, i5, 0));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        C0113v0 c0113v0 = (C0113v0) this.f1443c.f84c;
        C0104s0 c0104s0 = c0113v0.f1418l;
        C0113v0.k(c0104s0);
        c0104s0.r();
        Z z4 = c0113v0.f1417k;
        C0113v0.k(z4);
        z4.f1083o.a("Service disconnected");
        C0104s0 c0104s02 = c0113v0.f1418l;
        C0113v0.k(c0104s02);
        c0104s02.t(new RunnableC0999a(17, this, componentName, false));
    }
}
