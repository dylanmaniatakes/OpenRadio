package O;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class N {
    public static F0 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        F0 f0G = F0.g(null, rootWindowInsets);
        D0 d02 = f0G.f1894a;
        d02.p(f0G);
        d02.d(view.getRootView());
        return f0G;
    }

    public static int b(View view) {
        return view.getScrollIndicators();
    }

    public static void c(View view, int i5) {
        view.setScrollIndicators(i5);
    }

    public static void d(View view, int i5, int i6) {
        view.setScrollIndicators(i5, i6);
    }
}
