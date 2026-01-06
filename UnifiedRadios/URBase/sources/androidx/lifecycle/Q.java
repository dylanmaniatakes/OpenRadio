package androidx.lifecycle;

import android.app.Application;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class Q {

    /* renamed from: a, reason: collision with root package name */
    public static final List f3936a = t3.j.y(Application.class, K.class);

    /* renamed from: b, reason: collision with root package name */
    public static final List f3937b = AbstractC0296a2.i(K.class);

    public static final Constructor a(List list, Class cls) throws SecurityException {
        F3.i.f(list, "signature");
        Constructor<?>[] constructors = cls.getConstructors();
        F3.i.e(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            F3.i.e(parameterTypes, "constructor.parameterTypes");
            List listY = t3.h.y(parameterTypes);
            if (list.equals(listY)) {
                return constructor;
            }
            if (list.size() == listY.size() && listY.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final S b(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (S) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Failed to access " + cls, e5);
        } catch (InstantiationException e6) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e7.getCause());
        }
    }
}
