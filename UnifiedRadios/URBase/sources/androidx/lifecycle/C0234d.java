package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: androidx.lifecycle.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0234d {

    /* renamed from: c, reason: collision with root package name */
    public static final C0234d f3956c = new C0234d();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f3957a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f3958b = new HashMap();

    public static void b(HashMap map, C0233c c0233c, EnumC0243m enumC0243m, Class cls) {
        EnumC0243m enumC0243m2 = (EnumC0243m) map.get(c0233c);
        if (enumC0243m2 == null || enumC0243m == enumC0243m2) {
            if (enumC0243m2 == null) {
                map.put(c0233c, enumC0243m);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0233c.f3955b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + enumC0243m2 + ", new value " + enumC0243m);
    }

    public final C0232b a(Class cls, Method[] methodArr) throws SecurityException {
        int i5;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        HashMap map2 = this.f3957a;
        if (superclass != null) {
            C0232b c0232bA = (C0232b) map2.get(superclass);
            if (c0232bA == null) {
                c0232bA = a(superclass, null);
            }
            map.putAll(c0232bA.f3953b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            C0232b c0232bA2 = (C0232b) map2.get(cls2);
            if (c0232bA2 == null) {
                c0232bA2 = a(cls2, null);
            }
            for (Map.Entry entry : c0232bA2.f3953b.entrySet()) {
                b(map, (C0233c) entry.getKey(), (EnumC0243m) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e5) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e5);
            }
        }
        boolean z4 = false;
        for (Method method : methodArr) {
            C c2 = (C) method.getAnnotation(C.class);
            if (c2 != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i5 = 0;
                } else {
                    if (!InterfaceC0249t.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i5 = 1;
                }
                EnumC0243m enumC0243mValue = c2.value();
                if (parameterTypes.length > 1) {
                    if (!EnumC0243m.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (enumC0243mValue != EnumC0243m.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i5 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                b(map, new C0233c(method, i5), enumC0243mValue, cls);
                z4 = true;
            }
        }
        C0232b c0232b = new C0232b(map);
        map2.put(cls, c0232b);
        this.f3958b.put(cls, Boolean.valueOf(z4));
        return c0232b;
    }
}
