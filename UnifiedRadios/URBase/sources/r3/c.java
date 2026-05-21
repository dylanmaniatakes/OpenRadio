package R3;

import L.h;
import w3.InterfaceC0936d;
import y3.AbstractC0989c;

/* loaded from: classes.dex */
public final class c extends AbstractC0989c {

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f2310j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ h f2311k;

    /* renamed from: l, reason: collision with root package name */
    public int f2312l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(h hVar, InterfaceC0936d interfaceC0936d) {
        super(interfaceC0936d);
        this.f2311k = hVar;
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        this.f2310j = obj;
        this.f2312l |= Integer.MIN_VALUE;
        return this.f2311k.a(null, this);
    }
}
