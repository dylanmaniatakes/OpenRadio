package x3;

import E3.p;
import F3.i;
import F3.o;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import w3.InterfaceC0936d;
import w3.InterfaceC0941i;
import y3.AbstractC0989c;

/* loaded from: classes.dex */
public final class c extends AbstractC0989c {

    /* renamed from: j, reason: collision with root package name */
    public int f10453j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ p f10454k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f10455l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(InterfaceC0936d interfaceC0936d, InterfaceC0941i interfaceC0941i, p pVar, Object obj) {
        super(interfaceC0936d, interfaceC0941i);
        this.f10454k = pVar;
        this.f10455l = obj;
        i.d(interfaceC0936d, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        int i5 = this.f10453j;
        if (i5 != 0) {
            if (i5 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f10453j = 2;
            AbstractC0399v1.j(obj);
            return obj;
        }
        this.f10453j = 1;
        AbstractC0399v1.j(obj);
        p pVar = this.f10454k;
        i.d(pVar, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
        o.b(2, pVar);
        return pVar.c(this.f10455l, this);
    }
}
