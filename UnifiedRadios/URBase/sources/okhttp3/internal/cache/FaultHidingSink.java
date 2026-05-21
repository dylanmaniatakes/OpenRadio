package okhttp3.internal.cache;

import E3.l;
import F3.i;
import W3.D;
import W3.q;
import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes.dex */
public class FaultHidingSink extends q {
    private boolean hasErrors;
    private final l onException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaultHidingSink(D d5, l lVar) {
        super(d5);
        i.f(d5, "delegate");
        i.f(lVar, "onException");
        this.onException = lVar;
    }

    @Override // W3.q, W3.D, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e5) {
            this.hasErrors = true;
            this.onException.invoke(e5);
        }
    }

    @Override // W3.q, W3.D, java.io.Flushable
    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e5) {
            this.hasErrors = true;
            this.onException.invoke(e5);
        }
    }

    public final l getOnException() {
        return this.onException;
    }

    @Override // W3.q, W3.D
    public void write(W3.l lVar, long j5) throws EOFException {
        i.f(lVar, "source");
        if (this.hasErrors) {
            lVar.i(j5);
            return;
        }
        try {
            super.write(lVar, j5);
        } catch (IOException e5) {
            this.hasErrors = true;
            this.onException.invoke(e5);
        }
    }
}
