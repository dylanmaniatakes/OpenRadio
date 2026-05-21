package Y3;

import java.io.IOException;
import okhttp3.internal.http2.Settings;
import org.conscrypt.PSKKeyManager;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f2994a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 12, 16, 12, 12, 20, 12, 16, 24, 28, 12, 12, 32, 12, 36, 12, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 32, 32, 24, 40, 28, 12, 12, 48, 52, 52, 52, 48, 52, 52, 52, 48, 52, 52, 52, 52, 52, 48, 52, 52, 52, 52, 52, 48, 52, 52, 52, 52, 52, 24, 12, 28, 12, 12, 12, 56, 60, 60, 60, 56, 60, 60, 60, 56, 60, 60, 60, 60, 60, 56, 60, 60, 60, 60, 60, 56, 60, 60, 60, 60, 60, 24, 12, 28, 12, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 
    40, 40, 40, 40, 40, 40, 40, 40, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 56, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 11, 11, 11, 11, 12, 12, 12, 12, 13, 13, 13, 13, 14, 14, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 19, 19, 19, 19, 20, 20, 20, 20, 21, 21, 21, 21, 22, 22, 22, 22, 23, 23, 23, 23, 24, 24, 24, 24, 25, 25, 25, 25, 26, 26, 26, 26, 27, 27, 27, 27, 28, 28, 28, 28, 29, 29, 29, 29, 30, 30, 30, 30, 31, 31, 31, 31, 32, 32, 32, 32, 33, 33, 33, 33, 34, 34, 34, 34, 35, 35, 35, 35, 36, 36, 36, 36, 37, 37, 37, 37, 38, 38, 38, 38, 39, 39, 39, 39, 40, 40, 40, 40, 41, 41, 41, 41, 42, 42, 42, 42, 43, 43, 43, 43, 44, 44, 44, 44, 45, 45, 45, 45, 46, 46, 46, 46, 47, 47, 47, 47, 48, 48, 48, 48, 49, 49, 49, 49, 50, 50, 50, 50, 51, 51, 51, 51, 52, 52, 52, 52, 53, 53, 53, 53, 54, 54, 54, 54, 55, 55, 55, 55, 56, 56, 56, 56, 57, 57, 57, 57, 58, 58, 58, 58, 59, 59, 59, 59, 60, 60, 60, 60, 61, 61, 61, 61, 62, 62, 62, 62, 63, 63, 63, 63, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f2995b = {1024, 1536, 1280, 1536, 0, PSKKeyManager.MAX_KEY_LENGTH_BYTES, 768, 512};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f2996c = {1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f2997d = {3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f2998e = {0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f2999f = {131072, 131076, 131075, 196610, 131072, 131076, 131075, 262145, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};
    public static final int[] g = {0, 0, 0, 0, 0, 4096, 9216, 21504, 35840, 44032, 53248, 63488, 74752, 87040, 93696, 100864, 104704, 106752, 108928, 113536, 115968, 118528, 119872, 121280, 122016};
    public static final int[] h = {0, 0, 0, 0, 10, 10, 11, 11, 10, 10, 10, 10, 10, 9, 9, 8, 7, 7, 8, 7, 7, 6, 6, 5, 5};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f3000i = {1, 5, 9, 13, 17, 25, 33, 41, 49, 65, 81, 97, 113, 145, 177, 209, 241, 305, 369, 497, 753, 1265, 2289, 4337, 8433, 16625};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f3001j = {2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9, 10, 11, 12, 13, 24};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f3002k = {0, 1, 2, 3, 4, 5, 6, 8, 10, 14, 18, 26, 34, 50, 66, 98, 130, 194, 322, 578, 1090, 2114, 6210, 22594};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f3003l = {0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 12, 14, 24};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f3004m = {2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 18, 22, 30, 38, 54, 70, 102, 134, 198, 326, 582, 1094, 2118};
    public static final int[] n = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 24};

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f3005o = {0, 0, 8, 8, 0, 16, 8, 16, 16};

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f3006p = {0, 8, 0, 8, 16, 0, 16, 8, 16};

    /* renamed from: q, reason: collision with root package name */
    public static final byte[] f3007q = new byte[1024];

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f3008r = new int[1024];

    public static void a(int i5, int i6, int i7, int[] iArr, int[] iArr2) {
        int i8;
        int i9;
        int i10;
        int[] iArr3 = new int[i7];
        int[] iArr4 = new int[16];
        int[] iArr5 = new int[16];
        int i11 = 0;
        for (int i12 = 0; i12 < i7; i12++) {
            int i13 = iArr2[i12];
            iArr4[i13] = iArr4[i13] + 1;
        }
        iArr5[1] = 0;
        int i14 = 1;
        while (i14 < 15) {
            int i15 = i14 + 1;
            iArr5[i15] = iArr5[i14] + iArr4[i14];
            i14 = i15;
        }
        for (int i16 = 0; i16 < i7; i16++) {
            int i17 = iArr2[i16];
            if (i17 != 0) {
                int i18 = iArr5[i17];
                iArr5[i17] = i18 + 1;
                iArr3[i18] = i16;
            }
        }
        int i19 = 1 << i6;
        if (iArr5[15] == 1) {
            for (int i20 = 0; i20 < i19; i20++) {
                iArr[i5 + i20] = iArr3[0];
            }
            return;
        }
        int i21 = 2;
        int i22 = 2;
        int i23 = 0;
        int i24 = 1;
        while (i24 <= i6) {
            while (iArr4[i24] > 0) {
                int i25 = i5 + i11;
                int i26 = i23 + 1;
                int i27 = (i24 << 16) | iArr3[i23];
                int i28 = i19;
                do {
                    i28 -= i22;
                    iArr[i25 + i28] = i27;
                } while (i28 > 0);
                int i29 = 1 << (i24 - 1);
                while ((i11 & i29) != 0) {
                    i29 >>= 1;
                }
                i11 = (i11 & (i29 - 1)) + i29;
                iArr4[i24] = iArr4[i24] - 1;
                i23 = i26;
            }
            i24++;
            i22 <<= 1;
        }
        int i30 = i19 - 1;
        int i31 = i6 + 1;
        int i32 = -1;
        int i33 = i5;
        while (i31 <= 15) {
            while (iArr4[i31] > 0) {
                int i34 = i11 & i30;
                if (i34 != i32) {
                    int i35 = i33 + i19;
                    int i36 = 1 << (i31 - i6);
                    int i37 = i31;
                    while (i37 < 15) {
                        int i38 = i36 - iArr4[i37];
                        if (i38 <= 0) {
                            break;
                        }
                        i37++;
                        i36 = i38 << 1;
                    }
                    int i39 = i37 - i6;
                    iArr[i5 + i34] = ((i39 + i6) << 16) | ((i35 - i5) - i34);
                    i10 = i35;
                    i9 = i34;
                    i8 = 1 << i39;
                } else {
                    i8 = i19;
                    i9 = i32;
                    i10 = i33;
                }
                int i40 = i10 + (i11 >> i6);
                int i41 = i23 + 1;
                int i42 = ((i31 - i6) << 16) | iArr3[i23];
                int i43 = i8;
                do {
                    i43 -= i21;
                    iArr[i40 + i43] = i42;
                } while (i43 > 0);
                int i44 = 1 << (i31 - 1);
                while ((i11 & i44) != 0) {
                    i44 >>= 1;
                }
                i11 = (i11 & (i44 - 1)) + i44;
                iArr4[i31] = iArr4[i31] - 1;
                i19 = i8;
                i33 = i10;
                i32 = i9;
                i23 = i41;
            }
            i31++;
            i21 <<= 1;
        }
    }

    public static void b(f fVar, int i5) {
        a aVar = fVar.f3036c;
        int i6 = i5 * 2;
        a.b(aVar);
        int i7 = i5 * 1080;
        int iG = g(fVar.f3038e, i7, aVar);
        a.b(aVar);
        int iG2 = g(fVar.f3039f, i7, aVar);
        fVar.n[i5] = a.d(aVar, f3001j[iG2]) + f3000i[iG2];
        int[] iArr = fVar.f3046p;
        int i8 = iG == 1 ? iArr[i6 + 1] + 1 : iG == 0 ? iArr[i6] : iG - 2;
        int i9 = fVar.f3045o[i5];
        if (i8 >= i9) {
            i8 -= i9;
        }
        int i10 = i6 + 1;
        iArr[i6] = iArr[i10];
        iArr[i10] = i8;
    }

    public static int c(int i5, byte[] bArr, a aVar) throws IOException {
        int iD;
        a.e(aVar);
        if (a.d(aVar, 1) != 0) {
            int iD2 = a.d(aVar, 3);
            iD = iD2 == 0 ? 1 : a.d(aVar, iD2) + (1 << iD2);
        } else {
            iD = 0;
        }
        int i6 = iD + 1;
        if (i6 == 1) {
            int i7 = 0;
            while (i7 < i5) {
                int iMin = Math.min(i7 + 1024, i5) - i7;
                System.arraycopy(f3007q, 0, bArr, i7, iMin);
                i7 += iMin;
            }
            return i6;
        }
        int iD3 = a.d(aVar, 1) == 1 ? a.d(aVar, 4) + 1 : 0;
        int[] iArr = new int[1080];
        f(i6 + iD3, iArr, 0, aVar);
        int i8 = 0;
        while (i8 < i5) {
            a.e(aVar);
            a.b(aVar);
            int iG = g(iArr, 0, aVar);
            if (iG == 0) {
                bArr[i8] = 0;
            } else if (iG <= iD3) {
                for (int iD4 = a.d(aVar, iG) + (1 << iG); iD4 != 0; iD4--) {
                    if (i8 >= i5) {
                        throw new c("Corrupted context map");
                    }
                    bArr[i8] = 0;
                    i8++;
                }
            } else {
                bArr[i8] = (byte) (iG - iD3);
            }
            i8++;
        }
        if (a.d(aVar, 1) == 1) {
            int[] iArr2 = new int[PSKKeyManager.MAX_KEY_LENGTH_BYTES];
            for (int i9 = 0; i9 < 256; i9++) {
                iArr2[i9] = i9;
            }
            for (int i10 = 0; i10 < i5; i10++) {
                int i11 = bArr[i10] & 255;
                int i12 = iArr2[i11];
                bArr[i10] = (byte) i12;
                if (i11 != 0) {
                    while (i11 > 0) {
                        iArr2[i11] = iArr2[i11 - 1];
                        i11--;
                    }
                    iArr2[0] = i12;
                }
            }
        }
        return i6;
    }

    public static void d(f fVar) {
        b(fVar, 0);
        int i5 = fVar.f3046p[1];
        int i6 = i5 << 6;
        fVar.f3010A = i6;
        fVar.f3052v = ((int[]) fVar.f3042k.f7297e)[fVar.f3056z[i6] & 255];
        byte b5 = fVar.f3055y[i5];
        int[] iArr = f2995b;
        fVar.f3012C = iArr[b5];
        fVar.f3013D = iArr[b5 + 1];
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0130, code lost:
    
        throw new Y3.c("Invalid backward reference");
     */
    /* JADX WARN: Removed duplicated region for block: B:152:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x040b A[LOOP:5: B:162:0x040b->B:171:0x0451, LOOP_START, PHI: r3
      0x040b: PHI (r3v93 char) = (r3v63 char), (r3v99 char) binds: [B:161:0x0409, B:171:0x0451] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x05fa  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x06db  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x06e1  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x06ee  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0709  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x070b  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0773 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0773 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:448:0x05c5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:450:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(Y3.f r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2074
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Y3.d.e(Y3.f):void");
    }

    public static void f(int i5, int[] iArr, int i6, a aVar) {
        int i7;
        int i8;
        int i9;
        a.e(aVar);
        int[] iArr2 = new int[i5];
        int iD = a.d(aVar, 2);
        boolean z4 = true;
        if (iD == 1) {
            int i10 = i5 - 1;
            int[] iArr3 = new int[4];
            int iD2 = a.d(aVar, 2) + 1;
            int i11 = 0;
            while (i10 != 0) {
                i10 >>= 1;
                i11++;
            }
            for (int i12 = 0; i12 < iD2; i12++) {
                int iD3 = a.d(aVar, i11) % i5;
                iArr3[i12] = iD3;
                iArr2[iD3] = 2;
            }
            iArr2[iArr3[0]] = 1;
            if (iD2 != 1) {
                if (iD2 == 2) {
                    int i13 = iArr3[0];
                    int i14 = iArr3[1];
                    z = i13 != i14;
                    iArr2[i14] = 1;
                } else if (iD2 != 3) {
                    int i15 = iArr3[0];
                    int i16 = iArr3[1];
                    boolean z5 = (i15 == i16 || i15 == (i8 = iArr3[2]) || i15 == (i9 = iArr3[3]) || i16 == i8 || i16 == i9 || i8 == i9) ? false : true;
                    if (a.d(aVar, 1) == 1) {
                        iArr2[iArr3[2]] = 3;
                        iArr2[iArr3[3]] = 3;
                    } else {
                        iArr2[iArr3[0]] = 2;
                    }
                    z4 = z5;
                } else {
                    int i17 = iArr3[0];
                    int i18 = iArr3[1];
                    if (i17 != i18 && i17 != (i7 = iArr3[2]) && i18 != i7) {
                        z = true;
                    }
                }
                z4 = z;
            }
        } else {
            int[] iArr4 = new int[18];
            int i19 = 0;
            int i20 = 32;
            while (iD < 18 && i20 > 0) {
                int i21 = f2996c[iD];
                a.b(aVar);
                long j5 = aVar.f2988f;
                int i22 = aVar.g;
                int i23 = f2999f[((int) (j5 >>> i22)) & 15];
                aVar.g = i22 + (i23 >> 16);
                int i24 = i23 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
                iArr4[i21] = i24;
                if (i24 != 0) {
                    i20 -= 32 >> i24;
                    i19++;
                }
                iD++;
            }
            if (i19 != 1 && i20 != 0) {
                z4 = false;
            }
            int[] iArr5 = new int[32];
            a(0, 5, 18, iArr5, iArr4);
            int i25 = 32768;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 8;
            while (i26 < i5 && i25 > 0) {
                a.e(aVar);
                a.b(aVar);
                long j6 = aVar.f2988f;
                int i30 = aVar.g;
                int i31 = iArr5[((int) (j6 >>> i30)) & 31];
                aVar.g = i30 + (i31 >> 16);
                int i32 = i31 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
                if (i32 < 16) {
                    int i33 = i26 + 1;
                    iArr2[i26] = i32;
                    if (i32 != 0) {
                        i25 -= 32768 >> i32;
                        i26 = i33;
                        i29 = i32;
                    } else {
                        i26 = i33;
                    }
                    i28 = 0;
                } else {
                    int i34 = i32 - 14;
                    int i35 = i32 == 16 ? i29 : 0;
                    if (i27 != i35) {
                        i28 = 0;
                        i27 = i35;
                    }
                    int iD4 = a.d(aVar, i34) + 3 + (i28 > 0 ? (i28 - 2) << i34 : i28);
                    int i36 = iD4 - i28;
                    if (i26 + i36 > i5) {
                        throw new c("symbol + repeatDelta > numSymbols");
                    }
                    int i37 = 0;
                    while (i37 < i36) {
                        iArr2[i26] = i27;
                        i37++;
                        i26++;
                    }
                    if (i27 != 0) {
                        i25 -= i36 << (15 - i27);
                    }
                    i28 = iD4;
                }
            }
            if (i25 != 0) {
                throw new c("Unused space");
            }
            int i38 = i5 - i26;
            int i39 = 0;
            while (i39 < i38) {
                int iMin = Math.min(i39 + 1024, i38) - i39;
                System.arraycopy(f3008r, 0, iArr2, i26 + i39, iMin);
                i39 += iMin;
            }
        }
        if (!z4) {
            throw new c("Can't readHuffmanCode");
        }
        a(i6, 8, i5, iArr, iArr2);
    }

    public static int g(int[] iArr, int i5, a aVar) {
        long j5 = aVar.f2988f;
        int i6 = aVar.g;
        int i7 = (int) (j5 >>> i6);
        int i8 = i5 + (i7 & 255);
        int i9 = iArr[i8];
        int i10 = i9 >> 16;
        int i11 = i9 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        if (i10 <= 8) {
            aVar.g = i6 + i10;
            return i11;
        }
        int i12 = iArr[i8 + i11 + ((i7 & ((1 << i10) - 1)) >>> 8)];
        aVar.g = (i12 >> 16) + 8 + i6;
        return i12 & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
    }
}
