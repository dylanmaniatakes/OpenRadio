package Q3;

import L0.m;
import w3.InterfaceC0936d;
import y3.AbstractC0989c;

/* loaded from: classes.dex */
public final class c extends AbstractC0989c {

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f2180j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ m f2181k;

    /* renamed from: l, reason: collision with root package name */
    public int f2182l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(m mVar, InterfaceC0936d interfaceC0936d) {
        super(interfaceC0936d);
        this.f2181k = mVar;
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        this.f2180j = obj;
        this.f2182l |= Integer.MIN_VALUE;
        return this.f2181k.a(null, this);
    }
}
