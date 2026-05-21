package k4;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public long f8287a;

    /* renamed from: b, reason: collision with root package name */
    public long f8288b;

    /* renamed from: c, reason: collision with root package name */
    public long f8289c;

    /* renamed from: d, reason: collision with root package name */
    public long f8290d;

    public p(long j5, long j6, long j7, long j8) {
        this.f8287a = j5;
        this.f8288b = j6;
        this.f8289c = j7;
        this.f8290d = j8;
    }

    public static long a(long j5, long j6, long j7, long j8, double d5, double d6) {
        return Math.round(((j5 - j7) * d5) - ((j6 - j8) * d6)) + j7;
    }

    public static long b(long j5, long j6, long j7, long j8, double d5, double d6) {
        return Math.round(((j6 - j8) * d5) + ((j5 - j7) * d6)) + j8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        return this.f8287a == pVar.f8287a && this.f8288b == pVar.f8288b && this.f8289c == pVar.f8289c && this.f8290d == pVar.f8290d;
    }

    public final int hashCode() {
        return (int) (((((((this.f8287a * 31) + this.f8288b) * 31) + this.f8289c) * 31) + this.f8290d) % 2147483647L);
    }

    public final String toString() {
        return "RectL(" + this.f8287a + ", " + this.f8288b + " - " + this.f8289c + ", " + this.f8290d + ")";
    }
}
