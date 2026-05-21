package i2;

import O.G;
import O.Y;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import g2.C0547k;
import j.B;
import j.o;
import java.util.HashSet;
import java.util.WeakHashMap;
import n2.m;
import w0.C0927a;

/* loaded from: classes.dex */
public abstract class e extends ViewGroup implements B {

    /* renamed from: H, reason: collision with root package name */
    public static final int[] f7228H = {R.attr.state_checked};
    public static final int[] I = {-16842910};

    /* renamed from: A, reason: collision with root package name */
    public int f7229A;

    /* renamed from: B, reason: collision with root package name */
    public int f7230B;

    /* renamed from: C, reason: collision with root package name */
    public m f7231C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f7232D;

    /* renamed from: E, reason: collision with root package name */
    public ColorStateList f7233E;

    /* renamed from: F, reason: collision with root package name */
    public g f7234F;

    /* renamed from: G, reason: collision with root package name */
    public j.m f7235G;

    /* renamed from: c, reason: collision with root package name */
    public final C0927a f7236c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.material.datepicker.j f7237d;

    /* renamed from: e, reason: collision with root package name */
    public final N.d f7238e;

    /* renamed from: f, reason: collision with root package name */
    public final SparseArray f7239f;
    public int g;
    public c[] h;

    /* renamed from: i, reason: collision with root package name */
    public int f7240i;

    /* renamed from: j, reason: collision with root package name */
    public int f7241j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f7242k;

    /* renamed from: l, reason: collision with root package name */
    public int f7243l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f7244m;
    public final ColorStateList n;

    /* renamed from: o, reason: collision with root package name */
    public int f7245o;

    /* renamed from: p, reason: collision with root package name */
    public int f7246p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f7247q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f7248r;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f7249s;

    /* renamed from: t, reason: collision with root package name */
    public int f7250t;

    /* renamed from: u, reason: collision with root package name */
    public final SparseArray f7251u;

    /* renamed from: v, reason: collision with root package name */
    public int f7252v;

    /* renamed from: w, reason: collision with root package name */
    public int f7253w;

    /* renamed from: x, reason: collision with root package name */
    public int f7254x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f7255y;

    /* renamed from: z, reason: collision with root package name */
    public int f7256z;

    public e(Context context) {
        super(context);
        this.f7238e = new N.d(5);
        this.f7239f = new SparseArray(5);
        this.f7240i = 0;
        this.f7241j = 0;
        this.f7251u = new SparseArray(5);
        this.f7252v = -1;
        this.f7253w = -1;
        this.f7254x = -1;
        this.f7232D = false;
        this.n = c();
        if (isInEditMode()) {
            this.f7236c = null;
        } else {
            C0927a c0927a = new C0927a();
            this.f7236c = c0927a;
            c0927a.K(0);
            c0927a.z(A2.b.v(getContext(), com.unified.ur1.R.attr.motionDurationMedium4, getResources().getInteger(com.unified.ur1.R.integer.material_motion_duration_long_1)));
            c0927a.B(A2.b.w(getContext(), com.unified.ur1.R.attr.motionEasingStandard, P1.a.f2065b));
            c0927a.H(new C0547k());
        }
        this.f7237d = new com.google.android.material.datepicker.j(2, (U1.b) this);
        WeakHashMap weakHashMap = Y.f1904a;
        G.s(this, 1);
    }

    private c getNewItem() {
        c cVar = (c) this.f7238e.a();
        return cVar == null ? new U1.a(getContext()) : cVar;
    }

    private void setBadgeIfNeeded(c cVar) {
        R1.a aVar;
        int id = cVar.getId();
        if (id == -1 || (aVar = (R1.a) this.f7251u.get(id)) == null) {
            return;
        }
        cVar.setBadge(aVar);
    }

    @Override // j.B
    public final void a(j.m mVar) {
        this.f7235G = mVar;
    }

