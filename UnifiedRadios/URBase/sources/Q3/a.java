package Q3;

import P3.q;
import w3.InterfaceC0936d;
import y3.AbstractC0989c;

/* loaded from: classes.dex */
public final class a extends AbstractC0989c {

    /* renamed from: j, reason: collision with root package name */
    public q f2172j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f2173k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ b f2174l;

    /* renamed from: m, reason: collision with root package name */
    public int f2175m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, InterfaceC0936d interfaceC0936d) {
        super(interfaceC0936d);
        this.f2174l = bVar;
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        this.f2173k = obj;
        this.f2175m |= Integer.MIN_VALUE;
        return this.f2174l.b(null, this);
    }
}
