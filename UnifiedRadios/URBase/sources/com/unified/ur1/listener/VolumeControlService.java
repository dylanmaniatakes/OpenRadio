package com.unified.ur1.listener;

import B.t;
import android.R;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import com.unified.ur1.SatelliteTracker.h;
import f3.C0513e;
import j3.d;

/* loaded from: classes.dex */
public class VolumeControlService extends Service {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f5839e = 0;

    /* renamed from: c, reason: collision with root package name */
    public C0513e f5840c;

    /* renamed from: d, reason: collision with root package name */
    public final d f5841d = new d(this);

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Log.d("VolumeControlService", "VolumeControlService bound");
        return this.f5841d;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Log.d("VolumeControlService", "VolumeControlService created");
        this.f5840c = new C0513e(this);
        NotificationChannel notificationChannel = new NotificationChannel("VolumeControlChannel", "Volume Control Service", 2);
        notificationChannel.setDescription("Keeps volume control active in background");
        notificationChannel.setShowBadge(false);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        Log.d("VolumeControlService", "VolumeControlService destroyed");
        if (this.f5840c != null) {
            this.f5840c = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i5, int i6) {
        PowerManager.WakeLock wakeLock;
        Log.d("VolumeControlService", "VolumeControlService started");
        t tVar = new t(this, "VolumeControlChannel");
        tVar.f68e = t.b("Volume Control Active");
        tVar.f69f = t.b("Background volume control is running");
        tVar.f82v.icon = R.drawable.ic_media_play;
        tVar.c(2, true);
        tVar.f71j = -1;
        tVar.n = "service";
        startForeground(1001, tVar.a());
        C0513e c0513e = this.f5840c;
        if (c0513e != null && (wakeLock = (PowerManager.WakeLock) c0513e.f6688e) != null && !wakeLock.isHeld()) {
            try {
                ((PowerManager.WakeLock) c0513e.f6688e).acquire();
                Log.d("VolumeControlHandler", "Background operation enabled");
            } catch (Exception e5) {
                h.o(e5, new StringBuilder("Failed to enable background operation: "), "VolumeControlHandler");
            }
        }
        if (intent != null && "HANDLE_KNOB_ROTATION".equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("direction", 0);
            int intExtra2 = intent.getIntExtra("steps", 1);
            Log.d("VolumeControlService", "Handling knob rotation from broadcast: direction=" + intExtra + ", steps=" + intExtra2);
            for (int i7 = 0; i7 < Math.abs(intExtra2); i7++) {
                int i8 = intExtra > 0 ? 1 : -1;
                C0513e c0513e2 = this.f5840c;
                if (c0513e2 != null) {
                    c0513e2.f(i8);
                }
            }
        }
        return 1;
    }
}
