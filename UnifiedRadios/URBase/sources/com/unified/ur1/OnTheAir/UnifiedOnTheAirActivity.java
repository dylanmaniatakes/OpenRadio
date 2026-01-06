package com.unified.ur1.OnTheAir;

import C0.A;
import X2.C0202f;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.OnTheAir.UnifiedOnTheAirActivity;
import com.unified.ur1.R;
import com.unified.ur1.SatelliteTracker.h;
import com.unified.ur1.chat.ChatActivity;
import d4.a;
import d4.b;
import e3.C0451e;
import e3.C0452f;
import e3.C0453g;
import e3.C0454h;
import e3.RunnableC0448b;
import f.AbstractActivityC0472i;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import k4.d;
import l3.ViewOnLongClickListenerC0746d;
import l4.f;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public class UnifiedOnTheAirActivity extends AbstractActivityC0472i {

    /* renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f5557u = 0;

    /* renamed from: e, reason: collision with root package name */
    public MapView f5560e;

    /* renamed from: f, reason: collision with root package name */
    public b f5561f;
    public TextView g;
    public ListView h;

    /* renamed from: i, reason: collision with root package name */
    public Button f5562i;

    /* renamed from: j, reason: collision with root package name */
    public Switch f5563j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f5564k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f5565l;

    /* renamed from: m, reason: collision with root package name */
    public C0454h f5566m;
    public HashMap n;

    /* renamed from: o, reason: collision with root package name */
    public ExecutorService f5567o;

    /* renamed from: p, reason: collision with root package name */
    public Handler f5568p;

    /* renamed from: q, reason: collision with root package name */
    public A f5569q;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5558c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5559d = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f5570r = false;

    /* renamed from: s, reason: collision with root package name */
    public String f5571s = "all";

    /* renamed from: t, reason: collision with root package name */
    public String f5572t = "48h";

    public static String o() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://ur1.unifiedradios.com/api-teams/unified_api_php.php?action=get_unified_users&hours=48").openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
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
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public final void j(d dVar) {
        if (this.n.containsKey("MY_LOCATION")) {
            this.f5560e.getOverlays().remove(this.n.get("MY_LOCATION"));
        }
        m4.d dVar2 = new m4.d(this.f5560e);
        dVar2.i(dVar);
        dVar2.f8675b = "My Location";
        dVar2.f8676c = "Your current position";
        dVar2.g = 0.5f;
        dVar2.h = 1.0f;
        dVar2.h(m("YOU", true, false, true));
        this.f5560e.getOverlays().add(dVar2);
        this.n.put("MY_LOCATION", dVar2);
        this.f5558c = true;
        this.f5560e.invalidate();
    }

    public final void k() {
        long millis;
        this.f5565l.clear();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = this.f5572t;
        str.getClass();
        switch (str) {
            case "1h":
                millis = TimeUnit.HOURS.toMillis(1L);
                break;
            case "6h":
                millis = TimeUnit.HOURS.toMillis(6L);
                break;
            case "24h":
                millis = TimeUnit.HOURS.toMillis(24L);
                break;
            case "48h":
                millis = TimeUnit.HOURS.toMillis(48L);
                break;
            default:
                millis = TimeUnit.HOURS.toMillis(48L);
                break;
        }
        long j5 = jCurrentTimeMillis - millis;
        Iterator it = this.f5564k.iterator();
        while (it.hasNext()) {
            C0453g c0453g = (C0453g) it.next();
            if (c0453g.f6219i >= j5 && (this.f5570r || c0453g.e())) {
                if (this.f5571s.equals("all") || c0453g.g(this.f5571s)) {
                    if (!c0453g.f6220j) {
                        this.f5565l.add(c0453g);
                    }
                }
            }
        }
        this.f5566m.notifyDataSetChanged();
    }

    public final void l() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f5565l.iterator();
        while (it.hasNext()) {
            C0453g c0453g = (C0453g) it.next();
            if (c0453g.d()) {
                arrayList.add(new d(c0453g.g, c0453g.h));
            }
        }
        if (this.n.containsKey("MY_LOCATION")) {
            arrayList.add(((m4.d) this.n.get("MY_LOCATION")).f8665f);
        }
        if (arrayList.isEmpty()) {
            Toast.makeText(this, "No users with location data to display", 0).show();
            return;
        }
        if (arrayList.size() == 1) {
            ((f) this.f5561f).c((a) arrayList.get(0));
            ((f) this.f5561f).d(15.0d);
        } else {
            Iterator it2 = arrayList.iterator();
            double dMax = Double.MIN_VALUE;
            double dMin = Double.MAX_VALUE;
            double dMin2 = Double.MAX_VALUE;
            double dMax2 = Double.MIN_VALUE;
            while (it2.hasNext()) {
                d dVar = (d) it2.next();
                dMin = Math.min(dMin, dVar.f8265k);
                dMax = Math.max(dMax, dVar.f8265k);
                dMin2 = Math.min(dMin2, dVar.f8264j);
                dMax2 = Math.max(dMax2, dVar.f8264j);
            }
            ((f) this.f5561f).c(new d((dMin + dMax) / 2.0d, (dMin2 + dMax2) / 2.0d));
            double dMax3 = Math.max(dMax - dMin, dMax2 - dMin2);
            double d5 = 10.0d;
            if (dMax3 > 10.0d) {
                d5 = 3.0d;
            } else if (dMax3 > 5.0d) {
                d5 = 4.0d;
            } else if (dMax3 > 1.0d) {
                d5 = 6.0d;
            } else if (dMax3 <= 0.1d) {
                d5 = dMax3 > 0.01d ? 12.0d : dMax3 > 0.001d ? 14.0d : 16.0d;
            }
            ((f) this.f5561f).d(d5);
        }
        this.f5558c = true;
        this.f5560e.invalidate();
    }

    public final BitmapDrawable m(String str, boolean z4, boolean z5, boolean z6) {
        int iMax = Math.max((str.length() * 16) + 32, 80);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, 60, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        int i5 = z4 ? -12877066 : (z5 && z6) ? -15681151 : z5 ? -680437 : -9735552;
        Paint paint = new Paint();
        paint.setColor(i5);
        paint.setAntiAlias(true);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Paint paint2 = new Paint();
        paint2.setColor(-1);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(4.0f);
        Paint paint3 = new Paint();
        paint3.setColor(-1);
        paint3.setAntiAlias(true);
        paint3.setTextAlign(Paint.Align.CENTER);
        paint3.setTextSize(20.0f);
        paint3.setTypeface(Typeface.DEFAULT_BOLD);
        Paint paint4 = new Paint();
        paint4.setColor(-2013265920);
        paint4.setAntiAlias(true);
        paint4.setStyle(style);
        canvas.drawRoundRect(new RectF(3.0f, 3.0f, iMax - 3, 42), 15.0f, 15.0f, paint4);
        float f5 = iMax;
        RectF rectF = new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f5, 40);
        canvas.drawRoundRect(rectF, 15.0f, 15.0f, paint);
        canvas.drawRoundRect(rectF, 15.0f, 15.0f, paint2);
        canvas.drawText(str, f5 / 2.0f, (paint3.getTextSize() / 3.0f) + 20, paint3);
        Paint paint5 = new Paint();
        paint5.setAntiAlias(true);
        paint5.setStyle(style);
        if (z4) {
            paint5.setColor(-1);
        } else if (z5 && z6) {
            paint5.setColor(-16711936);
        } else if (z5) {
            paint5.setColor(-256);
        } else {
            paint5.setColor(-8355712);
        }
        canvas.drawCircle(iMax - 10, 10.0f, 5.0f, paint5);
        return new BitmapDrawable(getResources(), bitmapCreateBitmap);
    }

    public final void n() {
        if (this.f5561f == null) {
            Log.e("UnifiedOnTheAir", "Map controller not initialized");
            return;
        }
        if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
            requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1001);
            return;
        }
        LocationManager locationManager = (LocationManager) getSystemService("location");
        if (locationManager == null) {
            Log.e("UnifiedOnTheAir", "LocationManager is null");
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
                p();
                return;
            }
            d dVar = new d(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            ((f) this.f5561f).c(dVar);
            ((f) this.f5561f).d(15.0d);
            j(dVar);
        } catch (SecurityException e5) {
            Log.e("UnifiedOnTheAir", "Location permission denied", e5);
            Toast.makeText(this, "Location permission denied", 0).show();
        } catch (Exception e6) {
            Log.e("UnifiedOnTheAir", "Error getting location", e6);
            Toast.makeText(this, "Error getting location", 0).show();
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e4.a.g().f6223a = getPackageName();
        setContentView(R.layout.activity_unified_on_the_air);
        this.g = (TextView) findViewById(R.id.tvStats);
        this.h = (ListView) findViewById(R.id.lvActiveUsers);
        this.f5562i = (Button) findViewById(R.id.btnFilterOptions);
        this.f5563j = (Switch) findViewById(R.id.switchShowOffline);
        this.f5564k = new ArrayList();
        this.f5565l = new ArrayList();
        this.n = new HashMap();
        C0454h c0454h = new C0454h(this, 0, this.f5565l, 0);
        this.f5566m = c0454h;
        this.h.setAdapter((ListAdapter) c0454h);
        final int i5 = 0;
        this.f5562i.setOnClickListener(new View.OnClickListener(this) { // from class: e3.d

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ UnifiedOnTheAirActivity f6207d;

            {
                this.f6207d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UnifiedOnTheAirActivity unifiedOnTheAirActivity = this.f6207d;
                switch (i5) {
                    case 0:
                        int i6 = UnifiedOnTheAirActivity.f5557u;
                        UnifiedOnTheAirActivity unifiedOnTheAirActivity2 = this.f6207d;
                        unifiedOnTheAirActivity2.getClass();
                        AlertDialog.Builder builder = new AlertDialog.Builder(unifiedOnTheAirActivity2);
                        View viewInflate = LayoutInflater.from(unifiedOnTheAirActivity2).inflate(R.layout.dialog_filter_options, (ViewGroup) null);
                        Spinner spinner = (Spinner) viewInflate.findViewById(R.id.spinnerTimeFilter);
                        ArrayAdapter arrayAdapter = new ArrayAdapter(unifiedOnTheAirActivity2, android.R.layout.simple_spinner_item, new String[]{"1 Hour", "6 Hours", "24 Hours", "48 Hours"});
                        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
                        String[] strArr = {"1h", "6h", "24h", "48h"};
                        int i7 = 0;
                        while (true) {
                            if (i7 < 4) {
                                if (strArr[i7].equals(unifiedOnTheAirActivity2.f5572t)) {
                                    spinner.setSelection(i7);
                                } else {
                                    i7++;
                                }
                            }
                        }
                        Spinner spinner2 = (Spinner) viewInflate.findViewById(R.id.spinnerLocationFilter);
                        ArrayAdapter arrayAdapter2 = new ArrayAdapter(unifiedOnTheAirActivity2, android.R.layout.simple_spinner_item, new String[]{"All Locations", "USA", "Canada", "International"});
                        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner2.setAdapter((SpinnerAdapter) arrayAdapter2);
                        String[] strArr2 = {"all", "usa", "canada", "international"};
                        int i8 = 0;
                        while (true) {
                            if (i8 < 4) {
                                if (strArr2[i8].equals(unifiedOnTheAirActivity2.f5571s)) {
                                    spinner2.setSelection(i8);
                                } else {
                                    i8++;
                                }
                            }
                        }
                        builder.setView(viewInflate).setTitle("Filter Options").setPositiveButton("Apply", new DialogInterfaceOnClickListenerC0447a(unifiedOnTheAirActivity2, strArr, spinner, strArr2, spinner2)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
                        break;
                    case 1:
                        int i9 = UnifiedOnTheAirActivity.f5557u;
                        unifiedOnTheAirActivity.n();
                        break;
                    case 2:
                        int i10 = UnifiedOnTheAirActivity.f5557u;
                        unifiedOnTheAirActivity.f5567o.execute(new RunnableC0448b(unifiedOnTheAirActivity, 2));
                        Toast.makeText(unifiedOnTheAirActivity, "Refreshing user data...", 0).show();
                        break;
                    default:
                        int i11 = UnifiedOnTheAirActivity.f5557u;
                        unifiedOnTheAirActivity.l();
                        Toast.makeText(unifiedOnTheAirActivity, "Showing all active users", 0).show();
                        break;
                }
            }
        });
        this.f5563j.setOnCheckedChangeListener(new Z1.a(1, this));
        this.h.setOnItemClickListener(new C0451e(this, 0));
        final int i6 = 1;
        findViewById(R.id.btnMyLocation).setOnClickListener(new View.OnClickListener(this) { // from class: e3.d

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ UnifiedOnTheAirActivity f6207d;

            {
                this.f6207d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UnifiedOnTheAirActivity unifiedOnTheAirActivity = this.f6207d;
                switch (i6) {
                    case 0:
                        int i62 = UnifiedOnTheAirActivity.f5557u;
                        UnifiedOnTheAirActivity unifiedOnTheAirActivity2 = this.f6207d;
                        unifiedOnTheAirActivity2.getClass();
                        AlertDialog.Builder builder = new AlertDialog.Builder(unifiedOnTheAirActivity2);
                        View viewInflate = LayoutInflater.from(unifiedOnTheAirActivity2).inflate(R.layout.dialog_filter_options, (ViewGroup) null);
                        Spinner spinner = (Spinner) viewInflate.findViewById(R.id.spinnerTimeFilter);
                        ArrayAdapter arrayAdapter = new ArrayAdapter(unifiedOnTheAirActivity2, android.R.layout.simple_spinner_item, new String[]{"1 Hour", "6 Hours", "24 Hours", "48 Hours"});
                        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
                        String[] strArr = {"1h", "6h", "24h", "48h"};
                        int i7 = 0;
                        while (true) {
                            if (i7 < 4) {
                                if (strArr[i7].equals(unifiedOnTheAirActivity2.f5572t)) {
                                    spinner.setSelection(i7);
                                } else {
                                    i7++;
                                }
                            }
                        }
                        Spinner spinner2 = (Spinner) viewInflate.findViewById(R.id.spinnerLocationFilter);
                        ArrayAdapter arrayAdapter2 = new ArrayAdapter(unifiedOnTheAirActivity2, android.R.layout.simple_spinner_item, new String[]{"All Locations", "USA", "Canada", "International"});
                        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner2.setAdapter((SpinnerAdapter) arrayAdapter2);
                        String[] strArr2 = {"all", "usa", "canada", "international"};
                        int i8 = 0;
                        while (true) {
                            if (i8 < 4) {
                                if (strArr2[i8].equals(unifiedOnTheAirActivity2.f5571s)) {
                                    spinner2.setSelection(i8);
                                } else {
                                    i8++;
                                }
                            }
                        }
                        builder.setView(viewInflate).setTitle("Filter Options").setPositiveButton("Apply", new DialogInterfaceOnClickListenerC0447a(unifiedOnTheAirActivity2, strArr, spinner, strArr2, spinner2)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
                        break;
                    case 1:
                        int i9 = UnifiedOnTheAirActivity.f5557u;
                        unifiedOnTheAirActivity.n();
                        break;
                    case 2:
                        int i10 = UnifiedOnTheAirActivity.f5557u;
                        unifiedOnTheAirActivity.f5567o.execute(new RunnableC0448b(unifiedOnTheAirActivity, 2));
                        Toast.makeText(unifiedOnTheAirActivity, "Refreshing user data...", 0).show();
                        break;
                    default:
                        int i11 = UnifiedOnTheAirActivity.f5557u;
                        unifiedOnTheAirActivity.l();
                        Toast.makeText(unifiedOnTheAirActivity, "Showing all active users", 0).show();
                        break;
                }
            }
        });
        final int i7 = 2;
        findViewById(R.id.btnRefresh).setOnClickListener(new View.OnClickListener(this) { // from class: e3.d

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ UnifiedOnTheAirActivity f6207d;

            {
                this.f6207d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UnifiedOnTheAirActivity unifiedOnTheAirActivity = this.f6207d;
                switch (i7) {
                    case 0:
                        int i62 = UnifiedOnTheAirActivity.f5557u;
                        UnifiedOnTheAirActivity unifiedOnTheAirActivity2 = this.f6207d;
                        unifiedOnTheAirActivity2.getClass();
                        AlertDialog.Builder builder = new AlertDialog.Builder(unifiedOnTheAirActivity2);
                        View viewInflate = LayoutInflater.from(unifiedOnTheAirActivity2).inflate(R.layout.dialog_filter_options, (ViewGroup) null);
                        Spinner spinner = (Spinner) viewInflate.findViewById(R.id.spinnerTimeFilter);
                        ArrayAdapter arrayAdapter = new ArrayAdapter(unifiedOnTheAirActivity2, android.R.layout.simple_spinner_item, new String[]{"1 Hour", "6 Hours", "24 Hours", "48 Hours"});
                        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
                        String[] strArr = {"1h", "6h", "24h", "48h"};
                        int i72 = 0;
                        while (true) {
                            if (i72 < 4) {
                                if (strArr[i72].equals(unifiedOnTheAirActivity2.f5572t)) {
                                    spinner.setSelection(i72);
                                } else {
                                    i72++;
                                }
                            }
                        }
                        Spinner spinner2 = (Spinner) viewInflate.findViewById(R.id.spinnerLocationFilter);
                        ArrayAdapter arrayAdapter2 = new ArrayAdapter(unifiedOnTheAirActivity2, android.R.layout.simple_spinner_item, new String[]{"All Locations", "USA", "Canada", "International"});
                        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner2.setAdapter((SpinnerAdapter) arrayAdapter2);
                        String[] strArr2 = {"all", "usa", "canada", "international"};
                        int i8 = 0;
                        while (true) {
                            if (i8 < 4) {
                                if (strArr2[i8].equals(unifiedOnTheAirActivity2.f5571s)) {
                                    spinner2.setSelection(i8);
                                } else {
                                    i8++;
                                }
                            }
                        }
                        builder.setView(viewInflate).setTitle("Filter Options").setPositiveButton("Apply", new DialogInterfaceOnClickListenerC0447a(unifiedOnTheAirActivity2, strArr, spinner, strArr2, spinner2)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
                        break;
                    case 1:
                        int i9 = UnifiedOnTheAirActivity.f5557u;
                        unifiedOnTheAirActivity.n();
                        break;
                    case 2:
                        int i10 = UnifiedOnTheAirActivity.f5557u;
                        unifiedOnTheAirActivity.f5567o.execute(new RunnableC0448b(unifiedOnTheAirActivity, 2));
                        Toast.makeText(unifiedOnTheAirActivity, "Refreshing user data...", 0).show();
                        break;
                    default:
                        int i11 = UnifiedOnTheAirActivity.f5557u;
                        unifiedOnTheAirActivity.l();
                        Toast.makeText(unifiedOnTheAirActivity, "Showing all active users", 0).show();
                        break;
                }
            }
        });
        final int i8 = 3;
        findViewById(R.id.btnShowAll).setOnClickListener(new View.OnClickListener(this) { // from class: e3.d

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ UnifiedOnTheAirActivity f6207d;

            {
                this.f6207d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UnifiedOnTheAirActivity unifiedOnTheAirActivity = this.f6207d;
                switch (i8) {
                    case 0:
                        int i62 = UnifiedOnTheAirActivity.f5557u;
                        UnifiedOnTheAirActivity unifiedOnTheAirActivity2 = this.f6207d;
                        unifiedOnTheAirActivity2.getClass();
                        AlertDialog.Builder builder = new AlertDialog.Builder(unifiedOnTheAirActivity2);
                        View viewInflate = LayoutInflater.from(unifiedOnTheAirActivity2).inflate(R.layout.dialog_filter_options, (ViewGroup) null);
                        Spinner spinner = (Spinner) viewInflate.findViewById(R.id.spinnerTimeFilter);
                        ArrayAdapter arrayAdapter = new ArrayAdapter(unifiedOnTheAirActivity2, android.R.layout.simple_spinner_item, new String[]{"1 Hour", "6 Hours", "24 Hours", "48 Hours"});
                        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
                        String[] strArr = {"1h", "6h", "24h", "48h"};
                        int i72 = 0;
                        while (true) {
                            if (i72 < 4) {
                                if (strArr[i72].equals(unifiedOnTheAirActivity2.f5572t)) {
                                    spinner.setSelection(i72);
                                } else {
                                    i72++;
                                }
                            }
                        }
                        Spinner spinner2 = (Spinner) viewInflate.findViewById(R.id.spinnerLocationFilter);
                        ArrayAdapter arrayAdapter2 = new ArrayAdapter(unifiedOnTheAirActivity2, android.R.layout.simple_spinner_item, new String[]{"All Locations", "USA", "Canada", "International"});
                        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner2.setAdapter((SpinnerAdapter) arrayAdapter2);
                        String[] strArr2 = {"all", "usa", "canada", "international"};
                        int i82 = 0;
                        while (true) {
                            if (i82 < 4) {
                                if (strArr2[i82].equals(unifiedOnTheAirActivity2.f5571s)) {
                                    spinner2.setSelection(i82);
                                } else {
                                    i82++;
                                }
                            }
                        }
                        builder.setView(viewInflate).setTitle("Filter Options").setPositiveButton("Apply", new DialogInterfaceOnClickListenerC0447a(unifiedOnTheAirActivity2, strArr, spinner, strArr2, spinner2)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
                        break;
                    case 1:
                        int i9 = UnifiedOnTheAirActivity.f5557u;
                        unifiedOnTheAirActivity.n();
                        break;
                    case 2:
                        int i10 = UnifiedOnTheAirActivity.f5557u;
                        unifiedOnTheAirActivity.f5567o.execute(new RunnableC0448b(unifiedOnTheAirActivity, 2));
                        Toast.makeText(unifiedOnTheAirActivity, "Refreshing user data...", 0).show();
                        break;
                    default:
                        int i11 = UnifiedOnTheAirActivity.f5557u;
                        unifiedOnTheAirActivity.l();
                        Toast.makeText(unifiedOnTheAirActivity, "Showing all active users", 0).show();
                        break;
                }
            }
        });
        findViewById(R.id.btnMyLocation).setOnLongClickListener(new ViewOnLongClickListenerC0746d(this, 2));
        SharedPreferences sharedPreferences = getSharedPreferences("UnifiedOnTheAirPrefs", 0);
        this.f5570r = sharedPreferences.getBoolean("show_offline", false);
        this.f5571s = sharedPreferences.getString("location_filter", "all");
        this.f5572t = sharedPreferences.getString("time_filter", "48h");
        this.f5563j.setChecked(this.f5570r);
        MapView mapView = (MapView) findViewById(R.id.mapView);
        this.f5560e = mapView;
        mapView.setTileSource(i4.f.f7375a);
        this.f5560e.setMultiTouchControls(true);
        b controller = this.f5560e.getController();
        this.f5561f = controller;
        ((f) controller).d(4.0d);
        d dVar = new d(39.8283d, -98.5795d);
        ((f) this.f5561f).c(dVar);
        Log.d("UnifiedOnTheAir", "Map initialized with center: " + dVar.f8265k + "," + dVar.f8264j);
        this.f5567o = Executors.newFixedThreadPool(2);
        Handler handler = new Handler(Looper.getMainLooper());
        this.f5568p = handler;
        A a2 = new A(17, this);
        this.f5569q = a2;
        handler.postDelayed(a2, 30000L);
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.navigationBars());
                insetsController.setSystemBarsBehavior(2);
            }
        } else {
            getWindow().getDecorView().setSystemUiVisibility(4102);
        }
        n();
        this.f5567o.execute(new RunnableC0448b(this, 2));
    }

    @Override // f.AbstractActivityC0472i, androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        A a2 = this.f5569q;
        if (a2 != null) {
            this.f5568p.removeCallbacks(a2);
        }
        ExecutorService executorService = this.f5567o;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onPause() {
        super.onPause();
        MapView mapView = this.f5560e;
        if (mapView != null) {
            mapView.c();
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i5, strArr, iArr);
        StringBuilder sbF = h.f("Permission result: requestCode=", i5, ", grantResults.length=");
        sbF.append(iArr.length);
        Log.d("UnifiedOnTheAir", sbF.toString());
        if (i5 == 1001) {
            if (iArr.length > 0 && iArr[0] == 0) {
                Log.d("UnifiedOnTheAir", "Location permission granted, getting location...");
                Toast.makeText(this, "Location permission granted", 0).show();
                n();
            } else {
                Log.w("UnifiedOnTheAir", "Location permission denied");
                Toast.makeText(this, "Location permission denied. Using default location.", 1).show();
                ((f) this.f5561f).c(new d(39.8283d, -98.5795d));
                ((f) this.f5561f).d(4.0d);
            }
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onResume() {
        super.onResume();
        MapView mapView = this.f5560e;
        if (mapView != null) {
            mapView.d();
        }
    }

    public final void p() {
        Log.d("UnifiedOnTheAir", "Requesting location updates...");
        LocationManager locationManager = (LocationManager) getSystemService("location");
        C0452f c0452f = new C0452f(this, locationManager, 0);
        try {
            if (locationManager.isProviderEnabled("gps")) {
                Log.d("UnifiedOnTheAir", "Requesting GPS updates...");
                locationManager.requestLocationUpdates("gps", 1000L, 1.0f, c0452f);
            }
            if (locationManager.isProviderEnabled("network")) {
                Log.d("UnifiedOnTheAir", "Requesting Network updates...");
                locationManager.requestLocationUpdates("network", 1000L, 1.0f, c0452f);
            }
            if (locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network")) {
                return;
            }
            Log.w("UnifiedOnTheAir", "No location providers enabled");
            Toast.makeText(this, "Please enable location services", 1).show();
            ((f) this.f5561f).c(new d(39.8283d, -98.5795d));
            ((f) this.f5561f).d(4.0d);
        } catch (SecurityException e5) {
            Log.e("UnifiedOnTheAir", "Location permission denied for updates", e5);
        }
    }

    public final void q() {
        getSharedPreferences("UnifiedOnTheAirPrefs", 0).edit().putBoolean("show_offline", this.f5570r).putString("location_filter", this.f5571s).putString("time_filter", this.f5572t).apply();
    }

    public final void r(final C0453g c0453g) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.dialog_user_details, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tvUserCallsign);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tvUserStatus);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tvUserDevice);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tvUserLocation);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.tvUserLastSeen);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.tvUserAppVersion);
        String str = c0453g.f6218f;
        if (str == null) {
            str = "Unknown";
        }
        textView.setText(str);
        textView2.setText(c0453g.c());
        String str2 = c0453g.f6214b;
        if (str2 == null) {
            str2 = "Unknown";
        }
        String str3 = c0453g.f6215c;
        if (str3 == null) {
            str3 = "Unknown";
        }
        String str4 = c0453g.f6216d;
        if (str4 == null) {
            str4 = "Unknown";
        }
        textView3.setText(str2 + " " + str3 + " (OS: " + str4 + ")");
        if (c0453g.d()) {
            textView4.setText(String.format("%.6f, %.6f", Double.valueOf(c0453g.g), Double.valueOf(c0453g.h)));
        } else {
            textView4.setText("Location not available");
        }
        textView5.setText(c0453g.b());
        String str5 = c0453g.f6217e;
        textView6.setText(str5 != null ? str5 : "Unknown");
        final int i5 = 0;
        builder.setView(viewInflate).setTitle(c0453g.f6218f + " - Details").setPositiveButton("Send Message", new DialogInterface.OnClickListener(this) { // from class: e3.c

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ UnifiedOnTheAirActivity f6204d;

            {
                this.f6204d = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                C0453g c0453g2 = c0453g;
                UnifiedOnTheAirActivity unifiedOnTheAirActivity = this.f6204d;
                switch (i5) {
                    case 0:
                        int i7 = UnifiedOnTheAirActivity.f5557u;
                        unifiedOnTheAirActivity.getClass();
                        String strH = h4.c.h(unifiedOnTheAirActivity);
                        if (strH == null || strH.isEmpty() || strH.equals("NOCALL") || strH.equals("null")) {
                            unifiedOnTheAirActivity.runOnUiThread(new RunnableC0448b(unifiedOnTheAirActivity, 1));
                            break;
                        } else {
                            String str6 = c0453g2.f6218f;
                            if (str6 == null || str6.isEmpty()) {
                                Toast.makeText(unifiedOnTheAirActivity, "Invalid user callsign", 0).show();
                                break;
                            } else {
                                try {
                                    Intent intent = new Intent(unifiedOnTheAirActivity, (Class<?>) ChatActivity.class);
                                    intent.putExtra("other_user_callsign", str6);
                                    unifiedOnTheAirActivity.startActivity(intent);
                                    Log.d("UnifiedOnTheAir", "Opening chat with user: ".concat(str6));
                                    break;
                                } catch (Exception e5) {
                                    Log.e("UnifiedOnTheAir", "Error opening chat with user: ".concat(str6), e5);
                                    Toast.makeText(unifiedOnTheAirActivity, "Could not open chat", 0).show();
                                    return;
                                }
                            }
                        }
                        break;
                    default:
                        d4.b bVar = unifiedOnTheAirActivity.f5561f;
                        if (bVar != null) {
                            ((l4.f) bVar).c(new k4.d(c0453g2.g, c0453g2.h));
                            ((l4.f) unifiedOnTheAirActivity.f5561f).d(15.0d);
                            unifiedOnTheAirActivity.f5560e.invalidate();
                            break;
                        }
                        break;
                }
            }
        }).setNegativeButton("Close", (DialogInterface.OnClickListener) null);
        if (c0453g.d()) {
            final int i6 = 1;
            builder.setNeutralButton("Show on Map", new DialogInterface.OnClickListener(this) { // from class: e3.c

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ UnifiedOnTheAirActivity f6204d;

                {
                    this.f6204d = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i62) {
                    C0453g c0453g2 = c0453g;
                    UnifiedOnTheAirActivity unifiedOnTheAirActivity = this.f6204d;
                    switch (i6) {
                        case 0:
                            int i7 = UnifiedOnTheAirActivity.f5557u;
                            unifiedOnTheAirActivity.getClass();
                            String strH = h4.c.h(unifiedOnTheAirActivity);
                            if (strH == null || strH.isEmpty() || strH.equals("NOCALL") || strH.equals("null")) {
                                unifiedOnTheAirActivity.runOnUiThread(new RunnableC0448b(unifiedOnTheAirActivity, 1));
                                break;
                            } else {
                                String str6 = c0453g2.f6218f;
                                if (str6 == null || str6.isEmpty()) {
                                    Toast.makeText(unifiedOnTheAirActivity, "Invalid user callsign", 0).show();
                                    break;
                                } else {
                                    try {
                                        Intent intent = new Intent(unifiedOnTheAirActivity, (Class<?>) ChatActivity.class);
                                        intent.putExtra("other_user_callsign", str6);
                                        unifiedOnTheAirActivity.startActivity(intent);
                                        Log.d("UnifiedOnTheAir", "Opening chat with user: ".concat(str6));
                                        break;
                                    } catch (Exception e5) {
                                        Log.e("UnifiedOnTheAir", "Error opening chat with user: ".concat(str6), e5);
                                        Toast.makeText(unifiedOnTheAirActivity, "Could not open chat", 0).show();
                                        return;
                                    }
                                }
                            }
                            break;
                        default:
                            d4.b bVar = unifiedOnTheAirActivity.f5561f;
                            if (bVar != null) {
                                ((l4.f) bVar).c(new k4.d(c0453g2.g, c0453g2.h));
                                ((l4.f) unifiedOnTheAirActivity.f5561f).d(15.0d);
                                unifiedOnTheAirActivity.f5560e.invalidate();
                                break;
                            }
                            break;
                    }
                }
            });
        }
        builder.show();
    }

    public final void s() {
        int size = this.f5564k.size();
        long jCurrentTimeMillis = System.currentTimeMillis() - TimeUnit.HOURS.toMillis(1L);
        Iterator it = this.f5564k.iterator();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (it.hasNext()) {
            C0453g c0453g = (C0453g) it.next();
            if (c0453g.e()) {
                i5++;
            }
            if (c0453g.d()) {
                i7++;
            }
            if (c0453g.f6219i > jCurrentTimeMillis) {
                i6++;
            }
        }
        this.g.setText(String.format("Total: %d | Online Now: %d | Recent (1h): %d | Location: %d", Integer.valueOf(size), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)));
    }

    public final void updateMapMarkers() {
        if (this.f5560e == null) {
            return;
        }
        for (Map.Entry entry : this.n.entrySet()) {
            if (!"MY_LOCATION".equals(entry.getKey())) {
                this.f5560e.getOverlays().remove(entry.getValue());
            }
        }
        m4.d dVar = (m4.d) this.n.get("MY_LOCATION");
        this.n.clear();
        if (dVar != null) {
            this.n.put("MY_LOCATION", dVar);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f5565l.iterator();
        while (it.hasNext()) {
            C0453g c0453g = (C0453g) it.next();
            if (c0453g.d()) {
                d dVar2 = new d(c0453g.g, c0453g.h);
                m4.d dVar3 = new m4.d(this.f5560e);
                dVar3.i(dVar2);
                dVar3.f8675b = c0453g.f6218f;
                dVar3.f8676c = c0453g.c();
                dVar3.g = 0.5f;
                dVar3.h = 1.0f;
                dVar3.h(m(c0453g.f6218f, false, c0453g.e(), c0453g.f()));
                dVar3.f8668k = new C0202f(this, 6, c0453g);
                this.f5560e.getOverlays().add(dVar3);
                this.n.put(c0453g.f6218f + "_" + c0453g.f6213a, dVar3);
                arrayList.add(dVar2);
            }
        }
        Log.d("UnifiedOnTheAir", String.format("Map markers updated: %d users with location data displayed", Integer.valueOf(arrayList.size())));
        if (!this.f5559d && !this.f5558c && !arrayList.isEmpty()) {
            l();
            this.f5559d = true;
        }
        this.f5560e.invalidate();
    }
}
