package w3;

import E3.p;
import java.io.Serializable;

/* renamed from: w3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0935c implements InterfaceC0941i, Serializable {

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC0941i f10140j;

    /* renamed from: k, reason: collision with root package name */
    public final InterfaceC0939g f10141k;

    public C0935c(InterfaceC0939g interfaceC0939g, InterfaceC0941i interfaceC0941i) {
        F3.i.f(interfaceC0941i, "left");
        F3.i.f(interfaceC0939g, "element");
        this.f10140j = interfaceC0941i;
        this.f10141k = interfaceC0939g;
    }

    @Override // w3.InterfaceC0941i
    public final Object D(Object obj, p pVar) {
        return pVar.c(this.f10140j.D(obj, pVar), this.f10141k);
    }

    @Override // w3.InterfaceC0941i
    public final InterfaceC0941i V(InterfaceC0940h interfaceC0940h) {
        F3.i.f(interfaceC0940h, "key");
        InterfaceC0939g interfaceC0939g = this.f10141k;
        InterfaceC0939g interfaceC0939gO = interfaceC0939g.o(interfaceC0940h);
        InterfaceC0941i interfaceC0941i = this.f10140j;
        if (interfaceC0939gO != null) {
            return interfaceC0941i;
        }
        InterfaceC0941i interfaceC0941iV = interfaceC0941i.V(interfaceC0940h);
        return interfaceC0941iV == interfaceC0941i ? this : interfaceC0941iV == C0942j.f10143j ? interfaceC0939g : new C0935c(interfaceC0939g, interfaceC0941iV);
    }

    public final boolean equals(Object obj) {
        boolean zA;
        if (this != obj) {
            if (!(obj instanceof C0935c)) {
                return false;
            }
            C0935c c0935c = (C0935c) obj;
            c0935c.getClass();
            int i5 = 2;
            C0935c c0935c2 = c0935c;
            int i6 = 2;
            while (true) {
                InterfaceC0941i interfaceC0941i = c0935c2.f10140j;
                c0935c2 = interfaceC0941i instanceof C0935c ? (C0935c) interfaceC0941i : null;
                if (c0935c2 == null) {
                    break;
                }
                i6++;
            }
            C0935c c0935c3 = this;
            while (true) {
                InterfaceC0941i interfaceC0941i2 = c0935c3.f10140j;
                c0935c3 = interfaceC0941i2 instanceof C0935c ? (C0935c) interfaceC0941i2 : null;
                if (c0935c3 == null) {
                    break;
                }
                i5++;
            }
            if (i6 != i5) {
                return false;
            }
            C0935c c0935c4 = this;
            while (true) {
                InterfaceC0939g interfaceC0939g = c0935c4.f10141k;
                if (!F3.i.a(c0935c.o(interfaceC0939g.getKey()), interfaceC0939g)) {
                    zA = false;
                    break;
                }
                InterfaceC0941i interfaceC0941i3 = c0935c4.f10140j;
                if (!(interfaceC0941i3 instanceof C0935c)) {
                    F3.i.d(interfaceC0941i3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                    InterfaceC0939g interfaceC0939g2 = (InterfaceC0939g) interfaceC0941i3;
                    zA = F3.i.a(c0935c.o(interfaceC0939g2.getKey()), interfaceC0939g2);
                    break;
                }
                c0935c4 = (C0935c) interfaceC0941i3;
            }
            if (!zA) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.f10141k.hashCode() + this.f10140j.hashCode();
    }

    @Override // w3.InterfaceC0941i
    public final InterfaceC0939g o(InterfaceC0940h interfaceC0940h) {
        F3.i.f(interfaceC0940h, "key");
        C0935c c0935c = this;
        while (true) {
            InterfaceC0939g interfaceC0939gO = c0935c.f10141k.o(interfaceC0940h);
            if (interfaceC0939gO != null) {
                return interfaceC0939gO;
            }
            InterfaceC0941i interfaceC0941i = c0935c.f10140j;
            if (!(interfaceC0941i instanceof C0935c)) {
                return interfaceC0941i.o(interfaceC0940h);
            }
            c0935c = (C0935c) interfaceC0941i;
        }
    }

    public final String toString() {
        return "[" + ((String) D("", C0934b.f10137k)) + ']';
    }

    @Override // w3.InterfaceC0941i
    public final InterfaceC0941i x(InterfaceC0941i interfaceC0941i) {
        F3.i.f(interfaceC0941i, "context");
        return interfaceC0941i == C0942j.f10143j ? this : (InterfaceC0941i) interfaceC0941i.D(this, C0934b.f10138l);
    }
}
