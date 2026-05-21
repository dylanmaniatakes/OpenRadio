package p2;

import B0.r;
import L0.l;
import O.H;
import O.J;
import O.Y;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.slider.Slider;
import com.unified.ur1.R;
import g2.AbstractC0539c;
import g2.C0546j;
import g2.m;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import n2.h;
import v2.C0921a;

/* loaded from: classes.dex */
public abstract class c extends View {

    /* renamed from: A, reason: collision with root package name */
    public int f9170A;

    /* renamed from: B, reason: collision with root package name */
    public int f9171B;

    /* renamed from: C, reason: collision with root package name */
    public int f9172C;

    /* renamed from: D, reason: collision with root package name */
    public int f9173D;

    /* renamed from: E, reason: collision with root package name */
    public int f9174E;

    /* renamed from: F, reason: collision with root package name */
    public int f9175F;

    /* renamed from: G, reason: collision with root package name */
    public final int f9176G;

    /* renamed from: H, reason: collision with root package name */
    public float f9177H;
    public MotionEvent I;

    /* renamed from: J, reason: collision with root package name */
    public boolean f9178J;

    /* renamed from: K, reason: collision with root package name */
    public float f9179K;

    /* renamed from: L, reason: collision with root package name */
    public float f9180L;

    /* renamed from: M, reason: collision with root package name */
    public ArrayList f9181M;

    /* renamed from: N, reason: collision with root package name */
    public int f9182N;

    /* renamed from: O, reason: collision with root package name */
    public int f9183O;

    /* renamed from: P, reason: collision with root package name */
    public float f9184P;

    /* renamed from: Q, reason: collision with root package name */
    public float[] f9185Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f9186R;

    /* renamed from: S, reason: collision with root package name */
    public int f9187S;

    /* renamed from: T, reason: collision with root package name */
    public int f9188T;

    /* renamed from: U, reason: collision with root package name */
    public int f9189U;

    /* renamed from: V, reason: collision with root package name */
    public boolean f9190V;

    /* renamed from: W, reason: collision with root package name */
    public boolean f9191W;

    /* renamed from: a0, reason: collision with root package name */
    public ColorStateList f9192a0;

    /* renamed from: b0, reason: collision with root package name */
    public ColorStateList f9193b0;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f9194c;

    /* renamed from: c0, reason: collision with root package name */
    public ColorStateList f9195c0;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f9196d;

    /* renamed from: d0, reason: collision with root package name */
    public ColorStateList f9197d0;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f9198e;

    /* renamed from: e0, reason: collision with root package name */
    public ColorStateList f9199e0;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f9200f;

    /* renamed from: f0, reason: collision with root package name */
    public final h f9201f0;
    public final Paint g;

    /* renamed from: g0, reason: collision with root package name */
    public Drawable f9202g0;
    public final Paint h;

    /* renamed from: h0, reason: collision with root package name */
    public List f9203h0;

    /* renamed from: i, reason: collision with root package name */
    public final C0834a f9204i;

    /* renamed from: i0, reason: collision with root package name */
    public float f9205i0;

    /* renamed from: j, reason: collision with root package name */
    public final AccessibilityManager f9206j;

    /* renamed from: j0, reason: collision with root package name */
    public int f9207j0;

    /* renamed from: k, reason: collision with root package name */
    public r f9208k;

    /* renamed from: l, reason: collision with root package name */
    public final int f9209l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f9210m;
    public final ArrayList n;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f9211o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9212p;

    /* renamed from: q, reason: collision with root package name */
    public ValueAnimator f9213q;

    /* renamed from: r, reason: collision with root package name */
    public ValueAnimator f9214r;

    /* renamed from: s, reason: collision with root package name */
    public final int f9215s;

    /* renamed from: t, reason: collision with root package name */
    public final int f9216t;

    /* renamed from: u, reason: collision with root package name */
    public final int f9217u;

    /* renamed from: v, reason: collision with root package name */
    public final int f9218v;

    /* renamed from: w, reason: collision with root package name */
    public final int f9219w;

    /* renamed from: x, reason: collision with root package name */
    public final int f9220x;

    /* renamed from: y, reason: collision with root package name */
    public final int f9221y;

    /* renamed from: z, reason: collision with root package name */
    public final int f9222z;

