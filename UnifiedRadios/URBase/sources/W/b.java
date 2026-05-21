package W;

import J1.C;
import J1.D;
import O.C0156c;
import O.G;
import O.Y;
import P.j;
import P.m;
import Z3.g;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.WeakHashMap;
import org.conscrypt.PSKKeyManager;

/* loaded from: classes.dex */
public abstract class b extends C0156c {
    public static final Rect n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: o, reason: collision with root package name */
    public static final C f2538o = new C(17);

    /* renamed from: p, reason: collision with root package name */
    public static final D f2539p = new D(17);
    public final AccessibilityManager h;

    /* renamed from: i, reason: collision with root package name */
    public final View f2543i;

    /* renamed from: j, reason: collision with root package name */
    public a f2544j;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f2540d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    public final Rect f2541e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    public final Rect f2542f = new Rect();
    public final int[] g = new int[2];

    /* renamed from: k, reason: collision with root package name */
    public int f2545k = Integer.MIN_VALUE;

    /* renamed from: l, reason: collision with root package name */
    public int f2546l = Integer.MIN_VALUE;

    /* renamed from: m, reason: collision with root package name */
    public int f2547m = Integer.MIN_VALUE;

    public b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f2543i = view;
        this.h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        WeakHashMap weakHashMap = Y.f1904a;
        if (G.c(view) == 0) {
            G.s(view, 1);
        }
    }

    @Override // O.C0156c
    public final g b(View view) {
        if (this.f2544j == null) {
            this.f2544j = new a(this);
        }
        return this.f2544j;
    }

    @Override // O.C0156c
    public final void d(View view, j jVar) {
        this.f1912a.onInitializeAccessibilityNodeInfo(view, jVar.f2058a);
        t(jVar);
    }

    public final boolean j(int i5) {
        if (this.f2546l != i5) {
            return false;
        }
        this.f2546l = Integer.MIN_VALUE;
        v(i5, false);
        x(i5, 8);
        return true;
    }

    public final AccessibilityEvent k(int i5, int i6) {
        View view = this.f2543i;
        if (i5 == -1) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i6);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
            return accessibilityEventObtain;
        }
        AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain(i6);
        j jVarR = r(i5);
        accessibilityEventObtain2.getText().add(jVarR.e());
        AccessibilityNodeInfo accessibilityNodeInfo = jVarR.f2058a;
        accessibilityEventObtain2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        accessibilityEventObtain2.setScrollable(accessibilityNodeInfo.isScrollable());
        accessibilityEventObtain2.setPassword(accessibilityNodeInfo.isPassword());
        accessibilityEventObtain2.setEnabled(accessibilityNodeInfo.isEnabled());
        accessibilityEventObtain2.setChecked(accessibilityNodeInfo.isChecked());
        if (accessibilityEventObtain2.getText().isEmpty() && accessibilityEventObtain2.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain2.setClassName(accessibilityNodeInfo.getClassName());
        m.a(accessibilityEventObtain2, view, i5);
        accessibilityEventObtain2.setPackageName(view.getContext().getPackageName());
        return accessibilityEventObtain2;
    }

    public final j l(int i5) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
        j jVar = new j(accessibilityNodeInfoObtain);
        accessibilityNodeInfoObtain.setEnabled(true);
        accessibilityNodeInfoObtain.setFocusable(true);
        jVar.f("android.view.View");
        Rect rect = n;
        accessibilityNodeInfoObtain.setBoundsInParent(rect);
        accessibilityNodeInfoObtain.setBoundsInScreen(rect);
        jVar.f2059b = -1;
        View view = this.f2543i;
        accessibilityNodeInfoObtain.setParent(view);
        u(i5, jVar);
        if (jVar.e() == null && accessibilityNodeInfoObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.f2541e;
        jVar.d(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = accessibilityNodeInfoObtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoObtain.setPackageName(view.getContext().getPackageName());
        jVar.f2060c = i5;
        accessibilityNodeInfoObtain.setSource(view, i5);
        if (this.f2545k == i5) {
            accessibilityNodeInfoObtain.setAccessibilityFocused(true);
            jVar.a(128);
        } else {
            accessibilityNodeInfoObtain.setAccessibilityFocused(false);
            jVar.a(64);
        }
        boolean z4 = this.f2546l == i5;
        if (z4) {
            jVar.a(2);
        } else if (accessibilityNodeInfoObtain.isFocusable()) {
            jVar.a(1);
        }
        accessibilityNodeInfoObtain.setFocused(z4);
        int[] iArr = this.g;
        view.getLocationOnScreen(iArr);
        Rect rect3 = this.f2540d;
        accessibilityNodeInfoObtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            jVar.d(rect3);
            if (jVar.f2059b != -1) {
                j jVar2 = new j(AccessibilityNodeInfo.obtain());
                int i6 = jVar.f2059b;
                while (true) {
                    accessibilityNodeInfo = jVar2.f2058a;
                    if (i6 == -1) {
                        break;
                    }
                    jVar2.f2059b = -1;
                    accessibilityNodeInfo.setParent(view, -1);
                    accessibilityNodeInfo.setBoundsInParent(rect);
                    u(i6, jVar2);
                    jVar2.d(rect2);
                    rect3.offset(rect2.left, rect2.top);
                    i6 = jVar2.f2059b;
                }
                accessibilityNodeInfo.recycle();
            }
            rect3.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
        }
        Rect rect4 = this.f2542f;
        if (view.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - view.getScrollX(), iArr[1] - view.getScrollY());
            if (rect3.intersect(rect4)) {
                jVar.f2058a.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && view.getWindowVisibility() == 0) {
                    Object parent = view.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view2 = (View) parent;
                            if (view2.getAlpha() <= BitmapDescriptorFactory.HUE_RED || view2.getVisibility() != 0) {
                                break;
                            }
                            parent = view2.getParent();
                        } else if (parent != null) {
                            accessibilityNodeInfoObtain.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return jVar;
    }

    public final boolean m(MotionEvent motionEvent) {
        int i5;
        AccessibilityManager accessibilityManager = this.h;
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iN = n(motionEvent.getX(), motionEvent.getY());
            int i6 = this.f2547m;
            if (i6 != iN) {
                this.f2547m = iN;
                x(iN, 128);
                x(i6, PSKKeyManager.MAX_KEY_LENGTH_BYTES);
            }
            return iN != Integer.MIN_VALUE;
        }
        if (action != 10 || (i5 = this.f2547m) == Integer.MIN_VALUE) {
            return false;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.f2547m = Integer.MIN_VALUE;
            x(i5, PSKKeyManager.MAX_KEY_LENGTH_BYTES);
        }
        return true;
    }

    public abstract int n(float f5, float f6);

    public abstract void o(ArrayList arrayList);

    public final void p(int i5) {
        View view;
        ViewParent parent;
        if (i5 == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = (view = this.f2543i).getParent()) == null) {
            return;
        }
        AccessibilityEvent accessibilityEventK = k(i5, 2048);
        P.b.b(accessibilityEventK, 0);
        parent.requestSendAccessibilityEvent(view, accessibilityEventK);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(int r20, android.graphics.Rect r21) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W.b.q(int, android.graphics.Rect):boolean");
    }

    public final j r(int i5) {
        if (i5 != -1) {
            return l(i5);
        }
        View view = this.f2543i;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(view);
        j jVar = new j(accessibilityNodeInfoObtain);
        WeakHashMap weakHashMap = Y.f1904a;
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
        ArrayList arrayList = new ArrayList();
        o(arrayList);
        if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            jVar.f2058a.addChild(view, ((Integer) arrayList.get(i6)).intValue());
        }
        return jVar;
    }

    public abstract boolean s(int i5, int i6, Bundle bundle);

    public void t(j jVar) {
    }

    public abstract void u(int i5, j jVar);

    public void v(int i5, boolean z4) {
    }

    public final boolean w(int i5) {
        int i6;
        View view = this.f2543i;
        if ((!view.isFocused() && !view.requestFocus()) || (i6 = this.f2546l) == i5) {
            return false;
        }
        if (i6 != Integer.MIN_VALUE) {
            j(i6);
        }
        if (i5 == Integer.MIN_VALUE) {
            return false;
        }
        this.f2546l = i5;
        v(i5, true);
        x(i5, 8);
        return true;
    }

    public final void x(int i5, int i6) {
        View view;
        ViewParent parent;
        if (i5 == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = (view = this.f2543i).getParent()) == null) {
            return;
        }
        parent.requestSendAccessibilityEvent(view, k(i5, i6));
    }
}
