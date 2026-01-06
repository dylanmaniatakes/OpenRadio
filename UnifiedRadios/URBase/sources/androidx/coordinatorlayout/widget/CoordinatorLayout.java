package androidx.coordinatorlayout.widget;

import B0.a;
import N.d;
import O.AbstractC0170j;
import O.C0182v;
import O.F0;
import O.G;
import O.H;
import O.InterfaceC0180t;
import O.InterfaceC0181u;
import O.K;
import O.M;
import O.Y;
import X2.t;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.R;
import f2.ViewTreeObserverOnPreDrawListenerC0483g;
import f3.C0519j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import q.k;
import y.AbstractC0975a;
import z.InterfaceC0994a;
import z.b;
import z.c;
import z.e;
import z.f;
import z.g;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements InterfaceC0180t, InterfaceC0181u {

    /* renamed from: v, reason: collision with root package name */
    public static final String f3510v;

    /* renamed from: w, reason: collision with root package name */
    public static final Class[] f3511w;

    /* renamed from: x, reason: collision with root package name */
    public static final ThreadLocal f3512x;

    /* renamed from: y, reason: collision with root package name */
    public static final a f3513y;

    /* renamed from: z, reason: collision with root package name */
    public static final d f3514z;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f3515c;

    /* renamed from: d, reason: collision with root package name */
    public final t f3516d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f3517e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f3518f;
    public final int[] g;
    public final int[] h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3519i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3520j;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f3521k;

    /* renamed from: l, reason: collision with root package name */
    public View f3522l;

    /* renamed from: m, reason: collision with root package name */
    public View f3523m;
    public ViewTreeObserverOnPreDrawListenerC0483g n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3524o;

    /* renamed from: p, reason: collision with root package name */
    public F0 f3525p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3526q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f3527r;

    /* renamed from: s, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f3528s;

    /* renamed from: t, reason: collision with root package name */
    public C0519j f3529t;

    /* renamed from: u, reason: collision with root package name */
    public final C0182v f3530u;

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f3510v = r02 != null ? r02.getName() : null;
        f3513y = new a(11);
        f3511w = new Class[]{Context.class, AttributeSet.class};
        f3512x = new ThreadLocal();
        f3514z = new d(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, R.attr.coordinatorLayoutStyle);
        this.f3515c = new ArrayList();
        this.f3516d = new t(9);
        this.f3517e = new ArrayList();
        this.f3518f = new ArrayList();
        this.g = new int[2];
        this.h = new int[2];
        this.f3530u = new C0182v();
        int[] iArr = AbstractC0975a.f10456a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.coordinatorLayoutStyle, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, R.attr.coordinatorLayoutStyle, 0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.f3521k = intArray;
            float f5 = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i5 = 0; i5 < length; i5++) {
                this.f3521k[i5] = (int) (r2[i5] * f5);
            }
        }
        this.f3527r = typedArrayObtainStyledAttributes.getDrawable(1);
        typedArrayObtainStyledAttributes.recycle();
        w();
        super.setOnHierarchyChangeListener(new z.d(this));
        WeakHashMap weakHashMap = Y.f1904a;
        if (G.c(this) == 0) {
            G.s(this, 1);
        }
    }

    public static Rect g() {
        Rect rect = (Rect) f3514z.a();
        return rect == null ? new Rect() : rect;
    }

    public static void l(int i5, Rect rect, Rect rect2, e eVar, int i6, int i7) {
        int i8 = eVar.f10531c;
        if (i8 == 0) {
            i8 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i8, i5);
        int i9 = eVar.f10532d;
        if ((i9 & 7) == 0) {
            i9 |= 8388611;
        }
        if ((i9 & 112) == 0) {
            i9 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i9, i5);
        int i10 = absoluteGravity & 7;
        int i11 = absoluteGravity & 112;
        int i12 = absoluteGravity2 & 7;
        int i13 = absoluteGravity2 & 112;
        int iWidth = i12 != 1 ? i12 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i13 != 16 ? i13 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i10 == 1) {
            iWidth -= i6 / 2;
        } else if (i10 != 5) {
            iWidth -= i6;
        }
        if (i11 == 16) {
            iHeight -= i7 / 2;
        } else if (i11 != 80) {
            iHeight -= i7;
        }
        rect2.set(iWidth, iHeight, i6 + iWidth, i7 + iHeight);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static e n(View view) {
        e eVar = (e) view.getLayoutParams();
        if (!eVar.f10530b) {
            if (view instanceof InterfaceC0994a) {
                b behavior = ((InterfaceC0994a) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                eVar.b(behavior);
                eVar.f10530b = true;
            } else {
                c cVar = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    cVar = (c) superclass.getAnnotation(c.class);
                    if (cVar != null) {
                        break;
                    }
                }
                if (cVar != null) {
                    try {
                        eVar.b((b) cVar.value().getDeclaredConstructor(null).newInstance(null));
                    } catch (Exception e5) {
                        Log.e("CoordinatorLayout", "Default behavior class " + cVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e5);
                    }
                }
                eVar.f10530b = true;
            }
        }
        return eVar;
    }

    public static void u(View view, int i5) {
        e eVar = (e) view.getLayoutParams();
        int i6 = eVar.f10535i;
        if (i6 != i5) {
            WeakHashMap weakHashMap = Y.f1904a;
            view.offsetLeftAndRight(i5 - i6);
            eVar.f10535i = i5;
        }
    }

    public static void v(View view, int i5) {
        e eVar = (e) view.getLayoutParams();
        int i6 = eVar.f10536j;
        if (i6 != i5) {
            WeakHashMap weakHashMap = Y.f1904a;
            view.offsetTopAndBottom(i5 - i6);
            eVar.f10536j = i5;
        }
    }

    @Override // O.InterfaceC0180t
    public final void a(View view, View view2, int i5, int i6) {
        C0182v c0182v = this.f3530u;
        if (i6 == 1) {
            c0182v.f1975b = i5;
        } else {
            c0182v.f1974a = i5;
        }
        this.f3523m = view2;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            ((e) getChildAt(i7).getLayoutParams()).getClass();
        }
    }

    @Override // O.InterfaceC0180t
    public final void b(View view, int i5) {
        C0182v c0182v = this.f3530u;
        if (i5 == 1) {
            c0182v.f1975b = 0;
        } else {
            c0182v.f1974a = 0;
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            e eVar = (e) childAt.getLayoutParams();
            if (eVar.a(i5)) {
                b bVar = eVar.f10529a;
                if (bVar != null) {
                    bVar.p(childAt, view, i5);
                }
                if (i5 == 0) {
                    eVar.n = false;
                } else if (i5 == 1) {
                    eVar.f10540o = false;
                }
                eVar.f10541p = false;
            }
        }
        this.f3523m = null;
    }

    @Override // O.InterfaceC0180t
    public final void c(View view, int i5, int i6, int[] iArr, int i7) {
        b bVar;
        int childCount = getChildCount();
        boolean z4 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.a(i7) && (bVar = eVar.f10529a) != null) {
                    int[] iArr2 = this.g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    bVar.j(this, childAt, view, i5, i6, iArr2, i7);
                    iMax = i5 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i6 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z4 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z4) {
            p(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // O.InterfaceC0181u
    public final void d(View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        b bVar;
        int childCount = getChildCount();
        boolean z4 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.a(i9) && (bVar = eVar.f10529a) != null) {
                    int[] iArr2 = this.g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    bVar.k(this, childAt, i6, i7, i8, iArr2);
                    iMax = i7 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i8 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z4 = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z4) {
            p(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j5) {
        b bVar = ((e) view.getLayoutParams()).f10529a;
        if (bVar != null) {
            bVar.getClass();
        }
        return super.drawChild(canvas, view, j5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f3527r;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // O.InterfaceC0180t
    public final void e(View view, int i5, int i6, int i7, int i8, int i9) {
        d(view, i5, i6, i7, i8, 0, this.h);
    }

    @Override // O.InterfaceC0180t
    public final boolean f(View view, View view2, int i5, int i6) {
        int childCount = getChildCount();
        boolean z4 = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                b bVar = eVar.f10529a;
                if (bVar != null) {
                    boolean zO = bVar.o(childAt, i5, i6);
                    z4 |= zO;
                    if (i6 == 0) {
                        eVar.n = zO;
                    } else if (i6 == 1) {
                        eVar.f10540o = zO;
                    }
                } else if (i6 == 0) {
                    eVar.n = false;
                } else if (i6 == 1) {
                    eVar.f10540o = false;
                }
            }
        }
        return z4;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        s();
        return Collections.unmodifiableList(this.f3515c);
    }

    public final F0 getLastWindowInsets() {
        return this.f3525p;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0182v c0182v = this.f3530u;
        return c0182v.f1975b | c0182v.f1974a;
    }

    public Drawable getStatusBarBackground() {
        return this.f3527r;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final void h(e eVar, Rect rect, int i5, int i6) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i5) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i6) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
        rect.set(iMax, iMax2, i5 + iMax, i6 + iMax2);
    }

    public final void i(View view, Rect rect, boolean z4) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z4) {
            k(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList j(View view) {
        k kVar = (k) this.f3516d.f2834d;
        int i5 = kVar.f9278l;
        ArrayList arrayList = null;
        for (int i6 = 0; i6 < i5; i6++) {
            ArrayList arrayList2 = (ArrayList) kVar.j(i6);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(kVar.h(i6));
            }
        }
        ArrayList arrayList3 = this.f3518f;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    public final void k(View view, Rect rect) {
        ThreadLocal threadLocal = g.f10544a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = g.f10544a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        g.a(this, view, matrix);
        ThreadLocal threadLocal3 = g.f10545b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final int m(int i5) {
        int[] iArr = this.f3521k;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i5);
            return 0;
        }
        if (i5 >= 0 && i5 < iArr.length) {
            return iArr[i5];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i5 + " out of range for " + this);
        return 0;
    }

    public final boolean o(View view, int i5, int i6) {
        d dVar = f3514z;
        Rect rectG = g();
        k(view, rectG);
        try {
            return rectG.contains(i5, i6);
        } finally {
            rectG.setEmpty();
            dVar.c(rectG);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        int i5 = 1;
        super.onAttachedToWindow();
        t(false);
        if (this.f3524o) {
            if (this.n == null) {
                this.n = new ViewTreeObserverOnPreDrawListenerC0483g(i5, this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.n);
        }
        if (this.f3525p == null) {
            WeakHashMap weakHashMap = Y.f1904a;
            if (G.b(this)) {
                K.c(this);
            }
        }
        this.f3520j = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        t(false);
        if (this.f3524o && this.n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.n);
        }
        View view = this.f3523m;
        if (view != null) {
            b(view, 0);
        }
        this.f3520j = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f3526q || this.f3527r == null) {
            return;
        }
        F0 f02 = this.f3525p;
        int iD = f02 != null ? f02.d() : 0;
        if (iD > 0) {
            this.f3527r.setBounds(0, 0, getWidth(), iD);
            this.f3527r.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            t(true);
        }
        boolean zR = r(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            t(true);
        }
        return zR;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        b bVar;
        WeakHashMap weakHashMap = Y.f1904a;
        int iD = H.d(this);
        ArrayList arrayList = this.f3515c;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            View view = (View) arrayList.get(i9);
            if (view.getVisibility() != 8 && ((bVar = ((e) view.getLayoutParams()).f10529a) == null || !bVar.g(this, view, iD))) {
                q(view, iD);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0189  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r33, int r34) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f5, float f6, boolean z4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.a(0)) {
                    b bVar = eVar.f10529a;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f5, float f6) {
        b bVar;
        int childCount = getChildCount();
        boolean zI = false;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.a(0) && (bVar = eVar.f10529a) != null) {
                    zI |= bVar.i(view);
                }
            }
        }
        return zI;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i5, int i6, int[] iArr) {
        c(view, i5, i6, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i5, int i6, int i7, int i8) {
        e(view, i5, i6, i7, i8, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i5) {
        a(view, view2, i5, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.f2507j);
        SparseArray sparseArray = fVar.f10543l;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            int id = childAt.getId();
            b bVar = n(childAt).f10529a;
            if (id != -1 && bVar != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                bVar.m(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableN;
        f fVar = new f(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            int id = childAt.getId();
            b bVar = ((e) childAt.getLayoutParams()).f10529a;
            if (id != -1 && bVar != null && (parcelableN = bVar.n(childAt)) != null) {
                sparseArray.append(id, parcelableN);
            }
        }
        fVar.f10543l = sparseArray;
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i5) {
        return f(view, view2, i5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        b(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[PHI: r3
      0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f3522l
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.r(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2a
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.f3522l
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            z.e r6 = (z.e) r6
            z.b r6 = r6.f10529a
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f3522l
            boolean r6 = r6.q(r7, r1)
        L2a:
            android.view.View r7 = r0.f3522l
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L52
            r1 = 3
            if (r2 != r1) goto L55
        L52:
            r0.t(r5)
        L55:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0044 A[EDGE_INSN: B:146:0x0044->B:10:0x0044 BREAK  A[LOOP:2: B:122:0x02d4->B:139:0x030a], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(int r26) {
        /*
            Method dump skipped, instructions count: 821
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.p(int):void");
    }

    public final void q(View view, int i5) {
        Rect rectG;
        Rect rectG2;
        e eVar = (e) view.getLayoutParams();
        View view2 = eVar.f10537k;
        if (view2 == null && eVar.f10534f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        d dVar = f3514z;
        if (view2 != null) {
            rectG = g();
            rectG2 = g();
            try {
                k(view2, rectG);
                e eVar2 = (e) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                l(i5, rectG, rectG2, eVar2, measuredWidth, measuredHeight);
                h(eVar2, rectG2, measuredWidth, measuredHeight);
                view.layout(rectG2.left, rectG2.top, rectG2.right, rectG2.bottom);
                return;
            } finally {
                rectG.setEmpty();
                dVar.c(rectG);
                rectG2.setEmpty();
                dVar.c(rectG2);
            }
        }
        int i6 = eVar.f10533e;
        if (i6 < 0) {
            e eVar3 = (e) view.getLayoutParams();
            rectG = g();
            rectG.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar3).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar3).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar3).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar3).bottomMargin);
            if (this.f3525p != null) {
                WeakHashMap weakHashMap = Y.f1904a;
                if (G.b(this) && !G.b(view)) {
                    rectG.left = this.f3525p.b() + rectG.left;
                    rectG.top = this.f3525p.d() + rectG.top;
                    rectG.right -= this.f3525p.c();
                    rectG.bottom -= this.f3525p.a();
                }
            }
            rectG2 = g();
            int i7 = eVar3.f10531c;
            if ((i7 & 7) == 0) {
                i7 |= 8388611;
            }
            if ((i7 & 112) == 0) {
                i7 |= 48;
            }
            AbstractC0170j.b(i7, view.getMeasuredWidth(), view.getMeasuredHeight(), rectG, rectG2, i5);
            view.layout(rectG2.left, rectG2.top, rectG2.right, rectG2.bottom);
            return;
        }
        e eVar4 = (e) view.getLayoutParams();
        int i8 = eVar4.f10531c;
        if (i8 == 0) {
            i8 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i8, i5);
        int i9 = absoluteGravity & 7;
        int i10 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i5 == 1) {
            i6 = width - i6;
        }
        int iM = m(i6) - measuredWidth2;
        if (i9 == 1) {
            iM += measuredWidth2 / 2;
        } else if (i9 == 5) {
            iM += measuredWidth2;
        }
        int i11 = i10 != 16 ? i10 != 80 ? 0 : measuredHeight2 : measuredHeight2 / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar4).leftMargin, Math.min(iM, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) eVar4).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar4).topMargin, Math.min(i11, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) eVar4).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth2 + iMax, measuredHeight2 + iMax2);
    }

    public final boolean r(MotionEvent motionEvent, int i5) {
        boolean z4;
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f3517e;
        arrayList.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i6 = childCount - 1; i6 >= 0; i6--) {
            arrayList.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i6) : i6));
        }
        a aVar = f3513y;
        if (aVar != null) {
            Collections.sort(arrayList, aVar);
        }
        int size = arrayList.size();
        MotionEvent motionEventObtain = null;
        boolean zF = false;
        boolean z5 = false;
        for (int i7 = 0; i7 < size; i7++) {
            View view = (View) arrayList.get(i7);
            e eVar = (e) view.getLayoutParams();
            b bVar = eVar.f10529a;
            if (!(zF || z5) || actionMasked == 0) {
                if (!zF && bVar != null) {
                    if (i5 == 0) {
                        zF = bVar.f(this, view, motionEvent);
                    } else if (i5 == 1) {
                        zF = bVar.q(view, motionEvent);
                    }
                    if (zF) {
                        this.f3522l = view;
                    }
                }
                if (eVar.f10529a == null) {
                    eVar.f10539m = false;
                }
                boolean z6 = eVar.f10539m;
                if (z6) {
                    z4 = true;
                } else {
                    eVar.f10539m = z6;
                    z4 = z6;
                }
                z5 = z4 && !z6;
                if (z4 && !z5) {
                    break;
                }
            } else if (bVar != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                }
                if (i5 == 0) {
                    bVar.f(this, view, motionEventObtain);
                } else if (i5 == 1) {
                    bVar.q(view, motionEventObtain);
                }
            }
        }
        arrayList.clear();
        return zF;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        b bVar = ((e) view.getLayoutParams()).f10529a;
        if (bVar != null) {
            bVar.l(this, view);
        }
        return super.requestChildRectangleOnScreen(view, rect, z4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z4) {
        super.requestDisallowInterceptTouchEvent(z4);
        if (!z4 || this.f3519i) {
            return;
        }
        t(false);
        this.f3519i = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.s():void");
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z4) {
        super.setFitsSystemWindows(z4);
        w();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f3528s = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f3527r;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f3527r = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f3527r.setState(getDrawableState());
                }
                Drawable drawable3 = this.f3527r;
                WeakHashMap weakHashMap = Y.f1904a;
                F.c.b(drawable3, H.d(this));
                this.f3527r.setVisible(getVisibility() == 0, false);
                this.f3527r.setCallback(this);
            }
            WeakHashMap weakHashMap2 = Y.f1904a;
            G.k(this);
        }
    }

    public void setStatusBarBackgroundColor(int i5) {
        setStatusBarBackground(new ColorDrawable(i5));
    }

    public void setStatusBarBackgroundResource(int i5) {
        setStatusBarBackground(i5 != 0 ? C.c.b(getContext(), i5) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        super.setVisibility(i5);
        boolean z4 = i5 == 0;
        Drawable drawable = this.f3527r;
        if (drawable == null || drawable.isVisible() == z4) {
            return;
        }
        this.f3527r.setVisible(z4, false);
    }

    public final void t(boolean z4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            b bVar = ((e) childAt.getLayoutParams()).f10529a;
            if (bVar != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0);
                if (z4) {
                    bVar.f(this, childAt, motionEventObtain);
                } else {
                    bVar.q(childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            ((e) getChildAt(i6).getLayoutParams()).f10539m = false;
        }
        this.f3522l = null;
        this.f3519i = false;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3527r;
    }

    public final void w() {
        WeakHashMap weakHashMap = Y.f1904a;
        if (!G.b(this)) {
            M.u(this, null);
            return;
        }
        if (this.f3529t == null) {
            this.f3529t = new C0519j(25, this);
        }
        M.u(this, this.f3529t);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }
}
