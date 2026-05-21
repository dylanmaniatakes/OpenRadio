package f;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class r {
    public static OnBackInvokedDispatcher a(Activity activity) {
        return activity.getOnBackInvokedDispatcher();
    }

    public static OnBackInvokedCallback b(Object obj, x xVar) {
        Objects.requireNonNull(xVar);
        androidx.activity.o oVar = new androidx.activity.o(1, xVar);
        P.f.e(obj).registerOnBackInvokedCallback(1000000, oVar);
        return oVar;
    }

    public static void c(Object obj, Object obj2) {
        P.f.e(obj).unregisterOnBackInvokedCallback(P.f.b(obj2));
    }
}
