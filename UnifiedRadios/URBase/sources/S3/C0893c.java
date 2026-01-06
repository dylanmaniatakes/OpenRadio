package s3;

/* renamed from: s3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0893c implements Comparable {

    /* renamed from: k, reason: collision with root package name */
    public static final C0893c f9685k = new C0893c();

    /* renamed from: j, reason: collision with root package name */
    public final int f9686j;

    public C0893c() {
        if (!new J3.c(0, 255, 1).a(1) || !new J3.c(0, 255, 1).a(9) || !new J3.c(0, 255, 1).a(10)) {
            throw new IllegalArgumentException("Version components are out of range: 1.9.10".toString());
        }
        this.f9686j = 67850;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C0893c c0893c = (C0893c) obj;
        F3.i.f(c0893c, "other");
        return this.f9686j - c0893c.f9686j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        C0893c c0893c = obj instanceof C0893c ? (C0893c) obj : null;
        return c0893c != null && this.f9686j == c0893c.f9686j;
    }

    public final int hashCode() {
        return this.f9686j;
    }

    public final String toString() {
        return "1.9.10";
    }
}
