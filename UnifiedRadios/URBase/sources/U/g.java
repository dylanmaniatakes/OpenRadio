package u;

import java.util.ArrayList;
import s.C0880c;
import v.C0919b;

/* loaded from: classes.dex */
public final class g extends i {

    /* renamed from: A0, reason: collision with root package name */
    public int f9839A0;

    /* renamed from: B0, reason: collision with root package name */
    public C0919b f9840B0;

    /* renamed from: C0, reason: collision with root package name */
    public x.f f9841C0;

    /* renamed from: D0, reason: collision with root package name */
    public int f9842D0;

    /* renamed from: E0, reason: collision with root package name */
    public int f9843E0;

    /* renamed from: F0, reason: collision with root package name */
    public int f9844F0;

    /* renamed from: G0, reason: collision with root package name */
    public int f9845G0;

    /* renamed from: H0, reason: collision with root package name */
    public int f9846H0;

    /* renamed from: I0, reason: collision with root package name */
    public int f9847I0;

    /* renamed from: J0, reason: collision with root package name */
    public float f9848J0;

    /* renamed from: K0, reason: collision with root package name */
    public float f9849K0;

    /* renamed from: L0, reason: collision with root package name */
    public float f9850L0;

    /* renamed from: M0, reason: collision with root package name */
    public float f9851M0;

    /* renamed from: N0, reason: collision with root package name */
    public float f9852N0;
    public float O0;

    /* renamed from: P0, reason: collision with root package name */
    public int f9853P0;

    /* renamed from: Q0, reason: collision with root package name */
    public int f9854Q0;

    /* renamed from: R0, reason: collision with root package name */
    public int f9855R0;

    /* renamed from: S0, reason: collision with root package name */
    public int f9856S0;
    public int T0;

    /* renamed from: U0, reason: collision with root package name */
    public int f9857U0;

    /* renamed from: V0, reason: collision with root package name */
    public int f9858V0;

    /* renamed from: W0, reason: collision with root package name */
    public ArrayList f9859W0;

    /* renamed from: X0, reason: collision with root package name */
    public d[] f9860X0;

    /* renamed from: Y0, reason: collision with root package name */
    public d[] f9861Y0;

    /* renamed from: Z0, reason: collision with root package name */
    public int[] f9862Z0;

    /* renamed from: a1, reason: collision with root package name */
    public d[] f9863a1;

    /* renamed from: b1, reason: collision with root package name */
    public int f9864b1;

    /* renamed from: s0, reason: collision with root package name */
    public int f9865s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f9866t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f9867u0;
    public int v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f9868w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f9869x0;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f9870y0;
    public int z0;

    @Override // u.i
    public final void S() {
        for (int i5 = 0; i5 < this.f9877r0; i5++) {
            d dVar = this.f9876q0[i5];
            if (dVar != null) {
                dVar.f9745F = true;
            }
        }
    }

    public final int T(d dVar, int i5) {
        if (dVar == null) {
            return 0;
        }
        int[] iArr = dVar.f9793p0;
        if (iArr[1] == 3) {
            int i6 = dVar.f9796s;
            if (i6 == 0) {
                return 0;
            }
            if (i6 == 2) {
                int i7 = (int) (dVar.f9803z * i5);
                if (i7 != dVar.k()) {
                    dVar.g = true;
                    W(iArr[0], dVar.q(), 1, i7, dVar);
                }
                return i7;
            }
            if (i6 == 1) {
                return dVar.k();
            }
            if (i6 == 3) {
                return (int) ((dVar.q() * dVar.f9761W) + 0.5f);
            }
        }
        return dVar.k();
    }

