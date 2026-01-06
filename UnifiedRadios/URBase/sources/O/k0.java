package O;

import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public abstract class k0 {
    public static void a(Window window, boolean z4) {
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z4 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
    }
}
