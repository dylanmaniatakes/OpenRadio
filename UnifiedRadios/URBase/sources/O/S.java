package O;

import android.view.View;
import com.unified.ur1.R;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class S {
    public static void a(View view, X x4) {
        q.k kVar = (q.k) view.getTag(R.id.tag_unhandled_key_listeners);
        if (kVar == null) {
            kVar = new q.k();
            view.setTag(R.id.tag_unhandled_key_listeners, kVar);
        }
        Objects.requireNonNull(x4);
        View.OnUnhandledKeyEventListener q4 = new Q();
        kVar.put(x4, q4);
        view.addOnUnhandledKeyEventListener(q4);
    }

    public static CharSequence b(View view) {
        return view.getAccessibilityPaneTitle();
    }

    public static boolean c(View view) {
        return view.isAccessibilityHeading();
    }

    public static boolean d(View view) {
        return view.isScreenReaderFocusable();
    }

    public static void e(View view, X x4) {
        View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
        q.k kVar = (q.k) view.getTag(R.id.tag_unhandled_key_listeners);
        if (kVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) kVar.getOrDefault(x4, null)) == null) {
            return;
        }
        view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
    }

    public static <T> T f(View view, int i5) {
        return (T) view.requireViewById(i5);
    }

    public static void g(View view, boolean z4) {
        view.setAccessibilityHeading(z4);
    }

    public static void h(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    public static void i(View view, boolean z4) {
        view.setScreenReaderFocusable(z4);
    }
}
