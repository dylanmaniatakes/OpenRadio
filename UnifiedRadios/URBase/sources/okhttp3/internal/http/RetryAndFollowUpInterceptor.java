package okhttp3.internal.http;

import F3.f;
import F3.i;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.regex.Pattern;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;

/* loaded from: classes.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        i.f(okHttpClient, "client");
        this.client = okHttpClient;
    }

    private final Request buildRedirectRequest(Response response, String str) {
        String strHeader$default;
        HttpUrl httpUrlResolve;
        if (!this.client.followRedirects() || (strHeader$default = Response.header$default(response, "Location", null, 2, null)) == null || (httpUrlResolve = response.request().url().resolve(strHeader$default)) == null) {
            return null;
        }
        if (!i.a(httpUrlResolve.scheme(), response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder builderNewBuilder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(str)) {
            int iCode = response.code();
            HttpMethod httpMethod = HttpMethod.INSTANCE;
            boolean z4 = httpMethod.redirectsWithBody(str) || iCode == 308 || iCode == 307;
            if (!httpMethod.redirectsToGet(str) || iCode == 308 || iCode == 307) {
                builderNewBuilder.method(str, z4 ? response.request().body() : null);
            } else {
                builderNewBuilder.method("GET", null);
            }
            if (!z4) {
                builderNewBuilder.removeHeader("Transfer-Encoding");
                builderNewBuilder.removeHeader("Content-Length");
                builderNewBuilder.removeHeader("Content-Type");
            }
        }
        if (!Util.canReuseConnectionFor(response.request().url(), httpUrlResolve)) {
            builderNewBuilder.removeHeader("Authorization");
        }
        return builderNewBuilder.url(httpUrlResolve).build();
    }

    private final Request followUpRequest(Response response, Exchange exchange) throws IOException {
        RealConnection connection$okhttp;
        Route route = (exchange == null || (connection$okhttp = exchange.getConnection$okhttp()) == null) ? null : connection$okhttp.route();
        int iCode = response.code();
        String strMethod = response.request().method();
        if (iCode != 307 && iCode != 308) {
            if (iCode == 401) {
                return this.client.authenticator().authenticate(route, response);
            }
            if (iCode == 421) {
                RequestBody requestBodyBody = response.request().body();
                if ((requestBodyBody != null && requestBodyBody.isOneShot()) || exchange == null || !exchange.isCoalescedConnection$okhttp()) {
                    return null;
                }
                exchange.getConnection$okhttp().noCoalescedConnections$okhttp();
                return response.request();
            }
            if (iCode == 503) {
                Response responsePriorResponse = response.priorResponse();
                if ((responsePriorResponse == null || responsePriorResponse.code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                }
                return null;
            }
            if (iCode == 407) {
                i.c(route);
                if (route.proxy().type() == Proxy.Type.HTTP) {
                    return this.client.proxyAuthenticator().authenticate(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iCode == 408) {
                if (!this.client.retryOnConnectionFailure()) {
                    return null;
                }
                RequestBody requestBodyBody2 = response.request().body();
                if (requestBodyBody2 != null && requestBodyBody2.isOneShot()) {
                    return null;
                }
                Response responsePriorResponse2 = response.priorResponse();
                if ((responsePriorResponse2 == null || responsePriorResponse2.code() != 408) && retryAfter(response, 0) <= 0) {
                    return response.request();
                }
                return null;
            }
            switch (iCode) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        return buildRedirectRequest(response, strMethod);
    }

    private final boolean isRecoverable(IOException iOException, boolean z4) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z4 : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final boolean recover(IOException iOException, RealCall realCall, Request request, boolean z4) {
        if (this.client.retryOnConnectionFailure()) {
            return !(z4 && requestIsOneShot(iOException, request)) && isRecoverable(iOException, z4) && realCall.retryAfterFailure();
        }
        return false;
    }

    private final boolean requestIsOneShot(IOException iOException, Request request) {
        RequestBody requestBodyBody = request.body();
        return (requestBodyBody != null && requestBodyBody.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    private final int retryAfter(Response response, int i5) throws NumberFormatException {
        String strHeader$default = Response.header$default(response, "Retry-After", null, 2, null);
        if (strHeader$default == null) {
            return i5;
        }
        Pattern patternCompile = Pattern.compile("\\d+");
        i.e(patternCompile, "compile(pattern)");
        if (!patternCompile.matcher(strHeader$default).matches()) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strHeader$default);
        i.e(numValueOf, "valueOf(header)");
        return numValueOf.intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003e, code lost:
    
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
    
        r0 = r1.getInterceptorScopedExchange$okhttp();
        r6 = followUpRequest(r7, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
    
        if (r6 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
    
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
    
        if (r0.isDuplex$okhttp() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
    
        r1.timeoutEarlyExit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
    
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
    
        r0 = r6.body();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
    
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0066, code lost:
    
        if (r0.isOneShot() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0068, code lost:
    
        r1.exitNetworkInterceptorExchange$okhttp(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006b, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
    
        r0 = r7.body();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
    
        if (r0 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
    
        okhttp3.internal.Util.closeQuietly(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0075, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0079, code lost:
    
        if (r8 > 20) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
    
        throw new java.net.ProtocolException("Too many follow-up requests: " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        if (r7 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
    
        r0 = r0.newBuilder().priorResponse(r7.newBuilder().body(null).build()).build();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.util.ArrayList] */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r12) throws java.io.IOException {
        /*
            r11 = this;
            java.lang.String r0 = "chain"
            F3.i.f(r12, r0)
            okhttp3.internal.http.RealInterceptorChain r12 = (okhttp3.internal.http.RealInterceptorChain) r12
            okhttp3.Request r0 = r12.getRequest$okhttp()
            okhttp3.internal.connection.RealCall r1 = r12.getCall$okhttp()
            t3.q r2 = t3.q.f9711j
            r3 = 0
            r4 = 0
            r5 = 1
            r8 = r3
            r7 = r4
        L16:
            r6 = r5
        L17:
            r1.enterNetworkInterceptorExchange(r0, r6)
            boolean r6 = r1.isCanceled()     // Catch: java.lang.Throwable -> L40
            if (r6 != 0) goto Le6
            okhttp3.Response r0 = r12.proceed(r0)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L97 okhttp3.internal.connection.RouteException -> Lbd
            if (r7 == 0) goto L3e
            okhttp3.Response$Builder r0 = r0.newBuilder()     // Catch: java.lang.Throwable -> L40
            okhttp3.Response$Builder r6 = r7.newBuilder()     // Catch: java.lang.Throwable -> L40
            okhttp3.Response$Builder r6 = r6.body(r4)     // Catch: java.lang.Throwable -> L40
            okhttp3.Response r6 = r6.build()     // Catch: java.lang.Throwable -> L40
            okhttp3.Response$Builder r0 = r0.priorResponse(r6)     // Catch: java.lang.Throwable -> L40
            okhttp3.Response r0 = r0.build()     // Catch: java.lang.Throwable -> L40
        L3e:
            r7 = r0
            goto L43
        L40:
            r12 = move-exception
            goto Lee
        L43:
            okhttp3.internal.connection.Exchange r0 = r1.getInterceptorScopedExchange$okhttp()     // Catch: java.lang.Throwable -> L40
            okhttp3.Request r6 = r11.followUpRequest(r7, r0)     // Catch: java.lang.Throwable -> L40
            if (r6 != 0) goto L5c
            if (r0 == 0) goto L58
            boolean r12 = r0.isDuplex$okhttp()     // Catch: java.lang.Throwable -> L40
            if (r12 == 0) goto L58
            r1.timeoutEarlyExit()     // Catch: java.lang.Throwable -> L40
        L58:
            r1.exitNetworkInterceptorExchange$okhttp(r3)
            return r7
        L5c:
            okhttp3.RequestBody r0 = r6.body()     // Catch: java.lang.Throwable -> L40
            if (r0 == 0) goto L6c
            boolean r0 = r0.isOneShot()     // Catch: java.lang.Throwable -> L40
            if (r0 == 0) goto L6c
            r1.exitNetworkInterceptorExchange$okhttp(r3)
            return r7
        L6c:
            okhttp3.ResponseBody r0 = r7.body()     // Catch: java.lang.Throwable -> L40
            if (r0 == 0) goto L75
            okhttp3.internal.Util.closeQuietly(r0)     // Catch: java.lang.Throwable -> L40
        L75:
            int r8 = r8 + 1
            r0 = 20
            if (r8 > r0) goto L80
            r1.exitNetworkInterceptorExchange$okhttp(r5)
            r0 = r6
            goto L16
        L80:
            java.net.ProtocolException r12 = new java.net.ProtocolException     // Catch: java.lang.Throwable -> L40
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            r0.<init>()     // Catch: java.lang.Throwable -> L40
            java.lang.String r2 = "Too many follow-up requests: "
            r0.append(r2)     // Catch: java.lang.Throwable -> L40
            r0.append(r8)     // Catch: java.lang.Throwable -> L40
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L40
            r12.<init>(r0)     // Catch: java.lang.Throwable -> L40
            throw r12     // Catch: java.lang.Throwable -> L40
        L97:
            r6 = move-exception
            boolean r9 = r6 instanceof okhttp3.internal.http2.ConnectionShutdownException     // Catch: java.lang.Throwable -> L40
            r9 = r9 ^ r5
            boolean r9 = r11.recover(r6, r1, r0, r9)     // Catch: java.lang.Throwable -> L40
            if (r9 == 0) goto Lb8
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L40
            int r10 = r2.size()     // Catch: java.lang.Throwable -> L40
            int r10 = r10 + r5
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L40
            r9.addAll(r2)     // Catch: java.lang.Throwable -> L40
            r9.add(r6)     // Catch: java.lang.Throwable -> L40
        Lb1:
            r1.exitNetworkInterceptorExchange$okhttp(r5)
            r6 = r3
            r2 = r9
            goto L17
        Lb8:
            java.lang.Throwable r12 = okhttp3.internal.Util.withSuppressed(r6, r2)     // Catch: java.lang.Throwable -> L40
            throw r12     // Catch: java.lang.Throwable -> L40
        Lbd:
            r6 = move-exception
            java.io.IOException r9 = r6.getLastConnectException()     // Catch: java.lang.Throwable -> L40
            boolean r9 = r11.recover(r9, r1, r0, r3)     // Catch: java.lang.Throwable -> L40
            if (r9 == 0) goto Ldd
            java.io.IOException r6 = r6.getFirstConnectException()     // Catch: java.lang.Throwable -> L40
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L40
            int r10 = r2.size()     // Catch: java.lang.Throwable -> L40
            int r10 = r10 + r5
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L40
            r9.addAll(r2)     // Catch: java.lang.Throwable -> L40
            r9.add(r6)     // Catch: java.lang.Throwable -> L40
            goto Lb1
        Ldd:
            java.io.IOException r12 = r6.getFirstConnectException()     // Catch: java.lang.Throwable -> L40
            java.lang.Throwable r12 = okhttp3.internal.Util.withSuppressed(r12, r2)     // Catch: java.lang.Throwable -> L40
            throw r12     // Catch: java.lang.Throwable -> L40
        Le6:
            java.io.IOException r12 = new java.io.IOException     // Catch: java.lang.Throwable -> L40
            java.lang.String r0 = "Canceled"
            r12.<init>(r0)     // Catch: java.lang.Throwable -> L40
            throw r12     // Catch: java.lang.Throwable -> L40
        Lee:
            r1.exitNetworkInterceptorExchange$okhttp(r5)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.RetryAndFollowUpInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
