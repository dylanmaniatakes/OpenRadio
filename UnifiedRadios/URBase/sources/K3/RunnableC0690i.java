package k3;

import android.util.Log;
import com.unified.ur1.primary.DTMFKeypad;
import java.util.HashMap;

/* renamed from: k3.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0690i implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8136j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ DTMFKeypad f8137k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f8138l;

    public /* synthetic */ RunnableC0690i(DTMFKeypad dTMFKeypad, String str, int i5) {
        this.f8136j = i5;
        this.f8137k = dTMFKeypad;
        this.f8138l = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.f8138l;
        DTMFKeypad dTMFKeypad = this.f8137k;
        switch (this.f8136j) {
            case 0:
                if (!dTMFKeypad.g) {
                    Log.w("DTMFKeypad", "Transmission failed to start, retrying...");
                    dTMFKeypad.e();
                    dTMFKeypad.f5849e.postDelayed(new RunnableC0690i(dTMFKeypad, str, 1), 300L);
                    break;
                } else {
                    dTMFKeypad.a(str);
                    break;
                }
            default:
                HashMap map = DTMFKeypad.f5846k;
                dTMFKeypad.a(str);
                break;
        }
    }
}
