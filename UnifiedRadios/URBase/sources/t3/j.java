package t3;

import com.google.android.gms.internal.measurement.AbstractC0296a2;
import java.util.List;

/* loaded from: classes.dex */
public abstract class j extends AbstractC0296a2 {
    public static int x(List list) {
        F3.i.f(list, "<this>");
        return list.size() - 1;
    }

    public static List y(Object... objArr) {
        F3.i.f(objArr, "elements");
        return objArr.length > 0 ? h.r(objArr) : q.f9711j;
    }

    public static void z() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
