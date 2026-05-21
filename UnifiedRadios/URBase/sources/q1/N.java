package q1;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;
import n1.C0785b;

/* loaded from: classes.dex */
public final class N implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f9328a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public int f9329b = 2;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9330c;

    /* renamed from: d, reason: collision with root package name */
    public IBinder f9331d;

    /* renamed from: e, reason: collision with root package name */
    public final M f9332e;

    /* renamed from: f, reason: collision with root package name */
    public ComponentName f9333f;
    public final /* synthetic */ P g;

    public N(P p4, M m5) {
        this.g = p4;
        this.f9332e = m5;
    }

    public static C0785b a(N n, String str, Executor executor) throws RemoteException {
        C0785b c0785b;
        try {
            Intent intentA = n.f9332e.a(n.g.f9338b);
            n.f9329b = 3;
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            if (Build.VERSION.SDK_INT >= 31) {
                StrictMode.setVmPolicy(u1.e.a(new StrictMode.VmPolicy.Builder(vmPolicy)).build());
            }
            try {
                P p4 = n.g;
                boolean zD = p4.f9340d.d(p4.f9338b, str, intentA, n, 4225, executor);
                n.f9330c = zD;
                if (zD) {
                    n.g.f9339c.sendMessageDelayed(n.g.f9339c.obtainMessage(1, n.f9332e), n.g.f9342f);
                    c0785b = C0785b.n;
                } else {
                    n.f9329b = 2;
                    try {
                        P p5 = n.g;
                        p5.f9340d.c(p5.f9338b, n);
                    } catch (IllegalArgumentException unused) {
                    }
                    c0785b = new C0785b(16);
                }
                return c0785b;
            } finally {
                StrictMode.setVmPolicy(vmPolicy);
            }
        } catch (F e5) {
            return e5.f9314j;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.g.f9337a) {
            try {
                this.g.f9339c.removeMessages(1, this.f9332e);
                this.f9331d = iBinder;
                this.f9333f = componentName;
                Iterator it = this.f9328a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f9329b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.g.f9337a) {
            try {
                this.g.f9339c.removeMessages(1, this.f9332e);
                this.f9331d = null;
                this.f9333f = componentName;
                Iterator it = this.f9328a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f9329b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
