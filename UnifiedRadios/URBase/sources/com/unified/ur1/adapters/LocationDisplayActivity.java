package com.unified.ur1.adapters;

import B0.l;
import C.h;
import C0.e;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.R;
import com.unified.ur1.adapters.LocationDisplayActivity;
import f.AbstractActivityC0472i;
import f3.C0529u;
import f3.C0531w;
import f3.r;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public class LocationDisplayActivity extends AbstractActivityC0472i {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f5669q = 0;

    /* renamed from: c, reason: collision with root package name */
    public C0531w f5670c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f5671d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f5672e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f5673f;
    public TextView g;
    public TextView h;

    /* renamed from: i, reason: collision with root package name */
    public Button f5674i;

    /* renamed from: j, reason: collision with root package name */
    public Button f5675j;

    /* renamed from: k, reason: collision with root package name */
    public ProgressBar f5676k;

    /* renamed from: l, reason: collision with root package name */
    public LocationManager f5677l;

    /* renamed from: m, reason: collision with root package name */
    public r f5678m;
    public Handler n;

    /* renamed from: o, reason: collision with root package name */
    public e f5679o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f5680p = false;

    public final void j(C0529u c0529u) {
        String str = c0529u.f6797a;
        if (str == null || str.isEmpty()) {
            this.f5671d.setText("Address not available");
        } else {
            this.f5671d.setText(c0529u.f6797a);
        }
        String str2 = c0529u.h;
        if (str2 == null || str2.isEmpty()) {
            this.f5672e.setText("Intersection not available");
        } else {
            this.f5672e.setText(c0529u.h);
        }
        double d5 = c0529u.f6804j;
        if (d5 == 0.0d && c0529u.f6805k == 0.0d) {
            this.f5673f.setText("Coordinates not available");
        } else {
            this.f5673f.setText(String.format(Locale.US, "%.6f, %.6f", Double.valueOf(d5), Double.valueOf(c0529u.f6805k)));
        }
        String str3 = c0529u.f6806l;
        if (str3 == null || str3.isEmpty()) {
            this.g.setText("USNG not available");
        } else {
            this.g.setText(c0529u.f6806l);
        }
        String str4 = c0529u.f6807m;
        if (str4 == null || str4.isEmpty()) {
            this.h.setText("Grid not available");
        } else {
            this.h.setText(c0529u.f6807m);
        }
    }

    public final void k() {
        if (this.f5677l == null) {
            Toast.makeText(this, "Location manager not available", 0).show();
            return;
        }
        if (h.a(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            B.e.d(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1001);
            return;
        }
        p();
        this.f5680p = true;
        o(true);
        Toast.makeText(this, "Getting fresh location...", 0).show();
        Log.d("LocationDisplayActivity", "Requesting fresh location update");
        this.f5678m = new r(this, 0);
        e eVar = new e(14, this);
        this.f5679o = eVar;
        this.n.postDelayed(eVar, 30000L);
        try {
            if (this.f5677l.isProviderEnabled("gps")) {
                this.f5677l.requestLocationUpdates("gps", 0L, BitmapDescriptorFactory.HUE_RED, this.f5678m);
                Log.d("LocationDisplayActivity", "Requested GPS location updates");
            } else {
                r();
            }
        } catch (SecurityException e5) {
            Log.e("LocationDisplayActivity", "Security exception requesting location", e5);
            l("Location access denied");
        }
    }

    public final void l(String str) {
        this.f5680p = false;
        o(false);
        Log.e("LocationDisplayActivity", "Location error: " + str);
        Toast.makeText(this, "" + str, 1).show();
    }

    public final void m() {
        C0531w c0531w = this.f5670c;
        C0529u c0529u = new C0529u();
        SharedPreferences sharedPreferences = c0531w.f6816b;
        c0529u.f6797a = sharedPreferences.getString("current_address", "");
        c0529u.f6798b = sharedPreferences.getString("street_number", null);
        c0529u.f6799c = sharedPreferences.getString("street_name", null);
        c0529u.f6800d = sharedPreferences.getString("city", null);
        c0529u.f6801e = sharedPreferences.getString("state", null);
        c0529u.f6802f = sharedPreferences.getString("zip_code", null);
        c0529u.g = sharedPreferences.getString("country", null);
        c0529u.h = sharedPreferences.getString("closest_intersection", "");
        c0529u.f6803i = sharedPreferences.getFloat("intersection_distance", BitmapDescriptorFactory.HUE_RED);
        c0529u.f6804j = sharedPreferences.getFloat("last_latitude", BitmapDescriptorFactory.HUE_RED);
        c0529u.f6805k = sharedPreferences.getFloat("last_longitude", BitmapDescriptorFactory.HUE_RED);
        c0529u.f6806l = sharedPreferences.getString("usng_coordinates", "");
        c0529u.f6807m = sharedPreferences.getString("maidenhead_grid", "");
        j(c0529u);
    }

    public final void n(final double d5, final double d6) {
        Log.d("LocationDisplayActivity", String.format("Resolving location info for: %.6f, %.6f", Double.valueOf(d5), Double.valueOf(d6)));
        final C0531w c0531w = this.f5670c;
        final l lVar = new l(13, this);
        c0531w.getClass();
        new Thread(new Runnable() { // from class: f3.s
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                double d7 = d5;
                double d8 = d6;
                B0.l lVar2 = lVar;
                C0531w c0531w2 = c0531w;
                Handler handler = c0531w2.f6818d;
                try {
                    C0529u c0529u = new C0529u();
                    c0529u.f6804j = d7;
                    c0529u.f6805k = d8;
                    c0529u.f6806l = C0531w.d(d7, d8);
                    c0529u.f6807m = C0531w.c(d7, d8);
                    if (c0531w2.k(d7, d8, c0529u)) {
                        Log.d("LocationService", "Successfully used Android Geocoder");
                    } else {
                        if (!c0531w2.l(d7, d8, c0529u)) {
                            throw new Exception("Both geocoding services failed");
                        }
                        Log.d("LocationService", "Successfully used Nominatim Geocoder");
                    }
                    c0531w2.f(d7, d8, c0529u);
                    c0531w2.j(c0529u);
                    handler.post(new D.m(lVar2, 17, c0529u));
                } catch (Exception e5) {
                    Log.e("LocationService", "Error getting location info", e5);
                    handler.post(new D.m(lVar2, 18, e5));
                }
            }
        }).start();
    }

    public final void o(boolean z4) {
        this.f5676k.setVisibility(z4 ? 0 : 8);
        this.f5674i.setEnabled(!z4);
        if (z4) {
            this.f5674i.setText("Getting Location...");
        } else {
            this.f5674i.setText("Refresh Location");
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_location_display);
        C0531w c0531w = new C0531w();
        c0531w.f6815a = this;
        c0531w.f6816b = getSharedPreferences("location_prefs", 0);
        c0531w.f6818d = new Handler(Looper.getMainLooper());
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        c0531w.f6817c = builder.connectTimeout(15L, timeUnit).readTimeout(15L, timeUnit).build();
        this.f5670c = c0531w;
        this.f5677l = (LocationManager) getSystemService("location");
        this.n = new Handler(Looper.getMainLooper());
        this.f5671d = (TextView) findViewById(R.id.address_text);
        this.f5672e = (TextView) findViewById(R.id.intersection_text);
        this.f5673f = (TextView) findViewById(R.id.coordinates_text);
        this.g = (TextView) findViewById(R.id.usng_text);
        this.h = (TextView) findViewById(R.id.maidenhead_grid_text);
        this.f5674i = (Button) findViewById(R.id.refresh_button);
        this.f5675j = (Button) findViewById(R.id.clear_button);
        this.f5676k = (ProgressBar) findViewById(R.id.progress_bar);
        final int i5 = 0;
        this.f5674i.setOnClickListener(new View.OnClickListener(this) { // from class: f3.q

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ LocationDisplayActivity f6783d;

            {
                this.f6783d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i5) {
                    case 0:
                        LocationDisplayActivity locationDisplayActivity = this.f6783d;
                        if (!locationDisplayActivity.f5680p) {
                            if (C.h.a(locationDisplayActivity, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                                B.e.d(locationDisplayActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1001);
                                break;
                            } else {
                                locationDisplayActivity.k();
                                break;
                            }
                        } else {
                            Toast.makeText(locationDisplayActivity, "Already getting location...", 0).show();
                            break;
                        }
                    default:
                        LocationDisplayActivity locationDisplayActivity2 = this.f6783d;
                        locationDisplayActivity2.f5670c.f6816b.edit().clear().apply();
                        Log.d("LocationService", "Location data cleared");
                        locationDisplayActivity2.m();
                        Toast.makeText(locationDisplayActivity2, "Location data cleared", 0).show();
                        break;
                }
            }
        });
        final int i6 = 1;
        this.f5675j.setOnClickListener(new View.OnClickListener(this) { // from class: f3.q

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ LocationDisplayActivity f6783d;

            {
                this.f6783d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i6) {
                    case 0:
                        LocationDisplayActivity locationDisplayActivity = this.f6783d;
                        if (!locationDisplayActivity.f5680p) {
                            if (C.h.a(locationDisplayActivity, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                                B.e.d(locationDisplayActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1001);
                                break;
                            } else {
                                locationDisplayActivity.k();
                                break;
                            }
                        } else {
                            Toast.makeText(locationDisplayActivity, "Already getting location...", 0).show();
                            break;
                        }
                    default:
                        LocationDisplayActivity locationDisplayActivity2 = this.f6783d;
                        locationDisplayActivity2.f5670c.f6816b.edit().clear().apply();
                        Log.d("LocationService", "Location data cleared");
                        locationDisplayActivity2.m();
                        Toast.makeText(locationDisplayActivity2, "Location data cleared", 0).show();
                        break;
                }
            }
        });
        m();
    }

    @Override // f.AbstractActivityC0472i, androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onDestroy() {
        OkHttpClient okHttpClient;
        super.onDestroy();
        p();
        C0531w c0531w = this.f5670c;
        if (c0531w == null || (okHttpClient = c0531w.f6817c) == null) {
            return;
        }
        okHttpClient.dispatcher().executorService().shutdown();
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onPause() {
        super.onPause();
        p();
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i5, strArr, iArr);
        if (i5 == 1001) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, "Location permission is required", 1).show();
            } else {
                k();
            }
        }
    }

    public final void p() {
        r rVar;
        LocationManager locationManager = this.f5677l;
        if (locationManager != null && (rVar = this.f5678m) != null) {
            try {
                locationManager.removeUpdates(rVar);
                Log.d("LocationDisplayActivity", "Stopped location updates");
            } catch (SecurityException e5) {
                Log.e("LocationDisplayActivity", "Security exception stopping location updates", e5);
            }
        }
        this.f5678m = null;
        e eVar = this.f5679o;
        if (eVar != null) {
            this.n.removeCallbacks(eVar);
            this.f5679o = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q() {
        /*
            r7 = this;
            java.lang.String r0 = "Trying last known location as fallback"
            java.lang.String r1 = "LocationDisplayActivity"
            android.util.Log.d(r1, r0)
            java.lang.String r0 = "android.permission.ACCESS_FINE_LOCATION"
            int r0 = C.h.a(r7, r0)
            if (r0 == 0) goto L15
            java.lang.String r0 = "Location permission not granted"
            r7.l(r0)
            return
        L15:
            android.location.LocationManager r0 = r7.f5677l     // Catch: java.lang.SecurityException -> L36
            java.lang.String r2 = "gps"
            android.location.Location r0 = r0.getLastKnownLocation(r2)     // Catch: java.lang.SecurityException -> L36
            android.location.LocationManager r2 = r7.f5677l     // Catch: java.lang.SecurityException -> L36
            java.lang.String r3 = "network"
            android.location.Location r2 = r2.getLastKnownLocation(r3)     // Catch: java.lang.SecurityException -> L36
            if (r0 == 0) goto L38
            if (r2 == 0) goto L38
            long r3 = r0.getTime()     // Catch: java.lang.SecurityException -> L36
            long r5 = r2.getTime()     // Catch: java.lang.SecurityException -> L36
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L3d
            goto L40
        L36:
            r0 = move-exception
            goto L7c
        L38:
            if (r0 == 0) goto L3b
            goto L40
        L3b:
            if (r2 == 0) goto L3f
        L3d:
            r0 = r2
            goto L40
        L3f:
            r0 = 0
        L40:
            if (r0 == 0) goto L76
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.SecurityException -> L36
            long r4 = r0.getTime()     // Catch: java.lang.SecurityException -> L36
            long r2 = r2 - r4
            java.lang.String r4 = "Using fallback location (age: %d minutes)"
            r5 = 60000(0xea60, double:2.9644E-319)
            long r2 = r2 / r5
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.SecurityException -> L36
            java.lang.Object[] r2 = new java.lang.Object[]{r2}     // Catch: java.lang.SecurityException -> L36
            java.lang.String r2 = java.lang.String.format(r4, r2)     // Catch: java.lang.SecurityException -> L36
            android.util.Log.d(r1, r2)     // Catch: java.lang.SecurityException -> L36
            java.lang.String r2 = "Using cached location (fresh location unavailable)"
            r3 = 1
            android.widget.Toast r2 = android.widget.Toast.makeText(r7, r2, r3)     // Catch: java.lang.SecurityException -> L36
            r2.show()     // Catch: java.lang.SecurityException -> L36
            double r2 = r0.getLatitude()     // Catch: java.lang.SecurityException -> L36
            double r4 = r0.getLongitude()     // Catch: java.lang.SecurityException -> L36
            r7.n(r2, r4)     // Catch: java.lang.SecurityException -> L36
            goto L86
        L76:
            java.lang.String r0 = "No location data available. Please ensure GPS/Location is enabled."
            r7.l(r0)     // Catch: java.lang.SecurityException -> L36
            goto L86
        L7c:
            java.lang.String r2 = "Security exception getting last known location"
            android.util.Log.e(r1, r2, r0)
            java.lang.String r0 = "Location access denied"
            r7.l(r0)
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unified.ur1.adapters.LocationDisplayActivity.q():void");
    }

    public final void r() {
        LocationManager locationManager = this.f5677l;
        if (locationManager == null || this.f5678m == null) {
            return;
        }
        try {
            if (locationManager.isProviderEnabled("network")) {
                this.f5677l.requestLocationUpdates("network", 0L, BitmapDescriptorFactory.HUE_RED, this.f5678m);
                Log.d("LocationDisplayActivity", "Requested Network location updates");
            } else {
                Log.w("LocationDisplayActivity", "No location providers available");
                q();
            }
        } catch (SecurityException e5) {
            Log.e("LocationDisplayActivity", "Security exception with network provider", e5);
            q();
        }
    }
}
