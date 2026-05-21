package V1;

import A2.g;
import A2.j;
import O.F0;
import O.s0;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import android.view.View;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public int f2529a;

    /* renamed from: b, reason: collision with root package name */
    public int f2530b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2531c;

    /* renamed from: d, reason: collision with root package name */
    public Object f2532d;

    /* renamed from: e, reason: collision with root package name */
    public Serializable f2533e;

    public static String b(g gVar) {
        gVar.a();
        j jVar = gVar.f28c;
        String str = jVar.f42e;
        if (str != null) {
            return str;
        }
        gVar.a();
        String str2 = jVar.f39b;
        if (!str2.startsWith("1:")) {
            return str2;
        }
        String[] strArrSplit = str2.split(":");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    public synchronized String a() {
        try {
            if (((String) this.f2532d) == null) {
                f();
            }
        } catch (Throwable th) {
            throw th;
        }
        return (String) this.f2532d;
    }

    public PackageInfo c(String str) {
        try {
            return ((Context) this.f2531c).getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e5) {
            Log.w("FirebaseMessaging", "Failed to find package " + e5);
            return null;
        }
    }

    public boolean d() {
        int i5;
        synchronized (this) {
            i5 = this.f2530b;
            if (i5 == 0) {
                PackageManager packageManager = ((Context) this.f2531c).getPackageManager();
                if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
                    Log.e("FirebaseMessaging", "Google Play services missing or without correct permission.");
                    i5 = 0;
                } else {
                    Intent intent = new Intent("com.google.iid.TOKEN_REQUEST");
                    intent.setPackage("com.google.android.gms");
                    List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
                    if (listQueryBroadcastReceivers == null || listQueryBroadcastReceivers.size() <= 0) {
                        Log.w("FirebaseMessaging", "Failed to resolve IID implementation package, falling back");
                        this.f2530b = 2;
                    } else {
                        this.f2530b = 2;
                    }
                    i5 = 2;
                }
            }
        }
        return i5 != 0;
    }

    public void e(F0 f02, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if ((((s0) it.next()).f1965a.c() & 8) != 0) {
                ((View) this.f2532d).setTranslationY(P1.a.c(r3.f1965a.b(), this.f2530b, 0));
                return;
            }
        }
    }

    public synchronized void f() {
        PackageInfo packageInfoC = c(((Context) this.f2531c).getPackageName());
        if (packageInfoC != null) {
            this.f2532d = Integer.toString(packageInfoC.versionCode);
            this.f2533e = packageInfoC.versionName;
        }
    }
}
