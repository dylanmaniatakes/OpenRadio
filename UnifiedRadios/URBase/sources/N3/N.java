package N3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import s3.C0900j;

/* loaded from: classes.dex */
public final class N extends S {

    /* renamed from: o, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f1823o = AtomicIntegerFieldUpdater.newUpdater(N.class, "_invoked");
    private volatile int _invoked;
    public final E3.l n;

    public N(E3.l lVar) {
        this.n = lVar;
    }

    @Override // E3.l
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        l((Throwable) obj);
        return C0900j.f9694a;
    }

    @Override // N3.U
    public final void l(Throwable th) {
        if (f1823o.compareAndSet(this, 0, 1)) {
            this.n.invoke(th);
        }
    }
}
