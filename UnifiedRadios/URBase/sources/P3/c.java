package P3;

import w3.InterfaceC0936d;
import x3.EnumC0973a;
import y3.AbstractC0989c;

/* loaded from: classes.dex */
public final class c extends AbstractC0989c {

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f2085j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ d f2086k;

    /* renamed from: l, reason: collision with root package name */
    public int f2087l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, InterfaceC0936d interfaceC0936d) {
        super(interfaceC0936d);
        this.f2086k = dVar;
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f2085j = obj;
        this.f2087l |= Integer.MIN_VALUE;
        Object objB = this.f2086k.B(null, 0, 0L, this);
        return objB == EnumC0973a.f10448j ? objB : new k(objB);
    }
}
