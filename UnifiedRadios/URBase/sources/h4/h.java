package h4;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import k4.t;

/* loaded from: classes.dex */
public final class h extends m {

    /* renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList f7094e;

    /* renamed from: f, reason: collision with root package name */
    public int f7095f;

    public h() {
        super(e4.a.g().f6227e, e4.a.g().g);
        this.f7094e = new CopyOnWriteArrayList();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0050 A[Catch: all -> 0x007c, TRY_LEAVE, TryCatch #2 {all -> 0x007c, blocks: (B:22:0x0040, B:29:0x004a, B:30:0x004b, B:33:0x0050, B:23:0x0041, B:24:0x0044), top: B:48:0x0040 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap k(android.graphics.drawable.BitmapDrawable r10, long r11, int r13) {
        /*
            r0 = 0
            if (r13 > 0) goto L4
            return r0
        L4:
            android.graphics.Bitmap r1 = r10.getBitmap()
            int r1 = r1.getWidth()
            g4.a r2 = g4.a.f7035c
            android.graphics.Bitmap r2 = r2.b(r1, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L1d
            r2.setHasAlpha(r4)
            r2.eraseColor(r3)
            goto L23
        L1d:
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r1, r1, r2)
        L23:
            android.graphics.Canvas r5 = new android.graphics.Canvas
            r5.<init>(r2)
            boolean r6 = r10 instanceof g4.g
            if (r6 == 0) goto L30
            r7 = r10
            g4.g r7 = (g4.g) r7
            goto L31
        L30:
            r7 = r0
        L31:
            if (r6 == 0) goto L3e
            monitor-enter(r7)
            int r8 = r7.f7070c     // Catch: java.lang.Throwable -> L3b
            int r8 = r8 + r4
            r7.f7070c = r8     // Catch: java.lang.Throwable -> L3b
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L3b
            goto L3e
        L3b:
            r10 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L3b
            throw r10
        L3e:
            if (r6 == 0) goto L4b
            monitor-enter(r7)     // Catch: java.lang.Throwable -> L7c
            boolean r8 = r7.f7069b     // Catch: java.lang.Throwable -> L48
            r8 = r8 ^ r4
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L48
            if (r8 == 0) goto L73
            goto L4b
        L48:
            r10 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L48
            throw r10     // Catch: java.lang.Throwable -> L7c
        L4b:
            int r8 = r1 >> r13
            if (r8 != 0) goto L50
            goto L73
        L50:
            int r9 = k4.l.g(r11)     // Catch: java.lang.Throwable -> L7c
            int r13 = r4 << r13
            int r9 = r9 % r13
            int r9 = r9 * r8
            int r11 = k4.l.h(r11)     // Catch: java.lang.Throwable -> L7c
            int r11 = r11 % r13
            int r11 = r11 * r8
            android.graphics.Rect r12 = new android.graphics.Rect     // Catch: java.lang.Throwable -> L7c
            int r13 = r9 + r8
            int r8 = r8 + r11
            r12.<init>(r9, r11, r13, r8)     // Catch: java.lang.Throwable -> L7c
            android.graphics.Rect r11 = new android.graphics.Rect     // Catch: java.lang.Throwable -> L7c
            r11.<init>(r3, r3, r1, r1)     // Catch: java.lang.Throwable -> L7c
            android.graphics.Bitmap r10 = r10.getBitmap()     // Catch: java.lang.Throwable -> L7c
            r5.drawBitmap(r10, r12, r11, r0)     // Catch: java.lang.Throwable -> L7c
            r3 = r4
        L73:
            if (r6 == 0) goto L78
            r7.a()
        L78:
            if (r3 != 0) goto L7b
            return r0
        L7b:
            return r2
        L7c:
            r10 = move-exception
            if (r6 == 0) goto L82
            r7.a()
        L82:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.h.k(android.graphics.drawable.BitmapDrawable, long, int):android.graphics.Bitmap");
    }

    @Override // h4.m
    public final void b() {
        a();
        this.f7107a.shutdown();
        this.f7094e.clear();
    }

    @Override // h4.m
    public final int c() {
        return t.f8315b;
    }

    @Override // h4.m
    public final int d() {
        return this.f7095f;
    }

    @Override // h4.m
    public final String e() {
        return "approximater";
    }

    @Override // h4.m
    public final M0.d f() {
        return new g(this, 0);
    }

    @Override // h4.m
    public final boolean g() {
        return false;
    }

    @Override // h4.m
    public final void i(i4.c cVar) {
    }

    public final void j(j jVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f7094e;
        copyOnWriteArrayList.add(jVar);
        this.f7095f = 0;
        Iterator it = copyOnWriteArrayList.iterator();
        boolean z4 = true;
        while (it.hasNext()) {
            int iD = ((m) it.next()).d();
            if (z4) {
                this.f7095f = iD;
                z4 = false;
            } else {
                this.f7095f = Math.min(this.f7095f, iD);
            }
        }
    }
}
