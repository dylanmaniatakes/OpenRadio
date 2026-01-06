package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: androidx.recyclerview.widget.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0262i extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4252a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0263j f4253b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f4254c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f4255d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0265l f4256e;

    public /* synthetic */ C0262i(C0265l c0265l, C0263j c0263j, ViewPropertyAnimator viewPropertyAnimator, View view, int i5) {
        this.f4252a = i5;
        this.f4256e = c0265l;
        this.f4253b = c0263j;
        this.f4254c = viewPropertyAnimator;
        this.f4255d = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f4252a) {
            case 0:
                this.f4254c.setListener(null);
                View view = this.f4255d;
                view.setAlpha(1.0f);
                view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                C0263j c0263j = this.f4253b;
                n0 n0Var = c0263j.f4257a;
                C0265l c0265l = this.f4256e;
                c0265l.d(n0Var);
                c0265l.f4288r.remove(c0263j.f4257a);
                c0265l.j();
                break;
            default:
                this.f4254c.setListener(null);
                View view2 = this.f4255d;
                view2.setAlpha(1.0f);
                view2.setTranslationX(BitmapDescriptorFactory.HUE_RED);
                view2.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                C0263j c0263j2 = this.f4253b;
                n0 n0Var2 = c0263j2.f4258b;
                C0265l c0265l2 = this.f4256e;
                c0265l2.d(n0Var2);
                c0265l2.f4288r.remove(c0263j2.f4258b);
                c0265l2.j();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f4252a) {
            case 0:
                n0 n0Var = this.f4253b.f4257a;
                this.f4256e.getClass();
                break;
            default:
                n0 n0Var2 = this.f4253b.f4258b;
                this.f4256e.getClass();
                break;
        }
    }
}
