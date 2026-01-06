package k3;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.primary.LaunchActivity;
import e1.RunnableC0438f;
import g0.AbstractC0535a;

/* loaded from: classes.dex */
public final class x0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8240j;

    public x0(LaunchActivity launchActivity) {
        this.f8240j = launchActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LaunchActivity launchActivity = this.f8240j;
        if (launchActivity.f5955q1) {
            if (launchActivity.f5945n0 == BitmapDescriptorFactory.HUE_RED) {
                launchActivity.V();
            }
            launchActivity.f5942m = Build.DEVICE;
            String str = Build.MANUFACTURER;
            if (str.toLowerCase().contains("alps") || str.toLowerCase().contains("Ulefone") || (launchActivity.f5942m.toLowerCase().contains("Armor") && !LaunchActivity.f5855F1)) {
                LaunchActivity.f5855F1 = true;
                h4.c.K(launchActivity, true);
            }
            String string = h4.c.C(LaunchActivity.f5853D1).getString("rf_version", "Unknown");
            Uri.Builder builderAppendQueryParameter = Uri.parse("https://ur1.unifiedradios.com/telemetry.php").buildUpon().appendQueryParameter("cloud_auth", LaunchActivity.I1);
            if (str.toLowerCase().contains("Ulefone") || launchActivity.f5942m.toLowerCase().contains("Armor") || LaunchActivity.f5855F1) {
                builderAppendQueryParameter.appendQueryParameter("device_manufacturer", "ComJoTRadios");
                builderAppendQueryParameter.appendQueryParameter("device_model", "CJ_26");
                LaunchActivity.f5855F1 = true;
                if (launchActivity.n.contains("E7S6TA7")) {
                    builderAppendQueryParameter.appendQueryParameter("device_manufacturer", "ComJoTRadios");
                    builderAppendQueryParameter.appendQueryParameter("device_model", "CJ_26");
                }
            } else {
                builderAppendQueryParameter.appendQueryParameter("device_manufacturer", str);
                String str2 = Build.MODEL;
                if (str2 == null) {
                    str2 = "Unknown";
                }
                builderAppendQueryParameter.appendQueryParameter("device_model", str2);
                String str3 = Build.DISPLAY;
                if (str3 == null) {
                    str3 = "Unknown";
                }
                builderAppendQueryParameter.appendQueryParameter("rom_version", str3);
                if (string == null || string.isEmpty()) {
                    string = "Unknown";
                }
                builderAppendQueryParameter.appendQueryParameter("rf_version", string);
            }
            String str4 = Build.VERSION.RELEASE;
            builderAppendQueryParameter.appendQueryParameter("os_version", str4 != null ? str4 : "Unknown");
            String string2 = Settings.Secure.getString(launchActivity.getContentResolver(), "android_id");
            if (string2 != null && !string2.isEmpty()) {
                builderAppendQueryParameter.appendQueryParameter("os_uid", string2);
            }
            builderAppendQueryParameter.appendQueryParameter("app_version", "0.0.8-beta.13");
            float f5 = launchActivity.f5945n0;
            if (f5 != BitmapDescriptorFactory.HUE_RED || launchActivity.f5948o0 != BitmapDescriptorFactory.HUE_RED) {
                builderAppendQueryParameter.appendQueryParameter("lat", String.valueOf(f5));
                builderAppendQueryParameter.appendQueryParameter("lng", String.valueOf(launchActivity.f5948o0));
            }
            SharedPreferences sharedPreferences = launchActivity.getSharedPreferences("app_settings", 0);
            boolean z4 = sharedPreferences.getBoolean("telemetry_first_call", true);
            boolean z5 = launchActivity.f5884L == 1;
            if (z5 != sharedPreferences.getBoolean("last_tx_full", false) || z4) {
                sharedPreferences.edit().putBoolean("last_tx_full", z5).apply();
            }
            boolean z6 = launchActivity.f5882K == 1;
            if (z6 != sharedPreferences.getBoolean("last_tx_disable", false) || z4) {
                sharedPreferences.edit().putBoolean("last_tx_disable", z6).apply();
            }
            int i5 = h4.c.C(launchActivity).getInt("metricEnable", 0);
            boolean z7 = i5 == 1;
            if (z7 != sharedPreferences.getBoolean("last_metric", false) || z4) {
                builderAppendQueryParameter.appendQueryParameter("metric", z7 ? "1" : "0");
                sharedPreferences.edit().putBoolean("last_metric", z7).apply();
            }
            if (z4) {
                sharedPreferences.edit().putBoolean("telemetry_first_call", false).apply();
            }
            String string3 = builderAppendQueryParameter.build().toString();
            if (launchActivity.f5900U.equals("N4KYS")) {
                AbstractC0535a.v("Update URL: ", string3, "Unified - Main Activity");
            }
            new Thread(new RunnableC0438f(this, string3, sharedPreferences, i5)).start();
        }
    }
}
