package W3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: W3.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0194g extends I {
    public static final C0190c Companion = new C0190c();
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static final Condition condition;
    private static C0194g head;
    private static final ReentrantLock lock;
    private boolean inQueue;
    private C0194g next;
    private long timeoutAt;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        F3.i.e(conditionNewCondition, "newCondition(...)");
        condition = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static final long access$remainingNanos(C0194g c0194g, long j5) {
        return c0194g.timeoutAt - j5;
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            C0190c c0190c = Companion;
            c0190c.getClass();
            c0190c.getClass();
            ReentrantLock reentrantLock = lock;
            reentrantLock.lock();
            try {
                if (!(!this.inQueue)) {
                    throw new IllegalStateException("Unbalanced enter/exit".toString());
                }
                this.inQueue = true;
                if (head == null) {
                    head = new C0194g();
                    C0191d c0191d = new C0191d("Okio Watchdog");
                    c0191d.setDaemon(true);
                    c0191d.start();
                }
                long jNanoTime = System.nanoTime();
                if (jTimeoutNanos != 0 && zHasDeadline) {
                    this.timeoutAt = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime) + jNanoTime;
                } else if (jTimeoutNanos != 0) {
                    this.timeoutAt = jTimeoutNanos + jNanoTime;
                } else {
                    if (!zHasDeadline) {
                        throw new AssertionError();
                    }
                    this.timeoutAt = deadlineNanoTime();
                }
                long jAccess$remainingNanos = access$remainingNanos(this, jNanoTime);
                C0194g c0194g = head;
                F3.i.c(c0194g);
                while (c0194g.next != null) {
                    C0194g c0194g2 = c0194g.next;
                    F3.i.c(c0194g2);
                    if (jAccess$remainingNanos < access$remainingNanos(c0194g2, jNanoTime)) {
                        break;
                    }
                    c0194g = c0194g.next;
                    F3.i.c(c0194g);
                }
                this.next = c0194g.next;
                c0194g.next = this;
                if (c0194g == head) {
                    Companion.getClass();
                    condition.signal();
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final boolean exit() {
        C0190c c0190c = Companion;
        c0190c.getClass();
        c0190c.getClass();
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (!this.inQueue) {
                return false;
            }
            this.inQueue = false;
            for (C0194g c0194g = head; c0194g != null; c0194g = c0194g.next) {
                if (c0194g.next == this) {
                    c0194g.next = this.next;
                    this.next = null;
                    return false;
                }
            }
            reentrantLock.unlock();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final D sink(D d5) {
        F3.i.f(d5, "sink");
        return new C0192e(this, 0, d5);
    }

    public final F source(F f5) {
        F3.i.f(f5, "source");
        return new C0193f(this, f5);
    }

    public void timedOut() {
    }

    public final <T> T withTimeout(E3.a aVar) throws IOException {
        F3.i.f(aVar, "block");
        enter();
        try {
            T t4 = (T) aVar.invoke();
            if (exit()) {
                throw access$newTimeoutException(null);
            }
            return t4;
        } catch (IOException e5) {
            if (exit()) {
                throw access$newTimeoutException(e5);
            }
            throw e5;
        } finally {
            exit();
        }
    }
}
