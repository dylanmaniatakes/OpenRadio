package N0;

import h4.r;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import z2.InterfaceFutureC1000b;

/* loaded from: classes.dex */
public abstract class i implements InterfaceFutureC1000b {

    /* renamed from: m, reason: collision with root package name */
    public static final boolean f1780m = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger n = Logger.getLogger(i.class.getName());

    /* renamed from: o, reason: collision with root package name */
    public static final r f1781o;

    /* renamed from: p, reason: collision with root package name */
    public static final Object f1782p;

    /* renamed from: j, reason: collision with root package name */
    public volatile Object f1783j;

    /* renamed from: k, reason: collision with root package name */
    public volatile d f1784k;

    /* renamed from: l, reason: collision with root package name */
    public volatile h f1785l;

    static {
        r gVar;
        try {
            gVar = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(i.class, h.class, "l"), AtomicReferenceFieldUpdater.newUpdater(i.class, d.class, "k"), AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "j"));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        f1781o = gVar;
        if (th != null) {
            n.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f1782p = new Object();
    }

    public static void c(i iVar) {
        d dVar;
        d dVar2;
        d dVar3 = null;
        while (true) {
            h hVar = iVar.f1785l;
            if (f1781o.c(iVar, hVar, h.f1777c)) {
                while (hVar != null) {
                    Thread thread = hVar.f1778a;
                    if (thread != null) {
                        hVar.f1778a = null;
                        LockSupport.unpark(thread);
                    }
                    hVar = hVar.f1779b;
                }
                do {
                    dVar = iVar.f1784k;
                } while (!f1781o.a(iVar, dVar, d.f1766d));
                while (true) {
                    dVar2 = dVar3;
                    dVar3 = dVar;
                    if (dVar3 == null) {
                        break;
                    }
                    dVar = dVar3.f1769c;
                    dVar3.f1769c = dVar2;
                }
                while (dVar2 != null) {
                    dVar3 = dVar2.f1769c;
                    Runnable runnable = dVar2.f1767a;
                    if (runnable instanceof f) {
                        f fVar = (f) runnable;
                        iVar = fVar.f1775j;
                        if (iVar.f1783j == fVar) {
                            if (f1781o.b(iVar, fVar, f(fVar.f1776k))) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        d(runnable, dVar2.f1768b);
                    }
                    dVar2 = dVar3;
                }
                return;
            }
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e5) {
            n.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e5);
        }
    }

    public static Object e(Object obj) throws ExecutionException {
        if (obj instanceof a) {
            Throwable th = ((a) obj).f1762b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof c) {
            throw new ExecutionException(((c) obj).f1765a);
        }
        if (obj == f1782p) {
            return null;
        }
        return obj;
    }

