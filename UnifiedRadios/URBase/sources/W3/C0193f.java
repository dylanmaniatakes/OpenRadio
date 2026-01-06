package W3;

import g0.AbstractC0535a;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: W3.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0193f implements F {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f2634j = 0;

    /* renamed from: k, reason: collision with root package name */
    public final Object f2635k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f2636l;

    public C0193f(InputStream inputStream, I i5) {
        F3.i.f(i5, "timeout");
        this.f2635k = inputStream;
        this.f2636l = i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f2634j) {
            case 0:
                F f5 = (F) this.f2636l;
                C0194g c0194g = (C0194g) this.f2635k;
                c0194g.enter();
                try {
                    f5.close();
                    if (c0194g.exit()) {
                        throw c0194g.access$newTimeoutException(null);
                    }
                    return;
                } catch (IOException e5) {
                    if (!c0194g.exit()) {
                        throw e5;
                    }
                    throw c0194g.access$newTimeoutException(e5);
                } finally {
                    c0194g.exit();
                }
            default:
                ((InputStream) this.f2635k).close();
                return;
        }
    }

    @Override // W3.F
    public final long read(l lVar, long j5) throws IOException {
        switch (this.f2634j) {
            case 0:
                F3.i.f(lVar, "sink");
                F f5 = (F) this.f2636l;
                C0194g c0194g = (C0194g) this.f2635k;
                c0194g.enter();
                try {
                    long j6 = f5.read(lVar, j5);
                    if (c0194g.exit()) {
                        throw c0194g.access$newTimeoutException(null);
                    }
                    return j6;
                } catch (IOException e5) {
                    if (c0194g.exit()) {
                        throw c0194g.access$newTimeoutException(e5);
                    }
                    throw e5;
                } finally {
                    c0194g.exit();
                }
            default:
                F3.i.f(lVar, "sink");
                if (j5 == 0) {
                    return 0L;
                }
                if (j5 < 0) {
                    throw new IllegalArgumentException(AbstractC0535a.h(j5, "byteCount < 0: ").toString());
                }
                try {
                    ((I) this.f2636l).throwIfReached();
                    A aB0 = lVar.b0(1);
                    int i5 = ((InputStream) this.f2635k).read(aB0.f2617a, aB0.f2619c, (int) Math.min(j5, 8192 - aB0.f2619c));
                    if (i5 == -1) {
                        if (aB0.f2618b == aB0.f2619c) {
                            lVar.f2647j = aB0.a();
                            B.a(aB0);
                        }
                        return -1L;
                    }
                    aB0.f2619c += i5;
                    long j7 = i5;
                    lVar.f2648k += j7;
                    return j7;
                } catch (AssertionError e6) {
                    if (AbstractC0189b.f(e6)) {
                        throw new IOException(e6);
                    }
                    throw e6;
                }
        }
    }

    @Override // W3.F
    public final I timeout() {
        switch (this.f2634j) {
            case 0:
                return (C0194g) this.f2635k;
            default:
                return (I) this.f2636l;
        }
    }

    public final String toString() {
        switch (this.f2634j) {
            case 0:
                return "AsyncTimeout.source(" + ((F) this.f2636l) + ')';
            default:
                return "source(" + ((InputStream) this.f2635k) + ')';
        }
    }

    public C0193f(C0194g c0194g, F f5) {
        this.f2635k = c0194g;
        this.f2636l = f5;
    }
}
