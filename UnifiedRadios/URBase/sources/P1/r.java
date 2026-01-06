package p1;

/* loaded from: classes.dex */
public final class r implements InterfaceC0827c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0832h f9135a;

    public r(C0832h c0832h) {
        this.f9135a = c0832h;
    }

    @Override // p1.InterfaceC0827c
    public final void a(boolean z4) {
        A1.f fVar = this.f9135a.n;
        fVar.sendMessage(fVar.obtainMessage(1, Boolean.valueOf(z4)));
    }
}
