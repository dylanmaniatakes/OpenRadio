package W3;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: W3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0192e implements D {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f2631j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f2632k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f2633l;

    public /* synthetic */ C0192e(Object obj, int i5, Object obj2) {
        this.f2631j = i5;
        this.f2632k = obj;
        this.f2633l = obj2;
    }

    @Override // W3.D, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f2631j) {
            case 0:
                D d5 = (D) this.f2633l;
                C0194g c0194g = (C0194g) this.f2632k;
                c0194g.enter();
                try {
                    d5.close();
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
                ((OutputStream) this.f2632k).close();
                return;
        }
    }

    @Override // W3.D, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.f2631j) {
            case 0:
                D d5 = (D) this.f2633l;
                C0194g c0194g = (C0194g) this.f2632k;
                c0194g.enter();
                try {
                    d5.flush();
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
                ((OutputStream) this.f2632k).flush();
                return;
        }
    }

    @Override // W3.D
    public final I timeout() {
        switch (this.f2631j) {
            case 0:
                return (C0194g) this.f2632k;
            default:
                return (I) this.f2633l;
        }
    }

    public final String toString() {
        switch (this.f2631j) {
            case 0:
                return "AsyncTimeout.sink(" + ((D) this.f2633l) + ')';
            default:
                return "sink(" + ((OutputStream) this.f2632k) + ')';
        }
    }

    @Override // W3.D
    public final void write(l lVar, long j5) throws IOException {
        switch (this.f2631j) {
            case 0:
                F3.i.f(lVar, "source");
                AbstractC0189b.e(lVar.f2648k, 0L, j5);
                while (true) {
                    long j6 = 0;
                    if (j5 <= 0) {
                        return;
                    }
                    A a2 = lVar.f2647j;
                    F3.i.c(a2);
                    while (true) {
                        if (j6 < 65536) {
                            j6 += a2.f2619c - a2.f2618b;
                            if (j6 >= j5) {
                                j6 = j5;
                            } else {
                                a2 = a2.f2622f;
                                F3.i.c(a2);
                            }
                        }
                    }
                    D d5 = (D) this.f2633l;
                    C0194g c0194g = (C0194g) this.f2632k;
                    c0194g.enter();
                    try {
                        d5.write(lVar, j6);
                        if (c0194g.exit()) {
                            throw c0194g.access$newTimeoutException(null);
                        }
                        j5 -= j6;
                    } catch (IOException e5) {
                        if (!c0194g.exit()) {
                            throw e5;
                        }
                        throw c0194g.access$newTimeoutException(e5);
                    } finally {
                        c0194g.exit();
                    }
                }
            default:
                F3.i.f(lVar, "source");
                AbstractC0189b.e(lVar.f2648k, 0L, j5);
                while (j5 > 0) {
                    ((I) this.f2633l).throwIfReached();
                    A a3 = lVar.f2647j;
                    F3.i.c(a3);
                    int iMin = (int) Math.min(j5, a3.f2619c - a3.f2618b);
                    ((OutputStream) this.f2632k).write(a3.f2617a, a3.f2618b, iMin);
                    int i5 = a3.f2618b + iMin;
                    a3.f2618b = i5;
                    long j7 = iMin;
                    j5 -= j7;
                    lVar.f2648k -= j7;
                    if (i5 == a3.f2619c) {
                        lVar.f2647j = a3.a();
                        B.a(a3);
                    }
                }
                return;
        }
    }
}
