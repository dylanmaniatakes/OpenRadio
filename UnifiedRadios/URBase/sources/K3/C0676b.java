package k3;

import android.util.Log;
import android.widget.CompoundButton;
import com.unified.ur1.primary.AppSettings;
import f.C0467d;
import i3.DialogInterfaceOnClickListenerC0580i;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: k3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0676b implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8103a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppSettings f8104b;

    public /* synthetic */ C0676b(AppSettings appSettings, int i5) {
        this.f8103a = i5;
        this.f8104b = appSettings;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        AppSettings appSettings = this.f8104b;
        switch (this.f8103a) {
            case 0:
                ThreadPoolExecutor threadPoolExecutor = appSettings.f5843c;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.execute(new J1.W0(appSettings, z4, 1));
                    break;
                }
                break;
            case 1:
                if (!z4) {
                    int i5 = AppSettings.f5842e;
                    appSettings.n(false);
                    h4.c.d0(appSettings, String.valueOf(0));
                    Log.w("Unified - Settings", "MARS capability has been disabled by user");
                    break;
                } else {
                    L.h hVar = new L.h(appSettings);
                    C0467d c0467d = (C0467d) hVar.f1522d;
                    c0467d.f6292d = "Part 97 Amateur Radio Declaration";
                    c0467d.f6294f = "WARNING: This is an FCC Part 97 Amateur Radio device. By enabling this feature, I certify that I am a licensed Amateur Radio operator and that I am authorized under FCC Part 97 regulations to operate outside the standard amateur radio frequency band plan, in accordance with my license privileges and all applicable laws and regulations.";
                    hVar.e("I Agree & Enable", new DialogInterfaceOnClickListenerC0681d0(5, this));
                    hVar.c("Cancel", new DialogInterfaceOnClickListenerC0580i(this, 4, compoundButton));
                    c0467d.f6299m = false;
                    hVar.f();
                    break;
                }
            case 2:
                int i6 = AppSettings.f5842e;
                ThreadPoolExecutor threadPoolExecutor2 = appSettings.f5843c;
                if (threadPoolExecutor2 != null) {
                    threadPoolExecutor2.execute(new RunnableC0682e(0, z4));
                }
                if (!z4) {
                    h4.c.V(appSettings, String.valueOf(0));
                    Log.w("Unified - Settings", "TX has been enabled by user");
                    break;
                } else {
                    h4.c.V(appSettings, String.valueOf(1));
                    Log.w("Unified - Settings", "TX has been disabled by user");
                    break;
                }
            case 3:
                ThreadPoolExecutor threadPoolExecutor3 = appSettings.f5843c;
                if (threadPoolExecutor3 != null) {
                    threadPoolExecutor3.execute(new RunnableC0682e(1, z4));
                }
                if (!z4) {
                    h4.c.C(appSettings).edit().putInt("displayrx", 0).apply();
                    Log.w("Unified - Settings", "setdisplayRx has been disabled by user");
                    break;
                } else {
                    h4.c.C(appSettings).edit().putInt("displayrx", 1).apply();
                    Log.w("Unified - Settings", "setdisplayRx has been enabled by user");
                    break;
                }
            default:
                int i7 = AppSettings.f5842e;
                ThreadPoolExecutor threadPoolExecutor4 = appSettings.f5843c;
                if (threadPoolExecutor4 != null) {
                    threadPoolExecutor4.execute(new RunnableC0682e(2, z4));
                }
                if (!z4) {
                    h4.c.e0(appSettings, 0);
                    Log.w("Unified - Settings", "setMetricEnable has been disabled by user");
                    break;
                } else {
                    h4.c.e0(appSettings, 1);
                    Log.w("Unified - Settings", "setMetricEnable has been enabled by user");
                    break;
                }
        }
    }
}
