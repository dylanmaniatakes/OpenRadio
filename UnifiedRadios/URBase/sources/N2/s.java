package n2;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: classes.dex */
public final class s extends u {
    public static final RectF h = new RectF();

    /* renamed from: b, reason: collision with root package name */
    public final float f8866b;

    /* renamed from: c, reason: collision with root package name */
    public final float f8867c;

    /* renamed from: d, reason: collision with root package name */
    public final float f8868d;

    /* renamed from: e, reason: collision with root package name */
    public final float f8869e;

    /* renamed from: f, reason: collision with root package name */
    public float f8870f;
    public float g;

    public s(float f5, float f6, float f7, float f8) {
        this.f8866b = f5;
        this.f8867c = f6;
        this.f8868d = f7;
        this.f8869e = f8;
    }

    @Override // n2.u
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f8873a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        RectF rectF = h;
        rectF.set(this.f8866b, this.f8867c, this.f8868d, this.f8869e);
        path.arcTo(rectF, this.f8870f, this.g, false);
        path.transform(matrix);
    }
}
