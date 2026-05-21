package k3;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.unified.ur1.primary.DTMFKeypad;
import java.util.HashMap;

/* renamed from: k3.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnTouchListenerC0694k implements View.OnTouchListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f8146c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DTMFKeypad f8147d;

    public ViewOnTouchListenerC0694k(DTMFKeypad dTMFKeypad, String str) {
        this.f8147d = dTMFKeypad;
        this.f8146c = str;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i5 = 0;
        int action = motionEvent.getAction();
        String str = this.f8146c;
        DTMFKeypad dTMFKeypad = this.f8147d;
        if (action == 0) {
            HashMap map = DTMFKeypad.f5846k;
            dTMFKeypad.getClass();
            Log.d("DTMFKeypad", "Key pressed: " + str);
            if (dTMFKeypad.g) {
                dTMFKeypad.a(str);
            } else {
                dTMFKeypad.e();
                dTMFKeypad.f5849e.postDelayed(new RunnableC0690i(dTMFKeypad, str, i5), 500L);
            }
            view.setPressed(true);
            return true;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        HashMap map2 = DTMFKeypad.f5846k;
        dTMFKeypad.getClass();
        Log.d("DTMFKeypad", "Key released: " + str);
        C0.A a2 = dTMFKeypad.f5847c;
        if (a2 != null) {
            dTMFKeypad.f5849e.removeCallbacks(a2);
        }
        C0.A a3 = new C0.A(28, dTMFKeypad);
        dTMFKeypad.f5847c = a3;
        dTMFKeypad.f5849e.postDelayed(a3, 2000L);
        view.setPressed(false);
        return true;
    }
}
