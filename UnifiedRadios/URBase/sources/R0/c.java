package R0;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class c extends FilterInputStream {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f2205j = 0;

    /* renamed from: k, reason: collision with root package name */
    public long f2206k;

    /* renamed from: l, reason: collision with root package name */
    public long f2207l;

    public c(InputStream inputStream) {
        super(inputStream);
        this.f2207l = -1L;
        this.f2206k = 1048577L;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        switch (this.f2205j) {
            case 1:
                return (int) Math.min(((FilterInputStream) this).in.available(), this.f2206k);
            default:
                return super.available();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i5) {
        switch (this.f2205j) {
            case 1:
                synchronized (this) {
                    ((FilterInputStream) this).in.mark(i5);
                    this.f2207l = this.f2206k;
                }
                return;
            default:
                super.mark(i5);
                return;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        switch (this.f2205j) {
            case 0:
                int i5 = super.read();
                if (i5 != -1) {
                    this.f2207l++;
                }
                return i5;
            default:
                if (this.f2206k == 0) {
                    return -1;
                }
                int i6 = ((FilterInputStream) this).in.read();
                if (i6 != -1) {
                    this.f2206k--;
                }
                return i6;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        switch (this.f2205j) {
            case 1:
                synchronized (this) {
                    if (!((FilterInputStream) this).in.markSupported()) {
                        throw new IOException("Mark not supported");
                    }
                    if (this.f2207l == -1) {
                        throw new IOException("Mark not set");
                    }
                    ((FilterInputStream) this).in.reset();
                    this.f2206k = this.f2207l;
                }
                return;
            default:
                super.reset();
                return;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j5) throws IOException {
        switch (this.f2205j) {
            case 1:
                long jSkip = ((FilterInputStream) this).in.skip(Math.min(j5, this.f2206k));
                this.f2206k -= jSkip;
                return jSkip;
            default:
                return super.skip(j5);
        }
    }

    public c(BufferedInputStream bufferedInputStream, long j5) {
        super(bufferedInputStream);
        this.f2206k = j5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i5, int i6) throws IOException {
        switch (this.f2205j) {
            case 0:
                int i7 = super.read(bArr, i5, i6);
                if (i7 != -1) {
                    this.f2207l += i7;
                }
                return i7;
            default:
                long j5 = this.f2206k;
                if (j5 == 0) {
                    return -1;
                }
                int i8 = ((FilterInputStream) this).in.read(bArr, i5, (int) Math.min(i6, j5));
                if (i8 != -1) {
                    this.f2206k -= i8;
                }
                return i8;
        }
    }
}
