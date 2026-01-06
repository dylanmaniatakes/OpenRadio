package C0;

import N3.InterfaceC0144s;
import androidx.work.CoroutineWorker;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import s3.C0900j;
import w3.InterfaceC0936d;

/* loaded from: classes.dex */
public final class f extends y3.i implements E3.p {

    /* renamed from: k, reason: collision with root package name */
    public n f151k;

    /* renamed from: l, reason: collision with root package name */
    public int f152l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ n f153m;
    public final /* synthetic */ CoroutineWorker n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(n nVar, CoroutineWorker coroutineWorker, InterfaceC0936d interfaceC0936d) {
        super(2, interfaceC0936d);
        this.f153m = nVar;
        this.n = coroutineWorker;
    }

    @Override // E3.p
    public final Object c(Object obj, Object obj2) {
        f fVar = (f) create((InterfaceC0144s) obj, (InterfaceC0936d) obj2);
        C0900j c0900j = C0900j.f9694a;
        fVar.invokeSuspend(c0900j);
        return c0900j;
    }

    @Override // y3.AbstractC0987a
    public final InterfaceC0936d create(Object obj, InterfaceC0936d interfaceC0936d) {
        return new f(this.f153m, this.n, interfaceC0936d);
    }

    @Override // y3.AbstractC0987a
    public final Object invokeSuspend(Object obj) {
        int i5 = this.f152l;
        if (i5 == 0) {
            AbstractC0399v1.j(obj);
            this.f151k = this.f153m;
            this.f152l = 1;
            this.n.getClass();
            throw new IllegalStateException("Not implemented");
        }
        if (i5 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        n nVar = this.f151k;
        AbstractC0399v1.j(obj);
        nVar.f165j.j(obj);
        return C0900j.f9694a;
    }
}
