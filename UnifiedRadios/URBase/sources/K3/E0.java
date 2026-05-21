package k3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.unified.ur1.listener.VolumeControlService;
import com.unified.ur1.primary.OptionsActivity;
import com.unified.ur1.rfmodule.DmrAudioService;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import com.unified.ur1.rfmodule.RadioAudioService;
import e0.HandlerC0430a;
import e1.RunnableC0433a;
import f3.C0511d;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final /* synthetic */ class E0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7956j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ OptionsActivity f7957k;

    public /* synthetic */ E0(OptionsActivity optionsActivity, int i5) {
        this.f7956j = i5;
        this.f7957k = optionsActivity;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        final boolean z4 = true;
        char c2 = 1;
        char c5 = 1;
        final int i5 = 0;
        final OptionsActivity optionsActivity = this.f7957k;
        switch (this.f7956j) {
            case 0:
                int i6 = OptionsActivity.f5981H;
                if (optionsActivity.isFinishing()) {
                    return;
                }
                Toast.makeText(optionsActivity, "Error loading server settings, using local values", 0).show();
                return;
            case 1:
                int i7 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    Log.d("Unified - Settings", "AGC Status: " + optionsActivity.f6006w.getAGCStatus());
                    return;
                } catch (Exception e5) {
                    Log.e("Unified - Settings", "Error getting AGC status", e5);
                    return;
                }
            case 2:
                optionsActivity.f5985D.postDelayed(new J0(), 4000L);
                try {
                    try {
                        optionsActivity.f6006w = DMRBridge.j(optionsActivity);
                        optionsActivity.n();
                        optionsActivity.o();
                        optionsActivity.r();
                        optionsActivity.O();
                        optionsActivity.p();
                        optionsActivity.q();
                        optionsActivity.z();
                        if (optionsActivity.s()) {
                            optionsActivity.M();
                        }
                        Log.d("Unified - Settings", "Async component initialization completed");
                    } catch (Exception e6) {
                        Log.e("Unified - Settings", "Error in async component initialization", e6);
                    }
                    optionsActivity.f5985D.removeCallbacksAndMessages(null);
                    return;
                } catch (Throwable th) {
                    optionsActivity.f5985D.removeCallbacksAndMessages(null);
                    throw th;
                }
            case 3:
                int i8 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    optionsActivity.runOnUiThread(new I0(optionsActivity, optionsActivity.getSharedPreferences("mic_gain_settings", 0).getInt("mic_gain_level", 2), c2 == true ? 1 : 0));
                    return;
                } catch (Exception e7) {
                    Log.e("Unified - Settings", "Error loading mic gain settings", e7);
                    return;
                }
            case 4:
                int i9 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    final boolean zG = h4.c.G(optionsActivity);
                    try {
                        z4 = optionsActivity.getSharedPreferences("AppSettings", 0).getBoolean("new_message_sound_enabled", true);
                    } catch (Exception e8) {
                        Log.e("SharedSettings", "Error getting new message sound enabled", e8);
                    }
                    optionsActivity.runOnUiThread(new Runnable() { // from class: k3.O0
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i10 = OptionsActivity.f5981H;
                            OptionsActivity optionsActivity2 = optionsActivity;
                            if (optionsActivity2.isFinishing()) {
                                return;
                            }
                            Switch r22 = optionsActivity2.f5986E;
                            boolean z5 = zG;
                            if (r22 != null) {
                                r22.setChecked(z5);
                            }
                            Switch r23 = optionsActivity2.f5987F;
                            boolean z6 = z4;
                            if (r23 != null) {
                                r23.setChecked(z6);
                            }
                            try {
                                Switch r24 = optionsActivity2.f5986E;
                                if (r24 != null) {
                                    r24.setOnCheckedChangeListener(new S0(optionsActivity2, 1));
                                }
                                Switch r25 = optionsActivity2.f5987F;
                                if (r25 != null) {
                                    r25.setOnCheckedChangeListener(new S0(optionsActivity2, 2));
                                }
                            } catch (Exception e9) {
                                Log.e("Unified - Settings", "Error setting up Unified Messaging listeners", e9);
                            }
                            Log.d("Unified - Settings", "Unified Messaging settings loaded: messaging=" + z5 + ", sound=" + z6);
                        }
                    });
                    return;
                } catch (Exception e9) {
                    Log.e("Unified - Settings", "Error loading Unified Messaging settings", e9);
                    return;
                }
            case 5:
                int i10 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    SharedPreferences sharedPreferences = optionsActivity.getSharedPreferences("agc_settings", 0);
                    String str = Build.DISPLAY;
                    sharedPreferences.getInt("KEY_INPUT_VOLUME", 0);
                    final int i11 = sharedPreferences.getInt("roip_mic_gain_level", 2);
                    final int i12 = (str.contains("A500V5TN7.GQU2") || str.contains("Ulefone.HJ.FHD")) ? sharedPreferences.getInt("KEY_INPUT_VOLUME", 30) : sharedPreferences.getInt("KEY_INPUT_VOLUME", 20);
                    final boolean z5 = sharedPreferences.getBoolean("KEY_AGC_ENABLED", false);
                    optionsActivity.runOnUiThread(new Runnable() { // from class: k3.P0
                        @Override // java.lang.Runnable
                        public final void run() {
                            DMRBridge dMRBridge;
                            int i13 = i12;
                            int i14 = OptionsActivity.f5981H;
                            OptionsActivity optionsActivity2 = optionsActivity;
                            if (optionsActivity2.isFinishing()) {
                                return;
                            }
                            int i15 = i11;
                            optionsActivity2.f6001r = i15;
                            TextView textView = optionsActivity2.f6000q;
                            if (textView != null) {
                                textView.setText(String.valueOf(i15));
                            }
                            optionsActivity2.f6001r = i15;
                            optionsActivity2.T();
                            optionsActivity2.L();
                            TextView textView2 = optionsActivity2.f6003t;
                            boolean z6 = z5;
                            if (textView2 != null) {
                                if (z6) {
                                    textView2.setText("Base microphone input level (AGC will adjust on top of this)");
                                } else {
                                    textView2.setText("Manual microphone input level (no automatic adjustment)");
                                }
                            }
                            if (optionsActivity2.s() && (dMRBridge = optionsActivity2.f6006w) != null && DMRBridge.f6068o) {
                                try {
                                    dMRBridge.setAGCEnabled(z6);
                                    optionsActivity2.f6006w.inputvolume(i13 / 100.0f);
                                    Log.d("Unified - Settings", "Applied saved AGC settings: enabled=" + z6 + ", volume=" + i13 + "%");
                                } catch (Exception e10) {
                                    Log.e("Unified - Settings", "Error applying AGC settings", e10);
                                }
                            }
                        }
                    });
                    return;
                } catch (Exception e10) {
                    Log.e("Unified - Settings", "Error loading AGC settings", e10);
                    return;
                }
            case 6:
                int i13 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    final C0511d c0511dE = C0.g.q().e("disablePTT");
                    final C0511d c0511dE2 = C0.g.q().e("metricEnable");
                    optionsActivity.runOnUiThread(new Runnable() { // from class: k3.N0
                        @Override // java.lang.Runnable
                        public final void run() {
                            C0511d c0511d = c0511dE2;
                            C0511d c0511d2 = c0511dE;
                            OptionsActivity optionsActivity2 = optionsActivity;
                            switch (i5) {
                                case 0:
                                    int i14 = OptionsActivity.f5981H;
                                    if (!optionsActivity2.isFinishing()) {
                                        Switch r4 = optionsActivity2.f6004u;
                                        boolean z6 = true;
                                        if (r4 != null) {
                                            if (c0511d2 != null) {
                                                optionsActivity2.f6004u.setChecked("1".equals(c0511d2.f6684b) || "true".equals(c0511d2.f6684b));
                                            } else {
                                                r4.setChecked(false);
                                            }
                                            optionsActivity2.f6004u.setOnCheckedChangeListener(new S0(optionsActivity2, 3));
                                        }
                                        Switch r12 = optionsActivity2.f6005v;
                                        if (r12 != null) {
                                            if (c0511d != null) {
                                                if (!"1".equals(c0511d.f6684b) && !"true".equals(c0511d.f6684b)) {
                                                    z6 = false;
                                                }
                                                optionsActivity2.f6005v.setChecked(z6);
                                            } else {
                                                r12.setChecked(false);
                                            }
                                            optionsActivity2.f6005v.setOnCheckedChangeListener(new S0(optionsActivity2, 4));
                                            break;
                                        }
                                    }
                                    break;
                                default:
                                    int i15 = OptionsActivity.f5981H;
                                    if (!optionsActivity2.isFinishing()) {
                                        if (optionsActivity2.f6004u != null && c0511d2 != null) {
                                            boolean zEquals = "1".equals(c0511d2.f6684b);
                                            optionsActivity2.f6004u.setChecked(zEquals);
                                            Log.d("Unified - Settings", "PTT disable state from server/cache: " + zEquals);
                                        }
                                        if (optionsActivity2.f6005v != null && c0511d != null) {
                                            boolean zEquals2 = "1".equals(c0511d.f6684b);
                                            optionsActivity2.f6005v.setChecked(zEquals2);
                                            Log.d("Unified - Settings", "Metric enable state from server/cache: " + zEquals2);
                                            break;
                                        }
                                    }
                                    break;
                            }
                        }
                    });
                    return;
                } catch (Exception e11) {
                    Log.e("Unified - Settings", "Error loading PTT and metric settings", e11);
                    return;
                }
            case 7:
                int i14 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    final C0511d c0511dE3 = C0.g.q().e("disablePTT");
                    final C0511d c0511dE4 = C0.g.q().e("metricEnable");
                    final char c6 = c5 == true ? 1 : 0;
                    optionsActivity.runOnUiThread(new Runnable() { // from class: k3.N0
                        @Override // java.lang.Runnable
                        public final void run() {
                            C0511d c0511d = c0511dE4;
                            C0511d c0511d2 = c0511dE3;
                            OptionsActivity optionsActivity2 = optionsActivity;
                            switch (c6) {
                                case 0:
                                    int i142 = OptionsActivity.f5981H;
                                    if (!optionsActivity2.isFinishing()) {
                                        Switch r4 = optionsActivity2.f6004u;
                                        boolean z6 = true;
                                        if (r4 != null) {
                                            if (c0511d2 != null) {
                                                optionsActivity2.f6004u.setChecked("1".equals(c0511d2.f6684b) || "true".equals(c0511d2.f6684b));
                                            } else {
                                                r4.setChecked(false);
                                            }
                                            optionsActivity2.f6004u.setOnCheckedChangeListener(new S0(optionsActivity2, 3));
                                        }
                                        Switch r12 = optionsActivity2.f6005v;
                                        if (r12 != null) {
                                            if (c0511d != null) {
                                                if (!"1".equals(c0511d.f6684b) && !"true".equals(c0511d.f6684b)) {
                                                    z6 = false;
                                                }
                                                optionsActivity2.f6005v.setChecked(z6);
                                            } else {
                                                r12.setChecked(false);
                                            }
                                            optionsActivity2.f6005v.setOnCheckedChangeListener(new S0(optionsActivity2, 4));
                                            break;
                                        }
                                    }
                                    break;
                                default:
                                    int i15 = OptionsActivity.f5981H;
                                    if (!optionsActivity2.isFinishing()) {
                                        if (optionsActivity2.f6004u != null && c0511d2 != null) {
                                            boolean zEquals = "1".equals(c0511d2.f6684b);
                                            optionsActivity2.f6004u.setChecked(zEquals);
                                            Log.d("Unified - Settings", "PTT disable state from server/cache: " + zEquals);
                                        }
                                        if (optionsActivity2.f6005v != null && c0511d != null) {
                                            boolean zEquals2 = "1".equals(c0511d.f6684b);
                                            optionsActivity2.f6005v.setChecked(zEquals2);
                                            Log.d("Unified - Settings", "Metric enable state from server/cache: " + zEquals2);
                                            break;
                                        }
                                    }
                                    break;
                            }
                        }
                    });
                    return;
                } catch (Exception e12) {
                    Log.e("Unified - Settings", "Error loading PTT and metric settings from database", e12);
                    return;
                }
            case 8:
                int i15 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    optionsActivity.runOnUiThread(new D0.g(optionsActivity, optionsActivity.getSharedPreferences("radioteams_settings", 0).getBoolean("KEY_RADIOTEAMS_ENABLED", false), optionsActivity.getSharedPreferences("radioteams_settings", 0).getString("KEY_RADIOTEAMS_ID", "None"), 3));
                    return;
                } catch (Exception e13) {
                    Log.e("Unified - Settings", "Error loading RadioTeams settings", e13);
                    return;
                }
            case 9:
                int i16 = OptionsActivity.f5981H;
                if (optionsActivity.isFinishing()) {
                    return;
                }
                optionsActivity.C();
                return;
            case 10:
                int i17 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    Log.d("ExitDebug", "Starting application exit sequence");
                    Intent intent = new Intent(optionsActivity, (Class<?>) DmrAudioService.class);
                    intent.setAction("ACTION_STOP_SERVICE");
                    optionsActivity.startService(intent);
                    Intent intent2 = new Intent(optionsActivity, (Class<?>) RadioAudioService.class);
                    intent2.setAction("ACTION_STOP_SERVICE");
                    optionsActivity.startService(intent2);
                    Thread.sleep(1000L);
                    try {
                        y1.f.f();
                        Log.d("ExitDebug", "DMR closed successfully");
                    } catch (Exception e14) {
                        Log.e("ExitDebug", "Error closing DMR: " + e14.getMessage());
                    }
                    optionsActivity.stopService(new Intent(optionsActivity, (Class<?>) DmrAudioService.class));
                    optionsActivity.stopService(new Intent(optionsActivity, (Class<?>) RadioAudioService.class));
                    try {
                        optionsActivity.stopService(new Intent(optionsActivity, (Class<?>) VolumeControlService.class));
                    } catch (Exception e15) {
                        Log.e("ExitDebug", "Error stopping volume service: " + e15.getMessage());
                    }
                    ThreadPoolExecutor threadPoolExecutor = optionsActivity.f5989c;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdownNow();
                        try {
                            if (!optionsActivity.f5989c.awaitTermination(2L, TimeUnit.SECONDS)) {
                                Log.w("ExitDebug", "ThreadPool did not terminate gracefully");
                            }
                        } catch (InterruptedException e16) {
                            Log.w("ExitDebug", "ThreadPool termination interrupted", e16);
                            Thread.currentThread().interrupt();
                        }
                        optionsActivity.f5989c = null;
                    }
                    optionsActivity.runOnUiThread(new E0(optionsActivity, 11));
                    return;
                } catch (Exception e17) {
                    Log.e("ExitDebug", "Error during exit sequence: " + e17.getMessage(), e17);
                    optionsActivity.runOnUiThread(new E0(optionsActivity, 12));
                    return;
                }
            case 11:
                int i18 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    ProgressDialog progressDialog = optionsActivity.h;
                    if (progressDialog != null && progressDialog.isShowing()) {
                        optionsActivity.h.dismiss();
                        optionsActivity.h = null;
                    }
                    Handler handler = optionsActivity.f6007x;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                    Handler handler2 = optionsActivity.f6008y;
                    if (handler2 != null) {
                        handler2.removeCallbacksAndMessages(null);
                    }
                    Handler handler3 = optionsActivity.f5985D;
                    if (handler3 != null) {
                        handler3.removeCallbacksAndMessages(null);
                    }
                    HandlerC0430a handlerC0430a = optionsActivity.f5988G;
                    if (handlerC0430a != null) {
                        handlerC0430a.removeCallbacksAndMessages(null);
                    }
                    optionsActivity.C();
                    optionsActivity.F();
                    optionsActivity.D();
                    optionsActivity.H();
                    Log.d("ExitDebug", "Moving task to back and finishing");
                    optionsActivity.moveTaskToBack(true);
                    optionsActivity.finishAffinity();
                    new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0433a(2), 500L);
                    return;
                } catch (Exception e18) {
                    Log.e("ExitDebug", "Error in UI cleanup", e18);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                    return;
                }
            default:
                ProgressDialog progressDialog2 = optionsActivity.h;
                if (progressDialog2 != null && progressDialog2.isShowing()) {
                    optionsActivity.h.dismiss();
                }
                optionsActivity.finishAffinity();
                Process.killProcess(Process.myPid());
                System.exit(1);
                return;
        }
    }
}
