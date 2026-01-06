package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import h1.C0559c;
import j.B;
import j.k;
import j.l;
import j.m;
import j.o;
import j.y;
import k.C0627e;
import k.C0633h;
import k.C0637j;
import k.C0641l;
import k.C0655s0;
import k.InterfaceC0639k;
import k.InterfaceC0643m;
import k.j1;

/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements l, B {

    /* renamed from: A, reason: collision with root package name */
    public final int f3361A;

    /* renamed from: B, reason: collision with root package name */
    public final int f3362B;

    /* renamed from: C, reason: collision with root package name */
    public InterfaceC0643m f3363C;

    /* renamed from: r, reason: collision with root package name */
    public m f3364r;

    /* renamed from: s, reason: collision with root package name */
    public Context f3365s;

    /* renamed from: t, reason: collision with root package name */
    public int f3366t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3367u;

    /* renamed from: v, reason: collision with root package name */
    public C0637j f3368v;

    /* renamed from: w, reason: collision with root package name */
    public y f3369w;

    /* renamed from: x, reason: collision with root package name */
    public k f3370x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f3371y;

    /* renamed from: z, reason: collision with root package name */
    public int f3372z;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f5 = context.getResources().getDisplayMetrics().density;
        this.f3361A = (int) (56.0f * f5);
        this.f3362B = (int) (f5 * 4.0f);
        this.f3365s = context;
        this.f3366t = 0;
    }

    public static C0641l l() {
        C0641l c0641l = new C0641l(-2, -2);
        c0641l.f7815a = false;
        ((LinearLayout.LayoutParams) c0641l).gravity = 16;
        return c0641l;
    }

    public static C0641l m(ViewGroup.LayoutParams layoutParams) {
        C0641l c0641l;
        if (layoutParams == null) {
            return l();
        }
        if (layoutParams instanceof C0641l) {
            C0641l c0641l2 = (C0641l) layoutParams;
            c0641l = new C0641l(c0641l2);
            c0641l.f7815a = c0641l2.f7815a;
        } else {
            c0641l = new C0641l(layoutParams);
        }
        if (((LinearLayout.LayoutParams) c0641l).gravity <= 0) {
            ((LinearLayout.LayoutParams) c0641l).gravity = 16;
        }
        return c0641l;
    }

    @Override // j.B
    public final void a(m mVar) {
        this.f3364r = mVar;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0641l;
    }

    @Override // j.l
    public final boolean d(o oVar) {
        return this.f3364r.q(oVar, null, 0);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return l();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m(layoutParams);
    }

    public Menu getMenu() {
        if (this.f3364r == null) {
            Context context = getContext();
            m mVar = new m(context);
            this.f3364r = mVar;
            mVar.f7458e = new L0.l(27, this);
            C0637j c0637j = new C0637j(context);
            this.f3368v = c0637j;
            c0637j.f7798o = true;
            c0637j.f7799p = true;
            y c0559c = this.f3369w;
            if (c0559c == null) {
                c0559c = new C0559c();
            }
            c0637j.g = c0559c;
            this.f3364r.b(c0637j, this.f3365s);
            C0637j c0637j2 = this.f3368v;
            c0637j2.f7794j = this;
            this.f3364r = c0637j2.f7791e;
        }
        return this.f3364r;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        C0637j c0637j = this.f3368v;
        C0633h c0633h = c0637j.f7796l;
        if (c0633h != null) {
            return c0633h.getDrawable();
        }
        if (c0637j.n) {
            return c0637j.f7797m;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f3366t;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ C0655s0 generateDefaultLayoutParams() {
        return l();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: i */
    public final C0655s0 generateLayoutParams(AttributeSet attributeSet) {
        return new C0641l(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: j */
    public final /* bridge */ /* synthetic */ C0655s0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m(layoutParams);
    }

    public final boolean n(int i5) {
        boolean zA = false;
        if (i5 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i5 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i5);
        if (i5 < getChildCount() && (childAt instanceof InterfaceC0639k)) {
            zA = ((InterfaceC0639k) childAt).a();
        }
        return (i5 <= 0 || !(childAt2 instanceof InterfaceC0639k)) ? zA : zA | ((InterfaceC0639k) childAt2).b();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0637j c0637j = this.f3368v;
        if (c0637j != null) {
            c0637j.g(false);
            if (this.f3368v.f()) {
                this.f3368v.c();
                this.f3368v.n();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0637j c0637j = this.f3368v;
        if (c0637j != null) {
            c0637j.c();
            C0627e c0627e = c0637j.f7806w;
            if (c0627e == null || !c0627e.b()) {
                return;
            }
            c0627e.f7523j.dismiss();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int width;
        int paddingLeft;
        if (!this.f3371y) {
            super.onLayout(z4, i5, i6, i7, i8);
            return;
        }
        int childCount = getChildCount();
        int i9 = (i8 - i6) / 2;
        int dividerWidth = getDividerWidth();
        int i10 = i7 - i5;
        int paddingRight = (i10 - getPaddingRight()) - getPaddingLeft();
        boolean zA = j1.a(this);
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                C0641l c0641l = (C0641l) childAt.getLayoutParams();
                if (c0641l.f7815a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (n(i13)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zA) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) c0641l).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) c0641l).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i14 = i9 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i14, width, measuredHeight + i14);
                    paddingRight -= measuredWidth;
                    i11 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) c0641l).leftMargin) + ((LinearLayout.LayoutParams) c0641l).rightMargin;
                    n(i13);
                    i12++;
                }
            }
        }
        if (childCount == 1 && i11 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i15 = (i10 / 2) - (measuredWidth2 / 2);
            int i16 = i9 - (measuredHeight2 / 2);
            childAt2.layout(i15, i16, measuredWidth2 + i15, measuredHeight2 + i16);
            return;
        }
        int i17 = i12 - (i11 ^ 1);
        int iMax = Math.max(0, i17 > 0 ? paddingRight / i17 : 0);
        if (zA) {
            int width2 = getWidth() - getPaddingRight();
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt3 = getChildAt(i18);
                C0641l c0641l2 = (C0641l) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !c0641l2.f7815a) {
                    int i19 = width2 - ((LinearLayout.LayoutParams) c0641l2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i20 = i9 - (measuredHeight3 / 2);
                    childAt3.layout(i19 - measuredWidth3, i20, i19, measuredHeight3 + i20);
                    width2 = i19 - ((measuredWidth3 + ((LinearLayout.LayoutParams) c0641l2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt4 = getChildAt(i21);
            C0641l c0641l3 = (C0641l) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !c0641l3.f7815a) {
                int i22 = paddingLeft2 + ((LinearLayout.LayoutParams) c0641l3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i23 = i9 - (measuredHeight4 / 2);
                childAt4.layout(i22, i23, i22 + measuredWidth4, measuredHeight4 + i23);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) c0641l3).rightMargin + iMax + i22;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v26 */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i5, int i6) {
        int i7;
        int i8;
        int i9;
        boolean z4;
        int i10;
        int i11;
        int i12;
        int i13;
        ?? r12;
        int i14;
        int i15;
        int i16;
        m mVar;
        boolean z5 = this.f3371y;
        boolean z6 = View.MeasureSpec.getMode(i5) == 1073741824;
        this.f3371y = z6;
        if (z5 != z6) {
            this.f3372z = 0;
        }
        int size = View.MeasureSpec.getSize(i5);
        if (this.f3371y && (mVar = this.f3364r) != null && size != this.f3372z) {
            this.f3372z = size;
            mVar.p(true);
        }
        int childCount = getChildCount();
        if (!this.f3371y || childCount <= 0) {
            for (int i17 = 0; i17 < childCount; i17++) {
                C0641l c0641l = (C0641l) getChildAt(i17).getLayoutParams();
                ((LinearLayout.LayoutParams) c0641l).rightMargin = 0;
                ((LinearLayout.LayoutParams) c0641l).leftMargin = 0;
            }
            super.onMeasure(i5, i6);
            return;
        }
        int mode = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i5);
        int size3 = View.MeasureSpec.getSize(i6);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, paddingBottom, -2);
        int i18 = size2 - paddingRight;
        int i19 = this.f3361A;
        int i20 = i18 / i19;
        int i21 = i18 % i19;
        if (i20 == 0) {
            setMeasuredDimension(i18, 0);
            return;
        }
        int i22 = (i21 / i20) + i19;
        int childCount2 = getChildCount();
        int i23 = 0;
        int iMax = 0;
        int i24 = 0;
        boolean z7 = false;
        int i25 = 0;
        int iMax2 = 0;
        long j5 = 0;
        while (true) {
            i7 = this.f3362B;
            if (i24 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i24);
            int i26 = size3;
            if (childAt.getVisibility() == 8) {
                i14 = i18;
                i15 = paddingBottom;
            } else {
                boolean z8 = childAt instanceof ActionMenuItemView;
                int i27 = i23 + 1;
                if (z8) {
                    childAt.setPadding(i7, 0, i7, 0);
                }
                C0641l c0641l2 = (C0641l) childAt.getLayoutParams();
                c0641l2.f7820f = false;
                c0641l2.f7817c = 0;
                c0641l2.f7816b = 0;
                c0641l2.f7818d = false;
                ((LinearLayout.LayoutParams) c0641l2).leftMargin = 0;
                ((LinearLayout.LayoutParams) c0641l2).rightMargin = 0;
                c0641l2.f7819e = z8 && (TextUtils.isEmpty(((ActionMenuItemView) childAt).getText()) ^ true);
                int i28 = c0641l2.f7815a ? 1 : i20;
                C0641l c0641l3 = (C0641l) childAt.getLayoutParams();
                i14 = i18;
                i15 = paddingBottom;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z8 ? (ActionMenuItemView) childAt : null;
                boolean z9 = actionMenuItemView != null && (TextUtils.isEmpty(actionMenuItemView.getText()) ^ true);
                if (i28 <= 0 || (z9 && i28 < 2)) {
                    i16 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i28 * i22, Integer.MIN_VALUE), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i16 = measuredWidth / i22;
                    if (measuredWidth % i22 != 0) {
                        i16++;
                    }
                    if (z9 && i16 < 2) {
                        i16 = 2;
                    }
                }
                c0641l3.f7818d = !c0641l3.f7815a && z9;
                c0641l3.f7816b = i16;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i16 * i22, 1073741824), iMakeMeasureSpec);
                iMax = Math.max(iMax, i16);
                if (c0641l2.f7818d) {
                    i25++;
                }
                if (c0641l2.f7815a) {
                    z7 = true;
                }
                i20 -= i16;
                iMax2 = Math.max(iMax2, childAt.getMeasuredHeight());
                if (i16 == 1) {
                    j5 |= 1 << i24;
                }
                i23 = i27;
            }
            i24++;
            size3 = i26;
            paddingBottom = i15;
            i18 = i14;
        }
        int i29 = i18;
        int i30 = size3;
        int i31 = iMax2;
        boolean z10 = z7 && i23 == 2;
        boolean z11 = false;
        while (i25 > 0 && i20 > 0) {
            int i32 = Integer.MAX_VALUE;
            int i33 = 0;
            int i34 = 0;
            long j6 = 0;
            while (i34 < childCount2) {
                int i35 = i31;
                C0641l c0641l4 = (C0641l) getChildAt(i34).getLayoutParams();
                boolean z12 = z11;
                if (c0641l4.f7818d) {
                    int i36 = c0641l4.f7816b;
                    if (i36 < i32) {
                        j6 = 1 << i34;
                        i32 = i36;
                        i33 = 1;
                    } else if (i36 == i32) {
                        i33++;
                        j6 |= 1 << i34;
                    }
                }
                i34++;
                z11 = z12;
                i31 = i35;
            }
            i9 = i31;
            z4 = z11;
            j5 |= j6;
            if (i33 > i20) {
                i8 = mode;
                break;
            }
            int i37 = i32 + 1;
            int i38 = 0;
            while (i38 < childCount2) {
                View childAt2 = getChildAt(i38);
                C0641l c0641l5 = (C0641l) childAt2.getLayoutParams();
                int i39 = mode;
                int i40 = childMeasureSpec;
                int i41 = childCount2;
                long j7 = 1 << i38;
                if ((j6 & j7) != 0) {
                    if (z10 && c0641l5.f7819e) {
                        r12 = 1;
                        r12 = 1;
                        if (i20 == 1) {
                            childAt2.setPadding(i7 + i22, 0, i7, 0);
                        }
                    } else {
                        r12 = 1;
                    }
                    c0641l5.f7816b += r12;
                    c0641l5.f7820f = r12;
                    i20--;
                } else if (c0641l5.f7816b == i37) {
                    j5 |= j7;
                }
                i38++;
                childMeasureSpec = i40;
                mode = i39;
                childCount2 = i41;
            }
            i31 = i9;
            z11 = true;
        }
        i8 = mode;
        i9 = i31;
        z4 = z11;
        int i42 = childMeasureSpec;
        int i43 = childCount2;
        boolean z13 = !z7 && i23 == 1;
        if (i20 <= 0 || j5 == 0 || (i20 >= i23 - 1 && !z13 && iMax <= 1)) {
            i10 = i43;
        } else {
            float fBitCount = Long.bitCount(j5);
            if (!z13) {
                if ((j5 & 1) != 0 && !((C0641l) getChildAt(0).getLayoutParams()).f7819e) {
                    fBitCount -= 0.5f;
                }
                int i44 = i43 - 1;
                if ((j5 & (1 << i44)) != 0 && !((C0641l) getChildAt(i44).getLayoutParams()).f7819e) {
                    fBitCount -= 0.5f;
                }
            }
            int i45 = fBitCount > BitmapDescriptorFactory.HUE_RED ? (int) ((i20 * i22) / fBitCount) : 0;
            i10 = i43;
            for (int i46 = 0; i46 < i10; i46++) {
                if ((j5 & (1 << i46)) != 0) {
                    View childAt3 = getChildAt(i46);
                    C0641l c0641l6 = (C0641l) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        c0641l6.f7817c = i45;
                        c0641l6.f7820f = true;
                        if (i46 == 0 && !c0641l6.f7819e) {
                            ((LinearLayout.LayoutParams) c0641l6).leftMargin = (-i45) / 2;
                        }
                        z4 = true;
                    } else if (c0641l6.f7815a) {
                        c0641l6.f7817c = i45;
                        c0641l6.f7820f = true;
                        ((LinearLayout.LayoutParams) c0641l6).rightMargin = (-i45) / 2;
                        z4 = true;
                    } else {
                        if (i46 != 0) {
                            ((LinearLayout.LayoutParams) c0641l6).leftMargin = i45 / 2;
                        }
                        if (i46 != i10 - 1) {
                            ((LinearLayout.LayoutParams) c0641l6).rightMargin = i45 / 2;
                        }
                    }
                }
            }
        }
        if (z4) {
            int i47 = 0;
            while (i47 < i10) {
                View childAt4 = getChildAt(i47);
                C0641l c0641l7 = (C0641l) childAt4.getLayoutParams();
                if (c0641l7.f7820f) {
                    i13 = i42;
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((c0641l7.f7816b * i22) + c0641l7.f7817c, 1073741824), i13);
                } else {
                    i13 = i42;
                }
                i47++;
                i42 = i13;
            }
        }
        if (i8 != 1073741824) {
            i12 = i29;
            i11 = i9;
        } else {
            i11 = i30;
            i12 = i29;
        }
        setMeasuredDimension(i12, i11);
    }

    public void setExpandedActionViewsExclusive(boolean z4) {
        this.f3368v.f7803t = z4;
    }

    public void setOnMenuItemClickListener(InterfaceC0643m interfaceC0643m) {
        this.f3363C = interfaceC0643m;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        C0637j c0637j = this.f3368v;
        C0633h c0633h = c0637j.f7796l;
        if (c0633h != null) {
            c0633h.setImageDrawable(drawable);
        } else {
            c0637j.n = true;
            c0637j.f7797m = drawable;
        }
    }

    public void setOverflowReserved(boolean z4) {
        this.f3367u = z4;
    }

    public void setPopupTheme(int i5) {
        if (this.f3366t != i5) {
            this.f3366t = i5;
            if (i5 == 0) {
                this.f3365s = getContext();
            } else {
                this.f3365s = new ContextThemeWrapper(getContext(), i5);
            }
        }
    }

    public void setPresenter(C0637j c0637j) {
        this.f3368v = c0637j;
        c0637j.f7794j = this;
        this.f3364r = c0637j.f7791e;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0641l(getContext(), attributeSet);
    }
}
