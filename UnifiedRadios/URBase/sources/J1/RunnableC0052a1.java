package J1;

/* renamed from: J1.a1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0052a1 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1104j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ K0 f1105k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f1106l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f1107m;
    public final /* synthetic */ C0058c1 n;

    public /* synthetic */ RunnableC0052a1(C0058c1 c0058c1, K0 k02, long j5, boolean z4, int i5) {
        this.f1104j = i5;
        this.f1105k = k02;
        this.f1106l = j5;
        this.f1107m = z4;
        this.n = c0058c1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1104j) {
            case 0:
                C0058c1 c0058c1 = this.n;
                K0 k02 = this.f1105k;
                c0058c1.B(k02);
                C0058c1.n(c0058c1, k02, this.f1106l, true, this.f1107m);
                break;
            default:
                C0058c1 c0058c12 = this.n;
                K0 k03 = this.f1105k;
                c0058c12.B(k03);
                C0058c1.n(c0058c12, k03, this.f1106l, false, this.f1107m);
                break;
        }
    }
}
