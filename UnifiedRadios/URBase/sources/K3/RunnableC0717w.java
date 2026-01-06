package k3;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.unified.ur1.primary.LaunchActivity;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import m3.HandlerThreadC0778n;

/* renamed from: k3.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0717w implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8226j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8227k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Exception f8228l;

    public /* synthetic */ RunnableC0717w(LaunchActivity launchActivity, Exception exc, int i5) {
        this.f8226j = i5;
        this.f8227k = launchActivity;
        this.f8228l = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Exception exc = this.f8228l;
        LaunchActivity launchActivity = this.f8227k;
        switch (this.f8226j) {
            case 0:
                Context context = LaunchActivity.f5853D1;
                launchActivity.getClass();
                if (!LaunchActivity.f5855F1) {
                    Toast.makeText(launchActivity, "Failed to initialize radio hardware: " + exc.getMessage(), 1).show();
                    break;
                }
                break;
            case 1:
                Context context2 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                launchActivity.x0(exc instanceof SocketTimeoutException ? "Validation failed: Connection timeout. Please check your internet connection." : exc instanceof UnknownHostException ? "Validation failed: Unable to reach validation server. Please check your internet connection." : "Validation failed: Network error. Please try again later.");
                break;
            default:
                Context context3 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                Toast.makeText(launchActivity, "Error initializing audio system: " + exc.getMessage(), 1).show();
                if (launchActivity.f5968v != null) {
                    Log.d("Unified - Main Activity", "Release DMR Audio Handler #2");
                    launchActivity.f5968v.l();
                    launchActivity.f5968v = null;
                }
                HandlerThreadC0778n handlerThreadC0778n = launchActivity.f5918d;
                if (handlerThreadC0778n != null) {
                    handlerThreadC0778n.a();
                    launchActivity.f5918d = null;
                    break;
                }
                break;
        }
    }
}
