package X0;

/* loaded from: classes.dex */
public final class k extends r {

    /* renamed from: a, reason: collision with root package name */
    public final q f2722a = q.f2739j;

    /* renamed from: b, reason: collision with root package name */
    public final a f2723b;

    public k(i iVar) {
        this.f2723b = iVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        q qVar = this.f2722a;
        if (qVar != null ? qVar.equals(((k) rVar).f2722a) : ((k) rVar).f2722a == null) {
            a aVar = this.f2723b;
            if (aVar == null) {
                if (((k) rVar).f2723b == null) {
                    return true;
                }
            } else if (aVar.equals(((k) rVar).f2723b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        q qVar = this.f2722a;
        int iHashCode = ((qVar == null ? 0 : qVar.hashCode()) ^ 1000003) * 1000003;
        a aVar = this.f2723b;
        return (aVar != null ? aVar.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        return "ClientInfo{clientType=" + this.f2722a + ", androidClientInfo=" + this.f2723b + "}";
    }
}
