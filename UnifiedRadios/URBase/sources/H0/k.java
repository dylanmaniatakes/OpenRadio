package H0;

import C0.t;
import L0.o;
import N3.AbstractC0143q;
import N3.AbstractC0146u;
import N3.T;
import f3.C0519j;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final String f660a;

    static {
        String strF = t.f("WorkConstraintsTracker");
        F3.i.e(strF, "tagWithPrefix(\"WorkConstraintsTracker\")");
        f660a = strF;
    }

    public static final T a(C0519j c0519j, o oVar, AbstractC0143q abstractC0143q, e eVar) {
        F3.i.f(c0519j, "<this>");
        F3.i.f(abstractC0143q, "dispatcher");
        F3.i.f(eVar, "listener");
        T tB = AbstractC0146u.b();
        AbstractC0146u.j(AbstractC0146u.a(A2.b.u(abstractC0143q, tB)), new j(c0519j, oVar, eVar, null));
        return tB;
    }
}
