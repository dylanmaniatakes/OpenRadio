package q1;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.util.HashMap;
import java.util.concurrent.Executor;
import n1.C0785b;
import t1.C0902a;

/* loaded from: classes.dex */
public final class P {
    public static final Object h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public static P f9335i;

    /* renamed from: j, reason: collision with root package name */
    public static HandlerThread f9336j;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f9337a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Context f9338b;

    /* renamed from: c, reason: collision with root package name */
    public volatile A1.f f9339c;

    /* renamed from: d, reason: collision with root package name */
    public final C0902a f9340d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9341e;

    /* renamed from: f, reason: collision with root package name */
    public final long f9342f;
    public volatile Executor g;

    public P(Context context, Looper looper) {
        O o5 = new O(this);
        this.f9338b = context.getApplicationContext();
        A1.f fVar = new A1.f(looper, o5);
        Looper.getMainLooper();
        this.f9339c = fVar;
        this.f9340d = C0902a.b();
        this.f9341e = DeviceOrientationRequest.OUTPUT_PERIOD_FAST;
        this.f9342f = 300000L;
        this.g = null;
    }

    public static P a(Context context) {
        synchronized (h) {
            try {
                if (f9335i == null) {
                    f9335i = new P(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f9335i;
    }

    public final C0785b b(M m5, I i5, String str, Executor executor) {
        C0785b c0785bA;
        synchronized (this.f9337a) {
            try {
                N n = (N) this.f9337a.get(m5);
                if (executor == null) {
                    executor = this.g;
                }
                if (n == null) {
                    n = new N(this, m5);
                    n.f9328a.put(i5, i5);
                    c0785bA = N.a(n, str, executor);
                    this.f9337a.put(m5, n);
                } else {
                    this.f9339c.removeMessages(0, m5);
                    if (n.f9328a.containsKey(i5)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=".concat(m5.toString()));
                    }
                    n.f9328a.put(i5, i5);
                    int i6 = n.f9329b;
                    if (i6 == 1) {
                        i5.onServiceConnected(n.f9333f, n.f9331d);
                    } else if (i6 == 2) {
                        c0785bA = N.a(n, str, executor);
                    }
                    c0785bA = null;
                }
                if (n.f9330c) {
                    return C0785b.n;
                }
                if (c0785bA == null) {
                    c0785bA = new C0785b(-1);
                }
                return c0785bA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(String str, ServiceConnection serviceConnection, boolean z4) {
        M m5 = new M(str, z4);
        E.j(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f9337a) {
            try {
                N n = (N) this.f9337a.get(m5);
                if (n == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: ".concat(m5.toString()));
                }
                if (!n.f9328a.containsKey(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=".concat(m5.toString()));
                }
                n.f9328a.remove(serviceConnection);
                if (n.f9328a.isEmpty()) {
                    this.f9339c.sendMessageDelayed(this.f9339c.obtainMessage(0, m5), this.f9341e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
