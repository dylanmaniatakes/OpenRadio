package androidx.swiperefreshlayout.widget;

import O.C0179s;
import O.C0182v;
import O.G;
import O.InterfaceC0180t;
import O.InterfaceC0181u;
import O.M;
import O.Y;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.WeakHashMap;
import t0.a;
import u0.C0905a;
import u0.d;
import u0.e;
import u0.f;
import u0.g;
import u0.h;
import u0.i;
import u0.j;
import u0.k;

/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements InterfaceC0181u, InterfaceC0180t {

    /* renamed from: M, reason: collision with root package name */
    public static final int[] f4407M = {R.attr.enabled};

    /* renamed from: A, reason: collision with root package name */
    public int f4408A;

    /* renamed from: B, reason: collision with root package name */
    public final e f4409B;

    /* renamed from: C, reason: collision with root package name */
    public g f4410C;

    /* renamed from: D, reason: collision with root package name */
    public g f4411D;

    /* renamed from: E, reason: collision with root package name */
    public h f4412E;

    /* renamed from: F, reason: collision with root package name */
    public h f4413F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f4414G;

    /* renamed from: H, reason: collision with root package name */
    public int f4415H;
    public boolean I;

    /* renamed from: J, reason: collision with root package name */
    public final f f4416J;

    /* renamed from: K, reason: collision with root package name */
    public final g f4417K;

    /* renamed from: L, reason: collision with root package name */
    public final g f4418L;

    /* renamed from: c, reason: collision with root package name */
    public View f4419c;

    /* renamed from: d, reason: collision with root package name */
    public j f4420d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4421e;

    /* renamed from: f, reason: collision with root package name */
    public final int f4422f;
    public float g;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public final C0182v f4423i;

    /* renamed from: j, reason: collision with root package name */
    public final C0179s f4424j;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f4425k;

    /* renamed from: l, reason: collision with root package name */
    public final int[] f4426l;

    /* renamed from: m, reason: collision with root package name */
    public final int[] f4427m;
    public boolean n;

    /* renamed from: o, reason: collision with root package name */
    public final int f4428o;

    /* renamed from: p, reason: collision with root package name */
    public int f4429p;

    /* renamed from: q, reason: collision with root package name */
    public float f4430q;

    /* renamed from: r, reason: collision with root package name */
    public float f4431r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4432s;

    /* renamed from: t, reason: collision with root package name */
    public int f4433t;

    /* renamed from: u, reason: collision with root package name */
    public final DecelerateInterpolator f4434u;

    /* renamed from: v, reason: collision with root package name */
    public final C0905a f4435v;

    /* renamed from: w, reason: collision with root package name */
    public int f4436w;

    /* renamed from: x, reason: collision with root package name */
    public int f4437x;

    /* renamed from: y, reason: collision with root package name */
    public final int f4438y;

    /* renamed from: z, reason: collision with root package name */
    public final int f4439z;

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4421e = false;
        this.g = -1.0f;
        this.f4425k = new int[2];
        this.f4426l = new int[2];
        this.f4427m = new int[2];
        this.f4433t = -1;
        this.f4436w = -1;
        this.f4416J = new f(this, 0);
        this.f4417K = new g(this, 2);
        this.f4418L = new g(this, 3);
        this.f4422f = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f4428o = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f4434u = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f4415H = (int) (displayMetrics.density * 40.0f);
        C0905a c0905a = new C0905a(getContext());
        float f5 = c0905a.getContext().getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = c0905a.getContext().obtainStyledAttributes(a.f9696a);
        c0905a.f9880d = typedArrayObtainStyledAttributes.getColor(0, -328966);
        typedArrayObtainStyledAttributes.recycle();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        WeakHashMap weakHashMap = Y.f1904a;
        M.s(c0905a, f5 * 4.0f);
        shapeDrawable.getPaint().setColor(c0905a.f9880d);
        G.q(c0905a, shapeDrawable);
        this.f4435v = c0905a;
        e eVar = new e(getContext());
        this.f4409B = eVar;
        eVar.c(1);
        this.f4435v.setImageDrawable(this.f4409B);
        this.f4435v.setVisibility(8);
        addView(this.f4435v);
        setChildrenDrawingOrderEnabled(true);
        int i5 = (int) (displayMetrics.density * 64.0f);
        this.f4439z = i5;
        this.g = i5;
        this.f4423i = new C0182v();
        this.f4424j = new C0179s(this);
        setNestedScrollingEnabled(true);
        int i6 = -this.f4415H;
        this.f4429p = i6;
        this.f4438y = i6;
        k(1.0f);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f4407M);
        setEnabled(typedArrayObtainStyledAttributes2.getBoolean(0, true));
        typedArrayObtainStyledAttributes2.recycle();
    }

    private void setColorViewAlpha(int i5) {
        this.f4435v.getBackground().setAlpha(i5);
        this.f4409B.setAlpha(i5);
    }

    @Override // O.InterfaceC0180t
    public final void a(View view, View view2, int i5, int i6) {
        if (i6 == 0) {
            onNestedScrollAccepted(view, view2, i5);
        }
    }

    @Override // O.InterfaceC0180t
    public final void b(View view, int i5) {
        if (i5 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // O.InterfaceC0180t
    public final void c(View view, int i5, int i6, int[] iArr, int i7) {
        if (i7 == 0) {
            onNestedPreScroll(view, i5, i6, iArr);
        }
    }

    @Override // O.InterfaceC0181u
    public final void d(View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        if (i9 != 0) {
            return;
        }
        int i10 = iArr[1];
        if (i9 == 0) {
            this.f4424j.d(i5, i6, i7, i8, this.f4426l, i9, iArr);
        }
        int i11 = i8 - (iArr[1] - i10);
        if ((i11 == 0 ? i8 + this.f4426l[1] : i11) >= 0 || g()) {
            return;
        }
        float fAbs = this.h + Math.abs(r2);
        this.h = fAbs;
        j(fAbs);
        iArr[1] = iArr[1] + i11;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f5, float f6, boolean z4) {
        return this.f4424j.a(f5, f6, z4);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f5, float f6) {
        return this.f4424j.b(f5, f6);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i5, int i6, int[] iArr, int[] iArr2) {
        return this.f4424j.c(i5, i6, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i5, int i6, int i7, int i8, int[] iArr) {
        return this.f4424j.d(i5, i6, i7, i8, iArr, 0, null);
    }

    @Override // O.InterfaceC0180t
    public final void e(View view, int i5, int i6, int i7, int i8, int i9) {
        d(view, i5, i6, i7, i8, i9, this.f4427m);
    }

    @Override // O.InterfaceC0180t
    public final boolean f(View view, View view2, int i5, int i6) {
        if (i6 == 0) {
            return onStartNestedScroll(view, view2, i5);
        }
        return false;
    }

    public final boolean g() {
        View view = this.f4419c;
        return view instanceof ListView ? S.h.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i5, int i6) {
        int i7 = this.f4436w;
        return i7 < 0 ? i6 : i6 == i5 + (-1) ? i7 : i6 >= i7 ? i6 + 1 : i6;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0182v c0182v = this.f4423i;
        return c0182v.f1975b | c0182v.f1974a;
    }

    public int getProgressCircleDiameter() {
        return this.f4415H;
    }

    public int getProgressViewEndOffset() {
        return this.f4439z;
    }

    public int getProgressViewStartOffset() {
        return this.f4438y;
    }

    public final void h() {
        if (this.f4419c == null) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                if (!childAt.equals(this.f4435v)) {
                    this.f4419c = childAt;
                    return;
                }
            }
        }
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.f4424j.f(0);
    }

    public final void i(float f5) {
        if (f5 > this.g) {
            m(true, true);
            return;
        }
        this.f4421e = false;
        e eVar = this.f4409B;
        d dVar = eVar.f9906c;
        dVar.f9889e = BitmapDescriptorFactory.HUE_RED;
        dVar.f9890f = BitmapDescriptorFactory.HUE_RED;
        eVar.invalidateSelf();
        f fVar = new f(this, 1);
        this.f4437x = this.f4429p;
        g gVar = this.f4418L;
        gVar.reset();
        gVar.setDuration(200L);
        gVar.setInterpolator(this.f4434u);
        C0905a c0905a = this.f4435v;
        c0905a.f9879c = fVar;
        c0905a.clearAnimation();
        this.f4435v.startAnimation(gVar);
        e eVar2 = this.f4409B;
        d dVar2 = eVar2.f9906c;
        if (dVar2.n) {
            dVar2.n = false;
        }
        eVar2.invalidateSelf();
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.f4424j.f1963d;
    }

    public final void j(float f5) {
        h hVar;
        h hVar2;
        e eVar = this.f4409B;
        d dVar = eVar.f9906c;
        if (!dVar.n) {
            dVar.n = true;
        }
        eVar.invalidateSelf();
        float fMin = Math.min(1.0f, Math.abs(f5 / this.g));
        float fMax = (((float) Math.max(fMin - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f5) - this.g;
        int i5 = this.f4408A;
        if (i5 <= 0) {
            i5 = this.f4439z;
        }
        float f6 = i5;
        double dMax = Math.max(BitmapDescriptorFactory.HUE_RED, Math.min(fAbs, f6 * 2.0f) / f6) / 4.0f;
        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f;
        int i6 = this.f4438y + ((int) ((f6 * fMin) + (f6 * fPow * 2.0f)));
        if (this.f4435v.getVisibility() != 0) {
            this.f4435v.setVisibility(0);
        }
        this.f4435v.setScaleX(1.0f);
        this.f4435v.setScaleY(1.0f);
        if (f5 < this.g) {
            if (this.f4409B.f9906c.f9901t > 76 && ((hVar2 = this.f4412E) == null || !hVar2.hasStarted() || hVar2.hasEnded())) {
                h hVar3 = new h(this, this.f4409B.f9906c.f9901t, 76);
                hVar3.setDuration(300L);
                C0905a c0905a = this.f4435v;
                c0905a.f9879c = null;
                c0905a.clearAnimation();
                this.f4435v.startAnimation(hVar3);
                this.f4412E = hVar3;
            }
        } else if (this.f4409B.f9906c.f9901t < 255 && ((hVar = this.f4413F) == null || !hVar.hasStarted() || hVar.hasEnded())) {
            h hVar4 = new h(this, this.f4409B.f9906c.f9901t, 255);
            hVar4.setDuration(300L);
            C0905a c0905a2 = this.f4435v;
            c0905a2.f9879c = null;
            c0905a2.clearAnimation();
            this.f4435v.startAnimation(hVar4);
            this.f4413F = hVar4;
        }
        e eVar2 = this.f4409B;
        float fMin2 = Math.min(0.8f, fMax * 0.8f);
        d dVar2 = eVar2.f9906c;
        dVar2.f9889e = BitmapDescriptorFactory.HUE_RED;
        dVar2.f9890f = fMin2;
        eVar2.invalidateSelf();
        e eVar3 = this.f4409B;
        float fMin3 = Math.min(1.0f, fMax);
        d dVar3 = eVar3.f9906c;
        if (fMin3 != dVar3.f9897p) {
            dVar3.f9897p = fMin3;
        }
        eVar3.invalidateSelf();
        e eVar4 = this.f4409B;
        eVar4.f9906c.g = ((fPow * 2.0f) + ((fMax * 0.4f) - 0.25f)) * 0.5f;
        eVar4.invalidateSelf();
        setTargetOffsetTopAndBottom(i6 - this.f4429p);
    }

    public final void k(float f5) {
        setTargetOffsetTopAndBottom((this.f4437x + ((int) ((this.f4438y - r0) * f5))) - this.f4435v.getTop());
    }

    public final void l() {
        this.f4435v.clearAnimation();
        this.f4409B.stop();
        this.f4435v.setVisibility(8);
        setColorViewAlpha(255);
        setTargetOffsetTopAndBottom(this.f4438y - this.f4429p);
        this.f4429p = this.f4435v.getTop();
    }

    public final void m(boolean z4, boolean z5) {
        if (this.f4421e != z4) {
            this.f4414G = z5;
            h();
            this.f4421e = z4;
            f fVar = this.f4416J;
            if (!z4) {
                g gVar = new g(this, 1);
                this.f4411D = gVar;
                gVar.setDuration(150L);
                C0905a c0905a = this.f4435v;
                c0905a.f9879c = fVar;
                c0905a.clearAnimation();
                this.f4435v.startAnimation(this.f4411D);
                return;
            }
            this.f4437x = this.f4429p;
            g gVar2 = this.f4417K;
            gVar2.reset();
            gVar2.setDuration(200L);
            gVar2.setInterpolator(this.f4434u);
            if (fVar != null) {
                this.f4435v.f9879c = fVar;
            }
            this.f4435v.clearAnimation();
            this.f4435v.startAnimation(gVar2);
        }
    }

    public final void n(float f5) {
        float f6 = this.f4431r;
        float f7 = f5 - f6;
        int i5 = this.f4422f;
        if (f7 <= i5 || this.f4432s) {
            return;
        }
        this.f4430q = f6 + i5;
        this.f4432s = true;
        this.f4409B.setAlpha(76);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            r5.h()
            int r0 = r6.getActionMasked()
            boolean r1 = r5.isEnabled()
            r2 = 0
            if (r1 == 0) goto L88
            boolean r1 = r5.g()
            if (r1 != 0) goto L88
            boolean r1 = r5.f4421e
            if (r1 != 0) goto L88
            boolean r1 = r5.n
            if (r1 == 0) goto L1e
            goto L88
        L1e:
            if (r0 == 0) goto L64
            r1 = 1
            r3 = -1
            if (r0 == r1) goto L5f
            r4 = 2
            if (r0 == r4) goto L44
            r4 = 3
            if (r0 == r4) goto L5f
            r3 = 6
            if (r0 == r3) goto L2e
            goto L85
        L2e:
            int r0 = r6.getActionIndex()
            int r3 = r6.getPointerId(r0)
            int r4 = r5.f4433t
            if (r3 != r4) goto L85
            if (r0 != 0) goto L3d
            r2 = r1
        L3d:
            int r6 = r6.getPointerId(r2)
            r5.f4433t = r6
            goto L85
        L44:
            int r0 = r5.f4433t
            if (r0 != r3) goto L50
            java.lang.String r6 = "SwipeRefreshLayout"
            java.lang.String r0 = "Got ACTION_MOVE event but don't have an active pointer id."
            android.util.Log.e(r6, r0)
            return r2
        L50:
            int r0 = r6.findPointerIndex(r0)
            if (r0 >= 0) goto L57
            return r2
        L57:
            float r6 = r6.getY(r0)
            r5.n(r6)
            goto L85
        L5f:
            r5.f4432s = r2
            r5.f4433t = r3
            goto L85
        L64:
            u0.a r0 = r5.f4435v
            int r0 = r0.getTop()
            int r1 = r5.f4438y
            int r1 = r1 - r0
            r5.setTargetOffsetTopAndBottom(r1)
            int r0 = r6.getPointerId(r2)
            r5.f4433t = r0
            r5.f4432s = r2
            int r0 = r6.findPointerIndex(r0)
            if (r0 >= 0) goto L7f
            return r2
        L7f:
            float r6 = r6.getY(r0)
            r5.f4431r = r6
        L85:
            boolean r6 = r5.f4432s
            return r6
        L88:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f4419c == null) {
            h();
        }
        View view = this.f4419c;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.f4435v.getMeasuredWidth();
        int measuredHeight2 = this.f4435v.getMeasuredHeight();
        int i9 = measuredWidth / 2;
        int i10 = measuredWidth2 / 2;
        int i11 = this.f4429p;
        this.f4435v.layout(i9 - i10, i11, i9 + i10, measuredHeight2 + i11);
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (this.f4419c == null) {
            h();
        }
        View view = this.f4419c;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f4435v.measure(View.MeasureSpec.makeMeasureSpec(this.f4415H, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f4415H, 1073741824));
        this.f4436w = -1;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            if (getChildAt(i7) == this.f4435v) {
                this.f4436w = i7;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f5, float f6, boolean z4) {
        return this.f4424j.a(f5, f6, z4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f5, float f6) {
        return this.f4424j.b(f5, f6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i5, int i6, int[] iArr) {
        if (i6 > 0) {
            float f5 = this.h;
            if (f5 > BitmapDescriptorFactory.HUE_RED) {
                float f6 = i6;
                if (f6 > f5) {
                    iArr[1] = (int) f5;
                    this.h = BitmapDescriptorFactory.HUE_RED;
                } else {
                    this.h = f5 - f6;
                    iArr[1] = i6;
                }
                j(this.h);
            }
        }
        int i7 = i5 - iArr[0];
        int i8 = i6 - iArr[1];
        int[] iArr2 = this.f4425k;
        if (dispatchNestedPreScroll(i7, i8, iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i5, int i6, int i7, int i8) {
        d(view, i5, i6, i7, i8, 0, this.f4427m);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i5) {
        this.f4423i.f1974a = i5;
        startNestedScroll(i5 & 2);
        this.h = BitmapDescriptorFactory.HUE_RED;
        this.n = true;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        k kVar = (k) parcelable;
        super.onRestoreInstanceState(kVar.getSuperState());
        setRefreshing(kVar.f9917j);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new k(super.onSaveInstanceState(), this.f4421e);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i5) {
        return (!isEnabled() || this.f4421e || (i5 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        this.f4423i.f1974a = 0;
        this.n = false;
        float f5 = this.h;
        if (f5 > BitmapDescriptorFactory.HUE_RED) {
            i(f5);
            this.h = BitmapDescriptorFactory.HUE_RED;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (!isEnabled() || g() || this.f4421e || this.n) {
            return false;
        }
        if (actionMasked == 0) {
            this.f4433t = motionEvent.getPointerId(0);
            this.f4432s = false;
        } else {
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f4433t);
                if (iFindPointerIndex < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.f4432s) {
                    float y4 = (motionEvent.getY(iFindPointerIndex) - this.f4430q) * 0.5f;
                    this.f4432s = false;
                    i(y4);
                }
                this.f4433t = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.f4433t);
                if (iFindPointerIndex2 < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y5 = motionEvent.getY(iFindPointerIndex2);
                n(y5);
                if (this.f4432s) {
                    float f5 = (y5 - this.f4430q) * 0.5f;
                    if (f5 <= BitmapDescriptorFactory.HUE_RED) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    j(f5);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e("SwipeRefreshLayout", "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.f4433t = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    int actionIndex2 = motionEvent.getActionIndex();
                    if (motionEvent.getPointerId(actionIndex2) == this.f4433t) {
                        this.f4433t = motionEvent.getPointerId(actionIndex2 == 0 ? 1 : 0);
                    }
                }
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z4) {
        ViewParent parent;
        View view = this.f4419c;
        if (view != null) {
            WeakHashMap weakHashMap = Y.f1904a;
            if (!M.p(view)) {
                if (this.I || (parent = getParent()) == null) {
                    return;
                }
                parent.requestDisallowInterceptTouchEvent(z4);
                return;
            }
        }
        super.requestDisallowInterceptTouchEvent(z4);
    }

    public void setAnimationProgress(float f5) {
        this.f4435v.setScaleX(f5);
        this.f4435v.setScaleY(f5);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        h();
        e eVar = this.f4409B;
        d dVar = eVar.f9906c;
        dVar.f9891i = iArr;
        dVar.a(0);
        dVar.a(0);
        eVar.invalidateSelf();
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            iArr2[i5] = C.d.a(context, iArr[i5]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i5) {
        this.g = i5;
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
        if (z4) {
            return;
        }
        l();
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z4) {
        this.I = z4;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z4) {
        C0179s c0179s = this.f4424j;
        if (c0179s.f1963d) {
            WeakHashMap weakHashMap = Y.f1904a;
            M.z(c0179s.f1962c);
        }
        c0179s.f1963d = z4;
    }

    public void setOnChildScrollUpCallback(i iVar) {
    }

    public void setOnRefreshListener(j jVar) {
        this.f4420d = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i5) {
        setProgressBackgroundColorSchemeResource(i5);
    }

    public void setProgressBackgroundColorSchemeColor(int i5) {
        this.f4435v.setBackgroundColor(i5);
    }

    public void setProgressBackgroundColorSchemeResource(int i5) {
        setProgressBackgroundColorSchemeColor(C.d.a(getContext(), i5));
    }

    public void setRefreshing(boolean z4) {
        if (!z4 || this.f4421e == z4) {
            m(z4, false);
            return;
        }
        this.f4421e = z4;
        setTargetOffsetTopAndBottom((this.f4439z + this.f4438y) - this.f4429p);
        this.f4414G = false;
        f fVar = this.f4416J;
        this.f4435v.setVisibility(0);
        this.f4409B.setAlpha(255);
        g gVar = new g(this, 0);
        this.f4410C = gVar;
        gVar.setDuration(this.f4428o);
        if (fVar != null) {
            this.f4435v.f9879c = fVar;
        }
        this.f4435v.clearAnimation();
        this.f4435v.startAnimation(this.f4410C);
    }

    public void setSize(int i5) {
        if (i5 == 0 || i5 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i5 == 0) {
                this.f4415H = (int) (displayMetrics.density * 56.0f);
            } else {
                this.f4415H = (int) (displayMetrics.density * 40.0f);
            }
            this.f4435v.setImageDrawable(null);
            this.f4409B.c(i5);
            this.f4435v.setImageDrawable(this.f4409B);
        }
    }

    public void setSlingshotDistance(int i5) {
        this.f4408A = i5;
    }

    public void setTargetOffsetTopAndBottom(int i5) {
        C0905a c0905a = this.f4435v;
        c0905a.bringToFront();
        WeakHashMap weakHashMap = Y.f1904a;
        c0905a.offsetTopAndBottom(i5);
        this.f4429p = c0905a.getTop();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i5) {
        return this.f4424j.g(i5, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        this.f4424j.h(0);
    }
}
