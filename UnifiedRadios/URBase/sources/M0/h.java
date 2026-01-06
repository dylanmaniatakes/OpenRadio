package M0;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* loaded from: classes.dex */
public abstract class h {
    public static final NetworkCapabilities a(ConnectivityManager connectivityManager, Network network) {
        F3.i.f(connectivityManager, "<this>");
        return connectivityManager.getNetworkCapabilities(network);
    }

    public static final boolean b(NetworkCapabilities networkCapabilities, int i5) {
        F3.i.f(networkCapabilities, "<this>");
        return networkCapabilities.hasCapability(i5);
    }

    public static final void c(ConnectivityManager connectivityManager, ConnectivityManager.NetworkCallback networkCallback) {
        F3.i.f(connectivityManager, "<this>");
        F3.i.f(networkCallback, "networkCallback");
        connectivityManager.unregisterNetworkCallback(networkCallback);
    }
}
