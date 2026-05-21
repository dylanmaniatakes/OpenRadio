package O;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class y0 extends D0 {
    public static boolean h = false;

    /* renamed from: i, reason: collision with root package name */
    public static Method f1979i;

    /* renamed from: j, reason: collision with root package name */
    public static Class f1980j;

    /* renamed from: k, reason: collision with root package name */
    public static Field f1981k;

    /* renamed from: l, reason: collision with root package name */
    public static Field f1982l;

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets f1983c;

    /* renamed from: d, reason: collision with root package name */
    public E.c[] f1984d;

    /* renamed from: e, reason: collision with root package name */
    public E.c f1985e;

    /* renamed from: f, reason: collision with root package name */
    public F0 f1986f;
    public E.c g;

    public y0(F0 f02, WindowInsets windowInsets) {
        super(f02);
        this.f1985e = null;
        this.f1983c = windowInsets;
    }

    @SuppressLint({"WrongConstant"})
    private E.c r(int i5, boolean z4) {
        E.c cVarA = E.c.f418e;
        for (int i6 = 1; i6 <= 256; i6 <<= 1) {
            if ((i5 & i6) != 0) {
                cVarA = E.c.a(cVarA, s(i6, z4));
            }
        }
        return cVarA;
    }

    private E.c t() {
        F0 f02 = this.f1986f;
        return f02 != null ? f02.f1894a.h() : E.c.f418e;
    }

    private E.c u(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!h) {
            v();
        }
        Method method = f1979i;
        if (method != null && f1980j != null && f1981k != null) {
            try {
                Object objInvoke = method.invoke(view, null);
                if (objInvoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) f1981k.get(f1982l.get(objInvoke));
                if (rect != null) {
                    return E.c.b(rect.left, rect.top, rect.right, rect.bottom);
                }
                return null;
            } catch (ReflectiveOperationException e5) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e5.getMessage(), e5);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static void v() throws ClassNotFoundException, SecurityException {
        try {
            f1979i = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f1980j = cls;
            f1981k = cls.getDeclaredField("mVisibleInsets");
            f1982l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f1981k.setAccessible(true);
            f1982l.setAccessible(true);
        } catch (ReflectiveOperationException e5) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e5.getMessage(), e5);
        }
        h = true;
    }

    @Override // O.D0
    public void d(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        E.c cVarU = u(view);
        if (cVarU == null) {
            cVarU = E.c.f418e;
        }
        w(cVarU);
    }

    @Override // O.D0
    public E.c f(int i5) {
        return r(i5, false);
    }

    @Override // O.D0
    public final E.c j() {
        if (this.f1985e == null) {
            WindowInsets windowInsets = this.f1983c;
            this.f1985e = E.c.b(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f1985e;
    }

    @Override // O.D0
    public F0 l(int i5, int i6, int i7, int i8) {
        F0 f0G = F0.g(null, this.f1983c);
        int i9 = Build.VERSION.SDK_INT;
        x0 w0Var = i9 >= 30 ? new w0(f0G) : i9 >= 29 ? new v0(f0G) : new u0(f0G);
        w0Var.g(F0.e(j(), i5, i6, i7, i8));
        w0Var.e(F0.e(h(), i5, i6, i7, i8));
        return w0Var.b();
    }

    @Override // O.D0
    public boolean n() {
        return this.f1983c.isRound();
    }

    @Override // O.D0
    public void o(E.c[] cVarArr) {
        this.f1984d = cVarArr;
    }

    @Override // O.D0
    public void p(F0 f02) {
        this.f1986f = f02;
    }

    public E.c s(int i5, boolean z4) {
        E.c cVarH;
        int i6;
        if (i5 == 1) {
            return z4 ? E.c.b(0, Math.max(t().f420b, j().f420b), 0, 0) : E.c.b(0, j().f420b, 0, 0);
        }
        if (i5 == 2) {
            if (z4) {
                E.c cVarT = t();
                E.c cVarH2 = h();
                return E.c.b(Math.max(cVarT.f419a, cVarH2.f419a), 0, Math.max(cVarT.f421c, cVarH2.f421c), Math.max(cVarT.f422d, cVarH2.f422d));
            }
            E.c cVarJ = j();
            F0 f02 = this.f1986f;
            cVarH = f02 != null ? f02.f1894a.h() : null;
            int iMin = cVarJ.f422d;
            if (cVarH != null) {
                iMin = Math.min(iMin, cVarH.f422d);
            }
            return E.c.b(cVarJ.f419a, 0, cVarJ.f421c, iMin);
        }
        E.c cVar = E.c.f418e;
        if (i5 == 8) {
            E.c[] cVarArr = this.f1984d;
            cVarH = cVarArr != null ? cVarArr[3] : null;
            if (cVarH != null) {
                return cVarH;
            }
            E.c cVarJ2 = j();
            E.c cVarT2 = t();
            int i7 = cVarJ2.f422d;
            if (i7 > cVarT2.f422d) {
                return E.c.b(0, 0, 0, i7);
            }
            E.c cVar2 = this.g;
            return (cVar2 == null || cVar2.equals(cVar) || (i6 = this.g.f422d) <= cVarT2.f422d) ? cVar : E.c.b(0, 0, 0, i6);
        }
        if (i5 == 16) {
            return i();
        }
        if (i5 == 32) {
            return g();
        }
        if (i5 == 64) {
            return k();
        }
        if (i5 != 128) {
            return cVar;
        }
        F0 f03 = this.f1986f;
        C0168i c0168iE = f03 != null ? f03.f1894a.e() : e();
        if (c0168iE == null) {
            return cVar;
        }
        DisplayCutout displayCutout = c0168iE.f1933a;
        return E.c.b(AbstractC0166h.d(displayCutout), AbstractC0166h.f(displayCutout), AbstractC0166h.e(displayCutout), AbstractC0166h.c(displayCutout));
    }

    public void w(E.c cVar) {
        this.g = cVar;
    }
}
