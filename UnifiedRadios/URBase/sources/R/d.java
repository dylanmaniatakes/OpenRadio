package r;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class d extends AbstractC0930a {

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f9491d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f9492e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f9493f;
    public final AtomicReferenceFieldUpdater g;
    public final AtomicReferenceFieldUpdater h;

    public d(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f9491d = atomicReferenceFieldUpdater;
        this.f9492e = atomicReferenceFieldUpdater2;
        this.f9493f = atomicReferenceFieldUpdater3;
        this.g = atomicReferenceFieldUpdater4;
        this.h = atomicReferenceFieldUpdater5;
    }

    @Override // w1.AbstractC0930a
    public final boolean e(g gVar, c cVar, c cVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.g;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, cVar, cVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == cVar);
        return false;
    }

    @Override // w1.AbstractC0930a
    public final boolean f(g gVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.h;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == obj);
        return false;
    }

    @Override // w1.AbstractC0930a
    public final boolean g(g gVar, f fVar, f fVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f9493f;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, fVar, fVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == fVar);
        return false;
    }

    @Override // w1.AbstractC0930a
    public final void m(f fVar, f fVar2) {
        this.f9492e.lazySet(fVar, fVar2);
    }

    @Override // w1.AbstractC0930a
    public final void n(f fVar, Thread thread) {
        this.f9491d.lazySet(fVar, thread);
    }
}
