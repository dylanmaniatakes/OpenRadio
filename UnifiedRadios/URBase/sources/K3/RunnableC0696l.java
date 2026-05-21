package k3;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.PinConfig;
import com.hebs.dmrserial.jni.SerialPort;
import com.unified.ur1.R;
import com.unified.ur1.adapters.AppDatabase;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.DmrAudioService;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import com.unified.ur1.rfmodule.RadioAudioService;
import e0.C0432c;
import i3.C0573b;
import java.net.InetAddress;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import m3.C0768d;
import m3.C0774j;
import m3.HandlerThreadC0778n;
import org.conscrypt.FileClientSessionCache;
import w1.AbstractC0930a;

/* renamed from: k3.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0696l implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8152j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8153k;

    public /* synthetic */ RunnableC0696l(LaunchActivity launchActivity, int i5) {
        this.f8152j = i5;
        this.f8153k = launchActivity;
    }

    private final void a() throws InterruptedException {
        int i5 = 11;
        Context context = LaunchActivity.f5853D1;
        LaunchActivity launchActivity = this.f8153k;
        launchActivity.getClass();
        try {
            try {
                try {
                    Log.d("Unified - Main Activity", "Cleaning up DMRBridge");
                    DMRBridge dMRBridgeJ = DMRBridge.j(launchActivity);
                    if (dMRBridgeJ != null) {
                        if (dMRBridgeJ.isSocketConnected()) {
                            Log.d("Unified - Main Activity", "DMR is connected - starting disconnection process");
                            launchActivity.N();
                            Thread.sleep(1000L);
                        }
                        dMRBridgeJ.onDestroy();
                        Log.d("Unified - Main Activity", "DMRBridge cleanup completed");
                    } else {
                        Log.d("Unified - Main Activity", "DMRBridge instance is null - skipping DMR cleanup");
                    }
                } catch (Exception e5) {
                    try {
                        Log.e("Unified - Main Activity", "Error during DMRBridge cleanup", e5);
                    } catch (Exception e6) {
                        Log.e("Unified - Main Activity", "Critical error in onDestroy cleanup", e6);
                        launchActivity.runOnUiThread(new RunnableC0696l(launchActivity, i5));
                        Thread.sleep(200L);
                        Process.killProcess(Process.myPid());
                        System.exit(0);
                    }
                }
                launchActivity.f5952p1 = false;
                launchActivity.f5955q1 = false;
                Handler handler = launchActivity.f5946n1;
                if (handler != null) {
                    handler.removeCallbacks(launchActivity.f5865B1);
                    launchActivity.f5946n1.removeCallbacksAndMessages(null);
                    launchActivity.f5946n1 = null;
                }
                try {
                    Intent intent = new Intent(launchActivity, (Class<?>) RadioAudioService.class);
                    launchActivity.stopService(new Intent(launchActivity, (Class<?>) DmrAudioService.class));
                    launchActivity.stopService(intent);
                    launchActivity.E0();
                    launchActivity.F0();
                    launchActivity.Y();
                    if (launchActivity.f5966u0 != null) {
                        C0432c.a(launchActivity).d(launchActivity.f5966u0);
                    }
                    Log.d("Unified - Main Activity", "Services stopped");
                } catch (Exception e7) {
                    Log.e("Unified - Main Activity", "Error stopping services", e7);
                }
                try {
                    C0768d c0768d = launchActivity.f5968v;
                    if (c0768d != null) {
                        c0768d.o();
                        launchActivity.f5968v.l();
                        launchActivity.f5968v = null;
                    }
                    BroadcastReceiver broadcastReceiver = launchActivity.f5962t;
                    if (broadcastReceiver != null) {
                        try {
                            launchActivity.unregisterReceiver(broadcastReceiver);
                            C0432c.a(launchActivity).d(launchActivity.f5962t);
                        } catch (Exception e8) {
                            Log.e("Unified - Main Activity", "Error unregistering badge receiver", e8);
                        }
                    }
                    Log.d("Unified - Main Activity", "Audio components stopped");
                } catch (Exception e9) {
                    Log.e("Unified - Main Activity", "Error stopping audio components", e9);
                }
                try {
                    y1.f.f();
                    launchActivity.M();
                    HandlerThreadC0778n handlerThreadC0778n = launchActivity.f5918d;
                    if (handlerThreadC0778n != null) {
                        handlerThreadC0778n.a();
                        launchActivity.f5918d = null;
                    }
                    Log.d("Unified - Main Activity", "DMR system components stopped");
                } catch (Exception e10) {
                    Log.e("Unified - Main Activity", "Error stopping DMR components", e10);
                }
                C0573b c0573b = launchActivity.f5959s;
                if (c0573b != null) {
                    c0573b.l(launchActivity);
                }
                BroadcastReceiver broadcastReceiver2 = launchActivity.f5962t;
                if (broadcastReceiver2 != null) {
                    try {
                        launchActivity.unregisterReceiver(broadcastReceiver2);
                    } catch (Exception e11) {
                        Log.e("Unified - Main Activity", "Error unregistering badge receiver", e11);
                    }
                }
                try {
                    if (launchActivity.f5963t0 != null) {
                        C0432c.a(launchActivity).d(launchActivity.f5963t0);
                        launchActivity.f5963t0 = null;
                    }
                    O o5 = launchActivity.f5960s0;
                    if (o5 != null) {
                        launchActivity.unregisterReceiver(o5);
                        launchActivity.f5960s0 = null;
                    }
                    F f5 = launchActivity.f5887M0;
                    if (f5 != null) {
                        launchActivity.unregisterReceiver(f5);
                        launchActivity.f5887M0 = null;
                    }
                    O o6 = launchActivity.f5944m1;
                    if (o6 != null) {
                        launchActivity.unregisterReceiver(o6);
                        launchActivity.f5944m1 = null;
                    }
                    O o7 = launchActivity.f5894Q0;
                    if (o7 != null) {
                        launchActivity.unregisterReceiver(o7);
                        launchActivity.f5894Q0 = null;
                    }
                    Log.d("Unified - Main Activity", "Broadcast receivers unregistered");
                } catch (IllegalArgumentException e12) {
                    Log.e("Unified - Main Activity", "Receiver not registered: " + e12.getMessage());
                } catch (Exception e13) {
                    Log.e("Unified - Main Activity", "Error unregistering receivers", e13);
                }
                try {
                    C0432c.a(launchActivity).d(launchActivity.f5864B0);
                    Log.d("LaunchActivity", "Toast broadcast receiver unregistered");
                } catch (Exception e14) {
                    Log.e("LaunchActivity", "Error unregistering toast receiver", e14);
                }
                launchActivity.runOnUiThread(new RunnableC0696l(launchActivity, 10));
                try {
                    Log.d("Unified - Main Activity", "Audio resources cleaned up");
                } catch (Exception e15) {
                    Log.e("Unified - Main Activity", "Error cleaning up audio resources", e15);
                }
                try {
                    ObjectAnimator objectAnimator = launchActivity.f5932i0;
                    if (objectAnimator != null) {
                        objectAnimator.cancel();
                        launchActivity.f5932i0 = null;
                    }
                    ScaleAnimation scaleAnimation = launchActivity.f5935j0;
                    if (scaleAnimation != null) {
                        scaleAnimation.cancel();
                        launchActivity.f5935j0 = null;
                    }
                    Log.d("Unified - Main Activity", "Animations cleaned up");
                } catch (Exception e16) {
                    Log.e("Unified - Main Activity", "Error cleaning up animations", e16);
                }
                try {
                    ThreadPoolExecutor threadPoolExecutor = launchActivity.f5922e0;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdownNow();
                        try {
                            if (!launchActivity.f5922e0.awaitTermination(2L, TimeUnit.SECONDS)) {
                                Log.w("Unified - Main Activity", "ThreadPoolExecutor did not terminate gracefully");
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                        launchActivity.f5922e0 = null;
                    }
                    ScheduledExecutorService scheduledExecutorService = launchActivity.f5941l1;
                    if (scheduledExecutorService != null) {
                        scheduledExecutorService.shutdownNow();
                        try {
                            if (!launchActivity.f5941l1.awaitTermination(2L, TimeUnit.SECONDS)) {
                                Log.w("Unified - Main Activity", "Scheduler did not terminate gracefully");
                            }
                        } catch (InterruptedException unused2) {
                            Thread.currentThread().interrupt();
                        }
                        launchActivity.f5941l1 = null;
                    }
                    Log.d("Unified - Main Activity", "Thread pools and schedulers cleaned up");
                } catch (Exception e17) {
                    Log.e("Unified - Main Activity", "Error cleaning up thread pools", e17);
                }
                try {
                    PowerManager.WakeLock wakeLock = launchActivity.f5913a1;
                    if (wakeLock != null && wakeLock.isHeld()) {
                        launchActivity.f5913a1.release();
                        launchActivity.f5913a1 = null;
                    }
                    Log.d("Unified - Main Activity", "Wake locks released");
                } catch (Exception e18) {
                    Log.e("Unified - Main Activity", "Error releasing wake locks", e18);
                }
                try {
                    RadioAudioService radioAudioService = launchActivity.f5965u;
                    if (radioAudioService != null) {
                        radioAudioService.a();
                        launchActivity.f5965u.b(true);
                        launchActivity.f5965u = null;
                    }
                    if (launchActivity.f5928g1) {
                        launchActivity.unbindService(launchActivity.f5969v1);
                        launchActivity.f5928g1 = false;
                    }
                    if (launchActivity.f5930h1 != null) {
                        launchActivity.unbindService(launchActivity.f5933i1);
                        launchActivity.f5930h1 = null;
                    }
                    Log.d("Unified - Main Activity", "Services unbound");
                } catch (Exception e19) {
                    Log.e("Unified - Main Activity", "Error unbinding services", e19);
                }
                try {
                    Log.d("Unified - Main Activity", "MMDVM client cleaned up");
                } catch (Exception e20) {
                    Log.e("Unified - Main Activity", "Error cleaning up MMDVM client", e20);
                }
                launchActivity.f5863B = 0;
                launchActivity.f5886M = 0;
                launchActivity.f5972w1 = false;
                launchActivity.f5866C = false;
                LaunchActivity.f5853D1 = null;
                launchActivity.f5916c = null;
                launchActivity.f5979z = null;
                launchActivity.f5888N = null;
                launchActivity.f5907X0 = null;
                launchActivity.f5909Y0 = null;
                Log.d("Unified - Main Activity", "=== LaunchActivity cleanup completed successfully ===");
                Thread.sleep(500L);
                launchActivity.runOnUiThread(new RunnableC0696l(launchActivity, i5));
                Thread.sleep(200L);
                Process.killProcess(Process.myPid());
                System.exit(0);
            } catch (Throwable th) {
                try {
                    launchActivity.runOnUiThread(new RunnableC0696l(launchActivity, i5));
                    Thread.sleep(200L);
                    Process.killProcess(Process.myPid());
                    System.exit(0);
                } catch (Exception e21) {
                    Log.e("Unified - Main Activity", "Error in final cleanup", e21);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                }
                throw th;
            }
        } catch (Exception e22) {
            Log.e("Unified - Main Activity", "Error in final cleanup", e22);
            Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }

    @Override // java.lang.Runnable
    public final void run() throws Exception {
        int i5 = 3;
        int i6 = 20;
        boolean z4 = true;
        LaunchActivity launchActivity = this.f8153k;
        switch (this.f8152j) {
            case 0:
                Context context = LaunchActivity.f5853D1;
                launchActivity.getClass();
                try {
                    Thread.sleep(3000L);
                    if (!LaunchActivity.f5855F1) {
                        C0774j c0774jA = C0774j.a();
                        C0675a0 c0675a0 = new C0675a0();
                        c0774jA.getClass();
                        C0774j.b(c0675a0);
                    }
                    if (launchActivity.f5970w.equals("FM")) {
                        C0774j c0774jA2 = C0774j.a();
                        launchActivity.f5916c = c0774jA2;
                        if (!LaunchActivity.f5855F1) {
                            new L0.s(c0774jA2, i6, LaunchActivity.f5853D1).y();
                        }
                        launchActivity.runOnUiThread(new RunnableC0696l(launchActivity, i6));
                    } else {
                        if ((launchActivity.f5970w.equals("FM") || launchActivity.f5970w.equals("DMR")) && !LaunchActivity.f5855F1) {
                            C0774j c0774jA3 = C0774j.a();
                            launchActivity.f5916c = c0774jA3;
                            new L0.s(c0774jA3, i6, LaunchActivity.f5853D1).A();
                        }
                        launchActivity.runOnUiThread(new RunnableC0696l(launchActivity, 21));
                    }
                    launchActivity.f5863B = 1;
                    while (launchActivity.f5866C) {
                        Thread.sleep(100L);
                    }
                    launchActivity.runOnUiThread(new RunnableC0696l(launchActivity, 23));
                    if (launchActivity.f5970w.equals("DMR")) {
                        return;
                    }
                    launchActivity.f5970w.equals("ROIP");
                    return;
                } catch (Exception e5) {
                    Log.e("Unified - Main Activity", "Error initializing radio error 3656", e5);
                    return;
                }
            case 1:
                Context context2 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                Log.d("Unified - Main Activity", "Buffer recovery - returning to good status");
                launchActivity.f5878H0 = 0;
                launchActivity.L0(0);
                return;
            case 2:
                launchActivity.f5911Z0.setVisibility(8);
                launchActivity.f5911Z0.setClickable(false);
                launchActivity.f5911Z0.setFocusable(false);
                return;
            case 3:
                Context context3 = LaunchActivity.f5853D1;
                LaunchActivity launchActivity2 = this.f8153k;
                launchActivity2.getClass();
                Log.i("Unified - Main Activity", "Validation 2 started: ");
                SharedPreferences sharedPreferences = launchActivity2.getSharedPreferences("app_settings", 0);
                String string = Settings.Secure.getString(launchActivity2.getContentResolver(), "android_id");
                if (string == null || string.length() < 8) {
                    LaunchActivity.I1 = string != null ? String.format("%-8s", string).replace(' ', '0').substring(0, 8) : "00000000";
                } else {
                    LaunchActivity.I1 = string.substring(string.length() - 8);
                }
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString("auth_code_1", LaunchActivity.I1);
                editorEdit.apply();
                launchActivity2.runOnUiThread(new f3.U(launchActivity2, Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, Settings.Secure.getString(launchActivity2.getContentResolver(), "android_id"), String.valueOf(10)));
                return;
            case 4:
                Context context4 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                try {
                    C0.g = (AppDatabase) AbstractC0930a.h(launchActivity.getApplicationContext(), AppDatabase.class, "app_database").b();
                    launchActivity.runOnUiThread(new RunnableC0696l(launchActivity, 13));
                    launchActivity.f5943m0 = LocationServices.getFusedLocationProviderClient((Activity) launchActivity);
                    launchActivity.V();
                    launchActivity.f5871E = h4.c.q(LaunchActivity.f5853D1);
                    new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0696l(launchActivity, 14), 3000L);
                    return;
                } catch (Exception unused) {
                    launchActivity.runOnUiThread(new RunnableC0696l(launchActivity, 15));
                    return;
                }
            case 5:
                Context context5 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                Log.d("Unified - Main Activity", "Calling roipconnect()");
                launchActivity.m0();
                return;
            case 6:
                Context context6 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                Log.d("Unified - Main Activity", "Calling roipconnect()");
                launchActivity.m0();
                return;
            case 7:
                Context context7 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                Log.d("Unified - Main Activity", "Calling roipconnect()");
                launchActivity.m0();
                return;
            case 8:
                Context context8 = LaunchActivity.f5853D1;
                launchActivity.n0();
                Log.d("MainActivity", "DMR disconnection complete");
                return;
            case 9:
                String str = launchActivity.f5900U;
                if (str == null || str.isEmpty() || launchActivity.f5900U.equals("NOCALL") || launchActivity.f5900U.equals("null")) {
                    Log.d("Unified - Main Activity", "Calling Validation 1 = " + launchActivity.f5900U);
                    launchActivity.Q0();
                    return;
                }
                return;
            case 10:
                Context context9 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                try {
                    ProgressDialog progressDialog = launchActivity.f5977y0;
                    if (progressDialog != null && progressDialog.isShowing()) {
                        launchActivity.f5977y0.dismiss();
                        launchActivity.f5977y0 = null;
                    }
                    q2.k kVar = launchActivity.f5891P;
                    if (kVar != null) {
                        kVar.a(3);
                        launchActivity.f5891P = null;
                    }
                    q2.k kVar2 = launchActivity.f5890O;
                    if (kVar2 != null) {
                        kVar2.a(3);
                        launchActivity.f5890O = null;
                    }
                    launchActivity.getWindow().clearFlags(128);
                    Log.d("Unified - Main Activity", "UI cleanup completed");
                    return;
                } catch (Exception e6) {
                    Log.e("Unified - Main Activity", "Error during UI cleanup", e6);
                    return;
                }
            case 11:
                Context context10 = LaunchActivity.f5853D1;
                launchActivity.moveTaskToBack(true);
                launchActivity.finishAffinity();
                return;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                launchActivity.f5874F0.animate().scaleX(1.0f).scaleY(1.0f).setDuration(500L).start();
                return;
            case o1.f.ERROR /* 13 */:
                Context context11 = LaunchActivity.f5853D1;
                launchActivity.b0();
                launchActivity.I();
                return;
            case o1.f.INTERRUPTED /* 14 */:
                Context context12 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                new Thread(new RunnableC0696l(launchActivity, 24), "DmrInitThread").start();
                return;
            case 15:
                Context context13 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                Toast.makeText(launchActivity, "OnCreate Error initializing radio", 0).show();
                return;
            case 16:
                Context context14 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                if (!InetAddress.getByName("app.unifiedradios.com").isReachable(5000)) {
                    if (Runtime.getRuntime().exec("/system/bin/ping -c 1 -w 5 app.unifiedradios.com").waitFor() != 0) {
                        z4 = false;
                    }
                }
                try {
                    launchActivity.runOnUiThread(new R2.c(launchActivity, z4, i5));
                    return;
                } catch (Exception unused2) {
                    return;
                }
            case o1.f.API_NOT_CONNECTED /* 17 */:
                Context context15 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                try {
                    if (!LaunchActivity.f5855F1) {
                        HandlerThreadC0778n handlerThreadC0778nB = HandlerThreadC0778n.b();
                        launchActivity.f5918d = handlerThreadC0778nB;
                        SerialPort serialPort = handlerThreadC0778nB.f8624j;
                        if (serialPort == null || serialPort.f5554b == null || serialPort.f5553a == null) {
                            handlerThreadC0778nB.a();
                            handlerThreadC0778nB.c();
                            SerialPort serialPort2 = launchActivity.f5918d.f8624j;
                            if (serialPort2 == null || serialPort2.f5554b == null || serialPort2.f5553a == null) {
                                throw new Exception("Failed to initialize DMR serial port");
                            }
                        }
                        HandlerThreadC0778n handlerThreadC0778n = launchActivity.f5918d;
                        handlerThreadC0778n.f8626l = launchActivity;
                        handlerThreadC0778n.start();
                        if (!launchActivity.f5918d.isAlive()) {
                            throw new Exception("DMR serial failed to start");
                        }
                    }
                    launchActivity.runOnUiThread(new RunnableC0696l(launchActivity, 25));
                    return;
                } catch (Exception e7) {
                    Log.e("Unified - Main Activity", "Serial initialization failed", e7);
                    launchActivity.runOnUiThread(new RunnableC0717w(launchActivity, e7, 0));
                    return;
                }
            case 18:
                launchActivity.f5893Q.setVisibility(8);
                return;
            case o1.f.REMOTE_EXCEPTION /* 19 */:
                ProgressDialog progressDialog2 = launchActivity.f5977y0;
                if (progressDialog2 == null || !progressDialog2.isShowing()) {
                    return;
                }
                launchActivity.f5977y0.dismiss();
                return;
            case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                Context context16 = LaunchActivity.f5853D1;
                TextView textView = (TextView) launchActivity.findViewById(R.id.CallerID);
                launchActivity.f5973x = textView;
                textView.setVisibility(4);
                String str2 = launchActivity.f5900U;
                if (str2 == null && str2.isEmpty()) {
                    launchActivity.f5940l0.setText("");
                    return;
                }
                launchActivity.f5940l0.setText(" " + launchActivity.f5900U + " ");
                h4.c.C(launchActivity).edit().putString("dmr_callsign", launchActivity.f5900U).apply();
                return;
            case o1.f.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                Context context17 = LaunchActivity.f5853D1;
                TextView textView2 = (TextView) launchActivity.findViewById(R.id.CallerID);
                launchActivity.f5973x = textView2;
                textView2.setVisibility(0);
                return;
            case o1.f.RECONNECTION_TIMED_OUT /* 22 */:
                launchActivity.f5911Z0.setVisibility(8);
                launchActivity.f5911Z0.setClickable(false);
                launchActivity.f5911Z0.setFocusable(false);
                return;
            case 23:
                launchActivity.f5968v.n();
                return;
            case 24:
                Context context18 = LaunchActivity.f5853D1;
                if (launchActivity.f5918d != null) {
                    return;
                }
                new Thread(new RunnableC0696l(launchActivity, 17), "SerialInitThread").start();
                return;
            case 25:
                Context context19 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                new Thread(new RunnableC0672A(launchActivity, 0), "AudioInitThread").start();
                return;
            case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                TextView textView3 = launchActivity.f5973x;
                if (textView3 != null) {
                    textView3.setText("Auth Error");
                    return;
                }
                return;
            case 27:
                a();
                return;
            case 28:
                launchActivity.f5874F0.setVisibility(8);
                Log.d("LaunchActivity", "roipdisconnect called # 1");
                launchActivity.n0();
                return;
            default:
                launchActivity.f5950p.dismiss();
                return;
        }
    }
}
