package J1;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* renamed from: J1.r0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0101r0 extends Thread {

    /* renamed from: j, reason: collision with root package name */
    public final Object f1363j;

    /* renamed from: k, reason: collision with root package name */
    public final BlockingQueue f1364k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1365l = false;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ C0104s0 f1366m;

    public C0101r0(C0104s0 c0104s0, String str, BlockingQueue blockingQueue) {
        this.f1366m = c0104s0;
        q1.E.i(blockingQueue);
        this.f1363j = new Object();
        this.f1364k = blockingQueue;
        setName(str);
    }

    public final void a() {
        C0104s0 c0104s0 = this.f1366m;
        synchronized (c0104s0.f1383k) {
            try {
                if (!this.f1365l) {
                    c0104s0.f1384l.release();
                    c0104s0.f1383k.notifyAll();
                    if (this == c0104s0.f1379e) {
                        c0104s0.f1379e = null;
                    } else if (this == c0104s0.f1380f) {
                        c0104s0.f1380f = null;
                    } else {
                        Z z4 = ((C0113v0) c0104s0.f84c).f1417k;
                        C0113v0.k(z4);
                        z4.h.a("Current scheduler thread is neither worker nor network");
                    }
                    this.f1365l = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws InterruptedException {
        boolean z4 = false;
        while (!z4) {
            try {
                this.f1366m.f1384l.acquire();
                z4 = true;
            } catch (InterruptedException e5) {
                Z z5 = ((C0113v0) this.f1366m.f84c).f1417k;
                C0113v0.k(z5);
                z5.f1080k.b(e5, String.valueOf(getName()).concat(" was interrupted"));
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                BlockingQueue blockingQueue = this.f1364k;
                C0099q0 c0099q0 = (C0099q0) blockingQueue.poll();
                if (c0099q0 != null) {
                    Process.setThreadPriority(true != c0099q0.f1353k ? 10 : threadPriority);
                    c0099q0.run();
                } else {
                    Object obj = this.f1363j;
                    synchronized (obj) {
                        if (blockingQueue.peek() == null) {
                            this.f1366m.getClass();
                            try {
                                obj.wait(30000L);
                            } catch (InterruptedException e6) {
                                Z z6 = ((C0113v0) this.f1366m.f84c).f1417k;
                                C0113v0.k(z6);
                                z6.f1080k.b(e6, String.valueOf(getName()).concat(" was interrupted"));
                            }
                        }
                    }
                    synchronized (this.f1366m.f1383k) {
                        if (this.f1364k.peek() == null) {
                            a();
                            a();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            a();
            throw th;
        }
    }
}
