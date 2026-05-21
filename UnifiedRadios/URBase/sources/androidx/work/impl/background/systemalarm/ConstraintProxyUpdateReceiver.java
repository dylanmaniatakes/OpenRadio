package androidx.work.impl.background.systemalarm;

import C0.t;
import D0.v;
import F0.e;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.unified.ur1.SatelliteTracker.h;

/* loaded from: classes.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4490a = t.f("ConstrntProxyUpdtRecvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            t.d().a(f4490a, h.s("Ignoring unknown action ", action));
            return;
        }
        BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
        v.y(context).f303d.c(new e(intent, context, pendingResultGoAsync, 0));
    }
}
