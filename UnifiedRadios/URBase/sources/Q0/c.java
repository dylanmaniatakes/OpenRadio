package Q0;

import D1.C0016n;
import N1.p;
import X2.t;
import android.os.Process;
import f3.C0519j;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/* loaded from: classes.dex */
public final class c extends Thread {

    /* renamed from: p, reason: collision with root package name */
    public static final boolean f2135p = o.f2164a;

    /* renamed from: j, reason: collision with root package name */
    public final BlockingQueue f2136j;

    /* renamed from: k, reason: collision with root package name */
    public final BlockingQueue f2137k;

    /* renamed from: l, reason: collision with root package name */
    public final R0.d f2138l;

    /* renamed from: m, reason: collision with root package name */
    public final C0519j f2139m;
    public volatile boolean n = false;

    /* renamed from: o, reason: collision with root package name */
    public final t f2140o;

    public c(PriorityBlockingQueue priorityBlockingQueue, PriorityBlockingQueue priorityBlockingQueue2, R0.d dVar, C0519j c0519j) {
        this.f2136j = priorityBlockingQueue;
        this.f2137k = priorityBlockingQueue2;
        this.f2138l = dVar;
        this.f2139m = c0519j;
        t tVar = new t();
        tVar.f2833c = new HashMap();
        tVar.f2834d = c0519j;
        tVar.f2835e = this;
        tVar.f2836f = priorityBlockingQueue2;
        this.f2140o = tVar;
    }

    private void a() throws InterruptedException {
        R0.f fVar = (R0.f) this.f2136j.take();
        fVar.a("cache-queue-take");
        fVar.j(1);
        try {
            synchronized (fVar.n) {
            }
            b bVarA = this.f2138l.a(fVar.d());
            if (bVarA == null) {
                fVar.a("cache-miss");
                if (!this.f2140o.h(fVar)) {
                    this.f2137k.put(fVar);
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (bVarA.f2133e < jCurrentTimeMillis) {
                    fVar.a("cache-hit-expired");
                    fVar.f2223u = bVarA;
                    if (!this.f2140o.h(fVar)) {
                        this.f2137k.put(fVar);
                    }
                } else {
                    fVar.a("cache-hit");
                    C0016n c0016nI = fVar.i(new C0016n(bVarA.f2129a, bVarA.g));
                    fVar.a("cache-hit-parsed");
                    if (!(((l) c0016nI.f397f) == null)) {
                        fVar.a("cache-parsing-failed");
                        R0.d dVar = this.f2138l;
                        String strD = fVar.d();
                        synchronized (dVar) {
                            b bVarA2 = dVar.a(strD);
                            if (bVarA2 != null) {
                                bVarA2.f2134f = 0L;
                                bVarA2.f2133e = 0L;
                                dVar.f(strD, bVarA2);
                            }
                        }
                        fVar.f2223u = null;
                        if (!this.f2140o.h(fVar)) {
                            this.f2137k.put(fVar);
                        }
                    } else if (bVarA.f2134f < jCurrentTimeMillis) {
                        fVar.a("cache-hit-refresh-needed");
                        fVar.f2223u = bVarA;
                        c0016nI.f394c = true;
                        if (this.f2140o.h(fVar)) {
                            this.f2139m.s(fVar, c0016nI, null);
                        } else {
                            this.f2139m.s(fVar, c0016nI, new p(this, 3, fVar));
                        }
                    } else {
                        this.f2139m.s(fVar, c0016nI, null);
                    }
                }
            }
        } finally {
            fVar.j(2);
        }
    }

    public final void b() {
        this.n = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        if (f2135p) {
            o.d("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f2138l.d();
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.n) {
                    Thread.currentThread().interrupt();
                    return;
                }
                o.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
