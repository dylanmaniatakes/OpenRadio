package j0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import h1.C0559c;
import java.io.File;
import java.io.IOException;

/* renamed from: j0.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0598k {

    /* renamed from: a, reason: collision with root package name */
    public static final r.k f7556a = new r.k();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f7557b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static C0559c f7558c = null;

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? AbstractC0596i.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static C0559c b() {
        C0559c c0559c = new C0559c();
        f7558c = c0559c;
        f7556a.i(c0559c);
        return f7558c;
    }

    public static void c(Context context, boolean z4) {
        C0597j c0597jA;
        int i5;
        if (z4 || f7558c == null) {
            synchronized (f7557b) {
                if (!z4) {
                    try {
                        if (f7558c != null) {
                            return;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (Build.VERSION.SDK_INT == 30) {
                    b();
                    return;
                }
                File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                long length = file.length();
                int i6 = 0;
                boolean z5 = file.exists() && length > 0;
                File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                long length2 = file2.length();
                boolean z6 = file2.exists() && length2 > 0;
                try {
                    long jA = a(context);
                    File file3 = new File(context.getFilesDir(), "profileInstalled");
                    if (file3.exists()) {
                        try {
                            c0597jA = C0597j.a(file3);
                        } catch (IOException unused) {
                            b();
                            return;
                        }
                    } else {
                        c0597jA = null;
                    }
                    if (c0597jA != null && c0597jA.f7554c == jA && (i5 = c0597jA.f7553b) != 2) {
                        i6 = i5;
                    } else if (z5) {
                        i6 = 1;
                    } else if (z6) {
                        i6 = 2;
                    }
                    if (z4 && z6 && i6 != 1) {
                        i6 = 2;
                    }
                    C0597j c0597j = new C0597j(1, (c0597jA == null || c0597jA.f7553b != 2 || i6 != 1 || length >= c0597jA.f7555d) ? i6 : 3, jA, length2);
                    if (c0597jA == null || !c0597jA.equals(c0597j)) {
                        try {
                            c0597j.b(file3);
                        } catch (IOException unused2) {
                        }
                    }
                    b();
                } catch (PackageManager.NameNotFoundException unused3) {
                    b();
                }
            }
        }
    }
}
