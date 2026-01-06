package M0;

import android.net.ConnectivityManager;

/* loaded from: classes.dex */
public abstract class j {
    public static final void a(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
        F3.i.f(connectivityManager, "<this>");
        F3.i.f(networkCallback, "networkCallback");
        connectivityManager.registerDefaultNetworkCallback(networkCallback);
    }
}
