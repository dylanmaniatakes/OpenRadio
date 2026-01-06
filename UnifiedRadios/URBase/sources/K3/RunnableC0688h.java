package k3;

import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.unified.ur1.primary.DTMFKeypad;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import m3.HandlerThreadC0778n;
import p3.C0836b;

/* renamed from: k3.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0688h implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8133j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ C0836b f8134k;

    public /* synthetic */ RunnableC0688h(C0836b c0836b, int i5) {
        this.f8133j = i5;
        this.f8134k = c0836b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicBoolean atomicBoolean;
        int i5;
        long j5;
        long j6;
        long j7;
        int i6 = 5;
        long j8 = 0;
        C0836b c0836b = this.f8134k;
        switch (this.f8133j) {
            case 0:
                HashMap map = DTMFKeypad.f5846k;
                boolean z4 = !c0836b.g.get();
                Log.d("DTMFKeypad", "TX stopped successfully: " + z4);
                if (!z4) {
                    Log.w("DTMFKeypad", "TX didn't stop properly, forcing stop");
                    c0836b.f();
                    break;
                }
                break;
            case 1:
                if (!c0836b.f9237q.get() && c0836b.f9238r.get()) {
                    c0836b.e();
                    break;
                }
                break;
            case 2:
                c0836b.getClass();
                Process.setThreadPriority(-19);
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j9 = 0;
                long jElapsedRealtime2 = jElapsedRealtime;
                long j10 = jElapsedRealtime2;
                int i7 = 0;
                while (true) {
                    boolean z5 = c0836b.g.get();
                    atomicBoolean = c0836b.f9237q;
                    if (z5 && !atomicBoolean.get()) {
                        try {
                            try {
                                long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                                long j11 = jElapsedRealtime3 - jElapsedRealtime;
                                if (j11 > 20) {
                                    try {
                                        Log.d("DMR_TX", "Large gap detected: " + j11 + "ms. Resetting timing.");
                                        jElapsedRealtime2 = jElapsedRealtime3;
                                    } catch (Exception e5) {
                                        e = e5;
                                        i5 = 5;
                                        j5 = 0;
                                        Log.e("DMR_TX", "Error in transmit thread", e);
                                        try {
                                            Thread.sleep(5L);
                                            i6 = i5;
                                            j8 = j5;
                                        } catch (InterruptedException unused) {
                                        }
                                    }
                                }
                                long j12 = jElapsedRealtime2 - jElapsedRealtime3;
                                j5 = 0;
                                if (j12 > 0) {
                                    if (j12 > 1) {
                                        try {
                                            Thread.sleep(j12 - 1);
                                        } catch (Exception e6) {
                                            e = e6;
                                            i5 = 5;
                                            Log.e("DMR_TX", "Error in transmit thread", e);
                                            Thread.sleep(5L);
                                            i6 = i5;
                                            j8 = j5;
                                        }
                                    }
                                    while (SystemClock.elapsedRealtime() < jElapsedRealtime2 && !atomicBoolean.get()) {
                                        Thread.yield();
                                    }
                                }
                            } catch (InterruptedException e7) {
                                Log.e("DMR_TX", "Transmit thread interrupted", e7);
                            }
                        } catch (Exception e8) {
                            e = e8;
                            i5 = i6;
                            j5 = j8;
                        }
                        if (atomicBoolean.get()) {
                            Log.d("DMR_TX", "Transmission cancelled during frame processing");
                        } else {
                            long jElapsedRealtime4 = SystemClock.elapsedRealtime() + 10;
                            ArrayBlockingQueue arrayBlockingQueue = c0836b.f9226c;
                            try {
                                byte[] bArr = (byte[]) arrayBlockingQueue.poll();
                                if (bArr != null) {
                                    try {
                                        if (HandlerThreadC0778n.b().e(bArr)) {
                                            j9++;
                                            try {
                                                jElapsedRealtime = SystemClock.elapsedRealtime();
                                                i7 = 0;
                                            } catch (Exception e9) {
                                                e = e9;
                                                jElapsedRealtime2 = jElapsedRealtime4;
                                                i5 = 5;
                                                Log.e("DMR_TX", "Error in transmit thread", e);
                                                Thread.sleep(5L);
                                                i6 = i5;
                                                j8 = j5;
                                            }
                                        } else {
                                            Log.w("DMR_TX", "Failed to send frame");
                                            if (!arrayBlockingQueue.offer(bArr)) {
                                                arrayBlockingQueue.poll();
                                                arrayBlockingQueue.offer(bArr);
                                            }
                                            Thread.sleep(5L);
                                        }
                                        long jElapsedRealtime5 = SystemClock.elapsedRealtime();
                                        if (jElapsedRealtime5 - j10 >= 1000) {
                                            j7 = jElapsedRealtime4;
                                            try {
                                                Log.d("DMR_TX", String.format("Transmitting - Time: %ds, Frames: %d, Buffer: %d/%d", Long.valueOf((jElapsedRealtime5 - c0836b.f9229f) / 1000), Long.valueOf(j9), Integer.valueOf(arrayBlockingQueue.size()), 8));
                                                j10 = jElapsedRealtime5;
                                            } catch (Exception e10) {
                                                e = e10;
                                                jElapsedRealtime2 = j7;
                                                i5 = 5;
                                                Log.e("DMR_TX", "Error in transmit thread", e);
                                                Thread.sleep(5L);
                                                i6 = i5;
                                                j8 = j5;
                                            }
                                        } else {
                                            j7 = jElapsedRealtime4;
                                        }
                                        jElapsedRealtime2 = j7;
                                        i5 = 5;
                                    } catch (Exception e11) {
                                        e = e11;
                                        j7 = jElapsedRealtime4;
                                    }
                                } else {
                                    j6 = jElapsedRealtime4;
                                    i7++;
                                    i5 = 5;
                                    if (i7 > 5) {
                                        try {
                                            Log.w("DMR_TX", "Buffer empty for 5 consecutive attempts");
                                        } catch (Exception e12) {
                                            e = e12;
                                            jElapsedRealtime2 = j6;
                                            Log.e("DMR_TX", "Error in transmit thread", e);
                                            Thread.sleep(5L);
                                            i6 = i5;
                                            j8 = j5;
                                        }
                                        try {
                                            HandlerThreadC0778n.b().e(new byte[160]);
                                            i7 = 0;
                                        } catch (Exception e13) {
                                            e = e13;
                                            jElapsedRealtime2 = j6;
                                            i7 = 0;
                                            Log.e("DMR_TX", "Error in transmit thread", e);
                                            Thread.sleep(5L);
                                            i6 = i5;
                                            j8 = j5;
                                        }
                                    }
                                    jElapsedRealtime2 = SystemClock.elapsedRealtime() + 5;
                                }
                            } catch (Exception e14) {
                                e = e14;
                                j6 = jElapsedRealtime4;
                                i5 = 5;
                            }
                            i6 = i5;
                            j8 = j5;
                        }
                    }
                }
                Log.d("DMR_TX", "Transmit thread ending - cancelled: " + atomicBoolean.get());
                break;
            case 3:
                if (c0836b.g.get() && !c0836b.f9237q.get()) {
                    long jElapsedRealtime6 = SystemClock.elapsedRealtime();
                    long j13 = c0836b.h.get();
                    if (j13 > 0) {
                        long j14 = jElapsedRealtime6 - j13;
                        if (j14 > 2000) {
                            Log.w("DMR_TX", "Audio data gap detected: " + j14 + "ms");
                            int i8 = c0836b.f9234m;
                            Handler handler = c0836b.f9225b;
                            if (i8 >= 3) {
                                Log.e("DMR_TX", "Too many restart attempts. Stopping transmission.");
                                handler.post(new RunnableC0688h(c0836b, i6));
                                break;
                            } else {
                                c0836b.f9234m = i8 + 1;
                                Log.d("DMR_TX", "Attempting to restart audio recording (attempt " + c0836b.f9234m + ")");
                                handler.post(new RunnableC0688h(c0836b, 4));
                                break;
                            }
                        }
                    }
                } else {
                    c0836b.f9230i.shutdown();
                    break;
                }
                break;
            case 4:
                if (c0836b.f9232k != null && !c0836b.f9237q.get()) {
                    c0836b.f9232k.e();
                    c0836b.f9225b.postDelayed(new RunnableC0688h(c0836b, 6), 100L);
                    break;
                }
                break;
            case 5:
                c0836b.f();
                break;
            default:
                if (c0836b.g.get() && c0836b.f9232k != null && !c0836b.f9237q.get()) {
                    c0836b.f9232k.d();
                    c0836b.h.set(SystemClock.elapsedRealtime());
                    break;
                }
                break;
        }
    }
}
