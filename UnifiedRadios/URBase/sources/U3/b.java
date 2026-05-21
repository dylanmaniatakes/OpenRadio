package U3;

import N3.AbstractC0146u;
import S3.s;
import S3.w;
import g0.AbstractC0535a;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public final class b implements Executor, Closeable {

    /* renamed from: q, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f2475q = AtomicLongFieldUpdater.newUpdater(b.class, "parkedWorkersStack");

    /* renamed from: r, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f2476r = AtomicLongFieldUpdater.newUpdater(b.class, "controlState");

    /* renamed from: s, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f2477s = AtomicIntegerFieldUpdater.newUpdater(b.class, "_isTerminated");

    /* renamed from: t, reason: collision with root package name */
    public static final w f2478t = new w("NOT_IN_STACK", 0);
    private volatile int _isTerminated;
    private volatile long controlState;

    /* renamed from: j, reason: collision with root package name */
    public final int f2479j;

    /* renamed from: k, reason: collision with root package name */
    public final int f2480k;

    /* renamed from: l, reason: collision with root package name */
    public final long f2481l;

    /* renamed from: m, reason: collision with root package name */
    public final String f2482m;
    public final e n;

    /* renamed from: o, reason: collision with root package name */
    public final e f2483o;

    /* renamed from: p, reason: collision with root package name */
    public final s f2484p;
    private volatile long parkedWorkersStack;

    public b(String str, long j5, int i5, int i6) {
        this.f2479j = i5;
        this.f2480k = i6;
        this.f2481l = j5;
        this.f2482m = str;
        if (i5 < 1) {
            throw new IllegalArgumentException(AbstractC0535a.j("Core pool size ", i5, " should be at least 1").toString());
        }
        if (i6 < i5) {
            throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.c("Max pool size ", " should be greater than or equals to core pool size ", i6, i5).toString());
        }
        if (i6 > 2097150) {
            throw new IllegalArgumentException(AbstractC0535a.j("Max pool size ", i6, " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j5 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j5 + " must be positive").toString());
        }
        this.n = new e();
        this.f2483o = new e();
        this.f2484p = new s((i5 + 1) * 2);
        this.controlState = i5 << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void o(b bVar, Runnable runnable, boolean z4, int i5) {
        i iVar = k.g;
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        bVar.c(runnable, iVar, z4);
    }

    public final boolean D(long j5) {
        int i5 = ((int) (2097151 & j5)) - ((int) ((j5 & 4398044413952L) >> 21));
        if (i5 < 0) {
            i5 = 0;
        }
        int i6 = this.f2479j;
        if (i5 < i6) {
            int iA = a();
            if (iA == 1 && i6 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean V() {
        w wVar;
        int iB;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f2475q;
            long j5 = atomicLongFieldUpdater.get(this);
            a aVar = (a) this.f2484p.b((int) (2097151 & j5));
            if (aVar == null) {
                aVar = null;
            } else {
                long j6 = (2097152 + j5) & (-2097152);
                Object objC = aVar.c();
                while (true) {
                    wVar = f2478t;
                    if (objC == wVar) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    a aVar2 = (a) objC;
                    iB = aVar2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = aVar2.c();
                }
                if (iB >= 0 && atomicLongFieldUpdater.compareAndSet(this, j5, j6 | iB)) {
                    aVar.g(wVar);
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.f2467r.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }

    public final int a() {
        synchronized (this.f2484p) {
            try {
                if (f2477s.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f2476r;
                long j5 = atomicLongFieldUpdater.get(this);
                int i5 = (int) (j5 & 2097151);
                int i6 = i5 - ((int) ((j5 & 4398044413952L) >> 21));
                if (i6 < 0) {
                    i6 = 0;
                }
                if (i6 >= this.f2479j) {
                    return 0;
                }
                if (i5 >= this.f2480k) {
                    return 0;
                }
                int i7 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i7 <= 0 || this.f2484p.b(i7) != null) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                a aVar = new a(this, i7);
                this.f2484p.c(i7, aVar);
                if (i7 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                int i8 = i6 + 1;
                aVar.start();
                return i8;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(Runnable runnable, i iVar, boolean z4) {
        h jVar;
        int i5;
        k.f2499f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof h) {
            jVar = (h) runnable;
            jVar.f2490j = jNanoTime;
            jVar.f2491k = iVar;
        } else {
            jVar = new j(runnable, jNanoTime, iVar);
        }
        boolean z5 = false;
        boolean z6 = jVar.f2491k.f2492c == 1;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2476r;
        long jAddAndGet = z6 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        a aVar = threadCurrentThread instanceof a ? (a) threadCurrentThread : null;
        if (aVar == null || !F3.i.a(aVar.f2474q, this)) {
            aVar = null;
        }
        if (aVar != null && (i5 = aVar.f2470l) != 5 && (jVar.f2491k.f2492c != 0 || i5 != 2)) {
            aVar.f2473p = true;
            m mVar = aVar.f2468j;
            if (z4) {
                jVar = mVar.a(jVar);
            } else {
                mVar.getClass();
                h hVar = (h) m.f2501b.getAndSet(mVar, jVar);
                jVar = hVar == null ? null : mVar.a(hVar);
            }
        }
        if (jVar != null) {
            if (!(jVar.f2491k.f2492c == 1 ? this.f2483o.a(jVar) : this.n.a(jVar))) {
                throw new RejectedExecutionException(com.unified.ur1.SatelliteTracker.h.e(new StringBuilder(), this.f2482m, " was terminated"));
            }
        }
        if (z4 && aVar != null) {
            z5 = true;
        }
        if (z6) {
            if (z5 || V() || D(jAddAndGet)) {
                return;
            }
            V();
            return;
        }
        if (z5 || V() || D(atomicLongFieldUpdater.get(this))) {
            return;
        }
        V();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = U3.b.f2477s
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lc
            goto Laf
        Lc:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof U3.a
            r3 = 0
            if (r1 == 0) goto L18
            U3.a r0 = (U3.a) r0
            goto L19
        L18:
            r0 = r3
        L19:
            if (r0 == 0) goto L24
            U3.b r1 = r0.f2474q
            boolean r1 = F3.i.a(r1, r8)
            if (r1 == 0) goto L24
            goto L25
        L24:
            r0 = r3
        L25:
            S3.s r1 = r8.f2484p
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = U3.b.f2476r     // Catch: java.lang.Throwable -> Lc1
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc1
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r1)
            if (r2 > r4) goto L77
            r1 = r2
        L37:
            S3.s r5 = r8.f2484p
            java.lang.Object r5 = r5.b(r1)
            F3.i.c(r5)
            U3.a r5 = (U3.a) r5
            if (r5 == r0) goto L72
        L44:
            boolean r6 = r5.isAlive()
            if (r6 == 0) goto L53
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r6 = 10000(0x2710, double:4.9407E-320)
            r5.join(r6)
            goto L44
        L53:
            U3.m r5 = r5.f2468j
            U3.e r6 = r8.f2483o
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = U3.m.f2501b
            java.lang.Object r7 = r7.getAndSet(r5, r3)
            U3.h r7 = (U3.h) r7
            if (r7 == 0) goto L67
            r6.a(r7)
        L67:
            U3.h r7 = r5.b()
            if (r7 != 0) goto L6e
            goto L72
        L6e:
            r6.a(r7)
            goto L67
        L72:
            if (r1 == r4) goto L77
            int r1 = r1 + 1
            goto L37
        L77:
            U3.e r1 = r8.f2483o
            r1.b()
            U3.e r1 = r8.n
            r1.b()
        L81:
            if (r0 == 0) goto L89
            U3.h r1 = r0.a(r2)
            if (r1 != 0) goto Lb0
        L89:
            U3.e r1 = r8.n
            java.lang.Object r1 = r1.d()
            U3.h r1 = (U3.h) r1
            if (r1 != 0) goto Lb0
            U3.e r1 = r8.f2483o
            java.lang.Object r1 = r1.d()
            U3.h r1 = (U3.h) r1
            if (r1 != 0) goto Lb0
            if (r0 == 0) goto La3
            r1 = 5
            r0.h(r1)
        La3:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = U3.b.f2475q
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = U3.b.f2476r
            r0.set(r8, r1)
        Laf:
            return
        Lb0:
            r1.run()     // Catch: java.lang.Throwable -> Lb4
            goto L81
        Lb4:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L81
        Lc1:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: U3.b.close():void");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        o(this, runnable, false, 6);
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        s sVar = this.f2484p;
        int iA = sVar.a();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 1; i10 < iA; i10++) {
            a aVar = (a) sVar.b(i10);
            if (aVar != null) {
                m mVar = aVar.f2468j;
                mVar.getClass();
                int i11 = m.f2501b.get(mVar) != null ? (m.f2502c.get(mVar) - m.f2503d.get(mVar)) + 1 : m.f2502c.get(mVar) - m.f2503d.get(mVar);
                int iC = AbstractC0882e.c(aVar.f2470l);
                if (iC == 0) {
                    i5++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i11);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iC == 1) {
                    i6++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i11);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iC == 2) {
                    i7++;
                } else if (iC == 3) {
                    i8++;
                    if (i11 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i11);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (iC == 4) {
                    i9++;
                }
            }
        }
        long j5 = f2476r.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f2482m);
        sb4.append('@');
        sb4.append(AbstractC0146u.e(this));
        sb4.append("[Pool Size {core = ");
        int i12 = this.f2479j;
        sb4.append(i12);
        sb4.append(", max = ");
        sb4.append(this.f2480k);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i5);
        sb4.append(", blocking = ");
        sb4.append(i6);
        sb4.append(", parked = ");
        sb4.append(i7);
        sb4.append(", dormant = ");
        sb4.append(i8);
        sb4.append(", terminated = ");
        sb4.append(i9);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.n.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f2483o.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j5));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j5) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i12 - ((int) ((j5 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }

    public final void x(a aVar, int i5, int i6) {
        while (true) {
            long j5 = f2475q.get(this);
            int i7 = (int) (2097151 & j5);
            long j6 = (2097152 + j5) & (-2097152);
            if (i7 == i5) {
                if (i6 == 0) {
                    Object objC = aVar.c();
                    while (true) {
                        if (objC == f2478t) {
                            i7 = -1;
                            break;
                        }
                        if (objC == null) {
                            i7 = 0;
                            break;
                        }
                        a aVar2 = (a) objC;
                        int iB = aVar2.b();
                        if (iB != 0) {
                            i7 = iB;
                            break;
                        }
                        objC = aVar2.c();
                    }
                } else {
                    i7 = i6;
                }
            }
            if (i7 >= 0) {
                if (f2475q.compareAndSet(this, j5, i7 | j6)) {
                    return;
                }
            }
        }
    }
}
