package N3;

import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import w3.InterfaceC0941i;

/* loaded from: classes.dex */
public final class I extends H implements InterfaceC0151z {

    /* renamed from: l, reason: collision with root package name */
    public final Executor f1819l;

    public I(Executor executor) {
        Method method;
        this.f1819l = executor;
        Method method2 = S3.c.f2386a;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executor instanceof ScheduledThreadPoolExecutor ? (ScheduledThreadPoolExecutor) executor : null;
            if (scheduledThreadPoolExecutor != null && (method = S3.c.f2386a) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // N3.AbstractC0143q
    public final void W(InterfaceC0941i interfaceC0941i, Runnable runnable) {
        try {
            this.f1819l.execute(runnable);
        } catch (RejectedExecutionException e5) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e5);
            AbstractC0146u.d(interfaceC0941i, cancellationException);
            B.f1812b.W(interfaceC0941i, runnable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.f1819l;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof I) && ((I) obj).f1819l == this.f1819l;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f1819l);
    }

    @Override // N3.AbstractC0143q
    public final String toString() {
        return this.f1819l.toString();
    }
}
