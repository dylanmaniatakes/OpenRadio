package k3;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.unified.ur1.primary.LaunchActivity;

/* renamed from: k3.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0700n implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8169j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8170k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ProgressDialog f8171l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Exception f8172m;

    public /* synthetic */ RunnableC0700n(LaunchActivity launchActivity, ProgressDialog progressDialog, Exception exc, int i5) {
        this.f8169j = i5;
        this.f8170k = launchActivity;
        this.f8171l = progressDialog;
        this.f8172m = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProgressDialog progressDialog = this.f8171l;
        LaunchActivity launchActivity = this.f8170k;
        Exception exc = this.f8172m;
        switch (this.f8169j) {
            case 0:
                Context context = LaunchActivity.f5853D1;
                launchActivity.getClass();
                if (progressDialog != null) {
                    try {
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                    } catch (Exception e5) {
                        Log.e("Unified - Main Activity", "Error showing error toast", e5);
                        return;
                    }
                }
                Toast.makeText(launchActivity, "Error disconnecting from network: " + exc.getMessage(), 1).show();
                break;
            default:
                Context context2 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                if (progressDialog != null) {
                    try {
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                    } catch (Exception e6) {
                        Log.e("Unified - Main Activity", "Error showing error toast", e6);
                    }
                }
                Toast.makeText(launchActivity, "Error disconnecting from network: " + exc.getMessage(), 1).show();
                break;
        }
    }
}
