package k3;

import android.widget.Toast;
import com.unified.ur1.primary.LaunchActivity;

/* renamed from: k3.p0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0705p0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8186j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Exception f8187k;

    public /* synthetic */ RunnableC0705p0(Exception exc, int i5) {
        this.f8186j = i5;
        this.f8187k = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8186j) {
            case 0:
                Toast.makeText(LaunchActivity.f5853D1, "Error processing response: " + this.f8187k.getMessage(), 0).show();
                break;
            default:
                Toast.makeText(LaunchActivity.f5853D1, "Error processing response: " + this.f8187k.getMessage(), 0).show();
                break;
        }
    }
}
