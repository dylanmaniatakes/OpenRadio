package V1;

import a.AbstractC0203a;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.unified.ur1.SatelliteTracker.h;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class b extends A2.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2518a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z.b f2519b;

    public /* synthetic */ b(z.b bVar, int i5) {
        this.f2518a = i5;
        this.f2519b = bVar;
    }

    @Override // A2.b
    public final int d(View view, int i5) {
        switch (this.f2518a) {
            case 0:
                return view.getLeft();
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f2519b;
                return AbstractC0203a.b(i5, sideSheetBehavior.f5388a.i(), sideSheetBehavior.f5388a.h());
        }
    }

    @Override // A2.b
    public final int e(View view, int i5) {
        switch (this.f2518a) {
            case 0:
                return AbstractC0203a.b(i5, ((BottomSheetBehavior) this.f2519b).x(), n());
            default:
                return view.getTop();
        }
    }

    @Override // A2.b
    public int m(View view) {
        switch (this.f2518a) {
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f2519b;
                return sideSheetBehavior.f5397l + sideSheetBehavior.f5399o;
            default:
                return super.m(view);
        }
    }

    @Override // A2.b
    public int n() {
        switch (this.f2518a) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f2519b;
                return bottomSheetBehavior.I ? bottomSheetBehavior.f5199T : bottomSheetBehavior.f5187G;
            default:
                return super.n();
        }
    }

    @Override // A2.b
    public final void r(int i5) {
        switch (this.f2518a) {
            case 0:
                if (i5 == 1) {
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f2519b;
                    if (bottomSheetBehavior.f5190K) {
                        bottomSheetBehavior.C(1);
                        break;
                    }
                }
                break;
            default:
                if (i5 == 1) {
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f2519b;
                    if (sideSheetBehavior.g) {
                        sideSheetBehavior.r(1);
                        break;
                    }
                }
                break;
        }
    }

    @Override // A2.b
    public final void s(View view, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        switch (this.f2518a) {
            case 0:
                ((BottomSheetBehavior) this.f2519b).u(i6);
                return;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f2519b;
                WeakReference weakReference = sideSheetBehavior.f5401q;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
                    sideSheetBehavior.f5388a.u(marginLayoutParams, view.getLeft(), view.getRight());
                    view2.setLayoutParams(marginLayoutParams);
                }
                LinkedHashSet linkedHashSet = sideSheetBehavior.f5405u;
                if (linkedHashSet.isEmpty()) {
                    return;
                }
                sideSheetBehavior.f5388a.b(i5);
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    h.p(it.next());
                    throw null;
                }
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e6  */
    @Override // A2.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(android.view.View r6, float r7, float r8) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: V1.b.t(android.view.View, float, float):void");
    }

    @Override // A2.b
    public final boolean y(View view, int i5) {
        WeakReference weakReference;
        switch (this.f2518a) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f2519b;
                int i6 = bottomSheetBehavior.f5191L;
                if (i6 != 1 && !bottomSheetBehavior.f5207a0) {
                    if (i6 == 3 && bottomSheetBehavior.f5204Y == i5) {
                        WeakReference weakReference2 = bottomSheetBehavior.f5201V;
                        View view2 = weakReference2 != null ? (View) weakReference2.get() : null;
                        if (view2 != null && view2.canScrollVertically(-1)) {
                        }
                    }
                    System.currentTimeMillis();
                    WeakReference weakReference3 = bottomSheetBehavior.f5200U;
                    if (weakReference3 != null && weakReference3.get() == view) {
                        break;
                    }
                }
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f2519b;
                if (sideSheetBehavior.h != 1 && (weakReference = sideSheetBehavior.f5400p) != null && weakReference.get() == view) {
                    break;
                }
                break;
        }
        return true;
    }
}
