package w0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import w1.AbstractC0930a;

/* renamed from: w0.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0924A extends AnimatorListenerAdapter implements o {

    /* renamed from: a, reason: collision with root package name */
    public final View f10033a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10034b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f10035c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10037e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10038f = false;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f10036d = true;

    public C0924A(View view, int i5) {
        this.f10033a = view;
        this.f10034b = i5;
        this.f10035c = (ViewGroup) view.getParent();
        f(true);
    }

    @Override // w0.o
    public final void a() {
    }

    @Override // w0.o
    public final void b() {
        f(false);
    }

    @Override // w0.o
    public final void c() {
        f(true);
    }

    @Override // w0.o
    public final void d() {
    }

    @Override // w0.o
    public final void e(p pVar) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (!this.f10038f) {
            w.f10116a.F(this.f10033a, this.f10034b);
            ViewGroup viewGroup = this.f10035c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        f(false);
        pVar.v(this);
    }

    public final void f(boolean z4) {
        ViewGroup viewGroup;
        if (!this.f10036d || this.f10037e == z4 || (viewGroup = this.f10035c) == null) {
            return;
        }
        this.f10037e = z4;
        AbstractC0930a.p(viewGroup, z4);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f10038f = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (!this.f10038f) {
            w.f10116a.F(this.f10033a, this.f10034b);
            ViewGroup viewGroup = this.f10035c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        f(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (this.f10038f) {
            return;
        }
        w.f10116a.F(this.f10033a, this.f10034b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (this.f10038f) {
            return;
        }
        w.f10116a.F(this.f10033a, 0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
