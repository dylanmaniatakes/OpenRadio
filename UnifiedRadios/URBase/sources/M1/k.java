package m1;

import N1.p;
import X2.s;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import t1.C0902a;

/* loaded from: classes.dex */
public final class k implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public int f8533a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Messenger f8534b;

    /* renamed from: c, reason: collision with root package name */
    public L0.c f8535c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f8536d;

    /* renamed from: e, reason: collision with root package name */
    public final SparseArray f8537e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ m f8538f;

    public k(m mVar) {
        this.f8538f = mVar;
        A1.f fVar = new A1.f(Looper.getMainLooper(), new j(0, this));
        Looper.getMainLooper();
        this.f8534b = new Messenger(fVar);
        this.f8536d = new ArrayDeque();
        this.f8537e = new SparseArray();
    }

    public final synchronized void a(int i5, String str) {
        b(str, null);
    }

    public final synchronized void b(String str, SecurityException securityException) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Disconnected: ".concat(String.valueOf(str)));
            }
            int i5 = this.f8533a;
            if (i5 == 0) {
                throw new IllegalStateException();
            }
            if (i5 != 1 && i5 != 2) {
                if (i5 != 3) {
                    return;
                }
                this.f8533a = 4;
                return;
            }
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.f8533a = 4;
            C0902a.b().c((Context) this.f8538f.f8545d, this);
            s sVar = new s(str, securityException);
            Iterator it = this.f8536d.iterator();
            while (it.hasNext()) {
                ((l) it.next()).c(sVar);
            }
            this.f8536d.clear();
            for (int i6 = 0; i6 < this.f8537e.size(); i6++) {
                ((l) this.f8537e.valueAt(i6)).c(sVar);
            }
            this.f8537e.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c() {
        try {
            if (this.f8533a == 2 && this.f8536d.isEmpty() && this.f8537e.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.f8533a = 3;
                C0902a.b().c((Context) this.f8538f.f8545d, this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean d(l lVar) {
        int i5 = this.f8533a;
        if (i5 != 0) {
            if (i5 == 1) {
                this.f8536d.add(lVar);
                return true;
            }
            if (i5 != 2) {
                return false;
            }
            this.f8536d.add(lVar);
            ((ScheduledExecutorService) this.f8538f.f8546e).execute(new i(this, 0));
            return true;
        }
        this.f8536d.add(lVar);
        if (this.f8533a != 0) {
            throw new IllegalStateException();
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Starting bind to GmsCore");
        }
        this.f8533a = 1;
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        try {
            if (C0902a.b().a((Context) this.f8538f.f8545d, intent, this, 1)) {
                ((ScheduledExecutorService) this.f8538f.f8546e).schedule(new i(this, 1), 30L, TimeUnit.SECONDS);
            } else {
                a(0, "Unable to bind to service");
            }
        } catch (SecurityException e5) {
            b("Unable to bind to service", e5);
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        ((ScheduledExecutorService) this.f8538f.f8546e).execute(new p(7, this, iBinder, false));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        ((ScheduledExecutorService) this.f8538f.f8546e).execute(new i(this, 2));
    }
}
