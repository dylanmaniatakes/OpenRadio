package O;

import android.view.ViewGroup;

/* renamed from: O.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0173l {
    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getLayoutDirection();
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginEnd();
    }

    public static int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginStart();
    }

    public static boolean d(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.isMarginRelative();
    }

    public static void e(ViewGroup.MarginLayoutParams marginLayoutParams, int i5) {
        marginLayoutParams.resolveLayoutDirection(i5);
    }

    public static void f(ViewGroup.MarginLayoutParams marginLayoutParams, int i5) {
        marginLayoutParams.setLayoutDirection(i5);
    }

    public static void g(ViewGroup.MarginLayoutParams marginLayoutParams, int i5) {
        marginLayoutParams.setMarginEnd(i5);
    }

    public static void h(ViewGroup.MarginLayoutParams marginLayoutParams, int i5) {
        marginLayoutParams.setMarginStart(i5);
    }
}
