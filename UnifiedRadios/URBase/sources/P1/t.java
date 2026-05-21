package p1;

import android.accounts.Account;
import android.content.Context;
import android.content.res.Resources;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import com.google.android.gms.location.DeviceOrientationRequest;
import i3.C0573b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import k3.RunnableC0691i0;
import n1.C0785b;
import n1.C0787d;
import n1.C0789f;
import q1.AbstractC0854e;
import s1.C0887c;

/* loaded from: classes.dex */
public final class t implements o1.i, o1.j {

    /* renamed from: d, reason: collision with root package name */
    public final o1.c f9138d;

    /* renamed from: e, reason: collision with root package name */
    public final C0826b f9139e;

    /* renamed from: f, reason: collision with root package name */
    public final L0.c f9140f;

    /* renamed from: i, reason: collision with root package name */
    public final int f9141i;

    /* renamed from: j, reason: collision with root package name */
    public final BinderC0823D f9142j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f9143k;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ C0832h f9146o;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedList f9137c = new LinkedList();
    public final HashSet g = new HashSet();
    public final HashMap h = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f9144l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public C0785b f9145m = null;
    public int n = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public t(C0832h c0832h, o1.h hVar) {
        this.f9146o = c0832h;
        Looper looper = c0832h.n.getLooper();
        L0.i iVarA = hVar.a();
        D0.w wVar = new D0.w((Account) iVarA.f1547c, (q.c) iVarA.f1548d, (String) iVarA.f1549e, (String) iVarA.f1550f);
        AbstractC0296a2 abstractC0296a2 = hVar.f8903c.f8896a;
        q1.E.i(abstractC0296a2);
        o1.c cVarB = abstractC0296a2.b(hVar.f8901a, looper, wVar, hVar.f8904d, this, this);
        String str = hVar.f8902b;
        if (str != null && (cVarB instanceof AbstractC0854e)) {
            ((AbstractC0854e) cVarB).f9361s = str;
        }
        if (str != null && (cVarB instanceof n)) {
            com.unified.ur1.SatelliteTracker.h.p(cVarB);
            throw null;
        }
        this.f9138d = cVarB;
        this.f9139e = hVar.f8905e;
        this.f9140f = new L0.c(22);
        this.f9141i = hVar.f8906f;
        if (!cVarB.m()) {
            this.f9142j = null;
            return;
        }
        Context context = c0832h.f9120e;
        A1.f fVar = c0832h.n;
        L0.i iVarA2 = hVar.a();
        this.f9142j = new BinderC0823D(context, fVar, new D0.w((Account) iVarA2.f1547c, (q.c) iVarA2.f1548d, (String) iVarA2.f1549e, (String) iVarA2.f1550f));
    }

    @Override // o1.i
    public final void a(int i5) {
        Looper looperMyLooper = Looper.myLooper();
        C0832h c0832h = this.f9146o;
        if (looperMyLooper == c0832h.n.getLooper()) {
            i(i5);
        } else {
            c0832h.n.post(new B0.r(i5, 7, this));
        }
    }

    @Override // o1.j
    public final void b(C0785b c0785b) {
        o(c0785b, null);
    }

    @Override // o1.i
    public final void c() {
        Looper looperMyLooper = Looper.myLooper();
        C0832h c0832h = this.f9146o;
        if (looperMyLooper == c0832h.n.getLooper()) {
            h();
        } else {
            c0832h.n.post(new RunnableC0691i0(8, this));
        }
    }

