package F0;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f507j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ h f508k;

    public /* synthetic */ g(h hVar, int i5) {
        this.f507j = i5;
        this.f508k = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f507j) {
            case 0:
                h.a(this.f508k);
                break;
            default:
                h.b(this.f508k);
                break;
        }
    }
}
