package i3;

import android.graphics.Matrix;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

/* loaded from: classes.dex */
public final class w extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Matrix f7360a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float[] f7361b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ImageView f7362c;

    public w(Matrix matrix, float[] fArr, ImageView imageView) {
        this.f7360a = matrix;
        this.f7361b = fArr;
        this.f7362c = imageView;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        float focusX = scaleGestureDetector.getFocusX();
        float focusY = scaleGestureDetector.getFocusY();
        Matrix matrix = this.f7360a;
        matrix.postScale(scaleFactor, scaleFactor, focusX, focusY);
        float[] fArr = this.f7361b;
        matrix.getValues(fArr);
        float f5 = fArr[0];
        if (f5 < 0.5f) {
            matrix.setScale(0.5f, 0.5f);
        } else if (f5 > 5.0f) {
            matrix.setScale(5.0f, 5.0f);
        }
        this.f7362c.setImageMatrix(matrix);
        return true;
    }
}
