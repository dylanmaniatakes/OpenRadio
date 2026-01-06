package S2;

import com.unified.ur1.SatelliteTracker.h;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f2368a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2369b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2370c;

    /* renamed from: d, reason: collision with root package name */
    public final String f2371d;

    /* renamed from: e, reason: collision with root package name */
    public final long f2372e;

    /* renamed from: f, reason: collision with root package name */
    public final long f2373f;
    public final String g;

    public b(String str, int i5, String str2, String str3, long j5, long j6, String str4) {
        this.f2368a = str;
        this.f2369b = i5;
        this.f2370c = str2;
        this.f2371d = str3;
        this.f2372e = j5;
        this.f2373f = j6;
        this.g = str4;
    }

    public final a a() {
        a aVar = new a();
        aVar.f2362a = this.f2368a;
        aVar.f2363b = this.f2369b;
        aVar.f2364c = this.f2370c;
        aVar.f2365d = this.f2371d;
        aVar.f2366e = Long.valueOf(this.f2372e);
        aVar.f2367f = Long.valueOf(this.f2373f);
        aVar.g = this.g;
        return aVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        String str = this.f2368a;
        if (str != null ? str.equals(bVar.f2368a) : bVar.f2368a == null) {
            if (AbstractC0882e.a(this.f2369b, bVar.f2369b)) {
                String str2 = bVar.f2370c;
                String str3 = this.f2370c;
                if (str3 != null ? str3.equals(str2) : str2 == null) {
                    String str4 = bVar.f2371d;
                    String str5 = this.f2371d;
                    if (str5 != null ? str5.equals(str4) : str4 == null) {
                        if (this.f2372e == bVar.f2372e && this.f2373f == bVar.f2373f) {
                            String str6 = bVar.g;
                            String str7 = this.g;
                            if (str7 == null) {
                                if (str6 == null) {
                                    return true;
                                }
                            } else if (str7.equals(str6)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f2368a;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ AbstractC0882e.c(this.f2369b)) * 1000003;
        String str2 = this.f2370c;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2371d;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j5 = this.f2372e;
        int i5 = (iHashCode3 ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        long j6 = this.f2373f;
        int i6 = (i5 ^ ((int) (j6 ^ (j6 >>> 32)))) * 1000003;
        String str4 = this.g;
        return (str4 != null ? str4.hashCode() : 0) ^ i6;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PersistedInstallationEntry{firebaseInstallationId=");
        sb.append(this.f2368a);
        sb.append(", registrationStatus=");
        int i5 = this.f2369b;
        sb.append(i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? i5 != 5 ? "null" : "REGISTER_ERROR" : "REGISTERED" : "UNREGISTERED" : "NOT_GENERATED" : "ATTEMPT_MIGRATION");
        sb.append(", authToken=");
        sb.append(this.f2370c);
        sb.append(", refreshToken=");
        sb.append(this.f2371d);
        sb.append(", expiresInSecs=");
        sb.append(this.f2372e);
        sb.append(", tokenCreationEpochInSecs=");
        sb.append(this.f2373f);
        sb.append(", fisError=");
        return h.e(sb, this.g, "}");
    }
}
