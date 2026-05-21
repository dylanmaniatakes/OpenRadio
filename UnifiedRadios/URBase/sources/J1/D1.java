package J1;

/* loaded from: classes.dex */
public final class D1 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final long f724j;

    /* renamed from: k, reason: collision with root package name */
    public final long f725k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ L0.c f726l;

    public D1(L0.c cVar, long j5, long j6) {
        this.f726l = cVar;
        this.f724j = j5;
        this.f725k = j6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0104s0 c0104s0 = ((C0113v0) ((G1) this.f726l.f1537e).f84c).f1418l;
        C0113v0.k(c0104s0);
        c0104s0.t(new C0.A(4, this));
    }
}
