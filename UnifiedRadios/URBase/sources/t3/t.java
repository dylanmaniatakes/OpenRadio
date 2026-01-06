package t3;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final int f9714a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f9715b;

    public t(int i5, Object obj) {
        this.f9714a = i5;
        this.f9715b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f9714a == tVar.f9714a && F3.i.a(this.f9715b, tVar.f9715b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f9714a) * 31;
        Object obj = this.f9715b;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "IndexedValue(index=" + this.f9714a + ", value=" + this.f9715b + ')';
    }
}
