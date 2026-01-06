package s0;

import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import com.unified.ur1.R;
import h4.f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: s0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0884a {

    /* renamed from: d, reason: collision with root package name */
    public static volatile C0884a f9570d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f9571e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Context f9574c;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f9573b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f9572a = new HashMap();

    public C0884a(Context context) {
        this.f9574c = context.getApplicationContext();
    }

    public static C0884a c(Context context) {
        if (f9570d == null) {
            synchronized (f9571e) {
                try {
                    if (f9570d == null) {
                        f9570d = new C0884a(context);
                    }
                } finally {
                }
            }
        }
        return f9570d;
    }

    public final void a(Bundle bundle) throws ClassNotFoundException {
        HashSet hashSet;
        String string = this.f9574c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    hashSet = this.f9573b;
                    if (!zHasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e5) {
                throw new F1.b(e5);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object objB;
        if (f.j()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        HashMap map = this.f9572a;
        if (map.containsKey(cls)) {
            objB = map.get(cls);
        } else {
            hashSet.add(cls);
            try {
                b bVar = (b) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = bVar.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!map.containsKey(cls2)) {
                            b(cls2, hashSet);
                        }
                    }
                }
                objB = bVar.b(this.f9574c);
                hashSet.remove(cls);
                map.put(cls, objB);
            } catch (Throwable th2) {
                throw new F1.b(th2);
            }
        }
        Trace.endSection();
        return objB;
    }
}
