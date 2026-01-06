package androidx.recyclerview.widget;

import android.view.View;

/* renamed from: androidx.recyclerview.widget.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0271s {

    /* renamed from: a, reason: collision with root package name */
    public static final B0.a f4328a = new B0.a(3);

    public static int a(j0 j0Var, androidx.emoji2.text.f fVar, View view, View view2, X x4, boolean z4) {
        if (x4.v() == 0 || j0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z4) {
            return Math.abs(X.F(view) - X.F(view2)) + 1;
        }
        return Math.min(fVar.l(), fVar.b(view2) - fVar.e(view));
    }

    public static int b(j0 j0Var, androidx.emoji2.text.f fVar, View view, View view2, X x4, boolean z4, boolean z5) {
        if (x4.v() == 0 || j0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z5 ? Math.max(0, (j0Var.b() - Math.max(X.F(view), X.F(view2))) - 1) : Math.max(0, Math.min(X.F(view), X.F(view2)));
        if (z4) {
            return Math.round((iMax * (Math.abs(fVar.b(view2) - fVar.e(view)) / (Math.abs(X.F(view) - X.F(view2)) + 1))) + (fVar.k() - fVar.e(view)));
        }
        return iMax;
    }

    public static int c(j0 j0Var, androidx.emoji2.text.f fVar, View view, View view2, X x4, boolean z4) {
        if (x4.v() == 0 || j0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z4) {
            return j0Var.b();
        }
        return (int) (((fVar.b(view2) - fVar.e(view)) / (Math.abs(X.F(view) - X.F(view2)) + 1)) * j0Var.b());
    }
}
