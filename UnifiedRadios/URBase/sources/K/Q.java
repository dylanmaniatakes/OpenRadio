package k;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.recyclerview.widget.C0255b;
import j.ViewTreeObserverOnGlobalLayoutListenerC0585d;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class Q extends Spinner {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f7679k = {R.attr.spinnerMode};

    /* renamed from: c, reason: collision with root package name */
    public final C0255b f7680c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f7681d;

    /* renamed from: e, reason: collision with root package name */
    public final C0611F f7682e;

    /* renamed from: f, reason: collision with root package name */
    public SpinnerAdapter f7683f;
    public final boolean g;
    public final P h;

    /* renamed from: i, reason: collision with root package name */
    public int f7684i;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f7685j;

    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Q(android.content.Context r13, android.util.AttributeSet r14) throws java.lang.Throwable {
        /*
            r12 = this;
            r0 = 2130969580(0x7f0403ec, float:1.7547846E38)
            r12.<init>(r13, r14, r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r12.f7685j = r1
            android.content.Context r1 = r12.getContext()
            k.U0.a(r12, r1)
            int[] r1 = e.AbstractC0429a.f6133v
            r2 = 0
            L0.m r3 = L0.m.k(r13, r14, r1, r0, r2)
            androidx.recyclerview.widget.b r4 = new androidx.recyclerview.widget.b
            r4.<init>(r12)
            r12.f7680c = r4
            java.lang.Object r4 = r3.f1557e
            android.content.res.TypedArray r4 = (android.content.res.TypedArray) r4
            r5 = 4
            int r5 = r4.getResourceId(r5, r2)
            if (r5 == 0) goto L35
            i.e r6 = new i.e
            r6.<init>(r13, r5)
            r12.f7681d = r6
            goto L37
        L35:
            r12.f7681d = r13
        L37:
            r5 = -1
            r6 = 0
            int[] r7 = k.Q.f7679k     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            android.content.res.TypedArray r7 = r13.obtainStyledAttributes(r14, r7, r0, r2)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            boolean r8 = r7.hasValue(r2)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4e
            if (r8 == 0) goto L50
            int r5 = r7.getInt(r2, r2)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4e
            goto L50
        L4a:
            r13 = move-exception
            r6 = r7
            goto Ld5
        L4e:
            r8 = move-exception
            goto L59
        L50:
            r7.recycle()
            goto L63
        L54:
            r13 = move-exception
            goto Ld5
        L57:
            r8 = move-exception
            r7 = r6
        L59:
            java.lang.String r9 = "AppCompatSpinner"
            java.lang.String r10 = "Could not read android:spinnerMode"
            android.util.Log.i(r9, r10, r8)     // Catch: java.lang.Throwable -> L4a
            if (r7 == 0) goto L63
            goto L50
        L63:
            r7 = 2
            r8 = 1
            if (r5 == 0) goto L9d
            if (r5 == r8) goto L6a
            goto Laa
        L6a:
            k.N r5 = new k.N
            android.content.Context r9 = r12.f7681d
            r5.<init>(r12, r9, r14)
            android.content.Context r9 = r12.f7681d
            L0.m r1 = L0.m.k(r9, r14, r1, r0, r2)
            r9 = 3
            r10 = -2
            java.lang.Object r11 = r1.f1557e
            android.content.res.TypedArray r11 = (android.content.res.TypedArray) r11
            int r9 = r11.getLayoutDimension(r9, r10)
            r12.f7684i = r9
            android.graphics.drawable.Drawable r9 = r1.g(r8)
            r5.h(r9)
            java.lang.String r7 = r4.getString(r7)
            r5.f7674E = r7
            r1.n()
            r12.h = r5
            k.F r1 = new k.F
            r1.<init>(r12, r12, r5)
            r12.f7682e = r1
            goto Laa
        L9d:
            k.J r1 = new k.J
            r1.<init>(r12)
            r12.h = r1
            java.lang.String r5 = r4.getString(r7)
            r1.f7662e = r5
        Laa:
            java.lang.CharSequence[] r1 = r4.getTextArray(r2)
            if (r1 == 0) goto Lc1
            android.widget.ArrayAdapter r2 = new android.widget.ArrayAdapter
            r4 = 17367048(0x1090008, float:2.5162948E-38)
            r2.<init>(r13, r4, r1)
            r13 = 2131558599(0x7f0d00c7, float:1.8742518E38)
            r2.setDropDownViewResource(r13)
            r12.setAdapter(r2)
        Lc1:
            r3.n()
            r12.g = r8
            android.widget.SpinnerAdapter r13 = r12.f7683f
            if (r13 == 0) goto Lcf
            r12.setAdapter(r13)
            r12.f7683f = r6
        Lcf:
            androidx.recyclerview.widget.b r13 = r12.f7680c
            r13.k(r14, r0)
            return
        Ld5:
            if (r6 == 0) goto Lda
            r6.recycle()
        Lda:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: k.Q.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i5 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i5) {
                view = null;
                i5 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        Rect rect = this.f7685j;
        drawable.getPadding(rect);
        return iMax2 + rect.left + rect.right;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0255b c0255b = this.f7680c;
        if (c0255b != null) {
            c0255b.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        P p4 = this.h;
        return p4 != null ? p4.a() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        P p4 = this.h;
        return p4 != null ? p4.n() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.h != null ? this.f7684i : super.getDropDownWidth();
    }

    public final P getInternalPopup() {
        return this.h;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        P p4 = this.h;
        return p4 != null ? p4.d() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f7681d;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        P p4 = this.h;
        return p4 != null ? p4.o() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0255b c0255b = this.f7680c;
        if (c0255b != null) {
            return c0255b.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0255b c0255b = this.f7680c;
        if (c0255b != null) {
            return c0255b.i();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        P p4 = this.h;
        if (p4 == null || !p4.b()) {
            return;
        }
        p4.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (this.h == null || View.MeasureSpec.getMode(i5) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i5)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        O o5 = (O) parcelable;
        super.onRestoreInstanceState(o5.getSuperState());
        if (!o5.f7678j || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0585d(2, this));
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        O o5 = new O(super.onSaveInstanceState());
        P p4 = this.h;
        o5.f7678j = p4 != null && p4.b();
        return o5;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0611F c0611f = this.f7682e;
        if (c0611f == null || !c0611f.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        P p4 = this.h;
        if (p4 == null) {
            return super.performClick();
        }
        if (p4.b()) {
            return true;
        }
        this.h.m(AbstractC0613H.b(this), AbstractC0613H.a(this));
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0255b c0255b = this.f7680c;
        if (c0255b != null) {
            c0255b.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        C0255b c0255b = this.f7680c;
        if (c0255b != null) {
            c0255b.n(i5);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i5) {
        P p4 = this.h;
        if (p4 == null) {
            super.setDropDownHorizontalOffset(i5);
        } else {
            p4.j(i5);
            p4.l(i5);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i5) {
        P p4 = this.h;
        if (p4 != null) {
            p4.i(i5);
        } else {
            super.setDropDownVerticalOffset(i5);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i5) {
        if (this.h != null) {
            this.f7684i = i5;
        } else {
            super.setDropDownWidth(i5);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        P p4 = this.h;
        if (p4 != null) {
            p4.h(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i5) {
        setPopupBackgroundDrawable(AbstractC0930a.k(getPopupContext(), i5));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        P p4 = this.h;
        if (p4 != null) {
            p4.e(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0255b c0255b = this.f7680c;
        if (c0255b != null) {
            c0255b.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0255b c0255b = this.f7680c;
        if (c0255b != null) {
            c0255b.t(mode);
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.g) {
            this.f7683f = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        P p4 = this.h;
        if (p4 != null) {
            Context context = this.f7681d;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            C0616K c0616k = new C0616K();
            c0616k.f7664c = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                c0616k.f7665d = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                AbstractC0614I.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            }
            p4.p(c0616k);
        }
    }
}
