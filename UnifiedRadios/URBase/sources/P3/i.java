package P3;

/* loaded from: classes.dex */
public final class i extends j {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f2118a;

    public i(Throwable th) {
        this.f2118a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            if (F3.i.a(this.f2118a, ((i) obj).f2118a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f2118a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // P3.j
    public final String toString() {
        return "Closed(" + this.f2118a + ')';
    }
}
