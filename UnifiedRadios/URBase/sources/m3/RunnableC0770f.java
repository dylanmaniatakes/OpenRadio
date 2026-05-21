package m3;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.unified.ur1.rfmodule.DmrAudioService;
import g0.AbstractC0535a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: m3.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0770f implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8603j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ DmrAudioService f8604k;

    public /* synthetic */ RunnableC0770f(DmrAudioService dmrAudioService, int i5) {
        this.f8603j = i5;
        this.f8604k = dmrAudioService;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException, InterruptedException, SecurityException, IllegalArgumentException {
        int i5 = 1;
        int i6 = 4;
        int i7 = 2;
        switch (this.f8603j) {
            case 0:
                DmrAudioService dmrAudioService = this.f8604k;
                if (dmrAudioService.f6043m && !dmrAudioService.f6042l) {
                    AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(2).setContentType(1).build()).setAcceptsDelayedFocusGain(true).setWillPauseWhenDucked(false).setOnAudioFocusChangeListener(dmrAudioService.f6049t).build();
                    dmrAudioService.f6039i = audioFocusRequestBuild;
                    int iRequestAudioFocus = dmrAudioService.h.requestAudioFocus(audioFocusRequestBuild);
                    AbstractC0535a.u("Audio focus request result: ", iRequestAudioFocus, "DmrAudioService");
                    if (iRequestAudioFocus == 1) {
                        if (!dmrAudioService.f6040j.isHeld()) {
                            dmrAudioService.f6040j.acquire(600000L);
                        }
                        if (!dmrAudioService.f6041k.isHeld()) {
                            dmrAudioService.f6041k.acquire();
                        }
                        dmrAudioService.f6042l = true;
                        dmrAudioService.f(true);
                        dmrAudioService.f6037e.execute(new RunnableC0770f(dmrAudioService, i6));
                        break;
                    } else {
                        Log.e("DmrAudioService", "Could not get audio focus");
                        break;
                    }
                } else {
                    Log.d("DmrAudioService", "Cannot start recording - not initialized or already recording");
                    break;
                }
                break;
            case 1:
                int i8 = DmrAudioService.f6034u;
                this.f8604k.b();
                break;
            case 2:
                DmrAudioService dmrAudioService2 = this.f8604k;
                AudioRecord audioRecord = dmrAudioService2.g;
                if (audioRecord != null) {
                    try {
                        audioRecord.stop();
                        Log.d("DmrAudioService", "AudioRecord.stop() succeeded");
                    } catch (IllegalStateException e5) {
                        Log.e("DmrAudioService", "Error stopping AudioRecord", e5);
                    }
                }
                AudioFocusRequest audioFocusRequest = dmrAudioService2.f6039i;
                if (audioFocusRequest != null) {
                    dmrAudioService2.h.abandonAudioFocusRequest(audioFocusRequest);
                }
                dmrAudioService2.c();
                Thread thread = dmrAudioService2.n;
                if (thread != null) {
                    try {
                        thread.interrupt();
                        dmrAudioService2.n.join(100L);
                        Log.d("DmrAudioService", "Recording thread stopped");
                    } catch (InterruptedException e6) {
                        Log.e("DmrAudioService", "Error stopping recording thread", e6);
                    }
                    dmrAudioService2.n = null;
                    break;
                }
                break;
            case 3:
                DmrAudioService.a(this.f8604k);
                break;
            case 4:
                DmrAudioService dmrAudioService3 = this.f8604k;
                int i9 = DmrAudioService.f6034u;
                dmrAudioService3.getClass();
                try {
                    dmrAudioService3.g.startRecording();
                    Log.d("DmrAudioService", "AudioRecord.startRecording() succeeded");
                    Thread thread2 = new Thread(new RunnableC0770f(dmrAudioService3, 5), "AudioRecord Thread");
                    dmrAudioService3.n = thread2;
                    thread2.setPriority(10);
                    dmrAudioService3.n.start();
                    break;
                } catch (IllegalStateException e7) {
                    Log.e("DmrAudioService", "Failed to start AudioRecord", e7);
                    dmrAudioService3.f6042l = false;
                    dmrAudioService3.f(false);
                    AudioFocusRequest audioFocusRequest2 = dmrAudioService3.f6039i;
                    if (audioFocusRequest2 != null) {
                        dmrAudioService3.h.abandonAudioFocusRequest(audioFocusRequest2);
                    }
                    dmrAudioService3.c();
                    return;
                }
            case 5:
                DmrAudioService dmrAudioService4 = this.f8604k;
                int i10 = DmrAudioService.f6034u;
                dmrAudioService4.getClass();
                Process.setThreadPriority(-19);
                byte[] bArr = new byte[160];
                Log.d("DmrAudioService", "Recording thread started");
                while (dmrAudioService4.f6042l && !Thread.interrupted()) {
                    try {
                        if (dmrAudioService4.g.read(bArr, 0, 160) == 160) {
                            dmrAudioService4.f6044o.offer((byte[]) bArr.clone());
                        }
                    } catch (Exception e8) {
                        Log.e("DmrAudioService", "Error reading audio data", e8);
                    }
                }
                Log.d("DmrAudioService", "Recording thread ended");
                break;
            case 6:
                int i11 = DmrAudioService.f6034u;
                DmrAudioService dmrAudioService5 = this.f8604k;
                dmrAudioService5.e();
                dmrAudioService5.c();
                new Thread(new RunnableC0770f(dmrAudioService5, 11), "ServiceCleanupThread").start();
                break;
            case 7:
                DmrAudioService dmrAudioService6 = this.f8604k;
                int i12 = DmrAudioService.f6034u;
                if (dmrAudioService6.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
                    Log.d("DmrAudioService", "Audio permission not granted");
                    break;
                } else if (!dmrAudioService6.f6043m) {
                    dmrAudioService6.f6037e.execute(new RunnableC0770f(dmrAudioService6, i5));
                    break;
                }
                break;
            case 8:
                int i13 = DmrAudioService.f6034u;
                DmrAudioService dmrAudioService7 = this.f8604k;
                dmrAudioService7.getClass();
                NotificationChannel notificationChannel = new NotificationChannel("DmrAudioService", "DMR Audio Service", 2);
                notificationChannel.setSound(null, null);
                notificationChannel.setVibrationPattern(null);
                notificationChannel.setShowBadge(false);
                ((NotificationManager) dmrAudioService7.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
                Log.d("DmrAudioService", "Notification channel created");
                try {
                    dmrAudioService7.f(false);
                    Log.d("DmrAudioService", "Successfully started foreground service");
                } catch (SecurityException e9) {
                    Log.e("DmrAudioService", "Failed to start foreground service", e9);
                    dmrAudioService7.stopSelf();
                }
                Thread thread3 = new Thread(new RunnableC0770f(dmrAudioService7, 12), "AudioProcessing Thread");
                dmrAudioService7.f6045p = thread3;
                thread3.start();
                break;
            case 9:
                this.f8604k.e();
                break;
            case 10:
                DmrAudioService dmrAudioService8 = this.f8604k;
                dmrAudioService8.f6042l = false;
                dmrAudioService8.f(false);
                dmrAudioService8.f6037e.execute(new RunnableC0770f(dmrAudioService8, i7));
                break;
            case 11:
                DmrAudioService dmrAudioService9 = this.f8604k;
                HandlerThread handlerThread = dmrAudioService9.f6035c;
                if (handlerThread != null) {
                    handlerThread.quitSafely();
                    try {
                        dmrAudioService9.f6035c.join(500L);
                    } catch (InterruptedException e10) {
                        Log.e("DmrAudioService", "Error joining service thread", e10);
                    }
                }
                Thread thread4 = dmrAudioService9.f6045p;
                if (thread4 != null) {
                    thread4.interrupt();
                    try {
                        dmrAudioService9.f6045p.join(500L);
                    } catch (InterruptedException e11) {
                        Log.e("DmrAudioService", "Error joining background thread", e11);
                    }
                }
                X2.t tVar = dmrAudioService9.f6046q;
                if (tVar != null) {
                    boolean andSet = ((AtomicBoolean) tVar.f2835e).getAndSet(false);
                    ExecutorService executorService = (ExecutorService) tVar.f2833c;
                    if (andSet) {
                        ((LinkedBlockingQueue) tVar.f2834d).clear();
                        executorService.execute(new o(i6, tVar));
                        Log.d("AudioTransmitter", "Transmitter stopped");
                    }
                    executorService.shutdown();
                    try {
                        if (!executorService.awaitTermination(1000L, TimeUnit.MILLISECONDS)) {
                            executorService.shutdownNow();
                        }
                    } catch (InterruptedException unused) {
                        executorService.shutdownNow();
                    }
                    dmrAudioService9.f6046q = null;
                }
                ExecutorService executorService2 = dmrAudioService9.f6037e;
                executorService2.shutdown();
                try {
                    if (!executorService2.awaitTermination(500L, TimeUnit.MILLISECONDS)) {
                        executorService2.shutdownNow();
                    }
                } catch (InterruptedException unused2) {
                    executorService2.shutdownNow();
                }
                AudioRecord audioRecord2 = dmrAudioService9.g;
                if (audioRecord2 != null) {
                    try {
                        audioRecord2.release();
                        Log.d("DmrAudioService", "AudioRecord released");
                    } catch (Exception e12) {
                        Log.e("DmrAudioService", "Error releasing AudioRecord", e12);
                    }
                    dmrAudioService9.g = null;
                }
                new Handler(Looper.getMainLooper()).post(new RunnableC0770f(dmrAudioService9, 3));
                break;
            default:
                int i14 = DmrAudioService.f6034u;
                DmrAudioService dmrAudioService10 = this.f8604k;
                dmrAudioService10.getClass();
                Process.setThreadPriority(-16);
                while (!Thread.interrupted()) {
                    try {
                        byte[] bArr2 = (byte[]) dmrAudioService10.f6044o.take();
                        if (bArr2 != null && dmrAudioService10.f6047r != null) {
                            dmrAudioService10.f6036d.post(new g3.k(dmrAudioService10, 21, bArr2));
                        }
                    } catch (InterruptedException unused3) {
                        Thread.currentThread().interrupt();
                    }
                }
                break;
        }
    }
}
