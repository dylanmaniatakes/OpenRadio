package E0;

import C0.C0001a;
import C0.t;
import C0.u;
import D0.h;
import D0.j;
import D0.n;
import H0.e;
import H0.k;
import L0.i;
import L0.l;
import L0.o;
import N3.I;
import N3.P;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import f3.C0519j;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import z2.RunnableC0999a;

/* loaded from: classes.dex */
public final class c implements j, e, D0.c {

    /* renamed from: q, reason: collision with root package name */
    public static final String f444q = t.f("GreedyScheduler");

    /* renamed from: c, reason: collision with root package name */
    public final Context f445c;

    /* renamed from: e, reason: collision with root package name */
    public final a f447e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f448f;

    /* renamed from: i, reason: collision with root package name */
    public final h f449i;

    /* renamed from: j, reason: collision with root package name */
    public final L0.e f450j;

    /* renamed from: k, reason: collision with root package name */
    public final C0001a f451k;

    /* renamed from: m, reason: collision with root package name */
    public Boolean f453m;
    public final C0519j n;

    /* renamed from: o, reason: collision with root package name */
    public final i f454o;

    /* renamed from: p, reason: collision with root package name */
    public final d f455p;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f446d = new HashMap();
    public final Object g = new Object();
    public final L0.c h = new L0.c(2);

    /* renamed from: l, reason: collision with root package name */
    public final HashMap f452l = new HashMap();

    public c(Context context, C0001a c0001a, i iVar, h hVar, L0.e eVar, i iVar2) {
        this.f445c = context;
        u uVar = c0001a.f132c;
        l lVar = c0001a.f135f;
        this.f447e = new a(this, lVar, uVar);
        this.f455p = new d(lVar, eVar);
        this.f454o = iVar2;
        this.n = new C0519j(iVar);
        this.f451k = c0001a;
        this.f449i = hVar;
        this.f450j = eVar;
    }

    @Override // D0.j
    public final void a(String str) {
        Runnable runnable;
        if (this.f453m == null) {
            int i5 = M0.l.f1682a;
            Context context = this.f445c;
            F3.i.f(context, "context");
            F3.i.f(this.f451k, "configuration");
            this.f453m = Boolean.valueOf(F3.i.a(M0.a.f1663a.a(), context.getApplicationInfo().processName));
        }
        boolean zBooleanValue = this.f453m.booleanValue();
        String str2 = f444q;
        if (!zBooleanValue) {
            t.d().e(str2, "Ignoring schedule request in non-main process");
            return;
        }
        if (!this.f448f) {
            this.f449i.a(this);
            this.f448f = true;
        }
        t.d().a(str2, "Cancelling work ID " + str);
        a aVar = this.f447e;
        if (aVar != null && (runnable = (Runnable) aVar.f441d.remove(str)) != null) {
            ((Handler) aVar.f439b.f1554d).removeCallbacks(runnable);
        }
        for (n nVar : this.h.l(str)) {
            this.f455p.a(nVar);
            L0.e eVar = this.f450j;
            eVar.getClass();
            eVar.u(nVar, -512);
        }
    }

    @Override // D0.j
    public final boolean b() {
        return false;
    }

    @Override // H0.e
    public final void c(o oVar, H0.c cVar) {
        L0.j jVarD = AbstractC0409x1.d(oVar);
        boolean z4 = cVar instanceof H0.a;
        L0.e eVar = this.f450j;
        d dVar = this.f455p;
        String str = f444q;
        L0.c cVar2 = this.h;
        if (z4) {
            if (cVar2.c(jVarD)) {
                return;
            }
            t.d().a(str, "Constraints met: Scheduling work ID " + jVarD);
            n nVarN = cVar2.n(jVarD);
            dVar.b(nVarN);
            ((i) eVar.f1542e).c(new F0.e((h) eVar.f1541d, nVarN, (u) null));
            return;
        }
        t.d().a(str, "Constraints not met: Cancelling work ID " + jVarD);
        n nVarJ = cVar2.j(jVarD);
        if (nVarJ != null) {
            dVar.a(nVarJ);
            int i5 = ((H0.b) cVar).f645a;
            eVar.getClass();
            eVar.u(nVarJ, i5);
        }
    }

