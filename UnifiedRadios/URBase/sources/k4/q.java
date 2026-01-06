package k4;

/* loaded from: classes.dex */
public final class q implements n {

    /* renamed from: d, reason: collision with root package name */
    public long f8294d;

    /* renamed from: e, reason: collision with root package name */
    public long f8295e;

    /* renamed from: f, reason: collision with root package name */
    public long f8296f;
    public long g;
    public n h;

    /* renamed from: i, reason: collision with root package name */
    public L.h f8297i;
    public boolean n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8302o;

    /* renamed from: p, reason: collision with root package name */
    public int f8303p;

    /* renamed from: a, reason: collision with root package name */
    public final o f8291a = new o();

    /* renamed from: b, reason: collision with root package name */
    public final o f8292b = new o();

    /* renamed from: c, reason: collision with root package name */
    public final o f8293c = new o();

    /* renamed from: j, reason: collision with root package name */
    public final long[] f8298j = new long[4];

    /* renamed from: k, reason: collision with root package name */
    public final long[] f8299k = new long[4];

    /* renamed from: l, reason: collision with root package name */
    public final o f8300l = new o();

    /* renamed from: m, reason: collision with root package name */
    public final o f8301m = new o();

    @Override // k4.n
    public final void a() {
        this.n = true;
        L.h hVar = this.f8297i;
        if (hVar != null) {
            hVar.f1521c = 0;
        }
        this.h.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
    @Override // k4.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(long r45, long r47) {
        /*
            Method dump skipped, instructions count: 799
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.q.b(long, long):void");
    }

    @Override // k4.n
    public final void c() {
        L.h hVar = this.f8297i;
        if (hVar != null) {
            hVar.getClass();
        }
        this.h.c();
    }

    public final long d(long j5) {
        long j6 = this.f8294d;
        long j7 = this.f8296f;
        return j5 <= j6 ? j6 : j5 >= j7 ? j7 : j5;
    }

    public final long e(long j5) {
        long j6 = this.f8295e;
        long j7 = this.g;
        return j5 <= j6 ? j6 : j5 >= j7 ? j7 : j5;
    }

    public final boolean f(long j5, long j6, long j7, long j8) {
        long j9 = this.f8294d;
        if (!g(j5, j6, j7, j8, j9, this.f8295e, j9, this.g)) {
            long j10 = this.f8296f;
            if (!g(j5, j6, j7, j8, j10, this.f8295e, j10, this.g)) {
                long j11 = this.f8294d;
                long j12 = this.f8295e;
                if (!g(j5, j6, j7, j8, j11, j12, this.f8296f, j12)) {
                    long j13 = this.f8294d;
                    long j14 = this.g;
                    if (!g(j5, j6, j7, j8, j13, j14, this.f8296f, j14)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00cd A[PHI: r23 r25 r27 r29 r31 r33 r35 r36 r38
      0x00cd: PHI (r23v2 double) = (r23v0 double), (r23v0 double), (r23v0 double), (r23v0 double), (r23v0 double), (r23v4 double) binds: [B:24:0x00cb, B:27:0x00da, B:15:0x008f, B:17:0x0092, B:20:0x0097, B:5:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x00cd: PHI (r25v2 double) = (r25v0 double), (r25v0 double), (r25v0 double), (r25v0 double), (r25v0 double), (r25v4 double) binds: [B:24:0x00cb, B:27:0x00da, B:15:0x008f, B:17:0x0092, B:20:0x0097, B:5:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x00cd: PHI (r27v2 double) = (r27v0 double), (r27v0 double), (r27v0 double), (r27v0 double), (r27v0 double), (r27v4 double) binds: [B:24:0x00cb, B:27:0x00da, B:15:0x008f, B:17:0x0092, B:20:0x0097, B:5:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x00cd: PHI (r29v2 double) = (r29v0 double), (r29v0 double), (r29v0 double), (r29v0 double), (r29v0 double), (r29v4 double) binds: [B:24:0x00cb, B:27:0x00da, B:15:0x008f, B:17:0x0092, B:20:0x0097, B:5:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x00cd: PHI (r31v2 double) = (r31v0 double), (r31v0 double), (r31v0 double), (r31v0 double), (r31v0 double), (r31v4 double) binds: [B:24:0x00cb, B:27:0x00da, B:15:0x008f, B:17:0x0092, B:20:0x0097, B:5:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x00cd: PHI (r33v2 double) = (r33v0 double), (r33v0 double), (r33v0 double), (r33v0 double), (r33v0 double), (r33v4 double) binds: [B:24:0x00cb, B:27:0x00da, B:15:0x008f, B:17:0x0092, B:20:0x0097, B:5:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x00cd: PHI (r35v2 k4.o) = (r35v0 k4.o), (r35v0 k4.o), (r35v0 k4.o), (r35v0 k4.o), (r35v0 k4.o), (r35v4 k4.o) binds: [B:24:0x00cb, B:27:0x00da, B:15:0x008f, B:17:0x0092, B:20:0x0097, B:5:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x00cd: PHI (r36v2 double) = (r36v0 double), (r36v0 double), (r36v0 double), (r36v0 double), (r36v0 double), (r36v4 double) binds: [B:24:0x00cb, B:27:0x00da, B:15:0x008f, B:17:0x0092, B:20:0x0097, B:5:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x00cd: PHI (r38v2 double) = (r38v0 double), (r38v0 double), (r38v0 double), (r38v0 double), (r38v0 double), (r38v4 double) binds: [B:24:0x00cb, B:27:0x00da, B:15:0x008f, B:17:0x0092, B:20:0x0097, B:5:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56) {
        /*
            Method dump skipped, instructions count: 526
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.q.g(long, long, long, long, long, long, long, long):boolean");
    }

    public final boolean h(long j5, long j6) {
        return j5 > this.f8294d && j5 < this.f8296f && j6 > this.f8295e && j6 < this.g;
    }

    public final void i(long j5, long j6) {
        L.h hVar = this.f8297i;
        if (hVar != null) {
            int i5 = this.f8303p;
            int i6 = hVar.f1521c;
            hVar.f1521c = i6 + 1;
            ((int[]) hVar.f1522d)[i6] = i5;
        }
        this.h.b(j5, j6);
    }
}
