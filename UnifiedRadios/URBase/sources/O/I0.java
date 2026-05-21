package O;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;

/* loaded from: classes.dex */
public final class I0 extends L0.f {

    /* renamed from: a, reason: collision with root package name */
    public final WindowInsetsController f1897a;

    /* renamed from: b, reason: collision with root package name */
    public Window f1898b;

    public I0(WindowInsetsController windowInsetsController) {
        this.f1897a = windowInsetsController;
    }

    @Override // L0.f
    public final void k(boolean z4) {
        Window window = this.f1898b;
        if (z4) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            this.f1897a.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        this.f1897a.setSystemBarsAppearance(0, 16);
    }

    @Override // L0.f
    public final void l(boolean z4) {
        Window window = this.f1898b;
        if (z4) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            }
            this.f1897a.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        this.f1897a.setSystemBarsAppearance(0, 8);
    }

    @Override // L0.f
    public final void m() {
        Window window = this.f1898b;
        if (window != null && Build.VERSION.SDK_INT < 32) {
            ((InputMethodManager) window.getContext().getSystemService("input_method")).isActive();
        }
        this.f1897a.show(8);
    }
}
