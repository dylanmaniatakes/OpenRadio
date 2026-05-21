package v;

/* loaded from: classes.dex */
public final class k extends o {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f9993k = new int[2];

    public static void m(int[] iArr, int i5, int i6, int i7, int i8, float f5, int i9) {
        int i10 = i6 - i5;
        int i11 = i8 - i7;
        if (i9 != -1) {
            if (i9 == 0) {
                iArr[0] = (int) ((i11 * f5) + 0.5f);
                iArr[1] = i11;
                return;
            } else {
                if (i9 != 1) {
                    return;
                }
                iArr[0] = i10;
                iArr[1] = (int) ((i10 * f5) + 0.5f);
                return;
            }
        }
        int i12 = (int) ((i11 * f5) + 0.5f);
        int i13 = (int) ((i10 / f5) + 0.5f);
        if (i12 <= i10) {
            iArr[0] = i12;
            iArr[1] = i11;
        } else if (i13 <= i11) {
            iArr[0] = i10;
            iArr[1] = i13;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0267  */
    @Override // v.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(v.d r24) {
        /*
            Method dump skipped, instructions count: 907
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.k.a(v.d):void");
    }

    @Override // v.o
    public final void d() {
        u.d dVar;
        u.d dVar2;
        int i5;
        u.d dVar3;
        u.d dVar4;
        int i6;
        u.d dVar5 = this.f10005b;
        boolean z4 = dVar5.f9765a;
        g gVar = this.f10008e;
        if (z4) {
            gVar.d(dVar5.q());
        }
        boolean z5 = gVar.f9988j;
        f fVar = this.f10010i;
        f fVar2 = this.h;
        if (!z5) {
            u.d dVar6 = this.f10005b;
            int i7 = dVar6.f9793p0[0];
            this.f10007d = i7;
            if (i7 != 3) {
                if (i7 == 4 && (dVar4 = dVar6.f9758T) != null && ((i6 = dVar4.f9793p0[0]) == 1 || i6 == 4)) {
                    int iQ = (dVar4.q() - this.f10005b.I.e()) - this.f10005b.f9749K.e();
                    o.b(fVar2, dVar4.f9771d.h, this.f10005b.I.e());
                    o.b(fVar, dVar4.f9771d.f10010i, -this.f10005b.f9749K.e());
                    gVar.d(iQ);
                    return;
                }
                if (i7 == 1) {
                    gVar.d(dVar6.q());
                }
            }
        } else if (this.f10007d == 4 && (dVar2 = (dVar = this.f10005b).f9758T) != null && ((i5 = dVar2.f9793p0[0]) == 1 || i5 == 4)) {
            o.b(fVar2, dVar2.f9771d.h, dVar.I.e());
            o.b(fVar, dVar2.f9771d.f10010i, -this.f10005b.f9749K.e());
            return;
        }
        if (gVar.f9988j) {
            u.d dVar7 = this.f10005b;
            if (dVar7.f9765a) {
                u.c[] cVarArr = dVar7.f9755Q;
                u.c cVar = cVarArr[0];
                u.c cVar2 = cVar.f9738f;
                if (cVar2 != null && cVarArr[1].f9738f != null) {
                    if (dVar7.x()) {
                        fVar2.f9986f = this.f10005b.f9755Q[0].e();
                        fVar.f9986f = -this.f10005b.f9755Q[1].e();
                        return;
                    }
                    f fVarH = o.h(this.f10005b.f9755Q[0]);
                    if (fVarH != null) {
                        o.b(fVar2, fVarH, this.f10005b.f9755Q[0].e());
                    }
                    f fVarH2 = o.h(this.f10005b.f9755Q[1]);
                    if (fVarH2 != null) {
                        o.b(fVar, fVarH2, -this.f10005b.f9755Q[1].e());
                    }
                    fVar2.f9982b = true;
                    fVar.f9982b = true;
                    return;
                }
                if (cVar2 != null) {
                    f fVarH3 = o.h(cVar);
                    if (fVarH3 != null) {
                        o.b(fVar2, fVarH3, this.f10005b.f9755Q[0].e());
                        o.b(fVar, fVar2, gVar.g);
                        return;
                    }
                    return;
                }
                u.c cVar3 = cVarArr[1];
                if (cVar3.f9738f != null) {
                    f fVarH4 = o.h(cVar3);
                    if (fVarH4 != null) {
                        o.b(fVar, fVarH4, -this.f10005b.f9755Q[1].e());
                        o.b(fVar2, fVar, -gVar.g);
                        return;
                    }
                    return;
                }
                if ((dVar7 instanceof u.i) || dVar7.f9758T == null || dVar7.i(7).f9738f != null) {
                    return;
                }
                u.d dVar8 = this.f10005b;
                o.b(fVar2, dVar8.f9758T.f9771d.h, dVar8.r());
                o.b(fVar, fVar2, gVar.g);
                return;
            }
        }
        if (this.f10007d == 3) {
            u.d dVar9 = this.f10005b;
            int i8 = dVar9.f9795r;
            if (i8 == 2) {
                u.d dVar10 = dVar9.f9758T;
                if (dVar10 != null) {
                    g gVar2 = dVar10.f9773e.f10008e;
                    gVar.f9990l.add(gVar2);
                    gVar2.f9989k.add(gVar);
                    gVar.f9982b = true;
                    gVar.f9989k.add(fVar2);
                    gVar.f9989k.add(fVar);
                }
            } else if (i8 == 3) {
                if (dVar9.f9796s == 3) {
                    fVar2.f9981a = this;
                    fVar.f9981a = this;
                    m mVar = dVar9.f9773e;
                    mVar.h.f9981a = this;
                    mVar.f10010i.f9981a = this;
                    gVar.f9981a = this;
                    if (dVar9.y()) {
                        gVar.f9990l.add(this.f10005b.f9773e.f10008e);
                        this.f10005b.f9773e.f10008e.f9989k.add(gVar);
                        m mVar2 = this.f10005b.f9773e;
                        mVar2.f10008e.f9981a = this;
                        gVar.f9990l.add(mVar2.h);
                        gVar.f9990l.add(this.f10005b.f9773e.f10010i);
                        this.f10005b.f9773e.h.f9989k.add(gVar);
                        this.f10005b.f9773e.f10010i.f9989k.add(gVar);
                    } else if (this.f10005b.x()) {
                        this.f10005b.f9773e.f10008e.f9990l.add(gVar);
                        gVar.f9989k.add(this.f10005b.f9773e.f10008e);
                    } else {
                        this.f10005b.f9773e.f10008e.f9990l.add(gVar);
                    }
                } else {
                    g gVar3 = dVar9.f9773e.f10008e;
                    gVar.f9990l.add(gVar3);
                    gVar3.f9989k.add(gVar);
                    this.f10005b.f9773e.h.f9989k.add(gVar);
                    this.f10005b.f9773e.f10010i.f9989k.add(gVar);
                    gVar.f9982b = true;
                    gVar.f9989k.add(fVar2);
                    gVar.f9989k.add(fVar);
                    fVar2.f9990l.add(gVar);
                    fVar.f9990l.add(gVar);
                }
            }
        }
        u.d dVar11 = this.f10005b;
        u.c[] cVarArr2 = dVar11.f9755Q;
        u.c cVar4 = cVarArr2[0];
        u.c cVar5 = cVar4.f9738f;
        if (cVar5 != null && cVarArr2[1].f9738f != null) {
            if (dVar11.x()) {
                fVar2.f9986f = this.f10005b.f9755Q[0].e();
                fVar.f9986f = -this.f10005b.f9755Q[1].e();
                return;
            }
            f fVarH5 = o.h(this.f10005b.f9755Q[0]);
            f fVarH6 = o.h(this.f10005b.f9755Q[1]);
            if (fVarH5 != null) {
                fVarH5.b(this);
            }
            if (fVarH6 != null) {
                fVarH6.b(this);
            }
            this.f10011j = 4;
            return;
        }
        if (cVar5 != null) {
            f fVarH7 = o.h(cVar4);
            if (fVarH7 != null) {
                o.b(fVar2, fVarH7, this.f10005b.f9755Q[0].e());
                c(fVar, fVar2, 1, gVar);
                return;
            }
            return;
        }
        u.c cVar6 = cVarArr2[1];
        if (cVar6.f9738f != null) {
            f fVarH8 = o.h(cVar6);
            if (fVarH8 != null) {
                o.b(fVar, fVarH8, -this.f10005b.f9755Q[1].e());
                c(fVar2, fVar, -1, gVar);
                return;
            }
            return;
        }
        if ((dVar11 instanceof u.i) || (dVar3 = dVar11.f9758T) == null) {
            return;
        }
        o.b(fVar2, dVar3.f9771d.h, dVar11.r());
        c(fVar, fVar2, 1, gVar);
    }

    @Override // v.o
    public final void e() {
        f fVar = this.h;
        if (fVar.f9988j) {
            this.f10005b.f9763Y = fVar.g;
        }
    }

    @Override // v.o
    public final void f() {
        this.f10006c = null;
        this.h.c();
        this.f10010i.c();
        this.f10008e.c();
        this.g = false;
    }

    @Override // v.o
    public final boolean k() {
        return this.f10007d != 3 || this.f10005b.f9795r == 0;
    }

    public final void n() {
        this.g = false;
        f fVar = this.h;
        fVar.c();
        fVar.f9988j = false;
        f fVar2 = this.f10010i;
        fVar2.c();
        fVar2.f9988j = false;
        this.f10008e.f9988j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f10005b.f9778h0;
    }
}
