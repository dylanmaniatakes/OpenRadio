package X2;

import J1.R0;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessaging;

/* loaded from: classes.dex */
public final class v extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2841a = 0;

    /* renamed from: b, reason: collision with root package name */
    public Context f2842b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2843c;

    public /* synthetic */ v() {
    }

    public void a() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Connectivity change received registered");
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        R0 r02 = (R0) this.f2843c;
        if (r02 != null) {
            Context context = ((FirebaseMessaging) r02.f939m).f5544b;
            this.f2842b = context;
            context.registerReceiver(this, intentFilter);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.f2841a) {
            case 0:
                R0 r02 = (R0) this.f2843c;
                if (r02 != null && r02.a()) {
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                    }
                    R0 r03 = (R0) this.f2843c;
                    ((FirebaseMessaging) r03.f939m).getClass();
                    FirebaseMessaging.b(r03, 0L);
                    Context context2 = this.f2842b;
                    if (context2 != null) {
                        context2.unregisterReceiver(this);
                    }
                    this.f2843c = null;
                    return;
                }
                return;
            default:
                Uri data = intent.getData();
                if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
                    L0.s sVar = (L0.s) this.f2843c;
                    p1.q qVar = (p1.q) ((N1.p) sVar.f1597e).f1803l;
                    qVar.f9132e.set(null);
                    A1.f fVar = qVar.f9134i.n;
                    fVar.sendMessage(fVar.obtainMessage(3));
                    Dialog dialog = (Dialog) sVar.f1596d;
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                    synchronized (this) {
                        try {
                            Context context3 = this.f2842b;
                            if (context3 != null) {
                                context3.unregisterReceiver(this);
                            }
                            this.f2842b = null;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                }
                return;
        }
    }

    public v(L0.s sVar) {
        this.f2843c = sVar;
    }
}
