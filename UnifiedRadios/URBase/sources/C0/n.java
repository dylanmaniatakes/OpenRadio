package C0;

import N3.T;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import z2.InterfaceFutureC1000b;

/* loaded from: classes.dex */
public final class n implements InterfaceFutureC1000b {

    /* renamed from: j, reason: collision with root package name */
    public final N0.k f165j = new N0.k();

    public n(T t4) {
        t4.F(false, true, new m(0, this));
    }

    @Override // z2.InterfaceFutureC1000b
    public final void a(Runnable runnable, Executor executor) {
        this.f165j.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z4) {
        return this.f165j.cancel(z4);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f165j.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f165j.f1783j instanceof N0.a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f165j.isDone();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j5, TimeUnit timeUnit) {
        return this.f165j.get(j5, timeUnit);
    }
}
