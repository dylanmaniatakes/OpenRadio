package f3;

import android.app.ProgressDialog;
import android.util.Log;
import com.unified.ur1.adapters.MemoryChannelActivity;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;

/* renamed from: f3.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0534z implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6853j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ MemoryChannelActivity f6854k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0532x f6855l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ProgressDialog f6856m;

    public /* synthetic */ RunnableC0534z(MemoryChannelActivity memoryChannelActivity, ProgressDialog progressDialog, C0532x c0532x) {
        this.f6853j = 2;
        this.f6854k = memoryChannelActivity;
        this.f6856m = progressDialog;
        this.f6855l = c0532x;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        final int i5 = 1;
        C0532x c0532x = this.f6855l;
        final int i6 = 0;
        final ProgressDialog progressDialog = this.f6856m;
        MemoryChannelActivity memoryChannelActivity = this.f6854k;
        switch (this.f6853j) {
            case 0:
                int i7 = MemoryChannelActivity.f5681l;
                memoryChannelActivity.getClass();
                new Thread(new RunnableC0534z(memoryChannelActivity, c0532x, progressDialog, i5)).start();
                break;
            case 1:
                int i8 = MemoryChannelActivity.f5681l;
                memoryChannelActivity.getClass();
                try {
                    DMRBridge dMRBridgeJ = DMRBridge.j(null);
                    if (dMRBridgeJ.isSocketConnected() && !c0532x.f()) {
                        Log.d("Unified - MemoryChannel", "Switching from ROIP to non-ROIP channel - disconnecting ROIP first");
                        dMRBridgeJ.f();
                        for (int i9 = 0; dMRBridgeJ.isSocketConnected() && i9 < 5000; i9 += 100) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e5) {
                                Log.e("Unified - MemoryChannel", "Interrupted while waiting for ROIP disconnect", e5);
                            }
                        }
                        if (dMRBridgeJ.isSocketConnected()) {
                            Log.w("Unified - MemoryChannel", "ROIP disconnect timeout - proceeding anyway");
                        } else {
                            Log.d("Unified - MemoryChannel", "ROIP disconnected successfully");
                        }
                        Thread.sleep(500L);
                        memoryChannelActivity.runOnUiThread(new Runnable() { // from class: f3.A
                            @Override // java.lang.Runnable
                            public final void run() {
                                ProgressDialog progressDialog2 = progressDialog;
                                switch (i6) {
                                    case 0:
                                        int i10 = MemoryChannelActivity.f5681l;
                                        progressDialog2.setMessage("Switching to new channel...");
                                        break;
                                    default:
                                        int i11 = MemoryChannelActivity.f5681l;
                                        progressDialog2.setMessage("Configuring channel settings...");
                                        break;
                                }
                            }
                        });
                    }
                    memoryChannelActivity.runOnUiThread(new Runnable() { // from class: f3.A
                        @Override // java.lang.Runnable
                        public final void run() {
                            ProgressDialog progressDialog2 = progressDialog;
                            switch (i5) {
                                case 0:
                                    int i10 = MemoryChannelActivity.f5681l;
                                    progressDialog2.setMessage("Switching to new channel...");
                                    break;
                                default:
                                    int i11 = MemoryChannelActivity.f5681l;
                                    progressDialog2.setMessage("Configuring channel settings...");
                                    break;
                            }
                        }
                    });
                    Thread.sleep(100L);
                    Log.d("Unified - MemoryChannel", "Calling saveChannelSettings()...");
                    memoryChannelActivity.m(c0532x);
                    Log.d("Unified - MemoryChannel", "saveChannelSettings() completed successfully");
                    memoryChannelActivity.runOnUiThread(new RunnableC0534z(memoryChannelActivity, progressDialog, c0532x));
                    break;
                } catch (Exception e6) {
                    memoryChannelActivity.runOnUiThread(new D0.f(memoryChannelActivity, progressDialog, e6, 5));
                    return;
                }
                break;
            default:
                int i10 = MemoryChannelActivity.f5681l;
                memoryChannelActivity.getClass();
                progressDialog.dismiss();
                LaunchActivity.f5854E1 = false;
                if (c0532x.f()) {
                    Log.d("Unified - MemoryChannel", "ROIP channel - finishing activity after startActivity");
                    memoryChannelActivity.finish();
                    break;
                } else {
                    Log.d("Unified - MemoryChannel", "Finishing activity...");
                    memoryChannelActivity.finish();
                    break;
                }
        }
    }

    public /* synthetic */ RunnableC0534z(MemoryChannelActivity memoryChannelActivity, C0532x c0532x, ProgressDialog progressDialog, int i5) {
        this.f6853j = i5;
        this.f6854k = memoryChannelActivity;
        this.f6855l = c0532x;
        this.f6856m = progressDialog;
    }
}
