package v;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final C0919b f9992a = new C0919b();

    public static boolean a(u.d dVar) {
        int[] iArr = dVar.f9793p0;
        int i5 = iArr[0];
        int i6 = iArr[1];
        u.d dVar2 = dVar.f9758T;
        u.e eVar = dVar2 != null ? (u.e) dVar2 : null;
        if (eVar != null) {
            int i7 = eVar.f9793p0[0];
        }
        if (eVar != null) {
            int i8 = eVar.f9793p0[1];
        }
        boolean z4 = i5 == 1 || dVar.A() || i5 == 2 || (i5 == 3 && dVar.f9795r == 0 && dVar.f9761W == BitmapDescriptorFactory.HUE_RED && dVar.t(0)) || (i5 == 3 && dVar.f9795r == 1 && dVar.u(0, dVar.q()));
        boolean z5 = i6 == 1 || dVar.B() || i6 == 2 || (i6 == 3 && dVar.f9796s == 0 && dVar.f9761W == BitmapDescriptorFactory.HUE_RED && dVar.t(1)) || (i6 == 3 && dVar.f9796s == 1 && dVar.u(1, dVar.k()));
        if (dVar.f9761W <= BitmapDescriptorFactory.HUE_RED || !(z4 || z5)) {
            return z4 && z5;
        }
        return true;
    }

    public static n b(u.d dVar, int i5, ArrayList arrayList, n nVar) {
        int i6;
        int i7 = i5 == 0 ? dVar.f9789n0 : dVar.f9791o0;
        if (i7 != -1 && (nVar == null || i7 != nVar.f10000b)) {
            int i8 = 0;
            while (true) {
                if (i8 >= arrayList.size()) {
                    break;
                }
                n nVar2 = (n) arrayList.get(i8);
                if (nVar2.f10000b == i7) {
                    if (nVar != null) {
                        nVar.c(i5, nVar2);
                        arrayList.remove(nVar);
                    }
                    nVar = nVar2;
                } else {
                    i8++;
                }
            }
        } else if (i7 != -1) {
            return nVar;
        }
        if (nVar == null) {
            if (dVar instanceof u.i) {
                u.i iVar = (u.i) dVar;
                int i9 = 0;
                while (true) {
                    if (i9 >= iVar.f9877r0) {
                        i6 = -1;
                        break;
                    }
                    u.d dVar2 = iVar.f9876q0[i9];
                    if ((i5 == 0 && (i6 = dVar2.f9789n0) != -1) || (i5 == 1 && (i6 = dVar2.f9791o0) != -1)) {
                        break;
                    }
                    i9++;
                }
                if (i6 != -1) {
                    int i10 = 0;
                    while (true) {
                        if (i10 >= arrayList.size()) {
                            break;
                        }
                        n nVar3 = (n) arrayList.get(i10);
                        if (nVar3.f10000b == i6) {
                            nVar = nVar3;
                            break;
                        }
                        i10++;
                    }
                }
            }
            if (nVar == null) {
                nVar = new n();
                nVar.f9999a = new ArrayList();
                nVar.f10002d = null;
                nVar.f10003e = -1;
                int i11 = n.f9998f;
                n.f9998f = i11 + 1;
                nVar.f10000b = i11;
                nVar.f10001c = i5;
            }
            arrayList.add(nVar);
        }
        ArrayList arrayList2 = nVar.f9999a;
        if (!arrayList2.contains(dVar)) {
            arrayList2.add(dVar);
            if (dVar instanceof u.h) {
                u.h hVar = (u.h) dVar;
                hVar.f9874t0.c(hVar.f9875u0 == 0 ? 1 : 0, arrayList, nVar);
            }
            int i12 = nVar.f10000b;
            if (i5 == 0) {
                dVar.f9789n0 = i12;
                dVar.I.c(i5, arrayList, nVar);
                dVar.f9749K.c(i5, arrayList, nVar);
            } else {
                dVar.f9791o0 = i12;
                dVar.f9748J.c(i5, arrayList, nVar);
                dVar.f9751M.c(i5, arrayList, nVar);
                dVar.f9750L.c(i5, arrayList, nVar);
            }
            dVar.f9754P.c(i5, arrayList, nVar);
        }
        return nVar;
    }

    public static void c(int i5, u.d dVar, x.f fVar, boolean z4) {
        u.c cVar;
        u.c cVar2;
        u.c cVar3;
        u.c cVar4;
        if (dVar.f9787m) {
            return;
        }
        if (!(dVar instanceof u.e) && dVar.z() && a(dVar)) {
            u.e.V(dVar, fVar, new C0919b());
        }
        u.c cVarI = dVar.i(2);
        u.c cVarI2 = dVar.i(4);
        int iD = cVarI.d();
        int iD2 = cVarI2.d();
        HashSet hashSet = cVarI.f9733a;
        char c2 = 0;
        if (hashSet != null && cVarI.f9735c) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                u.c cVar5 = (u.c) it.next();
                u.d dVar2 = cVar5.f9736d;
                int i6 = i5 + 1;
                boolean zA = a(dVar2);
                if (dVar2.z() && zA) {
                    u.e.V(dVar2, fVar, new C0919b());
                }
                u.c cVar6 = dVar2.I;
                u.c cVar7 = dVar2.f9749K;
                char c5 = ((cVar5 == cVar6 && (cVar4 = cVar7.f9738f) != null && cVar4.f9735c) || (cVar5 == cVar7 && (cVar3 = cVar6.f9738f) != null && cVar3.f9735c)) ? (char) 1 : c2;
                int i7 = dVar2.f9793p0[c2];
                if (i7 != 3 || zA) {
                    if (!dVar2.z()) {
                        if (cVar5 == cVar6 && cVar7.f9738f == null) {
                            int iE = cVar6.e() + iD;
                            dVar2.J(iE, dVar2.q() + iE);
                            c(i6, dVar2, fVar, z4);
                        } else if (cVar5 == cVar7 && cVar6.f9738f == null) {
                            int iE2 = iD - cVar7.e();
                            dVar2.J(iE2 - dVar2.q(), iE2);
                            c(i6, dVar2, fVar, z4);
                        } else if (c5 != 0 && !dVar2.x()) {
                            d(i6, dVar2, fVar, z4);
                        }
                    }
                } else if (i7 == 3 && dVar2.f9799v >= 0 && dVar2.f9798u >= 0 && ((dVar2.f9777g0 == 8 || (dVar2.f9795r == 0 && dVar2.f9761W == BitmapDescriptorFactory.HUE_RED)) && !dVar2.x() && !dVar2.f9745F && c5 != 0 && !dVar2.x())) {
                    e(i6, dVar, fVar, dVar2, z4);
                }
                c2 = 0;
            }
        }
        if (dVar instanceof u.h) {
            return;
        }
        HashSet hashSet2 = cVarI2.f9733a;
        if (hashSet2 != null && cVarI2.f9735c) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                u.c cVar8 = (u.c) it2.next();
                u.d dVar3 = cVar8.f9736d;
                int i8 = i5 + 1;
                boolean zA2 = a(dVar3);
                if (dVar3.z() && zA2) {
                    u.e.V(dVar3, fVar, new C0919b());
                }
                u.c cVar9 = dVar3.I;
                u.c cVar10 = dVar3.f9749K;
                boolean z5 = (cVar8 == cVar9 && (cVar2 = cVar10.f9738f) != null && cVar2.f9735c) || (cVar8 == cVar10 && (cVar = cVar9.f9738f) != null && cVar.f9735c);
                int i9 = dVar3.f9793p0[0];
                if (i9 != 3 || zA2) {
                    if (!dVar3.z()) {
                        if (cVar8 == cVar9 && cVar10.f9738f == null) {
                            int iE3 = cVar9.e() + iD2;
                            dVar3.J(iE3, dVar3.q() + iE3);
                            c(i8, dVar3, fVar, z4);
                        } else if (cVar8 == cVar10 && cVar9.f9738f == null) {
                            int iE4 = iD2 - cVar10.e();
                            dVar3.J(iE4 - dVar3.q(), iE4);
                            c(i8, dVar3, fVar, z4);
                        } else if (z5 && !dVar3.x()) {
                            d(i8, dVar3, fVar, z4);
                        }
                    }
                } else if (i9 == 3 && dVar3.f9799v >= 0 && dVar3.f9798u >= 0) {
                    if (dVar3.f9777g0 != 8) {
                        if (dVar3.f9795r == 0) {
                            if (dVar3.f9761W == BitmapDescriptorFactory.HUE_RED) {
                            }
                        }
                    }
                    if (!dVar3.x() && !dVar3.f9745F && z5 && !dVar3.x()) {
                        e(i8, dVar, fVar, dVar3, z4);
                    }
                }
            }
        }
        dVar.f9787m = true;
    }

    public static void d(int i5, u.d dVar, x.f fVar, boolean z4) {
        float f5 = dVar.f9772d0;
        u.c cVar = dVar.I;
        int iD = cVar.f9738f.d();
        u.c cVar2 = dVar.f9749K;
        int iD2 = cVar2.f9738f.d();
        int iE = cVar.e() + iD;
        int iE2 = iD2 - cVar2.e();
        if (iD == iD2) {
            f5 = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iQ = dVar.q();
        int i6 = (iD2 - iD) - iQ;
        if (iD > iD2) {
            i6 = (iD - iD2) - iQ;
        }
        int i7 = ((int) (i6 > 0 ? (f5 * i6) + 0.5f : f5 * i6)) + iD;
        int i8 = i7 + iQ;
        if (iD > iD2) {
            i8 = i7 - iQ;
        }
        dVar.J(i7, i8);
        c(i5 + 1, dVar, fVar, z4);
    }

    public static void e(int i5, u.d dVar, x.f fVar, u.d dVar2, boolean z4) {
        float f5 = dVar2.f9772d0;
        u.c cVar = dVar2.I;
        int iE = cVar.e() + cVar.f9738f.d();
        u.c cVar2 = dVar2.f9749K;
        int iD = cVar2.f9738f.d() - cVar2.e();
        if (iD >= iE) {
            int iQ = dVar2.q();
            if (dVar2.f9777g0 != 8) {
                int i6 = dVar2.f9795r;
                if (i6 == 2) {
                    iQ = (int) (dVar2.f9772d0 * 0.5f * (dVar instanceof u.e ? dVar.q() : dVar.f9758T.q()));
                } else if (i6 == 0) {
                    iQ = iD - iE;
                }
                iQ = Math.max(dVar2.f9798u, iQ);
                int i7 = dVar2.f9799v;
                if (i7 > 0) {
                    iQ = Math.min(i7, iQ);
                }
            }
            int i8 = iE + ((int) ((f5 * ((iD - iE) - iQ)) + 0.5f));
            dVar2.J(i8, iQ + i8);
            c(i5 + 1, dVar2, fVar, z4);
        }
    }

    public static void f(int i5, u.d dVar, x.f fVar) {
        float f5 = dVar.f9774e0;
        u.c cVar = dVar.f9748J;
        int iD = cVar.f9738f.d();
        u.c cVar2 = dVar.f9750L;
        int iD2 = cVar2.f9738f.d();
        int iE = cVar.e() + iD;
        int iE2 = iD2 - cVar2.e();
        if (iD == iD2) {
            f5 = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iK = dVar.k();
        int i6 = (iD2 - iD) - iK;
        if (iD > iD2) {
            i6 = (iD - iD2) - iK;
        }
        int i7 = (int) (i6 > 0 ? (f5 * i6) + 0.5f : f5 * i6);
        int i8 = iD + i7;
        int i9 = i8 + iK;
        if (iD > iD2) {
            i8 = iD - i7;
            i9 = i8 - iK;
        }
        dVar.K(i8, i9);
        i(i5 + 1, dVar, fVar);
    }

    public static void g(int i5, u.d dVar, x.f fVar, u.d dVar2) {
        float f5 = dVar2.f9774e0;
        u.c cVar = dVar2.f9748J;
        int iE = cVar.e() + cVar.f9738f.d();
        u.c cVar2 = dVar2.f9750L;
        int iD = cVar2.f9738f.d() - cVar2.e();
        if (iD >= iE) {
            int iK = dVar2.k();
            if (dVar2.f9777g0 != 8) {
                int i6 = dVar2.f9796s;
                if (i6 == 2) {
                    iK = (int) (f5 * 0.5f * (dVar instanceof u.e ? dVar.k() : dVar.f9758T.k()));
                } else if (i6 == 0) {
                    iK = iD - iE;
                }
                iK = Math.max(dVar2.f9801x, iK);
                int i7 = dVar2.f9802y;
                if (i7 > 0) {
                    iK = Math.min(i7, iK);
                }
            }
            int i8 = iE + ((int) ((f5 * ((iD - iE) - iK)) + 0.5f));
            dVar2.K(i8, iK + i8);
            i(i5 + 1, dVar2, fVar);
        }
    }

    public static boolean h(int i5, int i6, int i7, int i8) {
        return (i7 == 1 || i7 == 2 || (i7 == 4 && i5 != 2)) || (i8 == 1 || i8 == 2 || (i8 == 4 && i6 != 2));
    }

    public static void i(int i5, u.d dVar, x.f fVar) {
        u.c cVar;
        u.c cVar2;
        u.c cVar3;
        u.c cVar4;
        u.c cVar5;
        if (dVar.n) {
            return;
        }
        if (!(dVar instanceof u.e) && dVar.z() && a(dVar)) {
            u.e.V(dVar, fVar, new C0919b());
        }
        u.c cVarI = dVar.i(3);
        u.c cVarI2 = dVar.i(5);
        int iD = cVarI.d();
        int iD2 = cVarI2.d();
        HashSet hashSet = cVarI.f9733a;
        if (hashSet != null && cVarI.f9735c) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                u.c cVar6 = (u.c) it.next();
                u.d dVar2 = cVar6.f9736d;
                int i6 = i5 + 1;
                boolean zA = a(dVar2);
                if (dVar2.z() && zA) {
                    u.e.V(dVar2, fVar, new C0919b());
                }
                u.c cVar7 = dVar2.f9748J;
                u.c cVar8 = dVar2.f9750L;
                boolean z4 = (cVar6 == cVar7 && (cVar5 = cVar8.f9738f) != null && cVar5.f9735c) || (cVar6 == cVar8 && (cVar4 = cVar7.f9738f) != null && cVar4.f9735c);
                int i7 = dVar2.f9793p0[1];
                if (i7 != 3 || zA) {
                    if (!dVar2.z()) {
                        if (cVar6 == cVar7 && cVar8.f9738f == null) {
                            int iE = cVar7.e() + iD;
                            dVar2.K(iE, dVar2.k() + iE);
                            i(i6, dVar2, fVar);
                        } else if (cVar6 == cVar8 && cVar7.f9738f == null) {
                            int iE2 = iD - cVar8.e();
                            dVar2.K(iE2 - dVar2.k(), iE2);
                            i(i6, dVar2, fVar);
                        } else if (z4 && !dVar2.y()) {
                            f(i6, dVar2, fVar);
                        }
                    }
                } else if (i7 == 3 && dVar2.f9802y >= 0 && dVar2.f9801x >= 0 && (dVar2.f9777g0 == 8 || (dVar2.f9796s == 0 && dVar2.f9761W == BitmapDescriptorFactory.HUE_RED))) {
                    if (!dVar2.y() && !dVar2.f9745F && z4 && !dVar2.y()) {
                        g(i6, dVar, fVar, dVar2);
                    }
                }
            }
        }
        if (dVar instanceof u.h) {
            return;
        }
        HashSet hashSet2 = cVarI2.f9733a;
        if (hashSet2 != null && cVarI2.f9735c) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                u.c cVar9 = (u.c) it2.next();
                u.d dVar3 = cVar9.f9736d;
                int i8 = i5 + 1;
                boolean zA2 = a(dVar3);
                if (dVar3.z() && zA2) {
                    u.e.V(dVar3, fVar, new C0919b());
                }
                u.c cVar10 = dVar3.f9748J;
                u.c cVar11 = dVar3.f9750L;
                boolean z5 = (cVar9 == cVar10 && (cVar3 = cVar11.f9738f) != null && cVar3.f9735c) || (cVar9 == cVar11 && (cVar2 = cVar10.f9738f) != null && cVar2.f9735c);
                int i9 = dVar3.f9793p0[1];
                if (i9 != 3 || zA2) {
                    if (!dVar3.z()) {
                        if (cVar9 == cVar10 && cVar11.f9738f == null) {
                            int iE3 = cVar10.e() + iD2;
                            dVar3.K(iE3, dVar3.k() + iE3);
                            i(i8, dVar3, fVar);
                        } else if (cVar9 == cVar11 && cVar10.f9738f == null) {
                            int iE4 = iD2 - cVar11.e();
                            dVar3.K(iE4 - dVar3.k(), iE4);
                            i(i8, dVar3, fVar);
                        } else if (z5 && !dVar3.y()) {
                            f(i8, dVar3, fVar);
                        }
                    }
                } else if (i9 == 3 && dVar3.f9802y >= 0 && dVar3.f9801x >= 0) {
                    if (dVar3.f9777g0 != 8) {
                        if (dVar3.f9796s == 0) {
                            if (dVar3.f9761W == BitmapDescriptorFactory.HUE_RED) {
                            }
                        }
                    }
                    if (!dVar3.y() && !dVar3.f9745F && z5 && !dVar3.y()) {
                        g(i8, dVar, fVar, dVar3);
                    }
                }
            }
        }
        u.c cVarI3 = dVar.i(6);
        if (cVarI3.f9733a != null && cVarI3.f9735c) {
            int iD3 = cVarI3.d();
            Iterator it3 = cVarI3.f9733a.iterator();
            while (it3.hasNext()) {
                u.c cVar12 = (u.c) it3.next();
                u.d dVar4 = cVar12.f9736d;
                int i10 = i5 + 1;
                boolean zA3 = a(dVar4);
                if (dVar4.z() && zA3) {
                    u.e.V(dVar4, fVar, new C0919b());
                }
                if (dVar4.f9793p0[1] != 3 || zA3) {
                    if (!dVar4.z() && cVar12 == (cVar = dVar4.f9751M)) {
                        int iE5 = cVar12.e() + iD3;
                        if (dVar4.f9744E) {
                            int i11 = iE5 - dVar4.f9766a0;
                            int i12 = dVar4.f9760V + i11;
                            dVar4.f9764Z = i11;
                            dVar4.f9748J.l(i11);
                            dVar4.f9750L.l(i12);
                            cVar.l(iE5);
                            dVar4.f9785l = true;
                        }
                        i(i10, dVar4, fVar);
                    }
                }
            }
        }
        dVar.n = true;
    }
}
