package R3;

import E3.p;
import N3.InterfaceC0144s;
import P3.h;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import java.util.concurrent.atomic.AtomicInteger;
import s3.C0900j;
import w3.InterfaceC0936d;
import x3.EnumC0973a;
import y3.i;

/* loaded from: classes.dex */
public final class d extends i implements p {

    /* renamed from: k, reason: collision with root package name */
    public int f2313k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Q3.e[] f2314l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f2315m;
    public final /* synthetic */ AtomicInteger n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ h f2316o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Q3.e[] eVarArr, int i5, AtomicInteger atomicInteger, P3.d dVar, InterfaceC0936d interfaceC0936d) {
        super(2, interfaceC0936d);
        this.f2314l = eVarArr;
        this.f2315m = i5;
        this.n = atomicInteger;
        this.f2316o = dVar;
    }

    @Override // E3.p
    public final Object c(Object obj, Object obj2) {
        return ((d) create((InterfaceC0144s) obj, (InterfaceC0936d) obj2)).invokeSuspend(C0900j.f9694a);
    }

    @Override // y3.AbstractC0987a
    public final InterfaceC0936d create(Object obj, InterfaceC0936d interfaceC0936d) {
        return new d(this.f2314l, this.f2315m, this.n, (P3.d) this.f2316o, interfaceC0936d);
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        EnumC0973a enumC0973a = EnumC0973a.f10448j;
        int i5 = this.f2313k;
        AtomicInteger atomicInteger = this.n;
        h hVar = this.f2316o;
        try {
            if (i5 == 0) {
                AbstractC0399v1.j(obj);
                Q3.e[] eVarArr = this.f2314l;
                int i6 = this.f2315m;
                Q3.e eVar = eVarArr[i6];
                L.h hVar2 = new L.h(i6, hVar);
                this.f2313k = 1;
                if (eVar.a(hVar2, this) == enumC0973a) {
                    return enumC0973a;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC0399v1.j(obj);
            }
            if (atomicInteger.decrementAndGet() == 0) {
                hVar.b(null);
            }
            return C0900j.f9694a;
        } finally {
            if (atomicInteger.decrementAndGet() == 0) {
                hVar.b(null);
            }
        }
    }
}
