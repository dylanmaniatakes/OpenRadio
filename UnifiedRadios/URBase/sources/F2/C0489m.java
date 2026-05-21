package f2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.Property;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.unified.ur1.R;
import java.util.ArrayList;
import l2.AbstractC0742a;

/* renamed from: f2.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0489m extends AbstractC0487k {

    /* renamed from: K, reason: collision with root package name */
    public StateListAnimator f6539K;

    @Override // f2.AbstractC0487k
    public final float e() {
        return this.f6532s.getElevation();
    }

    @Override // f2.AbstractC0487k
    public final void f(Rect rect) {
        if (((FloatingActionButton) this.f6533t.f1554d).f5367m) {
            super.f(rect);
            return;
        }
        if (this.f6522f) {
            FloatingActionButton floatingActionButton = this.f6532s;
            int sizeDimension = floatingActionButton.getSizeDimension();
            int i5 = this.f6525k;
            if (sizeDimension < i5) {
                int sizeDimension2 = (i5 - floatingActionButton.getSizeDimension()) / 2;
                rect.set(sizeDimension2, sizeDimension2, sizeDimension2, sizeDimension2);
                return;
            }
        }
        rect.set(0, 0, 0, 0);
    }

    @Override // f2.AbstractC0487k
    public final void g(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i5) {
        Drawable layerDrawable;
        n2.h hVarS = s();
        this.f6518b = hVarS;
        hVarS.setTintList(colorStateList);
        if (mode != null) {
            this.f6518b.setTintMode(mode);
        }
        n2.h hVar = this.f6518b;
        FloatingActionButton floatingActionButton = this.f6532s;
        hVar.j(floatingActionButton.getContext());
        if (i5 > 0) {
            Context context = floatingActionButton.getContext();
            n2.m mVar = this.f6517a;
            mVar.getClass();
            C0478b c0478b = new C0478b(mVar);
            int iA = C.d.a(context, R.color.design_fab_stroke_top_outer_color);
            int iA2 = C.d.a(context, R.color.design_fab_stroke_top_inner_color);
            int iA3 = C.d.a(context, R.color.design_fab_stroke_end_inner_color);
            int iA4 = C.d.a(context, R.color.design_fab_stroke_end_outer_color);
            c0478b.f6478i = iA;
            c0478b.f6479j = iA2;
            c0478b.f6480k = iA3;
            c0478b.f6481l = iA4;
            float f5 = i5;
            if (c0478b.h != f5) {
                c0478b.h = f5;
                c0478b.f6473b.setStrokeWidth(f5 * 1.3333f);
                c0478b.n = true;
                c0478b.invalidateSelf();
            }
            if (colorStateList != null) {
                c0478b.f6482m = colorStateList.getColorForState(c0478b.getState(), c0478b.f6482m);
            }
            c0478b.f6484p = colorStateList;
            c0478b.n = true;
            c0478b.invalidateSelf();
            this.f6520d = c0478b;
            C0478b c0478b2 = this.f6520d;
            c0478b2.getClass();
            n2.h hVar2 = this.f6518b;
            hVar2.getClass();
            layerDrawable = new LayerDrawable(new Drawable[]{c0478b2, hVar2});
        } else {
            this.f6520d = null;
            layerDrawable = this.f6518b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(AbstractC0742a.b(colorStateList2), layerDrawable, null);
        this.f6519c = rippleDrawable;
        this.f6521e = rippleDrawable;
    }

    @Override // f2.AbstractC0487k
    public final void h() {
    }

    @Override // f2.AbstractC0487k
    public final void i() {
        q();
    }

    @Override // f2.AbstractC0487k
    public final void j(int[] iArr) {
    }

    @Override // f2.AbstractC0487k
    public final void k(float f5, float f6, float f7) {
        FloatingActionButton floatingActionButton = this.f6532s;
        if (floatingActionButton.getStateListAnimator() == this.f6539K) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(AbstractC0487k.f6511E, r(f5, f7));
            stateListAnimator.addState(AbstractC0487k.f6512F, r(f5, f6));
            stateListAnimator.addState(AbstractC0487k.f6513G, r(f5, f6));
            stateListAnimator.addState(AbstractC0487k.f6514H, r(f5, f6));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, "elevation", f5).setDuration(0L));
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, BitmapDescriptorFactory.HUE_RED).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(AbstractC0487k.f6516z);
            stateListAnimator.addState(AbstractC0487k.I, animatorSet);
            stateListAnimator.addState(AbstractC0487k.f6515J, r(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED));
            this.f6539K = stateListAnimator;
            floatingActionButton.setStateListAnimator(stateListAnimator);
        }
        if (o()) {
            q();
        }
    }

    @Override // f2.AbstractC0487k
    public final void m(ColorStateList colorStateList) {
        Drawable drawable = this.f6519c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(AbstractC0742a.b(colorStateList));
        } else {
            super.m(colorStateList);
        }
    }

    @Override // f2.AbstractC0487k
    public final boolean o() {
        return ((FloatingActionButton) this.f6533t.f1554d).f5367m || (this.f6522f && this.f6532s.getSizeDimension() < this.f6525k);
    }

    @Override // f2.AbstractC0487k
    public final void p() {
    }

    public final AnimatorSet r(float f5, float f6) {
        AnimatorSet animatorSet = new AnimatorSet();
        float[] fArr = {f5};
        FloatingActionButton floatingActionButton = this.f6532s;
        animatorSet.play(ObjectAnimator.ofFloat(floatingActionButton, "elevation", fArr).setDuration(0L)).with(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f6).setDuration(100L));
        animatorSet.setInterpolator(AbstractC0487k.f6516z);
        return animatorSet;
    }

    public final n2.h s() {
        n2.m mVar = this.f6517a;
        mVar.getClass();
        return new C0488l(mVar);
    }
}
