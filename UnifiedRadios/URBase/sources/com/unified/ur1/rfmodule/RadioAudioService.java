package com.unified.ur1.rfmodule;

import B0.l;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioRecord;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.lifecycle.A;
import com.unified.ur1.primary.LaunchActivity;
import f3.C0518i;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import m3.C0764B;
import m3.C0774j;
import m3.t;
import m3.u;
import p3.C0836b;
import y1.f;

/* loaded from: classes.dex */
public class RadioAudioService extends Service {

    /* renamed from: m, reason: collision with root package name */
    public static final byte[] f6081m;
    public static final String n;

    /* renamed from: o, reason: collision with root package name */
    public static Context f6082o;

    /* renamed from: c, reason: collision with root package name */
    public C0764B f6083c = C0764B.e();

    /* renamed from: d, reason: collision with root package name */
    public ExecutorService f6084d = Executors.newSingleThreadExecutor();

    /* renamed from: e, reason: collision with root package name */
    public final u f6085e = new u(this);

    /* renamed from: f, reason: collision with root package name */
    public int f6086f = -1;
    public l g = null;
    public A h;

    /* renamed from: i, reason: collision with root package name */
    public String f6087i;

    /* renamed from: j, reason: collision with root package name */
    public int f6088j;

    /* renamed from: k, reason: collision with root package name */
    public int f6089k;

    /* renamed from: l, reason: collision with root package name */
    public C0774j f6090l;

    static {
        AudioRecord.getMinBufferSize(16000, 16, 2);
        AudioRecord.getMinBufferSize(44100, 16, 3);
        f6081m = new byte[]{-1, 0, -1, 0, -1, 0, -1, 0};
        n = "aprs_message_notifications";
    }

    public RadioAudioService() {
        new HashMap();
        this.h = null;
        this.f6087i = "144.000";
        this.f6088j = 0;
        this.f6089k = -1;
    }

    public final void a() {
        Log.d("Unified", "Ending PTT transmission");
        C0836b.b(this).f();
    }

    public final void b(boolean z4) {
        if (this.f6086f != 2) {
            return;
        }
        int i5 = this.f6088j;
        if (i5 == 0) {
            f(this.f6089k, i5, true);
        }
        if (z4) {
            this.f6086f = 0;
        }
    }

    public final void c() throws Throwable {
        Log.d("Unified", "Shutting down RadioAudioService");
        ExecutorService executorService = this.f6084d;
        if (executorService != null && !executorService.isShutdown()) {
            try {
                this.f6084d.shutdownNow();
                this.f6084d = null;
            } catch (Exception e5) {
                Log.e("Unified", "Error shutting down serialExecutor", e5);
            }
        }
        try {
            Context context = LaunchActivity.f5853D1;
            f.f();
        } catch (Exception e6) {
            Log.e("Unified", "Error closing DMR hardware", e6);
        }
        C0764B c0764b = this.f6083c;
        if (c0764b != null) {
            Log.d("SerialPort", "Starting comprehensive cleanup");
            c0764b.d();
            this.f6083c = null;
        }
        this.f6090l = null;
        this.g = null;
        f6082o = null;
        this.h = null;
    }

    public final void d() {
        if (getSharedPreferences("app_settings", 0).getBoolean("CJ_26_enabled", false)) {
            return;
        }
        Log.e("Unified", "Cannot start serial monitoring - connection not initialized");
        NotificationChannel notificationChannel = new NotificationChannel(n, "Chat messages", 3);
        notificationChannel.setDescription("APRS text chat messages addressed to you");
        ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
    }

    public final void e(int i5, String str, boolean z4) {
        if (this.f6086f == -1) {
            return;
        }
        this.f6086f = 0;
        if (!z4 && this.f6087i.equals(str) && this.f6088j == i5) {
            return;
        }
        this.f6087i = str;
        this.f6088j = i5;
    }

    public final void f(int i5, int i6, boolean z4) {
        if ((!z4 && this.f6089k == i5 && this.f6088j == i6) || this.f6086f == -1) {
            return;
        }
        A a2 = this.h;
        if (a2 == null) {
            Log.d("Unified", "Error: attempted tuneToMemory() but channelMemories was never set.");
            return;
        }
        Object obj = a2.f3899e;
        if (obj == A.f3894k) {
            obj = null;
        }
    }

    public final void g(C0518i c0518i, int i5, boolean z4) {
        if ((!z4 && this.f6089k == c0518i.f6721a && this.f6088j == i5) || this.f6086f == -1 || c0518i == null) {
            return;
        }
        this.f6087i = h(c0518i.f6723c);
        this.f6089k = c0518i.f6721a;
    }

    public final String h(String str) {
        String strTrim = str.trim();
        if (!strTrim.matches("14[4-8]\\.[0-9][0-9][0-9]")) {
            if (strTrim.matches("14[4-8]\\.[0-9][0-9]")) {
                strTrim = strTrim.concat("0");
            } else if (strTrim.matches("14[4-8]\\.[0-9]")) {
                strTrim = strTrim.concat("00");
            } else if (strTrim.matches("14[4-8]\\.")) {
                strTrim = strTrim.concat("000");
            } else if (strTrim.matches("14[4-8]")) {
                strTrim = strTrim.concat(".000");
            } else if (strTrim.matches("14[4-8][0-9][0-9][0-9]")) {
                strTrim = strTrim.substring(0, 3) + "." + strTrim.substring(3, 6);
            } else if (strTrim.matches("14[4-8][0-9][0-9]")) {
                strTrim = strTrim.substring(0, 3) + "." + strTrim.substring(3, 5) + "0";
            } else if (strTrim.matches("14[4-8][0-9]")) {
                strTrim = strTrim.substring(0, 3) + "." + strTrim.substring(3, 4) + "00";
            } else {
                strTrim = null;
            }
        }
        return strTrim == null ? this.f6087i : strTrim;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Bundle extras = intent.getExtras();
        extras.getString("callsign");
        this.f6088j = extras.getInt("squelch");
        this.f6089k = extras.getInt("activeMemoryId");
        this.f6087i = extras.getString("activeFrequencyStr");
        return this.f6085e;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        f6082o = getApplicationContext();
        this.f6083c = C0764B.e();
        this.f6084d.execute(new t(this, 0));
    }

    @Override // android.app.Service
    public final void onDestroy() {
        try {
            try {
                c();
                stopForeground(true);
                stopSelf();
            } catch (Exception e5) {
                Log.e("Unified", "Error in onDestroy", e5);
            }
        } finally {
            super.onDestroy();
        }
    }
}
