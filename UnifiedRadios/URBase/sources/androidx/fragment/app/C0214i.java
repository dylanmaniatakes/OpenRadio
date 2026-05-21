package androidx.fragment.app;

import android.transition.Transition;

/* renamed from: androidx.fragment.app.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0214i extends AbstractC0213h {

    /* renamed from: c, reason: collision with root package name */
    public final Object f3816c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f3817d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f3818e;

    public C0214i(p0 p0Var, K.d dVar, boolean z4, boolean z5) {
        super(p0Var, dVar);
        int i5 = p0Var.f3858a;
        Fragment fragment = p0Var.f3860c;
        if (i5 == 2) {
            this.f3816c = z4 ? fragment.getReenterTransition() : fragment.getEnterTransition();
            this.f3817d = z4 ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        } else {
            this.f3816c = z4 ? fragment.getReturnTransition() : fragment.getExitTransition();
            this.f3817d = true;
        }
        if (!z5) {
            this.f3818e = null;
        } else if (z4) {
            this.f3818e = fragment.getSharedElementReturnTransition();
        } else {
            this.f3818e = fragment.getSharedElementEnterTransition();
        }
    }

    public final l0 c(Object obj) {
        if (obj == null) {
            return null;
        }
        j0 j0Var = e0.f3796a;
        if (obj instanceof Transition) {
            return j0Var;
        }
        l0 l0Var = e0.f3797b;
        if (l0Var != null && l0Var.e(obj)) {
            return l0Var;
        }
        throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.f3808a.f3860c + " is not a valid framework Transition or AndroidX Transition");
    }
}
