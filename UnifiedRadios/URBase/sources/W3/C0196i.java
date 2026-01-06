package W3;

import g0.AbstractC0535a;
import java.io.Closeable;
import java.util.Arrays;

/* renamed from: W3.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0196i implements Closeable {

    /* renamed from: j, reason: collision with root package name */
    public l f2637j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2638k;

    /* renamed from: l, reason: collision with root package name */
    public A f2639l;
    public byte[] n;

    /* renamed from: m, reason: collision with root package name */
    public long f2640m = -1;

    /* renamed from: o, reason: collision with root package name */
    public int f2641o = -1;

    /* renamed from: p, reason: collision with root package name */
    public int f2642p = -1;

    public final void a(long j5) {
        l lVar = this.f2637j;
        if (lVar == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        if (!this.f2638k) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        }
        long j6 = lVar.f2648k;
        if (j5 <= j6) {
            if (j5 < 0) {
                throw new IllegalArgumentException(AbstractC0535a.h(j5, "newSize < 0: ").toString());
            }
            long j7 = j6 - j5;
            while (true) {
                if (j7 <= 0) {
                    break;
                }
                A a2 = lVar.f2647j;
                F3.i.c(a2);
                A a3 = a2.g;
                F3.i.c(a3);
                int i5 = a3.f2619c;
                long j8 = i5 - a3.f2618b;
                if (j8 > j7) {
                    a3.f2619c = i5 - ((int) j7);
                    break;
                } else {
                    lVar.f2647j = a3.a();
                    B.a(a3);
                    j7 -= j8;
                }
            }
            this.f2639l = null;
            this.f2640m = j5;
            this.n = null;
            this.f2641o = -1;
            this.f2642p = -1;
        } else if (j5 > j6) {
            long j9 = j5 - j6;
            int i6 = 1;
            boolean z4 = true;
            for (long j10 = 0; j9 > j10; j10 = 0) {
                A aB0 = lVar.b0(i6);
                int iMin = (int) Math.min(j9, 8192 - aB0.f2619c);
                int i7 = aB0.f2619c + iMin;
                aB0.f2619c = i7;
                j9 -= iMin;
                if (z4) {
                    this.f2639l = aB0;
                    this.f2640m = j6;
                    this.n = aB0.f2617a;
                    this.f2641o = i7 - iMin;
                    this.f2642p = i7;
                    z4 = false;
                }
                i6 = 1;
            }
        }
        lVar.f2648k = j5;
    }

    public final int c(long j5) {
        l lVar = this.f2637j;
        if (lVar == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        if (j5 >= -1) {
            long j6 = lVar.f2648k;
            if (j5 <= j6) {
                if (j5 == -1 || j5 == j6) {
                    this.f2639l = null;
                    this.f2640m = j5;
                    this.n = null;
                    this.f2641o = -1;
                    this.f2642p = -1;
                    return -1;
                }
                A a2 = lVar.f2647j;
                A a3 = this.f2639l;
                long j7 = 0;
                if (a3 != null) {
                    long j8 = this.f2640m - (this.f2641o - a3.f2618b);
                    if (j8 > j5) {
                        j6 = j8;
                        a3 = a2;
                        a2 = a3;
                    } else {
                        j7 = j8;
                    }
                } else {
                    a3 = a2;
                }
                if (j6 - j5 > j5 - j7) {
                    while (true) {
                        F3.i.c(a3);
                        long j9 = (a3.f2619c - a3.f2618b) + j7;
                        if (j5 < j9) {
                            break;
                        }
                        a3 = a3.f2622f;
                        j7 = j9;
                    }
                } else {
                    while (j6 > j5) {
                        F3.i.c(a2);
                        a2 = a2.g;
                        F3.i.c(a2);
                        j6 -= a2.f2619c - a2.f2618b;
                    }
                    a3 = a2;
                    j7 = j6;
                }
                if (this.f2638k) {
                    F3.i.c(a3);
                    if (a3.f2620d) {
                        byte[] bArr = a3.f2617a;
                        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                        F3.i.e(bArrCopyOf, "copyOf(this, size)");
                        A a4 = new A(bArrCopyOf, a3.f2618b, a3.f2619c, false, true);
                        if (lVar.f2647j == a3) {
                            lVar.f2647j = a4;
                        }
                        a3.b(a4);
                        A a5 = a4.g;
                        F3.i.c(a5);
                        a5.a();
                        a3 = a4;
                    }
                }
                this.f2639l = a3;
                this.f2640m = j5;
                F3.i.c(a3);
                this.n = a3.f2617a;
                int i5 = a3.f2618b + ((int) (j5 - j7));
                this.f2641o = i5;
                int i6 = a3.f2619c;
                this.f2642p = i6;
                return i6 - i5;
            }
        }
        throw new ArrayIndexOutOfBoundsException("offset=" + j5 + " > size=" + lVar.f2648k);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f2637j == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
        this.f2637j = null;
        this.f2639l = null;
        this.f2640m = -1L;
        this.n = null;
        this.f2641o = -1;
        this.f2642p = -1;
    }
}
