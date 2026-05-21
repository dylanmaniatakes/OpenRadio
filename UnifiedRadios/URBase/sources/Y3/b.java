package Y3;

import com.unified.ur1.SatelliteTracker.h;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.internal.http2.Http2;

/* loaded from: classes.dex */
public final class b extends InputStream {

    /* renamed from: j, reason: collision with root package name */
    public final byte[] f2990j;

    /* renamed from: k, reason: collision with root package name */
    public int f2991k;

    /* renamed from: l, reason: collision with root package name */
    public int f2992l;

    /* renamed from: m, reason: collision with root package name */
    public final f f2993m;

    public b(InputStream inputStream) throws IOException {
        f fVar = new f();
        this.f2993m = fVar;
        if (inputStream == null) {
            throw new IllegalArgumentException("source is null");
        }
        this.f2990j = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
        this.f2991k = 0;
        this.f2992l = 0;
        try {
            f.a(fVar, inputStream);
        } catch (c e5) {
            throw new IOException("Brotli decoder initialization failed", e5);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        f fVar = this.f2993m;
        int i5 = fVar.f3034a;
        if (i5 == 0) {
            throw new IllegalStateException("State MUST be initialized");
        }
        if (i5 == 11) {
            return;
        }
        fVar.f3034a = 11;
        a aVar = fVar.f3036c;
        InputStream inputStream = aVar.f2986d;
        aVar.f2986d = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        int i5 = this.f2992l;
        int i6 = this.f2991k;
        byte[] bArr = this.f2990j;
        if (i5 >= i6) {
            int i7 = read(bArr, 0, bArr.length);
            this.f2991k = i7;
            this.f2992l = 0;
            if (i7 == -1) {
                return -1;
            }
        }
        int i8 = this.f2992l;
        this.f2992l = i8 + 1;
        return bArr[i8] & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i5, int i6) throws IOException {
        f fVar = this.f2993m;
        if (i5 < 0) {
            throw new IllegalArgumentException(h.a(i5, "Bad offset: "));
        }
        if (i6 >= 0) {
            int i7 = i5 + i6;
            if (i7 > bArr.length) {
                StringBuilder sbF = h.f("Buffer overflow: ", i7, " > ");
                sbF.append(bArr.length);
                throw new IllegalArgumentException(sbF.toString());
            }
            if (i6 == 0) {
                return 0;
            }
            int iMax = Math.max(this.f2991k - this.f2992l, 0);
            if (iMax != 0) {
                iMax = Math.min(iMax, i6);
                System.arraycopy(this.f2990j, this.f2992l, bArr, i5, iMax);
                this.f2992l += iMax;
                i5 += iMax;
                i6 -= iMax;
                if (i6 == 0) {
                    return iMax;
                }
            }
            try {
                fVar.f3033Y = bArr;
                fVar.f3028T = i5;
                fVar.f3029U = i6;
                fVar.f3030V = 0;
                d.e(fVar);
                int i8 = fVar.f3030V;
                if (i8 == 0) {
                    return -1;
                }
                return i8 + iMax;
            } catch (c e5) {
                throw new IOException("Brotli stream decoding failed", e5);
            }
        }
        throw new IllegalArgumentException(h.a(i6, "Bad length: "));
    }
}
