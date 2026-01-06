package J1;

import java.util.concurrent.Callable;

/* renamed from: J1.z0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class CallableC0125z0 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1465a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1466b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1467c;

    public /* synthetic */ CallableC0125z0(Object obj, int i5, Object obj2) {
        this.f1465a = i5;
        this.f1467c = obj2;
        this.f1466b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f1465a) {
            case 0:
                E0 e02 = (E0) this.f1466b;
                e02.f728c.j();
                C0089n c0089n = e02.f728c.f1019e;
                V1.J(c0089n);
                return c0089n.r((String) this.f1467c);
            case 1:
                E0 e03 = (E0) this.f1466b;
                e03.f728c.j();
                return new C0074i(e03.f728c.a0(((b2) this.f1467c).f1138j));
            default:
                b2 b2Var = (b2) this.f1467c;
                String str = b2Var.f1138j;
                q1.E.i(str);
                V1 v12 = (V1) this.f1466b;
                K0 k0J0 = v12.j0(str);
                J0 j02 = J0.ANALYTICS_STORAGE;
                if (k0J0.k(j02) && K0.e(100, b2Var.f1126D).k(j02)) {
                    return v12.c0(b2Var).d();
                }
                v12.c().f1084p.a("Analytics storage consent denied. Returning null app instance id");
                return null;
        }
    }
}
