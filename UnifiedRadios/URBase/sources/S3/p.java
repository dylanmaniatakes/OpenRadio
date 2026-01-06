package S3;

import java.lang.reflect.InvocationTargetException;
import s3.C0900j;
import w3.InterfaceC0941i;

/* loaded from: classes.dex */
public final class p extends F3.j implements E3.l {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ E3.l f2413j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f2414k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0941i f2415l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(E3.l lVar, Object obj, InterfaceC0941i interfaceC0941i) {
        super(1);
        this.f2413j = lVar;
        this.f2414k = obj;
        this.f2415l = interfaceC0941i;
    }

    @Override // E3.l
    public final Object invoke(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AbstractC0187a.a(this.f2413j, this.f2414k, this.f2415l);
        return C0900j.f9694a;
    }
}
