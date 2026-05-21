package N3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class U extends S3.k implements C, K, E3.l {

    /* renamed from: m, reason: collision with root package name */
    public Y f1826m;

    @Override // N3.K
    public final boolean a() {
        return true;
    }

    @Override // N3.C
    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2;
        Y yK = k();
        while (true) {
            Object objA = yK.A();
            if (objA instanceof U) {
                if (objA != this) {
                    return;
                }
                D d5 = AbstractC0146u.f1878i;
                do {
                    atomicReferenceFieldUpdater2 = Y.f1838j;
                    if (atomicReferenceFieldUpdater2.compareAndSet(yK, objA, d5)) {
                        return;
                    }
                } while (atomicReferenceFieldUpdater2.get(yK) == objA);
            } else {
                if (!(objA instanceof K) || ((K) objA).e() == null) {
                    return;
                }
                while (true) {
                    Object objH = h();
                    if (objH instanceof S3.r) {
                        S3.k kVar = ((S3.r) objH).f2416a;
                        return;
                    }
                    if (objH == this) {
                        return;
                    }
                    F3.i.d(objH, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                    S3.k kVar2 = (S3.k) objH;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = S3.k.f2403l;
                    S3.r rVar = (S3.r) atomicReferenceFieldUpdater3.get(kVar2);
                    if (rVar == null) {
                        rVar = new S3.r(kVar2);
                        atomicReferenceFieldUpdater3.lazySet(kVar2, rVar);
                    }
                    do {
                        atomicReferenceFieldUpdater = S3.k.f2401j;
                        if (atomicReferenceFieldUpdater.compareAndSet(this, objH, rVar)) {
                            kVar2.f();
                            return;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == objH);
                }
            }
        }
    }

    @Override // N3.K
    public final Z e() {
        return null;
    }

    public final Y k() {
        Y y4 = this.f1826m;
        if (y4 != null) {
            return y4;
        }
        F3.i.k("job");
        throw null;
    }

    public abstract void l(Throwable th);

    @Override // S3.k
    public final String toString() {
        return getClass().getSimpleName() + '@' + AbstractC0146u.e(this) + "[job@" + AbstractC0146u.e(k()) + ']';
    }
}
