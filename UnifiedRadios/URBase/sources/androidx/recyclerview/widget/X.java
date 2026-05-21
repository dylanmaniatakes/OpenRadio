package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.WeakHashMap;
import k0.AbstractC0670a;

/* loaded from: classes.dex */
public abstract class X {

    /* renamed from: a, reason: collision with root package name */
    public C0258e f4178a;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerView f4179b;

    /* renamed from: c, reason: collision with root package name */
    public final L0.c f4180c;

    /* renamed from: d, reason: collision with root package name */
    public final L0.c f4181d;

    /* renamed from: e, reason: collision with root package name */
    public G f4182e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4183f;
    public boolean g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f4184i;

    /* renamed from: j, reason: collision with root package name */
    public int f4185j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4186k;

    /* renamed from: l, reason: collision with root package name */
    public int f4187l;

    /* renamed from: m, reason: collision with root package name */
    public int f4188m;
    public int n;

    /* renamed from: o, reason: collision with root package name */
    public int f4189o;

    public X() {
        V v4 = new V(this, 0);
        V v5 = new V(this, 1);
        this.f4180c = new L0.c(v4);
        this.f4181d = new L0.c(v5);
        this.f4183f = false;
        this.g = false;
        this.h = true;
        this.f4184i = true;
    }

    public static int F(View view) {
        return ((Y) view.getLayoutParams()).f4190a.getLayoutPosition();
    }

