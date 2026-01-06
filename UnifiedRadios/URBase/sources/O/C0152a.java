package O;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.unified.ur1.R;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* renamed from: O.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0152a extends View.AccessibilityDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final C0156c f1910a;

    public C0152a(C0156c c0156c) {
        this.f1910a = c0156c;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.f1910a.a(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        Z3.g gVarB = this.f1910a.b(view);
        if (gVarB != null) {
            return (AccessibilityNodeProvider) gVarB.f3163a;
        }
        return null;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f1910a.c(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        Object tag;
        P.j jVar = new P.j(accessibilityNodeInfo);
        WeakHashMap weakHashMap = Y.f1904a;
        accessibilityNodeInfo.setScreenReaderFocusable(Boolean.valueOf(S.d(view)).booleanValue());
        accessibilityNodeInfo.setHeading(Boolean.valueOf(S.c(view)).booleanValue());
        accessibilityNodeInfo.setPaneTitle(S.b(view));
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            tag = U.a(view);
        } else {
            tag = view.getTag(R.id.tag_state_description);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        CharSequence charSequence = (CharSequence) tag;
        if (i5 >= 30) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
        this.f1910a.d(view, jVar);
        accessibilityNodeInfo.getText();
        List listEmptyList = (List) view.getTag(R.id.tag_accessibility_actions);
        if (listEmptyList == null) {
            listEmptyList = Collections.emptyList();
        }
        for (int i6 = 0; i6 < listEmptyList.size(); i6++) {
            jVar.b((P.h) listEmptyList.get(i6));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f1910a.e(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f1910a.f(viewGroup, view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
        return this.f1910a.g(view, i5, bundle);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEvent(View view, int i5) {
        this.f1910a.h(view, i5);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.f1910a.i(view, accessibilityEvent);
    }
}
