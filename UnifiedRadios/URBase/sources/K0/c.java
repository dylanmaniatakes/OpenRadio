package K0;

import B0.r;
import C0.t;
import D0.n;
import D0.v;
import L0.i;
import L0.j;
import L0.o;
import N3.P;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.impl.foreground.SystemForegroundService;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.unified.ur1.SatelliteTracker.h;
import f3.C0519j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class c implements H0.e, D0.c {

    /* renamed from: l, reason: collision with root package name */
    public static final String f1492l = t.f("SystemFgDispatcher");

    /* renamed from: c, reason: collision with root package name */
    public final v f1493c;

    /* renamed from: d, reason: collision with root package name */
    public final i f1494d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f1495e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public j f1496f;
    public final LinkedHashMap g;
    public final HashMap h;

    /* renamed from: i, reason: collision with root package name */
    public final HashMap f1497i;

    /* renamed from: j, reason: collision with root package name */
    public final C0519j f1498j;

    /* renamed from: k, reason: collision with root package name */
    public b f1499k;

    public c(Context context) {
        v vVarY = v.y(context);
        this.f1493c = vVarY;
        this.f1494d = vVarY.f303d;
        this.f1496f = null;
        this.g = new LinkedHashMap();
        this.f1497i = new HashMap();
        this.h = new HashMap();
        this.f1498j = new C0519j(vVarY.f307j);
        vVarY.f305f.a(this);
    }

    public static Intent a(Context context, j jVar, C0.i iVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", iVar.f159a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", iVar.f160b);
        intent.putExtra("KEY_NOTIFICATION", iVar.f161c);
        intent.putExtra("KEY_WORKSPEC_ID", jVar.f1551a);
        intent.putExtra("KEY_GENERATION", jVar.f1552b);
        return intent;
    }

    public static Intent b(Context context, j jVar, C0.i iVar) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", jVar.f1551a);
        intent.putExtra("KEY_GENERATION", jVar.f1552b);
        intent.putExtra("KEY_NOTIFICATION_ID", iVar.f159a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", iVar.f160b);
        intent.putExtra("KEY_NOTIFICATION", iVar.f161c);
        return intent;
    }

    @Override // H0.e
    public final void c(o oVar, H0.c cVar) {
        if (cVar instanceof H0.b) {
            String str = oVar.f1561a;
            t.d().a(f1492l, h.s("Constraints unmet for WorkSpec ", str));
            j jVarD = AbstractC0409x1.d(oVar);
            v vVar = this.f1493c;
            vVar.getClass();
            n nVar = new n(jVarD);
            D0.h hVar = vVar.f305f;
            F3.i.f(hVar, "processor");
            vVar.f303d.c(new M0.n(hVar, nVar, true, -512));
        }
    }

    public final void d(Intent intent) {
        int i5 = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        j jVar = new j(stringExtra, intent.getIntExtra("KEY_GENERATION", 0));
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        t tVarD = t.d();
        StringBuilder sb = new StringBuilder("Notifying with (id:");
        sb.append(intExtra);
        sb.append(", workSpecId: ");
        sb.append(stringExtra);
        sb.append(", notificationType :");
        tVarD.a(f1492l, h.d(sb, intExtra2, ")"));
        if (notification == null || this.f1499k == null) {
            return;
        }
        C0.i iVar = new C0.i(intExtra, notification, intExtra2);
        LinkedHashMap linkedHashMap = this.g;
        linkedHashMap.put(jVar, iVar);
        if (this.f1496f == null) {
            this.f1496f = jVar;
            SystemForegroundService systemForegroundService = (SystemForegroundService) this.f1499k;
            systemForegroundService.f4500d.post(new d(systemForegroundService, intExtra, notification, intExtra2));
            return;
        }
        SystemForegroundService systemForegroundService2 = (SystemForegroundService) this.f1499k;
        systemForegroundService2.f4500d.post(new F0.j(systemForegroundService2, intExtra, notification, 1));
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            i5 |= ((C0.i) ((Map.Entry) it.next()).getValue()).f160b;
        }
        C0.i iVar2 = (C0.i) linkedHashMap.get(this.f1496f);
        if (iVar2 != null) {
            SystemForegroundService systemForegroundService3 = (SystemForegroundService) this.f1499k;
            systemForegroundService3.f4500d.post(new d(systemForegroundService3, iVar2.f159a, iVar2.f161c, i5));
        }
    }

    @Override // D0.c
    public final void e(j jVar, boolean z4) {
        Map.Entry entry;
        synchronized (this.f1495e) {
            try {
                P p4 = ((o) this.h.remove(jVar)) != null ? (P) this.f1497i.remove(jVar) : null;
                if (p4 != null) {
                    p4.c(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        C0.i iVar = (C0.i) this.g.remove(jVar);
        if (jVar.equals(this.f1496f)) {
            if (this.g.size() > 0) {
                Iterator it = this.g.entrySet().iterator();
                Object next = it.next();
                while (true) {
                    entry = (Map.Entry) next;
                    if (!it.hasNext()) {
                        break;
                    } else {
                        next = it.next();
                    }
                }
                this.f1496f = (j) entry.getKey();
                if (this.f1499k != null) {
                    C0.i iVar2 = (C0.i) entry.getValue();
                    SystemForegroundService systemForegroundService = (SystemForegroundService) this.f1499k;
                    systemForegroundService.f4500d.post(new d(systemForegroundService, iVar2.f159a, iVar2.f161c, iVar2.f160b));
                    SystemForegroundService systemForegroundService2 = (SystemForegroundService) this.f1499k;
                    systemForegroundService2.f4500d.post(new r(iVar2.f159a, 1, systemForegroundService2));
                }
            } else {
                this.f1496f = null;
            }
        }
        b bVar = this.f1499k;
        if (iVar == null || bVar == null) {
            return;
        }
        t.d().a(f1492l, "Removing Notification (id: " + iVar.f159a + ", workSpecId: " + jVar + ", notificationType: " + iVar.f160b);
        SystemForegroundService systemForegroundService3 = (SystemForegroundService) bVar;
        systemForegroundService3.f4500d.post(new r(iVar.f159a, 1, systemForegroundService3));
    }

    public final void f() {
        this.f1499k = null;
        synchronized (this.f1495e) {
            try {
                Iterator it = this.f1497i.values().iterator();
                while (it.hasNext()) {
                    ((P) it.next()).c(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f1493c.f305f.e(this);
    }
}
