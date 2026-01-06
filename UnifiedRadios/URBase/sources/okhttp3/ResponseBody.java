package okhttp3;

import F3.f;
import F3.i;
import M3.a;
import W3.l;
import W3.n;
import W3.o;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import g0.AbstractC0535a;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import s3.C0900j;

/* loaded from: classes.dex */
public abstract class ResponseBody implements Closeable {
    public static final Companion Companion = new Companion(null);
    private Reader reader;

    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final n source;

        public BomAwareReader(n nVar, Charset charset) {
            i.f(nVar, "source");
            i.f(charset, "charset");
            this.source = nVar;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            C0900j c0900j;
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
                c0900j = C0900j.f9694a;
            } else {
                c0900j = null;
            }
            if (c0900j == null) {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i5, int i6) throws IOException {
            i.f(cArr, "cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.delegate;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.source.T(), Util.readBomAsCharset(this.source, this.charset));
                this.delegate = inputStreamReader;
            }
            return inputStreamReader.read(cArr, i5, i6);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final ResponseBody create(String str, MediaType mediaType) {
            i.f(str, "<this>");
            Charset charset = a.f1740a;
            if (mediaType != null) {
                Charset charsetCharset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charsetCharset$default == null) {
                    mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charsetCharset$default;
                }
            }
            l lVar = new l();
            i.f(charset, "charset");
            lVar.k0(str, 0, str.length(), charset);
            return create(lVar, mediaType, lVar.f2648k);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, o oVar, MediaType mediaType, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(oVar, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, n nVar, MediaType mediaType, long j5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                mediaType = null;
            }
            if ((i5 & 2) != 0) {
                j5 = -1;
            }
            return companion.create(nVar, mediaType, j5);
        }

        public final ResponseBody create(byte[] bArr, MediaType mediaType) {
            i.f(bArr, "<this>");
            l lVar = new l();
            lVar.d0(bArr);
            return create(lVar, mediaType, bArr.length);
        }

        public final ResponseBody create(o oVar, MediaType mediaType) {
            i.f(oVar, "<this>");
            l lVar = new l();
            lVar.c0(oVar);
            return create(lVar, mediaType, oVar.c());
        }

        public final ResponseBody create(final n nVar, final MediaType mediaType, final long j5) {
            i.f(nVar, "<this>");
            return new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
                @Override // okhttp3.ResponseBody
                public long contentLength() {
                    return j5;
                }

                @Override // okhttp3.ResponseBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.ResponseBody
                public n source() {
                    return nVar;
                }
            };
        }

        public final ResponseBody create(MediaType mediaType, String str) {
            i.f(str, "content");
            return create(str, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, byte[] bArr) {
            i.f(bArr, "content");
            return create(bArr, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, o oVar) {
            i.f(oVar, "content");
            return create(oVar, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, long j5, n nVar) {
            i.f(nVar, "content");
            return create(nVar, mediaType, j5);
        }
    }

    private final Charset charset() {
        Charset charset;
        MediaType mediaTypeContentType = contentType();
        return (mediaTypeContentType == null || (charset = mediaTypeContentType.charset(a.f1740a)) == null) ? a.f1740a : charset;
    }

    private final <T> T consumeSource(E3.l lVar, E3.l lVar2) throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(AbstractC0535a.h(jContentLength, "Cannot buffer entire body for content length: "));
        }
        n nVarSource = source();
        try {
            T t4 = (T) lVar.invoke(nVarSource);
            AbstractC0399v1.b(nVarSource, null);
            int iIntValue = ((Number) lVar2.invoke(t4)).intValue();
            if (jContentLength == -1 || jContentLength == iIntValue) {
                return t4;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iIntValue + ") disagree");
        } finally {
        }
    }

    public static final ResponseBody create(n nVar, MediaType mediaType, long j5) {
        return Companion.create(nVar, mediaType, j5);
    }

    public final InputStream byteStream() {
        return source().T();
    }

    public final o byteString() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(AbstractC0535a.h(jContentLength, "Cannot buffer entire body for content length: "));
        }
        n nVarSource = source();
        try {
            o oVarF = nVarSource.f();
            AbstractC0399v1.b(nVarSource, null);
            int iC = oVarF.c();
            if (jContentLength == -1 || jContentLength == iC) {
                return oVarF;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iC + ") disagree");
        } finally {
        }
    }

    public final byte[] bytes() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(AbstractC0535a.h(jContentLength, "Cannot buffer entire body for content length: "));
        }
        n nVarSource = source();
        try {
            byte[] bArrW = nVarSource.w();
            AbstractC0399v1.b(nVarSource, null);
            int length = bArrW.length;
            if (jContentLength == -1 || jContentLength == length) {
                return bArrW;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + length + ") disagree");
        } finally {
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract n source();

    public final String string() throws IOException {
        n nVarSource = source();
        try {
            String strS = nVarSource.S(Util.readBomAsCharset(nVarSource, charset()));
            AbstractC0399v1.b(nVarSource, null);
            return strS;
        } finally {
        }
    }

    public static final ResponseBody create(o oVar, MediaType mediaType) {
        return Companion.create(oVar, mediaType);
    }

    public static final ResponseBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public static final ResponseBody create(MediaType mediaType, long j5, n nVar) {
        return Companion.create(mediaType, j5, nVar);
    }

    public static final ResponseBody create(MediaType mediaType, o oVar) {
        return Companion.create(mediaType, oVar);
    }

    public static final ResponseBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    public static final ResponseBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    public static final ResponseBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }
}
