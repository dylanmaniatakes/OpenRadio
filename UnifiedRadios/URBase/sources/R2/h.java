package R2;

/* loaded from: classes.dex */
public final class h implements j {

    /* renamed from: a, reason: collision with root package name */
    public final N1.k f2297a;

    public h(N1.k kVar) {
        this.f2297a = kVar;
    }

    @Override // R2.j
    public final boolean a(S2.b bVar) {
        int i5 = bVar.f2369b;
        if (i5 != 3 && i5 != 4 && i5 != 5) {
            return false;
        }
        this.f2297a.c(bVar.f2368a);
        return true;
    }

    @Override // R2.j
    public final boolean b(Exception exc) {
        return false;
    }
}
