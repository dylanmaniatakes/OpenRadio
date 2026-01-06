package J1;

import android.os.RemoteException;

/* renamed from: J1.o1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0094o1 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1334j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ C0120x1 f1335k;

    public /* synthetic */ RunnableC0094o1(C0120x1 c0120x1, int i5) {
        this.f1334j = i5;
        this.f1335k = c0120x1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1334j) {
            case 0:
                C0120x1 c0120x1 = this.f1335k;
                J j5 = c0120x1.f1451f;
                C0113v0 c0113v0 = (C0113v0) c0120x1.f84c;
                if (j5 == null) {
                    Z z4 = c0113v0.f1417k;
                    C0113v0.k(z4);
                    z4.h.a("Failed to send storage consent settings to service");
                    break;
                } else {
                    try {
                        j5.e(c0120x1.x(false));
                        c0120x1.z();
                        break;
                    } catch (RemoteException e5) {
                        Z z5 = c0113v0.f1417k;
                        C0113v0.k(z5);
                        z5.h.b(e5, "Failed to send storage consent settings to the service");
                        return;
                    }
                }
            case 1:
                C0120x1 c0120x12 = this.f1335k;
                J j6 = c0120x12.f1451f;
                C0113v0 c0113v02 = (C0113v0) c0120x12.f84c;
                if (j6 == null) {
                    Z z6 = c0113v02.f1417k;
                    C0113v0.k(z6);
                    z6.h.a("Failed to send Dma consent settings to service");
                    break;
                } else {
                    try {
                        j6.E(c0120x12.x(false));
                        c0120x12.z();
                        break;
                    } catch (RemoteException e6) {
                        Z z7 = c0113v02.f1417k;
                        C0113v0.k(z7);
                        z7.h.b(e6, "Failed to send Dma consent settings to the service");
                        return;
                    }
                }
            default:
                this.f1335k.n();
                break;
        }
    }
}
