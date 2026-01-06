package q2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.view.ViewPropertyAnimator;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.snackbar.SnackbarContentLayout;

/* renamed from: q2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0868a extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9432a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f9433b;

    public /* synthetic */ C0868a(i iVar, int i5) {
        this.f9432a = i5;
        this.f9433b = iVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f9432a) {
            case 0:
                this.f9433b.c();
                break;
            case 1:
                this.f9433b.d();
                break;
            case 2:
                this.f9433b.c();
                break;
            default:
                this.f9433b.d();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f9432a) {
            case 1:
                i iVar = this.f9433b;
                j jVar = iVar.f9463j;
                int i5 = iVar.f9458c;
                int i6 = iVar.f9456a;
                int i7 = i5 - i6;
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) jVar;
                snackbarContentLayout.f5408c.setAlpha(BitmapDescriptorFactory.HUE_RED);
                long j5 = i6;
                ViewPropertyAnimator duration = snackbarContentLayout.f5408c.animate().alpha(1.0f).setDuration(j5);
                TimeInterpolator timeInterpolator = snackbarContentLayout.f5410e;
                long j6 = i7;
                duration.setInterpolator(timeInterpolator).setStartDelay(j6).start();
                if (snackbarContentLayout.f5409d.getVisibility() == 0) {
                    snackbarContentLayout.f5409d.setAlpha(BitmapDescriptorFactory.HUE_RED);
                    snackbarContentLayout.f5409d.animate().alpha(1.0f).setDuration(j5).setInterpolator(timeInterpolator).setStartDelay(j6).start();
                    break;
                }
                break;
            case 2:
                i iVar2 = this.f9433b;
                j jVar2 = iVar2.f9463j;
                int i8 = iVar2.f9457b;
                SnackbarContentLayout snackbarContentLayout2 = (SnackbarContentLayout) jVar2;
                snackbarContentLayout2.f5408c.setAlpha(1.0f);
                long j7 = i8;
                ViewPropertyAnimator duration2 = snackbarContentLayout2.f5408c.animate().alpha(BitmapDescriptorFactory.HUE_RED).setDuration(j7);
                TimeInterpolator timeInterpolator2 = snackbarContentLayout2.f5410e;
                long j8 = 0;
                duration2.setInterpolator(timeInterpolator2).setStartDelay(j8).start();
                if (snackbarContentLayout2.f5409d.getVisibility() == 0) {
                    snackbarContentLayout2.f5409d.setAlpha(1.0f);
                    snackbarContentLayout2.f5409d.animate().alpha(BitmapDescriptorFactory.HUE_RED).setDuration(j7).setInterpolator(timeInterpolator2).setStartDelay(j8).start();
                    break;
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public /* synthetic */ C0868a(i iVar, int i5, int i6) {
        this.f9432a = i6;
        this.f9433b = iVar;
    }
}
