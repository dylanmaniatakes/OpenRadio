package com.unified.ur1.SatelliteTracker;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f5580j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ SatelliteTrackerActivity f5581k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Exception f5582l;

    public /* synthetic */ e(SatelliteTrackerActivity satelliteTrackerActivity, Exception exc, int i5) {
        this.f5580j = i5;
        this.f5581k = satelliteTrackerActivity;
        this.f5582l = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5580j) {
            case 0:
                this.f5581k.lambda$updateSatelliteCalculations$13(this.f5582l);
                break;
            case 1:
                this.f5581k.lambda$updateSatelliteData$7(this.f5582l);
                break;
            default:
                this.f5581k.lambda$onCreate$0(this.f5582l);
                break;
        }
    }
}
