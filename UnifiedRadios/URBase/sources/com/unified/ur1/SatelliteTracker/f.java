package com.unified.ur1.SatelliteTracker;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f5583j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ SatelliteTrackerActivity f5584k;

    public /* synthetic */ f(SatelliteTrackerActivity satelliteTrackerActivity, int i5) {
        this.f5583j = i5;
        this.f5584k = satelliteTrackerActivity;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException {
        switch (this.f5583j) {
            case 0:
                this.f5584k.lambda$onLocationChanged$2();
                break;
            case 1:
                this.f5584k.lambda$updateSatelliteData$8();
                break;
            case 2:
                this.f5584k.lambda$updateSatelliteData$3();
                break;
            case 3:
                this.f5584k.lambda$updateSatelliteData$4();
                break;
            case 4:
                this.f5584k.lambda$updateSatelliteData$5();
                break;
            case 5:
                this.f5584k.lambda$updateSatelliteData$6();
                break;
            case 6:
                this.f5584k.performInitialDataLoad();
                break;
            case 7:
                this.f5584k.startRealtimeMapUpdates();
                break;
            case 8:
                this.f5584k.startAutoRefresh();
                break;
            default:
                this.f5584k.lambda$updateSatelliteCalculations$10();
                break;
        }
    }
}
