package U3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2501b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f2502c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f2503d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f2504e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f2505a = new AtomicReferenceArray(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    public final h a(h hVar) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f2502c;
        if (atomicIntegerFieldUpdater.get(this) - f2503d.get(this) == 127) {
            return hVar;
        }
        if (hVar.f2491k.f2492c == 1) {
            f2504e.incrementAndGet(this);
        }
        int i5 = atomicIntegerFieldUpdater.get(this) & 127;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.f2505a;
            if (atomicReferenceArray.get(i5) == null) {
                atomicReferenceArray.lazySet(i5, hVar);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
            Thread.yield();
        }
    }

    public final h b() {
        h hVar;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f2503d;
            int i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 - f2502c.get(this) == 0) {
                return null;
            }
            int i6 = i5 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i5, i5 + 1) && (hVar = (h) this.f2505a.getAndSet(i6, null)) != null) {
                if (hVar.f2491k.f2492c == 1) {
                    f2504e.decrementAndGet(this);
                }
                return hVar;
            }
        }
    }

    public final h c(int i5, boolean z4) {
        int i6 = i5 & 127;
        AtomicReferenceArray atomicReferenceArray = this.f2505a;
        h hVar = (h) atomicReferenceArray.get(i6);
        if (hVar != null) {
            if ((hVar.f2491k.f2492c == 1) == z4) {
                while (!atomicReferenceArray.compareAndSet(i6, hVar, null)) {
                    if (atomicReferenceArray.get(i6) != hVar) {
                    }
                }
                if (z4) {
                    f2504e.decrementAndGet(this);
                }
                return hVar;
            }
        }
        return null;
    }
}
