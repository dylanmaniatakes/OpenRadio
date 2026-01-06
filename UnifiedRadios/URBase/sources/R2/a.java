package R2;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f2276a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2277b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2278c;

    public a(String str, long j5, long j6) {
        this.f2276a = str;
        this.f2277b = j5;
        this.f2278c = j6;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f2276a.equals(aVar.f2276a) && this.f2277b == aVar.f2277b && this.f2278c == aVar.f2278c;
    }

    public final int hashCode() {
        int iHashCode = (this.f2276a.hashCode() ^ 1000003) * 1000003;
        long j5 = this.f2277b;
        long j6 = this.f2278c;
        return ((iHashCode ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ ((int) (j6 ^ (j6 >>> 32)));
    }

    public final String toString() {
        return "InstallationTokenResult{token=" + this.f2276a + ", tokenExpirationTimestamp=" + this.f2277b + ", tokenCreationTimestamp=" + this.f2278c + "}";
    }
}
