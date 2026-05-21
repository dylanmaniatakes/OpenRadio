package w3;

import E3.p;

/* renamed from: w3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0933a implements InterfaceC0939g {

    /* renamed from: j, reason: collision with root package name */
    public final InterfaceC0940h f10136j;

    public AbstractC0933a(InterfaceC0940h interfaceC0940h) {
        this.f10136j = interfaceC0940h;
    }

    @Override // w3.InterfaceC0941i
    public final Object D(Object obj, p pVar) {
        return pVar.c(obj, this);
    }

    @Override // w3.InterfaceC0941i
    public InterfaceC0941i V(InterfaceC0940h interfaceC0940h) {
        return A2.b.p(this, interfaceC0940h);
    }

    @Override // w3.InterfaceC0939g
    public final InterfaceC0940h getKey() {
        return this.f10136j;
    }

    @Override // w3.InterfaceC0941i
    public InterfaceC0939g o(InterfaceC0940h interfaceC0940h) {
        return A2.b.g(this, interfaceC0940h);
    }

    @Override // w3.InterfaceC0941i
    public final InterfaceC0941i x(InterfaceC0941i interfaceC0941i) {
        return A2.b.u(this, interfaceC0941i);
    }
}
