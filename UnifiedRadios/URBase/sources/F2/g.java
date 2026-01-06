package F2;

import J1.D;
import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class g implements c {
    public static final f h = new f(0);

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f552a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f553b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f554c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f555d;

    /* renamed from: e, reason: collision with root package name */
    public final l f556e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference f557f;
    public final D g;

    public g(ArrayList arrayList, ArrayList arrayList2, D d5) {
        int i5 = 1;
        G2.k kVar = G2.k.f641j;
        this.f552a = new HashMap();
        this.f553b = new HashMap();
        this.f554c = new HashMap();
        this.f555d = new HashSet();
        this.f557f = new AtomicReference();
        l lVar = new l();
        this.f556e = lVar;
        this.g = d5;
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(b.c(lVar, l.class, N2.c.class, N2.b.class));
        arrayList3.add(b.c(this, g.class, new Class[0]));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar != null) {
                arrayList3.add(bVar);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList4.add(it2.next());
        }
        ArrayList arrayList5 = new ArrayList();
        synchronized (this) {
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((Q2.a) it3.next()).get();
                    if (componentRegistrar != null) {
                        arrayList3.addAll(this.g.h(componentRegistrar));
                        it3.remove();
                    }
                } catch (m e5) {
                    it3.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e5);
                }
            }
            Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                Object[] array = ((b) it4.next()).f544b.toArray();
                int length = array.length;
                int i6 = 0;
                while (true) {
                    if (i6 < length) {
                        Object obj = array[i6];
                        if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.f555d.contains(obj.toString())) {
                                it4.remove();
                                break;
                            }
                            this.f555d.add(obj.toString());
                        }
                        i6++;
                    }
                }
            }
            if (this.f552a.isEmpty()) {
                L0.f.g(arrayList3);
            } else {
                ArrayList arrayList6 = new ArrayList(this.f552a.keySet());
                arrayList6.addAll(arrayList3);
                L0.f.g(arrayList6);
            }
            Iterator it5 = arrayList3.iterator();
            while (it5.hasNext()) {
                b bVar2 = (b) it5.next();
                this.f552a.put(bVar2, new n(new A2.c(this, i5, bVar2)));
            }
            arrayList5.addAll(i(arrayList3));
            arrayList5.addAll(j());
            h();
        }
        Iterator it6 = arrayList5.iterator();
        while (it6.hasNext()) {
            ((Runnable) it6.next()).run();
        }
        Boolean bool = (Boolean) this.f557f.get();
        if (bool != null) {
            g(this.f552a, bool.booleanValue());
        }
    }

    @Override // F2.c
    public final synchronized Q2.a d(r rVar) {
        Z3.i.a(rVar, "Null interface requested.");
        return (Q2.a) this.f553b.get(rVar);
    }

    @Override // F2.c
    public final synchronized Q2.a f(r rVar) {
        o oVar = (o) this.f554c.get(rVar);
        if (oVar != null) {
            return oVar;
        }
        return h;
    }

    public final void g(Map map, boolean z4) {
        ArrayDeque arrayDeque;
        for (Map.Entry entry : map.entrySet()) {
            b bVar = (b) entry.getKey();
            Q2.a aVar = (Q2.a) entry.getValue();
            int i5 = bVar.f546d;
            if (i5 == 1 || (i5 == 2 && z4)) {
                aVar.get();
            }
        }
        l lVar = this.f556e;
        synchronized (lVar) {
            arrayDeque = lVar.f567b;
            if (arrayDeque != null) {
                lVar.f567b = null;
            } else {
                arrayDeque = null;
            }
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            if (it.hasNext()) {
                com.unified.ur1.SatelliteTracker.h.p(it.next());
                throw null;
            }
        }
    }

    public final void h() {
        for (b bVar : this.f552a.keySet()) {
            for (j jVar : bVar.f545c) {
                if (jVar.f564b == 2 && !this.f554c.containsKey(jVar.f563a)) {
                    HashMap map = this.f554c;
                    r rVar = jVar.f563a;
                    Set setEmptySet = Collections.emptySet();
                    o oVar = new o();
                    oVar.f573b = null;
                    oVar.f572a = Collections.newSetFromMap(new ConcurrentHashMap());
                    oVar.f572a.addAll(setEmptySet);
                    map.put(rVar, oVar);
                } else if (this.f553b.containsKey(jVar.f563a)) {
                    continue;
                } else {
                    int i5 = jVar.f564b;
                    if (i5 == 1) {
                        throw new k("Unsatisfied dependency for component " + bVar + ": " + jVar.f563a);
                    }
                    if (i5 != 2) {
                        HashMap map2 = this.f553b;
                        r rVar2 = jVar.f563a;
                        A2.i iVar = p.f574c;
                        f fVar = p.f575d;
                        p pVar = new p();
                        pVar.f576a = iVar;
                        pVar.f577b = fVar;
                        map2.put(rVar2, pVar);
                    }
                }
            }
        }
    }

    public final ArrayList i(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f547e == 0) {
                Q2.a aVar = (Q2.a) this.f552a.get(bVar);
                for (r rVar : bVar.f544b) {
                    HashMap map = this.f553b;
                    if (map.containsKey(rVar)) {
                        arrayList2.add(new D.m((p) ((Q2.a) map.get(rVar)), 3, aVar));
                    } else {
                        map.put(rVar, aVar);
                    }
                }
            }
        }
        return arrayList2;
    }

    public final ArrayList j() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f552a.entrySet()) {
            b bVar = (b) entry.getKey();
            if (bVar.f547e != 0) {
                Q2.a aVar = (Q2.a) entry.getValue();
                for (r rVar : bVar.f544b) {
                    if (!map.containsKey(rVar)) {
                        map.put(rVar, new HashSet());
                    }
                    ((Set) map.get(rVar)).add(aVar);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            Object key = entry2.getKey();
            HashMap map2 = this.f554c;
            if (map2.containsKey(key)) {
                o oVar = (o) map2.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new D.m(oVar, 4, (Q2.a) it.next()));
                }
            } else {
                r rVar2 = (r) entry2.getKey();
                Set set = (Set) ((Collection) entry2.getValue());
                o oVar2 = new o();
                oVar2.f573b = null;
                oVar2.f572a = Collections.newSetFromMap(new ConcurrentHashMap());
                oVar2.f572a.addAll(set);
                map2.put(rVar2, oVar2);
            }
        }
        return arrayList;
    }
}
