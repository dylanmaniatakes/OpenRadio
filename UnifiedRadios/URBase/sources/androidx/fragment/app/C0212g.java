package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.unified.ur1.R;

/* renamed from: androidx.fragment.app.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0212g extends AbstractC0213h {

    /* renamed from: c, reason: collision with root package name */
    public boolean f3803c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3804d;

    /* renamed from: e, reason: collision with root package name */
    public A f3805e;

    public final A c(Context context) throws Resources.NotFoundException {
        Animation animationLoadAnimation;
        A a2;
        if (this.f3804d) {
            return this.f3805e;
        }
        p0 p0Var = this.f3808a;
        Fragment fragment = p0Var.f3860c;
        boolean z4 = p0Var.f3858a == 2;
        boolean z5 = this.f3803c;
        int nextTransition = fragment.getNextTransition();
        int popEnterAnim = z5 ? z4 ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z4 ? fragment.getEnterAnim() : fragment.getExitAnim();
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        A a3 = null;
        if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            fragment.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
            Animation animationOnCreateAnimation = fragment.onCreateAnimation(nextTransition, z4, popEnterAnim);
            if (animationOnCreateAnimation != null) {
                a3 = new A(animationOnCreateAnimation);
            } else {
                Animator animatorOnCreateAnimator = fragment.onCreateAnimator(nextTransition, z4, popEnterAnim);
                if (animatorOnCreateAnimator != null) {
                    a3 = new A(animatorOnCreateAnimator);
                } else {
                    if (popEnterAnim == 0 && nextTransition != 0) {
                        popEnterAnim = nextTransition != 4097 ? nextTransition != 4099 ? nextTransition != 8194 ? -1 : z4 ? R.animator.fragment_close_enter : R.animator.fragment_close_exit : z4 ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit : z4 ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
                    }
                    if (popEnterAnim != 0) {
                        boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(popEnterAnim));
                        if (zEquals) {
                            try {
                                animationLoadAnimation = AnimationUtils.loadAnimation(context, popEnterAnim);
                            } catch (Resources.NotFoundException e5) {
                                throw e5;
                            } catch (RuntimeException unused) {
                            }
                            if (animationLoadAnimation != null) {
                                a2 = new A(animationLoadAnimation);
                                a3 = a2;
                            }
                        } else {
                            try {
                                Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, popEnterAnim);
                                if (animatorLoadAnimator != null) {
                                    a2 = new A(animatorLoadAnimator);
                                    a3 = a2;
                                }
                            } catch (RuntimeException e6) {
                                if (zEquals) {
                                    throw e6;
                                }
                                Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, popEnterAnim);
                                if (animationLoadAnimation2 != null) {
                                    a3 = new A(animationLoadAnimation2);
                                }
                            }
                        }
                    }
                }
            }
        }
        this.f3805e = a3;
        this.f3804d = true;
        return a3;
    }
}
