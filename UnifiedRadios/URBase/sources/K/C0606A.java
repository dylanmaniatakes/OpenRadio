package k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.recyclerview.widget.C0255b;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.unified.ur1.R;
import w1.AbstractC0930a;

/* renamed from: k.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0606A extends RadioButton implements S.t {

    /* renamed from: c, reason: collision with root package name */
    public final C0651q f7630c;

    /* renamed from: d, reason: collision with root package name */
    public final C0255b f7631d;

    /* renamed from: e, reason: collision with root package name */
    public final X f7632e;

    /* renamed from: f, reason: collision with root package name */
    public C0658u f7633f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0606A(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.radioButtonStyle);
        V0.a(context);
        U0.a(this, getContext());
        C0651q c0651q = new C0651q(this);
        this.f7630c = c0651q;
        c0651q.c(attributeSet, R.attr.radioButtonStyle);
        C0255b c0255b = new C0255b(this);
        this.f7631d = c0255b;
        c0255b.k(attributeSet, R.attr.radioButtonStyle);
        X x4 = new X(this);
        this.f7632e = x4;
        x4.f(attributeSet, R.attr.radioButtonStyle);
        getEmojiTextViewHelper().a(attributeSet, R.attr.radioButtonStyle);
    }

    private C0658u getEmojiTextViewHelper() {
        if (this.f7633f == null) {
            this.f7633f = new C0658u(this);
        }
        return this.f7633f;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0255b c0255b = this.f7631d;
        if (c0255b != null) {
            c0255b.a();
        }
        X x4 = this.f7632e;
        if (x4 != null) {
            x4.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C0651q c0651q = this.f7630c;
        if (c0651q != null) {
            c0651q.getClass();
        }
        return compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0255b c0255b = this.f7631d;
        if (c0255b != null) {
            return c0255b.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0255b c0255b = this.f7631d;
        if (c0255b != null) {
            return c0255b.i();
        }
        return null;
    }

    @Override // S.t
    public ColorStateList getSupportButtonTintList() {
        C0651q c0651q = this.f7630c;
        if (c0651q != null) {
            return c0651q.f7845a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0651q c0651q = this.f7630c;
        if (c0651q != null) {
            return c0651q.f7846b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f7632e.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f7632e.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().b(z4);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0255b c0255b = this.f7631d;
        if (c0255b != null) {
            c0255b.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        C0255b c0255b = this.f7631d;
        if (c0255b != null) {
            c0255b.n(i5);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0651q c0651q = this.f7630c;
        if (c0651q != null) {
            if (c0651q.f7849e) {
                c0651q.f7849e = false;
            } else {
                c0651q.f7849e = true;
                c0651q.a();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        X x4 = this.f7632e;
        if (x4 != null) {
            x4.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        X x4 = this.f7632e;
        if (x4 != null) {
            x4.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z4) {
        getEmojiTextViewHelper().c(z4);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((AbstractC0409x1) getEmojiTextViewHelper().f7871b.f3147d).i(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0255b c0255b = this.f7631d;
        if (c0255b != null) {
            c0255b.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0255b c0255b = this.f7631d;
        if (c0255b != null) {
            c0255b.t(mode);
        }
    }

    @Override // S.t
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0651q c0651q = this.f7630c;
        if (c0651q != null) {
            c0651q.f7845a = colorStateList;
            c0651q.f7847c = true;
            c0651q.a();
        }
    }

    @Override // S.t
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0651q c0651q = this.f7630c;
        if (c0651q != null) {
            c0651q.f7846b = mode;
            c0651q.f7848d = true;
            c0651q.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        X x4 = this.f7632e;
        x4.i(colorStateList);
        x4.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        X x4 = this.f7632e;
        x4.j(mode);
        x4.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i5) {
        setButtonDrawable(AbstractC0930a.k(getContext(), i5));
    }
}
