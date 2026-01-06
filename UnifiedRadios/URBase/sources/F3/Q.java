package f3;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import java.net.URL;

/* loaded from: classes.dex */
public final /* synthetic */ class Q implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6630j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ f0 f6631k;

    public /* synthetic */ Q(f0 f0Var, int i5) {
        this.f6630j = i5;
        this.f6631k = f0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6630j) {
            case 0:
                f0 f0Var = this.f6631k;
                Context context = f0Var.f6710b;
                try {
                    new URL("https://ur1.unifiedradios.com/request_repeater_update.php");
                    ((Activity) context).runOnUiThread(new Q(f0Var, 1));
                    break;
                } catch (Exception unused) {
                    ((Activity) context).runOnUiThread(new Q(f0Var, 2));
                    return;
                }
            case 1:
                Toast.makeText(this.f6631k.f6710b, "Update request submitted", 0).show();
                break;
            case 2:
                Toast.makeText(this.f6631k.f6710b, "Error submitting request", 0).show();
                break;
            default:
                Toast.makeText(this.f6631k.f6710b, "Error updating status", 0).show();
                break;
        }
    }
}
