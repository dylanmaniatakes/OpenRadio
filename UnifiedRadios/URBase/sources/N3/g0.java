package N3;

import w3.InterfaceC0941i;

/* loaded from: classes.dex */
public final class g0 extends AbstractC0143q {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f1850l = 0;

    static {
        new g0();
    }

    @Override // N3.AbstractC0143q
    public final void W(InterfaceC0941i interfaceC0941i, Runnable runnable) {
        j0 j0Var = (j0) interfaceC0941i.o(j0.f1852l);
        if (j0Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        j0Var.f1853k = true;
    }

    @Override // N3.AbstractC0143q
    public final String toString() {
        return "Dispatchers.Unconfined";
    }
}
