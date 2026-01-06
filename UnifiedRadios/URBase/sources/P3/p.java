package P3;

import N3.AbstractC0127a;
import N3.AbstractC0146u;
import N3.C0138l;
import N3.Q;
import N3.W;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import w3.InterfaceC0936d;
import w3.InterfaceC0941i;

/* loaded from: classes.dex */
public final class p extends AbstractC0127a implements q, h {

    /* renamed from: m, reason: collision with root package name */
    public final h f2126m;

    public p(InterfaceC0941i interfaceC0941i, d dVar) {
        super(interfaceC0941i, true);
        this.f2126m = dVar;
    }

    @Override // N3.AbstractC0127a
    public final void R(Throwable th, boolean z4) {
        if (this.f2126m.b(th) || z4) {
            return;
        }
        AbstractC0146u.g(this.f1840l, th);
    }

    @Override // N3.AbstractC0127a
    public final void S(Object obj) {
        this.f2126m.b(null);
    }

    @Override // P3.t
    public final boolean b(Throwable th) {
        return this.f2126m.b(th);
    }

    @Override // N3.Y, N3.P
    public final void c(CancellationException cancellationException) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objA = A();
        if (objA instanceof C0138l) {
            return;
        }
        if ((objA instanceof W) && ((W) objA).d()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new Q(r(), null, this);
        }
        p(cancellationException);
    }

    @Override // P3.t
    public final Object e(t3.t tVar, R3.c cVar) {
        return this.f2126m.e(tVar, cVar);
    }

    @Override // P3.s
    public final Object f(InterfaceC0936d interfaceC0936d) {
        return this.f2126m.f(interfaceC0936d);
    }

    @Override // P3.t
    public final void g(C0.m mVar) {
        this.f2126m.g(mVar);
    }

    @Override // P3.s
    public final Object h() {
        return this.f2126m.h();
    }

    @Override // P3.t
    public final Object i(Object obj) {
        return this.f2126m.i(obj);
    }

    @Override // P3.s
    public final a iterator() {
        return this.f2126m.iterator();
    }

    @Override // P3.t
    public final boolean j() {
        return this.f2126m.j();
    }

    @Override // N3.Y
    public final void p(CancellationException cancellationException) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f2126m.c(cancellationException);
        n(cancellationException);
    }
}
