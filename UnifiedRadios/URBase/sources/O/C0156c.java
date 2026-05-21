package O;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import com.unified.ur1.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* renamed from: O.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0156c {

    /* renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f1911c = new View.AccessibilityDelegate();

    /* renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f1912a;

    /* renamed from: b, reason: collision with root package name */
    public final C0152a f1913b;

    public C0156c() {
        this(f1911c);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f1912a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public Z3.g b(View view) {
        AccessibilityNodeProvider accessibilityNodeProviderA = AbstractC0154b.a(this.f1912a, view);
        if (accessibilityNodeProviderA != null) {
            return new Z3.g(accessibilityNodeProviderA);
        }
        return null;
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f1912a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, P.j jVar) {
        this.f1912a.onInitializeAccessibilityNodeInfo(view, jVar.f2058a);
    }

    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.f1912a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f1912a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean g(View view, int i5, Bundle bundle) {
        boolean zB;
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        List listEmptyList = (List) view.getTag(R.id.tag_accessibility_actions);
        if (listEmptyList == null) {
            listEmptyList = Collections.emptyList();
        }
        boolean z4 = false;
        int i6 = 0;
        while (true) {
            if (i6 >= listEmptyList.size()) {
                break;
            }
            P.h hVar = (P.h) listEmptyList.get(i6);
            if (hVar.a() == i5) {
                P.u uVar = hVar.f2056d;
                if (uVar != null) {
                    Class cls = hVar.f2055c;
                    if (cls != null) {
                        try {
                            com.unified.ur1.SatelliteTracker.h.p(cls.getDeclaredConstructor(null).newInstance(null));
                            throw null;
                        } catch (Exception e5) {
                            Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(cls.getName()), e5);
                        }
                    }
                    zB = uVar.d(view);
                }
            } else {
                i6++;
            }
        }
        zB = false;
        if (!zB) {
            zB = AbstractC0154b.b(this.f1912a, view, i5, bundle);
        }
        if (zB || i5 != R.id.accessibility_action_clickable_span || bundle == null) {
            return zB;
        }
        int i7 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i7)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
            CharSequence text = view.createAccessibilityNodeInfo().getText();
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            int i8 = 0;
            while (true) {
                if (clickableSpanArr == null || i8 >= clickableSpanArr.length) {
                    break;
                }
                if (clickableSpan.equals(clickableSpanArr[i8])) {
                    clickableSpan.onClick(view);
                    z4 = true;
                    break;
                }
                i8++;
            }
        }
        return z4;
    }

    public void h(View view, int i5) {
        this.f1912a.sendAccessibilityEvent(view, i5);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.f1912a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C0156c(View.AccessibilityDelegate accessibilityDelegate) {
        this.f1912a = accessibilityDelegate;
        this.f1913b = new C0152a(this);
    }
}
