package okhttp3;

import F3.f;
import F3.i;
import J1.C;
import W3.A;
import W3.AbstractC0189b;
import W3.F;
import W3.H;
import W3.I;
import W3.l;
import W3.n;
import W3.o;
import W3.w;
import X3.a;
import g0.AbstractC0535a;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http1.HeadersReader;

/* loaded from: classes.dex */
public final class MultipartReader implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final w afterBoundaryOptions;
    private final String boundary;
    private boolean closed;
    private final o crlfDashDashBoundary;
    private PartSource currentPart;
    private final o dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final n source;

    public static final class Companion {
        private Companion() {
        }

        public final w getAfterBoundaryOptions() {
            return MultipartReader.afterBoundaryOptions;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public static final class Part implements Closeable {
        private final n body;
        private final Headers headers;

        public Part(Headers headers, n nVar) {
            i.f(headers, "headers");
            i.f(nVar, "body");
            this.headers = headers;
            this.body = nVar;
        }

        public final n body() {
            return this.body;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.body.close();
        }

        public final Headers headers() {
            return this.headers;
        }
    }

    public final class PartSource implements F {
        private final I timeout = new I();

        public PartSource() {
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (i.a(MultipartReader.this.currentPart, this)) {
                MultipartReader.this.currentPart = null;
            }
        }

        @Override // W3.F
        public long read(l lVar, long j5) {
            long j6;
            i.f(lVar, "sink");
            if (j5 < 0) {
                throw new IllegalArgumentException(AbstractC0535a.h(j5, "byteCount < 0: ").toString());
            }
            if (!i.a(MultipartReader.this.currentPart, this)) {
                throw new IllegalStateException("closed".toString());
            }
            I iTimeout = MultipartReader.this.source.timeout();
            I i5 = this.timeout;
            MultipartReader multipartReader = MultipartReader.this;
            long jTimeoutNanos = iTimeout.timeoutNanos();
            H h = I.Companion;
            long jTimeoutNanos2 = i5.timeoutNanos();
            long jTimeoutNanos3 = iTimeout.timeoutNanos();
            h.getClass();
            if (jTimeoutNanos2 == 0 || (jTimeoutNanos3 != 0 && jTimeoutNanos2 >= jTimeoutNanos3)) {
                jTimeoutNanos2 = jTimeoutNanos3;
            }
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            iTimeout.timeout(jTimeoutNanos2, timeUnit);
            if (!iTimeout.hasDeadline()) {
                if (i5.hasDeadline()) {
                    iTimeout.deadlineNanoTime(i5.deadlineNanoTime());
                }
                try {
                    long jCurrentPartBytesRemaining = multipartReader.currentPartBytesRemaining(j5);
                    long j7 = jCurrentPartBytesRemaining == 0 ? -1L : multipartReader.source.read(lVar, jCurrentPartBytesRemaining);
                    iTimeout.timeout(jTimeoutNanos, timeUnit);
                    if (i5.hasDeadline()) {
                        iTimeout.clearDeadline();
                    }
                    return j7;
                } catch (Throwable th) {
                    iTimeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                    if (i5.hasDeadline()) {
                        iTimeout.clearDeadline();
                    }
                    throw th;
                }
            }
            long jDeadlineNanoTime = iTimeout.deadlineNanoTime();
            if (i5.hasDeadline()) {
                j6 = jDeadlineNanoTime;
                iTimeout.deadlineNanoTime(Math.min(iTimeout.deadlineNanoTime(), i5.deadlineNanoTime()));
            } else {
                j6 = jDeadlineNanoTime;
            }
            try {
                long jCurrentPartBytesRemaining2 = multipartReader.currentPartBytesRemaining(j5);
                long j8 = jCurrentPartBytesRemaining2 == 0 ? -1L : multipartReader.source.read(lVar, jCurrentPartBytesRemaining2);
                iTimeout.timeout(jTimeoutNanos, timeUnit);
                if (i5.hasDeadline()) {
                    iTimeout.deadlineNanoTime(j6);
                }
                return j8;
            } catch (Throwable th2) {
                long j9 = j6;
                iTimeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                if (i5.hasDeadline()) {
                    iTimeout.deadlineNanoTime(j9);
                }
                throw th2;
            }
        }

        @Override // W3.F
        public I timeout() {
            return this.timeout;
        }
    }

    static {
        o oVar = o.f2649m;
        afterBoundaryOptions = AbstractC0189b.g(C.i("\r\n"), C.i("--"), C.i(" "), C.i("\t"));
    }

    public MultipartReader(n nVar, String str) throws IOException {
        i.f(nVar, "source");
        i.f(str, "boundary");
        this.source = nVar;
        this.boundary = str;
        l lVar = new l();
        lVar.m0("--");
        lVar.m0(str);
        this.dashDashBoundary = lVar.g(lVar.f2648k);
        l lVar2 = new l();
        lVar2.m0("\r\n--");
        lVar2.m0(str);
        this.crlfDashDashBoundary = lVar2.g(lVar2.f2648k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long currentPartBytesRemaining(long j5) {
        long j6;
        long j7;
        this.source.N(this.crlfDashDashBoundary.c());
        l lVarB = this.source.b();
        o oVar = this.crlfDashDashBoundary;
        lVarB.getClass();
        i.f(oVar, "bytes");
        if (oVar.c() <= 0) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        A a2 = lVarB.f2647j;
        if (a2 == null) {
            j7 = -1;
        } else {
            long j8 = lVarB.f2648k;
            if (j8 < 0) {
                while (j8 > 0) {
                    a2 = a2.g;
                    i.c(a2);
                    j8 -= a2.f2619c - a2.f2618b;
                }
                byte[] bArrE = oVar.e();
                byte b5 = bArrE[0];
                int iC = oVar.c();
                long j9 = (lVarB.f2648k - iC) + 1;
                long j10 = 0;
                loop1: while (j8 < j9) {
                    long j11 = j9;
                    int iMin = (int) Math.min(a2.f2619c, (a2.f2618b + j9) - j8);
                    for (int i5 = (int) ((a2.f2618b + j10) - j8); i5 < iMin; i5++) {
                        if (a2.f2617a[i5] == b5 && a.a(a2, i5 + 1, bArrE, iC)) {
                            j7 = (i5 - a2.f2618b) + j8;
                            break loop1;
                        }
                    }
                    j10 = j8 + (a2.f2619c - a2.f2618b);
                    a2 = a2.f2622f;
                    i.c(a2);
                    j8 = j10;
                    j9 = j11;
                }
                j7 = -1;
            } else {
                long j12 = 0;
                while (true) {
                    long j13 = (a2.f2619c - a2.f2618b) + j12;
                    j6 = 0;
                    if (j13 > 0) {
                        break;
                    }
                    a2 = a2.f2622f;
                    i.c(a2);
                    j12 = j13;
                }
                byte[] bArrE2 = oVar.e();
                byte b6 = bArrE2[0];
                int iC2 = oVar.c();
                long j14 = (lVarB.f2648k - iC2) + 1;
                loop4: while (j12 < j14) {
                    long j15 = j14;
                    int iMin2 = (int) Math.min(a2.f2619c, (a2.f2618b + j14) - j12);
                    for (int i6 = (int) ((a2.f2618b + j6) - j12); i6 < iMin2; i6++) {
                        if (a2.f2617a[i6] == b6 && a.a(a2, i6 + 1, bArrE2, iC2)) {
                            j7 = (i6 - a2.f2618b) + j12;
                            break loop4;
                        }
                    }
                    j6 = (a2.f2619c - a2.f2618b) + j12;
                    a2 = a2.f2622f;
                    i.c(a2);
                    j12 = j6;
                    j14 = j15;
                }
                j7 = -1;
            }
        }
        return j7 == -1 ? Math.min(j5, (this.source.b().f2648k - this.crlfDashDashBoundary.c()) + 1) : Math.min(j5, j7);
    }

    public final String boundary() {
        return this.boundary;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    public final Part nextPart() throws IOException {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.noMoreParts) {
            return null;
        }
        if (this.partCount == 0 && this.source.J(0L, this.dashDashBoundary)) {
            this.source.i(this.dashDashBoundary.c());
        } else {
            while (true) {
                long jCurrentPartBytesRemaining = currentPartBytesRemaining(8192L);
                if (jCurrentPartBytesRemaining == 0) {
                    break;
                }
                this.source.i(jCurrentPartBytesRemaining);
            }
            this.source.i(this.crlfDashDashBoundary.c());
        }
        boolean z4 = false;
        while (true) {
            int iR = this.source.r(afterBoundaryOptions);
            if (iR == -1) {
                throw new ProtocolException("unexpected characters after boundary");
            }
            if (iR == 0) {
                this.partCount++;
                Headers headers = new HeadersReader(this.source).readHeaders();
                PartSource partSource = new PartSource();
                this.currentPart = partSource;
                return new Part(headers, AbstractC0189b.c(partSource));
            }
            if (iR == 1) {
                if (z4) {
                    throw new ProtocolException("unexpected characters after boundary");
                }
                if (this.partCount == 0) {
                    throw new ProtocolException("expected at least 1 part");
                }
                this.noMoreParts = true;
                return null;
            }
            if (iR == 2 || iR == 3) {
                z4 = true;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MultipartReader(ResponseBody responseBody) throws IOException {
        String strParameter;
        i.f(responseBody, "response");
        n nVarSource = responseBody.source();
        MediaType mediaTypeContentType = responseBody.contentType();
        if (mediaTypeContentType != null && (strParameter = mediaTypeContentType.parameter("boundary")) != null) {
            this(nVarSource, strParameter);
            return;
        }
        throw new ProtocolException("expected the Content-Type to have a boundary parameter");
    }
}
