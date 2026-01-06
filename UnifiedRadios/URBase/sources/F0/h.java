package F0;

import D0.n;
import J1.V0;
import L0.o;
import M0.m;
import M0.t;
import M0.u;
import M0.v;
import N3.I;
import N3.T;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import f3.C0519j;

/* loaded from: classes.dex */
public final class h implements H0.e, t {

    /* renamed from: q, reason: collision with root package name */
    public static final String f509q = C0.t.f("DelayMetCommandHandler");

    /* renamed from: c, reason: collision with root package name */
    public final Context f510c;

    /* renamed from: d, reason: collision with root package name */
    public final int f511d;

    /* renamed from: e, reason: collision with root package name */
    public final L0.j f512e;

    /* renamed from: f, reason: collision with root package name */
    public final l f513f;
    public final C0519j g;
    public final Object h;

    /* renamed from: i, reason: collision with root package name */
    public int f514i;

    /* renamed from: j, reason: collision with root package name */
    public final m f515j;

    /* renamed from: k, reason: collision with root package name */
    public final V0 f516k;

    /* renamed from: l, reason: collision with root package name */
    public PowerManager.WakeLock f517l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f518m;
    public final n n;

    /* renamed from: o, reason: collision with root package name */
    public final I f519o;

    /* renamed from: p, reason: collision with root package name */
    public volatile T f520p;

    public h(Context context, int i5, l lVar, n nVar) {
        this.f510c = context;
        this.f511d = i5;
        this.f513f = lVar;
        this.f512e = nVar.f281a;
        this.n = nVar;
        L0.i iVar = lVar.g.f307j;
        L0.i iVar2 = lVar.f529d;
        this.f515j = (m) iVar2.f1547c;
        this.f516k = (V0) iVar2.f1550f;
        this.f519o = (I) iVar2.f1548d;
        this.g = new C0519j(iVar);
        this.f518m = false;
        this.f514i = 0;
        this.h = new Object();
    }

    public static void a(h hVar) {
        boolean z4;
        L0.j jVar = hVar.f512e;
        String str = jVar.f1551a;
        int i5 = hVar.f514i;
        String str2 = f509q;
        if (i5 >= 2) {
            C0.t.d().a(str2, "Already stopped work for " + str);
            return;
        }
        hVar.f514i = 2;
        C0.t.d().a(str2, "Stopping work for WorkSpec " + str);
        Context context = hVar.f510c;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        c.c(intent, jVar);
        V0 v0 = hVar.f516k;
        l lVar = hVar.f513f;
        int i6 = hVar.f511d;
        v0.execute(new j(lVar, intent, i6, 0));
        D0.h hVar2 = lVar.f531f;
        String str3 = jVar.f1551a;
        synchronized (hVar2.f269k) {
            z4 = hVar2.c(str3) != null;
        }
        if (!z4) {
            C0.t.d().a(str2, "Processor does not have WorkSpec " + str + ". No need to reschedule");
            return;
        }
        C0.t.d().a(str2, "WorkSpec " + str + " needs to be rescheduled");
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_SCHEDULE_WORK");
        c.c(intent2, jVar);
        v0.execute(new j(lVar, intent2, i6, 0));
    }

    public static void b(h hVar) {
        if (hVar.f514i != 0) {
            C0.t.d().a(f509q, "Already started work for " + hVar.f512e);
            return;
        }
        hVar.f514i = 1;
        C0.t.d().a(f509q, "onAllConstraintsMet for " + hVar.f512e);
        if (!hVar.f513f.f531f.g(hVar.n, null)) {
            hVar.d();
            return;
        }
        v vVar = hVar.f513f.f530e;
        L0.j jVar = hVar.f512e;
        synchronized (vVar.f1709d) {
            C0.t.d().a(v.f1705e, "Starting timer for " + jVar);
            vVar.a(jVar);
            u uVar = new u(vVar, jVar);
            vVar.f1707b.put(jVar, uVar);
            vVar.f1708c.put(jVar, hVar);
            ((Handler) vVar.f1706a.f1554d).postDelayed(uVar, 600000L);
        }
    }

    @Override // H0.e
    public final void c(o oVar, H0.c cVar) {
        boolean z4 = cVar instanceof H0.a;
        m mVar = this.f515j;
        if (z4) {
            mVar.execute(new g(this, 1));
        } else {
            mVar.execute(new g(this, 0));
        }
    }

    public final void d() {
        synchronized (this.h) {
            try {
                if (this.f520p != null) {
                    this.f520p.c(null);
                }
                this.f513f.f530e.a(this.f512e);
                PowerManager.WakeLock wakeLock = this.f517l;
                if (wakeLock != null && wakeLock.isHeld()) {
                    C0.t.d().a(f509q, "Releasing wakelock " + this.f517l + "for WorkSpec " + this.f512e);
                    this.f517l.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        String str = this.f512e.f1551a;
        this.f517l = M0.o.a(this.f510c, str + " (" + this.f511d + ")");
        C0.t tVarD = C0.t.d();
        String str2 = f509q;
        tVarD.a(str2, "Acquiring wakelock " + this.f517l + "for WorkSpec " + str);
        this.f517l.acquire();
        o oVarH = this.f513f.g.f302c.v().h(str);
        if (oVarH == null) {
            this.f515j.execute(new g(this, 0));
            return;
        }
        boolean zB = oVarH.b();
        this.f518m = zB;
        if (zB) {
            this.f520p = H0.k.a(this.g, oVarH, this.f519o, this);
            return;
        }
        C0.t.d().a(str2, "No constraints for " + str);
        this.f515j.execute(new g(this, 1));
    }

    public final void f(boolean z4) {
        C0.t tVarD = C0.t.d();
        StringBuilder sb = new StringBuilder("onExecuted ");
        L0.j jVar = this.f512e;
        sb.append(jVar);
        sb.append(", ");
        sb.append(z4);
        tVarD.a(f509q, sb.toString());
        d();
        int i5 = this.f511d;
        l lVar = this.f513f;
        V0 v0 = this.f516k;
        Context context = this.f510c;
        if (z4) {
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_SCHEDULE_WORK");
            c.c(intent, jVar);
            v0.execute(new j(lVar, intent, i5, 0));
        }
        if (this.f518m) {
            Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent2.setAction("ACTION_CONSTRAINTS_CHANGED");
            v0.execute(new j(lVar, intent2, i5, 0));
        }
    }
}
