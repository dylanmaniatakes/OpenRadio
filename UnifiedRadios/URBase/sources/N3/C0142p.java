package N3;

import w3.InterfaceC0939g;
import w3.InterfaceC0940h;

/* renamed from: N3.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0142p implements InterfaceC0940h {

    /* renamed from: j, reason: collision with root package name */
    public final E3.l f1867j;

    /* renamed from: k, reason: collision with root package name */
    public final InterfaceC0940h f1868k;

    public C0142p(InterfaceC0940h interfaceC0940h, E3.l lVar) {
        F3.i.f(interfaceC0940h, "baseKey");
        this.f1867j = lVar;
        this.f1868k = interfaceC0940h instanceof C0142p ? ((C0142p) interfaceC0940h).f1868k : interfaceC0940h;
    }

    public final InterfaceC0939g a(InterfaceC0939g interfaceC0939g) {
        F3.i.f(interfaceC0939g, "element");
        return (InterfaceC0939g) this.f1867j.invoke(interfaceC0939g);
    }
}