    public final void d(C0785b c0785b) {
        HashSet hashSet = this.g;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
            return;
        }
        com.unified.ur1.SatelliteTracker.h.p(it.next());
        if (q1.E.l(c0785b, C0785b.n)) {
            this.f9138d.i();
        }
        throw null;
    }

    public final void e(Status status) {
        q1.E.d(this.f9146o.n);
        f(status, null, false);
    }

    public final void f(Status status, RuntimeException runtimeException, boolean z4) {
        q1.E.d(this.f9146o.n);
        if ((status == null) == (runtimeException == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f9137c.iterator();
        while (it.hasNext()) {
            x xVar = (x) it.next();
            if (!z4 || xVar.f9155a == 2) {
                if (status != null) {
                    xVar.c(status);
                } else {
                    xVar.d(runtimeException);
                }
                it.remove();
            }
        }
    }

    public final void g() {
        LinkedList linkedList = this.f9137c;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            x xVar = (x) arrayList.get(i5);
            if (!this.f9138d.a()) {
                return;
            }
            if (k(xVar)) {
                linkedList.remove(xVar);
            }
        }
    }

    public final void h() {
        o1.c cVar = this.f9138d;
        C0832h c0832h = this.f9146o;
        q1.E.d(c0832h.n);
        this.f9145m = null;
        d(C0785b.n);
        if (this.f9143k) {
            A1.f fVar = c0832h.n;
            C0826b c0826b = this.f9139e;
            fVar.removeMessages(11, c0826b);
            c0832h.n.removeMessages(9, c0826b);
            this.f9143k = false;
        }
        Iterator it = this.h.values().iterator();
        while (it.hasNext()) {
            C0821B c0821b = (C0821B) it.next();
            c0821b.f9082a.getClass();
            try {
                C0573b c0573b = c0821b.f9082a;
                ((o) ((m1.m) c0573b.f7297e).f8545d).p(cVar, new N1.k());
            } catch (DeadObjectException unused) {
                a(3);
                cVar.e("DeadObjectException thrown while calling register listener method.");
            } catch (RemoteException unused2) {
                it.remove();
            }
        }
        g();
        j();
    }

    public final void i(int i5) {
        C0832h c0832h = this.f9146o;
        q1.E.d(c0832h.n);
        this.f9145m = null;
        this.f9143k = true;
        String strJ = this.f9138d.j();
        L0.c cVar = this.f9140f;
        cVar.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i5 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i5 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (strJ != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(strJ);
        }
        cVar.o(true, new Status(20, sb.toString(), null, null));
        A1.f fVar = c0832h.n;
        C0826b c0826b = this.f9139e;
        fVar.sendMessageDelayed(Message.obtain(fVar, 9, c0826b), DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
        A1.f fVar2 = c0832h.n;
        fVar2.sendMessageDelayed(Message.obtain(fVar2, 11, c0826b), 120000L);
        ((SparseIntArray) c0832h.g.f1596d).clear();
        Iterator it = this.h.values().iterator();
        while (it.hasNext()) {
            ((C0821B) it.next()).f9084c.run();
        }
    }

    public final void j() {
        C0832h c0832h = this.f9146o;
        A1.f fVar = c0832h.n;
        C0826b c0826b = this.f9139e;
        fVar.removeMessages(12, c0826b);
        A1.f fVar2 = c0832h.n;
        fVar2.sendMessageDelayed(fVar2.obtainMessage(12, c0826b), c0832h.f9116a);
    }

    public final boolean k(x xVar) throws Resources.NotFoundException {
        C0787d c0787d;
        if (!(xVar instanceof x)) {
            o1.c cVar = this.f9138d;
            xVar.f(this.f9140f, cVar.m());
            try {
                xVar.e(this);
            } catch (DeadObjectException unused) {
                a(1);
                cVar.e("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        C0787d[] c0787dArrB = xVar.b(this);
        if (c0787dArrB == null || c0787dArrB.length == 0) {
            c0787d = null;
        } else {
            C0787d[] c0787dArrH = this.f9138d.h();
            if (c0787dArrH == null) {
                c0787dArrH = new C0787d[0];
            }
            q.b bVar = new q.b(c0787dArrH.length);
            for (C0787d c0787d2 : c0787dArrH) {
                bVar.put(c0787d2.f8734j, Long.valueOf(c0787d2.a()));
            }
            int length = c0787dArrB.length;
            for (int i5 = 0; i5 < length; i5++) {
                c0787d = c0787dArrB[i5];
                Long l5 = (Long) bVar.getOrDefault(c0787d.f8734j, null);
                if (l5 == null || l5.longValue() < c0787d.a()) {
                    break;
                }
            }
            c0787d = null;
        }
        if (c0787d == null) {
            o1.c cVar2 = this.f9138d;
            xVar.f(this.f9140f, cVar2.m());
            try {
                xVar.e(this);
            } catch (DeadObjectException unused2) {
                a(1);
                cVar2.e("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        Log.w("GoogleApiManager", this.f9138d.getClass().getName() + " could not execute call because it requires feature (" + c0787d.f8734j + ", " + c0787d.a() + ").");
        if (!this.f9146o.f9127o || !xVar.a(this)) {
            xVar.d(new o1.p(c0787d));
            return true;
        }
        u uVar = new u(this.f9139e, c0787d);
        int iIndexOf = this.f9144l.indexOf(uVar);
        if (iIndexOf >= 0) {
            u uVar2 = (u) this.f9144l.get(iIndexOf);
            this.f9146o.n.removeMessages(15, uVar2);
            A1.f fVar = this.f9146o.n;
            fVar.sendMessageDelayed(Message.obtain(fVar, 15, uVar2), DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
        } else {
            this.f9144l.add(uVar);
            A1.f fVar2 = this.f9146o.n;
            fVar2.sendMessageDelayed(Message.obtain(fVar2, 15, uVar), DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
            A1.f fVar3 = this.f9146o.n;
            fVar3.sendMessageDelayed(Message.obtain(fVar3, 16, uVar), 120000L);
            C0785b c0785b = new C0785b(2, null);
            if (!l(c0785b)) {
                this.f9146o.c(c0785b, this.f9141i);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        if (r6.get() == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l(n1.C0785b r6) {
        /*
            r5 = this;
            java.lang.Object r0 = p1.C0832h.f9114r
            monitor-enter(r0)
            p1.h r1 = r5.f9146o     // Catch: java.lang.Throwable -> L46
            p1.q r2 = r1.f9124k     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L48
            q.c r1 = r1.f9125l     // Catch: java.lang.Throwable -> L46
            p1.b r2 = r5.f9139e     // Catch: java.lang.Throwable -> L46
            boolean r1 = r1.contains(r2)     // Catch: java.lang.Throwable -> L46
            if (r1 == 0) goto L48
            p1.h r1 = r5.f9146o     // Catch: java.lang.Throwable -> L46
            p1.q r1 = r1.f9124k     // Catch: java.lang.Throwable -> L46
            int r2 = r5.f9141i     // Catch: java.lang.Throwable -> L46
            r1.getClass()     // Catch: java.lang.Throwable -> L46
            p1.G r3 = new p1.G     // Catch: java.lang.Throwable -> L46
            r3.<init>(r6, r2)     // Catch: java.lang.Throwable -> L46
        L21:
            java.util.concurrent.atomic.AtomicReference r6 = r1.f9132e     // Catch: java.lang.Throwable -> L46
        L23:
            r2 = 0
            boolean r2 = r6.compareAndSet(r2, r3)     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L37
            A1.f r6 = r1.f9133f     // Catch: java.lang.Throwable -> L46
            N1.p r2 = new N1.p     // Catch: java.lang.Throwable -> L46
            r4 = 12
            r2.<init>(r1, r4, r3)     // Catch: java.lang.Throwable -> L46
            r6.post(r2)     // Catch: java.lang.Throwable -> L46
            goto L43
        L37:
            java.lang.Object r2 = r6.get()     // Catch: java.lang.Throwable -> L46
            if (r2 == 0) goto L23
            java.lang.Object r6 = r6.get()     // Catch: java.lang.Throwable -> L46
            if (r6 == 0) goto L21
        L43:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L46
            r6 = 1
            return r6
        L46:
            r6 = move-exception
            goto L4b
        L48:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L46
            r6 = 0
            return r6
        L4b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L46
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.t.l(n1.b):boolean");
    }

    public final void m() {
        C0832h c0832h = this.f9146o;
        q1.E.d(c0832h.n);
        o1.c cVar = this.f9138d;
        if (cVar.a() || cVar.g()) {
            return;
        }
        try {
            L0.s sVar = c0832h.g;
            Context context = c0832h.f9120e;
            sVar.getClass();
            q1.E.i(context);
            int iF = cVar.f();
            SparseIntArray sparseIntArray = (SparseIntArray) sVar.f1596d;
            int iC = sparseIntArray.get(iF, -1);
            if (iC == -1) {
                iC = 0;
                int i5 = 0;
                while (true) {
                    if (i5 >= sparseIntArray.size()) {
                        iC = -1;
                        break;
                    }
                    int iKeyAt = sparseIntArray.keyAt(i5);
                    if (iKeyAt > iF && sparseIntArray.get(iKeyAt) == 0) {
                        break;
                    } else {
                        i5++;
                    }
                }
                if (iC == -1) {
                    iC = ((C0789f) sVar.f1597e).c(context, iF);
                }
                sparseIntArray.put(iF, iC);
            }
            if (iC != 0) {
                C0785b c0785b = new C0785b(iC, null);
                Log.w("GoogleApiManager", "The service for " + cVar.getClass().getName() + " is not available: " + c0785b.toString());
                o(c0785b, null);
                return;
            }
            v vVar = new v(c0832h, cVar, this.f9139e);
            if (cVar.m()) {
                BinderC0823D binderC0823D = this.f9142j;
                q1.E.i(binderC0823D);
                L1.a aVar = binderC0823D.f9090i;
                if (aVar != null) {
                    aVar.l();
                }
                Integer numValueOf = Integer.valueOf(System.identityHashCode(binderC0823D));
                D0.w wVar = binderC0823D.h;
                wVar.h = numValueOf;
                Handler handler = binderC0823D.f9088e;
                binderC0823D.f9090i = (L1.a) binderC0823D.f9089f.b(binderC0823D.f9087d, handler.getLooper(), wVar, (K1.a) wVar.g, binderC0823D, binderC0823D);
                binderC0823D.f9091j = vVar;
                Set set = binderC0823D.g;
                if (set == null || set.isEmpty()) {
                    handler.post(new RunnableC0691i0(10, binderC0823D));
                } else {
                    binderC0823D.f9090i.B();
                }
            }
            try {
                cVar.b(vVar);
            } catch (SecurityException e5) {
                o(new C0785b(10), e5);
            }
        } catch (IllegalStateException e6) {
            o(new C0785b(10), e6);
        }
    }

    public final void n(x xVar) {
        q1.E.d(this.f9146o.n);
        boolean zA = this.f9138d.a();
        LinkedList linkedList = this.f9137c;
        if (zA) {
            if (k(xVar)) {
                j();
                return;
            } else {
                linkedList.add(xVar);
                return;
            }
        }
        linkedList.add(xVar);
        C0785b c0785b = this.f9145m;
        if (c0785b == null || c0785b.f8728k == 0 || c0785b.f8729l == null) {
            m();
        } else {
            o(c0785b, null);
        }
    }

    public final void o(C0785b c0785b, RuntimeException runtimeException) {
        L1.a aVar;
        q1.E.d(this.f9146o.n);
        BinderC0823D binderC0823D = this.f9142j;
        if (binderC0823D != null && (aVar = binderC0823D.f9090i) != null) {
            aVar.l();
        }
        q1.E.d(this.f9146o.n);
        this.f9145m = null;
        ((SparseIntArray) this.f9146o.g.f1596d).clear();
        d(c0785b);
        if ((this.f9138d instanceof C0887c) && c0785b.f8728k != 24) {
            C0832h c0832h = this.f9146o;
            c0832h.f9117b = true;
            A1.f fVar = c0832h.n;
            fVar.sendMessageDelayed(fVar.obtainMessage(19), 300000L);
        }
        if (c0785b.f8728k == 4) {
            e(C0832h.f9113q);
            return;
        }
        if (this.f9137c.isEmpty()) {
            this.f9145m = c0785b;
            return;
        }
        if (runtimeException != null) {
            q1.E.d(this.f9146o.n);
            f(null, runtimeException, false);
            return;
        }
        if (!this.f9146o.f9127o) {
            e(C0832h.d(this.f9139e, c0785b));
            return;
        }
        f(C0832h.d(this.f9139e, c0785b), null, true);
        if (this.f9137c.isEmpty() || l(c0785b) || this.f9146o.c(c0785b, this.f9141i)) {
            return;
        }
        if (c0785b.f8728k == 18) {
            this.f9143k = true;
        }
        if (!this.f9143k) {
            e(C0832h.d(this.f9139e, c0785b));
            return;
        }
        C0832h c0832h2 = this.f9146o;
        C0826b c0826b = this.f9139e;
        A1.f fVar2 = c0832h2.n;
        fVar2.sendMessageDelayed(Message.obtain(fVar2, 9, c0826b), DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
    }

    public final void p(C0785b c0785b) {
        q1.E.d(this.f9146o.n);
        o1.c cVar = this.f9138d;
        cVar.e("onSignInFailed for " + cVar.getClass().getName() + " with " + String.valueOf(c0785b));
        o(c0785b, null);
    }

    public final void q() {
        q1.E.d(this.f9146o.n);
        Status status = C0832h.f9112p;
        e(status);
        this.f9140f.o(false, status);
        for (l lVar : (l[]) this.h.keySet().toArray(new l[0])) {
            n(new C0824E(lVar, new N1.k()));
        }
        d(new C0785b(4));
        o1.c cVar = this.f9138d;
        if (cVar.a()) {
            cVar.k(new s(this));
        }
    }
}
