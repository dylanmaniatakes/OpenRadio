package o3;

import com.unified.ur1.rfmodule.ROIP.DMRBridge;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8933j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ DMRBridge f8934k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f8935l;

    public /* synthetic */ i(DMRBridge dMRBridge, boolean z4, int i5) {
        this.f8933j = i5;
        this.f8934k = dMRBridge;
        this.f8935l = z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8933j) {
            case 0:
                k kVar = this.f8934k.f6074e;
                if (kVar != null) {
                    kVar.e(this.f8935l);
                    break;
                }
                break;
            default:
                k kVar2 = this.f8934k.f6074e;
                if (kVar2 != null) {
                    kVar2.d(this.f8935l);
                    break;
                }
                break;
        }
    }
}
