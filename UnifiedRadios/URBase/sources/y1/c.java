package Y1;

import D.i;
import D.p;
import L0.m;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.R;
import com.unified.ur1.SatelliteTracker.h;
import f2.C0477a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k.C0647o;
import w1.AbstractC0930a;
import x0.C0946b;
import x0.C0948d;
import x0.C0949e;

/* loaded from: classes.dex */
public final class c extends C0647o {

    /* renamed from: A, reason: collision with root package name */
    public static final int[] f2940A = {R.attr.state_indeterminate};

    /* renamed from: B, reason: collision with root package name */
    public static final int[] f2941B = {R.attr.state_error};

    /* renamed from: C, reason: collision with root package name */
    public static final int[][] f2942C = {new int[]{android.R.attr.state_enabled, R.attr.state_error}, new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: D, reason: collision with root package name */
    public static final int f2943D = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    public final LinkedHashSet g;
    public final LinkedHashSet h;

    /* renamed from: i, reason: collision with root package name */
    public ColorStateList f2944i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2945j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2946k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2947l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f2948m;
    public Drawable n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f2949o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f2950p;

    /* renamed from: q, reason: collision with root package name */
    public ColorStateList f2951q;

    /* renamed from: r, reason: collision with root package name */
    public ColorStateList f2952r;

    /* renamed from: s, reason: collision with root package name */
    public PorterDuff.Mode f2953s;

    /* renamed from: t, reason: collision with root package name */
    public int f2954t;

    /* renamed from: u, reason: collision with root package name */
    public int[] f2955u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2956v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f2957w;

    /* renamed from: x, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f2958x;

    /* renamed from: y, reason: collision with root package name */
    public final C0949e f2959y;

    /* renamed from: z, reason: collision with root package name */
    public final a f2960z;

    public c(Context context, AttributeSet attributeSet) {
        super(u2.a.a(context, attributeSet, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox), attributeSet, R.attr.checkboxStyle);
        this.g = new LinkedHashSet();
        this.h = new LinkedHashSet();
        Context context2 = getContext();
        C0949e c0949e = new C0949e(context2);
        Resources resources = context2.getResources();
        Resources.Theme theme = context2.getTheme();
        ThreadLocal threadLocal = p.f225a;
        Drawable drawableA = i.a(resources, R.drawable.mtrl_checkbox_button_checked_unchecked, theme);
        c0949e.f10369c = drawableA;
        drawableA.setCallback(c0949e.h);
        new C0477a(c0949e.f10369c.getConstantState());
        this.f2959y = c0949e;
        this.f2960z = new a(this);
        Context context3 = getContext();
        this.n = S.c.a(this);
        this.f2951q = getSuperButtonTintList();
        setSupportButtonTintList(null);
        m mVarJ = g2.m.j(context3, attributeSet, O1.a.f2012q, R.attr.checkboxStyle, R.style.Widget_MaterialComponents_CompoundButton_CheckBox, new int[0]);
        this.f2949o = mVarJ.g(2);
        Drawable drawable = this.n;
        TypedArray typedArray = (TypedArray) mVarJ.f1557e;
        if (drawable != null && AbstractC0399v1.g(context3, R.attr.isMaterial3Theme, false)) {
            int resourceId = typedArray.getResourceId(0, 0);
            int resourceId2 = typedArray.getResourceId(1, 0);
            if (resourceId == f2943D && resourceId2 == 0) {
                super.setButtonDrawable((Drawable) null);
                this.n = AbstractC0930a.k(context3, R.drawable.mtrl_checkbox_button);
                this.f2950p = true;
                if (this.f2949o == null) {
                    this.f2949o = AbstractC0930a.k(context3, R.drawable.mtrl_checkbox_button_icon);
                }
            }
        }
        this.f2952r = AbstractC0409x1.e(context3, mVarJ, 3);
        this.f2953s = g2.m.k(typedArray.getInt(4, -1), PorterDuff.Mode.SRC_IN);
        this.f2945j = typedArray.getBoolean(10, false);
        this.f2946k = typedArray.getBoolean(6, true);
        this.f2947l = typedArray.getBoolean(9, false);
        this.f2948m = typedArray.getText(8);
        if (typedArray.hasValue(7)) {
            setCheckedState(typedArray.getInt(7, 0));
        }
        mVarJ.n();
        a();
    }

    private String getButtonStateDescription() {
        int i5 = this.f2954t;
        return i5 == 1 ? getResources().getString(R.string.mtrl_checkbox_state_description_checked) : i5 == 0 ? getResources().getString(R.string.mtrl_checkbox_state_description_unchecked) : getResources().getString(R.string.mtrl_checkbox_state_description_indeterminate);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f2944i == null) {
            int iF = AbstractC0296a2.f(this, R.attr.colorControlActivated);
            int iF2 = AbstractC0296a2.f(this, R.attr.colorError);
            int iF3 = AbstractC0296a2.f(this, R.attr.colorSurface);
            int iF4 = AbstractC0296a2.f(this, R.attr.colorOnSurface);
            this.f2944i = new ColorStateList(f2942C, new int[]{AbstractC0296a2.h(1.0f, iF3, iF2), AbstractC0296a2.h(1.0f, iF3, iF), AbstractC0296a2.h(0.54f, iF3, iF4), AbstractC0296a2.h(0.38f, iF3, iF4), AbstractC0296a2.h(0.38f, iF3, iF4)});
        }
        return this.f2944i;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList colorStateList = this.f2951q;
        return colorStateList != null ? colorStateList : super.getButtonTintList() != null ? super.getButtonTintList() : getSupportButtonTintList();
    }

