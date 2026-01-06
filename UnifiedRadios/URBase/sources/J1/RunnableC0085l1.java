package J1;

/* renamed from: J1.l1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0085l1 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ C0082k1 f1294j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ C0082k1 f1295k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f1296l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f1297m;
    public final /* synthetic */ C0091n1 n;

    public RunnableC0085l1(C0091n1 c0091n1, C0082k1 c0082k1, C0082k1 c0082k12, long j5, boolean z4) {
        this.f1294j = c0082k1;
        this.f1295k = c0082k12;
        this.f1296l = j5;
        this.f1297m = z4;
        this.n = c0091n1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.n.o(this.f1294j, this.f1295k, this.f1296l, this.f1297m, null);
    }
}
