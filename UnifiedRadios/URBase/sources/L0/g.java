package L0;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f1543a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1544b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1545c;

    public g(String str, int i5, int i6) {
        F3.i.f(str, "workSpecId");
        this.f1543a = str;
        this.f1544b = i5;
        this.f1545c = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return F3.i.a(this.f1543a, gVar.f1543a) && this.f1544b == gVar.f1544b && this.f1545c == gVar.f1545c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f1545c) + ((Integer.hashCode(this.f1544b) + (this.f1543a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "SystemIdInfo(workSpecId=" + this.f1543a + ", generation=" + this.f1544b + ", systemId=" + this.f1545c + ')';
    }
}
