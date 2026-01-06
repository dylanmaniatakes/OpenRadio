package f;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class v extends ContentFrameLayout {

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ x f6370k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(x xVar, i.e eVar) {
        super(eVar, null);
        this.f6370k = xVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f6370k.v(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x4 = (int) motionEvent.getX();
            int y4 = (int) motionEvent.getY();
            if (x4 < -5 || y4 < -5 || x4 > getWidth() + 5 || y4 > getHeight() + 5) {
                x xVar = this.f6370k;
                xVar.t(xVar.A(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i5) {
        setBackgroundDrawable(AbstractC0930a.k(getContext(), i5));
    }
}
