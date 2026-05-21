package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* renamed from: androidx.fragment.app.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class AnimationAnimationListenerC0211f implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f3798a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f3799b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0212g f3800c;

    public AnimationAnimationListenerC0211f(View view, ViewGroup viewGroup, C0212g c0212g) {
        this.f3798a = viewGroup;
        this.f3799b = view;
        this.f3800c = c0212g;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.f3798a.post(new RunnableC0210e(0, this));
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
