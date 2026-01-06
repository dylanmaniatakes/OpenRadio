package P3;

import N3.AbstractC0146u;
import N3.C0131e;
import N3.i0;
import S3.v;
import S3.w;
import a.AbstractC0203a;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import w3.InterfaceC0941i;

/* loaded from: classes.dex */
public final class a implements i0 {

    /* renamed from: j, reason: collision with root package name */
    public Object f2079j = f.f2111p;

    /* renamed from: k, reason: collision with root package name */
    public C0131e f2080k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ d f2081l;

    public a(d dVar) {
        this.f2081l = dVar;
    }

    @Override // N3.i0
    public final void a(S3.u uVar, int i5) {
        C0131e c0131e = this.f2080k;
        if (c0131e != null) {
            c0131e.a(uVar, i5);
        }
    }

    public final Object b(Q3.g gVar) throws Throwable {
        C0131e c0131e;
        Boolean bool;
        S3.p pVar;
        int i5;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d.f2092q;
        d dVar = this.f2081l;
        l lVar = (l) atomicReferenceFieldUpdater.get(dVar);
        while (true) {
            dVar.getClass();
            if (dVar.v(d.f2088l.get(dVar), true)) {
                this.f2079j = f.f2108l;
                Throwable thR = dVar.r();
                if (thR == null) {
                    return Boolean.FALSE;
                }
                int i6 = v.f2420a;
                throw thR;
            }
            long andIncrement = d.f2089m.getAndIncrement(dVar);
            long j5 = f.f2100b;
            long j6 = andIncrement / j5;
            int i7 = (int) (andIncrement % j5);
            if (lVar.f2419l != j6) {
                l lVarQ = dVar.q(j6, lVar);
                if (lVarQ == null) {
                    continue;
                } else {
                    lVar = lVarQ;
                }
            }
            Object objF = dVar.F(lVar, i7, andIncrement, null);
            w wVar = f.f2109m;
            if (objF == wVar) {
                throw new IllegalStateException("unreachable".toString());
            }
            w wVar2 = f.f2110o;
            if (objF != wVar2) {
                if (objF != f.n) {
                    lVar.a();
                    this.f2079j = objF;
                    return Boolean.TRUE;
                }
                d dVar2 = this.f2081l;
                C0131e c0131eF = AbstractC0146u.f(AbstractC0203a.h(gVar));
                try {
                    this.f2080k = c0131eF;
                    c0131e = c0131eF;
                } catch (Throwable th) {
                    th = th;
                    c0131e = c0131eF;
                }
                try {
                    Object objF2 = dVar2.F(lVar, i7, andIncrement, this);
                    if (objF2 == wVar) {
                        a(lVar, i7);
                    } else {
                        InterfaceC0941i interfaceC0941i = c0131e.n;
                        E3.l lVar2 = dVar2.f2097k;
                        if (objF2 == wVar2) {
                            if (andIncrement < dVar2.t()) {
                                lVar.a();
                            }
                            l lVar3 = (l) d.f2092q.get(dVar2);
                            while (true) {
                                if (dVar2.v(d.f2088l.get(dVar2), true)) {
                                    C0131e c0131e2 = this.f2080k;
                                    F3.i.c(c0131e2);
                                    this.f2080k = null;
                                    this.f2079j = f.f2108l;
                                    Throwable thR2 = dVar.r();
                                    if (thR2 == null) {
                                        c0131e2.resumeWith(Boolean.FALSE);
                                    } else {
                                        c0131e2.resumeWith(AbstractC0399v1.c(thR2));
                                    }
                                } else {
                                    long andIncrement2 = d.f2089m.getAndIncrement(dVar2);
                                    long j7 = f.f2100b;
                                    long j8 = andIncrement2 / j7;
                                    int i8 = (int) (andIncrement2 % j7);
                                    if (lVar3.f2419l != j8) {
                                        l lVarQ2 = dVar2.q(j8, lVar3);
                                        if (lVarQ2 != null) {
                                            lVar3 = lVarQ2;
                                        }
                                    }
                                    E3.l lVar4 = lVar2;
                                    Object objF3 = dVar2.F(lVar3, i8, andIncrement2, this);
                                    if (objF3 == f.f2109m) {
                                        a(lVar3, i8);
                                        break;
                                    }
                                    if (objF3 == f.f2110o) {
                                        if (andIncrement2 < dVar2.t()) {
                                            lVar3.a();
                                        }
                                        lVar2 = lVar4;
                                    } else {
                                        if (objF3 == f.n) {
                                            throw new IllegalStateException("unexpected".toString());
                                        }
                                        lVar3.a();
                                        this.f2079j = objF3;
                                        this.f2080k = null;
                                        bool = Boolean.TRUE;
                                        pVar = lVar4 != null ? new S3.p(lVar4, objF3, interfaceC0941i) : null;
                                        i5 = c0131e.f1810l;
                                    }
                                }
                            }
                        } else {
                            lVar.a();
                            this.f2079j = objF2;
                            this.f2080k = null;
                            bool = Boolean.TRUE;
                            pVar = lVar2 != null ? new S3.p(lVar2, objF2, interfaceC0941i) : null;
                            i5 = c0131e.f1810l;
                        }
                        c0131e.v(bool, i5, pVar);
                    }
                    return c0131e.n();
                } catch (Throwable th2) {
                    th = th2;
                    c0131e.u();
                    throw th;
                }
            }
            if (andIncrement < dVar.t()) {
                lVar.a();
            }
        }
    }
}
