package W3;

import java.io.EOFException;

/* renamed from: W3.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0195h implements D {
    @Override // W3.D, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // W3.D, java.io.Flushable
    public final void flush() {
    }

    @Override // W3.D
    public final I timeout() {
        return I.NONE;
    }

    @Override // W3.D
    public final void write(l lVar, long j5) throws EOFException {
        F3.i.f(lVar, "source");
        lVar.i(j5);
    }
}
