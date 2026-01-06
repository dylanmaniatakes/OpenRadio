package okhttp3.internal.http1;

import F3.f;
import F3.i;
import W3.n;
import okhttp3.Headers;

/* loaded from: classes.dex */
public final class HeadersReader {
    public static final Companion Companion = new Companion(null);
    private static final int HEADER_LIMIT = 262144;
    private long headerLimit;
    private final n source;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public HeadersReader(n nVar) {
        i.f(nVar, "source");
        this.source = nVar;
        this.headerLimit = 262144L;
    }

    public final n getSource() {
        return this.source;
    }

    public final Headers readHeaders() {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String line = readLine();
            if (line.length() == 0) {
                return builder.build();
            }
            builder.addLenient$okhttp(line);
        }
    }

    public final String readLine() {
        String strG = this.source.G(this.headerLimit);
        this.headerLimit -= strG.length();
        return strG;
    }
}
