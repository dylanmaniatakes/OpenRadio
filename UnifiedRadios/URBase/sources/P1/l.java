package p1;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Object f9128a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9129b;

    public l(Object obj, String str) {
        this.f9128a = obj;
        this.f9129b = str;
    }

    public final String a() {
        return this.f9129b + "@" + System.identityHashCode(this.f9128a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f9128a == lVar.f9128a && this.f9129b.equals(lVar.f9129b);
    }

    public final int hashCode() {
        return this.f9129b.hashCode() + (System.identityHashCode(this.f9128a) * 31);
    }
}
