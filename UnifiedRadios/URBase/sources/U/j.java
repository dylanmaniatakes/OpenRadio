package u;

import s.C0880c;
import s.C0883f;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean[] f9878a = new boolean[3];

    /* JADX WARN: Removed duplicated region for block: B:184:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x069f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:408:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x06bd  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x06c8  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x06d1  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x06d8  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x06e8  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x06ec A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0707 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(u.e r36, s.C0880c r37, java.util.ArrayList r38, int r39) {
        /*
            Method dump skipped, instructions count: 1813
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.j.a(u.e, s.c, java.util.ArrayList, int):void");
    }

    public static void b(e eVar, C0880c c0880c, d dVar) {
        dVar.f9790o = -1;
        dVar.f9792p = -1;
        int i5 = eVar.f9793p0[0];
        int[] iArr = dVar.f9793p0;
        if (i5 != 2 && iArr[0] == 4) {
            c cVar = dVar.I;
            int i6 = cVar.g;
            int iQ = eVar.q();
            c cVar2 = dVar.f9749K;
            int i7 = iQ - cVar2.g;
            cVar.f9739i = c0880c.k(cVar);
            cVar2.f9739i = c0880c.k(cVar2);
            c0880c.d(cVar.f9739i, i6);
            c0880c.d(cVar2.f9739i, i7);
            dVar.f9790o = 2;
            dVar.f9763Y = i6;
            int i8 = i7 - i6;
            dVar.f9759U = i8;
            int i9 = dVar.f9768b0;
            if (i8 < i9) {
                dVar.f9759U = i9;
            }
        }
        if (eVar.f9793p0[1] == 2 || iArr[1] != 4) {
            return;
        }
        c cVar3 = dVar.f9748J;
        int i10 = cVar3.g;
        int iK = eVar.k();
        c cVar4 = dVar.f9750L;
        int i11 = iK - cVar4.g;
        cVar3.f9739i = c0880c.k(cVar3);
        cVar4.f9739i = c0880c.k(cVar4);
        c0880c.d(cVar3.f9739i, i10);
        c0880c.d(cVar4.f9739i, i11);
        if (dVar.f9766a0 > 0 || dVar.f9777g0 == 8) {
            c cVar5 = dVar.f9751M;
            C0883f c0883fK = c0880c.k(cVar5);
            cVar5.f9739i = c0883fK;
            c0880c.d(c0883fK, dVar.f9766a0 + i10);
        }
        dVar.f9792p = 2;
        dVar.f9764Z = i10;
        int i12 = i11 - i10;
        dVar.f9760V = i12;
        int i13 = dVar.f9770c0;
        if (i12 < i13) {
            dVar.f9760V = i13;
        }
    }

    public static final boolean c(int i5, int i6) {
        return (i5 & i6) == i6;
    }
}
