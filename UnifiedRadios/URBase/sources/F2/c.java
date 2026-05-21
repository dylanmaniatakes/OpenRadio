package F2;

import java.util.Set;

/* loaded from: classes.dex */
public interface c {
    default Object a(Class cls) {
        return c(r.a(cls));
    }

    default Set b(r rVar) {
        return (Set) f(rVar).get();
    }

    default Object c(r rVar) {
        Q2.a aVarD = d(rVar);
        if (aVarD == null) {
            return null;
        }
        return aVarD.get();
    }

    Q2.a d(r rVar);

    default Q2.a e(Class cls) {
        return d(r.a(cls));
    }

    Q2.a f(r rVar);
}