    public final void a() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        S1.a aVar;
        Drawable drawableMutate = this.n;
        ColorStateList colorStateList3 = this.f2951q;
        PorterDuff.Mode modeB = S.b.b(this);
        if (drawableMutate == null) {
            drawableMutate = null;
        } else if (colorStateList3 != null) {
            drawableMutate = drawableMutate.mutate();
            if (modeB != null) {
                F.b.i(drawableMutate, modeB);
            }
        }
        this.n = drawableMutate;
        Drawable drawableMutate2 = this.f2949o;
        ColorStateList colorStateList4 = this.f2952r;
        PorterDuff.Mode mode = this.f2953s;
        if (drawableMutate2 == null) {
            drawableMutate2 = null;
        } else if (colorStateList4 != null) {
            drawableMutate2 = drawableMutate2.mutate();
            if (mode != null) {
                F.b.i(drawableMutate2, mode);
            }
        }
        this.f2949o = drawableMutate2;
        if (this.f2950p) {
            C0949e c0949e = this.f2959y;
            if (c0949e != null) {
                Drawable drawable = c0949e.f10369c;
                a aVar2 = this.f2960z;
                if (drawable != null) {
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
                    if (aVar2.f2937a == null) {
                        aVar2.f2937a = new C0946b(aVar2);
                    }
                    animatedVectorDrawable.unregisterAnimationCallback(aVar2.f2937a);
                }
                ArrayList arrayList = c0949e.g;
                C0948d c0948d = c0949e.f10366d;
                if (arrayList != null && aVar2 != null) {
                    arrayList.remove(aVar2);
                    if (c0949e.g.size() == 0 && (aVar = c0949e.f10368f) != null) {
                        c0948d.f10363b.removeListener(aVar);
                        c0949e.f10368f = null;
                    }
                }
                Drawable drawable2 = c0949e.f10369c;
                if (drawable2 != null) {
                    AnimatedVectorDrawable animatedVectorDrawable2 = (AnimatedVectorDrawable) drawable2;
                    if (aVar2.f2937a == null) {
                        aVar2.f2937a = new C0946b(aVar2);
                    }
                    animatedVectorDrawable2.registerAnimationCallback(aVar2.f2937a);
                } else if (aVar2 != null) {
                    if (c0949e.g == null) {
                        c0949e.g = new ArrayList();
                    }
                    if (!c0949e.g.contains(aVar2)) {
                        c0949e.g.add(aVar2);
                        if (c0949e.f10368f == null) {
                            c0949e.f10368f = new S1.a(8, c0949e);
                        }
                        c0948d.f10363b.addListener(c0949e.f10368f);
                    }
                }
            }
            Drawable drawable3 = this.n;
            if ((drawable3 instanceof AnimatedStateListDrawable) && c0949e != null) {
                ((AnimatedStateListDrawable) drawable3).addTransition(R.id.checked, R.id.unchecked, c0949e, false);
                ((AnimatedStateListDrawable) this.n).addTransition(R.id.indeterminate, R.id.unchecked, c0949e, false);
            }
        }
        Drawable drawable4 = this.n;
        if (drawable4 != null && (colorStateList2 = this.f2951q) != null) {
            F.b.h(drawable4, colorStateList2);
        }
        Drawable drawable5 = this.f2949o;
        if (drawable5 != null && (colorStateList = this.f2952r) != null) {
            F.b.h(drawable5, colorStateList);
        }
        Drawable drawable6 = this.n;
        Drawable drawable7 = this.f2949o;
        if (drawable6 == null) {
            drawable6 = drawable7;
        } else if (drawable7 != null) {
            int intrinsicWidth = drawable7.getIntrinsicWidth();
            if (intrinsicWidth == -1) {
                intrinsicWidth = drawable6.getIntrinsicWidth();
            }
            int intrinsicHeight = drawable7.getIntrinsicHeight();
            if (intrinsicHeight == -1) {
                intrinsicHeight = drawable6.getIntrinsicHeight();
            }
            if (intrinsicWidth > drawable6.getIntrinsicWidth() || intrinsicHeight > drawable6.getIntrinsicHeight()) {
                float f5 = intrinsicWidth / intrinsicHeight;
                if (f5 >= drawable6.getIntrinsicWidth() / drawable6.getIntrinsicHeight()) {
                    int intrinsicWidth2 = drawable6.getIntrinsicWidth();
                    intrinsicHeight = (int) (intrinsicWidth2 / f5);
                    intrinsicWidth = intrinsicWidth2;
                } else {
                    intrinsicHeight = drawable6.getIntrinsicHeight();
                    intrinsicWidth = (int) (f5 * intrinsicHeight);
                }
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable6, drawable7});
            layerDrawable.setLayerSize(1, intrinsicWidth, intrinsicHeight);
            layerDrawable.setLayerGravity(1, 17);
            drawable6 = layerDrawable;
        }
        super.setButtonDrawable(drawable6);
        refreshDrawableState();
    }

    @Override // android.widget.CompoundButton
    public Drawable getButtonDrawable() {
        return this.n;
    }

    public Drawable getButtonIconDrawable() {
        return this.f2949o;
    }

    public ColorStateList getButtonIconTintList() {
        return this.f2952r;
    }

    public PorterDuff.Mode getButtonIconTintMode() {
        return this.f2953s;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getButtonTintList() {
        return this.f2951q;
    }

    public int getCheckedState() {
        return this.f2954t;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.f2948m;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final boolean isChecked() {
        return this.f2954t == 1;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2945j && this.f2951q == null && this.f2952r == null) {
            setUseMaterialThemeColors(true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i5) {
        int[] iArrCopyOf;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i5 + 2);
        if (getCheckedState() == 2) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2940A);
        }
        if (this.f2947l) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2941B);
        }
        int i6 = 0;
        while (true) {
            if (i6 >= iArrOnCreateDrawableState.length) {
                iArrCopyOf = Arrays.copyOf(iArrOnCreateDrawableState, iArrOnCreateDrawableState.length + 1);
                iArrCopyOf[iArrOnCreateDrawableState.length] = 16842912;
                break;
            }
            int i7 = iArrOnCreateDrawableState[i6];
            if (i7 == 16842912) {
                iArrCopyOf = iArrOnCreateDrawableState;
                break;
            }
            if (i7 == 0) {
                iArrCopyOf = (int[]) iArrOnCreateDrawableState.clone();
                iArrCopyOf[i6] = 16842912;
                break;
            }
            i6++;
        }
        this.f2955u = iArrCopyOf;
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        Drawable drawableA;
        if (!this.f2946k || !TextUtils.isEmpty(getText()) || (drawableA = S.c.a(this)) == null) {
            super.onDraw(canvas);
            return;
        }
        int width = ((getWidth() - drawableA.getIntrinsicWidth()) / 2) * (g2.m.h(this) ? -1 : 1);
        int iSave = canvas.save();
        canvas.translate(width, BitmapDescriptorFactory.HUE_RED);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (getBackground() != null) {
            Rect bounds = drawableA.getBounds();
            F.b.f(getBackground(), bounds.left + width, bounds.top, bounds.right + width, bounds.bottom);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (accessibilityNodeInfo != null && this.f2947l) {
            accessibilityNodeInfo.setText(((Object) accessibilityNodeInfo.getText()) + ", " + ((Object) this.f2948m));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setCheckedState(bVar.f2939j);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f2939j = getCheckedState();
        return bVar;
    }

    @Override // k.C0647o, android.widget.CompoundButton
    public void setButtonDrawable(int i5) {
        setButtonDrawable(AbstractC0930a.k(getContext(), i5));
    }

    public void setButtonIconDrawable(Drawable drawable) {
        this.f2949o = drawable;
        a();
    }

    public void setButtonIconDrawableResource(int i5) {
        setButtonIconDrawable(AbstractC0930a.k(getContext(), i5));
    }

    public void setButtonIconTintList(ColorStateList colorStateList) {
        if (this.f2952r == colorStateList) {
            return;
        }
        this.f2952r = colorStateList;
        a();
    }

    public void setButtonIconTintMode(PorterDuff.Mode mode) {
        if (this.f2953s == mode) {
            return;
        }
        this.f2953s = mode;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintList(ColorStateList colorStateList) {
        if (this.f2951q == colorStateList) {
            return;
        }
        this.f2951q = colorStateList;
        a();
    }

    @Override // android.widget.CompoundButton
    public void setButtonTintMode(PorterDuff.Mode mode) {
        setSupportButtonTintMode(mode);
        a();
    }

    public void setCenterIfNoTextEnabled(boolean z4) {
        this.f2946k = z4;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z4) {
        setCheckedState(z4 ? 1 : 0);
    }

    public void setCheckedState(int i5) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        if (this.f2954t != i5) {
            this.f2954t = i5;
            super.setChecked(i5 == 1);
            refreshDrawableState();
            if (Build.VERSION.SDK_INT >= 30 && this.f2957w == null) {
                super.setStateDescription(getButtonStateDescription());
            }
            if (this.f2956v) {
                return;
            }
            this.f2956v = true;
            LinkedHashSet linkedHashSet = this.h;
            if (linkedHashSet != null) {
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    h.p(it.next());
                    throw null;
                }
            }
            if (this.f2954t != 2 && (onCheckedChangeListener = this.f2958x) != null) {
                onCheckedChangeListener.onCheckedChanged(this, isChecked());
            }
            AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.notifyValueChanged(this);
            }
            this.f2956v = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
    }

    public void setErrorAccessibilityLabel(CharSequence charSequence) {
        this.f2948m = charSequence;
    }

    public void setErrorAccessibilityLabelResource(int i5) {
        setErrorAccessibilityLabel(i5 != 0 ? getResources().getText(i5) : null);
    }

    public void setErrorShown(boolean z4) {
        if (this.f2947l == z4) {
            return;
        }
        this.f2947l = z4;
        refreshDrawableState();
        Iterator it = this.g.iterator();
        if (it.hasNext()) {
            h.p(it.next());
            throw null;
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f2958x = onCheckedChangeListener;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public void setStateDescription(CharSequence charSequence) {
        this.f2957w = charSequence;
        if (charSequence != null) {
            super.setStateDescription(charSequence);
        } else {
            if (Build.VERSION.SDK_INT < 30 || charSequence != null) {
                return;
            }
            super.setStateDescription(getButtonStateDescription());
        }
    }

    public void setUseMaterialThemeColors(boolean z4) {
        this.f2945j = z4;
        if (z4) {
            S.b.c(this, getMaterialThemeColorsTintList());
        } else {
            S.b.c(this, null);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // k.C0647o, android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        this.n = drawable;
        this.f2950p = false;
        a();
    }
}
