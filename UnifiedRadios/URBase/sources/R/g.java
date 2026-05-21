package r;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import w1.AbstractC0930a;
import z2.InterfaceFutureC1000b;

/* loaded from: classes.dex */
public abstract class g implements InterfaceFutureC1000b {

    /* renamed from: m, reason: collision with root package name */
    public static final boolean f9497m = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger n = Logger.getLogger(g.class.getName());

    /* renamed from: o, reason: collision with root package name */
    public static final AbstractC0930a f9498o;

    /* renamed from: p, reason: collision with root package name */
    public static final Object f9499p;

    /* renamed from: j, reason: collision with root package name */
    public volatile Object f9500j;

    /* renamed from: k, reason: collision with root package name */
    public volatile c f9501k;

    /* renamed from: l, reason: collision with root package name */
    public volatile f f9502l;

    static {
        AbstractC0930a eVar;
        try {
            eVar = new d(AtomicReferenceFieldUpdater.newUpdater(f.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(f.class, f.class, "b"), AtomicReferenceFieldUpdater.newUpdater(g.class, f.class, "l"), AtomicReferenceFieldUpdater.newUpdater(g.class, c.class, "k"), AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "j"));
            th = null;
        } catch (Throwable th) {
            th = th;
            eVar = new e();
        }
        f9498o = eVar;
        if (th != null) {
            n.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f9499p = new Object();
    }

    public static void d(g gVar) {
        f fVar;
        c cVar;
        c cVar2;
        c cVar3;
        do {
            fVar = gVar.f9502l;
        } while (!f9498o.g(gVar, fVar, f.f9494c));
        while (true) {
            cVar = null;
            if (fVar == null) {
                break;
            }
            Thread thread = fVar.f9495a;
            if (thread != null) {
                fVar.f9495a = null;
                LockSupport.unpark(thread);
            }
            fVar = fVar.f9496b;
        }
        gVar.c();
        do {
            cVar2 = gVar.f9501k;
        } while (!f9498o.e(gVar, cVar2, c.f9487d));
        while (true) {
            cVar3 = cVar;
            cVar = cVar2;
            if (cVar == null) {
                break;
            }
            cVar2 = cVar.f9490c;
            cVar.f9490c = cVar3;
        }
        while (cVar3 != null) {
            c cVar4 = cVar3.f9490c;
            e(cVar3.f9488a, cVar3.f9489b);
            cVar3 = cVar4;
        }
    }

    public static void e(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e5) {
            n.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e5);
        }
    }

    public static Object f(Object obj) throws ExecutionException {
        if (obj instanceof C0870a) {
            Throwable th = ((C0870a) obj).f9485b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof C0871b) {
            throw new ExecutionException(((C0871b) obj).f9486a);
        }
        if (obj == f9499p) {
            return null;
        }
        return obj;
    }

    @Override // z2.InterfaceFutureC1000b
    public final void a(Runnable runnable, Executor executor) {
        executor.getClass();
        c cVar = this.f9501k;
        c cVar2 = c.f9487d;
        if (cVar != cVar2) {
            c cVar3 = new c(runnable, executor);
            do {
                cVar3.f9490c = cVar;
                if (f9498o.e(this, cVar, cVar3)) {
                    return;
                } else {
                    cVar = this.f9501k;
                }
            } while (cVar != cVar2);
        }
        e(runnable, executor);
    }

    public final void b(StringBuilder sb) {
        Object obj;
        boolean z4 = false;
        while (true) {
            try {
                try {
                    obj = get();
                    break;
                } catch (InterruptedException unused) {
                    z4 = true;
                } catch (Throwable th) {
                    if (z4) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException unused2) {
                sb.append("CANCELLED");
                return;
            } catch (RuntimeException e5) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e5.getClass());
                sb.append(" thrown from get()]");
                return;
            } catch (ExecutionException e6) {
                sb.append("FAILURE, cause=[");
                sb.append(e6.getCause());
                sb.append("]");
                return;
            }
        }
        if (z4) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        sb.append(obj == this ? "this future" : String.valueOf(obj));
        sb.append("]");
    }

    public void c() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z4) {
        Object obj = this.f9500j;
        if (obj != null) {
            return false;
        }
        if (!f9498o.f(this, obj, f9497m ? new C0870a(z4, new CancellationException("Future.cancel() was called.")) : z4 ? C0870a.f9482c : C0870a.f9483d)) {
            return false;
        }
        d(this);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String g() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j5, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j5);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f9500j;
        if (obj != null) {
            return f(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            f fVar = this.f9502l;
            f fVar2 = f.f9494c;
            if (fVar != fVar2) {
                f fVar3 = new f();
                do {
                    AbstractC0930a abstractC0930a = f9498o;
                    abstractC0930a.m(fVar3, fVar);
                    if (abstractC0930a.g(this, fVar, fVar3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                h(fVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f9500j;
                            if (obj2 != null) {
                                return f(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        h(fVar3);
                    } else {
                        fVar = this.f9502l;
                    }
                } while (fVar != fVar2);
            }
            return f(this.f9500j);
        }
        while (nanos > 0) {
            Object obj3 = this.f9500j;
            if (obj3 != null) {
                return f(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String strB = "Waited " + j5 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strB2 = com.unified.ur1.SatelliteTracker.h.b(strB, " (plus ");
            long j6 = -nanos;
            long jConvert = timeUnit.convert(j6, TimeUnit.NANOSECONDS);
            long nanos2 = j6 - timeUnit.toNanos(jConvert);
            boolean z4 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strB3 = strB2 + jConvert + " " + lowerCase;
                if (z4) {
                    strB3 = com.unified.ur1.SatelliteTracker.h.b(strB3, ",");
                }
                strB2 = com.unified.ur1.SatelliteTracker.h.b(strB3, " ");
            }
            if (z4) {
                strB2 = strB2 + nanos2 + " nanoseconds ";
            }
            strB = com.unified.ur1.SatelliteTracker.h.b(strB2, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(com.unified.ur1.SatelliteTracker.h.b(strB, " but future completed as timeout expired"));
        }
        throw new TimeoutException(strB + " for " + string);
    }

    public final void h(f fVar) {
        fVar.f9495a = null;
        while (true) {
            f fVar2 = this.f9502l;
            if (fVar2 == f.f9494c) {
                return;
            }
            f fVar3 = null;
            while (fVar2 != null) {
                f fVar4 = fVar2.f9496b;
                if (fVar2.f9495a != null) {
                    fVar3 = fVar2;
                } else if (fVar3 != null) {
                    fVar3.f9496b = fVar4;
                    if (fVar3.f9495a == null) {
                        break;
                    }
                } else if (!f9498o.g(this, fVar2, fVar4)) {
                    break;
                }
                fVar2 = fVar4;
            }
            return;
        }
    }

    public boolean i(Object obj) {
        if (obj == null) {
            obj = f9499p;
        }
        if (!f9498o.f(this, null, obj)) {
            return false;
        }
        d(this);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f9500j instanceof C0870a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f9500j != null;
    }

    public boolean j(Throwable th) {
        th.getClass();
        if (!f9498o.f(this, null, new C0871b(th))) {
            return false;
        }
        d(this);
        return true;
    }

    public final String toString() {
        String strG;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f9500j instanceof C0870a) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            b(sb);
        } else {
            try {
                strG = g();
            } catch (RuntimeException e5) {
                strG = "Exception thrown from implementation: " + e5.getClass();
            }
            if (strG != null && !strG.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strG);
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
            Object obj2 = this.f9500j;
            if (obj2 != null) {
                return f(obj2);
            }
            f fVar = this.f9502l;
            f fVar2 = f.f9494c;
            if (fVar != fVar2) {
                f fVar3 = new f();
                do {
                    AbstractC0930a abstractC0930a = f9498o;
                    abstractC0930a.m(fVar3, fVar);
                    if (abstractC0930a.g(this, fVar, fVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f9500j;
                            } else {
                                h(fVar3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return f(obj);
                    }
                    fVar = this.f9502l;
                } while (fVar != fVar2);
            }
            return f(this.f9500j);
        }
        throw new InterruptedException();
    }
}
