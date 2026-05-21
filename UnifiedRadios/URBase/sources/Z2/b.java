package Z2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f3143a;

    /* renamed from: b, reason: collision with root package name */
    public final c f3144b;

    public b(Set set, c cVar) {
        this.f3143a = b(set);
        this.f3144b = cVar;
    }

    public static String b(Set set) {
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            sb.append(aVar.f3141a);
            sb.append('/');
            sb.append(aVar.f3142b);
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public final String a() {
        Set setUnmodifiableSet;
        Set setUnmodifiableSet2;
        c cVar = this.f3144b;
        synchronized (((HashSet) cVar.f3147d)) {
            setUnmodifiableSet = Collections.unmodifiableSet((HashSet) cVar.f3147d);
        }
        boolean zIsEmpty = setUnmodifiableSet.isEmpty();
        String str = this.f3143a;
        if (zIsEmpty) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(' ');
        synchronized (((HashSet) cVar.f3147d)) {
            setUnmodifiableSet2 = Collections.unmodifiableSet((HashSet) cVar.f3147d);
        }
        sb.append(b(setUnmodifiableSet2));
        return sb.toString();
    }
}
