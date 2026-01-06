package O;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.unified.ur1.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class Y {

    /* renamed from: a, reason: collision with root package name */
    public static WeakHashMap f1904a;

    /* renamed from: b, reason: collision with root package name */
    public static Field f1905b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f1906c;

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f1907d;

    /* renamed from: e, reason: collision with root package name */
    public static final B f1908e;

    /* renamed from: f, reason: collision with root package name */
    public static final D f1909f;

    static {
        new AtomicInteger(1);
        f1904a = null;
        f1906c = false;
        f1907d = new int[]{R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
        f1908e = new B();
        f1909f = new D();
    }

    public static C0169i0 a(View view) {
        if (f1904a == null) {
            f1904a = new WeakHashMap();
        }
        C0169i0 c0169i0 = (C0169i0) f1904a.get(view);
        if (c0169i0 != null) {
            return c0169i0;
        }
        C0169i0 c0169i02 = new C0169i0(view);
        f1904a.put(view, c0169i02);
        return c0169i02;
    }

    public static View.AccessibilityDelegate b(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return T.a(view);
        }
        if (f1906c) {
            return null;
        }
        if (f1905b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f1905b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f1906c = true;
                return null;
            }
        }
        try {
            Object obj = f1905b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f1906c = true;
            return null;
        }
    }

    public static CharSequence c(View view) {
        return S.b(view);
    }

    public static ArrayList d(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static String[] e(View view) {
        return Build.VERSION.SDK_INT >= 31 ? V.a(view) : (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void f(View view, int i5) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z4 = c(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (J.a(view) != 0 || z4) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z4 ? 32 : 2048);
                J.g(accessibilityEventObtain, i5);
                if (z4) {
                    accessibilityEventObtain.getText().add(c(view));
                    if (G.c(view) == 0) {
                        G.s(view, 1);
                    }
                    ViewParent parent = view.getParent();
                    while (true) {
                        if (!(parent instanceof View)) {
                            break;
                        }
                        if (G.c((View) parent) == 4) {
                            G.s(view, 2);
                            break;
                        }
                        parent = parent.getParent();
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i5 != 32) {
                if (view.getParent() != null) {
                    try {
                        J.e(view.getParent(), view, view, i5);
                        return;
                    } catch (AbstractMethodError e5) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e5);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            J.g(accessibilityEventObtain2, i5);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(c(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static C0164g g(View view, C0164g c0164g) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + c0164g + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return V.b(view, c0164g);
        }
        InterfaceC0184x interfaceC0184x = (InterfaceC0184x) view.getTag(R.id.tag_on_receive_content_listener);
        InterfaceC0185y interfaceC0185y = f1908e;
        if (interfaceC0184x == null) {
            if (view instanceof InterfaceC0185y) {
                interfaceC0185y = (InterfaceC0185y) view;
            }
            return interfaceC0185y.a(c0164g);
        }
        C0164g c0164gA = ((S.s) interfaceC0184x).a(view, c0164g);
        if (c0164gA == null) {
            return null;
        }
        if (view instanceof InterfaceC0185y) {
            interfaceC0185y = (InterfaceC0185y) view;
        }
        return interfaceC0185y.a(c0164gA);
    }

    public static void h(View view, int i5) {
        ArrayList arrayListD = d(view);
        for (int i6 = 0; i6 < arrayListD.size(); i6++) {
            if (((P.h) arrayListD.get(i6)).a() == i5) {
                arrayListD.remove(i6);
                return;
            }
        }
    }

    public static void i(View view, P.h hVar, P.u uVar) {
        if (uVar == null) {
            h(view, hVar.a());
            f(view, 0);
            return;
        }
        P.h hVar2 = new P.h(null, hVar.f2054b, null, uVar, hVar.f2055c);
        View.AccessibilityDelegate accessibilityDelegateB = b(view);
        C0156c c0156c = accessibilityDelegateB == null ? null : accessibilityDelegateB instanceof C0152a ? ((C0152a) accessibilityDelegateB).f1910a : new C0156c(accessibilityDelegateB);
        if (c0156c == null) {
            c0156c = new C0156c();
        }
        k(view, c0156c);
        h(view, hVar2.a());
        d(view).add(hVar2);
        f(view, 0);
    }

    public static void j(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i5) {
        if (Build.VERSION.SDK_INT >= 29) {
            T.c(view, context, iArr, attributeSet, typedArray, i5, 0);
        }
    }

    public static void k(View view, C0156c c0156c) {
        if (c0156c == null && (b(view) instanceof C0152a)) {
            c0156c = new C0156c();
        }
        view.setAccessibilityDelegate(c0156c == null ? null : c0156c.f1913b);
    }

    public static void l(View view, CharSequence charSequence) {
        new C(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).e(view, charSequence);
        D d5 = f1909f;
        if (charSequence == null) {
            d5.f1886c.remove(view);
            view.removeOnAttachStateChangeListener(d5);
            G.o(view.getViewTreeObserver(), d5);
        } else {
            d5.f1886c.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(d5);
            if (J.b(view)) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(d5);
            }
        }
    }
}
