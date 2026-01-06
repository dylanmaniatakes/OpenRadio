package com.unified.ur1.primary;

import B.e;
import B.j;
import D0.l;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.unified.ur1.R;
import com.unified.ur1.SatelliteTracker.h;
import com.unified.ur1.adapters.AntennaCalculatorActivity;
import com.unified.ur1.adapters.LocationDisplayActivity;
import com.unified.ur1.adapters.SoundCustomizationActivity;
import com.unified.ur1.primary.OptionsActivity;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import e0.HandlerC0430a;
import f.AbstractActivityC0472i;
import f3.C0511d;
import f3.o0;
import f3.r;
import f3.r0;
import g0.AbstractC0535a;
import g3.k;
import h4.c;
import j3.C0605c;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k.C0657t0;
import k3.C0;
import k3.D0;
import k3.E0;
import k3.F0;
import k3.G0;
import k3.H0;
import k3.I0;
import k3.J0;
import k3.RunnableC0691i0;
import m3.C0774j;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class OptionsActivity extends AbstractActivityC0472i {

    /* renamed from: H, reason: collision with root package name */
    public static int f5981H;

    /* renamed from: A, reason: collision with root package name */
    public Switch f5982A;

    /* renamed from: B, reason: collision with root package name */
    public LinearLayout f5983B;

    /* renamed from: C, reason: collision with root package name */
    public EditText f5984C;

    /* renamed from: E, reason: collision with root package name */
    public Switch f5986E;

    /* renamed from: F, reason: collision with root package name */
    public Switch f5987F;

    /* renamed from: d, reason: collision with root package name */
    public LocationManager f5990d;

    /* renamed from: e, reason: collision with root package name */
    public Location f5991e;
    public String g;
    public ProgressDialog h;

    /* renamed from: i, reason: collision with root package name */
    public CardView f5993i;

    /* renamed from: j, reason: collision with root package name */
    public Button f5994j;

    /* renamed from: k, reason: collision with root package name */
    public Button f5995k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f5996l;
    public TextView n;

    /* renamed from: o, reason: collision with root package name */
    public Button f5998o;

    /* renamed from: p, reason: collision with root package name */
    public Button f5999p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f6000q;

    /* renamed from: s, reason: collision with root package name */
    public C0774j f6002s;

    /* renamed from: t, reason: collision with root package name */
    public TextView f6003t;

    /* renamed from: u, reason: collision with root package name */
    public Switch f6004u;

    /* renamed from: v, reason: collision with root package name */
    public Switch f6005v;

    /* renamed from: w, reason: collision with root package name */
    public DMRBridge f6006w;

    /* renamed from: z, reason: collision with root package name */
    public RunnableC0691i0 f6009z;

    /* renamed from: c, reason: collision with root package name */
    public ThreadPoolExecutor f5989c = null;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5992f = false;

    /* renamed from: m, reason: collision with root package name */
    public int f5997m = 3;

    /* renamed from: r, reason: collision with root package name */
    public int f6001r = 2;

    /* renamed from: x, reason: collision with root package name */
    public final Handler f6007x = new Handler(Looper.getMainLooper());

    /* renamed from: y, reason: collision with root package name */
    public final Handler f6008y = new Handler(Looper.getMainLooper());

    /* renamed from: D, reason: collision with root package name */
    public final Handler f5985D = new Handler(Looper.getMainLooper());

    /* renamed from: G, reason: collision with root package name */
    public final HandlerC0430a f5988G = new HandlerC0430a(this, Looper.getMainLooper(), 2);

    public static void J(Spinner spinner, int i5) {
        if (spinner == null || spinner.getAdapter() == null) {
            return;
        }
        int count = spinner.getAdapter().getCount();
        if (i5 >= 0 && i5 < count) {
            spinner.setSelection(i5);
            Log.d("Unified - Settings", "Set spinner selection to SSID: " + i5);
            return;
        }
        Log.w("Unified - Settings", "Invalid SSID for spinner: " + i5 + " (adapter has " + count + " items)");
        spinner.setSelection(0);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void Q(android.widget.TextView r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unified.ur1.primary.OptionsActivity.Q(android.widget.TextView, java.lang.String):void");
    }

    public static void R(String str, String str2) {
        try {
            C0511d c0511dE = C0.g.q().e(str);
            if (c0511dE == null) {
                C0.g.q().g(new C0511d(str, str2));
                Log.d("Unified - Settings", "Created local setting: " + str + " = " + str2);
            } else {
                c0511dE.f6684b = str2;
                C0.g.q().j(c0511dE);
                Log.d("Unified - Settings", "Updated local setting: " + str + " = " + str2);
            }
        } catch (Exception e5) {
            h.o(e5, new StringBuilder("Error updating local database: "), "Unified - Settings");
        }
    }

    public static Location k() {
        Location location = new Location("default");
        location.setLatitude(39.8283d);
        location.setLongitude(-98.5795d);
        return location;
    }

    public final void A() {
        try {
            r rVar = new r(this, 2);
            if (this.f5990d.isProviderEnabled("gps")) {
                this.f5990d.requestLocationUpdates("gps", DeviceOrientationRequest.OUTPUT_PERIOD_FAST, 10.0f, rVar);
            }
            if (this.f5990d.isProviderEnabled("network")) {
                this.f5990d.requestLocationUpdates("network", DeviceOrientationRequest.OUTPUT_PERIOD_FAST, 10.0f, rVar);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new k(this, 14, rVar), 15000L);
        } catch (SecurityException e5) {
            Log.e("Unified - Settings", "Security exception requesting location updates", e5);
            this.f5991e = k();
            this.f5992f = true;
        }
    }

    public final void B(String str, Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = this.f5989c;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            Log.w("Unified - Settings", "ThreadPoolExecutor not available for ".concat(str));
            return;
        }
        try {
            this.f5989c.execute(new r0(runnable, str, 1));
        } catch (RejectedExecutionException e5) {
            StringBuilder sbM = AbstractC0535a.m("Task rejected for ", str, ": ");
            sbM.append(e5.getMessage());
            Log.w("Unified - Settings", sbM.toString());
        } catch (Exception e6) {
            Log.e("Unified - Settings", "Error submitting task ".concat(str), e6);
        }
    }

    public final void C() {
        try {
            SharedPreferences.Editor editorEdit = getSharedPreferences("agc_settings", 0).edit();
            editorEdit.putInt("roip_mic_gain_level", this.f6001r);
            editorEdit.apply();
            Log.d("Unified - Settings", "AGC settings saved");
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error saving AGC settings", e5);
        }
    }

    public void CSLButtonClicked(View view) {
        try {
            j jVar = new j();
            WeakReference weakReference = new WeakReference(this);
            jVar.f48b = weakReference;
            Activity activity = (Activity) weakReference.get();
            if (activity != null && !activity.isFinishing()) {
                View viewInflate = LayoutInflater.from(activity).inflate(R.layout.callsign_input_dialog, (ViewGroup) null);
                activity.runOnUiThread(new l(jVar, activity, viewInflate, (EditText) viewInflate.findViewById(R.id.callsign_input), 2));
            }
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error launching callsign lookup", e5);
            Toast.makeText(this, "Error launching callsign lookup", 0).show();
        }
    }

    public final void D() {
        Switch r02 = this.f6005v;
        if (r02 != null) {
            B("SaveMetricSettings", new G0(this, r02.isChecked(), 1));
        }
    }

    public final void E(int i5) {
        try {
            SharedPreferences.Editor editorEdit = getSharedPreferences("mic_gain_settings", 0).edit();
            editorEdit.putInt("mic_gain_level", i5);
            editorEdit.apply();
            Log.d("Unified - Settings", "Mic gain settings saved: level=" + i5);
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error saving mic gain settings", e5);
        }
    }

    public final void F() {
        Switch r02 = this.f6004u;
        if (r02 != null) {
            B("SavePTTSettings", new G0(this, r02.isChecked(), 0));
        }
    }

    public final void G() {
        try {
            Switch r12 = this.f5982A;
            if (r12 != null) {
                boolean zIsChecked = r12.isChecked();
                SharedPreferences.Editor editorEdit = getSharedPreferences("radioteams_settings", 0).edit();
                editorEdit.putBoolean("KEY_RADIOTEAMS_ENABLED", zIsChecked);
                editorEdit.apply();
            }
            EditText editText = this.f5984C;
            if (editText != null) {
                String upperCase = editText.getText().toString().trim().toUpperCase();
                SharedPreferences.Editor editorEdit2 = getSharedPreferences("radioteams_settings", 0).edit();
                editorEdit2.putString("KEY_RADIOTEAMS_ID", upperCase);
                editorEdit2.apply();
            }
            Log.d("Unified - Settings", "RadioTeams settings saved");
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error saving RadioTeams settings", e5);
        }
    }

    public final void H() {
        try {
            Switch r12 = this.f5986E;
            if (r12 != null) {
                c.A0(this, r12.isChecked());
            }
            Switch r13 = this.f5987F;
            if (r13 != null) {
                c.h0(this, r13.isChecked());
            }
            Log.d("Unified - Settings", "Unified Messaging settings saved");
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error saving Unified Messaging settings", e5);
        }
    }

    public final void I(C0605c c0605c) {
        Location location;
        if (!this.f5992f || (location = this.f5991e) == null) {
            new Handler(Looper.getMainLooper()).postDelayed(new k(this, 13, c0605c), 2000L);
            return;
        }
        double latitude = location.getLatitude();
        double longitude = this.f5991e.getLongitude();
        c0605c.f7606b = latitude;
        c0605c.f7607c = longitude;
        c0605c.f7608d = true;
        Log.d("Unified - Settings", String.format("Using GPS location for solar data: %.4f, %.4f", Double.valueOf(latitude), Double.valueOf(longitude)));
        Toast.makeText(this, String.format("Using location: %.2f°, %.2f°", Double.valueOf(latitude), Double.valueOf(longitude)), 0).show();
    }

    public final void K() {
        try {
            Spinner spinner = (Spinner) findViewById(R.id.aprsSsidSpinner);
            if (spinner != null) {
                String[] strArr = new String[16];
                for (int i5 = 0; i5 < 16; i5++) {
                    strArr[i5] = String.valueOf(i5);
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, strArr);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter((SpinnerAdapter) arrayAdapter);
                Log.d("Unified - Settings", "APRS spinner setup with 16 items (0-15)");
            }
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error setting up APRS spinner", e5);
        }
    }

    public final void L() {
        try {
            Button button = this.f5998o;
            if (button != null) {
                button.setOnClickListener(new F0(this, 3));
            }
            Button button2 = this.f5999p;
            if (button2 != null) {
                button2.setOnClickListener(new F0(this, 4));
            }
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error setting up ROIP mic gain listeners", e5);
        }
    }

    public final void M() {
        RunnableC0691i0 runnableC0691i0 = this.f6009z;
        if (runnableC0691i0 != null) {
            this.f6007x.removeCallbacks(runnableC0691i0);
            this.f6009z = null;
        }
        if (!s()) {
            Log.d("Unified - Settings", "ROIP not connected, skipping AGC status updates");
            return;
        }
        RunnableC0691i0 runnableC0691i02 = new RunnableC0691i0(3, this);
        this.f6009z = runnableC0691i02;
        this.f6007x.post(runnableC0691i02);
    }

    public final void N() {
        try {
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.h = progressDialog;
            progressDialog.setMessage("Shutting Down RF Module and Application...");
            this.h.setProgressStyle(0);
            this.h.setCancelable(false);
            this.h.show();
            B("StartExit", new E0(this, 10));
        } catch (Exception e5) {
            Log.e("ExitDebug", "Error in startExit", e5);
            ProgressDialog progressDialog2 = this.h;
            if (progressDialog2 != null && progressDialog2.isShowing()) {
                this.h.dismiss();
            }
            finishAffinity();
            Process.killProcess(Process.myPid());
            System.exit(1);
        }
    }

    public final void O() {
        boolean zS = s();
        String str = Build.DISPLAY;
        if (!str.contains("H18_6762") && !str.contains("H18V") && !str.contains("H18_V1.1V")) {
            this.f5993i.setVisibility(8);
            return;
        }
        CardView cardView = this.f5993i;
        if (cardView != null) {
            cardView.setVisibility(zS ? 8 : 0);
            StringBuilder sb = new StringBuilder("Mic Gain controls ");
            sb.append(zS ? "hidden" : "shown");
            sb.append(" - ROIP ");
            h.q(sb, zS ? "connected" : "not connected", "Unified - Settings");
        }
    }

    public final void P() {
        Button button = this.f5994j;
        if (button != null) {
            button.setEnabled(this.f5997m < 10);
            this.f5994j.setAlpha(this.f5997m < 10 ? 1.0f : 0.5f);
        }
        Button button2 = this.f5995k;
        if (button2 != null) {
            button2.setEnabled(this.f5997m > 0);
            this.f5995k.setAlpha(this.f5997m > 0 ? 1.0f : 0.5f);
        }
    }

    public final void S(int i5) {
        int color;
        String str;
        if (this.n != null) {
            if (i5 <= 2) {
                color = Color.parseColor("#FFC107");
                str = "Low sensitivity - good for noisy environments";
            } else if (i5 <= 5) {
                color = Color.parseColor("#4CAF50");
                str = "Normal sensitivity - balanced setting";
            } else if (i5 <= 7) {
                color = Color.parseColor("#FF9800");
                str = "High sensitivity - good for quiet environments";
            } else {
                color = Color.parseColor("#F44336");
                str = "Maximum sensitivity - may pick up background noise";
            }
            this.n.setText(str);
            this.n.setTextColor(color);
        }
    }

    public void SkywarnReport(View view) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://inws.ncep.noaa.gov/report/"));
            startActivity(intent);
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error launching Skywarn report", e5);
            Toast.makeText(this, "Unable to open Skywarn report", 0).show();
        }
    }

    public final void T() {
        Button button = this.f5998o;
        if (button != null) {
            button.setEnabled(this.f6001r < 10);
            this.f5998o.setAlpha(this.f6001r < 10 ? 1.0f : 0.5f);
        }
        Button button2 = this.f5999p;
        if (button2 != null) {
            button2.setEnabled(this.f6001r > 0);
            this.f5999p.setAlpha(this.f6001r > 0 ? 1.0f : 0.5f);
        }
    }

    public void ToolboxClicked(View view) {
        try {
            startActivity(new Intent(this, (Class<?>) AntennaCalculatorActivity.class));
            Log.d("Unified - Settings", "Toolbox button clicked - launching AntennaCalculatorActivity");
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error launching toolbox activity", e5);
            Toast.makeText(this, "Toolbox feature temporarily unavailable", 0).show();
        }
    }

    public final void U() {
        int i5 = this.f6001r;
        TextView textView = this.f6000q;
        if (textView != null) {
            textView.setText(String.valueOf(i5));
        }
        this.f6001r = i5;
        final float f5 = i5 / 10.0f;
        if (s() && this.f6006w != null && DMRBridge.f6068o) {
            B("SetInputVolume", new Runnable() { // from class: k3.M0
                @Override // java.lang.Runnable
                public final void run() {
                    float f6 = f5;
                    int i6 = OptionsActivity.f5981H;
                    OptionsActivity optionsActivity = this.f7992j;
                    optionsActivity.getClass();
                    try {
                        optionsActivity.f6006w.inputvolume(f6);
                        Log.d("Unified - Settings", "Input volume set to: " + (f6 * 100.0f) + "%");
                        optionsActivity.runOnUiThread(new E0(optionsActivity, 9));
                    } catch (Exception e5) {
                        Log.e("Unified - Settings", "Error setting input volume", e5);
                        optionsActivity.runOnUiThread(new L0(optionsActivity, e5, 1));
                    }
                }
            });
        }
        T();
    }

    public void doneButtonClicked(View view) {
        try {
            boolean z4 = false;
            getSharedPreferences("preferences", 0).getInt("KEY_APRSTX", 0);
            String string = getSharedPreferences("app_settings", 0).getString("auth_code_1", null);
            Switch r5 = this.f6004u;
            boolean z5 = r5 != null && r5.isChecked();
            Switch r7 = this.f6005v;
            if (r7 != null && r7.isChecked()) {
                z4 = true;
            }
            String str = z5 ? "On" : "Off";
            String str2 = z4 ? "On" : "Off";
            Switch r4 = (Switch) findViewById(R.id.aprsSwitch);
            if (r4 == null || !r4.isChecked()) {
                Log.d("Unified - Settings", "Sending settings update: APRS=Off, TX Disable=" + str + ", Metric=" + str2);
                B("SendAPRSOffUpdate", new J0("https://ur1.unifiedradios.com/telemetry.php?cloud_auth=" + string + "&aprs=Off&tx_disable=" + str + "&metric=" + str2, 2));
            } else {
                String str3 = String.format("https://ur1.unifiedradios.com/telemetry.php?cloud_auth=%s&aprs=%d&tx_disable=%s&metric=%s", string, Integer.valueOf(f5981H), str, str2);
                Log.d("Unified - Settings", "Sending settings update: APRS=" + f5981H + ", TX Disable=" + str + ", Metric=" + str2);
                B("SendAPRSUpdate", new J0(str3, 0));
            }
            C();
            F();
            D();
            H();
            setResult(-1, getIntent());
            finish();
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error in doneButtonClicked", e5);
            finish();
        }
    }

    public void hfConditionsButtonClicked(View view) {
        Button button;
        Runnable runnable;
        try {
            final Dialog dialog = new Dialog(this, android.R.style.Theme.Black.NoTitleBar.Fullscreen);
            dialog.setContentView(R.layout.dialog_solar_conditions);
            dialog.getWindow().setLayout((int) (getResources().getDisplayMetrics().widthPixels * 0.95d), (int) (getResources().getDisplayMetrics().heightPixels * 0.9d));
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            final TextView textView = (TextView) dialog.findViewById(R.id.currentConditionsText);
            final TextView textView2 = (TextView) dialog.findViewById(R.id.solarFluxText);
            final TextView textView3 = (TextView) dialog.findViewById(R.id.sunspotNumberText);
            final TextView textView4 = (TextView) dialog.findViewById(R.id.aIndexText);
            final TextView textView5 = (TextView) dialog.findViewById(R.id.kIndexText);
            final TextView textView6 = (TextView) dialog.findViewById(R.id.xRayBackgroundText);
            final TextView textView7 = (TextView) dialog.findViewById(R.id.auroraActivityText);
            final TextView textView8 = (TextView) dialog.findViewById(R.id.auroraLatitudeText);
            final TextView textView9 = (TextView) dialog.findViewById(R.id.geomagFieldText);
            final TextView textView10 = (TextView) dialog.findViewById(R.id.solarFlareProbText);
            final TextView textView11 = (TextView) dialog.findViewById(R.id.signalNoiseLevelText);
            final TextView textView12 = (TextView) dialog.findViewById(R.id.lastUpdatedText);
            final TextView textView13 = (TextView) dialog.findViewById(R.id.pressureText);
            final TextView textView14 = (TextView) dialog.findViewById(R.id.temperatureText);
            final TextView textView15 = (TextView) dialog.findViewById(R.id.weatherConditionsText);
            final TextView textView16 = (TextView) dialog.findViewById(R.id.tropoConditionsText);
            final TextView textView17 = (TextView) dialog.findViewById(R.id.hf80m40mText);
            final TextView textView18 = (TextView) dialog.findViewById(R.id.hf30m20mText);
            final TextView textView19 = (TextView) dialog.findViewById(R.id.hf17m15mText);
            final TextView textView20 = (TextView) dialog.findViewById(R.id.hf12m10mText);
            final TextView textView21 = (TextView) dialog.findViewById(R.id.vhf6mText);
            final TextView textView22 = (TextView) dialog.findViewById(R.id.vhf4mText);
            final TextView textView23 = (TextView) dialog.findViewById(R.id.vhf2mText);
            final TextView textView24 = (TextView) dialog.findViewById(R.id.uhf70cmText);
            final TextView textView25 = (TextView) dialog.findViewById(R.id.uhf33cmText);
            final TextView textView26 = (TextView) dialog.findViewById(R.id.uhf23cmText);
            final TextView textView27 = (TextView) dialog.findViewById(R.id.microwave13cmText);
            final TextView textView28 = (TextView) dialog.findViewById(R.id.microwave9cmText);
            final TextView textView29 = (TextView) dialog.findViewById(R.id.microwave6cmText);
            final TextView textView30 = (TextView) dialog.findViewById(R.id.microwave3cmText);
            final LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.loadingContainer);
            final LinearLayout linearLayout2 = (LinearLayout) dialog.findViewById(R.id.errorContainer);
            final TextView textView31 = (TextView) dialog.findViewById(R.id.errorText);
            Button button2 = (Button) dialog.findViewById(R.id.refreshButton);
            Button button3 = (Button) dialog.findViewById(R.id.closeButton);
            final C0605c c0605c = new C0605c();
            I(c0605c);
            if (button3 != null) {
                button = button2;
                button3.setOnClickListener(new o0(c0605c, 8, dialog));
            } else {
                button = button2;
            }
            Button button4 = button;
            Runnable runnable2 = new Runnable() { // from class: k3.T0
                @Override // java.lang.Runnable
                public final void run() {
                    int i5 = OptionsActivity.f5981H;
                    OptionsActivity optionsActivity = this.f8040j;
                    optionsActivity.getClass();
                    LinearLayout linearLayout3 = linearLayout;
                    if (linearLayout3 != null) {
                        linearLayout3.setVisibility(0);
                    }
                    LinearLayout linearLayout4 = linearLayout2;
                    if (linearLayout4 != null) {
                        linearLayout4.setVisibility(8);
                    }
                    Dialog dialog2 = dialog;
                    TextView textView32 = textView;
                    TextView textView33 = textView2;
                    TextView textView34 = textView3;
                    TextView textView35 = textView4;
                    TextView textView36 = textView5;
                    TextView textView37 = textView6;
                    TextView textView38 = textView7;
                    TextView textView39 = textView8;
                    TextView textView40 = textView9;
                    TextView textView41 = textView10;
                    TextView textView42 = textView11;
                    TextView textView43 = textView12;
                    TextView textView44 = textView13;
                    TextView textView45 = textView14;
                    TextView textView46 = textView15;
                    TextView textView47 = textView16;
                    TextView textView48 = textView17;
                    TextView textView49 = textView18;
                    TextView textView50 = textView19;
                    TextView textView51 = textView20;
                    TextView textView52 = textView21;
                    TextView textView53 = textView22;
                    TextView textView54 = textView23;
                    TextView textView55 = textView24;
                    TextView textView56 = textView25;
                    TextView textView57 = textView26;
                    TextView textView58 = textView27;
                    TextView textView59 = textView28;
                    TextView textView60 = textView29;
                    TextView textView61 = textView30;
                    TextView textView62 = textView31;
                    f3.E0 e02 = new f3.E0();
                    e02.I = optionsActivity;
                    e02.f6571i = dialog2;
                    e02.f6565a = linearLayout3;
                    e02.f6566b = textView32;
                    e02.f6567c = textView33;
                    e02.f6568d = textView34;
                    e02.f6569e = textView35;
                    e02.f6570f = textView36;
                    e02.g = textView37;
                    e02.f6572j = textView38;
                    e02.f6573k = textView39;
                    e02.f6574l = textView40;
                    e02.f6575m = textView41;
                    e02.n = textView42;
                    e02.f6576o = textView43;
                    e02.f6577p = textView44;
                    e02.f6578q = textView45;
                    e02.f6579r = textView46;
                    e02.f6580s = textView47;
                    e02.f6581t = textView48;
                    e02.f6582u = textView49;
                    e02.f6583v = textView50;
                    e02.f6584w = textView51;
                    e02.f6585x = textView52;
                    e02.f6586y = textView53;
                    e02.f6587z = textView54;
                    e02.f6557A = textView55;
                    e02.f6558B = textView56;
                    e02.f6559C = textView57;
                    e02.f6560D = textView58;
                    e02.f6561E = textView59;
                    e02.f6562F = textView60;
                    e02.f6563G = textView61;
                    e02.h = linearLayout4;
                    e02.f6564H = textView62;
                    C0605c c0605c2 = c0605c;
                    c0605c2.getClass();
                    c0605c2.f7605a.execute(new g3.k(c0605c2, 5, e02));
                }
            };
            if (button4 != null) {
                runnable = runnable2;
                button4.setOnClickListener(new com.google.android.material.datepicker.l(5, runnable));
            } else {
                runnable = runnable2;
            }
            runnable.run();
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: k3.U0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    int i5 = OptionsActivity.f5981H;
                    ExecutorService executorService = c0605c.f7605a;
                    if (executorService == null || executorService.isShutdown()) {
                        return;
                    }
                    executorService.shutdown();
                }
            });
            dialog.show();
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error showing solar conditions dialog", e5);
            Toast.makeText(this, "Error displaying solar conditions", 0).show();
        }
    }

    public final void j() {
        try {
            Switch r02 = (Switch) findViewById(R.id.aprsSwitch);
            Spinner spinner = (Spinner) findViewById(R.id.aprsSsidSpinner);
            final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.aprsSsidContainer);
            if (r02 != null && linearLayout != null) {
                r02.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: k3.R0
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                        int i5 = OptionsActivity.f5981H;
                        OptionsActivity optionsActivity = this.f8014a;
                        optionsActivity.getClass();
                        try {
                            h4.c.J(optionsActivity, z4 ? 1 : 0);
                            optionsActivity.B("SetAprsEnabled", new H0(0, z4));
                        } catch (Exception e5) {
                            Log.e("Unified - Settings", "Error in setAprsEnabled", e5);
                        }
                        linearLayout.setVisibility(8);
                    }
                });
            }
            if (spinner != null) {
                spinner.setOnItemSelectedListener(new C0657t0(2, this));
            }
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error attaching listeners", e5);
        }
    }

    public final void l() throws NumberFormatException {
        K();
        Switch r22 = (Switch) findViewById(R.id.aprsSwitch);
        Spinner spinner = (Spinner) findViewById(R.id.aprsSsidSpinner);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.aprsSsidContainer);
        h.q(new StringBuilder("Populating UI with server values. CloudSSID: "), this.g, "Unified - Settings");
        String str = this.g;
        if (str == null) {
            Log.d("Unified - Settings", "No server APRS data, using local fallback");
            v();
        } else if (str.equals("Off")) {
            Log.d("Unified - Settings", "Setting UI to APRS Off (from server)");
            if (r22 != null) {
                r22.setChecked(false);
            }
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        } else {
            try {
                int i5 = Integer.parseInt(this.g);
                Log.d("Unified - Settings", "Setting UI to APRS On with SSID: " + i5 + " (from server)");
                if (i5 < 0 || i5 > 15) {
                    Log.w("Unified - Settings", "Invalid SSID from server: " + i5 + " (must be 0-15)");
                    if (r22 != null) {
                        r22.setChecked(false);
                    }
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                } else {
                    if (r22 != null) {
                        r22.setChecked(true);
                    }
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    J(spinner, i5);
                    f5981H = i5;
                    B("UpdateLocalAPRSDatabase", new I0(this, i5, 0));
                }
            } catch (NumberFormatException e5) {
                Log.e("Unified - Settings", "Error parsing server CloudSSID: " + e5.getMessage());
                if (r22 != null) {
                    r22.setChecked(false);
                }
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            }
        }
        B("PopulateServerValues", new E0(this, 7));
        j();
    }

    public void locationClicked(View view) {
        try {
            startActivity(new Intent(this, (Class<?>) LocationDisplayActivity.class));
            Log.d("Unified - Settings", "Location button clicked - launching LocationDisplayActivity");
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error launching location activity", e5);
            Toast.makeText(this, "Location feature temporarily unavailable", 0).show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m() {
        /*
            r9 = this;
            java.lang.String r0 = "network"
            java.lang.String r1 = "gps"
            java.lang.String r2 = "Unified - Settings"
            android.location.LocationManager r3 = r9.f5990d
            r4 = 1
            if (r3 != 0) goto L14
            android.location.Location r0 = k()
            r9.f5991e = r0
            r9.f5992f = r4
            return
        L14:
            boolean r3 = r3.isProviderEnabled(r1)     // Catch: java.lang.SecurityException -> L3a
            android.location.LocationManager r5 = r9.f5990d     // Catch: java.lang.SecurityException -> L3a
            boolean r5 = r5.isProviderEnabled(r0)     // Catch: java.lang.SecurityException -> L3a
            if (r3 != 0) goto L3c
            if (r5 != 0) goto L3c
            java.lang.String r0 = "Location services disabled, using default location"
            android.util.Log.w(r2, r0)     // Catch: java.lang.SecurityException -> L3a
            android.location.Location r0 = k()     // Catch: java.lang.SecurityException -> L3a
            r9.f5991e = r0     // Catch: java.lang.SecurityException -> L3a
            r9.f5992f = r4     // Catch: java.lang.SecurityException -> L3a
            java.lang.String r0 = "Location services disabled. Using default location."
            r1 = 0
            android.widget.Toast r0 = android.widget.Toast.makeText(r9, r0, r1)     // Catch: java.lang.SecurityException -> L3a
            r0.show()     // Catch: java.lang.SecurityException -> L3a
            return
        L3a:
            r0 = move-exception
            goto La0
        L3c:
            android.location.LocationManager r3 = r9.f5990d     // Catch: java.lang.SecurityException -> L59
            android.location.Location r1 = r3.getLastKnownLocation(r1)     // Catch: java.lang.SecurityException -> L59
            android.location.LocationManager r3 = r9.f5990d     // Catch: java.lang.SecurityException -> L59
            android.location.Location r0 = r3.getLastKnownLocation(r0)     // Catch: java.lang.SecurityException -> L59
            if (r1 == 0) goto L5b
            if (r0 == 0) goto L5b
            long r5 = r1.getTime()     // Catch: java.lang.SecurityException -> L59
            long r7 = r0.getTime()     // Catch: java.lang.SecurityException -> L59
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 <= 0) goto L5e
            goto L66
        L59:
            r0 = move-exception
            goto L60
        L5b:
            if (r1 == 0) goto L5e
            goto L66
        L5e:
            r1 = r0
            goto L66
        L60:
            java.lang.String r1 = "Security exception getting last known location"
            android.util.Log.e(r2, r1, r0)     // Catch: java.lang.SecurityException -> L3a
            r1 = 0
        L66:
            if (r1 == 0) goto L9c
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.SecurityException -> L3a
            long r7 = r1.getTime()     // Catch: java.lang.SecurityException -> L3a
            long r5 = r5 - r7
            r7 = 600000(0x927c0, double:2.964394E-318)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 >= 0) goto L9c
            r9.f5991e = r1     // Catch: java.lang.SecurityException -> L3a
            r9.f5992f = r4     // Catch: java.lang.SecurityException -> L3a
            java.lang.String r0 = "Using last known location: %.4f, %.4f"
            double r5 = r1.getLatitude()     // Catch: java.lang.SecurityException -> L3a
            java.lang.Double r1 = java.lang.Double.valueOf(r5)     // Catch: java.lang.SecurityException -> L3a
            android.location.Location r3 = r9.f5991e     // Catch: java.lang.SecurityException -> L3a
            double r5 = r3.getLongitude()     // Catch: java.lang.SecurityException -> L3a
            java.lang.Double r3 = java.lang.Double.valueOf(r5)     // Catch: java.lang.SecurityException -> L3a
            java.lang.Object[] r1 = new java.lang.Object[]{r1, r3}     // Catch: java.lang.SecurityException -> L3a
            java.lang.String r0 = java.lang.String.format(r0, r1)     // Catch: java.lang.SecurityException -> L3a
            android.util.Log.d(r2, r0)     // Catch: java.lang.SecurityException -> L3a
            return
        L9c:
            r9.A()     // Catch: java.lang.SecurityException -> L3a
            goto Lad
        La0:
            java.lang.String r1 = "Security exception getting location"
            android.util.Log.e(r2, r1, r0)
            android.location.Location r0 = k()
            r9.f5991e = r0
            r9.f5992f = r4
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unified.ur1.primary.OptionsActivity.m():void");
    }

    public final void n() {
        try {
            this.f5998o = (Button) findViewById(R.id.roipMicGainPlusButton);
            this.f5999p = (Button) findViewById(R.id.roipMicGainMinusButton);
            this.f6000q = (TextView) findViewById(R.id.roipMicGainValueText);
            this.f6003t = (TextView) findViewById(R.id.agcVolumeDescription);
            this.f6003t = (TextView) findViewById(R.id.agcVolumeDescription);
            B("LoadAGCSettings", new E0(this, 5));
            L();
            Log.d("Unified - Settings", "AGC components initialized");
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error initializing AGC components", e5);
        }
    }

    public final void o() {
        try {
            this.f5993i = (CardView) findViewById(R.id.micGainSettingsCard);
            this.f5994j = (Button) findViewById(R.id.micGainPlusButton);
            this.f5995k = (Button) findViewById(R.id.micGainMinusButton);
            this.f5996l = (TextView) findViewById(R.id.micGainValueText);
            this.n = (TextView) findViewById(R.id.micGainStatusText);
            this.f6002s = C0774j.a();
            CardView cardView = this.f5993i;
            if (cardView != null) {
                cardView.setVisibility(8);
            }
            B("LoadMicGainSettings", new E0(this, 3));
            Log.d("Unified - Settings", "Microphone gain components initialized");
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error initializing microphone gain components", e5);
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        if (i6 != -1 || intent == null || intent.getData() == null) {
            return;
        }
        Uri data = intent.getData();
        switch (i5) {
            case 1001:
                B("HandleAudioFileSelection", new l(this, data, "fm_ptt", "FM PTT", 4));
                break;
            case 1002:
                B("HandleAudioFileSelection", new l(this, data, "dmr_rf_ptt", "DMR PTT", 4));
                break;
            case 1003:
                B("HandleAudioFileSelection", new l(this, data, "roip_ptt", "ROIP PTT", 4));
                break;
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        int i5 = 2;
        super.onCreate(bundle);
        setContentView(R.layout.activity_options);
        try {
            this.f5989c = new ThreadPoolExecutor(4, 8, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new ThreadPoolExecutor.CallerRunsPolicy());
            Log.d("Unified - Settings", "Thread pool initialized successfully");
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error initializing thread pool", e5);
        }
        try {
            getWindow().getDecorView().setSystemUiVisibility(4098);
            TextView textView = (TextView) findViewById(R.id.appver);
            if (textView != null) {
                Context context = LaunchActivity.f5853D1;
                textView.setText("App Version: 0.0.8-beta.13");
            }
            TextView textView2 = (TextView) findViewById(R.id.subscription);
            if (textView2 != null) {
                textView2.setText("Subscription Status: " + c.C(this).getString("subscription", ""));
            }
            Button button = (Button) findViewById(R.id.ExitButton);
            if (button != null) {
                button.setOnClickListener(new F0(this, 1));
            }
            Button button2 = (Button) findViewById(R.id.checkUpdate);
            if (button2 != null) {
                button2.setOnClickListener(new F0(this, i5));
            }
            Log.d("Unified - Settings", "Critical UI setup completed");
        } catch (Exception e6) {
            Log.e("Unified - Settings", "Error in critical UI setup", e6);
        }
        this.f5990d = (LocationManager) getSystemService("location");
        if (C.h.a(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            e.d(this, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1001);
        } else {
            m();
        }
        this.f6008y.post(new E0(this, i5));
        ((Button) findViewById(R.id.btnRadioTeams)).setOnClickListener(new F0(this, 0));
    }

    @Override // f.AbstractActivityC0472i, androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        try {
            RunnableC0691i0 runnableC0691i0 = this.f6009z;
            if (runnableC0691i0 != null) {
                this.f6007x.removeCallbacks(runnableC0691i0);
                this.f6009z = null;
            }
            C();
            D();
            F();
            G();
            H();
            E(this.f5997m);
            Handler handler = this.f6007x;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            Handler handler2 = this.f6008y;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            Handler handler3 = this.f5985D;
            if (handler3 != null) {
                handler3.removeCallbacksAndMessages(null);
            }
            ThreadPoolExecutor threadPoolExecutor = this.f5989c;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.shutdownNow();
                try {
                    if (!this.f5989c.awaitTermination(2L, TimeUnit.SECONDS)) {
                        Log.w("Unified - Settings", "ThreadPool did not terminate gracefully");
                    }
                } catch (InterruptedException e5) {
                    Log.w("Unified - Settings", "ThreadPool termination interrupted", e5);
                    Thread.currentThread().interrupt();
                }
                this.f5989c = null;
            }
            ProgressDialog progressDialog = this.h;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.h.dismiss();
                this.h = null;
            }
            Log.d("Unified - Settings", "OptionsActivity destroyed successfully");
        } catch (Exception e6) {
            Log.e("Unified - Settings", "Error in onDestroy", e6);
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onPause() {
        super.onPause();
        try {
            RunnableC0691i0 runnableC0691i0 = this.f6009z;
            if (runnableC0691i0 != null) {
                this.f6007x.removeCallbacks(runnableC0691i0);
                this.f6009z = null;
            }
            F();
            D();
            C();
            G();
            H();
            E(this.f5997m);
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error in onPause", e5);
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i5, strArr, iArr);
        if (i5 == 1001) {
            if (iArr.length > 0 && iArr[0] == 0) {
                m();
                return;
            }
            Log.w("Unified - Settings", "Location permission denied, using default location");
            this.f5991e = k();
            this.f5992f = true;
            Toast.makeText(this, "Location permission denied. Using default location for weather data.", 1).show();
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onResume() {
        super.onResume();
        try {
            O();
            if (s()) {
                M();
            }
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error in onResume", e5);
        }
    }

    public final void p() {
        try {
            this.f6004u = (Switch) findViewById(R.id.DisablePTT);
            this.f6005v = (Switch) findViewById(R.id.metricEnable);
            B("LoadPTTAndMetricSettings", new E0(this, 6));
            Log.d("Unified - Settings", "PTT components initialized");
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error initializing PTT components", e5);
        }
    }

    public final void q() {
        try {
            this.f5982A = (Switch) findViewById(R.id.radioTeamsSwitch);
            this.f5983B = (LinearLayout) findViewById(R.id.radioTeamsInputContainer);
            this.f5984C = (EditText) findViewById(R.id.radioTeamsIdEditText);
            B("LoadRadioTeamsSettings", new E0(this, 8));
            Log.d("Unified - Settings", "RadioTeams components initialized");
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error initializing RadioTeams components", e5);
        }
    }

    public final void r() {
        try {
            this.f5986E = (Switch) findViewById(R.id.unifiedMessagingSwitch);
            this.f5987F = (Switch) findViewById(R.id.newMessageSoundSwitch);
            B("LoadUnifiedMessagingSettings", new E0(this, 4));
            Log.d("Unified - Settings", "Unified Messaging components initialized");
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error initializing Unified Messaging components", e5);
        }
    }

    public void refreshSettingsFromServer(View view) {
        Log.d("Unified - Settings", "Manually refreshing settings from server");
        z();
    }

    public final boolean s() {
        try {
            return c.C(this).getInt("roip_connection", 0) == 1;
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error checking ROIP connection", e5);
            return false;
        }
    }

    public void settingsClicked(View view) {
        try {
            Intent intent = new Intent("com.unified.ur1.SETTINGS_ACTION");
            intent.putExtra("requestCode", 2);
            startActivityForResult(intent, 2);
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error launching settings", e5);
            Toast.makeText(this, "Error opening settings", 0).show();
        }
    }

    public void soundClicked(View view) {
        try {
            startActivity(new Intent(this, (Class<?>) SoundCustomizationActivity.class));
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error launching Sound activity", e5);
        }
    }

    public final void t(JSONObject jSONObject) {
        try {
            Log.d("Unified - Settings", "Parsing JSON settings");
            if (jSONObject.has("aprs")) {
                w(jSONObject.getString("aprs"));
            }
            if (jSONObject.has("tx_disable")) {
                y(jSONObject.getString("tx_disable"));
            }
            if (jSONObject.has("metric")) {
                x(jSONObject.getString("metric"));
            }
            if (jSONObject.has("tx_full")) {
                Log.d("Unified - Settings", "TX Full setting: " + jSONObject.getString("tx_full"));
            }
            if (jSONObject.has("subscription")) {
                Log.d("Unified - Settings", "Subscription status: " + jSONObject.getString("subscription"));
            }
            l();
        } catch (JSONException e5) {
            Log.e("Unified - Settings", "JSON parsing error: " + e5.getMessage());
            throw new RuntimeException("Failed to parse JSON settings", e5);
        } catch (Exception e6) {
            h.o(e6, new StringBuilder("Unexpected error in JSON parsing: "), "Unified - Settings");
            throw e6;
        }
    }

    public final void u(String str) {
        for (String str2 : str.split("\n")) {
            String lowerCase = str2.trim().toLowerCase();
            if (lowerCase.contains("aprs")) {
                if (lowerCase.contains("off") || lowerCase.contains("0")) {
                    this.g = "Off";
                    c.J(this, 0);
                } else {
                    String[] strArrSplit = lowerCase.split("[:=]");
                    if (strArrSplit.length > 1) {
                        try {
                            int i5 = Integer.parseInt(strArrSplit[1].trim());
                            if (i5 >= 0 && i5 <= 15) {
                                this.g = String.valueOf(i5);
                                c.J(this, 1);
                                c.C(this).edit().putInt("aprssside", i5).apply();
                            }
                        } catch (NumberFormatException unused) {
                            Log.w("Unified - Settings", "Could not parse SSID from: " + strArrSplit[1]);
                        }
                    }
                }
            } else if (lowerCase.contains("tx_disable")) {
                y((lowerCase.contains("on") || lowerCase.contains("1")) ? "On" : "Off");
            } else if (lowerCase.contains("metric")) {
                x((lowerCase.contains("on") || lowerCase.contains("1")) ? "On" : "Off");
            }
        }
        l();
    }

    public final void v() {
        Switch r4 = (Switch) findViewById(R.id.aprsSwitch);
        Spinner spinner = (Spinner) findViewById(R.id.aprsSsidSpinner);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.aprsSsidContainer);
        h.q(new StringBuilder("Populating original values. CloudSSID: "), this.g, "Unified - Settings");
        String str = this.g;
        if (str == null) {
            Log.d("Unified - Settings", "CloudSSID is null, falling back to Room database values");
            B("PopulateOriginalValuesFromDB", new l(this, r4, linearLayout, spinner, 5));
            return;
        }
        if (str.equals("Off")) {
            Log.d("Unified - Settings", "Setting UI to APRS Off");
            if (r4 != null) {
                r4.setChecked(false);
            }
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        try {
            int i5 = Integer.parseInt(this.g);
            Log.d("Unified - Settings", "Setting UI to APRS On with SSID: " + i5);
            if (i5 < 0 || i5 > 15) {
                return;
            }
            if (r4 != null) {
                r4.setChecked(true);
            }
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            if (spinner != null) {
                spinner.setSelection(i5);
            }
            B("PopulateOriginalValues", new D0(i5, 0));
        } catch (NumberFormatException e5) {
            Log.e("Unified - Settings", "Error parsing CloudSSID: " + e5.getMessage());
        }
    }

    public final void w(String str) throws NumberFormatException {
        AbstractC0535a.v("Processing APRS setting: ", str, "Unified - Settings");
        try {
            if (str == null) {
                Log.w("Unified - Settings", "APRS value is null, defaulting to Off");
                this.g = "Off";
                c.J(this, 0);
                return;
            }
            String strTrim = str.trim();
            if (strTrim.equalsIgnoreCase("off")) {
                this.g = "Off";
                c.J(this, 0);
                Log.d("Unified - Settings", "Server APRS setting: OFF");
                return;
            }
            try {
                int i5 = Integer.parseInt(strTrim);
                if (i5 < 0 || i5 > 15) {
                    Log.w("Unified - Settings", "Invalid APRS SSID from server: " + i5 + " (must be 0-15)");
                    this.g = "Off";
                    c.J(this, 0);
                } else {
                    this.g = String.valueOf(i5);
                    c.J(this, 1);
                    c.C(this).edit().putInt("aprssside", i5).apply();
                    Log.d("Unified - Settings", "Server APRS setting: SSID " + i5);
                }
            } catch (NumberFormatException unused) {
                Log.w("Unified - Settings", "Could not parse APRS value as integer: ".concat(strTrim));
                this.g = "Off";
                c.J(this, 0);
            }
        } catch (Exception e5) {
            h.o(e5, new StringBuilder("Error processing APRS settings: "), "Unified - Settings");
            this.g = "Off";
            c.J(this, 0);
        }
    }

    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final void x(String str) {
        AbstractC0535a.v("Processing Metric enable setting: ", str, "Unified - Settings");
        if (str == null) {
            try {
                Log.w("Unified - Settings", "Metric value is null, defaulting to Off");
                str = "Off";
            } catch (Exception e5) {
                h.o(e5, new StringBuilder("Error processing metric settings: "), "Unified - Settings");
                return;
            }
        }
        String strTrim = str.trim();
        ?? r22 = 1;
        r22 = 1;
        if (!strTrim.equalsIgnoreCase("on") && !strTrim.equals("1")) {
            r22 = 0;
        }
        c.e0(this, r22);
        B("ProcessMetricSettings", new H0(1, r22));
    }

    public final void y(String str) {
        AbstractC0535a.v("Processing PTT disable setting: ", str, "Unified - Settings");
        if (str == null) {
            try {
                Log.w("Unified - Settings", "TX disable value is null, defaulting to Off");
                str = "Off";
            } catch (Exception e5) {
                h.o(e5, new StringBuilder("Error processing PTT settings: "), "Unified - Settings");
                return;
            }
        }
        String strTrim = str.trim();
        String str2 = "1";
        boolean z4 = strTrim.equalsIgnoreCase("on") || strTrim.equals("1");
        if (!z4) {
            str2 = "0";
        }
        c.V(this, str2);
        B("ProcessPTTSettings", new H0(2, z4));
    }

    public final void z() {
        String string = getSharedPreferences("app_settings", 0).getString("auth_code_1", null);
        if (string != null && !string.isEmpty()) {
            String strL = AbstractC0535a.l("https://ur1.unifiedradios.com/telemetry.php?cloud_auth=", string, "&query=1");
            Log.d("Unified - Settings", "Querying server settings from: ".concat(strL));
            new j(this, 2).execute(strL);
        } else {
            Log.w("Unified - Settings", "No auth code found, using local settings only");
            K();
            v();
            j();
        }
    }
}
