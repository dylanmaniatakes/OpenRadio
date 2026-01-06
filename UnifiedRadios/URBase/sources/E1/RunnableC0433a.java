package e1;

import android.os.Process;
import android.util.Log;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import com.unified.ur1.primary.OptionsActivity;
import com.unified.ur1.radioteams.RadioTeamsActivity;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import com.unified.ur1.rfmodule.RadioAudioService;
import m3.C0764B;
import p3.C0836b;

/* renamed from: e1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0433a implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6150j;

    public /* synthetic */ RunnableC0433a(int i5) {
        this.f6150j = i5;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f6150j) {
            case 0:
                int i5 = AlarmManagerSchedulerBroadcastReceiver.f4619a;
                break;
            case 1:
                try {
                    y1.f.t();
                    break;
                } catch (Exception unused) {
                    return;
                }
            case 2:
                int i6 = OptionsActivity.f5981H;
                Log.d("ExitDebug", "Killing process");
                Process.killProcess(Process.myPid());
                System.exit(0);
                break;
            case 3:
                int i7 = RadioTeamsActivity.f6010u;
                Log.d("RadioTeamsActivity", "User profile loaded");
                break;
            case 4:
                C0836b.b(RadioAudioService.f6082o).e();
                break;
            case 5:
                Log.i("SerialPort", "Shutdown hook triggered - cleaning up ports");
                C0764B.f8559i = true;
                C0764B c0764b = C0764B.h;
                if (c0764b != null) {
                    c0764b.d();
                    break;
                }
                break;
            default:
                boolean z4 = DMRBridge.f6068o;
                break;
        }
    }
}
