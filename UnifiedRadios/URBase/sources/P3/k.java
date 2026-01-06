package P3;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: b, reason: collision with root package name */
    public static final j f2119b = new j();

    /* renamed from: a, reason: collision with root package name */
    public final Object f2120a;

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            return F3.i.a(this.f2120a, ((k) obj).f2120a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f2120a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f2120a;
        if (obj instanceof i) {
            return ((i) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
