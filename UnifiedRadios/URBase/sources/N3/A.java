package N3;

import S3.AbstractC0187a;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import s3.AbstractC0897g;
import s3.C0900j;
import w3.InterfaceC0936d;
import w3.InterfaceC0941i;

/* loaded from: classes.dex */
public abstract class A extends U3.h {

    /* renamed from: l, reason: collision with root package name */
    public int f1810l;

    public A(int i5) {
        super(0L, U3.k.g);
        this.f1810l = i5;
    }

    public abstract void b(Object obj, CancellationException cancellationException);

    public abstract InterfaceC0936d c();

    public Throwable d(Object obj) {
        C0138l c0138l = obj instanceof C0138l ? (C0138l) obj : null;
        if (c0138l != null) {
            return c0138l.f1860a;
        }
        return null;
    }

    public Object e(Object obj) {
        return obj;
    }

    public final void f(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            android.support.v4.media.session.b.b(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        F3.i.c(th);
        AbstractC0146u.g(c().getContext(), new C0145t("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object g();

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objC = C0900j.f9694a;
        U3.i iVar = this.f2491k;
        try {
            InterfaceC0936d interfaceC0936dC = c();
            F3.i.d(interfaceC0936dC, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            S3.h hVar = (S3.h) interfaceC0936dC;
            InterfaceC0936d interfaceC0936d = hVar.n;
            Object obj = hVar.f2395p;
            InterfaceC0941i context = interfaceC0936d.getContext();
            Object objL = AbstractC0187a.l(context, obj);
            if (objL != AbstractC0187a.f2384f) {
                AbstractC0146u.n(interfaceC0936d, context);
            }
            try {
                InterfaceC0941i context2 = interfaceC0936d.getContext();
                Object objG = g();
                Throwable thD = d(objG);
                P p4 = (thD == null && AbstractC0146u.i(this.f1810l)) ? (P) context2.o(r.f1871k) : null;
                if (p4 != null && !p4.a()) {
                    CancellationException cancellationExceptionW = ((Y) p4).w();
                    b(objG, cancellationExceptionW);
                    interfaceC0936d.resumeWith(AbstractC0399v1.c(cancellationExceptionW));
                } else if (thD != null) {
                    interfaceC0936d.resumeWith(AbstractC0399v1.c(thD));
                } else {
                    interfaceC0936d.resumeWith(e(objG));
                }
                AbstractC0187a.h(context, objL);
                try {
                    iVar.getClass();
                } catch (Throwable th) {
                    objC = AbstractC0399v1.c(th);
                }
                f(null, AbstractC0897g.a(objC));
            } catch (Throwable th2) {
                AbstractC0187a.h(context, objL);
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                iVar.getClass();
            } catch (Throwable th4) {
                objC = AbstractC0399v1.c(th4);
            }
            f(th3, AbstractC0897g.a(objC));
        }
    }
}
