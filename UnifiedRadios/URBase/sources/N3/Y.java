package N3;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import w3.InterfaceC0939g;
import w3.InterfaceC0940h;
import w3.InterfaceC0941i;

/* loaded from: classes.dex */
public class Y implements P, InterfaceC0136j, c0 {

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1838j = AtomicReferenceFieldUpdater.newUpdater(Y.class, Object.class, "_state");

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1839k = AtomicReferenceFieldUpdater.newUpdater(Y.class, Object.class, "_parentHandle");
    private volatile Object _parentHandle;
    private volatile Object _state;

    public Y(boolean z4) {
        this._state = z4 ? AbstractC0146u.f1878i : AbstractC0146u.h;
    }

    public static C0135i J(S3.k kVar) {
        while (kVar.j()) {
            S3.k kVarF = kVar.f();
            if (kVarF == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = S3.k.f2402k;
                Object obj = atomicReferenceFieldUpdater.get(kVar);
                while (true) {
                    kVar = (S3.k) obj;
                    if (!kVar.j()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(kVar);
                }
            } else {
                kVar = kVarF;
            }
        }
        while (true) {
            kVar = kVar.i();
            if (!kVar.j()) {
                if (kVar instanceof C0135i) {
                    return (C0135i) kVar;
                }
                if (kVar instanceof Z) {
                    return null;
                }
            }
        }
    }

    public static String O(Object obj) {
        if (!(obj instanceof W)) {
            return obj instanceof K ? ((K) obj).a() ? "Active" : "New" : obj instanceof C0138l ? "Cancelled" : "Completed";
        }
        W w4 = (W) obj;
        return w4.d() ? "Cancelling" : w4.f() ? "Completing" : "Active";
    }

    public final Object A() {
        while (true) {
            Object obj = f1838j.get(this);
            if (!(obj instanceof S3.q)) {
                return obj;
            }
            ((S3.q) obj).a(this);
        }
    }

    public boolean B(Throwable th) {
        return false;
    }

    public void C(F1.b bVar) {
        throw bVar;
    }

    @Override // w3.InterfaceC0941i
    public final Object D(Object obj, E3.p pVar) {
        return pVar.c(obj, this);
    }

    public final void E(P p4) {
        boolean z4;
        a0 a0Var = a0.f1841j;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1839k;
        if (p4 == null) {
            atomicReferenceFieldUpdater.set(this, a0Var);
            return;
        }
        Y y4 = (Y) p4;
        do {
            Object objA = y4.A();
            boolean z5 = objA instanceof D;
            z4 = false;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f1838j;
            if (z5) {
                if (!((D) objA).f1813j) {
                    D d5 = AbstractC0146u.f1878i;
                    while (!atomicReferenceFieldUpdater2.compareAndSet(y4, objA, d5)) {
                        if (atomicReferenceFieldUpdater2.get(y4) != objA) {
                            z4 = -1;
                            break;
                        }
                    }
                    y4.getClass();
                    z4 = true;
                }
            } else if (objA instanceof J) {
                Z z6 = ((J) objA).f1820j;
                while (!atomicReferenceFieldUpdater2.compareAndSet(y4, objA, z6)) {
                    if (atomicReferenceFieldUpdater2.get(y4) != objA) {
                        z4 = -1;
                        break;
                    }
                }
                y4.getClass();
                z4 = true;
            }
            if (!z4) {
                break;
            }
        } while (!z4);
        InterfaceC0134h interfaceC0134h = (InterfaceC0134h) AbstractC0146u.h(y4, true, new C0135i(this), 2);
        atomicReferenceFieldUpdater.set(this, interfaceC0134h);
        if (!(A() instanceof K)) {
            interfaceC0134h.b();
            atomicReferenceFieldUpdater.set(this, a0Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00b8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final N3.C F(boolean r8, boolean r9, E3.l r10) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.Y.F(boolean, boolean, E3.l):N3.C");
    }

    public boolean G() {
        return false;
    }

    public final Object H(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objP;
        do {
            objP = P(A(), obj);
            if (objP == AbstractC0146u.f1874c) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                C0138l c0138l = obj instanceof C0138l ? (C0138l) obj : null;
                throw new IllegalStateException(str, c0138l != null ? c0138l.f1860a : null);
            }
        } while (objP == AbstractC0146u.f1876e);
        return objP;
    }

    public String I() {
        return getClass().getSimpleName();
    }

    public final void K(Z z4, Throwable th) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objH = z4.h();
        F3.i.d(objH, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        F1.b bVar = null;
        for (S3.k kVarI = (S3.k) objH; !kVarI.equals(z4); kVarI = kVarI.i()) {
            if (kVarI instanceof S) {
                U u4 = (U) kVarI;
                try {
                    u4.l(th);
                } catch (Throwable th2) {
                    if (bVar != null) {
                        android.support.v4.media.session.b.b(bVar, th2);
                    } else {
                        bVar = new F1.b("Exception in completion handler " + u4 + " for " + this, th2);
                    }
                }
            }
        }
        if (bVar != null) {
            C(bVar);
        }
        q(th);
    }

    public void L(Object obj) {
    }

    public void M() {
    }

    public final void N(U u4) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Z z4 = new Z();
        u4.getClass();
        S3.k.f2402k.lazySet(z4, u4);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = S3.k.f2401j;
        atomicReferenceFieldUpdater2.lazySet(z4, u4);
        loop0: while (true) {
            if (u4.h() == u4) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(u4, u4, z4)) {
                    if (atomicReferenceFieldUpdater2.get(u4) != u4) {
                        break;
                    }
                }
                z4.g(u4);
                break loop0;
            }
            break;
        }
        S3.k kVarI = u4.i();
        do {
            atomicReferenceFieldUpdater = f1838j;
            if (atomicReferenceFieldUpdater.compareAndSet(this, u4, kVarI)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == u4);
    }

