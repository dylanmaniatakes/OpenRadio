package W;

import P.j;
import Z3.g;
import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public final class a extends g {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f2537b;

    public a(b bVar) {
        this.f2537b = bVar;
    }

    @Override // Z3.g
    public final j a(int i5) {
        return new j(AccessibilityNodeInfo.obtain(this.f2537b.r(i5).f2058a));
    }

    @Override // Z3.g
    public final j b(int i5) {
        b bVar = this.f2537b;
        int i6 = i5 == 2 ? bVar.f2545k : bVar.f2546l;
        if (i6 == Integer.MIN_VALUE) {
            return null;
        }
        return a(i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    @Override // Z3.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(int r8, int r9, android.os.Bundle r10) {
        /*
            r7 = this;
            W.b r0 = r7.f2537b
            android.view.View r1 = r0.f2543i
            r2 = -1
            if (r8 == r2) goto L64
            r2 = 1
            if (r9 == r2) goto L5f
            r3 = 2
            if (r9 == r3) goto L5a
            r3 = 64
            r4 = 0
            r5 = 65536(0x10000, float:9.1835E-41)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r9 == r3) goto L2f
            r3 = 128(0x80, float:1.8E-43)
            if (r9 == r3) goto L1f
            boolean r8 = r0.s(r8, r9, r10)
            goto L6a
        L1f:
            int r9 = r0.f2545k
            if (r9 != r8) goto L2c
            r0.f2545k = r6
            r1.invalidate()
            r0.x(r8, r5)
            goto L2d
        L2c:
            r2 = r4
        L2d:
            r8 = r2
            goto L6a
        L2f:
            android.view.accessibility.AccessibilityManager r9 = r0.h
            boolean r10 = r9.isEnabled()
            if (r10 == 0) goto L2c
            boolean r9 = r9.isTouchExplorationEnabled()
            if (r9 != 0) goto L3e
            goto L2c
        L3e:
            int r9 = r0.f2545k
            if (r9 == r8) goto L2c
            if (r9 == r6) goto L4e
            r0.f2545k = r6
            android.view.View r10 = r0.f2543i
            r10.invalidate()
            r0.x(r9, r5)
        L4e:
            r0.f2545k = r8
            r1.invalidate()
            r9 = 32768(0x8000, float:4.5918E-41)
            r0.x(r8, r9)
            goto L2d
        L5a:
            boolean r8 = r0.j(r8)
            goto L6a
        L5f:
            boolean r8 = r0.w(r8)
            goto L6a
        L64:
            java.util.WeakHashMap r8 = O.Y.f1904a
            boolean r8 = O.G.j(r1, r9, r10)
        L6a:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: W.a.c(int, int, android.os.Bundle):boolean");
    }
}
