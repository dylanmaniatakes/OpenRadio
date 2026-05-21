package X2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import i0.ExecutorC0566c;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import v1.ThreadFactoryC0920a;

/* loaded from: classes.dex */
public abstract class g extends Service {

    /* renamed from: c, reason: collision with root package name */
    public final ExecutorService f2797c;

    /* renamed from: d, reason: collision with root package name */
    public D f2798d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f2799e;

    /* renamed from: f, reason: collision with root package name */
    public int f2800f;
    public int g;

    public g() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0920a("Firebase-Messaging-Intent-Handle"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f2797c = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.f2799e = new Object();
        this.g = 0;
    }

    public final void a(Intent intent) {
        if (intent != null) {
            C.b(intent);
        }
        synchronized (this.f2799e) {
            try {
                int i5 = this.g - 1;
                this.g = i5;
                if (i5 == 0) {
                    stopSelfResult(this.f2800f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void b(Intent intent);

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "Service received bind request");
            }
            if (this.f2798d == null) {
                this.f2798d = new D(new Z2.c(12, this));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f2798d;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f2797c.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i5, int i6) {
        synchronized (this.f2799e) {
            this.f2800f = i6;
            this.g++;
        }
        Intent intent2 = (Intent) ((ArrayDeque) t.c().f2836f).poll();
        if (intent2 == null) {
            a(intent);
            return 2;
        }
        N1.k kVar = new N1.k();
        this.f2797c.execute(new D0.f(this, intent2, kVar, 1));
        N1.r rVar = kVar.f1789a;
        if (rVar.e()) {
            a(intent);
            return 2;
        }
        rVar.h(new ExecutorC0566c(0), new C0202f(this, 0, intent));
        return 3;
    }
}
