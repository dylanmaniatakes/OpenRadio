package q1;

import android.accounts.Account;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import j1.C0599a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import k3.RunnableC0691i0;
import n1.C0785b;
import n1.C0787d;
import n1.C0789f;

/* renamed from: q1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0854e {

    /* renamed from: x, reason: collision with root package name */
    public static final C0787d[] f9345x = new C0787d[0];

    /* renamed from: b, reason: collision with root package name */
    public C0599a f9347b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f9348c;

    /* renamed from: d, reason: collision with root package name */
    public final P f9349d;

    /* renamed from: e, reason: collision with root package name */
    public final C0789f f9350e;

    /* renamed from: f, reason: collision with root package name */
    public final G f9351f;

    /* renamed from: i, reason: collision with root package name */
    public C0848A f9352i;

    /* renamed from: j, reason: collision with root package name */
    public InterfaceC0853d f9353j;

    /* renamed from: k, reason: collision with root package name */
    public IInterface f9354k;

    /* renamed from: m, reason: collision with root package name */
    public I f9356m;

    /* renamed from: o, reason: collision with root package name */
    public final InterfaceC0851b f9357o;

    /* renamed from: p, reason: collision with root package name */
    public final InterfaceC0852c f9358p;

    /* renamed from: q, reason: collision with root package name */
    public final int f9359q;

    /* renamed from: r, reason: collision with root package name */
    public final String f9360r;

    /* renamed from: s, reason: collision with root package name */
    public volatile String f9361s;

    /* renamed from: a, reason: collision with root package name */
    public volatile String f9346a = null;
    public final Object g = new Object();
    public final Object h = new Object();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f9355l = new ArrayList();
    public int n = 1;

    /* renamed from: t, reason: collision with root package name */
    public C0785b f9362t = null;

    /* renamed from: u, reason: collision with root package name */
    public boolean f9363u = false;

    /* renamed from: v, reason: collision with root package name */
    public volatile L f9364v = null;

    /* renamed from: w, reason: collision with root package name */
    public final AtomicInteger f9365w = new AtomicInteger(0);

    public AbstractC0854e(Context context, Looper looper, P p4, C0789f c0789f, int i5, InterfaceC0851b interfaceC0851b, InterfaceC0852c interfaceC0852c, String str) {
        E.j(context, "Context must not be null");
        this.f9348c = context;
        E.j(looper, "Looper must not be null");
        E.j(p4, "Supervisor must not be null");
        this.f9349d = p4;
        E.j(c0789f, "API availability must not be null");
        this.f9350e = c0789f;
        this.f9351f = new G(this, looper);
        this.f9359q = i5;
        this.f9357o = interfaceC0851b;
        this.f9358p = interfaceC0852c;
        this.f9360r = str;
    }

    public static /* bridge */ /* synthetic */ boolean z(AbstractC0854e abstractC0854e, int i5, int i6, IInterface iInterface) {
        synchronized (abstractC0854e.g) {
            try {
                if (abstractC0854e.n != i5) {
                    return false;
                }
                abstractC0854e.A(i6, iInterface);
                return true;
            } finally {
            }
        }
    }

    public final void A(int i5, IInterface iInterface) {
        C0599a c0599a;
        E.a((i5 == 4) == (iInterface != null));
        synchronized (this.g) {
            try {
                this.n = i5;
                this.f9354k = iInterface;
                Bundle bundle = null;
                if (i5 == 1) {
                    I i6 = this.f9356m;
                    if (i6 != null) {
                        P p4 = this.f9349d;
                        String str = this.f9347b.f7564c;
                        E.i(str);
                        this.f9347b.getClass();
                        if (this.f9360r == null) {
                            this.f9348c.getClass();
                        }
                        p4.c(str, i6, this.f9347b.f7563b);
                        this.f9356m = null;
                    }
                } else if (i5 == 2 || i5 == 3) {
                    I i7 = this.f9356m;
                    if (i7 != null && (c0599a = this.f9347b) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + c0599a.f7564c + " on com.google.android.gms");
                        P p5 = this.f9349d;
                        String str2 = this.f9347b.f7564c;
                        E.i(str2);
                        this.f9347b.getClass();
                        if (this.f9360r == null) {
                            this.f9348c.getClass();
                        }
                        p5.c(str2, i7, this.f9347b.f7563b);
                        this.f9365w.incrementAndGet();
                    }
                    I i8 = new I(this, this.f9365w.get());
                    this.f9356m = i8;
                    String strV = v();
                    boolean zW = w();
                    this.f9347b = new C0599a(2, strV, zW);
                    if (zW && f() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f9347b.f7564c)));
                    }
                    P p6 = this.f9349d;
                    String str3 = this.f9347b.f7564c;
                    E.i(str3);
                    this.f9347b.getClass();
                    String name = this.f9360r;
                    if (name == null) {
                        name = this.f9348c.getClass().getName();
                    }
                    C0785b c0785bB = p6.b(new M(str3, this.f9347b.f7563b), i8, name, null);
                    if (c0785bB.f8728k != 0) {
                        Log.w("GmsClient", "unable to connect to service: " + this.f9347b.f7564c + " on com.google.android.gms");
                        int i9 = c0785bB.f8728k;
                        if (i9 == -1) {
                            i9 = 16;
                        }
                        if (c0785bB.f8729l != null) {
                            bundle = new Bundle();
                            bundle.putParcelable("pendingIntent", c0785bB.f8729l);
                        }
                        int i10 = this.f9365w.get();
                        K k5 = new K(this, i9, bundle);
                        G g = this.f9351f;
                        g.sendMessage(g.obtainMessage(7, i10, -1, k5));
                    }
                } else if (i5 == 4) {
                    E.i(iInterface);
                    System.currentTimeMillis();
                }
            } finally {
            }
        }
    }

    public final boolean a() {
        boolean z4;
        synchronized (this.g) {
            z4 = this.n == 4;
        }
        return z4;
    }

    public final void b(InterfaceC0853d interfaceC0853d) {
        this.f9353j = interfaceC0853d;
        A(2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(InterfaceC0859j interfaceC0859j, Set set) {
        Bundle bundleR = r();
        String str = Build.VERSION.SDK_INT < 31 ? this.f9361s : this.f9361s;
        int i5 = this.f9359q;
        int i6 = C0789f.f8739a;
        Scope[] scopeArr = C0857h.f9373x;
        Bundle bundle = new Bundle();
        C0787d[] c0787dArr = C0857h.f9374y;
        C0857h c0857h = new C0857h(6, i5, i6, null, null, scopeArr, bundle, null, c0787dArr, c0787dArr, true, 0, false, str);
        c0857h.f9378m = this.f9348c.getPackageName();
        c0857h.f9380p = bundleR;
        if (set != null) {
            c0857h.f9379o = (Scope[]) set.toArray(new Scope[0]);
        }
        if (m()) {
            Account accountP = p();
            if (accountP == null) {
                accountP = new Account("<<default account>>", "com.google");
            }
            c0857h.f9381q = accountP;
            if (interfaceC0859j != 0) {
                c0857h.n = ((A1.a) interfaceC0859j).f7d;
            }
        }
        c0857h.f9382r = f9345x;
        c0857h.f9383s = q();
        if (y()) {
            c0857h.f9386v = true;
        }
        try {
            synchronized (this.h) {
                try {
                    C0848A c0848a = this.f9352i;
                    if (c0848a != null) {
                        c0848a.a(new H(this, this.f9365w.get()), c0857h);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e5) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e5);
            int i7 = this.f9365w.get();
            G g = this.f9351f;
            g.sendMessage(g.obtainMessage(6, i7, 3));
        } catch (RemoteException e6) {
            e = e6;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i8 = this.f9365w.get();
            J j5 = new J(this, 8, null, null);
            G g5 = this.f9351f;
            g5.sendMessage(g5.obtainMessage(1, i8, -1, j5));
        } catch (SecurityException e7) {
            throw e7;
        } catch (RuntimeException e8) {
            e = e8;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i82 = this.f9365w.get();
            J j52 = new J(this, 8, null, null);
            G g52 = this.f9351f;
            g52.sendMessage(g52.obtainMessage(1, i82, -1, j52));
        }
    }

    public final void e(String str) {
        this.f9346a = str;
        l();
    }

    public abstract int f();

    public final boolean g() {
        boolean z4;
        synchronized (this.g) {
            int i5 = this.n;
            z4 = true;
            if (i5 != 2 && i5 != 3) {
                z4 = false;
            }
        }
        return z4;
    }

    public final C0787d[] h() {
        L l5 = this.f9364v;
        if (l5 == null) {
            return null;
        }
        return l5.f9321k;
    }

    public final void i() {
        if (!a() || this.f9347b == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
    }

    public final String j() {
        return this.f9346a;
    }

    public final void k(p1.s sVar) {
        ((p1.t) sVar.f9136c).f9146o.n.post(new RunnableC0691i0(9, sVar));
    }

    public final void l() {
        this.f9365w.incrementAndGet();
        synchronized (this.f9355l) {
            try {
                int size = this.f9355l.size();
                for (int i5 = 0; i5 < size; i5++) {
                    y yVar = (y) this.f9355l.get(i5);
                    synchronized (yVar) {
                        yVar.f9426a = null;
                    }
                }
                this.f9355l.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.h) {
            this.f9352i = null;
        }
        A(1, null);
    }

    public boolean m() {
        return false;
    }

    public final void n() {
        int iC = this.f9350e.c(this.f9348c, f());
        if (iC == 0) {
            b(new C0863n(this));
            return;
        }
        A(1, null);
        this.f9353j = new C0863n(this);
        int i5 = this.f9365w.get();
        G g = this.f9351f;
        g.sendMessage(g.obtainMessage(3, i5, iC, null));
    }

    public abstract IInterface o(IBinder iBinder);

    public Account p() {
        return null;
    }

    public C0787d[] q() {
        return f9345x;
    }

    public Bundle r() {
        return new Bundle();
    }

    public Set s() {
        return Collections.emptySet();
    }

    public final IInterface t() {
        IInterface iInterface;
        synchronized (this.g) {
            try {
                if (this.n == 5) {
                    throw new DeadObjectException();
                }
                if (!a()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                iInterface = this.f9354k;
                E.j(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public abstract String u();

    public abstract String v();

    public boolean w() {
        return f() >= 211700000;
    }

    public void x() {
        System.currentTimeMillis();
    }

    public boolean y() {
        return this instanceof D1.D;
    }
}
