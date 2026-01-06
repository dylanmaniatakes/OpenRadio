package w0;

import O.C0165g0;
import O.G;
import O.M;
import O.Y;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import h1.C0558b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public abstract class p implements Cloneable {

    /* renamed from: D, reason: collision with root package name */
    public static final int[] f10080D = {2, 1, 3, 4};

    /* renamed from: E, reason: collision with root package name */
    public static final C0558b f10081E = new C0558b(9);

    /* renamed from: F, reason: collision with root package name */
    public static final ThreadLocal f10082F = new ThreadLocal();

    /* renamed from: B, reason: collision with root package name */
    public h4.r f10084B;

    /* renamed from: t, reason: collision with root package name */
    public ArrayList f10095t;

    /* renamed from: u, reason: collision with root package name */
    public ArrayList f10096u;

    /* renamed from: j, reason: collision with root package name */
    public final String f10086j = getClass().getName();

    /* renamed from: k, reason: collision with root package name */
    public long f10087k = -1;

    /* renamed from: l, reason: collision with root package name */
    public long f10088l = -1;

    /* renamed from: m, reason: collision with root package name */
    public TimeInterpolator f10089m = null;
    public final ArrayList n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f10090o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public L0.i f10091p = new L0.i(9);

    /* renamed from: q, reason: collision with root package name */
    public L0.i f10092q = new L0.i(9);

    /* renamed from: r, reason: collision with root package name */
    public u f10093r = null;

    /* renamed from: s, reason: collision with root package name */
    public final int[] f10094s = f10080D;

    /* renamed from: v, reason: collision with root package name */
    public final ArrayList f10097v = new ArrayList();

    /* renamed from: w, reason: collision with root package name */
    public int f10098w = 0;

    /* renamed from: x, reason: collision with root package name */
    public boolean f10099x = false;

    /* renamed from: y, reason: collision with root package name */
    public boolean f10100y = false;

    /* renamed from: z, reason: collision with root package name */
    public ArrayList f10101z = null;

    /* renamed from: A, reason: collision with root package name */
    public ArrayList f10083A = new ArrayList();

    /* renamed from: C, reason: collision with root package name */
    public C0558b f10085C = f10081E;

    public static void c(L0.i iVar, View view, v vVar) {
        ((q.b) iVar.f1547c).put(view, vVar);
        int id = view.getId();
        if (id >= 0) {
            SparseArray sparseArray = (SparseArray) iVar.f1548d;
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap weakHashMap = Y.f1904a;
        String strK = M.k(view);
        if (strK != null) {
            q.b bVar = (q.b) iVar.f1550f;
            if (bVar.containsKey(strK)) {
                bVar.put(strK, null);
            } else {
                bVar.put(strK, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                q.e eVar = (q.e) iVar.f1549e;
                if (eVar.f9253j) {
                    eVar.c();
                }
                if (q.d.b(eVar.f9254k, eVar.f9256m, itemIdAtPosition) < 0) {
                    G.r(view, true);
                    eVar.f(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) eVar.d(itemIdAtPosition, null);
                if (view2 != null) {
                    G.r(view2, false);
                    eVar.f(itemIdAtPosition, null);
                }
            }
        }
    }

    public static q.b o() {
        ThreadLocal threadLocal = f10082F;
        q.b bVar = (q.b) threadLocal.get();
        if (bVar != null) {
            return bVar;
        }
        q.b bVar2 = new q.b();
        threadLocal.set(bVar2);
        return bVar2;
    }

    public static boolean t(v vVar, v vVar2, String str) {
        Object obj = vVar.f10113a.get(str);
        Object obj2 = vVar2.f10113a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void A(h4.r rVar) {
        this.f10084B = rVar;
    }

    public void B(TimeInterpolator timeInterpolator) {
        this.f10089m = timeInterpolator;
    }

    public void C(C0558b c0558b) {
        if (c0558b == null) {
            this.f10085C = f10081E;
        } else {
            this.f10085C = c0558b;
        }
    }

    public void D() {
    }

    public void E(long j5) {
        this.f10087k = j5;
    }

    public final void F() {
        if (this.f10098w == 0) {
            ArrayList arrayList = this.f10101z;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f10101z.clone();
                int size = arrayList2.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((o) arrayList2.get(i5)).a();
                }
            }
            this.f10100y = false;
        }
        this.f10098w++;
    }

    public String G(String str) {
        StringBuilder sbB = AbstractC0882e.b(str);
        sbB.append(getClass().getSimpleName());
        sbB.append("@");
        sbB.append(Integer.toHexString(hashCode()));
        sbB.append(": ");
        String string = sbB.toString();
        if (this.f10088l != -1) {
            string = string + "dur(" + this.f10088l + ") ";
        }
        if (this.f10087k != -1) {
            string = string + "dly(" + this.f10087k + ") ";
        }
        if (this.f10089m != null) {
            string = string + "interp(" + this.f10089m + ") ";
        }
        ArrayList arrayList = this.n;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f10090o;
        if (size <= 0 && arrayList2.size() <= 0) {
            return string;
        }
        String strB = com.unified.ur1.SatelliteTracker.h.b(string, "tgts(");
        if (arrayList.size() > 0) {
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                if (i5 > 0) {
                    strB = com.unified.ur1.SatelliteTracker.h.b(strB, ", ");
                }
                StringBuilder sbB2 = AbstractC0882e.b(strB);
                sbB2.append(arrayList.get(i5));
                strB = sbB2.toString();
            }
        }
        if (arrayList2.size() > 0) {
            for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                if (i6 > 0) {
                    strB = com.unified.ur1.SatelliteTracker.h.b(strB, ", ");
                }
                StringBuilder sbB3 = AbstractC0882e.b(strB);
                sbB3.append(arrayList2.get(i6));
                strB = sbB3.toString();
            }
        }
        return com.unified.ur1.SatelliteTracker.h.b(strB, ")");
    }

    public void a(o oVar) {
        if (this.f10101z == null) {
            this.f10101z = new ArrayList();
        }
        this.f10101z.add(oVar);
    }

    public void b(View view) {
        this.f10090o.add(view);
    }

    public abstract void d(v vVar);

    public final void e(View view, boolean z4) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            v vVar = new v(view);
            if (z4) {
                g(vVar);
            } else {
                d(vVar);
            }
            vVar.f10115c.add(this);
            f(vVar);
            if (z4) {
                c(this.f10091p, view, vVar);
            } else {
                c(this.f10092q, view, vVar);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                e(viewGroup.getChildAt(i5), z4);
            }
        }
    }

    public void f(v vVar) {
    }

    public abstract void g(v vVar);

    public final void h(ViewGroup viewGroup, boolean z4) {
        i(z4);
        ArrayList arrayList = this.n;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f10090o;
        if (size <= 0 && arrayList2.size() <= 0) {
            e(viewGroup, z4);
            return;
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            View viewFindViewById = viewGroup.findViewById(((Integer) arrayList.get(i5)).intValue());
            if (viewFindViewById != null) {
                v vVar = new v(viewFindViewById);
                if (z4) {
                    g(vVar);
                } else {
                    d(vVar);
                }
                vVar.f10115c.add(this);
                f(vVar);
                if (z4) {
                    c(this.f10091p, viewFindViewById, vVar);
                } else {
                    c(this.f10092q, viewFindViewById, vVar);
                }
            }
        }
        for (int i6 = 0; i6 < arrayList2.size(); i6++) {
            View view = (View) arrayList2.get(i6);
            v vVar2 = new v(view);
            if (z4) {
                g(vVar2);
            } else {
                d(vVar2);
            }
            vVar2.f10115c.add(this);
            f(vVar2);
            if (z4) {
                c(this.f10091p, view, vVar2);
            } else {
                c(this.f10092q, view, vVar2);
            }
        }
    }

    public final void i(boolean z4) {
        if (z4) {
            ((q.b) this.f10091p.f1547c).clear();
            ((SparseArray) this.f10091p.f1548d).clear();
            ((q.e) this.f10091p.f1549e).a();
        } else {
            ((q.b) this.f10092q.f1547c).clear();
            ((SparseArray) this.f10092q.f1548d).clear();
            ((q.e) this.f10092q.f1549e).a();
        }
    }

    @Override // 
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public p clone() {
        try {
            p pVar = (p) super.clone();
            pVar.f10083A = new ArrayList();
            pVar.f10091p = new L0.i(9);
            pVar.f10092q = new L0.i(9);
            pVar.f10095t = null;
            pVar.f10096u = null;
            return pVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator k(ViewGroup viewGroup, v vVar, v vVar2) {
        return null;
    }

    public void l(ViewGroup viewGroup, L0.i iVar, L0.i iVar2, ArrayList arrayList, ArrayList arrayList2) {
        Animator animatorK;
        int i5;
        View view;
        v vVar;
        Animator animator;
        q.b bVarO = o();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            v vVar2 = (v) arrayList.get(i6);
            v vVar3 = (v) arrayList2.get(i6);
            v vVar4 = null;
            if (vVar2 != null && !vVar2.f10115c.contains(this)) {
                vVar2 = null;
            }
            if (vVar3 != null && !vVar3.f10115c.contains(this)) {
                vVar3 = null;
            }
            if (!(vVar2 == null && vVar3 == null) && ((vVar2 == null || vVar3 == null || r(vVar2, vVar3)) && (animatorK = k(viewGroup, vVar2, vVar3)) != null)) {
                String str = this.f10086j;
                if (vVar3 != null) {
                    String[] strArrP = p();
                    view = vVar3.f10114b;
                    if (strArrP != null && strArrP.length > 0) {
                        vVar = new v(view);
                        v vVar5 = (v) ((q.b) iVar2.f1547c).getOrDefault(view, null);
                        i5 = size;
                        if (vVar5 != null) {
                            int i7 = 0;
                            while (i7 < strArrP.length) {
                                HashMap map = vVar.f10113a;
                                String str2 = strArrP[i7];
                                map.put(str2, vVar5.f10113a.get(str2));
                                i7++;
                                strArrP = strArrP;
                            }
                        }
                        int i8 = bVarO.f9278l;
                        for (int i9 = 0; i9 < i8; i9++) {
                            animator = null;
                            n nVar = (n) bVarO.getOrDefault((Animator) bVarO.h(i9), null);
                            if (nVar.f10077c != null && nVar.f10075a == view && nVar.f10076b.equals(str) && nVar.f10077c.equals(vVar)) {
                                break;
                            }
                        }
                    } else {
                        i5 = size;
                        vVar = null;
                    }
                    animator = animatorK;
                    animatorK = animator;
                    vVar4 = vVar;
                } else {
                    i5 = size;
                    view = vVar2.f10114b;
                }
                if (animatorK != null) {
                    x xVar = w.f10116a;
                    C0926C c0926c = new C0926C(viewGroup);
                    n nVar2 = new n();
                    nVar2.f10075a = view;
                    nVar2.f10076b = str;
                    nVar2.f10077c = vVar4;
                    nVar2.f10078d = c0926c;
                    nVar2.f10079e = this;
                    bVarO.put(animatorK, nVar2);
                    this.f10083A.add(animatorK);
                }
            } else {
                i5 = size;
            }
            i6++;
            size = i5;
        }
        if (sparseIntArray.size() != 0) {
            for (int i10 = 0; i10 < sparseIntArray.size(); i10++) {
                Animator animator2 = (Animator) this.f10083A.get(sparseIntArray.keyAt(i10));
                animator2.setStartDelay(animator2.getStartDelay() + (sparseIntArray.valueAt(i10) - Long.MAX_VALUE));
            }
        }
    }

    public final void m() {
        int i5 = this.f10098w - 1;
        this.f10098w = i5;
        if (i5 == 0) {
            ArrayList arrayList = this.f10101z;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f10101z.clone();
                int size = arrayList2.size();
                for (int i6 = 0; i6 < size; i6++) {
                    ((o) arrayList2.get(i6)).e(this);
                }
            }
            for (int i7 = 0; i7 < ((q.e) this.f10091p.f1549e).h(); i7++) {
                View view = (View) ((q.e) this.f10091p.f1549e).i(i7);
                if (view != null) {
                    WeakHashMap weakHashMap = Y.f1904a;
                    G.r(view, false);
                }
            }
            for (int i8 = 0; i8 < ((q.e) this.f10092q.f1549e).h(); i8++) {
                View view2 = (View) ((q.e) this.f10092q.f1549e).i(i8);
                if (view2 != null) {
                    WeakHashMap weakHashMap2 = Y.f1904a;
                    G.r(view2, false);
                }
            }
            this.f10100y = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if (r3 < 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        r6 = r5.f10096u;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r6 = r5.f10095t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        return (w0.v) r6.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final w0.v n(android.view.View r6, boolean r7) {
        /*
            r5 = this;
            w0.u r0 = r5.f10093r
            if (r0 == 0) goto L9
            w0.v r6 = r0.n(r6, r7)
            return r6
        L9:
            if (r7 == 0) goto Le
            java.util.ArrayList r0 = r5.f10095t
            goto L10
        Le:
            java.util.ArrayList r0 = r5.f10096u
        L10:
            r1 = 0
            if (r0 != 0) goto L14
            return r1
        L14:
            int r2 = r0.size()
            r3 = 0
        L19:
            if (r3 >= r2) goto L2c
            java.lang.Object r4 = r0.get(r3)
            w0.v r4 = (w0.v) r4
            if (r4 != 0) goto L24
            return r1
        L24:
            android.view.View r4 = r4.f10114b
            if (r4 != r6) goto L29
            goto L2d
        L29:
            int r3 = r3 + 1
            goto L19
        L2c:
            r3 = -1
        L2d:
            if (r3 < 0) goto L3d
            if (r7 == 0) goto L34
            java.util.ArrayList r6 = r5.f10096u
            goto L36
        L34:
            java.util.ArrayList r6 = r5.f10095t
        L36:
            java.lang.Object r6 = r6.get(r3)
            r1 = r6
            w0.v r1 = (w0.v) r1
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.p.n(android.view.View, boolean):w0.v");
    }

    public String[] p() {
        return null;
    }

    public final v q(View view, boolean z4) {
        u uVar = this.f10093r;
        if (uVar != null) {
            return uVar.q(view, z4);
        }
        return (v) ((q.b) (z4 ? this.f10091p : this.f10092q).f1547c).getOrDefault(view, null);
    }

    public boolean r(v vVar, v vVar2) {
        if (vVar == null || vVar2 == null) {
            return false;
        }
        String[] strArrP = p();
        if (strArrP == null) {
            Iterator it = vVar.f10113a.keySet().iterator();
            while (it.hasNext()) {
                if (t(vVar, vVar2, (String) it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrP) {
            if (!t(vVar, vVar2, str)) {
            }
        }
        return false;
        return true;
    }

    public final boolean s(View view) {
        int id = view.getId();
        ArrayList arrayList = this.n;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f10090o;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view);
    }

    public final String toString() {
        return G("");
    }

    public void u(View view) {
        if (this.f10100y) {
            return;
        }
        q.b bVarO = o();
        int i5 = bVarO.f9278l;
        x xVar = w.f10116a;
        WindowId windowId = view.getWindowId();
        for (int i6 = i5 - 1; i6 >= 0; i6--) {
            n nVar = (n) bVarO.j(i6);
            if (nVar.f10075a != null) {
                C0926C c0926c = nVar.f10078d;
                if ((c0926c instanceof C0926C) && c0926c.f10045a.equals(windowId)) {
                    ((Animator) bVarO.h(i6)).pause();
                }
            }
        }
        ArrayList arrayList = this.f10101z;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.f10101z.clone();
            int size = arrayList2.size();
            for (int i7 = 0; i7 < size; i7++) {
                ((o) arrayList2.get(i7)).b();
            }
        }
        this.f10099x = true;
    }

    public void v(o oVar) {
        ArrayList arrayList = this.f10101z;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(oVar);
        if (this.f10101z.size() == 0) {
            this.f10101z = null;
        }
    }

    public void w(View view) {
        this.f10090o.remove(view);
    }

    public void x(View view) {
        if (this.f10099x) {
            if (!this.f10100y) {
                q.b bVarO = o();
                int i5 = bVarO.f9278l;
                x xVar = w.f10116a;
                WindowId windowId = view.getWindowId();
                for (int i6 = i5 - 1; i6 >= 0; i6--) {
                    n nVar = (n) bVarO.j(i6);
                    if (nVar.f10075a != null) {
                        C0926C c0926c = nVar.f10078d;
                        if ((c0926c instanceof C0926C) && c0926c.f10045a.equals(windowId)) {
                            ((Animator) bVarO.h(i6)).resume();
                        }
                    }
                }
                ArrayList arrayList = this.f10101z;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.f10101z.clone();
                    int size = arrayList2.size();
                    for (int i7 = 0; i7 < size; i7++) {
                        ((o) arrayList2.get(i7)).c();
                    }
                }
            }
            this.f10099x = false;
        }
    }

    public void y() {
        F();
        q.b bVarO = o();
        Iterator it = this.f10083A.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (bVarO.containsKey(animator)) {
                F();
                if (animator != null) {
                    animator.addListener(new C0165g0(this, bVarO));
                    long j5 = this.f10088l;
                    if (j5 >= 0) {
                        animator.setDuration(j5);
                    }
                    long j6 = this.f10087k;
                    if (j6 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j6);
                    }
                    TimeInterpolator timeInterpolator = this.f10089m;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new S1.a(6, this));
                    animator.start();
                }
            }
        }
        this.f10083A.clear();
        m();
    }

    public void z(long j5) {
        this.f10088l = j5;
    }
}
