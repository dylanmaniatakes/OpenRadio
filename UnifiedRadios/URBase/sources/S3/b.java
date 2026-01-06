package S3;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class b extends q {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f2385a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");
    private volatile Object _consensus = AbstractC0187a.f2379a;

    @Override // S3.q
    public final Object a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2385a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        w wVar = AbstractC0187a.f2379a;
        if (obj2 == wVar) {
            w wVarC = c(obj);
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 == wVar) {
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, wVar, wVarC)) {
                        obj2 = wVarC;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != wVar) {
                        obj2 = atomicReferenceFieldUpdater.get(this);
                        break;
                    }
                }
            }
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(Object obj, Object obj2);

    public abstract w c(Object obj);
}
