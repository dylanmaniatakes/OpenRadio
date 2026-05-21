package i2;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MenuItem;
import g2.C0542f;
import j.F;
import j.m;
import j.o;
import j.z;
import w0.C0927a;
import w0.t;

/* loaded from: classes.dex */
public final class g implements z {

    /* renamed from: c, reason: collision with root package name */
    public e f7259c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7260d;

    /* renamed from: e, reason: collision with root package name */
    public int f7261e;

    @Override // j.z
    public final void a(m mVar, boolean z4) {
    }

    @Override // j.z
    public final boolean d(o oVar) {
        return false;
    }

    @Override // j.z
    public final void e(Parcelable parcelable) {
        SparseArray sparseArray;
        if (parcelable instanceof f) {
            e eVar = this.f7259c;
            f fVar = (f) parcelable;
            int i5 = fVar.f7257j;
            int size = eVar.f7235G.f7459f.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    break;
                }
                MenuItem item = eVar.f7235G.getItem(i6);
                if (i5 == item.getItemId()) {
                    eVar.f7240i = i5;
                    eVar.f7241j = i6;
                    item.setChecked(true);
                    break;
                }
                i6++;
            }
            Context context = this.f7259c.getContext();
            C0542f c0542f = fVar.f7258k;
            SparseArray sparseArray2 = new SparseArray(c0542f.size());
            for (int i7 = 0; i7 < c0542f.size(); i7++) {
                int iKeyAt = c0542f.keyAt(i7);
                R1.b bVar = (R1.b) c0542f.valueAt(i7);
                sparseArray2.put(iKeyAt, bVar != null ? new R1.a(context, bVar) : null);
            }
            e eVar2 = this.f7259c;
            eVar2.getClass();
            int i8 = 0;
            while (true) {
                int size2 = sparseArray2.size();
                sparseArray = eVar2.f7251u;
                if (i8 >= size2) {
                    break;
                }
                int iKeyAt2 = sparseArray2.keyAt(i8);
                if (sparseArray.indexOfKey(iKeyAt2) < 0) {
                    sparseArray.append(iKeyAt2, (R1.a) sparseArray2.get(iKeyAt2));
                }
                i8++;
            }
            c[] cVarArr = eVar2.h;
            if (cVarArr != null) {
                for (c cVar : cVarArr) {
                    R1.a aVar = (R1.a) sparseArray.get(cVar.getId());
                    if (aVar != null) {
                        cVar.setBadge(aVar);
                    }
                }
            }
        }
    }

    @Override // j.z
    public final void g(boolean z4) {
        C0927a c0927a;
        if (this.f7260d) {
            return;
        }
        if (z4) {
            this.f7259c.b();
            return;
        }
        e eVar = this.f7259c;
        m mVar = eVar.f7235G;
        if (mVar == null || eVar.h == null) {
            return;
        }
        int size = mVar.f7459f.size();
        if (size != eVar.h.length) {
            eVar.b();
            return;
        }
        int i5 = eVar.f7240i;
        for (int i6 = 0; i6 < size; i6++) {
            MenuItem item = eVar.f7235G.getItem(i6);
            if (item.isChecked()) {
                eVar.f7240i = item.getItemId();
                eVar.f7241j = i6;
            }
        }
        if (i5 != eVar.f7240i && (c0927a = eVar.f7236c) != null) {
            t.a(eVar, c0927a);
        }
        int i7 = eVar.g;
        boolean z5 = i7 != -1 ? i7 == 0 : eVar.f7235G.l().size() > 3;
        for (int i8 = 0; i8 < size; i8++) {
            eVar.f7234F.f7260d = true;
            eVar.h[i8].setLabelVisibilityMode(eVar.g);
            eVar.h[i8].setShifting(z5);
            eVar.h[i8].c((o) eVar.f7235G.getItem(i8));
            eVar.f7234F.f7260d = false;
        }
    }

    @Override // j.z
    public final int getId() {
        return this.f7261e;
    }

    @Override // j.z
    public final void h(Context context, m mVar) {
        this.f7259c.f7235G = mVar;
    }

    @Override // j.z
    public final boolean i() {
        return false;
    }

    @Override // j.z
    public final Parcelable j() {
        f fVar = new f();
        fVar.f7257j = this.f7259c.getSelectedItemId();
        SparseArray<R1.a> badgeDrawables = this.f7259c.getBadgeDrawables();
        C0542f c0542f = new C0542f();
        for (int i5 = 0; i5 < badgeDrawables.size(); i5++) {
            int iKeyAt = badgeDrawables.keyAt(i5);
            R1.a aVarValueAt = badgeDrawables.valueAt(i5);
            c0542f.put(iKeyAt, aVarValueAt != null ? aVarValueAt.g.f2267a : null);
        }
        fVar.f7258k = c0542f;
        return fVar;
    }

    @Override // j.z
    public final boolean k(o oVar) {
        return false;
    }

    @Override // j.z
    public final boolean m(F f5) {
        return false;
    }
}
