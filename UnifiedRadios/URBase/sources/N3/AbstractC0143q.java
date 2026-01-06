package N3;

import w3.AbstractC0933a;
import w3.C0937e;
import w3.C0942j;
import w3.InterfaceC0938f;
import w3.InterfaceC0939g;
import w3.InterfaceC0940h;
import w3.InterfaceC0941i;

/* renamed from: N3.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0143q extends AbstractC0933a implements InterfaceC0938f {

    /* renamed from: k, reason: collision with root package name */
    public static final C0142p f1869k = new C0142p(C0937e.f10142j, C0141o.f1866j);

    public AbstractC0143q() {
        super(C0937e.f10142j);
    }

    @Override // w3.AbstractC0933a, w3.InterfaceC0941i
    public final InterfaceC0941i V(InterfaceC0940h interfaceC0940h) {
        F3.i.f(interfaceC0940h, "key");
        boolean z4 = interfaceC0940h instanceof C0142p;
        C0942j c0942j = C0942j.f10143j;
        if (z4) {
            C0142p c0142p = (C0142p) interfaceC0940h;
            InterfaceC0940h interfaceC0940h2 = this.f10136j;
            F3.i.f(interfaceC0940h2, "key");
            if ((interfaceC0940h2 == c0142p || c0142p.f1868k == interfaceC0940h2) && c0142p.a(this) != null) {
                return c0942j;
            }
        } else if (C0937e.f10142j == interfaceC0940h) {
            return c0942j;
        }
        return this;
    }

    public abstract void W(InterfaceC0941i interfaceC0941i, Runnable runnable);

    public void X(InterfaceC0941i interfaceC0941i, Runnable runnable) {
        W(interfaceC0941i, runnable);
    }

    public boolean Y() {
        return !(this instanceof g0);
    }

    @Override // w3.AbstractC0933a, w3.InterfaceC0941i
    public final InterfaceC0939g o(InterfaceC0940h interfaceC0940h) {
        F3.i.f(interfaceC0940h, "key");
        if (!(interfaceC0940h instanceof C0142p)) {
            if (C0937e.f10142j == interfaceC0940h) {
                return this;
            }
            return null;
        }
        C0142p c0142p = (C0142p) interfaceC0940h;
        InterfaceC0940h interfaceC0940h2 = this.f10136j;
        F3.i.f(interfaceC0940h2, "key");
        if (interfaceC0940h2 != c0142p && c0142p.f1868k != interfaceC0940h2) {
            return null;
        }
        InterfaceC0939g interfaceC0939gA = c0142p.a(this);
        if (interfaceC0939gA instanceof InterfaceC0939g) {
            return interfaceC0939gA;
        }
        return null;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + AbstractC0146u.e(this);
    }
}
