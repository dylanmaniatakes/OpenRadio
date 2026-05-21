package okhttp3.internal.cache;

import W3.D;
import java.io.IOException;

/* loaded from: classes.dex */
public interface CacheRequest {
    void abort();

    D body() throws IOException;
}
