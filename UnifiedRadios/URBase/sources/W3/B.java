package W3;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class B {

    /* renamed from: a, reason: collision with root package name */
    public static final A f2623a = new A(new byte[0], 0, 0, false, false);

    /* renamed from: b, reason: collision with root package name */
    public static final int f2624b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f2625c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f2624b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i5 = 0; i5 < iHighestOneBit; i5++) {
            atomicReferenceArr[i5] = new AtomicReference();
        }
        f2625c = atomicReferenceArr;
    }

    public static final void a(A a2) {
        F3.i.f(a2, "segment");
        if (a2.f2622f != null || a2.g != null) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (a2.f2620d) {
            return;
        }
        AtomicReference atomicReference = f2625c[(int) (Thread.currentThread().getId() & (f2624b - 1))];
        A a3 = f2623a;
        A a4 = (A) atomicReference.getAndSet(a3);
        if (a4 == a3) {
            return;
        }
        int i5 = a4 != null ? a4.f2619c : 0;
        if (i5 >= 65536) {
            atomicReference.set(a4);
            return;
        }
        a2.f2622f = a4;
        a2.f2618b = 0;
        a2.f2619c = i5 + 8192;
        atomicReference.set(a2);
    }

    public static final A b() {
        AtomicReference atomicReference = f2625c[(int) (Thread.currentThread().getId() & (f2624b - 1))];
        A a2 = f2623a;
        A a3 = (A) atomicReference.getAndSet(a2);
        if (a3 == a2) {
            return new A();
        }
        if (a3 == null) {
            atomicReference.set(null);
            return new A();
        }
        atomicReference.set(a3.f2622f);
        a3.f2622f = null;
        a3.f2619c = 0;
        return a3;
    }
}
