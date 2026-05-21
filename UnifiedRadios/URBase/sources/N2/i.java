package n2;

/* loaded from: classes.dex */
public final class i extends e {

    /* renamed from: k, reason: collision with root package name */
    public final e f8825k;

    /* renamed from: l, reason: collision with root package name */
    public final float f8826l;

    public i(f fVar, float f5) {
        super(0);
        this.f8825k = fVar;
        this.f8826l = f5;
    }

    @Override // n2.e
    public final boolean d() {
        return this.f8825k.d();
    }

    @Override // n2.e
    public final void e(float f5, float f6, float f7, w wVar) {
        this.f8825k.e(f5, f6 - this.f8826l, f7, wVar);
    }
}
