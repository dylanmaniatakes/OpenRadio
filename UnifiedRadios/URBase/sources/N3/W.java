package N3;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class W implements K {

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f1830k = AtomicIntegerFieldUpdater.newUpdater(W.class, "_isCompleting");

    /* renamed from: l, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1831l = AtomicReferenceFieldUpdater.newUpdater(W.class, Object.class, "_rootCause");

    /* renamed from: m, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1832m = AtomicReferenceFieldUpdater.newUpdater(W.class, Object.class, "_exceptionsHolder");
    private volatile Object _exceptionsHolder;
    private volatile int _isCompleting = 0;
    private volatile Object _rootCause;

    /* renamed from: j, reason: collision with root package name */
    public final Z f1833j;

    public W(Z z4, Throwable th) {
        this.f1833j = z4;
        this._rootCause = th;
    }

    @Override // N3.K
    public final boolean a() {
        return c() == null;
    }

    public final void b(Throwable th) {
        Throwable thC = c();
        if (thC == null) {
            f1831l.set(this, th);
            return;
        }
        if (th == thC) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1832m;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            atomicReferenceFieldUpdater.set(this, th);
            return;
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
                return;
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
        }
        if (th == obj) {
            return;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(th);
        atomicReferenceFieldUpdater.set(this, arrayList);
    }

    public final Throwable c() {
        return (Throwable) f1831l.get(this);
    }

    public final boolean d() {
        return c() != null;
    }

    @Override // N3.K
    public final Z e() {
        return this.f1833j;
    }

    public final boolean f() {
        return f1830k.get(this) != 0;
    }

    public final ArrayList g(Throwable th) {
        ArrayList arrayList;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1832m;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            arrayList = new ArrayList(4);
        } else if (obj instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(obj);
            arrayList = arrayList2;
        } else {
            if (!(obj instanceof ArrayList)) {
                throw new IllegalStateException(("State is " + obj).toString());
            }
            arrayList = (ArrayList) obj;
        }
        Throwable thC = c();
        if (thC != null) {
            arrayList.add(0, thC);
        }
        if (th != null && !th.equals(thC)) {
            arrayList.add(th);
        }
        atomicReferenceFieldUpdater.set(this, AbstractC0146u.g);
        return arrayList;
    }

    public final String toString() {
        return "Finishing[cancelling=" + d() + ", completing=" + f() + ", rootCause=" + c() + ", exceptions=" + f1832m.get(this) + ", list=" + this.f1833j + ']';
    }
}
