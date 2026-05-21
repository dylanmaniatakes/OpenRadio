package X2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import t1.C0902a;

/* loaded from: classes.dex */
public final class F implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2770a;

    /* renamed from: b, reason: collision with root package name */
    public final Intent f2771b;

    /* renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f2772c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f2773d;

    /* renamed from: e, reason: collision with root package name */
    public D f2774e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2775f;

    public F(Context context) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(40L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f2773d = new ArrayDeque();
        this.f2775f = false;
        Context applicationContext = context.getApplicationContext();
        this.f2770a = applicationContext;
        this.f2771b = new Intent("com.google.firebase.MESSAGING_EVENT").setPackage(applicationContext.getPackageName());
        this.f2772c = scheduledThreadPoolExecutor;
    }

    public final synchronized void a() {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "flush queue called");
            }
            while (!this.f2773d.isEmpty()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "found intent to be delivered");
                }
                D d5 = this.f2774e;
                if (d5 == null || !d5.isBinderAlive()) {
                    c();
                    return;
                }
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
                }
                this.f2774e.a((E) this.f2773d.poll());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized N1.r b(Intent intent) {
        E e5;
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
            }
            e5 = new E(intent);
            ScheduledExecutorService scheduledExecutorService = this.f2772c;
            e5.f2769b.f1789a.h(scheduledExecutorService, new D0.p(7, scheduledExecutorService.schedule(new C0.e(6, e5), 20L, TimeUnit.SECONDS)));
            this.f2773d.add(e5);
            a();
        } catch (Throwable th) {
            throw th;
        }
        return e5.f2769b.f1789a;
    }

    public final void c() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder("binder is dead. start connection? ");
            sb.append(!this.f2775f);
            Log.d("FirebaseMessaging", sb.toString());
        }
        if (this.f2775f) {
            return;
        }
        this.f2775f = true;
        try {
        } catch (SecurityException e5) {
            Log.e("FirebaseMessaging", "Exception while binding the service", e5);
        }
        if (C0902a.b().a(this.f2770a, this.f2771b, this, 65)) {
            return;
        }
        Log.e("FirebaseMessaging", "binding to the service failed");
        this.f2775f = false;
        while (true) {
            ArrayDeque arrayDeque = this.f2773d;
            if (arrayDeque.isEmpty()) {
                return;
            } else {
                ((E) arrayDeque.poll()).f2769b.c(null);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "onServiceConnected: " + componentName);
            }
            this.f2775f = false;
            if (iBinder instanceof D) {
                this.f2774e = (D) iBinder;
                a();
                return;
            }
            Log.e("FirebaseMessaging", "Invalid service connection: " + iBinder);
            while (true) {
                ArrayDeque arrayDeque = this.f2773d;
                if (arrayDeque.isEmpty()) {
                    return;
                } else {
                    ((E) arrayDeque.poll()).f2769b.c(null);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceDisconnected: " + componentName);
        }
        a();
    }
}
