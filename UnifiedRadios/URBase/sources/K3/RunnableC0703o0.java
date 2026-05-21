package k3;

import android.widget.Toast;
import com.unified.ur1.primary.LaunchActivity;

/* renamed from: k3.o0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0703o0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8180j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f8181k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f8182l;

    public /* synthetic */ RunnableC0703o0(String str, int i5, String str2) {
        this.f8180j = i5;
        this.f8181k = str;
        this.f8182l = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8180j) {
            case 0:
                boolean zEquals = "success".equals(this.f8181k);
                String str = this.f8182l;
                if (!zEquals) {
                    Toast.makeText(LaunchActivity.f5853D1, "" + str, 0).show();
                    break;
                } else {
                    Toast.makeText(LaunchActivity.f5853D1, str, 0).show();
                    break;
                }
            default:
                boolean zEquals2 = "success".equals(this.f8181k);
                String str2 = this.f8182l;
                if (!zEquals2) {
                    Toast.makeText(LaunchActivity.f5853D1, "" + str2, 0).show();
                    break;
                } else {
                    Toast.makeText(LaunchActivity.f5853D1, str2, 0).show();
                    break;
                }
        }
    }
}
