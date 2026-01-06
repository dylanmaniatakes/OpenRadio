package W3;

/* loaded from: classes.dex */
public final class x implements F {

    /* renamed from: j, reason: collision with root package name */
    public final n f2668j;

    /* renamed from: k, reason: collision with root package name */
    public final l f2669k;

    /* renamed from: l, reason: collision with root package name */
    public A f2670l;

    /* renamed from: m, reason: collision with root package name */
    public int f2671m;
    public boolean n;

    /* renamed from: o, reason: collision with root package name */
    public long f2672o;

    public x(n nVar) {
        F3.i.f(nVar, "upstream");
        this.f2668j = nVar;
        l lVarB = nVar.b();
        this.f2669k = lVarB;
        A a2 = lVarB.f2647j;
        this.f2670l = a2;
        this.f2671m = a2 != null ? a2.f2618b : -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.n = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        if (r3 == r5.f2618b) goto L15;
     */
    @Override // W3.F
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long read(W3.l r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            F3.i.f(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L76
            boolean r3 = r8.n
            r3 = r3 ^ 1
            if (r3 == 0) goto L6a
            W3.A r3 = r8.f2670l
            W3.l r4 = r8.f2669k
            if (r3 == 0) goto L31
            W3.A r5 = r4.f2647j
            if (r3 != r5) goto L25
            int r3 = r8.f2671m
            F3.i.c(r5)
            int r5 = r5.f2618b
            if (r3 != r5) goto L25
            goto L31
        L25:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L31:
            if (r2 != 0) goto L34
            return r0
        L34:
            long r0 = r8.f2672o
            r2 = 1
            long r0 = r0 + r2
            W3.n r2 = r8.f2668j
            boolean r0 = r2.l(r0)
            if (r0 != 0) goto L44
            r9 = -1
            return r9
        L44:
            W3.A r0 = r8.f2670l
            if (r0 != 0) goto L52
            W3.A r0 = r4.f2647j
            if (r0 == 0) goto L52
            r8.f2670l = r0
            int r0 = r0.f2618b
            r8.f2671m = r0
        L52:
            long r0 = r4.f2648k
            long r2 = r8.f2672o
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            W3.l r2 = r8.f2669k
            long r3 = r8.f2672o
            r5 = r9
            r6 = r10
            r2.s(r3, r5, r6)
            long r0 = r8.f2672o
            long r0 = r0 + r10
            r8.f2672o = r0
            return r10
        L6a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L76:
            java.lang.String r9 = "byteCount < 0: "
            java.lang.String r9 = g0.AbstractC0535a.h(r10, r9)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.x.read(W3.l, long):long");
    }

    @Override // W3.F
    public final I timeout() {
        return this.f2668j.timeout();
    }
}
