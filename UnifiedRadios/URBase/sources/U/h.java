package u;

import java.util.ArrayList;
import s.AbstractC0882e;
import s.C0879b;
import s.C0880c;
import s.C0883f;

/* loaded from: classes.dex */
public final class h extends d {

    /* renamed from: q0, reason: collision with root package name */
    public float f9871q0 = -1.0f;

    /* renamed from: r0, reason: collision with root package name */
    public int f9872r0 = -1;

    /* renamed from: s0, reason: collision with root package name */
    public int f9873s0 = -1;

    /* renamed from: t0, reason: collision with root package name */
    public c f9874t0 = this.f9748J;

    /* renamed from: u0, reason: collision with root package name */
    public int f9875u0 = 0;
    public boolean v0;

    public h() {
        this.f9756R.clear();
        this.f9756R.add(this.f9874t0);
        int length = this.f9755Q.length;
        for (int i5 = 0; i5 < length; i5++) {
            this.f9755Q[i5] = this.f9874t0;
        }
    }

    @Override // u.d
    public final boolean A() {
        return this.v0;
    }

    @Override // u.d
    public final boolean B() {
        return this.v0;
    }

    @Override // u.d
    public final void Q(C0880c c0880c, boolean z4) {
        if (this.f9758T == null) {
            return;
        }
        c cVar = this.f9874t0;
        c0880c.getClass();
        int iN = C0880c.n(cVar);
        if (this.f9875u0 == 1) {
            this.f9763Y = iN;
            this.f9764Z = 0;
            L(this.f9758T.k());
            O(0);
            return;
        }
        this.f9763Y = 0;
        this.f9764Z = iN;
        O(this.f9758T.q());
        L(0);
    }

    public final void R(int i5) {
        this.f9874t0.l(i5);
        this.v0 = true;
    }

    public final void S(int i5) {
        if (this.f9875u0 == i5) {
            return;
        }
        this.f9875u0 = i5;
        ArrayList arrayList = this.f9756R;
        arrayList.clear();
        if (this.f9875u0 == 1) {
            this.f9874t0 = this.I;
        } else {
            this.f9874t0 = this.f9748J;
        }
        arrayList.add(this.f9874t0);
        c[] cVarArr = this.f9755Q;
        int length = cVarArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            cVarArr[i6] = this.f9874t0;
        }
    }

    @Override // u.d
    public final void b(C0880c c0880c, boolean z4) {
        e eVar = (e) this.f9758T;
        if (eVar == null) {
            return;
        }
        Object objI = eVar.i(2);
        Object objI2 = eVar.i(4);
        d dVar = this.f9758T;
        boolean z5 = dVar != null && dVar.f9793p0[0] == 2;
        if (this.f9875u0 == 0) {
            objI = eVar.i(3);
            objI2 = eVar.i(5);
            d dVar2 = this.f9758T;
            z5 = dVar2 != null && dVar2.f9793p0[1] == 2;
        }
        if (this.v0) {
            c cVar = this.f9874t0;
            if (cVar.f9735c) {
                C0883f c0883fK = c0880c.k(cVar);
                c0880c.d(c0883fK, this.f9874t0.d());
                if (this.f9872r0 != -1) {
                    if (z5) {
                        c0880c.f(c0880c.k(objI2), c0883fK, 0, 5);
                    }
                } else if (this.f9873s0 != -1 && z5) {
                    C0883f c0883fK2 = c0880c.k(objI2);
                    c0880c.f(c0883fK, c0880c.k(objI), 0, 5);
                    c0880c.f(c0883fK2, c0883fK, 0, 5);
                }
                this.v0 = false;
                return;
            }
        }
        if (this.f9872r0 != -1) {
            C0883f c0883fK3 = c0880c.k(this.f9874t0);
            c0880c.e(c0883fK3, c0880c.k(objI), this.f9872r0, 8);
            if (z5) {
                c0880c.f(c0880c.k(objI2), c0883fK3, 0, 5);
                return;
            }
            return;
        }
        if (this.f9873s0 != -1) {
            C0883f c0883fK4 = c0880c.k(this.f9874t0);
            C0883f c0883fK5 = c0880c.k(objI2);
            c0880c.e(c0883fK4, c0883fK5, -this.f9873s0, 8);
            if (z5) {
                c0880c.f(c0883fK4, c0880c.k(objI), 0, 5);
                c0880c.f(c0883fK5, c0883fK4, 0, 5);
                return;
            }
            return;
        }
        if (this.f9871q0 != -1.0f) {
            C0883f c0883fK6 = c0880c.k(this.f9874t0);
            C0883f c0883fK7 = c0880c.k(objI2);
            float f5 = this.f9871q0;
            C0879b c0879bL = c0880c.l();
            c0879bL.f9540d.j(c0883fK6, -1.0f);
            c0879bL.f9540d.j(c0883fK7, f5);
            c0880c.c(c0879bL);
        }
    }

    @Override // u.d
    public final boolean c() {
        return true;
    }

    @Override // u.d
    public final c i(int i5) {
        int iC = AbstractC0882e.c(i5);
        if (iC != 1) {
            if (iC != 2) {
                if (iC != 3) {
                    if (iC != 4) {
                        return null;
                    }
                }
            }
            if (this.f9875u0 == 0) {
                return this.f9874t0;
            }
            return null;
        }
        if (this.f9875u0 == 1) {
            return this.f9874t0;
        }
        return null;
    }
}
