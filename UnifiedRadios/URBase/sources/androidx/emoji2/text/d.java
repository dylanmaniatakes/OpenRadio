package androidx.emoji2.text;

import J1.C;
import m3.C0777m;

/* loaded from: classes.dex */
public final class d extends h4.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f3599a;

    public d(e eVar) {
        this.f3599a = eVar;
    }

    @Override // h4.d
    public final void i(Throwable th) {
        ((j) this.f3599a.f3600a).d(th);
    }

    @Override // h4.d
    public final void j(L0.i iVar) {
        e eVar = this.f3599a;
        eVar.f3602c = iVar;
        L0.i iVar2 = (L0.i) eVar.f3602c;
        C c2 = new C(24);
        c cVar = ((j) eVar.f3600a).h;
        C0777m c0777m = new C0777m();
        c0777m.f8620c = c2;
        c0777m.f8621d = iVar2;
        c0777m.f8622e = cVar;
        eVar.f3601b = c0777m;
        ((j) eVar.f3600a).e();
    }
}
