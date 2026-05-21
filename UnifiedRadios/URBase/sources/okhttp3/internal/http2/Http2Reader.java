package okhttp3.internal.http2;

import F3.f;
import F3.i;
import J3.a;
import W3.F;
import W3.I;
import W3.l;
import W3.n;
import W3.o;
import android.support.v4.media.session.b;
import com.unified.ur1.SatelliteTracker.h;
import g0.AbstractC0535a;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;

/* loaded from: classes.dex */
public final class Http2Reader implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger;
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final n source;

    public static final class Companion {
        private Companion() {
        }

        public final Logger getLogger() {
            return Http2Reader.logger;
        }

        public final int lengthWithoutPadding(int i5, int i6, int i7) throws IOException {
            if ((i6 & 8) != 0) {
                i5--;
            }
            if (i7 <= i5) {
                return i5 - i7;
            }
            throw new IOException(h.c("PROTOCOL_ERROR padding ", " > remaining length ", i7, i5));
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public static final class ContinuationSource implements F {
        private int flags;
        private int left;
        private int length;
        private int padding;
        private final n source;
        private int streamId;

        public ContinuationSource(n nVar) {
            i.f(nVar, "source");
            this.source = nVar;
        }

        private final void readContinuationHeader() throws IOException {
            int i5 = this.streamId;
            int medium = Util.readMedium(this.source);
            this.left = medium;
            this.length = medium;
            int iAnd = Util.and(this.source.U(), 255);
            this.flags = Util.and(this.source.U(), 255);
            Companion companion = Http2Reader.Companion;
            if (companion.getLogger().isLoggable(Level.FINE)) {
                companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, iAnd, this.flags));
            }
            int iM = this.source.m() & Integer.MAX_VALUE;
            this.streamId = iM;
            if (iAnd == 9) {
                if (iM != i5) {
                    throw new IOException("TYPE_CONTINUATION streamId changed");
                }
            } else {
                throw new IOException(iAnd + " != TYPE_CONTINUATION");
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        @Override // W3.F
        public long read(l lVar, long j5) throws IOException {
            i.f(lVar, "sink");
            while (true) {
                int i5 = this.left;
                if (i5 != 0) {
                    long j6 = this.source.read(lVar, Math.min(j5, i5));
                    if (j6 == -1) {
                        return -1L;
                    }
                    this.left -= (int) j6;
                    return j6;
                }
                this.source.i(this.padding);
                this.padding = 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        public final void setFlags(int i5) {
            this.flags = i5;
        }

        public final void setLeft(int i5) {
            this.left = i5;
        }

        public final void setLength(int i5) {
            this.length = i5;
        }

        public final void setPadding(int i5) {
            this.padding = i5;
        }

        public final void setStreamId(int i5) {
            this.streamId = i5;
        }

        @Override // W3.F
        public I timeout() {
            return this.source.timeout();
        }
    }

    public interface Handler {
        void ackSettings();

        void alternateService(int i5, String str, o oVar, String str2, int i6, long j5);

        void data(boolean z4, int i5, n nVar, int i6) throws IOException;

        void goAway(int i5, ErrorCode errorCode, o oVar);

        void headers(boolean z4, int i5, int i6, List<Header> list);

        void ping(boolean z4, int i5, int i6);

        void priority(int i5, int i6, int i7, boolean z4);

        void pushPromise(int i5, int i6, List<Header> list) throws IOException;

        void rstStream(int i5, ErrorCode errorCode);

        void settings(boolean z4, Settings settings);

        void windowUpdate(int i5, long j5);
    }

    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        i.e(logger2, "getLogger(Http2::class.java.name)");
        logger = logger2;
    }

    public Http2Reader(n nVar, boolean z4) {
        i.f(nVar, "source");
        this.source = nVar;
        this.client = z4;
        ContinuationSource continuationSource = new ContinuationSource(nVar);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource, 4096, 0, 4, null);
    }

    private final void readData(Handler handler, int i5, int i6, int i7) throws IOException {
        if (i7 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z4 = (i6 & 1) != 0;
        if ((i6 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int iAnd = (i6 & 8) != 0 ? Util.and(this.source.U(), 255) : 0;
        handler.data(z4, i7, this.source, Companion.lengthWithoutPadding(i5, i6, iAnd));
        this.source.i(iAnd);
    }

    private final void readGoAway(Handler handler, int i5, int i6, int i7) throws IOException {
        if (i5 < 8) {
            throw new IOException(h.a(i5, "TYPE_GOAWAY length < 8: "));
        }
        if (i7 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int iM = this.source.m();
        int iM2 = this.source.m();
        int i8 = i5 - 8;
        ErrorCode errorCodeFromHttp2 = ErrorCode.Companion.fromHttp2(iM2);
        if (errorCodeFromHttp2 == null) {
            throw new IOException(h.a(iM2, "TYPE_GOAWAY unexpected error code: "));
        }
        o oVarG = o.f2649m;
        if (i8 > 0) {
            oVarG = this.source.g(i8);
        }
        handler.goAway(iM, errorCodeFromHttp2, oVarG);
    }

    private final List<Header> readHeaderBlock(int i5, int i6, int i7, int i8) throws IOException {
        this.continuation.setLeft(i5);
        ContinuationSource continuationSource = this.continuation;
        continuationSource.setLength(continuationSource.getLeft());
        this.continuation.setPadding(i6);
        this.continuation.setFlags(i7);
        this.continuation.setStreamId(i8);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler handler, int i5, int i6, int i7) throws IOException {
        if (i7 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z4 = (i6 & 1) != 0;
        int iAnd = (i6 & 8) != 0 ? Util.and(this.source.U(), 255) : 0;
        if ((i6 & 32) != 0) {
            readPriority(handler, i7);
            i5 -= 5;
        }
        handler.headers(z4, i7, -1, readHeaderBlock(Companion.lengthWithoutPadding(i5, i6, iAnd), iAnd, i6, i7));
    }

    private final void readPing(Handler handler, int i5, int i6, int i7) throws IOException {
        if (i5 != 8) {
            throw new IOException(h.a(i5, "TYPE_PING length != 8: "));
        }
        if (i7 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        handler.ping((i6 & 1) != 0, this.source.m(), this.source.m());
    }

    private final void readPriority(Handler handler, int i5, int i6, int i7) throws IOException {
        if (i5 != 5) {
            throw new IOException(AbstractC0535a.j("TYPE_PRIORITY length: ", i5, " != 5"));
        }
        if (i7 == 0) {
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
        readPriority(handler, i7);
    }

    private final void readPushPromise(Handler handler, int i5, int i6, int i7) throws IOException {
        if (i7 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int iAnd = (i6 & 8) != 0 ? Util.and(this.source.U(), 255) : 0;
        handler.pushPromise(i7, this.source.m() & Integer.MAX_VALUE, readHeaderBlock(Companion.lengthWithoutPadding(i5 - 4, i6, iAnd), iAnd, i6, i7));
    }

    private final void readRstStream(Handler handler, int i5, int i6, int i7) throws IOException {
        if (i5 != 4) {
            throw new IOException(AbstractC0535a.j("TYPE_RST_STREAM length: ", i5, " != 4"));
        }
        if (i7 == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int iM = this.source.m();
        ErrorCode errorCodeFromHttp2 = ErrorCode.Companion.fromHttp2(iM);
        if (errorCodeFromHttp2 == null) {
            throw new IOException(h.a(iM, "TYPE_RST_STREAM unexpected error code: "));
        }
        handler.rstStream(i7, errorCodeFromHttp2);
    }

    private final void readSettings(Handler handler, int i5, int i6, int i7) throws IOException {
        int iM;
        if (i7 != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((i6 & 1) != 0) {
            if (i5 != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            handler.ackSettings();
            return;
        }
        if (i5 % 6 != 0) {
            throw new IOException(h.a(i5, "TYPE_SETTINGS length % 6 != 0: "));
        }
        Settings settings = new Settings();
        a aVarH = b.h(b.j(0, i5), 6);
        int i8 = aVarH.f1475j;
        int i9 = aVarH.f1476k;
        int i10 = aVarH.f1477l;
        if ((i10 > 0 && i8 <= i9) || (i10 < 0 && i9 <= i8)) {
            while (true) {
                int iAnd = Util.and(this.source.K(), Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                iM = this.source.m();
                if (iAnd != 2) {
                    if (iAnd == 3) {
                        iAnd = 4;
                    } else if (iAnd != 4) {
                        if (iAnd == 5 && (iM < 16384 || iM > 16777215)) {
                            break;
                        }
                    } else {
                        if (iM < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                        iAnd = 7;
                    }
                } else if (iM != 0 && iM != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                settings.set(iAnd, iM);
                if (i8 == i9) {
                    break;
                } else {
                    i8 += i10;
                }
            }
            throw new IOException(h.a(iM, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
        }
        handler.settings(false, settings);
    }

    private final void readWindowUpdate(Handler handler, int i5, int i6, int i7) throws IOException {
        if (i5 != 4) {
            throw new IOException(h.a(i5, "TYPE_WINDOW_UPDATE length !=4: "));
        }
        long jAnd = Util.and(this.source.m(), 2147483647L);
        if (jAnd == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        handler.windowUpdate(i7, jAnd);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public final boolean nextFrame(boolean z4, Handler handler) throws IOException {
        i.f(handler, "handler");
        try {
            this.source.N(9L);
            int medium = Util.readMedium(this.source);
            if (medium > 16384) {
                throw new IOException(h.a(medium, "FRAME_SIZE_ERROR: "));
            }
            int iAnd = Util.and(this.source.U(), 255);
            int iAnd2 = Util.and(this.source.U(), 255);
            int iM = this.source.m() & Integer.MAX_VALUE;
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Http2.INSTANCE.frameLog(true, iM, medium, iAnd, iAnd2));
            }
            if (z4 && iAnd != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + Http2.INSTANCE.formattedType$okhttp(iAnd));
            }
            switch (iAnd) {
                case 0:
                    readData(handler, medium, iAnd2, iM);
                    return true;
                case 1:
                    readHeaders(handler, medium, iAnd2, iM);
                    return true;
                case 2:
                    readPriority(handler, medium, iAnd2, iM);
                    return true;
                case 3:
                    readRstStream(handler, medium, iAnd2, iM);
                    return true;
                case 4:
                    readSettings(handler, medium, iAnd2, iM);
                    return true;
                case 5:
                    readPushPromise(handler, medium, iAnd2, iM);
                    return true;
                case 6:
                    readPing(handler, medium, iAnd2, iM);
                    return true;
                case 7:
                    readGoAway(handler, medium, iAnd2, iM);
                    return true;
                case 8:
                    readWindowUpdate(handler, medium, iAnd2, iM);
                    return true;
                default:
                    this.source.i(medium);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readConnectionPreface(Handler handler) throws IOException {
        i.f(handler, "handler");
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        n nVar = this.source;
        o oVar = Http2.CONNECTION_PREFACE;
        o oVarG = nVar.g(oVar.c());
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Util.format("<< CONNECTION " + oVarG.d(), new Object[0]));
        }
        if (!i.a(oVar, oVarG)) {
            throw new IOException("Expected a connection header but was ".concat(oVarG.j()));
        }
    }

    private final void readPriority(Handler handler, int i5) throws IOException {
        int iM = this.source.m();
        handler.priority(i5, iM & Integer.MAX_VALUE, Util.and(this.source.U(), 255) + 1, (Integer.MIN_VALUE & iM) != 0);
    }
}
