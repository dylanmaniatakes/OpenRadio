package E;

import android.graphics.Path;
import android.util.Log;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public char f424a;

    /* renamed from: b, reason: collision with root package name */
    public float[] f425b;

    public static void a(Path path, float f5, float f6, float f7, float f8, float f9, float f10, float f11, boolean z4, boolean z5) {
        double d5;
        double d6;
        double radians = Math.toRadians(f11);
        double dCos = Math.cos(radians);
        double dSin = Math.sin(radians);
        double d7 = f5;
        double d8 = f6;
        double d9 = (d8 * dSin) + (d7 * dCos);
        double d10 = d7;
        double d11 = f9;
        double d12 = d9 / d11;
        double d13 = f10;
        double d14 = ((d8 * dCos) + ((-f5) * dSin)) / d13;
        double d15 = d8;
        double d16 = f8;
        double d17 = ((d16 * dSin) + (f7 * dCos)) / d11;
        double d18 = ((d16 * dCos) + ((-f7) * dSin)) / d13;
        double d19 = d12 - d17;
        double d20 = d14 - d18;
        double d21 = (d12 + d17) / 2.0d;
        double d22 = (d14 + d18) / 2.0d;
        double d23 = (d20 * d20) + (d19 * d19);
        if (d23 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d24 = (1.0d / d23) - 0.25d;
        if (d24 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d23);
            float fSqrt = (float) (Math.sqrt(d23) / 1.99999d);
            a(path, f5, f6, f7, f8, f9 * fSqrt, f10 * fSqrt, f11, z4, z5);
            return;
        }
        double dSqrt = Math.sqrt(d24);
        double d25 = d19 * dSqrt;
        double d26 = dSqrt * d20;
        if (z4 == z5) {
            d5 = d21 - d26;
            d6 = d22 + d25;
        } else {
            d5 = d21 + d26;
            d6 = d22 - d25;
        }
        double dAtan2 = Math.atan2(d14 - d6, d12 - d5);
        double dAtan22 = Math.atan2(d18 - d6, d17 - d5) - dAtan2;
        if (z5 != (dAtan22 >= 0.0d)) {
            dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
        }
        double d27 = d5 * d11;
        double d28 = d6 * d13;
        double d29 = (d27 * dCos) - (d28 * dSin);
        double d30 = (d28 * dCos) + (d27 * dSin);
        int iCeil = (int) Math.ceil(Math.abs((dAtan22 * 4.0d) / 3.141592653589793d));
        double dCos2 = Math.cos(radians);
        double dSin2 = Math.sin(radians);
        double dCos3 = Math.cos(dAtan2);
        double dSin3 = Math.sin(dAtan2);
        double d31 = -d11;
        double d32 = d31 * dCos2;
        double d33 = d13 * dSin2;
        double d34 = (d32 * dSin3) - (d33 * dCos3);
        double d35 = d31 * dSin2;
        double d36 = d13 * dCos2;
        double d37 = (dCos3 * d36) + (dSin3 * d35);
        double d38 = d36;
        double d39 = dAtan22 / iCeil;
        int i5 = 0;
        while (i5 < iCeil) {
            double d40 = dAtan2 + d39;
            double dSin4 = Math.sin(d40);
            double dCos4 = Math.cos(d40);
            double d41 = d39;
            double d42 = (((d11 * dCos2) * dCos4) + d29) - (d33 * dSin4);
            double d43 = d38;
            double d44 = d29;
            double d45 = (d43 * dSin4) + (d11 * dSin2 * dCos4) + d30;
            double d46 = (d32 * dSin4) - (d33 * dCos4);
            double d47 = (dCos4 * d43) + (dSin4 * d35);
            double d48 = d40 - dAtan2;
            double dTan = Math.tan(d48 / 2.0d);
            double dSqrt2 = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d48)) / 3.0d;
            path.rLineTo(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
            path.cubicTo((float) ((d34 * dSqrt2) + d10), (float) ((d37 * dSqrt2) + d15), (float) (d42 - (dSqrt2 * d46)), (float) (d45 - (dSqrt2 * d47)), (float) d42, (float) d45);
            i5++;
            dAtan2 = d40;
            d35 = d35;
            dCos2 = dCos2;
            iCeil = iCeil;
            d37 = d47;
            d11 = d11;
            d34 = d46;
            d10 = d42;
            d15 = d45;
            d29 = d44;
            d39 = d41;
            d38 = d43;
        }
    }

    public static void b(f[] fVarArr, Path path) {
        int i5;
        int i6;
        float[] fArr;
        char c2;
        int i7;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        f[] fVarArr2 = fVarArr;
        int i8 = 6;
        float[] fArr2 = new float[6];
        char c5 = 'm';
        int i9 = 0;
        char c6 = 'm';
        int i10 = 0;
        while (i10 < fVarArr2.length) {
            f fVar = fVarArr2[i10];
            char c7 = fVar.f424a;
            float[] fArr3 = fVar.f425b;
            float f19 = fArr2[i9];
            float f20 = fArr2[1];
            float f21 = fArr2[2];
            float f22 = fArr2[3];
            float f23 = fArr2[4];
            float f24 = fArr2[5];
            switch (c7) {
                case 'A':
                case 'a':
                    i5 = 7;
                    break;
                case 'C':
                case 'c':
                    i5 = i8;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i5 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i5 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f23, f24);
                    f19 = f23;
                    f21 = f19;
                    f20 = f24;
                    f22 = f20;
                default:
                    i5 = 2;
                    break;
            }
            float f25 = f23;
            float f26 = f24;
            float f27 = f19;
            float f28 = f20;
            int i11 = i9;
            while (i11 < fArr3.length) {
                if (c7 != 'A') {
                    if (c7 != 'C') {
                        if (c7 == 'H') {
                            i6 = i11;
                            fArr = fArr3;
                            c2 = c7;
                            i7 = i10;
                            path.lineTo(fArr[i6], f28);
                            f27 = fArr[i6];
                        } else if (c7 == 'Q') {
                            i6 = i11;
                            fArr = fArr3;
                            c2 = c7;
                            i7 = i10;
                            int i12 = i6 + 1;
                            int i13 = i6 + 2;
                            int i14 = i6 + 3;
                            path.quadTo(fArr[i6], fArr[i12], fArr[i13], fArr[i14]);
                            f5 = fArr[i6];
                            f6 = fArr[i12];
                            f27 = fArr[i13];
                            f28 = fArr[i14];
                        } else if (c7 == 'V') {
                            i6 = i11;
                            fArr = fArr3;
                            c2 = c7;
                            i7 = i10;
                            path.lineTo(f27, fArr[i6]);
                            f28 = fArr[i6];
                        } else if (c7 != 'a') {
                            if (c7 != 'c') {
                                if (c7 == 'h') {
                                    i6 = i11;
                                    path.rLineTo(fArr3[i6], BitmapDescriptorFactory.HUE_RED);
                                    f27 += fArr3[i6];
                                } else if (c7 == 'q') {
                                    i6 = i11;
                                    float f29 = f28;
                                    float f30 = f27;
                                    int i15 = i6 + 1;
                                    int i16 = i6 + 2;
                                    int i17 = i6 + 3;
                                    path.rQuadTo(fArr3[i6], fArr3[i15], fArr3[i16], fArr3[i17]);
                                    float f31 = f30 + fArr3[i6];
                                    float f32 = fArr3[i15] + f29;
                                    float f33 = f30 + fArr3[i16];
                                    f28 = f29 + fArr3[i17];
                                    f22 = f32;
                                    f21 = f31;
                                    fArr = fArr3;
                                    c2 = c7;
                                    i7 = i10;
                                    f27 = f33;
                                } else if (c7 == 'v') {
                                    i6 = i11;
                                    path.rLineTo(BitmapDescriptorFactory.HUE_RED, fArr3[i6]);
                                    f28 += fArr3[i6];
                                } else if (c7 == 'L') {
                                    i6 = i11;
                                    int i18 = i6 + 1;
                                    path.lineTo(fArr3[i6], fArr3[i18]);
                                    f27 = fArr3[i6];
                                    f28 = fArr3[i18];
                                } else if (c7 == 'M') {
                                    i6 = i11;
                                    f27 = fArr3[i6];
                                    f28 = fArr3[i6 + 1];
                                    if (i6 > 0) {
                                        path.lineTo(f27, f28);
                                    } else {
                                        path.moveTo(f27, f28);
                                        f26 = f28;
                                        f25 = f27;
                                    }
                                } else if (c7 == 'S') {
                                    i6 = i11;
                                    float f34 = f28;
                                    float f35 = f27;
                                    if (c6 == 'c' || c6 == 's' || c6 == 'C' || c6 == 'S') {
                                        f13 = (f34 * 2.0f) - f22;
                                        f14 = (f35 * 2.0f) - f21;
                                    } else {
                                        f14 = f35;
                                        f13 = f34;
                                    }
                                    int i19 = i6 + 1;
                                    int i20 = i6 + 2;
                                    int i21 = i6 + 3;
                                    path.cubicTo(f14, f13, fArr3[i6], fArr3[i19], fArr3[i20], fArr3[i21]);
                                    float f36 = fArr3[i6];
                                    float f37 = fArr3[i19];
                                    f27 = fArr3[i20];
                                    f28 = fArr3[i21];
                                    f22 = f37;
                                    f21 = f36;
                                } else if (c7 == 'T') {
                                    i6 = i11;
                                    float f38 = f28;
                                    float f39 = f27;
                                    if (c6 == 'q' || c6 == 't' || c6 == 'Q' || c6 == 'T') {
                                        f8 = (f39 * 2.0f) - f21;
                                        f9 = (f38 * 2.0f) - f22;
                                    } else {
                                        f8 = f39;
                                        f9 = f38;
                                    }
                                    int i22 = i6 + 1;
                                    path.quadTo(f8, f9, fArr3[i6], fArr3[i22]);
                                    f10 = fArr3[i6];
                                    f12 = fArr3[i22];
                                    f22 = f9;
                                    f21 = f8;
                                    fArr = fArr3;
                                    c2 = c7;
                                    i7 = i10;
                                    f27 = f10;
                                    f28 = f12;
                                } else if (c7 == 'l') {
                                    i6 = i11;
                                    int i23 = i6 + 1;
                                    path.rLineTo(fArr3[i6], fArr3[i23]);
                                    f27 += fArr3[i6];
                                    f28 += fArr3[i23];
                                } else if (c7 == c5) {
                                    i6 = i11;
                                    float f40 = fArr3[i6];
                                    f27 += f40;
                                    float f41 = fArr3[i6 + 1];
                                    f28 += f41;
                                    if (i6 > 0) {
                                        path.rLineTo(f40, f41);
                                    } else {
                                        path.rMoveTo(f40, f41);
                                        f26 = f28;
                                        f25 = f27;
                                    }
                                } else if (c7 == 's') {
                                    if (c6 == 'c' || c6 == 's' || c6 == 'C' || c6 == 'S') {
                                        f15 = f28 - f22;
                                        f16 = f27 - f21;
                                    } else {
                                        f16 = BitmapDescriptorFactory.HUE_RED;
                                        f15 = BitmapDescriptorFactory.HUE_RED;
                                    }
                                    int i24 = i11 + 1;
                                    int i25 = i11 + 2;
                                    int i26 = i11 + 3;
                                    i6 = i11;
                                    f7 = f28;
                                    float f42 = f27;
                                    path.rCubicTo(f16, f15, fArr3[i11], fArr3[i24], fArr3[i25], fArr3[i26]);
                                    f8 = f42 + fArr3[i6];
                                    f9 = f7 + fArr3[i24];
                                    f10 = f42 + fArr3[i25];
                                    f11 = fArr3[i26];
                                } else if (c7 != 't') {
                                    i6 = i11;
                                } else {
                                    if (c6 == 'q' || c6 == 't' || c6 == 'Q' || c6 == 'T') {
                                        f17 = f27 - f21;
                                        f18 = f28 - f22;
                                    } else {
                                        f18 = BitmapDescriptorFactory.HUE_RED;
                                        f17 = BitmapDescriptorFactory.HUE_RED;
                                    }
                                    int i27 = i11 + 1;
                                    path.rQuadTo(f17, f18, fArr3[i11], fArr3[i27]);
                                    float f43 = f17 + f27;
                                    float f44 = f18 + f28;
                                    f27 += fArr3[i11];
                                    f28 += fArr3[i27];
                                    f22 = f44;
                                    i6 = i11;
                                    fArr = fArr3;
                                    c2 = c7;
                                    i7 = i10;
                                    f21 = f43;
                                }
                                fArr = fArr3;
                                c2 = c7;
                                i7 = i10;
                            } else {
                                i6 = i11;
                                f7 = f28;
                                float f45 = f27;
                                int i28 = i6 + 2;
                                int i29 = i6 + 3;
                                int i30 = i6 + 4;
                                int i31 = i6 + 5;
                                path.rCubicTo(fArr3[i6], fArr3[i6 + 1], fArr3[i28], fArr3[i29], fArr3[i30], fArr3[i31]);
                                f8 = f45 + fArr3[i28];
                                f9 = f7 + fArr3[i29];
                                f10 = f45 + fArr3[i30];
                                f11 = fArr3[i31];
                            }
                            f12 = f11 + f7;
                            f22 = f9;
                            f21 = f8;
                            fArr = fArr3;
                            c2 = c7;
                            i7 = i10;
                            f27 = f10;
                            f28 = f12;
                        } else {
                            i6 = i11;
                            float f46 = f28;
                            float f47 = f27;
                            int i32 = i6 + 5;
                            int i33 = i6 + 6;
                            fArr = fArr3;
                            c2 = c7;
                            i7 = i10;
                            a(path, f47, f46, fArr3[i32] + f47, fArr3[i33] + f46, fArr3[i6], fArr3[i6 + 1], fArr3[i6 + 2], fArr3[i6 + 3] != BitmapDescriptorFactory.HUE_RED, fArr3[i6 + 4] != BitmapDescriptorFactory.HUE_RED);
                            f27 = f47 + fArr[i32];
                            f28 = f46 + fArr[i33];
                        }
                        i11 = i6 + i5;
                        c6 = c2;
                        c7 = c6;
                        fArr3 = fArr;
                        i10 = i7;
                        c5 = 'm';
                        i9 = 0;
                    } else {
                        i6 = i11;
                        fArr = fArr3;
                        c2 = c7;
                        i7 = i10;
                        int i34 = i6 + 2;
                        int i35 = i6 + 3;
                        int i36 = i6 + 4;
                        int i37 = i6 + 5;
                        path.cubicTo(fArr[i6], fArr[i6 + 1], fArr[i34], fArr[i35], fArr[i36], fArr[i37]);
                        f27 = fArr[i36];
                        f28 = fArr[i37];
                        f5 = fArr[i34];
                        f6 = fArr[i35];
                    }
                    f21 = f5;
                    f22 = f6;
                    i11 = i6 + i5;
                    c6 = c2;
                    c7 = c6;
                    fArr3 = fArr;
                    i10 = i7;
                    c5 = 'm';
                    i9 = 0;
                } else {
                    i6 = i11;
                    fArr = fArr3;
                    c2 = c7;
                    i7 = i10;
                    int i38 = i6 + 5;
                    int i39 = i6 + 6;
                    a(path, f27, f28, fArr[i38], fArr[i39], fArr[i6], fArr[i6 + 1], fArr[i6 + 2], fArr[i6 + 3] != BitmapDescriptorFactory.HUE_RED, fArr[i6 + 4] != BitmapDescriptorFactory.HUE_RED);
                    f27 = fArr[i38];
                    f28 = fArr[i39];
                }
                f22 = f28;
                f21 = f27;
                i11 = i6 + i5;
                c6 = c2;
                c7 = c6;
                fArr3 = fArr;
                i10 = i7;
                c5 = 'm';
                i9 = 0;
            }
            int i40 = i10;
            int i41 = i9;
            fArr2[i41] = f27;
            fArr2[1] = f28;
            fArr2[2] = f21;
            fArr2[3] = f22;
            fArr2[4] = f25;
            fArr2[5] = f26;
            i10 = i40 + 1;
            i8 = 6;
            c5 = 'm';
            i9 = i41;
            c6 = fVarArr[i40].f424a;
            fVarArr2 = fVarArr;
        }
    }
}
