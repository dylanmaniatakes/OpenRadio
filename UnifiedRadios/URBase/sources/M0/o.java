package M0;

import android.content.Context;
import android.os.PowerManager;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1691a;

    static {
        String strF = C0.t.f("WakeLocks");
        F3.i.e(strF, "tagWithPrefix(\"WakeLocks\")");
        f1691a = strF;
    }

    public static final PowerManager.WakeLock a(Context context, String str) {
        F3.i.f(context, "context");
        F3.i.f(str, "tag");
        Object systemService = context.getApplicationContext().getSystemService("power");
        F3.i.d(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        String strConcat = "WorkManager: ".concat(str);
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(1, strConcat);
        synchronized (p.f1692a) {
        }
        F3.i.e(wakeLockNewWakeLock, "wakeLock");
        return wakeLockNewWakeLock;
    }
}
