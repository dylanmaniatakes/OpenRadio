package okhttp3.internal.connection;

import F3.i;
import W3.AbstractC0189b;
import W3.D;
import W3.F;
import W3.l;
import W3.q;
import W3.r;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes.dex */
public final class Exchange {
    private final RealCall call;
    private final ExchangeCodec codec;
    private final RealConnection connection;
    private final EventListener eventListener;
    private final ExchangeFinder finder;
    private boolean hasFailure;
    private boolean isDuplex;

    public final class RequestBodySink extends q {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RequestBodySink(Exchange exchange, D d5, long j5) {
            super(d5);
            i.f(d5, "delegate");
            this.this$0 = exchange;
            this.contentLength = j5;
        }

        private final <E extends IOException> E complete(E e5) {
            if (this.completed) {
                return e5;
            }
            this.completed = true;
            return (E) this.this$0.bodyComplete(this.bytesReceived, false, true, e5);
        }

        @Override // W3.q, W3.D, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j5 = this.contentLength;
            if (j5 != -1 && this.bytesReceived != j5) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                complete(null);
            } catch (IOException e5) {
                throw complete(e5);
            }
        }

        @Override // W3.q, W3.D, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e5) {
                throw complete(e5);
            }
        }

        @Override // W3.q, W3.D
        public void write(l lVar, long j5) throws IOException {
            i.f(lVar, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            long j6 = this.contentLength;
            if (j6 == -1 || this.bytesReceived + j5 <= j6) {
                try {
                    super.write(lVar, j5);
                    this.bytesReceived += j5;
                    return;
                } catch (IOException e5) {
                    throw complete(e5);
                }
            }
            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + j5));
        }
    }

    public final class ResponseBodySource extends r {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;
        final /* synthetic */ Exchange this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResponseBodySource(Exchange exchange, F f5, long j5) {
            super(f5);
            i.f(f5, "delegate");
            this.this$0 = exchange;
            this.contentLength = j5;
            this.invokeStartEvent = true;
            if (j5 == 0) {
                complete(null);
            }
        }

        @Override // W3.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                complete(null);
            } catch (IOException e5) {
                throw complete(e5);
            }
        }

        public final <E extends IOException> E complete(E e5) {
            if (this.completed) {
                return e5;
            }
            this.completed = true;
            if (e5 == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
            }
            return (E) this.this$0.bodyComplete(this.bytesReceived, true, false, e5);
        }

        @Override // W3.r, W3.F
        public long read(l lVar, long j5) throws IOException {
            i.f(lVar, "sink");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long j6 = delegate().read(lVar, j5);
                if (this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    this.this$0.getEventListener$okhttp().responseBodyStart(this.this$0.getCall$okhttp());
                }
                if (j6 == -1) {
                    complete(null);
                    return -1L;
                }
                long j7 = this.bytesReceived + j6;
                long j8 = this.contentLength;
                if (j8 != -1 && j7 > j8) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j7);
                }
                this.bytesReceived = j7;
                if (j7 == j8) {
                    complete(null);
                }
                return j6;
            } catch (IOException e5) {
                throw complete(e5);
            }
        }
    }

    public Exchange(RealCall realCall, EventListener eventListener, ExchangeFinder exchangeFinder, ExchangeCodec exchangeCodec) {
        i.f(realCall, "call");
        i.f(eventListener, "eventListener");
        i.f(exchangeFinder, "finder");
        i.f(exchangeCodec, "codec");
        this.call = realCall;
        this.eventListener = eventListener;
        this.finder = exchangeFinder;
        this.codec = exchangeCodec;
        this.connection = exchangeCodec.getConnection();
    }

    private final void trackFailure(IOException iOException) {
        this.hasFailure = true;
        this.finder.trackFailure(iOException);
        this.codec.getConnection().trackFailure$okhttp(this.call, iOException);
    }

    public final <E extends IOException> E bodyComplete(long j5, boolean z4, boolean z5, E e5) {
        if (e5 != null) {
            trackFailure(e5);
        }
        if (z5) {
            if (e5 != null) {
                this.eventListener.requestFailed(this.call, e5);
            } else {
                this.eventListener.requestBodyEnd(this.call, j5);
            }
        }
        if (z4) {
            if (e5 != null) {
                this.eventListener.responseFailed(this.call, e5);
            } else {
                this.eventListener.responseBodyEnd(this.call, j5);
            }
        }
        return (E) this.call.messageDone$okhttp(this, z5, z4, e5);
    }

    public final void cancel() {
        this.codec.cancel();
    }

    public final D createRequestBody(Request request, boolean z4) throws IOException {
        i.f(request, "request");
        this.isDuplex = z4;
        RequestBody requestBodyBody = request.body();
        i.c(requestBodyBody);
        long jContentLength = requestBodyBody.contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this, this.codec.createRequestBody(request, jContentLength), jContentLength);
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, null);
    }

    public final void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
        } catch (IOException e5) {
            this.eventListener.requestFailed(this.call, e5);
            trackFailure(e5);
            throw e5;
        }
    }

    public final void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
        } catch (IOException e5) {
            this.eventListener.requestFailed(this.call, e5);
            trackFailure(e5);
            throw e5;
        }
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final RealConnection getConnection$okhttp() {
        return this.connection;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean getHasFailure$okhttp() {
        return this.hasFailure;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !i.a(this.finder.getAddress$okhttp().url().host(), this.connection.route().address().url().host());
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    public final RealWebSocket.Streams newWebSocketStreams() throws SocketException {
        this.call.timeoutEarlyExit();
        return this.codec.getConnection().newWebSocketStreams$okhttp(this);
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getConnection().noNewExchanges$okhttp();
    }

    public final void noRequestBody() {
        this.call.messageDone$okhttp(this, true, false, null);
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        i.f(response, "response");
        try {
            String strHeader$default = Response.header$default(response, "Content-Type", null, 2, null);
            long jReportedContentLength = this.codec.reportedContentLength(response);
            return new RealResponseBody(strHeader$default, jReportedContentLength, AbstractC0189b.c(new ResponseBodySource(this, this.codec.openResponseBodySource(response), jReportedContentLength)));
        } catch (IOException e5) {
            this.eventListener.responseFailed(this.call, e5);
            trackFailure(e5);
            throw e5;
        }
    }

    public final Response.Builder readResponseHeaders(boolean z4) throws IOException {
        try {
            Response.Builder responseHeaders = this.codec.readResponseHeaders(z4);
            if (responseHeaders != null) {
                responseHeaders.initExchange$okhttp(this);
            }
            return responseHeaders;
        } catch (IOException e5) {
            this.eventListener.responseFailed(this.call, e5);
            trackFailure(e5);
            throw e5;
        }
    }

    public final void responseHeadersEnd(Response response) {
        i.f(response, "response");
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    public final Headers trailers() throws IOException {
        return this.codec.trailers();
    }

    public final void webSocketUpgradeFailed() {
        bodyComplete(-1L, true, true, null);
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        i.f(request, "request");
        try {
            this.eventListener.requestHeadersStart(this.call);
            this.codec.writeRequestHeaders(request);
            this.eventListener.requestHeadersEnd(this.call, request);
        } catch (IOException e5) {
            this.eventListener.requestFailed(this.call, e5);
            trackFailure(e5);
            throw e5;
        }
    }
}
