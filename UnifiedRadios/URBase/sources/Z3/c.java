package Z3;

import J1.D;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.android.AndroidComponentsImpl;

/* loaded from: classes.dex */
public final class c {
    public static volatile c h;

    /* renamed from: i, reason: collision with root package name */
    public static final d f3152i;

    /* renamed from: j, reason: collision with root package name */
    public static final HashMap f3153j;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f3154a;

    /* renamed from: b, reason: collision with root package name */
    public final H3.b f3155b = new H3.b(1);

    /* renamed from: c, reason: collision with root package name */
    public final D f3156c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f3157d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3158e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3159f;
    public final f g;

    static {
        d dVar = new d();
        ExecutorService executorService = d.f3160a;
        f3152i = dVar;
        f3153j = new HashMap();
    }

    public c() {
        f3152i.getClass();
        AndroidComponentsImpl androidComponentsImpl = AndroidComponentsImpl.f9019c;
        this.g = androidComponentsImpl != null ? androidComponentsImpl.f9020a : new D(21);
        this.f3154a = new HashMap();
        new HashMap();
        new ConcurrentHashMap();
        D d5 = androidComponentsImpl != null ? androidComponentsImpl.f9021b : null;
        this.f3156c = d5;
        if (d5 != null) {
            new e(this, Looper.getMainLooper());
        }
        this.f3157d = true;
        this.f3158e = true;
        this.f3159f = true;
    }

    public static void a(ArrayList arrayList, Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!arrayList.contains(cls)) {
                arrayList.add(cls);
                a(arrayList, cls.getInterfaces());
            }
        }
    }

    public final void b(Object obj) {
        b bVar = (b) this.f3155b.get();
        ArrayList arrayList = bVar.f3149a;
        arrayList.add(obj);
        if (bVar.f3150b) {
            return;
        }
        if (this.f3156c != null) {
            Looper.getMainLooper();
            Looper.myLooper();
        }
        bVar.f3150b = true;
        while (true) {
            try {
                if (arrayList.isEmpty()) {
                    return;
                } else {
                    c(arrayList.remove(0), bVar);
                }
            } finally {
                bVar.f3150b = false;
            }
        }
    }

    public final void c(Object obj, b bVar) {
        boolean zD;
        List list;
        Class<?> cls = obj.getClass();
        if (this.f3159f) {
            HashMap map = f3153j;
            synchronized (map) {
                try {
                    List list2 = (List) map.get(cls);
                    list = list2;
                    if (list2 == null) {
                        ArrayList arrayList = new ArrayList();
                        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                            arrayList.add(superclass);
                            a(arrayList, superclass.getInterfaces());
                        }
                        f3153j.put(cls, arrayList);
                        list = arrayList;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int size = list.size();
            zD = false;
            for (int i5 = 0; i5 < size; i5++) {
                zD |= d(obj, bVar, (Class) list.get(i5));
            }
        } else {
            zD = d(obj, bVar, cls);
        }
        if (zD) {
            return;
        }
        if (this.f3157d) {
            this.g.c(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.f3158e || cls == g.class || cls == i.class) {
            return;
        }
        b(new g(obj));
    }

    public final boolean d(Object obj, b bVar, Class cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.f3154a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        if (!it.hasNext()) {
            return true;
        }
        com.unified.ur1.SatelliteTracker.h.p(it.next());
        bVar.f3151c = obj;
        int[] iArr = a.f3148a;
        throw null;
    }

    public final String toString() {
        return "EventBus[indexCount=0, eventInheritance=" + this.f3159f + "]";
    }
}
