package f2;

import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* renamed from: f2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0483g implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6499c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6500d;

    public /* synthetic */ ViewTreeObserverOnPreDrawListenerC0483g(int i5, Object obj) {
        this.f6499c = i5;
        this.f6500d = obj;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        switch (this.f6499c) {
            case 0:
                AbstractC0487k abstractC0487k = (AbstractC0487k) this.f6500d;
                float rotation = abstractC0487k.f6532s.getRotation();
                if (abstractC0487k.f6528o != rotation) {
                    abstractC0487k.f6528o = rotation;
                    abstractC0487k.p();
                    break;
                }
                break;
            default:
                ((CoordinatorLayout) this.f6500d).p(0);
                break;
        }
        return true;
    }
}
