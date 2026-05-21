package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0232b {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f3952a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map f3953b;

    public C0232b(HashMap map) {
        this.f3953b = map;
        for (Map.Entry entry : map.entrySet()) {
            EnumC0243m enumC0243m = (EnumC0243m) entry.getValue();
            List arrayList = (List) this.f3952a.get(enumC0243m);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f3952a.put(enumC0243m, arrayList);
            }
            arrayList.add((C0233c) entry.getKey());
        }
    }

    public static void a(List list, InterfaceC0249t interfaceC0249t, EnumC0243m enumC0243m, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                C0233c c0233c = (C0233c) list.get(size);
                c0233c.getClass();
                try {
                    int i5 = c0233c.f3954a;
                    Method method = c0233c.f3955b;
                    if (i5 == 0) {
                        method.invoke(obj, null);
                    } else if (i5 == 1) {
                        method.invoke(obj, interfaceC0249t);
                    } else if (i5 == 2) {
                        method.invoke(obj, interfaceC0249t, enumC0243m);
                    }
                } catch (IllegalAccessException e5) {
                    throw new RuntimeException(e5);
                } catch (InvocationTargetException e6) {
                    throw new RuntimeException("Failed to call observer method", e6.getCause());
                }
            }
        }
    }
}
