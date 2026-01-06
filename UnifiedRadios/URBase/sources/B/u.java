package B;

import J1.C0104s0;
import J1.C0113v0;
import J1.G0;
import J1.Z;
import android.content.Context;
import android.os.Bundle;
import q1.E;
import u1.C0906a;

/* loaded from: classes.dex */
public abstract class u implements G0 {

    /* renamed from: c, reason: collision with root package name */
    public Object f84c;

    public u(C0113v0 c0113v0) {
        E.i(c0113v0);
        this.f84c = c0113v0;
    }

    @Override // J1.G0
    public O2.e a() {
        throw null;
    }

    @Override // J1.G0
    public Z c() {
        throw null;
    }

    @Override // J1.G0
    public Context d() {
        throw null;
    }

    @Override // J1.G0
    public C0104s0 e() {
        throw null;
    }

    @Override // J1.G0
    public C0906a f() {
        throw null;
    }

    public void g(Bundle bundle) {
        bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", i());
    }

    public abstract void h(L0.i iVar);

    public abstract String i();

    public void j() {
        C0104s0 c0104s0 = ((C0113v0) this.f84c).f1418l;
        C0113v0.k(c0104s0);
        c0104s0.j();
    }
}
