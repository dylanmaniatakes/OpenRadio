package k3;

import f3.C0511d;

/* renamed from: k3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0682e implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8121j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ boolean f8122k;

    public /* synthetic */ RunnableC0682e(int i5, boolean z4) {
        this.f8121j = i5;
        this.f8122k = z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8121j) {
            case 0:
                C0511d c0511dE = C0.g.q().e("disablePTT");
                boolean z4 = this.f8122k;
                if (c0511dE != null) {
                    c0511dE.f6684b = "" + z4;
                    C0.g.q().j(c0511dE);
                    break;
                } else {
                    C0.g.q().g(new C0511d("disablePTT", "" + z4));
                    break;
                }
            case 1:
                C0511d c0511dE2 = C0.g.q().e("displayRX");
                boolean z5 = this.f8122k;
                if (c0511dE2 != null) {
                    c0511dE2.f6684b = "" + z5;
                    C0.g.q().j(c0511dE2);
                    break;
                } else {
                    C0.g.q().g(new C0511d("displayRX", "" + z5));
                    break;
                }
            case 2:
                C0511d c0511dE3 = C0.g.q().e("metricEnable");
                boolean z6 = this.f8122k;
                if (c0511dE3 != null) {
                    c0511dE3.f6684b = "" + z6;
                    C0.g.q().j(c0511dE3);
                    break;
                } else {
                    C0.g.q().g(new C0511d("metricEnable", "" + z6));
                    break;
                }
            default:
                C0511d c0511dE4 = C0.g.q().e("MarsCap");
                boolean z7 = this.f8122k;
                if (c0511dE4 != null) {
                    c0511dE4.f6684b = "" + z7;
                    C0.g.q().j(c0511dE4);
                    break;
                } else {
                    C0.g.q().g(new C0511d("MarsCap", "" + z7));
                    break;
                }
        }
    }
}
