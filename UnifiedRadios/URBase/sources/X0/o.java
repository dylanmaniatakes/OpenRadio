package X0;

/* loaded from: classes.dex */
public final class o extends w {

    /* renamed from: a, reason: collision with root package name */
    public final v f2737a;

    /* renamed from: b, reason: collision with root package name */
    public final u f2738b;

    public o(v vVar, u uVar) {
        this.f2737a = vVar;
        this.f2738b = uVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        v vVar = this.f2737a;
        if (vVar != null ? vVar.equals(((o) wVar).f2737a) : ((o) wVar).f2737a == null) {
            u uVar = this.f2738b;
            if (uVar == null) {
                if (((o) wVar).f2738b == null) {
                    return true;
                }
            } else if (uVar.equals(((o) wVar).f2738b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        v vVar = this.f2737a;
        int iHashCode = ((vVar == null ? 0 : vVar.hashCode()) ^ 1000003) * 1000003;
        u uVar = this.f2738b;
        return (uVar != null ? uVar.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f2737a + ", mobileSubtype=" + this.f2738b + "}";
    }
}
