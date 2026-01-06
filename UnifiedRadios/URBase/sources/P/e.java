package P;

import O.G;
import O.Y;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class e implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final d f2045a;

    public e(d dVar) {
        this.f2045a = dVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f2045a.equals(((e) obj).f2045a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2045a.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z4) {
        s2.h hVar = (s2.h) ((D0.p) this.f2045a).f289d;
        AutoCompleteTextView autoCompleteTextView = hVar.h;
        if (autoCompleteTextView == null || Z3.i.g(autoCompleteTextView)) {
            return;
        }
        int i5 = z4 ? 2 : 1;
        WeakHashMap weakHashMap = Y.f1904a;
        G.s(hVar.f9632d, i5);
    }
}
