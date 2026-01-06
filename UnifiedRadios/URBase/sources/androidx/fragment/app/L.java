package androidx.fragment.app;

import g0.AbstractC0535a;

/* loaded from: classes.dex */
public final class L {

    /* renamed from: b, reason: collision with root package name */
    public static final q.k f3675b = new q.k();

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T f3676a;

    public L(T t4) {
        this.f3676a = t4;
    }

    public static Class a(ClassLoader classLoader, String str) throws ClassNotFoundException {
        q.k kVar = f3675b;
        q.k kVar2 = (q.k) kVar.getOrDefault(classLoader, null);
        if (kVar2 == null) {
            kVar2 = new q.k();
            kVar.put(classLoader, kVar2);
        }
        Class cls = (Class) kVar2.getOrDefault(str, null);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        kVar2.put(str, cls2);
        return cls2;
    }

    public static Class b(ClassLoader classLoader, String str) {
        try {
            return a(classLoader, str);
        } catch (ClassCastException e5) {
            throw new F1.b(AbstractC0535a.l("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e5);
        } catch (ClassNotFoundException e6) {
            throw new F1.b(AbstractC0535a.l("Unable to instantiate fragment ", str, ": make sure class name exists"), e6);
        }
    }
}
