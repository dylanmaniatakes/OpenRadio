package n1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import q1.E;

/* renamed from: n1.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0792i {

    /* renamed from: c, reason: collision with root package name */
    public static C0792i f8747c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f8748a;

    /* renamed from: b, reason: collision with root package name */
    public volatile String f8749b;

    public C0792i(Context context) {
        this.f8748a = context.getApplicationContext();
    }

    public static C0792i a(Context context) {
        E.i(context);
        synchronized (C0792i.class) {
            try {
                if (f8747c == null) {
                    BinderC0796m binderC0796m = AbstractC0800q.f8763a;
                    synchronized (AbstractC0800q.class) {
                        if (AbstractC0800q.f8767e == null) {
                            AbstractC0800q.f8767e = context.getApplicationContext();
                        } else {
                            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
                        }
                    }
                    f8747c = new C0792i(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f8747c;
    }

    public static final AbstractBinderC0797n c(PackageInfo packageInfo, AbstractBinderC0797n... abstractBinderC0797nArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            BinderC0798o binderC0798o = new BinderC0798o(packageInfo.signatures[0].toByteArray());
            for (int i5 = 0; i5 < abstractBinderC0797nArr.length; i5++) {
                if (abstractBinderC0797nArr[i5].equals(binderC0798o)) {
                    return abstractBinderC0797nArr[i5];
                }
            }
        }
        return null;
    }

    public static final boolean d(PackageInfo packageInfo, boolean z4) {
        PackageInfo packageInfo2;
        if (!z4) {
            packageInfo2 = packageInfo;
        } else if (packageInfo != null) {
            if ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName)) {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                z4 = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
            }
            packageInfo2 = packageInfo;
        } else {
            packageInfo2 = null;
        }
        if (packageInfo != null && packageInfo2.signatures != null) {
            if ((z4 ? c(packageInfo2, AbstractC0799p.f8762a) : c(packageInfo2, AbstractC0799p.f8762a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x01a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int r18) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 519
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n1.C0792i.b(int):boolean");
    }
}
