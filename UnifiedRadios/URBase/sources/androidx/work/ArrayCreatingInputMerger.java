package androidx.work;

import C0.h;
import C0.k;
import F3.i;
import f3.C0519j;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class ArrayCreatingInputMerger extends k {
    @Override // C0.k
    public final h a(ArrayList arrayList) throws Throwable {
        Object objNewInstance;
        C0519j c0519j = new C0519j(1);
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Map mapUnmodifiableMap = Collections.unmodifiableMap(((h) it.next()).f158a);
            i.e(mapUnmodifiableMap, "input.keyValueMap");
            for (Map.Entry entry : mapUnmodifiableMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                Class cls = value != null ? value.getClass() : String.class;
                Object obj = map.get(str);
                i.e(str, "key");
                if (obj != null) {
                    Class<?> cls2 = obj.getClass();
                    if (cls2.equals(cls)) {
                        i.e(value, "value");
                        int length = Array.getLength(obj);
                        int length2 = Array.getLength(value);
                        Class<?> componentType = obj.getClass().getComponentType();
                        i.c(componentType);
                        Object objNewInstance2 = Array.newInstance(componentType, length + length2);
                        System.arraycopy(obj, 0, objNewInstance2, 0, length);
                        System.arraycopy(value, 0, objNewInstance2, length, length2);
                        i.e(objNewInstance2, "newArray");
                        value = objNewInstance2;
                    } else {
                        if (!i.a(cls2.getComponentType(), cls)) {
                            throw new IllegalArgumentException();
                        }
                        int length3 = Array.getLength(obj);
                        objNewInstance = Array.newInstance(cls, length3 + 1);
                        System.arraycopy(obj, 0, objNewInstance, 0, length3);
                        Array.set(objNewInstance, length3, value);
                        i.e(objNewInstance, "newArray");
                        value = objNewInstance;
                    }
                } else if (!cls.isArray()) {
                    objNewInstance = Array.newInstance(cls, 1);
                    Array.set(objNewInstance, 0, value);
                    i.e(objNewInstance, "newArray");
                    value = objNewInstance;
                }
                i.e(value, "if (existingValue == nul…      }\n                }");
                map.put(str, value);
            }
        }
        c0519j.t(map);
        h hVar = new h((HashMap) c0519j.f6730d);
        h.b(hVar);
        return hVar;
    }
}
