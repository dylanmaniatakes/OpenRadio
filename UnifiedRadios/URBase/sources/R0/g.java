package R0;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.conscrypt.PSKKeyManager;

/* loaded from: classes.dex */
public final class g extends ByteArrayOutputStream {

    /* renamed from: j, reason: collision with root package name */
    public final a f2228j;

    public g(a aVar, int i5) {
        this.f2228j = aVar;
        ((ByteArrayOutputStream) this).buf = aVar.a(Math.max(i5, PSKKeyManager.MAX_KEY_LENGTH_BYTES));
    }

    public final void a(int i5) {
        int i6 = ((ByteArrayOutputStream) this).count;
        if (i6 + i5 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        int i7 = (i6 + i5) * 2;
        a aVar = this.f2228j;
        byte[] bArrA = aVar.a(i7);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArrA, 0, ((ByteArrayOutputStream) this).count);
        aVar.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = bArrA;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f2228j.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public final void finalize() {
        this.f2228j.b(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i5, int i6) {
        a(i6);
        super.write(bArr, i5, i6);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i5) {
        a(1);
        super.write(i5);
    }
}
