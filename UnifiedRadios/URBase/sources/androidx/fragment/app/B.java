package androidx.fragment.app;

import O.ViewTreeObserverOnPreDrawListenerC0186z;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* loaded from: classes.dex */
public final class B extends AnimationSet implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final ViewGroup f3646j;

    /* renamed from: k, reason: collision with root package name */
    public final View f3647k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3648l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3649m;
    public boolean n;

    public B(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.n = true;
        this.f3646j = viewGroup;
        this.f3647k = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j5, Transformation transformation) {
        this.n = true;
        if (this.f3648l) {
            return !this.f3649m;
        }
        if (!super.getTransformation(j5, transformation)) {
            this.f3648l = true;
            ViewTreeObserverOnPreDrawListenerC0186z.a(this.f3646j, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z4 = this.f3648l;
        ViewGroup viewGroup = this.f3646j;
        if (z4 || !this.n) {
            viewGroup.endViewTransition(this.f3647k);
            this.f3649m = true;
        } else {
            this.n = false;
            viewGroup.post(this);
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j5, Transformation transformation, float f5) {
        this.n = true;
        if (this.f3648l) {
            return !this.f3649m;
        }
        if (!super.getTransformation(j5, transformation, f5)) {
            this.f3648l = true;
            ViewTreeObserverOnPreDrawListenerC0186z.a(this.f3646j, this);
        }
        return true;
    }
}
