package O;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;

/* renamed from: O.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0154b {
    public static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
        return accessibilityDelegate.getAccessibilityNodeProvider(view);
    }

    public static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i5, Bundle bundle) {
        return accessibilityDelegate.performAccessibilityAction(view, i5, bundle);
    }
}
