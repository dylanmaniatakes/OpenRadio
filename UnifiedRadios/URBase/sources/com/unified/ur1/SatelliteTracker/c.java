package com.unified.ur1.SatelliteTracker;

import com.unified.ur1.SatelliteTracker.FullscreenMapActivity;
import java.io.IOException;
import org.json.JSONException;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f5577j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ FullscreenMapActivity.AnonymousClass1 f5578k;

    public /* synthetic */ c(FullscreenMapActivity.AnonymousClass1 anonymousClass1, int i5) {
        this.f5577j = i5;
        this.f5578k = anonymousClass1;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException, IOException {
        switch (this.f5577j) {
            case 0:
                this.f5578k.lambda$run$1();
                break;
            case 1:
                this.f5578k.lambda$run$2();
                break;
            default:
                this.f5578k.lambda$run$0();
                break;
        }
    }
}
