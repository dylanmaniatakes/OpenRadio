package f3;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.unified.ur1.adapters.SoundCustomizationActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class x0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6851j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ E0 f6852k;

    public /* synthetic */ x0(E0 e02, int i5) {
        this.f6851j = i5;
        this.f6852k = e02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6851j) {
            case 0:
                Toast.makeText((Context) this.f6852k.f6571i, "Error playing sound", 0).show();
                break;
            default:
                E0 e02 = this.f6852k;
                Context context = (Context) e02.f6571i;
                try {
                    ((Activity) context).runOnUiThread(new z0(e02, h4.c.u(context), h4.c.o(context), h4.c.k(context), h4.c.x(context), h4.c.i(context), h4.c.m(context), h4.c.s(context)));
                    break;
                } catch (Exception e5) {
                    Log.e("SoundCustomizationManager", "Error loading sound settings", e5);
                    D0 d02 = (D0) e02.I;
                    if (d02 != null) {
                        String str = "Failed to load sound settings: " + e5.getMessage();
                        SoundCustomizationActivity soundCustomizationActivity = (SoundCustomizationActivity) d02;
                        Log.e("SoundCustomizationActivity", "Sound customization error: " + str);
                        soundCustomizationActivity.runOnUiThread(new D.m(soundCustomizationActivity, 26, str));
                    }
                    return;
                }
        }
    }
}
