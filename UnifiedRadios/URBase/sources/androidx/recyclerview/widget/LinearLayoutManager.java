package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public class LinearLayoutManager extends X implements i0 {

    /* renamed from: A, reason: collision with root package name */
    public final C f4049A;

    /* renamed from: B, reason: collision with root package name */
    public final D f4050B;

    /* renamed from: C, reason: collision with root package name */
    public final int f4051C;

    /* renamed from: D, reason: collision with root package name */
    public final int[] f4052D;

    /* renamed from: p, reason: collision with root package name */
    public int f4053p;

    /* renamed from: q, reason: collision with root package name */
    public E f4054q;

    /* renamed from: r, reason: collision with root package name */
    public androidx.emoji2.text.f f4055r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4056s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4057t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4058u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f4059v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f4060w;

    /* renamed from: x, reason: collision with root package name */
    public int f4061x;

    /* renamed from: y, reason: collision with root package name */
    public int f4062y;

    /* renamed from: z, reason: collision with root package name */
    public F f4063z;

    public LinearLayoutManager(int i5) {
        this.f4053p = 1;
        this.f4057t = false;
        this.f4058u = false;
        this.f4059v = false;
        this.f4060w = true;
        this.f4061x = -1;
        this.f4062y = Integer.MIN_VALUE;
        this.f4063z = null;
        this.f4049A = new C();
        this.f4050B = new D();
        this.f4051C = 2;
        this.f4052D = new int[2];
        c1(i5);
        c(null);
        if (this.f4057t) {
            this.f4057t = false;
            n0();
        }
    }

    @Override // androidx.recyclerview.widget.X
    public boolean B0() {
        return this.f4063z == null && this.f4056s == this.f4059v;
    }

    public void C0(j0 j0Var, int[] iArr) {
        int i5;
        int iL = j0Var.f4263a != -1 ? this.f4055r.l() : 0;
        if (this.f4054q.f4013f == -1) {
            i5 = 0;
        } else {
            i5 = iL;
            iL = 0;
        }
        iArr[0] = iL;
        iArr[1] = i5;
    }

    public void D0(j0 j0Var, E e5, Q1.b bVar) {
        int i5 = e5.f4011d;
        if (i5 < 0 || i5 >= j0Var.b()) {
            return;
        }
        bVar.a(i5, Math.max(0, e5.g));
    }

    public final int E0(j0 j0Var) {
        if (v() == 0) {
            return 0;
        }
        I0();
        androidx.emoji2.text.f fVar = this.f4055r;
        boolean z4 = !this.f4060w;
        return AbstractC0271s.a(j0Var, fVar, L0(z4), K0(z4), this, this.f4060w);
    }

    public final int F0(j0 j0Var) {
        if (v() == 0) {
            return 0;
        }
        I0();
        androidx.emoji2.text.f fVar = this.f4055r;
        boolean z4 = !this.f4060w;
        return AbstractC0271s.b(j0Var, fVar, L0(z4), K0(z4), this, this.f4060w, this.f4058u);
    }

    public final int G0(j0 j0Var) {
        if (v() == 0) {
            return 0;
        }
        I0();
        androidx.emoji2.text.f fVar = this.f4055r;
        boolean z4 = !this.f4060w;
        return AbstractC0271s.c(j0Var, fVar, L0(z4), K0(z4), this, this.f4060w);
    }

    public final int H0(int i5) {
        return i5 != 1 ? i5 != 2 ? i5 != 17 ? i5 != 33 ? i5 != 66 ? (i5 == 130 && this.f4053p == 1) ? 1 : Integer.MIN_VALUE : this.f4053p == 0 ? 1 : Integer.MIN_VALUE : this.f4053p == 1 ? -1 : Integer.MIN_VALUE : this.f4053p == 0 ? -1 : Integer.MIN_VALUE : (this.f4053p != 1 && V0()) ? -1 : 1 : (this.f4053p != 1 && V0()) ? 1 : -1;
    }

    public final void I0() {
        if (this.f4054q == null) {
            E e5 = new E();
            e5.f4008a = true;
            e5.h = 0;
            e5.f4014i = 0;
            e5.f4016k = null;
            this.f4054q = e5;
        }
    }

    @Override // androidx.recyclerview.widget.X
    public final boolean J() {
        return true;
    }

    public final int J0(d0 d0Var, E e5, j0 j0Var, boolean z4) {
        int i5;
        int i6 = e5.f4010c;
        int i7 = e5.g;
        if (i7 != Integer.MIN_VALUE) {
            if (i6 < 0) {
                e5.g = i7 + i6;
            }
            Y0(d0Var, e5);
        }
        int i8 = e5.f4010c + e5.h;
        while (true) {
            if ((!e5.f4017l && i8 <= 0) || (i5 = e5.f4011d) < 0 || i5 >= j0Var.b()) {
                break;
            }
            D d5 = this.f4050B;
            d5.f4004a = 0;
            d5.f4005b = false;
            d5.f4006c = false;
            d5.f4007d = false;
            W0(d0Var, j0Var, e5, d5);
            if (!d5.f4005b) {
                int i9 = e5.f4009b;
                int i10 = d5.f4004a;
                e5.f4009b = (e5.f4013f * i10) + i9;
                if (!d5.f4006c || e5.f4016k != null || !j0Var.g) {
                    e5.f4010c -= i10;
                    i8 -= i10;
                }
                int i11 = e5.g;
                if (i11 != Integer.MIN_VALUE) {
                    int i12 = i11 + i10;
                    e5.g = i12;
                    int i13 = e5.f4010c;
                    if (i13 < 0) {
                        e5.g = i12 + i13;
                    }
                    Y0(d0Var, e5);
                }
                if (z4 && d5.f4007d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i6 - e5.f4010c;
    }

    public final View K0(boolean z4) {
        return this.f4058u ? P0(0, v(), z4) : P0(v() - 1, -1, z4);
    }

    public final View L0(boolean z4) {
        return this.f4058u ? P0(v() - 1, -1, z4) : P0(0, v(), z4);
    }

    public final int M0() {
        View viewP0 = P0(0, v(), false);
        if (viewP0 == null) {
            return -1;
        }
        return X.F(viewP0);
    }

    public final int N0() {
        View viewP0 = P0(v() - 1, -1, false);
        if (viewP0 == null) {
            return -1;
        }
        return X.F(viewP0);
    }

    public final View O0(int i5, int i6) {
        int i7;
        int i8;
        I0();
        if (i6 <= i5 && i6 >= i5) {
            return u(i5);
        }
        if (this.f4055r.e(u(i5)) < this.f4055r.k()) {
            i7 = 16644;
            i8 = 16388;
        } else {
            i7 = 4161;
            i8 = 4097;
        }
        return this.f4053p == 0 ? this.f4180c.d(i5, i6, i7, i8) : this.f4181d.d(i5, i6, i7, i8);
    }

    public final View P0(int i5, int i6, boolean z4) {
        I0();
        int i7 = z4 ? 24579 : 320;
        return this.f4053p == 0 ? this.f4180c.d(i5, i6, i7, 320) : this.f4181d.d(i5, i6, i7, 320);
    }

    @Override // androidx.recyclerview.widget.X
    public final void Q(RecyclerView recyclerView) {
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View Q0(androidx.recyclerview.widget.d0 r17, androidx.recyclerview.widget.j0 r18, boolean r19, boolean r20) {
        /*
            r16 = this;
            r0 = r16
            r16.I0()
            int r1 = r16.v()
            r2 = 0
            r3 = 1
            if (r20 == 0) goto L15
            int r1 = r16.v()
            int r1 = r1 - r3
            r4 = -1
            r5 = r4
            goto L18
        L15:
            r4 = r1
            r1 = r2
            r5 = r3
        L18:
            int r6 = r18.b()
            androidx.emoji2.text.f r7 = r0.f4055r
            int r7 = r7.k()
            androidx.emoji2.text.f r8 = r0.f4055r
            int r8 = r8.g()
            r9 = 0
            r10 = r9
            r11 = r10
        L2b:
            if (r1 == r4) goto L7c
            android.view.View r12 = r0.u(r1)
            int r13 = androidx.recyclerview.widget.X.F(r12)
            androidx.emoji2.text.f r14 = r0.f4055r
            int r14 = r14.e(r12)
            androidx.emoji2.text.f r15 = r0.f4055r
            int r15 = r15.b(r12)
            if (r13 < 0) goto L7a
            if (r13 >= r6) goto L7a
            android.view.ViewGroup$LayoutParams r13 = r12.getLayoutParams()
            androidx.recyclerview.widget.Y r13 = (androidx.recyclerview.widget.Y) r13
            androidx.recyclerview.widget.n0 r13 = r13.f4190a
            boolean r13 = r13.isRemoved()
            if (r13 == 0) goto L57
            if (r11 != 0) goto L7a
            r11 = r12
            goto L7a
        L57:
            if (r15 > r7) goto L5d
            if (r14 >= r7) goto L5d
            r13 = r3
            goto L5e
        L5d:
            r13 = r2
        L5e:
            if (r14 < r8) goto L64
            if (r15 <= r8) goto L64
            r14 = r3
            goto L65
        L64:
            r14 = r2
        L65:
            if (r13 != 0) goto L6b
            if (r14 == 0) goto L6a
            goto L6b
        L6a:
            return r12
        L6b:
            if (r19 == 0) goto L73
            if (r14 == 0) goto L70
            goto L75
        L70:
            if (r9 != 0) goto L7a
            goto L79
        L73:
            if (r13 == 0) goto L77
        L75:
            r10 = r12
            goto L7a
        L77:
            if (r9 != 0) goto L7a
        L79:
            r9 = r12
        L7a:
            int r1 = r1 + r5
            goto L2b
        L7c:
            if (r9 == 0) goto L7f
            goto L84
        L7f:
            if (r10 == 0) goto L83
            r9 = r10
            goto L84
        L83:
            r9 = r11
        L84:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.Q0(androidx.recyclerview.widget.d0, androidx.recyclerview.widget.j0, boolean, boolean):android.view.View");
    }

    @Override // androidx.recyclerview.widget.X
    public View R(View view, int i5, d0 d0Var, j0 j0Var) {
        int iH0;
        a1();
        if (v() == 0 || (iH0 = H0(i5)) == Integer.MIN_VALUE) {
            return null;
        }
        I0();
        e1(iH0, (int) (this.f4055r.l() * 0.33333334f), false, j0Var);
        E e5 = this.f4054q;
        e5.g = Integer.MIN_VALUE;
        e5.f4008a = false;
        J0(d0Var, e5, j0Var, true);
        View viewO0 = iH0 == -1 ? this.f4058u ? O0(v() - 1, -1) : O0(0, v()) : this.f4058u ? O0(0, v()) : O0(v() - 1, -1);
        View viewU0 = iH0 == -1 ? U0() : T0();
        if (!viewU0.hasFocusable()) {
            return viewO0;
        }
        if (viewO0 == null) {
            return null;
        }
        return viewU0;
    }

    public final int R0(int i5, d0 d0Var, j0 j0Var, boolean z4) {
        int iG;
        int iG2 = this.f4055r.g() - i5;
        if (iG2 <= 0) {
            return 0;
        }
        int i6 = -b1(-iG2, d0Var, j0Var);
        int i7 = i5 + i6;
        if (!z4 || (iG = this.f4055r.g() - i7) <= 0) {
            return i6;
        }
        this.f4055r.p(iG);
        return iG + i6;
    }

    @Override // androidx.recyclerview.widget.X
    public final void S(AccessibilityEvent accessibilityEvent) {
        super.S(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(M0());
            accessibilityEvent.setToIndex(N0());
        }
    }

    public final int S0(int i5, d0 d0Var, j0 j0Var, boolean z4) {
        int iK;
        int iK2 = i5 - this.f4055r.k();
        if (iK2 <= 0) {
            return 0;
        }
        int i6 = -b1(iK2, d0Var, j0Var);
        int i7 = i5 + i6;
        if (!z4 || (iK = i7 - this.f4055r.k()) <= 0) {
            return i6;
        }
        this.f4055r.p(-iK);
        return i6 - iK;
    }

    public final View T0() {
        return u(this.f4058u ? 0 : v() - 1);
    }

    public final View U0() {
        return u(this.f4058u ? v() - 1 : 0);
    }

    public final boolean V0() {
        return A() == 1;
    }

    public void W0(d0 d0Var, j0 j0Var, E e5, D d5) {
        int iC;
        int i5;
        int i6;
        int iD;
        View viewB = e5.b(d0Var);
        if (viewB == null) {
            d5.f4005b = true;
            return;
        }
        Y y4 = (Y) viewB.getLayoutParams();
        if (e5.f4016k == null) {
            if (this.f4058u == (e5.f4013f == -1)) {
                b(viewB, -1, false);
            } else {
                b(viewB, 0, false);
            }
        } else {
            if (this.f4058u == (e5.f4013f == -1)) {
                b(viewB, -1, true);
            } else {
                b(viewB, 0, true);
            }
        }
        Y y5 = (Y) viewB.getLayoutParams();
        Rect rectN = this.f4179b.N(viewB);
        int i7 = rectN.left + rectN.right;
        int i8 = rectN.top + rectN.bottom;
        int iW = X.w(this.n, this.f4187l, D() + C() + ((ViewGroup.MarginLayoutParams) y5).leftMargin + ((ViewGroup.MarginLayoutParams) y5).rightMargin + i7, ((ViewGroup.MarginLayoutParams) y5).width, d());
        int iW2 = X.w(this.f4189o, this.f4188m, B() + E() + ((ViewGroup.MarginLayoutParams) y5).topMargin + ((ViewGroup.MarginLayoutParams) y5).bottomMargin + i8, ((ViewGroup.MarginLayoutParams) y5).height, e());
        if (w0(viewB, iW, iW2, y5)) {
            viewB.measure(iW, iW2);
        }
        d5.f4004a = this.f4055r.c(viewB);
        if (this.f4053p == 1) {
            if (V0()) {
                iD = this.n - D();
                iC = iD - this.f4055r.d(viewB);
            } else {
                iC = C();
                iD = this.f4055r.d(viewB) + iC;
            }
            if (e5.f4013f == -1) {
                i5 = e5.f4009b;
                i6 = i5 - d5.f4004a;
            } else {
                i6 = e5.f4009b;
                i5 = d5.f4004a + i6;
            }
        } else {
            int iE = E();
            int iD2 = this.f4055r.d(viewB) + iE;
            if (e5.f4013f == -1) {
                int i9 = e5.f4009b;
                int i10 = i9 - d5.f4004a;
                iD = i9;
                i5 = iD2;
                iC = i10;
                i6 = iE;
            } else {
                int i11 = e5.f4009b;
                int i12 = d5.f4004a + i11;
                iC = i11;
                i5 = iD2;
                i6 = iE;
                iD = i12;
            }
        }
        X.L(viewB, iC, i6, iD, i5);
        if (y4.f4190a.isRemoved() || y4.f4190a.isUpdated()) {
            d5.f4006c = true;
        }
        d5.f4007d = viewB.hasFocusable();
    }

    public void X0(d0 d0Var, j0 j0Var, C c2, int i5) {
    }

    public final void Y0(d0 d0Var, E e5) {
        if (!e5.f4008a || e5.f4017l) {
            return;
        }
        int i5 = e5.g;
        int i6 = e5.f4014i;
        if (e5.f4013f == -1) {
            int iV = v();
            if (i5 < 0) {
                return;
            }
            int iF = (this.f4055r.f() - i5) + i6;
            if (this.f4058u) {
                for (int i7 = 0; i7 < iV; i7++) {
                    View viewU = u(i7);
                    if (this.f4055r.e(viewU) < iF || this.f4055r.o(viewU) < iF) {
                        Z0(d0Var, 0, i7);
                        return;
                    }
                }
                return;
            }
            int i8 = iV - 1;
            for (int i9 = i8; i9 >= 0; i9--) {
                View viewU2 = u(i9);
                if (this.f4055r.e(viewU2) < iF || this.f4055r.o(viewU2) < iF) {
                    Z0(d0Var, i8, i9);
                    return;
                }
            }
            return;
        }
        if (i5 < 0) {
            return;
        }
        int i10 = i5 - i6;
        int iV2 = v();
        if (!this.f4058u) {
            for (int i11 = 0; i11 < iV2; i11++) {
                View viewU3 = u(i11);
                if (this.f4055r.b(viewU3) > i10 || this.f4055r.n(viewU3) > i10) {
                    Z0(d0Var, 0, i11);
                    return;
                }
            }
            return;
        }
        int i12 = iV2 - 1;
        for (int i13 = i12; i13 >= 0; i13--) {
            View viewU4 = u(i13);
            if (this.f4055r.b(viewU4) > i10 || this.f4055r.n(viewU4) > i10) {
                Z0(d0Var, i12, i13);
                return;
            }
        }
    }

    public final void Z0(d0 d0Var, int i5, int i6) {
        if (i5 == i6) {
            return;
        }
        if (i6 <= i5) {
            while (i5 > i6) {
                View viewU = u(i5);
                l0(i5);
                d0Var.h(viewU);
                i5--;
            }
            return;
        }
        for (int i7 = i6 - 1; i7 >= i5; i7--) {
            View viewU2 = u(i7);
            l0(i7);
            d0Var.h(viewU2);
        }
    }

    @Override // androidx.recyclerview.widget.i0
    public final PointF a(int i5) {
        if (v() == 0) {
            return null;
        }
        int i6 = (i5 < X.F(u(0))) != this.f4058u ? -1 : 1;
        return this.f4053p == 0 ? new PointF(i6, BitmapDescriptorFactory.HUE_RED) : new PointF(BitmapDescriptorFactory.HUE_RED, i6);
    }

    public final void a1() {
        if (this.f4053p == 1 || !V0()) {
            this.f4058u = this.f4057t;
        } else {
            this.f4058u = !this.f4057t;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0188  */
    @Override // androidx.recyclerview.widget.X
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b0(androidx.recyclerview.widget.d0 r18, androidx.recyclerview.widget.j0 r19) {
        /*
            Method dump skipped, instructions count: 1072
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.b0(androidx.recyclerview.widget.d0, androidx.recyclerview.widget.j0):void");
    }

    public final int b1(int i5, d0 d0Var, j0 j0Var) {
        if (v() == 0 || i5 == 0) {
            return 0;
        }
        I0();
        this.f4054q.f4008a = true;
        int i6 = i5 > 0 ? 1 : -1;
        int iAbs = Math.abs(i5);
        e1(i6, iAbs, true, j0Var);
        E e5 = this.f4054q;
        int iJ0 = J0(d0Var, e5, j0Var, false) + e5.g;
        if (iJ0 < 0) {
            return 0;
        }
        if (iAbs > iJ0) {
            i5 = i6 * iJ0;
        }
        this.f4055r.p(-i5);
        this.f4054q.f4015j = i5;
        return i5;
    }

    @Override // androidx.recyclerview.widget.X
    public final void c(String str) {
        if (this.f4063z == null) {
            super.c(str);
        }
    }

    @Override // androidx.recyclerview.widget.X
    public void c0(j0 j0Var) {
        this.f4063z = null;
        this.f4061x = -1;
        this.f4062y = Integer.MIN_VALUE;
        this.f4049A.d();
    }

    public final void c1(int i5) {
        if (i5 != 0 && i5 != 1) {
            throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.a(i5, "invalid orientation:"));
        }
        c(null);
        if (i5 != this.f4053p || this.f4055r == null) {
            androidx.emoji2.text.f fVarA = androidx.emoji2.text.f.a(this, i5);
            this.f4055r = fVarA;
            this.f4049A.f3999a = fVarA;
            this.f4053p = i5;
            n0();
        }
    }

    @Override // androidx.recyclerview.widget.X
    public final boolean d() {
        return this.f4053p == 0;
    }

    @Override // androidx.recyclerview.widget.X
    public final void d0(Parcelable parcelable) {
        if (parcelable instanceof F) {
            F f5 = (F) parcelable;
            this.f4063z = f5;
            if (this.f4061x != -1) {
                f5.f4018j = -1;
            }
            n0();
        }
    }

    public void d1(boolean z4) {
        c(null);
        if (this.f4059v == z4) {
            return;
        }
        this.f4059v = z4;
        n0();
    }

    @Override // androidx.recyclerview.widget.X
    public final boolean e() {
        return this.f4053p == 1;
    }

    @Override // androidx.recyclerview.widget.X
    public final Parcelable e0() {
        F f5 = this.f4063z;
        if (f5 != null) {
            F f6 = new F();
            f6.f4018j = f5.f4018j;
            f6.f4019k = f5.f4019k;
            f6.f4020l = f5.f4020l;
            return f6;
        }
        F f7 = new F();
        if (v() > 0) {
            I0();
            boolean z4 = this.f4056s ^ this.f4058u;
            f7.f4020l = z4;
            if (z4) {
                View viewT0 = T0();
                f7.f4019k = this.f4055r.g() - this.f4055r.b(viewT0);
                f7.f4018j = X.F(viewT0);
            } else {
                View viewU0 = U0();
                f7.f4018j = X.F(viewU0);
                f7.f4019k = this.f4055r.e(viewU0) - this.f4055r.k();
            }
        } else {
            f7.f4018j = -1;
        }
        return f7;
    }

    public final void e1(int i5, int i6, boolean z4, j0 j0Var) {
        int iK;
        this.f4054q.f4017l = this.f4055r.i() == 0 && this.f4055r.f() == 0;
        this.f4054q.f4013f = i5;
        int[] iArr = this.f4052D;
        iArr[0] = 0;
        iArr[1] = 0;
        C0(j0Var, iArr);
        int iMax = Math.max(0, iArr[0]);
        int iMax2 = Math.max(0, iArr[1]);
        boolean z5 = i5 == 1;
        E e5 = this.f4054q;
        int i7 = z5 ? iMax2 : iMax;
        e5.h = i7;
        if (!z5) {
            iMax = iMax2;
        }
        e5.f4014i = iMax;
        if (z5) {
            e5.h = this.f4055r.h() + i7;
            View viewT0 = T0();
            E e6 = this.f4054q;
            e6.f4012e = this.f4058u ? -1 : 1;
            int iF = X.F(viewT0);
            E e7 = this.f4054q;
            e6.f4011d = iF + e7.f4012e;
            e7.f4009b = this.f4055r.b(viewT0);
            iK = this.f4055r.b(viewT0) - this.f4055r.g();
        } else {
            View viewU0 = U0();
            E e8 = this.f4054q;
            e8.h = this.f4055r.k() + e8.h;
            E e9 = this.f4054q;
            e9.f4012e = this.f4058u ? 1 : -1;
            int iF2 = X.F(viewU0);
            E e10 = this.f4054q;
            e9.f4011d = iF2 + e10.f4012e;
            e10.f4009b = this.f4055r.e(viewU0);
            iK = (-this.f4055r.e(viewU0)) + this.f4055r.k();
        }
        E e11 = this.f4054q;
        e11.f4010c = i6;
        if (z4) {
            e11.f4010c = i6 - iK;
        }
        e11.g = iK;
    }

    public final void f1(int i5, int i6) {
        this.f4054q.f4010c = this.f4055r.g() - i6;
        E e5 = this.f4054q;
        e5.f4012e = this.f4058u ? -1 : 1;
        e5.f4011d = i5;
        e5.f4013f = 1;
        e5.f4009b = i6;
        e5.g = Integer.MIN_VALUE;
    }

    public final void g1(int i5, int i6) {
        this.f4054q.f4010c = i6 - this.f4055r.k();
        E e5 = this.f4054q;
        e5.f4011d = i5;
        e5.f4012e = this.f4058u ? 1 : -1;
        e5.f4013f = -1;
        e5.f4009b = i6;
        e5.g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.X
    public final void h(int i5, int i6, j0 j0Var, Q1.b bVar) {
        if (this.f4053p != 0) {
            i5 = i6;
        }
        if (v() == 0 || i5 == 0) {
            return;
        }
        I0();
        e1(i5 > 0 ? 1 : -1, Math.abs(i5), true, j0Var);
        D0(j0Var, this.f4054q, bVar);
    }

    @Override // androidx.recyclerview.widget.X
    public final void i(int i5, Q1.b bVar) {
        boolean z4;
        int i6;
        F f5 = this.f4063z;
        if (f5 == null || (i6 = f5.f4018j) < 0) {
            a1();
            z4 = this.f4058u;
            i6 = this.f4061x;
            if (i6 == -1) {
                i6 = z4 ? i5 - 1 : 0;
            }
        } else {
            z4 = f5.f4020l;
        }
        int i7 = z4 ? -1 : 1;
        for (int i8 = 0; i8 < this.f4051C && i6 >= 0 && i6 < i5; i8++) {
            bVar.a(i6, 0);
            i6 += i7;
        }
    }

    @Override // androidx.recyclerview.widget.X
    public final int j(j0 j0Var) {
        return E0(j0Var);
    }

    @Override // androidx.recyclerview.widget.X
    public int k(j0 j0Var) {
        return F0(j0Var);
    }

    @Override // androidx.recyclerview.widget.X
    public int l(j0 j0Var) {
        return G0(j0Var);
    }

    @Override // androidx.recyclerview.widget.X
    public final int m(j0 j0Var) {
        return E0(j0Var);
    }

    @Override // androidx.recyclerview.widget.X
    public int n(j0 j0Var) {
        return F0(j0Var);
    }

    @Override // androidx.recyclerview.widget.X
    public int o(j0 j0Var) {
        return G0(j0Var);
    }

    @Override // androidx.recyclerview.widget.X
    public int o0(int i5, d0 d0Var, j0 j0Var) {
        if (this.f4053p == 1) {
            return 0;
        }
        return b1(i5, d0Var, j0Var);
    }

    @Override // androidx.recyclerview.widget.X
    public final void p0(int i5) {
        this.f4061x = i5;
        this.f4062y = Integer.MIN_VALUE;
        F f5 = this.f4063z;
        if (f5 != null) {
            f5.f4018j = -1;
        }
        n0();
    }

    @Override // androidx.recyclerview.widget.X
    public final View q(int i5) {
        int iV = v();
        if (iV == 0) {
            return null;
        }
        int iF = i5 - X.F(u(0));
        if (iF >= 0 && iF < iV) {
            View viewU = u(iF);
            if (X.F(viewU) == i5) {
                return viewU;
            }
        }
        return super.q(i5);
    }

    @Override // androidx.recyclerview.widget.X
    public int q0(int i5, d0 d0Var, j0 j0Var) {
        if (this.f4053p == 0) {
            return 0;
        }
        return b1(i5, d0Var, j0Var);
    }

    @Override // androidx.recyclerview.widget.X
    public Y r() {
        return new Y(-2, -2);
    }

    @Override // androidx.recyclerview.widget.X
    public final boolean x0() {
        if (this.f4188m == 1073741824 || this.f4187l == 1073741824) {
            return false;
        }
        int iV = v();
        for (int i5 = 0; i5 < iV; i5++) {
            ViewGroup.LayoutParams layoutParams = u(i5).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.X
    public void z0(int i5, RecyclerView recyclerView) {
        G g = new G(recyclerView.getContext());
        g.f4021a = i5;
        A0(g);
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i5, int i6) {
        this.f4053p = 1;
        this.f4057t = false;
        this.f4058u = false;
        this.f4059v = false;
        this.f4060w = true;
        this.f4061x = -1;
        this.f4062y = Integer.MIN_VALUE;
        this.f4063z = null;
        this.f4049A = new C();
        this.f4050B = new D();
        this.f4051C = 2;
        this.f4052D = new int[2];
        W wG = X.G(context, attributeSet, i5, i6);
        c1(wG.f4174a);
        boolean z4 = wG.f4176c;
        c(null);
        if (z4 != this.f4057t) {
            this.f4057t = z4;
            n0();
        }
        d1(wG.f4177d);
    }
}
