package k4;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public long f8285a;

    /* renamed from: b, reason: collision with root package name */
    public long f8286b;

    public final void a(o oVar) {
        this.f8285a = oVar.f8285a;
        this.f8286b = oVar.f8286b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f8285a == oVar.f8285a && this.f8286b == oVar.f8286b;
    }

    public final String toString() {
        return "PointL(" + this.f8285a + ", " + this.f8286b + ")";
    }
}