    public static W G(Context context, AttributeSet attributeSet, int i5, int i6) {
        W w4 = new W();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0670a.f7914a, i5, i6);
        w4.f4174a = typedArrayObtainStyledAttributes.getInt(0, 1);
        w4.f4175b = typedArrayObtainStyledAttributes.getInt(10, 1);
        w4.f4176c = typedArrayObtainStyledAttributes.getBoolean(9, false);
        w4.f4177d = typedArrayObtainStyledAttributes.getBoolean(11, false);
        typedArrayObtainStyledAttributes.recycle();
        return w4;
    }

    public static boolean K(int i5, int i6, int i7) {
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        if (i7 > 0 && i5 != i7) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i5;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i5;
        }
        return true;
    }

    public static void L(View view, int i5, int i6, int i7, int i8) {
        Y y4 = (Y) view.getLayoutParams();
        Rect rect = y4.f4191b;
        view.layout(i5 + rect.left + ((ViewGroup.MarginLayoutParams) y4).leftMargin, i6 + rect.top + ((ViewGroup.MarginLayoutParams) y4).topMargin, (i7 - rect.right) - ((ViewGroup.MarginLayoutParams) y4).rightMargin, (i8 - rect.bottom) - ((ViewGroup.MarginLayoutParams) y4).bottomMargin);
    }

    public static int g(int i5, int i6, int i7) {
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i6, i7) : size : Math.min(size, Math.max(i6, i7));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int w(int r4, int r5, int r6, int r7, boolean r8) {
        /*
            int r4 = r4 - r6
            r6 = 0
            int r4 = java.lang.Math.max(r6, r4)
            r0 = -2
            r1 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r8 == 0) goto L1d
            if (r7 < 0) goto L12
        L10:
            r5 = r3
            goto L30
        L12:
            if (r7 != r1) goto L1a
            if (r5 == r2) goto L22
            if (r5 == 0) goto L1a
            if (r5 == r3) goto L22
        L1a:
            r5 = r6
            r7 = r5
            goto L30
        L1d:
            if (r7 < 0) goto L20
            goto L10
        L20:
            if (r7 != r1) goto L24
        L22:
            r7 = r4
            goto L30
        L24:
            if (r7 != r0) goto L1a
            if (r5 == r2) goto L2e
            if (r5 != r3) goto L2b
            goto L2e
        L2b:
            r7 = r4
            r5 = r6
            goto L30
        L2e:
            r7 = r4
            r5 = r2
        L30:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.X.w(int, int, int, int, boolean):int");
    }

    public final int A() {
        RecyclerView recyclerView = this.f4179b;
        WeakHashMap weakHashMap = O.Y.f1904a;
        return O.H.d(recyclerView);
    }

    public final void A0(G g) {
        G g5 = this.f4182e;
        if (g5 != null && g != g5 && g5.f4025e) {
            g5.i();
        }
        this.f4182e = g;
        RecyclerView recyclerView = this.f4179b;
        m0 m0Var = recyclerView.f4110g0;
        m0Var.f4294p.removeCallbacks(m0Var);
        m0Var.f4291l.abortAnimation();
        if (g.h) {
            Log.w("RecyclerView", "An instance of " + g.getClass().getSimpleName() + " was started more than once. Each instance of" + g.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        }
        g.f4022b = recyclerView;
        g.f4023c = this;
        int i5 = g.f4021a;
        if (i5 == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        recyclerView.f4115j0.f4263a = i5;
        g.f4025e = true;
        g.f4024d = true;
        g.f4026f = recyclerView.f4125p.q(i5);
        g.f4022b.f4110g0.b();
        g.h = true;
    }

    public final int B() {
        RecyclerView recyclerView = this.f4179b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public boolean B0() {
        return false;
    }

    public final int C() {
        RecyclerView recyclerView = this.f4179b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public final int D() {
        RecyclerView recyclerView = this.f4179b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int E() {
        RecyclerView recyclerView = this.f4179b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int H(d0 d0Var, j0 j0Var) {
        return -1;
    }

    public final void I(View view, Rect rect) {
        Matrix matrix;
        Rect rect2 = ((Y) view.getLayoutParams()).f4191b;
        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        if (this.f4179b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.f4179b.n;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public boolean J() {
        return false;
    }

    public void M(int i5) {
        RecyclerView recyclerView = this.f4179b;
        if (recyclerView != null) {
            int i6 = recyclerView.h.i();
            for (int i7 = 0; i7 < i6; i7++) {
                recyclerView.h.h(i7).offsetLeftAndRight(i5);
            }
        }
    }

    public void N(int i5) {
        RecyclerView recyclerView = this.f4179b;
        if (recyclerView != null) {
            int i6 = recyclerView.h.i();
            for (int i7 = 0; i7 < i6; i7++) {
                recyclerView.h.h(i7).offsetTopAndBottom(i5);
            }
        }
    }

    public void O() {
    }

    public void P(RecyclerView recyclerView) {
    }

    public abstract void Q(RecyclerView recyclerView);

    public abstract View R(View view, int i5, d0 d0Var, j0 j0Var);

    public void S(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.f4179b;
        d0 d0Var = recyclerView.f4106e;
        j0 j0Var = recyclerView.f4115j0;
        if (recyclerView == null || accessibilityEvent == null) {
            return;
        }
        boolean z4 = true;
        if (!recyclerView.canScrollVertically(1) && !this.f4179b.canScrollVertically(-1) && !this.f4179b.canScrollHorizontally(-1) && !this.f4179b.canScrollHorizontally(1)) {
            z4 = false;
        }
        accessibilityEvent.setScrollable(z4);
        N n = this.f4179b.f4123o;
        if (n != null) {
            accessibilityEvent.setItemCount(n.getItemCount());
        }
    }

    public void T(d0 d0Var, j0 j0Var, P.j jVar) {
        boolean zCanScrollVertically = this.f4179b.canScrollVertically(-1);
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f2058a;
        if (zCanScrollVertically || this.f4179b.canScrollHorizontally(-1)) {
            jVar.a(8192);
            accessibilityNodeInfo.setScrollable(true);
        }
        if (this.f4179b.canScrollVertically(1) || this.f4179b.canScrollHorizontally(1)) {
            jVar.a(4096);
            accessibilityNodeInfo.setScrollable(true);
        }
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(H(d0Var, j0Var), x(d0Var, j0Var), false, 0));
    }

    public final void U(View view, P.j jVar) {
        n0 n0VarM = RecyclerView.M(view);
        if (n0VarM == null || n0VarM.isRemoved()) {
            return;
        }
        C0258e c0258e = this.f4178a;
        if (((ArrayList) c0258e.f4227e).contains(n0VarM.itemView)) {
            return;
        }
        RecyclerView recyclerView = this.f4179b;
        V(recyclerView.f4106e, recyclerView.f4115j0, view, jVar);
    }

    public void V(d0 d0Var, j0 j0Var, View view, P.j jVar) {
    }

    public void W(int i5, int i6) {
    }

    public void X() {
    }

    public void Y(int i5, int i6) {
    }

    public void Z(int i5, int i6) {
    }

    public void a0(int i5, int i6) {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.view.View r10, int r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.X.b(android.view.View, int, boolean):void");
    }

    public abstract void b0(d0 d0Var, j0 j0Var);

    public void c(String str) {
        RecyclerView recyclerView = this.f4179b;
        if (recyclerView != null) {
            recyclerView.k(str);
        }
    }

    public abstract void c0(j0 j0Var);

    public abstract boolean d();

    public void d0(Parcelable parcelable) {
    }

    public abstract boolean e();

    public Parcelable e0() {
        return null;
    }

    public boolean f(Y y4) {
        return y4 != null;
    }

    public void f0(int i5) {
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0061 A[PHI: r3
      0x0061: PHI (r3v8 int) = (r3v5 int), (r3v11 int) binds: [B:28:0x007d, B:20:0x0053] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g0(androidx.recyclerview.widget.d0 r3, androidx.recyclerview.widget.j0 r4, int r5, android.os.Bundle r6) {
        /*
            r2 = this;
            androidx.recyclerview.widget.RecyclerView r3 = r2.f4179b
            r4 = 0
            if (r3 != 0) goto L6
            return r4
        L6:
            int r3 = r2.f4189o
            int r6 = r2.n
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            androidx.recyclerview.widget.RecyclerView r1 = r2.f4179b
            android.graphics.Matrix r1 = r1.getMatrix()
            boolean r1 = r1.isIdentity()
            if (r1 == 0) goto L2b
            androidx.recyclerview.widget.RecyclerView r1 = r2.f4179b
            boolean r1 = r1.getGlobalVisibleRect(r0)
            if (r1 == 0) goto L2b
            int r3 = r0.height()
            int r6 = r0.width()
        L2b:
            r0 = 4096(0x1000, float:5.74E-42)
            r1 = 1
            if (r5 == r0) goto L63
            r0 = 8192(0x2000, float:1.148E-41)
            if (r5 == r0) goto L37
            r3 = r4
            r5 = r3
            goto L8a
        L37:
            androidx.recyclerview.widget.RecyclerView r5 = r2.f4179b
            r0 = -1
            boolean r5 = r5.canScrollVertically(r0)
            if (r5 == 0) goto L4c
            int r5 = r2.E()
            int r3 = r3 - r5
            int r5 = r2.B()
            int r3 = r3 - r5
            int r3 = -r3
            goto L4d
        L4c:
            r3 = r4
        L4d:
            androidx.recyclerview.widget.RecyclerView r5 = r2.f4179b
            boolean r5 = r5.canScrollHorizontally(r0)
            if (r5 == 0) goto L61
            int r5 = r2.C()
            int r6 = r6 - r5
            int r5 = r2.D()
            int r6 = r6 - r5
            int r5 = -r6
            goto L8a
        L61:
            r5 = r4
            goto L8a
        L63:
            androidx.recyclerview.widget.RecyclerView r5 = r2.f4179b
            boolean r5 = r5.canScrollVertically(r1)
            if (r5 == 0) goto L76
            int r5 = r2.E()
            int r3 = r3 - r5
            int r5 = r2.B()
            int r3 = r3 - r5
            goto L77
        L76:
            r3 = r4
        L77:
            androidx.recyclerview.widget.RecyclerView r5 = r2.f4179b
            boolean r5 = r5.canScrollHorizontally(r1)
            if (r5 == 0) goto L61
            int r5 = r2.C()
            int r6 = r6 - r5
            int r5 = r2.D()
            int r5 = r6 - r5
        L8a:
            if (r3 != 0) goto L8f
            if (r5 != 0) goto L8f
            return r4
        L8f:
            androidx.recyclerview.widget.RecyclerView r4 = r2.f4179b
            r4.i0(r5, r3, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.X.g0(androidx.recyclerview.widget.d0, androidx.recyclerview.widget.j0, int, android.os.Bundle):boolean");
    }

    public void h(int i5, int i6, j0 j0Var, Q1.b bVar) {
    }

    public void h0() {
        n0();
    }

    public void i(int i5, Q1.b bVar) {
    }

    public final void i0(d0 d0Var) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            if (!RecyclerView.M(u(iV)).shouldIgnore()) {
                View viewU = u(iV);
                l0(iV);
                d0Var.h(viewU);
            }
        }
    }

    public abstract int j(j0 j0Var);

    public final void j0(d0 d0Var) {
        ArrayList arrayList;
        int size = d0Var.f4217a.size();
        int i5 = size - 1;
        while (true) {
            arrayList = d0Var.f4217a;
            if (i5 < 0) {
                break;
            }
            View view = ((n0) arrayList.get(i5)).itemView;
            n0 n0VarM = RecyclerView.M(view);
            if (!n0VarM.shouldIgnore()) {
                n0VarM.setIsRecyclable(false);
                if (n0VarM.isTmpDetached()) {
                    this.f4179b.removeDetachedView(view, false);
                }
                T t4 = this.f4179b.f4091O;
                if (t4 != null) {
                    t4.e(n0VarM);
                }
                n0VarM.setIsRecyclable(true);
                n0 n0VarM2 = RecyclerView.M(view);
                n0VarM2.mScrapContainer = null;
                n0VarM2.mInChangeScrap = false;
                n0VarM2.clearReturnedFromScrapFlag();
                d0Var.i(n0VarM2);
            }
            i5--;
        }
        arrayList.clear();
        ArrayList arrayList2 = d0Var.f4218b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.f4179b.invalidate();
        }
    }

    public abstract int k(j0 j0Var);

    public final void k0(View view, d0 d0Var) {
        C0258e c0258e = this.f4178a;
        L l5 = (L) c0258e.f4225c;
        int i5 = c0258e.f4224b;
        if (i5 == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        }
        if (i5 == 2) {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        try {
            c0258e.f4224b = 1;
            c0258e.f4228f = view;
            int iIndexOfChild = l5.f4048a.indexOfChild(view);
            if (iIndexOfChild >= 0) {
                if (((J1.U) c0258e.f4226d).g(iIndexOfChild)) {
                    c0258e.u(view);
                }
                l5.h(iIndexOfChild);
            }
            c0258e.f4224b = 0;
            c0258e.f4228f = null;
            d0Var.h(view);
        } catch (Throwable th) {
            c0258e.f4224b = 0;
            c0258e.f4228f = null;
            throw th;
        }
    }

    public abstract int l(j0 j0Var);

    public final void l0(int i5) {
        if (u(i5) != null) {
            C0258e c0258e = this.f4178a;
            L l5 = (L) c0258e.f4225c;
            int i6 = c0258e.f4224b;
            if (i6 == 1) {
                throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
            }
            if (i6 == 2) {
                throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
            }
            try {
                int iJ = c0258e.j(i5);
                View childAt = l5.f4048a.getChildAt(iJ);
                if (childAt != null) {
                    c0258e.f4224b = 1;
                    c0258e.f4228f = childAt;
                    if (((J1.U) c0258e.f4226d).g(iJ)) {
                        c0258e.u(childAt);
                    }
                    l5.h(iJ);
                }
            } finally {
                c0258e.f4224b = 0;
                c0258e.f4228f = null;
            }
        }
    }

    public abstract int m(j0 j0Var);

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m0(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            int r0 = r8.C()
            int r1 = r8.E()
            int r2 = r8.n
            int r3 = r8.D()
            int r2 = r2 - r3
            int r3 = r8.f4189o
            int r4 = r8.B()
            int r3 = r3 - r4
            int r4 = r10.getLeft()
            int r5 = r11.left
            int r4 = r4 + r5
            int r5 = r10.getScrollX()
            int r4 = r4 - r5
            int r5 = r10.getTop()
            int r6 = r11.top
            int r5 = r5 + r6
            int r10 = r10.getScrollY()
            int r5 = r5 - r10
            int r10 = r11.width()
            int r10 = r10 + r4
            int r11 = r11.height()
            int r11 = r11 + r5
            int r4 = r4 - r0
            r0 = 0
            int r6 = java.lang.Math.min(r0, r4)
            int r5 = r5 - r1
            int r1 = java.lang.Math.min(r0, r5)
            int r10 = r10 - r2
            int r2 = java.lang.Math.max(r0, r10)
            int r11 = r11 - r3
            int r11 = java.lang.Math.max(r0, r11)
            int r3 = r8.A()
            r7 = 1
            if (r3 != r7) goto L5c
            if (r2 == 0) goto L57
            goto L64
        L57:
            int r2 = java.lang.Math.max(r6, r10)
            goto L64
        L5c:
            if (r6 == 0) goto L5f
            goto L63
        L5f:
            int r6 = java.lang.Math.min(r4, r2)
        L63:
            r2 = r6
        L64:
            if (r1 == 0) goto L67
            goto L6b
        L67:
            int r1 = java.lang.Math.min(r5, r11)
        L6b:
            int[] r10 = new int[]{r2, r1}
            r11 = r10[r0]
            r10 = r10[r7]
            if (r13 == 0) goto Lae
            android.view.View r13 = r9.getFocusedChild()
            if (r13 != 0) goto L7c
            goto Lb3
        L7c:
            int r1 = r8.C()
            int r2 = r8.E()
            int r3 = r8.n
            int r4 = r8.D()
            int r3 = r3 - r4
            int r4 = r8.f4189o
            int r5 = r8.B()
            int r4 = r4 - r5
            androidx.recyclerview.widget.RecyclerView r5 = r8.f4179b
            android.graphics.Rect r5 = r5.f4118l
            r8.y(r13, r5)
            int r13 = r5.left
            int r13 = r13 - r11
            if (r13 >= r3) goto Lb3
            int r13 = r5.right
            int r13 = r13 - r11
            if (r13 <= r1) goto Lb3
            int r13 = r5.top
            int r13 = r13 - r10
            if (r13 >= r4) goto Lb3
            int r13 = r5.bottom
            int r13 = r13 - r10
            if (r13 > r2) goto Lae
            goto Lb3
        Lae:
            if (r11 != 0) goto Lb4
            if (r10 == 0) goto Lb3
            goto Lb4
        Lb3:
            return r0
        Lb4:
            if (r12 == 0) goto Lba
            r9.scrollBy(r11, r10)
            goto Lbd
        Lba:
            r9.i0(r11, r10, r0)
        Lbd:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.X.m0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    public abstract int n(j0 j0Var);

    public final void n0() {
        RecyclerView recyclerView = this.f4179b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public abstract int o(j0 j0Var);

    public abstract int o0(int i5, d0 d0Var, j0 j0Var);

    public final void p(d0 d0Var) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            n0 n0VarM = RecyclerView.M(viewU);
            if (n0VarM.shouldIgnore()) {
                if (RecyclerView.f4067D0) {
                    Log.d("RecyclerView", "ignoring view " + n0VarM);
                }
            } else if (!n0VarM.isInvalid() || n0VarM.isRemoved() || this.f4179b.f4123o.hasStableIds()) {
                u(iV);
                this.f4178a.g(iV);
                d0Var.j(viewU);
                this.f4179b.f4112i.s(n0VarM);
            } else {
                l0(iV);
                d0Var.i(n0VarM);
            }
        }
    }

    public abstract void p0(int i5);

    public View q(int i5) {
        int iV = v();
        for (int i6 = 0; i6 < iV; i6++) {
            View viewU = u(i6);
            n0 n0VarM = RecyclerView.M(viewU);
            if (n0VarM != null && n0VarM.getLayoutPosition() == i5 && !n0VarM.shouldIgnore() && (this.f4179b.f4115j0.g || !n0VarM.isRemoved())) {
                return viewU;
            }
        }
        return null;
    }

    public abstract int q0(int i5, d0 d0Var, j0 j0Var);

    public abstract Y r();

    public final void r0(RecyclerView recyclerView) {
        s0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    public Y s(Context context, AttributeSet attributeSet) {
        return new Y(context, attributeSet);
    }

    public final void s0(int i5, int i6) {
        this.n = View.MeasureSpec.getSize(i5);
        int mode = View.MeasureSpec.getMode(i5);
        this.f4187l = mode;
        if (mode == 0 && !RecyclerView.f4070G0) {
            this.n = 0;
        }
        this.f4189o = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i6);
        this.f4188m = mode2;
        if (mode2 != 0 || RecyclerView.f4070G0) {
            return;
        }
        this.f4189o = 0;
    }

    public Y t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof Y ? new Y((Y) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new Y((ViewGroup.MarginLayoutParams) layoutParams) : new Y(layoutParams);
    }

    public void t0(Rect rect, int i5, int i6) {
        int iD = D() + C() + rect.width();
        int iB = B() + E() + rect.height();
        RecyclerView recyclerView = this.f4179b;
        WeakHashMap weakHashMap = O.Y.f1904a;
        this.f4179b.setMeasuredDimension(g(i5, iD, O.G.e(recyclerView)), g(i6, iB, O.G.d(this.f4179b)));
    }

    public final View u(int i5) {
        C0258e c0258e = this.f4178a;
        if (c0258e != null) {
            return c0258e.h(i5);
        }
        return null;
    }

    public final void u0(int i5, int i6) {
        int iV = v();
        if (iV == 0) {
            this.f4179b.q(i5, i6);
            return;
        }
        int i7 = Integer.MIN_VALUE;
        int i8 = Integer.MAX_VALUE;
        int i9 = Integer.MIN_VALUE;
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < iV; i11++) {
            View viewU = u(i11);
            Rect rect = this.f4179b.f4118l;
            y(viewU, rect);
            int i12 = rect.left;
            if (i12 < i10) {
                i10 = i12;
            }
            int i13 = rect.right;
            if (i13 > i7) {
                i7 = i13;
            }
            int i14 = rect.top;
            if (i14 < i8) {
                i8 = i14;
            }
            int i15 = rect.bottom;
            if (i15 > i9) {
                i9 = i15;
            }
        }
        this.f4179b.f4118l.set(i10, i8, i7, i9);
        t0(this.f4179b.f4118l, i5, i6);
    }

    public final int v() {
        C0258e c0258e = this.f4178a;
        if (c0258e != null) {
            return c0258e.i();
        }
        return 0;
    }

    public final void v0(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.f4179b = null;
            this.f4178a = null;
            this.n = 0;
            this.f4189o = 0;
        } else {
            this.f4179b = recyclerView;
            this.f4178a = recyclerView.h;
            this.n = recyclerView.getWidth();
            this.f4189o = recyclerView.getHeight();
        }
        this.f4187l = 1073741824;
        this.f4188m = 1073741824;
    }

    public final boolean w0(View view, int i5, int i6, Y y4) {
        return (!view.isLayoutRequested() && this.h && K(view.getWidth(), i5, ((ViewGroup.MarginLayoutParams) y4).width) && K(view.getHeight(), i6, ((ViewGroup.MarginLayoutParams) y4).height)) ? false : true;
    }

    public int x(d0 d0Var, j0 j0Var) {
        return -1;
    }

    public boolean x0() {
        return false;
    }

    public void y(View view, Rect rect) {
        boolean z4 = RecyclerView.f4066C0;
        Y y4 = (Y) view.getLayoutParams();
        Rect rect2 = y4.f4191b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) y4).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) y4).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) y4).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) y4).bottomMargin);
    }

    public final boolean y0(View view, int i5, int i6, Y y4) {
        return (this.h && K(view.getMeasuredWidth(), i5, ((ViewGroup.MarginLayoutParams) y4).width) && K(view.getMeasuredHeight(), i6, ((ViewGroup.MarginLayoutParams) y4).height)) ? false : true;
    }

    public final int z() {
        RecyclerView recyclerView = this.f4179b;
        N adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    public abstract void z0(int i5, RecyclerView recyclerView);
}
