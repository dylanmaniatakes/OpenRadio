package k3;

import android.content.Context;
import android.graphics.Color;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.TextView;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;
import f3.C0511d;
import g0.AbstractC0535a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class T implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8020j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8021k;

    public /* synthetic */ T(LaunchActivity launchActivity, int i5) {
        this.f8020j = i5;
        this.f8021k = launchActivity;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        LaunchActivity launchActivity = this.f8021k;
        switch (this.f8020j) {
            case 0:
                launchActivity.G0();
                if (launchActivity.f5973x != null) {
                    TextView textView = (TextView) launchActivity.findViewById(R.id.activeFrequency);
                    textView.setTextColor(Color.parseColor("#000000"));
                    textView.clearAnimation();
                    ((TextView) launchActivity.findViewById(R.id.locFlag)).setText("");
                    launchActivity.N0();
                    break;
                }
                break;
            case 1:
                Context context = LaunchActivity.f5853D1;
                int intProperty = ((BatteryManager) launchActivity.getSystemService("batterymanager")).getIntProperty(4);
                TextView textView2 = (TextView) launchActivity.findViewById(R.id.battery);
                if (textView2 != null) {
                    textView2.setText(intProperty + "%");
                }
                Log.d("Battery", "Current battery percentage: " + intProperty + "%");
                launchActivity.c1.postDelayed(this, 120000L);
                break;
            case 2:
                Context context2 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
                TextView textView3 = (TextView) launchActivity.findViewById(R.id.time);
                if (textView3 != null) {
                    textView3.setText(str);
                }
                AbstractC0535a.v("Current military time: ", str, "Time");
                launchActivity.f5923e1.postDelayed(this, 60000L);
                break;
            case 3:
                Context context3 = LaunchActivity.f5853D1;
                launchActivity.Z();
                break;
            case 4:
                if (launchActivity.f5952p1) {
                    launchActivity.f5949o1++;
                    launchActivity.runOnUiThread(new C0.e(23, this));
                    launchActivity.f5946n1.postDelayed(this, 1000L);
                    break;
                }
                break;
            case 5:
                LaunchActivity.G(launchActivity);
                break;
            case 6:
                LaunchActivity.G(launchActivity);
                break;
            case 7:
                C0 c02 = launchActivity.f5919d0;
                C0511d c0511dE = C0.g.q().e("callsign");
                C0 c03 = launchActivity.f5919d0;
                C0511d c0511dE2 = C0.g.q().e("squelch");
                C0 c04 = launchActivity.f5919d0;
                C0511d c0511dE3 = C0.g.q().e("emphasis");
                C0 c05 = launchActivity.f5919d0;
                C0511d c0511dE4 = C0.g.q().e("highpass");
                C0 c06 = launchActivity.f5919d0;
                C0511d c0511dE5 = C0.g.q().e("lowpass");
                C0 c07 = launchActivity.f5919d0;
                C0511d c0511dE6 = C0.g.q().e("stickyPTT");
                C0 c08 = launchActivity.f5919d0;
                C0511d c0511dE7 = C0.g.q().e("disableAnimations");
                C0 c09 = launchActivity.f5919d0;
                C0511d c0511dE8 = C0.g.q().e("lastMemoryId");
                C0 c010 = launchActivity.f5919d0;
                C0511d c0511dE9 = C0.g.q().e("lastFreq");
                C0 c011 = launchActivity.f5919d0;
                launchActivity.runOnUiThread(new RunnableC0697l0(this, c0511dE, C0.g.q().e("lastGroup"), c0511dE8, c0511dE9, c0511dE2, c0511dE3, c0511dE4, c0511dE5, c0511dE6, c0511dE7));
                break;
            default:
                Log.e("Unified - Main Activity", "activeFrequencyField 5");
                ((TextView) launchActivity.findViewById(R.id.activeMemoryName)).setText(h4.c.C(LaunchActivity.f5853D1).getString("channel_name", ""));
                break;
        }
    }
}