    public final Object P(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        if (!(obj instanceof K)) {
            return AbstractC0146u.f1874c;
        }
        if (((obj instanceof D) || (obj instanceof U)) && !(obj instanceof C0135i) && !(obj2 instanceof C0138l)) {
            K k5 = (K) obj;
            Object l5 = obj2 instanceof K ? new L((K) obj2) : obj2;
            do {
                atomicReferenceFieldUpdater = f1838j;
                if (atomicReferenceFieldUpdater.compareAndSet(this, k5, l5)) {
                    L(obj2);
                    t(k5, obj2);
                    return obj2;
                }
            } while (atomicReferenceFieldUpdater.get(this) == k5);
            return AbstractC0146u.f1876e;
        }
        K k6 = (K) obj;
        Z z4 = z(k6);
        if (z4 == null) {
            return AbstractC0146u.f1876e;
        }
        C0135i c0135iJ = null;
        W w4 = k6 instanceof W ? (W) k6 : null;
        if (w4 == null) {
            w4 = new W(z4, null);
        }
        synchronized (w4) {
            if (w4.f()) {
                return AbstractC0146u.f1874c;
            }
            W.f1830k.set(w4, 1);
            if (w4 != k6) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f1838j;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, k6, w4)) {
                    if (atomicReferenceFieldUpdater2.get(this) != k6) {
                        return AbstractC0146u.f1876e;
                    }
                }
            }
            boolean zD = w4.d();
            C0138l c0138l = obj2 instanceof C0138l ? (C0138l) obj2 : null;
            if (c0138l != null) {
                w4.b(c0138l.f1860a);
            }
            Throwable thC = w4.c();
            if (!(!zD)) {
                thC = null;
            }
            if (thC != null) {
                K(z4, thC);
            }
            C0135i c0135i = k6 instanceof C0135i ? (C0135i) k6 : null;
            if (c0135i == null) {
                Z zE = k6.e();
                if (zE != null) {
                    c0135iJ = J(zE);
                }
            } else {
                c0135iJ = c0135i;
            }
            return (c0135iJ == null || !Q(w4, c0135iJ, obj2)) ? v(w4, obj2) : AbstractC0146u.f1875d;
        }
    }

    public final boolean Q(W w4, C0135i c0135i, Object obj) {
        while (AbstractC0146u.h(c0135i.n, false, new V(this, w4, c0135i, obj), 1) == a0.f1841j) {
            c0135i = J(c0135i);
            if (c0135i == null) {
                return false;
            }
        }
        return true;
    }

    @Override // w3.InterfaceC0941i
    public final InterfaceC0941i V(InterfaceC0940h interfaceC0940h) {
        return A2.b.p(this, interfaceC0940h);
    }

    @Override // N3.P
    public boolean a() {
        Object objA = A();
        return (objA instanceof K) && ((K) objA).a();
    }

    @Override // N3.P
    public void c(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new Q(r(), null, this);
        }
        p(cancellationException);
    }

    @Override // w3.InterfaceC0939g
    public final InterfaceC0940h getKey() {
        return r.f1871k;
    }

    public final boolean k(K k5, Z z4, U u4) {
        char c2;
        X x4 = new X(u4, this, k5);
        do {
            S3.k kVarF = z4.f();
            if (kVarF == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = S3.k.f2402k;
                Object obj = atomicReferenceFieldUpdater.get(z4);
                while (true) {
                    kVarF = (S3.k) obj;
                    if (!kVarF.j()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(kVarF);
                }
            }
            S3.k.f2402k.lazySet(u4, kVarF);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = S3.k.f2401j;
            atomicReferenceFieldUpdater2.lazySet(u4, z4);
            x4.f1835c = z4;
            while (true) {
                if (atomicReferenceFieldUpdater2.compareAndSet(kVarF, z4, x4)) {
                    c2 = x4.a(kVarF) == null ? (char) 1 : (char) 2;
                } else if (atomicReferenceFieldUpdater2.get(kVarF) != z4) {
                    c2 = 0;
                    break;
                }
            }
            if (c2 == 1) {
                return true;
            }
        } while (c2 != 2);
        return false;
    }

    public void l(Object obj) {
    }

    public void m(Object obj) {
        l(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0059, code lost:
    
        r0 = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n(java.lang.Object r10) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.Y.n(java.lang.Object):boolean");
    }

    @Override // w3.InterfaceC0941i
    public final InterfaceC0939g o(InterfaceC0940h interfaceC0940h) {
        return A2.b.g(this, interfaceC0940h);
    }

    public void p(CancellationException cancellationException) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        n(cancellationException);
    }

    public final boolean q(Throwable th) {
        if (G()) {
            return true;
        }
        boolean z4 = th instanceof CancellationException;
        InterfaceC0134h interfaceC0134h = (InterfaceC0134h) f1839k.get(this);
        return (interfaceC0134h == null || interfaceC0134h == a0.f1841j) ? z4 : interfaceC0134h.d(th) || z4;
    }

    public String r() {
        return "Job was cancelled";
    }

    public boolean s(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return n(th) && y();
    }

    public final void t(K k5, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1839k;
        InterfaceC0134h interfaceC0134h = (InterfaceC0134h) atomicReferenceFieldUpdater.get(this);
        if (interfaceC0134h != null) {
            interfaceC0134h.b();
            atomicReferenceFieldUpdater.set(this, a0.f1841j);
        }
        F1.b bVar = null;
        C0138l c0138l = obj instanceof C0138l ? (C0138l) obj : null;
        Throwable th = c0138l != null ? c0138l.f1860a : null;
        if (k5 instanceof U) {
            try {
                ((U) k5).l(th);
                return;
            } catch (Throwable th2) {
                C(new F1.b("Exception in completion handler " + k5 + " for " + this, th2));
                return;
            }
        }
        Z zE = k5.e();
        if (zE != null) {
            Object objH = zE.h();
            F3.i.d(objH, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            for (S3.k kVarI = (S3.k) objH; !kVarI.equals(zE); kVarI = kVarI.i()) {
                if (kVarI instanceof U) {
                    U u4 = (U) kVarI;
                    try {
                        u4.l(th);
                    } catch (Throwable th3) {
                        if (bVar != null) {
                            android.support.v4.media.session.b.b(bVar, th3);
                        } else {
                            bVar = new F1.b("Exception in completion handler " + u4 + " for " + this, th3);
                        }
                    }
                }
            }
            if (bVar != null) {
                C(bVar);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(I() + '{' + O(A()) + '}');
        sb.append('@');
        sb.append(AbstractC0146u.e(this));
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    public final Throwable u(Object obj) {
        CancellationException cancellationExceptionC;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        Y y4 = (Y) ((c0) obj);
        Object objA = y4.A();
        if (objA instanceof W) {
            cancellationExceptionC = ((W) objA).c();
        } else if (objA instanceof C0138l) {
            cancellationExceptionC = ((C0138l) objA).f1860a;
        } else {
            if (objA instanceof K) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objA).toString());
            }
            cancellationExceptionC = null;
        }
        CancellationException q4 = cancellationExceptionC instanceof CancellationException ? cancellationExceptionC : null;
        if (q4 == null) {
            q4 = new Q("Parent job is ".concat(O(objA)), cancellationExceptionC, y4);
        }
        return q4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object v(W w4, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Throwable q4 = null;
        C0138l c0138l = obj instanceof C0138l ? (C0138l) obj : null;
        Throwable th = c0138l != null ? c0138l.f1860a : null;
        synchronized (w4) {
            w4.d();
            ArrayList<Throwable> arrayListG = w4.g(th);
            if (!arrayListG.isEmpty()) {
                Iterator it = arrayListG.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (!(((Throwable) next) instanceof CancellationException)) {
                        q4 = next;
                        break;
                    }
                }
                q4 = q4;
                if (q4 == null) {
                    q4 = (Throwable) arrayListG.get(0);
                }
            } else if (w4.d()) {
                q4 = new Q(r(), null, this);
            }
            if (q4 != null && arrayListG.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListG.size()));
                for (Throwable th2 : arrayListG) {
                    if (th2 != q4 && th2 != q4 && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        android.support.v4.media.session.b.b(q4, th2);
                    }
                }
            }
        }
        if (q4 != null && q4 != th) {
            obj = new C0138l(q4, false);
        }
        if (q4 != null && (q(q4) || B(q4))) {
            F3.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            C0138l.f1859b.compareAndSet((C0138l) obj, 0, 1);
        }
        L(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1838j;
        Object l5 = obj instanceof K ? new L((K) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, w4, l5) && atomicReferenceFieldUpdater.get(this) == w4) {
        }
        t(w4, obj);
        return obj;
    }

    public final CancellationException w() {
        CancellationException cancellationException;
        Object objA = A();
        if (!(objA instanceof W)) {
            if (objA instanceof K) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(objA instanceof C0138l)) {
                return new Q(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((C0138l) objA).f1860a;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new Q(r(), th, this) : cancellationException;
        }
        Throwable thC = ((W) objA).c();
        if (thC == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        cancellationException = thC instanceof CancellationException ? (CancellationException) thC : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = r();
        }
        return new Q(strConcat, thC, this);
    }

    @Override // w3.InterfaceC0941i
    public final InterfaceC0941i x(InterfaceC0941i interfaceC0941i) {
        return A2.b.u(this, interfaceC0941i);
    }

    public boolean y() {
        return true;
    }

    public final Z z(K k5) {
        Z zE = k5.e();
        if (zE != null) {
            return zE;
        }
        if (k5 instanceof D) {
            return new Z();
        }
        if (k5 instanceof U) {
            N((U) k5);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + k5).toString());
    }
}
