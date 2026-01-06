package D0;

import C0.B;
import C0.C0001a;
import J1.V0;
import android.content.Context;
import android.database.Cursor;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import g0.AbstractC0535a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import l0.AbstractC0737m;
import l0.C0738n;
import q0.C0847j;
import z2.RunnableC0999a;

/* loaded from: classes.dex */
public final class x implements Runnable {

    /* renamed from: A, reason: collision with root package name */
    public static final String f314A = C0.t.f("WorkerWrapper");

    /* renamed from: j, reason: collision with root package name */
    public final Context f315j;

    /* renamed from: k, reason: collision with root package name */
    public final String f316k;

    /* renamed from: l, reason: collision with root package name */
    public final L0.o f317l;

    /* renamed from: m, reason: collision with root package name */
    public C0.s f318m;
    public final L0.i n;

    /* renamed from: p, reason: collision with root package name */
    public final C0001a f320p;

    /* renamed from: q, reason: collision with root package name */
    public final C0.u f321q;

    /* renamed from: r, reason: collision with root package name */
    public final K0.a f322r;

    /* renamed from: s, reason: collision with root package name */
    public final WorkDatabase f323s;

    /* renamed from: t, reason: collision with root package name */
    public final L0.q f324t;

    /* renamed from: u, reason: collision with root package name */
    public final L0.c f325u;

    /* renamed from: v, reason: collision with root package name */
    public final List f326v;

    /* renamed from: w, reason: collision with root package name */
    public String f327w;

    /* renamed from: o, reason: collision with root package name */
    public C0.r f319o = new C0.o();

    /* renamed from: x, reason: collision with root package name */
    public final N0.k f328x = new N0.k();

    /* renamed from: y, reason: collision with root package name */
    public final N0.k f329y = new N0.k();

    /* renamed from: z, reason: collision with root package name */
    public volatile int f330z = -256;

    public x(w wVar) {
        this.f315j = (Context) wVar.f309b;
        this.n = (L0.i) wVar.f311d;
        this.f322r = (K0.a) wVar.f310c;
        L0.o oVar = (L0.o) wVar.g;
        this.f317l = oVar;
        this.f316k = oVar.f1561a;
        this.f318m = null;
        C0001a c0001a = (C0001a) wVar.f312e;
        this.f320p = c0001a;
        this.f321q = c0001a.f132c;
        WorkDatabase workDatabase = (WorkDatabase) wVar.f313f;
        this.f323s = workDatabase;
        this.f324t = workDatabase.v();
        this.f325u = workDatabase.q();
        this.f326v = (List) wVar.h;
    }

