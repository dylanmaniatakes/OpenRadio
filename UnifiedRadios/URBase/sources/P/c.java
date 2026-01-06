package P;

import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
public abstract class c {
    public static boolean a(AccessibilityManager accessibilityManager, d dVar) {
        return accessibilityManager.addTouchExplorationStateChangeListener(new e(dVar));
    }

    public static boolean b(AccessibilityManager accessibilityManager, d dVar) {
        return accessibilityManager.removeTouchExplorationStateChangeListener(new e(dVar));
    }
}
