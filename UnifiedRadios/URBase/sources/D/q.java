package D;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: k, reason: collision with root package name */
    public static final q f228k;

    /* renamed from: a, reason: collision with root package name */
    public final float f229a;

    /* renamed from: b, reason: collision with root package name */
    public final float f230b;

    /* renamed from: c, reason: collision with root package name */
    public final float f231c;

    /* renamed from: d, reason: collision with root package name */
    public final float f232d;

    /* renamed from: e, reason: collision with root package name */
    public final float f233e;

    /* renamed from: f, reason: collision with root package name */
    public final float f234f;
    public final float[] g;
    public final float h;

    /* renamed from: i, reason: collision with root package name */
    public final float f235i;

    /* renamed from: j, reason: collision with root package name */
    public final float f236j;

    static {
        float[] fArr = b.f198c;
        float fL = (float) ((b.l() * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = b.f196a;
        float f5 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f6 = fArr3[0] * f5;
        float f7 = fArr[1];
        float f8 = (fArr3[1] * f7) + f6;
        float f9 = fArr[2];
        float f10 = (fArr3[2] * f9) + f8;
        float[] fArr4 = fArr2[1];
        float f11 = (fArr4[2] * f9) + (fArr4[1] * f7) + (fArr4[0] * f5);
        float[] fArr5 = fArr2[2];
        float f12 = (f9 * fArr5[2]) + (f7 * fArr5[1]) + (f5 * fArr5[0]);
        float f13 = ((double) 1.0f) >= 0.9d ? 0.69f : 0.655f;
        float fExp = (1.0f - (((float) Math.exp(((-fL) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d5 = fExp;
        if (d5 > 1.0d) {
            fExp = 1.0f;
        } else if (d5 < 0.0d) {
            fExp = BitmapDescriptorFactory.HUE_RED;
        }
        float[] fArr6 = {(((100.0f / f10) * fExp) + 1.0f) - fExp, (((100.0f / f11) * fExp) + 1.0f) - fExp, (((100.0f / f12) * fExp) + 1.0f) - fExp};
        float f14 = 1.0f / ((5.0f * fL) + 1.0f);
        float f15 = f14 * f14 * f14 * f14;
        float f16 = 1.0f - f15;
        float fCbrt = (0.1f * f16 * f16 * ((float) Math.cbrt(fL * 5.0d))) + (f15 * fL);
        float fL2 = b.l() / fArr[1];
        double d6 = fL2;
        float fSqrt = ((float) Math.sqrt(d6)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d6, 0.2d));
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * fCbrt) * f10) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * fCbrt) * f11) / 100.0d, 0.42d), (float) Math.pow(((fArr6[2] * fCbrt) * f12) / 100.0d, 0.42d)};
        float f17 = fArr7[0];
        float f18 = (f17 * 400.0f) / (f17 + 27.13f);
        float f19 = fArr7[1];
        float f20 = (f19 * 400.0f) / (f19 + 27.13f);
        float f21 = fArr7[2];
        float[] fArr8 = {f18, f20, (400.0f * f21) / (f21 + 27.13f)};
        f228k = new q(fL2, ((fArr8[2] * 0.05f) + (fArr8[0] * 2.0f) + fArr8[1]) * fPow, fPow, fPow, f13, 1.0f, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public q(float f5, float f6, float f7, float f8, float f9, float f10, float[] fArr, float f11, float f12, float f13) {
        this.f234f = f5;
        this.f229a = f6;
        this.f230b = f7;
        this.f231c = f8;
        this.f232d = f9;
        this.f233e = f10;
        this.g = fArr;
        this.h = f11;
        this.f235i = f12;
        this.f236j = f13;
    }
}
