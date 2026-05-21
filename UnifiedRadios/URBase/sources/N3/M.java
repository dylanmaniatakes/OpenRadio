package N3;

import s3.C0900j;

/* loaded from: classes.dex */
public final class M implements b0, E3.l {

    /* renamed from: j, reason: collision with root package name */
    public final E3.l f1822j;

    public M(E3.l lVar) {
        this.f1822j = lVar;
    }

    public final void a(Throwable th) {
        this.f1822j.invoke(th);
    }

    @Override // E3.l
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return C0900j.f9694a;
    }

    public final String toString() {
        return "InvokeOnCancel[" + this.f1822j.getClass().getSimpleName() + '@' + AbstractC0146u.e(this) + ']';
    }
}
