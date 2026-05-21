package w0;

import O.G;
import O.Y;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class h extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10062a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10063b;

    /* renamed from: c, reason: collision with root package name */
    public final View f10064c;

    public h(View view, boolean z4) {
        this.f10062a = 1;
        this.f10063b = z4;
        this.f10064c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f10062a) {
            case 0:
                x xVar = w.f10116a;
                View view = this.f10064c;
                xVar.E(view, 1.0f);
                if (this.f10063b) {
                    view.setLayerType(0, null);
                    break;
                }
                break;
            default:
                if (!this.f10063b) {
                    this.f10064c.setVisibility(4);
                    break;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        View view = this.f10064c;
        switch (this.f10062a) {
            case 0:
                WeakHashMap weakHashMap = Y.f1904a;
                if (G.h(view) && view.getLayerType() == 0) {
                    this.f10063b = true;
                    view.setLayerType(2, null);
                    break;
                }
                break;
            default:
                if (this.f10063b) {
                    view.setVisibility(0);
                    break;
                }
                break;
        }
    }

    public h(View view) {
        this.f10062a = 0;
        this.f10063b = false;
        this.f10064c = view;
    }
}
