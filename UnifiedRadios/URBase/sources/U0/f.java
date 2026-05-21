package u0;

import android.view.animation.Animation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* loaded from: classes.dex */
public final class f implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9910a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f9911b;

    public /* synthetic */ f(SwipeRefreshLayout swipeRefreshLayout, int i5) {
        this.f9910a = i5;
        this.f9911b = swipeRefreshLayout;
    }

    private final void a(Animation animation) {
    }

    private final void b(Animation animation) {
    }

    private final void c(Animation animation) {
    }

    private final void d(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        j jVar;
        switch (this.f9910a) {
            case 0:
                SwipeRefreshLayout swipeRefreshLayout = this.f9911b;
                if (!swipeRefreshLayout.f4421e) {
                    swipeRefreshLayout.l();
                    break;
                } else {
                    swipeRefreshLayout.f4409B.setAlpha(255);
                    swipeRefreshLayout.f4409B.start();
                    if (swipeRefreshLayout.f4414G && (jVar = swipeRefreshLayout.f4420d) != null) {
                        jVar.g();
                    }
                    swipeRefreshLayout.f4429p = swipeRefreshLayout.f4435v.getTop();
                    break;
                }
                break;
            default:
                SwipeRefreshLayout swipeRefreshLayout2 = this.f9911b;
                swipeRefreshLayout2.getClass();
                g gVar = new g(swipeRefreshLayout2, 1);
                swipeRefreshLayout2.f4411D = gVar;
                gVar.setDuration(150L);
                C0905a c0905a = swipeRefreshLayout2.f4435v;
                c0905a.f9879c = null;
                c0905a.clearAnimation();
                swipeRefreshLayout2.f4435v.startAnimation(swipeRefreshLayout2.f4411D);
                break;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i5 = this.f9910a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        int i5 = this.f9910a;
    }
}
