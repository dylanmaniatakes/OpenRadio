package o3;

import android.content.Intent;
import android.os.Looper;
import android.util.Log;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import e0.C0432c;
import e1.RunnableC0433a;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8926j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ DMRBridge f8927k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f8928l;

    public /* synthetic */ g(DMRBridge dMRBridge, int i5, int i6) {
        this.f8926j = i6;
        this.f8927k = dMRBridge;
        this.f8928l = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DMRBridge dMRBridge = this.f8927k;
        int i5 = this.f8928l;
        switch (this.f8926j) {
            case 0:
                boolean z4 = DMRBridge.f6068o;
                dMRBridge.getClass();
                try {
                    Log.i("ROIP", "Disconnecting from all Brandmeister talkgroups");
                    dMRBridge.u(i5, 0, 1);
                    dMRBridge.u(i5, 0, 2);
                    dMRBridge.u(i5, 4000, 0);
                    Log.i("ROIP", "Disconnected from all talkgroups");
                    break;
                } catch (Exception e5) {
                    Log.e("ROIP", "Error disconnecting from talkgroups", e5);
                    return;
                }
            case 1:
                boolean z5 = DMRBridge.f6068o;
                dMRBridge.getClass();
                try {
                    Log.d("DMRBridge", "Reinitializing audio after underrun");
                    dMRBridge.r();
                    Log.d("DMRBridge", "Resubscribing to talkgroup: " + i5);
                    dMRBridge.subscribeTalkgroup(i5);
                    Log.i("DMRBridge", "Call restart completed");
                    break;
                } catch (Exception e6) {
                    Log.e("DMRBridge", "Error during call restart", e6);
                    return;
                }
            case 2:
                boolean z6 = DMRBridge.f6068o;
                dMRBridge.getClass();
                try {
                    dMRBridge.f6074e.b(i5);
                    break;
                } catch (Exception e7) {
                    Log.e("DMRBridge", "Error sending call ended notification", e7);
                    return;
                }
            case 3:
                boolean z7 = DMRBridge.f6068o;
                dMRBridge.getClass();
                try {
                    dMRBridge.f6074e.b(i5);
                    Log.d("DMRBridge", "Sent call ended notification");
                    break;
                } catch (Exception e8) {
                    Log.e("DMRBridge", "Error sending call ended notification", e8);
                    return;
                }
            case 4:
                boolean z8 = DMRBridge.f6068o;
                dMRBridge.getClass();
                Log.d("DMRBridge", "=== In mainHandler.post for onCallEnded ===");
                StringBuilder sb = new StringBuilder("Main thread: ");
                sb.append(Looper.myLooper() == Looper.getMainLooper());
                Log.d("DMRBridge", sb.toString());
                Log.d("DMRBridge", "Forwarding onCallEnded to listener for srcId: " + i5);
                Log.d("DMRBridge", "mCallbackListener check again: ".concat(dMRBridge.f6074e != null ? "SET" : "NULL"));
                if (dMRBridge.f6074e != null) {
                    try {
                        Log.d("DMRBridge", "Calling mCallbackListener.onCallEnded(" + i5 + ")");
                        dMRBridge.f6074e.b(i5);
                        Log.d("DMRBridge", "listener.onCallEnded called successfully");
                    } catch (Exception e9) {
                        Log.e("DMRBridge", "Exception calling listener.onCallEnded: " + e9.getMessage(), e9);
                        e9.printStackTrace();
                    }
                } else {
                    Log.w("DMRBridge", "mCallbackListener is null, cannot forward onCallEnded");
                }
                try {
                    Log.d("DMRBridge", "Creating broadcast intent");
                    Intent intent = new Intent("com.unified.ur1.DMR_AUDIO_TRACK_STOPPED");
                    intent.putExtra("srcId", i5);
                    intent.putExtra("timestamp", System.currentTimeMillis());
                    Log.d("DMRBridge", "Sending broadcast via LocalBroadcastManager");
                    C0432c.a(dMRBridge.f6070a).c(intent);
                    Log.d("DMRBridge", "DMR_AUDIO_TRACK_STOPPED broadcast sent for srcId: " + i5);
                    break;
                } catch (Exception e10) {
                    Log.e("DMRBridge", "Exception sending broadcast: " + e10.getMessage(), e10);
                    e10.printStackTrace();
                    return;
                }
            default:
                boolean z9 = DMRBridge.f6068o;
                dMRBridge.getClass();
                try {
                    String string = dMRBridge.f6070a.getSharedPreferences("app_settings", 0).getString("auth_code_1", null);
                    if (string == null) {
                        Log.e("DMRBridge", "Authorization code not found - cannot call UR1 API");
                    } else if (dMRBridge.b(i5, string)) {
                        Log.i("DMRBridge", "UR1 talkgroup set successfully to " + i5);
                        dMRBridge.f6071b.post(new RunnableC0433a(6));
                    } else {
                        Log.e("DMRBridge", "Failed to set UR1 talkgroup to " + i5);
                        dMRBridge.subscribeTalkgroup(i5);
                    }
                    break;
                } catch (Exception e11) {
                    Log.e("DMRBridge", "Exception in setUR1Talkgroup", e11);
                    return;
                }
        }
    }
}
