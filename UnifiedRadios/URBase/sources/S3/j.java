package S3;

import N3.AbstractC0146u;

/* loaded from: classes.dex */
public final /* synthetic */ class j extends F3.c implements E3.a, K3.a {

    /* renamed from: p, reason: collision with root package name */
    public final boolean f2400p;

    public j(Object obj) {
        super(obj, AbstractC0146u.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", true);
        this.f2400p = false;
    }

    public final K3.a b() {
        if (!this.f2400p) {
            K3.a aVar = this.f590j;
            if (aVar != null) {
                return aVar;
            }
            d();
            this.f590j = this;
        }
        return this;
    }

    public final K3.a d() {
        F3.m.f603a.getClass();
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            return a().equals(jVar.a()) && this.f593m.equals(jVar.f593m) && this.n.equals(jVar.n) && F3.i.a(this.f591k, jVar.f591k);
        }
        if (obj instanceof j) {
            return obj.equals(b());
        }
        return false;
    }

    public final int hashCode() {
        return this.n.hashCode() + ((this.f593m.hashCode() + (a().hashCode() * 31)) * 31);
    }

    @Override // E3.a
    public final Object invoke() {
        return this.f591k.getClass().getSimpleName();
    }

    public final String toString() {
        K3.a aVarB = b();
        return aVarB != this ? aVarB.toString() : com.unified.ur1.SatelliteTracker.h.e(new StringBuilder("property "), this.f593m, " (Kotlin reflection is not available)");
    }
}
