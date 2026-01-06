package N;

/* loaded from: classes.dex */
public final class d extends c {

    /* renamed from: c, reason: collision with root package name */
    public final Object f1758c;

    public d(int i5) {
        super(i5);
        this.f1758c = new Object();
    }

    @Override // N.c
    public final Object a() {
        Object objA;
        synchronized (this.f1758c) {
            objA = super.a();
        }
        return objA;
    }

    @Override // N.c
    public final boolean c(Object obj) {
        boolean zC;
        synchronized (this.f1758c) {
            zC = super.c(obj);
        }
        return zC;
    }
}
