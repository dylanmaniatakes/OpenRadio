package x3;

import E3.p;
import F3.i;
import F3.o;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import w3.InterfaceC0936d;
import y3.AbstractC0993g;

/* renamed from: x3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0974b extends AbstractC0993g {

    /* renamed from: j, reason: collision with root package name */
    public int f10450j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ p f10451k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f10452l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0974b(p pVar, Object obj, InterfaceC0936d interfaceC0936d) {
        super(interfaceC0936d);
        this.f10451k = pVar;
        this.f10452l = obj;
        i.d(interfaceC0936d, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        int i5 = this.f10450j;
        if (i5 != 0) {
            if (i5 != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.f10450j = 2;
            AbstractC0399v1.j(obj);
            return obj;
        }
        this.f10450j = 1;
        AbstractC0399v1.j(obj);
        p pVar = this.f10451k;
        i.d(pVar, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
        o.b(2, pVar);
        return pVar.c(this.f10452l, this);
    }
}
