package C0;

/* loaded from: classes.dex */
public final class o extends r {

    /* renamed from: a, reason: collision with root package name */
    public final h f166a = h.f157c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        return this.f166a.equals(((o) obj).f166a);
    }

    public final int hashCode() {
        return this.f166a.hashCode() + (o.class.getName().hashCode() * 31);
    }

    public final String toString() {
        return "Failure {mOutputData=" + this.f166a + '}';
    }
}
