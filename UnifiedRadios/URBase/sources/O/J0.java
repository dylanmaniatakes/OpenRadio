package O;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* loaded from: classes.dex */
public final class J0 {

    /* renamed from: a, reason: collision with root package name */
    public final L0.f f1899a;

    public J0(WindowInsetsController windowInsetsController) {
        this.f1899a = new I0(windowInsetsController);
    }

    public J0(Window window, View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            I0 i02 = new I0(window.getInsetsController());
            i02.f1898b = window;
            this.f1899a = i02;
            return;
        }
        this.f1899a = new G0(window, view);
    }
}
