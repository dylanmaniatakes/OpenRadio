package p3;

import J1.ServiceConnectionC0075i0;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.DmrAudioService;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import k3.RunnableC0688h;
import m3.HandlerThreadC0775k;
import q3.AbstractC0869a;
import y1.f;

/* renamed from: p3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0836b {

    /* renamed from: s, reason: collision with root package name */
    public static C0836b f9223s;

    /* renamed from: a, reason: collision with root package name */
    public final Context f9224a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f9225b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayBlockingQueue f9226c;

    /* renamed from: d, reason: collision with root package name */
    public Thread f9227d;

    /* renamed from: e, reason: collision with root package name */
    public final PowerManager.WakeLock f9228e;

    /* renamed from: f, reason: collision with root package name */
    public long f9229f;

    /* renamed from: i, reason: collision with root package name */
    public ScheduledExecutorService f9230i;

    /* renamed from: j, reason: collision with root package name */
    public ServiceConnectionC0075i0 f9231j;

    /* renamed from: k, reason: collision with root package name */
    public DmrAudioService f9232k;
    public final AudioManager n;

    /* renamed from: o, reason: collision with root package name */
    public AudioFocusRequest f9235o;
    public final AtomicBoolean g = new AtomicBoolean(false);
    public final AtomicLong h = new AtomicLong(0);

    /* renamed from: l, reason: collision with root package name */
    public boolean f9233l = false;

    /* renamed from: m, reason: collision with root package name */
    public int f9234m = 0;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9236p = false;

    /* renamed from: q, reason: collision with root package name */
    public final AtomicBoolean f9237q = new AtomicBoolean(false);

    /* renamed from: r, reason: collision with root package name */
    public final AtomicBoolean f9238r = new AtomicBoolean(true);

    public C0836b(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f9224a = applicationContext;
        this.f9225b = new Handler(Looper.getMainLooper());
        this.f9226c = new ArrayBlockingQueue(8);
        this.n = (AudioManager) context.getSystemService("audio");
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) applicationContext.getSystemService("power")).newWakeLock(805306369, "TX::AudioTransmissionLock");
        this.f9228e = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
        a(null);
        for (int i5 = 0; i5 < 8; i5++) {
            this.f9226c.offer(new byte[160]);
        }
    }

    public static synchronized C0836b b(Context context) {
        try {
            if (f9223s == null) {
                f9223s = new C0836b(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9223s;
    }

    public final void a(RunnableC0688h runnableC0688h) {
        if (this.f9233l && this.f9232k != null) {
            if (runnableC0688h != null) {
                runnableC0688h.run();
            }
        } else {
            if (this.f9231j != null) {
                return;
            }
            this.f9231j = new ServiceConnectionC0075i0(this, 1, runnableC0688h);
            Context context = this.f9224a;
            Intent intent = new Intent(context, (Class<?>) DmrAudioService.class);
            context.startForegroundService(intent);
            context.bindService(intent, this.f9231j, 1);
        }
    }

    public final void c(byte[] bArr) {
        if (!this.g.get() || this.f9237q.get()) {
            return;
        }
        this.h.set(SystemClock.elapsedRealtime());
        ArrayBlockingQueue arrayBlockingQueue = this.f9226c;
        if (arrayBlockingQueue.offer((byte[]) bArr.clone())) {
            return;
        }
        arrayBlockingQueue.poll();
        if (arrayBlockingQueue.offer((byte[]) bArr.clone())) {
            return;
        }
        Log.w("DMR_TX", "Failed to add audio frame to buffer even after removing oldest");
    }

    public final void d(boolean z4) {
        this.f9238r.set(z4);
        AtomicBoolean atomicBoolean = this.f9237q;
        if (z4) {
            atomicBoolean.set(false);
        } else {
            atomicBoolean.set(true);
            if (this.g.get()) {
                Log.d("DMR_TX", "Transmission disallowed, stopping current transmission");
                f();
            }
        }
        Log.d("DMR_TX", "Transmission allowed set to: " + z4);
    }

    public final void e() {
        int i5 = 3;
        PowerManager.WakeLock wakeLock = this.f9228e;
        int i6 = 0;
        int i7 = 2;
        int i8 = 1;
        if (!this.f9238r.get()) {
            Log.w("DMR_TX", "Transmission not allowed, ignoring start request");
            return;
        }
        AtomicBoolean atomicBoolean = this.f9237q;
        if (atomicBoolean.get()) {
            Log.w("DMR_TX", "Transmission was cancelled, ignoring start request");
            return;
        }
        boolean z4 = this.f9233l;
        Context context = this.f9224a;
        if (!z4 || this.f9232k == null) {
            Log.w("DMR_TX", "Audio service not ready yet");
            a(null);
            Log.d("DMR_TX", "Service not ready, starting and binding");
            context.startForegroundService(new Intent(context, (Class<?>) DmrAudioService.class));
            a(new RunnableC0688h(this, i8));
            return;
        }
        AtomicBoolean atomicBoolean2 = this.g;
        if (atomicBoolean2.get()) {
            Log.w("DMR_TX", "Already transmitting");
            return;
        }
        this.f9234m = 0;
        if (!wakeLock.isHeld()) {
            Log.d("DMR_TX", "Acquiring wake lock");
            wakeLock.acquire(1800000L);
        }
        ((PowerManager) context.getSystemService("power")).newWakeLock(1, "TX::CPULock").acquire(1800000L);
        if (!this.f9236p) {
            AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(1).build()).setAcceptsDelayedFocusGain(true).setWillPauseWhenDucked(false).setOnAudioFocusChangeListener(new C0835a()).build();
            this.f9235o = audioFocusRequestBuild;
            boolean z5 = this.n.requestAudioFocus(audioFocusRequestBuild) == 1;
            this.f9236p = z5;
            Log.d("DMR_TX", "Audio focus request ".concat(z5 ? "granted" : "denied"));
        }
        ArrayBlockingQueue arrayBlockingQueue = this.f9226c;
        arrayBlockingQueue.clear();
        for (int i9 = 0; i9 < 8; i9++) {
            arrayBlockingQueue.offer(new byte[160]);
        }
        Log.d("DMR_TX", "Starting transmission");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f9229f = jElapsedRealtime;
        this.h.set(jElapsedRealtime);
        byte[] bArr = new byte[10];
        bArr[0] = 104;
        bArr[1] = 38;
        bArr[2] = 1;
        bArr[3] = 1;
        int i10 = 0;
        for (int i11 = 1; i11 < 4; i11++) {
            i10 += (bArr[i11] & 255) << (((i11 - 1) % 2) * 8);
        }
        while (true) {
            int i12 = i10 >> 16;
            if (i12 == 0) {
                break;
            } else {
                i10 = (65535 & i10) + i12;
            }
        }
        int i13 = 65535 & (~i10);
        bArr[4] = (byte) (i13 >> 8);
        bArr[5] = (byte) (i13 & 255);
        bArr[6] = 0;
        bArr[7] = 1;
        bArr[8] = 1;
        bArr[9] = 16;
        String strB = AbstractC0869a.b(bArr);
        context.startForegroundService(new Intent(context, (Class<?>) DmrAudioService.class));
        atomicBoolean2.set(true);
        if (atomicBoolean.get()) {
            Log.w("DMR_TX", "Transmission cancelled before sending start command");
            f();
            return;
        }
        boolean zG = false;
        while (i6 < 3 && !zG && !atomicBoolean.get()) {
            zG = HandlerThreadC0775k.a().g(strB);
            if (!zG) {
                try {
                    Thread.sleep(100L);
                    i6++;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        if (!zG || atomicBoolean.get()) {
            Log.e("DMR_TX", "Failed to send DMR start command after retries or transmission was cancelled");
            f();
            return;
        }
        if (this.f9232k != null && !atomicBoolean.get()) {
            this.f9232k.d();
        }
        Context context2 = LaunchActivity.f5853D1;
        f.D(1);
        HandlerThreadC0775k.a().g("6826010195c700010110");
        if (atomicBoolean.get()) {
            Log.w("DMR_TX", "Transmission cancelled before starting transmit thread");
            f();
            return;
        }
        Thread thread = new Thread(new RunnableC0688h(this, i7), "DMR-Transmit-Thread");
        this.f9227d = thread;
        thread.setPriority(10);
        this.f9227d.start();
        ScheduledExecutorService scheduledExecutorService = this.f9230i;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f9230i = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
        scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleAtFixedRate(new RunnableC0688h(this, i5), 500L, 500L, TimeUnit.MILLISECONDS);
    }

    public final void f() {
        PowerManager.WakeLock wakeLock = this.f9228e;
        AtomicBoolean atomicBoolean = this.g;
        if (atomicBoolean.get()) {
            Log.d("DMR_TX", String.format("Stopping transmission after %d seconds", Long.valueOf((SystemClock.elapsedRealtime() - this.f9229f) / 1000)));
            atomicBoolean.set(false);
            this.f9237q.set(true);
            ScheduledExecutorService scheduledExecutorService = this.f9230i;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
                this.f9230i = null;
            }
            Context context = LaunchActivity.f5853D1;
            Thread thread = this.f9227d;
            if (thread != null) {
                try {
                    thread.interrupt();
                    this.f9227d.join(100L);
                } catch (InterruptedException e5) {
                    Log.e("DMR_TX", "Error stopping transmit thread", e5);
                }
                this.f9227d = null;
            }
            Context context2 = LaunchActivity.f5853D1;
            HandlerThreadC0775k.a().g("6826010194c700010210");
            f.D(0);
            if (wakeLock.isHeld()) {
                wakeLock.release();
            }
            if (this.f9236p) {
                AudioFocusRequest audioFocusRequest = this.f9235o;
                if (audioFocusRequest != null) {
                    this.n.abandonAudioFocusRequest(audioFocusRequest);
                }
                this.f9236p = false;
                Log.d("DMR_TX", "Audio focus abandoned");
            }
            DmrAudioService dmrAudioService = this.f9232k;
            if (dmrAudioService != null) {
                dmrAudioService.e();
            }
            this.f9226c.clear();
            Context context3 = this.f9224a;
            context3.stopService(new Intent(context3, (Class<?>) DmrAudioService.class));
            this.f9234m = 0;
        }
    }
}
