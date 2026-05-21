package W3;

import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public interface m extends D, WritableByteChannel {
    m A(int i5);

    m B(o oVar);

    m C(byte[] bArr);

    m E();

    m O(String str);

    m P(long j5);

    l b();

    m e(long j5);

    @Override // W3.D, java.io.Flushable
    void flush();

    m j();

    m k(int i5);

    m n(int i5);

    m write(byte[] bArr, int i5, int i6);

    long z(F f5);
}
