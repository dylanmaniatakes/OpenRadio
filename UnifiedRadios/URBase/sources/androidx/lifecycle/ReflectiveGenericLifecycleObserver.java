package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements r {

    /* renamed from: j, reason: collision with root package name */
    public final Object f3938j;

    /* renamed from: k, reason: collision with root package name */
    public final C0232b f3939k;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f3938j = obj;
        C0234d c0234d = C0234d.f3956c;
        Class<?> cls = obj.getClass();
        C0232b c0232b = (C0232b) c0234d.f3957a.get(cls);
        this.f3939k = c0232b == null ? c0234d.a(cls, null) : c0232b;
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        HashMap map = this.f3939k.f3952a;
        List list = (List) map.get(enumC0243m);
        Object obj = this.f3938j;
        C0232b.a(list, interfaceC0249t, enumC0243m, obj);
        C0232b.a((List) map.get(EnumC0243m.ON_ANY), interfaceC0249t, enumC0243m, obj);
    }
}
