package f2;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* renamed from: f2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0481e implements TypeEvaluator {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f6488a = new float[9];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f6489b = new float[9];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f6490c = new Matrix();

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractC0487k f6491d;

    public C0481e(AbstractC0487k abstractC0487k) {
        this.f6491d = abstractC0487k;
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f5, Object obj, Object obj2) {
        this.f6491d.f6529p = f5;
        float[] fArr = this.f6488a;
        ((Matrix) obj).getValues(fArr);
        float[] fArr2 = this.f6489b;
        ((Matrix) obj2).getValues(fArr2);
        for (int i5 = 0; i5 < 9; i5++) {
            float f6 = fArr2[i5];
            float f7 = fArr[i5];
            fArr2[i5] = ((f6 - f7) * f5) + f7;
        }
        Matrix matrix = this.f6490c;
        matrix.setValues(fArr2);
        return matrix;
    }
}
