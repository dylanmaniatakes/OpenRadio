package com.unified.ur1.adapters;

import B.e;
import L.h;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.unified.ur1.R;
import com.unified.ur1.adapters.RepeaterDirectoryActivity;
import f.AbstractActivityC0472i;
import f.C0467d;
import f.DialogC0469f;
import f3.DialogInterfaceOnClickListenerC0516g;
import f3.S;
import f3.g0;
import f3.i0;
import f3.l0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RepeaterDirectoryActivity extends AbstractActivityC0472i {

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f5689s = 0;

    /* renamed from: c, reason: collision with root package name */
    public LocationManager f5690c;

    /* renamed from: d, reason: collision with root package name */
    public RecyclerView f5691d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f5692e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f5693f;
    public AppCompatButton g;

    /* renamed from: k, reason: collision with root package name */
    public Location f5696k;

    /* renamed from: m, reason: collision with root package name */
    public Handler f5698m;
    public DialogC0469f n;
    public final ExecutorService h = Executors.newSingleThreadExecutor();

    /* renamed from: i, reason: collision with root package name */
    public double f5694i = 0.0d;

    /* renamed from: j, reason: collision with root package name */
    public double f5695j = 0.0d;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5697l = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5699o = false;

    /* renamed from: p, reason: collision with root package name */
    public double f5700p = 0.0d;

    /* renamed from: q, reason: collision with root package name */
    public double f5701q = 0.0d;

    /* renamed from: r, reason: collision with root package name */
    public final l0 f5702r = new l0(this, 0);

    public final void j() {
        DialogC0469f dialogC0469f = this.n;
        if (dialogC0469f == null || !dialogC0469f.isShowing()) {
            return;
        }
        this.n.dismiss();
    }

    public final void k() {
        h hVar = new h(this);
        C0467d c0467d = (C0467d) hVar.f1522d;
        c0467d.f6292d = "Enter Coordinates";
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(50, 40, 50, 10);
        EditText editText = new EditText(this);
        editText.setHint("Latitude (e.g., 40.7128)");
        editText.setInputType(12290);
        if (this.f5699o) {
            editText.setText(String.valueOf(this.f5700p));
        } else {
            double d5 = this.f5694i;
            if (d5 != 0.0d) {
                editText.setText(String.valueOf(d5));
            }
        }
        linearLayout.addView(editText);
        EditText editText2 = new EditText(this);
        editText2.setHint("Longitude (e.g., -74.0060)");
        editText2.setInputType(12290);
        if (this.f5699o) {
            editText2.setText(String.valueOf(this.f5701q));
        } else {
            double d6 = this.f5695j;
            if (d6 != 0.0d) {
                editText2.setText(String.valueOf(d6));
            }
        }
        linearLayout.addView(editText2);
        c0467d.f6304s = linearLayout;
        hVar.e("Set Location", new S(this, editText, editText2, 1));
        hVar.c("Cancel", new DialogInterfaceOnClickListenerC0516g(6));
        hVar.f();
    }

    public final void l() {
        h hVar = new h(this);
        C0467d c0467d = (C0467d) hVar.f1522d;
        c0467d.f6292d = "Enable GPS";
        c0467d.f6294f = "GPS is required to find nearby repeaters. Would you like to enable it?";
        hVar.e("Yes", new i0(this, 5));
        hVar.c("No", new i0(this, 6));
        hVar.b().show();
    }

    public final void m(final double d5, final double d6) {
        this.f5694i = d5;
        this.f5695j = d6;
        String strConcat = String.format("Current Location: %.4f, %.4f", Double.valueOf(d5), Double.valueOf(d6));
        if (this.f5699o) {
            strConcat = strConcat.concat(" (Manual)");
        }
        this.f5692e.setText(strConcat);
        char c2 = (char) ((r7 / 10.0d) + 65.0d);
        char c5 = (char) (((int) ((90.0d + d5) % 10.0d)) + 48);
        char c6 = (char) (((r7 % 1.0d) * 24.0d) + 97.0d);
        String str = "" + ((char) ((r0 / 20.0d) + 65.0d)) + c2 + ((char) ((((int) ((180.0d + d6) % 20.0d)) / 2) + 48)) + c5 + ((char) (((r0 % 2.0d) * 12.0d) + 97.0d)) + c6;
        this.f5693f.setText("Grid Square: " + str);
        this.h.execute(new Runnable() { // from class: f3.k0
            @Override // java.lang.Runnable
            public final void run() throws JSONException, IOException, NumberFormatException {
                double d7;
                final int i5 = 2;
                double d8 = d5;
                double d9 = d6;
                int i6 = RepeaterDirectoryActivity.f5689s;
                final RepeaterDirectoryActivity repeaterDirectoryActivity = this.f6735j;
                repeaterDirectoryActivity.getClass();
                try {
                    final ArrayList arrayList = new ArrayList();
                    if (!arrayList.isEmpty()) {
                        repeaterDirectoryActivity.runOnUiThread(new Runnable() { // from class: f3.h0
                            @Override // java.lang.Runnable
                            public final void run() {
                                List list = arrayList;
                                RepeaterDirectoryActivity repeaterDirectoryActivity2 = repeaterDirectoryActivity;
                                switch (i5) {
                                    case 0:
                                        int i7 = RepeaterDirectoryActivity.f5689s;
                                        repeaterDirectoryActivity2.getClass();
                                        repeaterDirectoryActivity2.f5691d.setAdapter(new f0(repeaterDirectoryActivity2, (ArrayList) list));
                                        break;
                                    case 1:
                                        int i8 = RepeaterDirectoryActivity.f5689s;
                                        repeaterDirectoryActivity2.getClass();
                                        repeaterDirectoryActivity2.f5691d.setAdapter(new f0(repeaterDirectoryActivity2, (ArrayList) list));
                                        Toast.makeText(repeaterDirectoryActivity2, "Offline Mode - using Cached Repeater Data", 1).show();
                                        break;
                                    default:
                                        int i9 = RepeaterDirectoryActivity.f5689s;
                                        repeaterDirectoryActivity2.getClass();
                                        repeaterDirectoryActivity2.f5691d.setAdapter(new f0(repeaterDirectoryActivity2, (ArrayList) list));
                                        Toast.makeText(repeaterDirectoryActivity2, "Using cached repeater data from " + new SimpleDateFormat("MM/dd/yyyy HH:mm").format(new Date(repeaterDirectoryActivity2.getSharedPreferences("repeater_cache", 0).getLong("last_update_time", 0L))), 1).show();
                                        break;
                                }
                            }
                        });
                        return;
                    }
                    String string = repeaterDirectoryActivity.getSharedPreferences("app_settings", 0).getString("auth_code_1", null);
                    URLEncoder.encode(string, "UTF-8");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://ur1.unifiedradios.com/api-rf/repeaters?cloud_auth=" + string).openConnection();
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        } else {
                            sb.append(line);
                        }
                    }
                    JSONObject jSONObject = new JSONObject(sb.toString());
                    if (jSONObject.getBoolean("success")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("data");
                        for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i7);
                            String string2 = jSONObject2.getString("mode");
                            double d10 = jSONObject2.getDouble("rx");
                            if (((d10 >= 136.0d && d10 <= 174.0d) || (d10 >= 400.0d && d10 <= 480.0d)) && (string2.contains("FM") || string2.contains("DMR"))) {
                                String string3 = jSONObject2.getString("callsign");
                                String strValueOf = String.valueOf(jSONObject2.getDouble("rx"));
                                String strValueOf2 = String.valueOf(jSONObject2.getDouble("tx"));
                                String strOptString = jSONObject2.optString("city", "");
                                String string4 = jSONObject2.getString("state_code");
                                String strOptString2 = jSONObject2.optString("fm_tx_ctcss", "0.0");
                                String strOptString3 = jSONObject2.optString("dmr_ts1", "");
                                String strOptString4 = jSONObject2.optString("dmr_ts2", "");
                                String strOptString5 = jSONObject2.optString("dmr_cc", "1");
                                try {
                                    d7 = Double.parseDouble(jSONObject2.getString("distance").replaceAll("[^0-9.]", ""));
                                } catch (Exception unused) {
                                    d7 = 0.0d;
                                }
                                m0 m0Var = new m0(string3, strValueOf, strValueOf2, string2, strOptString, string4, strOptString2, 0, strOptString3, strOptString4, strOptString5, d7);
                                m0Var.f6753k = jSONObject2.optString("notes", "");
                                m0Var.f6752j = false;
                                arrayList.add(m0Var);
                            }
                        }
                        h4.r.o(repeaterDirectoryActivity, arrayList, d8, d9);
                    } else {
                        Log.e("RepeaterDirectory", "Server returned error");
                        ArrayList arrayListI = h4.r.i(repeaterDirectoryActivity);
                        if (!arrayListI.isEmpty()) {
                            repeaterDirectoryActivity.runOnUiThread(new g0(repeaterDirectoryActivity, 2));
                            arrayList = arrayListI;
                        }
                    }
                    final int i8 = 0;
                    repeaterDirectoryActivity.runOnUiThread(new Runnable() { // from class: f3.h0
                        @Override // java.lang.Runnable
                        public final void run() {
                            List list = arrayList;
                            RepeaterDirectoryActivity repeaterDirectoryActivity2 = repeaterDirectoryActivity;
                            switch (i8) {
                                case 0:
                                    int i72 = RepeaterDirectoryActivity.f5689s;
                                    repeaterDirectoryActivity2.getClass();
                                    repeaterDirectoryActivity2.f5691d.setAdapter(new f0(repeaterDirectoryActivity2, (ArrayList) list));
                                    break;
                                case 1:
                                    int i82 = RepeaterDirectoryActivity.f5689s;
                                    repeaterDirectoryActivity2.getClass();
                                    repeaterDirectoryActivity2.f5691d.setAdapter(new f0(repeaterDirectoryActivity2, (ArrayList) list));
                                    Toast.makeText(repeaterDirectoryActivity2, "Offline Mode - using Cached Repeater Data", 1).show();
                                    break;
                                default:
                                    int i9 = RepeaterDirectoryActivity.f5689s;
                                    repeaterDirectoryActivity2.getClass();
                                    repeaterDirectoryActivity2.f5691d.setAdapter(new f0(repeaterDirectoryActivity2, (ArrayList) list));
                                    Toast.makeText(repeaterDirectoryActivity2, "Using cached repeater data from " + new SimpleDateFormat("MM/dd/yyyy HH:mm").format(new Date(repeaterDirectoryActivity2.getSharedPreferences("repeater_cache", 0).getLong("last_update_time", 0L))), 1).show();
                                    break;
                            }
                        }
                    });
                } catch (Exception e5) {
                    Log.e("RepeaterDirectory", "Error fetching repeaters", e5);
                    final ArrayList arrayListI2 = h4.r.i(repeaterDirectoryActivity);
                    if (arrayListI2.isEmpty()) {
                        repeaterDirectoryActivity.runOnUiThread(new g0(repeaterDirectoryActivity, 1));
                    } else {
                        final int i9 = 1;
                        repeaterDirectoryActivity.runOnUiThread(new Runnable() { // from class: f3.h0
                            @Override // java.lang.Runnable
                            public final void run() {
                                List list = arrayListI2;
                                RepeaterDirectoryActivity repeaterDirectoryActivity2 = repeaterDirectoryActivity;
                                switch (i9) {
                                    case 0:
                                        int i72 = RepeaterDirectoryActivity.f5689s;
                                        repeaterDirectoryActivity2.getClass();
                                        repeaterDirectoryActivity2.f5691d.setAdapter(new f0(repeaterDirectoryActivity2, (ArrayList) list));
                                        break;
                                    case 1:
                                        int i82 = RepeaterDirectoryActivity.f5689s;
                                        repeaterDirectoryActivity2.getClass();
                                        repeaterDirectoryActivity2.f5691d.setAdapter(new f0(repeaterDirectoryActivity2, (ArrayList) list));
                                        Toast.makeText(repeaterDirectoryActivity2, "Offline Mode - using Cached Repeater Data", 1).show();
                                        break;
                                    default:
                                        int i92 = RepeaterDirectoryActivity.f5689s;
                                        repeaterDirectoryActivity2.getClass();
                                        repeaterDirectoryActivity2.f5691d.setAdapter(new f0(repeaterDirectoryActivity2, (ArrayList) list));
                                        Toast.makeText(repeaterDirectoryActivity2, "Using cached repeater data from " + new SimpleDateFormat("MM/dd/yyyy HH:mm").format(new Date(repeaterDirectoryActivity2.getSharedPreferences("repeater_cache", 0).getLong("last_update_time", 0L))), 1).show();
                                        break;
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    public final void n(Location location) {
        if (this.f5699o) {
            return;
        }
        this.f5696k = location;
        m(location.getLatitude(), location.getLongitude());
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setSystemUiVisibility(4098);
        setContentView(R.layout.activity_repeater_directory);
        this.f5692e = (TextView) findViewById(R.id.locationText);
        this.f5693f = (TextView) findViewById(R.id.gridSquareText);
        this.f5691d = (RecyclerView) findViewById(R.id.repeaterList);
        this.g = (AppCompatButton) findViewById(R.id.addRepeaterButton);
        this.f5691d.setLayoutManager(new LinearLayoutManager(1));
        final int i5 = 0;
        this.g.setOnClickListener(new View.OnClickListener(this) { // from class: f3.j0

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ RepeaterDirectoryActivity f6732d;

            {
                this.f6732d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepeaterDirectoryActivity repeaterDirectoryActivity = this.f6732d;
                switch (i5) {
                    case 0:
                        int i6 = RepeaterDirectoryActivity.f5689s;
                        repeaterDirectoryActivity.getClass();
                        Toast.makeText(repeaterDirectoryActivity, "Add Repeater functionality coming soon!", 0).show();
                        break;
                    default:
                        int i7 = RepeaterDirectoryActivity.f5689s;
                        repeaterDirectoryActivity.getClass();
                        L.h hVar = new L.h(repeaterDirectoryActivity);
                        boolean z4 = repeaterDirectoryActivity.f5699o;
                        C0467d c0467d = (C0467d) hVar.f1522d;
                        if (!z4) {
                            c0467d.f6292d = "Location Options";
                            c0467d.f6294f = "Currently using GPS location. Would you like to enter coordinates manually?";
                            hVar.e("Enter Coordinates", new i0(repeaterDirectoryActivity, 2));
                            hVar.c("Keep GPS", new DialogInterfaceOnClickListenerC0516g(5));
                            hVar.f();
                            break;
                        } else {
                            c0467d.f6292d = "Location Options";
                            c0467d.f6294f = "Current location is manually set. What would you like to do?";
                            hVar.e("Use GPS Location", new i0(repeaterDirectoryActivity, 0));
                            i0 i0Var = new i0(repeaterDirectoryActivity, 1);
                            c0467d.f6297k = "Enter New Coordinates";
                            c0467d.f6298l = i0Var;
                            hVar.c("Cancel", new DialogInterfaceOnClickListenerC0516g(4));
                            hVar.f();
                            break;
                        }
                }
            }
        });
        final int i6 = 1;
        this.f5692e.setOnClickListener(new View.OnClickListener(this) { // from class: f3.j0

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ RepeaterDirectoryActivity f6732d;

            {
                this.f6732d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepeaterDirectoryActivity repeaterDirectoryActivity = this.f6732d;
                switch (i6) {
                    case 0:
                        int i62 = RepeaterDirectoryActivity.f5689s;
                        repeaterDirectoryActivity.getClass();
                        Toast.makeText(repeaterDirectoryActivity, "Add Repeater functionality coming soon!", 0).show();
                        break;
                    default:
                        int i7 = RepeaterDirectoryActivity.f5689s;
                        repeaterDirectoryActivity.getClass();
                        L.h hVar = new L.h(repeaterDirectoryActivity);
                        boolean z4 = repeaterDirectoryActivity.f5699o;
                        C0467d c0467d = (C0467d) hVar.f1522d;
                        if (!z4) {
                            c0467d.f6292d = "Location Options";
                            c0467d.f6294f = "Currently using GPS location. Would you like to enter coordinates manually?";
                            hVar.e("Enter Coordinates", new i0(repeaterDirectoryActivity, 2));
                            hVar.c("Keep GPS", new DialogInterfaceOnClickListenerC0516g(5));
                            hVar.f();
                            break;
                        } else {
                            c0467d.f6292d = "Location Options";
                            c0467d.f6294f = "Current location is manually set. What would you like to do?";
                            hVar.e("Use GPS Location", new i0(repeaterDirectoryActivity, 0));
                            i0 i0Var = new i0(repeaterDirectoryActivity, 1);
                            c0467d.f6297k = "Enter New Coordinates";
                            c0467d.f6298l = i0Var;
                            hVar.c("Cancel", new DialogInterfaceOnClickListenerC0516g(4));
                            hVar.f();
                            break;
                        }
                }
            }
        });
        this.f5690c = (LocationManager) getSystemService("location");
        this.f5698m = new Handler(Looper.getMainLooper());
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
        for (int i7 = 0; i7 < 2; i7++) {
            if (C.h.a(this, strArr[i7]) != 0) {
                e.d(this, strArr, 100);
                return;
            }
        }
        startLocationUpdates();
    }

    @Override // f.AbstractActivityC0472i, androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onDestroy() {
        l0 l0Var;
        super.onDestroy();
        LocationManager locationManager = this.f5690c;
        if (locationManager != null && (l0Var = this.f5702r) != null) {
            locationManager.removeUpdates(l0Var);
        }
        this.f5698m.removeCallbacksAndMessages(null);
        j();
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i5, strArr, iArr);
        if (i5 == 100) {
            if (iArr.length > 0 && iArr[0] == 0) {
                startLocationUpdates();
                return;
            }
            if (!shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")) {
                Toast.makeText(this, "Location permission required for nearby repeaters", 1).show();
                finish();
                return;
            }
            h hVar = new h(this);
            C0467d c0467d = (C0467d) hVar.f1522d;
            c0467d.f6292d = "Location Permission Required";
            c0467d.f6294f = "This app needs location permission to find nearby repeaters. Please grant the permission in Settings.";
            hVar.e("Settings", new i0(this, 3));
            hVar.c("Cancel", new i0(this, 4));
            hVar.b().show();
        }
    }

    public final void startLocationUpdates() {
        DialogC0469f dialogC0469f;
        try {
            if (C.h.a(this, "android.permission.ACCESS_FINE_LOCATION") == 0 && C.h.a(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                if (!this.f5690c.isProviderEnabled("gps") && !this.f5690c.isProviderEnabled("network")) {
                    l();
                    return;
                }
                if (!this.f5699o && ((dialogC0469f = this.n) == null || !dialogC0469f.isShowing())) {
                    h hVar = new h(this);
                    C0467d c0467d = (C0467d) hVar.f1522d;
                    c0467d.f6292d = "Getting Location";
                    c0467d.f6294f = "Waiting for GPS signal...";
                    c0467d.f6299m = false;
                    DialogC0469f dialogC0469fB = hVar.b();
                    this.n = dialogC0469fB;
                    dialogC0469fB.show();
                }
                this.f5698m.postDelayed(new g0(this, 0), 30000L);
                this.f5697l = true;
                Location lastKnownLocation = null;
                try {
                    lastKnownLocation = this.f5690c.getLastKnownLocation("gps");
                    if (lastKnownLocation == null) {
                        lastKnownLocation = this.f5690c.getLastKnownLocation("network");
                    }
                } catch (SecurityException e5) {
                    Log.e("RepeaterDirectory", "Error getting last known location", e5);
                }
                if (lastKnownLocation != null && !this.f5699o && System.currentTimeMillis() - lastKnownLocation.getTime() < 300000) {
                    n(lastKnownLocation);
                }
                boolean zIsProviderEnabled = this.f5690c.isProviderEnabled("gps");
                l0 l0Var = this.f5702r;
                if (zIsProviderEnabled) {
                    this.f5690c.requestLocationUpdates("gps", 1000L, 10.0f, l0Var);
                }
                if (this.f5690c.isProviderEnabled("network")) {
                    this.f5690c.requestLocationUpdates("network", 1000L, 10.0f, l0Var);
                }
            }
        } catch (SecurityException e6) {
            Log.e("RepeaterDirectory", "Error starting location updates", e6);
            j();
            Toast.makeText(this, "Location permission required", 0).show();
        }
    }
}
