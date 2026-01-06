package L0;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f1551a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1552b;

    public j(String str, int i5) {
        F3.i.f(str, "workSpecId");
        this.f1551a = str;
        this.f1552b = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return F3.i.a(this.f1551a, jVar.f1551a) && this.f1552b == jVar.f1552b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f1552b) + (this.f1551a.hashCode() * 31);
    }

    public final String toString() {
        return "WorkGenerationalId(workSpecId=" + this.f1551a + ", generation=" + this.f1552b + ')';
    }
}
