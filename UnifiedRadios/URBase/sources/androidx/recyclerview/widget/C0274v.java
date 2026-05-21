package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import f2.AbstractC0487k;

/* renamed from: androidx.recyclerview.widget.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0274v extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4346a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4347b = false;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4348c;

    public C0274v(AbstractC0487k abstractC0487k) {
        this.f4348c = abstractC0487k;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f4346a) {
            case 0:
                this.f4347b = true;
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f4346a) {
            case 0:
                if (!this.f4347b) {
                    C0276x c0276x = (C0276x) this.f4348c;
                    if (((Float) c0276x.f4387z.getAnimatedValue()).floatValue() != BitmapDescriptorFactory.HUE_RED) {
                        c0276x.f4363A = 2;
                        c0276x.f4380s.invalidate();
                        break;
                    } else {
                        c0276x.f4363A = 0;
                        c0276x.f(0);
                        break;
                    }
                } else {
                    this.f4347b = false;
                    break;
                }
            default:
                AbstractC0487k abstractC0487k = (AbstractC0487k) this.f4348c;
                abstractC0487k.f6531r = 0;
                abstractC0487k.f6526l = null;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f4346a) {
            case 1:
                AbstractC0487k abstractC0487k = (AbstractC0487k) this.f4348c;
                abstractC0487k.f6532s.a(0, this.f4347b);
                abstractC0487k.f6531r = 2;
                abstractC0487k.f6526l = animator;
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public C0274v(C0276x c0276x) {
        this.f4348c = c0276x;
    }
}
