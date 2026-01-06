package O;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class n0 implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public final V1.e f1944a;

    /* renamed from: b, reason: collision with root package name */
    public F0 f1945b;

    public n0(View view, V1.e eVar) {
        F0 f0B;
        this.f1944a = eVar;
        WeakHashMap weakHashMap = Y.f1904a;
        F0 f0A = N.a(view);
        if (f0A != null) {
            int i5 = Build.VERSION.SDK_INT;
            f0B = (i5 >= 30 ? new w0(f0A) : i5 >= 29 ? new v0(f0A) : new u0(f0A)).b();
        } else {
            f0B = null;
        }
        this.f1945b = f0B;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        D0 d02;
        if (!view.isLaidOut()) {
            this.f1945b = F0.g(view, windowInsets);
            return o0.i(view, windowInsets);
        }
        F0 f0G = F0.g(view, windowInsets);
        if (this.f1945b == null) {
            WeakHashMap weakHashMap = Y.f1904a;
            this.f1945b = N.a(view);
        }
        if (this.f1945b == null) {
            this.f1945b = f0G;
            return o0.i(view, windowInsets);
        }
        V1.e eVarJ = o0.j(view);
        if (eVarJ != null && Objects.equals((WindowInsets) eVarJ.f2531c, windowInsets)) {
            return o0.i(view, windowInsets);
        }
        F0 f02 = this.f1945b;
        int i5 = 1;
        int i6 = 0;
        while (true) {
            d02 = f0G.f1894a;
            if (i5 > 256) {
                break;
            }
            if (!d02.f(i5).equals(f02.f1894a.f(i5))) {
                i6 |= i5;
            }
            i5 <<= 1;
        }
        if (i6 == 0) {
            return o0.i(view, windowInsets);
        }
        F0 f03 = this.f1945b;
        s0 s0Var = new s0(i6, new DecelerateInterpolator(), 160L);
        s0Var.f1965a.d(BitmapDescriptorFactory.HUE_RED);
        ValueAnimator duration = ValueAnimator.ofFloat(BitmapDescriptorFactory.HUE_RED, 1.0f).setDuration(s0Var.f1965a.a());
        E.c cVarF = d02.f(i6);
        E.c cVarF2 = f03.f1894a.f(i6);
        int iMin = Math.min(cVarF.f419a, cVarF2.f419a);
        int i7 = cVarF.f420b;
        int i8 = cVarF2.f420b;
        int iMin2 = Math.min(i7, i8);
        int i9 = cVarF.f421c;
        int i10 = cVarF2.f421c;
        int iMin3 = Math.min(i9, i10);
        int i11 = cVarF.f422d;
        int i12 = i6;
        int i13 = cVarF2.f422d;
        L0.c cVar = new L0.c(8, E.c.b(iMin, iMin2, iMin3, Math.min(i11, i13)), E.c.b(Math.max(cVarF.f419a, cVarF2.f419a), Math.max(i7, i8), Math.max(i9, i10), Math.max(i11, i13)), false);
        o0.f(view, windowInsets, false);
        duration.addUpdateListener(new m0(s0Var, f0G, f03, i12, view));
        duration.addListener(new C0165g0(s0Var, view, 1));
        ViewTreeObserverOnPreDrawListenerC0186z.a(view, new F0.e(view, s0Var, cVar, duration));
        this.f1945b = f0G;
        return o0.i(view, windowInsets);
    }
}
