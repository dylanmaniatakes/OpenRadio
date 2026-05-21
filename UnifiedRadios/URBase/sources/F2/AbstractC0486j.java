package f2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* renamed from: f2.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0486j extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6503a;

    /* renamed from: b, reason: collision with root package name */
    public float f6504b;

    /* renamed from: c, reason: collision with root package name */
    public float f6505c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractC0487k f6506d;

    public AbstractC0486j(C0489m c0489m) {
        this.f6506d = c0489m;
    }

    public abstract float a();

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        float f5 = (int) this.f6505c;
        n2.h hVar = this.f6506d.f6518b;
        if (hVar != null) {
            hVar.k(f5);
        }
        this.f6503a = false;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        boolean z4 = this.f6503a;
        AbstractC0487k abstractC0487k = this.f6506d;
        if (!z4) {
            n2.h hVar = abstractC0487k.f6518b;
            this.f6504b = hVar == null ? BitmapDescriptorFactory.HUE_RED : hVar.f8806c.n;
            this.f6505c = a();
            this.f6503a = true;
        }
        float f5 = this.f6504b;
        float animatedFraction = (int) ((valueAnimator.getAnimatedFraction() * (this.f6505c - f5)) + f5);
        n2.h hVar2 = abstractC0487k.f6518b;
        if (hVar2 != null) {
            hVar2.k(animatedFraction);
        }
    }
}
