package okhttp3;

import F3.f;
import F3.i;
import J1.C;
import W3.l;
import W3.m;
import W3.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;

/* loaded from: classes.dex */
public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE;
    private static final byte[] COLONSPACE;
    private static final byte[] CRLF;
    public static final Companion Companion = new Companion(null);
    private static final byte[] DASHDASH;
    public static final MediaType DIGEST;
    public static final MediaType FORM;
    public static final MediaType MIXED;
    public static final MediaType PARALLEL;
    private final o boundaryByteString;
    private long contentLength;
    private final MediaType contentType;
    private final List<Part> parts;
    private final MediaType type;

    public static final class Builder {
        private final o boundary;
        private final List<Part> parts;
        private MediaType type;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final Builder addFormDataPart(String str, String str2) {
            i.f(str, "name");
            i.f(str2, "value");
            addPart(Part.Companion.createFormData(str, str2));
            return this;
        }

        public final Builder addPart(RequestBody requestBody) {
            i.f(requestBody, "body");
            addPart(Part.Companion.create(requestBody));
            return this;
        }

        public final MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        public final Builder setType(MediaType mediaType) {
            i.f(mediaType, "type");
            if (i.a(mediaType.type(), "multipart")) {
                this.type = mediaType;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + mediaType).toString());
        }

        public Builder(String str) {
            i.f(str, "boundary");
            o oVar = o.f2649m;
            this.boundary = C.i(str);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        public final Builder addFormDataPart(String str, String str2, RequestBody requestBody) {
            i.f(str, "name");
            i.f(requestBody, "body");
            addPart(Part.Companion.createFormData(str, str2, requestBody));
            return this;
        }

        public final Builder addPart(Headers headers, RequestBody requestBody) {
            i.f(requestBody, "body");
            addPart(Part.Companion.create(headers, requestBody));
            return this;
        }

        public final Builder addPart(Part part) {
            i.f(part, "part");
            this.parts.add(part);
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Builder(String str, int i5, f fVar) {
            if ((i5 & 1) != 0) {
                str = UUID.randomUUID().toString();
                i.e(str, "randomUUID().toString()");
            }
            this(str);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public final void appendQuotedString$okhttp(StringBuilder sb, String str) {
            i.f(sb, "<this>");
            i.f(str, "key");
            sb.append('\"');
            int length = str.length();
            for (int i5 = 0; i5 < length; i5++) {
                char cCharAt = str.charAt(i5);
                if (cCharAt == '\n') {
                    sb.append("%0A");
                } else if (cCharAt == '\r') {
                    sb.append("%0D");
                } else if (cCharAt == '\"') {
                    sb.append("%22");
                } else {
                    sb.append(cCharAt);
                }
            }
            sb.append('\"');
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public static final class Part {
        public static final Companion Companion = new Companion(null);
        private final RequestBody body;
        private final Headers headers;

        public static final class Companion {
            private Companion() {
            }

            public final Part create(RequestBody requestBody) {
                i.f(requestBody, "body");
                return create(null, requestBody);
            }

            public final Part createFormData(String str, String str2) {
                i.f(str, "name");
                i.f(str2, "value");
                return createFormData(str, null, RequestBody.Companion.create$default(RequestBody.Companion, str2, (MediaType) null, 1, (Object) null));
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }

            public final Part create(Headers headers, RequestBody requestBody) {
                i.f(requestBody, "body");
                f fVar = null;
                if ((headers != null ? headers.get("Content-Type") : null) != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
                }
                if ((headers != null ? headers.get("Content-Length") : null) == null) {
                    return new Part(headers, requestBody, fVar);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
            }

            public final Part createFormData(String str, String str2, RequestBody requestBody) {
                i.f(str, "name");
                i.f(requestBody, "body");
                StringBuilder sb = new StringBuilder();
                sb.append("form-data; name=");
                Companion companion = MultipartBody.Companion;
                companion.appendQuotedString$okhttp(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    companion.appendQuotedString$okhttp(sb, str2);
                }
                String string = sb.toString();
                i.e(string, "StringBuilder().apply(builderAction).toString()");
                return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", string).build(), requestBody);
            }
        }

        public /* synthetic */ Part(Headers headers, RequestBody requestBody, f fVar) {
            this(headers, requestBody);
        }

        public static final Part create(Headers headers, RequestBody requestBody) {
            return Companion.create(headers, requestBody);
        }

        public static final Part createFormData(String str, String str2) {
            return Companion.createFormData(str, str2);
        }

        /* renamed from: -deprecated_body, reason: not valid java name */
        public final RequestBody m86deprecated_body() {
            return this.body;
        }

        /* renamed from: -deprecated_headers, reason: not valid java name */
        public final Headers m87deprecated_headers() {
            return this.headers;
        }

        public final RequestBody body() {
            return this.body;
        }

        public final Headers headers() {
            return this.headers;
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        public static final Part create(RequestBody requestBody) {
            return Companion.create(requestBody);
        }

        public static final Part createFormData(String str, String str2, RequestBody requestBody) {
            return Companion.createFormData(str, str2, requestBody);
        }
    }

    static {
        MediaType.Companion companion = MediaType.Companion;
        MIXED = companion.get("multipart/mixed");
        ALTERNATIVE = companion.get("multipart/alternative");
        DIGEST = companion.get("multipart/digest");
        PARALLEL = companion.get("multipart/parallel");
        FORM = companion.get("multipart/form-data");
        COLONSPACE = new byte[]{58, 32};
        CRLF = new byte[]{13, 10};
        DASHDASH = new byte[]{45, 45};
    }

    public MultipartBody(o oVar, MediaType mediaType, List<Part> list) {
        i.f(oVar, "boundaryByteString");
        i.f(mediaType, "type");
        i.f(list, "parts");
        this.boundaryByteString = oVar;
        this.type = mediaType;
        this.parts = list;
        this.contentType = MediaType.Companion.get(mediaType + "; boundary=" + boundary());
        this.contentLength = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long writeOrCountBytes(m mVar, boolean z4) throws IOException {
        l lVar;
        if (z4) {
            mVar = new l();
            lVar = mVar;
        } else {
            lVar = 0;
        }
        int size = this.parts.size();
        long j5 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Part part = this.parts.get(i5);
            Headers headers = part.headers();
            RequestBody requestBodyBody = part.body();
            i.c(mVar);
            mVar.C(DASHDASH);
            mVar.B(this.boundaryByteString);
            mVar.C(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    mVar.O(headers.name(i6)).C(COLONSPACE).O(headers.value(i6)).C(CRLF);
                }
            }
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                mVar.O("Content-Type: ").O(mediaTypeContentType.toString()).C(CRLF);
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength != -1) {
                mVar.O("Content-Length: ").P(jContentLength).C(CRLF);
            } else if (z4) {
                i.c(lVar);
                lVar.a();
                return -1L;
            }
            byte[] bArr = CRLF;
            mVar.C(bArr);
            if (z4) {
                j5 += jContentLength;
            } else {
                requestBodyBody.writeTo(mVar);
            }
            mVar.C(bArr);
        }
        i.c(mVar);
        byte[] bArr2 = DASHDASH;
        mVar.C(bArr2);
        mVar.B(this.boundaryByteString);
        mVar.C(bArr2);
        mVar.C(CRLF);
        if (!z4) {
            return j5;
        }
        i.c(lVar);
        long j6 = j5 + lVar.f2648k;
        lVar.a();
        return j6;
    }

    /* renamed from: -deprecated_boundary, reason: not valid java name */
    public final String m82deprecated_boundary() {
        return boundary();
    }

    /* renamed from: -deprecated_parts, reason: not valid java name */
    public final List<Part> m83deprecated_parts() {
        return this.parts;
    }

    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m84deprecated_size() {
        return size();
    }

    /* renamed from: -deprecated_type, reason: not valid java name */
    public final MediaType m85deprecated_type() {
        return this.type;
    }

    public final String boundary() {
        return this.boundaryByteString.j();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        long j5 = this.contentLength;
        if (j5 != -1) {
            return j5;
        }
        long jWriteOrCountBytes = writeOrCountBytes(null, true);
        this.contentLength = jWriteOrCountBytes;
        return jWriteOrCountBytes;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.contentType;
    }

    public final Part part(int i5) {
        return this.parts.get(i5);
    }

    public final List<Part> parts() {
        return this.parts;
    }

    public final int size() {
        return this.parts.size();
    }

    public final MediaType type() {
        return this.type;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(m mVar) throws IOException {
        i.f(mVar, "sink");
        writeOrCountBytes(mVar, false);
    }
}
