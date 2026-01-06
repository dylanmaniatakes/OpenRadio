package k3;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import f3.RunnableC0492C;

/* renamed from: k3.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0698m implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8164j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8165k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f8166l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ProgressDialog f8167m;
    public final /* synthetic */ long n;

    public /* synthetic */ RunnableC0698m(LaunchActivity launchActivity, Object obj, ProgressDialog progressDialog, long j5, int i5) {
        this.f8164j = i5;
        this.f8165k = launchActivity;
        this.f8166l = obj;
        this.f8167m = progressDialog;
        this.n = j5;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Object obj = this.f8166l;
        switch (this.f8164j) {
            case 0:
                Context context = LaunchActivity.f5853D1;
                LaunchActivity launchActivity = this.f8165k;
                if (!launchActivity.isFinishing() && !launchActivity.isDestroyed()) {
                    L0.s sVar = new L0.s(launchActivity.f5916c, 20, launchActivity);
                    sVar.A();
                    ((Handler) obj).postDelayed(new RunnableC0492C(sVar, 5), 6000L);
                    launchActivity.runOnUiThread(new RunnableC0706q(launchActivity, this.f8167m, this.n, 1));
                    break;
                }
                break;
            case 1:
                Context context2 = LaunchActivity.f5853D1;
                LaunchActivity launchActivity2 = this.f8165k;
                if (!launchActivity2.isFinishing() && !launchActivity2.isDestroyed()) {
                    L0.s sVar2 = new L0.s(launchActivity2.f5916c, 20, launchActivity2);
                    sVar2.y();
                    ((Handler) obj).postDelayed(new RunnableC0492C(sVar2, 4), 6000L);
                    launchActivity2.runOnUiThread(new RunnableC0706q(launchActivity2, this.f8167m, this.n, 0));
                    break;
                }
                break;
            default:
                DMRBridge dMRBridge = (DMRBridge) obj;
                ProgressDialog progressDialog = this.f8167m;
                long j5 = this.n;
                Context context3 = LaunchActivity.f5853D1;
                LaunchActivity launchActivity3 = this.f8165k;
                launchActivity3.getClass();
                try {
                    dMRBridge.s();
                    dMRBridge.g();
                    for (int i5 = 0; dMRBridge.isSocketConnected() && i5 < 6000; i5 += 200) {
                        Thread.sleep(200);
                    }
                    if (dMRBridge.isSocketConnected()) {
                        Log.w("Unified - Main Activity", "ROIP disconnect timeout - forcing cleanup");
                        dMRBridge.i();
                        dMRBridge.h();
                    }
                    Log.d("Unified - Main Activity", "ROIP disconnect completed");
                    new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0698m(launchActivity3, new Handler(Looper.getMainLooper()), progressDialog, j5, 1), 6000L);
                    break;
                } catch (Exception e5) {
                    Log.e("Unified - Main Activity", "Error during ROIP disconnect", e5);
                    if (launchActivity3.isFinishing() || launchActivity3.isDestroyed()) {
                        return;
                    }
                    launchActivity3.runOnUiThread(new RunnableC0700n(launchActivity3, progressDialog, e5, 1));
                }
        }
    }
}
