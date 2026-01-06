package u;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import f3.C0513e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import s.AbstractC0882e;
import s.C0880c;
import v.k;
import v.m;

/* loaded from: classes.dex */
public class d {

    /* renamed from: A, reason: collision with root package name */
    public int f9740A;

    /* renamed from: B, reason: collision with root package name */
    public float f9741B;

    /* renamed from: C, reason: collision with root package name */
    public final int[] f9742C;

    /* renamed from: D, reason: collision with root package name */
    public float f9743D;

    /* renamed from: E, reason: collision with root package name */
    public boolean f9744E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f9745F;

    /* renamed from: G, reason: collision with root package name */
    public int f9746G;

    /* renamed from: H, reason: collision with root package name */
    public int f9747H;
    public final c I;

    /* renamed from: J, reason: collision with root package name */
    public final c f9748J;

    /* renamed from: K, reason: collision with root package name */
    public final c f9749K;

    /* renamed from: L, reason: collision with root package name */
    public final c f9750L;

    /* renamed from: M, reason: collision with root package name */
    public final c f9751M;

    /* renamed from: N, reason: collision with root package name */
    public final c f9752N;

    /* renamed from: O, reason: collision with root package name */
    public final c f9753O;

    /* renamed from: P, reason: collision with root package name */
    public final c f9754P;

    /* renamed from: Q, reason: collision with root package name */
    public final c[] f9755Q;

    /* renamed from: R, reason: collision with root package name */
    public final ArrayList f9756R;

    /* renamed from: S, reason: collision with root package name */
    public final boolean[] f9757S;

    /* renamed from: T, reason: collision with root package name */
    public d f9758T;

    /* renamed from: U, reason: collision with root package name */
    public int f9759U;

    /* renamed from: V, reason: collision with root package name */
    public int f9760V;

    /* renamed from: W, reason: collision with root package name */
    public float f9761W;

    /* renamed from: X, reason: collision with root package name */
    public int f9762X;

    /* renamed from: Y, reason: collision with root package name */
    public int f9763Y;

    /* renamed from: Z, reason: collision with root package name */
    public int f9764Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f9766a0;

    /* renamed from: b, reason: collision with root package name */
    public v.c f9767b;

    /* renamed from: b0, reason: collision with root package name */
    public int f9768b0;

    /* renamed from: c, reason: collision with root package name */
    public v.c f9769c;

    /* renamed from: c0, reason: collision with root package name */
    public int f9770c0;

    /* renamed from: d0, reason: collision with root package name */
    public float f9772d0;

    /* renamed from: e0, reason: collision with root package name */
    public float f9774e0;

    /* renamed from: f0, reason: collision with root package name */
    public Object f9776f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f9777g0;

    /* renamed from: h0, reason: collision with root package name */
    public String f9778h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f9780i0;

    /* renamed from: j, reason: collision with root package name */
    public String f9781j;

    /* renamed from: j0, reason: collision with root package name */
    public int f9782j0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f9783k;

    /* renamed from: k0, reason: collision with root package name */
    public final float[] f9784k0;

    /* renamed from: l, reason: collision with root package name */
    public boolean f9785l;

    /* renamed from: l0, reason: collision with root package name */
    public final d[] f9786l0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9787m;

    /* renamed from: m0, reason: collision with root package name */
    public final d[] f9788m0;
    public boolean n;

    /* renamed from: n0, reason: collision with root package name */
    public int f9789n0;

    /* renamed from: o, reason: collision with root package name */
    public int f9790o;

    /* renamed from: o0, reason: collision with root package name */
    public int f9791o0;

    /* renamed from: p, reason: collision with root package name */
    public int f9792p;

    /* renamed from: p0, reason: collision with root package name */
    public final int[] f9793p0;

    /* renamed from: q, reason: collision with root package name */
    public int f9794q;

    /* renamed from: r, reason: collision with root package name */
    public int f9795r;

    /* renamed from: s, reason: collision with root package name */
    public int f9796s;

    /* renamed from: t, reason: collision with root package name */
    public final int[] f9797t;

    /* renamed from: u, reason: collision with root package name */
    public int f9798u;

