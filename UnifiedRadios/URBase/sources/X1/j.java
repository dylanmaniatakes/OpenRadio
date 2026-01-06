package x1;

/* loaded from: classes.dex */
public final class j implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10437a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC0960a f10438b;

    public /* synthetic */ j(AbstractC0960a abstractC0960a, int i5) {
        this.f10437a = i5;
        this.f10438b = abstractC0960a;
    }

    @Override // x1.k
    public final int a() {
        switch (this.f10437a) {
            case 0:
                return 4;
            default:
                return 5;
        }
    }

    @Override // x1.k
    public final void b() {
        switch (this.f10437a) {
            case 0:
                this.f10438b.zaa.onStart();
                break;
            default:
                this.f10438b.zaa.onResume();
                break;
        }
    }
}
