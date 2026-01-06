package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class G implements View.OnAttachStateChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b0 f3664c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ H f3665d;

    public G(H h, b0 b0Var) {
        this.f3665d = h;
        this.f3664c = b0Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        b0 b0Var = this.f3664c;
        Fragment fragment = b0Var.f3773c;
        b0Var.k();
        C0215j.i((ViewGroup) fragment.mView.getParent(), this.f3665d.f3666c).g();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
