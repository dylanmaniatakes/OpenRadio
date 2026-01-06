package k;

/* loaded from: classes.dex */
public final class I0 {

    /* renamed from: a, reason: collision with root package name */
    public int f7654a;

    /* renamed from: b, reason: collision with root package name */
    public int f7655b;

    /* renamed from: c, reason: collision with root package name */
    public int f7656c;

    /* renamed from: d, reason: collision with root package name */
    public int f7657d;

    /* renamed from: e, reason: collision with root package name */
    public int f7658e;

    /* renamed from: f, reason: collision with root package name */
    public int f7659f;
    public boolean g;
    public boolean h;

    public final void a(int i5, int i6) {
        this.f7656c = i5;
        this.f7657d = i6;
        this.h = true;
        if (this.g) {
            if (i6 != Integer.MIN_VALUE) {
                this.f7654a = i6;
            }
            if (i5 != Integer.MIN_VALUE) {
                this.f7655b = i5;
                return;
            }
            return;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.f7654a = i5;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.f7655b = i6;
        }
    }
}
