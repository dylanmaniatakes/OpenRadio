package u0;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f9881a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f9882b;

    public b(e eVar, d dVar) {
        this.f9882b = eVar;
        this.f9881a = dVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        e eVar = this.f9882b;
        eVar.getClass();
        d dVar = this.f9881a;
        e.d(fFloatValue, dVar);
        eVar.a(fFloatValue, dVar, false);
        eVar.invalidateSelf();
    }
}
