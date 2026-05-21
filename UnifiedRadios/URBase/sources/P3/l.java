package P3;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final class l extends S3.u {
    public final d n;

    /* renamed from: o, reason: collision with root package name */
    public final AtomicReferenceArray f2121o;

    public l(long j5, l lVar, d dVar, int i5) {
        super(j5, lVar, i5);
        this.n = dVar;
        this.f2121o = new AtomicReferenceArray(f.f2100b * 2);
    }

    @Override // S3.u
    public final int f() {
        return f.f2100b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x005b, code lost:
    
        m(r7, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005e, code lost:
    
        if (r1 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0060, code lost:
    
        F3.i.c(r4);
        r7 = r4.f2097k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0065, code lost:
    
        if (r7 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0067, code lost:
    
        S3.AbstractC0187a.a(r7, r0, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return;
     */
    @Override // S3.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r7, w3.InterfaceC0941i r8) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r6 = this;
            int r0 = P3.f.f2100b
            if (r7 < r0) goto L6
            r1 = 1
            goto L7
        L6:
            r1 = 0
        L7:
            if (r1 == 0) goto La
            int r7 = r7 - r0
        La:
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r6.f2121o
            int r2 = r7 * 2
            java.lang.Object r0 = r0.get(r2)
        L12:
            java.lang.Object r2 = r6.k(r7)
            boolean r3 = r2 instanceof N3.i0
            P3.d r4 = r6.n
            r5 = 0
            if (r3 != 0) goto L6b
            boolean r3 = r2 instanceof P3.u
            if (r3 == 0) goto L22
            goto L6b
        L22:
            S3.w r3 = P3.f.f2106j
            if (r2 == r3) goto L5b
            S3.w r3 = P3.f.f2107k
            if (r2 != r3) goto L2b
            goto L5b
        L2b:
            S3.w r3 = P3.f.g
            if (r2 == r3) goto L12
            S3.w r3 = P3.f.f2104f
            if (r2 != r3) goto L34
            goto L12
        L34:
            S3.w r7 = P3.f.f2105i
            if (r2 == r7) goto L5a
            S3.w r7 = P3.f.f2102d
            if (r2 != r7) goto L3d
            goto L5a
        L3d:
            S3.w r7 = P3.f.f2108l
            if (r2 != r7) goto L42
            return
        L42:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "unexpected state: "
            r8.<init>(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L5a:
            return
        L5b:
            r6.m(r7, r5)
            if (r1 == 0) goto L6a
            F3.i.c(r4)
            E3.l r7 = r4.f2097k
            if (r7 == 0) goto L6a
            S3.AbstractC0187a.a(r7, r0, r8)
        L6a:
            return
        L6b:
            if (r1 == 0) goto L70
            S3.w r3 = P3.f.f2106j
            goto L72
        L70:
            S3.w r3 = P3.f.f2107k
        L72:
            boolean r2 = r6.j(r2, r7, r3)
            if (r2 == 0) goto L12
            r6.m(r7, r5)
            r2 = r1 ^ 1
            r6.l(r7, r2)
            if (r1 == 0) goto L8c
            F3.i.c(r4)
            E3.l r7 = r4.f2097k
            if (r7 == 0) goto L8c
            S3.AbstractC0187a.a(r7, r0, r8)
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: P3.l.g(int, w3.i):void");
    }

    public final boolean j(Object obj, int i5, Object obj2) {
        AtomicReferenceArray atomicReferenceArray = this.f2121o;
        int i6 = (i5 * 2) + 1;
        while (!atomicReferenceArray.compareAndSet(i6, obj, obj2)) {
            if (atomicReferenceArray.get(i6) != obj) {
                return false;
            }
        }
        return true;
    }

    public final Object k(int i5) {
        return this.f2121o.get((i5 * 2) + 1);
    }

    public final void l(int i5, boolean z4) {
        if (z4) {
            d dVar = this.n;
            F3.i.c(dVar);
            dVar.H((this.f2419l * f.f2100b) + i5);
        }
        h();
    }

    public final void m(int i5, Object obj) {
        this.f2121o.lazySet(i5 * 2, obj);
    }

    public final void n(int i5, Object obj) {
        this.f2121o.set((i5 * 2) + 1, obj);
    }
}
