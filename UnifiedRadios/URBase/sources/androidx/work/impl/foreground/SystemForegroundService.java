package androidx.work.impl.foreground;

import C0.t;
import D0.v;
import K0.b;
import K0.c;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.AbstractServiceC0252w;
import java.util.UUID;
import z2.RunnableC0999a;

/* loaded from: classes.dex */
public class SystemForegroundService extends AbstractServiceC0252w implements b {
    public static final String h = t.f("SystemFgService");

    /* renamed from: d, reason: collision with root package name */
    public Handler f4500d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4501e;

    /* renamed from: f, reason: collision with root package name */
    public c f4502f;
    public NotificationManager g;

    public final void a() {
        this.f4500d = new Handler(Looper.getMainLooper());
        this.g = (NotificationManager) getApplicationContext().getSystemService("notification");
        c cVar = new c(getApplicationContext());
        this.f4502f = cVar;
        if (cVar.f1499k != null) {
            t.d().b(c.f1492l, "A callback already exists.");
        } else {
            cVar.f1499k = this;
        }
    }

    @Override // androidx.lifecycle.AbstractServiceC0252w, android.app.Service
    public final void onCreate() {
        super.onCreate();
        a();
    }

    @Override // androidx.lifecycle.AbstractServiceC0252w, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        this.f4502f.f();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i5, int i6) {
        super.onStartCommand(intent, i5, i6);
        boolean z4 = this.f4501e;
        String str = h;
        if (z4) {
            t.d().e(str, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.f4502f.f();
            a();
            this.f4501e = false;
        }
        if (intent == null) {
            return 3;
        }
        c cVar = this.f4502f;
        cVar.getClass();
        String action = intent.getAction();
        boolean zEquals = "ACTION_START_FOREGROUND".equals(action);
        String str2 = c.f1492l;
        if (zEquals) {
            t.d().e(str2, "Started foreground service " + intent);
            cVar.f1494d.c(new RunnableC0999a(21, cVar, intent.getStringExtra("KEY_WORKSPEC_ID"), false));
            cVar.d(intent);
            return 3;
        }
        if ("ACTION_NOTIFY".equals(action)) {
            cVar.d(intent);
            return 3;
        }
        if (!"ACTION_CANCEL_WORK".equals(action)) {
            if (!"ACTION_STOP_FOREGROUND".equals(action)) {
                return 3;
            }
            t.d().e(str2, "Stopping foreground service");
            b bVar = cVar.f1499k;
            if (bVar == null) {
                return 3;
            }
            SystemForegroundService systemForegroundService = (SystemForegroundService) bVar;
            systemForegroundService.f4501e = true;
            t.d().a(str, "All commands completed.");
            systemForegroundService.stopForeground(true);
            systemForegroundService.stopSelf();
            return 3;
        }
        t.d().e(str2, "Stopping foreground work for " + intent);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return 3;
        }
        UUID uuidFromString = UUID.fromString(stringExtra);
        v vVar = cVar.f1493c;
        vVar.getClass();
        vVar.f303d.c(new M0.b(vVar, uuidFromString));
        return 3;
    }
}
