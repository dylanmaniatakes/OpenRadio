package r;

/* loaded from: classes.dex */
public final class i extends g {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ j f9507q;

    public i(j jVar) {
        this.f9507q = jVar;
    }

    @Override // r.g
    public final String g() {
        h hVar = (h) this.f9507q.f9508j.get();
        if (hVar == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        return "tag=[" + hVar.f9503a + "]";
    }
}
