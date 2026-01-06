package O;

import androidx.lifecycle.EnumC0243m;
import androidx.lifecycle.InterfaceC0249t;

/* renamed from: O.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0175n implements androidx.lifecycle.r {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1942j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f1943k;

    public /* synthetic */ C0175n(int i5, Object obj) {
        this.f1942j = i5;
        this.f1943k = obj;
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) {
        switch (this.f1942j) {
            case 0:
                EnumC0243m enumC0243m2 = EnumC0243m.ON_DESTROY;
                C0177p c0177p = (C0177p) this.f1943k;
                if (enumC0243m != enumC0243m2) {
                    c0177p.getClass();
                    break;
                } else {
                    c0177p.a();
                    break;
                }
            default:
                o0.c cVar = (o0.c) this.f1943k;
                F3.i.f(cVar, "this$0");
                if (enumC0243m != EnumC0243m.ON_START) {
                    if (enumC0243m == EnumC0243m.ON_STOP) {
                        cVar.f8891f = false;
                        break;
                    }
                } else {
                    cVar.f8891f = true;
                    break;
                }
                break;
        }
    }
}
