package B0;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.X;
import androidx.recyclerview.widget.d0;
import androidx.recyclerview.widget.j0;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes.dex */
public final class j extends LinearLayoutManager {

    /* renamed from: E, reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f108E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(ViewPager2 viewPager2) {
        super(1);
        this.f108E = viewPager2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void C0(j0 j0Var, int[] iArr) {
        ViewPager2 viewPager2 = this.f108E;
        int offscreenPageLimit = viewPager2.getOffscreenPageLimit();
        if (offscreenPageLimit == -1) {
            super.C0(j0Var, iArr);
            return;
        }
        int pageSize = viewPager2.getPageSize() * offscreenPageLimit;
        iArr[0] = pageSize;
        iArr[1] = pageSize;
    }

    @Override // androidx.recyclerview.widget.X
    public final void T(d0 d0Var, j0 j0Var, P.j jVar) {
        super.T(d0Var, j0Var, jVar);
        this.f108E.f4476v.getClass();
    }

    @Override // androidx.recyclerview.widget.X
    public final void V(d0 d0Var, j0 j0Var, View view, P.j jVar) {
        int iF;
        int iF2;
        ViewPager2 viewPager2 = (ViewPager2) this.f108E.f4476v.f2836f;
        if (viewPager2.getOrientation() == 1) {
            viewPager2.f4464i.getClass();
            iF = X.F(view);
        } else {
            iF = 0;
        }
        if (viewPager2.getOrientation() == 0) {
            viewPager2.f4464i.getClass();
            iF2 = X.F(view);
        } else {
            iF2 = 0;
        }
        jVar.g(P.i.a(iF, 1, iF2, 1, false));
    }

    @Override // androidx.recyclerview.widget.X
    public final boolean g0(d0 d0Var, j0 j0Var, int i5, Bundle bundle) {
        this.f108E.f4476v.getClass();
        return super.g0(d0Var, j0Var, i5, bundle);
    }

    @Override // androidx.recyclerview.widget.X
    public final boolean m0(RecyclerView recyclerView, View view, Rect rect, boolean z4, boolean z5) {
        return false;
    }
}
