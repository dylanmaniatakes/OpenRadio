package O;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class F0 {

    /* renamed from: b, reason: collision with root package name */
    public static final F0 f1893b;

    /* renamed from: a, reason: collision with root package name */
    public final D0 f1894a;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f1893b = C0.f1885q;
        } else {
            f1893b = D0.f1887b;
        }
    }

    public F0(WindowInsets windowInsets) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            this.f1894a = new C0(this, windowInsets);
        } else if (i5 >= 29) {
            this.f1894a = new B0(this, windowInsets);
        } else {
            this.f1894a = new A0(this, windowInsets);
        }
    }

    public static E.c e(E.c cVar, int i5, int i6, int i7, int i8) {
        int iMax = Math.max(0, cVar.f419a - i5);
        int iMax2 = Math.max(0, cVar.f420b - i6);
        int iMax3 = Math.max(0, cVar.f421c - i7);
        int iMax4 = Math.max(0, cVar.f422d - i8);
        return (iMax == i5 && iMax2 == i6 && iMax3 == i7 && iMax4 == i8) ? cVar : E.c.b(iMax, iMax2, iMax3, iMax4);
    }

    public static F0 g(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        F0 f02 = new F0(windowInsets);
        if (view != null) {
            WeakHashMap weakHashMap = Y.f1904a;
            if (J.b(view)) {
                F0 f0A = N.a(view);
                D0 d02 = f02.f1894a;
                d02.p(f0A);
                d02.d(view.getRootView());
            }
        }
        return f02;
    }

    public final int a() {
        return this.f1894a.j().f422d;
    }

    public final int b() {
        return this.f1894a.j().f419a;
    }

    public final int c() {
        return this.f1894a.j().f421c;
    }

    public final int d() {
        return this.f1894a.j().f420b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof F0)) {
            return false;
        }
        return N.b.a(this.f1894a, ((F0) obj).f1894a);
    }

    public final WindowInsets f() {
        D0 d02 = this.f1894a;
        if (d02 instanceof y0) {
            return ((y0) d02).f1983c;
        }
        return null;
    }

    public final int hashCode() {
        D0 d02 = this.f1894a;
        if (d02 == null) {
            return 0;
        }
        return d02.hashCode();
    }

    public F0() {
        this.f1894a = new D0(this);
    }
}
