package H0;

import E3.p;
import L0.o;
import N3.InterfaceC0144s;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import f3.C0519j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s3.C0900j;
import w3.InterfaceC0936d;
import x3.EnumC0973a;

/* loaded from: classes.dex */
public final class j extends y3.i implements p {

    /* renamed from: k, reason: collision with root package name */
    public int f657k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0519j f658l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ o f659m;
    public final /* synthetic */ e n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(C0519j c0519j, o oVar, e eVar, InterfaceC0936d interfaceC0936d) {
        super(2, interfaceC0936d);
        this.f658l = c0519j;
        this.f659m = oVar;
        this.n = eVar;
    }

    @Override // E3.p
    public final Object c(Object obj, Object obj2) {
        return ((j) create((InterfaceC0144s) obj, (InterfaceC0936d) obj2)).invokeSuspend(C0900j.f9694a);
    }

    @Override // y3.AbstractC0987a
    public final InterfaceC0936d create(Object obj, InterfaceC0936d interfaceC0936d) {
        return new j(this.f658l, this.f659m, this.n, interfaceC0936d);
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        EnumC0973a enumC0973a = EnumC0973a.f10448j;
        int i5 = this.f657k;
        if (i5 == 0) {
            AbstractC0399v1.j(obj);
            C0519j c0519j = this.f658l;
            c0519j.getClass();
            o oVar = this.f659m;
            F3.i.f(oVar, "spec");
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (List) c0519j.f6730d) {
                if (((I0.e) obj2).b(oVar)) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = new ArrayList(t3.k.A(arrayList));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                I0.e eVar = (I0.e) it.next();
                eVar.getClass();
                arrayList2.add(new Q3.b(new I0.d(eVar, null)));
            }
            Q3.d dVar = new Q3.d(new i((Q3.e[]) t3.i.H(arrayList2).toArray(new Q3.e[0])));
            L0.c cVar = new L0.c(6, this.n, oVar, false);
            this.f657k = 1;
            if (dVar.a(cVar, this) == enumC0973a) {
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
