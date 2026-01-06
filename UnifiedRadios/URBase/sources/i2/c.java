package i2;

import B0.r;
import O.A;
import O.G;
import O.O;
import O.Y;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import h1.C0559c;
import j.InterfaceC0581A;
import j.o;
import java.util.WeakHashMap;
import k.g1;
import l2.AbstractC0742a;

/* loaded from: classes.dex */
public abstract class c extends FrameLayout implements InterfaceC0581A {
    public static final int[] I = {R.attr.state_checked};

    /* renamed from: J, reason: collision with root package name */
    public static final C0559c f7195J = new C0559c();

    /* renamed from: K, reason: collision with root package name */
    public static final b f7196K = new b();

    /* renamed from: A, reason: collision with root package name */
    public C0559c f7197A;

    /* renamed from: B, reason: collision with root package name */
    public float f7198B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f7199C;

    /* renamed from: D, reason: collision with root package name */
    public int f7200D;

    /* renamed from: E, reason: collision with root package name */
    public int f7201E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f7202F;

    /* renamed from: G, reason: collision with root package name */
    public int f7203G;

    /* renamed from: H, reason: collision with root package name */
    public R1.a f7204H;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7205c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f7206d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f7207e;

    /* renamed from: f, reason: collision with root package name */
    public int f7208f;
    public int g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public float f7209i;

    /* renamed from: j, reason: collision with root package name */
    public float f7210j;

    /* renamed from: k, reason: collision with root package name */
    public float f7211k;

    /* renamed from: l, reason: collision with root package name */
    public int f7212l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7213m;
    public final FrameLayout n;

    /* renamed from: o, reason: collision with root package name */
    public final View f7214o;

    /* renamed from: p, reason: collision with root package name */
    public final ImageView f7215p;

    /* renamed from: q, reason: collision with root package name */
    public final ViewGroup f7216q;

    /* renamed from: r, reason: collision with root package name */
    public final TextView f7217r;

    /* renamed from: s, reason: collision with root package name */
    public final TextView f7218s;

    /* renamed from: t, reason: collision with root package name */
    public int f7219t;

    /* renamed from: u, reason: collision with root package name */
    public int f7220u;

    /* renamed from: v, reason: collision with root package name */
    public o f7221v;

    /* renamed from: w, reason: collision with root package name */
    public ColorStateList f7222w;

    /* renamed from: x, reason: collision with root package name */
    public Drawable f7223x;

    /* renamed from: y, reason: collision with root package name */
    public Drawable f7224y;

    /* renamed from: z, reason: collision with root package name */
    public ValueAnimator f7225z;

