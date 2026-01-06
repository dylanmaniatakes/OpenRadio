package k3;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.unified.ur1.R;
import com.unified.ur1.chat.SimpleImageViewerActivity;
import com.unified.ur1.primary.LaunchActivity;
import f.AbstractActivityC0472i;
import f.C0467d;

/* loaded from: classes.dex */
public final class W implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8062a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0472i f8063b;

    public /* synthetic */ W(AbstractActivityC0472i abstractActivityC0472i, int i5) {
        this.f8062a = i5;
        this.f8063b = abstractActivityC0472i;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        AbstractActivityC0472i abstractActivityC0472i = this.f8063b;
        switch (this.f8062a) {
            case 0:
                LaunchActivity.z((LaunchActivity) abstractActivityC0472i);
                break;
            case 1:
                LaunchActivity launchActivity = (LaunchActivity) abstractActivityC0472i;
                ((Vibrator) launchActivity.getSystemService("vibrator")).vibrate(VibrationEffect.createOneShot(200L, -1));
                if (launchActivity.f5886M != 1 && !launchActivity.f5970w.equals("DMR") && !launchActivity.f5970w.equals("ROIP") && !launchActivity.f5970w.equals("FM")) {
                    Toast.makeText(launchActivity, (launchActivity.f5886M != 0 || launchActivity.f5970w.equals("DMR") || launchActivity.f5970w.equals("FM")) ? "DTMF Keypad not available in current mode" : "DTMF Keypad requires ROIP connection or DMR/FM mode", 0).show();
                    break;
                } else {
                    LaunchActivity.z(launchActivity);
                    break;
                }
                break;
            case 2:
                Context context = LaunchActivity.f5853D1;
                LaunchActivity launchActivity2 = (LaunchActivity) abstractActivityC0472i;
                if (!launchActivity2.isFinishing() && !launchActivity2.isDestroyed()) {
                    L.h hVar = new L.h(launchActivity2, R.style.Base_Theme_Material3_Dark_Dialog);
                    C0467d c0467d = (C0467d) hVar.f1522d;
                    c0467d.f6292d = "ROIP Stream Resync";
                    c0467d.f6294f = "Do you want to resync the ROIP stream? This will refresh your connection to the current talkgroup.";
                    hVar.e("Yes", new DialogInterfaceOnClickListenerC0681d0(3, launchActivity2));
                    hVar.c("No", new G(2));
                    try {
                        hVar.b().show();
                        break;
                    } catch (WindowManager.BadTokenException e5) {
                        Log.e("Unified - Main Activity", "Failed to show ROIP resync dialog - invalid window token", e5);
                        if (!launchActivity2.isFinishing() && !launchActivity2.isDestroyed()) {
                            Toast.makeText(launchActivity2, "Cannot show dialog - please try again", 0).show();
                            break;
                        }
                    }
                } else {
                    Log.w("Unified - Main Activity", "Activity is finishing/destroyed, cannot show ROIP resync dialog");
                    break;
                }
                break;
            default:
                int i5 = SimpleImageViewerActivity.n;
                ((SimpleImageViewerActivity) abstractActivityC0472i).j();
                break;
        }
        return true;
    }
}
