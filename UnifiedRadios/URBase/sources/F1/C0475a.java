package f1;

/* renamed from: f1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0475a {

    /* renamed from: f, reason: collision with root package name */
    public static final C0475a f6443f = new C0475a(10485760, 604800000, 200, 10000, 81920);

    /* renamed from: a, reason: collision with root package name */
    public final long f6444a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6445b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6446c;

    /* renamed from: d, reason: collision with root package name */
    public final long f6447d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6448e;

    public C0475a(long j5, long j6, int i5, int i6, int i7) {
        this.f6444a = j5;
        this.f6445b = i5;
        this.f6446c = i6;
        this.f6447d = j6;
        this.f6448e = i7;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0475a)) {
            return false;
        }
        C0475a c0475a = (C0475a) obj;
        return this.f6444a == c0475a.f6444a && this.f6445b == c0475a.f6445b && this.f6446c == c0475a.f6446c && this.f6447d == c0475a.f6447d && this.f6448e == c0475a.f6448e;
    }

    public final int hashCode() {
        long j5 = this.f6444a;
        int i5 = (((((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ this.f6445b) * 1000003) ^ this.f6446c) * 1000003;
        long j6 = this.f6447d;
        return ((i5 ^ ((int) ((j6 >>> 32) ^ j6))) * 1000003) ^ this.f6448e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EventStoreConfig{maxStorageSizeInBytes=");
        sb.append(this.f6444a);
        sb.append(", loadBatchSize=");
        sb.append(this.f6445b);
        sb.append(", criticalSectionEnterTimeoutMs=");
        sb.append(this.f6446c);
        sb.append(", eventCleanUpAge=");
        sb.append(this.f6447d);
        sb.append(", maxBlobByteSizePerRow=");
        return com.unified.ur1.SatelliteTracker.h.d(sb, this.f6448e, "}");
    }
}
