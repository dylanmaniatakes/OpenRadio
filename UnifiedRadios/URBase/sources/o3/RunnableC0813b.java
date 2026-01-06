package o3;

import com.unified.ur1.rfmodule.ROIP.DMRActivity;

/* renamed from: o3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0813b implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8915j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ DMRActivity f8916k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f8917l;

    public /* synthetic */ RunnableC0813b(DMRActivity dMRActivity, boolean z4, int i5) {
        this.f8915j = i5;
        this.f8916k = dMRActivity;
        this.f8917l = z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z4 = this.f8917l;
        DMRActivity dMRActivity = this.f8916k;
        switch (this.f8915j) {
            case 0:
                int i5 = DMRActivity.f6054s;
                dMRActivity.l(z4);
                break;
            default:
                int i6 = DMRActivity.f6054s;
                dMRActivity.m(z4);
                break;
        }
    }
}
