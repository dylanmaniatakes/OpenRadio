package w3;

import E3.p;
import java.io.Serializable;

/* renamed from: w3.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0942j implements InterfaceC0941i, Serializable {

    /* renamed from: j, reason: collision with root package name */
    public static final C0942j f10143j = new C0942j();

    @Override // w3.InterfaceC0941i
    public final Object D(Object obj, p pVar) {
        return obj;
    }

    @Override // w3.InterfaceC0941i
    public final InterfaceC0941i V(InterfaceC0940h interfaceC0940h) {
        F3.i.f(interfaceC0940h, "key");
        return this;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // w3.InterfaceC0941i
    public final InterfaceC0939g o(InterfaceC0940h interfaceC0940h) {
        F3.i.f(interfaceC0940h, "key");
        return null;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // w3.InterfaceC0941i
    public final InterfaceC0941i x(InterfaceC0941i interfaceC0941i) {
        F3.i.f(interfaceC0941i, "context");
        return interfaceC0941i;
    }
}
