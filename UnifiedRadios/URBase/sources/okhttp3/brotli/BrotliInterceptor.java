package okhttp3.brotli;

import F3.i;
import W3.AbstractC0189b;
import W3.C0193f;
import W3.I;
import W3.t;
import W3.v;
import W3.z;
import Y3.b;
import java.util.logging.Logger;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;

/* loaded from: classes.dex */
public final class BrotliInterceptor implements Interceptor {
    public static final BrotliInterceptor INSTANCE = new BrotliInterceptor();

    private BrotliInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        i.f(chain, "chain");
        return chain.request().header("Accept-Encoding") == null ? uncompress$okhttp_brotli(chain.proceed(chain.request().newBuilder().header("Accept-Encoding", "br,gzip").build())) : chain.proceed(chain.request());
    }

    public final Response uncompress$okhttp_brotli(Response response) {
        ResponseBody responseBodyBody;
        String strHeader$default;
        z zVarC;
        i.f(response, "response");
        if (!HttpHeaders.promisesBody(response) || (responseBodyBody = response.body()) == null || (strHeader$default = Response.header$default(response, "Content-Encoding", null, 2, null)) == null) {
            return response;
        }
        if (strHeader$default.equalsIgnoreCase("br")) {
            b bVar = new b(responseBodyBody.source().T());
            Logger logger = v.f2665a;
            zVarC = AbstractC0189b.c(new C0193f(bVar, new I()));
        } else {
            if (!strHeader$default.equalsIgnoreCase("gzip")) {
                return response;
            }
            zVarC = AbstractC0189b.c(new t(responseBodyBody.source()));
        }
        return response.newBuilder().removeHeader("Content-Encoding").removeHeader("Content-Length").body(ResponseBody.Companion.create(zVarC, responseBodyBody.contentType(), -1L)).build();
    }
}
