package k3;

import android.widget.Switch;
import com.google.android.material.slider.Slider;
import com.google.android.material.textfield.TextInputEditText;
import com.unified.ur1.R;
import com.unified.ur1.primary.AppSettings;
import f3.C0511d;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: k3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0680d implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ C0511d f8110j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ C0511d f8111k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0511d f8112l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ C0511d f8113m;
    public final /* synthetic */ C0511d n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ C0511d f8114o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ C0511d f8115p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ C0511d f8116q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ C0511d f8117r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ C0.A f8118s;

    public RunnableC0680d(C0.A a2, C0511d c0511d, C0511d c0511d2, C0511d c0511d3, C0511d c0511d4, C0511d c0511d5, C0511d c0511d6, C0511d c0511d7, C0511d c0511d8, C0511d c0511d9) {
        this.f8118s = a2;
        this.f8110j = c0511d;
        this.f8111k = c0511d2;
        this.f8112l = c0511d3;
        this.f8113m = c0511d4;
        this.n = c0511d5;
        this.f8114o = c0511d6;
        this.f8115p = c0511d7;
        this.f8116q = c0511d8;
        this.f8117r = c0511d9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0.A a2 = this.f8118s;
        C0511d c0511d = this.f8110j;
        if (c0511d != null) {
            ((TextInputEditText) ((AppSettings) a2.f128k).findViewById(R.id.callsignTextInputEditText)).setText(c0511d.f6684b);
        }
        C0511d c0511d2 = this.f8111k;
        if (c0511d2 != null) {
            ((Switch) ((AppSettings) a2.f128k).findViewById(R.id.HidePTTSwitch)).setChecked(Boolean.parseBoolean(c0511d2.f6684b));
        } else {
            boolean z4 = true;
            ((Switch) ((AppSettings) a2.f128k).findViewById(R.id.HidePTTSwitch)).setChecked(true);
            AppSettings appSettings = (AppSettings) a2.f128k;
            ThreadPoolExecutor threadPoolExecutor = appSettings.f5843c;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.execute(new J1.W0(appSettings, z4, 1));
            }
        }
        C0511d c0511d3 = this.f8112l;
        if (c0511d3 != null) {
            ((Switch) ((AppSettings) a2.f128k).findViewById(R.id.DisRXEnable)).setChecked(Boolean.parseBoolean(c0511d3.f6684b));
        } else {
            ((Switch) ((AppSettings) a2.f128k).findViewById(R.id.DisRXEnable)).setChecked(false);
            ThreadPoolExecutor threadPoolExecutor2 = ((AppSettings) a2.f128k).f5843c;
            if (threadPoolExecutor2 != null) {
                threadPoolExecutor2.execute(new RunnableC0682e(1, false));
            }
        }
        C0511d c0511d4 = this.f8113m;
        if (c0511d4 != null) {
            ((Slider) ((AppSettings) a2.f128k).findViewById(R.id.squelchSlider)).setValue(Float.parseFloat(c0511d4.f6684b));
        }
        C0511d c0511d5 = this.n;
        if (c0511d5 != null) {
            ((Switch) ((AppSettings) a2.f128k).findViewById(R.id.emphasisSwitch)).setChecked(Boolean.parseBoolean(c0511d5.f6684b));
        }
        C0511d c0511d6 = this.f8114o;
        if (c0511d6 != null) {
            ((Switch) ((AppSettings) a2.f128k).findViewById(R.id.highpassSwitch)).setChecked(Boolean.parseBoolean(c0511d6.f6684b));
        }
        C0511d c0511d7 = this.f8115p;
        if (c0511d7 != null) {
            ((Switch) ((AppSettings) a2.f128k).findViewById(R.id.lowpassSwitch)).setChecked(Boolean.parseBoolean(c0511d7.f6684b));
        }
        C0511d c0511d8 = this.f8116q;
        if (c0511d8 != null) {
            ((Switch) ((AppSettings) a2.f128k).findViewById(R.id.stickyPTTSwitch)).setChecked(Boolean.parseBoolean(c0511d8.f6684b));
        }
        C0511d c0511d9 = this.f8117r;
        if (c0511d9 != null) {
            ((Switch) ((AppSettings) a2.f128k).findViewById(R.id.noAnimationsSwitch)).setChecked(Boolean.parseBoolean(c0511d9.f6684b));
        }
    }
}