    public c(Context context) {
        super(context);
        this.f7205c = false;
        this.f7219t = -1;
        this.f7220u = 0;
        this.f7197A = f7195J;
        this.f7198B = BitmapDescriptorFactory.HUE_RED;
        this.f7199C = false;
        this.f7200D = 0;
        this.f7201E = 0;
        this.f7202F = false;
        this.f7203G = 0;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.n = (FrameLayout) findViewById(com.unified.ur1.R.id.navigation_bar_item_icon_container);
        this.f7214o = findViewById(com.unified.ur1.R.id.navigation_bar_item_active_indicator_view);
        ImageView imageView = (ImageView) findViewById(com.unified.ur1.R.id.navigation_bar_item_icon_view);
        this.f7215p = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(com.unified.ur1.R.id.navigation_bar_item_labels_group);
        this.f7216q = viewGroup;
        TextView textView = (TextView) findViewById(com.unified.ur1.R.id.navigation_bar_item_small_label_view);
        this.f7217r = textView;
        TextView textView2 = (TextView) findViewById(com.unified.ur1.R.id.navigation_bar_item_large_label_view);
        this.f7218s = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.f7208f = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.g = viewGroup.getPaddingBottom();
        this.h = getResources().getDimensionPixelSize(com.unified.ur1.R.dimen.m3_navigation_item_active_indicator_label_padding);
        WeakHashMap weakHashMap = Y.f1904a;
        G.s(textView, 2);
        G.s(textView2, 2);
        setFocusable(true);
        a(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new T1.a(1, (U1.a) this));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f(android.widget.TextView r4, int r5) throws android.content.res.Resources.NotFoundException {
        /*
            r4.setTextAppearance(r5)
            android.content.Context r0 = r4.getContext()
            r1 = 0
            if (r5 != 0) goto Lc
        La:
            r5 = r1
            goto L4c
        Lc:
            int[] r2 = O1.a.f1995E
            android.content.res.TypedArray r5 = r0.obtainStyledAttributes(r5, r2)
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            boolean r3 = r5.getValue(r1, r2)
            r5.recycle()
            if (r3 != 0) goto L21
            goto La
        L21:
            int r5 = r2.getComplexUnit()
            r3 = 2
            if (r5 != r3) goto L3e
            int r5 = r2.data
            float r5 = android.util.TypedValue.complexToFloat(r5)
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r0 = r0.density
            float r5 = r5 * r0
            int r5 = java.lang.Math.round(r5)
            goto L4c
        L3e:
            int r5 = r2.data
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r5 = android.util.TypedValue.complexToDimensionPixelSize(r5, r0)
        L4c:
            if (r5 == 0) goto L52
            float r5 = (float) r5
            r4.setTextSize(r1, r5)
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.c.f(android.widget.TextView, int):void");
    }

    public static void g(View view, float f5, float f6, int i5) {
        view.setScaleX(f5);
        view.setScaleY(f6);
        view.setVisibility(i5);
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.n;
        return frameLayout != null ? frameLayout : this.f7215p;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i5 = 0;
        for (int i6 = 0; i6 < iIndexOfChild; i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if ((childAt instanceof c) && childAt.getVisibility() == 0) {
                i5++;
            }
        }
        return i5;
    }

    private int getSuggestedIconHeight() {
        return getIconOrContainer().getMeasuredHeight() + ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin;
    }

    private int getSuggestedIconWidth() {
        R1.a aVar = this.f7204H;
        int minimumWidth = aVar == null ? 0 : aVar.getMinimumWidth() - this.f7204H.g.f2268b.f2244F.intValue();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.rightMargin) + this.f7215p.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.leftMargin);
    }

    public static void h(View view, int i5, int i6) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i5;
        layoutParams.bottomMargin = i5;
        layoutParams.gravity = i6;
        view.setLayoutParams(layoutParams);
    }

    public static void k(View view, int i5) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i5);
    }

    public final void a(float f5, float f6) {
        this.f7209i = f5 - f6;
        this.f7210j = (f6 * 1.0f) / f5;
        this.f7211k = (f5 * 1.0f) / f6;
    }

    public final void b() {
        o oVar = this.f7221v;
        if (oVar != null) {
            setChecked(oVar.isChecked());
        }
    }

    @Override // j.InterfaceC0581A
    public final void c(o oVar) {
        this.f7221v = oVar;
        setCheckable(oVar.isCheckable());
        setChecked(oVar.isChecked());
        setEnabled(oVar.isEnabled());
        setIcon(oVar.getIcon());
        setTitle(oVar.f7485e);
        setId(oVar.f7481a);
        if (!TextUtils.isEmpty(oVar.f7494q)) {
            setContentDescription(oVar.f7494q);
        }
        g1.a(this, !TextUtils.isEmpty(oVar.f7495r) ? oVar.f7495r : oVar.f7485e);
        setVisibility(oVar.isVisible() ? 0 : 8);
        this.f7205c = true;
    }

    public final void d() {
        Drawable rippleDrawable = this.f7207e;
        ColorStateList colorStateList = this.f7206d;
        FrameLayout frameLayout = this.n;
        RippleDrawable rippleDrawable2 = null;
        boolean z4 = true;
        if (colorStateList != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.f7199C && getActiveIndicatorDrawable() != null && frameLayout != null && activeIndicatorDrawable != null) {
                rippleDrawable2 = new RippleDrawable(AbstractC0742a.b(this.f7206d), null, activeIndicatorDrawable);
                z4 = false;
            } else if (rippleDrawable == null) {
                ColorStateList colorStateList2 = this.f7206d;
                int[] iArr = AbstractC0742a.f8392d;
                int iA = AbstractC0742a.a(colorStateList2, AbstractC0742a.f8391c);
                int[] iArr2 = AbstractC0742a.f8390b;
                rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{iArr, iArr2, StateSet.NOTHING}, new int[]{iA, AbstractC0742a.a(colorStateList2, iArr2), AbstractC0742a.a(colorStateList2, AbstractC0742a.f8389a)}), null, null);
            }
        }
        if (frameLayout != null) {
            frameLayout.setPadding(0, 0, 0, 0);
            frameLayout.setForeground(rippleDrawable2);
        }
        WeakHashMap weakHashMap = Y.f1904a;
        G.q(this, rippleDrawable);
        setDefaultFocusHighlightEnabled(z4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        FrameLayout frameLayout = this.n;
        if (frameLayout != null && this.f7199C) {
            frameLayout.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e(float f5, float f6) {
        View view = this.f7214o;
        if (view != null) {
            C0559c c0559c = this.f7197A;
            c0559c.getClass();
            view.setScaleX(P1.a.a(0.4f, 1.0f, f5));
            view.setScaleY(c0559c.g(f5, f6));
            view.setAlpha(P1.a.b(BitmapDescriptorFactory.HUE_RED, 1.0f, f6 == BitmapDescriptorFactory.HUE_RED ? 0.8f : 0.0f, f6 == BitmapDescriptorFactory.HUE_RED ? 1.0f : 0.2f, f5));
        }
        this.f7198B = f5;
    }

    public Drawable getActiveIndicatorDrawable() {
        View view = this.f7214o;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    public R1.a getBadge() {
        return this.f7204H;
    }

    public int getItemBackgroundResId() {
        return com.unified.ur1.R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // j.InterfaceC0581A
    public o getItemData() {
        return this.f7221v;
    }

    public int getItemDefaultMarginResId() {
        return com.unified.ur1.R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f7219t;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        ViewGroup viewGroup = this.f7216q;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return viewGroup.getMeasuredHeight() + getSuggestedIconHeight() + (viewGroup.getVisibility() == 0 ? this.h : 0) + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        ViewGroup viewGroup = this.f7216q;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), viewGroup.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
    }

    public final void i(View view) {
        if (this.f7204H != null) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                R1.a aVar = this.f7204H;
                if (aVar != null) {
                    if (aVar.c() != null) {
                        aVar.c().setForeground(null);
                    } else {
                        view.getOverlay().remove(aVar);
                    }
                }
            }
            this.f7204H = null;
        }
    }

    public final void j(int i5) {
        View view = this.f7214o;
        if (view == null || i5 <= 0) {
            return;
        }
        int iMin = Math.min(this.f7200D, i5 - (this.f7203G * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = (this.f7202F && this.f7212l == 2) ? iMin : this.f7201E;
        layoutParams.width = iMin;
        view.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i5) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i5 + 1);
        o oVar = this.f7221v;
        if (oVar != null && oVar.isCheckable() && this.f7221v.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, I);
        }
        return iArrOnCreateDrawableState;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo r9) {
        /*
            r8 = this;
            super.onInitializeAccessibilityNodeInfo(r9)
            R1.a r0 = r8.f7204H
            r1 = 0
            r2 = 1
            if (r0 == 0) goto La5
            boolean r0 = r0.isVisible()
            if (r0 == 0) goto La5
            j.o r0 = r8.f7221v
            java.lang.CharSequence r3 = r0.f7485e
            java.lang.CharSequence r0 = r0.f7494q
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1f
            j.o r0 = r8.f7221v
            java.lang.CharSequence r3 = r0.f7494q
        L1f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            java.lang.String r3 = ", "
            r0.append(r3)
            R1.a r3 = r8.f7204H
            boolean r4 = r3.isVisible()
            r5 = 0
            if (r4 != 0) goto L37
            goto L9b
        L37:
            R1.c r4 = r3.g
            R1.b r4 = r4.f2268b
            java.lang.String r6 = r4.f2259s
            if (r6 == 0) goto L41
            r7 = r2
            goto L42
        L41:
            r7 = r1
        L42:
            if (r7 == 0) goto L4c
            java.lang.CharSequence r3 = r4.f2264x
            if (r3 == 0) goto L4a
            r5 = r3
            goto L9b
        L4a:
            r5 = r6
            goto L9b
        L4c:
            boolean r6 = r3.f()
            if (r6 == 0) goto L99
            int r6 = r4.f2266z
            if (r6 == 0) goto L9b
            java.lang.ref.WeakReference r6 = r3.f2229c
            java.lang.Object r6 = r6.get()
            android.content.Context r6 = (android.content.Context) r6
            if (r6 != 0) goto L61
            goto L9b
        L61:
            int r5 = r3.f2234j
            r7 = -2
            if (r5 == r7) goto L7e
            int r5 = r3.d()
            int r7 = r3.f2234j
            if (r5 > r7) goto L6f
            goto L7e
        L6f:
            int r3 = r4.f2239A
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r5 = r6.getString(r3, r4)
            goto L9b
        L7e:
            android.content.res.Resources r5 = r6.getResources()
            int r4 = r4.f2266z
            int r6 = r3.d()
            int r3 = r3.d()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r5 = r5.getQuantityString(r4, r6, r3)
            goto L9b
        L99:
            java.lang.CharSequence r5 = r4.f2265y
        L9b:
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r9.setContentDescription(r0)
        La5:
            int r0 = r8.getItemVisiblePosition()
            boolean r3 = r8.isSelected()
            P.i r0 = P.i.a(r1, r2, r0, r2, r3)
            java.lang.Object r0 = r0.f2057a
            android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo r0 = (android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo) r0
            r9.setCollectionItemInfo(r0)
            boolean r0 = r8.isSelected()
            if (r0 == 0) goto Lca
            r9.setClickable(r1)
            P.h r0 = P.h.f2046e
            java.lang.Object r0 = r0.f2053a
            android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction r0 = (android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction) r0
            r9.removeAction(r0)
        Lca:
            android.content.res.Resources r0 = r8.getResources()
            r1 = 2131951719(0x7f130067, float:1.953986E38)
            java.lang.String r0 = r0.getString(r1)
            android.os.Bundle r9 = r9.getExtras()
            java.lang.String r1 = "AccessibilityNodeInfo.roleDescription"
            r9.putCharSequence(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.c.onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo):void");
    }

    @Override // android.view.View
    public final void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        post(new r(i5, 5, this));
    }

    public void setActiveIndicatorDrawable(Drawable drawable) {
        View view = this.f7214o;
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
        d();
    }

    public void setActiveIndicatorEnabled(boolean z4) {
        this.f7199C = z4;
        d();
        View view = this.f7214o;
        if (view != null) {
            view.setVisibility(z4 ? 0 : 8);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i5) {
        this.f7201E = i5;
        j(getWidth());
    }

    public void setActiveIndicatorLabelPadding(int i5) {
        if (this.h != i5) {
            this.h = i5;
            b();
        }
    }

    public void setActiveIndicatorMarginHorizontal(int i5) {
        this.f7203G = i5;
        j(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z4) {
        this.f7202F = z4;
    }

    public void setActiveIndicatorWidth(int i5) {
        this.f7200D = i5;
        j(getWidth());
    }

    public void setBadge(R1.a aVar) {
        R1.a aVar2 = this.f7204H;
        if (aVar2 == aVar) {
            return;
        }
        boolean z4 = aVar2 != null;
        ImageView imageView = this.f7215p;
        if (z4 && imageView != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            i(imageView);
        }
        this.f7204H = aVar;
        if (imageView == null || aVar == null) {
            return;
        }
        setClipChildren(false);
        setClipToPadding(false);
        R1.a aVar3 = this.f7204H;
        Rect rect = new Rect();
        imageView.getDrawingRect(rect);
        aVar3.setBounds(rect);
        aVar3.h(imageView, null);
        if (aVar3.c() != null) {
            aVar3.c().setForeground(aVar3);
        } else {
            imageView.getOverlay().add(aVar3);
        }
    }

    public void setCheckable(boolean z4) {
        refreshDrawableState();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setChecked(boolean r13) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.c.setChecked(boolean):void");
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
        this.f7217r.setEnabled(z4);
        this.f7218s.setEnabled(z4);
        this.f7215p.setEnabled(z4);
        if (z4) {
            O.d(this, A.b(getContext(), 1002));
        } else {
            WeakHashMap weakHashMap = Y.f1904a;
            O.d(this, null);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable == this.f7223x) {
            return;
        }
        this.f7223x = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = drawable.mutate();
            this.f7224y = drawable;
            ColorStateList colorStateList = this.f7222w;
            if (colorStateList != null) {
                F.b.h(drawable, colorStateList);
            }
        }
        this.f7215p.setImageDrawable(drawable);
    }

    public void setIconSize(int i5) {
        ImageView imageView = this.f7215p;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = i5;
        layoutParams.height = i5;
        imageView.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.f7222w = colorStateList;
        if (this.f7221v == null || (drawable = this.f7224y) == null) {
            return;
        }
        F.b.h(drawable, colorStateList);
        this.f7224y.invalidateSelf();
    }

    public void setItemBackground(int i5) {
        setItemBackground(i5 == 0 ? null : C.c.b(getContext(), i5));
    }

    public void setItemPaddingBottom(int i5) {
        if (this.g != i5) {
            this.g = i5;
            b();
        }
    }

    public void setItemPaddingTop(int i5) {
        if (this.f7208f != i5) {
            this.f7208f = i5;
            b();
        }
    }

    public void setItemPosition(int i5) {
        this.f7219t = i5;
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f7206d = colorStateList;
        d();
    }

    public void setLabelVisibilityMode(int i5) {
        if (this.f7212l != i5) {
            this.f7212l = i5;
            if (this.f7202F && i5 == 2) {
                this.f7197A = f7196K;
            } else {
                this.f7197A = f7195J;
            }
            j(getWidth());
            b();
        }
    }

    public void setShifting(boolean z4) {
        if (this.f7213m != z4) {
            this.f7213m = z4;
            b();
        }
    }

    public void setTextAppearanceActive(int i5) throws Resources.NotFoundException {
        this.f7220u = i5;
        TextView textView = this.f7218s;
        f(textView, i5);
        a(this.f7217r.getTextSize(), textView.getTextSize());
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z4) throws Resources.NotFoundException {
        setTextAppearanceActive(this.f7220u);
        TextView textView = this.f7218s;
        textView.setTypeface(textView.getTypeface(), z4 ? 1 : 0);
    }

    public void setTextAppearanceInactive(int i5) throws Resources.NotFoundException {
        TextView textView = this.f7217r;
        f(textView, i5);
        a(textView.getTextSize(), this.f7218s.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f7217r.setTextColor(colorStateList);
            this.f7218s.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f7217r.setText(charSequence);
        this.f7218s.setText(charSequence);
        o oVar = this.f7221v;
        if (oVar == null || TextUtils.isEmpty(oVar.f7494q)) {
            setContentDescription(charSequence);
        }
        o oVar2 = this.f7221v;
        if (oVar2 != null && !TextUtils.isEmpty(oVar2.f7495r)) {
            charSequence = this.f7221v.f7495r;
        }
        g1.a(this, charSequence);
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.f7207e = drawable;
        d();
    }
}
