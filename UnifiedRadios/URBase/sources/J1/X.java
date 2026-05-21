package J1;

/* loaded from: classes.dex */
public final class X {

    /* renamed from: a, reason: collision with root package name */
    public final int f1053a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1054b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1055c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Z f1056d;

    public X(Z z4, int i5, boolean z5, boolean z6) {
        this.f1056d = z4;
        this.f1053a = i5;
        this.f1054b = z5;
        this.f1055c = z6;
    }

    public final void a(String str) {
        this.f1056d.u(this.f1053a, this.f1054b, this.f1055c, str, null, null, null);
    }

    public final void b(Object obj, String str) {
        this.f1056d.u(this.f1053a, this.f1054b, this.f1055c, str, obj, null, null);
    }

    public final void c(Object obj, Object obj2, String str) {
        this.f1056d.u(this.f1053a, this.f1054b, this.f1055c, str, obj, obj2, null);
    }

    public final void d(String str, Object obj, Object obj2, Object obj3) {
        this.f1056d.u(this.f1053a, this.f1054b, this.f1055c, str, obj, obj2, obj3);
    }
}
