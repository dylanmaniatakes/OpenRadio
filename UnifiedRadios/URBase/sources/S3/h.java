package S3;

import N3.AbstractC0143q;
import N3.AbstractC0146u;
import N3.C0138l;
import N3.C0139m;
import N3.G;
import N3.f0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s3.AbstractC0897g;
import w3.InterfaceC0936d;
import w3.InterfaceC0941i;
import y3.InterfaceC0990d;

/* loaded from: classes.dex */
public final class h extends N3.A implements InterfaceC0990d, InterfaceC0936d {

    /* renamed from: q, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2392q = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: m, reason: collision with root package name */
    public final AbstractC0143q f2393m;
    public final InterfaceC0936d n;

    /* renamed from: o, reason: collision with root package name */
    public Object f2394o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f2395p;

    public h(AbstractC0143q abstractC0143q, InterfaceC0936d interfaceC0936d) {
        super(-1);
        this.f2393m = abstractC0143q;
        this.n = interfaceC0936d;
        this.f2394o = AbstractC0187a.f2381c;
        Object objD = interfaceC0936d.getContext().D(0, y.f2424k);
        F3.i.c(objD);
        this.f2395p = objD;
    }

    @Override // N3.A
    public final void b(Object obj, CancellationException cancellationException) {
        if (obj instanceof C0139m) {
            ((C0139m) obj).f1862b.invoke(cancellationException);
        }
    }

    @Override // N3.A
    public final InterfaceC0936d c() {
        return this;
    }

    @Override // N3.A
    public final Object g() {
        Object obj = this.f2394o;
        this.f2394o = AbstractC0187a.f2381c;
        return obj;
    }

    @Override // y3.InterfaceC0990d
    public final InterfaceC0990d getCallerFrame() {
        InterfaceC0936d interfaceC0936d = this.n;
        if (interfaceC0936d instanceof InterfaceC0990d) {
            return (InterfaceC0990d) interfaceC0936d;
        }
        return null;
    }

    @Override // w3.InterfaceC0936d
    public final InterfaceC0941i getContext() {
        return this.n.getContext();
    }

    @Override // w3.InterfaceC0936d
    public final void resumeWith(Object obj) {
        InterfaceC0936d interfaceC0936d = this.n;
        InterfaceC0941i context = interfaceC0936d.getContext();
        Throwable thA = AbstractC0897g.a(obj);
        Object c0138l = thA == null ? obj : new C0138l(thA, false);
        AbstractC0143q abstractC0143q = this.f2393m;
        if (abstractC0143q.Y()) {
            this.f2394o = c0138l;
            this.f1810l = 0;
            abstractC0143q.W(context, this);
            return;
        }
        G gA = f0.a();
        if (gA.d0()) {
            this.f2394o = c0138l;
            this.f1810l = 0;
            gA.a0(this);
            return;
        }
        gA.c0(true);
        try {
            InterfaceC0941i context2 = interfaceC0936d.getContext();
            Object objL = AbstractC0187a.l(context2, this.f2395p);
            try {
                interfaceC0936d.resumeWith(obj);
                while (gA.e0()) {
                }
            } finally {
                AbstractC0187a.h(context2, objL);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f2393m + ", " + AbstractC0146u.m(this.n) + ']';
    }
}
