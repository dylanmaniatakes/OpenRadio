package i3;

import android.graphics.Matrix;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/* loaded from: classes.dex */
public final class x extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Matrix f7363a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f7364b;

    public x(Matrix matrix, ImageView imageView) {
        this.f7363a = matrix;
        this.f7364b = imageView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        Matrix matrix = this.f7363a;
        matrix.reset();
        this.f7364b.setImageMatrix(matrix);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f5, float f6) {
        Matrix matrix = this.f7363a;
        matrix.postTranslate(-f5, -f6);
        this.f7364b.setImageMatrix(matrix);
        return true;
    }
}
