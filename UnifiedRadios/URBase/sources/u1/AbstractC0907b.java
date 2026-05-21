package u1;

import J1.B1;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import n1.AbstractC0791h;
import n1.C0792i;
import w1.C0931b;

/* renamed from: u1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0907b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f9919a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f9920b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f9921c;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f9922d;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f9923e;

    /* renamed from: f, reason: collision with root package name */
    public static Boolean f9924f;
    public static String g;
    public static Boolean h;

    public static boolean a(Context context, int i5) throws PackageManager.NameNotFoundException {
        if (c(i5, context, "com.google.android.gms")) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 64);
                C0792i c0792iA = C0792i.a(context);
                c0792iA.getClass();
                if (packageInfo == null) {
                    return false;
                }
                if (!C0792i.d(packageInfo, false)) {
                    if (!C0792i.d(packageInfo, true)) {
                        return false;
                    }
                    if (!AbstractC0791h.a(c0792iA.f8748a)) {
                        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
                        return false;
                    }
                }
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                if (Log.isLoggable("UidVerifier", 3)) {
                    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
                }
            }
        }
        return false;
    }

    public static boolean b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f9921c == null) {
            f9921c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        f9921c.booleanValue();
        if (f9922d == null) {
            f9922d = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f9922d.booleanValue() && Build.VERSION.SDK_INT >= 30;
    }

    public static boolean c(int i5, Context context, String str) {
        B1 b1A = C0931b.a(context);
        b1A.getClass();
        try {
            AppOpsManager appOpsManager = (AppOpsManager) b1A.f707a.getSystemService("appops");
            if (appOpsManager == null) {
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            appOpsManager.checkPackage(i5, str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
