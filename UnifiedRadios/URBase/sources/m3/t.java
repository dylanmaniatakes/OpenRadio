package m3;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.RadioAudioService;
import k3.RunnableC0687g0;
import k3.Y;

/* loaded from: classes.dex */
public final /* synthetic */ class t implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8634j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ RadioAudioService f8635k;

    public /* synthetic */ t(RadioAudioService radioAudioService, int i5) {
        this.f8634j = i5;
        this.f8635k = radioAudioService;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        int i5 = 20;
        int i6 = 0;
        int i7 = 1;
        RadioAudioService radioAudioService = this.f8635k;
        switch (this.f8634j) {
            case 0:
                byte[] bArr = RadioAudioService.f6081m;
                radioAudioService.getClass();
                try {
                    Log.d("Unified", "Starting radio initialization sequence");
                    Context context = LaunchActivity.f5853D1;
                    if (!C0764B.e().f()) {
                        throw new RuntimeException("Failed to initialize control port");
                    }
                    Log.d("Unified", "Control port initialized successfully");
                    Log.d("Unified", "CJ1 hardware Starting");
                    y1.f.t();
                    Thread.sleep(DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
                    radioAudioService.f6090l = C0774j.a();
                    if (h4.c.C(radioAudioService).getString("radio_mode", "").equals("FM")) {
                        new L0.s(radioAudioService.f6090l, i5, RadioAudioService.f6082o).y();
                    } else {
                        new L0.s(radioAudioService.f6090l, i5, RadioAudioService.f6082o).A();
                    }
                    if (radioAudioService.g != null) {
                        new Handler(Looper.getMainLooper()).post(new t(radioAudioService, i7));
                        return;
                    }
                    return;
                } catch (Exception e5) {
                    Log.e("Unified", "Radio initialization failed", e5);
                    Log.e("Unified", "Initialization failed", e5);
                    Log.d("Unified", "Cleaning up PTT resources");
                    radioAudioService.f6086f = 0;
                    Log.d("Unified", "PTT cleanup complete");
                    if (radioAudioService.g != null) {
                        new Handler(Looper.getMainLooper()).post(new t(radioAudioService, 2));
                        return;
                    }
                    return;
                }
            case 1:
                B0.l lVar = radioAudioService.g;
                ((Y) lVar.f110d).f8098b.runOnUiThread(new RunnableC0687g0(lVar, i6));
                return;
            default:
                B0.l lVar2 = radioAudioService.g;
                ((Y) lVar2.f110d).f8098b.runOnUiThread(new RunnableC0687g0(lVar2, i7));
                return;
        }
    }
}
