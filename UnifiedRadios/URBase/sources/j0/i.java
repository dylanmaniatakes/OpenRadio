package J0;

import C0.t;
import android.content.Context;
import android.net.ConnectivityManager;

/* loaded from: classes.dex */
public final class i extends f {

    /* renamed from: f, reason: collision with root package name */
    public final ConnectivityManager f693f;
    public final h g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, L0.i iVar) {
        super(context, iVar);
        F3.i.f(iVar, "taskExecutor");
        Object systemService = this.f687b.getSystemService("connectivity");
        F3.i.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f693f = (ConnectivityManager) systemService;
        this.g = new h(this);
    }

    @Override // J0.f
    public final Object a() {
        return j.a(this.f693f);
    }

    @Override // J0.f
    public final void c() {
        try {
            t.d().a(j.f694a, "Registering network callback");
            M0.j.a(this.f693f, this.g);
        } catch (IllegalArgumentException e5) {
            t.d().c(j.f694a, "Received exception while registering network callback", e5);
        } catch (SecurityException e6) {
            t.d().c(j.f694a, "Received exception while registering network callback", e6);
        }
    }

    @Override // J0.f
    public final void d() {
        try {
            t.d().a(j.f694a, "Unregistering network callback");
            M0.h.c(this.f693f, this.g);
        } catch (IllegalArgumentException e5) {
            t.d().c(j.f694a, "Received exception while unregistering network callback", e5);
        } catch (SecurityException e6) {
            t.d().c(j.f694a, "Received exception while unregistering network callback", e6);
        }
    }
}
