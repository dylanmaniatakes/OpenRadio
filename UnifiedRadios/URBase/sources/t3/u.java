package t3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import s3.C0895e;

/* loaded from: classes.dex */
public abstract class u extends e4.a {
    public static int w(int i5) {
        if (i5 < 0) {
            return i5;
        }
        if (i5 < 3) {
            return i5 + 1;
        }
        if (i5 < 1073741824) {
            return (int) ((i5 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map x(ArrayList arrayList) {
        r rVar = r.f9712j;
        int size = arrayList.size();
        if (size == 0) {
            return rVar;
        }
        if (size == 1) {
            C0895e c0895e = (C0895e) arrayList.get(0);
            F3.i.f(c0895e, "pair");
            Map mapSingletonMap = Collections.singletonMap(c0895e.f9687j, c0895e.f9688k);
            F3.i.e(mapSingletonMap, "singletonMap(pair.first, pair.second)");
            return mapSingletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(w(arrayList.size()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0895e c0895e2 = (C0895e) it.next();
            linkedHashMap.put(c0895e2.f9687j, c0895e2.f9688k);
        }
        return linkedHashMap;
    }

    public static final Map y(Map map) {
        F3.i.f(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        F3.i.e(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }
}
