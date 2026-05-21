package S3;

import N3.b0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import w3.InterfaceC0941i;

/* loaded from: classes.dex */
public abstract class u extends d implements b0 {

    /* renamed from: m, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f2418m = AtomicIntegerFieldUpdater.newUpdater(u.class, "cleanedAndPointers");
    private volatile int cleanedAndPointers;

    /* renamed from: l, reason: collision with root package name */
    public final long f2419l;

    public u(long j5, u uVar, int i5) {
        super(uVar);
        this.f2419l = j5;
        this.cleanedAndPointers = i5 << 16;
    }

    @Override // S3.d
    public final boolean c() {
        return f2418m.get(this) == f() && b() != null;
    }

    public final boolean e() {
        return f2418m.addAndGet(this, -65536) == f() && b() != null;
    }

    public abstract int f();

    public abstract void g(int i5, InterfaceC0941i interfaceC0941i);

    public final void h() {
        if (f2418m.incrementAndGet(this) == P3.f.f2100b) {
            d();
        }
    }

    public final boolean i() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i5;
        do {
            atomicIntegerFieldUpdater = f2418m;
            i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 == f() && b() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i5, 65536 + i5));
        return true;
    }
}
