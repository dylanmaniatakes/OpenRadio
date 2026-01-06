package J1;

/* renamed from: J1.m1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0088m1 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1302j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ C0091n1 f1303k;

    public /* synthetic */ RunnableC0088m1(C0091n1 c0091n1, int i5) {
        this.f1302j = i5;
        this.f1303k = c0091n1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1302j) {
            case 0:
                C0091n1 c0091n1 = this.f1303k;
                c0091n1.g = c0091n1.f1320l;
                break;
            default:
                this.f1303k.f1320l = null;
                break;
        }
    }
}
