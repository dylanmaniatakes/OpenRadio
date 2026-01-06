package N3;

/* renamed from: N3.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0139m {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1861a;

    /* renamed from: b, reason: collision with root package name */
    public final E3.l f1862b;

    public C0139m(Object obj, E3.l lVar) {
        this.f1861a = obj;
        this.f1862b = lVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0139m)) {
            return false;
        }
        C0139m c0139m = (C0139m) obj;
        return F3.i.a(this.f1861a, c0139m.f1861a) && F3.i.a(this.f1862b, c0139m.f1862b);
    }

    public final int hashCode() {
        Object obj = this.f1861a;
        return this.f1862b.hashCode() + ((obj == null ? 0 : obj.hashCode()) * 31);
    }

    public final String toString() {
        return "CompletedWithCancellation(result=" + this.f1861a + ", onCancellation=" + this.f1862b + ')';
    }
}
