package J1;

/* renamed from: J1.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0118x implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1444j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ long f1445k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ B f1446l;

    public /* synthetic */ RunnableC0118x(B b5, long j5, int i5) {
        this.f1444j = i5;
        this.f1445k = j5;
        this.f1446l = b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1444j) {
            case 0:
                ((A) this.f1446l).p(this.f1445k);
                break;
            default:
                C0091n1 c0091n1 = (C0091n1) this.f1446l;
                A a2 = ((C0113v0) c0091n1.f84c).f1424s;
                C0113v0.h(a2);
                a2.m(this.f1445k);
                c0091n1.g = null;
                break;
        }
    }
}
