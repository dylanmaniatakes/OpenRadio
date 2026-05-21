package W3;

import g0.AbstractC0535a;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class u implements F {

    /* renamed from: j, reason: collision with root package name */
    public final n f2661j;

    /* renamed from: k, reason: collision with root package name */
    public final Inflater f2662k;

    /* renamed from: l, reason: collision with root package name */
    public int f2663l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2664m;

    public u(z zVar, Inflater inflater) {
        this.f2661j = zVar;
        this.f2662k = inflater;
    }

    public final long a(l lVar, long j5) throws DataFormatException, IOException {
        Inflater inflater = this.f2662k;
        F3.i.f(lVar, "sink");
        if (j5 < 0) {
            throw new IllegalArgumentException(AbstractC0535a.h(j5, "byteCount < 0: ").toString());
        }
        if (!(!this.f2664m)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j5 == 0) {
            return 0L;
        }
        try {
            A aB0 = lVar.b0(1);
            int iMin = (int) Math.min(j5, 8192 - aB0.f2619c);
            boolean zNeedsInput = inflater.needsInput();
            n nVar = this.f2661j;
            if (zNeedsInput && !nVar.y()) {
                A a2 = nVar.b().f2647j;
                F3.i.c(a2);
                int i5 = a2.f2619c;
                int i6 = a2.f2618b;
                int i7 = i5 - i6;
                this.f2663l = i7;
                inflater.setInput(a2.f2617a, i6, i7);
            }
            int iInflate = inflater.inflate(aB0.f2617a, aB0.f2619c, iMin);
            int i8 = this.f2663l;
            if (i8 != 0) {
                int remaining = i8 - inflater.getRemaining();
                this.f2663l -= remaining;
                nVar.i(remaining);
            }
            if (iInflate > 0) {
                aB0.f2619c += iInflate;
                long j6 = iInflate;
                lVar.f2648k += j6;
                return j6;
            }
            if (aB0.f2618b == aB0.f2619c) {
                lVar.f2647j = aB0.a();
                B.a(aB0);
            }
            return 0L;
        } catch (DataFormatException e5) {
            throw new IOException(e5);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f2664m) {
            return;
        }
        this.f2662k.end();
        this.f2664m = true;
        this.f2661j.close();
    }

    @Override // W3.F
    public final long read(l lVar, long j5) throws DataFormatException, IOException {
        F3.i.f(lVar, "sink");
        do {
            long jA = a(lVar, j5);
            if (jA > 0) {
                return jA;
            }
            Inflater inflater = this.f2662k;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.f2661j.y());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // W3.F
    public final I timeout() {
        return this.f2661j.timeout();
    }
}
