package I0;

import C0.t;
import E3.p;
import P3.q;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import s3.C0900j;
import w3.InterfaceC0936d;
import x3.EnumC0973a;
import y3.i;

/* loaded from: classes.dex */
public final class d extends i implements p {

    /* renamed from: k, reason: collision with root package name */
    public int f674k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f675l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ e f676m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, InterfaceC0936d interfaceC0936d) {
        super(2, interfaceC0936d);
        this.f676m = eVar;
    }

    @Override // E3.p
    public final Object c(Object obj, Object obj2) {
        return ((d) create((q) obj, (InterfaceC0936d) obj2)).invokeSuspend(C0900j.f9694a);
    }

    @Override // y3.AbstractC0987a
    public final InterfaceC0936d create(Object obj, InterfaceC0936d interfaceC0936d) {
        d dVar = new d(this.f676m, interfaceC0936d);
        dVar.f675l = obj;
        return dVar;
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        EnumC0973a enumC0973a = EnumC0973a.f10448j;
        int i5 = this.f674k;
        if (i5 == 0) {
            AbstractC0399v1.j(obj);
            q qVar = (q) this.f675l;
            e eVar = this.f676m;
            c cVar = new c(eVar, qVar);
            J0.f fVar = eVar.f677a;
            fVar.getClass();
            synchronized (fVar.f688c) {
                try {
                    if (fVar.f689d.add(cVar)) {
                        if (fVar.f689d.size() == 1) {
                            fVar.f690e = fVar.a();
                            t.d().a(J0.g.f691a, fVar.getClass().getSimpleName() + ": initial state = " + fVar.f690e);
                            fVar.c();
                        }
                        cVar.a(fVar.f690e);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            b bVar = new b(this.f676m, cVar);
            this.f674k = 1;
            if (AbstractC0399v1.a(qVar, bVar, this) == enumC0973a) {
                return enumC0973a;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC0399v1.j(obj);
        }
        return C0900j.f9694a;
    }
}
