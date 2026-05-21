package f3;

/* renamed from: f3.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0525p {

    /* renamed from: a, reason: collision with root package name */
    public String f6774a;

    /* renamed from: b, reason: collision with root package name */
    public String f6775b;

    /* renamed from: c, reason: collision with root package name */
    public String f6776c;

    /* renamed from: d, reason: collision with root package name */
    public int f6777d;

    /* renamed from: e, reason: collision with root package name */
    public String f6778e;

    /* renamed from: f, reason: collision with root package name */
    public int f6779f;
    public String g = "✓ Complete";
    public long h = System.currentTimeMillis();

    public C0525p(String str, String str2, String str3, int i5, String str4, int i6) {
        this.f6774a = str;
        this.f6775b = str2;
        this.f6776c = str3;
        this.f6777d = i5;
        this.f6778e = str4;
        this.f6779f = i6;
    }

    public final String toString() {
        return "LastHeardItem{callsign='" + this.f6774a + "', name='" + this.f6775b + "', location='" + this.f6776c + "', talkgroup=" + this.f6777d + ", time='" + this.f6778e + "', duration=" + this.f6779f + ", status='" + this.g + "', timestamp=" + this.h + '}';
    }
}
