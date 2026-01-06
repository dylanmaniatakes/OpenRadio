package h0;

import E3.p;
import N3.InterfaceC0144s;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import i0.AbstractC0568e;
import s3.C0900j;
import w3.InterfaceC0936d;
import x3.EnumC0973a;
import y3.i;

/* renamed from: h0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0553a extends i implements p {

    /* renamed from: k, reason: collision with root package name */
    public int f7071k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0556d f7072l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0553a(C0556d c0556d, InterfaceC0936d interfaceC0936d) {
        super(2, interfaceC0936d);
        this.f7072l = c0556d;
    }

    @Override // E3.p
    public final Object c(Object obj, Object obj2) {
        return ((C0553a) create((InterfaceC0144s) obj, (InterfaceC0936d) obj2)).invokeSuspend(C0900j.f9694a);
    }

    @Override // y3.AbstractC0987a
    public final InterfaceC0936d create(Object obj, InterfaceC0936d interfaceC0936d) {
        return new C0553a(this.f7072l, interfaceC0936d);
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        EnumC0973a enumC0973a = EnumC0973a.f10448j;
        int i5 = this.f7071k;
        if (i5 == 0) {
            AbstractC0399v1.j(obj);
            AbstractC0568e abstractC0568e = this.f7072l.f7079a;
            this.f7071k = 1;
            obj = abstractC0568e.c(this);
            if (obj == enumC0973a) {
                return enumC0973a;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC0399v1.j(obj);
        }
        return obj;
    }
}
