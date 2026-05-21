package P;

import android.R;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import okhttp3.internal.http2.Http2;
import org.conscrypt.PSKKeyManager;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: e, reason: collision with root package name */
    public static final h f2046e;

    /* renamed from: f, reason: collision with root package name */
    public static final h f2047f;
    public static final h g;
    public static final h h;

    /* renamed from: i, reason: collision with root package name */
    public static final h f2048i;

    /* renamed from: j, reason: collision with root package name */
    public static final h f2049j;

    /* renamed from: k, reason: collision with root package name */
    public static final h f2050k;

    /* renamed from: l, reason: collision with root package name */
    public static final h f2051l;

    /* renamed from: m, reason: collision with root package name */
    public static final h f2052m;

    /* renamed from: a, reason: collision with root package name */
    public final Object f2053a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2054b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f2055c;

    /* renamed from: d, reason: collision with root package name */
    public final u f2056d;

    static {
        new h(1);
        new h(2);
        new h(4);
        new h(8);
        f2046e = new h(16);
        new h(32);
        new h(64);
        new h(128);
        new h(PSKKeyManager.MAX_KEY_LENGTH_BYTES, n.class);
        new h(512, n.class);
        new h(1024, o.class);
        new h(2048, o.class);
        f2047f = new h(4096);
        g = new h(8192);
        new h(Http2.INITIAL_MAX_FRAME_SIZE);
        new h(32768);
        new h(65536);
        new h(131072, s.class);
        h = new h(262144);
        f2048i = new h(524288);
        f2049j = new h(1048576);
        new h(2097152, t.class);
        int i5 = Build.VERSION.SDK_INT;
        new h(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
        new h(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, q.class);
        f2050k = new h(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
        new h(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
        f2051l = new h(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
        new h(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
        new h(i5 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
        new h(i5 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
        new h(i5 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
        new h(i5 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
        new h(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
        f2052m = new h(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, r.class);
        new h(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, R.id.accessibilityActionMoveWindow, null, null, p.class);
        new h(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, R.id.accessibilityActionShowTooltip, null, null, null);
        new h(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, R.id.accessibilityActionHideTooltip, null, null, null);
        new h(i5 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
        new h(i5 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
        new h(i5 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
        new h(i5 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
        new h(i5 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
        new h(i5 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
    }

    public h(int i5) {
        this(null, i5, null, null, null);
    }

    public final int a() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.f2053a).getId();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof h)) {
            return false;
        }
        Object obj2 = ((h) obj).f2053a;
        Object obj3 = this.f2053a;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f2053a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public h(int i5, Class cls) {
        this(null, i5, null, null, cls);
    }

    public h(Object obj, int i5, String str, u uVar, Class cls) {
        this.f2054b = i5;
        this.f2056d = uVar;
        if (obj == null) {
            this.f2053a = new AccessibilityNodeInfo.AccessibilityAction(i5, str);
        } else {
            this.f2053a = obj;
        }
        this.f2055c = cls;
    }
}
