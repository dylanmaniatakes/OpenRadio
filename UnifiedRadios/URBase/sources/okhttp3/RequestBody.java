package okhttp3;

import F3.f;
import F3.i;
import M3.a;
import W3.C0193f;
import W3.I;
import W3.m;
import W3.o;
import W3.v;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Logger;
import okhttp3.internal.Util;

/* loaded from: classes.dex */
public abstract class RequestBody {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr) {
            i.f(bArr, "content");
            return create$default(this, mediaType, bArr, 0, 0, 12, (Object) null);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, o oVar, MediaType mediaType, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(oVar, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr, int i5) {
            i.f(bArr, "content");
            return create$default(this, mediaType, bArr, i5, 0, 8, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i5, int i6, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                mediaType = null;
            }
            if ((i7 & 2) != 0) {
                i5 = 0;
            }
            if ((i7 & 4) != 0) {
                i6 = bArr.length;
            }
            return companion.create(bArr, mediaType, i5, i6);
        }

        public final RequestBody create(byte[] bArr) {
            i.f(bArr, "<this>");
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType) {
            i.f(bArr, "<this>");
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType, int i5) {
            i.f(bArr, "<this>");
            return create$default(this, bArr, mediaType, i5, 0, 4, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i5, int i6, int i7, Object obj) {
            if ((i7 & 4) != 0) {
                i5 = 0;
            }
            if ((i7 & 8) != 0) {
                i6 = bArr.length;
            }
            return companion.create(mediaType, bArr, i5, i6);
        }

        public final RequestBody create(String str, MediaType mediaType) {
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
            byte[] bytes = str.getBytes(charset);
            i.e(bytes, "this as java.lang.String).getBytes(charset)");
            return create(bytes, mediaType, 0, bytes.length);
        }

        public final RequestBody create(final o oVar, final MediaType mediaType) {
            i.f(oVar, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return oVar.c();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(m mVar) {
                    i.f(mVar, "sink");
                    mVar.B(oVar);
                }
            };
        }

        public final RequestBody create(final byte[] bArr, final MediaType mediaType, final int i5, final int i6) {
            i.f(bArr, "<this>");
            Util.checkOffsetAndCount(bArr.length, i5, i6);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return i6;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(m mVar) {
                    i.f(mVar, "sink");
                    mVar.write(bArr, i5, i6);
                }
            };
        }

        public final RequestBody create(final File file, final MediaType mediaType) {
            i.f(file, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(m mVar) {
                    i.f(mVar, "sink");
                    File file2 = file;
                    Logger logger = v.f2665a;
                    i.f(file2, "<this>");
                    C0193f c0193f = new C0193f(new FileInputStream(file2), I.NONE);
                    try {
                        mVar.z(c0193f);
                        AbstractC0399v1.b(c0193f, null);
                    } finally {
                    }
                }
            };
        }

        public final RequestBody create(MediaType mediaType, String str) {
            i.f(str, "content");
            return create(str, mediaType);
        }

        public final RequestBody create(MediaType mediaType, o oVar) {
            i.f(oVar, "content");
            return create(oVar, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr, int i5, int i6) {
            i.f(bArr, "content");
            return create(bArr, mediaType, i5, i6);
        }

        public final RequestBody create(MediaType mediaType, File file) {
            i.f(file, "file");
            return create(file, mediaType);
        }
    }

    public static final RequestBody create(o oVar, MediaType mediaType) {
        return Companion.create(oVar, mediaType);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(m mVar) throws IOException;

    public static final RequestBody create(File file, MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    public static final RequestBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, o oVar) {
        return Companion.create(mediaType, oVar);
    }

    public static final RequestBody create(MediaType mediaType, File file) {
        return Companion.create(mediaType, file);
    }

    public static final RequestBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i5) {
        return Companion.create(mediaType, bArr, i5);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i5, int i6) {
        return Companion.create(mediaType, bArr, i5, i6);
    }

    public static final RequestBody create(byte[] bArr) {
        return Companion.create(bArr);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i5) {
        return Companion.create(bArr, mediaType, i5);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i5, int i6) {
        return Companion.create(bArr, mediaType, i5, i6);
    }
}
