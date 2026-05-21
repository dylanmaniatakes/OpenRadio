package androidx.appcompat.widget;

import B0.l;
import C0.A;
import O.AbstractC0173l;
import O.C0177p;
import O.H;
import O.Y;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import com.unified.ur1.R;
import com.unified.ur1.SatelliteTracker.h;
import e.AbstractC0429a;
import i.j;
import j.k;
import j.m;
import j.o;
import j.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import k.C0637j;
import k.C0660v;
import k.C0662w;
import k.I0;
import k.InterfaceC0634h0;
import k.Y0;
import k.Z;
import k.a1;
import k.b1;
import k.c1;
import k.d1;
import k.f1;
import k.g1;
import k.j1;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {

    /* renamed from: A, reason: collision with root package name */
    public CharSequence f3440A;

    /* renamed from: B, reason: collision with root package name */
    public ColorStateList f3441B;

    /* renamed from: C, reason: collision with root package name */
    public ColorStateList f3442C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f3443D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f3444E;

    /* renamed from: F, reason: collision with root package name */
    public final ArrayList f3445F;

    /* renamed from: G, reason: collision with root package name */
    public final ArrayList f3446G;

    /* renamed from: H, reason: collision with root package name */
    public final int[] f3447H;
    public final C0177p I;

    /* renamed from: J, reason: collision with root package name */
    public ArrayList f3448J;

    /* renamed from: K, reason: collision with root package name */
    public c1 f3449K;

    /* renamed from: L, reason: collision with root package name */
    public final Z2.c f3450L;

    /* renamed from: M, reason: collision with root package name */
    public f1 f3451M;

    /* renamed from: N, reason: collision with root package name */
    public C0637j f3452N;

    /* renamed from: O, reason: collision with root package name */
    public a1 f3453O;

    /* renamed from: P, reason: collision with root package name */
    public y f3454P;

    /* renamed from: Q, reason: collision with root package name */
    public k f3455Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f3456R;

    /* renamed from: S, reason: collision with root package name */
    public OnBackInvokedCallback f3457S;

    /* renamed from: T, reason: collision with root package name */
    public OnBackInvokedDispatcher f3458T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f3459U;

    /* renamed from: V, reason: collision with root package name */
    public final A f3460V;

    /* renamed from: c, reason: collision with root package name */
    public ActionMenuView f3461c;

    /* renamed from: d, reason: collision with root package name */
    public Z f3462d;

    /* renamed from: e, reason: collision with root package name */
    public Z f3463e;

    /* renamed from: f, reason: collision with root package name */
    public C0660v f3464f;
    public C0662w g;
    public final Drawable h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f3465i;

    /* renamed from: j, reason: collision with root package name */
    public C0660v f3466j;

    /* renamed from: k, reason: collision with root package name */
    public View f3467k;

    /* renamed from: l, reason: collision with root package name */
    public Context f3468l;

    /* renamed from: m, reason: collision with root package name */
    public int f3469m;
    public int n;

    /* renamed from: o, reason: collision with root package name */
    public int f3470o;

    /* renamed from: p, reason: collision with root package name */
    public final int f3471p;

    /* renamed from: q, reason: collision with root package name */
    public final int f3472q;

    /* renamed from: r, reason: collision with root package name */
    public int f3473r;

    /* renamed from: s, reason: collision with root package name */
    public int f3474s;

    /* renamed from: t, reason: collision with root package name */
    public int f3475t;

    /* renamed from: u, reason: collision with root package name */
    public int f3476u;

    /* renamed from: v, reason: collision with root package name */
    public I0 f3477v;

    /* renamed from: w, reason: collision with root package name */
    public int f3478w;

    /* renamed from: x, reason: collision with root package name */
    public int f3479x;

    /* renamed from: y, reason: collision with root package name */
    public final int f3480y;

    /* renamed from: z, reason: collision with root package name */
    public CharSequence f3481z;

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i5 = 0; i5 < menu.size(); i5++) {
            arrayList.add(menu.getItem(i5));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new j(getContext());
    }

    public static b1 h() {
        b1 b1Var = new b1(-2, -2);
        b1Var.f7752b = 0;
        b1Var.f7751a = 8388627;
        return b1Var;
    }

    public static b1 i(ViewGroup.LayoutParams layoutParams) {
        boolean z4 = layoutParams instanceof b1;
        if (z4) {
            b1 b1Var = (b1) layoutParams;
            b1 b1Var2 = new b1(b1Var);
            b1Var2.f7752b = 0;
            b1Var2.f7752b = b1Var.f7752b;
            return b1Var2;
        }
        if (z4) {
            b1 b1Var3 = new b1((b1) layoutParams);
            b1Var3.f7752b = 0;
            return b1Var3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            b1 b1Var4 = new b1(layoutParams);
            b1Var4.f7752b = 0;
            return b1Var4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        b1 b1Var5 = new b1(marginLayoutParams);
        b1Var5.f7752b = 0;
        ((ViewGroup.MarginLayoutParams) b1Var5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) b1Var5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) b1Var5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) b1Var5).bottomMargin = marginLayoutParams.bottomMargin;
        return b1Var5;
    }

    public static int l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return AbstractC0173l.b(marginLayoutParams) + AbstractC0173l.c(marginLayoutParams);
    }

    public static int m(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(ArrayList arrayList, int i5) {
        WeakHashMap weakHashMap = Y.f1904a;
        boolean z4 = H.d(this) == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i5, H.d(this));
        arrayList.clear();
        if (!z4) {
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                b1 b1Var = (b1) childAt.getLayoutParams();
                if (b1Var.f7752b == 0 && v(childAt) && j(b1Var.f7751a) == absoluteGravity) {
                    arrayList.add(childAt);
                }
            }
            return;
        }
        for (int i7 = childCount - 1; i7 >= 0; i7--) {
            View childAt2 = getChildAt(i7);
            b1 b1Var2 = (b1) childAt2.getLayoutParams();
            if (b1Var2.f7752b == 0 && v(childAt2) && j(b1Var2.f7751a) == absoluteGravity) {
                arrayList.add(childAt2);
            }
        }
    }

    public final void b(View view, boolean z4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        b1 b1VarH = layoutParams == null ? h() : !checkLayoutParams(layoutParams) ? i(layoutParams) : (b1) layoutParams;
        b1VarH.f7752b = 1;
        if (!z4 || this.f3467k == null) {
            addView(view, b1VarH);
        } else {
            view.setLayoutParams(b1VarH);
            this.f3446G.add(view);
        }
    }

    public final void c() {
        if (this.f3466j == null) {
            C0660v c0660v = new C0660v(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f3466j = c0660v;
            c0660v.setImageDrawable(this.h);
            this.f3466j.setContentDescription(this.f3465i);
            b1 b1VarH = h();
            b1VarH.f7751a = (this.f3471p & 112) | 8388611;
            b1VarH.f7752b = 2;
            this.f3466j.setLayoutParams(b1VarH);
            this.f3466j.setOnClickListener(new com.google.android.material.datepicker.j(4, this));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b1);
    }

    public final void d() {
        if (this.f3477v == null) {
            I0 i02 = new I0();
            i02.f7654a = 0;
            i02.f7655b = 0;
            i02.f7656c = Integer.MIN_VALUE;
            i02.f7657d = Integer.MIN_VALUE;
            i02.f7658e = 0;
            i02.f7659f = 0;
            i02.g = false;
            i02.h = false;
            this.f3477v = i02;
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.f3461c;
        if (actionMenuView.f3364r == null) {
            m mVar = (m) actionMenuView.getMenu();
            if (this.f3453O == null) {
                this.f3453O = new a1(this);
            }
            this.f3461c.setExpandedActionViewsExclusive(true);
            mVar.b(this.f3453O, this.f3468l);
            x();
        }
    }

    public final void f() {
        if (this.f3461c == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f3461c = actionMenuView;
            actionMenuView.setPopupTheme(this.f3469m);
            this.f3461c.setOnMenuItemClickListener(this.f3450L);
            ActionMenuView actionMenuView2 = this.f3461c;
            y yVar = this.f3454P;
            l lVar = new l(20, this);
            actionMenuView2.f3369w = yVar;
            actionMenuView2.f3370x = lVar;
            b1 b1VarH = h();
            b1VarH.f7751a = (this.f3471p & 112) | 8388613;
            this.f3461c.setLayoutParams(b1VarH);
            b(this.f3461c, false);
        }
    }

    public final void g() {
        if (this.f3464f == null) {
            this.f3464f = new C0660v(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            b1 b1VarH = h();
            b1VarH.f7751a = (this.f3471p & 112) | 8388611;
            this.f3464f.setLayoutParams(b1VarH);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return h();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        C0660v c0660v = this.f3466j;
        if (c0660v != null) {
            return c0660v.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        C0660v c0660v = this.f3466j;
        if (c0660v != null) {
            return c0660v.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        I0 i02 = this.f3477v;
        if (i02 != null) {
            return i02.g ? i02.f7654a : i02.f7655b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i5 = this.f3479x;
        return i5 != Integer.MIN_VALUE ? i5 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        I0 i02 = this.f3477v;
        if (i02 != null) {
            return i02.f7654a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        I0 i02 = this.f3477v;
        if (i02 != null) {
            return i02.f7655b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        I0 i02 = this.f3477v;
        if (i02 != null) {
            return i02.g ? i02.f7655b : i02.f7654a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i5 = this.f3478w;
        return i5 != Integer.MIN_VALUE ? i5 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        m mVar;
        ActionMenuView actionMenuView = this.f3461c;
        return (actionMenuView == null || (mVar = actionMenuView.f3364r) == null || !mVar.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f3479x, 0));
    }

    public int getCurrentContentInsetLeft() {
        WeakHashMap weakHashMap = Y.f1904a;
        return H.d(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        WeakHashMap weakHashMap = Y.f1904a;
        return H.d(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f3478w, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        C0662w c0662w = this.g;
        if (c0662w != null) {
            return c0662w.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        C0662w c0662w = this.g;
        if (c0662w != null) {
            return c0662w.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f3461c.getMenu();
    }

    public View getNavButtonView() {
        return this.f3464f;
    }

    public CharSequence getNavigationContentDescription() {
        C0660v c0660v = this.f3464f;
        if (c0660v != null) {
            return c0660v.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        C0660v c0660v = this.f3464f;
        if (c0660v != null) {
            return c0660v.getDrawable();
        }
        return null;
    }

    public C0637j getOuterActionMenuPresenter() {
        return this.f3452N;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.f3461c.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f3468l;
    }

    public int getPopupTheme() {
        return this.f3469m;
    }

    public CharSequence getSubtitle() {
        return this.f3440A;
    }

    public final TextView getSubtitleTextView() {
        return this.f3463e;
    }

    public CharSequence getTitle() {
        return this.f3481z;
    }

    public int getTitleMarginBottom() {
        return this.f3476u;
    }

    public int getTitleMarginEnd() {
        return this.f3474s;
    }

    public int getTitleMarginStart() {
        return this.f3473r;
    }

    public int getTitleMarginTop() {
        return this.f3475t;
    }

    public final TextView getTitleTextView() {
        return this.f3462d;
    }

    public InterfaceC0634h0 getWrapper() {
        if (this.f3451M == null) {
            this.f3451M = new f1(this, true);
        }
        return this.f3451M;
    }

    public final int j(int i5) {
        WeakHashMap weakHashMap = Y.f1904a;
        int iD = H.d(this);
        int absoluteGravity = Gravity.getAbsoluteGravity(i5, iD) & 7;
        return (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) ? absoluteGravity : iD == 1 ? 5 : 3;
    }

    public final int k(View view, int i5) {
        b1 b1Var = (b1) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i6 = i5 > 0 ? (measuredHeight - i5) / 2 : 0;
        int i7 = b1Var.f7751a & 112;
        if (i7 != 16 && i7 != 48 && i7 != 80) {
            i7 = this.f3480y & 112;
        }
        if (i7 == 48) {
            return getPaddingTop() - i6;
        }
        if (i7 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) b1Var).bottomMargin) - i6;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i8 = ((ViewGroup.MarginLayoutParams) b1Var).topMargin;
        if (iMax < i8) {
            iMax = i8;
        } else {
            int i9 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i10 = ((ViewGroup.MarginLayoutParams) b1Var).bottomMargin;
            if (i9 < i10) {
                iMax = Math.max(0, iMax - (i10 - i9));
            }
        }
        return paddingTop + iMax;
    }

    public void n(int i5) {
        getMenuInflater().inflate(i5, getMenu());
    }

    public final void o() {
        Iterator it = this.f3448J.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        getMenuInflater();
        Iterator it2 = this.I.f1949b.iterator();
        if (it2.hasNext()) {
            h.p(it2.next());
            throw null;
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f3448J = currentMenuItems2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        x();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f3460V);
        x();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f3444E = false;
        }
        if (!this.f3444E) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f3444E = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f3444E = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x029b A[LOOP:0: B:106:0x0299->B:107:0x029b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02b8 A[LOOP:1: B:109:0x02b6->B:110:0x02b8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02d6 A[LOOP:2: B:112:0x02d4->B:113:0x02d6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0325 A[LOOP:3: B:121:0x0323->B:122:0x0325, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0222  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 822
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        int iL;
        int iMax;
        int iCombineMeasuredStates;
        int iL2;
        int iM;
        int iCombineMeasuredStates2;
        int iMax2;
        boolean zA = j1.a(this);
        int i7 = !zA ? 1 : 0;
        int i8 = 0;
        if (v(this.f3464f)) {
            u(this.f3464f, i5, 0, i6, this.f3472q);
            iL = l(this.f3464f) + this.f3464f.getMeasuredWidth();
            iMax = Math.max(0, m(this.f3464f) + this.f3464f.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f3464f.getMeasuredState());
        } else {
            iL = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (v(this.f3466j)) {
            u(this.f3466j, i5, 0, i6, this.f3472q);
            iL = l(this.f3466j) + this.f3466j.getMeasuredWidth();
            iMax = Math.max(iMax, m(this.f3466j) + this.f3466j.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f3466j.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, iL);
        int iMax4 = Math.max(0, currentContentInsetStart - iL);
        int[] iArr = this.f3447H;
        iArr[zA ? 1 : 0] = iMax4;
        if (v(this.f3461c)) {
            u(this.f3461c, i5, iMax3, i6, this.f3472q);
            iL2 = l(this.f3461c) + this.f3461c.getMeasuredWidth();
            iMax = Math.max(iMax, m(this.f3461c) + this.f3461c.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f3461c.getMeasuredState());
        } else {
            iL2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, iL2);
        iArr[i7] = Math.max(0, currentContentInsetEnd - iL2);
        if (v(this.f3467k)) {
            iMax5 += t(this.f3467k, i5, iMax5, i6, 0, iArr);
            iMax = Math.max(iMax, m(this.f3467k) + this.f3467k.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f3467k.getMeasuredState());
        }
        if (v(this.g)) {
            iMax5 += t(this.g, i5, iMax5, i6, 0, iArr);
            iMax = Math.max(iMax, m(this.g) + this.g.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.g.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (((b1) childAt.getLayoutParams()).f7752b == 0 && v(childAt)) {
                iMax5 += t(childAt, i5, iMax5, i6, 0, iArr);
                iMax = Math.max(iMax, m(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i10 = this.f3475t + this.f3476u;
        int i11 = this.f3473r + this.f3474s;
        if (v(this.f3462d)) {
            t(this.f3462d, i5, iMax5 + i11, i6, i10, iArr);
            int iL3 = l(this.f3462d) + this.f3462d.getMeasuredWidth();
            iM = m(this.f3462d) + this.f3462d.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f3462d.getMeasuredState());
            iMax2 = iL3;
        } else {
            iM = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (v(this.f3463e)) {
            iMax2 = Math.max(iMax2, t(this.f3463e, i5, iMax5 + i11, i6, iM + i10, iArr));
            iM += m(this.f3463e) + this.f3463e.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f3463e.getMeasuredState());
        }
        int iMax6 = Math.max(iMax, iM);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax6;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight + iMax5 + iMax2, getSuggestedMinimumWidth()), i5, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i6, iCombineMeasuredStates2 << 16);
        if (!this.f3456R) {
            i8 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (v(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i8 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i8);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof d1)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d1 d1Var = (d1) parcelable;
        super.onRestoreInstanceState(d1Var.f2507j);
        ActionMenuView actionMenuView = this.f3461c;
        m mVar = actionMenuView != null ? actionMenuView.f3364r : null;
        int i5 = d1Var.f7760l;
        if (i5 != 0 && this.f3453O != null && mVar != null && (menuItemFindItem = mVar.findItem(i5)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (d1Var.f7761m) {
            A a2 = this.f3460V;
            removeCallbacks(a2);
            post(a2);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i5) {
        super.onRtlPropertiesChanged(i5);
        d();
        I0 i02 = this.f3477v;
        boolean z4 = i5 == 1;
        if (z4 == i02.g) {
            return;
        }
        i02.g = z4;
        if (!i02.h) {
            i02.f7654a = i02.f7658e;
            i02.f7655b = i02.f7659f;
            return;
        }
        if (z4) {
            int i6 = i02.f7657d;
            if (i6 == Integer.MIN_VALUE) {
                i6 = i02.f7658e;
            }
            i02.f7654a = i6;
            int i7 = i02.f7656c;
            if (i7 == Integer.MIN_VALUE) {
                i7 = i02.f7659f;
            }
            i02.f7655b = i7;
            return;
        }
        int i8 = i02.f7656c;
        if (i8 == Integer.MIN_VALUE) {
            i8 = i02.f7658e;
        }
        i02.f7654a = i8;
        int i9 = i02.f7657d;
        if (i9 == Integer.MIN_VALUE) {
            i9 = i02.f7659f;
        }
        i02.f7655b = i9;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        o oVar;
        d1 d1Var = new d1(super.onSaveInstanceState());
        a1 a1Var = this.f3453O;
        if (a1Var != null && (oVar = a1Var.f7747d) != null) {
            d1Var.f7760l = oVar.f7481a;
        }
        d1Var.f7761m = q();
        return d1Var;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3443D = false;
        }
        if (!this.f3443D) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f3443D = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f3443D = false;
        }
        return true;
    }

    public final boolean p(View view) {
        return view.getParent() == this || this.f3446G.contains(view);
    }

    public final boolean q() {
        C0637j c0637j;
        ActionMenuView actionMenuView = this.f3461c;
        return (actionMenuView == null || (c0637j = actionMenuView.f3368v) == null || !c0637j.f()) ? false : true;
    }

    public final int r(View view, int i5, int i6, int[] iArr) {
        b1 b1Var = (b1) view.getLayoutParams();
        int i7 = ((ViewGroup.MarginLayoutParams) b1Var).leftMargin - iArr[0];
        int iMax = Math.max(0, i7) + i5;
        iArr[0] = Math.max(0, -i7);
        int iK = k(view, i6);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iK, iMax + measuredWidth, view.getMeasuredHeight() + iK);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) b1Var).rightMargin + iMax;
    }

    public final int s(View view, int i5, int i6, int[] iArr) {
        b1 b1Var = (b1) view.getLayoutParams();
        int i7 = ((ViewGroup.MarginLayoutParams) b1Var).rightMargin - iArr[1];
        int iMax = i5 - Math.max(0, i7);
        iArr[1] = Math.max(0, -i7);
        int iK = k(view, i6);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iK, iMax, view.getMeasuredHeight() + iK);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) b1Var).leftMargin);
    }

    public void setBackInvokedCallbackEnabled(boolean z4) {
        if (this.f3459U != z4) {
            this.f3459U = z4;
            x();
        }
    }

    public void setCollapseContentDescription(int i5) {
        setCollapseContentDescription(i5 != 0 ? getContext().getText(i5) : null);
    }

    public void setCollapseIcon(int i5) {
        setCollapseIcon(AbstractC0930a.k(getContext(), i5));
    }

    public void setCollapsible(boolean z4) {
        this.f3456R = z4;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i5) {
        if (i5 < 0) {
            i5 = Integer.MIN_VALUE;
        }
        if (i5 != this.f3479x) {
            this.f3479x = i5;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i5) {
        if (i5 < 0) {
            i5 = Integer.MIN_VALUE;
        }
        if (i5 != this.f3478w) {
            this.f3478w = i5;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i5) {
        setLogo(AbstractC0930a.k(getContext(), i5));
    }

    public void setLogoDescription(int i5) {
        setLogoDescription(getContext().getText(i5));
    }

    public void setNavigationContentDescription(int i5) {
        setNavigationContentDescription(i5 != 0 ? getContext().getText(i5) : null);
    }

    public void setNavigationIcon(int i5) {
        setNavigationIcon(AbstractC0930a.k(getContext(), i5));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.f3464f.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(c1 c1Var) {
        this.f3449K = c1Var;
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.f3461c.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i5) {
        if (this.f3469m != i5) {
            this.f3469m = i5;
            if (i5 == 0) {
                this.f3468l = getContext();
            } else {
                this.f3468l = new ContextThemeWrapper(getContext(), i5);
            }
        }
    }

    public void setSubtitle(int i5) {
        setSubtitle(getContext().getText(i5));
    }

    public void setSubtitleTextColor(int i5) {
        setSubtitleTextColor(ColorStateList.valueOf(i5));
    }

    public void setTitle(int i5) {
        setTitle(getContext().getText(i5));
    }

    public void setTitleMarginBottom(int i5) {
        this.f3476u = i5;
        requestLayout();
    }

    public void setTitleMarginEnd(int i5) {
        this.f3474s = i5;
        requestLayout();
    }

    public void setTitleMarginStart(int i5) {
        this.f3473r = i5;
        requestLayout();
    }

    public void setTitleMarginTop(int i5) {
        this.f3475t = i5;
        requestLayout();
    }

    public void setTitleTextColor(int i5) {
        setTitleTextColor(ColorStateList.valueOf(i5));
    }

    public final int t(View view, int i5, int i6, int i7, int i8, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i9 = marginLayoutParams.leftMargin - iArr[0];
        int i10 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i10) + Math.max(0, i9);
        iArr[0] = Math.max(0, -i9);
        iArr[1] = Math.max(0, -i10);
        view.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingRight() + getPaddingLeft() + iMax + i6, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i7, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i8, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void u(View view, int i5, int i6, int i7, int i8) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i7, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i8 >= 0) {
            if (mode != 0) {
                i8 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i8);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean v(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public final boolean w() {
        C0637j c0637j;
        ActionMenuView actionMenuView = this.f3461c;
        return (actionMenuView == null || (c0637j = actionMenuView.f3368v) == null || !c0637j.n()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x() {
        /*
            r4 = this;
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            if (r1 < r2) goto L4f
            android.window.OnBackInvokedDispatcher r1 = k.Z0.a(r4)
            k.a1 r2 = r4.f3453O
            if (r2 == 0) goto L23
            j.o r2 = r2.f7747d
            if (r2 == 0) goto L23
            if (r1 == 0) goto L23
            java.util.WeakHashMap r2 = O.Y.f1904a
            boolean r2 = O.J.b(r4)
            if (r2 == 0) goto L23
            boolean r2 = r4.f3459U
            if (r2 == 0) goto L23
            r2 = 1
            goto L24
        L23:
            r2 = r0
        L24:
            if (r2 == 0) goto L41
            android.window.OnBackInvokedDispatcher r3 = r4.f3458T
            if (r3 != 0) goto L41
            android.window.OnBackInvokedCallback r2 = r4.f3457S
            if (r2 != 0) goto L39
            k.Y0 r2 = new k.Y0
            r2.<init>(r4, r0)
            android.window.OnBackInvokedCallback r0 = k.Z0.b(r2)
            r4.f3457S = r0
        L39:
            android.window.OnBackInvokedCallback r0 = r4.f3457S
            k.Z0.c(r1, r0)
            r4.f3458T = r1
            goto L4f
        L41:
            if (r2 != 0) goto L4f
            android.window.OnBackInvokedDispatcher r0 = r4.f3458T
            if (r0 == 0) goto L4f
            android.window.OnBackInvokedCallback r1 = r4.f3457S
            k.Z0.d(r0, r1)
            r0 = 0
            r4.f3458T = r0
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.x():void");
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.f3480y = 8388627;
        this.f3445F = new ArrayList();
        this.f3446G = new ArrayList();
        this.f3447H = new int[2];
        this.I = new C0177p(new Y0(this, 1));
        this.f3448J = new ArrayList();
        this.f3450L = new Z2.c(23, this);
        this.f3460V = new A(24, this);
        Context context2 = getContext();
        int[] iArr = AbstractC0429a.f6135x;
        L0.m mVarK = L0.m.k(context2, attributeSet, iArr, R.attr.toolbarStyle, 0);
        Y.j(this, context, iArr, attributeSet, (TypedArray) mVarK.f1557e, R.attr.toolbarStyle);
        TypedArray typedArray = (TypedArray) mVarK.f1557e;
        this.n = typedArray.getResourceId(28, 0);
        this.f3470o = typedArray.getResourceId(19, 0);
        this.f3480y = typedArray.getInteger(0, 8388627);
        this.f3471p = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.f3476u = dimensionPixelOffset;
        this.f3475t = dimensionPixelOffset;
        this.f3474s = dimensionPixelOffset;
        this.f3473r = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f3473r = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f3474s = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f3475t = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f3476u = dimensionPixelOffset5;
        }
        this.f3472q = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        d();
        I0 i02 = this.f3477v;
        i02.h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            i02.f7658e = dimensionPixelSize;
            i02.f7654a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            i02.f7659f = dimensionPixelSize2;
            i02.f7655b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            i02.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.f3478w = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.f3479x = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.h = mVarK.g(4);
        this.f3465i = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f3468l = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable drawableG = mVarK.g(16);
        if (drawableG != null) {
            setNavigationIcon(drawableG);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawableG2 = mVarK.g(11);
        if (drawableG2 != null) {
            setLogo(drawableG2);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(mVarK.f(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(mVarK.f(20));
        }
        if (typedArray.hasValue(14)) {
            n(typedArray.getResourceId(14, 0));
        }
        mVarK.n();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        b1 b1Var = new b1(context, attributeSet);
        b1Var.f7751a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0429a.f6116b);
        b1Var.f7751a = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        b1Var.f7752b = 0;
        return b1Var;
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        C0660v c0660v = this.f3466j;
        if (c0660v != null) {
            c0660v.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.f3466j.setImageDrawable(drawable);
        } else {
            C0660v c0660v = this.f3466j;
            if (c0660v != null) {
                c0660v.setImageDrawable(this.h);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.g == null) {
                this.g = new C0662w(getContext(), null, 0);
            }
            if (!p(this.g)) {
                b(this.g, true);
            }
        } else {
            C0662w c0662w = this.g;
            if (c0662w != null && p(c0662w)) {
                removeView(this.g);
                this.f3446G.remove(this.g);
            }
        }
        C0662w c0662w2 = this.g;
        if (c0662w2 != null) {
            c0662w2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.g == null) {
            this.g = new C0662w(getContext(), null, 0);
        }
        C0662w c0662w = this.g;
        if (c0662w != null) {
            c0662w.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        C0660v c0660v = this.f3464f;
        if (c0660v != null) {
            c0660v.setContentDescription(charSequence);
            g1.a(this.f3464f, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!p(this.f3464f)) {
                b(this.f3464f, true);
            }
        } else {
            C0660v c0660v = this.f3464f;
            if (c0660v != null && p(c0660v)) {
                removeView(this.f3464f);
                this.f3446G.remove(this.f3464f);
            }
        }
        C0660v c0660v2 = this.f3464f;
        if (c0660v2 != null) {
            c0660v2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            Z z4 = this.f3463e;
            if (z4 != null && p(z4)) {
                removeView(this.f3463e);
                this.f3446G.remove(this.f3463e);
            }
        } else {
            if (this.f3463e == null) {
                Context context = getContext();
                Z z5 = new Z(context, null);
                this.f3463e = z5;
                z5.setSingleLine();
                this.f3463e.setEllipsize(TextUtils.TruncateAt.END);
                int i5 = this.f3470o;
                if (i5 != 0) {
                    this.f3463e.setTextAppearance(context, i5);
                }
                ColorStateList colorStateList = this.f3442C;
                if (colorStateList != null) {
                    this.f3463e.setTextColor(colorStateList);
                }
            }
            if (!p(this.f3463e)) {
                b(this.f3463e, true);
            }
        }
        Z z6 = this.f3463e;
        if (z6 != null) {
            z6.setText(charSequence);
        }
        this.f3440A = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f3442C = colorStateList;
        Z z4 = this.f3463e;
        if (z4 != null) {
            z4.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            Z z4 = this.f3462d;
            if (z4 != null && p(z4)) {
                removeView(this.f3462d);
                this.f3446G.remove(this.f3462d);
            }
        } else {
            if (this.f3462d == null) {
                Context context = getContext();
                Z z5 = new Z(context, null);
                this.f3462d = z5;
                z5.setSingleLine();
                this.f3462d.setEllipsize(TextUtils.TruncateAt.END);
                int i5 = this.n;
                if (i5 != 0) {
                    this.f3462d.setTextAppearance(context, i5);
                }
                ColorStateList colorStateList = this.f3441B;
                if (colorStateList != null) {
                    this.f3462d.setTextColor(colorStateList);
                }
            }
            if (!p(this.f3462d)) {
                b(this.f3462d, true);
            }
        }
        Z z6 = this.f3462d;
        if (z6 != null) {
            z6.setText(charSequence);
        }
        this.f3481z = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f3441B = colorStateList;
        Z z4 = this.f3462d;
        if (z4 != null) {
            z4.setTextColor(colorStateList);
        }
    }
}
