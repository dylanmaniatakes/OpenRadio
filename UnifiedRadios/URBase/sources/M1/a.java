package M1;

import C.h;
import C0.A;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import q1.E;
import u1.AbstractC0908c;
import u1.AbstractC0909d;
import u1.C0906a;
import w1.C0931b;

/* loaded from: classes.dex */
public final class a {
    public static final long n = TimeUnit.DAYS.toMillis(366);

    /* renamed from: o, reason: collision with root package name */
    public static volatile ScheduledExecutorService f1710o = null;

    /* renamed from: p, reason: collision with root package name */
    public static final Object f1711p = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Object f1712a;

    /* renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f1713b;

    /* renamed from: c, reason: collision with root package name */
    public int f1714c;

    /* renamed from: d, reason: collision with root package name */
    public ScheduledFuture f1715d;

    /* renamed from: e, reason: collision with root package name */
    public long f1716e;

    /* renamed from: f, reason: collision with root package name */
    public final HashSet f1717f;
    public boolean g;
    public F1.a h;

    /* renamed from: i, reason: collision with root package name */
    public final C0906a f1718i;

    /* renamed from: j, reason: collision with root package name */
    public final String f1719j;

    /* renamed from: k, reason: collision with root package name */
    public final HashMap f1720k;

    /* renamed from: l, reason: collision with root package name */
    public final AtomicInteger f1721l;

    /* renamed from: m, reason: collision with root package name */
    public final ScheduledExecutorService f1722m;

    public a(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean zBooleanValue;
        String packageName = context.getPackageName();
        this.f1712a = new Object();
        this.f1714c = 0;
        this.f1717f = new HashSet();
        this.g = true;
        this.f1718i = C0906a.f9918a;
        this.f1720k = new HashMap();
        this.f1721l = new AtomicInteger(0);
        E.g("wake:com.google.firebase.iid.WakeLockHolder", "WakeLock: wakeLockName must not be empty");
        context.getApplicationContext();
        WorkSource workSource = null;
        this.h = null;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f1719j = "wake:com.google.firebase.iid.WakeLockHolder";
        } else {
            this.f1719j = "wake:com.google.firebase.iid.WakeLockHolder".length() != 0 ? "*gcore*:".concat("wake:com.google.firebase.iid.WakeLockHolder") : new String("*gcore*:");
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            StringBuilder sb = new StringBuilder(29);
            sb.append((CharSequence) "expected a non-null reference", 0, 29);
            throw new F1.b(sb.toString());
        }
        this.f1713b = powerManager.newWakeLock(1, "wake:com.google.firebase.iid.WakeLockHolder");
        Method method = AbstractC0909d.f9926a;
        synchronized (AbstractC0909d.class) {
            Boolean bool = AbstractC0909d.f9930e;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                zBooleanValue = h.a(context, "android.permission.UPDATE_DEVICE_STATS") == 0;
                AbstractC0909d.f9930e = Boolean.valueOf(zBooleanValue);
            }
        }
        if (zBooleanValue) {
            int i5 = AbstractC0908c.f9925a;
            packageName = packageName == null || packageName.trim().isEmpty() ? context.getPackageName() : packageName;
            if (context.getPackageManager() != null && packageName != null) {
                try {
                    ApplicationInfo applicationInfoA = C0931b.a(context).a(0, packageName);
                    if (applicationInfoA == null) {
                        Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(packageName));
                    } else {
                        int i6 = applicationInfoA.uid;
                        workSource = new WorkSource();
                        AbstractC0909d.a(workSource, i6, packageName);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    Log.e("WorkSourceUtil", "Could not find package: ".concat(packageName));
                }
            }
            if (workSource != null) {
                try {
                    this.f1713b.setWorkSource(workSource);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e5) {
                    Log.wtf("WakeLock", e5.toString());
                }
            }
        }
        ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = f1710o;
        if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
            synchronized (f1711p) {
                try {
                    scheduledExecutorServiceUnconfigurableScheduledExecutorService = f1710o;
                    if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
                        scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        f1710o = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
                    }
                } finally {
                }
            }
        }
        this.f1722m = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
    }

    public final void a(long j5) {
        this.f1721l.incrementAndGet();
        long jMax = Math.max(Math.min(Long.MAX_VALUE, n), 1L);
        if (j5 > 0) {
            jMax = Math.min(j5, jMax);
        }
        synchronized (this.f1712a) {
            try {
                if (!b()) {
                    this.h = F1.a.f536j;
                    this.f1713b.acquire();
                    this.f1718i.getClass();
                    SystemClock.elapsedRealtime();
                }
                this.f1714c++;
                if (this.g) {
                    TextUtils.isEmpty(null);
                }
                b bVar = (b) this.f1720k.get(null);
                if (bVar == null) {
                    bVar = new b();
                    this.f1720k.put(null, bVar);
                }
                bVar.f1723a++;
                this.f1718i.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j6 = Long.MAX_VALUE - jElapsedRealtime > jMax ? jElapsedRealtime + jMax : Long.MAX_VALUE;
                if (j6 > this.f1716e) {
                    this.f1716e = j6;
                    ScheduledFuture scheduledFuture = this.f1715d;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.f1715d = this.f1722m.schedule(new A(8, this), jMax, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b() {
        boolean z4;
        synchronized (this.f1712a) {
            z4 = this.f1714c > 0;
        }
        return z4;
    }

    public final void c() {
        if (this.f1721l.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f1719j).concat(" release without a matched acquire!"));
        }
        synchronized (this.f1712a) {
            try {
                if (this.g) {
                    TextUtils.isEmpty(null);
                }
                if (this.f1720k.containsKey(null)) {
                    b bVar = (b) this.f1720k.get(null);
                    if (bVar != null) {
                        int i5 = bVar.f1723a - 1;
                        bVar.f1723a = i5;
                        if (i5 == 0) {
                            this.f1720k.remove(null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.f1719j).concat(" counter does not exist"));
                }
                e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        HashSet hashSet = this.f1717f;
        if (hashSet.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        hashSet.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        com.unified.ur1.SatelliteTracker.h.p(arrayList.get(0));
        throw null;
    }

    public final void e() {
        synchronized (this.f1712a) {
            try {
                if (b()) {
                    if (this.g) {
                        int i5 = this.f1714c - 1;
                        this.f1714c = i5;
                        if (i5 > 0) {
                            return;
                        }
                    } else {
                        this.f1714c = 0;
                    }
                    d();
                    Iterator it = this.f1720k.values().iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).f1723a = 0;
                    }
                    this.f1720k.clear();
                    ScheduledFuture scheduledFuture = this.f1715d;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                        this.f1715d = null;
                        this.f1716e = 0L;
                    }
                    if (this.f1713b.isHeld()) {
                        try {
                            try {
                                this.f1713b.release();
                                if (this.h != null) {
                                    this.h = null;
                                }
                            } catch (RuntimeException e5) {
                                if (!e5.getClass().equals(RuntimeException.class)) {
                                    throw e5;
                                }
                                Log.e("WakeLock", String.valueOf(this.f1719j).concat(" failed to release!"), e5);
                                if (this.h != null) {
                                    this.h = null;
                                }
                            }
                        } catch (Throwable th) {
                            if (this.h != null) {
                                this.h = null;
                            }
                            throw th;
                        }
                    } else {
                        Log.e("WakeLock", String.valueOf(this.f1719j).concat(" should be held!"));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
