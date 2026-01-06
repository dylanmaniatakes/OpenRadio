package k4;

/* loaded from: classes.dex */
public final class r implements n {

    /* renamed from: a, reason: collision with root package name */
    public final o f8304a = new o();

    /* renamed from: b, reason: collision with root package name */
    public final o f8305b = new o();

    /* renamed from: c, reason: collision with root package name */
    public final n f8306c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8307d;

    /* renamed from: e, reason: collision with root package name */
    public long f8308e;

    /* renamed from: f, reason: collision with root package name */
    public long f8309f;
    public int g;

    public r(n nVar) {
        this.f8306c = nVar;
    }

    @Override // k4.n
    public final void a() {
        this.f8307d = true;
        this.g = 0;
        this.f8306c.a();
    }

    @Override // k4.n
    public final void b(long j5, long j6) {
        boolean z4 = this.f8307d;
        o oVar = this.f8304a;
        if (z4) {
            this.f8307d = false;
            d(j5, j6);
            oVar.f8285a = j5;
            oVar.f8286b = j6;
            return;
        }
        long j7 = oVar.f8285a;
        if (j7 == j5 && oVar.f8286b == j6) {
            return;
        }
        o oVar2 = this.f8305b;
        if (j7 == j5) {
            if (this.g == 1) {
                if (this.f8308e > j6) {
                    this.f8308e = j6;
                }
                if (this.f8309f < j6) {
                    this.f8309f = j6;
                }
            } else {
                e();
                this.g = 1;
                oVar2.a(oVar);
                this.f8308e = Math.min(j6, oVar.f8286b);
                this.f8309f = Math.max(j6, oVar.f8286b);
            }
        } else if (oVar.f8286b != j6) {
            e();
            d(j5, j6);
        } else if (this.g == 2) {
            if (this.f8308e > j5) {
                this.f8308e = j5;
            }
            if (this.f8309f < j5) {
                this.f8309f = j5;
            }
        } else {
            e();
            this.g = 2;
            oVar2.a(oVar);
            this.f8308e = Math.min(j5, oVar.f8285a);
            this.f8309f = Math.max(j5, oVar.f8285a);
        }
        oVar.f8285a = j5;
        oVar.f8286b = j6;
    }

    @Override // k4.n
    public final void c() {
        e();
        this.f8306c.c();
    }

    public final void d(long j5, long j6) {
        this.f8306c.b(j5, j6);
    }

    public final void e() {
        int i5 = this.g;
        o oVar = this.f8305b;
        o oVar2 = this.f8304a;
        if (i5 == 1) {
            long j5 = oVar.f8285a;
            long j6 = oVar.f8286b;
            long j7 = oVar2.f8286b;
            if (j6 > j7) {
                j6 = j7;
                j7 = j6;
            }
            long j8 = this.f8308e;
            if (j8 < j6) {
                d(j5, j8);
            }
            long j9 = this.f8309f;
            if (j9 > j7) {
                d(j5, j9);
            }
            d(j5, oVar2.f8286b);
        } else if (i5 == 2) {
            long j10 = oVar.f8286b;
            long j11 = oVar.f8285a;
            long j12 = oVar2.f8285a;
            if (j11 > j12) {
                j11 = j12;
                j12 = j11;
            }
            long j13 = this.f8308e;
            if (j13 < j11) {
                d(j13, j10);
            }
            long j14 = this.f8309f;
            if (j14 > j12) {
                d(j14, j10);
            }
            d(oVar2.f8285a, j10);
        }
        this.g = 0;
    }
}
