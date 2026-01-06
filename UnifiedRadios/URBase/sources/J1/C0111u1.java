package J1;

/* renamed from: J1.u1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0111u1 extends AbstractC0092o {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f1396e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0120x1 f1397f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0111u1(C0120x1 c0120x1, G0 g02, int i5) {
        super(g02);
        this.f1396e = i5;
        this.f1397f = c0120x1;
    }

    @Override // J1.AbstractC0092o
    public final void b() {
        switch (this.f1396e) {
            case 0:
                C0120x1 c0120x1 = this.f1397f;
                c0120x1.j();
                if (c0120x1.t()) {
                    Z z4 = ((C0113v0) c0120x1.f84c).f1417k;
                    C0113v0.k(z4);
                    z4.f1084p.a("Inactivity, disconnecting from the service");
                    c0120x1.o();
                    break;
                }
                break;
            default:
                Z z5 = ((C0113v0) this.f1397f.f84c).f1417k;
                C0113v0.k(z5);
                z5.f1080k.a("Tasks have been queued for a long time");
                break;
        }
    }
}
