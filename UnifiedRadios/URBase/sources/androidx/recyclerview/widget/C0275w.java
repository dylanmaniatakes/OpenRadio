package androidx.recyclerview.widget;

import android.animation.ValueAnimator;

/* renamed from: androidx.recyclerview.widget.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0275w implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0276x f4355a;

    public C0275w(C0276x c0276x) {
        this.f4355a = c0276x;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        C0276x c0276x = this.f4355a;
        c0276x.f4367c.setAlpha(iFloatValue);
        c0276x.f4368d.setAlpha(iFloatValue);
        c0276x.f4380s.invalidate();
    }
}
