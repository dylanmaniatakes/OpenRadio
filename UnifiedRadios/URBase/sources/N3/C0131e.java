package N3;

import S3.AbstractC0187a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s3.AbstractC0897g;
import w3.InterfaceC0936d;
import w3.InterfaceC0941i;
import x3.EnumC0973a;
import y3.InterfaceC0990d;

/* renamed from: N3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0131e extends A implements InterfaceC0130d, InterfaceC0990d, i0 {

    /* renamed from: o, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f1844o = AtomicIntegerFieldUpdater.newUpdater(C0131e.class, "_decisionAndIndex");

    /* renamed from: p, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1845p = AtomicReferenceFieldUpdater.newUpdater(C0131e.class, Object.class, "_state");

    /* renamed from: q, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1846q = AtomicReferenceFieldUpdater.newUpdater(C0131e.class, Object.class, "_parentHandle");
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* renamed from: m, reason: collision with root package name */
    public final InterfaceC0936d f1847m;
    public final InterfaceC0941i n;

    public C0131e(int i5, InterfaceC0936d interfaceC0936d) {
        super(i5);
        this.f1847m = interfaceC0936d;
        this.n = interfaceC0936d.getContext();
        this._decisionAndIndex = 536870911;
        this._state = C0128b.f1842j;
    }

    public static void t(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public static Object w(b0 b0Var, Object obj, int i5, E3.l lVar) {
        if ((obj instanceof C0138l) || !AbstractC0146u.i(i5)) {
            return obj;
        }
        if (lVar != null || (b0Var instanceof M)) {
            return new C0137k(obj, b0Var instanceof M ? (M) b0Var : null, lVar, (CancellationException) null, 16);
        }
        return obj;
    }

    @Override // N3.i0
    public final void a(S3.u uVar, int i5) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i6;
        do {
            atomicIntegerFieldUpdater = f1844o;
            i6 = atomicIntegerFieldUpdater.get(this);
            if ((i6 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, ((i6 >> 29) << 29) + i5));
        r(uVar);
    }

    @Override // N3.A
    public final void b(Object obj, CancellationException cancellationException) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1845p;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof b0) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof C0138l) {
                return;
            }
            if (!(obj2 instanceof C0137k)) {
                C0137k c0137k = new C0137k(obj2, (M) null, (E3.l) null, cancellationException, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, c0137k)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                return;
            }
            C0137k c0137k2 = (C0137k) obj2;
            if (!(!(c0137k2.f1858e != null))) {
                throw new IllegalStateException("Must be called at most once".toString());
            }
            C0137k c0137kA = C0137k.a(c0137k2, null, cancellationException, 15);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, c0137kA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    break;
                }
            }
            M m5 = c0137k2.f1855b;
            if (m5 != null) {
                h(m5, cancellationException);
            }
            E3.l lVar = c0137k2.f1856c;
            if (lVar != null) {
                i(lVar, cancellationException);
                return;
            }
            return;
        }
    }

    @Override // N3.A
    public final InterfaceC0936d c() {
        return this.f1847m;
    }

    @Override // N3.A
    public final Throwable d(Object obj) {
        Throwable thD = super.d(obj);
        if (thD != null) {
            return thD;
        }
        return null;
    }

    @Override // N3.A
    public final Object e(Object obj) {
        return obj instanceof C0137k ? ((C0137k) obj).f1854a : obj;
    }

    @Override // N3.A
    public final Object g() {
        return f1845p.get(this);
    }

    @Override // y3.InterfaceC0990d
    public final InterfaceC0990d getCallerFrame() {
        InterfaceC0936d interfaceC0936d = this.f1847m;
        if (interfaceC0936d instanceof InterfaceC0990d) {
            return (InterfaceC0990d) interfaceC0936d;
        }
        return null;
    }

    @Override // w3.InterfaceC0936d
    public final InterfaceC0941i getContext() {
        return this.n;
    }

    public final void h(M m5, Throwable th) {
        try {
            m5.a(th);
        } catch (Throwable th2) {
            AbstractC0146u.g(this.n, new F1.b("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void i(E3.l lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            AbstractC0146u.g(this.n, new F1.b("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void j(S3.u uVar, Throwable th) {
        InterfaceC0941i interfaceC0941i = this.n;
        int i5 = f1844o.get(this) & 536870911;
        if (i5 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
        try {
            uVar.g(i5, interfaceC0941i);
        } catch (Throwable th2) {
            AbstractC0146u.g(interfaceC0941i, new F1.b("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void k(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1845p;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof b0) {
                C0132f c0132f = new C0132f(this, th, (obj instanceof M) || (obj instanceof S3.u));
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0132f)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                b0 b0Var = (b0) obj;
                if (b0Var instanceof M) {
                    h((M) obj, th);
                } else if (b0Var instanceof S3.u) {
                    j((S3.u) obj, th);
                }
                if (!s()) {
                    l();
                }
                m(this.f1810l);
                return;
            }
            return;
        }
    }

    public final void l() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1846q;
        C c2 = (C) atomicReferenceFieldUpdater.get(this);
        if (c2 == null) {
            return;
        }
        c2.b();
        atomicReferenceFieldUpdater.set(this, a0.f1841j);
    }

    public final void m(int i5) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i6;
        do {
            atomicIntegerFieldUpdater = f1844o;
            i6 = atomicIntegerFieldUpdater.get(this);
            int i7 = i6 >> 29;
            if (i7 != 0) {
                if (i7 != 1) {
                    throw new IllegalStateException("Already resumed".toString());
                }
                boolean z4 = i5 == 4;
                InterfaceC0936d interfaceC0936d = this.f1847m;
                if (z4 || !(interfaceC0936d instanceof S3.h) || AbstractC0146u.i(i5) != AbstractC0146u.i(this.f1810l)) {
                    AbstractC0146u.l(this, interfaceC0936d, z4);
                    return;
                }
                AbstractC0143q abstractC0143q = ((S3.h) interfaceC0936d).f2393m;
                InterfaceC0941i context = ((S3.h) interfaceC0936d).n.getContext();
                if (abstractC0143q.Y()) {
                    abstractC0143q.W(context, this);
                    return;
                }
                G gA = f0.a();
                if (gA.d0()) {
                    gA.a0(this);
                    return;
                }
                gA.c0(true);
                try {
                    AbstractC0146u.l(this, interfaceC0936d, true);
                    do {
                    } while (gA.e0());
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i6, 1073741824 + (536870911 & i6)));
    }

    public final Object n() throws Throwable {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i5;
        boolean zS = s();
        do {
            atomicIntegerFieldUpdater = f1844o;
            i5 = atomicIntegerFieldUpdater.get(this);
            int i6 = i5 >> 29;
            if (i6 != 0) {
                if (i6 != 2) {
                    throw new IllegalStateException("Already suspended".toString());
                }
                if (zS) {
                    u();
                }
                Object obj = f1845p.get(this);
                if (obj instanceof C0138l) {
                    throw ((C0138l) obj).f1860a;
                }
                if (AbstractC0146u.i(this.f1810l)) {
                    P p4 = (P) this.n.o(r.f1871k);
                    if (p4 != null && !p4.a()) {
                        CancellationException cancellationExceptionW = ((Y) p4).w();
                        b(obj, cancellationExceptionW);
                        throw cancellationExceptionW;
                    }
                }
                return e(obj);
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, 536870912 + (536870911 & i5)));
        if (((C) f1846q.get(this)) == null) {
            p();
        }
        if (zS) {
            u();
        }
        return EnumC0973a.f10448j;
    }

    public final void o() {
        C cP = p();
        if (cP != null && (!(f1845p.get(this) instanceof b0))) {
            cP.b();
            f1846q.set(this, a0.f1841j);
        }
    }

    public final C p() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        P p4 = (P) this.n.o(r.f1871k);
        if (p4 == null) {
            return null;
        }
        C cH = AbstractC0146u.h(p4, true, new C0133g(this), 2);
        do {
            atomicReferenceFieldUpdater = f1846q;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, cH)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return cH;
    }

    public final void q(E3.l lVar) {
        r(lVar instanceof M ? (M) lVar : new M(lVar));
    }

    public final void r(Object obj) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1845p;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof C0128b) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, obj)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                return;
            }
            if (obj2 instanceof M ? true : obj2 instanceof S3.u) {
                t(obj, obj2);
                throw null;
            }
            if (obj2 instanceof C0138l) {
                C0138l c0138l = (C0138l) obj2;
                c0138l.getClass();
                if (!C0138l.f1859b.compareAndSet(c0138l, 0, 1)) {
                    t(obj, obj2);
                    throw null;
                }
                if (obj2 instanceof C0132f) {
                    if (!(obj2 instanceof C0138l)) {
                        c0138l = null;
                    }
                    Throwable th = c0138l != null ? c0138l.f1860a : null;
                    if (obj instanceof M) {
                        h((M) obj, th);
                        return;
                    } else {
                        F3.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        j((S3.u) obj, th);
                        return;
                    }
                }
                return;
            }
            if (!(obj2 instanceof C0137k)) {
                if (obj instanceof S3.u) {
                    return;
                }
                F3.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                C0137k c0137k = new C0137k(obj2, (M) obj, (E3.l) null, (CancellationException) null, 28);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, c0137k)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                return;
            }
            C0137k c0137k2 = (C0137k) obj2;
            if (c0137k2.f1855b != null) {
                t(obj, obj2);
                throw null;
            }
            if (obj instanceof S3.u) {
                return;
            }
            F3.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
            M m5 = (M) obj;
            Throwable th2 = c0137k2.f1858e;
            if (th2 != null) {
                h(m5, th2);
                return;
            }
            C0137k c0137kA = C0137k.a(c0137k2, m5, null, 29);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, c0137kA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // w3.InterfaceC0936d
    public final void resumeWith(Object obj) {
        Throwable thA = AbstractC0897g.a(obj);
        if (thA != null) {
            obj = new C0138l(thA, false);
        }
        v(obj, this.f1810l, null);
    }

    public final boolean s() {
        if (this.f1810l == 2) {
            InterfaceC0936d interfaceC0936d = this.f1847m;
            F3.i.d(interfaceC0936d, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (S3.h.f2392q.get((S3.h) interfaceC0936d) != null) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CancellableContinuation(");
        sb.append(AbstractC0146u.m(this.f1847m));
        sb.append("){");
        Object obj = f1845p.get(this);
        sb.append(obj instanceof b0 ? "Active" : obj instanceof C0132f ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(AbstractC0146u.e(this));
        return sb.toString();
    }

    public final void u() {
        InterfaceC0936d interfaceC0936d = this.f1847m;
        Throwable th = null;
        S3.h hVar = interfaceC0936d instanceof S3.h ? (S3.h) interfaceC0936d : null;
        if (hVar != null) {
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = S3.h.f2392q;
                Object obj = atomicReferenceFieldUpdater.get(hVar);
                S3.w wVar = AbstractC0187a.f2382d;
                if (obj == wVar) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(hVar, wVar, this)) {
                        if (atomicReferenceFieldUpdater.get(hVar) != wVar) {
                            break;
                        }
                    }
                    break loop0;
                } else {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(hVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(hVar) != obj) {
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                    }
                    th = (Throwable) obj;
                }
            }
            if (th == null) {
                return;
            }
            l();
            k(th);
        }
    }

    public final void v(Object obj, int i5, E3.l lVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1845p;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof b0) {
                Object objW = w((b0) obj2, obj, i5, lVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objW)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!s()) {
                    l();
                }
                m(i5);
                return;
            }
            if (obj2 instanceof C0132f) {
                C0132f c0132f = (C0132f) obj2;
                c0132f.getClass();
                if (C0132f.f1848c.compareAndSet(c0132f, 0, 1)) {
                    if (lVar != null) {
                        i(lVar, c0132f.f1860a);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
        }
    }
}
