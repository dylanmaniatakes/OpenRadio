package x;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import org.conscrypt.PSKKeyManager;
import s.AbstractC0882e;
import v.C0919b;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f10223a;

    /* renamed from: b, reason: collision with root package name */
    public int f10224b;

    /* renamed from: c, reason: collision with root package name */
    public int f10225c;

    /* renamed from: d, reason: collision with root package name */
    public int f10226d;

    /* renamed from: e, reason: collision with root package name */
    public int f10227e;

    /* renamed from: f, reason: collision with root package name */
    public int f10228f;
    public int g;
    public final /* synthetic */ ConstraintLayout h;

    public f(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.h = constraintLayout;
        this.f10223a = constraintLayout2;
    }

    public static boolean a(int i5, int i6, int i7) {
        if (i5 == i6) {
            return true;
        }
        int mode = View.MeasureSpec.getMode(i5);
        View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        if (mode2 == 1073741824) {
            return (mode == Integer.MIN_VALUE || mode == 0) && i7 == size;
        }
        return false;
    }

    public final void b(u.d dVar, C0919b c0919b) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int iMax;
        int i5;
        int iMakeMeasureSpec3;
        boolean z4;
        int measuredWidth;
        int baseline;
        int i6;
        if (dVar == null) {
            return;
        }
        if (dVar.f9777g0 == 8) {
            c0919b.f9969e = 0;
            c0919b.f9970f = 0;
            c0919b.g = 0;
            return;
        }
        if (dVar.f9758T == null) {
            return;
        }
        int i7 = c0919b.f9965a;
        int i8 = c0919b.f9966b;
        int i9 = c0919b.f9967c;
        int i10 = c0919b.f9968d;
        int i11 = this.f10224b + this.f10225c;
        int i12 = this.f10226d;
        View view = (View) dVar.f9776f0;
        int iC = AbstractC0882e.c(i7);
        u.c cVar = dVar.f9749K;
        u.c cVar2 = dVar.I;
        if (iC == 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
        } else if (iC == 1) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f10228f, i12, -2);
        } else if (iC == 2) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f10228f, i12, -2);
            boolean z5 = dVar.f9795r == 1;
            int i13 = c0919b.f9972j;
            if (i13 == 1 || i13 == 2) {
                boolean z6 = view.getMeasuredHeight() == dVar.k();
                if (c0919b.f9972j == 2 || !z5 || ((z5 && z6) || dVar.A())) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(dVar.q(), 1073741824);
                }
            }
        } else if (iC != 3) {
            iMakeMeasureSpec = 0;
        } else {
            int i14 = this.f10228f;
            int i15 = cVar2 != null ? cVar2.g : 0;
            if (cVar != null) {
                i15 += cVar.g;
            }
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(i14, i12 + i15, -1);
        }
        int iC2 = AbstractC0882e.c(i8);
        if (iC2 == 0) {
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i10, 1073741824);
        } else if (iC2 == 1) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, i11, -2);
        } else if (iC2 == 2) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, i11, -2);
            boolean z7 = dVar.f9796s == 1;
            int i16 = c0919b.f9972j;
            if (i16 == 1 || i16 == 2) {
                boolean z8 = view.getMeasuredWidth() == dVar.q();
                if (c0919b.f9972j == 2 || !z7 || ((z7 && z8) || dVar.B())) {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(dVar.k(), 1073741824);
                }
            }
        } else if (iC2 != 3) {
            iMakeMeasureSpec2 = 0;
        } else {
            int i17 = this.g;
            int i18 = cVar2 != null ? dVar.f9748J.g : 0;
            if (cVar != null) {
                i18 += dVar.f9750L.g;
            }
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i17, i11 + i18, -1);
        }
        u.e eVar = (u.e) dVar.f9758T;
        ConstraintLayout constraintLayout = this.h;
        if (eVar != null && u.j.c(constraintLayout.f3502k, PSKKeyManager.MAX_KEY_LENGTH_BYTES) && view.getMeasuredWidth() == dVar.q() && view.getMeasuredWidth() < eVar.q() && view.getMeasuredHeight() == dVar.k() && view.getMeasuredHeight() < eVar.k() && view.getBaseline() == dVar.f9766a0 && !dVar.z() && a(dVar.f9746G, iMakeMeasureSpec, dVar.q()) && a(dVar.f9747H, iMakeMeasureSpec2, dVar.k())) {
            c0919b.f9969e = dVar.q();
            c0919b.f9970f = dVar.k();
            c0919b.g = dVar.f9766a0;
            return;
        }
        boolean z9 = i7 == 3;
        boolean z10 = i8 == 3;
        boolean z11 = i8 == 4 || i8 == 1;
        boolean z12 = i7 == 4 || i7 == 1;
        boolean z13 = z9 && dVar.f9761W > BitmapDescriptorFactory.HUE_RED;
        boolean z14 = z10 && dVar.f9761W > BitmapDescriptorFactory.HUE_RED;
        if (view == null) {
            return;
        }
        e eVar2 = (e) view.getLayoutParams();
        int i19 = c0919b.f9972j;
        if (i19 != 1 && i19 != 2 && z9 && dVar.f9795r == 0 && z10 && dVar.f9796s == 0) {
            z4 = false;
            measuredWidth = 0;
            i6 = -1;
            baseline = 0;
            iMax = 0;
        } else {
            if ((view instanceof t) && (dVar instanceof u.g)) {
                ((t) view).j((u.g) dVar, iMakeMeasureSpec, iMakeMeasureSpec2);
            } else {
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            }
            dVar.f9746G = iMakeMeasureSpec;
            dVar.f9747H = iMakeMeasureSpec2;
            dVar.g = false;
            int measuredWidth2 = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int baseline2 = view.getBaseline();
            int i20 = dVar.f9798u;
            int iMax2 = i20 > 0 ? Math.max(i20, measuredWidth2) : measuredWidth2;
            int i21 = dVar.f9799v;
            if (i21 > 0) {
                iMax2 = Math.min(i21, iMax2);
            }
            int i22 = dVar.f9801x;
            iMax = i22 > 0 ? Math.max(i22, measuredHeight) : measuredHeight;
            int i23 = iMakeMeasureSpec;
            int i24 = dVar.f9802y;
            if (i24 > 0) {
                iMax = Math.min(i24, iMax);
            }
            if (!u.j.c(constraintLayout.f3502k, 1)) {
                if (z13 && z11) {
                    iMax2 = (int) ((iMax * dVar.f9761W) + 0.5f);
                } else if (z14 && z12) {
                    iMax = (int) ((iMax2 / dVar.f9761W) + 0.5f);
                }
            }
            if (measuredWidth2 == iMax2 && measuredHeight == iMax) {
                baseline = baseline2;
                measuredWidth = iMax2;
                z4 = false;
            } else {
                if (measuredWidth2 != iMax2) {
                    i5 = 1073741824;
                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824);
                } else {
                    i5 = 1073741824;
                    iMakeMeasureSpec3 = i23;
                }
                if (measuredHeight != iMax) {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax, i5);
                }
                view.measure(iMakeMeasureSpec3, iMakeMeasureSpec2);
                dVar.f9746G = iMakeMeasureSpec3;
                dVar.f9747H = iMakeMeasureSpec2;
                z4 = false;
                dVar.g = false;
                measuredWidth = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                iMax = measuredHeight2;
            }
            i6 = -1;
        }
        boolean z15 = baseline != i6 ? true : z4;
        if (measuredWidth != c0919b.f9967c || iMax != c0919b.f9968d) {
            z4 = true;
        }
        c0919b.f9971i = z4;
        boolean z16 = eVar2.f10189c0 ? true : z15;
        if (z16 && baseline != -1 && dVar.f9766a0 != baseline) {
            c0919b.f9971i = true;
        }
        c0919b.f9969e = measuredWidth;
        c0919b.f9970f = iMax;
        c0919b.h = z16;
        c0919b.g = baseline;
    }
}
