package J1;

/* loaded from: classes.dex */
public final class U1 {

    /* renamed from: a, reason: collision with root package name */
    public final V1 f958a;

    /* renamed from: b, reason: collision with root package name */
    public int f959b = 1;

    /* renamed from: c, reason: collision with root package name */
    public long f960c = a();

    public U1(V1 v12) {
        this.f958a = v12;
    }

    public final long a() {
        V1 v12 = this.f958a;
        q1.E.i(v12);
        long jLongValue = ((Long) H.f851v.a(null)).longValue();
        long jLongValue2 = ((Long) H.f852w.a(null)).longValue();
        for (int i5 = 1; i5 < this.f959b; i5++) {
            jLongValue += jLongValue;
            if (jLongValue >= jLongValue2) {
                break;
            }
        }
        v12.f().getClass();
        return Math.min(jLongValue, jLongValue2) + System.currentTimeMillis();
    }
}
