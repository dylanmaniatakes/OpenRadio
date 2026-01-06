package R3;

import E3.p;
import P3.q;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import s3.C0900j;
import w3.InterfaceC0936d;
import x3.EnumC0973a;
import y3.i;

/* loaded from: classes.dex */
public final class b extends i implements p {

    /* renamed from: k, reason: collision with root package name */
    public int f2307k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f2308l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Q3.b f2309m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Q3.b bVar, InterfaceC0936d interfaceC0936d) {
        super(2, interfaceC0936d);
        this.f2309m = bVar;
    }

    @Override // E3.p
    public final Object c(Object obj, Object obj2) {
        return ((b) create((q) obj, (InterfaceC0936d) obj2)).invokeSuspend(C0900j.f9694a);
    }

    @Override // y3.AbstractC0987a
    public final InterfaceC0936d create(Object obj, InterfaceC0936d interfaceC0936d) {
        b bVar = new b(this.f2309m, interfaceC0936d);
        bVar.f2308l = obj;
        return bVar;
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        EnumC0973a enumC0973a = EnumC0973a.f10448j;
        int i5 = this.f2307k;
        if (i5 == 0) {
            AbstractC0399v1.j(obj);
            q qVar = (q) this.f2308l;
            this.f2307k = 1;
            if (this.f2309m.b(qVar, this) == enumC0973a) {
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
