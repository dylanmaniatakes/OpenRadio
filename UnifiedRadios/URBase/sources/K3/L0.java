package k3;

import android.widget.Toast;
import com.unified.ur1.primary.OptionsActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class L0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7986j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ OptionsActivity f7987k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Exception f7988l;

    public /* synthetic */ L0(OptionsActivity optionsActivity, Exception exc, int i5) {
        this.f7986j = i5;
        this.f7987k = optionsActivity;
        this.f7988l = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Exception exc = this.f7988l;
        OptionsActivity optionsActivity = this.f7987k;
        switch (this.f7986j) {
            case 0:
                int i5 = OptionsActivity.f5981H;
                if (!optionsActivity.isFinishing()) {
                    Toast.makeText(optionsActivity, "Error processing audio file: " + exc.getMessage(), 0).show();
                    break;
                }
                break;
            case 1:
                int i6 = OptionsActivity.f5981H;
                if (!optionsActivity.isFinishing()) {
                    Toast.makeText(optionsActivity, "Error setting volume: " + exc.getMessage(), 0).show();
                    break;
                }
                break;
            default:
                int i7 = OptionsActivity.f5981H;
                if (!optionsActivity.isFinishing()) {
                    Toast.makeText(optionsActivity, "Error setting microphone gain: " + exc.getMessage(), 0).show();
                    break;
                }
                break;
        }
    }
}
