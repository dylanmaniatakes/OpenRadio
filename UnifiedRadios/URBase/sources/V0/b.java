package V0;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f2510a;

    public b(Integer num) {
        this.f2510a = num;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        Integer num = this.f2510a;
        return num == null ? bVar.f2510a == null : num.equals(bVar.f2510a);
    }

    public final int hashCode() {
        Integer num = this.f2510a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public final String toString() {
        return "ProductData{productId=" + this.f2510a + "}";
    }
}
