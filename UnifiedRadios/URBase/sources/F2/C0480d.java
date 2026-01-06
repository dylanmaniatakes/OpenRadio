package f2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* renamed from: f2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0480d extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6485a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f6486b = false;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0487k f6487c;

    public C0480d(AbstractC0487k abstractC0487k) {
        this.f6487c = abstractC0487k;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f6485a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        AbstractC0487k abstractC0487k = this.f6487c;
        abstractC0487k.f6531r = 0;
        abstractC0487k.f6526l = null;
        if (this.f6485a) {
            return;
        }
        FloatingActionButton floatingActionButton = abstractC0487k.f6532s;
        boolean z4 = this.f6486b;
        floatingActionButton.a(z4 ? 8 : 4, z4);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        AbstractC0487k abstractC0487k = this.f6487c;
        abstractC0487k.f6532s.a(0, this.f6486b);
        abstractC0487k.f6531r = 1;
        abstractC0487k.f6526l = animator;
        this.f6485a = false;
    }
}
