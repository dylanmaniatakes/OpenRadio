package f3;

/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f6745a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6746b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6747c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6748d;

    /* renamed from: e, reason: collision with root package name */
    public final String f6749e;

    /* renamed from: f, reason: collision with root package name */
    public int f6750f;
    public final String g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final double f6751i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6752j = false;

    /* renamed from: k, reason: collision with root package name */
    public String f6753k = "";

    /* renamed from: l, reason: collision with root package name */
    public final String f6754l;

    /* renamed from: m, reason: collision with root package name */
    public final String f6755m;
    public double n;

    /* renamed from: o, reason: collision with root package name */
    public double f6756o;

    /* renamed from: p, reason: collision with root package name */
    public final String f6757p;

    /* renamed from: q, reason: collision with root package name */
    public final String f6758q;

    public m0(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i5, String str8, String str9, String str10, double d5) throws NumberFormatException {
        this.f6745a = str;
        this.f6747c = str2;
        this.f6758q = str3;
        this.f6757p = str2;
        this.f6748d = str4;
        this.f6755m = str5;
        this.f6754l = str6;
        this.f6749e = str7;
        this.f6750f = i5;
        this.g = str8;
        this.h = str9;
        this.f6751i = d5;
        this.f6746b = str10;
        if (str8 == null || str8.isEmpty()) {
            return;
        }
        try {
            for (String str11 : str8.split("/")) {
                if (str11.startsWith("CC")) {
                    Integer.parseInt(str11.substring(2));
                } else if (str11.startsWith("TS")) {
                    Integer.parseInt(str11.substring(2));
                } else if (str11.startsWith("TG")) {
                    Integer.parseInt(str11.substring(2));
                }
            }
        } catch (Exception unused) {
        }
    }
}
