package w0;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes.dex */
public final class y extends x {
    @Override // y1.f
    public final void E(View view, float f5) {
        view.setTransitionAlpha(f5);
    }

    @Override // w0.x, y1.f
    public final void F(View view, int i5) {
        view.setTransitionVisibility(i5);
    }

    @Override // w0.x
    public final void O(View view, int i5, int i6, int i7, int i8) {
        view.setLeftTopRightBottom(i5, i6, i7, i8);
    }

    @Override // w0.x
    public final void P(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // w0.x
    public final void Q(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    @Override // y1.f
    public final float o(View view) {
        return view.getTransitionAlpha();
    }
}
