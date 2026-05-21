package O;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import com.unified.ur1.R;

/* loaded from: classes.dex */
public abstract class M {
    public static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static F0 b(View view, F0 f02, Rect rect) {
        WindowInsets windowInsetsF = f02.f();
        if (windowInsetsF != null) {
            return F0.g(view, view.computeSystemWindowInsets(windowInsetsF, rect));
        }
        rect.setEmpty();
        return f02;
    }

    public static boolean c(View view, float f5, float f6, boolean z4) {
        return view.dispatchNestedFling(f5, f6, z4);
    }

    public static boolean d(View view, float f5, float f6) {
        return view.dispatchNestedPreFling(f5, f6);
    }

    public static boolean e(View view, int i5, int i6, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i5, i6, iArr, iArr2);
    }

    public static boolean f(View view, int i5, int i6, int i7, int i8, int[] iArr) {
        return view.dispatchNestedScroll(i5, i6, i7, i8, iArr);
    }

    public static ColorStateList g(View view) {
        return view.getBackgroundTintList();
    }

    public static PorterDuff.Mode h(View view) {
        return view.getBackgroundTintMode();
    }

    public static float i(View view) {
        return view.getElevation();
    }

    public static F0 j(View view) throws IllegalAccessException, IllegalArgumentException {
        if (!t0.f1969d || !view.isAttachedToWindow()) {
            return null;
        }
        try {
            Object obj = t0.f1966a.get(view.getRootView());
            if (obj == null) {
                return null;
            }
            Rect rect = (Rect) t0.f1967b.get(obj);
            Rect rect2 = (Rect) t0.f1968c.get(obj);
            if (rect == null || rect2 == null) {
                return null;
            }
            int i5 = Build.VERSION.SDK_INT;
            x0 w0Var = i5 >= 30 ? new w0() : i5 >= 29 ? new v0() : new u0();
            w0Var.e(E.c.b(rect.left, rect.top, rect.right, rect.bottom));
            w0Var.g(E.c.b(rect2.left, rect2.top, rect2.right, rect2.bottom));
            F0 f0B = w0Var.b();
            f0B.f1894a.p(f0B);
            f0B.f1894a.d(view.getRootView());
            return f0B;
        } catch (IllegalAccessException e5) {
            Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e5.getMessage(), e5);
            return null;
        }
    }

    public static String k(View view) {
        return view.getTransitionName();
    }

    public static float l(View view) {
        return view.getTranslationZ();
    }

    public static float m(View view) {
        return view.getZ();
    }

    public static boolean n(View view) {
        return view.hasNestedScrollingParent();
    }

    public static boolean o(View view) {
        return view.isImportantForAccessibility();
    }

    public static boolean p(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void q(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void r(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void s(View view, float f5) {
        view.setElevation(f5);
    }

    public static void t(View view, boolean z4) {
        view.setNestedScrollingEnabled(z4);
    }

    public static void u(View view, InterfaceC0183w interfaceC0183w) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, interfaceC0183w);
        }
        if (interfaceC0183w == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new L(view, interfaceC0183w));
        }
    }

    public static void v(View view, String str) {
        view.setTransitionName(str);
    }

    public static void w(View view, float f5) {
        view.setTranslationZ(f5);
    }

    public static void x(View view, float f5) {
        view.setZ(f5);
    }

    public static boolean y(View view, int i5) {
        return view.startNestedScroll(i5);
    }

    public static void z(View view) {
        view.stopNestedScroll();
    }
}
