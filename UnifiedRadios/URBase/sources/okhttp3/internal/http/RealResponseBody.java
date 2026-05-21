package okhttp3.internal.http;

import F3.i;
import W3.n;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* loaded from: classes.dex */
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final n source;

    public RealResponseBody(String str, long j5, n nVar) {
        i.f(nVar, "source");
        this.contentTypeString = str;
        this.contentLength = j5;
        this.source = nVar;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.Companion.parse(str);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    public n source() {
        return this.source;
    }
}
