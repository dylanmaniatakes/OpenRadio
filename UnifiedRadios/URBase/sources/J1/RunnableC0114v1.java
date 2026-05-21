package J1;

import java.util.concurrent.ScheduledExecutorService;

/* renamed from: J1.v1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0114v1 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1432j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ J f1433k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ServiceConnectionC0117w1 f1434l;

    public /* synthetic */ RunnableC0114v1(ServiceConnectionC0117w1 serviceConnectionC0117w1, J j5, int i5) {
        this.f1432j = i5;
        this.f1433k = j5;
        this.f1434l = serviceConnectionC0117w1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScheduledExecutorService scheduledExecutorService;
        switch (this.f1432j) {
            case 0:
                ServiceConnectionC0117w1 serviceConnectionC0117w1 = this.f1434l;
                synchronized (serviceConnectionC0117w1) {
                    try {
                        serviceConnectionC0117w1.f1441a = false;
                        C0120x1 c0120x1 = serviceConnectionC0117w1.f1443c;
                        if (!c0120x1.t()) {
                            Z z4 = ((C0113v0) c0120x1.f84c).f1417k;
                            C0113v0.k(z4);
                            z4.f1084p.a("Connected to service");
                            J j5 = this.f1433k;
                            c0120x1.j();
                            c0120x1.f1451f = j5;
                            c0120x1.z();
                            c0120x1.y();
                        }
                    } finally {
                    }
                }
                return;
            default:
                ServiceConnectionC0117w1 serviceConnectionC0117w12 = this.f1434l;
                synchronized (serviceConnectionC0117w12) {
                    try {
                        serviceConnectionC0117w12.f1441a = false;
                        C0120x1 c0120x12 = serviceConnectionC0117w12.f1443c;
                        if (!c0120x12.t()) {
                            Z z5 = ((C0113v0) c0120x12.f84c).f1417k;
                            C0113v0.k(z5);
                            z5.f1083o.a("Connected to remote service");
                            J j6 = this.f1433k;
                            c0120x12.j();
                            c0120x12.f1451f = j6;
                            c0120x12.z();
                            c0120x12.y();
                        }
                    } finally {
                    }
                }
                C0120x1 c0120x13 = this.f1434l.f1443c;
                if (!((C0113v0) c0120x13.f84c).f1415i.w(null, H.f835o1) || (scheduledExecutorService = c0120x13.f1452i) == null) {
                    return;
                }
                scheduledExecutorService.shutdownNow();
                c0120x13.f1452i = null;
                return;
        }
    }
}
