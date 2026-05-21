package W3;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class G extends I {
    @Override // W3.I
    public final I deadlineNanoTime(long j5) {
        return this;
    }

    @Override // W3.I
    public final void throwIfReached() {
    }

    @Override // W3.I
    public final I timeout(long j5, TimeUnit timeUnit) {
        F3.i.f(timeUnit, "unit");
        return this;
    }
}
