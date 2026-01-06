package okhttp3;

import F3.i;
import W3.o;
import com.unified.ur1.SatelliteTracker.h;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    public static final String basic(String str, String str2) {
        i.f(str, "username");
        i.f(str2, "password");
        return basic$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset charset, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            charset = StandardCharsets.ISO_8859_1;
            i.e(charset, "ISO_8859_1");
        }
        return basic(str, str2, charset);
    }

    public static final String basic(String str, String str2, Charset charset) {
        i.f(str, "username");
        i.f(str2, "password");
        i.f(charset, "charset");
        String str3 = str + ':' + str2;
        o oVar = o.f2649m;
        i.f(str3, "<this>");
        byte[] bytes = str3.getBytes(charset);
        i.e(bytes, "this as java.lang.String).getBytes(charset)");
        return h.s("Basic ", new o(bytes).a());
    }
}
