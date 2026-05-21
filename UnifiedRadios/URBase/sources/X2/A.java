package X2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class A extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public B f2755a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ B f2756b;

    public A(B b5, B b6) {
        this.f2756b = b5;
        this.f2755a = b6;
    }

    public final void a() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Connectivity change received registered");
        }
        this.f2756b.f2760j.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public final synchronized void onReceive(Context context, Intent intent) {
        try {
            B b5 = this.f2755a;
            if (b5 == null) {
                return;
            }
            if (b5.d()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                B b6 = this.f2755a;
                b6.f2763m.f2862f.schedule(b6, 0L, TimeUnit.SECONDS);
                context.unregisterReceiver(this);
                this.f2755a = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
