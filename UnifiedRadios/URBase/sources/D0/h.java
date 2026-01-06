package D0;

import C0.C0001a;
import J1.V0;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundService;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class h implements K0.a {

    /* renamed from: l, reason: collision with root package name */
    public static final String f260l = C0.t.f("Processor");

    /* renamed from: b, reason: collision with root package name */
    public final Context f262b;

    /* renamed from: c, reason: collision with root package name */
    public final C0001a f263c;

    /* renamed from: d, reason: collision with root package name */
    public final L0.i f264d;

    /* renamed from: e, reason: collision with root package name */
    public final WorkDatabase f265e;
    public final HashMap g = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f266f = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public final HashSet f267i = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f268j = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public PowerManager.WakeLock f261a = null;

    /* renamed from: k, reason: collision with root package name */
    public final Object f269k = new Object();
    public final HashMap h = new HashMap();

    public h(Context context, C0001a c0001a, L0.i iVar, WorkDatabase workDatabase) {
        this.f262b = context;
        this.f263c = c0001a;
        this.f264d = iVar;
        this.f265e = workDatabase;
    }

    public static boolean d(String str, x xVar, int i5) {
        if (xVar == null) {
            C0.t.d().a(f260l, "WorkerWrapper could not be found for " + str);
            return false;
        }
        xVar.f330z = i5;
        xVar.h();
        xVar.f329y.cancel(true);
        if (xVar.f318m == null || !(xVar.f329y.f1783j instanceof N0.a)) {
            C0.t.d().a(x.f314A, "WorkSpec " + xVar.f317l + " is already done. Not interrupting.");
        } else {
            xVar.f318m.e(i5);
        }
        C0.t.d().a(f260l, "WorkerWrapper interrupted for " + str);
        return true;
    }

    public final void a(c cVar) {
        synchronized (this.f269k) {
            this.f268j.add(cVar);
        }
    }

    public final x b(String str) {
        x xVar = (x) this.f266f.remove(str);
        boolean z4 = xVar != null;
        if (!z4) {
            xVar = (x) this.g.remove(str);
        }
        this.h.remove(str);
        if (z4) {
            synchronized (this.f269k) {
                try {
                    if (!(true ^ this.f266f.isEmpty())) {
                        Context context = this.f262b;
                        String str2 = K0.c.f1492l;
                        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
                        intent.setAction("ACTION_STOP_FOREGROUND");
                        try {
                            this.f262b.startService(intent);
                        } catch (Throwable th) {
                            C0.t.d().c(f260l, "Unable to stop foreground service", th);
                        }
                        PowerManager.WakeLock wakeLock = this.f261a;
                        if (wakeLock != null) {
                            wakeLock.release();
                            this.f261a = null;
                        }
                    }
                } finally {
                }
            }
        }
        return xVar;
    }

    public final x c(String str) {
        x xVar = (x) this.f266f.get(str);
        return xVar == null ? (x) this.g.get(str) : xVar;
    }

    public final void e(c cVar) {
        synchronized (this.f269k) {
            this.f268j.remove(cVar);
        }
    }

    public final void f(String str, C0.i iVar) {
        synchronized (this.f269k) {
            try {
                C0.t.d().e(f260l, "Moving WorkSpec (" + str + ") to the foreground");
                x xVar = (x) this.g.remove(str);
                if (xVar != null) {
                    if (this.f261a == null) {
                        PowerManager.WakeLock wakeLockA = M0.o.a(this.f262b, "ProcessorForegroundLck");
                        this.f261a = wakeLockA;
                        wakeLockA.acquire();
                    }
                    this.f266f.put(str, xVar);
                    C.f.b(this.f262b, K0.c.b(this.f262b, AbstractC0409x1.d(xVar.f317l), iVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean g(n nVar, C0.u uVar) {
        boolean z4;
        L0.j jVar = nVar.f281a;
        String str = jVar.f1551a;
        ArrayList arrayList = new ArrayList();
        L0.o oVar = (L0.o) this.f265e.n(new e(this, arrayList, str, 0));
        if (oVar == null) {
            C0.t.d().g(f260l, "Didn't find WorkSpec for id " + jVar);
            ((V0) this.f264d.f1550f).execute(new g(this, jVar));
            return false;
        }
        synchronized (this.f269k) {
            try {
                synchronized (this.f269k) {
                    z4 = c(str) != null;
                }
                if (z4) {
                    Set set = (Set) this.h.get(str);
                    if (((n) set.iterator().next()).f281a.f1552b == jVar.f1552b) {
                        set.add(nVar);
                        C0.t.d().a(f260l, "Work " + jVar + " is already enqueued for processing");
                    } else {
                        ((V0) this.f264d.f1550f).execute(new g(this, jVar));
                    }
                    return false;
                }
                if (oVar.f1577t != jVar.f1552b) {
                    ((V0) this.f264d.f1550f).execute(new g(this, jVar));
                    return false;
                }
                x xVar = new x(new w(this.f262b, this.f263c, this.f264d, this, this.f265e, oVar, arrayList));
                N0.k kVar = xVar.f328x;
                kVar.a(new f(this, kVar, xVar, 0), (V0) this.f264d.f1550f);
                this.g.put(str, xVar);
                HashSet hashSet = new HashSet();
                hashSet.add(nVar);
                this.h.put(str, hashSet);
                ((M0.m) this.f264d.f1547c).execute(xVar);
                C0.t.d().a(f260l, h.class.getSimpleName() + ": processing " + jVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
