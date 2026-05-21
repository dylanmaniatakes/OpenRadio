package androidx.appcompat.widget;

import O.C0169i0;
import O.G;
import O.Y;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.datepicker.j;
import com.unified.ur1.R;
import e.AbstractC0429a;
import e2.C0446b;
import j.B;
import j.m;
import java.util.WeakHashMap;
import k.C0627e;
import k.C0637j;
import k.j1;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {

    /* renamed from: c, reason: collision with root package name */
    public final C0446b f3319c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f3320d;

    /* renamed from: e, reason: collision with root package name */
    public ActionMenuView f3321e;

    /* renamed from: f, reason: collision with root package name */
    public C0637j f3322f;
    public int g;
    public C0169i0 h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3323i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3324j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f3325k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f3326l;

    /* renamed from: m, reason: collision with root package name */
    public View f3327m;
    public View n;

    /* renamed from: o, reason: collision with root package name */
    public View f3328o;

    /* renamed from: p, reason: collision with root package name */
    public LinearLayout f3329p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f3330q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f3331r;

    /* renamed from: s, reason: collision with root package name */
    public final int f3332s;

    /* renamed from: t, reason: collision with root package name */
    public final int f3333t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3334u;

    /* renamed from: v, reason: collision with root package name */
    public final int f3335v;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        int resourceId;
        super(context, attributeSet, R.attr.actionModeStyle);
        this.f3319c = new C0446b(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f3320d = context;
        } else {
            this.f3320d = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0429a.f6118d, R.attr.actionModeStyle, 0);
        Drawable drawable = (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(0) : AbstractC0930a.k(context, resourceId);
        WeakHashMap weakHashMap = Y.f1904a;
        G.q(this, drawable);
        this.f3332s = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f3333t = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.g = typedArrayObtainStyledAttributes.getLayoutDimension(3, 0);
        this.f3335v = typedArrayObtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static int f(View view, int i5, int i6) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), i6);
        return Math.max(0, i5 - view.getMeasuredWidth());
    }

    public static int g(View view, int i5, int i6, int i7, boolean z4) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i8 = ((i7 - measuredHeight) / 2) + i6;
        if (z4) {
            view.layout(i5 - measuredWidth, i8, i5, measuredHeight + i8);
        } else {
            view.layout(i5, i8, i5 + measuredWidth, measuredHeight + i8);
        }
        return z4 ? -measuredWidth : measuredWidth;
    }

    public final void c(i.b bVar) {
        View view = this.f3327m;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f3335v, (ViewGroup) this, false);
            this.f3327m = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f3327m);
        }
        View viewFindViewById = this.f3327m.findViewById(R.id.action_mode_close_button);
        this.n = viewFindViewById;
        viewFindViewById.setOnClickListener(new j(3, bVar));
        m mVarC = bVar.c();
        C0637j c0637j = this.f3322f;
        if (c0637j != null) {
            c0637j.c();
            C0627e c0627e = c0637j.f7806w;
            if (c0627e != null && c0627e.b()) {
                c0627e.f7523j.dismiss();
            }
        }
        C0637j c0637j2 = new C0637j(getContext());
        this.f3322f = c0637j2;
        c0637j2.f7798o = true;
        c0637j2.f7799p = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        mVarC.b(this.f3322f, this.f3320d);
        C0637j c0637j3 = this.f3322f;
        B b5 = c0637j3.f7794j;
        if (b5 == null) {
            B b6 = (B) c0637j3.f7792f.inflate(c0637j3.h, (ViewGroup) this, false);
            c0637j3.f7794j = b6;
            b6.a(c0637j3.f7791e);
            c0637j3.g(true);
        }
        B b7 = c0637j3.f7794j;
        if (b5 != b7) {
            ((ActionMenuView) b7).setPresenter(c0637j3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) b7;
        this.f3321e = actionMenuView;
        WeakHashMap weakHashMap = Y.f1904a;
        G.q(actionMenuView, null);
        addView(this.f3321e, layoutParams);
    }

    public final void d() {
        if (this.f3329p == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f3329p = linearLayout;
            this.f3330q = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f3331r = (TextView) this.f3329p.findViewById(R.id.action_bar_subtitle);
            int i5 = this.f3332s;
            if (i5 != 0) {
                this.f3330q.setTextAppearance(getContext(), i5);
            }
            int i6 = this.f3333t;
            if (i6 != 0) {
                this.f3331r.setTextAppearance(getContext(), i6);
            }
        }
        this.f3330q.setText(this.f3325k);
        this.f3331r.setText(this.f3326l);
        boolean z4 = !TextUtils.isEmpty(this.f3325k);
        boolean z5 = !TextUtils.isEmpty(this.f3326l);
        this.f3331r.setVisibility(z5 ? 0 : 8);
        this.f3329p.setVisibility((z4 || z5) ? 0 : 8);
        if (this.f3329p.getParent() == null) {
            addView(this.f3329p);
        }
    }

    public final void e() {
        removeAllViews();
        this.f3328o = null;
        this.f3321e = null;
        this.f3322f = null;
        View view = this.n;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        return this.h != null ? this.f3319c.f6195b : getVisibility();
    }

    public int getContentHeight() {
        return this.g;
    }

    public CharSequence getSubtitle() {
        return this.f3326l;
    }

    public CharSequence getTitle() {
        return this.f3325k;
    }

    @Override // android.view.View
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i5) {
        if (i5 != getVisibility()) {
            C0169i0 c0169i0 = this.h;
            if (c0169i0 != null) {
                c0169i0.b();
            }
            super.setVisibility(i5);
        }
    }

    public final C0169i0 i(int i5, long j5) {
        C0169i0 c0169i0 = this.h;
        if (c0169i0 != null) {
            c0169i0.b();
        }
        C0446b c0446b = this.f3319c;
        if (i5 != 0) {
            C0169i0 c0169i0A = Y.a(this);
            c0169i0A.a(BitmapDescriptorFactory.HUE_RED);
            c0169i0A.c(j5);
            ((ActionBarContextView) c0446b.f6196c).h = c0169i0A;
            c0446b.f6195b = i5;
            c0169i0A.d(c0446b);
            return c0169i0A;
        }
        if (getVisibility() != 0) {
            setAlpha(BitmapDescriptorFactory.HUE_RED);
        }
        C0169i0 c0169i0A2 = Y.a(this);
        c0169i0A2.a(1.0f);
        c0169i0A2.c(j5);
        ((ActionBarContextView) c0446b.f6196c).h = c0169i0A2;
        c0446b.f6195b = i5;
        c0169i0A2.d(c0446b);
        return c0169i0A2;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, AbstractC0429a.f6115a, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(13, 0));
        typedArrayObtainStyledAttributes.recycle();
        C0637j c0637j = this.f3322f;
        if (c0637j != null) {
            Configuration configuration2 = c0637j.f7790d.getResources().getConfiguration();
            int i5 = configuration2.screenWidthDp;
            int i6 = configuration2.screenHeightDp;
            c0637j.f7802s = (configuration2.smallestScreenWidthDp > 600 || i5 > 600 || (i5 > 960 && i6 > 720) || (i5 > 720 && i6 > 960)) ? 5 : (i5 >= 500 || (i5 > 640 && i6 > 480) || (i5 > 480 && i6 > 640)) ? 4 : i5 >= 360 ? 3 : 2;
            m mVar = c0637j.f7791e;
            if (mVar != null) {
                mVar.p(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0637j c0637j = this.f3322f;
        if (c0637j != null) {
            c0637j.c();
            C0627e c0627e = this.f3322f.f7806w;
            if (c0627e == null || !c0627e.b()) {
                return;
            }
            c0627e.f7523j.dismiss();
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f3324j = false;
        }
        if (!this.f3324j) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f3324j = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f3324j = false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        boolean zA = j1.a(this);
        int paddingRight = zA ? (i7 - i5) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i8 - i6) - getPaddingTop()) - getPaddingBottom();
        View view = this.f3327m;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3327m.getLayoutParams();
            int i9 = zA ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i10 = zA ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i11 = zA ? paddingRight - i9 : paddingRight + i9;
            int iG = g(this.f3327m, i11, paddingTop, paddingTop2, zA) + i11;
            paddingRight = zA ? iG - i10 : iG + i10;
        }
        LinearLayout linearLayout = this.f3329p;
        if (linearLayout != null && this.f3328o == null && linearLayout.getVisibility() != 8) {
            paddingRight += g(this.f3329p, paddingRight, paddingTop, paddingTop2, zA);
        }
        View view2 = this.f3328o;
        if (view2 != null) {
            g(view2, paddingRight, paddingTop, paddingTop2, zA);
        }
        int paddingLeft = zA ? getPaddingLeft() : (i7 - i5) - getPaddingRight();
        ActionMenuView actionMenuView = this.f3321e;
        if (actionMenuView != null) {
            g(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zA);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        if (View.MeasureSpec.getMode(i5) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i6) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i5);
        int size2 = this.g;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i6);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f3327m;
        if (view != null) {
            int iF = f(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f3327m.getLayoutParams();
            paddingLeft = iF - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f3321e;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = f(this.f3321e, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.f3329p;
        if (linearLayout != null && this.f3328o == null) {
            if (this.f3334u) {
                this.f3329p.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f3329p.getMeasuredWidth();
                boolean z4 = measuredWidth <= paddingLeft;
                if (z4) {
                    paddingLeft -= measuredWidth;
                }
                this.f3329p.setVisibility(z4 ? 0 : 8);
            } else {
                paddingLeft = f(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.f3328o;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i7 = layoutParams.width;
            int i8 = i7 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i7 >= 0) {
                paddingLeft = Math.min(i7, paddingLeft);
            }
            int i9 = layoutParams.height;
            int i10 = i9 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i9 >= 0) {
                iMin = Math.min(i9, iMin);
            }
            this.f3328o.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i8), View.MeasureSpec.makeMeasureSpec(iMin, i10));
        }
        if (this.g > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            int measuredHeight = getChildAt(i12).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i11) {
                i11 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i11);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3323i = false;
        }
        if (!this.f3323i) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f3323i = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f3323i = false;
        }
        return true;
    }

    public void setContentHeight(int i5) {
        this.g = i5;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f3328o;
        if (view2 != null) {
            removeView(view2);
        }
        this.f3328o = view;
        if (view != null && (linearLayout = this.f3329p) != null) {
            removeView(linearLayout);
            this.f3329p = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f3326l = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.f3325k = charSequence;
        d();
        Y.l(this, charSequence);
    }

    public void setTitleOptional(boolean z4) {
        if (z4 != this.f3334u) {
            requestLayout();
        }
        this.f3334u = z4;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