    public final int U(d dVar, int i5) {
        if (dVar == null) {
            return 0;
        }
        int[] iArr = dVar.f9793p0;
        if (iArr[0] == 3) {
            int i6 = dVar.f9795r;
            if (i6 == 0) {
                return 0;
            }
            if (i6 == 2) {
                int i7 = (int) (dVar.f9800w * i5);
                if (i7 != dVar.q()) {
                    dVar.g = true;
                    W(1, i7, iArr[1], dVar.k(), dVar);
                }
                return i7;
            }
            if (i6 == 1) {
                return dVar.q();
            }
            if (i6 == 3) {
                return (int) ((dVar.k() * dVar.f9761W) + 0.5f);
            }
        }
        return dVar.q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:282:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x076d  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0773  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0783  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0786  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x07a2  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x07a4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V(int r40, int r41, int r42, int r43) {
        /*
            Method dump skipped, instructions count: 1960
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.g.V(int, int, int, int):void");
    }

    public final void W(int i5, int i6, int i7, int i8, d dVar) {
        x.f fVar;
        d dVar2;
        while (true) {
            fVar = this.f9841C0;
            if (fVar != null || (dVar2 = this.f9758T) == null) {
                break;
            } else {
                this.f9841C0 = ((e) dVar2).f9820u0;
            }
        }
        C0919b c0919b = this.f9840B0;
        c0919b.f9965a = i5;
        c0919b.f9966b = i7;
        c0919b.f9967c = i6;
        c0919b.f9968d = i8;
        fVar.b(dVar, c0919b);
        dVar.O(c0919b.f9969e);
        dVar.L(c0919b.f9970f);
        dVar.f9744E = c0919b.h;
        dVar.I(c0919b.g);
    }

    @Override // u.d
    public final void b(C0880c c0880c, boolean z4) {
        d dVar;
        float f5;
        int i5;
        super.b(c0880c, z4);
        d dVar2 = this.f9758T;
        boolean z5 = dVar2 != null && ((e) dVar2).v0;
        int i6 = this.T0;
        ArrayList arrayList = this.f9859W0;
        if (i6 != 0) {
            if (i6 == 1) {
                int size = arrayList.size();
                int i7 = 0;
                while (i7 < size) {
                    ((f) arrayList.get(i7)).b(i7, z5, i7 == size + (-1));
                    i7++;
                }
            } else if (i6 != 2) {
                if (i6 == 3) {
                    int size2 = arrayList.size();
                    int i8 = 0;
                    while (i8 < size2) {
                        ((f) arrayList.get(i8)).b(i8, z5, i8 == size2 + (-1));
                        i8++;
                    }
                }
            } else if (this.f9862Z0 != null && this.f9861Y0 != null && this.f9860X0 != null) {
                for (int i9 = 0; i9 < this.f9864b1; i9++) {
                    this.f9863a1[i9].D();
                }
                int[] iArr = this.f9862Z0;
                int i10 = iArr[0];
                int i11 = iArr[1];
                float f6 = this.f9848J0;
                d dVar3 = null;
                int i12 = 0;
                while (i12 < i10) {
                    if (z5) {
                        i5 = (i10 - i12) - 1;
                        f5 = 1.0f - this.f9848J0;
                    } else {
                        f5 = f6;
                        i5 = i12;
                    }
                    d dVar4 = this.f9861Y0[i5];
                    if (dVar4 != null && dVar4.f9777g0 != 8) {
                        c cVar = dVar4.I;
                        if (i12 == 0) {
                            dVar4.f(cVar, this.I, this.f9868w0);
                            dVar4.f9780i0 = this.f9842D0;
                            dVar4.f9772d0 = f5;
                        }
                        if (i12 == i10 - 1) {
                            dVar4.f(dVar4.f9749K, this.f9749K, this.f9869x0);
                        }
                        if (i12 > 0 && dVar3 != null) {
                            int i13 = this.f9853P0;
                            c cVar2 = dVar3.f9749K;
                            dVar4.f(cVar, cVar2, i13);
                            dVar3.f(cVar2, cVar, 0);
                        }
                        dVar3 = dVar4;
                    }
                    i12++;
                    f6 = f5;
                }
                for (int i14 = 0; i14 < i11; i14++) {
                    d dVar5 = this.f9860X0[i14];
                    if (dVar5 != null && dVar5.f9777g0 != 8) {
                        c cVar3 = dVar5.f9748J;
                        if (i14 == 0) {
                            dVar5.f(cVar3, this.f9748J, this.f9865s0);
                            dVar5.f9782j0 = this.f9843E0;
                            dVar5.f9774e0 = this.f9849K0;
                        }
                        if (i14 == i11 - 1) {
                            dVar5.f(dVar5.f9750L, this.f9750L, this.f9866t0);
                        }
                        if (i14 > 0 && dVar3 != null) {
                            int i15 = this.f9854Q0;
                            c cVar4 = dVar3.f9750L;
                            dVar5.f(cVar3, cVar4, i15);
                            dVar3.f(cVar4, cVar3, 0);
                        }
                        dVar3 = dVar5;
                    }
                }
                for (int i16 = 0; i16 < i10; i16++) {
                    for (int i17 = 0; i17 < i11; i17++) {
                        int i18 = (i17 * i10) + i16;
                        if (this.f9858V0 == 1) {
                            i18 = (i16 * i11) + i17;
                        }
                        d[] dVarArr = this.f9863a1;
                        if (i18 < dVarArr.length && (dVar = dVarArr[i18]) != null && dVar.f9777g0 != 8) {
                            d dVar6 = this.f9861Y0[i16];
                            d dVar7 = this.f9860X0[i17];
                            if (dVar != dVar6) {
                                dVar.f(dVar.I, dVar6.I, 0);
                                dVar.f(dVar.f9749K, dVar6.f9749K, 0);
                            }
                            if (dVar != dVar7) {
                                dVar.f(dVar.f9748J, dVar7.f9748J, 0);
                                dVar.f(dVar.f9750L, dVar7.f9750L, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            ((f) arrayList.get(0)).b(0, z5, true);
        }
        this.f9870y0 = false;
    }
}
