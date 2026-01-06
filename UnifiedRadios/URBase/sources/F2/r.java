package F2;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final Class f578a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f579b;

    public r(Class cls, Class cls2) {
        this.f578a = cls;
        this.f579b = cls2;
    }

    public static r a(Class cls) {
        return new r(q.class, cls);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f579b.equals(rVar.f579b)) {
            return this.f578a.equals(rVar.f578a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f578a.hashCode() + (this.f579b.hashCode() * 31);
    }

    public final String toString() {
        Class cls = this.f579b;
        Class cls2 = this.f578a;
        if (cls2 == q.class) {
            return cls.getName();
        }
        return "@" + cls2.getName() + " " + cls.getName();
    }
}
