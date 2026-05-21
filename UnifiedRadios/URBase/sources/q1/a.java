package Q1;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public abstract class a extends z.b {

    /* renamed from: a, reason: collision with root package name */
    public b f2166a;

    /* renamed from: b, reason: collision with root package name */
    public int f2167b = 0;

    public a() {
    }

    @Override // z.b
    public boolean g(CoordinatorLayout coordinatorLayout, View view, int i5) {
        r(coordinatorLayout, view, i5);
        if (this.f2166a == null) {
            b bVar = new b();
            bVar.f2171d = view;
            this.f2166a = bVar;
        }
        b bVar2 = this.f2166a;
        View view2 = (View) bVar2.f2171d;
        bVar2.f2168a = view2.getTop();
        bVar2.f2169b = view2.getLeft();
        this.f2166a.b();
        int i6 = this.f2167b;
        if (i6 == 0) {
            return true;
        }
        b bVar3 = this.f2166a;
        if (bVar3.f2170c != i6) {
            bVar3.f2170c = i6;
            bVar3.b();
        }
        this.f2167b = 0;
        return true;
    }

    public void r(CoordinatorLayout coordinatorLayout, View view, int i5) {
        coordinatorLayout.q(view, i5);
    }

    public a(int i5) {
    }
}
