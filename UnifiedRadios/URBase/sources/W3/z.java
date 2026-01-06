package W3;

import g0.AbstractC0535a;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class z implements n {

    /* renamed from: j, reason: collision with root package name */
    public final F f2676j;

    /* renamed from: k, reason: collision with root package name */
    public final l f2677k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2678l;

    public z(F f5) {
        F3.i.f(f5, "source");
        this.f2676j = f5;
        this.f2677k = new l();
    }

    @Override // W3.n
    public final long F() throws EOFException {
        l lVar;
        byte bX;
        N(1L);
        long j5 = 0;
        while (true) {
            long j6 = j5 + 1;
            boolean zL = l(j6);
            lVar = this.f2677k;
            if (!zL) {
                break;
            }
            bX = lVar.x(j5);
            if ((bX < 48 || bX > 57) && !(j5 == 0 && bX == 45)) {
                break;
            }
            j5 = j6;
        }
        if (j5 == 0) {
            h4.c.b(16);
            h4.c.b(16);
            String string = Integer.toString(bX, 16);
            F3.i.e(string, "toString(this, checkRadix(radix))");
            throw new NumberFormatException("Expected a digit or '-' but was 0x".concat(string));
        }
        return lVar.F();
    }

    @Override // W3.n
    public final String G(long j5) throws EOFException {
        if (j5 < 0) {
            throw new IllegalArgumentException(AbstractC0535a.h(j5, "limit < 0: ").toString());
        }
        long j6 = j5 == Long.MAX_VALUE ? Long.MAX_VALUE : j5 + 1;
        long jA = a((byte) 10, 0L, j6);
        l lVar = this.f2677k;
        if (jA != -1) {
            return X3.a.b(lVar, jA);
        }
        if (j6 < Long.MAX_VALUE && l(j6) && lVar.x(j6 - 1) == 13 && l(1 + j6) && lVar.x(j6) == 10) {
            return X3.a.b(lVar, j6);
        }
        l lVar2 = new l();
        lVar.s(0L, lVar2, Math.min(32, lVar.f2648k));
        throw new EOFException("\\n not found: limit=" + Math.min(lVar.f2648k, j5) + " content=" + lVar2.g(lVar2.f2648k).d() + (char) 8230);
    }

    @Override // W3.n
    public final void H(l lVar, long j5) throws EOFException {
        l lVar2 = this.f2677k;
        F3.i.f(lVar, "sink");
        try {
            N(j5);
            lVar2.H(lVar, j5);
        } catch (EOFException e5) {
            lVar.z(lVar2);
            throw e5;
        }
    }

    @Override // W3.n
    public final boolean J(long j5, o oVar) {
        F3.i.f(oVar, "bytes");
        int iC = oVar.c();
        if (!(!this.f2678l)) {
            throw new IllegalStateException("closed".toString());
        }
        if (iC >= 0 && oVar.c() >= iC) {
            for (int i5 = 0; i5 < iC; i5++) {
                long j6 = i5;
                if (l(1 + j6) && this.f2677k.x(j6) == oVar.f(i5)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // W3.n
    public final short K() throws EOFException {
        N(2L);
        return this.f2677k.K();
    }

    @Override // W3.n
    public final z L() {
        return AbstractC0189b.c(new x(this));
    }

    @Override // W3.n
    public final void N(long j5) throws EOFException {
        if (!l(j5)) {
            throw new EOFException();
        }
    }

    @Override // W3.n
    public final long R() throws EOFException {
        l lVar;
        byte bX;
        N(1L);
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            boolean zL = l(i6);
            lVar = this.f2677k;
            if (!zL) {
                break;
            }
            bX = lVar.x(i5);
            if ((bX < 48 || bX > 57) && ((bX < 97 || bX > 102) && (bX < 65 || bX > 70))) {
                break;
            }
            i5 = i6;
        }
        if (i5 == 0) {
            h4.c.b(16);
            h4.c.b(16);
            String string = Integer.toString(bX, 16);
            F3.i.e(string, "toString(this, checkRadix(radix))");
            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
        }
        return lVar.R();
    }

    @Override // W3.n
    public final String S(Charset charset) {
        F3.i.f(charset, "charset");
        F f5 = this.f2676j;
        l lVar = this.f2677k;
        lVar.z(f5);
        return lVar.S(charset);
    }

    @Override // W3.n
    public final InputStream T() {
        return new j(this, 1);
    }

    @Override // W3.n
    public final byte U() throws EOFException {
        N(1L);
        return this.f2677k.U();
    }

    public final long a(byte b5, long j5, long j6) {
        if (!(!this.f2678l)) {
            throw new IllegalStateException("closed".toString());
        }
        long jMax = 0;
        if (0 > j6) {
            throw new IllegalArgumentException(AbstractC0535a.h(j6, "fromIndex=0 toIndex=").toString());
        }
        while (jMax < j6) {
            long jD = this.f2677k.D(b5, jMax, j6);
            if (jD != -1) {
                return jD;
            }
            l lVar = this.f2677k;
            long j7 = lVar.f2648k;
            if (j7 >= j6 || this.f2676j.read(lVar, 8192L) == -1) {
                return -1L;
            }
            jMax = Math.max(jMax, j7);
        }
        return -1L;
    }

    @Override // W3.n, W3.m
    public final l b() {
        return this.f2677k;
    }

    public final int c() throws EOFException {
        N(4L);
        int iM = this.f2677k.m();
        return ((iM & 255) << 24) | (((-16777216) & iM) >>> 24) | ((16711680 & iM) >>> 8) | ((65280 & iM) << 8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.f2678l) {
            return;
        }
        this.f2678l = true;
        this.f2676j.close();
        this.f2677k.a();
    }

    @Override // W3.n
    public final void d(byte[] bArr) throws EOFException {
        l lVar = this.f2677k;
        F3.i.f(bArr, "sink");
        try {
            N(bArr.length);
            lVar.d(bArr);
        } catch (EOFException e5) {
            int i5 = 0;
            while (true) {
                long j5 = lVar.f2648k;
                if (j5 <= 0) {
                    throw e5;
                }
                int i6 = lVar.read(bArr, i5, (int) j5);
                if (i6 == -1) {
                    throw new AssertionError();
                }
                i5 += i6;
            }
        }
    }

    @Override // W3.n
    public final o f() {
        F f5 = this.f2676j;
        l lVar = this.f2677k;
        lVar.z(f5);
        return lVar.g(lVar.f2648k);
    }

    @Override // W3.n
    public final o g(long j5) throws EOFException {
        N(j5);
        return this.f2677k.g(j5);
    }

    @Override // W3.n
    public final void i(long j5) throws EOFException {
        if (!(!this.f2678l)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j5 > 0) {
            l lVar = this.f2677k;
            if (lVar.f2648k == 0 && this.f2676j.read(lVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j5, lVar.f2648k);
            lVar.i(jMin);
            j5 -= jMin;
        }
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f2678l;
    }

    @Override // W3.n
    public final boolean l(long j5) {
        l lVar;
        if (j5 < 0) {
            throw new IllegalArgumentException(AbstractC0535a.h(j5, "byteCount < 0: ").toString());
        }
        if (!(!this.f2678l)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            lVar = this.f2677k;
            if (lVar.f2648k >= j5) {
                return true;
            }
        } while (this.f2676j.read(lVar, 8192L) != -1);
        return false;
    }

    @Override // W3.n
    public final int m() throws EOFException {
        N(4L);
        return this.f2677k.m();
    }

    @Override // W3.n
    public final long p(l lVar) {
        l lVar2;
        long j5 = 0;
        while (true) {
            F f5 = this.f2676j;
            lVar2 = this.f2677k;
            if (f5.read(lVar2, 8192L) == -1) {
                break;
            }
            long jO = lVar2.o();
            if (jO > 0) {
                j5 += jO;
                lVar.write(lVar2, jO);
            }
        }
        long j6 = lVar2.f2648k;
        if (j6 <= 0) {
            return j5;
        }
        long j7 = j5 + j6;
        lVar.write(lVar2, j6);
        return j7;
    }

    @Override // W3.n
    public final long q() throws EOFException {
        N(8L);
        return this.f2677k.q();
    }

    @Override // W3.n
    public final int r(w wVar) throws EOFException {
        F3.i.f(wVar, "options");
        if (!(!this.f2678l)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            l lVar = this.f2677k;
            int iC = X3.a.c(lVar, wVar, true);
            if (iC != -2) {
                if (iC != -1) {
                    lVar.i(wVar.f2666j[iC].c());
                    return iC;
                }
            } else if (this.f2676j.read(lVar, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        F3.i.f(byteBuffer, "sink");
        l lVar = this.f2677k;
        if (lVar.f2648k == 0 && this.f2676j.read(lVar, 8192L) == -1) {
            return -1;
        }
        return lVar.read(byteBuffer);
    }

    @Override // W3.F
    public final I timeout() {
        return this.f2676j.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f2676j + ')';
    }

    @Override // W3.n
    public final String u() {
        return G(Long.MAX_VALUE);
    }

    @Override // W3.n
    public final byte[] w() {
        F f5 = this.f2676j;
        l lVar = this.f2677k;
        lVar.z(f5);
        return lVar.X(lVar.f2648k);
    }

    @Override // W3.n
    public final boolean y() {
        if (!(!this.f2678l)) {
            throw new IllegalStateException("closed".toString());
        }
        l lVar = this.f2677k;
        return lVar.y() && this.f2676j.read(lVar, 8192L) == -1;
    }

    @Override // W3.F
    public final long read(l lVar, long j5) {
        F3.i.f(lVar, "sink");
        if (j5 >= 0) {
            if (!this.f2678l) {
                l lVar2 = this.f2677k;
                if (lVar2.f2648k == 0 && this.f2676j.read(lVar2, 8192L) == -1) {
                    return -1L;
                }
                return lVar2.read(lVar, Math.min(j5, lVar2.f2648k));
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(AbstractC0535a.h(j5, "byteCount < 0: ").toString());
    }
}
