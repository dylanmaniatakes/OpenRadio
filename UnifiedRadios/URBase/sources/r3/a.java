package R3;

import E3.p;
import N3.AbstractC0146u;
import N3.InterfaceC0144s;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import s3.C0900j;
import w3.InterfaceC0936d;
import x3.EnumC0973a;
import y3.i;

/* loaded from: classes.dex */
public final class a extends i implements p {

    /* renamed from: k, reason: collision with root package name */
    public int f2304k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f2305l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Q3.f f2306m;
    public final /* synthetic */ Q3.b n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Q3.f fVar, Q3.b bVar, InterfaceC0936d interfaceC0936d) {
        super(2, interfaceC0936d);
        this.f2306m = fVar;
        this.n = bVar;
    }

    @Override // E3.p
    public final Object c(Object obj, Object obj2) {
        return ((a) create((InterfaceC0144s) obj, (InterfaceC0936d) obj2)).invokeSuspend(C0900j.f9694a);
    }

    @Override // y3.AbstractC0987a
    public final InterfaceC0936d create(Object obj, InterfaceC0936d interfaceC0936d) {
        a aVar = new a(this.f2306m, this.n, interfaceC0936d);
        aVar.f2305l = obj;
        return aVar;
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        EnumC0973a enumC0973a = EnumC0973a.f10448j;
        int i5 = this.f2304k;
        C0900j c0900j = C0900j.f9694a;
        if (i5 == 0) {
            AbstractC0399v1.j(obj);
            InterfaceC0144s interfaceC0144s = (InterfaceC0144s) this.f2305l;
            Q3.b bVar = this.n;
            int i6 = bVar.f2177b;
            if (i6 == -3) {
                i6 = -2;
            }
            p bVar2 = new b(bVar, null);
            P3.p pVar = new P3.p(AbstractC0146u.k(interfaceC0144s, bVar.f2176a), android.support.v4.media.session.b.a(i6, bVar.f2178c, 4));
            pVar.T(3, pVar, bVar2);
            this.f2304k = 1;
            Object objB = AbstractC0409x1.b(this.f2306m, pVar, true, this);
            if (objB != enumC0973a) {
                objB = c0900j;
            }
            if (objB == enumC0973a) {
                return enumC0973a;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC0399v1.j(obj);
        }
        return c0900j;
    }
}