    public final void a(C0.r rVar) {
        boolean z4 = rVar instanceof C0.q;
        L0.o oVar = this.f317l;
        String str = f314A;
        if (!z4) {
            if (rVar instanceof C0.p) {
                C0.t.d().e(str, "Worker result RETRY for " + this.f327w);
                c();
                return;
            }
            C0.t.d().e(str, "Worker result FAILURE for " + this.f327w);
            if (oVar.c()) {
                d();
                return;
            } else {
                g();
                return;
            }
        }
        C0.t.d().e(str, "Worker result SUCCESS for " + this.f327w);
        if (oVar.c()) {
            d();
            return;
        }
        L0.c cVar = this.f325u;
        String str2 = this.f316k;
        L0.q qVar = this.f324t;
        WorkDatabase workDatabase = this.f323s;
        workDatabase.c();
        try {
            qVar.m(3, str2);
            qVar.l(str2, ((C0.q) this.f319o).f167a);
            this.f321q.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator it = cVar.g(str2).iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                if (qVar.f(str3) == 5 && cVar.h(str3)) {
                    C0.t.d().e(str, "Setting status to enqueued for " + str3);
                    qVar.m(1, str3);
                    qVar.k(jCurrentTimeMillis, str3);
                }
            }
            workDatabase.o();
            workDatabase.k();
            e(false);
        } catch (Throwable th) {
            workDatabase.k();
            e(false);
            throw th;
        }
    }

    public final void b() {
        if (h()) {
            return;
        }
        this.f323s.c();
        try {
            int iF = this.f324t.f(this.f316k);
            L0.m mVarU = this.f323s.u();
            String str = this.f316k;
            AbstractC0737m abstractC0737m = (AbstractC0737m) mVarU.f1556d;
            abstractC0737m.b();
            L0.h hVar = (L0.h) mVarU.f1557e;
            C0847j c0847jA = hVar.a();
            if (str == null) {
                c0847jA.t(1);
            } else {
                c0847jA.h(1, str);
            }
            abstractC0737m.c();
            try {
                c0847jA.c();
                abstractC0737m.o();
                if (iF == 0) {
                    e(false);
                } else if (iF == 2) {
                    a(this.f319o);
                } else if (!AbstractC0535a.d(iF)) {
                    this.f330z = -512;
                    c();
                }
                this.f323s.o();
                this.f323s.k();
            } finally {
                abstractC0737m.k();
                hVar.n(c0847jA);
            }
        } catch (Throwable th) {
            this.f323s.k();
            throw th;
        }
    }

    public final void c() {
        String str = this.f316k;
        L0.q qVar = this.f324t;
        WorkDatabase workDatabase = this.f323s;
        workDatabase.c();
        try {
            qVar.m(1, str);
            this.f321q.getClass();
            qVar.k(System.currentTimeMillis(), str);
            qVar.j(this.f317l.f1579v, str);
            qVar.i(-1L, str);
            workDatabase.o();
        } finally {
            workDatabase.k();
            e(true);
        }
    }

    public final void d() {
        String str = this.f316k;
        L0.q qVar = this.f324t;
        WorkDatabase workDatabase = this.f323s;
        workDatabase.c();
        try {
            this.f321q.getClass();
            qVar.k(System.currentTimeMillis(), str);
            AbstractC0737m abstractC0737m = qVar.f1582a;
            qVar.m(1, str);
            abstractC0737m.b();
            L0.h hVar = qVar.f1589j;
            C0847j c0847jA = hVar.a();
            if (str == null) {
                c0847jA.t(1);
            } else {
                c0847jA.h(1, str);
            }
            abstractC0737m.c();
            try {
                c0847jA.c();
                abstractC0737m.o();
                abstractC0737m.k();
                hVar.n(c0847jA);
                qVar.j(this.f317l.f1579v, str);
                abstractC0737m.b();
                L0.h hVar2 = qVar.f1587f;
                C0847j c0847jA2 = hVar2.a();
                if (str == null) {
                    c0847jA2.t(1);
                } else {
                    c0847jA2.h(1, str);
                }
                abstractC0737m.c();
                try {
                    c0847jA2.c();
                    abstractC0737m.o();
                    abstractC0737m.k();
                    hVar2.n(c0847jA2);
                    qVar.i(-1L, str);
                    workDatabase.o();
                } catch (Throwable th) {
                    abstractC0737m.k();
                    hVar2.n(c0847jA2);
                    throw th;
                }
            } catch (Throwable th2) {
                abstractC0737m.k();
                hVar.n(c0847jA);
                throw th2;
            }
        } finally {
            workDatabase.k();
            e(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(boolean r6) {
        /*
            r5 = this;
            androidx.work.impl.WorkDatabase r0 = r5.f323s
            r0.c()
            androidx.work.impl.WorkDatabase r0 = r5.f323s     // Catch: java.lang.Throwable -> L41
            L0.q r0 = r0.v()     // Catch: java.lang.Throwable -> L41
            r0.getClass()     // Catch: java.lang.Throwable -> L41
            java.lang.String r1 = "SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1"
            r2 = 0
            l0.n r1 = l0.C0738n.o(r2, r1)     // Catch: java.lang.Throwable -> L41
            l0.m r0 = r0.f1582a     // Catch: java.lang.Throwable -> L41
            r0.b()     // Catch: java.lang.Throwable -> L41
            r3 = 0
            android.database.Cursor r0 = r0.m(r1, r3)     // Catch: java.lang.Throwable -> L41
            boolean r3 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L2e
            r4 = 1
            if (r3 == 0) goto L30
            int r3 = r0.getInt(r2)     // Catch: java.lang.Throwable -> L2e
            if (r3 == 0) goto L30
            r3 = r4
            goto L31
        L2e:
            r6 = move-exception
            goto L72
        L30:
            r3 = r2
        L31:
            r0.close()     // Catch: java.lang.Throwable -> L41
            r1.s()     // Catch: java.lang.Throwable -> L41
            if (r3 != 0) goto L43
            android.content.Context r0 = r5.f315j     // Catch: java.lang.Throwable -> L41
            java.lang.Class<androidx.work.impl.background.systemalarm.RescheduleReceiver> r1 = androidx.work.impl.background.systemalarm.RescheduleReceiver.class
            M0.k.a(r0, r1, r2)     // Catch: java.lang.Throwable -> L41
            goto L43
        L41:
            r6 = move-exception
            goto L79
        L43:
            if (r6 == 0) goto L5e
            L0.q r0 = r5.f324t     // Catch: java.lang.Throwable -> L41
            java.lang.String r1 = r5.f316k     // Catch: java.lang.Throwable -> L41
            r0.m(r4, r1)     // Catch: java.lang.Throwable -> L41
            L0.q r0 = r5.f324t     // Catch: java.lang.Throwable -> L41
            java.lang.String r1 = r5.f316k     // Catch: java.lang.Throwable -> L41
            int r2 = r5.f330z     // Catch: java.lang.Throwable -> L41
            r0.n(r2, r1)     // Catch: java.lang.Throwable -> L41
            L0.q r0 = r5.f324t     // Catch: java.lang.Throwable -> L41
            java.lang.String r1 = r5.f316k     // Catch: java.lang.Throwable -> L41
            r2 = -1
            r0.i(r2, r1)     // Catch: java.lang.Throwable -> L41
        L5e:
            androidx.work.impl.WorkDatabase r0 = r5.f323s     // Catch: java.lang.Throwable -> L41
            r0.o()     // Catch: java.lang.Throwable -> L41
            androidx.work.impl.WorkDatabase r0 = r5.f323s
            r0.k()
            N0.k r0 = r5.f328x
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r0.j(r6)
            return
        L72:
            r0.close()     // Catch: java.lang.Throwable -> L41
            r1.s()     // Catch: java.lang.Throwable -> L41
            throw r6     // Catch: java.lang.Throwable -> L41
        L79:
            androidx.work.impl.WorkDatabase r0 = r5.f323s
            r0.k()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: D0.x.e(boolean):void");
    }

    public final void f() {
        L0.q qVar = this.f324t;
        String str = this.f316k;
        int iF = qVar.f(str);
        String str2 = f314A;
        if (iF == 2) {
            C0.t.d().a(str2, "Status for " + str + " is RUNNING; not doing any work and rescheduling for later execution");
            e(true);
            return;
        }
        C0.t tVarD = C0.t.d();
        StringBuilder sbM = AbstractC0535a.m("Status for ", str, " is ");
        sbM.append(AbstractC0535a.y(iF));
        sbM.append(" ; not doing any work");
        tVarD.a(str2, sbM.toString());
        e(false);
    }

    public final void g() {
        String str = this.f316k;
        WorkDatabase workDatabase = this.f323s;
        workDatabase.c();
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            while (true) {
                boolean zIsEmpty = linkedList.isEmpty();
                L0.q qVar = this.f324t;
                if (zIsEmpty) {
                    C0.h hVar = ((C0.o) this.f319o).f166a;
                    qVar.j(this.f317l.f1579v, str);
                    qVar.l(str, hVar);
                    workDatabase.o();
                    return;
                }
                String str2 = (String) linkedList.remove();
                if (qVar.f(str2) != 6) {
                    qVar.m(4, str2);
                }
                linkedList.addAll(this.f325u.g(str2));
            }
        } finally {
            workDatabase.k();
            e(false);
        }
    }

    public final boolean h() {
        if (this.f330z == -256) {
            return false;
        }
        C0.t.d().a(f314A, "Work interrupted for " + this.f327w);
        if (this.f324t.f(this.f316k) == 0) {
            e(false);
        } else {
            e(!AbstractC0535a.d(r0));
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        boolean z4;
        C0.k kVar;
        StringBuilder sb = new StringBuilder("Work [ id=");
        String str = this.f316k;
        sb.append(str);
        sb.append(", tags={ ");
        List<String> list = this.f326v;
        boolean z5 = true;
        for (String str2 : list) {
            if (z5) {
                z5 = false;
            } else {
                sb.append(", ");
            }
            sb.append(str2);
        }
        sb.append(" } ]");
        this.f327w = sb.toString();
        L0.o oVar = this.f317l;
        if (h()) {
            return;
        }
        WorkDatabase workDatabase = this.f323s;
        workDatabase.c();
        try {
            int i5 = oVar.f1562b;
            String str3 = oVar.f1563c;
            String str4 = f314A;
            if (i5 == 1) {
                if (oVar.c() || (oVar.f1562b == 1 && oVar.f1569k > 0)) {
                    this.f321q.getClass();
                    if (System.currentTimeMillis() < oVar.a()) {
                        C0.t.d().a(str4, "Delaying execution for " + str3 + " because it is being executed before schedule.");
                        e(true);
                        workDatabase.o();
                    }
                }
                workDatabase.o();
                workDatabase.k();
                boolean zC = oVar.c();
                C0.h hVarA = oVar.f1565e;
                L0.q qVar = this.f324t;
                C0001a c0001a = this.f320p;
                if (!zC) {
                    c0001a.f134e.getClass();
                    String str5 = oVar.f1564d;
                    F3.i.f(str5, "className");
                    String str6 = C0.l.f162a;
                    try {
                        Object objNewInstance = Class.forName(str5).getDeclaredConstructor(null).newInstance(null);
                        F3.i.d(objNewInstance, "null cannot be cast to non-null type androidx.work.InputMerger");
                        kVar = (C0.k) objNewInstance;
                    } catch (Exception e5) {
                        C0.t.d().c(C0.l.f162a, "Trouble instantiating ".concat(str5), e5);
                        kVar = null;
                    }
                    if (kVar == null) {
                        C0.t.d().b(str4, "Could not create Input Merger ".concat(str5));
                        g();
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(hVarA);
                    qVar.getClass();
                    C0738n c0738nO = C0738n.o(1, "SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)");
                    if (str == null) {
                        c0738nO.t(1);
                    } else {
                        c0738nO.h(1, str);
                    }
                    AbstractC0737m abstractC0737m = qVar.f1582a;
                    abstractC0737m.b();
                    Cursor cursorM = abstractC0737m.m(c0738nO, null);
                    try {
                        ArrayList arrayList2 = new ArrayList(cursorM.getCount());
                        while (cursorM.moveToNext()) {
                            arrayList2.add(C0.h.a(cursorM.isNull(0) ? null : cursorM.getBlob(0)));
                        }
                        cursorM.close();
                        c0738nO.s();
                        arrayList.addAll(arrayList2);
                        hVarA = kVar.a(arrayList);
                    } catch (Throwable th) {
                        cursorM.close();
                        c0738nO.s();
                        throw th;
                    }
                }
                UUID uuidFromString = UUID.fromString(str);
                ExecutorService executorService = c0001a.f130a;
                K0.a aVar = this.f322r;
                L0.i iVar = this.n;
                M0.r rVar = new M0.r(workDatabase, aVar, iVar);
                WorkerParameters workerParameters = new WorkerParameters();
                workerParameters.f4479a = uuidFromString;
                workerParameters.f4480b = hVarA;
                new HashSet(list);
                workerParameters.f4481c = executorService;
                workerParameters.f4482d = iVar;
                B b5 = c0001a.f133d;
                workerParameters.f4483e = b5;
                if (this.f318m == null) {
                    Context context = this.f315j;
                    b5.getClass();
                    this.f318m = B.a(context, str3, workerParameters);
                }
                C0.s sVar = this.f318m;
                if (sVar == null) {
                    C0.t.d().b(str4, "Could not create Worker " + str3);
                    g();
                    return;
                }
                if (sVar.f171f) {
                    C0.t.d().b(str4, "Received an already-used Worker " + str3 + "; Worker Factory should return new instances");
                    g();
                    return;
                }
                sVar.f171f = true;
                workDatabase.c();
                try {
                    if (qVar.f(str) == 1) {
                        qVar.m(2, str);
                        AbstractC0737m abstractC0737m2 = qVar.f1582a;
                        abstractC0737m2.b();
                        L0.h hVar = qVar.f1588i;
                        C0847j c0847jA = hVar.a();
                        if (str == null) {
                            c0847jA.t(1);
                        } else {
                            c0847jA.h(1, str);
                        }
                        abstractC0737m2.c();
                        try {
                            c0847jA.c();
                            abstractC0737m2.o();
                            abstractC0737m2.k();
                            hVar.n(c0847jA);
                            qVar.n(-256, str);
                            z4 = true;
                        } catch (Throwable th2) {
                            abstractC0737m2.k();
                            hVar.n(c0847jA);
                            throw th2;
                        }
                    } else {
                        z4 = false;
                    }
                    workDatabase.o();
                    if (!z4) {
                        f();
                        return;
                    }
                    if (h()) {
                        return;
                    }
                    M0.q qVar2 = new M0.q(this.f315j, this.f317l, this.f318m, rVar, this.n);
                    ((V0) iVar.f1550f).execute(qVar2);
                    N0.k kVar2 = qVar2.f1695j;
                    D.m mVar = new D.m(this, 1, kVar2);
                    C2.c cVar = new C2.c(6);
                    N0.k kVar3 = this.f329y;
                    kVar3.a(mVar, cVar);
                    boolean z6 = false;
                    kVar2.a(new RunnableC0999a(2, this, kVar2, z6), (V0) iVar.f1550f);
                    kVar3.a(new RunnableC0999a(3, this, this.f327w, z6), (M0.m) iVar.f1547c);
                    return;
                } finally {
                }
            }
            f();
            workDatabase.o();
            C0.t.d().a(str4, str3 + " is not in ENQUEUED state. Nothing more to do");
        } finally {
            workDatabase.k();
        }
    }
}
