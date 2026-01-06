package com.unified.ur1.SatelliteTracker;

import java.io.IOException;
import org.json.JSONException;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f5575j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ FullscreenMapActivity f5576k;

    public /* synthetic */ b(FullscreenMapActivity fullscreenMapActivity, int i5) {
        this.f5575j = i5;
        this.f5576k = fullscreenMapActivity;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException, IOException {
        switch (this.f5575j) {
            case 0:
                this.f5576k.lambda$fetchSatelliteData$4();
                break;
            case 1:
                this.f5576k.lambda$fetchSatelliteDataAndStartUpdates$2();
                break;
            case 2:
                this.f5576k.lambda$fetchSatelliteDataAndStartUpdates$1();
                break;
            default:
                this.f5576k.lambda$fetchSatelliteDataAndStartUpdates$0();
                break;
        }
    }
}
