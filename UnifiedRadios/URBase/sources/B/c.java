package B;

import android.app.Activity;
import android.app.SharedElementCallback;

/* loaded from: classes.dex */
public abstract class c {
    public static void a(Object obj) {
        ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
    }

    public static void b(Activity activity, String[] strArr, int i5) {
        activity.requestPermissions(strArr, i5);
    }

    public static boolean c(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
