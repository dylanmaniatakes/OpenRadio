package J0;

import C0.t;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f694a;

    static {
        String strF = t.f("NetworkStateTracker");
        F3.i.e(strF, "tagWithPrefix(\"NetworkStateTracker\")");
        f694a = strF;
    }

    public static final H0.d a(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilitiesA;
        F3.i.f(connectivityManager, "<this>");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z4 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        try {
            networkCapabilitiesA = M0.h.a(connectivityManager, M0.i.a(connectivityManager));
        } catch (SecurityException e5) {
            t.d().c(f694a, "Unable to validate active network", e5);
        }
        boolean zB = networkCapabilitiesA != null ? M0.h.b(networkCapabilitiesA, 16) : false;
        return new H0.d(z4, zB, J.a.a(connectivityManager), (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) ? false : true);
    }
}
