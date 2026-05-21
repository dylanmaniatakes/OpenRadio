package k;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: k.q0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0652q0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7851j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ AbstractViewOnTouchListenerC0653r0 f7852k;

    public /* synthetic */ RunnableC0652q0(AbstractViewOnTouchListenerC0653r0 abstractViewOnTouchListenerC0653r0, int i5) {
        this.f7851j = i5;
        this.f7852k = abstractViewOnTouchListenerC0653r0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7851j) {
            case 0:
                ViewParent parent = this.f7852k.f7859f.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            default:
                AbstractViewOnTouchListenerC0653r0 abstractViewOnTouchListenerC0653r0 = this.f7852k;
                abstractViewOnTouchListenerC0653r0.a();
                View view = abstractViewOnTouchListenerC0653r0.f7859f;
                if (view.isEnabled() && !view.isLongClickable() && abstractViewOnTouchListenerC0653r0.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                    view.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    abstractViewOnTouchListenerC0653r0.f7860i = true;
                    break;
                }
                break;
        }
    }
}
