package k;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;

/* renamed from: k.k0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0640k0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f7811a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f7812b;

    /* renamed from: c, reason: collision with root package name */
    public static final Method f7813c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f7814d;

    static {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Boolean.TYPE;
            Class cls3 = Float.TYPE;
            Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, cls2, cls3, cls3);
            f7811a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
            f7812b = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
            f7813c = declaredMethod3;
            declaredMethod3.setAccessible(true);
            f7814d = true;
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
        }
    }
}
