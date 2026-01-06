package i1;

import V0.d;
import android.util.SparseArray;
import com.unified.ur1.SatelliteTracker.h;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray f7191a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f7192b;

    static {
        HashMap map = new HashMap();
        f7192b = map;
        map.put(d.f2512j, 0);
        map.put(d.f2513k, 1);
        map.put(d.f2514l, 2);
        for (d dVar : map.keySet()) {
            f7191a.append(((Integer) f7192b.get(dVar)).intValue(), dVar);
        }
    }

    public static int a(d dVar) {
        Integer num = (Integer) f7192b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }

    public static d b(int i5) {
        d dVar = (d) f7191a.get(i5);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException(h.a(i5, "Unknown Priority for value "));
    }
}
