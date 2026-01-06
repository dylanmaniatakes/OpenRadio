package okhttp3.internal.ws;

import F3.i;
import W3.AbstractC0189b;
import W3.l;
import W3.u;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okhttp3.internal.http2.Settings;

/* loaded from: classes.dex */
public final class MessageInflater implements Closeable {
    private final l deflatedBytes;
    private final Inflater inflater;
    private final u inflaterSource;
    private final boolean noContextTakeover;

    public MessageInflater(boolean z4) {
        this.noContextTakeover = z4;
        l lVar = new l();
        this.deflatedBytes = lVar;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new u(AbstractC0189b.c(lVar), inflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    public final void inflate(l lVar) throws DataFormatException, IOException {
        i.f(lVar, "buffer");
        if (this.deflatedBytes.f2648k != 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.noContextTakeover) {
            this.inflater.reset();
        }
        this.deflatedBytes.z(lVar);
        this.deflatedBytes.h0(Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        long bytesRead = this.inflater.getBytesRead() + this.deflatedBytes.f2648k;
        do {
            this.inflaterSource.a(lVar, Long.MAX_VALUE);
        } while (this.inflater.getBytesRead() < bytesRead);
    }
}
