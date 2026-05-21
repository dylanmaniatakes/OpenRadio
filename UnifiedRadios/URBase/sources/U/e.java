package u;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import f3.C0513e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import m3.C0777m;
import s.C0880c;
import v.C0919b;
import v.o;

/* loaded from: classes.dex */
public final class e extends d {

    /* renamed from: A0, reason: collision with root package name */
    public int f9804A0;

    /* renamed from: B0, reason: collision with root package name */
    public b[] f9805B0;

    /* renamed from: C0, reason: collision with root package name */
    public b[] f9806C0;

    /* renamed from: D0, reason: collision with root package name */
    public int f9807D0;

    /* renamed from: E0, reason: collision with root package name */
    public boolean f9808E0;

    /* renamed from: F0, reason: collision with root package name */
    public boolean f9809F0;

    /* renamed from: G0, reason: collision with root package name */
    public WeakReference f9810G0;

    /* renamed from: H0, reason: collision with root package name */
    public WeakReference f9811H0;

    /* renamed from: I0, reason: collision with root package name */
    public WeakReference f9812I0;

    /* renamed from: J0, reason: collision with root package name */
    public WeakReference f9813J0;

    /* renamed from: K0, reason: collision with root package name */
    public final HashSet f9814K0;

    /* renamed from: L0, reason: collision with root package name */
    public final C0919b f9815L0;

    /* renamed from: q0, reason: collision with root package name */
    public ArrayList f9816q0 = new ArrayList();

    /* renamed from: r0, reason: collision with root package name */
    public final C0777m f9817r0;

    /* renamed from: s0, reason: collision with root package name */
    public final v.e f9818s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f9819t0;

    /* renamed from: u0, reason: collision with root package name */
    public x.f f9820u0;
    public boolean v0;

    /* renamed from: w0, reason: collision with root package name */
    public final C0880c f9821w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f9822x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f9823y0;
    public int z0;

    public e() {
        C0777m c0777m = new C0777m();
        c0777m.f8620c = new ArrayList();
        c0777m.f8621d = new C0919b();
        c0777m.f8622e = this;
        this.f9817r0 = c0777m;
        v.e eVar = new v.e();
        eVar.f9976b = true;
        eVar.f9977c = true;
        eVar.f9979e = new ArrayList();
        new ArrayList();
        eVar.f9980f = null;
        eVar.g = new C0919b();
        eVar.h = new ArrayList();
        eVar.f9975a = this;
        eVar.f9978d = this;
        this.f9818s0 = eVar;
        this.f9820u0 = null;
        this.v0 = false;
        this.f9821w0 = new C0880c();
        this.z0 = 0;
        this.f9804A0 = 0;
        this.f9805B0 = new b[4];
        this.f9806C0 = new b[4];
        this.f9807D0 = 257;
        this.f9808E0 = false;
        this.f9809F0 = false;
        this.f9810G0 = null;
        this.f9811H0 = null;
        this.f9812I0 = null;
        this.f9813J0 = null;
        this.f9814K0 = new HashSet();
        this.f9815L0 = new C0919b();
    }