    public final void b() throws Resources.NotFoundException {
        removeAllViews();
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    this.f7238e.c(cVar);
                    cVar.i(cVar.f7215p);
                    cVar.f7221v = null;
                    cVar.f7198B = BitmapDescriptorFactory.HUE_RED;
                    cVar.f7205c = false;
                }
            }
        }
        if (this.f7235G.f7459f.size() == 0) {
            this.f7240i = 0;
            this.f7241j = 0;
            this.h = null;
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i5 = 0; i5 < this.f7235G.f7459f.size(); i5++) {
            hashSet.add(Integer.valueOf(this.f7235G.getItem(i5).getItemId()));
        }
        int i6 = 0;
        while (true) {
            SparseArray sparseArray = this.f7251u;
            if (i6 >= sparseArray.size()) {
                break;
            }
            int iKeyAt = sparseArray.keyAt(i6);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                sparseArray.delete(iKeyAt);
            }
            i6++;
        }
        this.h = new c[this.f7235G.f7459f.size()];
        int i7 = this.g;
        boolean z4 = i7 != -1 ? i7 == 0 : this.f7235G.l().size() > 3;
        for (int i8 = 0; i8 < this.f7235G.f7459f.size(); i8++) {
            this.f7234F.f7260d = true;
            this.f7235G.getItem(i8).setCheckable(true);
            this.f7234F.f7260d = false;
            c newItem = getNewItem();
            this.h[i8] = newItem;
            newItem.setIconTintList(this.f7242k);
            newItem.setIconSize(this.f7243l);
            newItem.setTextColor(this.n);
            newItem.setTextAppearanceInactive(this.f7245o);
            newItem.setTextAppearanceActive(this.f7246p);
            newItem.setTextAppearanceActiveBoldEnabled(this.f7247q);
            newItem.setTextColor(this.f7244m);
            int i9 = this.f7252v;
            if (i9 != -1) {
                newItem.setItemPaddingTop(i9);
            }
            int i10 = this.f7253w;
            if (i10 != -1) {
                newItem.setItemPaddingBottom(i10);
            }
            int i11 = this.f7254x;
            if (i11 != -1) {
                newItem.setActiveIndicatorLabelPadding(i11);
            }
            newItem.setActiveIndicatorWidth(this.f7256z);
            newItem.setActiveIndicatorHeight(this.f7229A);
            newItem.setActiveIndicatorMarginHorizontal(this.f7230B);
            newItem.setActiveIndicatorDrawable(d());
            newItem.setActiveIndicatorResizeable(this.f7232D);
            newItem.setActiveIndicatorEnabled(this.f7255y);
            Drawable drawable = this.f7248r;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.f7250t);
            }
            newItem.setItemRippleColor(this.f7249s);
            newItem.setShifting(z4);
            newItem.setLabelVisibilityMode(this.g);
            o oVar = (o) this.f7235G.getItem(i8);
            newItem.c(oVar);
            newItem.setItemPosition(i8);
            SparseArray sparseArray2 = this.f7239f;
            int i12 = oVar.f7481a;
            newItem.setOnTouchListener((View.OnTouchListener) sparseArray2.get(i12));
            newItem.setOnClickListener(this.f7237d);
            int i13 = this.f7240i;
            if (i13 != 0 && i12 == i13) {
                this.f7241j = i8;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int iMin = Math.min(this.f7235G.f7459f.size() - 1, this.f7241j);
        this.f7241j = iMin;
        this.f7235G.getItem(iMin).setChecked(true);
    }

    public final ColorStateList c() throws Resources.NotFoundException {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.textColorSecondary, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListC = C.h.c(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(com.unified.ur1.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i5 = typedValue.data;
        int defaultColor = colorStateListC.getDefaultColor();
        int[] iArr = I;
        return new ColorStateList(new int[][]{iArr, f7228H, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateListC.getColorForState(iArr, defaultColor), i5, defaultColor});
    }

    public final n2.h d() {
        if (this.f7231C == null || this.f7233E == null) {
            return null;
        }
        n2.h hVar = new n2.h(this.f7231C);
        hVar.l(this.f7233E);
        return hVar;
    }

    public int getActiveIndicatorLabelPadding() {
        return this.f7254x;
    }

    public SparseArray<R1.a> getBadgeDrawables() {
        return this.f7251u;
    }

    public ColorStateList getIconTintList() {
        return this.f7242k;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f7233E;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.f7255y;
    }

    public int getItemActiveIndicatorHeight() {
        return this.f7229A;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f7230B;
    }

    public m getItemActiveIndicatorShapeAppearance() {
        return this.f7231C;
    }

    public int getItemActiveIndicatorWidth() {
        return this.f7256z;
    }

    public Drawable getItemBackground() {
        c[] cVarArr = this.h;
        return (cVarArr == null || cVarArr.length <= 0) ? this.f7248r : cVarArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f7250t;
    }

    public int getItemIconSize() {
        return this.f7243l;
    }

    public int getItemPaddingBottom() {
        return this.f7253w;
    }

    public int getItemPaddingTop() {
        return this.f7252v;
    }

    public ColorStateList getItemRippleColor() {
        return this.f7249s;
    }

    public int getItemTextAppearanceActive() {
        return this.f7246p;
    }

    public int getItemTextAppearanceInactive() {
        return this.f7245o;
    }

    public ColorStateList getItemTextColor() {
        return this.f7244m;
    }

    public int getLabelVisibilityMode() {
        return this.g;
    }

    public j.m getMenu() {
        return this.f7235G;
    }

    public int getSelectedItemId() {
        return this.f7240i;
    }

    public int getSelectedItemPosition() {
        return this.f7241j;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, this.f7235G.l().size(), false, 1));
    }

    public void setActiveIndicatorLabelPadding(int i5) {
        this.f7254x = i5;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setActiveIndicatorLabelPadding(i5);
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f7242k = colorStateList;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.f7233E = colorStateList;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setActiveIndicatorDrawable(d());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z4) {
        this.f7255y = z4;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setActiveIndicatorEnabled(z4);
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i5) {
        this.f7229A = i5;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setActiveIndicatorHeight(i5);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i5) {
        this.f7230B = i5;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setActiveIndicatorMarginHorizontal(i5);
            }
        }
    }

    public void setItemActiveIndicatorResizeable(boolean z4) {
        this.f7232D = z4;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setActiveIndicatorResizeable(z4);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(m mVar) {
        this.f7231C = mVar;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setActiveIndicatorDrawable(d());
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i5) {
        this.f7256z = i5;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setActiveIndicatorWidth(i5);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.f7248r = drawable;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i5) {
        this.f7250t = i5;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setItemBackground(i5);
            }
        }
    }

    public void setItemIconSize(int i5) {
        this.f7243l = i5;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setIconSize(i5);
            }
        }
    }

    public void setItemPaddingBottom(int i5) {
        this.f7253w = i5;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setItemPaddingBottom(i5);
            }
        }
    }

    public void setItemPaddingTop(int i5) {
        this.f7252v = i5;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setItemPaddingTop(i5);
            }
        }
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f7249s = colorStateList;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setItemRippleColor(colorStateList);
            }
        }
    }

    public void setItemTextAppearanceActive(int i5) throws Resources.NotFoundException {
        this.f7246p = i5;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setTextAppearanceActive(i5);
                ColorStateList colorStateList = this.f7244m;
                if (colorStateList != null) {
                    cVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z4) throws Resources.NotFoundException {
        this.f7247q = z4;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setTextAppearanceActiveBoldEnabled(z4);
            }
        }
    }

    public void setItemTextAppearanceInactive(int i5) throws Resources.NotFoundException {
        this.f7245o = i5;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setTextAppearanceInactive(i5);
                ColorStateList colorStateList = this.f7244m;
                if (colorStateList != null) {
                    cVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f7244m = colorStateList;
        c[] cVarArr = this.h;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i5) {
        this.g = i5;
    }

    public void setPresenter(g gVar) {
        this.f7234F = gVar;
    }
}
