package k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.recyclerview.widget.C0255b;
import com.unified.ur1.R;
import e.AbstractC0429a;
import w1.AbstractC0930a;

/* renamed from: k.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0649p extends CheckedTextView {

    /* renamed from: c, reason: collision with root package name */
    public final C0651q f7841c;

    /* renamed from: d, reason: collision with root package name */
    public final C0255b f7842d;

    /* renamed from: e, reason: collision with root package name */
    public final X f7843e;

    /* renamed from: f, reason: collision with root package name */
    public C0658u f7844f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0649p(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        super(context, attributeSet, R.attr.checkedTextViewStyle);
        V0.a(context);
        U0.a(this, getContext());
        X x4 = new X(this);
        this.f7843e = x4;
        x4.f(attributeSet, R.attr.checkedTextViewStyle);
        x4.b();
        C0255b c0255b = new C0255b(this);
        this.f7842d = c0255b;
        c0255b.k(attributeSet, R.attr.checkedTextViewStyle);
        this.f7841c = new C0651q(this);
        Context context2 = getContext();
        int[] iArr = AbstractC0429a.f6124l;
        L0.m mVarK = L0.m.k(context2, attributeSet, iArr, R.attr.checkedTextViewStyle, 0);
        TypedArray typedArray = (TypedArray) mVarK.f1557e;
        O.Y.j(this, getContext(), iArr, attributeSet, (TypedArray) mVarK.f1557e, R.attr.checkedTextViewStyle);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    setCheckMarkDrawable(AbstractC0930a.k(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                }
            } else if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                setCheckMarkDrawable(AbstractC0930a.k(getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
                setCheckMarkTintList(mVarK.f(2));
            }
            if (typedArray.hasValue(3)) {
                setCheckMarkTintMode(AbstractC0636i0.b(typedArray.getInt(3, -1), null));
            }
            mVarK.n();
            getEmojiTextViewHelper().a(attributeSet, R.attr.checkedTextViewStyle);
        } catch (Throwable th) {
            mVarK.n();
            throw th;
        }
    }

    private C0658u getEmojiTextViewHelper() {
        if (this.f7844f == null) {
            this.f7844f = new C0658u(this);
        }
        return this.f7844f;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        X x4 = this.f7843e;
        if (x4 != null) {
            x4.b();
        }
        C0255b c0255b = this.f7842d;
        if (c0255b != null) {
            c0255b.a();
        }
        C0651q c0651q = this.f7841c;
        if (c0651q != null) {
            c0651q.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return super.getCustomSelectionActionModeCallback();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0255b c0255b = this.f7842d;
        if (c0255b != null) {
            return c0255b.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0255b c0255b = this.f7842d;
        if (c0255b != null) {
            return c0255b.i();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        C0651q c0651q = this.f7841c;
        if (c0651q != null) {
            return c0651q.f7845a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        C0651q c0651q = this.f7841c;
        if (c0651q != null) {
            return c0651q.f7846b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f7843e.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f7843e.e();
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        android.support.v4.media.session.b.g(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().b(z4);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0255b c0255b = this.f7842d;
        if (c0255b != null) {
            c0255b.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        C0255b c0255b = this.f7842d;
        if (c0255b != null) {
            c0255b.n(i5);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        C0651q c0651q = this.f7841c;
        if (c0651q != null) {
            if (c0651q.f7849e) {
                c0651q.f7849e = false;
            } else {
                c0651q.f7849e = true;
                c0651q.b();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        X x4 = this.f7843e;
        if (x4 != null) {
            x4.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        X x4 = this.f7843e;
        if (x4 != null) {
            x4.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setEmojiCompatEnabled(boolean z4) {
        getEmojiTextViewHelper().c(z4);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0255b c0255b = this.f7842d;
        if (c0255b != null) {
            c0255b.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0255b c0255b = this.f7842d;
        if (c0255b != null) {
            c0255b.t(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        C0651q c0651q = this.f7841c;
        if (c0651q != null) {
            c0651q.f7845a = colorStateList;
            c0651q.f7847c = true;
            c0651q.b();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        C0651q c0651q = this.f7841c;
        if (c0651q != null) {
            c0651q.f7846b = mode;
            c0651q.f7848d = true;
            c0651q.b();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        X x4 = this.f7843e;
        x4.i(colorStateList);
        x4.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        X x4 = this.f7843e;
        x4.j(mode);
        x4.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        X x4 = this.f7843e;
        if (x4 != null) {
            x4.g(context, i5);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i5) {
        setCheckMarkDrawable(AbstractC0930a.k(getContext(), i5));
    }
}
