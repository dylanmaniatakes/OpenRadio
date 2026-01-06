package okhttp3;

import F3.f;
import F3.i;
import W3.l;
import W3.m;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

/* loaded from: classes.dex */
public final class FormBody extends RequestBody {
    private final List<String> encodedNames;
    private final List<String> encodedValues;
    public static final Companion Companion = new Companion(null);
    private static final MediaType CONTENT_TYPE = MediaType.Companion.get("application/x-www-form-urlencoded");

    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final Builder add(String str, String str2) {
            i.f(str, "name");
            i.f(str2, "value");
            List<String> list = this.names;
            HttpUrl.Companion companion = HttpUrl.Companion;
            list.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, null));
            return this;
        }

        public final Builder addEncoded(String str, String str2) {
            i.f(str, "name");
            i.f(str2, "value");
            List<String> list = this.names;
            HttpUrl.Companion companion = HttpUrl.Companion;
            list.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            return this;
        }

        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }

        public Builder(Charset charset) {
            this.charset = charset;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        public /* synthetic */ Builder(Charset charset, int i5, f fVar) {
            this((i5 & 1) != 0 ? null : charset);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public FormBody(List<String> list, List<String> list2) {
        i.f(list, "encodedNames");
        i.f(list2, "encodedValues");
        this.encodedNames = Util.toImmutableList(list);
        this.encodedValues = Util.toImmutableList(list2);
    }

    private final long writeOrCountBytes(m mVar, boolean z4) throws EOFException {
        l lVarB;
        if (z4) {
            lVarB = new l();
        } else {
            i.c(mVar);
            lVarB = mVar.b();
        }
        int size = this.encodedNames.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (i5 > 0) {
                lVarB.e0(38);
            }
            lVarB.m0(this.encodedNames.get(i5));
            lVarB.e0(61);
            lVarB.m0(this.encodedValues.get(i5));
        }
        if (!z4) {
            return 0L;
        }
        long j5 = lVarB.f2648k;
        lVarB.a();
        return j5;
    }

    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m44deprecated_size() {
        return size();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public final String encodedName(int i5) {
        return this.encodedNames.get(i5);
    }

    public final String encodedValue(int i5) {
        return this.encodedValues.get(i5);
    }

    public final String name(int i5) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedName(i5), 0, 0, true, 3, null);
    }

    public final int size() {
        return this.encodedNames.size();
    }

    public final String value(int i5) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedValue(i5), 0, 0, true, 3, null);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(m mVar) throws IOException {
        i.f(mVar, "sink");
        writeOrCountBytes(mVar, false);
    }
}