    public static void V(d dVar, x.f fVar, C0919b c0919b) {
        int i5;
        int i6;
        if (fVar == null) {
            return;
        }
        if (dVar.f9777g0 == 8 || (dVar instanceof h) || (dVar instanceof C0904a)) {
            c0919b.f9969e = 0;
            c0919b.f9970f = 0;
            return;
        }
        int[] iArr = dVar.f9793p0;
        c0919b.f9965a = iArr[0];
        c0919b.f9966b = iArr[1];
        c0919b.f9967c = dVar.q();
        c0919b.f9968d = dVar.k();
        c0919b.f9971i = false;
        c0919b.f9972j = 0;
        boolean z4 = c0919b.f9965a == 3;
        boolean z5 = c0919b.f9966b == 3;
        boolean z6 = z4 && dVar.f9761W > BitmapDescriptorFactory.HUE_RED;
        boolean z7 = z5 && dVar.f9761W > BitmapDescriptorFactory.HUE_RED;
        if (z4 && dVar.t(0) && dVar.f9795r == 0 && !z6) {
            c0919b.f9965a = 2;
            if (z5 && dVar.f9796s == 0) {
                c0919b.f9965a = 1;
            }
            z4 = false;
        }
        if (z5 && dVar.t(1) && dVar.f9796s == 0 && !z7) {
            c0919b.f9966b = 2;
            if (z4 && dVar.f9795r == 0) {
                c0919b.f9966b = 1;
            }
            z5 = false;
        }
        if (dVar.A()) {
            c0919b.f9965a = 1;
            z4 = false;
        }
        if (dVar.B()) {
            c0919b.f9966b = 1;
            z5 = false;
        }
        int[] iArr2 = dVar.f9797t;
        if (z6) {
            if (iArr2[0] == 4) {
                c0919b.f9965a = 1;
            } else if (!z5) {
                if (c0919b.f9966b == 1) {
                    i6 = c0919b.f9968d;
                } else {
                    c0919b.f9965a = 2;
                    fVar.b(dVar, c0919b);
                    i6 = c0919b.f9970f;
                }
                c0919b.f9965a = 1;
                c0919b.f9967c = (int) (dVar.f9761W * i6);
            }
        }
        if (z7) {
            if (iArr2[1] == 4) {
                c0919b.f9966b = 1;
            } else if (!z4) {
                if (c0919b.f9965a == 1) {
                    i5 = c0919b.f9967c;
                } else {
                    c0919b.f9966b = 2;
                    fVar.b(dVar, c0919b);
                    i5 = c0919b.f9969e;
                }
                c0919b.f9966b = 1;
                if (dVar.f9762X == -1) {
                    c0919b.f9968d = (int) (i5 / dVar.f9761W);
                } else {
                    c0919b.f9968d = (int) (dVar.f9761W * i5);
                }
            }
        }
        fVar.b(dVar, c0919b);
        dVar.O(c0919b.f9969e);
        dVar.L(c0919b.f9970f);
        dVar.f9744E = c0919b.h;
        dVar.I(c0919b.g);
        c0919b.f9972j = 0;
    }

    @Override // u.d
    public final void C() {
        this.f9821w0.t();
        this.f9822x0 = 0;
        this.f9823y0 = 0;
        X();
    }

