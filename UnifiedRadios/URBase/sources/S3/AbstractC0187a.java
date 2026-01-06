package S3;

import N3.AbstractC0143q;
import N3.AbstractC0146u;
import N3.C0138l;
import N3.C0139m;
import N3.G;
import N3.P;
import N3.Y;
import N3.e0;
import N3.f0;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import g0.AbstractC0535a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s3.AbstractC0897g;
import w3.InterfaceC0936d;
import w3.InterfaceC0941i;

/* renamed from: S3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0187a {

    /* renamed from: a, reason: collision with root package name */
    public static final w f2379a = new w("NO_DECISION", 0);

    /* renamed from: b, reason: collision with root package name */
    public static final w f2380b = new w("CLOSED", 0);

    /* renamed from: c, reason: collision with root package name */
    public static final w f2381c = new w("UNDEFINED", 0);

    /* renamed from: d, reason: collision with root package name */
    public static final w f2382d = new w("REUSABLE_CLAIMED", 0);

    /* renamed from: e, reason: collision with root package name */
    public static final w f2383e = new w("CONDITION_FALSE", 0);

    /* renamed from: f, reason: collision with root package name */
    public static final w f2384f = new w("NO_THREAD_ELEMENTS", 0);

    public static final void a(E3.l lVar, Object obj, InterfaceC0941i interfaceC0941i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        F1.b bVarB = b(lVar, obj, null);
        if (bVarB != null) {
            AbstractC0146u.g(interfaceC0941i, bVarB);
        }
    }

    public static final F1.b b(E3.l lVar, Object obj, F1.b bVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            lVar.invoke(obj);
        } catch (Throwable th) {
            if (bVar == null || bVar.getCause() == th) {
                return new F1.b("Exception in undelivered element handler for " + obj, th);
            }
            android.support.v4.media.session.b.b(bVar, th);
        }
        return bVar;
    }

    public static final Object c(u uVar, long j5) {
        P3.e eVar = P3.e.f2098r;
        while (true) {
            long j6 = uVar.f2419l;
            if (j6 >= j5 && !uVar.c()) {
                return uVar;
            }
            Object obj = d.f2387j.get(uVar);
            w wVar = f2380b;
            if (obj == wVar) {
                return wVar;
            }
            u uVar2 = (u) ((d) obj);
            if (uVar2 != null) {
                uVar = uVar2;
            } else {
                u uVar3 = (u) eVar.c(Long.valueOf(j6 + 1), uVar);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d.f2387j;
                    if (atomicReferenceFieldUpdater.compareAndSet(uVar, null, uVar3)) {
                        if (uVar.c()) {
                            uVar.d();
                        }
                        uVar = uVar3;
                    } else if (atomicReferenceFieldUpdater.get(uVar) != null) {
                        break;
                    }
                }
            }
        }
    }

    public static final u d(Object obj) {
        if (obj == f2380b) {
            throw new IllegalStateException("Does not contain segment".toString());
        }
        F3.i.d(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (u) obj;
    }

    public static final void e(InterfaceC0941i interfaceC0941i, Throwable th) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Throwable runtimeException;
        Iterator it = f.f2390a.iterator();
        while (it.hasNext()) {
            try {
                ((O3.b) it.next()).W(interfaceC0941i, th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    android.support.v4.media.session.b.b(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            android.support.v4.media.session.b.b(th, new g(interfaceC0941i));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static final boolean f(Object obj) {
        return obj == f2380b;
    }

    public static final Object g(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static final void h(InterfaceC0941i interfaceC0941i, Object obj) {
        if (obj == f2384f) {
            return;
        }
        if (!(obj instanceof A)) {
            Object objD = interfaceC0941i.D(null, y.f2425l);
            F3.i.d(objD, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            AbstractC0535a.t(objD);
            throw null;
        }
        A a2 = (A) obj;
        e0[] e0VarArr = a2.f2378b;
        int length = e0VarArr.length - 1;
        if (length < 0) {
            return;
        }
        e0 e0Var = e0VarArr[length];
        F3.i.c(null);
        Object obj2 = a2.f2377a[length];
        throw null;
    }

    public static final void i(InterfaceC0936d interfaceC0936d, Object obj, E3.l lVar) {
        if (!(interfaceC0936d instanceof h)) {
            interfaceC0936d.resumeWith(obj);
            return;
        }
        h hVar = (h) interfaceC0936d;
        Throwable thA = AbstractC0897g.a(obj);
        Object c0139m = thA == null ? lVar != null ? new C0139m(obj, lVar) : obj : new C0138l(thA, false);
        InterfaceC0936d interfaceC0936d2 = hVar.n;
        interfaceC0936d2.getContext();
        AbstractC0143q abstractC0143q = hVar.f2393m;
        if (abstractC0143q.Y()) {
            hVar.f2394o = c0139m;
            hVar.f1810l = 1;
            abstractC0143q.W(interfaceC0936d2.getContext(), hVar);
            return;
        }
        G gA = f0.a();
        if (gA.d0()) {
            hVar.f2394o = c0139m;
            hVar.f1810l = 1;
            gA.a0(hVar);
            return;
        }
        gA.c0(true);
        try {
            P p4 = (P) interfaceC0936d2.getContext().o(N3.r.f1871k);
            if (p4 == null || p4.a()) {
                Object obj2 = hVar.f2395p;
                InterfaceC0941i context = interfaceC0936d2.getContext();
                Object objL = l(context, obj2);
                if (objL != f2384f) {
                    AbstractC0146u.n(interfaceC0936d2, context);
                }
                try {
                    interfaceC0936d2.resumeWith(obj);
                } finally {
                    h(context, objL);
                }
            } else {
                CancellationException cancellationExceptionW = ((Y) p4).w();
                hVar.b(c0139m, cancellationExceptionW);
                hVar.resumeWith(AbstractC0399v1.c(cancellationExceptionW));
            }
            while (gA.e0()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006f A[PHI: r18
      0x006f: PHI (r18v2 long) = (r18v1 long), (r18v4 long) binds: [B:28:0x0061, B:32:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long j(java.lang.String r22, long r23, long r25, long r27) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S3.AbstractC0187a.j(java.lang.String, long, long, long):long");
    }

    public static int k(String str, int i5, int i6, int i7, int i8) {
        if ((i8 & 4) != 0) {
            i6 = 1;
        }
        if ((i8 & 8) != 0) {
            i7 = Integer.MAX_VALUE;
        }
        return (int) j(str, i5, i6, i7);
    }

    public static final Object l(InterfaceC0941i interfaceC0941i, Object obj) {
        if (obj == null) {
            obj = interfaceC0941i.D(0, y.f2424k);
            F3.i.c(obj);
        }
        if (obj == 0) {
            return f2384f;
        }
        if (obj instanceof Integer) {
            return interfaceC0941i.D(new A(((Number) obj).intValue(), interfaceC0941i), y.f2426m);
        }
        AbstractC0535a.t(obj);
        throw null;
    }
}
