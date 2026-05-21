package h0;

import E3.p;
import N3.InterfaceC0144s;
import android.net.Uri;
import android.view.InputEvent;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import i0.AbstractC0568e;
import s3.C0900j;
import w3.InterfaceC0936d;
import x3.EnumC0973a;
import y3.i;

/* renamed from: h0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0554b extends i implements p {

    /* renamed from: k, reason: collision with root package name */
    public int f7073k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0556d f7074l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Uri f7075m;
    public final /* synthetic */ InputEvent n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0554b(C0556d c0556d, Uri uri, InputEvent inputEvent, InterfaceC0936d interfaceC0936d) {
        super(2, interfaceC0936d);
        this.f7074l = c0556d;
        this.f7075m = uri;
        this.n = inputEvent;
    }

    @Override // E3.p
    public final Object c(Object obj, Object obj2) {
        return ((C0554b) create((InterfaceC0144s) obj, (InterfaceC0936d) obj2)).invokeSuspend(C0900j.f9694a);
    }

    @Override // y3.AbstractC0987a
    public final InterfaceC0936d create(Object obj, InterfaceC0936d interfaceC0936d) {
        return new C0554b(this.f7074l, this.f7075m, this.n, interfaceC0936d);
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        EnumC0973a enumC0973a = EnumC0973a.f10448j;
        int i5 = this.f7073k;
        if (i5 == 0) {
            AbstractC0399v1.j(obj);
            AbstractC0568e abstractC0568e = this.f7074l.f7079a;
            this.f7073k = 1;
            if (abstractC0568e.e(this.f7075m, this.n, this) == enumC0973a) {
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
