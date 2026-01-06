package k4;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public long f8261a;

    /* renamed from: b, reason: collision with root package name */
    public int f8262b;

    public final void a() {
        long[] jArr = v.f8316b;
        int i5 = this.f8262b;
        long j5 = jArr[i5];
        if (i5 < 4) {
            this.f8262b = i5 + 1;
        }
        this.f8261a = (System.nanoTime() / 1000000) + j5;
    }
}
