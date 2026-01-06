package f3;

import android.util.Log;
import com.unified.ur1.adapters.SoundCustomizationActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class s0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6795j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ SoundCustomizationActivity f6796k;

    public /* synthetic */ s0(SoundCustomizationActivity soundCustomizationActivity, int i5) {
        this.f6795j = i5;
        this.f6796k = soundCustomizationActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = 1;
        SoundCustomizationActivity soundCustomizationActivity = this.f6796k;
        switch (this.f6795j) {
            case 0:
                int i6 = SoundCustomizationActivity.f5721f;
                soundCustomizationActivity.getClass();
                try {
                    Log.d("SoundCustomizationActivity", "Starting reset operation...");
                    h4.c.l0(soundCustomizationActivity, true);
                    h4.c.X(soundCustomizationActivity, "default");
                    h4.c.R(soundCustomizationActivity, "default");
                    h4.c.n0(soundCustomizationActivity, "default");
                    h4.c.O(soundCustomizationActivity, "default");
                    h4.c.C(soundCustomizationActivity).edit().putString("disconnect_sound_mode", "default").apply();
                    h4.c.i0(soundCustomizationActivity, "default");
                    h4.c.Y(soundCustomizationActivity, null);
                    h4.c.S(soundCustomizationActivity, null);
                    h4.c.o0(soundCustomizationActivity, null);
                    h4.c.P(soundCustomizationActivity, null);
                    h4.c.C(soundCustomizationActivity).edit().putString("disconnect_sound_path", null).apply();
                    h4.c.j0(soundCustomizationActivity, null);
                    soundCustomizationActivity.m();
                    soundCustomizationActivity.runOnUiThread(new s0(soundCustomizationActivity, i5));
                    Log.d("SoundCustomizationActivity", "Reset operation completed successfully");
                    break;
                } catch (Exception e5) {
                    Log.e("SoundCustomizationActivity", "Error resetting sound settings", e5);
                    soundCustomizationActivity.runOnUiThread(new D.m(soundCustomizationActivity, 27, e5));
                    return;
                }
            default:
                SoundCustomizationActivity.k(soundCustomizationActivity);
                break;
        }
    }
}
