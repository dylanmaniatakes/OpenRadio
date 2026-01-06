package com.unified.ur1.primary;

import B.e;
import C.h;
import C0.A;
import J1.RunnableC0115w;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import com.google.android.material.datepicker.j;
import com.google.android.material.snackbar.SnackbarContentLayout;
import com.unified.ur1.R;
import com.unified.ur1.adapters.LocationDisplayActivity;
import f.AbstractActivityC0472i;
import f.C0467d;
import h4.c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k3.AsyncTaskC0674a;
import k3.AsyncTaskC0678c;
import k3.C0676b;
import k3.RunnableC0682e;
import q2.k;

/* loaded from: classes.dex */
public class AppSettings extends AbstractActivityC0472i {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f5842e = 0;

    /* renamed from: c, reason: collision with root package name */
    public ThreadPoolExecutor f5843c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f5844d = "unknown";

    public static void j(AppSettings appSettings) {
        appSettings.getClass();
        Log.i("Unified - Settings", "Validation started: ");
        String string = appSettings.getSharedPreferences("app_settings", 0).getString("auth_code_1", null);
        if (string == null) {
            appSettings.o("Authorization code not found");
            return;
        }
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        String str3 = Build.VERSION.RELEASE;
        String string2 = Settings.Secure.getString(appSettings.getContentResolver(), "android_id");
        LocationManager locationManager = (LocationManager) appSettings.getSystemService("location");
        if (h.a(appSettings, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            e.d(appSettings, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1001);
            return;
        }
        Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
        if (lastKnownLocation == null) {
            lastKnownLocation = new Location("dummy");
            lastKnownLocation.setLatitude(0.0d);
            lastKnownLocation.setLongitude(0.0d);
        }
        boolean z4 = appSettings.getSharedPreferences("app_settings", 0).getBoolean("CJ_26_enabled", false);
        Uri.Builder builderBuildUpon = Uri.parse("https://ur1.unifiedradios.com/telemetry.php").buildUpon();
        if (z4) {
            builderBuildUpon.appendQueryParameter("cloud_auth", string).appendQueryParameter("device_manufacturer", "ComJoTRadios").appendQueryParameter("device_model", "CJ_26").appendQueryParameter("os_version", str3).appendQueryParameter("os_uid", string2).appendQueryParameter("app_version", "1").appendQueryParameter("lat", String.valueOf(lastKnownLocation.getLatitude())).appendQueryParameter("lng", String.valueOf(lastKnownLocation.getLongitude()));
        } else {
            builderBuildUpon.appendQueryParameter("cloud_auth", string).appendQueryParameter("device_manufacturer", str).appendQueryParameter("device_model", str2).appendQueryParameter("os_version", str3).appendQueryParameter("os_uid", string2).appendQueryParameter("app_version", "1").appendQueryParameter("lat", String.valueOf(lastKnownLocation.getLatitude())).appendQueryParameter("lng", String.valueOf(lastKnownLocation.getLongitude()));
        }
        new AsyncTaskC0678c(appSettings, 0).execute(builderBuildUpon.build().toString());
    }

    public void closedCaptionsButtonClicked(View view) {
        try {
            startActivity(new Intent("com.android.settings.action.live_caption"));
        } catch (ActivityNotFoundException unused) {
            k kVarG = k.g(null, findViewById(R.id.settingsTopLevelView), "This phone model doesn't support closed captions", 0);
            kVarG.h(Color.rgb(140, 20, 0));
            q2.h hVar = kVarG.f9462i;
            ((SnackbarContentLayout) hVar.getChildAt(0)).getActionView().setTextColor(-1);
            kVarG.i(-1);
            ((TextView) hVar.findViewById(R.id.snackbar_action)).setTextSize(20.0f);
            ((TextView) hVar.findViewById(R.id.snackbar_text)).setTextSize(20.0f);
            kVarG.j();
        }
    }

    public void doneButtonClicked(View view) {
        Switch r6 = (Switch) findViewById(R.id.MarsSwitch);
        Switch r02 = (Switch) findViewById(R.id.DisablePTT);
        Switch r12 = (Switch) findViewById(R.id.metricEnable);
        String string = getSharedPreferences("app_settings", 0).getString("auth_code_1", null);
        String str = r6.isChecked() ? "On" : "Off";
        String str2 = r02.isChecked() ? "On" : "Off";
        new AsyncTaskC0674a(str, str2, r12.isChecked() ? "On" : "Off").execute("https://ur1.unifiedradios.com/telemetry.php?cloud_auth=" + string + "&tx_disable=" + str + "&metric=" + str2);
        setResult(-1, getIntent());
        finish();
    }

    public final void k(String str, String str2, String str3) {
        Switch r02 = (Switch) findViewById(R.id.DisablePTT);
        Switch r12 = (Switch) findViewById(R.id.MarsSwitch);
        Switch r22 = (Switch) findViewById(R.id.metricEnable);
        r02.setChecked(false);
        r12.setChecked(false);
        r22.setChecked(false);
        if ("On".equals(str)) {
            r02.setChecked(true);
            ThreadPoolExecutor threadPoolExecutor = this.f5843c;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.execute(new RunnableC0682e(0, true));
            }
            c.V(this, String.valueOf(1));
            Log.i("Unified - Settings", "TX disabled based on fresh server data");
        }
        if ("On".equals(str2)) {
            r12.setChecked(true);
            n(true);
            c.d0(this, String.valueOf(1));
            Log.i("Unified - Settings", "MARS enabled based on fresh server data");
        }
        if ("On".equals(str3)) {
            r22.setChecked(true);
            ThreadPoolExecutor threadPoolExecutor2 = this.f5843c;
            if (threadPoolExecutor2 != null) {
                threadPoolExecutor2.execute(new RunnableC0682e(2, true));
            }
            c.e0(this, 1);
            Log.i("Unified - Settings", "Metric enabled based on fresh server data");
        }
    }

