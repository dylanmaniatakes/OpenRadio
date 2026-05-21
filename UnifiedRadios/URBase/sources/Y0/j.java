package Y0;

import J1.C;
import J1.D;
import X2.t;
import a1.C0205a;
import android.content.Context;
import e1.C0443k;
import f3.C0513e;
import f3.C0519j;
import h1.AbstractC0557a;
import h1.C0558b;
import h1.C0559c;
import m3.C0777m;
import r3.InterfaceC0877a;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public Context f2915a;

    public k a() {
        Context context = this.f2915a;
        if (context == null) {
            throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
        }
        k kVar = new k();
        kVar.f2916j = C0205a.a(n.f2923a);
        C0519j c0519j = new C0519j(11, context);
        kVar.f2917k = c0519j;
        C0558b c0558b = AbstractC0557a.f7080a;
        C0559c c0559c = AbstractC0557a.f7081b;
        C0513e c0513e = new C0513e();
        c0513e.f6686c = c0519j;
        c0513e.f6687d = c0558b;
        c0513e.f6688e = c0559c;
        kVar.f2918l = C0205a.a(new L0.c(11, c0519j, c0513e, false));
        C0519j c0519j2 = kVar.f2917k;
        C c2 = f1.e.f6452a;
        D d5 = f1.e.f6453b;
        C0777m c0777m = new C0777m();
        c0777m.f8620c = c0519j2;
        c0777m.f8621d = c2;
        c0777m.f8622e = d5;
        kVar.f2919m = c0777m;
        InterfaceC0877a interfaceC0877aA = C0205a.a(new r(kVar.f2919m, C0205a.a(new C0519j(15, c0519j2))));
        kVar.n = interfaceC0877aA;
        B0.l lVar = new B0.l(10);
        C0519j c0519j3 = kVar.f2917k;
        C0559c c0559c2 = AbstractC0557a.f7081b;
        L0.i iVar = new L0.i();
        iVar.f1547c = c0519j3;
        iVar.f1548d = interfaceC0877aA;
        iVar.f1549e = lVar;
        iVar.f1550f = c0559c2;
        InterfaceC0877a interfaceC0877a = kVar.f2916j;
        InterfaceC0877a interfaceC0877a2 = kVar.f2918l;
        r rVar = new r(interfaceC0877a, interfaceC0877a2, iVar, interfaceC0877aA, interfaceC0877aA);
        C0443k c0443k = new C0443k(c0519j3, interfaceC0877a2, interfaceC0877aA, iVar, interfaceC0877a, interfaceC0877aA, interfaceC0877aA);
        t tVar = new t();
        tVar.f2833c = interfaceC0877a;
        tVar.f2834d = interfaceC0877aA;
        tVar.f2835e = iVar;
        tVar.f2836f = interfaceC0877aA;
        kVar.f2920o = C0205a.a(new r(rVar, c0443k, tVar));
        return kVar;
    }
}
