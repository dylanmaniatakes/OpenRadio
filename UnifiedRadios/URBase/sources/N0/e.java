package N0;

import h4.r;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class e extends r {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f1770a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f1771b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f1772c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f1773d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f1774e;

    public e(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f1770a = atomicReferenceFieldUpdater;
        this.f1771b = atomicReferenceFieldUpdater2;
        this.f1772c = atomicReferenceFieldUpdater3;
        this.f1773d = atomicReferenceFieldUpdater4;
        this.f1774e = atomicReferenceFieldUpdater5;
    }

    @Override // h4.r
    public final boolean a(i iVar, d dVar, d dVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f1773d;
            if (atomicReferenceFieldUpdater.compareAndSet(iVar, dVar, dVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(iVar) == dVar);
        return false;
    }

    @Override // h4.r
    public final boolean b(i iVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f1774e;
            if (atomicReferenceFieldUpdater.compareAndSet(iVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(iVar) == obj);
        return false;
    }

    @Override // h4.r
    public final boolean c(i iVar, h hVar, h hVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f1772c;
            if (atomicReferenceFieldUpdater.compareAndSet(iVar, hVar, hVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(iVar) == hVar);
        return false;
    }

    @Override // h4.r
    public final void m(h hVar, h hVar2) {
        this.f1771b.lazySet(hVar, hVar2);
    }

    @Override // h4.r
    public final void n(h hVar, Thread thread) {
        this.f1770a.lazySet(hVar, thread);
    }
}
