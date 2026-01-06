package O;

import android.view.View;
import android.view.ViewTreeObserver;

/* renamed from: O.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0186z implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public final View f1987c;

    /* renamed from: d, reason: collision with root package name */
    public ViewTreeObserver f1988d;

    /* renamed from: e, reason: collision with root package name */
    public final Runnable f1989e;

    public ViewTreeObserverOnPreDrawListenerC0186z(View view, Runnable runnable) {
        this.f1987c = view;
        this.f1988d = view.getViewTreeObserver();
        this.f1989e = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        ViewTreeObserverOnPreDrawListenerC0186z viewTreeObserverOnPreDrawListenerC0186z = new ViewTreeObserverOnPreDrawListenerC0186z(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0186z);
        view.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC0186z);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean zIsAlive = this.f1988d.isAlive();
        View view = this.f1987c;
        if (zIsAlive) {
            this.f1988d.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.f1989e.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f1988d = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean zIsAlive = this.f1988d.isAlive();
        View view2 = this.f1987c;
        if (zIsAlive) {
            this.f1988d.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}
