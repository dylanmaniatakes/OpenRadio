package C0;

/* loaded from: classes.dex */
public final class q extends r {

    /* renamed from: a, reason: collision with root package name */
    public final h f167a;

    public q(h hVar) {
        this.f167a = hVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        return this.f167a.equals(((q) obj).f167a);
    }

    public final int hashCode() {
        return this.f167a.hashCode() + (q.class.getName().hashCode() * 31);
    }

    public final String toString() {
        return "Success {mOutputData=" + this.f167a + '}';
    }
}
