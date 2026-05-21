package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.recyclerview.widget.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0261h extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f4240a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4241b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f4242c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4243d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f4244e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0265l f4245f;

    public C0261h(C0265l c0265l, n0 n0Var, int i5, View view, int i6, ViewPropertyAnimator viewPropertyAnimator) {
        this.f4245f = c0265l;
        this.f4240a = n0Var;
        this.f4241b = i5;
        this.f4242c = view;
        this.f4243d = i6;
        this.f4244e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i5 = this.f4241b;
        View view = this.f4242c;
        if (i5 != 0) {
            view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
        }
        if (this.f4243d != 0) {
            view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f4244e.setListener(null);
        C0265l c0265l = this.f4245f;
        n0 n0Var = this.f4240a;
        c0265l.d(n0Var);
        c0265l.f4286p.remove(n0Var);
        c0265l.j();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f4245f.getClass();
    }
}
