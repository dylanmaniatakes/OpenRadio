package L3;

import com.google.android.gms.internal.measurement.AbstractC0296a2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t3.q;

/* loaded from: classes.dex */
public abstract class e extends f {
    public static List x(c cVar) {
        Iterator it = cVar.iterator();
        if (!it.hasNext()) {
            return q.f9711j;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return AbstractC0296a2.i(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
