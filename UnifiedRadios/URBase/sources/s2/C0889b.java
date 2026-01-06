package s2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: s2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0889b extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9579a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0890c f9580b;

    public /* synthetic */ C0889b(C0890c c0890c, int i5) {
        this.f9579a = i5;
        this.f9580b = c0890c;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f9579a) {
            case 1:
                this.f9580b.f9630b.h(false);
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f9579a) {
            case 0:
                this.f9580b.f9630b.h(true);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
