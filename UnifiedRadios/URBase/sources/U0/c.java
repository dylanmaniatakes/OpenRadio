package u0;

import android.animation.Animator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public final class c implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f9883a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f9884b;

    public c(e eVar, d dVar) {
        this.f9884b = eVar;
        this.f9883a = dVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        e eVar = this.f9884b;
        d dVar = this.f9883a;
        eVar.a(1.0f, dVar, true);
        dVar.f9893k = dVar.f9889e;
        dVar.f9894l = dVar.f9890f;
        dVar.f9895m = dVar.g;
        dVar.a((dVar.f9892j + 1) % dVar.f9891i.length);
        if (!eVar.h) {
            eVar.g += 1.0f;
            return;
        }
        eVar.h = false;
        animator.cancel();
        animator.setDuration(1332L);
        animator.start();
        if (dVar.n) {
            dVar.n = false;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f9884b.g = BitmapDescriptorFactory.HUE_RED;
    }
}
