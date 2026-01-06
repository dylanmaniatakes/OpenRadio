package k3;

import android.widget.LinearLayout;
import android.widget.Toast;
import com.unified.ur1.R;

/* renamed from: k3.w0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0718w0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8229j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ x0 f8230k;

    public /* synthetic */ RunnableC0718w0(x0 x0Var, int i5) {
        this.f8229j = i5;
        this.f8230k = x0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8229j) {
            case 0:
                x0 x0Var = this.f8230k;
                x0Var.f8240j.f5908Y.setVisibility(0);
                LinearLayout linearLayout = (LinearLayout) x0Var.f8240j.findViewById(R.id.buttonbar);
                if (linearLayout != null) {
                    linearLayout.setVisibility(4);
                    break;
                }
                break;
            default:
                Toast.makeText(this.f8230k.f8240j, "IP address has changed", 0).show();
                break;
        }
    }
}
