package W3;

import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import m3.C0764B;

/* loaded from: classes.dex */
public final class k extends OutputStream {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f2645j = 0;

    /* renamed from: k, reason: collision with root package name */
    public final Object f2646k;

    public k(C0764B c0764b) {
        this.f2646k = c0764b;
    }

    private final void a() {
    }

    private final void c() {
    }

    private final void o() {
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        switch (this.f2645j) {
            case 0:
                break;
            default:
                super.close();
                break;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        int i5 = this.f2645j;
    }

    public String toString() {
        switch (this.f2645j) {
            case 0:
                return ((l) this.f2646k) + ".outputStream()";
            default:
                return super.toString();
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i5) throws IOException {
        Object obj = this.f2646k;
        switch (this.f2645j) {
            case 0:
                ((l) obj).e0(i5);
                return;
            default:
                try {
                    ((C0764B) obj).h(new byte[]{(byte) i5});
                    return;
                } catch (Exception e5) {
                    Log.e("CustomStreams", "Error writing to serial port", e5);
                    throw new IOException("Error writing to serial port", e5);
                }
        }
    }

    public k(l lVar) {
        this.f2646k = lVar;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        switch (this.f2645j) {
            case 1:
                try {
                    ((C0764B) this.f2646k).h(bArr);
                    return;
                } catch (Exception e5) {
                    Log.e("CustomStreams", "Error writing to serial port", e5);
                    throw new IOException("Error writing to serial port", e5);
                }
            default:
                super.write(bArr);
                return;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i5, int i6) throws IOException {
        switch (this.f2645j) {
            case 0:
                F3.i.f(bArr, "data");
                ((l) this.f2646k).m0write(bArr, i5, i6);
                break;
            default:
                if (i5 == 0 && i6 == bArr.length) {
                    write(bArr);
                    break;
                } else {
                    byte[] bArr2 = new byte[i6];
                    System.arraycopy(bArr, i5, bArr2, 0, i6);
                    write(bArr2);
                    break;
                }
                break;
        }
    }
}
