package i2;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f7193a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f7194b;

    public a(c cVar, float f5) {
        this.f7194b = cVar;
        this.f7193a = f5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f7194b.e(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f7193a);
    }
}
