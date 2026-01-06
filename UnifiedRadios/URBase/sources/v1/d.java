package V1;

import C0.A;
import O.G;
import O.Y;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import n1.C0787d;
import p1.o;
import q1.E;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2524a;

    /* renamed from: b, reason: collision with root package name */
    public int f2525b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2526c;

    /* renamed from: d, reason: collision with root package name */
    public Object f2527d;

    /* renamed from: e, reason: collision with root package name */
    public Object f2528e;

    public /* synthetic */ d() {
        this.f2524a = 2;
    }

    public static d b() {
        d dVar = new d();
        dVar.f2526c = true;
        dVar.f2525b = 0;
        return dVar;
    }

    public d a() {
        E.b(((o) this.f2527d) != null, "execute parameter required");
        return new d(this, (C0787d[]) this.f2528e, this.f2526c, this.f2525b);
    }

    public void c(int i5) {
        switch (this.f2524a) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f2528e;
                WeakReference weakReference = bottomSheetBehavior.f5200U;
                if (weakReference != null && weakReference.get() != null) {
                    this.f2525b = i5;
                    if (!this.f2526c) {
                        View view = (View) bottomSheetBehavior.f5200U.get();
                        WeakHashMap weakHashMap = Y.f1904a;
                        G.m(view, (A) this.f2527d);
                        this.f2526c = true;
                        break;
                    }
                }
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f2528e;
                WeakReference weakReference2 = sideSheetBehavior.f5400p;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.f2525b = i5;
                    if (!this.f2526c) {
                        View view2 = (View) sideSheetBehavior.f5400p.get();
                        WeakHashMap weakHashMap2 = Y.f1904a;
                        G.m(view2, (m3.o) this.f2527d);
                        this.f2526c = true;
                        break;
                    }
                }
                break;
        }
    }

    public d(d dVar, C0787d[] c0787dArr, boolean z4, int i5) {
        this.f2524a = 3;
        this.f2528e = dVar;
        this.f2527d = c0787dArr;
        boolean z5 = false;
        if (c0787dArr != null && z4) {
            z5 = true;
        }
        this.f2526c = z5;
        this.f2525b = i5;
    }

    public d(SideSheetBehavior sideSheetBehavior) {
        this.f2524a = 1;
        this.f2528e = sideSheetBehavior;
        this.f2527d = new m3.o(1, this);
    }

    public d(BottomSheetBehavior bottomSheetBehavior) {
        this.f2524a = 0;
        this.f2528e = bottomSheetBehavior;
        this.f2527d = new A(11, this);
    }
}
