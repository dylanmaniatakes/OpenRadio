package androidx.fragment.app;

import O.AbstractC0155b0;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.unified.ur1.R;
import g0.AbstractC0535a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.WeakHashMap;

/* renamed from: androidx.fragment.app.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0215j {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f3820a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3821b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f3822c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public boolean f3823d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3824e = false;

    public C0215j(ViewGroup viewGroup) {
        this.f3820a = viewGroup;
    }

    public static void a(View view, ArrayList arrayList) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (AbstractC0155b0.b(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if (childAt.getVisibility() == 0) {
                a(childAt, arrayList);
            }
        }
    }

    public static void e(q.b bVar, View view) {
        WeakHashMap weakHashMap = O.Y.f1904a;
        String strK = O.M.k(view);
        if (strK != null) {
            bVar.put(strK, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = viewGroup.getChildAt(i5);
                if (childAt.getVisibility() == 0) {
                    e(bVar, childAt);
                }
            }
        }
    }

    public static C0215j h(ViewGroup viewGroup, J1.D d5) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof C0215j) {
            return (C0215j) tag;
        }
        d5.getClass();
        C0215j c0215j = new C0215j(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, c0215j);
        return c0215j;
    }

    public static C0215j i(ViewGroup viewGroup, T t4) {
        return h(viewGroup, t4.A());
    }

    public static void k(q.b bVar, Collection collection) {
        Iterator it = ((q.h) bVar.entrySet()).iterator();
        while (true) {
            q.i iVar = (q.i) it;
            if (!iVar.hasNext()) {
                return;
            }
            iVar.next();
            View view = (View) iVar.getValue();
            WeakHashMap weakHashMap = O.Y.f1904a;
            if (!collection.contains(O.M.k(view))) {
                iVar.remove();
            }
        }
    }

    public final void b(int i5, int i6, b0 b0Var) {
        synchronized (this.f3821b) {
            try {
                K.d dVar = new K.d();
                p0 p0VarF = f(b0Var.f3773c);
                if (p0VarF != null) {
                    p0VarF.c(i5, i6);
                    return;
                }
                p0 p0Var = new p0(i5, i6, b0Var, dVar);
                this.f3821b.add(p0Var);
                p0Var.f3861d.add(new o0(this, p0Var, 0));
                p0Var.f3861d.add(new o0(this, p0Var, 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x05e6  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x067a A[LOOP:6: B:233:0x0674->B:235:0x067a, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.util.ArrayList r35, boolean r36) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0215j.c(java.util.ArrayList, boolean):void");
    }

    public final void d() {
        if (this.f3824e) {
            return;
        }
        ViewGroup viewGroup = this.f3820a;
        WeakHashMap weakHashMap = O.Y.f1904a;
        if (!O.J.b(viewGroup)) {
            g();
            this.f3823d = false;
            return;
        }
        synchronized (this.f3821b) {
            try {
                if (!this.f3821b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f3822c);
                    this.f3822c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        p0 p0Var = (p0) it.next();
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + p0Var);
                        }
                        p0Var.a();
                        if (!p0Var.g) {
                            this.f3822c.add(p0Var);
                        }
                    }
                    l();
                    ArrayList arrayList2 = new ArrayList(this.f3821b);
                    this.f3821b.clear();
                    this.f3822c.addAll(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((p0) it2.next()).d();
                    }
                    c(arrayList2, this.f3823d);
                    this.f3823d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final p0 f(Fragment fragment) {
        Iterator it = this.f3821b.iterator();
        while (it.hasNext()) {
            p0 p0Var = (p0) it.next();
            if (p0Var.f3860c.equals(fragment) && !p0Var.f3863f) {
                return p0Var;
            }
        }
        return null;
    }

    public final void g() {
        String str;
        String str2;
        ViewGroup viewGroup = this.f3820a;
        WeakHashMap weakHashMap = O.Y.f1904a;
        boolean zB = O.J.b(viewGroup);
        synchronized (this.f3821b) {
            try {
                l();
                Iterator it = this.f3821b.iterator();
                while (it.hasNext()) {
                    ((p0) it.next()).d();
                }
                Iterator it2 = new ArrayList(this.f3822c).iterator();
                while (it2.hasNext()) {
                    p0 p0Var = (p0) it2.next();
                    if (Log.isLoggable("FragmentManager", 2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        if (zB) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f3820a + " is not attached to window. ";
                        }
                        sb.append(str2);
                        sb.append("Cancelling running operation ");
                        sb.append(p0Var);
                        Log.v("FragmentManager", sb.toString());
                    }
                    p0Var.a();
                }
                Iterator it3 = new ArrayList(this.f3821b).iterator();
                while (it3.hasNext()) {
                    p0 p0Var2 = (p0) it3.next();
                    if (Log.isLoggable("FragmentManager", 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (zB) {
                            str = "";
                        } else {
                            str = "Container " + this.f3820a + " is not attached to window. ";
                        }
                        sb2.append(str);
                        sb2.append("Cancelling pending operation ");
                        sb2.append(p0Var2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    p0Var2.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j() {
        synchronized (this.f3821b) {
            try {
                l();
                this.f3824e = false;
                int size = this.f3821b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    p0 p0Var = (p0) this.f3821b.get(size);
                    int iC = AbstractC0535a.c(p0Var.f3860c.mView);
                    if (p0Var.f3858a == 2 && iC != 2) {
                        this.f3824e = p0Var.f3860c.isPostponed();
                        break;
                    }
                    size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l() {
        Iterator it = this.f3821b.iterator();
        while (it.hasNext()) {
            p0 p0Var = (p0) it.next();
            if (p0Var.f3859b == 2) {
                p0Var.c(AbstractC0535a.b(p0Var.f3860c.requireView().getVisibility()), 1);
            }
        }
    }
}
