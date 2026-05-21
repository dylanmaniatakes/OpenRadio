package androidx.recyclerview.widget;

import O.C0179s;
import O.C0182v;
import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import g0.AbstractC0535a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import k0.AbstractC0670a;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup {

    /* renamed from: C0, reason: collision with root package name */
    public static boolean f4066C0 = false;

    /* renamed from: D0, reason: collision with root package name */
    public static boolean f4067D0 = false;

    /* renamed from: E0, reason: collision with root package name */
    public static final int[] f4068E0 = {R.attr.nestedScrollingEnabled};

    /* renamed from: F0, reason: collision with root package name */
    public static final float f4069F0 = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* renamed from: G0, reason: collision with root package name */
    public static final boolean f4070G0 = true;

    /* renamed from: H0, reason: collision with root package name */
    public static final boolean f4071H0 = true;

    /* renamed from: I0, reason: collision with root package name */
    public static final boolean f4072I0 = true;

    /* renamed from: J0, reason: collision with root package name */
    public static final Class[] f4073J0;

    /* renamed from: K0, reason: collision with root package name */
    public static final W.d f4074K0;

    /* renamed from: L0, reason: collision with root package name */
    public static final k0 f4075L0;

    /* renamed from: A, reason: collision with root package name */
    public boolean f4076A;

    /* renamed from: A0, reason: collision with root package name */
    public int f4077A0;

    /* renamed from: B, reason: collision with root package name */
    public int f4078B;

    /* renamed from: B0, reason: collision with root package name */
    public final L f4079B0;

    /* renamed from: C, reason: collision with root package name */
    public boolean f4080C;

    /* renamed from: D, reason: collision with root package name */
    public final AccessibilityManager f4081D;

    /* renamed from: E, reason: collision with root package name */
    public ArrayList f4082E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f4083F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f4084G;

    /* renamed from: H, reason: collision with root package name */
    public int f4085H;
    public int I;

    /* renamed from: J, reason: collision with root package name */
    public S f4086J;

    /* renamed from: K, reason: collision with root package name */
    public EdgeEffect f4087K;

    /* renamed from: L, reason: collision with root package name */
    public EdgeEffect f4088L;

    /* renamed from: M, reason: collision with root package name */
    public EdgeEffect f4089M;

    /* renamed from: N, reason: collision with root package name */
    public EdgeEffect f4090N;

    /* renamed from: O, reason: collision with root package name */
    public T f4091O;

    /* renamed from: P, reason: collision with root package name */
    public int f4092P;

    /* renamed from: Q, reason: collision with root package name */
    public int f4093Q;

    /* renamed from: R, reason: collision with root package name */
    public VelocityTracker f4094R;

    /* renamed from: S, reason: collision with root package name */
    public int f4095S;

    /* renamed from: T, reason: collision with root package name */
    public int f4096T;

    /* renamed from: U, reason: collision with root package name */
    public int f4097U;

    /* renamed from: V, reason: collision with root package name */
    public int f4098V;

    /* renamed from: W, reason: collision with root package name */
    public int f4099W;

    /* renamed from: a0, reason: collision with root package name */
    public Z f4100a0;

    /* renamed from: b0, reason: collision with root package name */
    public final int f4101b0;

    /* renamed from: c, reason: collision with root package name */
    public final float f4102c;

    /* renamed from: c0, reason: collision with root package name */
    public final int f4103c0;

    /* renamed from: d, reason: collision with root package name */
    public final f0 f4104d;

    /* renamed from: d0, reason: collision with root package name */
    public final float f4105d0;

    /* renamed from: e, reason: collision with root package name */
    public final d0 f4106e;

    /* renamed from: e0, reason: collision with root package name */
    public final float f4107e0;

    /* renamed from: f, reason: collision with root package name */
    public g0 f4108f;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f4109f0;
    public final C0255b g;

    /* renamed from: g0, reason: collision with root package name */
    public final m0 f4110g0;
    public final C0258e h;

    /* renamed from: h0, reason: collision with root package name */
    public RunnableC0278z f4111h0;

    /* renamed from: i, reason: collision with root package name */
    public final L0.e f4112i;

    /* renamed from: i0, reason: collision with root package name */
    public final Q1.b f4113i0;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4114j;

    /* renamed from: j0, reason: collision with root package name */
    public final j0 f4115j0;

    /* renamed from: k, reason: collision with root package name */
    public final K f4116k;

    /* renamed from: k0, reason: collision with root package name */
    public a0 f4117k0;

    /* renamed from: l, reason: collision with root package name */
    public final Rect f4118l;

    /* renamed from: l0, reason: collision with root package name */
    public ArrayList f4119l0;

    /* renamed from: m, reason: collision with root package name */
    public final Rect f4120m;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f4121m0;
    public final RectF n;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f4122n0;

    /* renamed from: o, reason: collision with root package name */
    public N f4123o;

    /* renamed from: o0, reason: collision with root package name */
    public final L f4124o0;

    /* renamed from: p, reason: collision with root package name */
    public X f4125p;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f4126p0;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f4127q;

    /* renamed from: q0, reason: collision with root package name */
    public p0 f4128q0;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f4129r;

    /* renamed from: r0, reason: collision with root package name */
    public final int[] f4130r0;

    /* renamed from: s, reason: collision with root package name */
    public final ArrayList f4131s;

    /* renamed from: s0, reason: collision with root package name */
    public C0179s f4132s0;

    /* renamed from: t, reason: collision with root package name */
    public C0276x f4133t;

    /* renamed from: t0, reason: collision with root package name */
    public final int[] f4134t0;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4135u;

    /* renamed from: u0, reason: collision with root package name */
    public final int[] f4136u0;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4137v;
    public final int[] v0;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4138w;

    /* renamed from: w0, reason: collision with root package name */
    public final ArrayList f4139w0;

    /* renamed from: x, reason: collision with root package name */
    public int f4140x;

    /* renamed from: x0, reason: collision with root package name */
    public final K f4141x0;

    /* renamed from: y, reason: collision with root package name */
    public boolean f4142y;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f4143y0;

    /* renamed from: z, reason: collision with root package name */
    public boolean f4144z;
    public int z0;

    static {
        Class cls = Integer.TYPE;
        f4073J0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f4074K0 = new W.d(1);
        f4075L0 = new k0();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.unified.ur1.R.attr.recyclerViewStyle);
    }

    public static RecyclerView H(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            RecyclerView recyclerViewH = H(viewGroup.getChildAt(i5));
            if (recyclerViewH != null) {
                return recyclerViewH;
            }
        }
        return null;
    }

    public static n0 M(View view) {
        if (view == null) {
            return null;
        }
        return ((Y) view.getLayoutParams()).f4190a;
    }

    private C0179s getScrollingChildHelper() {
        if (this.f4132s0 == null) {
            this.f4132s0 = new C0179s(this);
        }
        return this.f4132s0;
    }

    public static void l(n0 n0Var) {
        WeakReference<RecyclerView> weakReference = n0Var.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == n0Var.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            n0Var.mNestedRecyclerView = null;
        }
    }

    public static int o(int i5, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i6) {
        if (i5 > 0 && edgeEffect != null && h4.d.h(edgeEffect) != BitmapDescriptorFactory.HUE_RED) {
            int iRound = Math.round(h4.d.k(edgeEffect, ((-i5) * 4.0f) / i6, 0.5f) * ((-i6) / 4.0f));
            if (iRound != i5) {
                edgeEffect.finish();
            }
            return i5 - iRound;
        }
        if (i5 >= 0 || edgeEffect2 == null || h4.d.h(edgeEffect2) == BitmapDescriptorFactory.HUE_RED) {
            return i5;
        }
        float f5 = i6;
        int iRound2 = Math.round(h4.d.k(edgeEffect2, (i5 * 4.0f) / f5, 0.5f) * (f5 / 4.0f));
        if (iRound2 != i5) {
            edgeEffect2.finish();
        }
        return i5 - iRound2;
    }

    public static void setDebugAssertionsEnabled(boolean z4) {
        f4066C0 = z4;
    }

    public static void setVerboseLoggingEnabled(boolean z4) {
        f4067D0 = z4;
    }

    public final void A() {
        if (this.f4089M != null) {
            return;
        }
        ((k0) this.f4086J).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f4089M = edgeEffect;
        if (this.f4114j) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void B() {
        if (this.f4088L != null) {
            return;
        }
        ((k0) this.f4086J).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f4088L = edgeEffect;
        if (this.f4114j) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final String C() {
        return " " + super.toString() + ", adapter:" + this.f4123o + ", layout:" + this.f4125p + ", context:" + getContext();
    }

    public final void D(j0 j0Var) {
        if (getScrollState() != 2) {
            j0Var.getClass();
            return;
        }
        OverScroller overScroller = this.f4110g0.f4291l;
        overScroller.getFinalX();
        overScroller.getCurrX();
        j0Var.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    public final View E(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public final boolean F(MotionEvent motionEvent) {
        boolean z4;
        int action = motionEvent.getAction();
        ArrayList arrayList = this.f4131s;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            C0276x c0276x = (C0276x) arrayList.get(i5);
            int i6 = c0276x.f4383v;
            if (i6 == 1) {
                boolean zD = c0276x.d(motionEvent.getX(), motionEvent.getY());
                boolean zC = c0276x.c(motionEvent.getX(), motionEvent.getY());
                if (motionEvent.getAction() == 0 && (zD || zC)) {
                    if (zC) {
                        c0276x.f4384w = 1;
                        c0276x.f4377p = (int) motionEvent.getX();
                    } else if (zD) {
                        c0276x.f4384w = 2;
                        c0276x.f4375m = (int) motionEvent.getY();
                    }
                    c0276x.f(2);
                }
            } else {
                z4 = i6 == 2;
            }
            if (z4 && action != 3) {
                this.f4133t = c0276x;
                return true;
            }
        }
        return false;
    }

    public final void G(int[] iArr) {
        int i5 = this.h.i();
        if (i5 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i6 = Integer.MAX_VALUE;
        int i7 = Integer.MIN_VALUE;
        for (int i8 = 0; i8 < i5; i8++) {
            n0 n0VarM = M(this.h.h(i8));
            if (!n0VarM.shouldIgnore()) {
                int layoutPosition = n0VarM.getLayoutPosition();
                if (layoutPosition < i6) {
                    i6 = layoutPosition;
                }
                if (layoutPosition > i7) {
                    i7 = layoutPosition;
                }
            }
        }
        iArr[0] = i6;
        iArr[1] = i7;
    }

    public final n0 I(int i5) {
        n0 n0Var = null;
        if (this.f4083F) {
            return null;
        }
        int iL = this.h.l();
        for (int i6 = 0; i6 < iL; i6++) {
            n0 n0VarM = M(this.h.k(i6));
            if (n0VarM != null && !n0VarM.isRemoved() && J(n0VarM) == i5) {
                if (!this.h.o(n0VarM.itemView)) {
                    return n0VarM;
                }
                n0Var = n0VarM;
            }
        }
        return n0Var;
    }

    public final int J(n0 n0Var) {
        if (n0Var.hasAnyOfTheFlags(524) || !n0Var.isBound()) {
            return -1;
        }
        C0255b c0255b = this.g;
        int i5 = n0Var.mPosition;
        ArrayList arrayList = (ArrayList) c0255b.f4200c;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            C0254a c0254a = (C0254a) arrayList.get(i6);
            int i7 = c0254a.f4194a;
            if (i7 != 1) {
                if (i7 == 2) {
                    int i8 = c0254a.f4195b;
                    if (i8 <= i5) {
                        int i9 = c0254a.f4197d;
                        if (i8 + i9 > i5) {
                            return -1;
                        }
                        i5 -= i9;
                    } else {
                        continue;
                    }
                } else if (i7 == 8) {
                    int i10 = c0254a.f4195b;
                    if (i10 == i5) {
                        i5 = c0254a.f4197d;
                    } else {
                        if (i10 < i5) {
                            i5--;
                        }
                        if (c0254a.f4197d <= i5) {
                            i5++;
                        }
                    }
                }
            } else if (c0254a.f4195b <= i5) {
                i5 += c0254a.f4197d;
            }
        }
        return i5;
    }

    public final long K(n0 n0Var) {
        return this.f4123o.hasStableIds() ? n0Var.getItemId() : n0Var.mPosition;
    }

    public final n0 L(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return M(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final Rect N(View view) {
        Y y4 = (Y) view.getLayoutParams();
        boolean z4 = y4.f4192c;
        Rect rect = y4.f4191b;
        if (!z4) {
            return rect;
        }
        if (this.f4115j0.g && (y4.f4190a.isUpdated() || y4.f4190a.isInvalid())) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        ArrayList arrayList = this.f4129r;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            Rect rect2 = this.f4118l;
            rect2.set(0, 0, 0, 0);
            ((U) arrayList.get(i5)).getClass();
            ((Y) view.getLayoutParams()).f4190a.getLayoutPosition();
            rect2.set(0, 0, 0, 0);
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        y4.f4192c = false;
        return rect;
    }

    public final boolean O() {
        return !this.f4138w || this.f4083F || this.g.j();
    }

    public final boolean P() {
        return this.f4085H > 0;
    }

    public final void Q(int i5) {
        if (this.f4125p == null) {
            return;
        }
        setScrollState(2);
        this.f4125p.p0(i5);
        awakenScrollBars();
    }

    public final void R() {
        int iL = this.h.l();
        for (int i5 = 0; i5 < iL; i5++) {
            ((Y) this.h.k(i5).getLayoutParams()).f4192c = true;
        }
        ArrayList arrayList = this.f4106e.f4219c;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            Y y4 = (Y) ((n0) arrayList.get(i6)).itemView.getLayoutParams();
            if (y4 != null) {
                y4.f4192c = true;
            }
        }
    }

    public final void S(int i5, int i6, boolean z4) {
        int i7 = i5 + i6;
        int iL = this.h.l();
        for (int i8 = 0; i8 < iL; i8++) {
            n0 n0VarM = M(this.h.k(i8));
            if (n0VarM != null && !n0VarM.shouldIgnore()) {
                int i9 = n0VarM.mPosition;
                j0 j0Var = this.f4115j0;
                if (i9 >= i7) {
                    if (f4067D0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i8 + " holder " + n0VarM + " now at position " + (n0VarM.mPosition - i6));
                    }
                    n0VarM.offsetPosition(-i6, z4);
                    j0Var.f4268f = true;
                } else if (i9 >= i5) {
                    if (f4067D0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i8 + " holder " + n0VarM + " now REMOVED");
                    }
                    n0VarM.flagRemovedAndOffsetPosition(i5 - 1, -i6, z4);
                    j0Var.f4268f = true;
                }
            }
        }
        d0 d0Var = this.f4106e;
        ArrayList arrayList = d0Var.f4219c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            n0 n0Var = (n0) arrayList.get(size);
            if (n0Var != null) {
                int i10 = n0Var.mPosition;
                if (i10 >= i7) {
                    if (f4067D0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove cached " + size + " holder " + n0Var + " now at position " + (n0Var.mPosition - i6));
                    }
                    n0Var.offsetPosition(-i6, z4);
                } else if (i10 >= i5) {
                    n0Var.addFlags(8);
                    d0Var.g(size);
                }
            }
        }
        requestLayout();
    }

    public final void T() {
        this.f4085H++;
    }

    public final void U(boolean z4) {
        int i5;
        AccessibilityManager accessibilityManager;
        int i6 = this.f4085H - 1;
        this.f4085H = i6;
        if (i6 < 1) {
            if (f4066C0 && i6 < 0) {
                throw new IllegalStateException(AbstractC0535a.i(this, new StringBuilder("layout or scroll counter cannot go below zero.Some calls are not matching")));
            }
            this.f4085H = 0;
            if (z4) {
                int i7 = this.f4078B;
                this.f4078B = 0;
                if (i7 != 0 && (accessibilityManager = this.f4081D) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(2048);
                    P.b.b(accessibilityEventObtain, i7);
                    sendAccessibilityEventUnchecked(accessibilityEventObtain);
                }
                ArrayList arrayList = this.f4139w0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    n0 n0Var = (n0) arrayList.get(size);
                    if (n0Var.itemView.getParent() == this && !n0Var.shouldIgnore() && (i5 = n0Var.mPendingAccessibilityState) != -1) {
                        View view = n0Var.itemView;
                        WeakHashMap weakHashMap = O.Y.f1904a;
                        O.G.s(view, i5);
                        n0Var.mPendingAccessibilityState = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    public final void V(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f4093Q) {
            int i5 = actionIndex == 0 ? 1 : 0;
            this.f4093Q = motionEvent.getPointerId(i5);
            int x4 = (int) (motionEvent.getX(i5) + 0.5f);
            this.f4097U = x4;
            this.f4095S = x4;
            int y4 = (int) (motionEvent.getY(i5) + 0.5f);
            this.f4098V = y4;
            this.f4096T = y4;
        }
    }

    public final void W() {
        if (this.f4126p0 || !this.f4135u) {
            return;
        }
        WeakHashMap weakHashMap = O.Y.f1904a;
        O.G.m(this, this.f4141x0);
        this.f4126p0 = true;
    }

    public final void X() {
        boolean z4;
        boolean z5 = false;
        if (this.f4083F) {
            C0255b c0255b = this.g;
            c0255b.q((ArrayList) c0255b.f4200c);
            c0255b.q((ArrayList) c0255b.f4201d);
            c0255b.f4198a = 0;
            if (this.f4084G) {
                this.f4125p.X();
            }
        }
        if (this.f4091O == null || !this.f4125p.B0()) {
            this.g.d();
        } else {
            this.g.p();
        }
        boolean z6 = this.f4121m0 || this.f4122n0;
        boolean z7 = this.f4138w && this.f4091O != null && ((z4 = this.f4083F) || z6 || this.f4125p.f4183f) && (!z4 || this.f4123o.hasStableIds());
        j0 j0Var = this.f4115j0;
        j0Var.f4270j = z7;
        if (z7 && z6 && !this.f4083F && this.f4091O != null && this.f4125p.B0()) {
            z5 = true;
        }
        j0Var.f4271k = z5;
    }

    public final void Y(boolean z4) {
        this.f4084G = z4 | this.f4084G;
        this.f4083F = true;
        int iL = this.h.l();
        for (int i5 = 0; i5 < iL; i5++) {
            n0 n0VarM = M(this.h.k(i5));
            if (n0VarM != null && !n0VarM.shouldIgnore()) {
                n0VarM.addFlags(6);
            }
        }
        R();
        d0 d0Var = this.f4106e;
        ArrayList arrayList = d0Var.f4219c;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            n0 n0Var = (n0) arrayList.get(i6);
            if (n0Var != null) {
                n0Var.addFlags(6);
                n0Var.addChangePayload(null);
            }
        }
        N n = d0Var.h.f4123o;
        if (n == null || !n.hasStableIds()) {
            d0Var.f();
        }
    }

    public final void Z(n0 n0Var, C0182v c0182v) {
        n0Var.setFlags(0, 8192);
        boolean z4 = this.f4115j0.h;
        L0.e eVar = this.f4112i;
        if (z4 && n0Var.isUpdated() && !n0Var.isRemoved() && !n0Var.shouldIgnore()) {
            ((q.e) eVar.f1542e).f(K(n0Var), n0Var);
        }
        q.k kVar = (q.k) eVar.f1541d;
        x0 x0VarA = (x0) kVar.getOrDefault(n0Var, null);
        if (x0VarA == null) {
            x0VarA = x0.a();
            kVar.put(n0Var, x0VarA);
        }
        x0VarA.f4390b = c0182v;
        x0VarA.f4389a |= 4;
    }

    public final int a0(int i5, float f5) {
        float height = f5 / getHeight();
        float width = i5 / getWidth();
        EdgeEffect edgeEffect = this.f4087K;
        float f6 = BitmapDescriptorFactory.HUE_RED;
        if (edgeEffect == null || h4.d.h(edgeEffect) == BitmapDescriptorFactory.HUE_RED) {
            EdgeEffect edgeEffect2 = this.f4089M;
            if (edgeEffect2 != null && h4.d.h(edgeEffect2) != BitmapDescriptorFactory.HUE_RED) {
                if (canScrollHorizontally(1)) {
                    this.f4089M.onRelease();
                } else {
                    float fK = h4.d.k(this.f4089M, width, height);
                    if (h4.d.h(this.f4089M) == BitmapDescriptorFactory.HUE_RED) {
                        this.f4089M.onRelease();
                    }
                    f6 = fK;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.f4087K.onRelease();
            } else {
                float f7 = -h4.d.k(this.f4087K, -width, 1.0f - height);
                if (h4.d.h(this.f4087K) == BitmapDescriptorFactory.HUE_RED) {
                    this.f4087K.onRelease();
                }
                f6 = f7;
            }
            invalidate();
        }
        return Math.round(f6 * getWidth());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i5, int i6) {
        X x4 = this.f4125p;
        if (x4 != null) {
            x4.getClass();
        }
        super.addFocusables(arrayList, i5, i6);
    }

    public final int b0(int i5, float f5) {
        float width = f5 / getWidth();
        float height = i5 / getHeight();
        EdgeEffect edgeEffect = this.f4088L;
        float f6 = BitmapDescriptorFactory.HUE_RED;
        if (edgeEffect == null || h4.d.h(edgeEffect) == BitmapDescriptorFactory.HUE_RED) {
            EdgeEffect edgeEffect2 = this.f4090N;
            if (edgeEffect2 != null && h4.d.h(edgeEffect2) != BitmapDescriptorFactory.HUE_RED) {
                if (canScrollVertically(1)) {
                    this.f4090N.onRelease();
                } else {
                    float fK = h4.d.k(this.f4090N, height, 1.0f - width);
                    if (h4.d.h(this.f4090N) == BitmapDescriptorFactory.HUE_RED) {
                        this.f4090N.onRelease();
                    }
                    f6 = fK;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.f4088L.onRelease();
            } else {
                float f7 = -h4.d.k(this.f4088L, -height, width);
                if (h4.d.h(this.f4088L) == BitmapDescriptorFactory.HUE_RED) {
                    this.f4088L.onRelease();
                }
                f6 = f7;
            }
            invalidate();
        }
        return Math.round(f6 * getHeight());
    }

    public final void c0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.f4118l;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof Y) {
            Y y4 = (Y) layoutParams;
            if (!y4.f4192c) {
                int i5 = rect.left;
                Rect rect2 = y4.f4191b;
                rect.left = i5 - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.f4125p.m0(this, view, this.f4118l, !this.f4138w, view2 == null);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof Y) && this.f4125p.f((Y) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        X x4 = this.f4125p;
        if (x4 != null && x4.d()) {
            return this.f4125p.j(this.f4115j0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        X x4 = this.f4125p;
        if (x4 != null && x4.d()) {
            return this.f4125p.k(this.f4115j0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        X x4 = this.f4125p;
        if (x4 != null && x4.d()) {
            return this.f4125p.l(this.f4115j0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        X x4 = this.f4125p;
        if (x4 != null && x4.e()) {
            return this.f4125p.m(this.f4115j0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        X x4 = this.f4125p;
        if (x4 != null && x4.e()) {
            return this.f4125p.n(this.f4115j0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        X x4 = this.f4125p;
        if (x4 != null && x4.e()) {
            return this.f4125p.o(this.f4115j0);
        }
        return 0;
    }

    public final void d0() {
        VelocityTracker velocityTracker = this.f4094R;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean zIsFinished = false;
        m0(0);
        EdgeEffect edgeEffect = this.f4087K;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.f4087K.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f4088L;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.f4088L.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f4089M;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.f4089M.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f4090N;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.f4090N.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = O.Y.f1904a;
            O.G.k(this);
        }
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f5, float f6, boolean z4) {
        return getScrollingChildHelper().a(f5, f6, z4);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f5, float f6) {
        return getScrollingChildHelper().b(f5, f6);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i5, int i6, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i5, i6, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i5, int i6, int i7, int i8, int[] iArr) {
        return getScrollingChildHelper().d(i5, i6, i7, i8, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z4;
        super.draw(canvas);
        ArrayList arrayList = this.f4129r;
        int size = arrayList.size();
        boolean z5 = false;
        for (int i5 = 0; i5 < size; i5++) {
            ((U) arrayList.get(i5)).b(canvas, this);
        }
        EdgeEffect edgeEffect = this.f4087K;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z4 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f4114j ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, BitmapDescriptorFactory.HUE_RED);
            EdgeEffect edgeEffect2 = this.f4087K;
            z4 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.f4088L;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f4114j) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f4088L;
            z4 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.f4089M;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f4114j ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f4089M;
            z4 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.f4090N;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f4114j) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f4090N;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z5 = true;
            }
            z4 |= z5;
            canvas.restoreToCount(iSave4);
        }
        if ((z4 || this.f4091O == null || arrayList.size() <= 0 || !this.f4091O.g()) ? z4 : true) {
            WeakHashMap weakHashMap = O.Y.f1904a;
            O.G.k(this);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j5) {
        return super.drawChild(canvas, view, j5);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e0(int r20, int r21, android.view.MotionEvent r22, int r23) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.e0(int, int, android.view.MotionEvent, int):boolean");
    }

    public final void f0(int i5, int i6, int[] iArr) {
        n0 n0Var;
        C0258e c0258e = this.h;
        k0();
        T();
        int i7 = K.l.f1491a;
        K.k.a("RV Scroll");
        j0 j0Var = this.f4115j0;
        D(j0Var);
        d0 d0Var = this.f4106e;
        int iO0 = i5 != 0 ? this.f4125p.o0(i5, d0Var, j0Var) : 0;
        int iQ0 = i6 != 0 ? this.f4125p.q0(i6, d0Var, j0Var) : 0;
        K.k.b();
        int i8 = c0258e.i();
        for (int i9 = 0; i9 < i8; i9++) {
            View viewH = c0258e.h(i9);
            n0 n0VarL = L(viewH);
            if (n0VarL != null && (n0Var = n0VarL.mShadowingHolder) != null) {
                View view = n0Var.itemView;
                int left = viewH.getLeft();
                int top = viewH.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        U(true);
        l0(false);
        if (iArr != null) {
            iArr[0] = iO0;
            iArr[1] = iQ0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0079  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View focusSearch(android.view.View r17, int r18) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final void g0(int i5) {
        G g;
        if (this.f4144z) {
            return;
        }
        setScrollState(0);
        m0 m0Var = this.f4110g0;
        m0Var.f4294p.removeCallbacks(m0Var);
        m0Var.f4291l.abortAnimation();
        X x4 = this.f4125p;
        if (x4 != null && (g = x4.f4182e) != null) {
            g.i();
        }
        X x5 = this.f4125p;
        if (x5 == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            x5.p0(i5);
            awakenScrollBars();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        X x4 = this.f4125p;
        if (x4 != null) {
            return x4.r();
        }
        throw new IllegalStateException(AbstractC0535a.i(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        X x4 = this.f4125p;
        if (x4 != null) {
            return x4.s(getContext(), attributeSet);
        }
        throw new IllegalStateException(AbstractC0535a.i(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public N getAdapter() {
        return this.f4123o;
    }

    @Override // android.view.View
    public int getBaseline() {
        X x4 = this.f4125p;
        if (x4 == null) {
            return super.getBaseline();
        }
        x4.getClass();
        return -1;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i5, int i6) {
        return super.getChildDrawingOrder(i5, i6);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f4114j;
    }

    public p0 getCompatAccessibilityDelegate() {
        return this.f4128q0;
    }

    public S getEdgeEffectFactory() {
        return this.f4086J;
    }

    public T getItemAnimator() {
        return this.f4091O;
    }

    public int getItemDecorationCount() {
        return this.f4129r.size();
    }

    public X getLayoutManager() {
        return this.f4125p;
    }

    public int getMaxFlingVelocity() {
        return this.f4103c0;
    }

    public int getMinFlingVelocity() {
        return this.f4101b0;
    }

    public long getNanoTime() {
        if (f4072I0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public Z getOnFlingListener() {
        return this.f4100a0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f4109f0;
    }

    public c0 getRecycledViewPool() {
        return this.f4106e.c();
    }

    public int getScrollState() {
        return this.f4092P;
    }

    public final void h(n0 n0Var) {
        View view = n0Var.itemView;
        boolean z4 = view.getParent() == this;
        this.f4106e.l(L(view));
        if (n0Var.isTmpDetached()) {
            this.h.e(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z4) {
            this.h.d(view, -1, true);
            return;
        }
        C0258e c0258e = this.h;
        int iIndexOfChild = ((L) c0258e.f4225c).f4048a.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            ((J1.U) c0258e.f4226d).i(iIndexOfChild);
            c0258e.m(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final boolean h0(EdgeEffect edgeEffect, int i5, int i6) {
        if (i5 > 0) {
            return true;
        }
        float fH = h4.d.h(edgeEffect) * i6;
        float fAbs = Math.abs(-i5) * 0.35f;
        float f5 = this.f4102c * 0.015f;
        double dLog = Math.log(fAbs / f5);
        double d5 = f4069F0;
        return ((float) (Math.exp((d5 / (d5 - 1.0d)) * dLog) * ((double) f5))) < fH;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f(0);
    }

    public final void i(U u4) {
        X x4 = this.f4125p;
        if (x4 != null) {
            x4.c("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.f4129r;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(u4);
        R();
        requestLayout();
    }

    public final void i0(int i5, int i6, boolean z4) {
        X x4 = this.f4125p;
        if (x4 == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f4144z) {
            return;
        }
        if (!x4.d()) {
            i5 = 0;
        }
        if (!this.f4125p.e()) {
            i6 = 0;
        }
        if (i5 == 0 && i6 == 0) {
            return;
        }
        if (z4) {
            int i7 = i5 != 0 ? 1 : 0;
            if (i6 != 0) {
                i7 |= 2;
            }
            getScrollingChildHelper().g(i7, 1);
        }
        this.f4110g0.c(i5, i6, Integer.MIN_VALUE, null);
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.f4135u;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f4144z;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f1963d;
    }

    public final void j(a0 a0Var) {
        if (this.f4119l0 == null) {
            this.f4119l0 = new ArrayList();
        }
        this.f4119l0.add(a0Var);
    }

    public final void j0(int i5) {
        if (this.f4144z) {
            return;
        }
        X x4 = this.f4125p;
        if (x4 == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            x4.z0(i5, this);
        }
    }

    public final void k(String str) {
        if (P()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException(AbstractC0535a.i(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
        }
        if (this.I > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(AbstractC0535a.i(this, new StringBuilder(""))));
        }
    }

    public final void k0() {
        int i5 = this.f4140x + 1;
        this.f4140x = i5;
        if (i5 != 1 || this.f4144z) {
            return;
        }
        this.f4142y = false;
    }

    public final void l0(boolean z4) {
        if (this.f4140x < 1) {
            if (f4066C0) {
                throw new IllegalStateException(AbstractC0535a.i(this, new StringBuilder("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.")));
            }
            this.f4140x = 1;
        }
        if (!z4 && !this.f4144z) {
            this.f4142y = false;
        }
        if (this.f4140x == 1) {
            if (z4 && this.f4142y && !this.f4144z && this.f4125p != null && this.f4123o != null) {
                s();
            }
            if (!this.f4144z) {
                this.f4142y = false;
            }
        }
        this.f4140x--;
    }

    public final void m() {
        int iL = this.h.l();
        for (int i5 = 0; i5 < iL; i5++) {
            n0 n0VarM = M(this.h.k(i5));
            if (!n0VarM.shouldIgnore()) {
                n0VarM.clearOldPosition();
            }
        }
        d0 d0Var = this.f4106e;
        ArrayList arrayList = d0Var.f4219c;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            ((n0) arrayList.get(i6)).clearOldPosition();
        }
        ArrayList arrayList2 = d0Var.f4217a;
        int size2 = arrayList2.size();
        for (int i7 = 0; i7 < size2; i7++) {
            ((n0) arrayList2.get(i7)).clearOldPosition();
        }
        ArrayList arrayList3 = d0Var.f4218b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i8 = 0; i8 < size3; i8++) {
                ((n0) d0Var.f4218b.get(i8)).clearOldPosition();
            }
        }
    }

    public final void m0(int i5) {
        getScrollingChildHelper().h(i5);
    }

    public final void n(int i5, int i6) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f4087K;
        if (edgeEffect == null || edgeEffect.isFinished() || i5 <= 0) {
            zIsFinished = false;
        } else {
            this.f4087K.onRelease();
            zIsFinished = this.f4087K.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f4089M;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i5 < 0) {
            this.f4089M.onRelease();
            zIsFinished |= this.f4089M.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f4088L;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i6 > 0) {
            this.f4088L.onRelease();
            zIsFinished |= this.f4088L.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f4090N;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i6 < 0) {
            this.f4090N.onRelease();
            zIsFinished |= this.f4090N.isFinished();
        }
        if (zIsFinished) {
            WeakHashMap weakHashMap = O.Y.f1904a;
            O.G.k(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.f4085H = r0
            r1 = 1
            r5.f4135u = r1
            boolean r2 = r5.f4138w
            if (r2 == 0) goto L15
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L15
            r2 = r1
            goto L16
        L15:
            r2 = r0
        L16:
            r5.f4138w = r2
            androidx.recyclerview.widget.d0 r2 = r5.f4106e
            r2.d()
            androidx.recyclerview.widget.X r2 = r5.f4125p
            if (r2 == 0) goto L26
            r2.g = r1
            r2.P(r5)
        L26:
            r5.f4126p0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.f4072I0
            if (r0 == 0) goto L91
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.RunnableC0278z.n
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.z r1 = (androidx.recyclerview.widget.RunnableC0278z) r1
            r5.f4111h0 = r1
            if (r1 != 0) goto L74
            androidx.recyclerview.widget.z r1 = new androidx.recyclerview.widget.z
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f4398j = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f4401m = r2
            r5.f4111h0 = r1
            java.util.WeakHashMap r1 = O.Y.f1904a
            android.view.Display r1 = O.H.b(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L66
            if (r1 == 0) goto L66
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L66
            goto L68
        L66:
            r1 = 1114636288(0x42700000, float:60.0)
        L68:
            androidx.recyclerview.widget.z r2 = r5.f4111h0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f4400l = r3
            r0.set(r2)
        L74:
            androidx.recyclerview.widget.z r0 = r5.f4111h0
            r0.getClass()
            boolean r1 = androidx.recyclerview.widget.RecyclerView.f4066C0
            java.util.ArrayList r0 = r0.f4398j
            if (r1 == 0) goto L8e
            boolean r1 = r0.contains(r5)
            if (r1 != 0) goto L86
            goto L8e
        L86:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "RecyclerView already present in worker list!"
            r0.<init>(r1)
            throw r0
        L8e:
            r0.add(r5)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        d0 d0Var;
        RunnableC0278z runnableC0278z;
        G g;
        super.onDetachedFromWindow();
        T t4 = this.f4091O;
        if (t4 != null) {
            t4.f();
        }
        int i5 = 0;
        setScrollState(0);
        m0 m0Var = this.f4110g0;
        m0Var.f4294p.removeCallbacks(m0Var);
        m0Var.f4291l.abortAnimation();
        X x4 = this.f4125p;
        if (x4 != null && (g = x4.f4182e) != null) {
            g.i();
        }
        this.f4135u = false;
        X x5 = this.f4125p;
        if (x5 != null) {
            x5.g = false;
            x5.Q(this);
        }
        this.f4139w0.clear();
        removeCallbacks(this.f4141x0);
        this.f4112i.getClass();
        while (x0.f4388d.a() != null) {
        }
        int i6 = 0;
        while (true) {
            d0Var = this.f4106e;
            ArrayList arrayList = d0Var.f4219c;
            if (i6 >= arrayList.size()) {
                break;
            }
            AbstractC0930a.d(((n0) arrayList.get(i6)).itemView);
            i6++;
        }
        d0Var.e(d0Var.h.f4123o, false);
        while (i5 < getChildCount()) {
            int i7 = i5 + 1;
            View childAt = getChildAt(i5);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            }
            U.a aVar = (U.a) childAt.getTag(com.unified.ur1.R.id.pooling_container_listener_holder_tag);
            if (aVar == null) {
                aVar = new U.a();
                childAt.setTag(com.unified.ur1.R.id.pooling_container_listener_holder_tag, aVar);
            }
            ArrayList arrayList2 = aVar.f2459a;
            int iX = t3.j.x(arrayList2);
            if (-1 < iX) {
                com.unified.ur1.SatelliteTracker.h.p(arrayList2.get(iX));
                throw null;
            }
            i5 = i7;
        }
        if (!f4072I0 || (runnableC0278z = this.f4111h0) == null) {
            return;
        }
        boolean zRemove = runnableC0278z.f4398j.remove(this);
        if (f4066C0 && !zRemove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
        this.f4111h0 = null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.f4129r;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((U) arrayList.get(i5)).a(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0085  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z4;
        boolean z5;
        if (this.f4144z) {
            return false;
        }
        this.f4133t = null;
        if (F(motionEvent)) {
            d0();
            setScrollState(0);
            return true;
        }
        X x4 = this.f4125p;
        if (x4 == null) {
            return false;
        }
        boolean zD = x4.d();
        boolean zE = this.f4125p.e();
        if (this.f4094R == null) {
            this.f4094R = VelocityTracker.obtain();
        }
        this.f4094R.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f4076A) {
                this.f4076A = false;
            }
            this.f4093Q = motionEvent.getPointerId(0);
            int x5 = (int) (motionEvent.getX() + 0.5f);
            this.f4097U = x5;
            this.f4095S = x5;
            int y4 = (int) (motionEvent.getY() + 0.5f);
            this.f4098V = y4;
            this.f4096T = y4;
            EdgeEffect edgeEffect = this.f4087K;
            if (edgeEffect == null || h4.d.h(edgeEffect) == BitmapDescriptorFactory.HUE_RED || canScrollHorizontally(-1)) {
                z4 = false;
            } else {
                h4.d.k(this.f4087K, BitmapDescriptorFactory.HUE_RED, 1.0f - (motionEvent.getY() / getHeight()));
                z4 = true;
            }
            EdgeEffect edgeEffect2 = this.f4089M;
            boolean z6 = z4;
            if (edgeEffect2 != null) {
                z6 = z4;
                if (h4.d.h(edgeEffect2) != BitmapDescriptorFactory.HUE_RED) {
                    z6 = z4;
                    if (!canScrollHorizontally(1)) {
                        h4.d.k(this.f4089M, BitmapDescriptorFactory.HUE_RED, motionEvent.getY() / getHeight());
                        z6 = true;
                    }
                }
            }
            EdgeEffect edgeEffect3 = this.f4088L;
            boolean z7 = z6;
            if (edgeEffect3 != null) {
                z7 = z6;
                if (h4.d.h(edgeEffect3) != BitmapDescriptorFactory.HUE_RED) {
                    z7 = z6;
                    if (!canScrollVertically(-1)) {
                        h4.d.k(this.f4088L, BitmapDescriptorFactory.HUE_RED, motionEvent.getX() / getWidth());
                        z7 = true;
                    }
                }
            }
            EdgeEffect edgeEffect4 = this.f4090N;
            boolean z8 = z7;
            if (edgeEffect4 != null) {
                z8 = z7;
                if (h4.d.h(edgeEffect4) != BitmapDescriptorFactory.HUE_RED) {
                    z8 = z7;
                    if (!canScrollVertically(1)) {
                        h4.d.k(this.f4090N, BitmapDescriptorFactory.HUE_RED, 1.0f - (motionEvent.getX() / getWidth()));
                        z8 = true;
                    }
                }
            }
            if (z8 || this.f4092P == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                m0(1);
            }
            int[] iArr = this.f4136u0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i5 = zD;
            if (zE) {
                i5 = (zD ? 1 : 0) | 2;
            }
            getScrollingChildHelper().g(i5, 0);
        } else if (actionMasked == 1) {
            this.f4094R.clear();
            m0(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f4093Q);
            if (iFindPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f4093Q + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x6 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y5 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.f4092P != 1) {
                int i6 = x6 - this.f4095S;
                int i7 = y5 - this.f4096T;
                if (zD == 0 || Math.abs(i6) <= this.f4099W) {
                    z5 = false;
                } else {
                    this.f4097U = x6;
                    z5 = true;
                }
                if (zE && Math.abs(i7) > this.f4099W) {
                    this.f4098V = y5;
                    z5 = true;
                }
                if (z5) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            d0();
            setScrollState(0);
        } else if (actionMasked == 5) {
            this.f4093Q = motionEvent.getPointerId(actionIndex);
            int x7 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f4097U = x7;
            this.f4095S = x7;
            int y6 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f4098V = y6;
            this.f4096T = y6;
        } else if (actionMasked == 6) {
            V(motionEvent);
        }
        return this.f4092P == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int i9 = K.l.f1491a;
        K.k.a("RV OnLayout");
        s();
        K.k.b();
        this.f4138w = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        X x4 = this.f4125p;
        if (x4 == null) {
            q(i5, i6);
            return;
        }
        boolean zJ = x4.J();
        boolean z4 = false;
        j0 j0Var = this.f4115j0;
        if (zJ) {
            int mode = View.MeasureSpec.getMode(i5);
            int mode2 = View.MeasureSpec.getMode(i6);
            this.f4125p.f4179b.q(i5, i6);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z4 = true;
            }
            this.f4143y0 = z4;
            if (z4 || this.f4123o == null) {
                return;
            }
            if (j0Var.f4266d == 1) {
                t();
            }
            this.f4125p.s0(i5, i6);
            j0Var.f4269i = true;
            u();
            this.f4125p.u0(i5, i6);
            if (this.f4125p.x0()) {
                this.f4125p.s0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                j0Var.f4269i = true;
                u();
                this.f4125p.u0(i5, i6);
            }
            this.z0 = getMeasuredWidth();
            this.f4077A0 = getMeasuredHeight();
            return;
        }
        if (this.f4137v) {
            this.f4125p.f4179b.q(i5, i6);
            return;
        }
        if (this.f4080C) {
            k0();
            T();
            X();
            U(true);
            if (j0Var.f4271k) {
                j0Var.g = true;
            } else {
                this.g.d();
                j0Var.g = false;
            }
            this.f4080C = false;
            l0(false);
        } else if (j0Var.f4271k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        N n = this.f4123o;
        if (n != null) {
            j0Var.f4267e = n.getItemCount();
        } else {
            j0Var.f4267e = 0;
        }
        k0();
        this.f4125p.f4179b.q(i5, i6);
        l0(false);
        j0Var.g = false;
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i5, Rect rect) {
        if (P()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i5, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof g0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g0 g0Var = (g0) parcelable;
        this.f4108f = g0Var;
        super.onRestoreInstanceState(g0Var.f2507j);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        g0 g0Var = new g0(super.onSaveInstanceState());
        g0 g0Var2 = this.f4108f;
        if (g0Var2 != null) {
            g0Var.f4239l = g0Var2.f4239l;
        } else {
            X x4 = this.f4125p;
            if (x4 != null) {
                g0Var.f4239l = x4.e0();
            } else {
                g0Var.f4239l = null;
            }
        }
        return g0Var;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        if (i5 == i7 && i6 == i8) {
            return;
        }
        this.f4090N = null;
        this.f4088L = null;
        this.f4089M = null;
        this.f4087K = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x039d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01fa A[PHI: r0
      0x01fa: PHI (r0v55 int) = (r0v40 int), (r0v59 int) binds: [B:90:0x01e3, B:94:0x01f6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01fd  */
    /* JADX WARN: Type inference failed for: r5v26, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v28 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r25) {
        /*
            Method dump skipped, instructions count: 1359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        C0258e c0258e = this.h;
        C0255b c0255b = this.g;
        if (!this.f4138w || this.f4083F) {
            int i5 = K.l.f1491a;
            K.k.a("RV FullInvalidate");
            s();
            K.k.b();
            return;
        }
        if (c0255b.j()) {
            int i6 = c0255b.f4198a;
            if ((i6 & 4) == 0 || (i6 & 11) != 0) {
                if (c0255b.j()) {
                    int i7 = K.l.f1491a;
                    K.k.a("RV FullInvalidate");
                    s();
                    K.k.b();
                    return;
                }
                return;
            }
            int i8 = K.l.f1491a;
            K.k.a("RV PartialInvalidate");
            k0();
            T();
            c0255b.p();
            if (!this.f4142y) {
                int i9 = c0258e.i();
                int i10 = 0;
                while (true) {
                    if (i10 < i9) {
                        n0 n0VarM = M(c0258e.h(i10));
                        if (n0VarM != null && !n0VarM.shouldIgnore() && n0VarM.isUpdated()) {
                            s();
                            break;
                        }
                        i10++;
                    } else {
                        c0255b.c();
                        break;
                    }
                }
            }
            l0(true);
            U(true);
            K.k.b();
        }
    }

    public final void q(int i5, int i6) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = O.Y.f1904a;
        setMeasuredDimension(X.g(i5, paddingRight, O.G.e(this)), X.g(i6, getPaddingBottom() + getPaddingTop(), O.G.d(this)));
    }

    public final void r(View view) {
        n0 n0VarM = M(view);
        N n = this.f4123o;
        if (n != null && n0VarM != null) {
            n.onViewDetachedFromWindow(n0VarM);
        }
        ArrayList arrayList = this.f4082E;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((B0.i) this.f4082E.get(size)).getClass();
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z4) {
        n0 n0VarM = M(view);
        if (n0VarM != null) {
            if (n0VarM.isTmpDetached()) {
                n0VarM.clearTmpDetachFlag();
            } else if (!n0VarM.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(n0VarM);
                throw new IllegalArgumentException(AbstractC0535a.i(this, sb));
            }
        } else if (f4066C0) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            throw new IllegalArgumentException(AbstractC0535a.i(this, sb2));
        }
        view.clearAnimation();
        r(view);
        super.removeDetachedView(view, z4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        G g = this.f4125p.f4182e;
        if ((g == null || !g.f4025e) && !P() && view2 != null) {
            c0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        return this.f4125p.m0(this, view, rect, z4, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z4) {
        ArrayList arrayList = this.f4131s;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((C0276x) arrayList.get(i5)).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z4);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f4140x != 0 || this.f4144z) {
            this.f4142y = true;
        } else {
            super.requestLayout();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:164:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03ab  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [androidx.recyclerview.widget.n0] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            Method dump skipped, instructions count: 1042
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.s():void");
    }

    @Override // android.view.View
    public final void scrollBy(int i5, int i6) {
        X x4 = this.f4125p;
        if (x4 == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f4144z) {
            return;
        }
        boolean zD = x4.d();
        boolean zE = this.f4125p.e();
        if (zD || zE) {
            if (!zD) {
                i5 = 0;
            }
            if (!zE) {
                i6 = 0;
            }
            e0(i5, i6, null, 0);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i5, int i6) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!P()) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int iA = accessibilityEvent != null ? P.b.a(accessibilityEvent) : 0;
            this.f4078B |= iA != 0 ? iA : 0;
        }
    }

    public void setAccessibilityDelegateCompat(p0 p0Var) {
        this.f4128q0 = p0Var;
        O.Y.k(this, p0Var);
    }

    public void setAdapter(N n) {
        setLayoutFrozen(false);
        N n5 = this.f4123o;
        f0 f0Var = this.f4104d;
        if (n5 != null) {
            n5.unregisterAdapterDataObserver(f0Var);
            this.f4123o.onDetachedFromRecyclerView(this);
        }
        T t4 = this.f4091O;
        if (t4 != null) {
            t4.f();
        }
        X x4 = this.f4125p;
        d0 d0Var = this.f4106e;
        if (x4 != null) {
            x4.i0(d0Var);
            this.f4125p.j0(d0Var);
        }
        d0Var.f4217a.clear();
        d0Var.f();
        C0255b c0255b = this.g;
        c0255b.q((ArrayList) c0255b.f4200c);
        c0255b.q((ArrayList) c0255b.f4201d);
        c0255b.f4198a = 0;
        N n6 = this.f4123o;
        this.f4123o = n;
        if (n != null) {
            n.registerAdapterDataObserver(f0Var);
            n.onAttachedToRecyclerView(this);
        }
        X x5 = this.f4125p;
        if (x5 != null) {
            x5.O();
        }
        N n7 = this.f4123o;
        d0Var.f4217a.clear();
        d0Var.f();
        d0Var.e(n6, true);
        c0 c0VarC = d0Var.c();
        if (n6 != null) {
            c0VarC.f4210b--;
        }
        if (c0VarC.f4210b == 0) {
            int i5 = 0;
            while (true) {
                SparseArray sparseArray = c0VarC.f4209a;
                if (i5 >= sparseArray.size()) {
                    break;
                }
                b0 b0Var = (b0) sparseArray.valueAt(i5);
                Iterator it = b0Var.f4204a.iterator();
                while (it.hasNext()) {
                    AbstractC0930a.d(((n0) it.next()).itemView);
                }
                b0Var.f4204a.clear();
                i5++;
            }
        }
        if (n7 != null) {
            c0VarC.f4210b++;
        }
        d0Var.d();
        this.f4115j0.f4268f = true;
        Y(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(Q q4) {
        if (q4 == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z4) {
        if (z4 != this.f4114j) {
            this.f4090N = null;
            this.f4088L = null;
            this.f4089M = null;
            this.f4087K = null;
        }
        this.f4114j = z4;
        super.setClipToPadding(z4);
        if (this.f4138w) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(S s4) {
        s4.getClass();
        this.f4086J = s4;
        this.f4090N = null;
        this.f4088L = null;
        this.f4089M = null;
        this.f4087K = null;
    }

    public void setHasFixedSize(boolean z4) {
        this.f4137v = z4;
    }

    public void setItemAnimator(T t4) {
        T t5 = this.f4091O;
        if (t5 != null) {
            t5.f();
            this.f4091O.f4166a = null;
        }
        this.f4091O = t4;
        if (t4 != null) {
            t4.f4166a = this.f4124o0;
        }
    }

    public void setItemViewCacheSize(int i5) {
        d0 d0Var = this.f4106e;
        d0Var.f4221e = i5;
        d0Var.m();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z4) {
        suppressLayout(z4);
    }

    public void setLayoutManager(X x4) {
        L l5;
        G g;
        if (x4 == this.f4125p) {
            return;
        }
        setScrollState(0);
        m0 m0Var = this.f4110g0;
        m0Var.f4294p.removeCallbacks(m0Var);
        m0Var.f4291l.abortAnimation();
        X x5 = this.f4125p;
        if (x5 != null && (g = x5.f4182e) != null) {
            g.i();
        }
        X x6 = this.f4125p;
        d0 d0Var = this.f4106e;
        if (x6 != null) {
            T t4 = this.f4091O;
            if (t4 != null) {
                t4.f();
            }
            this.f4125p.i0(d0Var);
            this.f4125p.j0(d0Var);
            d0Var.f4217a.clear();
            d0Var.f();
            if (this.f4135u) {
                X x7 = this.f4125p;
                x7.g = false;
                x7.Q(this);
            }
            this.f4125p.v0(null);
            this.f4125p = null;
        } else {
            d0Var.f4217a.clear();
            d0Var.f();
        }
        C0258e c0258e = this.h;
        ((J1.U) c0258e.f4226d).h();
        ArrayList arrayList = (ArrayList) c0258e.f4227e;
        int size = arrayList.size() - 1;
        while (true) {
            l5 = (L) c0258e.f4225c;
            if (size < 0) {
                break;
            }
            View view = (View) arrayList.get(size);
            l5.getClass();
            n0 n0VarM = M(view);
            if (n0VarM != null) {
                n0VarM.onLeftHiddenState(l5.f4048a);
            }
            arrayList.remove(size);
            size--;
        }
        RecyclerView recyclerView = l5.f4048a;
        int childCount = recyclerView.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = recyclerView.getChildAt(i5);
            recyclerView.r(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.f4125p = x4;
        if (x4 != null) {
            if (x4.f4179b != null) {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(x4);
                sb.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(AbstractC0535a.i(x4.f4179b, sb));
            }
            x4.v0(this);
            if (this.f4135u) {
                X x8 = this.f4125p;
                x8.g = true;
                x8.P(this);
            }
        }
        d0Var.m();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z4) {
        C0179s scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f1963d) {
            WeakHashMap weakHashMap = O.Y.f1904a;
            O.M.z(scrollingChildHelper.f1962c);
        }
        scrollingChildHelper.f1963d = z4;
    }

    public void setOnFlingListener(Z z4) {
        this.f4100a0 = z4;
    }

    @Deprecated
    public void setOnScrollListener(a0 a0Var) {
        this.f4117k0 = a0Var;
    }

    public void setPreserveFocusAfterLayout(boolean z4) {
        this.f4109f0 = z4;
    }

    public void setRecycledViewPool(c0 c0Var) {
        d0 d0Var = this.f4106e;
        RecyclerView recyclerView = d0Var.h;
        d0Var.e(recyclerView.f4123o, false);
        if (d0Var.g != null) {
            r2.f4210b--;
        }
        d0Var.g = c0Var;
        if (c0Var != null && recyclerView.getAdapter() != null) {
            d0Var.g.f4210b++;
        }
        d0Var.d();
    }

    @Deprecated
    public void setRecyclerListener(e0 e0Var) {
    }

    public void setScrollState(int i5) {
        G g;
        if (i5 == this.f4092P) {
            return;
        }
        if (f4067D0) {
            StringBuilder sbF = com.unified.ur1.SatelliteTracker.h.f("setting scroll state to ", i5, " from ");
            sbF.append(this.f4092P);
            Log.d("RecyclerView", sbF.toString(), new Exception());
        }
        this.f4092P = i5;
        if (i5 != 2) {
            m0 m0Var = this.f4110g0;
            m0Var.f4294p.removeCallbacks(m0Var);
            m0Var.f4291l.abortAnimation();
            X x4 = this.f4125p;
            if (x4 != null && (g = x4.f4182e) != null) {
                g.i();
            }
        }
        X x5 = this.f4125p;
        if (x5 != null) {
            x5.f0(i5);
        }
        a0 a0Var = this.f4117k0;
        if (a0Var != null) {
            a0Var.a(i5, this);
        }
        ArrayList arrayList = this.f4119l0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a0) this.f4119l0.get(size)).a(i5, this);
            }
        }
    }

    public void setScrollingTouchSlop(int i5) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i5 != 0) {
            if (i5 == 1) {
                this.f4099W = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i5 + "; using default value");
        }
        this.f4099W = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(l0 l0Var) {
        this.f4106e.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i5) {
        return getScrollingChildHelper().g(i5, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().h(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z4) {
        G g;
        if (z4 != this.f4144z) {
            k("Do not suppressLayout in layout or scroll");
            if (!z4) {
                this.f4144z = false;
                if (this.f4142y && this.f4125p != null && this.f4123o != null) {
                    requestLayout();
                }
                this.f4142y = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0));
            this.f4144z = true;
            this.f4076A = true;
            setScrollState(0);
            m0 m0Var = this.f4110g0;
            m0Var.f4294p.removeCallbacks(m0Var);
            m0Var.f4291l.abortAnimation();
            X x4 = this.f4125p;
            if (x4 == null || (g = x4.f4182e) == null) {
                return;
            }
            g.i();
        }
    }

    public final void t() {
        View viewE;
        x0 x0Var;
        j0 j0Var = this.f4115j0;
        j0Var.a(1);
        D(j0Var);
        j0Var.f4269i = false;
        k0();
        L0.e eVar = this.f4112i;
        ((q.k) eVar.f1541d).clear();
        q.e eVar2 = (q.e) eVar.f1542e;
        eVar2.a();
        T();
        X();
        View focusedChild = (this.f4109f0 && hasFocus() && this.f4123o != null) ? getFocusedChild() : null;
        n0 n0VarL = (focusedChild == null || (viewE = E(focusedChild)) == null) ? null : L(viewE);
        if (n0VarL == null) {
            j0Var.f4273m = -1L;
            j0Var.f4272l = -1;
            j0Var.n = -1;
        } else {
            j0Var.f4273m = this.f4123o.hasStableIds() ? n0VarL.getItemId() : -1L;
            j0Var.f4272l = this.f4083F ? -1 : n0VarL.isRemoved() ? n0VarL.mOldPosition : n0VarL.getAbsoluteAdapterPosition();
            View focusedChild2 = n0VarL.itemView;
            int id = focusedChild2.getId();
            while (!focusedChild2.isFocused() && (focusedChild2 instanceof ViewGroup) && focusedChild2.hasFocus()) {
                focusedChild2 = ((ViewGroup) focusedChild2).getFocusedChild();
                if (focusedChild2.getId() != -1) {
                    id = focusedChild2.getId();
                }
            }
            j0Var.n = id;
        }
        j0Var.h = j0Var.f4270j && this.f4122n0;
        this.f4122n0 = false;
        this.f4121m0 = false;
        j0Var.g = j0Var.f4271k;
        j0Var.f4267e = this.f4123o.getItemCount();
        G(this.f4130r0);
        boolean z4 = j0Var.f4270j;
        q.k kVar = (q.k) eVar.f1541d;
        if (z4) {
            int i5 = this.h.i();
            for (int i6 = 0; i6 < i5; i6++) {
                n0 n0VarM = M(this.h.h(i6));
                if (!n0VarM.shouldIgnore() && (!n0VarM.isInvalid() || this.f4123o.hasStableIds())) {
                    T t4 = this.f4091O;
                    T.b(n0VarM);
                    n0VarM.getUnmodifiedPayloads();
                    t4.getClass();
                    C0182v c0182v = new C0182v();
                    c0182v.d(n0VarM);
                    x0 x0VarA = (x0) kVar.getOrDefault(n0VarM, null);
                    if (x0VarA == null) {
                        x0VarA = x0.a();
                        kVar.put(n0VarM, x0VarA);
                    }
                    x0VarA.f4390b = c0182v;
                    x0VarA.f4389a |= 4;
                    if (j0Var.h && n0VarM.isUpdated() && !n0VarM.isRemoved() && !n0VarM.shouldIgnore() && !n0VarM.isInvalid()) {
                        eVar2.f(K(n0VarM), n0VarM);
                    }
                }
            }
        }
        if (j0Var.f4271k) {
            int iL = this.h.l();
            for (int i7 = 0; i7 < iL; i7++) {
                n0 n0VarM2 = M(this.h.k(i7));
                if (f4066C0 && n0VarM2.mPosition == -1 && !n0VarM2.isRemoved()) {
                    throw new IllegalStateException(AbstractC0535a.i(this, new StringBuilder("view holder cannot have position -1 unless it is removed")));
                }
                if (!n0VarM2.shouldIgnore()) {
                    n0VarM2.saveOldPosition();
                }
            }
            boolean z5 = j0Var.f4268f;
            j0Var.f4268f = false;
            this.f4125p.b0(this.f4106e, j0Var);
            j0Var.f4268f = z5;
            for (int i8 = 0; i8 < this.h.i(); i8++) {
                n0 n0VarM3 = M(this.h.h(i8));
                if (!n0VarM3.shouldIgnore() && ((x0Var = (x0) kVar.getOrDefault(n0VarM3, null)) == null || (x0Var.f4389a & 4) == 0)) {
                    T.b(n0VarM3);
                    boolean zHasAnyOfTheFlags = n0VarM3.hasAnyOfTheFlags(8192);
                    T t5 = this.f4091O;
                    n0VarM3.getUnmodifiedPayloads();
                    t5.getClass();
                    C0182v c0182v2 = new C0182v();
                    c0182v2.d(n0VarM3);
                    if (zHasAnyOfTheFlags) {
                        Z(n0VarM3, c0182v2);
                    } else {
                        x0 x0VarA2 = (x0) kVar.getOrDefault(n0VarM3, null);
                        if (x0VarA2 == null) {
                            x0VarA2 = x0.a();
                            kVar.put(n0VarM3, x0VarA2);
                        }
                        x0VarA2.f4389a |= 2;
                        x0VarA2.f4390b = c0182v2;
                    }
                }
            }
            m();
        } else {
            m();
        }
        U(true);
        l0(false);
        j0Var.f4266d = 2;
    }

    public final void u() {
        k0();
        T();
        j0 j0Var = this.f4115j0;
        j0Var.a(6);
        this.g.d();
        j0Var.f4267e = this.f4123o.getItemCount();
        j0Var.f4265c = 0;
        if (this.f4108f != null && this.f4123o.canRestoreState()) {
            Parcelable parcelable = this.f4108f.f4239l;
            if (parcelable != null) {
                this.f4125p.d0(parcelable);
            }
            this.f4108f = null;
        }
        j0Var.g = false;
        this.f4125p.b0(this.f4106e, j0Var);
        j0Var.f4268f = false;
        j0Var.f4270j = j0Var.f4270j && this.f4091O != null;
        j0Var.f4266d = 4;
        U(true);
        l0(false);
    }

    public final boolean v(int i5, int i6, int i7, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i5, i6, i7, iArr, iArr2);
    }

    public final void w(int i5, int i6, int i7, int i8, int[] iArr, int i9, int[] iArr2) {
        getScrollingChildHelper().d(i5, i6, i7, i8, iArr, i9, iArr2);
    }

    public final void x(int i5, int i6) {
        this.I++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i5, scrollY - i6);
        a0 a0Var = this.f4117k0;
        if (a0Var != null) {
            a0Var.b(this, i5, i6);
        }
        ArrayList arrayList = this.f4119l0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((a0) this.f4119l0.get(size)).b(this, i5, i6);
            }
        }
        this.I--;
    }

    public final void y() {
        if (this.f4090N != null) {
            return;
        }
        ((k0) this.f4086J).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f4090N = edgeEffect;
        if (this.f4114j) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void z() {
        if (this.f4087K != null) {
            return;
        }
        ((k0) this.f4086J).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f4087K = edgeEffect;
        if (this.f4114j) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerView(Context context, AttributeSet attributeSet, int i5) throws NoSuchMethodException, SecurityException {
        int i6;
        char c2;
        Object[] objArr;
        Constructor constructor;
        super(context, attributeSet, i5);
        int i7 = 1;
        int i8 = 0;
        this.f4104d = new f0(i8, this);
        this.f4106e = new d0(this);
        this.f4112i = new L0.e(12);
        this.f4116k = new K(i8, this);
        this.f4118l = new Rect();
        this.f4120m = new Rect();
        this.n = new RectF();
        this.f4127q = new ArrayList();
        this.f4129r = new ArrayList();
        this.f4131s = new ArrayList();
        this.f4140x = 0;
        this.f4083F = false;
        this.f4084G = false;
        this.f4085H = 0;
        this.I = 0;
        this.f4086J = f4075L0;
        C0265l c0265l = new C0265l();
        c0265l.f4166a = null;
        c0265l.f4167b = new ArrayList();
        c0265l.f4168c = 120L;
        c0265l.f4169d = 120L;
        c0265l.f4170e = 250L;
        c0265l.f4171f = 250L;
        c0265l.g = true;
        c0265l.h = new ArrayList();
        c0265l.f4280i = new ArrayList();
        c0265l.f4281j = new ArrayList();
        c0265l.f4282k = new ArrayList();
        c0265l.f4283l = new ArrayList();
        c0265l.f4284m = new ArrayList();
        c0265l.n = new ArrayList();
        c0265l.f4285o = new ArrayList();
        c0265l.f4286p = new ArrayList();
        c0265l.f4287q = new ArrayList();
        c0265l.f4288r = new ArrayList();
        this.f4091O = c0265l;
        this.f4092P = 0;
        this.f4093Q = -1;
        this.f4105d0 = Float.MIN_VALUE;
        this.f4107e0 = Float.MIN_VALUE;
        this.f4109f0 = true;
        this.f4110g0 = new m0(this);
        this.f4113i0 = f4072I0 ? new Q1.b() : null;
        j0 j0Var = new j0();
        j0Var.f4263a = -1;
        j0Var.f4264b = 0;
        j0Var.f4265c = 0;
        j0Var.f4266d = 1;
        j0Var.f4267e = 0;
        j0Var.f4268f = false;
        j0Var.g = false;
        j0Var.h = false;
        j0Var.f4269i = false;
        j0Var.f4270j = false;
        j0Var.f4271k = false;
        this.f4115j0 = j0Var;
        this.f4121m0 = false;
        this.f4122n0 = false;
        L l5 = new L(this);
        this.f4124o0 = l5;
        this.f4126p0 = false;
        this.f4130r0 = new int[2];
        this.f4134t0 = new int[2];
        this.f4136u0 = new int[2];
        this.v0 = new int[2];
        this.f4139w0 = new ArrayList();
        this.f4141x0 = new K(i7, this);
        this.z0 = 0;
        this.f4077A0 = 0;
        this.f4079B0 = new L(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f4099W = viewConfiguration.getScaledTouchSlop();
        this.f4105d0 = O.Z.a(viewConfiguration);
        this.f4107e0 = O.Z.b(viewConfiguration);
        this.f4101b0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f4103c0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f4102c = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.f4091O.f4166a = l5;
        this.g = new C0255b(new L(this));
        this.h = new C0258e(new L(this));
        WeakHashMap weakHashMap = O.Y.f1904a;
        if (O.P.b(this) == 0) {
            O.P.l(this, 8);
        }
        if (O.G.c(this) == 0) {
            O.G.s(this, 1);
        }
        this.f4081D = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new p0(this));
        int[] iArr = AbstractC0670a.f7914a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i5, 0);
        O.Y.j(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i5);
        String string = typedArrayObtainStyledAttributes.getString(8);
        if (typedArrayObtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f4114j = typedArrayObtainStyledAttributes.getBoolean(1, true);
        if (typedArrayObtainStyledAttributes.getBoolean(3, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(6);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(7);
            StateListDrawable stateListDrawable2 = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(4);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(5);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException(AbstractC0535a.i(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
            }
            Resources resources = getContext().getResources();
            i6 = 4;
            c2 = 2;
            new C0276x(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(com.unified.ur1.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(com.unified.ur1.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(com.unified.ur1.R.dimen.fastscroll_margin));
        } else {
            i6 = 4;
            c2 = 2;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (string != null) {
            String strTrim = string.trim();
            if (!strTrim.isEmpty()) {
                if (strTrim.charAt(0) == '.') {
                    strTrim = context.getPackageName() + strTrim;
                } else if (!strTrim.contains(".")) {
                    strTrim = RecyclerView.class.getPackage().getName() + '.' + strTrim;
                }
                try {
                    Class<? extends U> clsAsSubclass = Class.forName(strTrim, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(X.class);
                    try {
                        constructor = clsAsSubclass.getConstructor(f4073J0);
                        objArr = new Object[i6];
                        objArr[0] = context;
                        objArr[1] = attributeSet;
                        objArr[c2] = Integer.valueOf(i5);
                        objArr[3] = 0;
                    } catch (NoSuchMethodException e5) {
                        try {
                            objArr = null;
                            constructor = clsAsSubclass.getConstructor(null);
                        } catch (NoSuchMethodException e6) {
                            e6.initCause(e5);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + strTrim, e6);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((X) constructor.newInstance(objArr));
                } catch (ClassCastException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + strTrim, e7);
                } catch (ClassNotFoundException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + strTrim, e8);
                } catch (IllegalAccessException e9) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + strTrim, e9);
                } catch (InstantiationException e10) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strTrim, e10);
                } catch (InvocationTargetException e11) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + strTrim, e11);
                }
            }
        }
        int[] iArr2 = f4068E0;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i5, 0);
        O.Y.j(this, context, iArr2, attributeSet, typedArrayObtainStyledAttributes2, i5);
        boolean z4 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z4);
        setTag(com.unified.ur1.R.id.is_pooling_container_tag, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        X x4 = this.f4125p;
        if (x4 != null) {
            return x4.t(layoutParams);
        }
        throw new IllegalStateException(AbstractC0535a.i(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }
}
