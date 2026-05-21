package k3;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import com.unified.ur1.primary.OptionsActivity;
import g0.AbstractC0535a;
import m3.C0774j;

/* loaded from: classes.dex */
public final /* synthetic */ class I0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7972j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ OptionsActivity f7973k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f7974l;

    public /* synthetic */ I0(OptionsActivity optionsActivity, int i5, int i6) {
        this.f7972j = i6;
        this.f7973k = optionsActivity;
        this.f7974l = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OptionsActivity optionsActivity = this.f7973k;
        int i5 = this.f7974l;
        switch (this.f7972j) {
            case 0:
                int i6 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    OptionsActivity.R("aprsEnabled", "1");
                    OptionsActivity.R("aprsSsid", String.valueOf(i5));
                    break;
                } catch (Exception e5) {
                    Log.e("Unified - Settings", "Error updating local database for APRS", e5);
                    return;
                }
            case 1:
                int i7 = OptionsActivity.f5981H;
                if (!optionsActivity.isFinishing()) {
                    optionsActivity.f5997m = i5;
                    TextView textView = optionsActivity.f5996l;
                    if (textView != null) {
                        textView.setText(String.valueOf(i5));
                    }
                    optionsActivity.f5997m = i5;
                    optionsActivity.S(i5);
                    optionsActivity.P();
                    try {
                        Button button = optionsActivity.f5994j;
                        if (button != null) {
                            button.setOnClickListener(new F0(optionsActivity, 5));
                        }
                        Button button2 = optionsActivity.f5995k;
                        if (button2 != null) {
                            button2.setOnClickListener(new F0(optionsActivity, 6));
                        }
                    } catch (Exception e6) {
                        Log.e("Unified - Settings", "Error setting up mic gain listeners", e6);
                    }
                    AbstractC0535a.u("Mic gain settings loaded: level=", i5, "Unified - Settings");
                    break;
                }
                break;
            default:
                int i8 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    C0774j c0774j = optionsActivity.f6002s;
                    V0 v0 = new V0(optionsActivity, i5);
                    c0774j.getClass();
                    C0774j.f(i5, v0);
                    optionsActivity.E(i5);
                    Log.d("Unified - Settings", "Microphone gain set to: " + i5);
                    break;
                } catch (Exception e7) {
                    Log.e("Unified - Settings", "Error setting microphone gain", e7);
                    optionsActivity.runOnUiThread(new L0(optionsActivity, e7, 2));
                }
        }
    }
}
