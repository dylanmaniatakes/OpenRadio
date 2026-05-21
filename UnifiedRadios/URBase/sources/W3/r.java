package W3;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class r implements F {
    private final F delegate;

    public r(F f5) {
        F3.i.f(f5, "delegate");
        this.delegate = f5;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final F m2deprecated_delegate() {
        return this.delegate;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final F delegate() {
        return this.delegate;
    }

    @Override // W3.F
    public long read(l lVar, long j5) throws IOException {
        F3.i.f(lVar, "sink");
        return this.delegate.read(lVar, j5);
    }

    @Override // W3.F
    public I timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
