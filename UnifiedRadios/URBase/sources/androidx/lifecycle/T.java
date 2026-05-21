package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class T implements V {

    /* renamed from: c, reason: collision with root package name */
    public static final T f3947c = new T();

    /* renamed from: d, reason: collision with root package name */
    public static final T f3948d = new T();

    /* renamed from: e, reason: collision with root package name */
    public static T f3949e;

    @Override // androidx.lifecycle.V
    public S b(Class cls) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            F3.i.e(objNewInstance, "{\n                modelC…wInstance()\n            }");
            return (S) objNewInstance;
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Cannot create an instance of " + cls, e5);
        } catch (InstantiationException e6) {
            throw new RuntimeException("Cannot create an instance of " + cls, e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("Cannot create an instance of " + cls, e7);
        }
    }
}
