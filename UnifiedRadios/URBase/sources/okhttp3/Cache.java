package okhttp3;

import F3.f;
import F3.i;
import G3.a;
import J1.C;
import M3.e;
import W3.AbstractC0189b;
import W3.D;
import W3.F;
import W3.j;
import W3.l;
import W3.m;
import W3.n;
import W3.o;
import W3.q;
import W3.r;
import W3.y;
import W3.z;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import t3.s;

/* loaded from: classes.dex */
public final class Cache implements Closeable, Flushable {
    public static final Companion Companion = new Companion(null);
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    public static final class CacheResponseBody extends ResponseBody {
        private final n bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(DiskLruCache.Snapshot snapshot, String str, String str2) {
            i.f(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = AbstractC0189b.c(new r(snapshot.getSource(1)) { // from class: okhttp3.Cache.CacheResponseBody.1
                @Override // W3.r, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    this.getSnapshot().close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            String str = this.contentLength;
            if (str != null) {
                return Util.toLongOrDefault(str, -1L);
            }
            return -1L;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.Companion.parse(str);
            }
            return null;
        }

        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override // okhttp3.ResponseBody
        public n source() {
            return this.bodySource;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        private final Set<String> varyFields(Headers headers) {
            int size = headers.size();
            TreeSet treeSet = null;
            for (int i5 = 0; i5 < size; i5++) {
                if ("Vary".equalsIgnoreCase(headers.name(i5))) {
                    String strValue = headers.value(i5);
                    if (treeSet == null) {
                        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
                        i.e(comparator, "CASE_INSENSITIVE_ORDER");
                        treeSet = new TreeSet(comparator);
                    }
                    Iterator it = e.K(strValue, new char[]{','}).iterator();
                    while (it.hasNext()) {
                        treeSet.add(e.P((String) it.next()).toString());
                    }
                }
            }
            return treeSet == null ? s.f9713j : treeSet;
        }

        public final boolean hasVaryAll(Response response) {
            i.f(response, "<this>");
            return varyFields(response.headers()).contains("*");
        }

        public final String key(HttpUrl httpUrl) {
            i.f(httpUrl, "url");
            o oVar = o.f2649m;
            return C.i(httpUrl.toString()).b("MD5").d();
        }

        public final int readInt$okhttp(n nVar) throws IOException {
            i.f(nVar, "source");
            try {
                long jF = nVar.F();
                String strU = nVar.u();
                if (jF >= 0 && jF <= 2147483647L && strU.length() <= 0) {
                    return (int) jF;
                }
                throw new IOException("expected an int but was \"" + jF + strU + '\"');
            } catch (NumberFormatException e5) {
                throw new IOException(e5.getMessage());
            }
        }

        public final Headers varyHeaders(Response response) {
            i.f(response, "<this>");
            Response responseNetworkResponse = response.networkResponse();
            i.c(responseNetworkResponse);
            return varyHeaders(responseNetworkResponse.request().headers(), response.headers());
        }

        public final boolean varyMatches(Response response, Headers headers, Request request) {
            i.f(response, "cachedResponse");
            i.f(headers, "cachedRequest");
            i.f(request, "newRequest");
            Set<String> setVaryFields = varyFields(response.headers());
            if ((setVaryFields instanceof Collection) && setVaryFields.isEmpty()) {
                return true;
            }
            for (String str : setVaryFields) {
                if (!i.a(headers.values(str), request.headers(str))) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private final Headers varyHeaders(Headers headers, Headers headers2) {
            Set<String> setVaryFields = varyFields(headers2);
            if (setVaryFields.isEmpty()) {
                return Util.EMPTY_HEADERS;
            }
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i5 = 0; i5 < size; i5++) {
                String strName = headers.name(i5);
                if (setVaryFields.contains(strName)) {
                    builder.add(strName, headers.value(i5));
                }
            }
            return builder.build();
        }
    }

    public final class RealCacheRequest implements CacheRequest {
        private final D body;
        private final D cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;
        final /* synthetic */ Cache this$0;

        public RealCacheRequest(final Cache cache, DiskLruCache.Editor editor) {
            i.f(editor, "editor");
            this.this$0 = cache;
            this.editor = editor;
            D dNewSink = editor.newSink(1);
            this.cacheOut = dNewSink;
            this.body = new q(dNewSink) { // from class: okhttp3.Cache.RealCacheRequest.1
                @Override // W3.q, W3.D, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    Cache cache2 = cache;
                    RealCacheRequest realCacheRequest = this;
                    synchronized (cache2) {
                        if (realCacheRequest.getDone()) {
                            return;
                        }
                        realCacheRequest.setDone(true);
                        cache2.setWriteSuccessCount$okhttp(cache2.getWriteSuccessCount$okhttp() + 1);
                        super.close();
                        this.editor.commit();
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() throws IOException {
            Cache cache = this.this$0;
            synchronized (cache) {
                if (this.done) {
                    return;
                }
                this.done = true;
                cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount$okhttp() + 1);
                Util.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public D body() {
            return this.body;
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z4) {
            this.done = z4;
        }
    }

    /* renamed from: okhttp3.Cache$urls$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<String>, a {
        private boolean canRemove;
        private final Iterator<DiskLruCache.Snapshot> delegate;
        private String nextUrl;

        public AnonymousClass1(Cache cache) {
            this.delegate = cache.getCache$okhttp().snapshots();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextUrl != null) {
                return true;
            }
            this.canRemove = false;
            while (this.delegate.hasNext()) {
                try {
                    DiskLruCache.Snapshot next = this.delegate.next();
                    try {
                        continue;
                        this.nextUrl = AbstractC0189b.c(next.getSource(0)).G(Long.MAX_VALUE);
                        AbstractC0399v1.b(next, null);
                        return true;
                    } finally {
                        try {
                            continue;
                        } catch (Throwable th) {
                        }
                    }
                } catch (IOException unused) {
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.canRemove) {
                throw new IllegalStateException("remove() before next()".toString());
            }
            this.delegate.remove();
        }

        @Override // java.util.Iterator
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.nextUrl;
            i.c(str);
            this.nextUrl = null;
            this.canRemove = true;
            return str;
        }
    }

    public Cache(File file, long j5, FileSystem fileSystem) {
        i.f(file, "directory");
        i.f(fileSystem, "fileSystem");
        this.cache = new DiskLruCache(fileSystem, file, VERSION, 2, j5, TaskRunner.INSTANCE);
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public static final String key(HttpUrl httpUrl) {
        return Companion.key(httpUrl);
    }

    /* renamed from: -deprecated_directory, reason: not valid java name */
    public final File m15deprecated_directory() {
        return this.cache.getDirectory();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cache.close();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final File directory() {
        return this.cache.getDirectory();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.cache.flush();
    }

    public final Response get$okhttp(Request request) throws IOException {
        i.f(request, "request");
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(Companion.key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody != null) {
                    Util.closeQuietly(responseBodyBody);
                }
                return null;
            } catch (IOException unused) {
                Util.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final CacheRequest put$okhttp(Response response) {
        DiskLruCache.Editor editorEdit$default;
        i.f(response, "response");
        String strMethod = response.request().method();
        if (HttpMethod.INSTANCE.invalidatesCache(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!i.a(strMethod, "GET")) {
            return null;
        }
        Companion companion = Companion;
        if (companion.hasVaryAll(response)) {
            return null;
        }
        Entry entry = new Entry(response);
        try {
            editorEdit$default = DiskLruCache.edit$default(this.cache, companion.key(response.request().url()), 0L, 2, null);
            if (editorEdit$default == null) {
                return null;
            }
            try {
                entry.writeTo(editorEdit$default);
                return new RealCacheRequest(this, editorEdit$default);
            } catch (IOException unused2) {
                abortQuietly(editorEdit$default);
                return null;
            }
        } catch (IOException unused3) {
            editorEdit$default = null;
        }
    }

    public final void remove$okhttp(Request request) throws IOException {
        i.f(request, "request");
        this.cache.remove(Companion.key(request.url()));
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    public final void setWriteAbortCount$okhttp(int i5) {
        this.writeAbortCount = i5;
    }

    public final void setWriteSuccessCount$okhttp(int i5) {
        this.writeSuccessCount = i5;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized void trackResponse$okhttp(CacheStrategy cacheStrategy) {
        try {
            i.f(cacheStrategy, "cacheStrategy");
            this.requestCount++;
            if (cacheStrategy.getNetworkRequest() != null) {
                this.networkCount++;
            } else if (cacheStrategy.getCacheResponse() != null) {
                this.hitCount++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void update$okhttp(Response response, Response response2) {
        DiskLruCache.Editor editorEdit;
        i.f(response, "cached");
        i.f(response2, "network");
        Entry entry = new Entry(response2);
        ResponseBody responseBodyBody = response.body();
        i.d(responseBodyBody, "null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        try {
            editorEdit = ((CacheResponseBody) responseBodyBody).getSnapshot().edit();
            if (editorEdit == null) {
                return;
            }
            try {
                entry.writeTo(editorEdit);
                editorEdit.commit();
            } catch (IOException unused) {
                abortQuietly(editorEdit);
            }
        } catch (IOException unused2) {
            editorEdit = null;
        }
    }

    public final Iterator<String> urls() throws IOException {
        return new AnonymousClass1(this);
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Cache(File file, long j5) {
        this(file, j5, FileSystem.SYSTEM);
        i.f(file, "directory");
    }

    public static final class Entry {
        public static final Companion Companion = new Companion(null);
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final HttpUrl url;
        private final Headers varyHeaders;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }
        }

        static {
            StringBuilder sb = new StringBuilder();
            Platform.Companion companion = Platform.Companion;
            sb.append(companion.get().getPrefix());
            sb.append("-Sent-Millis");
            SENT_MILLIS = sb.toString();
            RECEIVED_MILLIS = companion.get().getPrefix() + "-Received-Millis";
        }

        public Entry(F f5) throws IOException {
            i.f(f5, "rawSource");
            try {
                z zVarC = AbstractC0189b.c(f5);
                String strG = zVarC.G(Long.MAX_VALUE);
                HttpUrl httpUrl = HttpUrl.Companion.parse(strG);
                if (httpUrl == null) {
                    IOException iOException = new IOException("Cache corruption for ".concat(strG));
                    Platform.Companion.get().log("cache corruption", 5, iOException);
                    throw iOException;
                }
                this.url = httpUrl;
                this.requestMethod = zVarC.G(Long.MAX_VALUE);
                Headers.Builder builder = new Headers.Builder();
                int int$okhttp = Cache.Companion.readInt$okhttp(zVarC);
                for (int i5 = 0; i5 < int$okhttp; i5++) {
                    builder.addLenient$okhttp(zVarC.G(Long.MAX_VALUE));
                }
                this.varyHeaders = builder.build();
                StatusLine statusLine = StatusLine.Companion.parse(zVarC.G(Long.MAX_VALUE));
                this.protocol = statusLine.protocol;
                this.code = statusLine.code;
                this.message = statusLine.message;
                Headers.Builder builder2 = new Headers.Builder();
                int int$okhttp2 = Cache.Companion.readInt$okhttp(zVarC);
                for (int i6 = 0; i6 < int$okhttp2; i6++) {
                    builder2.addLenient$okhttp(zVarC.G(Long.MAX_VALUE));
                }
                String str = SENT_MILLIS;
                String str2 = builder2.get(str);
                String str3 = RECEIVED_MILLIS;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                this.sentRequestMillis = str2 != null ? Long.parseLong(str2) : 0L;
                this.receivedResponseMillis = str4 != null ? Long.parseLong(str4) : 0L;
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String strG2 = zVarC.G(Long.MAX_VALUE);
                    if (strG2.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + strG2 + '\"');
                    }
                    this.handshake = Handshake.Companion.get(!zVarC.y() ? TlsVersion.Companion.forJavaName(zVarC.G(Long.MAX_VALUE)) : TlsVersion.SSL_3_0, CipherSuite.Companion.forJavaName(zVarC.G(Long.MAX_VALUE)), readCertificateList(zVarC), readCertificateList(zVarC));
                } else {
                    this.handshake = null;
                }
                AbstractC0399v1.b(f5, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AbstractC0399v1.b(f5, th);
                    throw th2;
                }
            }
        }

        private final boolean isHttps() {
            return i.a(this.url.scheme(), "https");
        }

        private final List<Certificate> readCertificateList(n nVar) throws IOException, CertificateException {
            int int$okhttp = Cache.Companion.readInt$okhttp(nVar);
            if (int$okhttp == -1) {
                return t3.q.f9711j;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(int$okhttp);
                for (int i5 = 0; i5 < int$okhttp; i5++) {
                    String strU = nVar.u();
                    l lVar = new l();
                    o oVar = o.f2649m;
                    o oVarG = C.g(strU);
                    if (oVarG == null) {
                        throw new IOException("Corrupt certificate in cache entry");
                    }
                    lVar.c0(oVarG);
                    arrayList.add(certificateFactory.generateCertificate(new j(lVar, 0)));
                }
                return arrayList;
            } catch (CertificateException e5) {
                throw new IOException(e5.getMessage());
            }
        }

        private final void writeCertList(m mVar, List<? extends Certificate> list) throws IOException, CertificateEncodingException {
            try {
                mVar.P(list.size()).A(10);
                Iterator<? extends Certificate> it = list.iterator();
                while (it.hasNext()) {
                    byte[] encoded = it.next().getEncoded();
                    o oVar = o.f2649m;
                    i.e(encoded, "bytes");
                    mVar.O(C.l(encoded).a()).A(10);
                }
            } catch (CertificateEncodingException e5) {
                throw new IOException(e5.getMessage());
            }
        }

        public final boolean matches(Request request, Response response) {
            i.f(request, "request");
            i.f(response, "response");
            return i.a(this.url, request.url()) && i.a(this.requestMethod, request.method()) && Cache.Companion.varyMatches(response, this.varyHeaders, request);
        }

        public final Response response(DiskLruCache.Snapshot snapshot) {
            i.f(snapshot, "snapshot");
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public final void writeTo(DiskLruCache.Editor editor) throws IOException {
            i.f(editor, "editor");
            y yVarB = AbstractC0189b.b(editor.newSink(0));
            try {
                yVarB.O(this.url.toString());
                yVarB.A(10);
                yVarB.O(this.requestMethod);
                yVarB.A(10);
                yVarB.P(this.varyHeaders.size());
                yVarB.A(10);
                int size = this.varyHeaders.size();
                for (int i5 = 0; i5 < size; i5++) {
                    yVarB.O(this.varyHeaders.name(i5));
                    yVarB.O(": ");
                    yVarB.O(this.varyHeaders.value(i5));
                    yVarB.A(10);
                }
                yVarB.O(new StatusLine(this.protocol, this.code, this.message).toString());
                yVarB.A(10);
                yVarB.P(this.responseHeaders.size() + 2);
                yVarB.A(10);
                int size2 = this.responseHeaders.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    yVarB.O(this.responseHeaders.name(i6));
                    yVarB.O(": ");
                    yVarB.O(this.responseHeaders.value(i6));
                    yVarB.A(10);
                }
                yVarB.O(SENT_MILLIS);
                yVarB.O(": ");
                yVarB.P(this.sentRequestMillis);
                yVarB.A(10);
                yVarB.O(RECEIVED_MILLIS);
                yVarB.O(": ");
                yVarB.P(this.receivedResponseMillis);
                yVarB.A(10);
                if (isHttps()) {
                    yVarB.A(10);
                    Handshake handshake = this.handshake;
                    i.c(handshake);
                    yVarB.O(handshake.cipherSuite().javaName());
                    yVarB.A(10);
                    writeCertList(yVarB, this.handshake.peerCertificates());
                    writeCertList(yVarB, this.handshake.localCertificates());
                    yVarB.O(this.handshake.tlsVersion().javaName());
                    yVarB.A(10);
                }
                AbstractC0399v1.b(yVarB, null);
            } finally {
            }
        }

        public Entry(Response response) {
            i.f(response, "response");
            this.url = response.request().url();
            this.varyHeaders = Cache.Companion.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }
}
