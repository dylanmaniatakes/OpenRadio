package N3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import w3.InterfaceC0941i;

/* loaded from: classes.dex */
public abstract class F extends G implements InterfaceC0151z {

    /* renamed from: o, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1814o = AtomicReferenceFieldUpdater.newUpdater(F.class, Object.class, "_queue");

    /* renamed from: p, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1815p = AtomicReferenceFieldUpdater.newUpdater(F.class, Object.class, "_delayed");

    /* renamed from: q, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f1816q = AtomicIntegerFieldUpdater.newUpdater(F.class, "_isCompleted");
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    @Override // N3.AbstractC0143q
    public final void W(InterfaceC0941i interfaceC0941i, Runnable runnable) {
        f0(runnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
    
        N3.RunnableC0147v.f1879r.f0(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f0(java.lang.Runnable r6) {
        /*
            r5 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = N3.F.f1814o
            java.lang.Object r1 = r0.get(r5)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = N3.F.f1816q
            int r2 = r2.get(r5)
            if (r2 == 0) goto Lf
            goto L4a
        Lf:
            if (r1 != 0) goto L20
        L11:
            r1 = 0
            boolean r1 = r0.compareAndSet(r5, r1, r6)
            if (r1 == 0) goto L19
            goto L66
        L19:
            java.lang.Object r1 = r0.get(r5)
            if (r1 == 0) goto L11
            goto L0
        L20:
            boolean r2 = r1 instanceof S3.n
            r3 = 1
            if (r2 == 0) goto L46
            r2 = r1
            S3.n r2 = (S3.n) r2
            int r4 = r2.a(r6)
            if (r4 == 0) goto L66
            if (r4 == r3) goto L34
            r0 = 2
            if (r4 == r0) goto L4a
            goto L0
        L34:
            S3.n r2 = r2.c()
        L38:
            boolean r3 = r0.compareAndSet(r5, r1, r2)
            if (r3 == 0) goto L3f
            goto L0
        L3f:
            java.lang.Object r3 = r0.get(r5)
            if (r3 == r1) goto L38
            goto L0
        L46:
            S3.w r2 = N3.AbstractC0146u.f1873b
            if (r1 != r2) goto L50
        L4a:
            N3.v r0 = N3.RunnableC0147v.f1879r
            r0.f0(r6)
            goto L73
        L50:
            S3.n r2 = new S3.n
            r4 = 8
            r2.<init>(r4, r3)
            r3 = r1
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r2.a(r3)
            r2.a(r6)
        L60:
            boolean r3 = r0.compareAndSet(r5, r1, r2)
            if (r3 == 0) goto L74
        L66:
            java.lang.Thread r6 = r5.b0()
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            if (r0 == r6) goto L73
            java.util.concurrent.locks.LockSupport.unpark(r6)
        L73:
            return
        L74:
            java.lang.Object r3 = r0.get(r5)
            if (r3 == r1) goto L60
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.F.f0(java.lang.Runnable):void");
    }

    public final boolean g0() {
        t3.g gVar = this.n;
        if (!(gVar != null ? gVar.isEmpty() : true)) {
            return false;
        }
        Object obj = f1814o.get(this);
        if (obj == null) {
            return true;
        }
        if (obj instanceof S3.n) {
            long j5 = S3.n.f2407f.get((S3.n) obj);
            if (((int) (1073741823 & j5)) == ((int) ((j5 & 1152921503533105152L) >> 30))) {
                return true;
            }
        } else if (obj == AbstractC0146u.f1873b) {
            return true;
        }
        return false;
    }

    public final long h0() {
        Runnable runnable;
        if (e0()) {
            return 0L;
        }
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1814o;
            Object obj = atomicReferenceFieldUpdater.get(this);
            runnable = null;
            if (obj == null) {
                break;
            }
            if (!(obj instanceof S3.n)) {
                if (obj != AbstractC0146u.f1873b) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    runnable = (Runnable) obj;
                    break loop0;
                }
                break;
            }
            S3.n nVar = (S3.n) obj;
            Object objD = nVar.d();
            if (objD != S3.n.g) {
                runnable = (Runnable) objD;
                break;
            }
            S3.n nVarC = nVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nVarC) && atomicReferenceFieldUpdater.get(this) == obj) {
            }
        }
        if (runnable != null) {
            runnable.run();
            return 0L;
        }
        t3.g gVar = this.n;
        if (((gVar == null || gVar.isEmpty()) ? Long.MAX_VALUE : 0L) == 0) {
            return 0L;
        }
        Object obj2 = f1814o.get(this);
        if (obj2 == null) {
        } else if (obj2 instanceof S3.n) {
            long j5 = S3.n.f2407f.get((S3.n) obj2);
            if (((int) (1073741823 & j5)) != ((int) ((j5 & 1152921503533105152L) >> 30))) {
                return 0L;
            }
        } else if (obj2 != AbstractC0146u.f1873b) {
            return 0L;
        }
        return Long.MAX_VALUE;
    }

    @Override // N3.G
    public void shutdown() {
        f0.f1849a.set(null);
        f1816q.set(this, 1);
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1814o;
            Object obj = atomicReferenceFieldUpdater.get(this);
            S3.w wVar = AbstractC0146u.f1873b;
            if (obj != null) {
                if (!(obj instanceof S3.n)) {
                    if (obj != wVar) {
                        S3.n nVar = new S3.n(8, true);
                        nVar.a((Runnable) obj);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nVar)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((S3.n) obj).b();
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, wVar)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                    break;
                }
            }
            break loop0;
        }
        while (h0() <= 0) {
        }
        System.nanoTime();
    }
}
