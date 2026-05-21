package X3;

import F3.i;
import W3.A;
import W3.l;
import java.io.EOFException;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f2863a;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(M3.a.f1740a);
        i.e(bytes, "this as java.lang.String).getBytes(charset)");
        f2863a = bytes;
    }

    public static final boolean a(A a2, int i5, byte[] bArr, int i6) {
        int i7 = a2.f2619c;
        byte[] bArr2 = a2.f2617a;
        for (int i8 = 1; i8 < i6; i8++) {
            if (i5 == i7) {
                a2 = a2.f2622f;
                i.c(a2);
                i5 = a2.f2618b;
                i7 = a2.f2619c;
                bArr2 = a2.f2617a;
            }
            if (bArr2[i5] != bArr[i8]) {
                return false;
            }
            i5++;
        }
        return true;
    }

    public static final String b(l lVar, long j5) throws EOFException {
        i.f(lVar, "<this>");
        if (j5 > 0) {
            long j6 = j5 - 1;
            if (lVar.x(j6) == 13) {
                String strY = lVar.Y(j6, M3.a.f1740a);
                lVar.i(2L);
                return strY;
            }
        }
        String strY2 = lVar.Y(j5, M3.a.f1740a);
        lVar.i(1L);
        return strY2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
    
        if (r19 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0066, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int c(W3.l r17, W3.w r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 173
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.a.c(W3.l, W3.w, boolean):int");
    }
}
