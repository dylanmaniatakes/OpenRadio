package W2;

import E2.b;
import E2.c;
import E2.d;
import F2.e;
import F2.r;
import F2.t;
import F3.i;
import N3.I;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class a implements e {

    /* renamed from: d, reason: collision with root package name */
    public static final a f2613d = new a(0);

    /* renamed from: e, reason: collision with root package name */
    public static final a f2614e = new a(1);

    /* renamed from: f, reason: collision with root package name */
    public static final a f2615f = new a(2);
    public static final a g = new a(3);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2616c;

    public /* synthetic */ a(int i5) {
        this.f2616c = i5;
    }

    @Override // F2.e
    public final Object b(t tVar) {
        switch (this.f2616c) {
            case 0:
                Object objC = tVar.c(new r(E2.a.class, Executor.class));
                i.e(objC, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return new I((Executor) objC);
            case 1:
                Object objC2 = tVar.c(new r(c.class, Executor.class));
                i.e(objC2, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return new I((Executor) objC2);
            case 2:
                Object objC3 = tVar.c(new r(b.class, Executor.class));
                i.e(objC3, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return new I((Executor) objC3);
            default:
                Object objC4 = tVar.c(new r(d.class, Executor.class));
                i.e(objC4, "c.get(Qualified.qualifie…a, Executor::class.java))");
                return new I((Executor) objC4);
        }
    }
}
