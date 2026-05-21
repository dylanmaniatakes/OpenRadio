package okhttp3.internal.http2;

import F3.f;
import F3.i;
import W3.l;
import W3.m;
import com.unified.ur1.SatelliteTracker.h;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;

/* loaded from: classes.dex */
public final class Http2Writer implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final l hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final m sink;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public Http2Writer(m mVar, boolean z4) {
        i.f(mVar, "sink");
        this.sink = mVar;
        this.client = z4;
        l lVar = new l();
        this.hpackBuffer = lVar;
        this.maxFrameSize = Http2.INITIAL_MAX_FRAME_SIZE;
        this.hpackWriter = new Hpack.Writer(0, false, lVar, 3, null);
    }

    private final void writeContinuationFrames(int i5, long j5) throws IOException {
        while (j5 > 0) {
            long jMin = Math.min(this.maxFrameSize, j5);
            j5 -= jMin;
            frameHeader(i5, (int) jMin, 9, j5 == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, jMin);
        }
    }

    public final synchronized void applyAndAckSettings(Settings settings) throws IOException {
        try {
            i.f(settings, "peerSettings");
            if (this.closed) {
                throw new IOException("closed");
            }
            this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
            if (settings.getHeaderTableSize() != -1) {
                this.hpackWriter.resizeHeaderTable(settings.getHeaderTableSize());
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void connectionPreface() throws IOException {
        try {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (this.client) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.d(), new Object[0]));
                }
                this.sink.B(Http2.CONNECTION_PREFACE);
                this.sink.flush();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void data(boolean z4, int i5, l lVar, int i6) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        dataFrame(i5, z4 ? 1 : 0, lVar, i6);
    }

    public final void dataFrame(int i5, int i6, l lVar, int i7) throws IOException {
        frameHeader(i5, i7, 0, i6);
        if (i7 > 0) {
            m mVar = this.sink;
            i.c(lVar);
            mVar.write(lVar, i7);
        }
    }

    public final synchronized void flush() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public final void frameHeader(int i5, int i6, int i7, int i8) throws IOException {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.INSTANCE.frameLog(false, i5, i6, i7, i8));
        }
        if (i6 > this.maxFrameSize) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + i6).toString());
        }
        if ((Integer.MIN_VALUE & i5) != 0) {
            throw new IllegalArgumentException(h.a(i5, "reserved bit set: ").toString());
        }
        Util.writeMedium(this.sink, i6);
        this.sink.A(i7 & 255);
        this.sink.A(i8 & 255);
        this.sink.n(i5 & Integer.MAX_VALUE);
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int i5, ErrorCode errorCode, byte[] bArr) throws IOException {
        try {
            i.f(errorCode, "errorCode");
            i.f(bArr, "debugData");
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.getHttpCode() == -1) {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
            frameHeader(0, bArr.length + 8, 7, 0);
            this.sink.n(i5);
            this.sink.n(errorCode.getHttpCode());
            if (!(bArr.length == 0)) {
                this.sink.C(bArr);
            }
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void headers(boolean z4, int i5, List<Header> list) throws IOException {
        i.f(list, "headerBlock");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long j5 = this.hpackBuffer.f2648k;
        long jMin = Math.min(this.maxFrameSize, j5);
        int i6 = j5 == jMin ? 4 : 0;
        if (z4) {
            i6 |= 1;
        }
        frameHeader(i5, (int) jMin, 1, i6);
        this.sink.write(this.hpackBuffer, jMin);
        if (j5 > jMin) {
            writeContinuationFrames(i5, j5 - jMin);
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean z4, int i5, int i6) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        frameHeader(0, 8, 6, z4 ? 1 : 0);
        this.sink.n(i5);
        this.sink.n(i6);
        this.sink.flush();
    }

    public final synchronized void pushPromise(int i5, int i6, List<Header> list) throws IOException {
        i.f(list, "requestHeaders");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long j5 = this.hpackBuffer.f2648k;
        int iMin = (int) Math.min(this.maxFrameSize - 4, j5);
        long j6 = iMin;
        frameHeader(i5, iMin + 4, 5, j5 == j6 ? 4 : 0);
        this.sink.n(i6 & Integer.MAX_VALUE);
        this.sink.write(this.hpackBuffer, j6);
        if (j5 > j6) {
            writeContinuationFrames(i5, j5 - j6);
        }
    }

    public final synchronized void rstStream(int i5, ErrorCode errorCode) throws IOException {
        i.f(errorCode, "errorCode");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (errorCode.getHttpCode() == -1) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        frameHeader(i5, 4, 3, 0);
        this.sink.n(errorCode.getHttpCode());
        this.sink.flush();
    }

    public final synchronized void settings(Settings settings) throws IOException {
        try {
            i.f(settings, "settings");
            if (this.closed) {
                throw new IOException("closed");
            }
            int i5 = 0;
            frameHeader(0, settings.size() * 6, 4, 0);
            while (i5 < 10) {
                if (settings.isSet(i5)) {
                    this.sink.k(i5 != 4 ? i5 != 7 ? i5 : 4 : 3);
                    this.sink.n(settings.get(i5));
                }
                i5++;
            }
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void windowUpdate(int i5, long j5) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (j5 == 0 || j5 > 2147483647L) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j5).toString());
        }
        frameHeader(i5, 4, 8, 0);
        this.sink.n((int) j5);
        this.sink.flush();
    }
}
