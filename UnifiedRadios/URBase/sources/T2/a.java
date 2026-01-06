package T2;

import s.AbstractC0882e;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f2441a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2442b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2443c;

    /* renamed from: d, reason: collision with root package name */
    public final b f2444d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2445e;

    public a(String str, String str2, String str3, b bVar, int i5) {
        this.f2441a = str;
        this.f2442b = str2;
        this.f2443c = str3;
        this.f2444d = bVar;
        this.f2445e = i5;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f2441a;
        if (str != null ? str.equals(aVar.f2441a) : aVar.f2441a == null) {
            String str2 = this.f2442b;
            if (str2 != null ? str2.equals(aVar.f2442b) : aVar.f2442b == null) {
                String str3 = this.f2443c;
                if (str3 != null ? str3.equals(aVar.f2443c) : aVar.f2443c == null) {
                    b bVar = this.f2444d;
                    if (bVar != null ? bVar.equals(aVar.f2444d) : aVar.f2444d == null) {
                        int i5 = this.f2445e;
                        if (i5 == 0) {
                            if (aVar.f2445e == 0) {
                                return true;
                            }
                        } else if (AbstractC0882e.a(i5, aVar.f2445e)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f2441a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f2442b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2443c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        b bVar = this.f2444d;
        int iHashCode4 = (iHashCode3 ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
        int i5 = this.f2445e;
        return (i5 != 0 ? AbstractC0882e.c(i5) : 0) ^ iHashCode4;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallationResponse{uri=");
        sb.append(this.f2441a);
        sb.append(", fid=");
        sb.append(this.f2442b);
        sb.append(", refreshToken=");
        sb.append(this.f2443c);
        sb.append(", authToken=");
        sb.append(this.f2444d);
        sb.append(", responseCode=");
        int i5 = this.f2445e;
        sb.append(i5 != 1 ? i5 != 2 ? "null" : "BAD_CONFIG" : "OK");
        sb.append("}");
        return sb.toString();
    }
}
