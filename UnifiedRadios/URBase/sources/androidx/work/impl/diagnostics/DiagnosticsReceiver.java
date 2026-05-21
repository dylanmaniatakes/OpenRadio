package androidx.work.impl.diagnostics;

import C0.t;
import D0.v;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4499a = t.f("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        t tVarD = t.d();
        String str = f4499a;
        tVarD.a(str, "Requesting diagnostics");
        try {
            v.y(context).e(C0.v.a());
        } catch (IllegalStateException e5) {
            t.d().c(str, "WorkManager is not initialized", e5);
        }
    }
}
