package q2;

import a0.C0204a;
import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9434a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f9435b;

    public /* synthetic */ b(i iVar, int i5, byte b5) {
        this.f9434a = i5;
        this.f9435b = iVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        i iVar = this.f9435b;
        switch (this.f9434a) {
            case 0:
                iVar.f9462i.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 1:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                iVar.f9462i.setScaleX(fFloatValue);
                iVar.f9462i.setScaleY(fFloatValue);
                break;
            case 2:
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                C0204a c0204a = i.f9452w;
                iVar.f9462i.setTranslationY(iIntValue);
                break;
            default:
                int iIntValue2 = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                C0204a c0204a2 = i.f9452w;
                iVar.f9462i.setTranslationY(iIntValue2);
                break;
        }
    }

    public b(i iVar, int i5) {
        this.f9434a = 2;
        this.f9435b = iVar;
    }
}
