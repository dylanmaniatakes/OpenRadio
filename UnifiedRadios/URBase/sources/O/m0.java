package O;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import java.util.Collections;

/* loaded from: classes.dex */
public final class m0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0 f1937a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ F0 f1938b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ F0 f1939c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1940d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View f1941e;

    public m0(s0 s0Var, F0 f02, F0 f03, int i5, View view) {
        this.f1937a = s0Var;
        this.f1938b = f02;
        this.f1939c = f03;
        this.f1940d = i5;
        this.f1941e = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        s0 s0Var = this.f1937a;
        s0Var.f1965a.d(animatedFraction);
        float fB = s0Var.f1965a.b();
        int i5 = Build.VERSION.SDK_INT;
        F0 f02 = this.f1938b;
        x0 w0Var = i5 >= 30 ? new w0(f02) : i5 >= 29 ? new v0(f02) : new u0(f02);
        for (int i6 = 1; i6 <= 256; i6 <<= 1) {
            if ((this.f1940d & i6) == 0) {
                w0Var.c(i6, f02.f1894a.f(i6));
            } else {
                E.c cVarF = f02.f1894a.f(i6);
                E.c cVarF2 = this.f1939c.f1894a.f(i6);
                float f5 = 1.0f - fB;
                w0Var.c(i6, F0.e(cVarF, (int) (((cVarF.f419a - cVarF2.f419a) * f5) + 0.5d), (int) (((cVarF.f420b - cVarF2.f420b) * f5) + 0.5d), (int) (((cVarF.f421c - cVarF2.f421c) * f5) + 0.5d), (int) (((cVarF.f422d - cVarF2.f422d) * f5) + 0.5d)));
            }
        }
        o0.g(this.f1941e, w0Var.b(), Collections.singletonList(s0Var));
    }
}
