package t3;

import java.util.Collection;

/* loaded from: classes.dex */
public abstract class k extends j {
    public static int A(Iterable iterable) {
        F3.i.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }
}
