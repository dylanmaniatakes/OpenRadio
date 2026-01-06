package r;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public Object f9503a;

    /* renamed from: b, reason: collision with root package name */
    public j f9504b;

    /* renamed from: c, reason: collision with root package name */
    public k f9505c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9506d;

    public final void finalize() {
        k kVar;
        j jVar = this.f9504b;
        if (jVar != null) {
            i iVar = jVar.f9509k;
            if (!iVar.isDone()) {
                iVar.j(new N0.b("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f9503a, 2));
            }
        }
        if (this.f9506d || (kVar = this.f9505c) == null) {
            return;
        }
        kVar.i(null);
    }
}
