package n1;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import w1.C0931b;

/* renamed from: n1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0791h {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f8743b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f8744c = false;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f8746e = 0;

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f8742a = new AtomicBoolean();

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f8745d = new AtomicBoolean();

    public static boolean a(Context context) {
        try {
            if (!f8744c) {
                try {
                    PackageInfo packageInfoB = C0931b.a(context).b(64, "com.google.android.gms");
                    C0792i.a(context);
                    if (packageInfoB == null || C0792i.d(packageInfoB, false) || !C0792i.d(packageInfoB, true)) {
                        f8743b = false;
                    } else {
                        f8743b = true;
                    }
                    f8744c = true;
                } catch (PackageManager.NameNotFoundException e5) {
                    Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e5);
                    f8744c = true;
                }
            }
            return f8743b || !"user".equals(Build.TYPE);
        } catch (Throwable th) {
            f8744c = true;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0138  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int b(android.content.Context r9, int r10) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.AbstractC0791h.b(android.content.Context, int):int");
    }

    public static boolean c(Context context) {
        try {
            Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            while (it.hasNext()) {
                if ("com.google.android.gms".equals(it.next().getAppPackageName())) {
                    return true;
                }
            }
            return context.getPackageManager().getApplicationInfo("com.google.android.gms", 8192).enabled;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }
}
