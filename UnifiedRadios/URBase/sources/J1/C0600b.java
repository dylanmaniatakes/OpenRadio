package j1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import h4.p;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import n1.C0789f;
import n1.C0790g;
import n1.ServiceConnectionC0784a;
import q1.E;
import t1.C0902a;
import z1.AbstractBinderC0997c;
import z1.AbstractC0995a;
import z1.C0996b;
import z1.InterfaceC0998d;

/* renamed from: j1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0600b {

    /* renamed from: a, reason: collision with root package name */
    public ServiceConnectionC0784a f7565a;

    /* renamed from: b, reason: collision with root package name */
    public InterfaceC0998d f7566b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7567c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f7568d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public C0601c f7569e;

    /* renamed from: f, reason: collision with root package name */
    public final Context f7570f;
    public final long g;

    public C0600b(Context context) {
        E.i(context);
        Context applicationContext = context.getApplicationContext();
        this.f7570f = applicationContext != null ? applicationContext : context;
        this.f7567c = false;
        this.g = -1L;
    }

    public static C0599a a(Context context) {
        C0600b c0600b = new C0600b(context);
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            c0600b.c();
            C0599a c0599aE = c0600b.e();
            d(c0599aE, SystemClock.elapsedRealtime() - jElapsedRealtime, null);
            return c0599aE;
        } finally {
        }
    }

    public static void d(C0599a c0599a, long j5, Throwable th) {
        if (Math.random() <= 0.0d) {
            HashMap map = new HashMap();
            map.put("app_context", "1");
            if (c0599a != null) {
                map.put("limit_ad_tracking", true != c0599a.f7563b ? "0" : "1");
                String str = c0599a.f7564c;
                if (str != null) {
                    map.put("ad_id_size", Integer.toString(str.length()));
                }
            }
            if (th != null) {
                map.put("error", th.getClass().getName());
            }
            map.put("tag", "AdvertisingIdClient");
            map.put("time_spent", Long.toString(j5));
            new p(1, map).start();
        }
    }

    public final void b() {
        E.h("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f7570f == null || this.f7565a == null) {
                    return;
                }
                try {
                    if (this.f7567c) {
                        C0902a.b().c(this.f7570f, this.f7565a);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.f7567c = false;
                this.f7566b = null;
                this.f7565a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c() {
        E.h("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f7567c) {
                    b();
                }
                Context context = this.f7570f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iC = C0789f.f8740b.c(context, 12451000);
                    if (iC != 0 && iC != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    ServiceConnectionC0784a serviceConnectionC0784a = new ServiceConnectionC0784a();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!C0902a.b().a(context, intent, serviceConnectionC0784a, 1)) {
                            throw new IOException("Connection failure");
                        }
                        this.f7565a = serviceConnectionC0784a;
                        try {
                            IBinder iBinderA = serviceConnectionC0784a.a(TimeUnit.MILLISECONDS);
                            int i5 = AbstractBinderC0997c.f10548c;
                            IInterface iInterfaceQueryLocalInterface = iBinderA.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                            this.f7566b = iInterfaceQueryLocalInterface instanceof InterfaceC0998d ? (InterfaceC0998d) iInterfaceQueryLocalInterface : new C0996b(iBinderA);
                            this.f7567c = true;
                        } catch (InterruptedException unused) {
                            throw new IOException("Interrupted exception");
                        } catch (Throwable th) {
                            throw new IOException(th);
                        }
                    } finally {
                        IOException iOException = new IOException(th);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new C0790g(9);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final C0599a e() {
        C0599a c0599a;
        E.h("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.f7567c) {
                    synchronized (this.f7568d) {
                        C0601c c0601c = this.f7569e;
                        if (c0601c == null || !c0601c.f7574m) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        c();
                        if (!this.f7567c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e5) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e5);
                    }
                }
                E.i(this.f7565a);
                E.i(this.f7566b);
                try {
                    C0996b c0996b = (C0996b) this.f7566b;
                    c0996b.getClass();
                    Parcel parcelObtain = Parcel.obtain();
                    parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    boolean z4 = true;
                    Parcel parcelA = c0996b.a(1, parcelObtain);
                    String string = parcelA.readString();
                    parcelA.recycle();
                    C0996b c0996b2 = (C0996b) this.f7566b;
                    c0996b2.getClass();
                    Parcel parcelObtain2 = Parcel.obtain();
                    parcelObtain2.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    int i5 = AbstractC0995a.f10546a;
                    parcelObtain2.writeInt(1);
                    Parcel parcelA2 = c0996b2.a(2, parcelObtain2);
                    if (parcelA2.readInt() == 0) {
                        z4 = false;
                    }
                    parcelA2.recycle();
                    c0599a = new C0599a(0, string, z4);
                } catch (RemoteException e6) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e6);
                    throw new IOException("Remote exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f();
        return c0599a;
    }

    public final void f() {
        synchronized (this.f7568d) {
            C0601c c0601c = this.f7569e;
            if (c0601c != null) {
                c0601c.f7573l.countDown();
                try {
                    this.f7569e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j5 = this.g;
            if (j5 > 0) {
                this.f7569e = new C0601c(this, j5);
            }
        }
    }

    public final void finalize() throws Throwable {
        b();
        super.finalize();
    }
}
