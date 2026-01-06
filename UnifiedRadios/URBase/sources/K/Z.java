package k;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.recyclerview.widget.C0255b;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public class Z extends TextView {

    /* renamed from: c, reason: collision with root package name */
    public final C0255b f7741c;

    /* renamed from: d, reason: collision with root package name */
    public final X f7742d;

    /* renamed from: e, reason: collision with root package name */
    public C0658u f7743e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7744f;
    public C0668z g;
    public Future h;

    public Z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private C0658u getEmojiTextViewHelper() {
        if (this.f7743e == null) {
            this.f7743e = new C0658u(this);
        }
        return this.f7743e;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0255b c0255b = this.f7741c;
        if (c0255b != null) {
            c0255b.a();
        }
        X x4 = this.f7742d;
        if (x4 != null) {
            x4.b();
        }
    }

    public final void f() {
        Future future = this.h;
        if (future == null) {
            return;
        }
        try {
            this.h = null;
            com.unified.ur1.SatelliteTracker.h.p(future.get());
            if (Build.VERSION.SDK_INT >= 29) {
                throw null;
            }
            PrecomputedText.Params paramsB = S.r.b(this);
            paramsB.getTextPaint();
            paramsB.getTextDirection();
            paramsB.getBreakStrategy();
            paramsB.getHyphenationFrequency();
            throw null;
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        Method method = j1.f7810a;
        return super.getAutoSizeMaxTextSize();
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        Method method = j1.f7810a;
        return super.getAutoSizeMinTextSize();
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        Method method = j1.f7810a;
        return super.getAutoSizeStepGranularity();
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        Method method = j1.f7810a;
        return super.getAutoSizeTextAvailableSizes();
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        Method method = j1.f7810a;
        return super.getAutoSizeTextType() == 1 ? 1 : 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return super.getCustomSelectionActionModeCallback();
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public Y getSuperCaller() {
        if (this.g == null) {
            this.g = new C0668z(this);
        }
        return this.g;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0255b c0255b = this.f7741c;
        if (c0255b != null) {
            return c0255b.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0255b c0255b = this.f7741c;
        if (c0255b != null) {
            return c0255b.i();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f7742d.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f7742d.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        f();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return super.getTextClassifier();
    }

    public M.d getTextMetricsParamsCompat() {
        return new M.d(S.r.b(this));
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f7742d.getClass();
        X.h(this, inputConnectionOnCreateInputConnection, editorInfo);
        android.support.v4.media.session.b.g(inputConnectionOnCreateInputConnection, editorInfo, this);
        return inputConnectionOnCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        X x4 = this.f7742d;
        if (x4 != null) {
            x4.getClass();
            Method method = j1.f7810a;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i5, int i6) {
        f();
        super.onMeasure(i5, i6);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        super.onTextChanged(charSequence, i5, i6, i7);
        if (this.f7742d != null) {
            Method method = j1.f7810a;
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z4) {
        super.setAllCaps(z4);
        getEmojiTextViewHelper().b(z4);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i5, int i6, int i7, int i8) {
        Method method = j1.f7810a;
        super.setAutoSizeTextTypeUniformWithConfiguration(i5, i6, i7, i8);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i5) {
        Method method = j1.f7810a;
        super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i5);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i5) {
        Method method = j1.f7810a;
        super.setAutoSizeTextTypeWithDefaults(i5);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0255b c0255b = this.f7741c;
        if (c0255b != null) {
            c0255b.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        C0255b c0255b = this.f7741c;
        if (c0255b != null) {
            c0255b.n(i5);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        X x4 = this.f7742d;
        if (x4 != null) {
            x4.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        X x4 = this.f7742d;
        if (x4 != null) {
            x4.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        X x4 = this.f7742d;
        if (x4 != null) {
            x4.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        X x4 = this.f7742d;
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

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(((AbstractC0409x1) getEmojiTextViewHelper().f7871b.f3147d).i(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i5) {
        getSuperCaller().b(i5);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i5) {
        getSuperCaller().a(i5);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i5) {
        h4.f.b(i5);
        if (i5 != getPaint().getFontMetricsInt(null)) {
            setLineSpacing(i5 - r0, 1.0f);
        }
    }

    public void setPrecomputedText(M.e eVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        PrecomputedText.Params paramsB = S.r.b(this);
        paramsB.getTextPaint();
        paramsB.getTextDirection();
        paramsB.getBreakStrategy();
        paramsB.getHyphenationFrequency();
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0255b c0255b = this.f7741c;
        if (c0255b != null) {
            c0255b.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0255b c0255b = this.f7741c;
        if (c0255b != null) {
            c0255b.t(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        X x4 = this.f7742d;
        x4.i(colorStateList);
        x4.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        X x4 = this.f7742d;
        x4.j(mode);
        x4.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i5) {
        super.setTextAppearance(context, i5);
        X x4 = this.f7742d;
        if (x4 != null) {
            x4.g(context, i5);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        super.setTextClassifier(textClassifier);
    }

    public void setTextFuture(Future<M.e> future) {
        this.h = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(M.d dVar) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = dVar.f1652b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i5 = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i5 = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i5 = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i5 = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i5 = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i5 = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i5 = 7;
            }
        }
        S.p.h(this, i5);
        getPaint().set(dVar.f1651a);
        S.q.e(this, dVar.f1653c);
        S.q.h(this, dVar.f1654d);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i5, float f5) {
        Method method = j1.f7810a;
        super.setTextSize(i5, f5);
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i5) {
        Typeface typefaceCreate;
        if (this.f7744f) {
            return;
        }
        if (typeface == null || i5 <= 0) {
            typefaceCreate = null;
        } else {
            Context context = getContext();
            h4.f fVar = E.g.f426a;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typefaceCreate = Typeface.create(typeface, i5);
        }
        this.f7744f = true;
        if (typefaceCreate != null) {
            typeface = typefaceCreate;
        }
        try {
            super.setTypeface(typeface, i5);
        } finally {
            this.f7744f = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        V0.a(context);
        this.f7744f = false;
        this.g = null;
        U0.a(this, getContext());
        C0255b c0255b = new C0255b(this);
        this.f7741c = c0255b;
        c0255b.k(attributeSet, i5);
        X x4 = new X(this);
        this.f7742d = x4;
        x4.f(attributeSet, i5);
        x4.b();
        getEmojiTextViewHelper().a(attributeSet, i5);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i5, int i6, int i7, int i8) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i5 != 0 ? AbstractC0930a.k(context, i5) : null, i6 != 0 ? AbstractC0930a.k(context, i6) : null, i7 != 0 ? AbstractC0930a.k(context, i7) : null, i8 != 0 ? AbstractC0930a.k(context, i8) : null);
        X x4 = this.f7742d;
        if (x4 != null) {
            x4.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i5, int i6, int i7, int i8) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i5 != 0 ? AbstractC0930a.k(context, i5) : null, i6 != 0 ? AbstractC0930a.k(context, i6) : null, i7 != 0 ? AbstractC0930a.k(context, i7) : null, i8 != 0 ? AbstractC0930a.k(context, i8) : null);
        X x4 = this.f7742d;
        if (x4 != null) {
            x4.b();
        }
    }
}
