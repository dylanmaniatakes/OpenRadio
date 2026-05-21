package com.unified.ur1.adapters;

import B.e;
import C.h;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.R;
import com.unified.ur1.adapters.RepeaterMapActivity;
import d4.a;
import d4.b;
import f.AbstractActivityC0472i;
import f3.l0;
import f3.m0;
import f3.p0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import l4.f;
import m4.d;
import m4.i;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public class RepeaterMapActivity extends AbstractActivityC0472i {

    /* renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f5703w = 0;

    /* renamed from: c, reason: collision with root package name */
    public MapView f5704c;

    /* renamed from: d, reason: collision with root package name */
    public b f5705d;

    /* renamed from: e, reason: collision with root package name */
    public LocationManager f5706e;
    public i n;

    /* renamed from: o, reason: collision with root package name */
    public d f5713o;

    /* renamed from: p, reason: collision with root package name */
    public ImageView f5714p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f5715q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f5716r;

    /* renamed from: s, reason: collision with root package name */
    public Button f5717s;

    /* renamed from: t, reason: collision with root package name */
    public Button f5718t;

    /* renamed from: u, reason: collision with root package name */
    public Button f5719u;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f5707f = new ArrayList();
    public final HashMap g = new HashMap();
    public final ExecutorService h = Executors.newSingleThreadExecutor();

    /* renamed from: i, reason: collision with root package name */
    public double f5708i = 0.0d;

    /* renamed from: j, reason: collision with root package name */
    public double f5709j = 0.0d;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5710k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5711l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5712m = false;

    /* renamed from: v, reason: collision with root package name */
    public final l0 f5720v = new l0(this, 1);

    public static double p(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty() && !"null".equals(str)) {
                    if (str.matches("^[0-9]+(\\.[0-9]+)?$")) {
                        return Double.parseDouble(str);
                    }
                    String strReplaceAll = str.replaceAll("[^0-9.]", "");
                    if (strReplaceAll.isEmpty()) {
                        return 0.0d;
                    }
                    return Double.parseDouble(strReplaceAll);
                }
            } catch (Exception e5) {
                Log.w("RepeaterMap", "Error parsing distance: ".concat(str), e5);
            }
        }
        return 0.0d;
    }

    public final void j(k4.d dVar) {
        if (this.n != null) {
            this.f5704c.getOverlays().remove(this.n);
        }
        this.n = new i();
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 <= 360; i5 += 10) {
            double radians = Math.toRadians(i5);
            arrayList.add(new k4.d((Math.cos(radians) * 0.7228440531800215d) + dVar.f8265k, (Math.sin(radians) * 0.7228440531800215d) + dVar.f8264j));
        }
        this.n.f(arrayList);
        this.n.h.setColor(Color.argb(20, 0, 150, 255));
        this.n.g.setColor(Color.argb(100, 0, 150, 255));
        this.n.g.setStrokeWidth(2.0f);
        this.f5704c.getOverlays().add(this.n);
        this.f5704c.invalidate();
    }

    public final void k(k4.d dVar) {
        if (this.f5713o != null) {
            this.f5704c.getOverlays().remove(this.f5713o);
        }
        d dVar2 = new d(this.f5704c);
        this.f5713o = dVar2;
        dVar2.i(dVar);
        d dVar3 = this.f5713o;
        dVar3.f8675b = "My Location";
        dVar3.f8676c = "Your current position";
        dVar3.g = 0.5f;
        dVar3.h = 1.0f;
        this.f5713o.h(m(-12877066, "YOU"));
        this.f5704c.getOverlays().add(this.f5713o);
        this.f5711l = true;
        this.f5704c.invalidate();
    }

    public final void l() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f5707f.iterator();
        while (it.hasNext()) {
            m0 m0Var = (m0) it.next();
            double d5 = m0Var.n;
            if (d5 != 0.0d) {
                double d6 = m0Var.f6756o;
                if (d6 != 0.0d) {
                    arrayList.add(new k4.d(d5, d6));
                }
            }
        }
        d dVar = this.f5713o;
        if (dVar != null) {
            arrayList.add(dVar.f8665f);
        }
        if (arrayList.isEmpty()) {
            Toast.makeText(this, "No repeaters with location data to display", 0).show();
            return;
        }
        if (arrayList.size() == 1) {
            ((f) this.f5705d).c((a) arrayList.get(0));
            ((f) this.f5705d).d(15.0d);
        } else {
            Iterator it2 = arrayList.iterator();
            double dMax = Double.MIN_VALUE;
            double dMin = Double.MAX_VALUE;
            double dMin2 = Double.MAX_VALUE;
            double dMax2 = Double.MIN_VALUE;
            while (it2.hasNext()) {
                k4.d dVar2 = (k4.d) it2.next();
                dMin = Math.min(dMin, dVar2.f8265k);
                dMax = Math.max(dMax, dVar2.f8265k);
                dMin2 = Math.min(dMin2, dVar2.f8264j);
                dMax2 = Math.max(dMax2, dVar2.f8264j);
            }
            ((f) this.f5705d).c(new k4.d((dMin + dMax) / 2.0d, (dMin2 + dMax2) / 2.0d));
            double dMax3 = Math.max(dMax - dMin, dMax2 - dMin2);
            double d7 = 10.0d;
            if (dMax3 > 10.0d) {
                d7 = 3.0d;
            } else if (dMax3 > 5.0d) {
                d7 = 4.0d;
            } else if (dMax3 > 1.0d) {
                d7 = 6.0d;
            } else if (dMax3 <= 0.1d) {
                d7 = dMax3 > 0.01d ? 12.0d : dMax3 > 0.001d ? 14.0d : 16.0d;
            }
            ((f) this.f5705d).d(d7);
        }
        this.f5711l = true;
        this.f5704c.invalidate();
    }

    public final BitmapDrawable m(int i5, String str) {
        int iMax = Math.max((str.length() * 16) + 32, 80);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMax, 60, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
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
        float f6 = 40;
        RectF rectF = new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f5, f6);
        canvas.drawRoundRect(rectF, 15.0f, 15.0f, paint);
        canvas.drawRoundRect(rectF, 15.0f, 15.0f, paint2);
        float f7 = f5 / 2.0f;
        canvas.drawText(str, f7, (paint3.getTextSize() / 3.0f) + 20, paint3);
        Paint paint5 = new Paint();
        paint5.setColor(i5);
        paint5.setAntiAlias(true);
        float[] fArr = {f7 - 10.0f, f6, 10.0f + f7, f6, f7, 55};
        Path path = new Path();
        path.moveTo(fArr[0], fArr[1]);
        path.lineTo(fArr[2], fArr[3]);
        path.lineTo(fArr[4], fArr[5]);
        path.close();
        canvas.drawPath(path, paint5);
        return new BitmapDrawable(getResources(), bitmapCreateBitmap);
    }

    public final void n() {
        this.f5716r.setText("Loading repeaters...");
        this.h.execute(new p0(this, 0));
    }

    public final void o() {
        try {
            if (h.a(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                return;
            }
            LocationManager locationManager = this.f5706e;
            l0 l0Var = this.f5720v;
            locationManager.requestSingleUpdate("gps", l0Var, (Looper) null);
            this.f5706e.requestSingleUpdate("network", l0Var, (Looper) null);
        } catch (SecurityException e5) {
            Log.e("RepeaterMap", "Error getting current location", e5);
            Toast.makeText(this, "Location permission denied", 0).show();
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e4.a.g().f6223a = getPackageName();
        setContentView(R.layout.activity_repeater_map_osm);
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                WindowInsetsController insetsController = getWindow().getInsetsController();
                if (insetsController != null) {
                    insetsController.hide(WindowInsets.Type.navigationBars());
                    insetsController.setSystemBarsBehavior(2);
                }
            } else {
                View decorView = getWindow().getDecorView();
                if (decorView != null) {
                    decorView.setSystemUiVisibility(4102);
                }
            }
        } catch (Exception e5) {
            Log.e("RepeaterMap", "Error hiding system UI", e5);
        }
        this.f5714p = (ImageView) findViewById(R.id.buttonBack);
        this.f5715q = (TextView) findViewById(R.id.locationText);
        this.f5716r = (TextView) findViewById(R.id.statusText);
        this.f5717s = (Button) findViewById(R.id.btnMyLocation);
        this.f5718t = (Button) findViewById(R.id.btnRefresh);
        this.f5719u = (Button) findViewById(R.id.btnShowAll);
        final int i5 = 0;
        this.f5714p.setOnClickListener(new View.OnClickListener(this) { // from class: f3.n0

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ RepeaterMapActivity f6767d;

            {
                this.f6767d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepeaterMapActivity repeaterMapActivity = this.f6767d;
                switch (i5) {
                    case 0:
                        int i6 = RepeaterMapActivity.f5703w;
                        repeaterMapActivity.finish();
                        break;
                    case 1:
                        int i7 = RepeaterMapActivity.f5703w;
                        repeaterMapActivity.o();
                        Toast.makeText(repeaterMapActivity, "Finding your location...", 0).show();
                        break;
                    case 2:
                        int i8 = RepeaterMapActivity.f5703w;
                        repeaterMapActivity.n();
                        Toast.makeText(repeaterMapActivity, "Refreshing repeater data...", 0).show();
                        break;
                    default:
                        int i9 = RepeaterMapActivity.f5703w;
                        repeaterMapActivity.l();
                        Toast.makeText(repeaterMapActivity, "Showing all repeaters", 0).show();
                        break;
                }
            }
        });
        final int i6 = 1;
        this.f5717s.setOnClickListener(new View.OnClickListener(this) { // from class: f3.n0

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ RepeaterMapActivity f6767d;

            {
                this.f6767d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepeaterMapActivity repeaterMapActivity = this.f6767d;
                switch (i6) {
                    case 0:
                        int i62 = RepeaterMapActivity.f5703w;
                        repeaterMapActivity.finish();
                        break;
                    case 1:
                        int i7 = RepeaterMapActivity.f5703w;
                        repeaterMapActivity.o();
                        Toast.makeText(repeaterMapActivity, "Finding your location...", 0).show();
                        break;
                    case 2:
                        int i8 = RepeaterMapActivity.f5703w;
                        repeaterMapActivity.n();
                        Toast.makeText(repeaterMapActivity, "Refreshing repeater data...", 0).show();
                        break;
                    default:
                        int i9 = RepeaterMapActivity.f5703w;
                        repeaterMapActivity.l();
                        Toast.makeText(repeaterMapActivity, "Showing all repeaters", 0).show();
                        break;
                }
            }
        });
        final int i7 = 2;
        this.f5718t.setOnClickListener(new View.OnClickListener(this) { // from class: f3.n0

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ RepeaterMapActivity f6767d;

            {
                this.f6767d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepeaterMapActivity repeaterMapActivity = this.f6767d;
                switch (i7) {
                    case 0:
                        int i62 = RepeaterMapActivity.f5703w;
                        repeaterMapActivity.finish();
                        break;
                    case 1:
                        int i72 = RepeaterMapActivity.f5703w;
                        repeaterMapActivity.o();
                        Toast.makeText(repeaterMapActivity, "Finding your location...", 0).show();
                        break;
                    case 2:
                        int i8 = RepeaterMapActivity.f5703w;
                        repeaterMapActivity.n();
                        Toast.makeText(repeaterMapActivity, "Refreshing repeater data...", 0).show();
                        break;
                    default:
                        int i9 = RepeaterMapActivity.f5703w;
                        repeaterMapActivity.l();
                        Toast.makeText(repeaterMapActivity, "Showing all repeaters", 0).show();
                        break;
                }
            }
        });
        final int i8 = 3;
        this.f5719u.setOnClickListener(new View.OnClickListener(this) { // from class: f3.n0

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ RepeaterMapActivity f6767d;

            {
                this.f6767d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepeaterMapActivity repeaterMapActivity = this.f6767d;
                switch (i8) {
                    case 0:
                        int i62 = RepeaterMapActivity.f5703w;
                        repeaterMapActivity.finish();
                        break;
                    case 1:
                        int i72 = RepeaterMapActivity.f5703w;
                        repeaterMapActivity.o();
                        Toast.makeText(repeaterMapActivity, "Finding your location...", 0).show();
                        break;
                    case 2:
                        int i82 = RepeaterMapActivity.f5703w;
                        repeaterMapActivity.n();
                        Toast.makeText(repeaterMapActivity, "Refreshing repeater data...", 0).show();
                        break;
                    default:
                        int i9 = RepeaterMapActivity.f5703w;
                        repeaterMapActivity.l();
                        Toast.makeText(repeaterMapActivity, "Showing all repeaters", 0).show();
                        break;
                }
            }
        });
        this.f5716r.setText("Initializing map...");
        this.f5706e = (LocationManager) getSystemService("location");
        MapView mapView = (MapView) findViewById(R.id.mapView);
        this.f5704c = mapView;
        mapView.setTileSource(i4.f.f7375a);
        this.f5704c.setMultiTouchControls(true);
        b controller = this.f5704c.getController();
        this.f5705d = controller;
        ((f) controller).d(4.0d);
        k4.d dVar = new k4.d(39.8283d, -98.5795d);
        ((f) this.f5705d).c(dVar);
        this.f5716r.setText("Map ready. Getting location...");
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
        int i9 = 0;
        while (true) {
            if (i9 >= 2) {
                q();
                break;
            } else {
                if (h.a(this, strArr[i9]) != 0) {
                    e.d(this, strArr, 100);
                    break;
                }
                i9++;
            }
        }
        Log.d("RepeaterMap", "Map initialized with center: " + dVar.f8265k + "," + dVar.f8264j);
    }

    @Override // f.AbstractActivityC0472i, androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onDestroy() {
        l0 l0Var;
        super.onDestroy();
        LocationManager locationManager = this.f5706e;
        if (locationManager != null && (l0Var = this.f5720v) != null) {
            locationManager.removeUpdates(l0Var);
        }
        ExecutorService executorService = this.h;
        if (executorService == null || executorService.isShutdown()) {
            return;
        }
        executorService.shutdown();
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onPause() {
        super.onPause();
        MapView mapView = this.f5704c;
        if (mapView != null) {
            mapView.c();
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i5, strArr, iArr);
        if (i5 == 100) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, "Location permission required for map functionality", 1).show();
                n();
            } else {
                q();
                Toast.makeText(this, "Location permission granted", 0).show();
            }
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onResume() {
        super.onResume();
        MapView mapView = this.f5704c;
        if (mapView != null) {
            mapView.d();
        }
    }

    public final void q() {
        try {
            if (h.a(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                return;
            }
            this.f5716r.setText("Getting GPS location...");
            Location lastKnownLocation = this.f5706e.getLastKnownLocation("gps");
            if (lastKnownLocation == null) {
                lastKnownLocation = this.f5706e.getLastKnownLocation("network");
            }
            if (lastKnownLocation == null || this.f5710k) {
                o();
                return;
            }
            r(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            this.f5710k = true;
            k4.d dVar = new k4.d(this.f5708i, this.f5709j);
            ((f) this.f5705d).c(dVar);
            ((f) this.f5705d).d(10.0d);
            k(dVar);
            j(dVar);
            n();
        } catch (SecurityException e5) {
            Log.e("RepeaterMap", "Error starting location updates", e5);
            this.f5716r.setText("Location permission error");
            n();
        }
    }

    public final void r(double d5, double d6) {
        this.f5708i = d5;
        this.f5709j = d6;
        this.f5715q.setText(String.format("Location: %.4f, %.4f", Double.valueOf(d5), Double.valueOf(d6)));
        Log.d("RepeaterMap", "Location updated: " + d5 + ", " + d6);
    }
}
