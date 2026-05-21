package W3;

import java.io.Closeable;
import java.io.Flushable;

/* loaded from: classes.dex */
public interface D extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @Override // java.io.Flushable
    void flush();

    I timeout();

    void write(l lVar, long j5);
}
