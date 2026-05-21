package o2;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* renamed from: o2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0809a extends e4.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8908b;

    /* renamed from: c, reason: collision with root package name */
    public final SideSheetBehavior f8909c;

    public /* synthetic */ C0809a(SideSheetBehavior sideSheetBehavior, int i5) {
        this.f8908b = i5;
        this.f8909c = sideSheetBehavior;
    }

    @Override // e4.a
    public final int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        switch (this.f8908b) {
            case 0:
                return marginLayoutParams.leftMargin;
            default:
                return marginLayoutParams.rightMargin;
        }
    }

    @Override // e4.a
    public final float b(int i5) {
        switch (this.f8908b) {
            case 0:
                float f5 = f();
                return (i5 - f5) / (e() - f5);
            default:
                float f6 = this.f8909c.f5398m;
                return (f6 - i5) / (f6 - e());
        }
    }

    @Override // e4.a
    public final int e() {
        switch (this.f8908b) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.f8909c;
                return Math.max(0, sideSheetBehavior.n + sideSheetBehavior.f5399o);
            default:
                SideSheetBehavior sideSheetBehavior2 = this.f8909c;
                return Math.max(0, (sideSheetBehavior2.f5398m - sideSheetBehavior2.f5397l) - sideSheetBehavior2.f5399o);
        }
    }

    @Override // e4.a
    public final int f() {
        switch (this.f8908b) {
            case 0:
                SideSheetBehavior sideSheetBehavior = this.f8909c;
                return (-sideSheetBehavior.f5397l) - sideSheetBehavior.f5399o;
            default:
                return this.f8909c.f5398m;
        }
    }

    @Override // e4.a
    public final int h() {
        switch (this.f8908b) {
            case 0:
                return this.f8909c.f5399o;
            default:
                return this.f8909c.f5398m;
        }
    }

    @Override // e4.a
    public final int i() {
        switch (this.f8908b) {
            case 0:
                return -this.f8909c.f5397l;
            default:
                return e();
        }
    }

    @Override // e4.a
    public final int k(View view) {
        switch (this.f8908b) {
            case 0:
                return view.getRight() + this.f8909c.f5399o;
            default:
                return view.getLeft() - this.f8909c.f5399o;
        }
    }

    @Override // e4.a
    public final int l(CoordinatorLayout coordinatorLayout) {
        switch (this.f8908b) {
            case 0:
                return coordinatorLayout.getLeft();
            default:
                return coordinatorLayout.getRight();
        }
    }

    @Override // e4.a
    public final int m() {
        switch (this.f8908b) {
            case 0:
                return 1;
            default:
                return 0;
        }
    }

    @Override // e4.a
    public final boolean p(float f5) {
        switch (this.f8908b) {
            case 0:
                if (f5 > BitmapDescriptorFactory.HUE_RED) {
                }
                break;
            default:
                if (f5 < BitmapDescriptorFactory.HUE_RED) {
                }
                break;
        }
        return false;
    }

    @Override // e4.a
    public final boolean q(View view) {
        switch (this.f8908b) {
            case 0:
                if (view.getRight() < (e() - f()) / 2) {
                }
                break;
            default:
                if (view.getLeft() > (e() + this.f8909c.f5398m) / 2) {
                }
                break;
        }
        return false;
    }

    @Override // e4.a
    public final boolean r(float f5, float f6) {
        switch (this.f8908b) {
            case 0:
                if (Math.abs(f5) > Math.abs(f6)) {
                    float fAbs = Math.abs(f5);
                    this.f8909c.getClass();
                    if (fAbs > 500) {
                    }
                }
                break;
            default:
                if (Math.abs(f5) > Math.abs(f6)) {
                    float fAbs2 = Math.abs(f5);
                    this.f8909c.getClass();
                    if (fAbs2 > 500) {
                    }
                }
                break;
        }
        return false;
    }

    @Override // e4.a
    public final boolean t(View view, float f5) {
        switch (this.f8908b) {
            case 0:
                if (Math.abs((f5 * this.f8909c.f5396k) + view.getLeft()) > 0.5f) {
                }
                break;
            default:
                if (Math.abs((f5 * this.f8909c.f5396k) + view.getRight()) > 0.5f) {
                }
                break;
        }
        return false;
    }

    @Override // e4.a
    public final void u(ViewGroup.MarginLayoutParams marginLayoutParams, int i5, int i6) {
        switch (this.f8908b) {
            case 0:
                if (i5 <= this.f8909c.f5398m) {
                    marginLayoutParams.leftMargin = i6;
                    break;
                }
                break;
            default:
                int i7 = this.f8909c.f5398m;
                if (i5 <= i7) {
                    marginLayoutParams.rightMargin = i7 - i5;
                    break;
                }
                break;
        }
    }
}
