package androidx.recyclerview.widget;

import O.C0156c;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import g0.AbstractC0535a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4217a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f4218b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f4219c;

    /* renamed from: d, reason: collision with root package name */
    public final List f4220d;

    /* renamed from: e, reason: collision with root package name */
    public int f4221e;

    /* renamed from: f, reason: collision with root package name */
    public int f4222f;
    public c0 g;
    public final /* synthetic */ RecyclerView h;

    public d0(RecyclerView recyclerView) {
        this.h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.f4217a = arrayList;
        this.f4218b = null;
        this.f4219c = new ArrayList();
        this.f4220d = Collections.unmodifiableList(arrayList);
        this.f4221e = 2;
        this.f4222f = 2;
    }

    public final void a(n0 n0Var, boolean z4) {
        RecyclerView.l(n0Var);
        View view = n0Var.itemView;
        RecyclerView recyclerView = this.h;
        p0 p0Var = recyclerView.f4128q0;
        if (p0Var != null) {
            o0 o0Var = p0Var.f4310e;
            O.Y.k(view, o0Var instanceof o0 ? (C0156c) o0Var.f4305e.remove(view) : null);
        }
        if (z4) {
            ArrayList arrayList = recyclerView.f4127q;
            if (arrayList.size() > 0) {
                com.unified.ur1.SatelliteTracker.h.p(arrayList.get(0));
                throw null;
            }
            N n = recyclerView.f4123o;
            if (n != null) {
                n.onViewRecycled(n0Var);
            }
            if (recyclerView.f4115j0 != null) {
                recyclerView.f4112i.t(n0Var);
            }
            if (RecyclerView.f4067D0) {
                Log.d("RecyclerView", "dispatchViewRecycled: " + n0Var);
            }
        }
        n0Var.mBindingAdapter = null;
        n0Var.mOwnerRecyclerView = null;
        c0 c0VarC = c();
        c0VarC.getClass();
        int itemViewType = n0Var.getItemViewType();
        ArrayList arrayList2 = c0VarC.a(itemViewType).f4204a;
        if (((b0) c0VarC.f4209a.get(itemViewType)).f4205b <= arrayList2.size()) {
            AbstractC0930a.d(n0Var.itemView);
        } else {
            if (RecyclerView.f4066C0 && arrayList2.contains(n0Var)) {
                throw new IllegalArgumentException("this scrap item already exists");
            }
            n0Var.resetInternal();
            arrayList2.add(n0Var);
        }
    }

    public final int b(int i5) {
        RecyclerView recyclerView = this.h;
        if (i5 >= 0 && i5 < recyclerView.f4115j0.b()) {
            return !recyclerView.f4115j0.g ? i5 : recyclerView.g.g(i5, 0);
        }
        StringBuilder sbF = com.unified.ur1.SatelliteTracker.h.f("invalid position ", i5, ". State item count is ");
        sbF.append(recyclerView.f4115j0.b());
        sbF.append(recyclerView.C());
        throw new IndexOutOfBoundsException(sbF.toString());
    }

    public final c0 c() {
        if (this.g == null) {
            c0 c0Var = new c0();
            c0Var.f4209a = new SparseArray();
            c0Var.f4210b = 0;
            c0Var.f4211c = Collections.newSetFromMap(new IdentityHashMap());
            this.g = c0Var;
            d();
        }
        return this.g;
    }

    public final void d() {
        RecyclerView recyclerView;
        N n;
        c0 c0Var = this.g;
        if (c0Var == null || (n = (recyclerView = this.h).f4123o) == null || !recyclerView.f4135u) {
            return;
        }
        c0Var.f4211c.add(n);
    }

    public final void e(N n, boolean z4) {
        c0 c0Var = this.g;
        if (c0Var == null) {
            return;
        }
        Set set = c0Var.f4211c;
        set.remove(n);
        if (set.size() != 0 || z4) {
            return;
        }
        int i5 = 0;
        while (true) {
            SparseArray sparseArray = c0Var.f4209a;
            if (i5 >= sparseArray.size()) {
                return;
            }
            ArrayList arrayList = ((b0) sparseArray.get(sparseArray.keyAt(i5))).f4204a;
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                AbstractC0930a.d(((n0) arrayList.get(i6)).itemView);
            }
            i5++;
        }
    }

    public final void f() {
        ArrayList arrayList = this.f4219c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            g(size);
        }
        arrayList.clear();
        if (RecyclerView.f4072I0) {
            Q1.b bVar = this.h.f4113i0;
            int[] iArr = (int[]) bVar.f2171d;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            bVar.f2170c = 0;
        }
    }

    public final void g(int i5) {
        if (RecyclerView.f4067D0) {
            AbstractC0535a.u("Recycling cached view at index ", i5, "RecyclerView");
        }
        ArrayList arrayList = this.f4219c;
        n0 n0Var = (n0) arrayList.get(i5);
        if (RecyclerView.f4067D0) {
            Log.d("RecyclerView", "CachedViewHolder to be recycled: " + n0Var);
        }
        a(n0Var, true);
        arrayList.remove(i5);
    }

    public final void h(View view) {
        n0 n0VarM = RecyclerView.M(view);
        boolean zIsTmpDetached = n0VarM.isTmpDetached();
        RecyclerView recyclerView = this.h;
        if (zIsTmpDetached) {
            recyclerView.removeDetachedView(view, false);
        }
        if (n0VarM.isScrap()) {
            n0VarM.unScrap();
        } else if (n0VarM.wasReturnedFromScrap()) {
            n0VarM.clearReturnedFromScrapFlag();
        }
        i(n0VarM);
        if (recyclerView.f4091O == null || n0VarM.isRecyclable()) {
            return;
        }
        recyclerView.f4091O.e(n0VarM);
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00dc, code lost:
    
        r4 = r4 - 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(androidx.recyclerview.widget.n0 r12) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.d0.i(androidx.recyclerview.widget.n0):void");
    }

    public final void j(View view) {
        T t4;
        n0 n0VarM = RecyclerView.M(view);
        boolean zHasAnyOfTheFlags = n0VarM.hasAnyOfTheFlags(12);
        RecyclerView recyclerView = this.h;
        if (!zHasAnyOfTheFlags && n0VarM.isUpdated() && (t4 = recyclerView.f4091O) != null) {
            C0265l c0265l = (C0265l) t4;
            if (n0VarM.getUnmodifiedPayloads().isEmpty() && c0265l.g && !n0VarM.isInvalid()) {
                if (this.f4218b == null) {
                    this.f4218b = new ArrayList();
                }
                n0VarM.setScrapContainer(this, true);
                this.f4218b.add(n0VarM);
                return;
            }
        }
        if (n0VarM.isInvalid() && !n0VarM.isRemoved() && !recyclerView.f4123o.hasStableIds()) {
            throw new IllegalArgumentException(AbstractC0535a.i(recyclerView, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
        }
        n0VarM.setScrapContainer(this, false);
        this.f4217a.add(n0VarM);
    }

    /* JADX WARN: Removed duplicated region for block: B:188:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x054e  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0569  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.recyclerview.widget.n0 k(int r28, long r29) {
        /*
            Method dump skipped, instructions count: 1438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.d0.k(int, long):androidx.recyclerview.widget.n0");
    }

    public final void l(n0 n0Var) {
        if (n0Var.mInChangeScrap) {
            this.f4218b.remove(n0Var);
        } else {
            this.f4217a.remove(n0Var);
        }
        n0Var.mScrapContainer = null;
        n0Var.mInChangeScrap = false;
        n0Var.clearReturnedFromScrapFlag();
    }

    public final void m() {
        X x4 = this.h.f4125p;
        this.f4222f = this.f4221e + (x4 != null ? x4.f4185j : 0);
        ArrayList arrayList = this.f4219c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f4222f; size--) {
            g(size);
        }
    }
}
