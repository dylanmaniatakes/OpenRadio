package v;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public final class m extends o {

    /* renamed from: k, reason: collision with root package name */
    public f f9996k;

    /* renamed from: l, reason: collision with root package name */
    public C0918a f9997l;

    @Override // v.d
    public final void a(d dVar) {
        float f5;
        float f6;
        float f7;
        int i5;
        if (AbstractC0882e.c(this.f10011j) == 3) {
            u.d dVar2 = this.f10005b;
            l(dVar2.f9748J, dVar2.f9750L, 1);
            return;
        }
        g gVar = this.f10008e;
        if (gVar.f9983c && !gVar.f9988j && this.f10007d == 3) {
            u.d dVar3 = this.f10005b;
            int i6 = dVar3.f9796s;
            if (i6 == 2) {
                u.d dVar4 = dVar3.f9758T;
                if (dVar4 != null) {
                    if (dVar4.f9773e.f10008e.f9988j) {
                        gVar.d((int) ((r5.g * dVar3.f9803z) + 0.5f));
                    }
                }
            } else if (i6 == 3) {
                g gVar2 = dVar3.f9771d.f10008e;
                if (gVar2.f9988j) {
                    int i7 = dVar3.f9762X;
                    if (i7 == -1) {
                        f5 = gVar2.g;
                        f6 = dVar3.f9761W;
                    } else if (i7 == 0) {
                        f7 = gVar2.g * dVar3.f9761W;
                        i5 = (int) (f7 + 0.5f);
                        gVar.d(i5);
                    } else if (i7 != 1) {
                        i5 = 0;
                        gVar.d(i5);
                    } else {
                        f5 = gVar2.g;
                        f6 = dVar3.f9761W;
                    }
                    f7 = f5 / f6;
                    i5 = (int) (f7 + 0.5f);
                    gVar.d(i5);
                }
            }
        }
        f fVar = this.h;
        if (fVar.f9983c) {
            f fVar2 = this.f10010i;
            if (fVar2.f9983c) {
                if (fVar.f9988j && fVar2.f9988j && gVar.f9988j) {
                    return;
                }
                if (!gVar.f9988j && this.f10007d == 3) {
                    u.d dVar5 = this.f10005b;
                    if (dVar5.f9795r == 0 && !dVar5.y()) {
                        f fVar3 = (f) fVar.f9990l.get(0);
                        f fVar4 = (f) fVar2.f9990l.get(0);
                        int i8 = fVar3.g + fVar.f9986f;
                        int i9 = fVar4.g + fVar2.f9986f;
                        fVar.d(i8);
                        fVar2.d(i9);
                        gVar.d(i9 - i8);
                        return;
                    }
                }
                if (!gVar.f9988j && this.f10007d == 3 && this.f10004a == 1 && fVar.f9990l.size() > 0 && fVar2.f9990l.size() > 0) {
                    f fVar5 = (f) fVar.f9990l.get(0);
                    int i10 = (((f) fVar2.f9990l.get(0)).g + fVar2.f9986f) - (fVar5.g + fVar.f9986f);
                    int i11 = gVar.f9991m;
                    if (i10 < i11) {
                        gVar.d(i10);
                    } else {
                        gVar.d(i11);
                    }
                }
                if (gVar.f9988j && fVar.f9990l.size() > 0 && fVar2.f9990l.size() > 0) {
                    f fVar6 = (f) fVar.f9990l.get(0);
                    f fVar7 = (f) fVar2.f9990l.get(0);
                    int i12 = fVar6.g;
                    int i13 = fVar.f9986f + i12;
                    int i14 = fVar7.g;
                    int i15 = fVar2.f9986f + i14;
                    float f8 = this.f10005b.f9774e0;
                    if (fVar6 == fVar7) {
                        f8 = 0.5f;
                    } else {
                        i12 = i13;
                        i14 = i15;
                    }
                    fVar.d((int) ((((i14 - i12) - gVar.g) * f8) + i12 + 0.5f));
                    fVar2.d(fVar.g + gVar.g);
                }
            }
        }
    }

    @Override // v.o
    public final void d() {
        u.d dVar;
        u.d dVar2;
        u.d dVar3;
        u.d dVar4;
        u.d dVar5 = this.f10005b;
        boolean z4 = dVar5.f9765a;
        g gVar = this.f10008e;
        if (z4) {
            gVar.d(dVar5.k());
        }
        boolean z5 = gVar.f9988j;
        f fVar = this.f10010i;
        f fVar2 = this.h;
        if (!z5) {
            u.d dVar6 = this.f10005b;
            this.f10007d = dVar6.f9793p0[1];
            if (dVar6.f9744E) {
                this.f9997l = new C0918a(this);
            }
            int i5 = this.f10007d;
            if (i5 != 3) {
                if (i5 == 4 && (dVar4 = this.f10005b.f9758T) != null && dVar4.f9793p0[1] == 1) {
                    int iK = (dVar4.k() - this.f10005b.f9748J.e()) - this.f10005b.f9750L.e();
                    o.b(fVar2, dVar4.f9773e.h, this.f10005b.f9748J.e());
                    o.b(fVar, dVar4.f9773e.f10010i, -this.f10005b.f9750L.e());
                    gVar.d(iK);
                    return;
                }
                if (i5 == 1) {
                    gVar.d(this.f10005b.k());
                }
            }
        } else if (this.f10007d == 4 && (dVar2 = (dVar = this.f10005b).f9758T) != null && dVar2.f9793p0[1] == 1) {
            o.b(fVar2, dVar2.f9773e.h, dVar.f9748J.e());
            o.b(fVar, dVar2.f9773e.f10010i, -this.f10005b.f9750L.e());
            return;
        }
        boolean z6 = gVar.f9988j;
        f fVar3 = this.f9996k;
        if (z6) {
            u.d dVar7 = this.f10005b;
            if (dVar7.f9765a) {
                u.c[] cVarArr = dVar7.f9755Q;
                u.c cVar = cVarArr[2];
                u.c cVar2 = cVar.f9738f;
                if (cVar2 != null && cVarArr[3].f9738f != null) {
                    if (dVar7.y()) {
                        fVar2.f9986f = this.f10005b.f9755Q[2].e();
                        fVar.f9986f = -this.f10005b.f9755Q[3].e();
                    } else {
                        f fVarH = o.h(this.f10005b.f9755Q[2]);
                        if (fVarH != null) {
                            o.b(fVar2, fVarH, this.f10005b.f9755Q[2].e());
                        }
                        f fVarH2 = o.h(this.f10005b.f9755Q[3]);
                        if (fVarH2 != null) {
                            o.b(fVar, fVarH2, -this.f10005b.f9755Q[3].e());
                        }
                        fVar2.f9982b = true;
                        fVar.f9982b = true;
                    }
                    u.d dVar8 = this.f10005b;
                    if (dVar8.f9744E) {
                        o.b(fVar3, fVar2, dVar8.f9766a0);
                        return;
                    }
                    return;
                }
                if (cVar2 != null) {
                    f fVarH3 = o.h(cVar);
                    if (fVarH3 != null) {
                        o.b(fVar2, fVarH3, this.f10005b.f9755Q[2].e());
                        o.b(fVar, fVar2, gVar.g);
                        u.d dVar9 = this.f10005b;
                        if (dVar9.f9744E) {
                            o.b(fVar3, fVar2, dVar9.f9766a0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                u.c cVar3 = cVarArr[3];
                if (cVar3.f9738f != null) {
                    f fVarH4 = o.h(cVar3);
                    if (fVarH4 != null) {
                        o.b(fVar, fVarH4, -this.f10005b.f9755Q[3].e());
                        o.b(fVar2, fVar, -gVar.g);
                    }
                    u.d dVar10 = this.f10005b;
                    if (dVar10.f9744E) {
                        o.b(fVar3, fVar2, dVar10.f9766a0);
                        return;
                    }
                    return;
                }
                u.c cVar4 = cVarArr[4];
                if (cVar4.f9738f != null) {
                    f fVarH5 = o.h(cVar4);
                    if (fVarH5 != null) {
                        o.b(fVar3, fVarH5, 0);
                        o.b(fVar2, fVar3, -this.f10005b.f9766a0);
                        o.b(fVar, fVar2, gVar.g);
                        return;
                    }
                    return;
                }
                if ((dVar7 instanceof u.i) || dVar7.f9758T == null || dVar7.i(7).f9738f != null) {
                    return;
                }
                u.d dVar11 = this.f10005b;
                o.b(fVar2, dVar11.f9758T.f9773e.h, dVar11.s());
                o.b(fVar, fVar2, gVar.g);
                u.d dVar12 = this.f10005b;
                if (dVar12.f9744E) {
                    o.b(fVar3, fVar2, dVar12.f9766a0);
                    return;
                }
                return;
            }
        }
        if (z6 || this.f10007d != 3) {
            gVar.b(this);
        } else {
            u.d dVar13 = this.f10005b;
            int i6 = dVar13.f9796s;
            if (i6 == 2) {
                u.d dVar14 = dVar13.f9758T;
                if (dVar14 != null) {
                    g gVar2 = dVar14.f9773e.f10008e;
                    gVar.f9990l.add(gVar2);
                    gVar2.f9989k.add(gVar);
                    gVar.f9982b = true;
                    gVar.f9989k.add(fVar2);
                    gVar.f9989k.add(fVar);
                }
            } else if (i6 == 3 && !dVar13.y()) {
                u.d dVar15 = this.f10005b;
                if (dVar15.f9795r != 3) {
                    g gVar3 = dVar15.f9771d.f10008e;
                    gVar.f9990l.add(gVar3);
                    gVar3.f9989k.add(gVar);
                    gVar.f9982b = true;
                    gVar.f9989k.add(fVar2);
                    gVar.f9989k.add(fVar);
                }
            }
        }
        u.d dVar16 = this.f10005b;
        u.c[] cVarArr2 = dVar16.f9755Q;
        u.c cVar5 = cVarArr2[2];
        u.c cVar6 = cVar5.f9738f;
        if (cVar6 != null && cVarArr2[3].f9738f != null) {
            if (dVar16.y()) {
                fVar2.f9986f = this.f10005b.f9755Q[2].e();
                fVar.f9986f = -this.f10005b.f9755Q[3].e();
            } else {
                f fVarH6 = o.h(this.f10005b.f9755Q[2]);
                f fVarH7 = o.h(this.f10005b.f9755Q[3]);
                if (fVarH6 != null) {
                    fVarH6.b(this);
                }
                if (fVarH7 != null) {
                    fVarH7.b(this);
                }
                this.f10011j = 4;
            }
            if (this.f10005b.f9744E) {
                c(fVar3, fVar2, 1, this.f9997l);
            }
        } else if (cVar6 != null) {
            f fVarH8 = o.h(cVar5);
            if (fVarH8 != null) {
                o.b(fVar2, fVarH8, this.f10005b.f9755Q[2].e());
                c(fVar, fVar2, 1, gVar);
                if (this.f10005b.f9744E) {
                    c(fVar3, fVar2, 1, this.f9997l);
                }
                if (this.f10007d == 3) {
                    u.d dVar17 = this.f10005b;
                    if (dVar17.f9761W > BitmapDescriptorFactory.HUE_RED) {
                        k kVar = dVar17.f9771d;
                        if (kVar.f10007d == 3) {
                            kVar.f10008e.f9989k.add(gVar);
                            gVar.f9990l.add(this.f10005b.f9771d.f10008e);
                            gVar.f9981a = this;
                        }
                    }
                }
            }
        } else {
            u.c cVar7 = cVarArr2[3];
            if (cVar7.f9738f != null) {
                f fVarH9 = o.h(cVar7);
                if (fVarH9 != null) {
                    o.b(fVar, fVarH9, -this.f10005b.f9755Q[3].e());
                    c(fVar2, fVar, -1, gVar);
                    if (this.f10005b.f9744E) {
                        c(fVar3, fVar2, 1, this.f9997l);
                    }
                }
            } else {
                u.c cVar8 = cVarArr2[4];
                if (cVar8.f9738f != null) {
                    f fVarH10 = o.h(cVar8);
                    if (fVarH10 != null) {
                        o.b(fVar3, fVarH10, 0);
                        c(fVar2, fVar3, -1, this.f9997l);
                        c(fVar, fVar2, 1, gVar);
                    }
                } else if (!(dVar16 instanceof u.i) && (dVar3 = dVar16.f9758T) != null) {
                    o.b(fVar2, dVar3.f9773e.h, dVar16.s());
                    c(fVar, fVar2, 1, gVar);
                    if (this.f10005b.f9744E) {
                        c(fVar3, fVar2, 1, this.f9997l);
                    }
                    if (this.f10007d == 3) {
                        u.d dVar18 = this.f10005b;
                        if (dVar18.f9761W > BitmapDescriptorFactory.HUE_RED) {
                            k kVar2 = dVar18.f9771d;
                            if (kVar2.f10007d == 3) {
                                kVar2.f10008e.f9989k.add(gVar);
                                gVar.f9990l.add(this.f10005b.f9771d.f10008e);
                                gVar.f9981a = this;
                            }
                        }
                    }
                }
            }
        }
        if (gVar.f9990l.size() == 0) {
            gVar.f9983c = true;
        }
    }

    @Override // v.o
    public final void e() {
        f fVar = this.h;
        if (fVar.f9988j) {
            this.f10005b.f9764Z = fVar.g;
        }
    }

    @Override // v.o
    public final void f() {
        this.f10006c = null;
        this.h.c();
        this.f10010i.c();
        this.f9996k.c();
        this.f10008e.c();
        this.g = false;
    }

    @Override // v.o
    public final boolean k() {
        return this.f10007d != 3 || this.f10005b.f9796s == 0;
    }

    public final void m() {
        this.g = false;
        f fVar = this.h;
        fVar.c();
        fVar.f9988j = false;
        f fVar2 = this.f10010i;
        fVar2.c();
        fVar2.f9988j = false;
        f fVar3 = this.f9996k;
        fVar3.c();
        fVar3.f9988j = false;
        this.f10008e.f9988j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f10005b.f9778h0;
    }
}
