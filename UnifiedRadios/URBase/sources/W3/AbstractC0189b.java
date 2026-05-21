package W3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

/* renamed from: W3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0189b {

    /* renamed from: a, reason: collision with root package name */
    public static final C0196i f2629a = new C0196i();

    public static final boolean a(byte[] bArr, int i5, int i6, byte[] bArr2, int i7) {
        F3.i.f(bArr, "a");
        F3.i.f(bArr2, "b");
        for (int i8 = 0; i8 < i7; i8++) {
            if (bArr[i8 + i5] != bArr2[i8 + i6]) {
                return false;
            }
        }
        return true;
    }

    public static final y b(D d5) {
        F3.i.f(d5, "<this>");
        return new y(d5);
    }

    public static final z c(F f5) {
        F3.i.f(f5, "<this>");
        return new z(f5);
    }

    public static void d(long j5, l lVar, int i5, ArrayList arrayList, int i6, int i7, ArrayList arrayList2) {
        int i8;
        int i9;
        int i10;
        int i11;
        l lVar2;
        int i12 = i5;
        if (i6 >= i7) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        for (int i13 = i6; i13 < i7; i13++) {
            if (((o) arrayList.get(i13)).c() < i12) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        o oVar = (o) arrayList.get(i6);
        o oVar2 = (o) arrayList.get(i7 - 1);
        int i14 = -1;
        if (i12 == oVar.c()) {
            int iIntValue = ((Number) arrayList2.get(i6)).intValue();
            int i15 = i6 + 1;
            o oVar3 = (o) arrayList.get(i15);
            i8 = i15;
            i9 = iIntValue;
            oVar = oVar3;
        } else {
            i8 = i6;
            i9 = -1;
        }
        if (oVar.f(i12) == oVar2.f(i12)) {
            int iMin = Math.min(oVar.c(), oVar2.c());
            int i16 = 0;
            for (int i17 = i12; i17 < iMin && oVar.f(i17) == oVar2.f(i17); i17++) {
                i16++;
            }
            long j6 = 4;
            long j7 = (lVar.f2648k / j6) + j5 + 2 + i16 + 1;
            lVar.h0(-i16);
            lVar.h0(i9);
            int i18 = i16 + i12;
            while (i12 < i18) {
                lVar.h0(oVar.f(i12) & 255);
                i12++;
            }
            if (i8 + 1 == i7) {
                if (i18 != ((o) arrayList.get(i8)).c()) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                lVar.h0(((Number) arrayList2.get(i8)).intValue());
                return;
            } else {
                l lVar3 = new l();
                lVar.h0(((int) ((lVar3.f2648k / j6) + j7)) * (-1));
                d(j7, lVar3, i18, arrayList, i8, i7, arrayList2);
                lVar.z(lVar3);
                return;
            }
        }
        int i19 = 1;
        for (int i20 = i8 + 1; i20 < i7; i20++) {
            if (((o) arrayList.get(i20 - 1)).f(i12) != ((o) arrayList.get(i20)).f(i12)) {
                i19++;
            }
        }
        long j8 = 4;
        long j9 = (lVar.f2648k / j8) + j5 + 2 + (i19 * 2);
        lVar.h0(i19);
        lVar.h0(i9);
        for (int i21 = i8; i21 < i7; i21++) {
            int iF = ((o) arrayList.get(i21)).f(i12);
            if (i21 == i8 || iF != ((o) arrayList.get(i21 - 1)).f(i12)) {
                lVar.h0(iF & 255);
            }
        }
        l lVar4 = new l();
        int i22 = i8;
        while (i22 < i7) {
            byte bF = ((o) arrayList.get(i22)).f(i12);
            int i23 = i22 + 1;
            int i24 = i23;
            while (true) {
                if (i24 >= i7) {
                    i10 = i7;
                    break;
                } else {
                    if (bF != ((o) arrayList.get(i24)).f(i12)) {
                        i10 = i24;
                        break;
                    }
                    i24++;
                }
            }
            if (i23 == i10 && i12 + 1 == ((o) arrayList.get(i22)).c()) {
                lVar.h0(((Number) arrayList2.get(i22)).intValue());
                i11 = i10;
                lVar2 = lVar4;
            } else {
                lVar.h0(((int) ((lVar4.f2648k / j8) + j9)) * i14);
                i11 = i10;
                lVar2 = lVar4;
                d(j9, lVar4, i12 + 1, arrayList, i22, i10, arrayList2);
            }
            lVar4 = lVar2;
            i22 = i11;
            i14 = -1;
        }
        lVar.z(lVar4);
    }

    public static final void e(long j5, long j6, long j7) {
        if ((j6 | j7) < 0 || j6 > j5 || j5 - j6 < j7) {
            throw new ArrayIndexOutOfBoundsException("size=" + j5 + " offset=" + j6 + " byteCount=" + j7);
        }
    }

    public static final boolean f(AssertionError assertionError) {
        Logger logger = v.f2665a;
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? M3.e.z(message, "getsockname failed") : false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x0156, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static W3.w g(W3.o... r14) {
        /*
            Method dump skipped, instructions count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.AbstractC0189b.g(W3.o[]):W3.w");
    }

    public static final D h(Socket socket) throws IOException {
        Logger logger = v.f2665a;
        F3.i.f(socket, "<this>");
        E e5 = new E(socket);
        OutputStream outputStream = socket.getOutputStream();
        F3.i.e(outputStream, "getOutputStream(...)");
        return e5.sink(new C0192e(outputStream, 1, e5));
    }

    public static final F i(Socket socket) throws IOException {
        Logger logger = v.f2665a;
        F3.i.f(socket, "<this>");
        E e5 = new E(socket);
        InputStream inputStream = socket.getInputStream();
        F3.i.e(inputStream, "getInputStream(...)");
        return e5.source(new C0193f(inputStream, e5));
    }
}
