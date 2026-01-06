package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: E, reason: collision with root package name */
    public boolean f4034E;

    /* renamed from: F, reason: collision with root package name */
    public int f4035F;

    /* renamed from: G, reason: collision with root package name */
    public int[] f4036G;

    /* renamed from: H, reason: collision with root package name */
    public View[] f4037H;
    public final SparseIntArray I;

    /* renamed from: J, reason: collision with root package name */
    public final SparseIntArray f4038J;

    /* renamed from: K, reason: collision with root package name */
    public final L0.e f4039K;

    /* renamed from: L, reason: collision with root package name */
    public final Rect f4040L;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.f4034E = false;
        this.f4035F = -1;
        this.I = new SparseIntArray();
        this.f4038J = new SparseIntArray();
        this.f4039K = new L0.e(11);
        this.f4040L = new Rect();
        o1(X.G(context, attributeSet, i5, i6).f4175b);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.X
    public final boolean B0() {
        return this.f4063z == null && !this.f4034E;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void D0(j0 j0Var, E e5, Q1.b bVar) {
        int i5;
        int i6 = this.f4035F;
        for (int i7 = 0; i7 < this.f4035F && (i5 = e5.f4011d) >= 0 && i5 < j0Var.b() && i6 > 0; i7++) {
            bVar.a(e5.f4011d, Math.max(0, e5.g));
            this.f4039K.getClass();
            i6--;
            e5.f4011d += e5.f4012e;
        }
    }

    @Override // androidx.recyclerview.widget.X
    public final int H(d0 d0Var, j0 j0Var) {
        if (this.f4053p == 0) {
            return this.f4035F;
        }
        if (j0Var.b() < 1) {
            return 0;
        }
        return k1(j0Var.b() - 1, d0Var, j0Var) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View Q0(d0 d0Var, j0 j0Var, boolean z4, boolean z5) {
        int i5;
        int iV;
        int iV2 = v();
        int i6 = 1;
        if (z5) {
            iV = v() - 1;
            i5 = -1;
            i6 = -1;
        } else {
            i5 = iV2;
            iV = 0;
        }
        int iB = j0Var.b();
        I0();
        int iK = this.f4055r.k();
        int iG = this.f4055r.g();
        View view = null;
        View view2 = null;
        while (iV != i5) {
            View viewU = u(iV);
            int iF = X.F(viewU);
            if (iF >= 0 && iF < iB && l1(iF, d0Var, j0Var) == 0) {
                if (((Y) viewU.getLayoutParams()).f4190a.isRemoved()) {
                    if (view2 == null) {
                        view2 = viewU;
                    }
                } else {
                    if (this.f4055r.e(viewU) < iG && this.f4055r.b(viewU) >= iK) {
                        return viewU;
                    }
                    if (view == null) {
                        view = viewU;
                    }
                }
            }
            iV += i6;
        }
        return view != null ? view : view2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00df, code lost:
    
        if (r13 == (r2 > r15)) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0126  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.X
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View R(android.view.View r23, int r24, androidx.recyclerview.widget.d0 r25, androidx.recyclerview.widget.j0 r26) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.R(android.view.View, int, androidx.recyclerview.widget.d0, androidx.recyclerview.widget.j0):android.view.View");
    }

    @Override // androidx.recyclerview.widget.X
    public final void T(d0 d0Var, j0 j0Var, P.j jVar) {
        super.T(d0Var, j0Var, jVar);
        jVar.f(GridView.class.getName());
    }

    @Override // androidx.recyclerview.widget.X
    public final void V(d0 d0Var, j0 j0Var, View view, P.j jVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof A)) {
            U(view, jVar);
            return;
        }
        A a2 = (A) layoutParams;
        int iK1 = k1(a2.f4190a.getLayoutPosition(), d0Var, j0Var);
        if (this.f4053p == 0) {
            jVar.g(P.i.a(a2.f3990e, a2.f3991f, iK1, 1, false));
        } else {
            jVar.g(P.i.a(iK1, 1, a2.f3990e, a2.f3991f, false));
        }
    }

    @Override // androidx.recyclerview.widget.X
    public final void W(int i5, int i6) {
        L0.e eVar = this.f4039K;
        eVar.n();
        ((SparseIntArray) eVar.f1542e).clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v37 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void W0(d0 d0Var, j0 j0Var, E e5, D d5) {
        int i5;
        int i6;
        int i7;
        int iD;
        int iC;
        int iE;
        int iD2;
        int iW;
        int iW2;
        ?? r8;
        int i8;
        View viewB;
        int iJ = this.f4055r.j();
        boolean z4 = iJ != 1073741824;
        int i9 = v() > 0 ? this.f4036G[this.f4035F] : 0;
        if (z4) {
            p1();
        }
        boolean z5 = e5.f4012e == 1;
        int iL1 = this.f4035F;
        if (!z5) {
            iL1 = l1(e5.f4011d, d0Var, j0Var) + m1(e5.f4011d, d0Var, j0Var);
        }
        int i10 = 0;
        while (i10 < this.f4035F && (i8 = e5.f4011d) >= 0 && i8 < j0Var.b() && iL1 > 0) {
            int i11 = e5.f4011d;
            int iM1 = m1(i11, d0Var, j0Var);
            if (iM1 > this.f4035F) {
                StringBuilder sb = new StringBuilder("Item at position ");
                sb.append(i11);
                sb.append(" requires ");
                sb.append(iM1);
                sb.append(" spans but GridLayoutManager has only ");
                throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.d(sb, this.f4035F, " spans."));
            }
            iL1 -= iM1;
            if (iL1 < 0 || (viewB = e5.b(d0Var)) == null) {
                break;
            }
            this.f4037H[i10] = viewB;
            i10++;
        }
        if (i10 == 0) {
            d5.f4005b = true;
            return;
        }
        if (z5) {
            i7 = 1;
            i6 = i10;
            i5 = 0;
        } else {
            i5 = i10 - 1;
            i6 = -1;
            i7 = -1;
        }
        int i12 = 0;
        while (i5 != i6) {
            View view = this.f4037H[i5];
            A a2 = (A) view.getLayoutParams();
            int iM12 = m1(X.F(view), d0Var, j0Var);
            a2.f3991f = iM12;
            a2.f3990e = i12;
            i12 += iM12;
            i5 += i7;
        }
        float f5 = BitmapDescriptorFactory.HUE_RED;
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            View view2 = this.f4037H[i14];
            if (e5.f4016k != null) {
                r8 = 0;
                r8 = 0;
                if (z5) {
                    b(view2, -1, true);
                } else {
                    b(view2, 0, true);
                }
            } else if (z5) {
                r8 = 0;
                b(view2, -1, false);
            } else {
                r8 = 0;
                b(view2, 0, false);
            }
            RecyclerView recyclerView = this.f4179b;
            Rect rect = this.f4040L;
            if (recyclerView == null) {
                rect.set(r8, r8, r8, r8);
            } else {
                rect.set(recyclerView.N(view2));
            }
            n1(view2, iJ, r8);
            int iC2 = this.f4055r.c(view2);
            if (iC2 > i13) {
                i13 = iC2;
            }
            float fD = (this.f4055r.d(view2) * 1.0f) / ((A) view2.getLayoutParams()).f3991f;
            if (fD > f5) {
                f5 = fD;
            }
        }
        if (z4) {
            h1(Math.max(Math.round(f5 * this.f4035F), i9));
            i13 = 0;
            for (int i15 = 0; i15 < i10; i15++) {
                View view3 = this.f4037H[i15];
                n1(view3, 1073741824, true);
                int iC3 = this.f4055r.c(view3);
                if (iC3 > i13) {
                    i13 = iC3;
                }
            }
        }
        for (int i16 = 0; i16 < i10; i16++) {
            View view4 = this.f4037H[i16];
            if (this.f4055r.c(view4) != i13) {
                A a3 = (A) view4.getLayoutParams();
                Rect rect2 = a3.f4191b;
                int i17 = rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) a3).topMargin + ((ViewGroup.MarginLayoutParams) a3).bottomMargin;
                int i18 = rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) a3).leftMargin + ((ViewGroup.MarginLayoutParams) a3).rightMargin;
                int iJ1 = j1(a3.f3990e, a3.f3991f);
                if (this.f4053p == 1) {
                    iW2 = X.w(iJ1, 1073741824, i18, ((ViewGroup.MarginLayoutParams) a3).width, false);
                    iW = View.MeasureSpec.makeMeasureSpec(i13 - i17, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i13 - i18, 1073741824);
                    iW = X.w(iJ1, 1073741824, i17, ((ViewGroup.MarginLayoutParams) a3).height, false);
                    iW2 = iMakeMeasureSpec;
                }
                if (y0(view4, iW2, iW, (Y) view4.getLayoutParams())) {
                    view4.measure(iW2, iW);
                }
            }
        }
        d5.f4004a = i13;
        if (this.f4053p != 1) {
            if (e5.f4013f == -1) {
                int i19 = e5.f4009b;
                iC = i19 - i13;
                iD = i19;
            } else {
                int i20 = e5.f4009b;
                iD = i20 + i13;
                iC = i20;
            }
            iE = 0;
            iD2 = 0;
        } else if (e5.f4013f == -1) {
            iD2 = e5.f4009b;
            iE = iD2 - i13;
            iC = 0;
            iD = 0;
        } else {
            int i21 = e5.f4009b;
            iE = i21;
            iD = 0;
            iD2 = i21 + i13;
            iC = 0;
        }
        for (int i22 = 0; i22 < i10; i22++) {
            View view5 = this.f4037H[i22];
            A a4 = (A) view5.getLayoutParams();
            if (this.f4053p != 1) {
                iE = E() + this.f4036G[a4.f3990e];
                iD2 = this.f4055r.d(view5) + iE;
            } else if (V0()) {
                int iC4 = C() + this.f4036G[this.f4035F - a4.f3990e];
                iD = iC4;
                iC = iC4 - this.f4055r.d(view5);
            } else {
                iC = C() + this.f4036G[a4.f3990e];
                iD = this.f4055r.d(view5) + iC;
            }
            X.L(view5, iC, iE, iD, iD2);
            if (a4.f4190a.isRemoved() || a4.f4190a.isUpdated()) {
                d5.f4006c = true;
            }
            d5.f4007d = view5.hasFocusable() | d5.f4007d;
        }
        Arrays.fill(this.f4037H, (Object) null);
    }

    @Override // androidx.recyclerview.widget.X
    public final void X() {
        L0.e eVar = this.f4039K;
        eVar.n();
        ((SparseIntArray) eVar.f1542e).clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void X0(d0 d0Var, j0 j0Var, C c2, int i5) {
        p1();
        if (j0Var.b() > 0 && !j0Var.g) {
            boolean z4 = i5 == 1;
            int iL1 = l1(c2.f4000b, d0Var, j0Var);
            if (z4) {
                while (iL1 > 0) {
                    int i6 = c2.f4000b;
                    if (i6 <= 0) {
                        break;
                    }
                    int i7 = i6 - 1;
                    c2.f4000b = i7;
                    iL1 = l1(i7, d0Var, j0Var);
                }
            } else {
                int iB = j0Var.b() - 1;
                int i8 = c2.f4000b;
                while (i8 < iB) {
                    int i9 = i8 + 1;
                    int iL12 = l1(i9, d0Var, j0Var);
                    if (iL12 <= iL1) {
                        break;
                    }
                    i8 = i9;
                    iL1 = iL12;
                }
                c2.f4000b = i8;
            }
        }
        i1();
    }

    @Override // androidx.recyclerview.widget.X
    public final void Y(int i5, int i6) {
        L0.e eVar = this.f4039K;
        eVar.n();
        ((SparseIntArray) eVar.f1542e).clear();
    }

    @Override // androidx.recyclerview.widget.X
    public final void Z(int i5, int i6) {
        L0.e eVar = this.f4039K;
        eVar.n();
        ((SparseIntArray) eVar.f1542e).clear();
    }

    @Override // androidx.recyclerview.widget.X
    public final void a0(int i5, int i6) {
        L0.e eVar = this.f4039K;
        eVar.n();
        ((SparseIntArray) eVar.f1542e).clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.X
    public final void b0(d0 d0Var, j0 j0Var) {
        boolean z4 = j0Var.g;
        SparseIntArray sparseIntArray = this.f4038J;
        SparseIntArray sparseIntArray2 = this.I;
        if (z4) {
            int iV = v();
            for (int i5 = 0; i5 < iV; i5++) {
                A a2 = (A) u(i5).getLayoutParams();
                int layoutPosition = a2.f4190a.getLayoutPosition();
                sparseIntArray2.put(layoutPosition, a2.f3991f);
                sparseIntArray.put(layoutPosition, a2.f3990e);
            }
        }
        super.b0(d0Var, j0Var);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.X
    public final void c0(j0 j0Var) {
        super.c0(j0Var);
        this.f4034E = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void d1(boolean z4) {
        if (z4) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.d1(false);
    }

    @Override // androidx.recyclerview.widget.X
    public final boolean f(Y y4) {
        return y4 instanceof A;
    }

    public final void h1(int i5) {
        int i6;
        int[] iArr = this.f4036G;
        int i7 = this.f4035F;
        if (iArr == null || iArr.length != i7 + 1 || iArr[iArr.length - 1] != i5) {
            iArr = new int[i7 + 1];
        }
        int i8 = 0;
        iArr[0] = 0;
        int i9 = i5 / i7;
        int i10 = i5 % i7;
        int i11 = 0;
        for (int i12 = 1; i12 <= i7; i12++) {
            i8 += i10;
            if (i8 <= 0 || i7 - i8 >= i10) {
                i6 = i9;
            } else {
                i6 = i9 + 1;
                i8 -= i7;
            }
            i11 += i6;
            iArr[i12] = i11;
        }
        this.f4036G = iArr;
    }

    public final void i1() {
        View[] viewArr = this.f4037H;
        if (viewArr == null || viewArr.length != this.f4035F) {
            this.f4037H = new View[this.f4035F];
        }
    }

    public final int j1(int i5, int i6) {
        if (this.f4053p != 1 || !V0()) {
            int[] iArr = this.f4036G;
            return iArr[i6 + i5] - iArr[i5];
        }
        int[] iArr2 = this.f4036G;
        int i7 = this.f4035F;
        return iArr2[i7 - i5] - iArr2[(i7 - i5) - i6];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.X
    public final int k(j0 j0Var) {
        return F0(j0Var);
    }

    public final int k1(int i5, d0 d0Var, j0 j0Var) {
        boolean z4 = j0Var.g;
        L0.e eVar = this.f4039K;
        if (!z4) {
            int i6 = this.f4035F;
            eVar.getClass();
            return L0.e.k(i5, i6);
        }
        int iB = d0Var.b(i5);
        if (iB != -1) {
            int i7 = this.f4035F;
            eVar.getClass();
            return L0.e.k(iB, i7);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i5);
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.X
    public final int l(j0 j0Var) {
        return G0(j0Var);
    }

    public final int l1(int i5, d0 d0Var, j0 j0Var) {
        boolean z4 = j0Var.g;
        L0.e eVar = this.f4039K;
        if (!z4) {
            int i6 = this.f4035F;
            eVar.getClass();
            return i5 % i6;
        }
        int i7 = this.f4038J.get(i5, -1);
        if (i7 != -1) {
            return i7;
        }
        int iB = d0Var.b(i5);
        if (iB != -1) {
            int i8 = this.f4035F;
            eVar.getClass();
            return iB % i8;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i5);
        return 0;
    }

    public final int m1(int i5, d0 d0Var, j0 j0Var) {
        boolean z4 = j0Var.g;
        L0.e eVar = this.f4039K;
        if (!z4) {
            eVar.getClass();
            return 1;
        }
        int i6 = this.I.get(i5, -1);
        if (i6 != -1) {
            return i6;
        }
        if (d0Var.b(i5) != -1) {
            eVar.getClass();
            return 1;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i5);
        return 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.X
    public final int n(j0 j0Var) {
        return F0(j0Var);
    }

    public final void n1(View view, int i5, boolean z4) {
        int iW;
        int iW2;
        A a2 = (A) view.getLayoutParams();
        Rect rect = a2.f4191b;
        int i6 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) a2).topMargin + ((ViewGroup.MarginLayoutParams) a2).bottomMargin;
        int i7 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) a2).leftMargin + ((ViewGroup.MarginLayoutParams) a2).rightMargin;
        int iJ1 = j1(a2.f3990e, a2.f3991f);
        if (this.f4053p == 1) {
            iW2 = X.w(iJ1, i5, i7, ((ViewGroup.MarginLayoutParams) a2).width, false);
            iW = X.w(this.f4055r.l(), this.f4188m, i6, ((ViewGroup.MarginLayoutParams) a2).height, true);
        } else {
            int iW3 = X.w(iJ1, i5, i6, ((ViewGroup.MarginLayoutParams) a2).height, false);
            int iW4 = X.w(this.f4055r.l(), this.f4187l, i7, ((ViewGroup.MarginLayoutParams) a2).width, true);
            iW = iW3;
            iW2 = iW4;
        }
        Y y4 = (Y) view.getLayoutParams();
        if (z4 ? y0(view, iW2, iW, y4) : w0(view, iW2, iW, y4)) {
            view.measure(iW2, iW);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.X
    public final int o(j0 j0Var) {
        return G0(j0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.X
    public final int o0(int i5, d0 d0Var, j0 j0Var) {
        p1();
        i1();
        return super.o0(i5, d0Var, j0Var);
    }

    public final void o1(int i5) {
        if (i5 == this.f4035F) {
            return;
        }
        this.f4034E = true;
        if (i5 < 1) {
            throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.a(i5, "Span count should be at least 1. Provided "));
        }
        this.f4035F = i5;
        this.f4039K.n();
        n0();
    }

    public final void p1() {
        int iB;
        int iE;
        if (this.f4053p == 1) {
            iB = this.n - D();
            iE = C();
        } else {
            iB = this.f4189o - B();
            iE = E();
        }
        h1(iB - iE);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.X
    public final int q0(int i5, d0 d0Var, j0 j0Var) {
        p1();
        i1();
        return super.q0(i5, d0Var, j0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.X
    public final Y r() {
        return this.f4053p == 0 ? new A(-2, -1) : new A(-1, -2);
    }

    @Override // androidx.recyclerview.widget.X
    public final Y s(Context context, AttributeSet attributeSet) {
        A a2 = new A(context, attributeSet);
        a2.f3990e = -1;
        a2.f3991f = 0;
        return a2;
    }

    @Override // androidx.recyclerview.widget.X
    public final Y t(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            A a2 = new A((ViewGroup.MarginLayoutParams) layoutParams);
            a2.f3990e = -1;
            a2.f3991f = 0;
            return a2;
        }
        A a3 = new A(layoutParams);
        a3.f3990e = -1;
        a3.f3991f = 0;
        return a3;
    }

    @Override // androidx.recyclerview.widget.X
    public final void t0(Rect rect, int i5, int i6) {
        int iG;
        int iG2;
        if (this.f4036G == null) {
            super.t0(rect, i5, i6);
        }
        int iD = D() + C();
        int iB = B() + E();
        if (this.f4053p == 1) {
            int iHeight = rect.height() + iB;
            RecyclerView recyclerView = this.f4179b;
            WeakHashMap weakHashMap = O.Y.f1904a;
            iG2 = X.g(i6, iHeight, O.G.d(recyclerView));
            int[] iArr = this.f4036G;
            iG = X.g(i5, iArr[iArr.length - 1] + iD, O.G.e(this.f4179b));
        } else {
            int iWidth = rect.width() + iD;
            RecyclerView recyclerView2 = this.f4179b;
            WeakHashMap weakHashMap2 = O.Y.f1904a;
            iG = X.g(i5, iWidth, O.G.e(recyclerView2));
            int[] iArr2 = this.f4036G;
            iG2 = X.g(i6, iArr2[iArr2.length - 1] + iB, O.G.d(this.f4179b));
        }
        this.f4179b.setMeasuredDimension(iG, iG2);
    }

    @Override // androidx.recyclerview.widget.X
    public final int x(d0 d0Var, j0 j0Var) {
        if (this.f4053p == 1) {
            return this.f4035F;
        }
        if (j0Var.b() < 1) {
            return 0;
        }
        return k1(j0Var.b() - 1, d0Var, j0Var) + 1;
    }

    public GridLayoutManager(int i5) {
        super(1);
        this.f4034E = false;
        this.f4035F = -1;
        this.I = new SparseIntArray();
        this.f4038J = new SparseIntArray();
        this.f4039K = new L0.e(11);
        this.f4040L = new Rect();
        o1(i5);
    }
}
