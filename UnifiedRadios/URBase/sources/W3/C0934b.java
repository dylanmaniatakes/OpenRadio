package w3;

import E3.p;

/* renamed from: w3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0934b extends F3.j implements p {

    /* renamed from: k, reason: collision with root package name */
    public static final C0934b f10137k = new C0934b(2, 0);

    /* renamed from: l, reason: collision with root package name */
    public static final C0934b f10138l = new C0934b(2, 1);

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f10139j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0934b(int i5, int i6) {
        super(i5);
        this.f10139j = i6;
    }

    @Override // E3.p
    public final Object c(Object obj, Object obj2) {
        C0935c c0935c;
        switch (this.f10139j) {
            case 0:
                String str = (String) obj;
                InterfaceC0939g interfaceC0939g = (InterfaceC0939g) obj2;
                F3.i.f(str, "acc");
                F3.i.f(interfaceC0939g, "element");
                if (str.length() == 0) {
                    return interfaceC0939g.toString();
                }
                return str + ", " + interfaceC0939g;
            default:
                InterfaceC0941i interfaceC0941i = (InterfaceC0941i) obj;
                InterfaceC0939g interfaceC0939g2 = (InterfaceC0939g) obj2;
                F3.i.f(interfaceC0941i, "acc");
                F3.i.f(interfaceC0939g2, "element");
                InterfaceC0941i interfaceC0941iV = interfaceC0941i.V(interfaceC0939g2.getKey());
                C0942j c0942j = C0942j.f10143j;
                if (interfaceC0941iV == c0942j) {
                    return interfaceC0939g2;
                }
                C0937e c0937e = C0937e.f10142j;
                InterfaceC0938f interfaceC0938f = (InterfaceC0938f) interfaceC0941iV.o(c0937e);
                if (interfaceC0938f == null) {
                    c0935c = new C0935c(interfaceC0939g2, interfaceC0941iV);
                } else {
                    InterfaceC0941i interfaceC0941iV2 = interfaceC0941iV.V(c0937e);
                    if (interfaceC0941iV2 == c0942j) {
                        return new C0935c(interfaceC0938f, interfaceC0939g2);
                    }
                    c0935c = new C0935c(interfaceC0938f, new C0935c(interfaceC0939g2, interfaceC0941iV2));
                }
                return c0935c;
        }
    }
}
