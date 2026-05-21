package W3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class s extends I {

    /* renamed from: a, reason: collision with root package name */
    public I f2656a;

    public s(I i5) {
        F3.i.f(i5, "delegate");
        this.f2656a = i5;
    }

    @Override // W3.I
    public final I clearDeadline() {
        return this.f2656a.clearDeadline();
    }

    @Override // W3.I
    public final I clearTimeout() {
        return this.f2656a.clearTimeout();
    }

    @Override // W3.I
    public final long deadlineNanoTime() {
        return this.f2656a.deadlineNanoTime();
    }

    @Override // W3.I
    public final boolean hasDeadline() {
        return this.f2656a.hasDeadline();
    }

    @Override // W3.I
    public final void throwIfReached() throws IOException {
        this.f2656a.throwIfReached();
    }

    @Override // W3.I
    public final I timeout(long j5, TimeUnit timeUnit) {
        F3.i.f(timeUnit, "unit");
        return this.f2656a.timeout(j5, timeUnit);
    }

    @Override // W3.I
    public final long timeoutNanos() {
        return this.f2656a.timeoutNanos();
    }

    @Override // W3.I
    public final I deadlineNanoTime(long j5) {
        return this.f2656a.deadlineNanoTime(j5);
    }
}
