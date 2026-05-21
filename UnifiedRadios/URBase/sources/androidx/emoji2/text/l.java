package androidx.emoji2.text;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f3616d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final int f3617a;

    /* renamed from: b, reason: collision with root package name */
    public final L0.i f3618b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f3619c = 0;

    public l(L0.i iVar, int i5) {
        this.f3618b = iVar;
        this.f3617a = i5;
    }

    public final int a(int i5) {
        X.a aVarC = c();
        int iA = aVarC.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) aVarC.f1892d;
        int i6 = iA + aVarC.f1889a;
        return byteBuffer.getInt((i5 * 4) + byteBuffer.getInt(i6) + i6 + 4);
    }

    public final int b() {
        X.a aVarC = c();
        int iA = aVarC.a(16);
        if (iA == 0) {
            return 0;
        }
        int i5 = iA + aVarC.f1889a;
        return ((ByteBuffer) aVarC.f1892d).getInt(((ByteBuffer) aVarC.f1892d).getInt(i5) + i5);
    }

    public final X.a c() {
        ThreadLocal threadLocal = f3616d;
        X.a aVar = (X.a) threadLocal.get();
        if (aVar == null) {
            aVar = new X.a();
            threadLocal.set(aVar);
        }
        X.b bVar = (X.b) this.f3618b.f1547c;
        int iA = bVar.a(6);
        if (iA != 0) {
            int i5 = iA + bVar.f1889a;
            int i6 = (this.f3617a * 4) + ((ByteBuffer) bVar.f1892d).getInt(i5) + i5 + 4;
            int i7 = ((ByteBuffer) bVar.f1892d).getInt(i6) + i6;
            ByteBuffer byteBuffer = (ByteBuffer) bVar.f1892d;
            aVar.f1892d = byteBuffer;
            if (byteBuffer != null) {
                aVar.f1889a = i7;
                int i8 = i7 - byteBuffer.getInt(i7);
                aVar.f1890b = i8;
                aVar.f1891c = ((ByteBuffer) aVar.f1892d).getShort(i8);
            } else {
                aVar.f1889a = 0;
                aVar.f1890b = 0;
                aVar.f1891c = 0;
            }
        }
        return aVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        X.a aVarC = c();
        int iA = aVarC.a(4);
        sb.append(Integer.toHexString(iA != 0 ? ((ByteBuffer) aVarC.f1892d).getInt(iA + aVarC.f1889a) : 0));
        sb.append(", codepoints:");
        int iB = b();
        for (int i5 = 0; i5 < iB; i5++) {
            sb.append(Integer.toHexString(a(i5)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
