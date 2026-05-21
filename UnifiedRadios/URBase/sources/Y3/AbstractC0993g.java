package y3;

import w3.C0942j;
import w3.InterfaceC0936d;
import w3.InterfaceC0941i;

/* renamed from: y3.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0993g extends AbstractC0987a {
    public AbstractC0993g(InterfaceC0936d interfaceC0936d) {
        super(interfaceC0936d);
        if (interfaceC0936d != null && interfaceC0936d.getContext() != C0942j.f10143j) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
        }
    }

    @Override // w3.InterfaceC0936d
    public final InterfaceC0941i getContext() {
        return C0942j.f10143j;
    }
}
