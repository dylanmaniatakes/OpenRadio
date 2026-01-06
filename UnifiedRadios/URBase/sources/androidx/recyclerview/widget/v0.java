package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class v0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4349a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public int f4350b = Integer.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public int f4351c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public int f4352d = 0;

    /* renamed from: e, reason: collision with root package name */
    public final int f4353e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f4354f;

    public v0(StaggeredGridLayoutManager staggeredGridLayoutManager, int i5) {
        this.f4354f = staggeredGridLayoutManager;
        this.f4353e = i5;
    }

    public final void a() {
        View view = (View) this.f4349a.get(r0.size() - 1);
        s0 s0Var = (s0) view.getLayoutParams();
        this.f4351c = this.f4354f.f4157r.b(view);
        s0Var.getClass();
    }

    public final void b() {
        this.f4349a.clear();
        this.f4350b = Integer.MIN_VALUE;
        this.f4351c = Integer.MIN_VALUE;
        this.f4352d = 0;
    }

    public final int c() {
        return this.f4354f.f4162w ? e(r1.size() - 1, -1) : e(0, this.f4349a.size());
    }

    public final int d() {
        return this.f4354f.f4162w ? e(0, this.f4349a.size()) : e(r1.size() - 1, -1);
    }

    public final int e(int i5, int i6) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f4354f;
        int iK = staggeredGridLayoutManager.f4157r.k();
        int iG = staggeredGridLayoutManager.f4157r.g();
        int i7 = i6 > i5 ? 1 : -1;
        while (i5 != i6) {
            View view = (View) this.f4349a.get(i5);
            int iE = staggeredGridLayoutManager.f4157r.e(view);
            int iB = staggeredGridLayoutManager.f4157r.b(view);
            boolean z4 = iE <= iG;
            boolean z5 = iB >= iK;
            if (z4 && z5 && (iE < iK || iB > iG)) {
                return X.F(view);
            }
            i5 += i7;
        }
        return -1;
    }

    public final int f(int i5) {
        int i6 = this.f4351c;
        if (i6 != Integer.MIN_VALUE) {
            return i6;
        }
        if (this.f4349a.size() == 0) {
            return i5;
        }
        a();
        return this.f4351c;
    }

    public final View g(int i5, int i6) {
        ArrayList arrayList = this.f4349a;
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f4354f;
        View view = null;
        if (i6 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.f4162w && X.F(view2) >= i5) || ((!staggeredGridLayoutManager.f4162w && X.F(view2) <= i5) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
        } else {
            int size2 = arrayList.size();
            int i7 = 0;
            while (i7 < size2) {
                View view3 = (View) arrayList.get(i7);
                if ((staggeredGridLayoutManager.f4162w && X.F(view3) <= i5) || ((!staggeredGridLayoutManager.f4162w && X.F(view3) >= i5) || !view3.hasFocusable())) {
                    break;
                }
                i7++;
                view = view3;
            }
        }
        return view;
    }

    public final int h(int i5) {
        int i6 = this.f4350b;
        if (i6 != Integer.MIN_VALUE) {
            return i6;
        }
        if (this.f4349a.size() == 0) {
            return i5;
        }
        View view = (View) this.f4349a.get(0);
        s0 s0Var = (s0) view.getLayoutParams();
        this.f4350b = this.f4354f.f4157r.e(view);
        s0Var.getClass();
        return this.f4350b;
    }
}
