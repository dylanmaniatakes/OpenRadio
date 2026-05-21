package okhttp3.internal;

import F3.i;
import javax.net.ssl.SSLSocket;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes.dex */
public final class Internal {
    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str) {
        i.f(builder, "builder");
        i.f(str, "line");
        return builder.addLenient$okhttp(str);
    }

    public static final void applyConnectionSpec(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z4) {
        i.f(connectionSpec, "connectionSpec");
        i.f(sSLSocket, "sslSocket");
        connectionSpec.apply$okhttp(sSLSocket, z4);
    }

    public static final Response cacheGet(Cache cache, Request request) {
        i.f(cache, "cache");
        i.f(request, "request");
        return cache.get$okhttp(request);
    }

    public static final String cookieToString(Cookie cookie, boolean z4) {
        i.f(cookie, "cookie");
        return cookie.toString$okhttp(z4);
    }

    public static final Cookie parseCookie(long j5, HttpUrl httpUrl, String str) {
        i.f(httpUrl, "url");
        i.f(str, "setCookie");
        return Cookie.Companion.parse$okhttp(j5, httpUrl, str);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str, String str2) {
        i.f(builder, "builder");
        i.f(str, "name");
        i.f(str2, "value");
        return builder.addLenient$okhttp(str, str2);
    }
}
