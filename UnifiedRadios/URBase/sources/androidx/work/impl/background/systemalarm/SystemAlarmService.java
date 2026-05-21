package androidx.work.impl.background.systemalarm;

import C0.t;
import F0.k;
import F0.l;
import M0.o;
import M0.p;
import android.content.Intent;
import android.os.PowerManager;
import androidx.lifecycle.AbstractServiceC0252w;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SystemAlarmService extends AbstractServiceC0252w implements k {

    /* renamed from: f, reason: collision with root package name */
    public static final String f4492f = t.f("SystemAlarmService");

    /* renamed from: d, reason: collision with root package name */
    public l f4493d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4494e;

    public final void a() {
        this.f4494e = true;
        t.d().a(f4492f, "All commands completed in dispatcher");
        String str = o.f1691a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (p.f1692a) {
            linkedHashMap.putAll(p.f1693b);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) entry.getKey();
            String str2 = (String) entry.getValue();
            if (wakeLock != null && wakeLock.isHeld()) {
                t.d().g(o.f1691a, "WakeLock held for " + str2);
            }
        }
        stopSelf();
    }

    @Override // androidx.lifecycle.AbstractServiceC0252w, android.app.Service
    public final void onCreate() {
        super.onCreate();
        l lVar = new l(this);
        this.f4493d = lVar;
        if (lVar.f534k != null) {
            t.d().b(l.f527m, "A completion listener for SystemAlarmDispatcher already exists.");
        } else {
            lVar.f534k = this;
        }
        this.f4494e = false;
    }

    @Override // androidx.lifecycle.AbstractServiceC0252w, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f4494e = true;
        l lVar = this.f4493d;
        lVar.getClass();
        t.d().a(l.f527m, "Destroying SystemAlarmDispatcher");
        lVar.f531f.e(lVar);
        lVar.f534k = null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i5, int i6) {
        super.onStartCommand(intent, i5, i6);
        if (this.f4494e) {
            t.d().e(f4492f, "Re-initializing SystemAlarmDispatcher after a request to shut-down.");
            l lVar = this.f4493d;
            lVar.getClass();
            t tVarD = t.d();
            String str = l.f527m;
            tVarD.a(str, "Destroying SystemAlarmDispatcher");
            lVar.f531f.e(lVar);
            lVar.f534k = null;
            l lVar2 = new l(this);
            this.f4493d = lVar2;
            if (lVar2.f534k != null) {
                t.d().b(str, "A completion listener for SystemAlarmDispatcher already exists.");
            } else {
                lVar2.f534k = this;
            }
            this.f4494e = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f4493d.a(intent, i6);
        return 3;
    }
}
