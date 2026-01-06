package com.unified.ur1.rfmodule;

import R2.c;
import X2.t;
import android.app.Service;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import com.unified.ur1.rfmodule.DmrAudioService;
import f3.C0519j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.RunnableC0691i0;
import m3.BinderC0772h;
import m3.C0771g;
import m3.RunnableC0770f;
import p3.C0836b;

/* loaded from: classes.dex */
public class DmrAudioService extends Service {

    /* renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f6034u = 0;

    /* renamed from: c, reason: collision with root package name */
    public HandlerThread f6035c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f6036d;
    public AudioRecord g;
    public AudioManager h;

    /* renamed from: i, reason: collision with root package name */
    public AudioFocusRequest f6039i;

    /* renamed from: j, reason: collision with root package name */
    public PowerManager.WakeLock f6040j;

    /* renamed from: k, reason: collision with root package name */
    public PowerManager.WakeLock f6041k;
    public Thread n;

    /* renamed from: p, reason: collision with root package name */
    public Thread f6045p;

    /* renamed from: q, reason: collision with root package name */
    public t f6046q;

    /* renamed from: r, reason: collision with root package name */
    public C0836b f6047r;

    /* renamed from: e, reason: collision with root package name */
    public final ExecutorService f6037e = Executors.newSingleThreadExecutor();

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f6038f = new AtomicBoolean(false);

    /* renamed from: l, reason: collision with root package name */
    public volatile boolean f6042l = false;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f6043m = false;

    /* renamed from: o, reason: collision with root package name */
    public final LinkedBlockingQueue f6044o = new LinkedBlockingQueue();

    /* renamed from: s, reason: collision with root package name */
    public final BinderC0772h f6048s = new BinderC0772h(this);

    /* renamed from: t, reason: collision with root package name */
    public final C0771g f6049t = new AudioManager.OnAudioFocusChangeListener() { // from class: m3.g
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i5) throws IllegalStateException {
            AudioRecord audioRecord;
            DmrAudioService dmrAudioService = this.f8605a;
            int i6 = DmrAudioService.f6034u;
            if (i5 == -2) {
                if (!dmrAudioService.f6042l || (audioRecord = dmrAudioService.g) == null) {
                    return;
                }
                audioRecord.stop();
                dmrAudioService.f6042l = false;
                dmrAudioService.f(false);
                return;
            }
            if (i5 == -1) {
                dmrAudioService.e();
                return;
            }
            if (i5 != 1) {
                dmrAudioService.getClass();
            } else {
                if (dmrAudioService.f6042l || !dmrAudioService.f6043m) {
                    return;
                }
                dmrAudioService.d();
            }
        }
    };

    public static /* synthetic */ void a(DmrAudioService dmrAudioService) {
        dmrAudioService.f6047r = null;
        super.onDestroy();
    }

    public final void b() {
        try {
            if (checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
                Log.d("DmrAudioService", "Audio permission not granted");
                return;
            }
            int iMax = Math.max(AudioRecord.getMinBufferSize(8000, 16, 2) * 4, 640);
            this.f6039i = new AudioFocusRequest.Builder(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(2).setContentType(1).build()).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(this.f6049t).build();
            AudioRecord audioRecord = this.g;
            if (audioRecord != null) {
                audioRecord.release();
            }
            this.g = new AudioRecord.Builder().setAudioSource(9).setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(8000).setChannelMask(16).build()).setBufferSizeInBytes(iMax).build();
            this.f6043m = true;
            Log.d("DmrAudioService", "AudioRecord initialization complete");
        } catch (Exception e5) {
            Log.e("DmrAudioService", "Failed to initialize AudioRecord", e5);
            this.f6043m = false;
        }
    }

    public final void c() {
        PowerManager.WakeLock wakeLock = this.f6040j;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.f6040j.release();
        }
        PowerManager.WakeLock wakeLock2 = this.f6041k;
        if (wakeLock2 == null || !wakeLock2.isHeld()) {
            return;
        }
        this.f6041k.release();
    }

    public final void d() {
        Log.d("DmrAudioService", "startRecording() called");
        this.f6036d.post(new RunnableC0770f(this, 0));
    }

    public final void e() {
        Log.d("DmrAudioService", "stopRecording() called");
        this.f6036d.post(new RunnableC0770f(this, 10));
    }

    public final void f(boolean z4) {
        if (this.f6038f.get()) {
            this.f6036d.post(new c(this, z4, 5));
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Log.d("DmrAudioService", "onBind() called");
        this.f6036d.post(new RunnableC0770f(this, 7));
        return this.f6048s;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = new HandlerThread("DmrAudioThread", -16);
        this.f6035c = handlerThread;
        handlerThread.start();
        this.f6036d = new Handler(this.f6035c.getLooper());
        this.f6038f.set(true);
        PowerManager powerManager = (PowerManager) getSystemService("power");
        this.f6040j = powerManager.newWakeLock(1, "DmrAudio::RecordingWakeLock");
        this.f6041k = powerManager.newWakeLock(1, "DmrAudio::BackgroundWakeLock");
        this.h = (AudioManager) getSystemService("audio");
        t tVar = new t(7);
        this.f6046q = tVar;
        tVar.f2836f = new C0519j(23, this);
        this.f6036d.post(new RunnableC0770f(this, 8));
        this.f6036d.post(new RunnableC0770f(this, 7));
        this.f6036d.postDelayed(new RunnableC0691i0(7, this), 1000L);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        Log.d("DmrAudioService", "onDestroy() called");
        this.f6038f.set(false);
        this.f6036d.post(new RunnableC0770f(this, 6));
        stopForeground(true);
        try {
            Log.d("ServiceDebug", "Service cleanup completed");
        } catch (Exception e5) {
            Log.e("ServiceDebug", "Error during service cleanup", e5);
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i5, int i6) {
        if (intent != null && "ACTION_STOP_SERVICE".equals(intent.getAction())) {
            Log.d("ServiceDebug", "Received stop action - stopping service gracefully");
            stopForeground(true);
            try {
                Log.d("ServiceDebug", "Service cleanup completed");
            } catch (Exception e5) {
                Log.e("ServiceDebug", "Error during service cleanup", e5);
            }
            stopSelf();
        }
        return 2;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        Log.d("DmrAudioService", "onUnbind() called");
        this.f6036d.post(new RunnableC0770f(this, 9));
        return super.onUnbind(intent);
    }
}
