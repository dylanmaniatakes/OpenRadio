package com.unified.ur1.adapters;

import D0.l;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.unified.ur1.R;
import com.unified.ur1.adapters.SoundCustomizationActivity;
import f.AbstractActivityC0472i;
import f.C0467d;
import f3.D0;
import f3.E0;
import f3.r0;
import g0.AbstractC0535a;
import h4.c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class SoundCustomizationActivity extends AbstractActivityC0472i implements D0 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f5721f = 0;

    /* renamed from: c, reason: collision with root package name */
    public E0 f5722c;

    /* renamed from: d, reason: collision with root package name */
    public ThreadPoolExecutor f5723d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f5724e;

    public static void j(SoundCustomizationActivity soundCustomizationActivity, String str) {
        if (super.isFinishing()) {
            return;
        }
        Toast.makeText(soundCustomizationActivity, str, 0).show();
    }

    public static void k(SoundCustomizationActivity soundCustomizationActivity) {
        if (super.isFinishing()) {
            return;
        }
        Toast.makeText(soundCustomizationActivity, "All sound settings reset to defaults", 0).show();
        E0 e02 = soundCustomizationActivity.f5722c;
        if (e02 != null) {
            e02.a();
        }
        soundCustomizationActivity.n();
    }

    public static void l(SoundCustomizationActivity soundCustomizationActivity, Exception exc) {
        if (super.isFinishing()) {
            return;
        }
        Toast.makeText(soundCustomizationActivity, "Error resetting settings: " + exc.getMessage(), 0).show();
    }

    public final void m() {
        try {
            getSharedPreferences("AppSettings", 0).edit().commit();
            Log.d("SoundCustomizationActivity", "All settings committed to SharedPreferences");
        } catch (Exception e5) {
            Log.e("SoundCustomizationActivity", "Error committing settings", e5);
        }
    }

    public final void n() {
        try {
            E0 e02 = new E0();
            e02.f6571i = this;
            e02.I = this;
            this.f5722c = e02;
            e02.d(this);
            Log.d("SoundCustomizationActivity", "Sound customization manager initialized successfully");
        } catch (Exception e5) {
            Log.e("SoundCustomizationActivity", "Error initializing sound manager", e5);
            Toast.makeText(this, "Error initializing sound manager", 0).show();
        }
    }

    public final void o(String str, Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = this.f5723d;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            Log.w("SoundCustomizationActivity", "ThreadPoolExecutor not available for ".concat(str));
            return;
        }
        try {
            this.f5723d.execute(new r0(runnable, str, 0));
        } catch (RejectedExecutionException e5) {
            StringBuilder sbM = AbstractC0535a.m("Task rejected for ", str, ": ");
            sbM.append(e5.getMessage());
            Log.w("SoundCustomizationActivity", sbM.toString());
        } catch (Exception e6) {
            Log.e("SoundCustomizationActivity", "Error submitting task ".concat(str), e6);
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i5, int i6, Intent intent) {
        String str;
        String str2;
        super.onActivityResult(i5, i6, intent);
        Log.d("SoundCustomizationActivity", "onActivityResult called with requestCode: " + i5 + ", resultCode: " + i6);
        if (i6 != -1 || intent == null || intent.getData() == null) {
            Log.w("SoundCustomizationActivity", "Activity result not OK or no data received");
            return;
        }
        Uri data = intent.getData();
        Log.d("SoundCustomizationActivity", "Selected file URI: " + data);
        if (this.f5722c == null || !(i5 == 1001 || i5 == 1002 || i5 == 1003 || i5 == 1004 || i5 == 1005 || i5 == 1006)) {
            Log.w("SoundCustomizationActivity", "Sound manager is null or unknown request code: " + i5);
            return;
        }
        AbstractC0535a.u("Passing file selection to sound manager for request code: ", i5, "SoundCustomizationActivity");
        E0 e02 = this.f5722c;
        e02.getClass();
        switch (i5) {
            case 1001:
                str = "fm_ptt";
                str2 = "FM PTT";
                break;
            case 1002:
                str = "dmr_rf_ptt";
                str2 = "DMR PTT";
                break;
            case 1003:
                str = "roip_ptt";
                str2 = "ROIP PTT";
                break;
            case GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION /* 1004 */:
                str = "connected_sound";
                str2 = "Connected";
                break;
            case 1005:
                str = "disconnect_sound";
                str2 = "Disconnect";
                break;
            case 1006:
                str = "notification_sound";
                str2 = "Notification";
                break;
            default:
                Log.e("SoundCustomizationManager", "Unknown request code: " + i5);
                return;
        }
        String str3 = str;
        String str4 = str2;
        D0 d02 = (D0) e02.I;
        if (d02 != null) {
            ((SoundCustomizationActivity) d02).o("HandleAudioFileSelection", new l(e02, data, str3, str4, 3));
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        Log.d("SoundCustomizationActivity", "Back pressed - ensuring settings are saved");
        m();
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sound_customization);
        try {
            this.f5724e = new Handler(Looper.getMainLooper());
            try {
                this.f5723d = new ThreadPoolExecutor(2, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(50), new ThreadPoolExecutor.CallerRunsPolicy());
                Log.d("SoundCustomizationActivity", "Thread pool initialized successfully");
            } catch (Exception e5) {
                Log.e("SoundCustomizationActivity", "Error initializing thread pool", e5);
            }
            p();
            n();
        } catch (Exception e6) {
            Log.e("SoundCustomizationActivity", "Error initializing components", e6);
            Toast.makeText(this, "Error initializing sound customization", 0).show();
        }
        Log.d("SoundCustomizationActivity", "Sound Customization Activity created");
    }

    @Override // f.AbstractActivityC0472i, androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        try {
            E0 e02 = this.f5722c;
            if (e02 != null) {
                e02.a();
                this.f5722c = null;
            }
            ThreadPoolExecutor threadPoolExecutor = this.f5723d;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.shutdownNow();
                try {
                    if (!this.f5723d.awaitTermination(2L, TimeUnit.SECONDS)) {
                        Log.w("SoundCustomizationActivity", "ThreadPool did not terminate gracefully");
                    }
                } catch (InterruptedException e5) {
                    Log.w("SoundCustomizationActivity", "ThreadPool termination interrupted", e5);
                    Thread.currentThread().interrupt();
                }
                this.f5723d = null;
            }
            Handler handler = this.f5724e;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f5724e = null;
            }
            Log.d("SoundCustomizationActivity", "Sound Customization Activity destroyed successfully");
        } catch (Exception e6) {
            Log.e("SoundCustomizationActivity", "Error in onDestroy", e6);
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onPause() {
        super.onPause();
        try {
            Log.d("SoundCustomizationActivity", "Activity paused - ensuring settings are saved");
            m();
        } catch (Exception e5) {
            Log.e("SoundCustomizationActivity", "Error in onPause", e5);
        }
    }

    public final void p() {
        try {
            getWindow().getDecorView().setSystemUiVisibility(4098);
            Button button = (Button) findViewById(R.id.backButton);
            if (button != null) {
                final int i5 = 0;
                button.setOnClickListener(new View.OnClickListener(this) { // from class: f3.q0

                    /* renamed from: d, reason: collision with root package name */
                    public final /* synthetic */ SoundCustomizationActivity f6785d;

                    {
                        this.f6785d = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SoundCustomizationActivity soundCustomizationActivity = this.f6785d;
                        switch (i5) {
                            case 0:
                                int i6 = SoundCustomizationActivity.f5721f;
                                soundCustomizationActivity.onBackPressed();
                                break;
                            case 1:
                                int i7 = SoundCustomizationActivity.f5721f;
                                soundCustomizationActivity.getClass();
                                try {
                                    Log.d("SoundCustomizationActivity", "Starting save and exit process...");
                                    soundCustomizationActivity.m();
                                    soundCustomizationActivity.q();
                                    Toast.makeText(soundCustomizationActivity, "All sound settings saved", 0).show();
                                    soundCustomizationActivity.setResult(-1);
                                    soundCustomizationActivity.finish();
                                    break;
                                } catch (Exception e5) {
                                    StringBuilder sbG = com.unified.ur1.SatelliteTracker.h.g("SoundCustomizationActivity", "Error saving settings", e5, "Error saving settings: ");
                                    sbG.append(e5.getMessage());
                                    Toast.makeText(soundCustomizationActivity, sbG.toString(), 0).show();
                                    return;
                                }
                            default:
                                int i8 = SoundCustomizationActivity.f5721f;
                                soundCustomizationActivity.getClass();
                                try {
                                    L.h hVar = new L.h(soundCustomizationActivity);
                                    C0467d c0467d = (C0467d) hVar.f1522d;
                                    c0467d.f6292d = "Reset Sound Settings";
                                    c0467d.f6294f = "Are you sure you want to reset all sound settings to defaults? This will remove any custom audio files for PTT sounds, connection sounds, and notifications.";
                                    hVar.e("Reset", new DialogInterfaceOnClickListenerC0520k(2, soundCustomizationActivity));
                                    hVar.c("Cancel", null);
                                    hVar.f();
                                    break;
                                } catch (Exception e6) {
                                    Log.e("SoundCustomizationActivity", "Error showing reset dialog", e6);
                                }
                        }
                    }
                });
            }
            Button button2 = (Button) findViewById(R.id.saveButton);
            if (button2 != null) {
                final int i6 = 1;
                button2.setOnClickListener(new View.OnClickListener(this) { // from class: f3.q0

                    /* renamed from: d, reason: collision with root package name */
                    public final /* synthetic */ SoundCustomizationActivity f6785d;

                    {
                        this.f6785d = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SoundCustomizationActivity soundCustomizationActivity = this.f6785d;
                        switch (i6) {
                            case 0:
                                int i62 = SoundCustomizationActivity.f5721f;
                                soundCustomizationActivity.onBackPressed();
                                break;
                            case 1:
                                int i7 = SoundCustomizationActivity.f5721f;
                                soundCustomizationActivity.getClass();
                                try {
                                    Log.d("SoundCustomizationActivity", "Starting save and exit process...");
                                    soundCustomizationActivity.m();
                                    soundCustomizationActivity.q();
                                    Toast.makeText(soundCustomizationActivity, "All sound settings saved", 0).show();
                                    soundCustomizationActivity.setResult(-1);
                                    soundCustomizationActivity.finish();
                                    break;
                                } catch (Exception e5) {
                                    StringBuilder sbG = com.unified.ur1.SatelliteTracker.h.g("SoundCustomizationActivity", "Error saving settings", e5, "Error saving settings: ");
                                    sbG.append(e5.getMessage());
                                    Toast.makeText(soundCustomizationActivity, sbG.toString(), 0).show();
                                    return;
                                }
                            default:
                                int i8 = SoundCustomizationActivity.f5721f;
                                soundCustomizationActivity.getClass();
                                try {
                                    L.h hVar = new L.h(soundCustomizationActivity);
                                    C0467d c0467d = (C0467d) hVar.f1522d;
                                    c0467d.f6292d = "Reset Sound Settings";
                                    c0467d.f6294f = "Are you sure you want to reset all sound settings to defaults? This will remove any custom audio files for PTT sounds, connection sounds, and notifications.";
                                    hVar.e("Reset", new DialogInterfaceOnClickListenerC0520k(2, soundCustomizationActivity));
                                    hVar.c("Cancel", null);
                                    hVar.f();
                                    break;
                                } catch (Exception e6) {
                                    Log.e("SoundCustomizationActivity", "Error showing reset dialog", e6);
                                }
                        }
                    }
                });
            }
            Button button3 = (Button) findViewById(R.id.resetButton);
            if (button3 != null) {
                final int i7 = 2;
                button3.setOnClickListener(new View.OnClickListener(this) { // from class: f3.q0

                    /* renamed from: d, reason: collision with root package name */
                    public final /* synthetic */ SoundCustomizationActivity f6785d;

                    {
                        this.f6785d = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SoundCustomizationActivity soundCustomizationActivity = this.f6785d;
                        switch (i7) {
                            case 0:
                                int i62 = SoundCustomizationActivity.f5721f;
                                soundCustomizationActivity.onBackPressed();
                                break;
                            case 1:
                                int i72 = SoundCustomizationActivity.f5721f;
                                soundCustomizationActivity.getClass();
                                try {
                                    Log.d("SoundCustomizationActivity", "Starting save and exit process...");
                                    soundCustomizationActivity.m();
                                    soundCustomizationActivity.q();
                                    Toast.makeText(soundCustomizationActivity, "All sound settings saved", 0).show();
                                    soundCustomizationActivity.setResult(-1);
                                    soundCustomizationActivity.finish();
                                    break;
                                } catch (Exception e5) {
                                    StringBuilder sbG = com.unified.ur1.SatelliteTracker.h.g("SoundCustomizationActivity", "Error saving settings", e5, "Error saving settings: ");
                                    sbG.append(e5.getMessage());
                                    Toast.makeText(soundCustomizationActivity, sbG.toString(), 0).show();
                                    return;
                                }
                            default:
                                int i8 = SoundCustomizationActivity.f5721f;
                                soundCustomizationActivity.getClass();
                                try {
                                    L.h hVar = new L.h(soundCustomizationActivity);
                                    C0467d c0467d = (C0467d) hVar.f1522d;
                                    c0467d.f6292d = "Reset Sound Settings";
                                    c0467d.f6294f = "Are you sure you want to reset all sound settings to defaults? This will remove any custom audio files for PTT sounds, connection sounds, and notifications.";
                                    hVar.e("Reset", new DialogInterfaceOnClickListenerC0520k(2, soundCustomizationActivity));
                                    hVar.c("Cancel", null);
                                    hVar.f();
                                    break;
                                } catch (Exception e6) {
                                    Log.e("SoundCustomizationActivity", "Error showing reset dialog", e6);
                                }
                        }
                    }
                });
            }
        } catch (Exception e5) {
            Log.e("SoundCustomizationActivity", "Error setting up UI", e5);
        }
    }

    public final void q() {
        try {
            Log.d("SoundCustomizationActivity", "=== CURRENT SAVED SETTINGS ===");
            Log.d("SoundCustomizationActivity", "PTT Enabled: " + c.C(this).getBoolean("ptt_sound_enabled", true));
            Log.d("SoundCustomizationActivity", "FM PTT Mode: " + c.o(this));
            Log.d("SoundCustomizationActivity", "DMR PTT Mode: " + c.k(this));
            Log.d("SoundCustomizationActivity", "ROIP PTT Mode: " + c.x(this));
            Log.d("SoundCustomizationActivity", "Connected Mode: " + c.i(this));
            Log.d("SoundCustomizationActivity", "Disconnect Mode: " + c.m(this));
            Log.d("SoundCustomizationActivity", "Notification Mode: " + c.s(this));
            Log.d("SoundCustomizationActivity", "=== END SETTINGS VERIFICATION ===");
        } catch (Exception e5) {
            Log.e("SoundCustomizationActivity", "Error verifying settings", e5);
        }
    }
}
