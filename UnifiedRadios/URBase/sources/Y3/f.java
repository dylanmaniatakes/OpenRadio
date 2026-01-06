package Y3;

import i3.C0573b;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: A, reason: collision with root package name */
    public int f3010A;

    /* renamed from: B, reason: collision with root package name */
    public int f3011B;

    /* renamed from: C, reason: collision with root package name */
    public int f3012C;

    /* renamed from: D, reason: collision with root package name */
    public int f3013D;

    /* renamed from: E, reason: collision with root package name */
    public int f3014E;

    /* renamed from: F, reason: collision with root package name */
    public int f3015F;

    /* renamed from: G, reason: collision with root package name */
    public byte[] f3016G;

    /* renamed from: H, reason: collision with root package name */
    public int f3017H;
    public int I;

    /* renamed from: J, reason: collision with root package name */
    public int f3018J;

    /* renamed from: K, reason: collision with root package name */
    public int f3019K;

    /* renamed from: L, reason: collision with root package name */
    public int f3020L;

    /* renamed from: M, reason: collision with root package name */
    public int f3021M;

    /* renamed from: N, reason: collision with root package name */
    public int f3022N;

    /* renamed from: O, reason: collision with root package name */
    public int f3023O;

    /* renamed from: T, reason: collision with root package name */
    public int f3028T;

    /* renamed from: U, reason: collision with root package name */
    public int f3029U;

    /* renamed from: V, reason: collision with root package name */
    public int f3030V;

    /* renamed from: W, reason: collision with root package name */
    public int f3031W;

    /* renamed from: X, reason: collision with root package name */
    public int f3032X;

    /* renamed from: Y, reason: collision with root package name */
    public byte[] f3033Y;

    /* renamed from: b, reason: collision with root package name */
    public int f3035b;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f3037d;
    public int g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3040i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3041j;

    /* renamed from: v, reason: collision with root package name */
    public int f3052v;

    /* renamed from: w, reason: collision with root package name */
    public int f3053w;

    /* renamed from: x, reason: collision with root package name */
    public int f3054x;

    /* renamed from: y, reason: collision with root package name */
    public byte[] f3055y;

    /* renamed from: z, reason: collision with root package name */
    public byte[] f3056z;

    /* renamed from: a, reason: collision with root package name */
    public int f3034a = 0;

    /* renamed from: c, reason: collision with root package name */
    public final a f3036c = new a();

    /* renamed from: e, reason: collision with root package name */
    public final int[] f3038e = new int[3240];

    /* renamed from: f, reason: collision with root package name */
    public final int[] f3039f = new int[3240];

    /* renamed from: k, reason: collision with root package name */
    public final C0573b f3042k = new C0573b();

    /* renamed from: l, reason: collision with root package name */
    public final C0573b f3043l = new C0573b();

    /* renamed from: m, reason: collision with root package name */
    public final C0573b f3044m = new C0573b();
    public final int[] n = new int[3];

    /* renamed from: o, reason: collision with root package name */
    public final int[] f3045o = new int[3];

    /* renamed from: p, reason: collision with root package name */
    public final int[] f3046p = new int[6];

    /* renamed from: q, reason: collision with root package name */
    public final int[] f3047q = {16, 15, 11, 4};

    /* renamed from: r, reason: collision with root package name */
    public int f3048r = 0;

    /* renamed from: s, reason: collision with root package name */
    public int f3049s = 0;

    /* renamed from: t, reason: collision with root package name */
    public int f3050t = 0;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3051u = false;

    /* renamed from: P, reason: collision with root package name */
    public int f3024P = 0;

    /* renamed from: Q, reason: collision with root package name */
    public long f3025Q = 0;

    /* renamed from: R, reason: collision with root package name */
    public final byte[] f3026R = new byte[0];

    /* renamed from: S, reason: collision with root package name */
    public int f3027S = 0;

    public static void a(f fVar, InputStream inputStream) throws IOException {
        int i5;
        if (fVar.f3034a != 0) {
            throw new IllegalStateException("State MUST be uninitialized");
        }
        a aVar = fVar.f3036c;
        if (aVar.f2986d != null) {
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
        L0.e eVar = aVar.f2985c;
        eVar.f1541d = aVar.f2983a;
        eVar.f1542e = aVar.f2984b;
        aVar.f2986d = inputStream;
        aVar.f2988f = 0L;
        aVar.g = 64;
        aVar.h = 1024;
        aVar.f2987e = false;
        a.e(aVar);
        a.a(aVar, false);
        a.b(aVar);
        a.b(aVar);
        if (a.d(aVar, 1) == 0) {
            i5 = 16;
        } else {
            int iD = a.d(aVar, 3);
            i5 = 17;
            if (iD != 0) {
                i5 = 17 + iD;
            } else {
                int iD2 = a.d(aVar, 3);
                if (iD2 != 0) {
                    i5 = iD2 + 8;
                }
            }
        }
        if (i5 == 9) {
            throw new c("Invalid 'windowBits' code");
        }
        int i6 = 1 << i5;
        fVar.f3023O = i6;
        fVar.f3022N = i6 - 16;
        fVar.f3034a = 1;
    }
}
