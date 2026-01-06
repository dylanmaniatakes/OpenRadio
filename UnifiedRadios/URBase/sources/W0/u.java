package w0;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import h1.C0558b;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class u extends p {
    public int I;

    /* renamed from: G, reason: collision with root package name */
    public ArrayList f10109G = new ArrayList();

    /* renamed from: H, reason: collision with root package name */
    public boolean f10110H = true;

    /* renamed from: J, reason: collision with root package name */
    public boolean f10111J = false;

    /* renamed from: K, reason: collision with root package name */
    public int f10112K = 0;

    @Override // w0.p
    public final void A(h4.r rVar) {
        this.f10084B = rVar;
        this.f10112K |= 8;
        int size = this.f10109G.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((p) this.f10109G.get(i5)).A(rVar);
        }
    }

    @Override // w0.p
    public final void C(C0558b c0558b) {
        super.C(c0558b);
        this.f10112K |= 4;
        if (this.f10109G != null) {
            for (int i5 = 0; i5 < this.f10109G.size(); i5++) {
                ((p) this.f10109G.get(i5)).C(c0558b);
            }
        }
    }

    @Override // w0.p
    public final void D() {
        this.f10112K |= 2;
        int size = this.f10109G.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((p) this.f10109G.get(i5)).D();
        }
    }

    @Override // w0.p
    public final void E(long j5) {
        this.f10087k = j5;
    }

    @Override // w0.p
    public final String G(String str) {
        String strG = super.G(str);
        for (int i5 = 0; i5 < this.f10109G.size(); i5++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strG);
            sb.append("\n");
            sb.append(((p) this.f10109G.get(i5)).G(str + "  "));
            strG = sb.toString();
        }
        return strG;
    }

    public final void H(p pVar) {
        this.f10109G.add(pVar);
        pVar.f10093r = this;
        long j5 = this.f10088l;
        if (j5 >= 0) {
            pVar.z(j5);
        }
        if ((this.f10112K & 1) != 0) {
            pVar.B(this.f10089m);
        }
        if ((this.f10112K & 2) != 0) {
            pVar.D();
        }
        if ((this.f10112K & 4) != 0) {
            pVar.C(this.f10085C);
        }
        if ((this.f10112K & 8) != 0) {
            pVar.A(this.f10084B);
        }
    }

    @Override // w0.p
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final void z(long j5) {
        ArrayList arrayList;
        this.f10088l = j5;
        if (j5 < 0 || (arrayList = this.f10109G) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((p) this.f10109G.get(i5)).z(j5);
        }
    }

    @Override // w0.p
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public final void B(TimeInterpolator timeInterpolator) {
        this.f10112K |= 1;
        ArrayList arrayList = this.f10109G;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                ((p) this.f10109G.get(i5)).B(timeInterpolator);
            }
        }
        this.f10089m = timeInterpolator;
    }

    public final void K(int i5) {
        if (i5 == 0) {
            this.f10110H = true;
        } else {
            if (i5 != 1) {
                throw new AndroidRuntimeException(com.unified.ur1.SatelliteTracker.h.a(i5, "Invalid parameter for TransitionSet ordering: "));
            }
            this.f10110H = false;
        }
    }

    @Override // w0.p
    public final void b(View view) {
        for (int i5 = 0; i5 < this.f10109G.size(); i5++) {
            ((p) this.f10109G.get(i5)).b(view);
        }
        this.f10090o.add(view);
    }

    @Override // w0.p
    public final void d(v vVar) {
        if (s(vVar.f10114b)) {
            Iterator it = this.f10109G.iterator();
            while (it.hasNext()) {
                p pVar = (p) it.next();
                if (pVar.s(vVar.f10114b)) {
                    pVar.d(vVar);
                    vVar.f10115c.add(pVar);
                }
            }
        }
    }

    @Override // w0.p
    public final void f(v vVar) {
        int size = this.f10109G.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((p) this.f10109G.get(i5)).f(vVar);
        }
    }

    @Override // w0.p
    public final void g(v vVar) {
        if (s(vVar.f10114b)) {
            Iterator it = this.f10109G.iterator();
            while (it.hasNext()) {
                p pVar = (p) it.next();
                if (pVar.s(vVar.f10114b)) {
                    pVar.g(vVar);
                    vVar.f10115c.add(pVar);
                }
            }
        }
    }

    @Override // w0.p
    /* renamed from: j */
    public final p clone() {
        u uVar = (u) super.clone();
        uVar.f10109G = new ArrayList();
        int size = this.f10109G.size();
        for (int i5 = 0; i5 < size; i5++) {
            p pVarClone = ((p) this.f10109G.get(i5)).clone();
            uVar.f10109G.add(pVarClone);
            pVarClone.f10093r = uVar;
        }
        return uVar;
    }

    @Override // w0.p
    public final void l(ViewGroup viewGroup, L0.i iVar, L0.i iVar2, ArrayList arrayList, ArrayList arrayList2) {
        long j5 = this.f10087k;
        int size = this.f10109G.size();
        for (int i5 = 0; i5 < size; i5++) {
            p pVar = (p) this.f10109G.get(i5);
            if (j5 > 0 && (this.f10110H || i5 == 0)) {
                long j6 = pVar.f10087k;
                if (j6 > 0) {
                    pVar.E(j6 + j5);
                } else {
                    pVar.E(j5);
                }
            }
            pVar.l(viewGroup, iVar, iVar2, arrayList, arrayList2);
        }
    }

    @Override // w0.p
    public final void u(View view) {
        super.u(view);
        int size = this.f10109G.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((p) this.f10109G.get(i5)).u(view);
        }
    }

    @Override // w0.p
    public final void w(View view) {
        for (int i5 = 0; i5 < this.f10109G.size(); i5++) {
            ((p) this.f10109G.get(i5)).w(view);
        }
        this.f10090o.remove(view);
    }

    @Override // w0.p
    public final void x(View view) {
        super.x(view);
        int size = this.f10109G.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((p) this.f10109G.get(i5)).x(view);
        }
    }

    @Override // w0.p
    public final void y() {
        if (this.f10109G.isEmpty()) {
            F();
            m();
            return;
        }
        g gVar = new g();
        gVar.f10061b = this;
        Iterator it = this.f10109G.iterator();
        while (it.hasNext()) {
            ((p) it.next()).a(gVar);
        }
        this.I = this.f10109G.size();
        if (this.f10110H) {
            Iterator it2 = this.f10109G.iterator();
            while (it2.hasNext()) {
                ((p) it2.next()).y();
            }
            return;
        }
        for (int i5 = 1; i5 < this.f10109G.size(); i5++) {
            ((p) this.f10109G.get(i5 - 1)).a(new g(1, (p) this.f10109G.get(i5)));
        }
        p pVar = (p) this.f10109G.get(0);
        if (pVar != null) {
            pVar.y();
        }
    }
}
