package M2;

/* loaded from: classes.dex */
public final class h implements J2.g {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1736a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1737b = false;

    /* renamed from: c, reason: collision with root package name */
    public J2.c f1738c;

    /* renamed from: d, reason: collision with root package name */
    public final f f1739d;

    public h(f fVar) {
        this.f1739d = fVar;
    }

    @Override // J2.g
    public final J2.g c(String str) {
        if (this.f1736a) {
            throw new J2.b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f1736a = true;
        this.f1739d.d(this.f1738c, str, this.f1737b);
        return this;
    }

    @Override // J2.g
    public final J2.g d(boolean z4) {
        if (this.f1736a) {
            throw new J2.b("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f1736a = true;
        this.f1739d.c(this.f1738c, z4 ? 1 : 0, this.f1737b);
        return this;
    }
}
