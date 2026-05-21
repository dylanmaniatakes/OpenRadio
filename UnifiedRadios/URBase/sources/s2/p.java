package s2;

import O.H;
import O.J;
import O.Y;
import a.AbstractC0203a;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.textfield.TextInputLayout;
import com.unified.ur1.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import k.Z;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: A, reason: collision with root package name */
    public ColorStateList f9639A;

    /* renamed from: B, reason: collision with root package name */
    public Typeface f9640B;

    /* renamed from: a, reason: collision with root package name */
    public final int f9641a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9642b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9643c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f9644d;

    /* renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f9645e;

    /* renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f9646f;
    public final Context g;
    public final TextInputLayout h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f9647i;

    /* renamed from: j, reason: collision with root package name */
    public int f9648j;

    /* renamed from: k, reason: collision with root package name */
    public FrameLayout f9649k;

    /* renamed from: l, reason: collision with root package name */
    public Animator f9650l;

    /* renamed from: m, reason: collision with root package name */
    public final float f9651m;
    public int n;

    /* renamed from: o, reason: collision with root package name */
    public int f9652o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f9653p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f9654q;

    /* renamed from: r, reason: collision with root package name */
    public Z f9655r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f9656s;

    /* renamed from: t, reason: collision with root package name */
    public int f9657t;

    /* renamed from: u, reason: collision with root package name */
    public int f9658u;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f9659v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f9660w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f9661x;

    /* renamed from: y, reason: collision with root package name */
    public Z f9662y;

    /* renamed from: z, reason: collision with root package name */
    public int f9663z;

    public p(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.g = context;
        this.h = textInputLayout;
        this.f9651m = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        this.f9641a = A2.b.v(context, R.attr.motionDurationShort4, 217);
        this.f9642b = A2.b.v(context, R.attr.motionDurationMedium4, 167);
        this.f9643c = A2.b.v(context, R.attr.motionDurationShort4, 167);
        this.f9644d = A2.b.w(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, P1.a.f2067d);
        LinearInterpolator linearInterpolator = P1.a.f2064a;
        this.f9645e = A2.b.w(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, linearInterpolator);
        this.f9646f = A2.b.w(context, R.attr.motionEasingLinearInterpolator, linearInterpolator);
    }

    public final void a(TextView textView, int i5) {
        if (this.f9647i == null && this.f9649k == null) {
            Context context = this.g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.f9647i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.f9647i;
            TextInputLayout textInputLayout = this.h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.f9649k = new FrameLayout(context);
            this.f9647i.addView(this.f9649k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i5 == 0 || i5 == 1) {
            this.f9649k.setVisibility(0);
            this.f9649k.addView(textView);
        } else {
            this.f9647i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f9647i.setVisibility(0);
        this.f9648j++;
    }

    public final void b() {
        if (this.f9647i != null) {
            TextInputLayout textInputLayout = this.h;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.g;
                boolean zJ = AbstractC0409x1.j(context);
                LinearLayout linearLayout = this.f9647i;
                WeakHashMap weakHashMap = Y.f1904a;
                int iF = H.f(editText);
                if (zJ) {
                    iF = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
                if (zJ) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
                }
                int iE = H.e(editText);
                if (zJ) {
                    iE = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                H.k(linearLayout, iF, dimensionPixelSize, iE, 0);
            }
        }
    }

    public final void c() {
        Animator animator = this.f9650l;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z4, TextView textView, int i5, int i6, int i7) {
        if (textView == null || !z4) {
            return;
        }
        if (i5 == i7 || i5 == i6) {
            boolean z5 = i7 == i5;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z5 ? 1.0f : 0.0f);
            int i8 = this.f9643c;
            objectAnimatorOfFloat.setDuration(z5 ? this.f9642b : i8);
            objectAnimatorOfFloat.setInterpolator(z5 ? this.f9645e : this.f9646f);
            if (i5 == i7 && i6 != 0) {
                objectAnimatorOfFloat.setStartDelay(i8);
            }
            arrayList.add(objectAnimatorOfFloat);
            if (i7 != i5 || i6 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f9651m, BitmapDescriptorFactory.HUE_RED);
            objectAnimatorOfFloat2.setDuration(this.f9641a);
            objectAnimatorOfFloat2.setInterpolator(this.f9644d);
            objectAnimatorOfFloat2.setStartDelay(i8);
            arrayList.add(objectAnimatorOfFloat2);
        }
    }

    public final TextView e(int i5) {
        if (i5 == 1) {
            return this.f9655r;
        }
        if (i5 != 2) {
            return null;
        }
        return this.f9662y;
    }

    public final void f() {
        this.f9653p = null;
        c();
        if (this.n == 1) {
            if (!this.f9661x || TextUtils.isEmpty(this.f9660w)) {
                this.f9652o = 0;
            } else {
                this.f9652o = 2;
            }
        }
        i(this.n, this.f9652o, h(this.f9655r, ""));
    }

    public final void g(TextView textView, int i5) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.f9647i;
        if (linearLayout == null) {
            return;
        }
        if ((i5 == 0 || i5 == 1) && (frameLayout = this.f9649k) != null) {
            frameLayout.removeView(textView);
        } else {
            linearLayout.removeView(textView);
        }
        int i6 = this.f9648j - 1;
        this.f9648j = i6;
        LinearLayout linearLayout2 = this.f9647i;
        if (i6 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean h(TextView textView, CharSequence charSequence) {
        WeakHashMap weakHashMap = Y.f1904a;
        TextInputLayout textInputLayout = this.h;
        return J.c(textInputLayout) && textInputLayout.isEnabled() && !(this.f9652o == this.n && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    public final void i(int i5, int i6, boolean z4) {
        TextView textViewE;
        TextView textViewE2;
        if (i5 == i6) {
            return;
        }
        if (z4) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f9650l = animatorSet;
            ArrayList arrayList = new ArrayList();
            d(arrayList, this.f9661x, this.f9662y, 2, i5, i6);
            d(arrayList, this.f9654q, this.f9655r, 1, i5, i6);
            AbstractC0203a.k(animatorSet, arrayList);
            animatorSet.addListener(new n(this, i6, e(i5), i5, e(i6)));
            animatorSet.start();
        } else if (i5 != i6) {
            if (i6 != 0 && (textViewE2 = e(i6)) != null) {
                textViewE2.setVisibility(0);
                textViewE2.setAlpha(1.0f);
            }
            if (i5 != 0 && (textViewE = e(i5)) != null) {
                textViewE.setVisibility(4);
                if (i5 == 1) {
                    textViewE.setText((CharSequence) null);
                }
            }
            this.n = i6;
        }
        TextInputLayout textInputLayout = this.h;
        textInputLayout.r();
        textInputLayout.u(z4, false);
        textInputLayout.x();
    }
}
