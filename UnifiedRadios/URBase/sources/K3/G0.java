package k3;

import android.util.Log;
import com.unified.ur1.primary.OptionsActivity;
import f3.C0511d;

/* loaded from: classes.dex */
public final /* synthetic */ class G0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7961j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ OptionsActivity f7962k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f7963l;

    public /* synthetic */ G0(OptionsActivity optionsActivity, boolean z4, int i5) {
        this.f7961j = i5;
        this.f7962k = optionsActivity;
        this.f7963l = z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        str = "disabled";
        String str2 = "1";
        boolean z4 = this.f7963l;
        OptionsActivity optionsActivity = this.f7962k;
        switch (this.f7961j) {
            case 0:
                int i5 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    C0511d c0511dE = C0.g.q().e("disablePTT");
                    if (c0511dE == null) {
                        C0.g.q().g(new C0511d("disablePTT", z4 ? "1" : "0"));
                    } else {
                        c0511dE.f6684b = z4 ? "1" : "0";
                        C0.g.q().j(c0511dE);
                    }
                    if (!z4) {
                        str2 = "0";
                    }
                    h4.c.V(optionsActivity, str2);
                    StringBuilder sb = new StringBuilder("PTT ");
                    if (!z4) {
                        str = "enabled";
                    }
                    sb.append(str);
                    sb.append(" by user");
                    Log.d("Unified - Settings", sb.toString());
                    break;
                } catch (Exception e5) {
                    Log.e("Unified - Settings", "Error saving PTT settings", e5);
                    return;
                }
            default:
                int i6 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    C0511d c0511dE2 = C0.g.q().e("metricEnable");
                    if (c0511dE2 == null) {
                        if (!z4) {
                            str2 = "0";
                        }
                        C0.g.q().g(new C0511d("metricEnable", str2));
                    } else {
                        if (!z4) {
                            str2 = "0";
                        }
                        c0511dE2.f6684b = str2;
                        C0.g.q().j(c0511dE2);
                    }
                    h4.c.e0(optionsActivity, z4 ? 1 : 0);
                    StringBuilder sb2 = new StringBuilder("Metric display ");
                    sb2.append(z4 ? "enabled" : "disabled");
                    sb2.append(" by user");
                    Log.d("Unified - Settings", sb2.toString());
                    break;
                } catch (Exception e6) {
                    Log.e("Unified - Settings", "Error saving metric settings", e6);
                }
        }
    }
}
