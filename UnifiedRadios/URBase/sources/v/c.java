package v;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c extends o {

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f9973k;

    /* renamed from: l, reason: collision with root package name */
    public int f9974l;

    public c(u.d dVar, int i5) {
        u.d dVar2;
        super(dVar);
        this.f9973k = new ArrayList();
        this.f10009f = i5;
        u.d dVar3 = this.f10005b;
        u.d dVarM = dVar3.m(i5);
        while (true) {
            u.d dVar4 = dVarM;
            dVar2 = dVar3;
            dVar3 = dVar4;
            if (dVar3 == null) {
                break;
            } else {
                dVarM = dVar3.m(this.f10009f);
            }
        }
        this.f10005b = dVar2;
        int i6 = this.f10009f;
        o oVar = i6 == 0 ? dVar2.f9771d : i6 == 1 ? dVar2.f9773e : null;
        ArrayList arrayList = this.f9973k;
        arrayList.add(oVar);
        u.d dVarL = dVar2.l(this.f10009f);
        while (dVarL != null) {
            int i7 = this.f10009f;
            arrayList.add(i7 == 0 ? dVarL.f9771d : i7 == 1 ? dVarL.f9773e : null);
            dVarL = dVarL.l(this.f10009f);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            o oVar2 = (o) it.next();
            int i8 = this.f10009f;
            if (i8 == 0) {
                oVar2.f10005b.f9767b = this;
            } else if (i8 == 1) {
                oVar2.f10005b.f9769c = this;
            }
        }
        if (this.f10009f == 0 && ((u.e) this.f10005b.f9758T).v0 && arrayList.size() > 1) {
            this.f10005b = ((o) arrayList.get(arrayList.size() - 1)).f10005b;
        }
        this.f9974l = this.f10009f == 0 ? this.f10005b.f9780i0 : this.f10005b.f9782j0;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0153  */
    @Override // v.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(v.d r27) {
        /*
            Method dump skipped, instructions count: 969
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.c.a(v.d):void");
    }

    @Override // v.o
    public final void d() {
        ArrayList arrayList = this.f9973k;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((o) it.next()).d();
        }
        int size = arrayList.size();
        if (size < 1) {
            return;
        }
        u.d dVar = ((o) arrayList.get(0)).f10005b;
        u.d dVar2 = ((o) arrayList.get(size - 1)).f10005b;
        int i5 = this.f10009f;
        f fVar = this.f10010i;
        f fVar2 = this.h;
        if (i5 == 0) {
            u.c cVar = dVar.I;
            u.c cVar2 = dVar2.f9749K;
            f fVarI = o.i(cVar, 0);
            int iE = cVar.e();
            u.d dVarM = m();
            if (dVarM != null) {
                iE = dVarM.I.e();
            }
            if (fVarI != null) {
                o.b(fVar2, fVarI, iE);
            }
            f fVarI2 = o.i(cVar2, 0);
            int iE2 = cVar2.e();
            u.d dVarN = n();
            if (dVarN != null) {
                iE2 = dVarN.f9749K.e();
            }
            if (fVarI2 != null) {
                o.b(fVar, fVarI2, -iE2);
            }
        } else {
            u.c cVar3 = dVar.f9748J;
            u.c cVar4 = dVar2.f9750L;
            f fVarI3 = o.i(cVar3, 1);
            int iE3 = cVar3.e();
            u.d dVarM2 = m();
            if (dVarM2 != null) {
                iE3 = dVarM2.f9748J.e();
            }
            if (fVarI3 != null) {
                o.b(fVar2, fVarI3, iE3);
            }
            f fVarI4 = o.i(cVar4, 1);
            int iE4 = cVar4.e();
            u.d dVarN2 = n();
            if (dVarN2 != null) {
                iE4 = dVarN2.f9750L.e();
            }
            if (fVarI4 != null) {
                o.b(fVar, fVarI4, -iE4);
            }
        }
        fVar2.f9981a = this;
        fVar.f9981a = this;
    }

    @Override // v.o
    public final void e() {
        int i5 = 0;
        while (true) {
            ArrayList arrayList = this.f9973k;
            if (i5 >= arrayList.size()) {
                return;
            }
            ((o) arrayList.get(i5)).e();
            i5++;
        }
    }

    @Override // v.o
    public final void f() {
        this.f10006c = null;
        Iterator it = this.f9973k.iterator();
        while (it.hasNext()) {
            ((o) it.next()).f();
        }
    }

    @Override // v.o
    public final long j() {
        ArrayList arrayList = this.f9973k;
        int size = arrayList.size();
        long j5 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            j5 = r5.f10010i.f9986f + ((o) arrayList.get(i5)).j() + j5 + r5.h.f9986f;
        }
        return j5;
    }

    @Override // v.o
    public final boolean k() {
        ArrayList arrayList = this.f9973k;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!((o) arrayList.get(i5)).k()) {
                return false;
            }
        }
        return true;
    }

    public final u.d m() {
        int i5 = 0;
        while (true) {
            ArrayList arrayList = this.f9973k;
            if (i5 >= arrayList.size()) {
                return null;
            }
            u.d dVar = ((o) arrayList.get(i5)).f10005b;
            if (dVar.f9777g0 != 8) {
                return dVar;
            }
            i5++;
        }
    }

    public final u.d n() {
        ArrayList arrayList = this.f9973k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            u.d dVar = ((o) arrayList.get(size)).f10005b;
            if (dVar.f9777g0 != 8) {
                return dVar;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f10009f == 0 ? "horizontal : " : "vertical : ");
        Iterator it = this.f9973k.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            sb.append("<");
            sb.append(oVar);
            sb.append("> ");
        }
        return sb.toString();
    }
}
