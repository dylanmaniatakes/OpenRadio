package t3;

import com.google.android.gms.internal.measurement.AbstractC0296a2;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class i extends o {
    public static final void C(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, E3.l lVar) {
        F3.i.f(iterable, "<this>");
        F3.i.f(charSequence, "separator");
        F3.i.f(charSequence2, "prefix");
        F3.i.f(charSequence3, "postfix");
        F3.i.f(charSequence4, "truncated");
        sb.append(charSequence2);
        int i6 = 0;
        for (Object obj : iterable) {
            i6++;
            if (i6 > 1) {
                sb.append(charSequence);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            } else {
                h4.d.a(sb, obj, lVar);
            }
        }
        if (i5 >= 0 && i6 > i5) {
            sb.append(charSequence4);
        }
        sb.append(charSequence3);
    }

    public static String E(Iterable iterable, String str, String str2, String str3, E3.l lVar, int i5) {
        if ((i5 & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i5 & 2) != 0 ? "" : str2;
        String str6 = (i5 & 4) != 0 ? "" : str3;
        if ((i5 & 32) != 0) {
            lVar = null;
        }
        F3.i.f(iterable, "<this>");
        F3.i.f(str4, "separator");
        F3.i.f(str5, "prefix");
        F3.i.f(str6, "postfix");
        StringBuilder sb = new StringBuilder();
        C(iterable, sb, str4, str5, str6, -1, "...", lVar);
        String string = sb.toString();
        F3.i.e(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static ArrayList F(Collection collection, Iterable iterable) {
        F3.i.f(collection, "<this>");
        F3.i.f(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            o.B(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static final void G(Iterable iterable, AbstractCollection abstractCollection) {
        F3.i.f(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static List H(Iterable iterable) {
        ArrayList arrayList;
        F3.i.f(iterable, "<this>");
        boolean z4 = iterable instanceof Collection;
        q qVar = q.f9711j;
        if (!z4) {
            if (z4) {
                arrayList = new ArrayList((Collection) iterable);
            } else {
                arrayList = new ArrayList();
                G(iterable, arrayList);
            }
            int size = arrayList.size();
            return size != 0 ? size != 1 ? arrayList : AbstractC0296a2.i(arrayList.get(0)) : qVar;
        }
        Collection collection = (Collection) iterable;
        int size2 = collection.size();
        if (size2 == 0) {
            return qVar;
        }
        if (size2 != 1) {
            return new ArrayList(collection);
        }
        return AbstractC0296a2.i(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }
}
