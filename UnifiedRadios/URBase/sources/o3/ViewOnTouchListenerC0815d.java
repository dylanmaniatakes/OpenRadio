package o3;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.unified.ur1.rfmodule.ROIP.DMRActivity;

/* renamed from: o3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnTouchListenerC0815d implements View.OnTouchListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8919c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f8920d;

    public /* synthetic */ ViewOnTouchListenerC0815d(int i5, Object obj) {
        this.f8919c = i5;
        this.f8920d = obj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Object obj = this.f8920d;
        switch (this.f8919c) {
            case 0:
                int i5 = DMRActivity.f6054s;
                DMRActivity dMRActivity = (DMRActivity) obj;
                dMRActivity.getClass();
                int action = motionEvent.getAction();
                if (action != 0) {
                    if ((action == 1 || action == 3) && dMRActivity.f6065p && dMRActivity.f6066q) {
                        dMRActivity.f6064o.stopTransmission();
                        dMRActivity.f6066q = false;
                        dMRActivity.l(false);
                    }
                } else if (dMRActivity.f6065p && !dMRActivity.f6066q) {
                    try {
                        dMRActivity.f6067r = Integer.parseInt(dMRActivity.g.getText().toString().trim());
                    } catch (NumberFormatException unused) {
                        Log.w("DMRActivity", "Invalid talkgroup value, using default");
                    }
                    dMRActivity.f6064o.startTransmissionToTalkgroup(dMRActivity.f6067r);
                    dMRActivity.f6066q = true;
                    dMRActivity.l(true);
                }
                return true;
            default:
                s2.h hVar = (s2.h) obj;
                hVar.getClass();
                if (motionEvent.getAction() == 1) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - hVar.f9600o;
                    if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
                        hVar.f9599m = false;
                    }
                    hVar.u();
                    hVar.f9599m = true;
                    hVar.f9600o = System.currentTimeMillis();
                }
                return false;
        }
    }
}
