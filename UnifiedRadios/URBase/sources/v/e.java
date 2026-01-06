package v;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public u.e f9975a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9976b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9977c;

    /* renamed from: d, reason: collision with root package name */
    public u.e f9978d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f9979e;

    /* renamed from: f, reason: collision with root package name */
    public x.f f9980f;
    public C0919b g;
    public ArrayList h;

    public final void a(f fVar, int i5, ArrayList arrayList, l lVar) {
        o oVar = fVar.f9984d;
        if (oVar.f10006c == null) {
            u.e eVar = this.f9975a;
            if (oVar == eVar.f9771d || oVar == eVar.f9773e) {
                return;
            }
            if (lVar == null) {
                lVar = new l();
                lVar.f9994a = null;
                lVar.f9995b = new ArrayList();
                lVar.f9994a = oVar;
                arrayList.add(lVar);
            }
            oVar.f10006c = lVar;
            lVar.f9995b.add(oVar);
            f fVar2 = oVar.h;
            Iterator it = fVar2.f9989k.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar instanceof f) {
                    a((f) dVar, i5, arrayList, lVar);
                }
            }
            f fVar3 = oVar.f10010i;
            Iterator it2 = fVar3.f9989k.iterator();
            while (it2.hasNext()) {
                d dVar2 = (d) it2.next();
                if (dVar2 instanceof f) {
                    a((f) dVar2, i5, arrayList, lVar);
                }
            }
            if (i5 == 1 && (oVar instanceof m)) {
                Iterator it3 = ((m) oVar).f9996k.f9989k.iterator();
                while (it3.hasNext()) {
                    d dVar3 = (d) it3.next();
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i5, arrayList, lVar);
                    }
                }
            }
            Iterator it4 = fVar2.f9990l.iterator();
            while (it4.hasNext()) {
                a((f) it4.next(), i5, arrayList, lVar);
            }
            Iterator it5 = fVar3.f9990l.iterator();
            while (it5.hasNext()) {
                a((f) it5.next(), i5, arrayList, lVar);
            }
            if (i5 == 1 && (oVar instanceof m)) {
                Iterator it6 = ((m) oVar).f9996k.f9990l.iterator();
                while (it6.hasNext()) {
                    a((f) it6.next(), i5, arrayList, lVar);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x0260 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01f9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0008 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(u.e r17) {
        /*
            Method dump skipped, instructions count: 791
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.e.b(u.e):void");
    }

    public final void c() {
        ArrayList arrayList = this.f9979e;
        arrayList.clear();
        u.e eVar = this.f9978d;
        eVar.f9771d.f();
        eVar.f9773e.f();
        arrayList.add(eVar.f9771d);
        arrayList.add(eVar.f9773e);
        Iterator it = eVar.f9816q0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            u.d dVar = (u.d) it.next();
            if (dVar instanceof u.h) {
                i iVar = new i(dVar);
                dVar.f9771d.f();
                dVar.f9773e.f();
                iVar.f10009f = ((u.h) dVar).f9875u0;
                arrayList.add(iVar);
            } else {
                if (dVar.x()) {
                    if (dVar.f9767b == null) {
                        dVar.f9767b = new c(dVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(dVar.f9767b);
                } else {
                    arrayList.add(dVar.f9771d);
                }
                if (dVar.y()) {
                    if (dVar.f9769c == null) {
                        dVar.f9769c = new c(dVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(dVar.f9769c);
                } else {
                    arrayList.add(dVar.f9773e);
                }
                if (dVar instanceof u.i) {
                    arrayList.add(new j(dVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((o) it2.next()).f();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            o oVar = (o) it3.next();
            if (oVar.f10005b != eVar) {
                oVar.d();
            }
        }
        ArrayList arrayList2 = this.h;
        arrayList2.clear();
        u.e eVar2 = this.f9975a;
        e(eVar2.f9771d, 0, arrayList2);
        e(eVar2.f9773e, 1, arrayList2);
        this.f9976b = false;
    }

    public final int d(u.e eVar, int i5) {
        ArrayList arrayList;
        int i6;
        int i7;
        long jMax;
        float f5;
        u.e eVar2 = eVar;
        ArrayList arrayList2 = this.h;
        int size = arrayList2.size();
        int i8 = 0;
        long jMax2 = 0;
        while (i8 < size) {
            o oVar = ((l) arrayList2.get(i8)).f9994a;
            if (!(oVar instanceof c) ? !(i5 != 0 ? (oVar instanceof m) : (oVar instanceof k)) : ((c) oVar).f10009f != i5) {
                f fVar = (i5 == 0 ? eVar2.f9771d : eVar2.f9773e).h;
                f fVar2 = (i5 == 0 ? eVar2.f9771d : eVar2.f9773e).f10010i;
                boolean zContains = oVar.h.f9990l.contains(fVar);
                f fVar3 = oVar.f10010i;
                boolean zContains2 = fVar3.f9990l.contains(fVar2);
                long j5 = oVar.j();
                f fVar4 = oVar.h;
                if (zContains && zContains2) {
                    long jB = l.b(fVar4, 0L);
                    ArrayList arrayList3 = arrayList2;
                    i6 = size;
                    long jA = l.a(fVar3, 0L);
                    long j6 = jB - j5;
                    int i9 = fVar3.f9986f;
                    arrayList = arrayList3;
                    i7 = i8;
                    if (j6 >= (-i9)) {
                        j6 += i9;
                    }
                    long j7 = (-jA) - j5;
                    long j8 = fVar4.f9986f;
                    long j9 = j7 - j8;
                    if (j9 >= j8) {
                        j9 -= j8;
                    }
                    u.d dVar = oVar.f10005b;
                    if (i5 == 0) {
                        f5 = dVar.f9772d0;
                    } else if (i5 == 1) {
                        f5 = dVar.f9774e0;
                    } else {
                        dVar.getClass();
                        f5 = -1.0f;
                    }
                    float f6 = f5 > BitmapDescriptorFactory.HUE_RED ? (long) ((j6 / (1.0f - f5)) + (j9 / f5)) : 0L;
                    jMax = (fVar4.f9986f + ((((long) ((f6 * f5) + 0.5f)) + j5) + ((long) (((1.0f - f5) * f6) + 0.5f)))) - fVar3.f9986f;
                } else {
                    arrayList = arrayList2;
                    i6 = size;
                    i7 = i8;
                    jMax = zContains ? Math.max(l.b(fVar4, fVar4.f9986f), fVar4.f9986f + j5) : zContains2 ? Math.max(-l.a(fVar3, fVar3.f9986f), (-fVar3.f9986f) + j5) : (oVar.j() + fVar4.f9986f) - fVar3.f9986f;
                }
            } else {
                arrayList = arrayList2;
                i6 = size;
                i7 = i8;
                jMax = 0;
            }
            jMax2 = Math.max(jMax2, jMax);
            i8 = i7 + 1;
            eVar2 = eVar;
            size = i6;
            arrayList2 = arrayList;
        }
        return (int) jMax2;
    }

    public final void e(o oVar, int i5, ArrayList arrayList) {
        f fVar;
        Iterator it = oVar.h.f9989k.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            fVar = oVar.f10010i;
            if (!zHasNext) {
                break;
            }
            d dVar = (d) it.next();
            if (dVar instanceof f) {
                a((f) dVar, i5, arrayList, null);
            } else if (dVar instanceof o) {
                a(((o) dVar).h, i5, arrayList, null);
            }
        }
        Iterator it2 = fVar.f9989k.iterator();
        while (it2.hasNext()) {
            d dVar2 = (d) it2.next();
            if (dVar2 instanceof f) {
                a((f) dVar2, i5, arrayList, null);
            } else if (dVar2 instanceof o) {
                a(((o) dVar2).f10010i, i5, arrayList, null);
            }
        }
        if (i5 == 1) {
            Iterator it3 = ((m) oVar).f9996k.f9989k.iterator();
            while (it3.hasNext()) {
                d dVar3 = (d) it3.next();
                if (dVar3 instanceof f) {
                    a((f) dVar3, i5, arrayList, null);
                }
            }
        }
    }

    public final void f(int i5, int i6, int i7, int i8, u.d dVar) {
        C0919b c0919b = this.g;
        c0919b.f9965a = i5;
        c0919b.f9966b = i7;
        c0919b.f9967c = i6;
        c0919b.f9968d = i8;
        this.f9980f.b(dVar, c0919b);
        dVar.O(c0919b.f9969e);
        dVar.L(c0919b.f9970f);
        dVar.f9744E = c0919b.h;
        dVar.I(c0919b.g);
    }

    public final void g() {
        C0918a c0918a;
        Iterator it = this.f9975a.f9816q0.iterator();
        while (it.hasNext()) {
            u.d dVar = (u.d) it.next();
            if (!dVar.f9765a) {
                int[] iArr = dVar.f9793p0;
                boolean z4 = false;
                int i5 = iArr[0];
                int i6 = iArr[1];
                int i7 = dVar.f9795r;
                int i8 = dVar.f9796s;
                boolean z5 = i5 == 2 || (i5 == 3 && i7 == 1);
                if (i6 == 2 || (i6 == 3 && i8 == 1)) {
                    z4 = true;
                }
                g gVar = dVar.f9771d.f10008e;
                boolean z6 = gVar.f9988j;
                g gVar2 = dVar.f9773e.f10008e;
                boolean z7 = gVar2.f9988j;
                if (z6 && z7) {
                    f(1, gVar.g, 1, gVar2.g, dVar);
                    dVar.f9765a = true;
                } else if (z6 && z4) {
                    f(1, gVar.g, 2, gVar2.g, dVar);
                    if (i6 == 3) {
                        dVar.f9773e.f10008e.f9991m = dVar.k();
                    } else {
                        dVar.f9773e.f10008e.d(dVar.k());
                        dVar.f9765a = true;
                    }
                } else if (z7 && z5) {
                    f(2, gVar.g, 1, gVar2.g, dVar);
                    if (i5 == 3) {
                        dVar.f9771d.f10008e.f9991m = dVar.q();
                    } else {
                        dVar.f9771d.f10008e.d(dVar.q());
                        dVar.f9765a = true;
                    }
                }
                if (dVar.f9765a && (c0918a = dVar.f9773e.f9997l) != null) {
                    c0918a.d(dVar.f9766a0);
                }
            }
        }
    }
}
