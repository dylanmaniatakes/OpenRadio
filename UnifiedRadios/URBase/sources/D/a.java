package D;

import android.graphics.Color;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final float f190a;

    /* renamed from: b, reason: collision with root package name */
    public final float f191b;

    /* renamed from: c, reason: collision with root package name */
    public final float f192c;

    /* renamed from: d, reason: collision with root package name */
    public final float f193d;

    /* renamed from: e, reason: collision with root package name */
    public final float f194e;

    /* renamed from: f, reason: collision with root package name */
    public final float f195f;

    public a(float f5, float f6, float f7, float f8, float f9, float f10) {
        this.f190a = f5;
        this.f191b = f6;
        this.f192c = f7;
        this.f193d = f8;
        this.f194e = f9;
        this.f195f = f10;
    }

    public static a a(int i5) {
        q qVar = q.f228k;
        float fE = b.e(Color.red(i5));
        float fE2 = b.e(Color.green(i5));
        float fE3 = b.e(Color.blue(i5));
        float[][] fArr = b.f199d;
        float[] fArr2 = fArr[0];
        float f5 = (fArr2[2] * fE3) + (fArr2[1] * fE2) + (fArr2[0] * fE);
        float[] fArr3 = fArr[1];
        float f6 = (fArr3[2] * fE3) + (fArr3[1] * fE2) + (fArr3[0] * fE);
        float[] fArr4 = fArr[2];
        float[] fArr5 = {f5, f6, (fE3 * fArr4[2]) + (fE2 * fArr4[1]) + (fE * fArr4[0])};
        float[][] fArr6 = b.f196a;
        float f7 = fArr5[0];
        float[] fArr7 = fArr6[0];
        float f8 = fArr7[0] * f7;
        float f9 = fArr5[1];
        float f10 = (fArr7[1] * f9) + f8;
        float f11 = fArr5[2];
        float f12 = (fArr7[2] * f11) + f10;
        float[] fArr8 = fArr6[1];
        float f13 = (fArr8[2] * f11) + (fArr8[1] * f9) + (fArr8[0] * f7);
        float[] fArr9 = fArr6[2];
        float f14 = (f11 * fArr9[2]) + (f9 * fArr9[1]) + (f7 * fArr9[0]);
        float[] fArr10 = qVar.g;
        float f15 = fArr10[0] * f12;
        float f16 = fArr10[1] * f13;
        float f17 = fArr10[2] * f14;
        float fAbs = Math.abs(f15);
        float f18 = qVar.h;
        float fPow = (float) Math.pow((fAbs * f18) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow((Math.abs(f16) * f18) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow((Math.abs(f17) * f18) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f15) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f16) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f17) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d5 = fSignum3;
        float f19 = ((float) (((fSignum2 * (-12.0d)) + (fSignum * 11.0d)) + d5)) / 11.0f;
        float f20 = ((float) ((fSignum + fSignum2) - (d5 * 2.0d))) / 9.0f;
        float f21 = fSignum2 * 20.0f;
        float f22 = ((21.0f * fSignum3) + ((fSignum * 20.0f) + f21)) / 20.0f;
        float f23 = (((fSignum * 40.0f) + f21) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f20, f19)) * 180.0f) / 3.1415927f;
        if (fAtan2 < BitmapDescriptorFactory.HUE_RED) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f24 = fAtan2;
        float f25 = (3.1415927f * f24) / 180.0f;
        float f26 = f23 * qVar.f230b;
        float f27 = qVar.f229a;
        float f28 = qVar.f232d;
        float fPow4 = ((float) Math.pow(f26 / f27, qVar.f236j * f28)) * 100.0f;
        Math.sqrt(fPow4 / 100.0f);
        float f29 = f27 + 4.0f;
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, qVar.f234f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) f24) < 20.14d ? 360.0f + f24 : f24) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * qVar.f233e) * qVar.f231c) * ((float) Math.sqrt((f20 * f20) + (f19 * f19)))) / (f22 + 0.305f), 0.9d)) * ((float) Math.sqrt(fPow4 / 100.0d));
        float f30 = qVar.f235i * fPow5;
        Math.sqrt((r4 * f28) / f29);
        float f31 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((f30 * 0.0228f) + 1.0f)) * 43.85965f;
        double d6 = f25;
        return new a(f24, fPow5, fPow4, f31, fLog * ((float) Math.cos(d6)), fLog * ((float) Math.sin(d6)));
    }

    public static a b(float f5, float f6, float f7) {
        q qVar = q.f228k;
        float f8 = qVar.f232d;
        Math.sqrt(f5 / 100.0d);
        float f9 = qVar.f229a + 4.0f;
        float f10 = qVar.f235i * f6;
        Math.sqrt(((f6 / ((float) Math.sqrt(r1))) * qVar.f232d) / f9);
        float f11 = (1.7f * f5) / ((0.007f * f5) + 1.0f);
        float fLog = ((float) Math.log((f10 * 0.0228d) + 1.0d)) * 43.85965f;
        double d5 = (3.1415927f * f7) / 180.0f;
        return new a(f7, f6, f5, f11, fLog * ((float) Math.cos(d5)), fLog * ((float) Math.sin(d5)));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(D.q r17) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D.a.c(D.q):int");
    }
}
