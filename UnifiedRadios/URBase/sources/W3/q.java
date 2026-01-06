package W3;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class q implements D {
    private final D delegate;

    public q(D d5) {
        F3.i.f(d5, "delegate");
        this.delegate = d5;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final D m1deprecated_delegate() {
        return this.delegate;
    }

    @Override // W3.D, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final D delegate() {
        return this.delegate;
    }

    @Override // W3.D, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // W3.D
    public I timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // W3.D
    public void write(l lVar, long j5) throws IOException {
        F3.i.f(lVar, "source");
        this.delegate.write(lVar, j5);
    }
}
