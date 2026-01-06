package J1;

/* renamed from: J1.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0103s {

    /* renamed from: a, reason: collision with root package name */
    public final String f1369a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1370b;

    /* renamed from: c, reason: collision with root package name */
    public final long f1371c;

    /* renamed from: d, reason: collision with root package name */
    public final long f1372d;

    /* renamed from: e, reason: collision with root package name */
    public final long f1373e;

    /* renamed from: f, reason: collision with root package name */
    public final long f1374f;
    public final long g;
    public final Long h;

    /* renamed from: i, reason: collision with root package name */
    public final Long f1375i;

    /* renamed from: j, reason: collision with root package name */
    public final Long f1376j;

    /* renamed from: k, reason: collision with root package name */
    public final Boolean f1377k;

    public C0103s(String str, String str2, long j5, long j6, long j7, long j8, long j9, Long l5, Long l6, Long l7, Boolean bool) {
        q1.E.f(str);
        q1.E.f(str2);
        q1.E.a(j5 >= 0);
        q1.E.a(j6 >= 0);
        q1.E.a(j7 >= 0);
        q1.E.a(j9 >= 0);
        this.f1369a = str;
        this.f1370b = str2;
        this.f1371c = j5;
        this.f1372d = j6;
        this.f1373e = j7;
        this.f1374f = j8;
        this.g = j9;
        this.h = l5;
        this.f1375i = l6;
        this.f1376j = l7;
        this.f1377k = bool;
    }

    public final C0103s a(Long l5, Long l6, Boolean bool) {
        return new C0103s(this.f1369a, this.f1370b, this.f1371c, this.f1372d, this.f1373e, this.f1374f, this.g, this.h, l5, l6, bool);
    }
}
