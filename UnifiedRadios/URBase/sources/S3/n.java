package S3;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2406e = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_next");

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f2407f = AtomicLongFieldUpdater.newUpdater(n.class, "_state");
    public static final w g = new w("REMOVE_FROZEN", 0);
    private volatile Object _next;
    private volatile long _state;

    /* renamed from: a, reason: collision with root package name */
    public final int f2408a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2409b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2410c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReferenceArray f2411d;

    public n(int i5, boolean z4) {
        this.f2408a = i5;
        this.f2409b = z4;
        int i6 = i5 - 1;
        this.f2410c = i6;
        this.f2411d = new AtomicReferenceArray(i5);
        if (i6 > 1073741823) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if ((i5 & i6) != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Object r14) {
        /*
            r13 = this;
        L0:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = S3.n.f2407f
            long r3 = r0.get(r13)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            r2 = 1
            if (r1 == 0) goto L19
            r0 = 2305843009213693952(0x2000000000000000, double:1.4916681462400413E-154)
            long r0 = r0 & r3
            int r14 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r14 == 0) goto L18
            r2 = 2
        L18:
            return r2
        L19:
            r5 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r5 = r5 & r3
            int r1 = (int) r5
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r9 = 30
            long r5 = r5 >> r9
            int r10 = (int) r5
            int r5 = r10 + 2
            int r11 = r13.f2410c
            r5 = r5 & r11
            r6 = r1 & r11
            if (r5 != r6) goto L32
            return r2
        L32:
            boolean r5 = r13.f2409b
            r6 = 1073741823(0x3fffffff, float:1.9999999)
            java.util.concurrent.atomic.AtomicReferenceArray r12 = r13.f2411d
            if (r5 != 0) goto L51
            r5 = r10 & r11
            java.lang.Object r5 = r12.get(r5)
            if (r5 == 0) goto L51
            r0 = 1024(0x400, float:1.435E-42)
            int r3 = r13.f2408a
            if (r3 < r0) goto L50
            int r10 = r10 - r1
            r0 = r10 & r6
            int r1 = r3 >> 1
            if (r0 <= r1) goto L0
        L50:
            return r2
        L51:
            int r1 = r10 + 1
            r1 = r1 & r6
            r5 = -1152921503533105153(0xf00000003fffffff, double:-3.1050369248997324E231)
            long r5 = r5 & r3
            long r1 = (long) r1
            long r1 = r1 << r9
            long r5 = r5 | r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = S3.n.f2407f
            r2 = r13
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L0
            r1 = r10 & r11
            r12.set(r1, r14)
            r1 = r13
        L6c:
            long r2 = r0.get(r1)
            r4 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r2 = r2 & r4
            int r2 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r2 == 0) goto L95
            S3.n r1 = r1.c()
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r1.f2411d
            int r3 = r1.f2410c
            r3 = r3 & r10
            java.lang.Object r4 = r2.get(r3)
            boolean r5 = r4 instanceof S3.m
            if (r5 == 0) goto L92
            S3.m r4 = (S3.m) r4
            int r4 = r4.f2405a
            if (r4 != r10) goto L92
            r2.set(r3, r14)
            goto L93
        L92:
            r1 = 0
        L93:
            if (r1 != 0) goto L6c
        L95:
            r14 = 0
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: S3.n.a(java.lang.Object):int");
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j5;
        do {
            atomicLongFieldUpdater = f2407f;
            j5 = atomicLongFieldUpdater.get(this);
            if ((j5 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j5) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j5, 2305843009213693952L | j5));
        return true;
    }

    public final n c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j5;
        while (true) {
            atomicLongFieldUpdater = f2407f;
            j5 = atomicLongFieldUpdater.get(this);
            if ((j5 & 1152921504606846976L) != 0) {
                break;
            }
            long j6 = j5 | 1152921504606846976L;
            if (atomicLongFieldUpdater.compareAndSet(this, j5, j6)) {
                j5 = j6;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2406e;
            n nVar = (n) atomicReferenceFieldUpdater.get(this);
            if (nVar != null) {
                return nVar;
            }
            n nVar2 = new n(this.f2408a * 2, this.f2409b);
            int i5 = (int) (1073741823 & j5);
            int i6 = (int) ((1152921503533105152L & j5) >> 30);
            while (true) {
                int i7 = this.f2410c;
                int i8 = i5 & i7;
                if (i8 == (i7 & i6)) {
                    break;
                }
                Object mVar = this.f2411d.get(i8);
                if (mVar == null) {
                    mVar = new m(i5);
                }
                nVar2.f2411d.set(nVar2.f2410c & i5, mVar);
                i5++;
            }
            atomicLongFieldUpdater.set(nVar2, (-1152921504606846977L) & j5);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, nVar2) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    public final Object d() {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f2407f;
            long j5 = atomicLongFieldUpdater.get(this);
            if ((j5 & 1152921504606846976L) != 0) {
                return g;
            }
            int i5 = (int) (j5 & 1073741823);
            int i6 = this.f2410c;
            int i7 = i5 & i6;
            if ((((int) ((1152921503533105152L & j5) >> 30)) & i6) == i7) {
                return null;
            }
            AtomicReferenceArray atomicReferenceArray = this.f2411d;
            Object obj = atomicReferenceArray.get(i7);
            boolean z4 = this.f2409b;
            if (obj == null) {
                if (z4) {
                    return null;
                }
            } else {
                if (obj instanceof m) {
                    return null;
                }
                long j6 = (i5 + 1) & 1073741823;
                if (atomicLongFieldUpdater.compareAndSet(this, j5, (j5 & (-1073741824)) | j6)) {
                    atomicReferenceArray.set(i7, null);
                    return obj;
                }
                if (z4) {
                    n nVarC = this;
                    while (true) {
                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f2407f;
                        long j7 = atomicLongFieldUpdater2.get(nVarC);
                        int i8 = (int) (j7 & 1073741823);
                        if ((j7 & 1152921504606846976L) != 0) {
                            nVarC = nVarC.c();
                        } else {
                            if (atomicLongFieldUpdater2.compareAndSet(nVarC, j7, (j7 & (-1073741824)) | j6)) {
                                nVarC.f2411d.set(nVarC.f2410c & i8, null);
                                nVarC = null;
                            } else {
                                continue;
                            }
                        }
                        if (nVarC == null) {
                            return obj;
                        }
                    }
                }
            }
        }
    }
}
