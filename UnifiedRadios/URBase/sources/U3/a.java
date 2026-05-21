package U3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class a extends Thread {

    /* renamed from: r, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f2467r = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl");
    private volatile int indexInArray;

    /* renamed from: j, reason: collision with root package name */
    public final m f2468j;

    /* renamed from: k, reason: collision with root package name */
    public final F3.l f2469k;

    /* renamed from: l, reason: collision with root package name */
    public int f2470l;

    /* renamed from: m, reason: collision with root package name */
    public long f2471m;
    public long n;
    private volatile Object nextParkedWorker;

    /* renamed from: o, reason: collision with root package name */
    public int f2472o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f2473p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ b f2474q;
    private volatile int workerCtl;

    public a(b bVar, int i5) {
        this.f2474q = bVar;
        setDaemon(true);
        this.f2468j = new m();
        this.f2469k = new F3.l();
        this.f2470l = 4;
        this.nextParkedWorker = b.f2478t;
        H3.e.f666j.getClass();
        this.f2472o = H3.e.f667k.a().nextInt();
        f(i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        r12 = U3.m.f2503d.get(r3);
        r0 = U3.m.f2502c.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        if (r12 == r0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
    
        if (U3.m.f2504e.get(r3) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        r0 = r0 - 1;
        r5 = r3.c(r0, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
    
        if (r5 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        r2 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final U3.h a(boolean r12) {
        /*
            r11 = this;
            int r0 = r11.f2470l
            r1 = 1
            r2 = 0
            U3.m r3 = r11.f2468j
            U3.b r4 = r11.f2474q
            if (r0 != r1) goto Lc
            goto L86
        Lc:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = U3.b.f2476r
        Le:
            U3.b r6 = r11.f2474q
            long r7 = r0.get(r6)
            r9 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
            long r9 = r9 & r7
            r5 = 42
            long r9 = r9 >> r5
            int r5 = (int) r9
            if (r5 != 0) goto L75
            r3.getClass()
        L23:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = U3.m.f2501b
            java.lang.Object r0 = r12.get(r3)
            U3.h r0 = (U3.h) r0
            if (r0 != 0) goto L2e
            goto L43
        L2e:
            U3.i r5 = r0.f2491k
            int r5 = r5.f2492c
            if (r5 != r1) goto L43
        L34:
            boolean r5 = r12.compareAndSet(r3, r0, r2)
            if (r5 == 0) goto L3c
            r2 = r0
            goto L63
        L3c:
            java.lang.Object r5 = r12.get(r3)
            if (r5 == r0) goto L34
            goto L23
        L43:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r12 = U3.m.f2503d
            int r12 = r12.get(r3)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = U3.m.f2502c
            int r0 = r0.get(r3)
        L4f:
            if (r12 == r0) goto L63
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r5 = U3.m.f2504e
            int r5 = r5.get(r3)
            if (r5 != 0) goto L5a
            goto L63
        L5a:
            int r0 = r0 + (-1)
            U3.h r5 = r3.c(r0, r1)
            if (r5 == 0) goto L4f
            r2 = r5
        L63:
            if (r2 != 0) goto L74
            U3.e r12 = r4.f2483o
            java.lang.Object r12 = r12.d()
            r2 = r12
            U3.h r2 = (U3.h) r2
            if (r2 != 0) goto L74
            U3.h r2 = r11.i(r1)
        L74:
            return r2
        L75:
            r9 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
            long r9 = r7 - r9
            java.util.concurrent.atomic.AtomicLongFieldUpdater r5 = U3.b.f2476r
            boolean r5 = r5.compareAndSet(r6, r7, r9)
            if (r5 == 0) goto Le
            r11.f2470l = r1
        L86:
            if (r12 == 0) goto Lba
            int r12 = r4.f2479j
            int r12 = r12 * 2
            int r12 = r11.d(r12)
            if (r12 != 0) goto L93
            goto L94
        L93:
            r1 = 0
        L94:
            if (r1 == 0) goto L9d
            U3.h r12 = r11.e()
            if (r12 == 0) goto L9d
            goto Lc6
        L9d:
            r3.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r12 = U3.m.f2501b
            java.lang.Object r12 = r12.getAndSet(r3, r2)
            U3.h r12 = (U3.h) r12
            if (r12 != 0) goto Lae
            U3.h r12 = r3.b()
        Lae:
            if (r12 == 0) goto Lb1
            goto Lc6
        Lb1:
            if (r1 != 0) goto Lc1
            U3.h r12 = r11.e()
            if (r12 == 0) goto Lc1
            goto Lc6
        Lba:
            U3.h r12 = r11.e()
            if (r12 == 0) goto Lc1
            goto Lc6
        Lc1:
            r12 = 3
            U3.h r12 = r11.i(r12)
        Lc6:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: U3.a.a(boolean):U3.h");
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i5) {
        int i6 = this.f2472o;
        int i7 = i6 ^ (i6 << 13);
        int i8 = i7 ^ (i7 >> 17);
        int i9 = i8 ^ (i8 << 5);
        this.f2472o = i9;
        int i10 = i5 - 1;
        return (i10 & i5) == 0 ? i9 & i10 : (i9 & Integer.MAX_VALUE) % i5;
    }

    public final h e() {
        int iD = d(2);
        b bVar = this.f2474q;
        if (iD == 0) {
            h hVar = (h) bVar.n.d();
            return hVar != null ? hVar : (h) bVar.f2483o.d();
        }
        h hVar2 = (h) bVar.f2483o.d();
        return hVar2 != null ? hVar2 : (h) bVar.n.d();
    }

    public final void f(int i5) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2474q.f2482m);
        sb.append("-worker-");
        sb.append(i5 == 0 ? "TERMINATED" : String.valueOf(i5));
        setName(sb.toString());
        this.indexInArray = i5;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(int i5) {
        int i6 = this.f2470l;
        boolean z4 = i6 == 1;
        if (z4) {
            b.f2476r.addAndGet(this.f2474q, 4398046511104L);
        }
        if (i6 != i5) {
            this.f2470l = i5;
        }
        return z4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        r19 = r6;
        r6 = -2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final U3.h i(int r24) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: U3.a.i(int):U3.h");
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: U3.a.run():void");
    }
}
