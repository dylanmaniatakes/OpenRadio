package N3;

import w3.InterfaceC0939g;
import w3.InterfaceC0941i;

/* renamed from: N3.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0140n extends F3.j implements E3.p {

    /* renamed from: k, reason: collision with root package name */
    public static final C0140n f1863k = new C0140n(2, 0);

    /* renamed from: l, reason: collision with root package name */
    public static final C0140n f1864l = new C0140n(2, 1);

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1865j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0140n(int i5, int i6) {
        super(i5);
        this.f1865j = i6;
    }

    @Override // E3.p
    public final Object c(Object obj, Object obj2) {
        switch (this.f1865j) {
            case 0:
                return ((InterfaceC0941i) obj).x((InterfaceC0939g) obj2);
            case 1:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            default:
                return ((InterfaceC0941i) obj).x((InterfaceC0939g) obj2);
        }
    }
}
