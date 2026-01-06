package k;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.recyclerview.widget.C0255b;
import w1.AbstractC0930a;

/* renamed from: k.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0664x extends MultiAutoCompleteTextView {

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f7880f = {R.attr.popupBackground};

    /* renamed from: c, reason: collision with root package name */
    public final C0255b f7881c;

    /* renamed from: d, reason: collision with root package name */
    public final X f7882d;

    /* renamed from: e, reason: collision with root package name */
    public final C0668z f7883e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0664x(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.unified.ur1.R.attr.autoCompleteTextViewStyle);
        V0.a(context);
        U0.a(this, getContext());
        L0.m mVarK = L0.m.k(getContext(), attributeSet, f7880f, com.unified.ur1.R.attr.autoCompleteTextViewStyle, 0);
        if (((TypedArray) mVarK.f1557e).hasValue(0)) {
            setDropDownBackgroundDrawable(mVarK.g(0));
        }
        mVarK.n();
        C0255b c0255b = new C0255b(this);
        this.f7881c = c0255b;
        c0255b.k(attributeSet, com.unified.ur1.R.attr.autoCompleteTextViewStyle);
        X x4 = new X(this);
        this.f7882d = x4;
        x4.f(attributeSet, com.unified.ur1.R.attr.autoCompleteTextViewStyle);
        x4.b();
        C0668z c0668z = new C0668z(this);
        this.f7883e = c0668z;
        c0668z.d(attributeSet, com.unified.ur1.R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean zIsFocusable = isFocusable();
            boolean zIsClickable = isClickable();
            boolean zIsLongClickable = isLongClickable();
            int inputType = getInputType();
            KeyListener keyListenerC = c0668z.c(keyListener);
            if (keyListenerC == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerC);
            setRawInputType(inputType);
            setFocusable(zIsFocusable);
            setClickable(zIsClickable);
            setLongClickable(zIsLongClickable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0255b c0255b = this.f7881c;
        if (c0255b != null) {
            c0255b.a();
        }
        X x4 = this.f7882d;
        if (x4 != null) {
            x4.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0255b c0255b = this.f7881c;
        if (c0255b != null) {
            return c0255b.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0255b c0255b = this.f7881c;
        if (c0255b != null) {
            return c0255b.i();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f7882d.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f7882d.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        android.support.v4.media.session.b.g(inputConnectionOnCreateInputConnection, editorInfo, this);
        return this.f7883e.e(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0255b c0255b = this.f7881c;
        if (c0255b != null) {
            c0255b.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        C0255b c0255b = this.f7881c;
        if (c0255b != null) {
            c0255b.n(i5);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        X x4 = this.f7882d;
        if (x4 != null) {
            x4.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        X x4 = this.f7882d;
        if (x4 != null) {
            x4.b();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i5) {
        setDropDownBackgroundDrawable(AbstractC0930a.k(getContext(), i5));
    }

    public void setEmojiCompatEnabled(boolean z4) {
        this.f7883e.f(z4);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f7883e.c(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0255b c0255b = this.f7881c;
        if (c0255b != null) {
            c0255b.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0255b c0255b = this.f7881c;
        if (c0255b != null) {
            c0255b.t(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        X x4 = this.f7882d;
        x4.i(colorStateList);
        x4.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        X x4 = this.f7882d;
        x4.j(mode);
        x4.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        X x4 = this.f7882d;
        if (x4 != null) {
            x4.g(context, i5);
        }
    }
}
