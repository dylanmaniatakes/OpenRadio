package W3;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class y implements m {

    /* renamed from: j, reason: collision with root package name */
    public final D f2673j;

    /* renamed from: k, reason: collision with root package name */
    public final l f2674k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2675l;

    public y(D d5) {
        F3.i.f(d5, "sink");
        this.f2673j = d5;
        this.f2674k = new l();
    }

    @Override // W3.m
    public final m A(int i5) {
        if (!(!this.f2675l)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2674k.e0(i5);
        E();
        return this;
    }

    @Override // W3.m
    public final m B(o oVar) {
        F3.i.f(oVar, "byteString");
        if (!(!this.f2675l)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2674k.c0(oVar);
        E();
        return this;
    }

    @Override // W3.m
    public final m C(byte[] bArr) {
        F3.i.f(bArr, "source");
        if (!(!this.f2675l)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2674k.d0(bArr);
        E();
        return this;
    }

    @Override // W3.m
    public final m E() {
        if (!(!this.f2675l)) {
            throw new IllegalStateException("closed".toString());
        }
        l lVar = this.f2674k;
        long jO = lVar.o();
        if (jO > 0) {
            this.f2673j.write(lVar, jO);
        }
        return this;
    }

    @Override // W3.m
    public final m O(String str) {
        F3.i.f(str, "string");
        if (!(!this.f2675l)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2674k.m0(str);
        E();
        return this;
    }

    @Override // W3.m
    public final m P(long j5) {
        if (!(!this.f2675l)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2674k.f0(j5);
        E();
        return this;
    }

    @Override // W3.m
    public final l b() {
        return this.f2674k;
    }

    @Override // W3.D, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        D d5 = this.f2673j;
        if (this.f2675l) {
            return;
        }
        try {
            l lVar = this.f2674k;
            long j5 = lVar.f2648k;
            if (j5 > 0) {
                d5.write(lVar, j5);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            d5.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f2675l = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // W3.m
    public final m e(long j5) {
        if (!(!this.f2675l)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2674k.g0(j5);
        E();
        return this;
    }

    @Override // W3.m, W3.D, java.io.Flushable
    public final void flush() {
        if (!(!this.f2675l)) {
            throw new IllegalStateException("closed".toString());
        }
        l lVar = this.f2674k;
        long j5 = lVar.f2648k;
        D d5 = this.f2673j;
        if (j5 > 0) {
            d5.write(lVar, j5);
        }
        d5.flush();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f2675l;
    }

    @Override // W3.m
    public final m j() {
        if (!(!this.f2675l)) {
            throw new IllegalStateException("closed".toString());
        }
        l lVar = this.f2674k;
        long j5 = lVar.f2648k;
        if (j5 > 0) {
            this.f2673j.write(lVar, j5);
        }
        return this;
    }

    @Override // W3.m
    public final m k(int i5) {
        if (!(!this.f2675l)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2674k.j0(i5);
        E();
        return this;
    }

    @Override // W3.m
    public final m n(int i5) {
        if (!(!this.f2675l)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f2674k.h0(i5);
        E();
        return this;
    }

    @Override // W3.D
    public final I timeout() {
        return this.f2673j.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f2673j + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        F3.i.f(byteBuffer, "source");
        if (!(!this.f2675l)) {
            throw new IllegalStateException("closed".toString());
        }
        int iWrite = this.f2674k.write(byteBuffer);
        E();
        return iWrite;
    }

    @Override // W3.m
    public final long z(F f5) throws IOException {
        long j5 = 0;
        while (true) {
            long j6 = ((C0193f) f5).read(this.f2674k, 8192L);
            if (j6 == -1) {
                return j5;
            }
            j5 += j6;
            E();
        }
    }

    @Override // W3.D
    public final void write(l lVar, long j5) {
        F3.i.f(lVar, "source");
        if (!this.f2675l) {
            this.f2674k.write(lVar, j5);
            E();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // W3.m
    public final m write(byte[] bArr, int i5, int i6) {
        F3.i.f(bArr, "source");
        if (!this.f2675l) {
            this.f2674k.m0write(bArr, i5, i6);
            E();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }
}
