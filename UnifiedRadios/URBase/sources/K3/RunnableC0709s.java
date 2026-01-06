package k3;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;
import i3.C0573b;

/* renamed from: k3.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0709s implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8199j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8200k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f8201l;

    public /* synthetic */ RunnableC0709s(LaunchActivity launchActivity, int i5, int i6) {
        this.f8199j = i6;
        this.f8200k = launchActivity;
        this.f8201l = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f8201l;
        LaunchActivity launchActivity = this.f8200k;
        switch (this.f8199j) {
            case 0:
                launchActivity.f5959s.n(launchActivity.f5956r);
                Log.d("Unified - Main Activity", "Badge updated in UI: " + i5);
                return;
            case 1:
                Context context = LaunchActivity.f5853D1;
                launchActivity.R(i5);
                CardView cardView = launchActivity.f5874F0;
                if (cardView == null || cardView.getVisibility() != 0) {
                    return;
                }
                TextView textView = (TextView) launchActivity.f5874F0.findViewById(R.id.ROIP_Connection);
                if (textView != null) {
                    textView.setText("🔊 ROIP RX: " + i5);
                }
                launchActivity.f5874F0.animate().scaleX(1.05f).scaleY(1.05f).setDuration(500L).withEndAction(new RunnableC0696l(launchActivity, 12)).start();
                return;
            case 2:
                Context context2 = LaunchActivity.f5853D1;
                TextView textView2 = (TextView) launchActivity.findViewById(R.id.mailBadge);
                if (textView2 == null) {
                    Log.e("Unified - Main Activity", "Badge TextView not found!");
                    return;
                }
                if (i5 <= 0) {
                    textView2.setVisibility(8);
                    Log.d("Unified - Main Activity", "Badge hidden (no unread messages)");
                    return;
                }
                String strValueOf = i5 > 99 ? "99+" : String.valueOf(i5);
                textView2.setText(strValueOf);
                textView2.setVisibility(0);
                Log.d("Unified - Main Activity", "Badge updated to show: " + strValueOf);
                return;
            case 3:
                Context context3 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                try {
                    String str = LaunchActivity.I1;
                    if (str == null) {
                        Log.e("Unified - Main Activity", "Authorization code not found - cannot call UR1 API");
                        return;
                    }
                    if (!launchActivity.J(i5, str)) {
                        Log.e("Unified - Main Activity", "Failed to set UR1 talkgroup to " + i5);
                        return;
                    } else {
                        Log.i("Unified - Main Activity", "UR1 talkgroup set successfully to " + i5);
                        if (i5 == 4000) {
                            launchActivity.n0();
                            launchActivity.f5915b1.f();
                        }
                        throw null;
                    }
                } catch (Exception e5) {
                    Log.e("Unified - Main Activity", "Exception in setUR1Talkgroup", e5);
                    return;
                }
            case 4:
                C0573b c0573b = launchActivity.f5959s;
                if (c0573b != null) {
                    c0573b.o(i5);
                }
                launchActivity.O0(i5);
                return;
            case 5:
                Context context4 = LaunchActivity.f5853D1;
                launchActivity.L0(i5);
                return;
            default:
                Context context5 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                launchActivity.D0("✓ TG " + i5 + " set successfully");
                return;
        }
    }
}
