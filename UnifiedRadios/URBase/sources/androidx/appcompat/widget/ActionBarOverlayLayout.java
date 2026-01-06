package androidx.appcompat.widget;

import O.C0182v;
import O.D0;
import O.F0;
import O.G;
import O.InterfaceC0180t;
import O.InterfaceC0181u;
import O.K;
import O.M;
import O.Y;
import O.u0;
import O.v0;
import O.w0;
import O.x0;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import com.unified.ur1.R;
import f.C0463I;
import i.l;
import j.m;
import j.y;
import java.util.WeakHashMap;
import k.C0625d;
import k.C0637j;
import k.InterfaceC0623c;
import k.InterfaceC0632g0;
import k.InterfaceC0634h0;
import k.RunnableC0621b;
import k.a1;
import k.f1;
import org.conscrypt.PSKKeyManager;
import w1.AbstractC0930a;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements InterfaceC0632g0, InterfaceC0180t, InterfaceC0181u {

    /* renamed from: D, reason: collision with root package name */
    public static final int[] f3336D = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};

    /* renamed from: A, reason: collision with root package name */
    public final RunnableC0621b f3337A;

    /* renamed from: B, reason: collision with root package name */
    public final RunnableC0621b f3338B;

    /* renamed from: C, reason: collision with root package name */
    public final C0182v f3339C;

    /* renamed from: c, reason: collision with root package name */
    public int f3340c;

    /* renamed from: d, reason: collision with root package name */
    public int f3341d;

    /* renamed from: e, reason: collision with root package name */
    public ContentFrameLayout f3342e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContainer f3343f;
    public InterfaceC0634h0 g;
    public Drawable h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3344i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3345j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3346k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3347l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3348m;
    public int n;

    /* renamed from: o, reason: collision with root package name */
    public int f3349o;

    /* renamed from: p, reason: collision with root package name */
    public final Rect f3350p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f3351q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f3352r;

    /* renamed from: s, reason: collision with root package name */
    public F0 f3353s;

    /* renamed from: t, reason: collision with root package name */
    public F0 f3354t;

    /* renamed from: u, reason: collision with root package name */
    public F0 f3355u;

    /* renamed from: v, reason: collision with root package name */
    public F0 f3356v;

    /* renamed from: w, reason: collision with root package name */
    public InterfaceC0623c f3357w;

    /* renamed from: x, reason: collision with root package name */
    public OverScroller f3358x;

    /* renamed from: y, reason: collision with root package name */
    public ViewPropertyAnimator f3359y;

    /* renamed from: z, reason: collision with root package name */
    public final S1.a f3360z;

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3341d = 0;
        this.f3350p = new Rect();
        this.f3351q = new Rect();
        this.f3352r = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        F0 f02 = F0.f1893b;
        this.f3353s = f02;
        this.f3354t = f02;
        this.f3355u = f02;
        this.f3356v = f02;
        this.f3360z = new S1.a(3, this);
        this.f3337A = new RunnableC0621b(this, 0);
        this.f3338B = new RunnableC0621b(this, 1);
        i(context);
        this.f3339C = new C0182v();
    }

    public static boolean g(View view, Rect rect, boolean z4) {
        boolean z5;
        C0625d c0625d = (C0625d) view.getLayoutParams();
        int i5 = ((ViewGroup.MarginLayoutParams) c0625d).leftMargin;
        int i6 = rect.left;
        if (i5 != i6) {
            ((ViewGroup.MarginLayoutParams) c0625d).leftMargin = i6;
            z5 = true;
        } else {
            z5 = false;
        }
        int i7 = ((ViewGroup.MarginLayoutParams) c0625d).topMargin;
        int i8 = rect.top;
        if (i7 != i8) {
            ((ViewGroup.MarginLayoutParams) c0625d).topMargin = i8;
            z5 = true;
        }
        int i9 = ((ViewGroup.MarginLayoutParams) c0625d).rightMargin;
        int i10 = rect.right;
        if (i9 != i10) {
            ((ViewGroup.MarginLayoutParams) c0625d).rightMargin = i10;
            z5 = true;
        }
        if (z4) {
            int i11 = ((ViewGroup.MarginLayoutParams) c0625d).bottomMargin;
            int i12 = rect.bottom;
            if (i11 != i12) {
                ((ViewGroup.MarginLayoutParams) c0625d).bottomMargin = i12;
                return true;
            }
        }
        return z5;
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
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0625d;
    }

    @Override // O.InterfaceC0181u
    public final void d(View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        e(view, i5, i6, i7, i8, i9);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.h == null || this.f3344i) {
            return;
        }
        if (this.f3343f.getVisibility() == 0) {
            translationY = (int) (this.f3343f.getTranslationY() + this.f3343f.getBottom() + 0.5f);
        } else {
            translationY = 0;
        }
        this.h.setBounds(0, translationY, getWidth(), this.h.getIntrinsicHeight() + translationY);
        this.h.draw(canvas);
    }

    @Override // O.InterfaceC0180t
    public final void e(View view, int i5, int i6, int i7, int i8, int i9) {
        if (i9 == 0) {
            onNestedScroll(view, i5, i6, i7, i8);
        }
    }

    @Override // O.InterfaceC0180t
    public final boolean f(View view, View view2, int i5, int i6) {
        return i6 == 0 && onStartNestedScroll(view, view2, i5);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0625d(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0625d(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f3343f;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0182v c0182v = this.f3339C;
        return c0182v.f1975b | c0182v.f1974a;
    }

    public CharSequence getTitle() {
        k();
        return ((f1) this.g).f7769a.getTitle();
    }

    public final void h() {
        removeCallbacks(this.f3337A);
        removeCallbacks(this.f3338B);
        ViewPropertyAnimator viewPropertyAnimator = this.f3359y;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void i(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f3336D);
        this.f3340c = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.h = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f3344i = context.getApplicationInfo().targetSdkVersion < 19;
        this.f3358x = new OverScroller(context);
    }

    public final void j(int i5) {
        k();
        if (i5 == 2) {
            ((f1) this.g).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i5 == 5) {
            ((f1) this.g).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else {
            if (i5 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public final void k() {
        InterfaceC0634h0 wrapper;
        if (this.f3342e == null) {
            this.f3342e = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f3343f = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof InterfaceC0634h0) {
                wrapper = (InterfaceC0634h0) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.g = wrapper;
        }
    }

    public final void l(Menu menu, y yVar) {
        k();
        f1 f1Var = (f1) this.g;
        C0637j c0637j = f1Var.f7779m;
        Toolbar toolbar = f1Var.f7769a;
        if (c0637j == null) {
            C0637j c0637j2 = new C0637j(toolbar.getContext());
            f1Var.f7779m = c0637j2;
            c0637j2.f7795k = R.id.action_menu_presenter;
        }
        C0637j c0637j3 = f1Var.f7779m;
        c0637j3.g = yVar;
        m mVar = (m) menu;
        if (mVar == null && toolbar.f3461c == null) {
            return;
        }
        toolbar.f();
        m mVar2 = toolbar.f3461c.f3364r;
        if (mVar2 == mVar) {
            return;
        }
        if (mVar2 != null) {
            mVar2.r(toolbar.f3452N);
            mVar2.r(toolbar.f3453O);
        }
        if (toolbar.f3453O == null) {
            toolbar.f3453O = new a1(toolbar);
        }
        c0637j3.f7803t = true;
        if (mVar != null) {
            mVar.b(c0637j3, toolbar.f3468l);
            mVar.b(toolbar.f3453O, toolbar.f3468l);
        } else {
            c0637j3.h(toolbar.f3468l, null);
            toolbar.f3453O.h(toolbar.f3468l, null);
            c0637j3.g(true);
            toolbar.f3453O.g(true);
        }
        toolbar.f3461c.setPopupTheme(toolbar.f3469m);
        toolbar.f3461c.setPresenter(c0637j3);
        toolbar.f3452N = c0637j3;
        toolbar.x();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        k();
        F0 f0G = F0.g(this, windowInsets);
        boolean zG = g(this.f3343f, new Rect(f0G.b(), f0G.d(), f0G.c(), f0G.a()), false);
        WeakHashMap weakHashMap = Y.f1904a;
        Rect rect = this.f3350p;
        M.b(this, f0G, rect);
        int i5 = rect.left;
        int i6 = rect.top;
        int i7 = rect.right;
        int i8 = rect.bottom;
        D0 d02 = f0G.f1894a;
        F0 f0L = d02.l(i5, i6, i7, i8);
        this.f3353s = f0L;
        boolean z4 = true;
        if (!this.f3354t.equals(f0L)) {
            this.f3354t = this.f3353s;
            zG = true;
        }
        Rect rect2 = this.f3351q;
        if (rect2.equals(rect)) {
            z4 = zG;
        } else {
            rect2.set(rect);
        }
        if (z4) {
            requestLayout();
        }
        return d02.a().f1894a.c().f1894a.b().f();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i(getContext());
        WeakHashMap weakHashMap = Y.f1904a;
        K.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                C0625d c0625d = (C0625d) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i10 = ((ViewGroup.MarginLayoutParams) c0625d).leftMargin + paddingLeft;
                int i11 = ((ViewGroup.MarginLayoutParams) c0625d).topMargin + paddingTop;
                childAt.layout(i10, i11, measuredWidth + i10, measuredHeight + i11);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        int measuredHeight;
        k();
        measureChildWithMargins(this.f3343f, i5, 0, i6, 0);
        C0625d c0625d = (C0625d) this.f3343f.getLayoutParams();
        int iMax = Math.max(0, this.f3343f.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0625d).leftMargin + ((ViewGroup.MarginLayoutParams) c0625d).rightMargin);
        int iMax2 = Math.max(0, this.f3343f.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0625d).topMargin + ((ViewGroup.MarginLayoutParams) c0625d).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f3343f.getMeasuredState());
        WeakHashMap weakHashMap = Y.f1904a;
        boolean z4 = (G.g(this) & PSKKeyManager.MAX_KEY_LENGTH_BYTES) != 0;
        if (z4) {
            measuredHeight = this.f3340c;
            if (this.f3346k && this.f3343f.getTabContainer() != null) {
                measuredHeight += this.f3340c;
            }
        } else {
            measuredHeight = this.f3343f.getVisibility() != 8 ? this.f3343f.getMeasuredHeight() : 0;
        }
        Rect rect = this.f3350p;
        Rect rect2 = this.f3352r;
        rect2.set(rect);
        F0 f02 = this.f3353s;
        this.f3355u = f02;
        if (this.f3345j || z4) {
            E.c cVarB = E.c.b(f02.b(), this.f3355u.d() + measuredHeight, this.f3355u.c(), this.f3355u.a());
            F0 f03 = this.f3355u;
            int i7 = Build.VERSION.SDK_INT;
            x0 w0Var = i7 >= 30 ? new w0(f03) : i7 >= 29 ? new v0(f03) : new u0(f03);
            w0Var.g(cVarB);
            this.f3355u = w0Var.b();
        } else {
            rect2.top += measuredHeight;
            rect2.bottom = rect2.bottom;
            this.f3355u = f02.f1894a.l(0, measuredHeight, 0, 0);
        }
        g(this.f3342e, rect2, true);
        if (!this.f3356v.equals(this.f3355u)) {
            F0 f04 = this.f3355u;
            this.f3356v = f04;
            ContentFrameLayout contentFrameLayout = this.f3342e;
            WindowInsets windowInsetsF = f04.f();
            if (windowInsetsF != null) {
                WindowInsets windowInsetsA = K.a(contentFrameLayout, windowInsetsF);
                if (!windowInsetsA.equals(windowInsetsF)) {
                    F0.g(contentFrameLayout, windowInsetsA);
                }
            }
        }
        measureChildWithMargins(this.f3342e, i5, 0, i6, 0);
        C0625d c0625d2 = (C0625d) this.f3342e.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f3342e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0625d2).leftMargin + ((ViewGroup.MarginLayoutParams) c0625d2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f3342e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0625d2).topMargin + ((ViewGroup.MarginLayoutParams) c0625d2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f3342e.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax3, getSuggestedMinimumWidth()), i5, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax4, getSuggestedMinimumHeight()), i6, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f5, float f6, boolean z4) {
        if (!this.f3347l || !z4) {
            return false;
        }
        this.f3358x.fling(0, 0, 0, (int) f6, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f3358x.getFinalY() > this.f3343f.getHeight()) {
            h();
            this.f3338B.run();
        } else {
            h();
            this.f3337A.run();
        }
        this.f3348m = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f5, float f6) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i5, int i6, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i5, int i6, int i7, int i8) {
        int i9 = this.n + i6;
        this.n = i9;
        setActionBarHideOffset(i9);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i5) {
        C0463I c0463i;
        l lVar;
        this.f3339C.f1974a = i5;
        this.n = getActionBarHideOffset();
        h();
        InterfaceC0623c interfaceC0623c = this.f3357w;
        if (interfaceC0623c == null || (lVar = (c0463i = (C0463I) interfaceC0623c).f6281t) == null) {
            return;
        }
        lVar.a();
        c0463i.f6281t = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i5) {
        if ((i5 & 2) == 0 || this.f3343f.getVisibility() != 0) {
            return false;
        }
        return this.f3347l;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f3347l || this.f3348m) {
            return;
        }
        if (this.n <= this.f3343f.getHeight()) {
            h();
            postDelayed(this.f3337A, 600L);
        } else {
            h();
            postDelayed(this.f3338B, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i5) {
        super.onWindowSystemUiVisibilityChanged(i5);
        k();
        int i6 = this.f3349o ^ i5;
        this.f3349o = i5;
        boolean z4 = (i5 & 4) == 0;
        boolean z5 = (i5 & PSKKeyManager.MAX_KEY_LENGTH_BYTES) != 0;
        InterfaceC0623c interfaceC0623c = this.f3357w;
        if (interfaceC0623c != null) {
            ((C0463I) interfaceC0623c).f6276o = !z5;
            if (z4 || !z5) {
                C0463I c0463i = (C0463I) interfaceC0623c;
                if (c0463i.f6278q) {
                    c0463i.f6278q = false;
                    c0463i.v(true);
                }
            } else {
                C0463I c0463i2 = (C0463I) interfaceC0623c;
                if (!c0463i2.f6278q) {
                    c0463i2.f6278q = true;
                    c0463i2.v(true);
                }
            }
        }
        if ((i6 & PSKKeyManager.MAX_KEY_LENGTH_BYTES) == 0 || this.f3357w == null) {
            return;
        }
        WeakHashMap weakHashMap = Y.f1904a;
        K.c(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i5) {
        super.onWindowVisibilityChanged(i5);
        this.f3341d = i5;
        InterfaceC0623c interfaceC0623c = this.f3357w;
        if (interfaceC0623c != null) {
            ((C0463I) interfaceC0623c).n = i5;
        }
    }

    public void setActionBarHideOffset(int i5) {
        h();
        this.f3343f.setTranslationY(-Math.max(0, Math.min(i5, this.f3343f.getHeight())));
    }

    public void setActionBarVisibilityCallback(InterfaceC0623c interfaceC0623c) {
        this.f3357w = interfaceC0623c;
        if (getWindowToken() != null) {
            ((C0463I) this.f3357w).n = this.f3341d;
            int i5 = this.f3349o;
            if (i5 != 0) {
                onWindowSystemUiVisibilityChanged(i5);
                WeakHashMap weakHashMap = Y.f1904a;
                K.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z4) {
        this.f3346k = z4;
    }

    public void setHideOnContentScrollEnabled(boolean z4) {
        if (z4 != this.f3347l) {
            this.f3347l = z4;
            if (z4) {
                return;
            }
            h();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i5) {
        k();
        f1 f1Var = (f1) this.g;
        f1Var.f7772d = i5 != 0 ? AbstractC0930a.k(f1Var.f7769a.getContext(), i5) : null;
        f1Var.c();
    }

    public void setLogo(int i5) {
        k();
        f1 f1Var = (f1) this.g;
        f1Var.f7773e = i5 != 0 ? AbstractC0930a.k(f1Var.f7769a.getContext(), i5) : null;
        f1Var.c();
    }

    public void setOverlayMode(boolean z4) {
        this.f3345j = z4;
        this.f3344i = z4 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z4) {
    }

    public void setUiOptions(int i5) {
    }

    @Override // k.InterfaceC0632g0
    public void setWindowCallback(Window.Callback callback) {
        k();
        ((f1) this.g).f7777k = callback;
    }

    @Override // k.InterfaceC0632g0
    public void setWindowTitle(CharSequence charSequence) {
        k();
        f1 f1Var = (f1) this.g;
        if (f1Var.g) {
            return;
        }
        f1Var.h = charSequence;
        if ((f1Var.f7770b & 8) != 0) {
            Toolbar toolbar = f1Var.f7769a;
            toolbar.setTitle(charSequence);
            if (f1Var.g) {
                Y.l(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0625d(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        k();
        f1 f1Var = (f1) this.g;
        f1Var.f7772d = drawable;
        f1Var.c();
    }
}
