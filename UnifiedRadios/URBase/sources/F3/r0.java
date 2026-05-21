package f3;

import android.util.Log;
import com.unified.ur1.adapters.SoundCustomizationActivity;
import com.unified.ur1.primary.OptionsActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class r0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6788j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Runnable f6789k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f6790l;

    public /* synthetic */ r0(Runnable runnable, String str, int i5) {
        this.f6788j = i5;
        this.f6789k = runnable;
        this.f6790l = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.f6790l;
        Runnable runnable = this.f6789k;
        switch (this.f6788j) {
            case 0:
                int i5 = SoundCustomizationActivity.f5721f;
                try {
                    runnable.run();
                    break;
                } catch (Exception e5) {
                    Log.e("SoundCustomizationActivity", "Error executing " + str, e5);
                    return;
                }
            default:
                int i6 = OptionsActivity.f5981H;
                try {
                    runnable.run();
                    break;
                } catch (Exception e6) {
                    Log.e("Unified - Settings", "Error executing " + str, e6);
                }
        }
    }
}
