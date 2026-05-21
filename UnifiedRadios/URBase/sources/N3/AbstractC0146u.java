package N3;

import S3.AbstractC0187a;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s3.AbstractC0897g;
import w3.C0937e;
import w3.C0942j;
import w3.InterfaceC0936d;
import w3.InterfaceC0941i;
import y3.InterfaceC0990d;

/* renamed from: N3.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0146u {

    /* renamed from: a, reason: collision with root package name */
    public static final S3.w f1872a = new S3.w("RESUME_TOKEN", 0);

    /* renamed from: b, reason: collision with root package name */
    public static final S3.w f1873b = new S3.w("CLOSED_EMPTY", 0);

    /* renamed from: c, reason: collision with root package name */
    public static final S3.w f1874c = new S3.w("COMPLETING_ALREADY", 0);

    /* renamed from: d, reason: collision with root package name */
    public static final S3.w f1875d = new S3.w("COMPLETING_WAITING_CHILDREN", 0);

    /* renamed from: e, reason: collision with root package name */
    public static final S3.w f1876e = new S3.w("COMPLETING_RETRY", 0);

    /* renamed from: f, reason: collision with root package name */
    public static final S3.w f1877f = new S3.w("TOO_LATE_TO_CANCEL", 0);
    public static final S3.w g = new S3.w("SEALED", 0);
    public static final D h = new D(false);

    /* renamed from: i, reason: collision with root package name */
    public static final D f1878i = new D(true);

    public static final S3.e a(InterfaceC0941i interfaceC0941i) {
        if (interfaceC0941i.o(r.f1871k) == null) {
            interfaceC0941i = interfaceC0941i.x(b());
        }
        return new S3.e(interfaceC0941i);
    }

    public static T b() {
        return new T(null);
    }

    public static C0150y c(S3.e eVar, E3.p pVar) {
        C0150y c0150y = new C0150y(k(eVar, C0942j.f10143j), true);
        c0150y.T(1, c0150y, pVar);
        return c0150y;
    }

    public static final void d(InterfaceC0941i interfaceC0941i, CancellationException cancellationException) {
        P p4 = (P) interfaceC0941i.o(r.f1871k);
        if (p4 != null) {
            p4.c(cancellationException);
        }
    }

    public static final String e(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final C0131e f(InterfaceC0936d interfaceC0936d) {
        C0131e c0131e;
        C0131e c0131e2;
        if (!(interfaceC0936d instanceof S3.h)) {
            return new C0131e(1, interfaceC0936d);
        }
        S3.h hVar = (S3.h) interfaceC0936d;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = S3.h.f2392q;
            Object obj = atomicReferenceFieldUpdater.get(hVar);
            S3.w wVar = AbstractC0187a.f2382d;
            c0131e = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(hVar, wVar);
                c0131e2 = null;
                break;
            }
            if (obj instanceof C0131e) {
                while (!atomicReferenceFieldUpdater.compareAndSet(hVar, obj, wVar)) {
                    if (atomicReferenceFieldUpdater.get(hVar) != obj) {
                        break;
                    }
                }
                c0131e2 = (C0131e) obj;
                break loop0;
            }
            if (obj != wVar && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (c0131e2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C0131e.f1845p;
            Object obj2 = atomicReferenceFieldUpdater2.get(c0131e2);
            if (!(obj2 instanceof C0137k) || ((C0137k) obj2).f1857d == null) {
                C0131e.f1844o.set(c0131e2, 536870911);
                atomicReferenceFieldUpdater2.set(c0131e2, C0128b.f1842j);
                c0131e = c0131e2;
            } else {
                c0131e2.l();
            }
            if (c0131e != null) {
                return c0131e;
            }
        }
        return new C0131e(2, interfaceC0936d);
    }

    public static final void g(InterfaceC0941i interfaceC0941i, Throwable th) {
        try {
            O3.b bVar = (O3.b) interfaceC0941i.o(r.f1870j);
            if (bVar != null) {
                bVar.W(interfaceC0941i, th);
            } else {
                AbstractC0187a.e(interfaceC0941i, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                android.support.v4.media.session.b.b(runtimeException, th);
                th = runtimeException;
            }
            AbstractC0187a.e(interfaceC0941i, th);
        }
    }

    public static /* synthetic */ C h(P p4, boolean z4, U u4, int i5) {
        if ((i5 & 1) != 0) {
            z4 = false;
        }
        return ((Y) p4).F(z4, (i5 & 2) != 0, u4);
    }

    public static final boolean i(int i5) {
        return i5 == 1 || i5 == 2;
    }

    public static void j(InterfaceC0144s interfaceC0144s, E3.p pVar) {
        AbstractC0127a d0Var = new d0(k(interfaceC0144s, C0942j.f10143j), true);
        d0Var.T(1, d0Var, pVar);
    }

    public static final InterfaceC0941i k(InterfaceC0144s interfaceC0144s, InterfaceC0941i interfaceC0941i) {
        InterfaceC0941i interfaceC0941iX;
        InterfaceC0941i interfaceC0941iD = interfaceC0144s.d();
        Boolean bool = Boolean.FALSE;
        C0140n c0140n = C0140n.f1864l;
        boolean zBooleanValue = ((Boolean) interfaceC0941iD.D(bool, c0140n)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) interfaceC0941i.D(bool, c0140n)).booleanValue();
        if (zBooleanValue || zBooleanValue2) {
            C0942j c0942j = C0942j.f10143j;
            InterfaceC0941i interfaceC0941i2 = (InterfaceC0941i) interfaceC0941iD.D(c0942j, new C0140n(2, 2));
            Object objD = interfaceC0941i;
            if (zBooleanValue2) {
                objD = interfaceC0941i.D(c0942j, C0140n.f1863k);
            }
            interfaceC0941iX = interfaceC0941i2.x((InterfaceC0941i) objD);
        } else {
            interfaceC0941iX = interfaceC0941iD.x(interfaceC0941i);
        }
        U3.d dVar = B.f1811a;
        return (interfaceC0941iX == dVar || interfaceC0941iX.o(C0937e.f10142j) != null) ? interfaceC0941iX : interfaceC0941iX.x(dVar);
    }

    public static final void l(A a2, InterfaceC0936d interfaceC0936d, boolean z4) {
        Object objG = a2.g();
        Throwable thD = a2.d(objG);
        Object objC = thD != null ? AbstractC0399v1.c(thD) : a2.e(objG);
        if (!z4) {
            interfaceC0936d.resumeWith(objC);
            return;
        }
        F3.i.d(interfaceC0936d, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        S3.h hVar = (S3.h) interfaceC0936d;
        InterfaceC0936d interfaceC0936d2 = hVar.n;
        InterfaceC0941i context = interfaceC0936d2.getContext();
        Object objL = AbstractC0187a.l(context, hVar.f2395p);
        if (objL != AbstractC0187a.f2384f) {
            n(interfaceC0936d2, context);
        }
        try {
            interfaceC0936d2.resumeWith(objC);
        } finally {
            AbstractC0187a.h(context, objL);
        }
    }

    public static final String m(InterfaceC0936d interfaceC0936d) {
        Object objC;
        if (interfaceC0936d instanceof S3.h) {
            return interfaceC0936d.toString();
        }
        try {
            objC = interfaceC0936d + '@' + e(interfaceC0936d);
        } catch (Throwable th) {
            objC = AbstractC0399v1.c(th);
        }
        if (AbstractC0897g.a(objC) != null) {
            objC = interfaceC0936d.getClass().getName() + '@' + e(interfaceC0936d);
        }
        return (String) objC;
    }

    public static final void n(InterfaceC0936d interfaceC0936d, InterfaceC0941i interfaceC0941i) {
        if ((interfaceC0936d instanceof InterfaceC0990d) && interfaceC0941i.o(h0.f1851j) != null) {
            InterfaceC0990d callerFrame = (InterfaceC0990d) interfaceC0936d;
            do {
                callerFrame = callerFrame.getCallerFrame();
            } while (callerFrame != null);
        }
    }
}
