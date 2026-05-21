package A2;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f14a;

    /* renamed from: b, reason: collision with root package name */
    public final long f15b;

    /* renamed from: c, reason: collision with root package name */
    public final long f16c;

    public a(long j5, long j6, long j7) {
        this.f14a = j5;
        this.f15b = j6;
        this.f16c = j7;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f14a == aVar.f14a && this.f15b == aVar.f15b && this.f16c == aVar.f16c;
    }

    public final int hashCode() {
        long j5 = this.f14a;
        long j6 = this.f15b;
        int i5 = (((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003;
        long j7 = this.f16c;
        return i5 ^ ((int) ((j7 >>> 32) ^ j7));
    }

    public final String toString() {
        return "StartupTime{epochMillis=" + this.f14a + ", elapsedRealtime=" + this.f15b + ", uptimeMillis=" + this.f16c + "}";
    }
}
