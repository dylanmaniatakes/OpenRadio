package X0;

/* loaded from: classes.dex */
public final class i extends a {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f2711a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2712b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2713c;

    /* renamed from: d, reason: collision with root package name */
    public final String f2714d;

    /* renamed from: e, reason: collision with root package name */
    public final String f2715e;

    /* renamed from: f, reason: collision with root package name */
    public final String f2716f;
    public final String g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final String f2717i;

    /* renamed from: j, reason: collision with root package name */
    public final String f2718j;

    /* renamed from: k, reason: collision with root package name */
    public final String f2719k;

    /* renamed from: l, reason: collision with root package name */
    public final String f2720l;

    public i(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f2711a = num;
        this.f2712b = str;
        this.f2713c = str2;
        this.f2714d = str3;
        this.f2715e = str4;
        this.f2716f = str5;
        this.g = str6;
        this.h = str7;
        this.f2717i = str8;
        this.f2718j = str9;
        this.f2719k = str10;
        this.f2720l = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        Integer num = this.f2711a;
        if (num != null ? num.equals(((i) aVar).f2711a) : ((i) aVar).f2711a == null) {
            String str = this.f2712b;
            if (str != null ? str.equals(((i) aVar).f2712b) : ((i) aVar).f2712b == null) {
                String str2 = this.f2713c;
                if (str2 != null ? str2.equals(((i) aVar).f2713c) : ((i) aVar).f2713c == null) {
                    String str3 = this.f2714d;
                    if (str3 != null ? str3.equals(((i) aVar).f2714d) : ((i) aVar).f2714d == null) {
                        String str4 = this.f2715e;
                        if (str4 != null ? str4.equals(((i) aVar).f2715e) : ((i) aVar).f2715e == null) {
                            String str5 = this.f2716f;
                            if (str5 != null ? str5.equals(((i) aVar).f2716f) : ((i) aVar).f2716f == null) {
                                String str6 = this.g;
                                if (str6 != null ? str6.equals(((i) aVar).g) : ((i) aVar).g == null) {
                                    String str7 = this.h;
                                    if (str7 != null ? str7.equals(((i) aVar).h) : ((i) aVar).h == null) {
                                        String str8 = this.f2717i;
                                        if (str8 != null ? str8.equals(((i) aVar).f2717i) : ((i) aVar).f2717i == null) {
                                            String str9 = this.f2718j;
                                            if (str9 != null ? str9.equals(((i) aVar).f2718j) : ((i) aVar).f2718j == null) {
                                                String str10 = this.f2719k;
                                                if (str10 != null ? str10.equals(((i) aVar).f2719k) : ((i) aVar).f2719k == null) {
                                                    String str11 = this.f2720l;
                                                    if (str11 == null) {
                                                        if (((i) aVar).f2720l == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(((i) aVar).f2720l)) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.f2711a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f2712b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f2713c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f2714d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f2715e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f2716f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.f2717i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f2718j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f2719k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f2720l;
        return (str11 != null ? str11.hashCode() : 0) ^ iHashCode11;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb.append(this.f2711a);
        sb.append(", model=");
        sb.append(this.f2712b);
        sb.append(", hardware=");
        sb.append(this.f2713c);
        sb.append(", device=");
        sb.append(this.f2714d);
        sb.append(", product=");
        sb.append(this.f2715e);
        sb.append(", osBuild=");
        sb.append(this.f2716f);
        sb.append(", manufacturer=");
        sb.append(this.g);
        sb.append(", fingerprint=");
        sb.append(this.h);
        sb.append(", locale=");
        sb.append(this.f2717i);
        sb.append(", country=");
        sb.append(this.f2718j);
        sb.append(", mccMnc=");
        sb.append(this.f2719k);
        sb.append(", applicationBuild=");
        return com.unified.ur1.SatelliteTracker.h.e(sb, this.f2720l, "}");
    }
}
