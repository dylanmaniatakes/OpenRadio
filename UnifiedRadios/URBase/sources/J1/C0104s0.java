package J1;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: J1.s0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0104s0 extends F0 {

    /* renamed from: m, reason: collision with root package name */
    public static final AtomicLong f1378m = new AtomicLong(Long.MIN_VALUE);

    /* renamed from: e, reason: collision with root package name */
    public C0101r0 f1379e;

    /* renamed from: f, reason: collision with root package name */
    public C0101r0 f1380f;
    public final PriorityBlockingQueue g;
    public final LinkedBlockingQueue h;

    /* renamed from: i, reason: collision with root package name */
    public final C0096p0 f1381i;

    /* renamed from: j, reason: collision with root package name */
    public final C0096p0 f1382j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f1383k;

    /* renamed from: l, reason: collision with root package name */
    public final Semaphore f1384l;

    public C0104s0(C0113v0 c0113v0) {
        super(c0113v0);
        this.f1383k = new Object();
        this.f1384l = new Semaphore(2);
        this.g = new PriorityBlockingQueue();
        this.h = new LinkedBlockingQueue();
        this.f1381i = new C0096p0(this, "Thread death: Uncaught exception on worker thread");
        this.f1382j = new C0096p0(this, "Thread death: Uncaught exception on network thread");
    }

    @Override // B.u
    public final void j() {
        if (Thread.currentThread() != this.f1379e) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // J1.F0
    public final boolean k() {
        return false;
    }

    public final void n() {
        if (Thread.currentThread() != this.f1380f) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final Object o(AtomicReference atomicReference, long j5, String str, Runnable runnable) {
        synchronized (atomicReference) {
            C0104s0 c0104s0 = ((C0113v0) this.f84c).f1418l;
            C0113v0.k(c0104s0);
            c0104s0.t(runnable);
            try {
                atomicReference.wait(j5);
            } catch (InterruptedException unused) {
                Z z4 = ((C0113v0) this.f84c).f1417k;
                C0113v0.k(z4);
                z4.f1080k.a("Interrupted waiting for ".concat(str));
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            Z z5 = ((C0113v0) this.f84c).f1417k;
            C0113v0.k(z5);
            z5.f1080k.a("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    public final C0099q0 p(Callable callable) {
        l();
        C0099q0 c0099q0 = new C0099q0(this, callable, false);
        if (Thread.currentThread() == this.f1379e) {
            if (!this.g.isEmpty()) {
                Z z4 = ((C0113v0) this.f84c).f1417k;
                C0113v0.k(z4);
                z4.f1080k.a("Callable skipped the worker queue.");
            }
            c0099q0.run();
        } else {
            w(c0099q0);
        }
        return c0099q0;
    }

    public final C0099q0 q(Callable callable) {
        l();
        C0099q0 c0099q0 = new C0099q0(this, callable, true);
        if (Thread.currentThread() == this.f1379e) {
            c0099q0.run();
        } else {
            w(c0099q0);
        }
        return c0099q0;
    }

    public final void r() {
        if (Thread.currentThread() == this.f1379e) {
            throw new IllegalStateException("Call not expected from worker thread");
        }
    }

    public final void s(Runnable runnable) {
        l();
        C0099q0 c0099q0 = new C0099q0(this, runnable, false, "Task exception on network thread");
        synchronized (this.f1383k) {
            try {
                LinkedBlockingQueue linkedBlockingQueue = this.h;
                linkedBlockingQueue.add(c0099q0);
                C0101r0 c0101r0 = this.f1380f;
                if (c0101r0 == null) {
                    C0101r0 c0101r02 = new C0101r0(this, "Measurement Network", linkedBlockingQueue);
                    this.f1380f = c0101r02;
                    c0101r02.setUncaughtExceptionHandler(this.f1382j);
                    this.f1380f.start();
                } else {
                    Object obj = c0101r0.f1363j;
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void t(Runnable runnable) {
        l();
        q1.E.i(runnable);
        w(new C0099q0(this, runnable, false, "Task exception on worker thread"));
    }

    public final void u(Runnable runnable) {
        l();
        w(new C0099q0(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean v() {
        return Thread.currentThread() == this.f1379e;
    }

    public final void w(C0099q0 c0099q0) {
        synchronized (this.f1383k) {
            try {
                PriorityBlockingQueue priorityBlockingQueue = this.g;
                priorityBlockingQueue.add(c0099q0);
                C0101r0 c0101r0 = this.f1379e;
                if (c0101r0 == null) {
                    C0101r0 c0101r02 = new C0101r0(this, "Measurement Worker", priorityBlockingQueue);
                    this.f1379e = c0101r02;
                    c0101r02.setUncaughtExceptionHandler(this.f1381i);
                    this.f1379e.start();
                } else {
                    Object obj = c0101r0.f1363j;
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
