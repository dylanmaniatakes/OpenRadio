package N3;

/* loaded from: classes.dex */
public final class D implements K {

    /* renamed from: j, reason: collision with root package name */
    public final boolean f1813j;

    public D(boolean z4) {
        this.f1813j = z4;
    }

    @Override // N3.K
    public final boolean a() {
        return this.f1813j;
    }

    @Override // N3.K
    public final Z e() {
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Empty{");
        sb.append(this.f1813j ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
