package J0;

import C0.t;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* loaded from: classes.dex */
public final class h extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f692a;

    public h(i iVar) {
        this.f692a = iVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        F3.i.f(network, "network");
        F3.i.f(networkCapabilities, "capabilities");
        t.d().a(j.f694a, "Network capabilities changed: " + networkCapabilities);
        i iVar = this.f692a;
        iVar.b(j.a(iVar.f693f));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        F3.i.f(network, "network");
        t.d().a(j.f694a, "Network connection lost");
        i iVar = this.f692a;
        iVar.b(j.a(iVar.f693f));
    }
}
