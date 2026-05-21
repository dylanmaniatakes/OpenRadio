package androidx.emoji2.text;

import android.util.SparseArray;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f3633a;

    /* renamed from: b, reason: collision with root package name */
    public l f3634b;

    public p(int i5) {
        this.f3633a = new SparseArray(i5);
    }

    public final void a(l lVar, int i5, int i6) {
        int iA = lVar.a(i5);
        SparseArray sparseArray = this.f3633a;
        p pVar = sparseArray == null ? null : (p) sparseArray.get(iA);
        if (pVar == null) {
            pVar = new p(1);
            sparseArray.put(lVar.a(i5), pVar);
        }
        if (i6 > i5) {
            pVar.a(lVar, i5 + 1, i6);
        } else {
            pVar.f3634b = lVar;
        }
    }
}