    @Override // D0.j
    public final void d(o... oVarArr) {
        long jMax;
        boolean z4 = false;
        if (this.f453m == null) {
            int i5 = M0.l.f1682a;
            Context context = this.f445c;
            F3.i.f(context, "context");
            F3.i.f(this.f451k, "configuration");
            this.f453m = Boolean.valueOf(F3.i.a(M0.a.f1663a.a(), context.getApplicationInfo().processName));
        }
        if (!this.f453m.booleanValue()) {
            t.d().e(f444q, "Ignoring schedule request in a secondary process");
            return;
        }
        if (!this.f448f) {
            this.f449i.a(this);
            this.f448f = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (o oVar : oVarArr) {
            if (!this.h.c(AbstractC0409x1.d(oVar))) {
                synchronized (this.g) {
                    try {
                        L0.j jVarD = AbstractC0409x1.d(oVar);
                        b bVar = (b) this.f452l.get(jVarD);
                        if (bVar == null) {
                            int i6 = oVar.f1569k;
                            this.f451k.f132c.getClass();
                            bVar = new b(i6, System.currentTimeMillis());
                            this.f452l.put(jVarD, bVar);
                        }
                        jMax = (Math.max((oVar.f1569k - bVar.f442a) - 5, 0) * 30000) + bVar.f443b;
                    } finally {
                    }
                }
                long jMax2 = Math.max(oVar.a(), jMax);
                this.f451k.f132c.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (oVar.f1562b == 1) {
                    if (jCurrentTimeMillis < jMax2) {
                        a aVar = this.f447e;
                        if (aVar != null) {
                            HashMap map = aVar.f441d;
                            Runnable runnable = (Runnable) map.remove(oVar.f1561a);
                            l lVar = aVar.f439b;
                            if (runnable != null) {
                                ((Handler) lVar.f1554d).removeCallbacks(runnable);
                            }
                            RunnableC0999a runnableC0999a = new RunnableC0999a(4, aVar, oVar, z4);
                            map.put(oVar.f1561a, runnableC0999a);
                            aVar.f440c.getClass();
                            ((Handler) lVar.f1554d).postDelayed(runnableC0999a, jMax2 - System.currentTimeMillis());
                        }
                    } else if (oVar.b()) {
                        if (oVar.f1568j.f145c) {
                            t.d().a(f444q, "Ignoring " + oVar + ". Requires device idle.");
                        } else if (!r7.h.isEmpty()) {
                            t.d().a(f444q, "Ignoring " + oVar + ". Requires ContentUri triggers.");
                        } else {
                            hashSet.add(oVar);
                            hashSet2.add(oVar.f1561a);
                        }
                    } else if (!this.h.c(AbstractC0409x1.d(oVar))) {
                        t.d().a(f444q, "Starting work for " + oVar.f1561a);
                        L0.c cVar = this.h;
                        cVar.getClass();
                        n nVarN = cVar.n(AbstractC0409x1.d(oVar));
                        this.f455p.b(nVarN);
                        L0.e eVar = this.f450j;
                        ((i) eVar.f1542e).c(new F0.e((h) eVar.f1541d, nVarN, (u) null));
                    }
                }
            }
        }
        synchronized (this.g) {
            try {
                if (!hashSet.isEmpty()) {
                    t.d().a(f444q, "Starting tracking for " + TextUtils.join(",", hashSet2));
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        o oVar2 = (o) it.next();
                        L0.j jVarD2 = AbstractC0409x1.d(oVar2);
                        if (!this.f446d.containsKey(jVarD2)) {
                            this.f446d.put(jVarD2, k.a(this.n, oVar2, (I) this.f454o.f1548d, this));
                        }
                    }
                }
            } finally {
            }
        }
    }

    @Override // D0.c
    public final void e(L0.j jVar, boolean z4) {
        P p4;
        n nVarJ = this.h.j(jVar);
        if (nVarJ != null) {
            this.f455p.a(nVarJ);
        }
        synchronized (this.g) {
            p4 = (P) this.f446d.remove(jVar);
        }
        if (p4 != null) {
            t.d().a(f444q, "Stopping tracking for " + jVar);
            p4.c(null);
        }
        if (z4) {
            return;
        }
        synchronized (this.g) {
            this.f452l.remove(jVar);
        }
    }
}
