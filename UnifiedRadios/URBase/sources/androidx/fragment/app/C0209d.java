package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import g0.AbstractC0535a;

/* renamed from: androidx.fragment.app.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0209d extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f3783a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f3784b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f3785c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p0 f3786d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0212g f3787e;

    public C0209d(ViewGroup viewGroup, View view, boolean z4, p0 p0Var, C0212g c0212g) {
        this.f3783a = viewGroup;
        this.f3784b = view;
        this.f3785c = z4;
        this.f3786d = p0Var;
        this.f3787e = c0212g;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.f3783a;
        View view = this.f3784b;
        viewGroup.endViewTransition(view);
        if (this.f3785c) {
            AbstractC0535a.a(view, this.f3786d.f3858a);
        }
        this.f3787e.a();
    }
}
