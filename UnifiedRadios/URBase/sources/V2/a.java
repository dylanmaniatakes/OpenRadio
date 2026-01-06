package V2;

import C.e;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2534a;

    public a(Context context, String str) {
        boolean z4;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Context contextA = e.a(context);
        SharedPreferences sharedPreferences = contextA.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        boolean z5 = true;
        if (sharedPreferences.contains("firebase_data_collection_default_enabled")) {
            z4 = sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true);
        } else {
            try {
                PackageManager packageManager = contextA.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(contextA.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_data_collection_default_enabled")) {
                    z5 = applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            z4 = z5;
        }
        this.f2534a = z4;
    }
}
