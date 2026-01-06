package F3;

import E3.p;
import E3.r;
import java.util.List;
import q0.C0839b;
import s3.InterfaceC0891a;

/* loaded from: classes.dex */
public abstract class o {
    public static List a(Object obj) {
        if ((obj instanceof G3.a) && !(obj instanceof G3.b)) {
            c(obj, "kotlin.collections.MutableList");
            throw null;
        }
        try {
            return (List) obj;
        } catch (ClassCastException e5) {
            i.j(e5, o.class.getName());
            throw e5;
        }
    }

    public static void b(int i5, Object obj) {
        if (obj != null) {
            if (obj instanceof InterfaceC0891a) {
                if ((obj instanceof g ? ((g) obj).getArity() : obj instanceof E3.a ? 0 : obj instanceof E3.l ? 1 : obj instanceof p ? 2 : obj instanceof H0.h ? 3 : obj instanceof C0839b ? 4 : obj instanceof r ? 6 : -1) == i5) {
                    return;
                }
            }
            c(obj, "kotlin.jvm.functions.Function" + i5);
            throw null;
        }
    }

    public static void c(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
        i.j(classCastException, o.class.getName());
        throw classCastException;
    }
}
