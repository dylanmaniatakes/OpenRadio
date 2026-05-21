package T2;

import i3.C0573b;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f2446a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2447b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2448c;

    public b(int i5, String str, long j5) {
        this.f2446a = str;
        this.f2447b = j5;
        this.f2448c = i5;
    }

    public static C0573b a() {
        C0573b c0573b = new C0573b();
        c0573b.f7297e = 0L;
        return c0573b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        String str = this.f2446a;
        if (str != null ? str.equals(bVar.f2446a) : bVar.f2446a == null) {
            if (this.f2447b == bVar.f2447b) {
                int i5 = bVar.f2448c;
                int i6 = this.f2448c;
                if (i6 == 0) {
                    if (i5 == 0) {
                        return true;
                    }
                } else if (AbstractC0882e.a(i6, i5)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f2446a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j5 = this.f2447b;
        int i5 = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        int i6 = this.f2448c;
        return (i6 != 0 ? AbstractC0882e.c(i6) : 0) ^ i5;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TokenResult{token=");
        sb.append(this.f2446a);
        sb.append(", tokenExpirationTimestamp=");
        sb.append(this.f2447b);
        sb.append(", responseCode=");
        int i5 = this.f2448c;
        sb.append(i5 != 1 ? i5 != 2 ? i5 != 3 ? "null" : "AUTH_ERROR" : "BAD_CONFIG" : "OK");
        sb.append("}");
        return sb.toString();
    }
}
