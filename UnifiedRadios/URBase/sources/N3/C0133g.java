package N3;

import S3.AbstractC0187a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s3.C0900j;
import w3.InterfaceC0936d;

/* renamed from: N3.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0133g extends S {
    public final C0131e n;

    public C0133g(C0131e c0131e) {
        this.n = c0131e;
    }

    @Override // E3.l
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        l((Throwable) obj);
        return C0900j.f9694a;
    }

    @Override // N3.U
    public final void l(Throwable th) {
        Y yK = k();
        C0131e c0131e = this.n;
        c0131e.getClass();
        CancellationException cancellationExceptionW = yK.w();
        if (c0131e.s()) {
            InterfaceC0936d interfaceC0936d = c0131e.f1847m;
            F3.i.d(interfaceC0936d, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            S3.h hVar = (S3.h) interfaceC0936d;
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = S3.h.f2392q;
                Object obj = atomicReferenceFieldUpdater.get(hVar);
                S3.w wVar = AbstractC0187a.f2382d;
                if (!F3.i.a(obj, wVar)) {
                    if (!(obj instanceof Throwable)) {
                        while (!atomicReferenceFieldUpdater.compareAndSet(hVar, obj, null)) {
                            if (atomicReferenceFieldUpdater.get(hVar) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    return;
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(hVar, wVar, cancellationExceptionW)) {
                    if (atomicReferenceFieldUpdater.get(hVar) != wVar) {
                        break;
                    }
                }
                return;
            }
        }
        c0131e.k(cancellationExceptionW);
        if (c0131e.s()) {
            return;
        }
        c0131e.l();
    }
}
