package W3;

import g0.AbstractC0535a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/* loaded from: classes.dex */
public class I {
    public static final H Companion = new H();
    public static final I NONE = new G();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public final void awaitSignal(Condition condition) throws InterruptedException, InterruptedIOException {
        F3.i.f(condition, "condition");
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            long jNanoTime = 0;
            if (!zHasDeadline && jTimeoutNanos == 0) {
                condition.await();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime2);
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - jNanoTime2;
            }
            if (jTimeoutNanos > 0) {
                condition.await(jTimeoutNanos, TimeUnit.NANOSECONDS);
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jTimeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public I clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public I clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final I deadline(long j5, TimeUnit timeUnit) {
        F3.i.f(timeUnit, "unit");
        if (j5 <= 0) {
            throw new IllegalArgumentException(AbstractC0535a.h(j5, "duration <= 0: ").toString());
        }
        return deadlineNanoTime(timeUnit.toNanos(j5) + System.nanoTime());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final <T> T intersectWith(I i5, E3.a aVar) {
        F3.i.f(i5, "other");
        F3.i.f(aVar, "block");
        long jTimeoutNanos = timeoutNanos();
        H h = Companion;
        long jTimeoutNanos2 = i5.timeoutNanos();
        long jTimeoutNanos3 = timeoutNanos();
        h.getClass();
        if (jTimeoutNanos2 == 0 || (jTimeoutNanos3 != 0 && jTimeoutNanos2 >= jTimeoutNanos3)) {
            jTimeoutNanos2 = jTimeoutNanos3;
        }
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(jTimeoutNanos2, timeUnit);
        if (!hasDeadline()) {
            if (i5.hasDeadline()) {
                deadlineNanoTime(i5.deadlineNanoTime());
            }
            try {
                T t4 = (T) aVar.invoke();
                timeout(jTimeoutNanos, timeUnit);
                if (i5.hasDeadline()) {
                    clearDeadline();
                }
                return t4;
            } catch (Throwable th) {
                timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                if (i5.hasDeadline()) {
                    clearDeadline();
                }
                throw th;
            }
        }
        long jDeadlineNanoTime = deadlineNanoTime();
        if (i5.hasDeadline()) {
            deadlineNanoTime(Math.min(deadlineNanoTime(), i5.deadlineNanoTime()));
        }
        try {
            T t5 = (T) aVar.invoke();
            timeout(jTimeoutNanos, timeUnit);
            if (i5.hasDeadline()) {
                deadlineNanoTime(jDeadlineNanoTime);
            }
            return t5;
        } catch (Throwable th2) {
            timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            if (i5.hasDeadline()) {
                deadlineNanoTime(jDeadlineNanoTime);
            }
            throw th2;
        }
    }

    public void throwIfReached() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public I timeout(long j5, TimeUnit timeUnit) {
        F3.i.f(timeUnit, "unit");
        if (j5 < 0) {
            throw new IllegalArgumentException(AbstractC0535a.h(j5, "timeout < 0: ").toString());
        }
        this.timeoutNanos = timeUnit.toNanos(j5);
        return this;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object obj) throws InterruptedException, InterruptedIOException {
        F3.i.f(obj, "monitor");
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            long jNanoTime = 0;
            if (!zHasDeadline && jTimeoutNanos == 0) {
                obj.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime2);
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - jNanoTime2;
            }
            if (jTimeoutNanos > 0) {
                long j5 = jTimeoutNanos / 1000000;
                obj.wait(j5, (int) (jTimeoutNanos - (1000000 * j5)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jTimeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public I deadlineNanoTime(long j5) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j5;
        return this;
    }
}
