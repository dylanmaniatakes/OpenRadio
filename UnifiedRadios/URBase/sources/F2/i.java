package F2;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final r f561a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f562b;

    public i(r rVar, boolean z4) {
        this.f561a = rVar;
        this.f562b = z4;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return iVar.f561a.equals(this.f561a) && iVar.f562b == this.f562b;
    }

    public final int hashCode() {
        return ((this.f561a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f562b).hashCode();
    }
}
