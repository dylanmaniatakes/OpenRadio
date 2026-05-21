package F0;

import C0.C0001a;
import C0.t;
import J1.V0;
import M0.o;
import M0.v;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class l implements D0.c {

    /* renamed from: m, reason: collision with root package name */
    public static final String f527m = t.f("SystemAlarmDispatcher");

    /* renamed from: c, reason: collision with root package name */
    public final Context f528c;

    /* renamed from: d, reason: collision with root package name */
    public final L0.i f529d;

    /* renamed from: e, reason: collision with root package name */
    public final v f530e;

    /* renamed from: f, reason: collision with root package name */
    public final D0.h f531f;
    public final D0.v g;
    public final c h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f532i;

    /* renamed from: j, reason: collision with root package name */
    public Intent f533j;

    /* renamed from: k, reason: collision with root package name */
    public k f534k;

    /* renamed from: l, reason: collision with root package name */
    public final L0.e f535l;

    public l(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f528c = applicationContext;
        L0.c cVar = new L0.c(2);
        D0.v vVarY = D0.v.y(context);
        this.g = vVarY;
        C0001a c0001a = vVarY.f301b;
        this.h = new c(applicationContext, c0001a.f132c, cVar);
        this.f530e = new v(c0001a.f135f);
        D0.h hVar = vVarY.f305f;
        this.f531f = hVar;
        L0.i iVar = vVarY.f303d;
        this.f529d = iVar;
        this.f535l = new L0.e(hVar, iVar);
        hVar.a(this);
        this.f532i = new ArrayList();
        this.f533j = null;
    }

    public static void b() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public final void a(Intent intent, int i5) {
        t tVarD = t.d();
        String str = f527m;
        tVarD.a(str, "Adding command " + intent + " (" + i5 + ")");
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            t.d().g(str, "Unknown command. Ignoring");
            return;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            b();
            synchronized (this.f532i) {
                try {
                    Iterator it = this.f532i.iterator();
                    while (it.hasNext()) {
                        if ("ACTION_CONSTRAINTS_CHANGED".equals(((Intent) it.next()).getAction())) {
                            return;
                        }
                    }
                } finally {
                }
            }
        }
        intent.putExtra("KEY_START_ID", i5);
        synchronized (this.f532i) {
            try {
                boolean z4 = !this.f532i.isEmpty();
                this.f532i.add(intent);
                if (!z4) {
                    c();
                }
            } finally {
            }
        }
    }

    public final void c() {
        b();
        PowerManager.WakeLock wakeLockA = o.a(this.f528c, "ProcessCommand");
        try {
            wakeLockA.acquire();
            this.g.f303d.c(new i(this, 0));
        } finally {
            wakeLockA.release();
        }
    }

    @Override // D0.c
    public final void e(L0.j jVar, boolean z4) {
        int i5 = 0;
        V0 v0 = (V0) this.f529d.f1550f;
        String str = c.h;
        Intent intent = new Intent(this.f528c, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z4);
        c.c(intent, jVar);
        v0.execute(new j(this, intent, i5, i5));
    }
}
