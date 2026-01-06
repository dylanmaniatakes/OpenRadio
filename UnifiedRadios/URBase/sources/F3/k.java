package F3;

/* loaded from: classes.dex */
public final class k implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Class f601a;

    public k(Class cls) {
        i.f(cls, "jClass");
        this.f601a = cls;
    }

    @Override // F3.d
    public final Class a() {
        return this.f601a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            if (i.a(this.f601a, ((k) obj).f601a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f601a.hashCode();
    }

    public final String toString() {
        return this.f601a.toString() + " (Kotlin reflection is not available)";
    }
}
