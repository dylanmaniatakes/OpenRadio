package Y3;

import java.io.InputStream;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public InputStream f2986d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2987e;

    /* renamed from: f, reason: collision with root package name */
    public long f2988f;
    public int g;
    public int h;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f2983a = new byte[4160];

    /* renamed from: b, reason: collision with root package name */
    public final int[] f2984b = new int[1040];

    /* renamed from: c, reason: collision with root package name */
    public final L0.e f2985c = new L0.e(10, false);

    /* renamed from: i, reason: collision with root package name */
    public int f2989i = 0;

    public static void a(a aVar, boolean z4) {
        if (aVar.f2987e) {
            int i5 = ((aVar.h << 2) + ((aVar.g + 7) >> 3)) - 8;
            int i6 = aVar.f2989i;
            if (i5 > i6) {
                throw new c("Read after end");
            }
            if (z4 && i5 != i6) {
                throw new c("Unused bytes after end");
            }
        }
    }

    public static void b(a aVar) {
        int i5 = aVar.g;
        if (i5 >= 32) {
            aVar.h = aVar.h + 1;
            aVar.f2988f = (aVar.f2984b[r2] << 32) | (aVar.f2988f >>> 32);
            aVar.g = i5 - 32;
        }
    }

    public static int c(a aVar) {
        return (aVar.f2987e ? (aVar.f2989i + 3) >> 2 : 1024) - aVar.h;
    }

    public static int d(a aVar, int i5) {
        b(aVar);
        long j5 = aVar.f2988f;
        int i6 = aVar.g;
        int i7 = ((int) (j5 >>> i6)) & ((1 << i5) - 1);
        aVar.g = i6 + i5;
        return i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        r7.f2987e = true;
        r7.f2989i = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
    
        r1 = r1 + 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(Y3.a r7) throws java.io.IOException {
        /*
            int r0 = r7.h
            r1 = 1015(0x3f7, float:1.422E-42)
            if (r0 > r1) goto L7
            return
        L7:
            boolean r1 = r7.f2987e
            if (r1 == 0) goto L1b
            int r7 = c(r7)
            r0 = -2
            if (r7 < r0) goto L13
            return
        L13:
            Y3.c r7 = new Y3.c
            java.lang.String r0 = "No more input"
            r7.<init>(r0)
            throw r7
        L1b:
            int r0 = r0 << 2
            int r1 = 4096 - r0
            byte[] r2 = r7.f2983a
            r3 = 0
            java.lang.System.arraycopy(r2, r0, r2, r3, r1)
            r7.h = r3
        L27:
            r0 = 4096(0x1000, float:5.74E-42)
            if (r1 >= r0) goto L49
            java.io.InputStream r0 = r7.f2986d     // Catch: java.io.IOException -> L3d
            int r4 = 4096 - r1
            int r0 = r0.read(r2, r1, r4)     // Catch: java.io.IOException -> L3d
            if (r0 > 0) goto L3f
            r0 = 1
            r7.f2987e = r0     // Catch: java.io.IOException -> L3d
            r7.f2989i = r1     // Catch: java.io.IOException -> L3d
            int r1 = r1 + 3
            goto L49
        L3d:
            r7 = move-exception
            goto L41
        L3f:
            int r1 = r1 + r0
            goto L27
        L41:
            Y3.c r0 = new Y3.c
            java.lang.String r1 = "Failed to read input"
            r0.<init>(r1, r7)
            throw r0
        L49:
            int r0 = r1 >> 2
        L4b:
            if (r3 >= r0) goto L7d
            L0.e r1 = r7.f2985c
            java.lang.Object r2 = r1.f1542e
            int[] r2 = (int[]) r2
            java.lang.Object r1 = r1.f1541d
            byte[] r1 = (byte[]) r1
            int r4 = r3 * 4
            r5 = r1[r4]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r6 = r4 + 1
            r6 = r1[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 8
            r5 = r5 | r6
            int r6 = r4 + 2
            r6 = r1[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << 16
            r5 = r5 | r6
            int r4 = r4 + 3
            r1 = r1[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 24
            r1 = r1 | r5
            r2[r3] = r1
            int r3 = r3 + 1
            goto L4b
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Y3.a.e(Y3.a):void");
    }
}
