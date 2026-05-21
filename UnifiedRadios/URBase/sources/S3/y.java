package S3;

import N3.e0;
import w3.InterfaceC0939g;

/* loaded from: classes.dex */
public final class y extends F3.j implements E3.p {

    /* renamed from: k, reason: collision with root package name */
    public static final y f2424k = new y(2, 0);

    /* renamed from: l, reason: collision with root package name */
    public static final y f2425l = new y(2, 1);

    /* renamed from: m, reason: collision with root package name */
    public static final y f2426m = new y(2, 2);

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f2427j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(int i5, int i6) {
        super(i5);
        this.f2427j = i6;
    }

    @Override // E3.p
    public final Object c(Object obj, Object obj2) {
        switch (this.f2427j) {
            case 0:
                InterfaceC0939g interfaceC0939g = (InterfaceC0939g) obj2;
                if (!(interfaceC0939g instanceof e0)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? interfaceC0939g : Integer.valueOf(iIntValue + 1);
            case 1:
                e0 e0Var = (e0) obj;
                InterfaceC0939g interfaceC0939g2 = (InterfaceC0939g) obj2;
                if (e0Var != null) {
                    return e0Var;
                }
                if (interfaceC0939g2 instanceof e0) {
                    return (e0) interfaceC0939g2;
                }
                return null;
            default:
                return (A) obj;
        }
    }
}
