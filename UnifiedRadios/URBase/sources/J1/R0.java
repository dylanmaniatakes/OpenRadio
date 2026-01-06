package J1;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessaging;
import com.unified.ur1.primary.LaunchActivity;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import v1.ThreadFactoryC0920a;

/* loaded from: classes.dex */
public final /* synthetic */ class R0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f936j;

    /* renamed from: k, reason: collision with root package name */
    public final long f937k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f938l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f939m;

    public /* synthetic */ R0(C0058c1 c0058c1, Bundle bundle, long j5) {
        this.f936j = 0;
        this.f938l = c0058c1;
        this.f939m = bundle;
        this.f937k = j5;
    }

    public boolean a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ((FirebaseMessaging) this.f939m).f5544b.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean b() throws IOException {
        try {
            if (((FirebaseMessaging) this.f939m).a() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            if (!Log.isLoggable("FirebaseMessaging", 3)) {
                return true;
            }
            Log.d("FirebaseMessaging", "Token successfully retrieved");
            return true;
        } catch (IOException e5) {
            String message = e5.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                if (e5.getMessage() != null) {
                    throw e5;
                }
                Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            Log.w("FirebaseMessaging", "Token retrieval failed: " + e5.getMessage() + ". Will retry token retrieval");
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0118  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 802
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.R0.run():void");
    }

    public /* synthetic */ R0(Object obj, Object obj2, long j5, int i5) {
        this.f936j = i5;
        this.f938l = obj2;
        this.f937k = j5;
        this.f939m = obj;
    }

    public R0(FirebaseMessaging firebaseMessaging, long j5) {
        this.f936j = 3;
        new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0920a("firebase-iid-executor"));
        this.f939m = firebaseMessaging;
        this.f937k = j5;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) firebaseMessaging.f5544b.getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f938l = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    public R0(LaunchActivity launchActivity, long j5, Handler handler) {
        this.f936j = 4;
        this.f939m = launchActivity;
        this.f937k = j5;
        this.f938l = handler;
    }
}
