package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import e.AbstractC0429a;
import j.AbstractC0584c;
import j.C0583b;
import j.InterfaceC0581A;
import j.l;
import j.m;
import j.o;
import k.InterfaceC0639k;
import k.Z;
import k.g1;

/* loaded from: classes.dex */
public class ActionMenuItemView extends Z implements InterfaceC0581A, View.OnClickListener, InterfaceC0639k {

    /* renamed from: i, reason: collision with root package name */
    public o f3286i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f3287j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f3288k;

    /* renamed from: l, reason: collision with root package name */
    public l f3289l;

    /* renamed from: m, reason: collision with root package name */
    public C0583b f3290m;
    public AbstractC0584c n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3291o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3292p;

    /* renamed from: q, reason: collision with root package name */
    public final int f3293q;

    /* renamed from: r, reason: collision with root package name */
    public int f3294r;

    /* renamed from: s, reason: collision with root package name */
    public final int f3295s;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.f3291o = g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0429a.f6117c, 0, 0);
        this.f3293q = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f3295s = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f3294r = -1;
        setSaveEnabled(false);
    }

    @Override // k.InterfaceC0639k
    public final boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // k.InterfaceC0639k
    public final boolean b() {
        return (TextUtils.isEmpty(getText()) ^ true) && this.f3286i.getIcon() == null;
    }

    @Override // j.InterfaceC0581A
    public final void c(o oVar) {
        this.f3286i = oVar;
        setIcon(oVar.getIcon());
        setTitle(oVar.getTitleCondensed());
        setId(oVar.f7481a);
        setVisibility(oVar.isVisible() ? 0 : 8);
        setEnabled(oVar.isEnabled());
        if (oVar.hasSubMenu() && this.f3290m == null) {
            this.f3290m = new C0583b(this);
        }
    }

    public final boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i5 = configuration.screenWidthDp;
        return i5 >= 480 || (i5 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // j.InterfaceC0581A
    public o getItemData() {
        return this.f3286i;
    }

    public final void h() {
        boolean z4 = true;
        boolean z5 = !TextUtils.isEmpty(this.f3287j);
        if (this.f3288k != null && ((this.f3286i.f7502y & 4) != 4 || (!this.f3291o && !this.f3292p))) {
            z4 = false;
        }
        boolean z6 = z5 & z4;
        setText(z6 ? this.f3287j : null);
        CharSequence charSequence = this.f3286i.f7494q;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z6 ? null : this.f3286i.f7485e);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.f3286i.f7495r;
        if (TextUtils.isEmpty(charSequence2)) {
            g1.a(this, z6 ? null : this.f3286i.f7485e);
        } else {
            g1.a(this, charSequence2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        l lVar = this.f3289l;
        if (lVar != null) {
            lVar.d(this.f3286i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3291o = g();
        h();
    }

    @Override // k.Z, android.widget.TextView, android.view.View
    public final void onMeasure(int i5, int i6) {
        int i7;
        boolean z4 = !TextUtils.isEmpty(getText());
        if (z4 && (i7 = this.f3294r) >= 0) {
            super.setPadding(i7, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i5, i6);
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int measuredWidth = getMeasuredWidth();
        int i8 = this.f3293q;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i8) : i8;
        if (mode != 1073741824 && i8 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i6);
        }
        if (z4 || this.f3288k == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f3288k.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0583b c0583b;
        if (this.f3286i.hasSubMenu() && (c0583b = this.f3290m) != null && c0583b.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z4) {
    }

    public void setChecked(boolean z4) {
    }

    public void setExpandedFormat(boolean z4) {
        if (this.f3292p != z4) {
            this.f3292p = z4;
            o oVar = this.f3286i;
            if (oVar != null) {
                m mVar = oVar.n;
                mVar.f7462k = true;
                mVar.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f3288k = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i5 = this.f3295s;
            if (intrinsicWidth > i5) {
                intrinsicHeight = (int) (intrinsicHeight * (i5 / intrinsicWidth));
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > i5) {
                intrinsicWidth = (int) (intrinsicWidth * (i5 / intrinsicHeight));
            } else {
                i5 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i5);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(l lVar) {
        this.f3289l = lVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i5, int i6, int i7, int i8) {
        this.f3294r = i5;
        super.setPadding(i5, i6, i7, i8);
    }

    public void setPopupCallback(AbstractC0584c abstractC0584c) {
        this.n = abstractC0584c;
    }

    public void setTitle(CharSequence charSequence) {
        this.f3287j = charSequence;
        h();
    }
}
