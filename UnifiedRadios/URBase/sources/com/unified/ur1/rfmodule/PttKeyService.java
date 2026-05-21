package com.unified.ur1.rfmodule;

import B.t;
import J0.d;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.PowerManager;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;
import m3.C0774j;

/* loaded from: classes.dex */
public class PttKeyService extends Service {

    /* renamed from: c, reason: collision with root package name */
    public PowerManager.WakeLock f6052c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6053d = false;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel("PttServiceChannel", "PTT Service Channel", 2));
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) LaunchActivity.class), 67108864);
        t tVar = new t(this, "PttServiceChannel");
        tVar.f68e = t.b("Unified Radios");
        tVar.f69f = t.b("Monitoring for Radio Events!");
        tVar.f82v.icon = R.drawable.ic_status;
        tVar.g = activity;
        startForeground(1, tVar.a());
        this.f6052c = ((PowerManager) getSystemService("power")).newWakeLock(1, "MyApp::PTTServiceWakeLock");
        registerReceiver(new d(6, this), new IntentFilter("com.unified.ur1.KEY_EVENT"), 4);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        if (this.f6052c.isHeld()) {
            this.f6052c.release();
        }
        if (C0774j.f8610c == null) {
            C0774j.f8610c = new C0774j();
        }
        C0774j.f8610c.getClass();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i5, int i6) {
        PendingIntent.getBroadcast(this, 0, new Intent("com.unified.ur1.F1_KEY_EVENT"), 67108864);
        return 1;
    }
}
