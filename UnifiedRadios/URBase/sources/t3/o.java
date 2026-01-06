package t3;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class o extends n {
    public static void B(Collection collection, Iterable iterable) {
        F3.i.f(collection, "<this>");
        F3.i.f(iterable, "elements");
        if (iterable instanceof Collection) {
            collection.addAll((Collection) iterable);
            return;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }
}
