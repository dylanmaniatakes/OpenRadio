package Q0;

import D1.C0016n;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import f3.C0519j;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/* loaded from: classes.dex */
public final class g extends Thread {

    /* renamed from: j, reason: collision with root package name */
    public final BlockingQueue f2145j;

    /* renamed from: k, reason: collision with root package name */
    public final L0.e f2146k;

    /* renamed from: l, reason: collision with root package name */
    public final R0.d f2147l;

    /* renamed from: m, reason: collision with root package name */
    public final C0519j f2148m;
    public volatile boolean n = false;

    public g(PriorityBlockingQueue priorityBlockingQueue, L0.e eVar, R0.d dVar, C0519j c0519j) {
        this.f2145j = priorityBlockingQueue;
        this.f2146k = eVar;
        this.f2147l = dVar;
        this.f2148m = c0519j;
    }

    private void a() throws InterruptedException {
        b bVar;
        R0.f fVar = (R0.f) this.f2145j.take();
        C0519j c0519j = this.f2148m;
        SystemClock.elapsedRealtime();
        fVar.j(3);
        Object obj = null;
        try {
            try {
                fVar.a("network-queue-take");
                synchronized (fVar.n) {
                }
                TrafficStats.setThreadStatsTag(fVar.f2216m);
                C0016n c0016nO = this.f2146k.o(fVar);
                fVar.a("network-http-complete");
                if (c0016nO.f394c && fVar.f()) {
                    fVar.b("not-modified");
                    fVar.g();
                } else {
                    C0016n c0016nI = fVar.i(c0016nO);
                    fVar.a("network-parse-complete");
                    if (fVar.f2220r && (bVar = (b) c0016nI.f396e) != null) {
                        this.f2147l.f(fVar.d(), bVar);
                        fVar.a("network-cache-written");
                    }
                    synchronized (fVar.n) {
                        fVar.f2221s = true;
                    }
                    c0519j.s(fVar, c0016nI, null);
                    fVar.h(c0016nI);
                }
            } catch (l e5) {
                SystemClock.elapsedRealtime();
                c0519j.getClass();
                fVar.a("post-error");
                ((e) c0519j.f6730d).execute(new F0.e(fVar, new C0016n(e5), obj, 13));
                fVar.g();
            } catch (Exception e6) {
                Log.e("Volley", o.a("Unhandled exception %s", e6.toString()), e6);
                l lVar = new l(e6);
                SystemClock.elapsedRealtime();
                c0519j.getClass();
                fVar.a("post-error");
                ((e) c0519j.f6730d).execute(new F0.e(fVar, new C0016n(lVar), obj, 13));
                fVar.g();
            }
        } finally {
            fVar.j(4);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.n) {
                    Thread.currentThread().interrupt();
                    return;
                }
                o.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
