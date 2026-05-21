package A2;

import F2.r;
import F2.t;
import N3.I;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class h implements F2.e {

    /* renamed from: d, reason: collision with root package name */
    public static final h f33d = new h(0);

    /* renamed from: e, reason: collision with root package name */
    public static final h f34e = new h(1);

    /* renamed from: f, reason: collision with root package name */
    public static final h f35f = new h(2);
    public static final h g = new h(3);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f36c;

    public /* synthetic */ h(int i5) {
        this.f36c = i5;
    }

    @Override // F2.e
    public final Object b(t tVar) {
        switch (this.f36c) {
            case 0:
                Object objC = tVar.c(new r(E2.a.class, Executor.class));
                F3.i.e(objC, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return new I((Executor) objC);
            case 1:
                Object objC2 = tVar.c(new r(E2.c.class, Executor.class));
                F3.i.e(objC2, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return new I((Executor) objC2);
            case 2:
                Object objC3 = tVar.c(new r(E2.b.class, Executor.class));
                F3.i.e(objC3, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return new I((Executor) objC3);
            default:
                Object objC4 = tVar.c(new r(E2.d.class, Executor.class));
                F3.i.e(objC4, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return new I((Executor) objC4);
        }
    }
}
