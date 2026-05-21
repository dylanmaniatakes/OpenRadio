package k3;

import android.util.Log;
import com.unified.ur1.primary.OptionsActivity;
import f3.C0511d;

/* loaded from: classes.dex */
public final /* synthetic */ class H0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7967j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ boolean f7968k;

    public /* synthetic */ H0(int i5, boolean z4) {
        this.f7967j = i5;
        this.f7968k = z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = "1";
        boolean z4 = this.f7968k;
        switch (this.f7967j) {
            case 0:
                int i5 = OptionsActivity.f5981H;
                try {
                    C0511d c0511dE = C0.g.q().e("aprsEnabled");
                    if (c0511dE == null) {
                        C0.g.q().g(new C0511d("aprsEnabled", String.valueOf(z4 ? 1 : 0)));
                    } else {
                        c0511dE.f6684b = String.valueOf(z4 ? 1 : 0);
                        C0.g.q().j(c0511dE);
                    }
                    break;
                } catch (Exception e5) {
                    Log.e("Unified - Settings", "Error setting APRS enabled", e5);
                    return;
                }
            case 1:
                int i6 = OptionsActivity.f5981H;
                try {
                    C0511d c0511dE2 = C0.g.q().e("metricEnable");
                    if (c0511dE2 == null) {
                        if (!z4) {
                            str = "0";
                        }
                        C0.g.q().g(new C0511d("metricEnable", str));
                    } else {
                        if (!z4) {
                            str = "0";
                        }
                        c0511dE2.f6684b = str;
                        C0.g.q().j(c0511dE2);
                    }
                    Log.d("Unified - Settings", "Server Metric enable setting applied: " + z4);
                    break;
                } catch (Exception e6) {
                    Log.e("Unified - Settings", "Error updating metric settings in database", e6);
                    return;
                }
            default:
                int i7 = OptionsActivity.f5981H;
                try {
                    C0511d c0511dE3 = C0.g.q().e("disablePTT");
                    if (c0511dE3 == null) {
                        if (!z4) {
                            str = "0";
                        }
                        C0.g.q().g(new C0511d("disablePTT", str));
                    } else {
                        if (!z4) {
                            str = "0";
                        }
                        c0511dE3.f6684b = str;
                        C0.g.q().j(c0511dE3);
                    }
                    Log.d("Unified - Settings", "Server PTT disable setting applied: " + z4);
                    break;
                } catch (Exception e7) {
                    Log.e("Unified - Settings", "Error updating PTT settings in database", e7);
                }
        }
    }
}
