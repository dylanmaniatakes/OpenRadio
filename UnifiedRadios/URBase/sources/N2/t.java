package n2;

import android.graphics.Matrix;
import android.graphics.Path;

/* loaded from: classes.dex */
public final class t extends u {

    /* renamed from: b, reason: collision with root package name */
    public float f8871b;

    /* renamed from: c, reason: collision with root package name */
    public float f8872c;

    @Override // n2.u
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f8873a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.f8871b, this.f8872c);
        path.transform(matrix);
    }
}