    /* renamed from: v, reason: collision with root package name */
    public int f9799v;

    /* renamed from: w, reason: collision with root package name */
    public float f9800w;

    /* renamed from: x, reason: collision with root package name */
    public int f9801x;

    /* renamed from: y, reason: collision with root package name */
    public int f9802y;

    /* renamed from: z, reason: collision with root package name */
    public float f9803z;

    /* renamed from: a, reason: collision with root package name */
    public boolean f9765a = false;

    /* renamed from: d, reason: collision with root package name */
    public k f9771d = null;

    /* renamed from: e, reason: collision with root package name */
    public m f9773e = null;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f9775f = {true, true};
    public boolean g = true;
    public int h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f9779i = -1;

    public d() {
        new HashMap();
        this.f9783k = false;
        this.f9785l = false;
        this.f9787m = false;
        this.n = false;
        this.f9790o = -1;
        this.f9792p = -1;
        this.f9794q = 0;
        this.f9795r = 0;
        this.f9796s = 0;
        this.f9797t = new int[2];
        this.f9798u = 0;
        this.f9799v = 0;
        this.f9800w = 1.0f;
        this.f9801x = 0;
        this.f9802y = 0;
        this.f9803z = 1.0f;
        this.f9740A = -1;
        this.f9741B = 1.0f;
        this.f9742C = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.f9743D = BitmapDescriptorFactory.HUE_RED;
        this.f9744E = false;
        this.f9745F = false;
        this.f9746G = 0;
        this.f9747H = 0;
        c cVar = new c(this, 2);
        this.I = cVar;
        c cVar2 = new c(this, 3);
        this.f9748J = cVar2;
        c cVar3 = new c(this, 4);
        this.f9749K = cVar3;
        c cVar4 = new c(this, 5);
        this.f9750L = cVar4;
        c cVar5 = new c(this, 6);
        this.f9751M = cVar5;
        c cVar6 = new c(this, 8);
        this.f9752N = cVar6;
        c cVar7 = new c(this, 9);
        this.f9753O = cVar7;
        c cVar8 = new c(this, 7);
        this.f9754P = cVar8;
        this.f9755Q = new c[]{cVar, cVar3, cVar2, cVar4, cVar5, cVar8};
        ArrayList arrayList = new ArrayList();
        this.f9756R = arrayList;
        this.f9757S = new boolean[2];
        this.f9793p0 = new int[]{1, 1};
        this.f9758T = null;
        this.f9759U = 0;
        this.f9760V = 0;
        this.f9761W = BitmapDescriptorFactory.HUE_RED;
        this.f9762X = -1;
        this.f9763Y = 0;
        this.f9764Z = 0;
        this.f9766a0 = 0;
        this.f9772d0 = 0.5f;
        this.f9774e0 = 0.5f;
        this.f9777g0 = 0;
        this.f9778h0 = null;
        this.f9780i0 = 0;
        this.f9782j0 = 0;
        this.f9784k0 = new float[]{-1.0f, -1.0f};
        this.f9786l0 = new d[]{null, null};
        this.f9788m0 = new d[]{null, null};
        this.f9789n0 = -1;
        this.f9791o0 = -1;
        arrayList.add(cVar);
        arrayList.add(cVar2);
        arrayList.add(cVar3);
        arrayList.add(cVar4);
        arrayList.add(cVar6);
        arrayList.add(cVar7);
        arrayList.add(cVar8);
        arrayList.add(cVar5);
    }

