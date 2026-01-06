package r;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import z2.InterfaceFutureC1000b;

/* loaded from: classes.dex */
public final class j implements InterfaceFutureC1000b {

    /* renamed from: j, reason: collision with root package name */
    public final WeakReference f9508j;

    /* renamed from: k, reason: collision with root package name */
    public final i f9509k = new i(this);

    public j(h hVar) {
        this.f9508j = new WeakReference(hVar);
    }

    @Override // z2.InterfaceFutureC1000b
    public final void a(Runnable runnable, Executor executor) {
        this.f9509k.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z4) {
        h hVar = (h) this.f9508j.get();
        boolean zCancel = this.f9509k.cancel(z4);
        if (zCancel && hVar != null) {
            hVar.f9503a = null;
            hVar.f9504b = null;
            hVar.f9505c.i(null);
        }
        return zCancel;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f9509k.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f9509k.f9500j instanceof C0870a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f9509k.isDone();
    }

    public final String toString() {
        return this.f9509k.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j5, TimeUnit timeUnit) {
        return this.f9509k.get(j5, timeUnit);
    }
}
