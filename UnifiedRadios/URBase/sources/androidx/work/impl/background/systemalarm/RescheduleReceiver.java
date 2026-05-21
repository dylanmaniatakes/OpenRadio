package androidx.work.impl.background.systemalarm;

import C0.t;
import D0.v;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4491a = t.f("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        t.d().a(f4491a, "Received intent " + intent);
        try {
            v vVarY = v.y(context);
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            synchronized (v.f299m) {
                try {
                    BroadcastReceiver.PendingResult pendingResult = vVarY.f306i;
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                    vVarY.f306i = pendingResultGoAsync;
                    if (vVarY.h) {
                        pendingResultGoAsync.finish();
                        vVarY.f306i = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (IllegalStateException e5) {
            t.d().c(f4491a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e5);
        }
    }
}