    public c(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(u2.a.a(context, attributeSet, R.attr.sliderStyle, R.style.Widget_MaterialComponents_Slider), attributeSet, R.attr.sliderStyle);
        this.f9210m = new ArrayList();
        this.n = new ArrayList();
        this.f9211o = new ArrayList();
        this.f9212p = false;
        this.f9178J = false;
        this.f9181M = new ArrayList();
        this.f9182N = -1;
        this.f9183O = -1;
        this.f9184P = BitmapDescriptorFactory.HUE_RED;
        this.f9186R = true;
        this.f9190V = false;
        h hVar = new h();
        this.f9201f0 = hVar;
        this.f9203h0 = Collections.emptyList();
        this.f9207j0 = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f9194c = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint paint2 = new Paint();
        this.f9196d = paint2;
        paint2.setStyle(style);
        paint2.setStrokeCap(cap);
        Paint paint3 = new Paint(1);
        this.f9198e = paint3;
        Paint.Style style2 = Paint.Style.FILL;
        paint3.setStyle(style2);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.f9200f = paint4;
        paint4.setStyle(style2);
        Paint paint5 = new Paint();
        this.g = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        Paint paint6 = new Paint();
        this.h = paint6;
        paint6.setStyle(style);
        paint6.setStrokeCap(cap);
        Resources resources = context2.getResources();
        this.f9222z = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.f9216t = dimensionPixelOffset;
        this.f9173D = dimensionPixelOffset;
        this.f9217u = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.f9218v = resources.getDimensionPixelSize(R.dimen.mtrl_slider_track_height);
        this.f9219w = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_radius);
        this.f9220x = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_radius);
        this.f9176G = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
        int[] iArr = O1.a.f1993C;
        m.a(context2, attributeSet, R.attr.sliderStyle, R.style.Widget_MaterialComponents_Slider);
        m.b(context2, attributeSet, iArr, R.attr.sliderStyle, R.style.Widget_MaterialComponents_Slider, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, R.attr.sliderStyle, R.style.Widget_MaterialComponents_Slider);
        this.f9209l = typedArrayObtainStyledAttributes.getResourceId(8, R.style.Widget_MaterialComponents_Tooltip);
        this.f9179K = typedArrayObtainStyledAttributes.getFloat(3, BitmapDescriptorFactory.HUE_RED);
        this.f9180L = typedArrayObtainStyledAttributes.getFloat(4, 1.0f);
        setValues(Float.valueOf(this.f9179K));
        this.f9184P = typedArrayObtainStyledAttributes.getFloat(2, BitmapDescriptorFactory.HUE_RED);
        this.f9221y = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(9, (float) Math.ceil(TypedValue.applyDimension(1, 48, getContext().getResources().getDisplayMetrics()))));
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(21);
        int i5 = zHasValue ? 21 : 23;
        int i6 = zHasValue ? 21 : 22;
        ColorStateList colorStateListF = AbstractC0409x1.f(context2, typedArrayObtainStyledAttributes, i5);
        setTrackInactiveTintList(colorStateListF == null ? C.h.c(context2, R.color.material_slider_inactive_track_color) : colorStateListF);
        ColorStateList colorStateListF2 = AbstractC0409x1.f(context2, typedArrayObtainStyledAttributes, i6);
        setTrackActiveTintList(colorStateListF2 == null ? C.h.c(context2, R.color.material_slider_active_track_color) : colorStateListF2);
        hVar.l(AbstractC0409x1.f(context2, typedArrayObtainStyledAttributes, 10));
        if (typedArrayObtainStyledAttributes.hasValue(13)) {
            setThumbStrokeColor(AbstractC0409x1.f(context2, typedArrayObtainStyledAttributes, 13));
        }
        setThumbStrokeWidth(typedArrayObtainStyledAttributes.getDimension(14, BitmapDescriptorFactory.HUE_RED));
        ColorStateList colorStateListF3 = AbstractC0409x1.f(context2, typedArrayObtainStyledAttributes, 5);
        setHaloTintList(colorStateListF3 == null ? C.h.c(context2, R.color.material_slider_halo_color) : colorStateListF3);
        this.f9186R = typedArrayObtainStyledAttributes.getBoolean(20, true);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(15);
        int i7 = zHasValue2 ? 15 : 17;
        int i8 = zHasValue2 ? 15 : 16;
        ColorStateList colorStateListF4 = AbstractC0409x1.f(context2, typedArrayObtainStyledAttributes, i7);
        setTickInactiveTintList(colorStateListF4 == null ? C.h.c(context2, R.color.material_slider_inactive_tick_marks_color) : colorStateListF4);
        ColorStateList colorStateListF5 = AbstractC0409x1.f(context2, typedArrayObtainStyledAttributes, i8);
        setTickActiveTintList(colorStateListF5 == null ? C.h.c(context2, R.color.material_slider_active_tick_marks_color) : colorStateListF5);
        setThumbRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0));
        setHaloRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0));
        setThumbElevation(typedArrayObtainStyledAttributes.getDimension(11, BitmapDescriptorFactory.HUE_RED));
        setTrackHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(24, 0));
        setTickActiveRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(18, 0));
        setTickInactiveRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(19, 0));
        setLabelBehavior(typedArrayObtainStyledAttributes.getInt(7, 0));
        if (!typedArrayObtainStyledAttributes.getBoolean(0, true)) {
            setEnabled(false);
        }
        typedArrayObtainStyledAttributes.recycle();
        setFocusable(true);
        setClickable(true);
        hVar.m();
        this.f9215s = ViewConfiguration.get(context2).getScaledTouchSlop();
        C0834a c0834a = new C0834a((Slider) this);
        this.f9204i = c0834a;
        Y.k(this, c0834a);
        this.f9206j = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public final void a(Drawable drawable) {
        int i5 = this.f9174E * 2;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, i5, i5);
        } else {
            float fMax = i5 / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * fMax), (int) (intrinsicHeight * fMax));
        }
    }

    public final int b() {
        int i5 = this.f9170A / 2;
        int i6 = this.f9171B;
        return i5 + ((i6 == 1 || i6 == 3) ? ((C0921a) this.f9210m.get(0)).getIntrinsicHeight() : 0);
    }

    public final ValueAnimator c(boolean z4) {
        int iV;
        TimeInterpolator timeInterpolatorW;
        float fFloatValue = z4 ? 0.0f : 1.0f;
        ValueAnimator valueAnimator = z4 ? this.f9214r : this.f9213q;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, z4 ? 1.0f : 0.0f);
        if (z4) {
            iV = A2.b.v(getContext(), R.attr.motionDurationMedium4, 83);
            timeInterpolatorW = A2.b.w(getContext(), R.attr.motionEasingEmphasizedInterpolator, P1.a.f2068e);
        } else {
            iV = A2.b.v(getContext(), R.attr.motionDurationShort3, 117);
            timeInterpolatorW = A2.b.w(getContext(), R.attr.motionEasingEmphasizedAccelerateInterpolator, P1.a.f2066c);
        }
        valueAnimatorOfFloat.setDuration(iV);
        valueAnimatorOfFloat.setInterpolator(timeInterpolatorW);
        valueAnimatorOfFloat.addUpdateListener(new V1.a(3, this));
        return valueAnimatorOfFloat;
    }

    public final void d(Canvas canvas, int i5, int i6, float f5, Drawable drawable) {
        canvas.save();
        canvas.translate((this.f9173D + ((int) (m(f5) * i5))) - (drawable.getBounds().width() / 2.0f), i6 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.f9204i.m(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        this.f9194c.setColor(f(this.f9199e0));
        this.f9196d.setColor(f(this.f9197d0));
        this.g.setColor(f(this.f9195c0));
        this.h.setColor(f(this.f9193b0));
        Iterator it = this.f9210m.iterator();
        while (it.hasNext()) {
            C0921a c0921a = (C0921a) it.next();
            if (c0921a.isStateful()) {
                c0921a.setState(getDrawableState());
            }
        }
        h hVar = this.f9201f0;
        if (hVar.isStateful()) {
            hVar.setState(getDrawableState());
        }
        Paint paint = this.f9200f;
        paint.setColor(f(this.f9192a0));
        paint.setAlpha(63);
    }

    public final float[] e() {
        float fFloatValue = ((Float) Collections.max(getValues())).floatValue();
        float fFloatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.f9181M.size() == 1) {
            fFloatValue2 = this.f9179K;
        }
        float fM = m(fFloatValue2);
        float fM2 = m(fFloatValue);
        return i() ? new float[]{fM2, fM} : new float[]{fM, fM2};
    }

    public final int f(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    public final boolean g(float f5) {
        double dDoubleValue = new BigDecimal(Float.toString(f5)).divide(new BigDecimal(Float.toString(this.f9184P)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(dDoubleValue)) - dDoubleValue) < 1.0E-4d;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f9204i.f2545k;
    }

    public float getMinSeparation() {
        return BitmapDescriptorFactory.HUE_RED;
    }

    public abstract float getValueFrom();

    public abstract float getValueTo();

    public List<Float> getValues() {
        return new ArrayList(this.f9181M);
    }

    public final boolean h(MotionEvent motionEvent) {
        if (motionEvent.getToolType(0) == 3) {
            return false;
        }
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    public final boolean i() {
        WeakHashMap weakHashMap = Y.f1904a;
        return H.d(this) == 1;
    }

    public final void j() {
        if (this.f9184P <= BitmapDescriptorFactory.HUE_RED) {
            return;
        }
        v();
        int iMin = Math.min((int) (((this.f9180L - this.f9179K) / this.f9184P) + 1.0f), (this.f9189U / (this.f9172C * 2)) + 1);
        float[] fArr = this.f9185Q;
        if (fArr == null || fArr.length != iMin * 2) {
            this.f9185Q = new float[iMin * 2];
        }
        float f5 = this.f9189U / (iMin - 1);
        for (int i5 = 0; i5 < iMin * 2; i5 += 2) {
            float[] fArr2 = this.f9185Q;
            fArr2[i5] = ((i5 / 2.0f) * f5) + this.f9173D;
            fArr2[i5 + 1] = b();
        }
    }

    public final boolean k(int i5) {
        int i6 = this.f9183O;
        long j5 = i6 + i5;
        long size = this.f9181M.size() - 1;
        if (j5 < 0) {
            j5 = 0;
        } else if (j5 > size) {
            j5 = size;
        }
        int i7 = (int) j5;
        this.f9183O = i7;
        if (i7 == i6) {
            return false;
        }
        if (this.f9182N != -1) {
            this.f9182N = i7;
        }
        t();
        postInvalidate();
        return true;
    }

    public final void l(int i5) {
        if (i()) {
            i5 = i5 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i5;
        }
        k(i5);
    }

    public final float m(float f5) {
        float f6 = this.f9179K;
        float f7 = (f5 - f6) / (this.f9180L - f6);
        return i() ? 1.0f - f7 : f7;
    }

    public final void n() {
        Iterator it = this.f9211o.iterator();
        if (it.hasNext()) {
            com.unified.ur1.SatelliteTracker.h.p(it.next());
            throw null;
        }
    }

    public final void o(C0921a c0921a, float f5) {
        String str = String.format(((float) ((int) f5)) == f5 ? "%.0f" : "%.2f", Float.valueOf(f5));
        if (!TextUtils.equals(c0921a.f10028z, str)) {
            c0921a.f10028z = str;
            c0921a.f10016C.f6944e = true;
            c0921a.invalidateSelf();
        }
        int iM = (this.f9173D + ((int) (m(f5) * this.f9189U))) - (c0921a.getIntrinsicWidth() / 2);
        int iB = b() - (this.f9176G + this.f9174E);
        c0921a.setBounds(iM, iB - c0921a.getIntrinsicHeight(), c0921a.getIntrinsicWidth() + iM, iB);
        Rect rect = new Rect(c0921a.getBounds());
        AbstractC0539c.b(m.e(this), this, rect);
        c0921a.setBounds(rect);
        ((ViewOverlay) m.f(this).f1554d).add(c0921a);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator it = this.f9210m.iterator();
        while (it.hasNext()) {
            C0921a c0921a = (C0921a) it.next();
            ViewGroup viewGroupE = m.e(this);
            if (viewGroupE == null) {
                c0921a.getClass();
            } else {
                c0921a.getClass();
                int[] iArr = new int[2];
                viewGroupE.getLocationOnScreen(iArr);
                c0921a.f10023K = iArr[0];
                viewGroupE.getWindowVisibleDisplayFrame(c0921a.f10018E);
                viewGroupE.addOnLayoutChangeListener(c0921a.f10017D);
            }
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        r rVar = this.f9208k;
        if (rVar != null) {
            removeCallbacks(rVar);
        }
        this.f9212p = false;
        Iterator it = this.f9210m.iterator();
        while (it.hasNext()) {
            C0921a c0921a = (C0921a) it.next();
            l lVarF = m.f(this);
            if (lVarF != null) {
                ((ViewOverlay) lVarF.f1554d).remove(c0921a);
                ViewGroup viewGroupE = m.e(this);
                if (viewGroupE == null) {
                    c0921a.getClass();
                } else {
                    viewGroupE.removeOnLayoutChangeListener(c0921a.f10017D);
                }
            }
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f9191W) {
            v();
            j();
        }
        super.onDraw(canvas);
        int iB = b();
        int i5 = this.f9189U;
        float[] fArrE = e();
        int i6 = this.f9173D;
        float f5 = i5;
        float f6 = i6 + (fArrE[1] * f5);
        float f7 = i6 + i5;
        Paint paint = this.f9194c;
        if (f6 < f7) {
            float f8 = iB;
            canvas.drawLine(f6, f8, f7, f8, paint);
        }
        float f9 = this.f9173D;
        float f10 = (fArrE[0] * f5) + f9;
        if (f10 > f9) {
            float f11 = iB;
            canvas.drawLine(f9, f11, f10, f11, paint);
        }
        if (((Float) Collections.max(getValues())).floatValue() > this.f9179K) {
            int i7 = this.f9189U;
            float[] fArrE2 = e();
            float f12 = this.f9173D;
            float f13 = i7;
            float f14 = iB;
            canvas.drawLine((fArrE2[0] * f13) + f12, f14, (fArrE2[1] * f13) + f12, f14, this.f9196d);
        }
        if (this.f9186R && this.f9184P > BitmapDescriptorFactory.HUE_RED) {
            float[] fArrE3 = e();
            int iRound = Math.round(fArrE3[0] * ((this.f9185Q.length / 2) - 1));
            int iRound2 = Math.round(fArrE3[1] * ((this.f9185Q.length / 2) - 1));
            float[] fArr = this.f9185Q;
            int i8 = iRound * 2;
            Paint paint2 = this.g;
            canvas.drawPoints(fArr, 0, i8, paint2);
            int i9 = iRound2 * 2;
            canvas.drawPoints(this.f9185Q, i8, i9 - i8, this.h);
            float[] fArr2 = this.f9185Q;
            canvas.drawPoints(fArr2, i9, fArr2.length - i9, paint2);
        }
        if ((this.f9178J || isFocused()) && isEnabled()) {
            int i10 = this.f9189U;
            if (!(getBackground() instanceof RippleDrawable)) {
                canvas.drawCircle((int) ((m(((Float) this.f9181M.get(this.f9183O)).floatValue()) * i10) + this.f9173D), iB, this.f9175F, this.f9200f);
            }
        }
        if ((this.f9182N != -1 || this.f9171B == 3) && isEnabled()) {
            if (this.f9171B != 2) {
                if (!this.f9212p) {
                    this.f9212p = true;
                    ValueAnimator valueAnimatorC = c(true);
                    this.f9213q = valueAnimatorC;
                    this.f9214r = null;
                    valueAnimatorC.start();
                }
                ArrayList arrayList = this.f9210m;
                Iterator it = arrayList.iterator();
                for (int i11 = 0; i11 < this.f9181M.size() && it.hasNext(); i11++) {
                    if (i11 != this.f9183O) {
                        o((C0921a) it.next(), ((Float) this.f9181M.get(i11)).floatValue());
                    }
                }
                if (!it.hasNext()) {
                    throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(arrayList.size()), Integer.valueOf(this.f9181M.size())));
                }
                o((C0921a) it.next(), ((Float) this.f9181M.get(this.f9183O)).floatValue());
            }
        } else if (this.f9212p) {
            this.f9212p = false;
            ValueAnimator valueAnimatorC2 = c(false);
            this.f9214r = valueAnimatorC2;
            this.f9213q = null;
            valueAnimatorC2.addListener(new S1.a(4, this));
            this.f9214r.start();
        }
        int i12 = this.f9189U;
        for (int i13 = 0; i13 < this.f9181M.size(); i13++) {
            float fFloatValue = ((Float) this.f9181M.get(i13)).floatValue();
            Drawable drawable = this.f9202g0;
            if (drawable != null) {
                d(canvas, i12, iB, fFloatValue, drawable);
            } else if (i13 < this.f9203h0.size()) {
                d(canvas, i12, iB, fFloatValue, (Drawable) this.f9203h0.get(i13));
            } else {
                if (!isEnabled()) {
                    canvas.drawCircle((m(fFloatValue) * i12) + this.f9173D, iB, this.f9174E, this.f9198e);
                }
                d(canvas, i12, iB, fFloatValue, this.f9201f0);
            }
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z4, int i5, Rect rect) {
        super.onFocusChanged(z4, i5, rect);
        C0834a c0834a = this.f9204i;
        if (!z4) {
            this.f9182N = -1;
            c0834a.j(this.f9183O);
            return;
        }
        if (i5 == 1) {
            k(Integer.MAX_VALUE);
        } else if (i5 == 2) {
            k(Integer.MIN_VALUE);
        } else if (i5 == 17) {
            l(Integer.MAX_VALUE);
        } else if (i5 == 66) {
            l(Integer.MIN_VALUE);
        }
        c0834a.w(this.f9183O);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onKeyDown(int r14, android.view.KeyEvent r15) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.c.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i5, KeyEvent keyEvent) {
        this.f9190V = false;
        return super.onKeyUp(i5, keyEvent);
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        int i7 = this.f9170A;
        int i8 = this.f9171B;
        super.onMeasure(i5, View.MeasureSpec.makeMeasureSpec(i7 + ((i8 == 1 || i8 == 3) ? ((C0921a) this.f9210m.get(0)).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        this.f9179K = bVar.f9166j;
        this.f9180L = bVar.f9167k;
        p(bVar.f9168l);
        this.f9184P = bVar.f9169m;
        if (bVar.n) {
            requestFocus();
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f9166j = this.f9179K;
        bVar.f9167k = this.f9180L;
        bVar.f9168l = new ArrayList(this.f9181M);
        bVar.f9169m = this.f9184P;
        bVar.n = hasFocus();
        return bVar;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i5, int i6, int i7, int i8) {
        this.f9189U = Math.max(i5 - (this.f9173D * 2), 0);
        j();
        t();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.c.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i5) {
        l lVarF;
        super.onVisibilityChanged(view, i5);
        if (i5 == 0 || (lVarF = m.f(this)) == null) {
            return;
        }
        Iterator it = this.f9210m.iterator();
        while (it.hasNext()) {
            ((ViewOverlay) lVarF.f1554d).remove((C0921a) it.next());
        }
    }

    public final void p(ArrayList arrayList) {
        ViewGroup viewGroupE;
        int resourceId;
        l lVarF;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.f9181M.size() == arrayList.size() && this.f9181M.equals(arrayList)) {
            return;
        }
        this.f9181M = arrayList;
        this.f9191W = true;
        this.f9183O = 0;
        t();
        ArrayList arrayList2 = this.f9210m;
        if (arrayList2.size() > this.f9181M.size()) {
            List<C0921a> listSubList = arrayList2.subList(this.f9181M.size(), arrayList2.size());
            for (C0921a c0921a : listSubList) {
                WeakHashMap weakHashMap = Y.f1904a;
                if (J.b(this) && (lVarF = m.f(this)) != null) {
                    ((ViewOverlay) lVarF.f1554d).remove(c0921a);
                    ViewGroup viewGroupE2 = m.e(this);
                    if (viewGroupE2 == null) {
                        c0921a.getClass();
                    } else {
                        viewGroupE2.removeOnLayoutChangeListener(c0921a.f10017D);
                    }
                }
            }
            listSubList.clear();
        }
        while (true) {
            k2.d dVar = null;
            if (arrayList2.size() >= this.f9181M.size()) {
                break;
            }
            Context context = getContext();
            int i5 = this.f9209l;
            C0921a c0921a2 = new C0921a(context, i5);
            TypedArray typedArrayI = m.i(c0921a2.f10014A, null, O1.a.I, 0, i5, new int[0]);
            Context context2 = c0921a2.f10014A;
            c0921a2.f10022J = context2.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
            n2.l lVarE = c0921a2.f8806c.f8787a.e();
            lVarE.f8836k = c0921a2.s();
            c0921a2.setShapeAppearanceModel(lVarE.a());
            CharSequence text = typedArrayI.getText(6);
            boolean zEquals = TextUtils.equals(c0921a2.f10028z, text);
            C0546j c0546j = c0921a2.f10016C;
            if (!zEquals) {
                c0921a2.f10028z = text;
                c0546j.f6944e = true;
                c0921a2.invalidateSelf();
            }
            if (typedArrayI.hasValue(0) && (resourceId = typedArrayI.getResourceId(0, 0)) != 0) {
                dVar = new k2.d(context2, resourceId);
            }
            if (dVar != null && typedArrayI.hasValue(1)) {
                dVar.f7930j = AbstractC0409x1.f(context2, typedArrayI, 1);
            }
            c0546j.c(dVar, context2);
            TypedValue typedValueH = AbstractC0399v1.h(R.attr.colorOnBackground, context2, C0921a.class.getCanonicalName());
            int i6 = typedValueH.resourceId;
            int iA = i6 != 0 ? C.d.a(context2, i6) : typedValueH.data;
            TypedValue typedValueH2 = AbstractC0399v1.h(android.R.attr.colorBackground, context2, C0921a.class.getCanonicalName());
            int i7 = typedValueH2.resourceId;
            c0921a2.l(ColorStateList.valueOf(typedArrayI.getColor(7, E.a.b(E.a.d(iA, 153), E.a.d(i7 != 0 ? C.d.a(context2, i7) : typedValueH2.data, 229)))));
            TypedValue typedValueH3 = AbstractC0399v1.h(R.attr.colorSurface, context2, C0921a.class.getCanonicalName());
            int i8 = typedValueH3.resourceId;
            c0921a2.n(ColorStateList.valueOf(i8 != 0 ? C.d.a(context2, i8) : typedValueH3.data));
            c0921a2.f10019F = typedArrayI.getDimensionPixelSize(2, 0);
            c0921a2.f10020G = typedArrayI.getDimensionPixelSize(4, 0);
            c0921a2.f10021H = typedArrayI.getDimensionPixelSize(5, 0);
            c0921a2.I = typedArrayI.getDimensionPixelSize(3, 0);
            typedArrayI.recycle();
            arrayList2.add(c0921a2);
            WeakHashMap weakHashMap2 = Y.f1904a;
            if (J.b(this) && (viewGroupE = m.e(this)) != null) {
                int[] iArr = new int[2];
                viewGroupE.getLocationOnScreen(iArr);
                c0921a2.f10023K = iArr[0];
                viewGroupE.getWindowVisibleDisplayFrame(c0921a2.f10018E);
                viewGroupE.addOnLayoutChangeListener(c0921a2.f10017D);
            }
        }
        int i9 = arrayList2.size() == 1 ? 0 : 1;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            C0921a c0921a3 = (C0921a) it.next();
            c0921a3.f8806c.f8795k = i9;
            c0921a3.invalidateSelf();
        }
        Iterator it2 = this.n.iterator();
        while (it2.hasNext()) {
            com.unified.ur1.SatelliteTracker.h.p(it2.next());
            Iterator it3 = this.f9181M.iterator();
            if (it3.hasNext()) {
                ((Float) it3.next()).getClass();
                throw null;
            }
        }
        postInvalidate();
    }

    public final boolean q(int i5, float f5) {
        this.f9183O = i5;
        if (Math.abs(f5 - ((Float) this.f9181M.get(i5)).floatValue()) < 1.0E-4d) {
            return false;
        }
        float minSeparation = getMinSeparation();
        if (this.f9207j0 == 0) {
            if (minSeparation == BitmapDescriptorFactory.HUE_RED) {
                minSeparation = 0.0f;
            } else {
                float f6 = this.f9179K;
                minSeparation = ((f6 - this.f9180L) * ((minSeparation - this.f9173D) / this.f9189U)) + f6;
            }
        }
        if (i()) {
            minSeparation = -minSeparation;
        }
        int i6 = i5 + 1;
        float fFloatValue = i6 >= this.f9181M.size() ? this.f9180L : ((Float) this.f9181M.get(i6)).floatValue() - minSeparation;
        int i7 = i5 - 1;
        float fFloatValue2 = i7 < 0 ? this.f9179K : minSeparation + ((Float) this.f9181M.get(i7)).floatValue();
        if (f5 < fFloatValue2) {
            f5 = fFloatValue2;
        } else if (f5 > fFloatValue) {
            f5 = fFloatValue;
        }
        this.f9181M.set(i5, Float.valueOf(f5));
        Iterator it = this.n.iterator();
        if (it.hasNext()) {
            com.unified.ur1.SatelliteTracker.h.p(it.next());
            ((Float) this.f9181M.get(i5)).getClass();
            throw null;
        }
        AccessibilityManager accessibilityManager = this.f9206j;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return true;
        }
        Runnable runnable = this.f9208k;
        if (runnable == null) {
            this.f9208k = new r(this);
        } else {
            removeCallbacks(runnable);
        }
        r rVar = this.f9208k;
        rVar.f118k = i5;
        postDelayed(rVar, 200L);
        return true;
    }

    public final void r() {
        double dRound;
        float f5 = this.f9205i0;
        float f6 = this.f9184P;
        if (f6 > BitmapDescriptorFactory.HUE_RED) {
            dRound = Math.round(f5 * r1) / ((int) ((this.f9180L - this.f9179K) / f6));
        } else {
            dRound = f5;
        }
        if (i()) {
            dRound = 1.0d - dRound;
        }
        float f7 = this.f9180L;
        q(this.f9182N, (float) ((dRound * (f7 - r1)) + this.f9179K));
    }

    public final void s(int i5, Rect rect) {
        int iM = this.f9173D + ((int) (m(getValues().get(i5).floatValue()) * this.f9189U));
        int iB = b();
        int i6 = this.f9174E;
        int i7 = this.f9221y;
        if (i6 <= i7) {
            i6 = i7;
        }
        int i8 = i6 / 2;
        rect.set(iM - i8, iB - i8, iM + i8, iB + i8);
    }

    public void setActiveThumbIndex(int i5) {
        this.f9182N = i5;
    }

    public void setCustomThumbDrawablesForValues(int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            drawableArr[i5] = getResources().getDrawable(iArr[i5]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
        setLayerType(z4 ? 0 : 2, null);
    }

    public abstract void setHaloRadius(int i5);

    public abstract void setHaloTintList(ColorStateList colorStateList);

    public abstract void setLabelBehavior(int i5);

    public void setSeparationUnit(int i5) {
        this.f9207j0 = i5;
        this.f9191W = true;
        postInvalidate();
    }

    public abstract void setThumbElevation(float f5);

    public abstract void setThumbRadius(int i5);

    public abstract void setThumbStrokeColor(ColorStateList colorStateList);

    public abstract void setThumbStrokeWidth(float f5);

    public abstract void setTickActiveRadius(int i5);

    public abstract void setTickActiveTintList(ColorStateList colorStateList);

    public abstract void setTickInactiveRadius(int i5);

    public abstract void setTickInactiveTintList(ColorStateList colorStateList);

    public abstract void setTrackActiveTintList(ColorStateList colorStateList);

    public abstract void setTrackHeight(int i5);

    public abstract void setTrackInactiveTintList(ColorStateList colorStateList);

    public void setValues(Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        p(arrayList);
    }

    public final void t() {
        if ((!(getBackground() instanceof RippleDrawable)) || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int iM = (int) ((m(((Float) this.f9181M.get(this.f9183O)).floatValue()) * this.f9189U) + this.f9173D);
            int iB = b();
            int i5 = this.f9175F;
            F.b.f(background, iM - i5, iB - i5, iM + i5, iB + i5);
        }
    }

    public final void u() {
        boolean z4;
        int iMax = Math.max(this.f9222z, Math.max(this.f9172C + getPaddingBottom() + getPaddingTop(), getPaddingBottom() + getPaddingTop() + (this.f9174E * 2)));
        boolean z5 = false;
        if (iMax == this.f9170A) {
            z4 = false;
        } else {
            this.f9170A = iMax;
            z4 = true;
        }
        int iMax2 = Math.max(Math.max(Math.max(this.f9174E - this.f9217u, 0), Math.max((this.f9172C - this.f9218v) / 2, 0)), Math.max(Math.max(this.f9187S - this.f9219w, 0), Math.max(this.f9188T - this.f9220x, 0))) + this.f9216t;
        if (this.f9173D != iMax2) {
            this.f9173D = iMax2;
            WeakHashMap weakHashMap = Y.f1904a;
            if (J.c(this)) {
                this.f9189U = Math.max(getWidth() - (this.f9173D * 2), 0);
                j();
            }
            z5 = true;
        }
        if (z4) {
            requestLayout();
        } else if (z5) {
            postInvalidate();
        }
    }

    public final void v() {
        if (this.f9191W) {
            float f5 = this.f9179K;
            float f6 = this.f9180L;
            if (f5 >= f6) {
                throw new IllegalStateException("valueFrom(" + this.f9179K + ") must be smaller than valueTo(" + this.f9180L + ")");
            }
            if (f6 <= f5) {
                throw new IllegalStateException("valueTo(" + this.f9180L + ") must be greater than valueFrom(" + this.f9179K + ")");
            }
            if (this.f9184P > BitmapDescriptorFactory.HUE_RED && !g(f6 - f5)) {
                throw new IllegalStateException("The stepSize(" + this.f9184P + ") must be 0, or a factor of the valueFrom(" + this.f9179K + ")-valueTo(" + this.f9180L + ") range");
            }
            Iterator it = this.f9181M.iterator();
            while (it.hasNext()) {
                Float f7 = (Float) it.next();
                if (f7.floatValue() < this.f9179K || f7.floatValue() > this.f9180L) {
                    throw new IllegalStateException("Slider value(" + f7 + ") must be greater or equal to valueFrom(" + this.f9179K + "), and lower or equal to valueTo(" + this.f9180L + ")");
                }
                if (this.f9184P > BitmapDescriptorFactory.HUE_RED && !g(f7.floatValue() - this.f9179K)) {
                    float f8 = this.f9179K;
                    float f9 = this.f9184P;
                    throw new IllegalStateException("Value(" + f7 + ") must be equal to valueFrom(" + f8 + ") plus a multiple of stepSize(" + f9 + ") when using stepSize(" + f9 + ")");
                }
            }
            float minSeparation = getMinSeparation();
            if (minSeparation < BitmapDescriptorFactory.HUE_RED) {
                throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal to 0");
            }
            float f10 = this.f9184P;
            if (f10 > BitmapDescriptorFactory.HUE_RED && minSeparation > BitmapDescriptorFactory.HUE_RED) {
                if (this.f9207j0 != 1) {
                    throw new IllegalStateException("minSeparation(" + minSeparation + ") cannot be set as a dimension when using stepSize(" + this.f9184P + ")");
                }
                if (minSeparation < f10 || !g(minSeparation)) {
                    float f11 = this.f9184P;
                    throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal and a multiple of stepSize(" + f11 + ") when using stepSize(" + f11 + ")");
                }
            }
            float f12 = this.f9184P;
            if (f12 != BitmapDescriptorFactory.HUE_RED) {
                if (((int) f12) != f12) {
                    Log.w("c", "Floating point value used for stepSize(" + f12 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
                float f13 = this.f9179K;
                if (((int) f13) != f13) {
                    Log.w("c", "Floating point value used for valueFrom(" + f13 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
                float f14 = this.f9180L;
                if (((int) f14) != f14) {
                    Log.w("c", "Floating point value used for valueTo(" + f14 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
            }
            this.f9191W = false;
        }
    }

    public void setValues(List<Float> list) {
        p(new ArrayList(list));
    }

    public void setCustomThumbDrawablesForValues(Drawable... drawableArr) {
        this.f9202g0 = null;
        this.f9203h0 = new ArrayList();
        for (Drawable drawable : drawableArr) {
            List list = this.f9203h0;
            Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
            a(drawableNewDrawable);
            list.add(drawableNewDrawable);
        }
        postInvalidate();
    }
}
