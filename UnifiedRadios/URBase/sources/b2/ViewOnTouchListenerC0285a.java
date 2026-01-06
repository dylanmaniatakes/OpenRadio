package b2;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: b2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnTouchListenerC0285a implements View.OnTouchListener {

    /* renamed from: c, reason: collision with root package name */
    public final Dialog f4536c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4537d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4538e;

    public ViewOnTouchListenerC0285a(Dialog dialog, Rect rect) {
        this.f4536c = dialog;
        this.f4537d = rect.left;
        this.f4538e = rect.top;
        ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = viewFindViewById.getLeft() + this.f4537d;
        int width = viewFindViewById.getWidth() + left;
        if (new RectF(left, viewFindViewById.getTop() + this.f4538e, width, viewFindViewById.getHeight() + r4).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        view.performClick();
        return this.f4536c.onTouchEvent(motionEventObtain);
    }
}
