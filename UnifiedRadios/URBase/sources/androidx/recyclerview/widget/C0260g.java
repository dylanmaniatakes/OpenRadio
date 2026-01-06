package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* renamed from: androidx.recyclerview.widget.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0260g extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4234a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n0 f4235b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f4236c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f4237d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0265l f4238e;

    public C0260g(C0265l c0265l, n0 n0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f4238e = c0265l;
        this.f4235b = n0Var;
        this.f4237d = viewPropertyAnimator;
        this.f4236c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f4234a) {
            case 1:
                this.f4236c.setAlpha(1.0f);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f4234a) {
            case 0:
                this.f4237d.setListener(null);
                this.f4236c.setAlpha(1.0f);
                C0265l c0265l = this.f4238e;
                n0 n0Var = this.f4235b;
                c0265l.d(n0Var);
                c0265l.f4287q.remove(n0Var);
                c0265l.j();
                break;
            default:
                this.f4237d.setListener(null);
                C0265l c0265l2 = this.f4238e;
                n0 n0Var2 = this.f4235b;
                c0265l2.d(n0Var2);
                c0265l2.f4285o.remove(n0Var2);
                c0265l2.j();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f4234a) {
            case 0:
                this.f4238e.getClass();
                break;
            default:
                this.f4238e.getClass();
                break;
        }
    }

    public C0260g(C0265l c0265l, n0 n0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f4238e = c0265l;
        this.f4235b = n0Var;
        this.f4236c = view;
        this.f4237d = viewPropertyAnimator;
    }
}
