package com.unified.ur1.radioteams;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.R;
import com.unified.ur1.SatelliteTracker.h;
import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.radioteams.RadioTeamsActivity;
import d4.b;
import e3.C0451e;
import e3.C0452f;
import e3.C0454h;
import e4.a;
import f.AbstractActivityC0472i;
import f3.C0513e;
import f3.DialogInterfaceOnClickListenerC0517h;
import g0.AbstractC0535a;
import g4.e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import k3.RunnableC0691i0;
import k4.d;
import l3.C0747e;
import l3.C0749g;
import l3.InterfaceC0748f;
import l3.RunnableC0743a;
import l3.RunnableC0744b;
import l3.ViewOnLongClickListenerC0746d;
import l4.f;
import m4.l;
import org.conscrypt.PSKKeyManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public class RadioTeamsActivity extends AbstractActivityC0472i {

    /* renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f6010u = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6011c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6012d = false;

    /* renamed from: e, reason: collision with root package name */
    public l f6013e;

    /* renamed from: f, reason: collision with root package name */
    public MapView f6014f;
    public b g;
    public Button h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f6015i;

    /* renamed from: j, reason: collision with root package name */
    public ListView f6016j;

    /* renamed from: k, reason: collision with root package name */
    public String f6017k;

    /* renamed from: l, reason: collision with root package name */
    public String f6018l;

    /* renamed from: m, reason: collision with root package name */
    public String f6019m;
    public JSONObject n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f6020o;

    /* renamed from: p, reason: collision with root package name */
    public C0454h f6021p;

    /* renamed from: q, reason: collision with root package name */
    public HashMap f6022q;

    /* renamed from: r, reason: collision with root package name */
    public ExecutorService f6023r;

    /* renamed from: s, reason: collision with root package name */
    public Handler f6024s;

    /* renamed from: t, reason: collision with root package name */
    public RunnableC0691i0 f6025t;

    public static String m(Spinner spinner) {
        Object selectedItem = spinner.getSelectedItem();
        return selectedItem != null ? selectedItem.toString() : "";
    }

    public static String n(Spinner spinner) {
        String strM = m(spinner);
        if (strM == null || strM.isEmpty()) {
            return null;
        }
        return strM.toLowerCase().replace(" ", "-").replace("&", "").replace("/", "-").replace("(", "").replace(")", "").trim();
    }

    public static void r(CheckBox checkBox, JSONArray jSONArray, String str) {
        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
            try {
                if (str.equals(jSONArray.getString(i5))) {
                    checkBox.setChecked(true);
                    return;
                }
            } catch (JSONException e5) {
                Log.e("RadioTeamsActivity", "Error setting checkbox from array", e5);
                return;
            }
        }
    }

    public static void t(Spinner spinner, String str) {
        if (str.isEmpty()) {
            return;
        }
        ArrayAdapter arrayAdapter = (ArrayAdapter) spinner.getAdapter();
        for (int i5 = 0; i5 < arrayAdapter.getCount(); i5++) {
            String str2 = (String) arrayAdapter.getItem(i5);
            if (str2 != null && str2.toLowerCase().replace(" ", "-").equals(str.toLowerCase())) {
                spinner.setSelection(i5);
                return;
            }
        }
    }

    public final void j(d dVar) {
        if (this.f6022q.containsKey("USER_LOCATION")) {
            this.f6014f.getOverlays().remove(this.f6022q.get("USER_LOCATION"));
        }
        m4.d dVar2 = new m4.d(this.f6014f);
        dVar2.i(dVar);
        dVar2.f8675b = "My Location - " + this.f6019m;
        dVar2.f8676c = "Your current position";
        dVar2.g = 0.5f;
        dVar2.h = 1.0f;
        dVar2.h(k(this.f6019m, false, true));
        this.f6014f.getOverlays().add(dVar2);
        this.f6022q.put("USER_LOCATION", dVar2);
        this.f6011c = true;
        this.f6014f.invalidate();
    }

    public final BitmapDrawable k(String str, boolean z4, boolean z5) {
        int length = (str.length() * 20) + 40;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(length, 80, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        int i5 = z4 ? -1096636 : z5 ? -12877066 : -15681151;
        Paint paint = new Paint();
        paint.setColor(i5);
        paint.setAntiAlias(true);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Paint paint2 = new Paint();
        paint2.setColor(-1);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(6.0f);
        Paint paint3 = new Paint();
        paint3.setColor(-1);
        paint3.setAntiAlias(true);
        paint3.setTextAlign(Paint.Align.CENTER);
        paint3.setTextSize(28.0f);
        paint3.setTypeface(Typeface.DEFAULT_BOLD);
        Paint paint4 = new Paint();
        paint4.setColor(1711276032);
        paint4.setAntiAlias(true);
        paint4.setStyle(style);
        canvas.drawRoundRect(new RectF(4.0f, 4.0f, r0 + 36, 60), 20.0f, 20.0f, paint4);
        float f5 = length;
        RectF rectF = new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f5, 56);
        canvas.drawRoundRect(rectF, 20.0f, 20.0f, paint);
        canvas.drawRoundRect(rectF, 20.0f, 20.0f, paint2);
        canvas.drawText(str, f5 / 2.0f, (paint3.getTextSize() / 3.0f) + 28, paint3);
        return new BitmapDrawable(getResources(), bitmapCreateBitmap);
    }

    public final void l() {
        if (this.g == null) {
            Log.e("RadioTeamsActivity", "Map controller not initialized");
            return;
        }
        if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
            requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1001);
            return;
        }
        LocationManager locationManager = (LocationManager) getSystemService("location");
        if (locationManager == null) {
            Log.e("RadioTeamsActivity", "LocationManager is null");
            Toast.makeText(this, "Location services not available", 0).show();
            return;
        }
        try {
            boolean zIsProviderEnabled = locationManager.isProviderEnabled("gps");
            boolean zIsProviderEnabled2 = locationManager.isProviderEnabled("network");
            Location lastKnownLocation = zIsProviderEnabled ? locationManager.getLastKnownLocation("gps") : null;
            if (lastKnownLocation == null && zIsProviderEnabled2) {
                lastKnownLocation = locationManager.getLastKnownLocation("network");
            }
            if (lastKnownLocation == null) {
                lastKnownLocation = locationManager.getLastKnownLocation("passive");
            }
            if (lastKnownLocation == null || lastKnownLocation.getLatitude() == 0.0d || lastKnownLocation.getLongitude() == 0.0d) {
                q();
                return;
            }
            d dVar = new d(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            ((f) this.g).c(dVar);
            ((f) this.g).d(15.0d);
            j(dVar);
        } catch (SecurityException e5) {
            Log.e("RadioTeamsActivity", "Location permission denied", e5);
            Toast.makeText(this, "Location permission denied", 0).show();
        } catch (Exception e6) {
            Log.e("RadioTeamsActivity", "Error getting location", e6);
            Toast.makeText(this, "Error getting location", 0).show();
        }
    }

    public final void o(String str, String str2, InterfaceC0748f interfaceC0748f) {
        Log.d("RadioTeamsActivity", "Attempting login - TeamID: " + str + ", Callsign: " + str2);
        this.f6023r.execute(new RunnableC0744b(this, str, str2, getSharedPreferences("app_settings", 0).getString("auth_code_1", null), interfaceC0748f, 1));
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.g().f6223a = getPackageName();
        setContentView(R.layout.activity_radio_teams);
        this.h = (Button) findViewById(R.id.btnEditProfile);
        this.f6015i = (TextView) findViewById(R.id.tvTeamInfo);
        this.f6016j = (ListView) findViewById(R.id.lvTeamMembers);
        this.f6020o = new ArrayList();
        this.f6022q = new HashMap();
        C0454h c0454h = new C0454h(this, 0, this.f6020o, 3);
        this.f6021p = c0454h;
        this.f6016j.setAdapter((ListAdapter) c0454h);
        final int i5 = 0;
        this.h.setOnClickListener(new View.OnClickListener(this) { // from class: l3.c

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ RadioTeamsActivity f8401d;

            {
                this.f8401d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RadioTeamsActivity radioTeamsActivity = this.f8401d;
                switch (i5) {
                    case 0:
                        int i6 = RadioTeamsActivity.f6010u;
                        radioTeamsActivity.v();
                        break;
                    case 1:
                        int i7 = RadioTeamsActivity.f6010u;
                        radioTeamsActivity.l();
                        break;
                    case 2:
                        int i8 = RadioTeamsActivity.f6010u;
                        radioTeamsActivity.f6023r.execute(new RunnableC0743a(radioTeamsActivity, 4));
                        Toast.makeText(radioTeamsActivity, "Refreshing team data...", 0).show();
                        break;
                    default:
                        int i9 = RadioTeamsActivity.f6010u;
                        radioTeamsActivity.getClass();
                        Intent intent = new Intent(radioTeamsActivity, (Class<?>) ChatActivity.class);
                        intent.putExtra("team_id", radioTeamsActivity.f6018l);
                        intent.putExtra("team_name", radioTeamsActivity.f6018l);
                        radioTeamsActivity.startActivity(intent);
                        break;
                }
            }
        });
        this.f6016j.setOnItemClickListener(new C0451e(this, 1));
        final int i6 = 1;
        findViewById(R.id.btnMyLocation).setOnClickListener(new View.OnClickListener(this) { // from class: l3.c

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ RadioTeamsActivity f8401d;

            {
                this.f8401d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RadioTeamsActivity radioTeamsActivity = this.f8401d;
                switch (i6) {
                    case 0:
                        int i62 = RadioTeamsActivity.f6010u;
                        radioTeamsActivity.v();
                        break;
                    case 1:
                        int i7 = RadioTeamsActivity.f6010u;
                        radioTeamsActivity.l();
                        break;
                    case 2:
                        int i8 = RadioTeamsActivity.f6010u;
                        radioTeamsActivity.f6023r.execute(new RunnableC0743a(radioTeamsActivity, 4));
                        Toast.makeText(radioTeamsActivity, "Refreshing team data...", 0).show();
                        break;
                    default:
                        int i9 = RadioTeamsActivity.f6010u;
                        radioTeamsActivity.getClass();
                        Intent intent = new Intent(radioTeamsActivity, (Class<?>) ChatActivity.class);
                        intent.putExtra("team_id", radioTeamsActivity.f6018l);
                        intent.putExtra("team_name", radioTeamsActivity.f6018l);
                        radioTeamsActivity.startActivity(intent);
                        break;
                }
            }
        });
        final int i7 = 2;
        findViewById(R.id.btnRefresh).setOnClickListener(new View.OnClickListener(this) { // from class: l3.c

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ RadioTeamsActivity f8401d;

            {
                this.f8401d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RadioTeamsActivity radioTeamsActivity = this.f8401d;
                switch (i7) {
                    case 0:
                        int i62 = RadioTeamsActivity.f6010u;
                        radioTeamsActivity.v();
                        break;
                    case 1:
                        int i72 = RadioTeamsActivity.f6010u;
                        radioTeamsActivity.l();
                        break;
                    case 2:
                        int i8 = RadioTeamsActivity.f6010u;
                        radioTeamsActivity.f6023r.execute(new RunnableC0743a(radioTeamsActivity, 4));
                        Toast.makeText(radioTeamsActivity, "Refreshing team data...", 0).show();
                        break;
                    default:
                        int i9 = RadioTeamsActivity.f6010u;
                        radioTeamsActivity.getClass();
                        Intent intent = new Intent(radioTeamsActivity, (Class<?>) ChatActivity.class);
                        intent.putExtra("team_id", radioTeamsActivity.f6018l);
                        intent.putExtra("team_name", radioTeamsActivity.f6018l);
                        radioTeamsActivity.startActivity(intent);
                        break;
                }
            }
        });
        findViewById(R.id.btnRefresh).setOnLongClickListener(new ViewOnLongClickListenerC0746d(this, 0));
        final int i8 = 3;
        ((Button) findViewById(R.id.btnSendGroupMessage)).setOnClickListener(new View.OnClickListener(this) { // from class: l3.c

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ RadioTeamsActivity f8401d;

            {
                this.f8401d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RadioTeamsActivity radioTeamsActivity = this.f8401d;
                switch (i8) {
                    case 0:
                        int i62 = RadioTeamsActivity.f6010u;
                        radioTeamsActivity.v();
                        break;
                    case 1:
                        int i72 = RadioTeamsActivity.f6010u;
                        radioTeamsActivity.l();
                        break;
                    case 2:
                        int i82 = RadioTeamsActivity.f6010u;
                        radioTeamsActivity.f6023r.execute(new RunnableC0743a(radioTeamsActivity, 4));
                        Toast.makeText(radioTeamsActivity, "Refreshing team data...", 0).show();
                        break;
                    default:
                        int i9 = RadioTeamsActivity.f6010u;
                        radioTeamsActivity.getClass();
                        Intent intent = new Intent(radioTeamsActivity, (Class<?>) ChatActivity.class);
                        intent.putExtra("team_id", radioTeamsActivity.f6018l);
                        intent.putExtra("team_name", radioTeamsActivity.f6018l);
                        radioTeamsActivity.startActivity(intent);
                        break;
                }
            }
        });
        findViewById(R.id.btnMyLocation).setOnLongClickListener(new ViewOnLongClickListenerC0746d(this, 1));
        SharedPreferences sharedPreferences = getSharedPreferences("RadioTeamsPrefs", 0);
        this.f6017k = sharedPreferences.getString("session_token", null);
        this.f6018l = sharedPreferences.getString("team_id", null);
        String string = sharedPreferences.getString("callsign", null);
        this.f6019m = string;
        String str = this.f6018l;
        if (str != null && string != null) {
            this.f6015i.setText("Team: " + str + " | Call: " + string);
        }
        MapView mapView = (MapView) findViewById(R.id.mapView);
        this.f6014f = mapView;
        mapView.setTileSource(i4.f.f7375a);
        this.f6014f.setMultiTouchControls(true);
        b controller = this.f6014f.getController();
        this.g = controller;
        ((f) controller).d(4.0d);
        d dVar = new d(39.8283d, -98.5795d);
        ((f) this.g).c(dVar);
        try {
            C0747e c0747e = new C0747e("CountyBoundaries", 1, 18, PSKKeyManager.MAX_KEY_LENGTH_BYTES, ".png", new String[]{"https://server.arcgisonline.com/ArcGIS/rest/services/Reference/World_Boundaries_and_Places/MapServer/tile/"}, 2);
            e eVar = new e(getApplicationContext(), i4.f.f7376b);
            eVar.g(c0747e);
            getApplicationContext();
            l lVar = new l(eVar, true, true);
            this.f6013e = lVar;
            if (lVar.g != 0) {
                lVar.g = 0;
                BitmapDrawable bitmapDrawable = lVar.f8698f;
                lVar.f8698f = null;
                g4.a.f7035c.a(bitmapDrawable);
            }
            l lVar2 = this.f6013e;
            if (lVar2.h != 0) {
                lVar2.h = 0;
                BitmapDrawable bitmapDrawable2 = lVar2.f8698f;
                lVar2.f8698f = null;
                g4.a.f7035c.a(bitmapDrawable2);
            }
            this.f6014f.getOverlays().add(this.f6013e);
        } catch (Exception e5) {
            Log.e("RadioTeamsActivity", "Error creating county overlay", e5);
        }
        Log.d("RadioTeamsActivity", "Map initialized with center: " + dVar.f8265k + "," + dVar.f8264j);
        this.f6023r = Executors.newFixedThreadPool(2);
        Handler handler = new Handler(Looper.getMainLooper());
        this.f6024s = handler;
        RunnableC0691i0 runnableC0691i0 = new RunnableC0691i0(5, this);
        this.f6025t = runnableC0691i0;
        handler.postDelayed(runnableC0691i0, 15000L);
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.navigationBars());
                insetsController.setSystemBarsBehavior(2);
            }
        } else {
            getWindow().getDecorView().setSystemUiVisibility(4102);
        }
        l();
        if (this.f6017k != null) {
            this.f6023r.execute(new RunnableC0743a(this, 0));
            this.f6023r.execute(new RunnableC0743a(this, 4));
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.d("RadioTeamsActivity", "No launch parameters found");
            return;
        }
        String string2 = extras.getString("team_id");
        String string3 = extras.getString("callsign");
        String string4 = extras.getString("session_token");
        boolean z4 = extras.getBoolean("auto_login", false);
        if (string2 == null) {
            Log.e("RadioTeamsActivity", "team_id is null");
            Toast.makeText(this, "Team ID is missing", 1).show();
            finish();
        } else if (string3 == null) {
            Log.e("RadioTeamsActivity", "callsign is null");
            Toast.makeText(this, "Callsign is missing", 1).show();
            finish();
        } else if (string4 != null) {
            Log.d("RadioTeamsActivity", "Using provided session token");
            s(string4, string2, string3);
        } else if (!z4) {
            Log.d("RadioTeamsActivity", "No auto-login parameters provided");
        } else {
            Log.d("RadioTeamsActivity", "Starting auto-login process...");
            o(string2, string3, new C0513e((Object) this, (Object) string3, string2));
        }
    }

    @Override // f.AbstractActivityC0472i, androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        RunnableC0691i0 runnableC0691i0 = this.f6025t;
        if (runnableC0691i0 != null) {
            this.f6024s.removeCallbacks(runnableC0691i0);
        }
        ExecutorService executorService = this.f6023r;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onPause() {
        super.onPause();
        MapView mapView = this.f6014f;
        if (mapView != null) {
            mapView.c();
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i5, strArr, iArr);
        StringBuilder sbF = h.f("Permission result: requestCode=", i5, ", grantResults.length=");
        sbF.append(iArr.length);
        Log.d("RadioTeamsActivity", sbF.toString());
        if (i5 == 1001) {
            if (iArr.length > 0 && iArr[0] == 0) {
                Log.d("RadioTeamsActivity", "Location permission granted, getting location...");
                Toast.makeText(this, "Location permission granted", 0).show();
                l();
            } else {
                Log.w("RadioTeamsActivity", "Location permission denied");
                Toast.makeText(this, "Location permission denied. Using default location.", 1).show();
                ((f) this.g).c(new d(39.8283d, -98.5795d));
                ((f) this.g).d(4.0d);
            }
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onResume() {
        super.onResume();
        MapView mapView = this.f6014f;
        if (mapView != null) {
            mapView.d();
        }
    }

    public final String p(String str, String str2, JSONObject jSONObject) throws IOException {
        String string;
        if (!"GET".equals(str) || str2 == null) {
            string = "https://team.unifiedradios.com/api.php";
        } else {
            StringBuilder sbM = AbstractC0535a.m("https://team.unifiedradios.com/api.php?action=", str2, "&session_token=");
            sbM.append(this.f6017k);
            string = sbM.toString();
        }
        if (jSONObject != null) {
            Log.d("RadioTeamsActivity", "Request data: " + jSONObject.toString());
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string).openConnection();
        httpURLConnection.setRequestMethod(str);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        if ("POST".equals(str) && jSONObject != null) {
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                byte[] bytes = jSONObject.toString().getBytes("utf-8");
                outputStream.write(bytes, 0, bytes.length);
                outputStream.close();
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        int responseCode = httpURLConnection.getResponseCode();
        InputStream errorStream = (responseCode < 200 || responseCode >= 300) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, "utf-8"));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return sb.toString();
                }
                sb.append(line.trim());
            } catch (Throwable th3) {
                try {
                    bufferedReader.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
                throw th3;
            }
        }
    }

    public final void q() {
        Log.d("RadioTeamsActivity", "Requesting location updates...");
        LocationManager locationManager = (LocationManager) getSystemService("location");
        C0452f c0452f = new C0452f(this, locationManager, 1);
        try {
            if (locationManager.isProviderEnabled("gps")) {
                Log.d("RadioTeamsActivity", "Requesting GPS updates...");
                locationManager.requestLocationUpdates("gps", 1000L, 1.0f, c0452f);
            }
            if (locationManager.isProviderEnabled("network")) {
                Log.d("RadioTeamsActivity", "Requesting Network updates...");
                locationManager.requestLocationUpdates("network", 1000L, 1.0f, c0452f);
            }
            if (locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network")) {
                return;
            }
            Log.w("RadioTeamsActivity", "No location providers enabled");
            Toast.makeText(this, "Please enable location services", 1).show();
            ((f) this.g).c(new d(39.8283d, -98.5795d));
            ((f) this.g).d(4.0d);
        } catch (SecurityException e5) {
            Log.e("RadioTeamsActivity", "Location permission denied for updates", e5);
        }
    }

    public final void s(String str, String str2, String str3) {
        this.f6017k = str;
        this.f6018l = str2;
        this.f6019m = str3;
        getSharedPreferences("RadioTeamsPrefs", 0).edit().putString("session_token", str).putString("team_id", str2).putString("callsign", str3).apply();
        this.f6015i.setText("Team: " + str2 + " | Call: " + str3);
        this.f6023r.execute(new RunnableC0743a(this, 0));
        this.f6023r.execute(new RunnableC0743a(this, 4));
    }

    public final void u(C0749g c0749g) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.dialog_member_profile, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tvMemberCallsign);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tvMemberStatus);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tvMemberRole);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tvMemberOrganization);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.tvMemberVehicle);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.tvMemberSupplies);
        TextView textView7 = (TextView) viewInflate.findViewById(R.id.tvMemberSkills);
        textView.setText(c0749g.f8404a);
        textView2.setText(c0749g.b());
        String str = c0749g.g;
        if (str == null) {
            str = "Not specified";
        }
        textView3.setText(str);
        String str2 = c0749g.h;
        if (str2 == null) {
            str2 = "Not specified";
        }
        textView4.setText(str2);
        String str3 = c0749g.f8410i;
        if (str3 == null) {
            str3 = "Not specified";
        }
        textView5.setText(str3);
        String str4 = c0749g.f8411j;
        textView6.setText(str4 != null ? str4 : "Not specified");
        StringBuilder sb = new StringBuilder();
        JSONArray jSONArray = c0749g.f8412k;
        if (jSONArray == null || jSONArray.length() <= 0) {
            sb.append("None specified");
        } else {
            for (int i5 = 0; i5 < c0749g.f8412k.length(); i5++) {
                try {
                    if (i5 > 0) {
                        sb.append(", ");
                    }
                    sb.append(c0749g.f8412k.getString(i5));
                } catch (JSONException unused) {
                    sb.append("Error loading skills");
                }
            }
        }
        textView7.setText(sb.toString());
        builder.setView(viewInflate).setTitle(c0749g.f8404a + " - Profile").setPositiveButton("Close", (DialogInterface.OnClickListener) null);
        if (c0749g.c()) {
            builder.setNeutralButton("Show on Map", new DialogInterfaceOnClickListenerC0517h(this, 8, c0749g));
        }
        builder.show();
    }

    public final void v() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.dialog_profile_edit, (ViewGroup) null);
        Spinner spinner = (Spinner) viewInflate.findViewById(R.id.spinnerPrimaryRole);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"", "Search & Rescue", "Medical", "Damage Assessment", "Communications", "Logistics", "Traffic Control", "Other"});
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        Spinner spinner2 = (Spinner) viewInflate.findViewById(R.id.spinnerOrganization);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"", "EMA", "EMS", "Fire Rescue", "Law Enforcement", "None"});
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapter2);
        Spinner spinner3 = (Spinner) viewInflate.findViewById(R.id.spinnerPPELevel);
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"", "Full PPE", "Basic PPE", "No PPE"});
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter((SpinnerAdapter) arrayAdapter3);
        Spinner spinner4 = (Spinner) viewInflate.findViewById(R.id.spinnerVehicleType);
        ArrayAdapter arrayAdapter4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"", "4x4 Truck", "SUV", "ATV/UTV", "Boat", "On Foot"});
        arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter((SpinnerAdapter) arrayAdapter4);
        Spinner spinner5 = (Spinner) viewInflate.findViewById(R.id.spinnerHasMedication);
        ArrayAdapter arrayAdapter5 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"No", "Yes"});
        arrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter((SpinnerAdapter) arrayAdapter5);
        Spinner spinner6 = (Spinner) viewInflate.findViewById(R.id.spinnerMedicalLimitations);
        ArrayAdapter arrayAdapter6 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"", "Mobility Issues", "Vision Impaired", "Hearing Impaired", "Severe Allergies", "Other"});
        arrayAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter((SpinnerAdapter) arrayAdapter6);
        Spinner spinner7 = (Spinner) viewInflate.findViewById(R.id.spinnerHasExtraFuel);
        ArrayAdapter arrayAdapter7 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"", "Gasoline", "Diesel", "Propane", "Mixed Types"});
        arrayAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter((SpinnerAdapter) arrayAdapter7);
        Spinner spinner8 = (Spinner) viewInflate.findViewById(R.id.spinnerFuelAmount);
        ArrayAdapter arrayAdapter8 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"", "1-5 gallons", "6-20 gallons", "20+ gallons"});
        arrayAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner8.setAdapter((SpinnerAdapter) arrayAdapter8);
        Spinner spinner9 = (Spinner) viewInflate.findViewById(R.id.spinnerSupplyDays);
        ArrayAdapter arrayAdapter9 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"", "Less than 1 day", "1-2 days", "3+ days"});
        arrayAdapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner9.setAdapter((SpinnerAdapter) arrayAdapter9);
        Spinner spinner10 = (Spinner) viewInflate.findViewById(R.id.spinnerFCCLicense);
        ArrayAdapter arrayAdapter10 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"", "Technician", "General", "Amateur Extra"});
        arrayAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner10.setAdapter((SpinnerAdapter) arrayAdapter10);
        Spinner spinner11 = (Spinner) viewInflate.findViewById(R.id.spinnerARESStatus);
        ArrayAdapter arrayAdapter11 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"", "Active Member", "Leadership"});
        arrayAdapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner11.setAdapter((SpinnerAdapter) arrayAdapter11);
        Spinner spinner12 = (Spinner) viewInflate.findViewById(R.id.spinnerSkywarnStatus);
        ArrayAdapter arrayAdapter12 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"", "Basic", "Advanced"});
        arrayAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner12.setAdapter((SpinnerAdapter) arrayAdapter12);
        Spinner spinner13 = (Spinner) viewInflate.findViewById(R.id.spinnerGROL);
        ArrayAdapter arrayAdapter13 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"No", "Yes"});
        arrayAdapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner13.setAdapter((SpinnerAdapter) arrayAdapter13);
        Spinner spinner14 = (Spinner) viewInflate.findViewById(R.id.spinnerRACES);
        ArrayAdapter arrayAdapter14 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"No", "Yes"});
        arrayAdapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner14.setAdapter((SpinnerAdapter) arrayAdapter14);
        Spinner spinner15 = (Spinner) viewInflate.findViewById(R.id.spinnerAUXCOMM);
        ArrayAdapter arrayAdapter15 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"No", "Yes"});
        arrayAdapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner15.setAdapter((SpinnerAdapter) arrayAdapter15);
        JSONObject jSONObject = this.n;
        if (jSONObject != null) {
            try {
                int[] iArr = {R.id.cbChainsaw, R.id.cbHandTools, R.id.cbFirstAid, R.id.cbAED, R.id.cbRopeRescue, R.id.cbGenerator, R.id.cbWaterBottles, R.id.cbWaterBulk, R.id.cbWaterPurification, R.id.cbWaterStorage, R.id.cbFoodMREs, R.id.cbFoodCanned, R.id.cbFoodDry, R.id.cbFoodCooking, R.id.cbFoodBulk, R.id.cbShelterTarps, R.id.cbShelterTents, R.id.cbShelterSleeping, R.id.cbShelterBlankets, R.id.cbShelterPortable, R.id.cbSatellitePhone, R.id.cbSatelliteMessenger, R.id.cbCellularBooster, R.id.cbCBRadio, R.id.cbGMRS, R.id.cbInternetBackup, R.id.cbVHFRadio, R.id.cbUHFRadio, R.id.cbHFRadio, R.id.cbEC001, R.id.cbEC016, R.id.cbIS100, R.id.cbIS200, R.id.cbIS700, R.id.cbIS800, R.id.cbWinlink, R.id.cbAPRS, R.id.cbHFDigital, R.id.cbDMR, R.id.cbSatellite, R.id.cbMesh, R.id.cbMicrowave, R.id.cbAntennaModeling};
                for (int i5 = 0; i5 < 43; i5++) {
                    CheckBox checkBox = (CheckBox) viewInflate.findViewById(iArr[i5]);
                    if (checkBox != null) {
                        checkBox.setChecked(false);
                    }
                }
                t((Spinner) viewInflate.findViewById(R.id.spinnerPrimaryRole), jSONObject.optString("primary_role", ""));
                t((Spinner) viewInflate.findViewById(R.id.spinnerOrganization), jSONObject.optString("organization", ""));
                t((Spinner) viewInflate.findViewById(R.id.spinnerPPELevel), jSONObject.optString("ppe_level", ""));
                t((Spinner) viewInflate.findViewById(R.id.spinnerVehicleType), jSONObject.optString("vehicle_type", ""));
                t((Spinner) viewInflate.findViewById(R.id.spinnerSupplyDays), jSONObject.optString("supply_days", ""));
                t((Spinner) viewInflate.findViewById(R.id.spinnerFCCLicense), jSONObject.optString("fcc_license", ""));
                t((Spinner) viewInflate.findViewById(R.id.spinnerARESStatus), jSONObject.optString("ares_status", ""));
                t((Spinner) viewInflate.findViewById(R.id.spinnerSkywarnStatus), jSONObject.optString("skywarn_status", ""));
                t((Spinner) viewInflate.findViewById(R.id.spinnerHasExtraFuel), jSONObject.optString("has_extra_fuel", ""));
                t((Spinner) viewInflate.findViewById(R.id.spinnerFuelAmount), jSONObject.optString("fuel_amount", ""));
                t((Spinner) viewInflate.findViewById(R.id.spinnerMedicalLimitations), jSONObject.optString("medical_limitations", ""));
                t((Spinner) viewInflate.findViewById(R.id.spinnerHasMedication), jSONObject.optInt("has_medication", 0) == 1 ? "Yes" : "No");
                t((Spinner) viewInflate.findViewById(R.id.spinnerGROL), jSONObject.optInt("grol_license", 0) == 1 ? "Yes" : "No");
                t((Spinner) viewInflate.findViewById(R.id.spinnerRACES), jSONObject.optInt("races_status", 0) == 1 ? "Yes" : "No");
                t((Spinner) viewInflate.findViewById(R.id.spinnerAUXCOMM), jSONObject.optInt("auxcomm_status", 0) == 1 ? "Yes" : "No");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tools_gear");
                if (jSONArrayOptJSONArray != null) {
                    r((CheckBox) viewInflate.findViewById(R.id.cbChainsaw), jSONArrayOptJSONArray, "chainsaw");
                    r((CheckBox) viewInflate.findViewById(R.id.cbHandTools), jSONArrayOptJSONArray, "hand-tools");
                    r((CheckBox) viewInflate.findViewById(R.id.cbFirstAid), jSONArrayOptJSONArray, "first-aid");
                    r((CheckBox) viewInflate.findViewById(R.id.cbAED), jSONArrayOptJSONArray, "aed");
                    r((CheckBox) viewInflate.findViewById(R.id.cbRopeRescue), jSONArrayOptJSONArray, "rope-rescue");
                    r((CheckBox) viewInflate.findViewById(R.id.cbGenerator), jSONArrayOptJSONArray, "generator");
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("alt_communication");
                if (jSONArrayOptJSONArray2 != null) {
                    r((CheckBox) viewInflate.findViewById(R.id.cbSatellitePhone), jSONArrayOptJSONArray2, "satellite-phone");
                    r((CheckBox) viewInflate.findViewById(R.id.cbSatelliteMessenger), jSONArrayOptJSONArray2, "satellite-messenger");
                    r((CheckBox) viewInflate.findViewById(R.id.cbCellularBooster), jSONArrayOptJSONArray2, "cellular-booster");
                    r((CheckBox) viewInflate.findViewById(R.id.cbCBRadio), jSONArrayOptJSONArray2, "cb-radio");
                    r((CheckBox) viewInflate.findViewById(R.id.cbGMRS), jSONArrayOptJSONArray2, "gmrs");
                    r((CheckBox) viewInflate.findViewById(R.id.cbInternetBackup), jSONArrayOptJSONArray2, "internet-backup");
                    r((CheckBox) viewInflate.findViewById(R.id.cbVHFRadio), jSONArrayOptJSONArray2, "vhf-radio");
                    r((CheckBox) viewInflate.findViewById(R.id.cbUHFRadio), jSONArrayOptJSONArray2, "uhf-radio");
                    r((CheckBox) viewInflate.findViewById(R.id.cbHFRadio), jSONArrayOptJSONArray2, "hf-radio");
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("water_supplies");
                if (jSONArrayOptJSONArray3 != null) {
                    r((CheckBox) viewInflate.findViewById(R.id.cbWaterBottles), jSONArrayOptJSONArray3, "bottles");
                    r((CheckBox) viewInflate.findViewById(R.id.cbWaterBulk), jSONArrayOptJSONArray3, "bulk-containers");
                    r((CheckBox) viewInflate.findViewById(R.id.cbWaterPurification), jSONArrayOptJSONArray3, "purification");
                    r((CheckBox) viewInflate.findViewById(R.id.cbWaterStorage), jSONArrayOptJSONArray3, "storage-tanks");
                }
                JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("food_supplies");
                if (jSONArrayOptJSONArray4 != null) {
                    r((CheckBox) viewInflate.findViewById(R.id.cbFoodMREs), jSONArrayOptJSONArray4, "mres");
                    r((CheckBox) viewInflate.findViewById(R.id.cbFoodCanned), jSONArrayOptJSONArray4, "canned-goods");
                    r((CheckBox) viewInflate.findViewById(R.id.cbFoodDry), jSONArrayOptJSONArray4, "dry-goods");
                    r((CheckBox) viewInflate.findViewById(R.id.cbFoodCooking), jSONArrayOptJSONArray4, "cooking-supplies");
                    r((CheckBox) viewInflate.findViewById(R.id.cbFoodBulk), jSONArrayOptJSONArray4, "bulk-food");
                }
                JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("shelter_supplies");
                if (jSONArrayOptJSONArray5 != null) {
                    r((CheckBox) viewInflate.findViewById(R.id.cbShelterTarps), jSONArrayOptJSONArray5, "tarps");
                    r((CheckBox) viewInflate.findViewById(R.id.cbShelterTents), jSONArrayOptJSONArray5, "tents");
                    r((CheckBox) viewInflate.findViewById(R.id.cbShelterSleeping), jSONArrayOptJSONArray5, "sleeping-gear");
                    r((CheckBox) viewInflate.findViewById(R.id.cbShelterBlankets), jSONArrayOptJSONArray5, "blankets");
                    r((CheckBox) viewInflate.findViewById(R.id.cbShelterPortable), jSONArrayOptJSONArray5, "portable-shelter");
                }
                JSONArray jSONArrayOptJSONArray6 = jSONObject.optJSONArray("emcomm_training");
                if (jSONArrayOptJSONArray6 != null) {
                    r((CheckBox) viewInflate.findViewById(R.id.cbEC001), jSONArrayOptJSONArray6, "ec001");
                    r((CheckBox) viewInflate.findViewById(R.id.cbEC016), jSONArrayOptJSONArray6, "ec016");
                    r((CheckBox) viewInflate.findViewById(R.id.cbIS100), jSONArrayOptJSONArray6, "is100");
                    r((CheckBox) viewInflate.findViewById(R.id.cbIS200), jSONArrayOptJSONArray6, "is200");
                    r((CheckBox) viewInflate.findViewById(R.id.cbIS700), jSONArrayOptJSONArray6, "is700");
                    r((CheckBox) viewInflate.findViewById(R.id.cbIS800), jSONArrayOptJSONArray6, "is800");
                }
                JSONArray jSONArrayOptJSONArray7 = jSONObject.optJSONArray("specialized_skills");
                if (jSONArrayOptJSONArray7 != null) {
                    r((CheckBox) viewInflate.findViewById(R.id.cbWinlink), jSONArrayOptJSONArray7, "winlink");
                    r((CheckBox) viewInflate.findViewById(R.id.cbAPRS), jSONArrayOptJSONArray7, "aprs");
                    r((CheckBox) viewInflate.findViewById(R.id.cbHFDigital), jSONArrayOptJSONArray7, "hf-digital");
                    r((CheckBox) viewInflate.findViewById(R.id.cbDMR), jSONArrayOptJSONArray7, "dmr");
                    r((CheckBox) viewInflate.findViewById(R.id.cbSatellite), jSONArrayOptJSONArray7, "satellite");
                    r((CheckBox) viewInflate.findViewById(R.id.cbMesh), jSONArrayOptJSONArray7, "mesh");
                    r((CheckBox) viewInflate.findViewById(R.id.cbMicrowave), jSONArrayOptJSONArray7, "microwave");
                    r((CheckBox) viewInflate.findViewById(R.id.cbAntennaModeling), jSONArrayOptJSONArray7, "antenna-modeling");
                }
            } catch (Exception e5) {
                Log.e("RadioTeamsActivity", "Error populating profile form", e5);
            }
        }
        builder.setView(viewInflate).setTitle("Edit Responder Profile").setPositiveButton("Save", new DialogInterfaceOnClickListenerC0517h(this, 9, viewInflate)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }
}
