package w0;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public class x extends y1.f {

    /* renamed from: f, reason: collision with root package name */
    public static boolean f10118f = true;
    public static boolean g = true;
    public static boolean h = true;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f10119i = true;

    @Override // y1.f
    public void F(View view, int i5) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (Build.VERSION.SDK_INT == 28) {
            super.F(view, i5);
        } else if (f10119i) {
            try {
                view.setTransitionVisibility(i5);
            } catch (NoSuchMethodError unused) {
                f10119i = false;
            }
        }
    }

    public void O(View view, int i5, int i6, int i7, int i8) {
        if (h) {
            try {
                view.setLeftTopRightBottom(i5, i6, i7, i8);
            } catch (NoSuchMethodError unused) {
                h = false;
            }
        }
    }

    public void P(View view, Matrix matrix) {
        if (f10118f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f10118f = false;
            }
        }
    }

    public void Q(View view, Matrix matrix) {
        if (g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                g = false;
            }
        }
    }
}
