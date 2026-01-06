package M2;

import java.io.OutputStream;

/* loaded from: classes.dex */
public final class b extends OutputStream {

    /* renamed from: j, reason: collision with root package name */
    public long f1725j;

    @Override // java.io.OutputStream
    public final void write(int i5) {
        this.f1725j++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f1725j += bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i5, int i6) {
        int i7;
        if (i5 >= 0 && i5 <= bArr.length && i6 >= 0 && (i7 = i5 + i6) <= bArr.length && i7 >= 0) {
            this.f1725j += i6;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