    public static void G(int i5, int i6, String str, StringBuilder sb) {
        if (i5 == i6) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i5);
        sb.append(",\n");
    }

    public static void H(StringBuilder sb, String str, float f5, float f6) {
        if (f5 == f6) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f5);
        sb.append(",\n");
    }

    public static void o(StringBuilder sb, String str, int i5, int i6, int i7, int i8, int i9, float f5) {
        sb.append(str);
        sb.append(" :  {\n");
        G(i5, 0, "      size", sb);
        G(i6, 0, "      min", sb);
        G(i7, Integer.MAX_VALUE, "      max", sb);
        G(i8, 0, "      matchMin", sb);
        G(i9, 0, "      matchDef", sb);
        H(sb, "      matchPercent", f5, 1.0f);
        sb.append("    },\n");
    }

    public static void p(StringBuilder sb, String str, c cVar) {
        if (cVar.f9738f == null) {
            return;
        }
        sb.append("    ");
        sb.append(str);
        sb.append(" : [ '");
        sb.append(cVar.f9738f);
        sb.append("'");
        if (cVar.h != Integer.MIN_VALUE || cVar.g != 0) {
            sb.append(",");
            sb.append(cVar.g);
            if (cVar.h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(cVar.h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    public boolean A() {
        return this.f9783k || (this.I.f9735c && this.f9749K.f9735c);
    }

    public boolean B() {
        return this.f9785l || (this.f9748J.f9735c && this.f9750L.f9735c);
    }

    public void C() {
        this.I.j();
        this.f9748J.j();
        this.f9749K.j();
        this.f9750L.j();
        this.f9751M.j();
        this.f9752N.j();
        this.f9753O.j();
        this.f9754P.j();
        this.f9758T = null;
        this.f9743D = BitmapDescriptorFactory.HUE_RED;
        this.f9759U = 0;
        this.f9760V = 0;
        this.f9761W = BitmapDescriptorFactory.HUE_RED;
        this.f9762X = -1;
        this.f9763Y = 0;
        this.f9764Z = 0;
        this.f9766a0 = 0;
        this.f9768b0 = 0;
        this.f9770c0 = 0;
        this.f9772d0 = 0.5f;
        this.f9774e0 = 0.5f;
        int[] iArr = this.f9793p0;
        iArr[0] = 1;
        iArr[1] = 1;
        this.f9776f0 = null;
        this.f9777g0 = 0;
        this.f9780i0 = 0;
        this.f9782j0 = 0;
        float[] fArr = this.f9784k0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f9790o = -1;
        this.f9792p = -1;
        int[] iArr2 = this.f9742C;
        iArr2[0] = Integer.MAX_VALUE;
        iArr2[1] = Integer.MAX_VALUE;
        this.f9795r = 0;
        this.f9796s = 0;
        this.f9800w = 1.0f;
        this.f9803z = 1.0f;
        this.f9799v = Integer.MAX_VALUE;
        this.f9802y = Integer.MAX_VALUE;
        this.f9798u = 0;
        this.f9801x = 0;
        this.f9740A = -1;
        this.f9741B = 1.0f;
        boolean[] zArr = this.f9775f;
        zArr[0] = true;
        zArr[1] = true;
        this.f9745F = false;
        boolean[] zArr2 = this.f9757S;
        zArr2[0] = false;
        zArr2[1] = false;
        this.g = true;
        int[] iArr3 = this.f9797t;
        iArr3[0] = 0;
        iArr3[1] = 0;
        this.h = -1;
        this.f9779i = -1;
    }

    public final void D() {
        d dVar = this.f9758T;
        if (dVar != null && (dVar instanceof e)) {
            ((e) dVar).getClass();
        }
        ArrayList arrayList = this.f9756R;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((c) arrayList.get(i5)).j();
        }
    }

    public final void E() {
        this.f9783k = false;
        this.f9785l = false;
        this.f9787m = false;
        this.n = false;
        ArrayList arrayList = this.f9756R;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            c cVar = (c) arrayList.get(i5);
            cVar.f9735c = false;
            cVar.f9734b = 0;
        }
    }

    public void F(C0513e c0513e) {
        this.I.k();
        this.f9748J.k();
        this.f9749K.k();
        this.f9750L.k();
        this.f9751M.k();
        this.f9754P.k();
        this.f9752N.k();
        this.f9753O.k();
    }

    public final void I(int i5) {
        this.f9766a0 = i5;
        this.f9744E = i5 > 0;
    }

    public final void J(int i5, int i6) {
        if (this.f9783k) {
            return;
        }
        this.I.l(i5);
        this.f9749K.l(i6);
        this.f9763Y = i5;
        this.f9759U = i6 - i5;
        this.f9783k = true;
    }

    public final void K(int i5, int i6) {
        if (this.f9785l) {
            return;
        }
        this.f9748J.l(i5);
        this.f9750L.l(i6);
        this.f9764Z = i5;
        this.f9760V = i6 - i5;
        if (this.f9744E) {
            this.f9751M.l(i5 + this.f9766a0);
        }
        this.f9785l = true;
    }

    public final void L(int i5) {
        this.f9760V = i5;
        int i6 = this.f9770c0;
        if (i5 < i6) {
            this.f9760V = i6;
        }
    }

    public final void M(int i5) {
        this.f9793p0[0] = i5;
    }

    public final void N(int i5) {
        this.f9793p0[1] = i5;
    }

    public final void O(int i5) {
        this.f9759U = i5;
        int i6 = this.f9768b0;
        if (i5 < i6) {
            this.f9759U = i6;
        }
    }

    public void P(boolean z4, boolean z5) {
        int i5;
        int i6;
        k kVar = this.f9771d;
        boolean z6 = z4 & kVar.g;
        m mVar = this.f9773e;
        boolean z7 = z5 & mVar.g;
        int i7 = kVar.h.g;
        int i8 = mVar.h.g;
        int i9 = kVar.f10010i.g;
        int i10 = mVar.f10010i.g;
        int i11 = i10 - i8;
        if (i9 - i7 < 0 || i11 < 0 || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE || i8 == Integer.MIN_VALUE || i8 == Integer.MAX_VALUE || i9 == Integer.MIN_VALUE || i9 == Integer.MAX_VALUE || i10 == Integer.MIN_VALUE || i10 == Integer.MAX_VALUE) {
            i9 = 0;
            i10 = 0;
            i7 = 0;
            i8 = 0;
        }
        int i12 = i9 - i7;
        int i13 = i10 - i8;
        if (z6) {
            this.f9763Y = i7;
        }
        if (z7) {
            this.f9764Z = i8;
        }
        if (this.f9777g0 == 8) {
            this.f9759U = 0;
            this.f9760V = 0;
            return;
        }
        int[] iArr = this.f9793p0;
        if (z6) {
            if (iArr[0] == 1 && i12 < (i6 = this.f9759U)) {
                i12 = i6;
            }
            this.f9759U = i12;
            int i14 = this.f9768b0;
            if (i12 < i14) {
                this.f9759U = i14;
            }
        }
        if (z7) {
            if (iArr[1] == 1 && i13 < (i5 = this.f9760V)) {
                i13 = i5;
            }
            this.f9760V = i13;
            int i15 = this.f9770c0;
            if (i13 < i15) {
                this.f9760V = i15;
            }
        }
    }

    public void Q(C0880c c0880c, boolean z4) {
        int i5;
        int i6;
        m mVar;
        k kVar;
        c cVar = this.I;
        c0880c.getClass();
        int iN = C0880c.n(cVar);
        int iN2 = C0880c.n(this.f9748J);
        int iN3 = C0880c.n(this.f9749K);
        int iN4 = C0880c.n(this.f9750L);
        if (z4 && (kVar = this.f9771d) != null) {
            v.f fVar = kVar.h;
            if (fVar.f9988j) {
                v.f fVar2 = kVar.f10010i;
                if (fVar2.f9988j) {
                    iN = fVar.g;
                    iN3 = fVar2.g;
                }
            }
        }
        if (z4 && (mVar = this.f9773e) != null) {
            v.f fVar3 = mVar.h;
            if (fVar3.f9988j) {
                v.f fVar4 = mVar.f10010i;
                if (fVar4.f9988j) {
                    iN2 = fVar3.g;
                    iN4 = fVar4.g;
                }
            }
        }
        int i7 = iN4 - iN2;
        if (iN3 - iN < 0 || i7 < 0 || iN == Integer.MIN_VALUE || iN == Integer.MAX_VALUE || iN2 == Integer.MIN_VALUE || iN2 == Integer.MAX_VALUE || iN3 == Integer.MIN_VALUE || iN3 == Integer.MAX_VALUE || iN4 == Integer.MIN_VALUE || iN4 == Integer.MAX_VALUE) {
            iN = 0;
            iN2 = 0;
            iN3 = 0;
            iN4 = 0;
        }
        int i8 = iN3 - iN;
        int i9 = iN4 - iN2;
        this.f9763Y = iN;
        this.f9764Z = iN2;
        if (this.f9777g0 == 8) {
            this.f9759U = 0;
            this.f9760V = 0;
            return;
        }
        int[] iArr = this.f9793p0;
        int i10 = iArr[0];
        if (i10 == 1 && i8 < (i6 = this.f9759U)) {
            i8 = i6;
        }
        if (iArr[1] == 1 && i9 < (i5 = this.f9760V)) {
            i9 = i5;
        }
        this.f9759U = i8;
        this.f9760V = i9;
        int i11 = this.f9770c0;
        if (i9 < i11) {
            this.f9760V = i11;
        }
        int i12 = this.f9768b0;
        if (i8 < i12) {
            this.f9759U = i12;
        }
        int i13 = this.f9799v;
        if (i13 > 0 && i10 == 3) {
            this.f9759U = Math.min(this.f9759U, i13);
        }
        int i14 = this.f9802y;
        if (i14 > 0 && iArr[1] == 3) {
            this.f9760V = Math.min(this.f9760V, i14);
        }
        int i15 = this.f9759U;
        if (i8 != i15) {
            this.h = i15;
        }
        int i16 = this.f9760V;
        if (i9 != i16) {
            this.f9779i = i16;
        }
    }

    public final void a(e eVar, C0880c c0880c, HashSet hashSet, int i5, boolean z4) {
        if (z4) {
            if (!hashSet.contains(this)) {
                return;
            }
            j.b(eVar, c0880c, this);
            hashSet.remove(this);
            b(c0880c, eVar.W(64));
        }
        if (i5 == 0) {
            HashSet hashSet2 = this.I.f9733a;
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).f9736d.a(eVar, c0880c, hashSet, i5, true);
                }
            }
            HashSet hashSet3 = this.f9749K.f9733a;
            if (hashSet3 != null) {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    ((c) it2.next()).f9736d.a(eVar, c0880c, hashSet, i5, true);
                }
                return;
            }
            return;
        }
        HashSet hashSet4 = this.f9748J.f9733a;
        if (hashSet4 != null) {
            Iterator it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                ((c) it3.next()).f9736d.a(eVar, c0880c, hashSet, i5, true);
            }
        }
        HashSet hashSet5 = this.f9750L.f9733a;
        if (hashSet5 != null) {
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                ((c) it4.next()).f9736d.a(eVar, c0880c, hashSet, i5, true);
            }
        }
        HashSet hashSet6 = this.f9751M.f9733a;
        if (hashSet6 != null) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                ((c) it5.next()).f9736d.a(eVar, c0880c, hashSet, i5, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x05bd  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x06a5  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x070a  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0712  */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(s.C0880c r59, boolean r60) {
        /*
            Method dump skipped, instructions count: 1994
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.d.b(s.c, boolean):void");
    }

    public boolean c() {
        return this.f9777g0 != 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x04cf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x04f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:353:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(s.C0880c r31, boolean r32, boolean r33, boolean r34, boolean r35, s.C0883f r36, s.C0883f r37, int r38, boolean r39, u.c r40, u.c r41, int r42, int r43, int r44, int r45, float r46, boolean r47, boolean r48, boolean r49, boolean r50, boolean r51, int r52, int r53, int r54, int r55, float r56, boolean r57) {
        /*
            Method dump skipped, instructions count: 1364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.d.d(s.c, boolean, boolean, boolean, boolean, s.f, s.f, int, boolean, u.c, u.c, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public final void e(int i5, d dVar, int i6, int i7) {
        boolean z4;
        if (i5 == 7) {
            if (i6 != 7) {
                if (i6 == 2 || i6 == 4) {
                    e(2, dVar, i6, 0);
                    e(4, dVar, i6, 0);
                    i(7).a(dVar.i(i6), 0);
                    return;
                } else {
                    if (i6 == 3 || i6 == 5) {
                        e(3, dVar, i6, 0);
                        e(5, dVar, i6, 0);
                        i(7).a(dVar.i(i6), 0);
                        return;
                    }
                    return;
                }
            }
            c cVarI = i(2);
            c cVarI2 = i(4);
            c cVarI3 = i(3);
            c cVarI4 = i(5);
            boolean z5 = true;
            if ((cVarI == null || !cVarI.h()) && (cVarI2 == null || !cVarI2.h())) {
                e(2, dVar, 2, 0);
                e(4, dVar, 4, 0);
                z4 = true;
            } else {
                z4 = false;
            }
            if ((cVarI3 == null || !cVarI3.h()) && (cVarI4 == null || !cVarI4.h())) {
                e(3, dVar, 3, 0);
                e(5, dVar, 5, 0);
            } else {
                z5 = false;
            }
            if (z4 && z5) {
                i(7).a(dVar.i(7), 0);
                return;
            } else if (z4) {
                i(8).a(dVar.i(8), 0);
                return;
            } else {
                if (z5) {
                    i(9).a(dVar.i(9), 0);
                    return;
                }
                return;
            }
        }
        if (i5 == 8 && (i6 == 2 || i6 == 4)) {
            c cVarI5 = i(2);
            c cVarI6 = dVar.i(i6);
            c cVarI7 = i(4);
            cVarI5.a(cVarI6, 0);
            cVarI7.a(cVarI6, 0);
            i(8).a(cVarI6, 0);
            return;
        }
        if (i5 == 9 && (i6 == 3 || i6 == 5)) {
            c cVarI8 = dVar.i(i6);
            i(3).a(cVarI8, 0);
            i(5).a(cVarI8, 0);
            i(9).a(cVarI8, 0);
            return;
        }
        if (i5 == 8 && i6 == 8) {
            i(2).a(dVar.i(2), 0);
            i(4).a(dVar.i(4), 0);
            i(8).a(dVar.i(i6), 0);
            return;
        }
        if (i5 == 9 && i6 == 9) {
            i(3).a(dVar.i(3), 0);
            i(5).a(dVar.i(5), 0);
            i(9).a(dVar.i(i6), 0);
            return;
        }
        c cVarI9 = i(i5);
        c cVarI10 = dVar.i(i6);
        if (cVarI9.i(cVarI10)) {
            if (i5 == 6) {
                c cVarI11 = i(3);
                c cVarI12 = i(5);
                if (cVarI11 != null) {
                    cVarI11.j();
                }
                if (cVarI12 != null) {
                    cVarI12.j();
                }
            } else if (i5 == 3 || i5 == 5) {
                c cVarI13 = i(6);
                if (cVarI13 != null) {
                    cVarI13.j();
                }
                c cVarI14 = i(7);
                if (cVarI14.f9738f != cVarI10) {
                    cVarI14.j();
                }
                c cVarF = i(i5).f();
                c cVarI15 = i(9);
                if (cVarI15.h()) {
                    cVarF.j();
                    cVarI15.j();
                }
            } else if (i5 == 2 || i5 == 4) {
                c cVarI16 = i(7);
                if (cVarI16.f9738f != cVarI10) {
                    cVarI16.j();
                }
                c cVarF2 = i(i5).f();
                c cVarI17 = i(8);
                if (cVarI17.h()) {
                    cVarF2.j();
                    cVarI17.j();
                }
            }
            cVarI9.a(cVarI10, i7);
        }
    }

    public final void f(c cVar, c cVar2, int i5) {
        if (cVar.f9736d == this) {
            e(cVar.f9737e, cVar2.f9736d, cVar2.f9737e, i5);
        }
    }

    public final void g(C0880c c0880c) {
        c0880c.k(this.I);
        c0880c.k(this.f9748J);
        c0880c.k(this.f9749K);
        c0880c.k(this.f9750L);
        if (this.f9766a0 > 0) {
            c0880c.k(this.f9751M);
        }
    }

    public final void h() {
        if (this.f9771d == null) {
            k kVar = new k(this);
            kVar.h.f9985e = 4;
            kVar.f10010i.f9985e = 5;
            kVar.f10009f = 0;
            this.f9771d = kVar;
        }
        if (this.f9773e == null) {
            m mVar = new m(this);
            v.f fVar = new v.f(mVar);
            mVar.f9996k = fVar;
            mVar.f9997l = null;
            mVar.h.f9985e = 6;
            mVar.f10010i.f9985e = 7;
            fVar.f9985e = 8;
            mVar.f10009f = 1;
            this.f9773e = mVar;
        }
    }

    public c i(int i5) {
        switch (AbstractC0882e.c(i5)) {
            case 0:
                return null;
            case 1:
                return this.I;
            case 2:
                return this.f9748J;
            case 3:
                return this.f9749K;
            case 4:
                return this.f9750L;
            case 5:
                return this.f9751M;
            case 6:
                return this.f9754P;
            case 7:
                return this.f9752N;
            case 8:
                return this.f9753O;
            default:
                throw new AssertionError(com.unified.ur1.SatelliteTracker.h.t(i5));
        }
    }

    public final int j(int i5) {
        int[] iArr = this.f9793p0;
        if (i5 == 0) {
            return iArr[0];
        }
        if (i5 == 1) {
            return iArr[1];
        }
        return 0;
    }

    public final int k() {
        if (this.f9777g0 == 8) {
            return 0;
        }
        return this.f9760V;
    }

    public final d l(int i5) {
        c cVar;
        c cVar2;
        if (i5 != 0) {
            if (i5 == 1 && (cVar2 = (cVar = this.f9750L).f9738f) != null && cVar2.f9738f == cVar) {
                return cVar2.f9736d;
            }
            return null;
        }
        c cVar3 = this.f9749K;
        c cVar4 = cVar3.f9738f;
        if (cVar4 == null || cVar4.f9738f != cVar3) {
            return null;
        }
        return cVar4.f9736d;
    }

    public final d m(int i5) {
        c cVar;
        c cVar2;
        if (i5 != 0) {
            if (i5 == 1 && (cVar2 = (cVar = this.f9748J).f9738f) != null && cVar2.f9738f == cVar) {
                return cVar2.f9736d;
            }
            return null;
        }
        c cVar3 = this.I;
        c cVar4 = cVar3.f9738f;
        if (cVar4 == null || cVar4.f9738f != cVar3) {
            return null;
        }
        return cVar4.f9736d;
    }

    public void n(StringBuilder sb) {
        sb.append("  " + this.f9781j + ":{\n");
        StringBuilder sb2 = new StringBuilder("    actualWidth:");
        sb2.append(this.f9759U);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.f9760V);
        sb.append("\n");
        sb.append("    actualLeft:" + this.f9763Y);
        sb.append("\n");
        sb.append("    actualTop:" + this.f9764Z);
        sb.append("\n");
        p(sb, "left", this.I);
        p(sb, "top", this.f9748J);
        p(sb, "right", this.f9749K);
        p(sb, "bottom", this.f9750L);
        p(sb, "baseline", this.f9751M);
        p(sb, "centerX", this.f9752N);
        p(sb, "centerY", this.f9753O);
        int i5 = this.f9759U;
        int i6 = this.f9768b0;
        int[] iArr = this.f9742C;
        int i7 = iArr[0];
        int i8 = this.f9798u;
        int i9 = this.f9795r;
        float f5 = this.f9800w;
        float[] fArr = this.f9784k0;
        float f6 = fArr[0];
        o(sb, "    width", i5, i6, i7, i8, i9, f5);
        int i10 = this.f9760V;
        int i11 = this.f9770c0;
        int i12 = iArr[1];
        int i13 = this.f9801x;
        int i14 = this.f9796s;
        float f7 = this.f9803z;
        float f8 = fArr[1];
        o(sb, "    height", i10, i11, i12, i13, i14, f7);
        float f9 = this.f9761W;
        int i15 = this.f9762X;
        if (f9 != BitmapDescriptorFactory.HUE_RED) {
            sb.append("    dimensionRatio");
            sb.append(" :  [");
            sb.append(f9);
            sb.append(",");
            sb.append(i15);
            sb.append("");
            sb.append("],\n");
        }
        H(sb, "    horizontalBias", this.f9772d0, 0.5f);
        H(sb, "    verticalBias", this.f9774e0, 0.5f);
        G(this.f9780i0, 0, "    horizontalChainStyle", sb);
        G(this.f9782j0, 0, "    verticalChainStyle", sb);
        sb.append("  }");
    }

    public final int q() {
        if (this.f9777g0 == 8) {
            return 0;
        }
        return this.f9759U;
    }

    public final int r() {
        d dVar = this.f9758T;
        return (dVar == null || !(dVar instanceof e)) ? this.f9763Y : ((e) dVar).f9822x0 + this.f9763Y;
    }

    public final int s() {
        d dVar = this.f9758T;
        return (dVar == null || !(dVar instanceof e)) ? this.f9764Z : ((e) dVar).f9823y0 + this.f9764Z;
    }

    public final boolean t(int i5) {
        if (i5 == 0) {
            return (this.I.f9738f != null ? 1 : 0) + (this.f9749K.f9738f != null ? 1 : 0) < 2;
        }
        return ((this.f9748J.f9738f != null ? 1 : 0) + (this.f9750L.f9738f != null ? 1 : 0)) + (this.f9751M.f9738f != null ? 1 : 0) < 2;
    }

    public String toString() {
        StringBuilder sbB = AbstractC0882e.b("");
        sbB.append(this.f9778h0 != null ? com.unified.ur1.SatelliteTracker.h.e(new StringBuilder("id: "), this.f9778h0, " ") : "");
        sbB.append("(");
        sbB.append(this.f9763Y);
        sbB.append(", ");
        sbB.append(this.f9764Z);
        sbB.append(") - (");
        sbB.append(this.f9759U);
        sbB.append(" x ");
        return com.unified.ur1.SatelliteTracker.h.d(sbB, this.f9760V, ")");
    }

    public final boolean u(int i5, int i6) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        if (i5 == 0) {
            c cVar5 = this.I;
            c cVar6 = cVar5.f9738f;
            if (cVar6 != null && cVar6.f9735c && (cVar4 = (cVar3 = this.f9749K).f9738f) != null && cVar4.f9735c) {
                return (cVar4.d() - cVar3.e()) - (cVar5.e() + cVar5.f9738f.d()) >= i6;
            }
        } else {
            c cVar7 = this.f9748J;
            c cVar8 = cVar7.f9738f;
            if (cVar8 != null && cVar8.f9735c && (cVar2 = (cVar = this.f9750L).f9738f) != null && cVar2.f9735c) {
                return (cVar2.d() - cVar.e()) - (cVar7.e() + cVar7.f9738f.d()) >= i6;
            }
        }
        return false;
    }

    public final void v(int i5, int i6, int i7, int i8, d dVar) {
        i(i5).b(dVar.i(i6), i7, i8, true);
    }

    public final boolean w(int i5) {
        c cVar;
        c cVar2;
        int i6 = i5 * 2;
        c[] cVarArr = this.f9755Q;
        c cVar3 = cVarArr[i6];
        c cVar4 = cVar3.f9738f;
        return (cVar4 == null || cVar4.f9738f == cVar3 || (cVar2 = (cVar = cVarArr[i6 + 1]).f9738f) == null || cVar2.f9738f != cVar) ? false : true;
    }

    public final boolean x() {
        c cVar = this.I;
        c cVar2 = cVar.f9738f;
        if (cVar2 != null && cVar2.f9738f == cVar) {
            return true;
        }
        c cVar3 = this.f9749K;
        c cVar4 = cVar3.f9738f;
        return cVar4 != null && cVar4.f9738f == cVar3;
    }

    public final boolean y() {
        c cVar = this.f9748J;
        c cVar2 = cVar.f9738f;
        if (cVar2 != null && cVar2.f9738f == cVar) {
            return true;
        }
        c cVar3 = this.f9750L;
        c cVar4 = cVar3.f9738f;
        return cVar4 != null && cVar4.f9738f == cVar3;
    }

    public final boolean z() {
        return this.g && this.f9777g0 != 8;
    }
}
