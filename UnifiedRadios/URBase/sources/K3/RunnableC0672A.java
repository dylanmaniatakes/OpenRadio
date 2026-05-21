package k3;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.unified.ur1.primary.LaunchActivity;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import m3.C0764B;
import m3.C0768d;

/* renamed from: k3.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0672A implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7934j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f7935k;

    public /* synthetic */ RunnableC0672A(LaunchActivity launchActivity, int i5) {
        this.f7934j = i5;
        this.f7935k = launchActivity;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException {
        int i5 = 8;
        switch (this.f7934j) {
            case 0:
                Context context = LaunchActivity.f5853D1;
                LaunchActivity launchActivity = this.f7935k;
                launchActivity.getClass();
                try {
                    Thread.sleep(8000L);
                    launchActivity.f5968v = new C0768d(launchActivity);
                    launchActivity.runOnUiThread(new RunnableC0672A(launchActivity, i5));
                    return;
                } catch (Exception e5) {
                    Log.e("Unified - Main Activity", "Audio initialization failed", e5);
                    launchActivity.runOnUiThread(new RunnableC0717w(launchActivity, e5, 2));
                    return;
                }
            case 1:
                LaunchActivity launchActivity2 = this.f7935k;
                while (launchActivity2.f5901U0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - launchActivity2.f5898S0 > 1000) {
                        synchronized (launchActivity2.f5903V0) {
                            try {
                                if (launchActivity2.f5901U0) {
                                    if (jCurrentTimeMillis - launchActivity2.T0 > 20) {
                                        launchActivity2.T0 = jCurrentTimeMillis;
                                        launchActivity2.f5901U0 = false;
                                        launchActivity2.runOnUiThread(new T(launchActivity2, 0));
                                    }
                                    return;
                                }
                                return;
                            } finally {
                            }
                        }
                    }
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                return;
            case 2:
                Context context2 = LaunchActivity.f5853D1;
                LaunchActivity launchActivity3 = this.f7935k;
                launchActivity3.getClass();
                X2.n nVar = new X2.n();
                nVar.f2822e = new AtomicBoolean(false);
                nVar.f2819b = C0764B.e();
                nVar.f2820c = Executors.newSingleThreadExecutor();
                nVar.f2821d = new Handler(Looper.getMainLooper());
                launchActivity3.f5979z = nVar;
                U u4 = new U(launchActivity3);
                Log.d("Unified - DMR-CallerID", "Starting caller ID listener");
                nVar.f2818a = u4;
                return;
            case 3:
                TextView textView = this.f7935k.f5973x;
                if (textView != null) {
                    textView.setText("Caller ID: --");
                    return;
                }
                return;
            case 4:
                LaunchActivity launchActivity4 = this.f7935k;
                if (launchActivity4.f5977y0.isShowing()) {
                    launchActivity4.f5977y0.dismiss();
                    return;
                }
                return;
            case 5:
                LaunchActivity launchActivity5 = this.f7935k;
                if (launchActivity5.f5977y0.isShowing()) {
                    launchActivity5.f5977y0.dismiss();
                    return;
                }
                return;
            case 6:
                Context context3 = LaunchActivity.f5853D1;
                this.f7935k.getClass();
                return;
            case 7:
                this.f7935k.f5910Z.setVisibility(8);
                return;
            default:
                Context context4 = LaunchActivity.f5853D1;
                LaunchActivity launchActivity6 = this.f7935k;
                launchActivity6.getClass();
                try {
                    new Handler().postDelayed(new T(launchActivity6, 3), 10L);
                    return;
                } catch (Exception e6) {
                    StringBuilder sbG = com.unified.ur1.SatelliteTracker.h.g("Unified - Main Activity", "Final setup failed", e6, "Error in final setup: ");
                    sbG.append(e6.getMessage());
                    Toast.makeText(launchActivity6, sbG.toString(), 1).show();
                    return;
                }
        }
    }
}
