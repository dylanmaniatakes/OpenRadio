package s2;

import O.AbstractC0173l;
import O.H;
import O.J;
import O.Y;
import a.AbstractC0203a;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.unified.ur1.R;
import java.util.WeakHashMap;
import k.Z;

/* loaded from: classes.dex */
public final class t extends LinearLayout {

    /* renamed from: c, reason: collision with root package name */
    public final TextInputLayout f9674c;

    /* renamed from: d, reason: collision with root package name */
    public final Z f9675d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f9676e;

    /* renamed from: f, reason: collision with root package name */
    public final CheckableImageButton f9677f;
    public ColorStateList g;
    public PorterDuff.Mode h;

    /* renamed from: i, reason: collision with root package name */
    public int f9678i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView.ScaleType f9679j;

    /* renamed from: k, reason: collision with root package name */
    public View.OnLongClickListener f9680k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f9681l;

    public t(TextInputLayout textInputLayout, L0.m mVar) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f9674c = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f9677f = checkableImageButton;
        Z z4 = new Z(getContext(), null);
        this.f9675d = z4;
        if (AbstractC0409x1.j(getContext())) {
            AbstractC0173l.g((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        View.OnLongClickListener onLongClickListener = this.f9680k;
        checkableImageButton.setOnClickListener(null);
        AbstractC0203a.m(checkableImageButton, onLongClickListener);
        this.f9680k = null;
        checkableImageButton.setOnLongClickListener(null);
        AbstractC0203a.m(checkableImageButton, null);
        TypedArray typedArray = (TypedArray) mVar.f1557e;
        if (typedArray.hasValue(69)) {
            this.g = AbstractC0409x1.e(getContext(), mVar, 69);
        }
        if (typedArray.hasValue(70)) {
            this.h = g2.m.k(typedArray.getInt(70, -1), null);
        }
        if (typedArray.hasValue(66)) {
            b(mVar.g(66));
            if (typedArray.hasValue(65) && checkableImageButton.getContentDescription() != (text = typedArray.getText(65))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(64, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(67, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.f9678i) {
            this.f9678i = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(68)) {
            ImageView.ScaleType scaleTypeD = AbstractC0203a.d(typedArray.getInt(68, -1));
            this.f9679j = scaleTypeD;
            checkableImageButton.setScaleType(scaleTypeD);
        }
        z4.setVisibility(8);
        z4.setId(R.id.textinput_prefix_text);
        z4.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        WeakHashMap weakHashMap = Y.f1904a;
        J.f(z4, 1);
        z4.setTextAppearance(typedArray.getResourceId(60, 0));
        if (typedArray.hasValue(61)) {
            z4.setTextColor(mVar.f(61));
        }
        CharSequence text2 = typedArray.getText(59);
        this.f9676e = TextUtils.isEmpty(text2) ? null : text2;
        z4.setText(text2);
        e();
        addView(checkableImageButton);
        addView(z4);
    }

    public final int a() {
        int iB;
        CheckableImageButton checkableImageButton = this.f9677f;
        if (checkableImageButton.getVisibility() == 0) {
            iB = AbstractC0173l.b((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()) + checkableImageButton.getMeasuredWidth();
        } else {
            iB = 0;
        }
        WeakHashMap weakHashMap = Y.f1904a;
        return H.f(this.f9675d) + H.f(this) + iB;
    }

    public final void b(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f9677f;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.g;
            PorterDuff.Mode mode = this.h;
            TextInputLayout textInputLayout = this.f9674c;
            AbstractC0203a.a(textInputLayout, checkableImageButton, colorStateList, mode);
            c(true);
            AbstractC0203a.l(textInputLayout, checkableImageButton, this.g);
            return;
        }
        c(false);
        View.OnLongClickListener onLongClickListener = this.f9680k;
        checkableImageButton.setOnClickListener(null);
        AbstractC0203a.m(checkableImageButton, onLongClickListener);
        this.f9680k = null;
        checkableImageButton.setOnLongClickListener(null);
        AbstractC0203a.m(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void c(boolean z4) {
        CheckableImageButton checkableImageButton = this.f9677f;
        if ((checkableImageButton.getVisibility() == 0) != z4) {
            checkableImageButton.setVisibility(z4 ? 0 : 8);
            d();
            e();
        }
    }

    public final void d() throws Resources.NotFoundException {
        int iF;
        EditText editText = this.f9674c.f5447f;
        if (editText == null) {
            return;
        }
        if (this.f9677f.getVisibility() == 0) {
            iF = 0;
        } else {
            WeakHashMap weakHashMap = Y.f1904a;
            iF = H.f(editText);
        }
        int compoundPaddingTop = editText.getCompoundPaddingTop();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int compoundPaddingBottom = editText.getCompoundPaddingBottom();
        WeakHashMap weakHashMap2 = Y.f1904a;
        H.k(this.f9675d, iF, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
    }

    public final void e() {
        int i5 = (this.f9676e == null || this.f9681l) ? 8 : 0;
        setVisibility((this.f9677f.getVisibility() == 0 || i5 == 0) ? 0 : 8);
        this.f9675d.setVisibility(i5);
        this.f9674c.q();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i5, int i6) throws Resources.NotFoundException {
        super.onMeasure(i5, i6);
        d();
    }
}
