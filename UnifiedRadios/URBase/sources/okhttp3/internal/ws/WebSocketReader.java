package okhttp3.internal.ws;

import F3.i;
import W3.C0196i;
import W3.l;
import W3.n;
import W3.o;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import java.util.zip.DataFormatException;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Settings;

/* loaded from: classes.dex */
public final class WebSocketReader implements Closeable {
    private boolean closed;
    private final l controlFrameBuffer;
    private final FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private final C0196i maskCursor;
    private final byte[] maskKey;
    private final l messageFrameBuffer;
    private MessageInflater messageInflater;
    private final boolean noContextTakeover;
    private int opcode;
    private final boolean perMessageDeflate;
    private boolean readingCompressedMessage;
    private final n source;

    public interface FrameCallback {
        void onReadClose(int i5, String str);

        void onReadMessage(o oVar) throws IOException;

        void onReadMessage(String str) throws IOException;

        void onReadPing(o oVar);

        void onReadPong(o oVar);
    }

    public WebSocketReader(boolean z4, n nVar, FrameCallback frameCallback, boolean z5, boolean z6) {
        i.f(nVar, "source");
        i.f(frameCallback, "frameCallback");
        this.isClient = z4;
        this.source = nVar;
        this.frameCallback = frameCallback;
        this.perMessageDeflate = z5;
        this.noContextTakeover = z6;
        this.controlFrameBuffer = new l();
        this.messageFrameBuffer = new l();
        this.maskKey = z4 ? null : new byte[4];
        this.maskCursor = z4 ? null : new C0196i();
    }

    private final void readControlFrame() throws IOException {
        short sK;
        String strZ;
        long j5 = this.frameLength;
        if (j5 > 0) {
            this.source.H(this.controlFrameBuffer, j5);
            if (!this.isClient) {
                l lVar = this.controlFrameBuffer;
                C0196i c0196i = this.maskCursor;
                i.c(c0196i);
                lVar.W(c0196i);
                this.maskCursor.c(0L);
                WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                C0196i c0196i2 = this.maskCursor;
                byte[] bArr = this.maskKey;
                i.c(bArr);
                webSocketProtocol.toggleMask(c0196i2, bArr);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                l lVar2 = this.controlFrameBuffer;
                long j6 = lVar2.f2648k;
                if (j6 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (j6 != 0) {
                    sK = lVar2.K();
                    strZ = this.controlFrameBuffer.Z();
                    String strCloseCodeExceptionMessage = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(sK);
                    if (strCloseCodeExceptionMessage != null) {
                        throw new ProtocolException(strCloseCodeExceptionMessage);
                    }
                } else {
                    sK = 1005;
                    strZ = "";
                }
                this.frameCallback.onReadClose(sK, strZ);
                this.closed = true;
                return;
            case 9:
                FrameCallback frameCallback = this.frameCallback;
                l lVar3 = this.controlFrameBuffer;
                frameCallback.onReadPing(lVar3.g(lVar3.f2648k));
                return;
            case 10:
                FrameCallback frameCallback2 = this.frameCallback;
                l lVar4 = this.controlFrameBuffer;
                frameCallback2.onReadPong(lVar4.g(lVar4.f2648k));
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Util.toHexString(this.opcode));
        }
    }

    private final void readHeader() throws IOException {
        boolean z4;
        if (this.closed) {
            throw new IOException("closed");
        }
        long jTimeoutNanos = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            int iAnd = Util.and(this.source.U(), 255);
            this.source.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            int i5 = iAnd & 15;
            this.opcode = i5;
            boolean z5 = (iAnd & 128) != 0;
            this.isFinalFrame = z5;
            boolean z6 = (iAnd & 8) != 0;
            this.isControlFrame = z6;
            if (z6 && !z5) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z7 = (iAnd & 64) != 0;
            if (i5 == 1 || i5 == 2) {
                if (!z7) {
                    z4 = false;
                } else {
                    if (!this.perMessageDeflate) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z4 = true;
                }
                this.readingCompressedMessage = z4;
            } else if (z7) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((iAnd & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((iAnd & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            int iAnd2 = Util.and(this.source.U(), 255);
            boolean z8 = (iAnd2 & 128) != 0;
            if (z8 == this.isClient) {
                throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j5 = iAnd2 & 127;
            this.frameLength = j5;
            if (j5 == 126) {
                this.frameLength = Util.and(this.source.K(), Settings.DEFAULT_INITIAL_WINDOW_SIZE);
            } else if (j5 == 127) {
                long jQ = this.source.q();
                this.frameLength = jQ;
                if (jQ < 0) {
                    throw new ProtocolException("Frame length 0x" + Util.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z8) {
                n nVar = this.source;
                byte[] bArr = this.maskKey;
                i.c(bArr);
                nVar.d(bArr);
            }
        } catch (Throwable th) {
            this.source.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private final void readMessage() throws IOException {
        while (!this.closed) {
            long j5 = this.frameLength;
            if (j5 > 0) {
                this.source.H(this.messageFrameBuffer, j5);
                if (!this.isClient) {
                    l lVar = this.messageFrameBuffer;
                    C0196i c0196i = this.maskCursor;
                    i.c(c0196i);
                    lVar.W(c0196i);
                    this.maskCursor.c(this.messageFrameBuffer.f2648k - this.frameLength);
                    WebSocketProtocol webSocketProtocol = WebSocketProtocol.INSTANCE;
                    C0196i c0196i2 = this.maskCursor;
                    byte[] bArr = this.maskKey;
                    i.c(bArr);
                    webSocketProtocol.toggleMask(c0196i2, bArr);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + Util.toHexString(this.opcode));
            }
        }
        throw new IOException("closed");
    }

    private final void readMessageFrame() throws DataFormatException, IOException {
        int i5 = this.opcode;
        if (i5 != 1 && i5 != 2) {
            throw new ProtocolException("Unknown opcode: " + Util.toHexString(i5));
        }
        readMessage();
        if (this.readingCompressedMessage) {
            MessageInflater messageInflater = this.messageInflater;
            if (messageInflater == null) {
                messageInflater = new MessageInflater(this.noContextTakeover);
                this.messageInflater = messageInflater;
            }
            messageInflater.inflate(this.messageFrameBuffer);
        }
        if (i5 == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.Z());
            return;
        }
        FrameCallback frameCallback = this.frameCallback;
        l lVar = this.messageFrameBuffer;
        frameCallback.onReadMessage(lVar.g(lVar.f2648k));
    }

    private final void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            } else {
                readControlFrame();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        MessageInflater messageInflater = this.messageInflater;
        if (messageInflater != null) {
            messageInflater.close();
        }
    }

    public final n getSource() {
        return this.source;
    }

    public final void processNextFrame() throws DataFormatException, IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
