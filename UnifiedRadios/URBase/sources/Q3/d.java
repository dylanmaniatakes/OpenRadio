package Q3;

import E3.l;
import E3.p;
import L0.m;
import java.io.Serializable;
import s3.C0900j;
import w3.InterfaceC0936d;
import x3.EnumC0973a;

/* loaded from: classes.dex */
public final class d implements e {

    /* renamed from: a, reason: collision with root package name */
    public final e f2183a;

    /* renamed from: b, reason: collision with root package name */
    public final l f2184b;

    /* renamed from: c, reason: collision with root package name */
    public final p f2185c;

    public d(H0.i iVar) {
        i iVar2 = i.f2192j;
        h hVar = h.f2191j;
        this.f2183a = iVar;
        this.f2184b = iVar2;
        this.f2185c = hVar;
    }

    @Override // Q3.e
    public final Object a(f fVar, InterfaceC0936d interfaceC0936d) {
        F3.l lVar = new F3.l();
        lVar.f602j = R3.g.f2326a;
        Object objA = this.f2183a.a(new m((Object) this, (Serializable) lVar, (Object) fVar, 3), interfaceC0936d);
        return objA == EnumC0973a.f10448j ? objA : C0900j.f9694a;
    }
}
