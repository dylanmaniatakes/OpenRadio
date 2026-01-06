package f3;

import java.util.ArrayList;
import java.util.List;

/* renamed from: f3.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0532x {

    /* renamed from: A, reason: collision with root package name */
    public final String f6821A;

    /* renamed from: B, reason: collision with root package name */
    public final int f6822B;

    /* renamed from: C, reason: collision with root package name */
    public final int f6823C;

    /* renamed from: D, reason: collision with root package name */
    public final int f6824D;

    /* renamed from: E, reason: collision with root package name */
    public final String f6825E;

    /* renamed from: F, reason: collision with root package name */
    public final List f6826F;

    /* renamed from: G, reason: collision with root package name */
    public final List f6827G;

    /* renamed from: a, reason: collision with root package name */
    public final String f6828a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6829b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6830c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6831d;

    /* renamed from: e, reason: collision with root package name */
    public final String f6832e;

    /* renamed from: f, reason: collision with root package name */
    public final double f6833f;
    public final double g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final int f6834i;

    /* renamed from: j, reason: collision with root package name */
    public final int f6835j;

    /* renamed from: k, reason: collision with root package name */
    public final int f6836k;

    /* renamed from: l, reason: collision with root package name */
    public final int f6837l;

    /* renamed from: m, reason: collision with root package name */
    public final String f6838m;
    public final String n;

    /* renamed from: o, reason: collision with root package name */
    public final String f6839o;

    /* renamed from: p, reason: collision with root package name */
    public final String f6840p;

    /* renamed from: q, reason: collision with root package name */
    public final String f6841q;

    /* renamed from: r, reason: collision with root package name */
    public final String f6842r;

    /* renamed from: s, reason: collision with root package name */
    public final String f6843s;

    /* renamed from: t, reason: collision with root package name */
    public final String f6844t;

    /* renamed from: u, reason: collision with root package name */
    public final String f6845u;

    /* renamed from: v, reason: collision with root package name */
    public final String f6846v;

    /* renamed from: w, reason: collision with root package name */
    public final String f6847w;

    /* renamed from: x, reason: collision with root package name */
    public final String f6848x;

    /* renamed from: y, reason: collision with root package name */
    public final int f6849y;

    /* renamed from: z, reason: collision with root package name */
    public final String f6850z;

    public C0532x(String str, String str2, String str3, String str4, String str5, double d5, double d6, int i5, int i6, int i7, int i8, int i9, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i10, String str18, String str19, int i11, int i12, int i13, String str20, ArrayList arrayList, ArrayList arrayList2) {
        String str21 = str5;
        this.f6828a = str;
        this.f6829b = str2;
        this.f6830c = str3;
        this.f6831d = str4;
        if ("FMW".equals(str5)) {
            str21 = "FM";
        } else if ("FMN".equals(str5)) {
            str21 = "FMN";
        }
        this.f6832e = str21;
        this.f6833f = d5;
        this.g = d6;
        this.h = i5;
        this.f6834i = i6;
        this.f6835j = i7;
        this.f6836k = i8;
        this.f6837l = i9;
        this.f6838m = str6;
        this.n = str7;
        this.f6839o = str8;
        this.f6840p = str9;
        this.f6841q = str10;
        this.f6842r = str11;
        this.f6843s = str12;
        this.f6844t = str13;
        this.f6845u = str14;
        this.f6846v = str15;
        this.f6847w = str16;
        this.f6848x = str17;
        this.f6849y = i10;
        this.f6850z = str18;
        this.f6821A = str19;
        this.f6822B = i11;
        this.f6823C = i12;
        this.f6824D = i13;
        this.f6825E = str20 != null ? str20 : "No";
        this.f6826F = arrayList;
        this.f6827G = arrayList2;
    }

    public final String a(int i5) {
        List list = this.f6826F;
        if (list == null || i5 < 0 || i5 >= list.size()) {
            return null;
        }
        return (String) list.get(i5);
    }

    public final int b() {
        List list = this.f6826F;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final String c(int i5) {
        List list = this.f6827G;
        if (list == null || i5 < 0 || i5 >= list.size()) {
            return null;
        }
        return (String) list.get(i5);
    }

    public final boolean d() {
        String str = this.f6832e;
        return "DMR".equals(str) || ("IP".equals(str) && "DMR".equals(this.f6845u));
    }

    public final boolean e() {
        return "Yes".equals(this.f6825E);
    }

    public final boolean f() {
        return "Yes".equals(this.n) || "IP".equals(this.f6832e);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MemoryChannel{name='");
        sb.append(this.f6828a);
        sb.append("', zone='");
        sb.append(this.f6829b);
        sb.append("', rxFreq='");
        sb.append(this.f6830c);
        sb.append("', txFreq='");
        sb.append(this.f6831d);
        sb.append("', mode='");
        sb.append(this.f6832e);
        sb.append("', power='");
        sb.append(this.f6839o);
        sb.append("', dmrNetwork='");
        sb.append(this.f6840p);
        sb.append("', contactDescription='");
        sb.append(this.f6841q);
        sb.append("', encrypt='");
        sb.append(this.f6843s);
        sb.append("', roipServer='");
        sb.append(this.f6847w);
        sb.append("', hasBmApi=");
        String str = this.f6821A;
        sb.append((str == null || str.isEmpty()) ? false : true);
        sb.append(", multiRx='");
        sb.append(this.f6825E);
        sb.append("', multiContactCount=");
        sb.append(b());
        sb.append('}');
        return sb.toString();
    }
}
