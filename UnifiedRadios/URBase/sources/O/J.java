package O;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public abstract class J {
    public static int a(View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static boolean b(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean c(View view) {
        return view.isLaidOut();
    }

    public static boolean d(View view) {
        return view.isLayoutDirectionResolved();
    }

    public static void e(ViewParent viewParent, View view, View view2, int i5) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i5);
    }

    public static void f(View view, int i5) {
        view.setAccessibilityLiveRegion(i5);
    }

    public static void g(AccessibilityEvent accessibilityEvent, int i5) {
        accessibilityEvent.setContentChangeTypes(i5);
    }
}
