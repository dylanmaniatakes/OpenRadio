package l4;

import android.animation.Animator;
import android.animation.ValueAnimator;
import k4.t;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public final class d implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b, reason: collision with root package name */
    public final f f8454b;

    /* renamed from: c, reason: collision with root package name */
    public final Double f8455c;

    /* renamed from: d, reason: collision with root package name */
    public final Double f8456d;

    /* renamed from: e, reason: collision with root package name */
    public final d4.a f8457e;

    /* renamed from: f, reason: collision with root package name */
    public final d4.a f8458f;

    /* renamed from: a, reason: collision with root package name */
    public final k4.d f8453a = new k4.d(0.0d, 0.0d);
    public final Float g = null;
    public final Float h = null;

    public d(f fVar, Double d5, Double d6, k4.d dVar, d4.a aVar, Float f5) {
        this.f8454b = fVar;
        this.f8455c = d5;
        this.f8456d = d6;
        this.f8457e = dVar;
        this.f8458f = aVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f8454b.b();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f8454b.b();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f8454b.f8463a.f9049k.set(true);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        f fVar = this.f8454b;
        Double d5 = this.f8456d;
        if (d5 != null) {
            Double d6 = this.f8455c;
            fVar.f8463a.g(((d5.doubleValue() - d6.doubleValue()) * fFloatValue) + d6.doubleValue());
        }
        Float f5 = this.h;
        if (f5 != null) {
            fVar.f8463a.setMapOrientation((f5.floatValue() * fFloatValue) + this.g.floatValue());
        }
        d4.a aVar = this.f8458f;
        if (aVar != null) {
            MapView mapView = fVar.f8463a;
            t tileSystem = MapView.getTileSystem();
            k4.d dVar = (k4.d) this.f8457e;
            double d7 = dVar.f8264j;
            tileSystem.getClass();
            double dC = t.c(d7);
            k4.d dVar2 = (k4.d) aVar;
            double d8 = fFloatValue;
            double dC2 = t.c(((t.c(dVar2.f8264j) - dC) * d8) + dC);
            double dA = t.a(dVar.f8265k, -85.05112877980658d, 85.05112877980658d);
            double dA2 = t.a(((t.a(dVar2.f8265k, -85.05112877980658d, 85.05112877980658d) - dA) * d8) + dA, -85.05112877980658d, 85.05112877980658d);
            k4.d dVar3 = this.f8453a;
            dVar3.f8265k = dA2;
            dVar3.f8264j = dC2;
            fVar.f8463a.setExpectedCenter(dVar3);
        }
        fVar.f8463a.invalidate();
    }
}
