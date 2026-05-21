package N3;

import s3.C0900j;

/* loaded from: classes.dex */
public final class V extends U {
    public final Y n;

    /* renamed from: o, reason: collision with root package name */
    public final W f1827o;

    /* renamed from: p, reason: collision with root package name */
    public final C0135i f1828p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f1829q;

    public V(Y y4, W w4, C0135i c0135i, Object obj) {
        this.n = y4;
        this.f1827o = w4;
        this.f1828p = c0135i;
        this.f1829q = obj;
    }

    @Override // E3.l
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        l((Throwable) obj);
        return C0900j.f9694a;
    }

    @Override // N3.U
    public final void l(Throwable th) {
        Y y4 = this.n;
        y4.getClass();
        C0135i c0135iJ = Y.J(this.f1828p);
        W w4 = this.f1827o;
        Object obj = this.f1829q;
        if (c0135iJ == null || !y4.Q(w4, c0135iJ, obj)) {
            y4.l(y4.v(w4, obj));
        }
    }
}
