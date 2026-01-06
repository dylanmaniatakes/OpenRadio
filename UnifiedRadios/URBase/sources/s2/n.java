package s2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import k.Z;

/* loaded from: classes.dex */
public final class n extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9633a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f9634b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9635c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TextView f9636d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ p f9637e;

    public n(p pVar, int i5, TextView textView, int i6, TextView textView2) {
        this.f9637e = pVar;
        this.f9633a = i5;
        this.f9634b = textView;
        this.f9635c = i6;
        this.f9636d = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        Z z4;
        int i5 = this.f9633a;
        p pVar = this.f9637e;
        pVar.n = i5;
        pVar.f9650l = null;
        TextView textView = this.f9634b;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.f9635c == 1 && (z4 = pVar.f9655r) != null) {
                z4.setText((CharSequence) null);
            }
        }
        TextView textView2 = this.f9636d;
        if (textView2 != null) {
            textView2.setTranslationY(BitmapDescriptorFactory.HUE_RED);
            textView2.setAlpha(1.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        TextView textView = this.f9636d;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setAlpha(BitmapDescriptorFactory.HUE_RED);
        }
    }
}
