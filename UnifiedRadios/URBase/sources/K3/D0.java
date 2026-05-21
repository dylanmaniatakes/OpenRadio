package k3;

import android.util.Log;
import com.unified.ur1.primary.OptionsActivity;
import f3.C0511d;

/* loaded from: classes.dex */
public final /* synthetic */ class D0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7953j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f7954k;

    public /* synthetic */ D0(int i5, int i6) {
        this.f7953j = i6;
        this.f7954k = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f7954k;
        switch (this.f7953j) {
            case 0:
                int i6 = OptionsActivity.f5981H;
                try {
                    C0511d c0511dE = C0.g.q().e("aprsEnabled");
                    if (c0511dE == null) {
                        C0.g.q().g(new C0511d("aprsEnabled", "1"));
                    } else {
                        c0511dE.f6684b = "1";
                        C0.g.q().j(c0511dE);
                    }
                    C0511d c0511dE2 = C0.g.q().e("aprsSsid");
                    if (c0511dE2 != null) {
                        c0511dE2.f6684b = String.valueOf(i5);
                        C0.g.q().j(c0511dE2);
                        break;
                    } else {
                        C0.g.q().g(new C0511d("aprsSsid", String.valueOf(i5)));
                        break;
                    }
                } catch (Exception e5) {
                    Log.e("Unified - Settings", "Error updating database in populateOriginalValues", e5);
                    return;
                }
            default:
                int i7 = OptionsActivity.f5981H;
                try {
                    C0511d c0511dE3 = C0.g.q().e("aprsSsid");
                    if (c0511dE3 == null) {
                        C0.g.q().g(new C0511d("aprsSsid", String.valueOf(i5)));
                    } else {
                        c0511dE3.f6684b = String.valueOf(i5);
                        C0.g.q().j(c0511dE3);
                    }
                    break;
                } catch (Exception e6) {
                    Log.e("Unified - Settings", "Error setting APRS SSID", e6);
                    return;
                }
        }
    }
}
