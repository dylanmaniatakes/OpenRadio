package S3;

import N3.AbstractC0143q;
import N3.AbstractC0148w;
import N3.InterfaceC0151z;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import w3.InterfaceC0941i;

/* loaded from: classes.dex */
public final class i extends AbstractC0143q implements InterfaceC0151z {

    /* renamed from: p, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f2396p = AtomicIntegerFieldUpdater.newUpdater(i.class, "runningWorkers");

    /* renamed from: l, reason: collision with root package name */
    public final AbstractC0143q f2397l;

    /* renamed from: m, reason: collision with root package name */
    public final int f2398m;
    public final l n;

    /* renamed from: o, reason: collision with root package name */
    public final Object f2399o;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public i(AbstractC0143q abstractC0143q, int i5) {
        this.f2397l = abstractC0143q;
        this.f2398m = i5;
        if ((abstractC0143q instanceof InterfaceC0151z ? (InterfaceC0151z) abstractC0143q : null) == null) {
            int i6 = AbstractC0148w.f1881a;
        }
        this.n = new l();
        this.f2399o = new Object();
    }

    @Override // N3.AbstractC0143q
    public final void W(InterfaceC0941i interfaceC0941i, Runnable runnable) {
        Runnable runnableZ;
        this.n.a(runnable);
        if (f2396p.get(this) >= this.f2398m || !a0() || (runnableZ = Z()) == null) {
            return;
        }
        this.f2397l.W(this, new N1.p(this, 4, runnableZ));
    }

    @Override // N3.AbstractC0143q
    public final void X(InterfaceC0941i interfaceC0941i, Runnable runnable) {
        Runnable runnableZ;
        this.n.a(runnable);
        if (f2396p.get(this) >= this.f2398m || !a0() || (runnableZ = Z()) == null) {
            return;
        }
        this.f2397l.X(this, new N1.p(this, 4, runnableZ));
    }

    public final Runnable Z() {
        while (true) {
            Runnable runnable = (Runnable) this.n.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f2399o) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f2396p;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.n.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean a0() {
        synchronized (this.f2399o) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f2396p;
            if (atomicIntegerFieldUpdater.get(this) >= this.f2398m) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }
}
