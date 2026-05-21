package k3;

import android.widget.Toast;
import com.unified.ur1.primary.LaunchActivity;
import java.io.IOException;

/* renamed from: k3.q0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0707q0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8192j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ IOException f8193k;

    public /* synthetic */ RunnableC0707q0(IOException iOException, int i5) {
        this.f8192j = i5;
        this.f8193k = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8192j) {
            case 0:
                Toast.makeText(LaunchActivity.f5853D1, "Error saving memory: " + this.f8193k.getMessage(), 0).show();
                break;
            default:
                Toast.makeText(LaunchActivity.f5853D1, "Network error: " + this.f8193k.getMessage(), 0).show();
                break;
        }
    }
}
