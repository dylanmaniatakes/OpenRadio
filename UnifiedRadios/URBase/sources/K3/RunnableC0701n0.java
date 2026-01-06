package k3;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.widget.TextView;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;
import f3.C0511d;

/* renamed from: k3.n0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0701n0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8173j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f8174k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8175l;

    public /* synthetic */ RunnableC0701n0(LaunchActivity launchActivity, String str, int i5) {
        this.f8173j = i5;
        this.f8175l = launchActivity;
        this.f8174k = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8173j) {
            case 0:
                LaunchActivity launchActivity = this.f8175l;
                C0 c02 = launchActivity.f5919d0;
                C0511d c0511dE = C0.g.q().e("lastFreq");
                String str = this.f8174k;
                if (c0511dE != null) {
                    c0511dE.f6684b = str;
                    C0 c03 = launchActivity.f5919d0;
                    C0.g.q().j(c0511dE);
                } else {
                    C0511d c0511d = new C0511d("lastFreq", str);
                    C0 c04 = launchActivity.f5919d0;
                    C0.g.q().g(c0511d);
                }
                C0 c05 = launchActivity.f5919d0;
                C0511d c0511dE2 = C0.g.q().e("lastMemoryId");
                if (c0511dE2 == null) {
                    C0511d c0511d2 = new C0511d("lastMemoryId", "-1");
                    C0 c06 = launchActivity.f5919d0;
                    C0.g.q().g(c0511d2);
                    break;
                } else {
                    c0511dE2.f6684b = "-1";
                    C0 c07 = launchActivity.f5919d0;
                    C0.g.q().j(c0511dE2);
                    break;
                }
            case 1:
                Log.e("Unified - Main Activity", "showMemoryName");
                TextView textView = (TextView) this.f8175l.findViewById(R.id.activeMemoryName);
                textView.setText(this.f8174k);
                if (LaunchActivity.f5854E1) {
                    textView.setText("Multi-RX");
                    textView.setTextSize(1, 60.0f);
                    break;
                }
                break;
            default:
                LaunchActivity launchActivity2 = this.f8175l;
                TextView textView2 = (TextView) launchActivity2.findViewById(R.id.activeFrequency);
                textView2.setText("");
                String str2 = this.f8174k;
                if (str2.length() > 7) {
                    String strSubstring = str2.substring(0, str2.length() - 2);
                    String strSubstring2 = str2.substring(str2.length() - 2);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(com.unified.ur1.SatelliteTracker.h.b(strSubstring, strSubstring2));
                    spannableStringBuilder.setSpan(new RelativeSizeSpan(0.25f), strSubstring.length(), strSubstring2.length() + strSubstring.length(), 33);
                    textView2.setText(spannableStringBuilder);
                } else {
                    textView2.setText(str2);
                }
                textView2.setTextColor(Color.parseColor("#8B0000"));
                launchActivity2.f5897S = str2;
                break;
        }
    }
}
