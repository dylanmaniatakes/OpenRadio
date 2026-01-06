package k3;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.unified.ur1.listener.VolumeControlService;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.RadioAudioService;
import m3.BinderC0772h;

/* loaded from: classes.dex */
public final class Y implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8097a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8098b;

    public /* synthetic */ Y(LaunchActivity launchActivity, int i5) {
        this.f8097a = i5;
        this.f8098b = launchActivity;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        androidx.lifecycle.B b5;
        LaunchActivity launchActivity = this.f8098b;
        switch (this.f8097a) {
            case 0:
                launchActivity.f5930h1 = ((BinderC0772h) iBinder).f8606c;
                launchActivity.f5928g1 = true;
                break;
            case 1:
                VolumeControlService volumeControlService = ((j3.d) iBinder).f7611c;
                Context context = LaunchActivity.f5853D1;
                launchActivity.getClass();
                launchActivity.getClass();
                Log.d("Unified - Main Activity", "Volume control service connected");
                break;
            default:
                RadioAudioService radioAudioService = ((m3.u) iBinder).f8636c;
                launchActivity.f5965u = radioAudioService;
                try {
                    radioAudioService.g = new B0.l(21, this);
                    C0 c02 = launchActivity.f5919d0;
                    if (c02 != null && (b5 = c02.f7948e) != null) {
                        radioAudioService.h = b5;
                    }
                    radioAudioService.d();
                    break;
                } catch (Exception e5) {
                    com.unified.ur1.SatelliteTracker.h.o(e5, new StringBuilder("Error setting up radio service: "), "Unified - Main Activity");
                }
                break;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        LaunchActivity launchActivity = this.f8098b;
        switch (this.f8097a) {
            case 0:
                launchActivity.f5930h1 = null;
                launchActivity.f5928g1 = false;
                break;
            case 1:
                Context context = LaunchActivity.f5853D1;
                launchActivity.getClass();
                launchActivity.getClass();
                Log.d("Unified - Main Activity", "Volume control service disconnected");
                break;
            default:
                launchActivity.f5965u = null;
                break;
        }
    }
}
