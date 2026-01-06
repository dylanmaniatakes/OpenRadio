package u;

import s.AbstractC0882e;
import s.C0879b;
import s.C0880c;
import s.C0883f;

/* renamed from: u.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0904a extends i {

    /* renamed from: s0, reason: collision with root package name */
    public int f9716s0;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f9717t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f9718u0;
    public boolean v0;

    @Override // u.d
    public final boolean A() {
        return this.v0;
    }

    @Override // u.d
    public final boolean B() {
        return this.v0;
    }

    public final boolean T() {
        int i5;
        int i6;
        int i7;
        boolean z4 = true;
        int i8 = 0;
        while (true) {
            i5 = this.f9877r0;
            if (i8 >= i5) {
                break;
            }
            d dVar = this.f9876q0[i8];
            if ((this.f9717t0 || dVar.c()) && ((((i6 = this.f9716s0) == 0 || i6 == 1) && !dVar.A()) || (((i7 = this.f9716s0) == 2 || i7 == 3) && !dVar.B()))) {
                z4 = false;
            }
            i8++;
        }
        if (!z4 || i5 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z5 = false;
        for (int i9 = 0; i9 < this.f9877r0; i9++) {
            d dVar2 = this.f9876q0[i9];
            if (this.f9717t0 || dVar2.c()) {
                if (!z5) {
                    int i10 = this.f9716s0;
                    if (i10 == 0) {
                        iMax = dVar2.i(2).d();
                    } else if (i10 == 1) {
                        iMax = dVar2.i(4).d();
                    } else if (i10 == 2) {
                        iMax = dVar2.i(3).d();
                    } else if (i10 == 3) {
                        iMax = dVar2.i(5).d();
                    }
                    z5 = true;
                }
                int i11 = this.f9716s0;
                if (i11 == 0) {
                    iMax = Math.min(iMax, dVar2.i(2).d());
                } else if (i11 == 1) {
                    iMax = Math.max(iMax, dVar2.i(4).d());
                } else if (i11 == 2) {
                    iMax = Math.min(iMax, dVar2.i(3).d());
                } else if (i11 == 3) {
                    iMax = Math.max(iMax, dVar2.i(5).d());
                }
            }
        }
        int i12 = iMax + this.f9718u0;
        int i13 = this.f9716s0;
        if (i13 == 0 || i13 == 1) {
            J(i12, i12);
        } else {
            K(i12, i12);
        }
        this.v0 = true;
        return true;
    }

    public final int U() {
        int i5 = this.f9716s0;
        if (i5 == 0 || i5 == 1) {
            return 0;
        }
        return (i5 == 2 || i5 == 3) ? 1 : -1;
    }

    @Override // u.d
    public final void b(C0880c c0880c, boolean z4) {
        boolean z5;
        int i5;
        int i6;
        c[] cVarArr = this.f9755Q;
        c cVar = this.I;
        cVarArr[0] = cVar;
        c cVar2 = this.f9748J;
        int i7 = 2;
        cVarArr[2] = cVar2;
        c cVar3 = this.f9749K;
        cVarArr[1] = cVar3;
        c cVar4 = this.f9750L;
        cVarArr[3] = cVar4;
        for (c cVar5 : cVarArr) {
            cVar5.f9739i = c0880c.k(cVar5);
        }
        int i8 = this.f9716s0;
        if (i8 < 0 || i8 >= 4) {
            return;
        }
        c cVar6 = cVarArr[i8];
        if (!this.v0) {
            T();
        }
        if (this.v0) {
            this.v0 = false;
            int i9 = this.f9716s0;
            if (i9 == 0 || i9 == 1) {
                c0880c.d(cVar.f9739i, this.f9763Y);
                c0880c.d(cVar3.f9739i, this.f9763Y);
                return;
            } else {
                if (i9 == 2 || i9 == 3) {
                    c0880c.d(cVar2.f9739i, this.f9764Z);
                    c0880c.d(cVar4.f9739i, this.f9764Z);
                    return;
                }
                return;
            }
        }
        for (int i10 = 0; i10 < this.f9877r0; i10++) {
            d dVar = this.f9876q0[i10];
            if ((this.f9717t0 || dVar.c()) && ((((i6 = this.f9716s0) == 0 || i6 == 1) && dVar.f9793p0[0] == 3 && dVar.I.f9738f != null && dVar.f9749K.f9738f != null) || ((i6 == 2 || i6 == 3) && dVar.f9793p0[1] == 3 && dVar.f9748J.f9738f != null && dVar.f9750L.f9738f != null))) {
                z5 = true;
                break;
            }
        }
        z5 = false;
        boolean z6 = cVar.g() || cVar3.g();
        boolean z7 = cVar2.g() || cVar4.g();
        int i11 = (z5 || !(((i5 = this.f9716s0) == 0 && z6) || ((i5 == 2 && z7) || ((i5 == 1 && z6) || (i5 == 3 && z7))))) ? 4 : 5;
        int i12 = 0;
        while (i12 < this.f9877r0) {
            d dVar2 = this.f9876q0[i12];
            if (this.f9717t0 || dVar2.c()) {
                C0883f c0883fK = c0880c.k(dVar2.f9755Q[this.f9716s0]);
                int i13 = this.f9716s0;
                c cVar7 = dVar2.f9755Q[i13];
                cVar7.f9739i = c0883fK;
                c cVar8 = cVar7.f9738f;
                int i14 = (cVar8 == null || cVar8.f9736d != this) ? 0 : cVar7.g;
                if (i13 == 0 || i13 == i7) {
                    C0883f c0883f = cVar6.f9739i;
                    int i15 = this.f9718u0 - i14;
                    C0879b c0879bL = c0880c.l();
                    C0883f c0883fM = c0880c.m();
                    c0883fM.f9562m = 0;
                    c0879bL.c(c0883f, c0883fK, c0883fM, i15);
                    c0880c.c(c0879bL);
                } else {
                    C0883f c0883f2 = cVar6.f9739i;
                    int i16 = this.f9718u0 + i14;
                    C0879b c0879bL2 = c0880c.l();
                    C0883f c0883fM2 = c0880c.m();
                    c0883fM2.f9562m = 0;
                    c0879bL2.b(c0883f2, c0883fK, c0883fM2, i16);
                    c0880c.c(c0879bL2);
                }
                c0880c.e(cVar6.f9739i, c0883fK, this.f9718u0 + i14, i11);
            }
            i12++;
            i7 = 2;
        }
        int i17 = this.f9716s0;
        if (i17 == 0) {
            c0880c.e(cVar3.f9739i, cVar.f9739i, 0, 8);
            c0880c.e(cVar.f9739i, this.f9758T.f9749K.f9739i, 0, 4);
            c0880c.e(cVar.f9739i, this.f9758T.I.f9739i, 0, 0);
            return;
        }
        if (i17 == 1) {
            c0880c.e(cVar.f9739i, cVar3.f9739i, 0, 8);
            c0880c.e(cVar.f9739i, this.f9758T.I.f9739i, 0, 4);
            c0880c.e(cVar.f9739i, this.f9758T.f9749K.f9739i, 0, 0);
        } else if (i17 == 2) {
            c0880c.e(cVar4.f9739i, cVar2.f9739i, 0, 8);
            c0880c.e(cVar2.f9739i, this.f9758T.f9750L.f9739i, 0, 4);
            c0880c.e(cVar2.f9739i, this.f9758T.f9748J.f9739i, 0, 0);
        } else if (i17 == 3) {
            c0880c.e(cVar2.f9739i, cVar4.f9739i, 0, 8);
            c0880c.e(cVar2.f9739i, this.f9758T.f9748J.f9739i, 0, 4);
            c0880c.e(cVar2.f9739i, this.f9758T.f9750L.f9739i, 0, 0);
        }
    }

    @Override // u.d
    public final boolean c() {
        return true;
    }

    @Override // u.d
    public final String toString() {
        String strE = com.unified.ur1.SatelliteTracker.h.e(new StringBuilder("[Barrier] "), this.f9778h0, " {");
        for (int i5 = 0; i5 < this.f9877r0; i5++) {
            d dVar = this.f9876q0[i5];
            if (i5 > 0) {
                strE = com.unified.ur1.SatelliteTracker.h.b(strE, ", ");
            }
            StringBuilder sbB = AbstractC0882e.b(strE);
            sbB.append(dVar.f9778h0);
            strE = sbB.toString();
        }
        return com.unified.ur1.SatelliteTracker.h.b(strE, "}");
    }
}
