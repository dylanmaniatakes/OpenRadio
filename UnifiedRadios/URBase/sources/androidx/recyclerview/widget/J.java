package androidx.recyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class J extends Z {

    /* renamed from: a, reason: collision with root package name */
    public RecyclerView f4042a;

    /* renamed from: b, reason: collision with root package name */
    public final q0 f4043b = new q0(this);

    /* renamed from: c, reason: collision with root package name */
    public I f4044c;

    /* renamed from: d, reason: collision with root package name */
    public I f4045d;

    public static int c(View view, androidx.emoji2.text.f fVar) {
        return ((fVar.c(view) / 2) + fVar.e(view)) - ((fVar.l() / 2) + fVar.k());
    }

    public static View d(X x4, androidx.emoji2.text.f fVar) {
        int iV = x4.v();
        View view = null;
        if (iV == 0) {
            return null;
        }
        int iL = (fVar.l() / 2) + fVar.k();
        int i5 = Integer.MAX_VALUE;
        for (int i6 = 0; i6 < iV; i6++) {
            View viewU = x4.u(i6);
            int iAbs = Math.abs(((fVar.c(viewU) / 2) + fVar.e(viewU)) - iL);
            if (iAbs < i5) {
                view = viewU;
                i5 = iAbs;
            }
        }
        return view;
    }

    public final void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f4042a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        q0 q0Var = this.f4043b;
        if (recyclerView2 != null) {
            ArrayList arrayList = recyclerView2.f4119l0;
            if (arrayList != null) {
                arrayList.remove(q0Var);
            }
            this.f4042a.setOnFlingListener(null);
        }
        this.f4042a = recyclerView;
        if (recyclerView != null) {
            if (recyclerView.getOnFlingListener() != null) {
                throw new IllegalStateException("An instance of OnFlingListener already set.");
            }
            this.f4042a.j(q0Var);
            this.f4042a.setOnFlingListener(this);
            new Scroller(this.f4042a.getContext(), new DecelerateInterpolator());
            h();
        }
    }

    public final int[] b(X x4, View view) {
        int[] iArr = new int[2];
        if (x4.d()) {
            iArr[0] = c(view, f(x4));
        } else {
            iArr[0] = 0;
        }
        if (x4.e()) {
            iArr[1] = c(view, g(x4));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public View e(X x4) {
        if (x4.e()) {
            return d(x4, g(x4));
        }
        if (x4.d()) {
            return d(x4, f(x4));
        }
        return null;
    }

    public final androidx.emoji2.text.f f(X x4) {
        I i5 = this.f4045d;
        if (i5 == null || ((X) i5.f3604b) != x4) {
            this.f4045d = new I(x4, 0);
        }
        return this.f4045d;
    }

    public final androidx.emoji2.text.f g(X x4) {
        I i5 = this.f4044c;
        if (i5 == null || ((X) i5.f3604b) != x4) {
            this.f4044c = new I(x4, 1);
        }
        return this.f4044c;
    }

    public final void h() {
        X layoutManager;
        View viewE;
        RecyclerView recyclerView = this.f4042a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewE = e(layoutManager)) == null) {
            return;
        }
        int[] iArrB = b(layoutManager, viewE);
        int i5 = iArrB[0];
        if (i5 == 0 && iArrB[1] == 0) {
            return;
        }
        this.f4042a.i0(i5, iArrB[1], false);
    }
}
