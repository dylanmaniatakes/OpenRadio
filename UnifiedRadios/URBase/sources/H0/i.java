package H0;

import h4.r;
import s3.C0900j;
import w3.InterfaceC0936d;
import x3.EnumC0973a;

/* loaded from: classes.dex */
public final class i implements Q3.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Q3.e[] f656a;

    public i(Q3.e[] eVarArr) {
        this.f656a = eVarArr;
    }

    @Override // Q3.e
    public final Object a(Q3.f fVar, InterfaceC0936d interfaceC0936d) throws Throwable {
        Q3.e[] eVarArr = this.f656a;
        R3.e eVar = new R3.e(eVarArr, new g(0, eVarArr), new h(3, null), fVar, null);
        R3.f fVar2 = new R3.f(interfaceC0936d, interfaceC0936d.getContext());
        Object objP = r.p(fVar2, fVar2, eVar);
        EnumC0973a enumC0973a = EnumC0973a.f10448j;
        C0900j c0900j = C0900j.f9694a;
        if (objP != enumC0973a) {
            objP = c0900j;
        }
        return objP == enumC0973a ? objP : c0900j;
    }
}
