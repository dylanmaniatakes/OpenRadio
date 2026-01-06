package f1;

/* renamed from: f1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0476b {

    /* renamed from: a, reason: collision with root package name */
    public final long f6449a;

    /* renamed from: b, reason: collision with root package name */
    public final Y0.i f6450b;

    /* renamed from: c, reason: collision with root package name */
    public final Y0.h f6451c;

    public C0476b(long j5, Y0.i iVar, Y0.h hVar) {
        this.f6449a = j5;
        this.f6450b = iVar;
        this.f6451c = hVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0476b)) {
            return false;
        }
        C0476b c0476b = (C0476b) obj;
        return this.f6449a == c0476b.f6449a && this.f6450b.equals(c0476b.f6450b) && this.f6451c.equals(c0476b.f6451c);
    }

    public final int hashCode() {
        long j5 = this.f6449a;
        return ((((((int) ((j5 >>> 32) ^ j5)) ^ 1000003) * 1000003) ^ this.f6450b.hashCode()) * 1000003) ^ this.f6451c.hashCode();
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f6449a + ", transportContext=" + this.f6450b + ", event=" + this.f6451c + "}";
    }
}
