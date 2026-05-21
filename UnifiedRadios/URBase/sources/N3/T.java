package N3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class T extends Y {

    /* renamed from: l, reason: collision with root package name */
    public final boolean f1825l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T(P p4) {
        super(true);
        boolean z4 = true;
        E(p4);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = Y.f1839k;
        InterfaceC0134h interfaceC0134h = (InterfaceC0134h) atomicReferenceFieldUpdater.get(this);
        C0135i c0135i = interfaceC0134h instanceof C0135i ? (C0135i) interfaceC0134h : null;
        if (c0135i == null) {
            z4 = false;
            break;
        }
        Y yK = c0135i.k();
        while (!yK.y()) {
            InterfaceC0134h interfaceC0134h2 = (InterfaceC0134h) atomicReferenceFieldUpdater.get(yK);
            C0135i c0135i2 = interfaceC0134h2 instanceof C0135i ? (C0135i) interfaceC0134h2 : null;
            if (c0135i2 == null) {
                z4 = false;
                break;
            }
            yK = c0135i2.k();
        }
        this.f1825l = z4;
    }

    @Override // N3.Y
    public final boolean y() {
        return this.f1825l;
    }
}
