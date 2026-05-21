package okhttp3.internal.ws;

import F3.i;
import W3.AbstractC0189b;
import W3.C0196i;
import W3.l;
import W3.o;
import W3.p;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;

/* loaded from: classes.dex */
public final class MessageDeflater implements Closeable {
    private final l deflatedBytes;
    private final Deflater deflater;
    private final p deflaterSink;
    private final boolean noContextTakeover;

    public MessageDeflater(boolean z4) {
        this.noContextTakeover = z4;
        l lVar = new l();
        this.deflatedBytes = lVar;
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        this.deflaterSink = new p(lVar, deflater);
    }

    private final boolean endsWith(l lVar, o oVar) {
        return lVar.J(lVar.f2648k - oVar.c(), oVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.deflaterSink.close();
    }

    public final void deflate(l lVar) throws IOException {
        i.f(lVar, "buffer");
        if (this.deflatedBytes.f2648k != 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.noContextTakeover) {
            this.deflater.reset();
        }
        this.deflaterSink.write(lVar, lVar.f2648k);
        this.deflaterSink.flush();
        if (endsWith(this.deflatedBytes, MessageDeflaterKt.EMPTY_DEFLATE_BLOCK)) {
            l lVar2 = this.deflatedBytes;
            long j5 = lVar2.f2648k - 4;
            C0196i c0196iW = lVar2.W(AbstractC0189b.f2629a);
            try {
                c0196iW.a(j5);
                AbstractC0399v1.b(c0196iW, null);
            } finally {
            }
        } else {
            this.deflatedBytes.e0(0);
        }
        l lVar3 = this.deflatedBytes;
        lVar.write(lVar3, lVar3.f2648k);
    }
}