    public final void l() {
        ((Switch) findViewById(R.id.HidePTTSwitch)).setOnCheckedChangeListener(new C0676b(this, 0));
        ((Switch) findViewById(R.id.MarsSwitch)).setOnCheckedChangeListener(new C0676b(this, 1));
        ((Switch) findViewById(R.id.DisablePTT)).setOnCheckedChangeListener(new C0676b(this, 2));
        ((Switch) findViewById(R.id.DisRXEnable)).setOnCheckedChangeListener(new C0676b(this, 3));
        ((Switch) findViewById(R.id.metricEnable)).setOnCheckedChangeListener(new C0676b(this, 4));
    }

    public void locationClicked(View view) {
        startActivity(new Intent(this, (Class<?>) LocationDisplayActivity.class));
    }

    public final void m() {
        Log.d("Unified - Settings", "Loading cached server settings (no fresh data available)");
        SharedPreferences sharedPreferences = getSharedPreferences("server_settings", 0);
        long j5 = sharedPreferences.getLong("last_server_update", 0L);
        if (j5 > 0) {
            Log.d("Unified - Settings", "Using cached data from " + ((System.currentTimeMillis() - j5) / 60000) + " minutes ago");
        }
        k(sharedPreferences.getString("cached_tx_disable", "Off"), sharedPreferences.getString("cached_tx_full", "Off"), sharedPreferences.getString("cached_metric", "Off"));
    }

    public final void n(boolean z4) {
        ThreadPoolExecutor threadPoolExecutor = this.f5843c;
        if (threadPoolExecutor == null) {
            return;
        }
        threadPoolExecutor.execute(new RunnableC0682e(3, z4));
    }

    public final void o(String str) {
        L.h hVar = new L.h(this, R.style.Base_Theme_Material3_Dark_Dialog);
        C0467d c0467d = (C0467d) hVar.f1522d;
        c0467d.f6292d = "Error";
        c0467d.f6294f = str;
        hVar.e("OK", null);
        hVar.f();
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        int i5 = 1;
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        getWindow().setSoftInputMode(3);
        getWindow().getDecorView().setSystemUiVisibility(4098);
        c.q(this);
        this.f5843c = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        if (getSharedPreferences("app_settings", 0).getString("auth_code_1", null) != null) {
            Log.d("Unified - Settings", "Attempting fresh server query on startup");
            Switch r22 = (Switch) findViewById(R.id.DisablePTT);
            Switch r5 = (Switch) findViewById(R.id.MarsSwitch);
            Switch r6 = (Switch) findViewById(R.id.metricEnable);
            r22.setChecked(false);
            r5.setChecked(false);
            r6.setChecked(false);
            new AsyncTaskC0678c(this, i5).execute(new String[0]);
        } else {
            Log.w("Unified - Settings", "No auth code found, loading cached settings only");
            m();
            ThreadPoolExecutor threadPoolExecutor = this.f5843c;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.execute(new A(27, this));
            }
            l();
        }
        this.f5843c.execute(new RunnableC0115w(2));
        TextView textView = (TextView) findViewById(R.id.RegCallSign);
        TextView textView2 = (TextView) findViewById(R.id.appver);
        Context context = LaunchActivity.f5853D1;
        textView2.setText("App Version: 0.0.8-beta.13");
        ((TextView) findViewById(R.id.DMRID2)).setText(String.valueOf(c.q(this)));
        String strH = c.h(this);
        boolean z4 = strH == null || strH.isEmpty() || strH.equals("NOCALL") || strH.equals("null");
        if (z4) {
            c.L(this, "NOCALL");
            strH = "NOCALL";
        }
        if (z4) {
            strH = "Unregistered";
        }
        textView.setText(strH);
        this.f5844d = c.C(this).getString("rf_version", "Unknown");
        if (z4) {
            textView.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            textView.setClickable(true);
            textView.setBackground(getResources().getDrawable(android.R.drawable.list_selector_background));
            textView.setOnClickListener(new j(7, this));
        } else {
            textView.setClickable(false);
            textView.setPaintFlags(textView.getPaintFlags() & (-9));
            textView.setBackground(null);
        }
        TextView textView3 = (TextView) findViewById(R.id.authcodeinfo);
        SharedPreferences sharedPreferences = getSharedPreferences("app_settings", 0);
        String string = sharedPreferences.getString("auth_code_1", null);
        if (string == null) {
            String string2 = Settings.Secure.getString(getContentResolver(), "android_id");
            string = (string2 == null || string2.length() < 8) ? string2 != null ? String.format("%-8s", string2).replace(' ', '0').substring(0, 8) : "00000000" : string2.substring(string2.length() - 8);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("auth_code_1", string);
            editorEdit.apply();
        }
        textView3.setText("Cloud Auth ID: " + string);
        TextView textView4 = (TextView) findViewById(R.id.nicknameinfo);
        String string3 = getApplicationContext().getSharedPreferences("AppSettings", 0).getString("deviceName", "");
        if (string3 == null) {
            string3 = "My Radio";
        }
        textView4.setText(string3);
        ((TextView) findViewById(R.id.rfinfo)).setText("" + this.f5844d);
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onPause() {
        super.onPause();
        ThreadPoolExecutor threadPoolExecutor = this.f5843c;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdownNow();
            this.f5843c = null;
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.f5843c == null) {
            this.f5843c = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        }
    }

    public void settingsClicked(View view) {
        Intent intent = new Intent("com.unified.ur1.SETTINGS_ACTION");
        intent.putExtra("requestCode", 2);
        startActivityForResult(intent, 2);
    }
}
