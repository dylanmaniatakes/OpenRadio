package F0;

import C0.t;
import C0.u;
import D0.n;
import J1.V0;
import L0.o;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import g0.AbstractC0535a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import l0.AbstractC0737m;
import q0.C0847j;

/* loaded from: classes.dex */
public final class c implements D0.c {
    public static final String h = t.f("CommandHandler");

    /* renamed from: c, reason: collision with root package name */
    public final Context f493c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f494d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final Object f495e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public final u f496f;
    public final L0.c g;

    public c(Context context, u uVar, L0.c cVar) {
        this.f493c = context;
        this.f496f = uVar;
        this.g = cVar;
    }

    public static L0.j b(Intent intent) {
        return new L0.j(intent.getStringExtra("KEY_WORKSPEC_ID"), intent.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    public static void c(Intent intent, L0.j jVar) {
        intent.putExtra("KEY_WORKSPEC_ID", jVar.f1551a);
        intent.putExtra("KEY_WORKSPEC_GENERATION", jVar.f1552b);
    }

    public final void a(Intent intent, int i5, l lVar) {
        List<n> listL;
        String action = intent.getAction();
        int i6 = 0;
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            t.d().a(h, "Handling constraints changed " + intent);
            f fVar = new f(this.f493c, this.f496f, i5, lVar);
            ArrayList arrayListE = lVar.g.f302c.v().e();
            String str = d.f497a;
            Iterator it = arrayListE.iterator();
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            while (it.hasNext()) {
                C0.d dVar = ((o) it.next()).f1568j;
                z4 |= dVar.f146d;
                z5 |= dVar.f144b;
                z6 |= dVar.f147e;
                z7 |= dVar.f143a != 1;
                if (z4 && z5 && z6 && z7) {
                    break;
                }
            }
            String str2 = ConstraintProxyUpdateReceiver.f4490a;
            Intent intent2 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
            Context context = fVar.f503a;
            intent2.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
            intent2.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z4).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z5).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z6).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z7);
            context.sendBroadcast(intent2);
            ArrayList arrayList = new ArrayList(arrayListE.size());
            fVar.f504b.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator it2 = arrayListE.iterator();
            while (it2.hasNext()) {
                o oVar = (o) it2.next();
                if (jCurrentTimeMillis >= oVar.a() && (!oVar.b() || fVar.f506d.r(oVar))) {
                    arrayList.add(oVar);
                }
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                o oVar2 = (o) it3.next();
                String str3 = oVar2.f1561a;
                L0.j jVarD = AbstractC0409x1.d(oVar2);
                Intent intent3 = new Intent(context, (Class<?>) SystemAlarmService.class);
                intent3.setAction("ACTION_DELAY_MET");
                c(intent3, jVarD);
                t.d().a(f.f502e, AbstractC0535a.l("Creating a delay_met command for workSpec with id (", str3, ")"));
                ((V0) lVar.f529d.f1550f).execute(new j(lVar, intent3, fVar.f505c, i6));
            }
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            t.d().a(h, "Handling reschedule " + intent + ", " + i5);
            lVar.g.A();
            return;
        }
        Bundle extras = intent.getExtras();
        String[] strArr = {"KEY_WORKSPEC_ID"};
        if (extras == null || extras.isEmpty() || extras.get(strArr[0]) == null) {
            t.d().b(h, "Invalid request for " + action + " , requires KEY_WORKSPEC_ID .");
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            L0.j jVarB = b(intent);
            String str4 = h;
            t.d().a(str4, "Handling schedule work for " + jVarB);
            WorkDatabase workDatabase = lVar.g.f302c;
            workDatabase.c();
            try {
                o oVarH = workDatabase.v().h(jVarB.f1551a);
                if (oVarH == null) {
                    t.d().g(str4, "Skipping scheduling " + jVarB + " because it's no longer in the DB");
                } else if (AbstractC0535a.d(oVarH.f1562b)) {
                    t.d().g(str4, "Skipping scheduling " + jVarB + "because it is finished.");
                } else {
                    long jA = oVarH.a();
                    boolean zB = oVarH.b();
                    Context context2 = this.f493c;
                    if (zB) {
                        t.d().a(str4, "Opportunistically setting an alarm for " + jVarB + "at " + jA);
                        b.b(context2, workDatabase, jVarB, jA);
                        Intent intent4 = new Intent(context2, (Class<?>) SystemAlarmService.class);
                        intent4.setAction("ACTION_CONSTRAINTS_CHANGED");
                        ((V0) lVar.f529d.f1550f).execute(new j(lVar, intent4, i5, i6));
                    } else {
                        t.d().a(str4, "Setting up Alarms for " + jVarB + "at " + jA);
                        b.b(context2, workDatabase, jVarB, jA);
                    }
                    workDatabase.o();
                }
                return;
            } finally {
                workDatabase.k();
            }
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            synchronized (this.f495e) {
                try {
                    L0.j jVarB2 = b(intent);
                    t tVarD = t.d();
                    String str5 = h;
                    tVarD.a(str5, "Handing delay met for " + jVarB2);
                    if (this.f494d.containsKey(jVarB2)) {
                        t.d().a(str5, "WorkSpec " + jVarB2 + " is is already being handled for ACTION_DELAY_MET");
                    } else {
                        h hVar = new h(this.f493c, i5, lVar, this.g.n(jVarB2));
                        this.f494d.put(jVarB2, hVar);
                        hVar.e();
                    }
                } finally {
                }
            }
            return;
        }
        if (!"ACTION_STOP_WORK".equals(action)) {
            if (!"ACTION_EXECUTION_COMPLETED".equals(action)) {
                t.d().g(h, "Ignoring intent " + intent);
                return;
            }
            L0.j jVarB3 = b(intent);
            boolean z8 = intent.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
            t.d().a(h, "Handling onExecutionCompleted " + intent + ", " + i5);
            e(jVarB3, z8);
            return;
        }
        Bundle extras2 = intent.getExtras();
        String string = extras2.getString("KEY_WORKSPEC_ID");
        boolean zContainsKey = extras2.containsKey("KEY_WORKSPEC_GENERATION");
        L0.c cVar = this.g;
        if (zContainsKey) {
            int i7 = extras2.getInt("KEY_WORKSPEC_GENERATION");
            ArrayList arrayList2 = new ArrayList(1);
            n nVarJ = cVar.j(new L0.j(string, i7));
            listL = arrayList2;
            if (nVarJ != null) {
                arrayList2.add(nVarJ);
                listL = arrayList2;
            }
        } else {
            listL = cVar.l(string);
        }
        for (n nVar : listL) {
            t.d().a(h, com.unified.ur1.SatelliteTracker.h.s("Handing stopWork work for ", string));
            L0.e eVar = lVar.f535l;
            eVar.getClass();
            F3.i.f(nVar, "workSpecId");
            eVar.u(nVar, -512);
            WorkDatabase workDatabase2 = lVar.g.f302c;
            String str6 = b.f492a;
            L0.i iVarS = workDatabase2.s();
            L0.j jVar = nVar.f281a;
            L0.g gVarG = iVarS.g(jVar);
            if (gVarG != null) {
                b.a(this.f493c, jVar, gVarG.f1545c);
                t.d().a(b.f492a, "Removing SystemIdInfo for workSpecId (" + jVar + ")");
                AbstractC0737m abstractC0737m = (AbstractC0737m) iVarS.f1547c;
                abstractC0737m.b();
                L0.h hVar2 = (L0.h) iVarS.f1549e;
                C0847j c0847jA = hVar2.a();
                String str7 = jVar.f1551a;
                if (str7 == null) {
                    c0847jA.t(1);
                } else {
                    c0847jA.h(1, str7);
                }
                c0847jA.I(2, jVar.f1552b);
                abstractC0737m.c();
                try {
                    c0847jA.c();
                    abstractC0737m.o();
                } finally {
                    abstractC0737m.k();
                    hVar2.n(c0847jA);
                }
            }
            lVar.e(jVar, false);
        }
    }

    @Override // D0.c
    public final void e(L0.j jVar, boolean z4) {
        synchronized (this.f495e) {
            try {
                h hVar = (h) this.f494d.remove(jVar);
                this.g.j(jVar);
                if (hVar != null) {
                    hVar.f(z4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
