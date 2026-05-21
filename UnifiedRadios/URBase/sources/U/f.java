package u;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f9824a;

    /* renamed from: d, reason: collision with root package name */
    public c f9827d;

    /* renamed from: e, reason: collision with root package name */
    public c f9828e;

    /* renamed from: f, reason: collision with root package name */
    public c f9829f;
    public c g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f9830i;

    /* renamed from: j, reason: collision with root package name */
    public int f9831j;

    /* renamed from: k, reason: collision with root package name */
    public int f9832k;

    /* renamed from: q, reason: collision with root package name */
    public int f9837q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ g f9838r;

    /* renamed from: b, reason: collision with root package name */
    public d f9825b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f9826c = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f9833l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f9834m = 0;
    public int n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f9835o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f9836p = 0;

    public f(g gVar, int i5, c cVar, c cVar2, c cVar3, c cVar4, int i6) {
        this.f9838r = gVar;
        this.h = 0;
        this.f9830i = 0;
        this.f9831j = 0;
        this.f9832k = 0;
        this.f9837q = 0;
        this.f9824a = i5;
        this.f9827d = cVar;
        this.f9828e = cVar2;
        this.f9829f = cVar3;
        this.g = cVar4;
        this.h = gVar.f9868w0;
        this.f9830i = gVar.f9865s0;
        this.f9831j = gVar.f9869x0;
        this.f9832k = gVar.f9866t0;
        this.f9837q = i6;
    }

    public final void a(d dVar) {
        int i5 = this.f9824a;
        g gVar = this.f9838r;
        if (i5 == 0) {
            int iU = gVar.U(dVar, this.f9837q);
            if (dVar.f9793p0[0] == 3) {
                this.f9836p++;
                iU = 0;
            }
            this.f9833l = iU + (dVar.f9777g0 != 8 ? gVar.f9853P0 : 0) + this.f9833l;
            int iT = gVar.T(dVar, this.f9837q);
            if (this.f9825b == null || this.f9826c < iT) {
                this.f9825b = dVar;
                this.f9826c = iT;
                this.f9834m = iT;
            }
        } else {
            int iU2 = gVar.U(dVar, this.f9837q);
            int iT2 = gVar.T(dVar, this.f9837q);
            if (dVar.f9793p0[1] == 3) {
                this.f9836p++;
                iT2 = 0;
            }
            this.f9834m = iT2 + (dVar.f9777g0 != 8 ? gVar.f9854Q0 : 0) + this.f9834m;
            if (this.f9825b == null || this.f9826c < iU2) {
                this.f9825b = dVar;
                this.f9826c = iU2;
                this.f9833l = iU2;
            }
        }
        this.f9835o++;
    }

    public final void b(int i5, boolean z4, boolean z5) {
        g gVar;
        int i6;
        int i7;
        int i8;
        d dVar;
        int i9;
        char c2;
        int i10;
        float f5;
        float f6;
        int i11;
        float f7;
        int i12;
        int i13 = this.f9835o;
        int i14 = 0;
        while (true) {
            gVar = this.f9838r;
            if (i14 >= i13 || (i12 = this.n + i14) >= gVar.f9864b1) {
                break;
            }
            d dVar2 = gVar.f9863a1[i12];
            if (dVar2 != null) {
                dVar2.D();
            }
            i14++;
        }
        if (i13 == 0 || this.f9825b == null) {
            return;
        }
        boolean z6 = z5 && i5 == 0;
        int i15 = -1;
        int i16 = -1;
        for (int i17 = 0; i17 < i13; i17++) {
            int i18 = this.n + (z4 ? (i13 - 1) - i17 : i17);
            if (i18 >= gVar.f9864b1) {
                break;
            }
            d dVar3 = gVar.f9863a1[i18];
            if (dVar3 != null && dVar3.f9777g0 == 0) {
                if (i15 == -1) {
                    i15 = i17;
                }
                i16 = i17;
            }
        }
        if (this.f9824a != 0) {
            d dVar4 = this.f9825b;
            dVar4.f9780i0 = gVar.f9842D0;
            int i19 = this.h;
            if (i5 > 0) {
                i19 += gVar.f9853P0;
            }
            c cVar = dVar4.I;
            c cVar2 = dVar4.f9749K;
            if (z4) {
                cVar2.a(this.f9829f, i19);
                if (z5) {
                    cVar.a(this.f9827d, this.f9831j);
                }
                if (i5 > 0) {
                    this.f9829f.f9736d.I.a(cVar2, 0);
                }
            } else {
                cVar.a(this.f9827d, i19);
                if (z5) {
                    cVar2.a(this.f9829f, this.f9831j);
                }
                if (i5 > 0) {
                    this.f9827d.f9736d.f9749K.a(cVar, 0);
                }
            }
            d dVar5 = null;
            for (int i20 = 0; i20 < i13; i20++) {
                int i21 = this.n + i20;
                if (i21 >= gVar.f9864b1) {
                    return;
                }
                d dVar6 = gVar.f9863a1[i21];
                if (dVar6 != null) {
                    c cVar3 = dVar6.f9748J;
                    if (i20 == 0) {
                        dVar6.f(cVar3, this.f9828e, this.f9830i);
                        int i22 = gVar.f9843E0;
                        float f8 = gVar.f9849K0;
                        if (this.n == 0) {
                            i8 = gVar.f9845G0;
                            i6 = i22;
                            i7 = -1;
                            if (i8 != -1) {
                                f8 = gVar.f9851M0;
                            }
                            dVar6.f9782j0 = i8;
                            dVar6.f9774e0 = f8;
                        } else {
                            i6 = i22;
                            i7 = -1;
                        }
                        if (!z5 || (i8 = gVar.f9847I0) == i7) {
                            i8 = i6;
                        } else {
                            f8 = gVar.O0;
                        }
                        dVar6.f9782j0 = i8;
                        dVar6.f9774e0 = f8;
                    }
                    if (i20 == i13 - 1) {
                        dVar6.f(dVar6.f9750L, this.g, this.f9832k);
                    }
                    if (dVar5 != null) {
                        int i23 = gVar.f9854Q0;
                        c cVar4 = dVar5.f9750L;
                        cVar3.a(cVar4, i23);
                        if (i20 == i15) {
                            int i24 = this.f9830i;
                            if (cVar3.h()) {
                                cVar3.h = i24;
                            }
                        }
                        cVar4.a(cVar3, 0);
                        if (i20 == i16 + 1) {
                            int i25 = this.f9832k;
                            if (cVar4.h()) {
                                cVar4.h = i25;
                            }
                        }
                    }
                    if (dVar6 != dVar4) {
                        c cVar5 = dVar6.f9749K;
                        c cVar6 = dVar6.I;
                        if (z4) {
                            int i26 = gVar.f9855R0;
                            if (i26 == 0) {
                                cVar5.a(cVar2, 0);
                            } else if (i26 == 1) {
                                cVar6.a(cVar, 0);
                            } else if (i26 == 2) {
                                cVar6.a(cVar, 0);
                                cVar5.a(cVar2, 0);
                            }
                            dVar5 = dVar6;
                        } else {
                            int i27 = gVar.f9855R0;
                            if (i27 == 0) {
                                cVar6.a(cVar, 0);
                            } else if (i27 == 1) {
                                cVar5.a(cVar2, 0);
                            } else if (i27 == 2) {
                                if (z6) {
                                    cVar6.a(this.f9827d, this.h);
                                    cVar5.a(this.f9829f, this.f9831j);
                                } else {
                                    cVar6.a(cVar, 0);
                                    cVar5.a(cVar2, 0);
                                }
                            }
                            dVar5 = dVar6;
                        }
                    } else {
                        dVar5 = dVar6;
                    }
                }
            }
            return;
        }
        d dVar7 = this.f9825b;
        dVar7.f9782j0 = gVar.f9843E0;
        int i28 = this.f9830i;
        if (i5 > 0) {
            i28 += gVar.f9854Q0;
        }
        c cVar7 = this.f9828e;
        c cVar8 = dVar7.f9748J;
        cVar8.a(cVar7, i28);
        c cVar9 = dVar7.f9750L;
        if (z5) {
            cVar9.a(this.g, this.f9832k);
        }
        if (i5 > 0) {
            this.f9828e.f9736d.f9750L.a(cVar8, 0);
        }
        if (gVar.f9856S0 != 3 || dVar7.f9744E) {
            dVar = dVar7;
        } else {
            for (int i29 = 0; i29 < i13; i29++) {
                int i30 = this.n + (z4 ? (i13 - 1) - i29 : i29);
                if (i30 >= gVar.f9864b1) {
                    break;
                }
                dVar = gVar.f9863a1[i30];
                if (dVar.f9744E) {
                    break;
                }
            }
            dVar = dVar7;
        }
        int i31 = 0;
        d dVar8 = null;
        while (i31 < i13) {
            int i32 = z4 ? (i13 - 1) - i31 : i31;
            int i33 = this.n + i32;
            if (i33 >= gVar.f9864b1) {
                return;
            }
            d dVar9 = gVar.f9863a1[i33];
            if (dVar9 == null) {
                i9 = i13;
                c2 = 3;
            } else {
                c cVar10 = dVar9.I;
                if (i31 == 0) {
                    dVar9.f(cVar10, this.f9827d, this.h);
                }
                if (i32 == 0) {
                    int i34 = gVar.f9842D0;
                    if (z4) {
                        i10 = i34;
                        f5 = 1.0f - gVar.f9848J0;
                    } else {
                        i10 = i34;
                        f5 = gVar.f9848J0;
                    }
                    if (this.n == 0) {
                        int i35 = gVar.f9844F0;
                        f6 = f5;
                        if (i35 != -1) {
                            f7 = z4 ? 1.0f - gVar.f9850L0 : gVar.f9850L0;
                            i11 = i35;
                        }
                        dVar9.f9780i0 = i11;
                        dVar9.f9772d0 = f7;
                    } else {
                        f6 = f5;
                    }
                    if (!z5 || (i11 = gVar.f9846H0) == -1) {
                        i11 = i10;
                        f7 = f6;
                    } else {
                        f7 = z4 ? 1.0f - gVar.f9852N0 : gVar.f9852N0;
                    }
                    dVar9.f9780i0 = i11;
                    dVar9.f9772d0 = f7;
                }
                if (i31 == i13 - 1) {
                    i9 = i13;
                    dVar9.f(dVar9.f9749K, this.f9829f, this.f9831j);
                } else {
                    i9 = i13;
                }
                if (dVar8 != null) {
                    int i36 = gVar.f9853P0;
                    c cVar11 = dVar8.f9749K;
                    cVar10.a(cVar11, i36);
                    if (i31 == i15) {
                        int i37 = this.h;
                        if (cVar10.h()) {
                            cVar10.h = i37;
                        }
                    }
                    cVar11.a(cVar10, 0);
                    if (i31 == i16 + 1) {
                        int i38 = this.f9831j;
                        if (cVar11.h()) {
                            cVar11.h = i38;
                        }
                    }
                }
                if (dVar9 != dVar7) {
                    int i39 = gVar.f9856S0;
                    c2 = 3;
                    if (i39 == 3 && dVar.f9744E && dVar9 != dVar && dVar9.f9744E) {
                        dVar9.f9751M.a(dVar.f9751M, 0);
                    } else {
                        c cVar12 = dVar9.f9748J;
                        if (i39 != 0) {
                            c cVar13 = dVar9.f9750L;
                            if (i39 == 1) {
                                cVar13.a(cVar9, 0);
                            } else if (z6) {
                                cVar12.a(this.f9828e, this.f9830i);
                                cVar13.a(this.g, this.f9832k);
                            } else {
                                cVar12.a(cVar8, 0);
                                cVar13.a(cVar9, 0);
                            }
                        } else {
                            cVar12.a(cVar8, 0);
                        }
                    }
                } else {
                    c2 = 3;
                }
                dVar8 = dVar9;
            }
            i31++;
            i13 = i9;
        }
    }

    public final int c() {
        return this.f9824a == 1 ? this.f9834m - this.f9838r.f9854Q0 : this.f9834m;
    }

    public final int d() {
        return this.f9824a == 0 ? this.f9833l - this.f9838r.f9853P0 : this.f9833l;
    }

    public final void e(int i5) {
        g gVar;
        int i6;
        int i7 = this.f9836p;
        if (i7 == 0) {
            return;
        }
        int i8 = this.f9835o;
        int i9 = i5 / i7;
        int i10 = 0;
        while (true) {
            gVar = this.f9838r;
            if (i10 >= i8 || (i6 = this.n + i10) >= gVar.f9864b1) {
                break;
            }
            d dVar = gVar.f9863a1[i6];
            if (this.f9824a == 0) {
                if (dVar != null) {
                    int[] iArr = dVar.f9793p0;
                    if (iArr[0] == 3 && dVar.f9795r == 0) {
                        gVar.W(1, i9, iArr[1], dVar.k(), dVar);
                    }
                }
            } else if (dVar != null) {
                int[] iArr2 = dVar.f9793p0;
                if (iArr2[1] == 3 && dVar.f9796s == 0) {
                    gVar.W(iArr2[0], dVar.q(), 1, i9, dVar);
                }
            }
            i10++;
        }
        this.f9833l = 0;
        this.f9834m = 0;
        this.f9825b = null;
        this.f9826c = 0;
        int i11 = this.f9835o;
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = this.n + i12;
            if (i13 >= gVar.f9864b1) {
                return;
            }
            d dVar2 = gVar.f9863a1[i13];
            if (this.f9824a == 0) {
                int iQ = dVar2.q();
                int i14 = gVar.f9853P0;
                if (dVar2.f9777g0 == 8) {
                    i14 = 0;
                }
                this.f9833l = iQ + i14 + this.f9833l;
                int iT = gVar.T(dVar2, this.f9837q);
                if (this.f9825b == null || this.f9826c < iT) {
                    this.f9825b = dVar2;
                    this.f9826c = iT;
                    this.f9834m = iT;
                }
            } else {
                int iU = gVar.U(dVar2, this.f9837q);
                int iT2 = gVar.T(dVar2, this.f9837q);
                int i15 = gVar.f9854Q0;
                if (dVar2.f9777g0 == 8) {
                    i15 = 0;
                }
                this.f9834m = iT2 + i15 + this.f9834m;
                if (this.f9825b == null || this.f9826c < iU) {
                    this.f9825b = dVar2;
                    this.f9826c = iU;
                    this.f9833l = iU;
                }
            }
        }
    }

    public final void f(int i5, c cVar, c cVar2, c cVar3, c cVar4, int i6, int i7, int i8, int i9, int i10) {
        this.f9824a = i5;
        this.f9827d = cVar;
        this.f9828e = cVar2;
        this.f9829f = cVar3;
        this.g = cVar4;
        this.h = i6;
        this.f9830i = i7;
        this.f9831j = i8;
        this.f9832k = i9;
        this.f9837q = i10;
    }
}
