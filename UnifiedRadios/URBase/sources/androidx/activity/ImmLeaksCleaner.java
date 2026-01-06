package androidx.activity;

import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.EnumC0243m;
import androidx.lifecycle.InterfaceC0249t;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements androidx.lifecycle.r {

    /* renamed from: j, reason: collision with root package name */
    public static int f3216j;

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) throws SecurityException {
        if (enumC0243m != EnumC0243m.ON_DESTROY) {
            return;
        }
        if (f3216j == 0) {
            try {
                f3216j = 2;
                InputMethodManager.class.getDeclaredField("mServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mNextServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mH").setAccessible(true);
                f3216j = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (f3216j == 1) {
            throw null;
        }
    }
}
