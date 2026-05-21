package L0;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f1538a;

    /* renamed from: b, reason: collision with root package name */
    public final Long f1539b;

    public d(String str, Long l5) {
        this.f1538a = str;
        this.f1539b = l5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return F3.i.a(this.f1538a, dVar.f1538a) && F3.i.a(this.f1539b, dVar.f1539b);
    }

    public final int hashCode() {
        int iHashCode = this.f1538a.hashCode() * 31;
        Long l5 = this.f1539b;
        return iHashCode + (l5 == null ? 0 : l5.hashCode());
    }

    public final String toString() {
        return "Preference(key=" + this.f1538a + ", value=" + this.f1539b + ')';
    }
}
