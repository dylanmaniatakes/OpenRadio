package H0;

/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: a, reason: collision with root package name */
    public final int f645a;

    public b(int i5) {
        this.f645a = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.f645a == ((b) obj).f645a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f645a);
    }

    public final String toString() {
        return "ConstraintsNotMet(reason=" + this.f645a + ')';
    }
}
