package w2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public final class b extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f10133a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f10134b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f10135c;

    public b(boolean z4, View view, View view2) {
        this.f10133a = z4;
        this.f10134b = view;
        this.f10135c = view2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.f10133a) {
            return;
        }
        this.f10134b.setVisibility(4);
        View view = this.f10135c;
        view.setAlpha(1.0f);
        view.setVisibility(0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        if (this.f10133a) {
            this.f10134b.setVisibility(0);
            View view = this.f10135c;
            view.setAlpha(BitmapDescriptorFactory.HUE_RED);
            view.setVisibility(4);
        }
    }
}
