package R2;

/* loaded from: classes.dex */
public final class g implements j {

    /* renamed from: a, reason: collision with root package name */
    public final k f2295a;

    /* renamed from: b, reason: collision with root package name */
    public final N1.k f2296b;

    public g(k kVar, N1.k kVar2) {
        this.f2295a = kVar;
        this.f2296b = kVar2;
    }

    @Override // R2.j
    public final boolean a(S2.b bVar) {
        if (bVar.f2369b != 4 || this.f2295a.a(bVar)) {
            return false;
        }
        String str = bVar.f2370c;
        if (str == null) {
            throw new NullPointerException("Null token");
        }
        this.f2296b.a(new a(str, bVar.f2372e, bVar.f2373f));
        return true;
    }

    @Override // R2.j
    public final boolean b(Exception exc) {
        this.f2296b.b(exc);
        return true;
    }
}
