package O;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class u0 extends x0 {

    /* renamed from: e, reason: collision with root package name */
    public static Field f1970e = null;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f1971f = false;
    public static Constructor g = null;
    public static boolean h = false;

    /* renamed from: c, reason: collision with root package name */
    public WindowInsets f1972c;

    /* renamed from: d, reason: collision with root package name */
    public E.c f1973d;

    public u0() {
        this.f1972c = i();
    }

    private static WindowInsets i() {
        if (!f1971f) {
            try {
                f1970e = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e5) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e5);
            }
            f1971f = true;
        }
        Field field = f1970e;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e6) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e6);
            }
        }
        if (!h) {
            try {
                g = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e7) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e7);
            }
            h = true;
        }
        Constructor constructor = g;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e8) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e8);
            }
        }
        return null;
    }

    @Override // O.x0
    public F0 b() {
        a();
        F0 f0G = F0.g(null, this.f1972c);
        E.c[] cVarArr = this.f1978b;
        D0 d02 = f0G.f1894a;
        d02.o(cVarArr);
        d02.q(this.f1973d);
        return f0G;
    }

    @Override // O.x0
    public void e(E.c cVar) {
        this.f1973d = cVar;
    }

    @Override // O.x0
    public void g(E.c cVar) {
        WindowInsets windowInsets = this.f1972c;
        if (windowInsets != null) {
            this.f1972c = windowInsets.replaceSystemWindowInsets(cVar.f419a, cVar.f420b, cVar.f421c, cVar.f422d);
        }
    }

    public u0(F0 f02) {
        super(f02);
        this.f1972c = f02.f();
    }
}
