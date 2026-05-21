package k3;

import android.util.Log;
import android.widget.TextView;
import com.unified.ur1.primary.LaunchActivity;
import i3.C0573b;

/* renamed from: k3.b0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0677b0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8105j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ C0573b f8106k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f8107l;

    public /* synthetic */ RunnableC0677b0(C0573b c0573b, int i5, int i6) {
        this.f8105j = i6;
        this.f8106k = c0573b;
        this.f8107l = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8105j) {
            case 0:
                C0573b c0573b = this.f8106k;
                c0573b.getClass();
                Log.d("Unified - Main Activity", "Updating UI with fallback after JSON error");
                TextView textView = ((LaunchActivity) c0573b.f7297e).f5973x;
                if (textView != null) {
                    textView.setText("DMR ID: " + this.f8107l);
                    break;
                }
                break;
            case 1:
                C0573b c0573b2 = this.f8106k;
                c0573b2.getClass();
                Log.d("Unified - Main Activity", "Updating UI with fallback after general error");
                TextView textView2 = ((LaunchActivity) c0573b2.f7297e).f5973x;
                if (textView2 != null) {
                    textView2.setText("DMR ID: " + this.f8107l);
                    break;
                }
                break;
            default:
                C0573b c0573b3 = this.f8106k;
                c0573b3.getClass();
                StringBuilder sb = new StringBuilder("Updating UI with fallback text for radioId: ");
                int i5 = this.f8107l;
                sb.append(i5);
                Log.d("Unified - Main Activity", sb.toString());
                TextView textView3 = ((LaunchActivity) c0573b3.f7297e).f5973x;
                if (textView3 == null) {
                    Log.w("Unified - Main Activity", "callerIdText is null, cannot update UI");
                    break;
                } else {
                    textView3.setText("DMR ID: " + i5);
                    break;
                }
        }
    }
}
