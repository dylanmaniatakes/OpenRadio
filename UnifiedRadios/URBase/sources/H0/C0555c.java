package h0;

import E3.p;
import N3.InterfaceC0144s;
import android.net.Uri;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import i0.AbstractC0568e;
import s3.C0900j;
import w3.InterfaceC0936d;
import x3.EnumC0973a;
import y3.i;

/* renamed from: h0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0555c extends i implements p {

    /* renamed from: k, reason: collision with root package name */
    public int f7076k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0556d f7077l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Uri f7078m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0555c(C0556d c0556d, Uri uri, InterfaceC0936d interfaceC0936d) {
        super(2, interfaceC0936d);
        this.f7077l = c0556d;
        this.f7078m = uri;
    }

    @Override // E3.p
    public final Object c(Object obj, Object obj2) {
        return ((C0555c) create((InterfaceC0144s) obj, (InterfaceC0936d) obj2)).invokeSuspend(C0900j.f9694a);
    }

    @Override // y3.AbstractC0987a
    public final InterfaceC0936d create(Object obj, InterfaceC0936d interfaceC0936d) {
        return new C0555c(this.f7077l, this.f7078m, interfaceC0936d);
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        EnumC0973a enumC0973a = EnumC0973a.f10448j;
        int i5 = this.f7076k;
        if (i5 == 0) {
            AbstractC0399v1.j(obj);
            AbstractC0568e abstractC0568e = this.f7077l.f7079a;
            this.f7076k = 1;
            if (abstractC0568e.i(this.f7078m, this) == enumC0973a) {
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