    public static Object f(InterfaceFutureC1000b interfaceFutureC1000b) {
        if (interfaceFutureC1000b instanceof i) {
            Object obj = ((i) interfaceFutureC1000b).f1783j;
            if (!(obj instanceof a)) {
                return obj;
            }
            a aVar = (a) obj;
            return aVar.f1761a ? aVar.f1762b != null ? new a(false, (CancellationException) aVar.f1762b) : a.f1760d : obj;
        }
        boolean zIsCancelled = interfaceFutureC1000b.isCancelled();
        if ((!f1780m) && zIsCancelled) {
            return a.f1760d;
        }
        try {
            Object objG = g(interfaceFutureC1000b);
            return objG == null ? f1782p : objG;
        } catch (CancellationException e5) {
            if (zIsCancelled) {
                return new a(false, e5);
            }
            return new c(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + interfaceFutureC1000b, e5));
        } catch (ExecutionException e6) {
            return new c(e6.getCause());
        } catch (Throwable th) {
            return new c(th);
        }
    }

    public static Object g(Future future) {
        Object obj;
        boolean z4 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z4 = true;
            } catch (Throwable th) {
                if (z4) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z4) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    @Override // z2.InterfaceFutureC1000b
    public final void a(Runnable runnable, Executor executor) {
        executor.getClass();
        d dVar = this.f1784k;
        d dVar2 = d.f1766d;
        if (dVar != dVar2) {
            d dVar3 = new d(runnable, executor);
            do {
                dVar3.f1769c = dVar;
                if (f1781o.a(this, dVar, dVar3)) {
                    return;
                } else {
                    dVar = this.f1784k;
                }
            } while (dVar != dVar2);
        }
        d(runnable, executor);
    }

    public final void b(StringBuilder sb) {
        try {
            Object objG = g(this);
            sb.append("SUCCESS, result=[");
            sb.append(objG == this ? "this future" : String.valueOf(objG));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e5) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e5.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e6) {
            sb.append("FAILURE, cause=[");
            sb.append(e6.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z4) {
        Object obj = this.f1783j;
        if (!(obj == null) && !(obj instanceof f)) {
            return false;
        }
        a aVar = f1780m ? new a(z4, new CancellationException("Future.cancel() was called.")) : z4 ? a.f1759c : a.f1760d;
        i iVar = this;
        boolean z5 = false;
        while (true) {
            if (f1781o.b(iVar, obj, aVar)) {
                c(iVar);
                if (!(obj instanceof f)) {
                    return true;
                }
                InterfaceFutureC1000b interfaceFutureC1000b = ((f) obj).f1776k;
                if (!(interfaceFutureC1000b instanceof i)) {
                    interfaceFutureC1000b.cancel(z4);
                    return true;
                }
                iVar = (i) interfaceFutureC1000b;
                obj = iVar.f1783j;
                if (!(obj == null) && !(obj instanceof f)) {
                    return true;
                }
                z5 = true;
            } else {
                obj = iVar.f1783j;
                if (!(obj instanceof f)) {
                    return z5;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b5  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00a8 -> B:36:0x0074). Please report as a decompilation issue!!! */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(long r20, java.util.concurrent.TimeUnit r22) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N0.i.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String h() {
        Object obj = this.f1783j;
        if (obj instanceof f) {
            StringBuilder sb = new StringBuilder("setFuture=[");
            InterfaceFutureC1000b interfaceFutureC1000b = ((f) obj).f1776k;
            return com.unified.ur1.SatelliteTracker.h.e(sb, interfaceFutureC1000b == this ? "this future" : String.valueOf(interfaceFutureC1000b), "]");
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void i(h hVar) {
        hVar.f1778a = null;
        while (true) {
            h hVar2 = this.f1785l;
            if (hVar2 == h.f1777c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.f1779b;
                if (hVar2.f1778a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.f1779b = hVar4;
                    if (hVar3.f1778a == null) {
                        break;
                    }
                } else if (!f1781o.c(this, hVar2, hVar4)) {
                    break;
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f1783j instanceof a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof f)) & (this.f1783j != null);
    }

    public final String toString() {
        String strH;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f1783j instanceof a) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            b(sb);
        } else {
            try {
                strH = h();
            } catch (RuntimeException e5) {
                strH = "Exception thrown from implementation: " + e5.getClass();
            }
            if (strH != null && !strH.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strH);
                sb.append("]");
            } else if (isDone()) {
                b(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f1783j;
            if ((obj2 != null) & (!(obj2 instanceof f))) {
                return e(obj2);
            }
            h hVar = this.f1785l;
            h hVar2 = h.f1777c;
            if (hVar != hVar2) {
                h hVar3 = new h();
                do {
                    r rVar = f1781o;
                    rVar.m(hVar3, hVar);
                    if (rVar.c(this, hVar, hVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f1783j;
                            } else {
                                i(hVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return e(obj);
                    }
                    hVar = this.f1785l;
                } while (hVar != hVar2);
            }
            return e(this.f1783j);
        }
        throw new InterruptedException();
    }
}
