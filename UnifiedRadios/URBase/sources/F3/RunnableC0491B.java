package f3;

import android.content.Context;
import android.util.Log;
import com.unified.ur1.adapters.MemoryChannelActivity;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import e1.RunnableC0433a;
import java.util.ArrayList;

/* renamed from: f3.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0491B implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6545j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ DMRBridge f6546k;

    public /* synthetic */ RunnableC0491B(DMRBridge dMRBridge, int i5) {
        this.f6545j = i5;
        this.f6546k = dMRBridge;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException {
        switch (this.f6545j) {
            case 0:
                DMRBridge dMRBridge = this.f6546k;
                int i5 = MemoryChannelActivity.f5681l;
                try {
                    dMRBridge.isSocketConnected();
                    dMRBridge.s();
                    dMRBridge.g();
                    for (int i6 = 0; dMRBridge.isSocketConnected() && i6 < 6000; i6 += 200) {
                        Thread.sleep(200);
                    }
                    if (dMRBridge.isSocketConnected()) {
                        Log.w("Unified - MemoryChannel", "ROIP disconnect timeout - forcing cleanup");
                        dMRBridge.i();
                        dMRBridge.h();
                        break;
                    }
                } catch (Exception e5) {
                    Log.e("Unified - MemoryChannel", "Error opening DMR", e5);
                    return;
                }
                break;
            case 1:
                DMRBridge dMRBridge2 = this.f6546k;
                Context context = dMRBridge2.f6070a;
                try {
                    ArrayList arrayListR = h4.c.r(context);
                    if (arrayListR.isEmpty()) {
                        Log.e("DMRBridge", "No Multi-RX talkgroups found - cannot call UR1 API");
                    } else {
                        String string = context.getSharedPreferences("app_settings", 0).getString("auth_code_1", null);
                        if (string == null) {
                            Log.e("DMRBridge", "Authorization code not found - cannot call UR1 API");
                        } else if (dMRBridge2.a(string, arrayListR)) {
                            Log.i("DMRBridge", "UR1 Multi-RX talkgroups set successfully: " + arrayListR);
                            dMRBridge2.f6071b.post(new RunnableC0433a(6));
                        } else {
                            Log.e("DMRBridge", "Failed to set UR1 Multi-RX talkgroups: " + arrayListR);
                        }
                    }
                    break;
                } catch (Exception e6) {
                    Log.e("DMRBridge", "Exception in setUR1MultiRXTalkgroups", e6);
                    return;
                }
            case 2:
                DMRBridge dMRBridge3 = this.f6546k;
                Context context2 = dMRBridge3.f6070a;
                try {
                    if (dMRBridge3.isSocketConnected()) {
                        dMRBridge3.stopTransmission();
                        Log.d("DMRBridge", "Stopped active transmission");
                    }
                    String strJ = h4.c.j(context2);
                    if (strJ != null && strJ.toLowerCase().contains("brandmeister")) {
                        dMRBridge3.e(h4.c.C(context2).getInt("dmr_id", 1));
                        Log.d("DMRBridge", "Disconnected from Brandmeister talkgroups");
                        Thread.sleep(500L);
                    }
                    dMRBridge3.disconnectSockets();
                    Log.d("DMRBridge", "Socket connection closed");
                    dMRBridge3.c();
                    Log.d("DMRBridge", "DMR Bridge cleaned up");
                    dMRBridge3.f6071b.post(new RunnableC0491B(dMRBridge3, 3));
                    dMRBridge3.f6077j = -1;
                    dMRBridge3.f6078k = 0L;
                    break;
                } catch (Exception e7) {
                    Log.e("DMRBridge", "Error during DMR disconnection", e7);
                    return;
                }
                break;
            case 3:
                o3.k kVar = this.f6546k.f6074e;
                if (kVar != null) {
                    kVar.d(false);
                    Log.d("DMRBridge", "Notified listener of disconnection - keeping callback listener active");
                    break;
                }
                break;
            case 4:
                DMRBridge dMRBridge4 = this.f6546k;
                Context context3 = dMRBridge4.f6070a;
                try {
                    Log.d("DMRBridge", "Step 1: Force stopping all audio systems");
                    dMRBridge4.B();
                    Thread.sleep(200L);
                    if (dMRBridge4.isSocketConnected()) {
                        Log.d("DMRBridge", "Step 2: Stopping active transmissions");
                        dMRBridge4.stopTransmission();
                        Thread.sleep(100L);
                    }
                    String strJ2 = h4.c.j(context3);
                    if (strJ2 != null && strJ2.toLowerCase().contains("brandmeister")) {
                        Log.d("DMRBridge", "Step 3: Disconnecting from Brandmeister talkgroups");
                        dMRBridge4.e(h4.c.C(context3).getInt("dmr_id", 1));
                        Thread.sleep(300L);
                    }
                    Log.d("DMRBridge", "Step 4: Closing socket connection");
                    dMRBridge4.disconnectSockets();
                    Thread.sleep(200L);
                    Log.d("DMRBridge", "Step 5: Final cleanup");
                    dMRBridge4.c();
                    dMRBridge4.f6071b.post(new RunnableC0491B(dMRBridge4, 5));
                    Log.i("DMRBridge", "Enhanced ROIP disconnection completed successfully");
                    break;
                } catch (Exception e8) {
                    Log.e("DMRBridge", "Error during enhanced ROIP disconnection", e8);
                    return;
                }
                break;
            case 5:
                o3.k kVar2 = this.f6546k.f6074e;
                if (kVar2 != null) {
                    kVar2.d(false);
                    Log.d("DMRBridge", "Notified listener of disconnection");
                    break;
                }
                break;
            case 6:
                boolean z4 = DMRBridge.f6068o;
                DMRBridge dMRBridge5 = this.f6546k;
                dMRBridge5.getClass();
                try {
                    Log.w("ROIP", "Stopping reconnection attempts due to repeated authentication failures");
                    dMRBridge5.disconnectSockets();
                    break;
                } catch (Exception e9) {
                    Log.e("ROIP", "Error stopping reconnection", e9);
                    return;
                }
            default:
                DMRBridge dMRBridge6 = this.f6546k;
                while (dMRBridge6.f6080m) {
                    try {
                        dMRBridge6.processQtEvents();
                        Thread.sleep(1L);
                    } catch (InterruptedException unused) {
                        Log.d("DMRBridge", "Qt event processor interrupted - shutting down");
                    } catch (Exception e10) {
                        com.unified.ur1.SatelliteTracker.h.o(e10, new StringBuilder("Error processing Qt events: "), "DMRBridge");
                        if (!dMRBridge6.f6080m) {
                        }
                    }
                }
                Log.d("DMRBridge", "Qt event processor thread stopped");
                break;
        }
    }
}
