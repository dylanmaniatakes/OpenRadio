package O;

import J1.P0;
import android.os.Build;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    public r0 f1965a;

    public s0(int i5, DecelerateInterpolator decelerateInterpolator, long j5) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f1965a = new q0(P0.l(i5, decelerateInterpolator, j5));
        } else {
            this.f1965a = new o0(i5, decelerateInterpolator, j5);
        }
    }
}
