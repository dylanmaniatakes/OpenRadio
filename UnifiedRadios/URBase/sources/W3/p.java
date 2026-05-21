package W3;

import java.io.IOException;
import java.util.zip.Deflater;

/* loaded from: classes.dex */
public final class p implements D {

    /* renamed from: j, reason: collision with root package name */
    public final m f2653j;

    /* renamed from: k, reason: collision with root package name */
    public final Deflater f2654k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2655l;

    public p(l lVar, Deflater deflater) {
        this.f2653j = AbstractC0189b.b(lVar);
        this.f2654k = deflater;
    }

    public final void a(boolean z4) throws IOException {
        A aB0;
        int iDeflate;
        m mVar = this.f2653j;
        l lVarB = mVar.b();
        while (true) {
            aB0 = lVarB.b0(1);
            Deflater deflater = this.f2654k;
            byte[] bArr = aB0.f2617a;
            if (z4) {
                try {
                    int i5 = aB0.f2619c;
                    iDeflate = deflater.deflate(bArr, i5, 8192 - i5, 2);
                } catch (NullPointerException e5) {
                    throw new IOException("Deflater already closed", e5);
                }
            } else {
                int i6 = aB0.f2619c;
                iDeflate = deflater.deflate(bArr, i6, 8192 - i6);
            }
            if (iDeflate > 0) {
                aB0.f2619c += iDeflate;
                lVarB.f2648k += iDeflate;
                mVar.E();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (aB0.f2618b == aB0.f2619c) {
            lVarB.f2647j = aB0.a();
            B.a(aB0);
        }
    }

    @Override // W3.D, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        Deflater deflater = this.f2654k;
        if (this.f2655l) {
            return;
        }
        try {
            deflater.finish();
            a(false);
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f2653j.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f2655l = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // W3.D, java.io.Flushable
    public final void flush() throws IOException {
        a(true);
        this.f2653j.flush();
    }

    @Override // W3.D
    public final I timeout() {
        return this.f2653j.timeout();
    }

    public final String toString() {
        return "DeflaterSink(" + this.f2653j + ')';
    }

    @Override // W3.D
    public final void write(l lVar, long j5) throws IOException {
        F3.i.f(lVar, "source");
        AbstractC0189b.e(lVar.f2648k, 0L, j5);
        while (j5 > 0) {
            A a2 = lVar.f2647j;
            F3.i.c(a2);
            int iMin = (int) Math.min(j5, a2.f2619c - a2.f2618b);
            this.f2654k.setInput(a2.f2617a, a2.f2618b, iMin);
            a(false);
            long j6 = iMin;
            lVar.f2648k -= j6;
            int i5 = a2.f2618b + iMin;
            a2.f2618b = i5;
            if (i5 == a2.f2619c) {
                lVar.f2647j = a2.a();
                B.a(a2);
            }
            j5 -= j6;
        }
    }
}
