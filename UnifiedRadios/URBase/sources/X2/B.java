package X2;

import android.content.Context;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

/* loaded from: classes.dex */
public final class B implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public static final Object f2757o = new Object();

    /* renamed from: p, reason: collision with root package name */
    public static Boolean f2758p;

    /* renamed from: q, reason: collision with root package name */
    public static Boolean f2759q;

    /* renamed from: j, reason: collision with root package name */
    public final Context f2760j;

    /* renamed from: k, reason: collision with root package name */
    public final V1.e f2761k;

    /* renamed from: l, reason: collision with root package name */
    public final PowerManager.WakeLock f2762l;

    /* renamed from: m, reason: collision with root package name */
    public final z f2763m;
    public final long n;

    public B(z zVar, Context context, V1.e eVar, long j5) {
        this.f2763m = zVar;
        this.f2760j = context;
        this.n = j5;
        this.f2761k = eVar;
        this.f2762l = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    public static boolean a(Context context) {
        boolean zBooleanValue;
        synchronized (f2757o) {
            try {
                Boolean bool = f2759q;
                Boolean boolValueOf = Boolean.valueOf(bool == null ? b(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
                f2759q = boolValueOf;
                zBooleanValue = boolValueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    public static boolean b(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z4 = context.checkCallingOrSelfPermission(str) == 0;
        if (!z4 && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return z4;
    }

    public static boolean c(Context context) {
        boolean zBooleanValue;
        synchronized (f2757o) {
            try {
                Boolean bool = f2758p;
                Boolean boolValueOf = Boolean.valueOf(bool == null ? b(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
                f2758p = boolValueOf;
                zBooleanValue = boolValueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean d() {
        /*
            r2 = this;
            monitor-enter(r2)
            android.content.Context r0 = r2.f2760j     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L12
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L12
            goto L15
        L12:
            r0 = move-exception
            goto L22
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L1f
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L1f
            r0 = 1
            goto L20
        L1f:
            r0 = 0
        L20:
            monitor-exit(r2)
            return r0
        L22:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: X2.B.d():boolean");
    }

    @Override // java.lang.Runnable
    public final void run() {
        z zVar = this.f2763m;
        Context context = this.f2760j;
        boolean zC = c(context);
        PowerManager.WakeLock wakeLock = this.f2762l;
        if (zC) {
            wakeLock.acquire(AbstractC0201e.f2793a);
        }
        try {
            try {
                synchronized (zVar) {
                    zVar.g = true;
                }
            } catch (IOException e5) {
                Log.e("FirebaseMessaging", "Failed to sync topics. Won't retry sync. " + e5.getMessage());
                synchronized (zVar) {
                    zVar.g = false;
                    if (!c(context)) {
                        return;
                    }
                }
            }
            if (!this.f2761k.d()) {
                synchronized (zVar) {
                    zVar.g = false;
                }
                if (c(context)) {
                    try {
                        wakeLock.release();
                        return;
                    } catch (RuntimeException unused) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        return;
                    }
                }
                return;
            }
            if (a(context) && !d()) {
                new A(this, this).a();
                if (c(context)) {
                    try {
                        wakeLock.release();
                        return;
                    } catch (RuntimeException unused2) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        return;
                    }
                }
                return;
            }
            if (zVar.d()) {
                synchronized (zVar) {
                    zVar.g = false;
                }
            } else {
                zVar.e(this.n);
            }
            if (!c(context)) {
                return;
            }
            try {
                wakeLock.release();
            } catch (RuntimeException unused3) {
                Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
            }
        } catch (Throwable th) {
            if (c(context)) {
                try {
                    wakeLock.release();
                } catch (RuntimeException unused4) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
            throw th;
        }
    }
}
