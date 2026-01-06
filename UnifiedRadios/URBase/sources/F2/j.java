package F2;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final r f563a;

    /* renamed from: b, reason: collision with root package name */
    public final int f564b;

    /* renamed from: c, reason: collision with root package name */
    public final int f565c;

    public j(int i5, int i6, Class cls) {
        this(r.a(cls), i5, i6);
    }

    public static j a(Class cls) {
        return new j(1, 0, cls);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f563a.equals(jVar.f563a) && this.f564b == jVar.f564b && this.f565c == jVar.f565c;
    }

    public final int hashCode() {
        return ((((this.f563a.hashCode() ^ 1000003) * 1000003) ^ this.f564b) * 1000003) ^ this.f565c;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f563a);
        sb.append(", type=");
        int i5 = this.f564b;
        sb.append(i5 == 1 ? "required" : i5 == 0 ? "optional" : "set");
        sb.append(", injection=");
        int i6 = this.f565c;
        if (i6 == 0) {
            str = "direct";
        } else if (i6 == 1) {
            str = "provider";
        } else {
            if (i6 != 2) {
                throw new AssertionError(com.unified.ur1.SatelliteTracker.h.a(i6, "Unsupported injection: "));
            }
            str = "deferred";
        }
        return com.unified.ur1.SatelliteTracker.h.e(sb, str, "}");
    }

    public j(r rVar, int i5, int i6) {
        this.f563a = rVar;
        this.f564b = i5;
        this.f565c = i6;
    }
}
