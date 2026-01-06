package M0;

import android.net.ConnectivityManager;
import android.net.Network;

/* loaded from: classes.dex */
public abstract class i {
    public static final Network a(ConnectivityManager connectivityManager) {
        F3.i.f(connectivityManager, "<this>");
        return connectivityManager.getActiveNetwork();
    }
}
