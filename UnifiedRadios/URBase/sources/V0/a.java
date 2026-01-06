package V0;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2508a;

    /* renamed from: b, reason: collision with root package name */
    public final b f2509b;

    public a(Y2.e eVar, b bVar) {
        this.f2508a = eVar;
        this.f2509b = bVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        aVar.getClass();
        if (this.f2508a.equals(aVar.f2508a)) {
            Object obj2 = d.f2512j;
            if (obj2.equals(obj2)) {
                b bVar = aVar.f2509b;
                b bVar2 = this.f2509b;
                if (bVar2 == null) {
                    if (bVar == null) {
                        return true;
                    }
                } else if (bVar2.equals(bVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((((1000003 * 1000003) ^ this.f2508a.hashCode()) * 1000003) ^ d.f2512j.hashCode()) * 1000003;
        b bVar = this.f2509b;
        return (bVar == null ? 0 : bVar.hashCode()) ^ iHashCode;
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.f2508a + ", priority=" + d.f2512j + ", productData=" + this.f2509b + "}";
    }
}
