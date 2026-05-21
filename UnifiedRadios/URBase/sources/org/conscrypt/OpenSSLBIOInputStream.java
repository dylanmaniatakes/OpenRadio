package org.conscrypt;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
class OpenSSLBIOInputStream extends FilterInputStream {
    private long ctx;

    public OpenSSLBIOInputStream(InputStream inputStream, boolean z4) {
        super(inputStream);
        this.ctx = NativeCrypto.create_BIO_InputStream(this, z4);
    }

    public long getBioContext() {
        return this.ctx;
    }

    public int gets(byte[] bArr) throws IOException {
        int i5;
        int i6 = 0;
        if (bArr != null && bArr.length != 0) {
            while (i6 < bArr.length && (i5 = read()) != -1) {
                if (i5 != 10) {
                    bArr[i6] = (byte) i5;
                    i6++;
                } else if (i6 != 0) {
                    break;
                }
            }
        }
        return i6;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public void release() {
        NativeCrypto.BIO_free_all(this.ctx);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        if (i5 < 0 || i6 < 0 || i6 > bArr.length - i5) {
            throw new IndexOutOfBoundsException("Invalid bounds");
        }
        int i7 = 0;
        if (i6 == 0) {
            return 0;
        }
        do {
            int i8 = super.read(bArr, i5 + i7, (i6 - i7) - i5);
            if (i8 == -1) {
                break;
            }
            i7 += i8;
        } while (i5 + i7 < i6);
        if (i7 == 0) {
            return -1;
        }
        return i7;
    }
}
