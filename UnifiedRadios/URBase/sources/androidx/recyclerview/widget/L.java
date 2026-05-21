package androidx.recyclerview.widget;

import O.C0182v;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class L {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f4048a;

    public /* synthetic */ L(RecyclerView recyclerView) {
        this.f4048a = recyclerView;
    }

    public void a(C0254a c0254a) {
        int i5 = c0254a.f4194a;
        RecyclerView recyclerView = this.f4048a;
        if (i5 == 1) {
            recyclerView.f4125p.W(c0254a.f4195b, c0254a.f4197d);
            return;
        }
        if (i5 == 2) {
            recyclerView.f4125p.Z(c0254a.f4195b, c0254a.f4197d);
        } else if (i5 == 4) {
            recyclerView.f4125p.a0(c0254a.f4195b, c0254a.f4197d);
        } else {
            if (i5 != 8) {
                return;
            }
            recyclerView.f4125p.Y(c0254a.f4195b, c0254a.f4197d);
        }
    }

    public n0 b(int i5) {
        RecyclerView recyclerView = this.f4048a;
        int iL = recyclerView.h.l();
        int i6 = 0;
        n0 n0Var = null;
        while (true) {
            if (i6 >= iL) {
                break;
            }
            n0 n0VarM = RecyclerView.M(recyclerView.h.k(i6));
            if (n0VarM != null && !n0VarM.isRemoved() && n0VarM.mPosition == i5) {
                if (!recyclerView.h.o(n0VarM.itemView)) {
                    n0Var = n0VarM;
                    break;
                }
                n0Var = n0VarM;
            }
            i6++;
        }
        if (n0Var == null) {
            return null;
        }
        if (!recyclerView.h.o(n0Var.itemView)) {
            return n0Var;
        }
        if (RecyclerView.f4067D0) {
            Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
        }
        return null;
    }

    public void c(int i5, int i6, Object obj) {
        int i7;
        int i8;
        RecyclerView recyclerView = this.f4048a;
        int iL = recyclerView.h.l();
        int i9 = i6 + i5;
        for (int i10 = 0; i10 < iL; i10++) {
            View viewK = recyclerView.h.k(i10);
            n0 n0VarM = RecyclerView.M(viewK);
            if (n0VarM != null && !n0VarM.shouldIgnore() && (i8 = n0VarM.mPosition) >= i5 && i8 < i9) {
                n0VarM.addFlags(2);
                n0VarM.addChangePayload(obj);
                ((Y) viewK.getLayoutParams()).f4192c = true;
            }
        }
        d0 d0Var = recyclerView.f4106e;
        ArrayList arrayList = d0Var.f4219c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            n0 n0Var = (n0) arrayList.get(size);
            if (n0Var != null && (i7 = n0Var.mPosition) >= i5 && i7 < i9) {
                n0Var.addFlags(2);
                d0Var.g(size);
            }
        }
        recyclerView.f4122n0 = true;
    }

    public void d(int i5, int i6) {
        RecyclerView recyclerView = this.f4048a;
        int iL = recyclerView.h.l();
        for (int i7 = 0; i7 < iL; i7++) {
            n0 n0VarM = RecyclerView.M(recyclerView.h.k(i7));
            if (n0VarM != null && !n0VarM.shouldIgnore() && n0VarM.mPosition >= i5) {
                if (RecyclerView.f4067D0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert attached child " + i7 + " holder " + n0VarM + " now at position " + (n0VarM.mPosition + i6));
                }
                n0VarM.offsetPosition(i6, false);
                recyclerView.f4115j0.f4268f = true;
            }
        }
        ArrayList arrayList = recyclerView.f4106e.f4219c;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            n0 n0Var = (n0) arrayList.get(i8);
            if (n0Var != null && n0Var.mPosition >= i5) {
                if (RecyclerView.f4067D0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert cached " + i8 + " holder " + n0Var + " now at position " + (n0Var.mPosition + i6));
                }
                n0Var.offsetPosition(i6, false);
            }
        }
        recyclerView.requestLayout();
        recyclerView.f4121m0 = true;
    }

    public void e(int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        RecyclerView recyclerView = this.f4048a;
        int iL = recyclerView.h.l();
        if (i5 < i6) {
            i8 = i5;
            i7 = i6;
            i9 = -1;
        } else {
            i7 = i5;
            i8 = i6;
            i9 = 1;
        }
        boolean z4 = false;
        for (int i15 = 0; i15 < iL; i15++) {
            n0 n0VarM = RecyclerView.M(recyclerView.h.k(i15));
            if (n0VarM != null && (i14 = n0VarM.mPosition) >= i8 && i14 <= i7) {
                if (RecyclerView.f4067D0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove attached child " + i15 + " holder " + n0VarM);
                }
                if (n0VarM.mPosition == i5) {
                    n0VarM.offsetPosition(i6 - i5, false);
                } else {
                    n0VarM.offsetPosition(i9, false);
                }
                recyclerView.f4115j0.f4268f = true;
            }
        }
        d0 d0Var = recyclerView.f4106e;
        d0Var.getClass();
        if (i5 < i6) {
            i11 = i5;
            i10 = i6;
            i12 = -1;
        } else {
            i10 = i5;
            i11 = i6;
            i12 = 1;
        }
        ArrayList arrayList = d0Var.f4219c;
        int size = arrayList.size();
        int i16 = 0;
        while (i16 < size) {
            n0 n0Var = (n0) arrayList.get(i16);
            if (n0Var != null && (i13 = n0Var.mPosition) >= i11 && i13 <= i10) {
                if (i13 == i5) {
                    n0Var.offsetPosition(i6 - i5, z4);
                } else {
                    n0Var.offsetPosition(i12, z4);
                }
                if (RecyclerView.f4067D0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove cached child " + i16 + " holder " + n0Var);
                }
            }
            i16++;
            z4 = false;
        }
        recyclerView.requestLayout();
        recyclerView.f4121m0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(androidx.recyclerview.widget.n0 r9, O.C0182v r10, O.C0182v r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r8.f4048a
            r0.getClass()
            r1 = 0
            r9.setIsRecyclable(r1)
            androidx.recyclerview.widget.T r1 = r0.f4091O
            r2 = r1
            androidx.recyclerview.widget.l r2 = (androidx.recyclerview.widget.C0265l) r2
            if (r10 == 0) goto L29
            r2.getClass()
            int r4 = r10.f1974a
            int r6 = r11.f1974a
            if (r4 != r6) goto L1f
            int r1 = r10.f1975b
            int r3 = r11.f1975b
            if (r1 == r3) goto L29
        L1f:
            int r5 = r10.f1975b
            int r7 = r11.f1975b
            r3 = r9
            boolean r9 = r2.h(r3, r4, r5, r6, r7)
            goto L38
        L29:
            r2.m(r9)
            android.view.View r10 = r9.itemView
            r11 = 0
            r10.setAlpha(r11)
            java.util.ArrayList r10 = r2.f4280i
            r10.add(r9)
            r9 = 1
        L38:
            if (r9 == 0) goto L3d
            r0.W()
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.L.f(androidx.recyclerview.widget.n0, O.v, O.v):void");
    }

    public void g(n0 n0Var, C0182v c0182v, C0182v c0182v2) {
        boolean zH;
        RecyclerView recyclerView = this.f4048a;
        recyclerView.f4106e.l(n0Var);
        recyclerView.h(n0Var);
        n0Var.setIsRecyclable(false);
        C0265l c0265l = (C0265l) recyclerView.f4091O;
        c0265l.getClass();
        int i5 = c0182v.f1974a;
        int i6 = c0182v.f1975b;
        View view = n0Var.itemView;
        int left = c0182v2 == null ? view.getLeft() : c0182v2.f1974a;
        int top = c0182v2 == null ? view.getTop() : c0182v2.f1975b;
        if (n0Var.isRemoved() || (i5 == left && i6 == top)) {
            c0265l.m(n0Var);
            c0265l.h.add(n0Var);
            zH = true;
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            zH = c0265l.h(n0Var, i5, i6, left, top);
        }
        if (zH) {
            recyclerView.W();
        }
    }

    public void h(int i5) {
        RecyclerView recyclerView = this.f4048a;
        View childAt = recyclerView.getChildAt(i5);
        if (childAt != null) {
            recyclerView.r(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i5);
    }
}
