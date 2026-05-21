package u0;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* loaded from: classes.dex */
public final class g extends Animation {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f9912j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f9913k;

    public /* synthetic */ g(SwipeRefreshLayout swipeRefreshLayout, int i5) {
        this.f9912j = i5;
        this.f9913k = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f5, Transformation transformation) {
        switch (this.f9912j) {
            case 0:
                this.f9913k.setAnimationProgress(f5);
                break;
            case 1:
                this.f9913k.setAnimationProgress(1.0f - f5);
                break;
            case 2:
                SwipeRefreshLayout swipeRefreshLayout = this.f9913k;
                swipeRefreshLayout.getClass();
                int iAbs = swipeRefreshLayout.f4439z - Math.abs(swipeRefreshLayout.f4438y);
                swipeRefreshLayout.setTargetOffsetTopAndBottom((swipeRefreshLayout.f4437x + ((int) ((iAbs - r1) * f5))) - swipeRefreshLayout.f4435v.getTop());
                e eVar = swipeRefreshLayout.f4409B;
                float f6 = 1.0f - f5;
                d dVar = eVar.f9906c;
                if (f6 != dVar.f9897p) {
                    dVar.f9897p = f6;
                }
                eVar.invalidateSelf();
                break;
            default:
                this.f9913k.k(f5);
                break;
        }
    }
}
