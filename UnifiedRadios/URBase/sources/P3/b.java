package P3;

import w3.InterfaceC0936d;
import x3.EnumC0973a;
import y3.AbstractC0989c;

/* loaded from: classes.dex */
public final class b extends AbstractC0989c {

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f2082j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ d f2083k;

    /* renamed from: l, reason: collision with root package name */
    public int f2084l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar, InterfaceC0936d interfaceC0936d) {
        super(interfaceC0936d);
        this.f2083k = dVar;
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f2082j = obj;
        this.f2084l |= Integer.MIN_VALUE;
        Object objA = d.A(this.f2083k, this);
        return objA == EnumC0973a.f10448j ? objA : new k(objA);
    }
}
