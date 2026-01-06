package y3;

import N3.AbstractC0143q;
import N3.C0131e;
import S3.AbstractC0187a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import w3.C0937e;
import w3.InterfaceC0936d;
import w3.InterfaceC0938f;
import w3.InterfaceC0939g;
import w3.InterfaceC0941i;

/* renamed from: y3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0989c extends AbstractC0987a {
    private final InterfaceC0941i _context;
    private transient InterfaceC0936d intercepted;

    public AbstractC0989c(InterfaceC0936d interfaceC0936d, InterfaceC0941i interfaceC0941i) {
        super(interfaceC0936d);
        this._context = interfaceC0941i;
    }

    @Override // w3.InterfaceC0936d
    public InterfaceC0941i getContext() {
        InterfaceC0941i interfaceC0941i = this._context;
        F3.i.c(interfaceC0941i);
        return interfaceC0941i;
    }

    public final InterfaceC0936d intercepted() {
        InterfaceC0936d hVar = this.intercepted;
        if (hVar == null) {
            InterfaceC0938f interfaceC0938f = (InterfaceC0938f) getContext().o(C0937e.f10142j);
            hVar = interfaceC0938f != null ? new S3.h((AbstractC0143q) interfaceC0938f, this) : this;
            this.intercepted = hVar;
        }
        return hVar;
    }

    @Override // y3.AbstractC0987a
    public void releaseIntercepted() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        InterfaceC0936d interfaceC0936d = this.intercepted;
        if (interfaceC0936d != null && interfaceC0936d != this) {
            InterfaceC0939g interfaceC0939gO = getContext().o(C0937e.f10142j);
            F3.i.c(interfaceC0939gO);
            S3.h hVar = (S3.h) interfaceC0936d;
            do {
                atomicReferenceFieldUpdater = S3.h.f2392q;
            } while (atomicReferenceFieldUpdater.get(hVar) == AbstractC0187a.f2382d);
            Object obj = atomicReferenceFieldUpdater.get(hVar);
            C0131e c0131e = obj instanceof C0131e ? (C0131e) obj : null;
            if (c0131e != null) {
                c0131e.l();
            }
        }
        this.intercepted = C0988b.f10523j;
    }

    public AbstractC0989c(InterfaceC0936d interfaceC0936d) {
        this(interfaceC0936d, interfaceC0936d != null ? interfaceC0936d.getContext() : null);
    }
}
