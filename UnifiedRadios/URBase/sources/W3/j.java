package W3;

import android.util.Log;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.io.IOException;
import java.io.InputStream;
import m3.C0764B;

/* loaded from: classes.dex */
public final class j extends InputStream {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f2643j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f2644k;

    public /* synthetic */ j(n nVar, int i5) {
        this.f2643j = i5;
        this.f2644k = nVar;
    }

    private final void a() {
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        switch (this.f2643j) {
            case 0:
                return (int) Math.min(((l) this.f2644k).f2648k, Integer.MAX_VALUE);
            case 1:
                z zVar = (z) this.f2644k;
                if (zVar.f2678l) {
                    throw new IOException("closed");
                }
                return (int) Math.min(zVar.f2677k.f2648k, Integer.MAX_VALUE);
            default:
                return ((C0764B) this.f2644k).a();
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        switch (this.f2643j) {
            case 0:
                break;
            case 1:
                ((z) this.f2644k).close();
                break;
            default:
                super.close();
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws InterruptedException, IOException {
        switch (this.f2643j) {
            case 0:
                l lVar = (l) this.f2644k;
                if (lVar.f2648k > 0) {
                    return lVar.U() & 255;
                }
                return -1;
            case 1:
                z zVar = (z) this.f2644k;
                if (zVar.f2678l) {
                    throw new IOException("closed");
                }
                l lVar2 = zVar.f2677k;
                if (lVar2.f2648k == 0 && zVar.f2676j.read(lVar2, 8192L) == -1) {
                    return -1;
                }
                return zVar.f2677k.U() & 255;
            default:
                C0764B c0764b = (C0764B) this.f2644k;
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis() + DeviceOrientationRequest.OUTPUT_PERIOD_FAST;
                    while (c0764b.a() <= 0) {
                        if (System.currentTimeMillis() > jCurrentTimeMillis) {
                            return -1;
                        }
                        try {
                            Thread.sleep(10L);
                        } catch (InterruptedException e5) {
                            throw new IOException("Read interrupted", e5);
                        }
                    }
                    byte[] bArrG = c0764b.g(1);
                    if (bArrG.length > 0) {
                        return bArrG[0] & 255;
                    }
                    return -1;
                } catch (Exception e6) {
                    Log.e("CustomStreams", "Error reading from serial port", e6);
                    throw new IOException("Error reading from serial port", e6);
                }
        }
    }

    public String toString() {
        switch (this.f2643j) {
            case 0:
                return ((l) this.f2644k) + ".inputStream()";
            case 1:
                return ((z) this.f2644k) + ".inputStream()";
            default:
                return super.toString();
        }
    }

    public j(C0764B c0764b) {
        this.f2643j = 2;
        this.f2644k = c0764b;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        switch (this.f2643j) {
            case 0:
                F3.i.f(bArr, "sink");
                return ((l) this.f2644k).read(bArr, i5, i6);
            case 1:
                F3.i.f(bArr, "data");
                z zVar = (z) this.f2644k;
                if (!zVar.f2678l) {
                    AbstractC0189b.e(bArr.length, i5, i6);
                    l lVar = zVar.f2677k;
                    if (lVar.f2648k == 0 && zVar.f2676j.read(lVar, 8192L) == -1) {
                        return -1;
                    }
                    return zVar.f2677k.read(bArr, i5, i6);
                }
                throw new IOException("closed");
            default:
                return super.read(bArr, i5, i6);
        }
    }
}
