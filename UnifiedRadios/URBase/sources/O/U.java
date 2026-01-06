package O;

import android.view.View;
import android.view.WindowInsetsController;

/* loaded from: classes.dex */
public abstract class U {
    public static CharSequence a(View view) {
        return view.getStateDescription();
    }

    public static J0 b(View view) {
        WindowInsetsController windowInsetsController = view.getWindowInsetsController();
        if (windowInsetsController != null) {
            return new J0(windowInsetsController);
        }
        return null;
    }

    public static void c(View view, CharSequence charSequence) {
        view.setStateDescription(charSequence);
    }
}
