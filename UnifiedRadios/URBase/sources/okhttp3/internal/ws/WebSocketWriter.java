package okhttp3.internal.ws;

import F3.i;
import W3.C0196i;
import W3.l;
import W3.m;
import W3.o;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;

/* loaded from: classes.dex */
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    private final C0196i maskCursor;
    private final byte[] maskKey;
    private final l messageBuffer;
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final m sink;
    private final l sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z4, m mVar, Random random, boolean z5, boolean z6, long j5) {
        i.f(mVar, "sink");
        i.f(random, "random");
        this.isClient = z4;
        this.sink = mVar;
        this.random = random;
        this.perMessageDeflate = z5;
        this.noContextTakeover = z6;
        this.minimumDeflateSize = j5;
        this.messageBuffer = new l();
        this.sinkBuffer = mVar.b();
        this.maskKey = z4 ? new byte[4] : null;
        this.maskCursor = z4 ? new C0196i() : null;
    }

    private final void writeControlFrame(int i5, o oVar) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int iC = oVar.c();
        if (iC > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        this.sinkBuffer.e0(i5 | 128);
        if (this.isClient) {
            this.sinkBuffer.e0(iC | 128);
            Random random = this.random;
            byte[] bArr = this.maskKey;
            i.c(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.d0(this.maskKey);
            if (iC > 0) {
                l lVar = this.sinkBuffer;
                long j5 = lVar.f2648k;
                lVar.c0(oVar);
                l lVar2 = this.sinkBuffer;
                C0196i c0196i = this.maskCursor;
                i.c(c0196i);
                lVar2.W(c0196i);
                this.maskCursor.c(j5);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.e0(iC);
            this.sinkBuffer.c0(oVar);
        }
        this.sink.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater != null) {
            messageDeflater.close();
        }
    }

    public final Random getRandom() {
        return this.random;
    }

    public final m getSink() {
        return this.sink;
    }

    public final void writeClose(int i5, o oVar) throws IOException {
        o oVarG = o.f2649m;
        if (i5 != 0 || oVar != null) {
            if (i5 != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(i5);
            }
            l lVar = new l();
            lVar.j0(i5);
            if (oVar != null) {
                lVar.c0(oVar);
            }
            oVarG = lVar.g(lVar.f2648k);
        }
        try {
            writeControlFrame(8, oVarG);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int i5, o oVar) throws IOException {
        i.f(oVar, "data");
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        this.messageBuffer.c0(oVar);
        int i6 = i5 | 128;
        if (this.perMessageDeflate && oVar.c() >= this.minimumDeflateSize) {
            MessageDeflater messageDeflater = this.messageDeflater;
            if (messageDeflater == null) {
                messageDeflater = new MessageDeflater(this.noContextTakeover);
                this.messageDeflater = messageDeflater;
            }
            messageDeflater.deflate(this.messageBuffer);
            i6 = i5 | 192;
        }
        long j5 = this.messageBuffer.f2648k;
        this.sinkBuffer.e0(i6);
        int i7 = this.isClient ? 128 : 0;
        if (j5 <= 125) {
            this.sinkBuffer.e0(i7 | ((int) j5));
        } else if (j5 <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.sinkBuffer.e0(i7 | WebSocketProtocol.PAYLOAD_SHORT);
            this.sinkBuffer.j0((int) j5);
        } else {
            this.sinkBuffer.e0(i7 | 127);
            this.sinkBuffer.i0(j5);
        }
        if (this.isClient) {
            Random random = this.random;
            byte[] bArr = this.maskKey;
            i.c(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.d0(this.maskKey);
            if (j5 > 0) {
                l lVar = this.messageBuffer;
                C0196i c0196i = this.maskCursor;
                i.c(c0196i);
                lVar.W(c0196i);
                this.maskCursor.c(0L);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        this.sinkBuffer.write(this.messageBuffer, j5);
        this.sink.j();
    }

    public final void writePing(o oVar) throws IOException {
        i.f(oVar, "payload");
        writeControlFrame(9, oVar);
    }

    public final void writePong(o oVar) throws IOException {
        i.f(oVar, "payload");
        writeControlFrame(10, oVar);
    }
}
