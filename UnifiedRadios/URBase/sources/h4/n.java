package h4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final ConnectivityManager f7111a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7112b = "Android-x86".equalsIgnoreCase(Build.BRAND);

    /* renamed from: c, reason: collision with root package name */
    public final boolean f7113c;

    public n(Context context) {
        this.f7111a = (ConnectivityManager) context.getSystemService("connectivity");
        this.f7113c = context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0;
    }

    public final boolean a() {
        if (!this.f7113c) {
            return true;
        }
        NetworkInfo activeNetworkInfo = this.f7111a.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        if (activeNetworkInfo.isConnected()) {
            return true;
        }
        return this.f7112b && activeNetworkInfo.getType() == 9;
    }
}
