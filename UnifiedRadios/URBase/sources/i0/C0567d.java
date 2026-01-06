package i0;

import E3.p;
import N3.InterfaceC0144s;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import s3.C0900j;
import w3.InterfaceC0936d;
import y3.i;

/* renamed from: i0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0567d extends i implements p {

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f7188k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ AbstractC0568e f7189l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0567d(AbstractC0568e abstractC0568e, InterfaceC0936d interfaceC0936d) {
        super(2, interfaceC0936d);
        this.f7189l = abstractC0568e;
    }

    @Override // E3.p
    public final Object c(Object obj, Object obj2) {
        ((C0567d) create((InterfaceC0144s) obj, (InterfaceC0936d) obj2)).invokeSuspend(C0900j.f9694a);
        throw null;
    }

    @Override // y3.AbstractC0987a
    public final InterfaceC0936d create(Object obj, InterfaceC0936d interfaceC0936d) {
        C0567d c0567d = new C0567d(this.f7189l, interfaceC0936d);
        c0567d.f7188k = obj;
        return c0567d;
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        AbstractC0399v1.j(obj);
        throw null;
    }
}