    @Override // u.d
    public final void F(C0513e c0513e) {
        super.F(c0513e);
        int size = this.f9816q0.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((d) this.f9816q0.get(i5)).F(c0513e);
        }
    }

    @Override // u.d
    public final void P(boolean z4, boolean z5) {
        super.P(z4, z5);
        int size = this.f9816q0.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((d) this.f9816q0.get(i5)).P(z4, z5);
        }
    }

    public final void R(d dVar, int i5) {
        if (i5 == 0) {
            int i6 = this.z0 + 1;
            b[] bVarArr = this.f9806C0;
            if (i6 >= bVarArr.length) {
                this.f9806C0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            b[] bVarArr2 = this.f9806C0;
            int i7 = this.z0;
            bVarArr2[i7] = new b(dVar, 0, this.v0);
            this.z0 = i7 + 1;
            return;
        }
        if (i5 == 1) {
            int i8 = this.f9804A0 + 1;
            b[] bVarArr3 = this.f9805B0;
            if (i8 >= bVarArr3.length) {
                this.f9805B0 = (b[]) Arrays.copyOf(bVarArr3, bVarArr3.length * 2);
            }
            b[] bVarArr4 = this.f9805B0;
            int i9 = this.f9804A0;
            bVarArr4[i9] = new b(dVar, 1, this.v0);
            this.f9804A0 = i9 + 1;
        }
    }

    public final void S(C0880c c0880c) {
        boolean zW = W(64);
        b(c0880c, zW);
        int size = this.f9816q0.size();
        boolean z4 = false;
        for (int i5 = 0; i5 < size; i5++) {
            d dVar = (d) this.f9816q0.get(i5);
            boolean[] zArr = dVar.f9757S;
            zArr[0] = false;
            zArr[1] = false;
            if (dVar instanceof C0904a) {
                z4 = true;
            }
        }
        if (z4) {
            for (int i6 = 0; i6 < size; i6++) {
                d dVar2 = (d) this.f9816q0.get(i6);
                if (dVar2 instanceof C0904a) {
                    C0904a c0904a = (C0904a) dVar2;
                    for (int i7 = 0; i7 < c0904a.f9877r0; i7++) {
                        d dVar3 = c0904a.f9876q0[i7];
                        if (c0904a.f9717t0 || dVar3.c()) {
                            int i8 = c0904a.f9716s0;
                            if (i8 == 0 || i8 == 1) {
                                dVar3.f9757S[0] = true;
                            } else if (i8 == 2 || i8 == 3) {
                                dVar3.f9757S[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet hashSet = this.f9814K0;
        hashSet.clear();
        for (int i9 = 0; i9 < size; i9++) {
            d dVar4 = (d) this.f9816q0.get(i9);
            dVar4.getClass();
            boolean z5 = dVar4 instanceof g;
            if (z5 || (dVar4 instanceof h)) {
                if (z5) {
                    hashSet.add(dVar4);
                } else {
                    dVar4.b(c0880c, zW);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                g gVar = (g) ((d) it.next());
                for (int i10 = 0; i10 < gVar.f9877r0; i10++) {
                    if (hashSet.contains(gVar.f9876q0[i10])) {
                        gVar.b(c0880c, zW);
                        hashSet.remove(gVar);
                        break;
                    }
                }
            }
            if (size2 == hashSet.size()) {
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).b(c0880c, zW);
                }
                hashSet.clear();
            }
        }
        if (C0880c.f9542p) {
            HashSet hashSet2 = new HashSet();
            for (int i11 = 0; i11 < size; i11++) {
                d dVar5 = (d) this.f9816q0.get(i11);
                dVar5.getClass();
                if (!(dVar5 instanceof g) && !(dVar5 instanceof h)) {
                    hashSet2.add(dVar5);
                }
            }
            a(this, c0880c, hashSet2, this.f9793p0[0] == 2 ? 0 : 1, false);
            Iterator it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                d dVar6 = (d) it3.next();
                j.b(this, c0880c, dVar6);
                dVar6.b(c0880c, zW);
            }
        } else {
            for (int i12 = 0; i12 < size; i12++) {
                d dVar7 = (d) this.f9816q0.get(i12);
                if (dVar7 instanceof e) {
                    int[] iArr = dVar7.f9793p0;
                    int i13 = iArr[0];
                    int i14 = iArr[1];
                    if (i13 == 2) {
                        dVar7.M(1);
                    }
                    if (i14 == 2) {
                        dVar7.N(1);
                    }
                    dVar7.b(c0880c, zW);
                    if (i13 == 2) {
                        dVar7.M(i13);
                    }
                    if (i14 == 2) {
                        dVar7.N(i14);
                    }
                } else {
                    j.b(this, c0880c, dVar7);
                    if (!(dVar7 instanceof g) && !(dVar7 instanceof h)) {
                        dVar7.b(c0880c, zW);
                    }
                }
            }
        }
        if (this.z0 > 0) {
            j.a(this, c0880c, null, 0);
        }
        if (this.f9804A0 > 0) {
            j.a(this, c0880c, null, 1);
        }
    }

    public final boolean T(int i5, boolean z4) {
        boolean z5;
        v.e eVar = this.f9818s0;
        e eVar2 = eVar.f9975a;
        boolean z6 = false;
        int iJ = eVar2.j(0);
        int iJ2 = eVar2.j(1);
        int iR = eVar2.r();
        int iS = eVar2.s();
        ArrayList arrayList = eVar.f9979e;
        if (z4 && (iJ == 2 || iJ2 == 2)) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o oVar = (o) it.next();
                if (oVar.f10009f == i5 && !oVar.k()) {
                    z4 = false;
                    break;
                }
            }
            if (i5 == 0) {
                if (z4 && iJ == 2) {
                    eVar2.M(1);
                    eVar2.O(eVar.d(eVar2, 0));
                    eVar2.f9771d.f10008e.d(eVar2.q());
                }
            } else if (z4 && iJ2 == 2) {
                eVar2.N(1);
                eVar2.L(eVar.d(eVar2, 1));
                eVar2.f9773e.f10008e.d(eVar2.k());
            }
        }
        int[] iArr = eVar2.f9793p0;
        if (i5 == 0) {
            int i6 = iArr[0];
            if (i6 == 1 || i6 == 4) {
                int iQ = eVar2.q() + iR;
                eVar2.f9771d.f10010i.d(iQ);
                eVar2.f9771d.f10008e.d(iQ - iR);
                z5 = true;
            }
            z5 = false;
        } else {
            int i7 = iArr[1];
            if (i7 == 1 || i7 == 4) {
                int iK = eVar2.k() + iS;
                eVar2.f9773e.f10010i.d(iK);
                eVar2.f9773e.f10008e.d(iK - iS);
                z5 = true;
            }
            z5 = false;
        }
        eVar.g();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            o oVar2 = (o) it2.next();
            if (oVar2.f10009f == i5 && (oVar2.f10005b != eVar2 || oVar2.g)) {
                oVar2.e();
            }
        }
        Iterator it3 = arrayList.iterator();
        while (true) {
            if (!it3.hasNext()) {
                z6 = true;
                break;
            }
            o oVar3 = (o) it3.next();
            if (oVar3.f10009f == i5 && (z5 || oVar3.f10005b != eVar2)) {
                if (!oVar3.h.f9988j || !oVar3.f10010i.f9988j || (!(oVar3 instanceof v.c) && !oVar3.f10008e.f9988j)) {
                    break;
                }
            }
        }
        eVar2.M(iJ);
        eVar2.N(iJ2);
        return z6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:349:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0606  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0639  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x064f  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x065f  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0675 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:396:0x067b  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0683  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x068a  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x06b1  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x07c0  */
    /* JADX WARN: Removed duplicated region for block: B:489:0x07fd  */
    /* JADX WARN: Removed duplicated region for block: B:495:0x0818 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:500:0x0824 A[LOOP:14: B:499:0x0822->B:500:0x0824, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:512:0x088a  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x0896  */
    /* JADX WARN: Removed duplicated region for block: B:516:0x08a9  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x08b2  */
    /* JADX WARN: Removed duplicated region for block: B:519:0x08b6  */
    /* JADX WARN: Removed duplicated region for block: B:532:0x08ed  */
    /* JADX WARN: Removed duplicated region for block: B:534:0x08f1  */
    /* JADX WARN: Removed duplicated region for block: B:538:0x08fe  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:611:0x08f2 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U() {
        /*
            Method dump skipped, instructions count: 2314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.e.U():void");
    }

    public final boolean W(int i5) {
        return (this.f9807D0 & i5) == i5;
    }

    public final void X() {
        this.f9816q0.clear();
        super.C();
    }

    @Override // u.d
    public final void n(StringBuilder sb) {
        sb.append(this.f9781j + ":{\n");
        StringBuilder sb2 = new StringBuilder("  actualWidth:");
        sb2.append(this.f9759U);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("  actualHeight:" + this.f9760V);
        sb.append("\n");
        Iterator it = this.f9816q0.iterator();
        while (it.hasNext()) {
            ((d) it.next()).n(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }
}
