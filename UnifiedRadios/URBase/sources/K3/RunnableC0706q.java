package k3;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;

/* renamed from: k3.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0706q implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8188j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8189k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ProgressDialog f8190l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f8191m;

    public /* synthetic */ RunnableC0706q(LaunchActivity launchActivity, ProgressDialog progressDialog, long j5, int i5) {
        this.f8188j = i5;
        this.f8189k = launchActivity;
        this.f8190l = progressDialog;
        this.f8191m = j5;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException {
        ProgressDialog progressDialog = this.f8190l;
        LaunchActivity launchActivity = this.f8189k;
        long j5 = this.f8191m;
        switch (this.f8188j) {
            case 0:
                Context context = LaunchActivity.f5853D1;
                launchActivity.getClass();
                if (progressDialog != null) {
                    try {
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                    } catch (Exception e5) {
                        Log.e("Unified - Main Activity", "Error in UI update after ROIP disconnect", e5);
                        return;
                    }
                }
                TextView textView = (TextView) launchActivity.findViewById(R.id.CallerID);
                launchActivity.f5973x = textView;
                textView.setVisibility(4);
                TextView textView2 = (TextView) launchActivity.findViewById(R.id.activeFrequency);
                String str = String.format("%.5f", Double.valueOf(j5 / 1000000.0d));
                textView2.setText(str);
                ((TextView) launchActivity.findViewById(R.id.activeMemoryName)).setText("FM Analog");
                launchActivity.f5970w = "FM";
                String str2 = launchActivity.f5900U;
                if (str2 == null && str2.isEmpty()) {
                    launchActivity.f5940l0.setText("");
                } else {
                    launchActivity.f5940l0.setText(" " + launchActivity.f5900U + " ");
                }
                h4.c.b0(launchActivity, "FM Analog");
                h4.c.p0(launchActivity, "FM");
                h4.c.a0(launchActivity, str);
                launchActivity.H0(str);
                launchActivity.onResume();
                break;
            case 1:
                Context context2 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                if (progressDialog != null) {
                    try {
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                    } catch (Exception e6) {
                        Log.e("Unified - Main Activity", "Error in UI update after ROIP disconnect", e6);
                        return;
                    }
                }
                TextView textView3 = (TextView) launchActivity.findViewById(R.id.CallerID);
                launchActivity.f5973x = textView3;
                textView3.setVisibility(0);
                launchActivity.f5970w = "DMR";
                h4.c.p0(LaunchActivity.f5853D1, "DMR");
                h4.c.a0(LaunchActivity.f5853D1, String.format("%.5f", Double.valueOf(j5 / 1000000.0d)));
                h4.c.b0(LaunchActivity.f5853D1, "DMR Digital");
                launchActivity.M0(j5);
                ((TextView) launchActivity.findViewById(R.id.activeMemoryName)).setText("DMR Digital");
                launchActivity.onResume();
                break;
            default:
                ProgressDialog progressDialog2 = this.f8190l;
                long j6 = this.f8191m;
                Context context3 = LaunchActivity.f5853D1;
                LaunchActivity launchActivity2 = this.f8189k;
                launchActivity2.getClass();
                try {
                    launchActivity2.f5915b1.s();
                    launchActivity2.f5915b1.g();
                    for (int i5 = 0; launchActivity2.f5915b1.isSocketConnected() && i5 < 6000; i5 += 200) {
                        Thread.sleep(200);
                    }
                    if (launchActivity2.f5915b1.isSocketConnected()) {
                        Log.w("Unified - Main Activity", "ROIP disconnect timeout - forcing cleanup");
                        launchActivity2.f5915b1.i();
                        launchActivity2.f5915b1.h();
                    }
                    Log.d("Unified - Main Activity", "ROIP disconnect completed");
                    new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0698m(launchActivity2, new Handler(Looper.getMainLooper()), progressDialog2, j6, 0), 6000L);
                    break;
                } catch (Exception e7) {
                    Log.e("Unified - Main Activity", "Error during ROIP disconnect", e7);
                    if (launchActivity2.isFinishing() || launchActivity2.isDestroyed()) {
                        return;
                    }
                    launchActivity2.runOnUiThread(new RunnableC0700n(launchActivity2, progressDialog2, e7, 0));
                }
        }
    }
}
