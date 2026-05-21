package androidx.work;

import C0.h;
import C0.k;
import F3.i;
import f3.C0519j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class OverwritingInputMerger extends k {
    @Override // C0.k
    public final h a(ArrayList arrayList) throws Throwable {
        C0519j c0519j = new C0519j(1);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Map mapUnmodifiableMap = Collections.unmodifiableMap(((h) it.next()).f158a);
            i.e(mapUnmodifiableMap, "input.keyValueMap");
            linkedHashMap.putAll(mapUnmodifiableMap);
        }
        c0519j.t(linkedHashMap);
        h hVar = new h((HashMap) c0519j.f6730d);
        h.b(hVar);
        return hVar;
    }
}
