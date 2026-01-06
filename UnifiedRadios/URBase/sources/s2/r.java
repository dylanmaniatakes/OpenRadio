package s2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.google.android.material.textfield.TextInputLayout;
import com.unified.ur1.R;
import java.util.Locale;
import k.C0617L;
import k.C0645n;
import k.C0667y0;

/* loaded from: classes.dex */
public final class r extends C0645n {
    public final C0667y0 g;
    public final AccessibilityManager h;

    /* renamed from: i, reason: collision with root package name */
    public final Rect f9667i;

    /* renamed from: j, reason: collision with root package name */
    public final int f9668j;

    /* renamed from: k, reason: collision with root package name */
    public final float f9669k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f9670l;

    /* renamed from: m, reason: collision with root package name */
    public int f9671m;
    public ColorStateList n;

    public r(Context context, AttributeSet attributeSet) {
        super(u2.a.a(context, attributeSet, R.attr.autoCompleteTextViewStyle, 0), attributeSet);
        this.f9667i = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayI = g2.m.i(context2, attributeSet, O1.a.f2008l, R.attr.autoCompleteTextViewStyle, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (typedArrayI.hasValue(0) && typedArrayI.getInt(0, 0) == 0) {
            setKeyListener(null);
        }
        this.f9668j = typedArrayI.getResourceId(3, R.layout.mtrl_auto_complete_simple_item);
        this.f9669k = typedArrayI.getDimensionPixelOffset(1, R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        if (typedArrayI.hasValue(2)) {
            this.f9670l = ColorStateList.valueOf(typedArrayI.getColor(2, 0));
        }
        this.f9671m = typedArrayI.getColor(4, 0);
        this.n = AbstractC0409x1.f(context2, typedArrayI, 5);
        this.h = (AccessibilityManager) context2.getSystemService("accessibility");
        C0667y0 c0667y0 = new C0667y0(context2, null, R.attr.listPopupWindowStyle, 0);
        this.g = c0667y0;
        c0667y0.f7887A = true;
        c0667y0.f7888B.setFocusable(true);
        c0667y0.f7900q = this;
        c0667y0.f7888B.setInputMethodMode(2);
        c0667y0.p(getAdapter());
        c0667y0.f7901r = new C0617L(2, this);
        if (typedArrayI.hasValue(6)) {
            setSimpleItems(typedArrayI.getResourceId(6, 0));
        }
        typedArrayI.recycle();
    }

    public static void a(r rVar, Object obj) {
        rVar.setText(rVar.convertSelectionToString(obj), false);
    }

    public final TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.AutoCompleteTextView
    public final void dismissDropDown() {
        AccessibilityManager accessibilityManager = this.h;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.dismissDropDown();
        } else {
            this.g.dismiss();
        }
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.f9670l;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutB = b();
        return (textInputLayoutB == null || !textInputLayoutB.f5423G) ? super.getHint() : textInputLayoutB.getHint();
    }

    public float getPopupElevation() {
        return this.f9669k;
    }

    public int getSimpleItemSelectedColor() {
        return this.f9671m;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.n;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutB = b();
        if (textInputLayoutB != null && textInputLayoutB.f5423G && super.getHint() == null) {
            String str = Build.MANUFACTURER;
            if ((str != null ? str.toLowerCase(Locale.ENGLISH) : "").equals("meizu")) {
                setHint("");
            }
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.g.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (View.MeasureSpec.getMode(i5) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout textInputLayoutB = b();
            int measuredWidth2 = 0;
            if (adapter != null && textInputLayoutB != null) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                C0667y0 c0667y0 = this.g;
                int iMin = Math.min(adapter.getCount(), Math.max(0, !c0667y0.f7888B.isShowing() ? -1 : c0667y0.f7891e.getSelectedItemPosition()) + 15);
                View view = null;
                int iMax = 0;
                for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
                    int itemViewType = adapter.getItemViewType(iMax2);
                    if (itemViewType != measuredWidth2) {
                        view = null;
                        measuredWidth2 = itemViewType;
                    }
                    view = adapter.getView(iMax2, view, textInputLayoutB);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    iMax = Math.max(iMax, view.getMeasuredWidth());
                }
                Drawable background = c0667y0.f7888B.getBackground();
                if (background != null) {
                    Rect rect = this.f9667i;
                    background.getPadding(rect);
                    iMax += rect.left + rect.right;
                }
                measuredWidth2 = textInputLayoutB.getEndIconView().getMeasuredWidth() + iMax;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, measuredWidth2), View.MeasureSpec.getSize(i5)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z4) {
        AccessibilityManager accessibilityManager = this.h;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.onWindowFocusChanged(z4);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t4) {
        super.setAdapter(t4);
        this.g.p(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        C0667y0 c0667y0 = this.g;
        if (c0667y0 != null) {
            c0667y0.h(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i5) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i5));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.f9670l = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof n2.h) {
            ((n2.h) dropDownBackground).l(this.f9670l);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.g.f7902s = getOnItemSelectedListener();
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i5) {
        super.setRawInputType(i5);
        TextInputLayout textInputLayoutB = b();
        if (textInputLayoutB != null) {
            textInputLayoutB.s();
        }
    }

    public void setSimpleItemSelectedColor(int i5) {
        this.f9671m = i5;
        if (getAdapter() instanceof q) {
            ((q) getAdapter()).a();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.n = colorStateList;
        if (getAdapter() instanceof q) {
            ((q) getAdapter()).a();
        }
    }

    public void setSimpleItems(int i5) {
        setSimpleItems(getResources().getStringArray(i5));
    }

    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        AccessibilityManager accessibilityManager = this.h;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.g.c();
        }
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new q(this, getContext(), this.f9668j, strArr));
    }
}
