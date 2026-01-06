package X1;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.G;
import androidx.recyclerview.widget.J;
import androidx.recyclerview.widget.h0;
import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: classes.dex */
public final class b extends G {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f2748q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f2749r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Object obj, Context context, int i5) {
        super(context);
        this.f2748q = i5;
        this.f2749r = obj;
    }

    @Override // androidx.recyclerview.widget.G
    public int b(View view, int i5) {
        switch (this.f2748q) {
            case 0:
                ((CarouselLayoutManager) this.f2749r).getClass();
                return 0;
            default:
                return super.b(view, i5);
        }
    }

    @Override // androidx.recyclerview.widget.G
    public int c(View view, int i5) {
        switch (this.f2748q) {
            case 0:
                ((CarouselLayoutManager) this.f2749r).getClass();
                return 0;
            default:
                return super.c(view, i5);
        }
    }

    @Override // androidx.recyclerview.widget.G
    public float d(DisplayMetrics displayMetrics) {
        switch (this.f2748q) {
            case 1:
                return 100.0f / displayMetrics.densityDpi;
            default:
                return super.d(displayMetrics);
        }
    }

    @Override // androidx.recyclerview.widget.G
    public int e(int i5) {
        switch (this.f2748q) {
            case 1:
                return Math.min(100, super.e(i5));
            default:
                return super.e(i5);
        }
    }

    @Override // androidx.recyclerview.widget.G
    public PointF f(int i5) {
        switch (this.f2748q) {
            case 0:
                return ((CarouselLayoutManager) this.f2749r).a(i5);
            default:
                return super.f(i5);
        }
    }

    @Override // androidx.recyclerview.widget.G
    public void h(View view, h0 h0Var) {
        switch (this.f2748q) {
            case 1:
                J j5 = (J) this.f2749r;
                int[] iArrB = j5.b(j5.f4042a.getLayoutManager(), view);
                int i5 = iArrB[0];
                int i6 = iArrB[1];
                int iCeil = (int) Math.ceil(e(Math.max(Math.abs(i5), Math.abs(i6))) / 0.3356d);
                if (iCeil > 0) {
                    DecelerateInterpolator decelerateInterpolator = this.f4028j;
                    h0Var.f4248c = i5;
                    h0Var.f4249d = i6;
                    h0Var.f4250e = iCeil;
                    h0Var.h = decelerateInterpolator;
                    h0Var.f4247b = true;
                    break;
                }
                break;
            default:
                super.h(view, h0Var);
                break;
        }
    }
}
