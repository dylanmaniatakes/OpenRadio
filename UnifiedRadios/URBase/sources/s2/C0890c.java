package s2;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.internal.CheckableImageButton;
import com.unified.ur1.R;
import i3.ViewOnFocusChangeListenerC0574c;

/* renamed from: s2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0890c extends m {

    /* renamed from: e, reason: collision with root package name */
    public final int f9581e;

    /* renamed from: f, reason: collision with root package name */
    public final int f9582f;
    public final TimeInterpolator g;
    public final TimeInterpolator h;

    /* renamed from: i, reason: collision with root package name */
    public EditText f9583i;

    /* renamed from: j, reason: collision with root package name */
    public final com.google.android.material.datepicker.l f9584j;

    /* renamed from: k, reason: collision with root package name */
    public final ViewOnFocusChangeListenerC0574c f9585k;

    /* renamed from: l, reason: collision with root package name */
    public AnimatorSet f9586l;

    /* renamed from: m, reason: collision with root package name */
    public ValueAnimator f9587m;

    public C0890c(l lVar) {
        super(lVar);
        this.f9584j = new com.google.android.material.datepicker.l(9, this);
        this.f9585k = new ViewOnFocusChangeListenerC0574c(1, this);
        this.f9581e = A2.b.v(lVar.getContext(), R.attr.motionDurationShort3, 100);
        this.f9582f = A2.b.v(lVar.getContext(), R.attr.motionDurationShort3, 150);
        this.g = A2.b.w(lVar.getContext(), R.attr.motionEasingLinearInterpolator, P1.a.f2064a);
        this.h = A2.b.w(lVar.getContext(), R.attr.motionEasingEmphasizedInterpolator, P1.a.f2067d);
    }

    @Override // s2.m
    public final void a() {
        if (this.f9630b.f9622r != null) {
            return;
        }
        t(u());
    }

    @Override // s2.m
    public final int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // s2.m
    public final int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // s2.m
    public final View.OnFocusChangeListener e() {
        return this.f9585k;
    }

    @Override // s2.m
    public final View.OnClickListener f() {
        return this.f9584j;
    }

    @Override // s2.m
    public final View.OnFocusChangeListener g() {
        return this.f9585k;
    }

    @Override // s2.m
    public final void m(EditText editText) {
        this.f9583i = editText;
        this.f9629a.setEndIconVisible(u());
    }

    @Override // s2.m
    public final void p(boolean z4) {
        if (this.f9630b.f9622r == null) {
            return;
        }
        t(z4);
    }

    @Override // s2.m
    public final void r() {
        final int i5 = 1;
        final int i6 = 0;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.h);
        valueAnimatorOfFloat.setDuration(this.f9582f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: s2.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C0890c f9578b;

            {
                this.f9578b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i5) {
                    case 0:
                        C0890c c0890c = this.f9578b;
                        c0890c.getClass();
                        c0890c.f9632d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        C0890c c0890c2 = this.f9578b;
                        c0890c2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = c0890c2.f9632d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(BitmapDescriptorFactory.HUE_RED, 1.0f);
        TimeInterpolator timeInterpolator = this.g;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        int i7 = this.f9581e;
        valueAnimatorOfFloat2.setDuration(i7);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: s2.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C0890c f9578b;

            {
                this.f9578b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i6) {
                    case 0:
                        C0890c c0890c = this.f9578b;
                        c0890c.getClass();
                        c0890c.f9632d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        C0890c c0890c2 = this.f9578b;
                        c0890c2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = c0890c2.f9632d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.f9586l = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.f9586l.addListener(new C0889b(this, i6));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, BitmapDescriptorFactory.HUE_RED);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(i7);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: s2.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C0890c f9578b;

            {
                this.f9578b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i6) {
                    case 0:
                        C0890c c0890c = this.f9578b;
                        c0890c.getClass();
                        c0890c.f9632d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        C0890c c0890c2 = this.f9578b;
                        c0890c2.getClass();
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = c0890c2.f9632d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        this.f9587m = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new C0889b(this, i5));
    }

    @Override // s2.m
    public final void s() {
        EditText editText = this.f9583i;
        if (editText != null) {
            editText.post(new m3.o(6, this));
        }
    }

    public final void t(boolean z4) {
        boolean z5 = this.f9630b.d() == z4;
        if (z4 && !this.f9586l.isRunning()) {
            this.f9587m.cancel();
            this.f9586l.start();
            if (z5) {
                this.f9586l.end();
                return;
            }
            return;
        }
        if (z4) {
            return;
        }
        this.f9586l.cancel();
        this.f9587m.start();
        if (z5) {
            this.f9587m.end();
        }
    }

    public final boolean u() {
        EditText editText = this.f9583i;
        return editText != null && (editText.hasFocus() || this.f9632d.hasFocus()) && this.f9583i.getText().length() > 0;
    }
}
