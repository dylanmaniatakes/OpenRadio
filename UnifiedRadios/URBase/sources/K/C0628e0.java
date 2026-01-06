package k;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import androidx.recyclerview.widget.C0255b;
import com.google.android.gms.internal.measurement.AbstractC0409x1;

/* renamed from: k.e0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0628e0 extends ToggleButton {

    /* renamed from: c, reason: collision with root package name */
    public final C0255b f7763c;

    /* renamed from: d, reason: collision with root package name */
    public final X f7764d;

    /* renamed from: e, reason: collision with root package name */
    public C0658u f7765e;

    public C0628e0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyleToggle);
        U0.a(this, getContext());
        C0255b c0255b = new C0255b(this);
        this.f7763c = c0255b;
        c0255b.k(attributeSet, R.attr.buttonStyleToggle);
        X x4 = new X(this);
        this.f7764d = x4;
        x4.f(attributeSet, R.attr.buttonStyleToggle);
        getEmojiTextViewHelper().a(attributeSet, R.attr.buttonStyleToggle);
    }

    private C0658u getEmojiTextViewHelper() {
        if (this.f7765e == null) {
            this.f7765e = new C0658u(this);
        }
        return this.f7765e;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0255b c0255b = this.f7763c;
        if (c0255b != null) {
            c0255b.a();
        }
        X x4 = this.f7764d;
        if (x4 != null) {
            x4.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0255b c0255b = this.f7763c;
        if (c0255b != null) {
            return c0255b.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0255b c0255b = this.f7763c;
        if (c0255b != null) {
            return c0255b.i();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f7764d.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f7764d.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().b(z4);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0255b c0255b = this.f7763c;
        if (c0255b != null) {
            c0255b.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        C0255b c0255b = this.f7763c;
        if (c0255b != null) {
            c0255b.n(i5);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        X x4 = this.f7764d;
        if (x4 != null) {
            x4.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        X x4 = this.f7764d;
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
        C0255b c0255b = this.f7763c;
        if (c0255b != null) {
            c0255b.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0255b c0255b = this.f7763c;
        if (c0255b != null) {
            c0255b.t(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        X x4 = this.f7764d;
        x4.i(colorStateList);
        x4.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        X x4 = this.f7764d;
        x4.j(mode);
        x4.b();
    }
}
