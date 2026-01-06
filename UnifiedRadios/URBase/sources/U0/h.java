package u0;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* loaded from: classes.dex */
public final class h extends Animation {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f9914j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f9915k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f9916l;

    public h(SwipeRefreshLayout swipeRefreshLayout, int i5, int i6) {
        this.f9916l = swipeRefreshLayout;
        this.f9914j = i5;
        this.f9915k = i6;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f5, Transformation transformation) {
        this.f9916l.f4409B.setAlpha((int) (((this.f9915k - r0) * f5) + this.f9914j));
    }
}
