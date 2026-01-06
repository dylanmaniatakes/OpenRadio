package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends X implements i0 {

    /* renamed from: B, reason: collision with root package name */
    public final L0.s f4146B;

    /* renamed from: C, reason: collision with root package name */
    public final int f4147C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f4148D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f4149E;

    /* renamed from: F, reason: collision with root package name */
    public u0 f4150F;

    /* renamed from: G, reason: collision with root package name */
    public final Rect f4151G;

    /* renamed from: H, reason: collision with root package name */
    public final r0 f4152H;
    public final boolean I;

    /* renamed from: J, reason: collision with root package name */
    public int[] f4153J;

    /* renamed from: K, reason: collision with root package name */
    public final RunnableC0272t f4154K;

    /* renamed from: p, reason: collision with root package name */
    public final int f4155p;

    /* renamed from: q, reason: collision with root package name */
    public final v0[] f4156q;

    /* renamed from: r, reason: collision with root package name */
    public final androidx.emoji2.text.f f4157r;

    /* renamed from: s, reason: collision with root package name */
    public final androidx.emoji2.text.f f4158s;

    /* renamed from: t, reason: collision with root package name */
    public final int f4159t;

    /* renamed from: u, reason: collision with root package name */
    public int f4160u;

    /* renamed from: v, reason: collision with root package name */
    public final B f4161v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f4162w;

    /* renamed from: y, reason: collision with root package name */
    public final BitSet f4164y;

    /* renamed from: x, reason: collision with root package name */
    public boolean f4163x = false;

    /* renamed from: z, reason: collision with root package name */
    public int f4165z = -1;

    /* renamed from: A, reason: collision with root package name */
    public int f4145A = Integer.MIN_VALUE;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i5, int i6) {
        this.f4155p = -1;
        this.f4162w = false;
        L0.s sVar = new L0.s(11, false);
        this.f4146B = sVar;
        this.f4147C = 2;
        this.f4151G = new Rect();
        this.f4152H = new r0(this);
        this.I = true;
        this.f4154K = new RunnableC0272t(1, this);
        W wG = X.G(context, attributeSet, i5, i6);
        int i7 = wG.f4174a;
        if (i7 != 0 && i7 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        c(null);
        if (i7 != this.f4159t) {
            this.f4159t = i7;
            androidx.emoji2.text.f fVar = this.f4157r;
            this.f4157r = this.f4158s;
            this.f4158s = fVar;
            n0();
        }
        int i8 = wG.f4175b;
        c(null);
        if (i8 != this.f4155p) {
            sVar.c();
            n0();
            this.f4155p = i8;
            this.f4164y = new BitSet(this.f4155p);
            this.f4156q = new v0[this.f4155p];
            for (int i9 = 0; i9 < this.f4155p; i9++) {
                this.f4156q[i9] = new v0(this, i9);
            }
            n0();
        }
        boolean z4 = wG.f4176c;
        c(null);
        u0 u0Var = this.f4150F;
        if (u0Var != null && u0Var.f4343q != z4) {
            u0Var.f4343q = z4;
        }
        this.f4162w = z4;
        n0();
        B b5 = new B();
        b5.f3992a = true;
        b5.f3997f = 0;
        b5.g = 0;
        this.f4161v = b5;
        this.f4157r = androidx.emoji2.text.f.a(this, this.f4159t);
        this.f4158s = androidx.emoji2.text.f.a(this, 1 - this.f4159t);
    }

    public static int f1(int i5, int i6, int i7) {
        if (i6 == 0 && i7 == 0) {
            return i5;
        }
        int mode = View.MeasureSpec.getMode(i5);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i5) - i6) - i7), mode) : i5;
    }

    @Override // androidx.recyclerview.widget.X
    public final boolean B0() {
        return this.f4150F == null;
    }

    public final int C0(int i5) {
        if (v() == 0) {
            return this.f4163x ? 1 : -1;
        }
        return (i5 < M0()) != this.f4163x ? -1 : 1;
    }

    public final boolean D0() {
        int iM0;
        if (v() != 0 && this.f4147C != 0 && this.g) {
            if (this.f4163x) {
                iM0 = N0();
                M0();
            } else {
                iM0 = M0();
                N0();
            }
            L0.s sVar = this.f4146B;
            if (iM0 == 0 && R0() != null) {
                sVar.c();
                this.f4183f = true;
                n0();
                return true;
            }
        }
        return false;
    }

    public final int E0(j0 j0Var) {
        if (v() == 0) {
            return 0;
        }
        androidx.emoji2.text.f fVar = this.f4157r;
        boolean z4 = this.I;
        return AbstractC0271s.a(j0Var, fVar, J0(!z4), I0(!z4), this, this.I);
    }

    public final int F0(j0 j0Var) {
        if (v() == 0) {
            return 0;
        }
        androidx.emoji2.text.f fVar = this.f4157r;
        boolean z4 = this.I;
        return AbstractC0271s.b(j0Var, fVar, J0(!z4), I0(!z4), this, this.I, this.f4163x);
    }

    public final int G0(j0 j0Var) {
        if (v() == 0) {
            return 0;
        }
        androidx.emoji2.text.f fVar = this.f4157r;
        boolean z4 = this.I;
        return AbstractC0271s.c(j0Var, fVar, J0(!z4), I0(!z4), this, this.I);
    }

    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean, int] */
    public final int H0(d0 d0Var, B b5, j0 j0Var) {
        v0 v0Var;
        ?? r6;
        int i5;
        int iH;
        int iC;
        int iK;
        int iC2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        int i11 = 1;
        this.f4164y.set(0, this.f4155p, true);
        B b6 = this.f4161v;
        int i12 = b6.f3998i ? b5.f3996e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : b5.f3996e == 1 ? b5.g + b5.f3993b : b5.f3997f - b5.f3993b;
        int i13 = b5.f3996e;
        for (int i14 = 0; i14 < this.f4155p; i14++) {
            if (!this.f4156q[i14].f4349a.isEmpty()) {
                e1(this.f4156q[i14], i13, i12);
            }
        }
        int iG = this.f4163x ? this.f4157r.g() : this.f4157r.k();
        boolean z4 = false;
        while (true) {
            int i15 = b5.f3994c;
            if (((i15 < 0 || i15 >= j0Var.b()) ? i10 : i11) == 0 || (!b6.f3998i && this.f4164y.isEmpty())) {
                break;
            }
            View view = d0Var.k(b5.f3994c, Long.MAX_VALUE).itemView;
            b5.f3994c += b5.f3995d;
            s0 s0Var = (s0) view.getLayoutParams();
            int layoutPosition = s0Var.f4190a.getLayoutPosition();
            L0.s sVar = this.f4146B;
            int[] iArr = (int[]) sVar.f1596d;
            int i16 = (iArr == null || layoutPosition >= iArr.length) ? -1 : iArr[layoutPosition];
            if (i16 == -1) {
                if (V0(b5.f3996e)) {
                    i9 = this.f4155p - i11;
                    i8 = -1;
                    i7 = -1;
                } else {
                    i7 = i11;
                    i8 = this.f4155p;
                    i9 = i10;
                }
                v0 v0Var2 = null;
                if (b5.f3996e == i11) {
                    int iK2 = this.f4157r.k();
                    int i17 = Integer.MAX_VALUE;
                    while (i9 != i8) {
                        v0 v0Var3 = this.f4156q[i9];
                        int iF = v0Var3.f(iK2);
                        if (iF < i17) {
                            i17 = iF;
                            v0Var2 = v0Var3;
                        }
                        i9 += i7;
                    }
                } else {
                    int iG2 = this.f4157r.g();
                    int i18 = Integer.MIN_VALUE;
                    while (i9 != i8) {
                        v0 v0Var4 = this.f4156q[i9];
                        int iH2 = v0Var4.h(iG2);
                        if (iH2 > i18) {
                            v0Var2 = v0Var4;
                            i18 = iH2;
                        }
                        i9 += i7;
                    }
                }
                v0Var = v0Var2;
                sVar.d(layoutPosition);
                ((int[]) sVar.f1596d)[layoutPosition] = v0Var.f4353e;
            } else {
                v0Var = this.f4156q[i16];
            }
            s0Var.f4329e = v0Var;
            if (b5.f3996e == 1) {
                r6 = 0;
                b(view, -1, false);
            } else {
                r6 = 0;
                b(view, 0, false);
            }
            if (this.f4159t == 1) {
                i5 = 1;
                T0(view, X.w(this.f4160u, this.f4187l, r6, ((ViewGroup.MarginLayoutParams) s0Var).width, r6), X.w(this.f4189o, this.f4188m, B() + E(), ((ViewGroup.MarginLayoutParams) s0Var).height, true));
            } else {
                i5 = 1;
                T0(view, X.w(this.n, this.f4187l, D() + C(), ((ViewGroup.MarginLayoutParams) s0Var).width, true), X.w(this.f4160u, this.f4188m, 0, ((ViewGroup.MarginLayoutParams) s0Var).height, false));
            }
            if (b5.f3996e == i5) {
                iC = v0Var.f(iG);
                iH = this.f4157r.c(view) + iC;
            } else {
                iH = v0Var.h(iG);
                iC = iH - this.f4157r.c(view);
            }
            if (b5.f3996e == 1) {
                v0 v0Var5 = s0Var.f4329e;
                v0Var5.getClass();
                s0 s0Var2 = (s0) view.getLayoutParams();
                s0Var2.f4329e = v0Var5;
                ArrayList arrayList = v0Var5.f4349a;
                arrayList.add(view);
                v0Var5.f4351c = Integer.MIN_VALUE;
                if (arrayList.size() == 1) {
                    v0Var5.f4350b = Integer.MIN_VALUE;
                }
                if (s0Var2.f4190a.isRemoved() || s0Var2.f4190a.isUpdated()) {
                    v0Var5.f4352d = v0Var5.f4354f.f4157r.c(view) + v0Var5.f4352d;
                }
            } else {
                v0 v0Var6 = s0Var.f4329e;
                v0Var6.getClass();
                s0 s0Var3 = (s0) view.getLayoutParams();
                s0Var3.f4329e = v0Var6;
                ArrayList arrayList2 = v0Var6.f4349a;
                arrayList2.add(0, view);
                v0Var6.f4350b = Integer.MIN_VALUE;
                if (arrayList2.size() == 1) {
                    v0Var6.f4351c = Integer.MIN_VALUE;
                }
                if (s0Var3.f4190a.isRemoved() || s0Var3.f4190a.isUpdated()) {
                    v0Var6.f4352d = v0Var6.f4354f.f4157r.c(view) + v0Var6.f4352d;
                }
            }
            if (S0() && this.f4159t == 1) {
                iC2 = this.f4158s.g() - (((this.f4155p - 1) - v0Var.f4353e) * this.f4160u);
                iK = iC2 - this.f4158s.c(view);
            } else {
                iK = this.f4158s.k() + (v0Var.f4353e * this.f4160u);
                iC2 = this.f4158s.c(view) + iK;
            }
            if (this.f4159t == 1) {
                X.L(view, iK, iC, iC2, iH);
            } else {
                X.L(view, iC, iK, iH, iC2);
            }
            e1(v0Var, b6.f3996e, i12);
            X0(d0Var, b6);
            if (b6.h && view.hasFocusable()) {
                i6 = 0;
                this.f4164y.set(v0Var.f4353e, false);
            } else {
                i6 = 0;
            }
            i10 = i6;
            i11 = 1;
            z4 = true;
        }
        int i19 = i10;
        if (!z4) {
            X0(d0Var, b6);
        }
        int iK3 = b6.f3996e == -1 ? this.f4157r.k() - P0(this.f4157r.k()) : O0(this.f4157r.g()) - this.f4157r.g();
        return iK3 > 0 ? Math.min(b5.f3993b, iK3) : i19;
    }

    public final View I0(boolean z4) {
        int iK = this.f4157r.k();
        int iG = this.f4157r.g();
        View view = null;
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            int iE = this.f4157r.e(viewU);
            int iB = this.f4157r.b(viewU);
            if (iB > iK && iE < iG) {
                if (iB <= iG || !z4) {
                    return viewU;
                }
                if (view == null) {
                    view = viewU;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.X
    public final boolean J() {
        return this.f4147C != 0;
    }

    public final View J0(boolean z4) {
        int iK = this.f4157r.k();
        int iG = this.f4157r.g();
        int iV = v();
        View view = null;
        for (int i5 = 0; i5 < iV; i5++) {
            View viewU = u(i5);
            int iE = this.f4157r.e(viewU);
            if (this.f4157r.b(viewU) > iK && iE < iG) {
                if (iE >= iK || !z4) {
                    return viewU;
                }
                if (view == null) {
                    view = viewU;
                }
            }
        }
        return view;
    }

    public final void K0(d0 d0Var, j0 j0Var, boolean z4) {
        int iG;
        int iO0 = O0(Integer.MIN_VALUE);
        if (iO0 != Integer.MIN_VALUE && (iG = this.f4157r.g() - iO0) > 0) {
            int i5 = iG - (-b1(-iG, d0Var, j0Var));
            if (!z4 || i5 <= 0) {
                return;
            }
            this.f4157r.p(i5);
        }
    }

    public final void L0(d0 d0Var, j0 j0Var, boolean z4) {
        int iK;
        int iP0 = P0(Integer.MAX_VALUE);
        if (iP0 != Integer.MAX_VALUE && (iK = iP0 - this.f4157r.k()) > 0) {
            int iB1 = iK - b1(iK, d0Var, j0Var);
            if (!z4 || iB1 <= 0) {
                return;
            }
            this.f4157r.p(-iB1);
        }
    }

    @Override // androidx.recyclerview.widget.X
    public final void M(int i5) {
        super.M(i5);
        for (int i6 = 0; i6 < this.f4155p; i6++) {
            v0 v0Var = this.f4156q[i6];
            int i7 = v0Var.f4350b;
            if (i7 != Integer.MIN_VALUE) {
                v0Var.f4350b = i7 + i5;
            }
            int i8 = v0Var.f4351c;
            if (i8 != Integer.MIN_VALUE) {
                v0Var.f4351c = i8 + i5;
            }
        }
    }

    public final int M0() {
        if (v() == 0) {
            return 0;
        }
        return X.F(u(0));
    }

    @Override // androidx.recyclerview.widget.X
    public final void N(int i5) {
        super.N(i5);
        for (int i6 = 0; i6 < this.f4155p; i6++) {
            v0 v0Var = this.f4156q[i6];
            int i7 = v0Var.f4350b;
            if (i7 != Integer.MIN_VALUE) {
                v0Var.f4350b = i7 + i5;
            }
            int i8 = v0Var.f4351c;
            if (i8 != Integer.MIN_VALUE) {
                v0Var.f4351c = i8 + i5;
            }
        }
    }

    public final int N0() {
        int iV = v();
        if (iV == 0) {
            return 0;
        }
        return X.F(u(iV - 1));
    }

    @Override // androidx.recyclerview.widget.X
    public final void O() {
        this.f4146B.c();
        for (int i5 = 0; i5 < this.f4155p; i5++) {
            this.f4156q[i5].b();
        }
    }

    public final int O0(int i5) {
        int iF = this.f4156q[0].f(i5);
        for (int i6 = 1; i6 < this.f4155p; i6++) {
            int iF2 = this.f4156q[i6].f(i5);
            if (iF2 > iF) {
                iF = iF2;
            }
        }
        return iF;
    }

    public final int P0(int i5) {
        int iH = this.f4156q[0].h(i5);
        for (int i6 = 1; i6 < this.f4155p; i6++) {
            int iH2 = this.f4156q[i6].h(i5);
            if (iH2 < iH) {
                iH = iH2;
            }
        }
        return iH;
    }

    @Override // androidx.recyclerview.widget.X
    public final void Q(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f4179b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.f4154K);
        }
        for (int i5 = 0; i5 < this.f4155p; i5++) {
            this.f4156q[i5].b();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q0(int r8, int r9, int r10) {
        /*
            r7 = this;
            boolean r0 = r7.f4163x
            if (r0 == 0) goto L9
            int r0 = r7.N0()
            goto Ld
        L9:
            int r0 = r7.M0()
        Ld:
            r1 = 8
            if (r10 != r1) goto L1b
            if (r8 >= r9) goto L17
            int r2 = r9 + 1
        L15:
            r3 = r8
            goto L1e
        L17:
            int r2 = r8 + 1
            r3 = r9
            goto L1e
        L1b:
            int r2 = r8 + r9
            goto L15
        L1e:
            L0.s r4 = r7.f4146B
            r4.l(r3)
            r5 = 1
            if (r10 == r5) goto L37
            r6 = 2
            if (r10 == r6) goto L33
            if (r10 == r1) goto L2c
            goto L3a
        L2c:
            r4.r(r8, r5)
            r4.q(r9, r5)
            goto L3a
        L33:
            r4.r(r8, r9)
            goto L3a
        L37:
            r4.q(r8, r9)
        L3a:
            if (r2 > r0) goto L3d
            return
        L3d:
            boolean r8 = r7.f4163x
            if (r8 == 0) goto L46
            int r8 = r7.M0()
            goto L4a
        L46:
            int r8 = r7.N0()
        L4a:
            if (r3 > r8) goto L4f
            r7.n0()
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.Q0(int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x005f  */
    @Override // androidx.recyclerview.widget.X
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View R(android.view.View r9, int r10, androidx.recyclerview.widget.d0 r11, androidx.recyclerview.widget.j0 r12) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.R(android.view.View, int, androidx.recyclerview.widget.d0, androidx.recyclerview.widget.j0):android.view.View");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ff A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x002c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View R0() {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.R0():android.view.View");
    }

    @Override // androidx.recyclerview.widget.X
    public final void S(AccessibilityEvent accessibilityEvent) {
        super.S(accessibilityEvent);
        if (v() > 0) {
            View viewJ0 = J0(false);
            View viewI0 = I0(false);
            if (viewJ0 == null || viewI0 == null) {
                return;
            }
            int iF = X.F(viewJ0);
            int iF2 = X.F(viewI0);
            if (iF < iF2) {
                accessibilityEvent.setFromIndex(iF);
                accessibilityEvent.setToIndex(iF2);
            } else {
                accessibilityEvent.setFromIndex(iF2);
                accessibilityEvent.setToIndex(iF);
            }
        }
    }

    public final boolean S0() {
        return A() == 1;
    }

    public final void T0(View view, int i5, int i6) {
        RecyclerView recyclerView = this.f4179b;
        Rect rect = this.f4151G;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.N(view));
        }
        s0 s0Var = (s0) view.getLayoutParams();
        int iF1 = f1(i5, ((ViewGroup.MarginLayoutParams) s0Var).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) s0Var).rightMargin + rect.right);
        int iF12 = f1(i6, ((ViewGroup.MarginLayoutParams) s0Var).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) s0Var).bottomMargin + rect.bottom);
        if (w0(view, iF1, iF12, s0Var)) {
            view.measure(iF1, iF12);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0405  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U0(androidx.recyclerview.widget.d0 r17, androidx.recyclerview.widget.j0 r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 1056
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.U0(androidx.recyclerview.widget.d0, androidx.recyclerview.widget.j0, boolean):void");
    }

    public final boolean V0(int i5) {
        if (this.f4159t == 0) {
            return (i5 == -1) != this.f4163x;
        }
        return ((i5 == -1) == this.f4163x) == S0();
    }

    @Override // androidx.recyclerview.widget.X
    public final void W(int i5, int i6) {
        Q0(i5, i6, 1);
    }

    public final void W0(int i5, j0 j0Var) {
        int iM0;
        int i6;
        if (i5 > 0) {
            iM0 = N0();
            i6 = 1;
        } else {
            iM0 = M0();
            i6 = -1;
        }
        B b5 = this.f4161v;
        b5.f3992a = true;
        d1(iM0, j0Var);
        c1(i6);
        b5.f3994c = iM0 + b5.f3995d;
        b5.f3993b = Math.abs(i5);
    }

    @Override // androidx.recyclerview.widget.X
    public final void X() {
        this.f4146B.c();
        n0();
    }

    public final void X0(d0 d0Var, B b5) {
        if (!b5.f3992a || b5.f3998i) {
            return;
        }
        if (b5.f3993b == 0) {
            if (b5.f3996e == -1) {
                Y0(d0Var, b5.g);
                return;
            } else {
                Z0(d0Var, b5.f3997f);
                return;
            }
        }
        int i5 = 1;
        if (b5.f3996e == -1) {
            int i6 = b5.f3997f;
            int iH = this.f4156q[0].h(i6);
            while (i5 < this.f4155p) {
                int iH2 = this.f4156q[i5].h(i6);
                if (iH2 > iH) {
                    iH = iH2;
                }
                i5++;
            }
            int i7 = i6 - iH;
            Y0(d0Var, i7 < 0 ? b5.g : b5.g - Math.min(i7, b5.f3993b));
            return;
        }
        int i8 = b5.g;
        int iF = this.f4156q[0].f(i8);
        while (i5 < this.f4155p) {
            int iF2 = this.f4156q[i5].f(i8);
            if (iF2 < iF) {
                iF = iF2;
            }
            i5++;
        }
        int i9 = iF - b5.g;
        Z0(d0Var, i9 < 0 ? b5.f3997f : Math.min(i9, b5.f3993b) + b5.f3997f);
    }

    @Override // androidx.recyclerview.widget.X
    public final void Y(int i5, int i6) {
        Q0(i5, i6, 8);
    }

    public final void Y0(d0 d0Var, int i5) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            if (this.f4157r.e(viewU) < i5 || this.f4157r.o(viewU) < i5) {
                return;
            }
            s0 s0Var = (s0) viewU.getLayoutParams();
            s0Var.getClass();
            if (s0Var.f4329e.f4349a.size() == 1) {
                return;
            }
            v0 v0Var = s0Var.f4329e;
            ArrayList arrayList = v0Var.f4349a;
            int size = arrayList.size();
            View view = (View) arrayList.remove(size - 1);
            s0 s0Var2 = (s0) view.getLayoutParams();
            s0Var2.f4329e = null;
            if (s0Var2.f4190a.isRemoved() || s0Var2.f4190a.isUpdated()) {
                v0Var.f4352d -= v0Var.f4354f.f4157r.c(view);
            }
            if (size == 1) {
                v0Var.f4350b = Integer.MIN_VALUE;
            }
            v0Var.f4351c = Integer.MIN_VALUE;
            k0(viewU, d0Var);
        }
    }

    @Override // androidx.recyclerview.widget.X
    public final void Z(int i5, int i6) {
        Q0(i5, i6, 2);
    }

    public final void Z0(d0 d0Var, int i5) {
        while (v() > 0) {
            View viewU = u(0);
            if (this.f4157r.b(viewU) > i5 || this.f4157r.n(viewU) > i5) {
                return;
            }
            s0 s0Var = (s0) viewU.getLayoutParams();
            s0Var.getClass();
            if (s0Var.f4329e.f4349a.size() == 1) {
                return;
            }
            v0 v0Var = s0Var.f4329e;
            ArrayList arrayList = v0Var.f4349a;
            View view = (View) arrayList.remove(0);
            s0 s0Var2 = (s0) view.getLayoutParams();
            s0Var2.f4329e = null;
            if (arrayList.size() == 0) {
                v0Var.f4351c = Integer.MIN_VALUE;
            }
            if (s0Var2.f4190a.isRemoved() || s0Var2.f4190a.isUpdated()) {
                v0Var.f4352d -= v0Var.f4354f.f4157r.c(view);
            }
            v0Var.f4350b = Integer.MIN_VALUE;
            k0(viewU, d0Var);
        }
    }

    @Override // androidx.recyclerview.widget.i0
    public final PointF a(int i5) {
        int iC0 = C0(i5);
        PointF pointF = new PointF();
        if (iC0 == 0) {
            return null;
        }
        if (this.f4159t == 0) {
            pointF.x = iC0;
            pointF.y = BitmapDescriptorFactory.HUE_RED;
        } else {
            pointF.x = BitmapDescriptorFactory.HUE_RED;
            pointF.y = iC0;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.X
    public final void a0(int i5, int i6) {
        Q0(i5, i6, 4);
    }

    public final void a1() {
        if (this.f4159t == 1 || !S0()) {
            this.f4163x = this.f4162w;
        } else {
            this.f4163x = !this.f4162w;
        }
    }

    @Override // androidx.recyclerview.widget.X
    public final void b0(d0 d0Var, j0 j0Var) {
        U0(d0Var, j0Var, true);
    }

    public final int b1(int i5, d0 d0Var, j0 j0Var) {
        if (v() == 0 || i5 == 0) {
            return 0;
        }
        W0(i5, j0Var);
        B b5 = this.f4161v;
        int iH0 = H0(d0Var, b5, j0Var);
        if (b5.f3993b >= iH0) {
            i5 = i5 < 0 ? -iH0 : iH0;
        }
        this.f4157r.p(-i5);
        this.f4148D = this.f4163x;
        b5.f3993b = 0;
        X0(d0Var, b5);
        return i5;
    }

    @Override // androidx.recyclerview.widget.X
    public final void c(String str) {
        if (this.f4150F == null) {
            super.c(str);
        }
    }

    @Override // androidx.recyclerview.widget.X
    public final void c0(j0 j0Var) {
        this.f4165z = -1;
        this.f4145A = Integer.MIN_VALUE;
        this.f4150F = null;
        this.f4152H.a();
    }

    public final void c1(int i5) {
        B b5 = this.f4161v;
        b5.f3996e = i5;
        b5.f3995d = this.f4163x != (i5 == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.X
    public final boolean d() {
        return this.f4159t == 0;
    }

    @Override // androidx.recyclerview.widget.X
    public final void d0(Parcelable parcelable) {
        if (parcelable instanceof u0) {
            u0 u0Var = (u0) parcelable;
            this.f4150F = u0Var;
            if (this.f4165z != -1) {
                u0Var.f4340m = null;
                u0Var.f4339l = 0;
                u0Var.f4337j = -1;
                u0Var.f4338k = -1;
                u0Var.f4340m = null;
                u0Var.f4339l = 0;
                u0Var.n = 0;
                u0Var.f4341o = null;
                u0Var.f4342p = null;
            }
            n0();
        }
    }

    public final void d1(int i5, j0 j0Var) {
        int iL;
        int iL2;
        int i6;
        B b5 = this.f4161v;
        boolean z4 = false;
        b5.f3993b = 0;
        b5.f3994c = i5;
        G g = this.f4182e;
        if (!(g != null && g.f4025e) || (i6 = j0Var.f4263a) == -1) {
            iL = 0;
            iL2 = 0;
        } else {
            if (this.f4163x == (i6 < i5)) {
                iL = this.f4157r.l();
                iL2 = 0;
            } else {
                iL2 = this.f4157r.l();
                iL = 0;
            }
        }
        RecyclerView recyclerView = this.f4179b;
        if (recyclerView == null || !recyclerView.f4114j) {
            b5.g = this.f4157r.f() + iL;
            b5.f3997f = -iL2;
        } else {
            b5.f3997f = this.f4157r.k() - iL2;
            b5.g = this.f4157r.g() + iL;
        }
        b5.h = false;
        b5.f3992a = true;
        if (this.f4157r.i() == 0 && this.f4157r.f() == 0) {
            z4 = true;
        }
        b5.f3998i = z4;
    }

    @Override // androidx.recyclerview.widget.X
    public final boolean e() {
        return this.f4159t == 1;
    }

    @Override // androidx.recyclerview.widget.X
    public final Parcelable e0() {
        int iH;
        int iK;
        int[] iArr;
        u0 u0Var = this.f4150F;
        if (u0Var != null) {
            u0 u0Var2 = new u0();
            u0Var2.f4339l = u0Var.f4339l;
            u0Var2.f4337j = u0Var.f4337j;
            u0Var2.f4338k = u0Var.f4338k;
            u0Var2.f4340m = u0Var.f4340m;
            u0Var2.n = u0Var.n;
            u0Var2.f4341o = u0Var.f4341o;
            u0Var2.f4343q = u0Var.f4343q;
            u0Var2.f4344r = u0Var.f4344r;
            u0Var2.f4345s = u0Var.f4345s;
            u0Var2.f4342p = u0Var.f4342p;
            return u0Var2;
        }
        u0 u0Var3 = new u0();
        u0Var3.f4343q = this.f4162w;
        u0Var3.f4344r = this.f4148D;
        u0Var3.f4345s = this.f4149E;
        L0.s sVar = this.f4146B;
        if (sVar == null || (iArr = (int[]) sVar.f1596d) == null) {
            u0Var3.n = 0;
        } else {
            u0Var3.f4341o = iArr;
            u0Var3.n = iArr.length;
            u0Var3.f4342p = (List) sVar.f1597e;
        }
        if (v() > 0) {
            u0Var3.f4337j = this.f4148D ? N0() : M0();
            View viewI0 = this.f4163x ? I0(true) : J0(true);
            u0Var3.f4338k = viewI0 != null ? X.F(viewI0) : -1;
            int i5 = this.f4155p;
            u0Var3.f4339l = i5;
            u0Var3.f4340m = new int[i5];
            for (int i6 = 0; i6 < this.f4155p; i6++) {
                if (this.f4148D) {
                    iH = this.f4156q[i6].f(Integer.MIN_VALUE);
                    if (iH != Integer.MIN_VALUE) {
                        iK = this.f4157r.g();
                        iH -= iK;
                    }
                } else {
                    iH = this.f4156q[i6].h(Integer.MIN_VALUE);
                    if (iH != Integer.MIN_VALUE) {
                        iK = this.f4157r.k();
                        iH -= iK;
                    }
                }
                u0Var3.f4340m[i6] = iH;
            }
        } else {
            u0Var3.f4337j = -1;
            u0Var3.f4338k = -1;
            u0Var3.f4339l = 0;
        }
        return u0Var3;
    }

    public final void e1(v0 v0Var, int i5, int i6) {
        int i7 = v0Var.f4352d;
        int i8 = v0Var.f4353e;
        if (i5 != -1) {
            int i9 = v0Var.f4351c;
            if (i9 == Integer.MIN_VALUE) {
                v0Var.a();
                i9 = v0Var.f4351c;
            }
            if (i9 - i7 >= i6) {
                this.f4164y.set(i8, false);
                return;
            }
            return;
        }
        int i10 = v0Var.f4350b;
        if (i10 == Integer.MIN_VALUE) {
            View view = (View) v0Var.f4349a.get(0);
            s0 s0Var = (s0) view.getLayoutParams();
            v0Var.f4350b = v0Var.f4354f.f4157r.e(view);
            s0Var.getClass();
            i10 = v0Var.f4350b;
        }
        if (i10 + i7 <= i6) {
            this.f4164y.set(i8, false);
        }
    }

    @Override // androidx.recyclerview.widget.X
    public final boolean f(Y y4) {
        return y4 instanceof s0;
    }

    @Override // androidx.recyclerview.widget.X
    public final void f0(int i5) {
        if (i5 == 0) {
            D0();
        }
    }

    @Override // androidx.recyclerview.widget.X
    public final void h(int i5, int i6, j0 j0Var, Q1.b bVar) {
        B b5;
        int iF;
        int iH;
        if (this.f4159t != 0) {
            i5 = i6;
        }
        if (v() == 0 || i5 == 0) {
            return;
        }
        W0(i5, j0Var);
        int[] iArr = this.f4153J;
        if (iArr == null || iArr.length < this.f4155p) {
            this.f4153J = new int[this.f4155p];
        }
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = this.f4155p;
            b5 = this.f4161v;
            if (i7 >= i9) {
                break;
            }
            if (b5.f3995d == -1) {
                iF = b5.f3997f;
                iH = this.f4156q[i7].h(iF);
            } else {
                iF = this.f4156q[i7].f(b5.g);
                iH = b5.g;
            }
            int i10 = iF - iH;
            if (i10 >= 0) {
                this.f4153J[i8] = i10;
                i8++;
            }
            i7++;
        }
        Arrays.sort(this.f4153J, 0, i8);
        for (int i11 = 0; i11 < i8; i11++) {
            int i12 = b5.f3994c;
            if (i12 < 0 || i12 >= j0Var.b()) {
                return;
            }
            bVar.a(b5.f3994c, this.f4153J[i11]);
            b5.f3994c += b5.f3995d;
        }
    }

    @Override // androidx.recyclerview.widget.X
    public final int j(j0 j0Var) {
        return E0(j0Var);
    }

    @Override // androidx.recyclerview.widget.X
    public final int k(j0 j0Var) {
        return F0(j0Var);
    }

    @Override // androidx.recyclerview.widget.X
    public final int l(j0 j0Var) {
        return G0(j0Var);
    }

    @Override // androidx.recyclerview.widget.X
    public final int m(j0 j0Var) {
        return E0(j0Var);
    }

    @Override // androidx.recyclerview.widget.X
    public final int n(j0 j0Var) {
        return F0(j0Var);
    }

    @Override // androidx.recyclerview.widget.X
    public final int o(j0 j0Var) {
        return G0(j0Var);
    }

    @Override // androidx.recyclerview.widget.X
    public final int o0(int i5, d0 d0Var, j0 j0Var) {
        return b1(i5, d0Var, j0Var);
    }

    @Override // androidx.recyclerview.widget.X
    public final void p0(int i5) {
        u0 u0Var = this.f4150F;
        if (u0Var != null && u0Var.f4337j != i5) {
            u0Var.f4340m = null;
            u0Var.f4339l = 0;
            u0Var.f4337j = -1;
            u0Var.f4338k = -1;
        }
        this.f4165z = i5;
        this.f4145A = Integer.MIN_VALUE;
        n0();
    }

    @Override // androidx.recyclerview.widget.X
    public final int q0(int i5, d0 d0Var, j0 j0Var) {
        return b1(i5, d0Var, j0Var);
    }

    @Override // androidx.recyclerview.widget.X
    public final Y r() {
        return this.f4159t == 0 ? new s0(-2, -1) : new s0(-1, -2);
    }

    @Override // androidx.recyclerview.widget.X
    public final Y s(Context context, AttributeSet attributeSet) {
        return new s0(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.X
    public final Y t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new s0((ViewGroup.MarginLayoutParams) layoutParams) : new s0(layoutParams);
    }

    @Override // androidx.recyclerview.widget.X
    public final void t0(Rect rect, int i5, int i6) {
        int iG;
        int iG2;
        int i7 = this.f4155p;
        int iD = D() + C();
        int iB = B() + E();
        if (this.f4159t == 1) {
            int iHeight = rect.height() + iB;
            RecyclerView recyclerView = this.f4179b;
            WeakHashMap weakHashMap = O.Y.f1904a;
            iG2 = X.g(i6, iHeight, O.G.d(recyclerView));
            iG = X.g(i5, (this.f4160u * i7) + iD, O.G.e(this.f4179b));
        } else {
            int iWidth = rect.width() + iD;
            RecyclerView recyclerView2 = this.f4179b;
            WeakHashMap weakHashMap2 = O.Y.f1904a;
            iG = X.g(i5, iWidth, O.G.e(recyclerView2));
            iG2 = X.g(i6, (this.f4160u * i7) + iB, O.G.d(this.f4179b));
        }
        this.f4179b.setMeasuredDimension(iG, iG2);
    }

    @Override // androidx.recyclerview.widget.X
    public final void z0(int i5, RecyclerView recyclerView) {
        G g = new G(recyclerView.getContext());
        g.f4021a = i5;
        A0(g);
    }
}
