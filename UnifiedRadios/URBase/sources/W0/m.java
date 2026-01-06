package w0;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.l0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class m extends l0 {
    @Override // androidx.fragment.app.l0
    public final void a(View view, Object obj) {
        if (obj != null) {
            ((p) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.l0
    public final void b(Object obj, ArrayList arrayList) {
        p pVar = (p) obj;
        if (pVar == null) {
            return;
        }
        int i5 = 0;
        if (pVar instanceof u) {
            u uVar = (u) pVar;
            int size = uVar.f10109G.size();
            while (i5 < size) {
                b((i5 < 0 || i5 >= uVar.f10109G.size()) ? null : (p) uVar.f10109G.get(i5), arrayList);
                i5++;
            }
            return;
        }
        if ((!l0.h(pVar.n)) || !l0.h(pVar.f10090o)) {
            return;
        }
        int size2 = arrayList.size();
        while (i5 < size2) {
            pVar.b((View) arrayList.get(i5));
            i5++;
        }
    }

    @Override // androidx.fragment.app.l0
    public final void c(ViewGroup viewGroup, Object obj) {
        t.a(viewGroup, (p) obj);
    }

    @Override // androidx.fragment.app.l0
    public final boolean e(Object obj) {
        return obj instanceof p;
    }

    @Override // androidx.fragment.app.l0
    public final Object f(Object obj) {
        if (obj != null) {
            return ((p) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.l0
    public final Object i(Object obj, Object obj2, Object obj3) {
        p pVar = (p) obj;
        p pVar2 = (p) obj2;
        p pVar3 = (p) obj3;
        if (pVar != null && pVar2 != null) {
            u uVar = new u();
            uVar.H(pVar);
            uVar.H(pVar2);
            uVar.K(1);
            pVar = uVar;
        } else if (pVar == null) {
            pVar = pVar2 != null ? pVar2 : null;
        }
        if (pVar3 == null) {
            return pVar;
        }
        u uVar2 = new u();
        if (pVar != null) {
            uVar2.H(pVar);
        }
        uVar2.H(pVar3);
        return uVar2;
    }

    @Override // androidx.fragment.app.l0
    public final Object j(Object obj, Object obj2, Object obj3) {
        u uVar = new u();
        if (obj != null) {
            uVar.H((p) obj);
        }
        if (obj2 != null) {
            uVar.H((p) obj2);
        }
        if (obj3 != null) {
            uVar.H((p) obj3);
        }
        return uVar;
    }

    @Override // androidx.fragment.app.l0
    public final void k(Object obj, View view, ArrayList arrayList) {
        ((p) obj).a(new k(view, arrayList));
    }

    @Override // androidx.fragment.app.l0
    public final void l(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((p) obj).a(new l(this, obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.l0
    public final void m(View view, Object obj) {
        if (view != null) {
            l0.g(view, new Rect());
            ((p) obj).A(new j());
        }
    }

    @Override // androidx.fragment.app.l0
    public final void n(Object obj, Rect rect) {
        if (obj != null) {
            ((p) obj).A(new j());
        }
    }

    @Override // androidx.fragment.app.l0
    public final void p(Object obj, View view, ArrayList arrayList) {
        u uVar = (u) obj;
        ArrayList arrayList2 = uVar.f10090o;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            l0.d((View) arrayList.get(i5), arrayList2);
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(uVar, arrayList);
    }

    @Override // androidx.fragment.app.l0
    public final void q(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        u uVar = (u) obj;
        if (uVar != null) {
            ArrayList arrayList3 = uVar.f10090o;
            arrayList3.clear();
            arrayList3.addAll(arrayList2);
            s(uVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.l0
    public final Object r(Object obj) {
        if (obj == null) {
            return null;
        }
        u uVar = new u();
        uVar.H((p) obj);
        return uVar;
    }

    public final void s(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        p pVar = (p) obj;
        int i5 = 0;
        if (pVar instanceof u) {
            u uVar = (u) pVar;
            int size = uVar.f10109G.size();
            while (i5 < size) {
                s((i5 < 0 || i5 >= uVar.f10109G.size()) ? null : (p) uVar.f10109G.get(i5), arrayList, arrayList2);
                i5++;
            }
            return;
        }
        if (!l0.h(pVar.n)) {
            return;
        }
        ArrayList arrayList3 = pVar.f10090o;
        if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
            int size2 = arrayList2 == null ? 0 : arrayList2.size();
            while (i5 < size2) {
                pVar.b((View) arrayList2.get(i5));
                i5++;
            }
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                pVar.w((View) arrayList.get(size3));
            }
        }
    }
}
