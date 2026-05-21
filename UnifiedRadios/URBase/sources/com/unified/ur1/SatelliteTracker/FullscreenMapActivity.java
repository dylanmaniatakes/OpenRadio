package com.unified.ur1.SatelliteTracker;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import com.unified.ur1.R;
import f.AbstractActivityC0472i;
import f.AbstractC0464a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import k4.t;
import l4.l;
import m4.i;
import m4.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public class FullscreenMapActivity extends AbstractActivityC0472i {
    private static final String API_URL = "https://ur1.unifiedradios.com/satellite.php?cloud_auth=c2cb03a0";
    private static final String TAG = "FullscreenMap";
    private ExecutorService executorService;
    private d4.b mapController;
    private Handler mapUpdateHandler;
    private Runnable mapUpdateRunnable;
    private MapView mapView;
    private SatelliteTrackerActivity parentActivity;
    private TextView statusText;
    private TextView timeText;
    private double userLatitude;
    private double userLongitude;
    private List<m4.d> satelliteMarkers = new ArrayList();
    private List<j> satelliteTracks = new ArrayList();
    private Map<String, TleData> tleDatabase = new HashMap();
    private Map<String, SatelliteFrequency> frequencyDatabase = new HashMap();

    /* renamed from: com.unified.ur1.SatelliteTracker.FullscreenMapActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            FullscreenMapActivity.this.updateSatelliteMap();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1() {
            FullscreenMapActivity.this.runOnUiThread(new c(this, 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$2() throws JSONException, IOException {
            FullscreenMapActivity.this.fetchSatelliteData(new c(this, 0));
        }

        @Override // java.lang.Runnable
        public void run() {
            if (System.currentTimeMillis() % 75000 < 15000) {
                FullscreenMapActivity.this.executorService.execute(new c(this, 1));
            } else {
                FullscreenMapActivity.this.updateSatelliteMap();
            }
            FullscreenMapActivity.this.mapUpdateHandler.postDelayed(this, 15000L);
        }
    }

    public static class SatelliteFrequency {
        public String downlinkFreq;
        public String mode;
        public String name;
        public String noradId;
        public String uplinkFreq;
    }

    public static class SatellitePosition {
        public double altitude;
        public double latitude;
        public double longitude;
    }

    public static class TleData {
        public String line1;
        public String line2;
        public String name;
        public String noradId;
    }

    public static class TopocentricData {
        public double azimuth;
        public double elevation;
        public double range;
    }

    private void addSatelliteGroundTrack(TleData tleData, String str, long j5, boolean z4) {
        ArrayList arrayList = new ArrayList();
        long j6 = j5 + 900;
        for (long j7 = j5 - 900; j7 <= j6; j7 += 60) {
            SatellitePosition satellitePositionCalculateSatellitePosition = calculateSatellitePosition(tleData, j7);
            if (satellitePositionCalculateSatellitePosition != null) {
                arrayList.add(new k4.d(satellitePositionCalculateSatellitePosition.latitude, satellitePositionCalculateSatellitePosition.longitude));
            }
        }
        if (arrayList.size() > 1) {
            j jVar = new j();
            jVar.f(arrayList);
            if (z4) {
                jVar.g.setColor(-48060);
                jVar.g.setStrokeWidth(4.0f);
            } else {
                jVar.g.setColor(-2138535800);
                jVar.g.setStrokeWidth(2.0f);
            }
            this.mapView.getOverlays().add(jVar);
            this.satelliteTracks.add(jVar);
        }
    }

    private void addUserLocationMarker() {
        double d5 = this.userLatitude;
        double d6 = this.userLongitude;
        m4.d dVar = new m4.d(this.mapView);
        k4.d dVar2 = new k4.d();
        dVar2.f8265k = d5;
        dVar2.f8264j = d6;
        dVar2.f8266l = 0.0d;
        dVar.f8665f = dVar2;
        if (dVar.f()) {
            o4.a aVar = dVar.f8677d;
            if (aVar != null) {
                aVar.a();
            }
            dVar.j();
        }
        e4.a.g().getClass();
        dVar.g = 0.5f;
        dVar.h = 1.0f;
        try {
            dVar.h(C.c.b(this, R.drawable.ic_location_user));
        } catch (Exception unused) {
            Log.w(TAG, "Custom user location icon not found, using default");
        }
        dVar.f8675b = "Your Location";
        dVar.f8676c = String.format(Locale.US, "%.4f°, %.4f°", Double.valueOf(this.userLatitude), Double.valueOf(this.userLongitude));
        this.mapView.getOverlays().add(dVar);
        this.mapView.invalidate();
    }

    private void addVisibilityCircle(k4.d dVar, boolean z4) {
        try {
            i iVar = new i();
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 <= 360; i5 += 10) {
                double radians = Math.toRadians(i5);
                arrayList.add(new k4.d((Math.cos(radians) * 0.5d) + dVar.f8265k, (0.5d * Math.sin(radians)) + dVar.f8264j));
            }
            iVar.f(arrayList);
            if (z4) {
                iVar.h.setColor(822018048);
                iVar.g.setColor(-65536);
            } else {
                iVar.h.setColor(545292416);
                iVar.g.setColor(-8355712);
            }
            iVar.g.setStrokeWidth(2.0f);
            this.mapView.getOverlays().add(iVar);
            this.satelliteTracks.add(new j());
        } catch (Exception e5) {
            Log.w(TAG, "Could not add visibility circle: " + e5.getMessage());
        }
    }

    private SatellitePosition calculateSatellitePosition(TleData tleData, long j5) {
        Log.w(TAG, "Satellite position calculation not implemented - need SGP4 algorithm");
        return null;
    }

    private TopocentricData calculateTopocentric(SatellitePosition satellitePosition, double d5, double d6) {
        Log.w(TAG, "Topocentric calculation not implemented");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchSatelliteData(Runnable runnable) throws JSONException, IOException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(API_URL).openConnection();
            httpURLConnection.setRequestMethod("GET");
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
            bufferedReader.close();
            String strTrim = sb.toString().trim();
            this.tleDatabase.clear();
            this.frequencyDatabase.clear();
            try {
                JSONObject jSONObject = new JSONObject(strTrim);
                if (jSONObject.has("tle_data")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("tle_data");
                    for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                        TleData tleData = new TleData();
                        tleData.noradId = jSONObject2.getString("noradId");
                        tleData.name = jSONObject2.getString("name");
                        tleData.line1 = jSONObject2.getString("line1");
                        tleData.line2 = jSONObject2.getString("line2");
                        this.tleDatabase.put(tleData.noradId, tleData);
                    }
                }
                if (jSONObject.has("frequency_data")) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("frequency_data");
                    for (int i6 = 0; i6 < jSONArray2.length(); i6++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i6);
                        SatelliteFrequency satelliteFrequency = new SatelliteFrequency();
                        satelliteFrequency.noradId = jSONObject3.getString("noradId");
                        satelliteFrequency.name = jSONObject3.getString("name");
                        satelliteFrequency.downlinkFreq = jSONObject3.optString("downlinkFreq", "");
                        satelliteFrequency.uplinkFreq = jSONObject3.optString("uplinkFreq", "");
                        satelliteFrequency.mode = jSONObject3.optString("mode", "");
                        this.frequencyDatabase.put(satelliteFrequency.noradId, satelliteFrequency);
                    }
                }
                if (runnable != null) {
                    runnable.run();
                }
            } catch (JSONException unused) {
                Log.d(TAG, "Response is TLE data, parsing satellite information...");
                runOnUiThread(new D0.f(this, strTrim, runnable, 3));
            }
        } catch (Exception e5) {
            Log.e(TAG, "Error fetching satellite data: " + e5.getMessage(), e5);
            runOnUiThread(new b(this, 0));
        }
    }

    private void fetchSatelliteDataAndStartUpdates() {
        this.statusText.setText("Loading satellite data from server...");
        this.executorService.execute(new b(this, 1));
    }

    private void initializeComponents() {
        this.statusText = (TextView) findViewById(R.id.fullscreen_status_text);
        this.timeText = (TextView) findViewById(R.id.fullscreen_time_text);
        this.statusText.setText("Initializing satellite map...");
        updateTimeDisplay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchSatelliteData$3(String str, Runnable runnable) {
        parseTleDataFromString(str);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchSatelliteData$4() {
        this.statusText.setText("Error loading satellite data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchSatelliteDataAndStartUpdates$0() {
        Log.d(TAG, "Data fetched: " + this.tleDatabase.size() + " TLE records and " + this.frequencyDatabase.size() + " frequency records");
        if (this.tleDatabase.size() > 0) {
            startRealtimeUpdates();
        } else {
            this.statusText.setText("No satellite data available");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchSatelliteDataAndStartUpdates$1() {
        runOnUiThread(new b(this, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchSatelliteDataAndStartUpdates$2() throws JSONException, IOException {
        fetchSatelliteData(new b(this, 2));
    }

    private void parseTleDataFromString(String str) {
        int i5;
        try {
            String[] strArrSplit = str.split("\n");
            int i6 = 0;
            while (i6 < strArrSplit.length) {
                String strTrim = strArrSplit[i6].trim();
                if (!strTrim.isEmpty() && !strTrim.startsWith("1 ") && !strTrim.startsWith("2 ") && (i5 = i6 + 2) < strArrSplit.length) {
                    String strTrim2 = strArrSplit[i6 + 1].trim();
                    String strTrim3 = strArrSplit[i5].trim();
                    if (strTrim2.startsWith("1 ") && strTrim3.startsWith("2 ")) {
                        String strTrim4 = strTrim2.substring(2, 7).trim();
                        TleData tleData = new TleData();
                        tleData.noradId = strTrim4;
                        tleData.name = strTrim;
                        tleData.line1 = strTrim2;
                        tleData.line2 = strTrim3;
                        this.tleDatabase.put(strTrim4, tleData);
                        SatelliteFrequency satelliteFrequency = new SatelliteFrequency();
                        satelliteFrequency.noradId = strTrim4;
                        satelliteFrequency.name = strTrim;
                        if (strTrim.contains("AO-") || strTrim.contains("AMSAT")) {
                            satelliteFrequency.downlinkFreq = "145.800";
                            satelliteFrequency.uplinkFreq = "435.200";
                            satelliteFrequency.mode = "FM";
                        } else if (strTrim.contains("ISS") || strTrim.contains("CSS")) {
                            satelliteFrequency.downlinkFreq = "145.800";
                            satelliteFrequency.uplinkFreq = "145.200";
                            satelliteFrequency.mode = "FM";
                        } else if (strTrim.contains("FOX") || strTrim.contains("FO-")) {
                            satelliteFrequency.downlinkFreq = "145.980";
                            satelliteFrequency.uplinkFreq = "435.300";
                            satelliteFrequency.mode = "USB";
                        } else {
                            satelliteFrequency.downlinkFreq = "145.800";
                            satelliteFrequency.uplinkFreq = "435.200";
                            satelliteFrequency.mode = "FM";
                        }
                        this.frequencyDatabase.put(strTrim4, satelliteFrequency);
                        Log.d(TAG, "Parsed satellite: " + strTrim + " (NORAD " + strTrim4 + ")");
                        i6 = i5;
                    }
                }
                i6++;
            }
            Log.d(TAG, "Parsed " + this.tleDatabase.size() + " satellites from TLE data");
        } catch (Exception e5) {
            Log.e(TAG, "Error parsing TLE data: " + e5.getMessage(), e5);
        }
        MapView mapView = this.mapView;
        if (mapView != null) {
            mapView.b();
        }
    }

    public static void setStaticData(Map<String, Object> map, Map<String, Object> map2, Object obj) {
    }

    private void setupMap() {
        MapView mapView = (MapView) findViewById(R.id.fullscreen_map_view);
        this.mapView = mapView;
        if (mapView == null) {
            Log.e(TAG, "MapView not found in layout!");
            return;
        }
        mapView.setTileSource(i4.f.f7375a);
        this.mapView.setMultiTouchControls(true);
        this.mapView.setBuiltInZoomControls(true);
        this.mapView.getZoomController().c(3);
        d4.b controller = this.mapView.getController();
        this.mapController = controller;
        ((l4.f) controller).d(6.0d);
        double d5 = this.userLatitude;
        if (d5 != 0.0d) {
            double d6 = this.userLongitude;
            if (d6 != 0.0d) {
                ((l4.f) this.mapController).c(new k4.d(d5, d6));
                addUserLocationMarker();
            }
        }
        Log.d(TAG, "Fullscreen map setup complete");
    }

    private void startRealtimeUpdates() {
        this.mapUpdateHandler = new Handler(Looper.getMainLooper());
        this.mapUpdateRunnable = new AnonymousClass1();
        updateSatelliteMap();
        this.mapUpdateHandler.postDelayed(this.mapUpdateRunnable, 15000L);
    }

    private void stopRealtimeUpdates() {
        Runnable runnable;
        Handler handler = this.mapUpdateHandler;
        if (handler == null || (runnable = this.mapUpdateRunnable) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSatelliteMap() {
        String str;
        int i5;
        double dLog;
        double d5;
        double dLog2;
        Iterator<String> it;
        SatellitePosition satellitePositionCalculateSatellitePosition;
        int i6;
        m4.d dVar;
        Iterator<m4.d> it2 = this.satelliteMarkers.iterator();
        while (it2.hasNext()) {
            this.mapView.getOverlays().remove(it2.next());
        }
        Iterator<j> it3 = this.satelliteTracks.iterator();
        while (it3.hasNext()) {
            this.mapView.getOverlays().remove(it3.next());
        }
        this.satelliteMarkers.clear();
        this.satelliteTracks.clear();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        Log.d(TAG, "Updating satellite map with " + this.frequencyDatabase.size() + " satellites");
        ArrayList arrayList = new ArrayList();
        Iterator<String> it4 = this.frequencyDatabase.keySet().iterator();
        int i7 = 0;
        int i8 = 0;
        while (it4.hasNext()) {
            String next = it4.next();
            TleData tleData = this.tleDatabase.get(next);
            SatelliteFrequency satelliteFrequency = this.frequencyDatabase.get(next);
            if (tleData == null || satelliteFrequency == null || (satellitePositionCalculateSatellitePosition = calculateSatellitePosition(tleData, jCurrentTimeMillis)) == null) {
                it = it4;
                i7 = i7;
            } else {
                int i9 = i7;
                it = it4;
                TopocentricData topocentricDataCalculateTopocentric = calculateTopocentric(satellitePositionCalculateSatellitePosition, this.userLatitude, this.userLongitude);
                k4.d dVar2 = new k4.d(satellitePositionCalculateSatellitePosition.latitude, satellitePositionCalculateSatellitePosition.longitude);
                arrayList.add(dVar2);
                int i10 = i8 + 1;
                m4.d dVar3 = new m4.d(this.mapView);
                dVar3.i(dVar2);
                dVar3.g = 0.5f;
                dVar3.h = 0.5f;
                boolean z4 = topocentricDataCalculateTopocentric.elevation > 0.0d;
                if (z4) {
                    int i11 = i9 + 1;
                    try {
                        dVar3.h(C.c.b(this, R.drawable.ic_satellite_live));
                    } catch (Exception unused) {
                        Log.w(TAG, "Custom satellite icon not found, using default");
                    }
                    dVar3.f8675b = h.e(new StringBuilder("🔴 "), satelliteFrequency.name, " - LIVE");
                    Locale locale = Locale.US;
                    dVar3.f8676c = String.format(locale, "CURRENTLY VISIBLE\nPosition: %.4f°, %.4f°\nElevation: %.1f° | Azimuth: %.1f°\nRange: %.0f km | Altitude: %.0f km\nUpdated: %s", Double.valueOf(satellitePositionCalculateSatellitePosition.latitude), Double.valueOf(satellitePositionCalculateSatellitePosition.longitude), Double.valueOf(topocentricDataCalculateTopocentric.elevation), Double.valueOf(topocentricDataCalculateTopocentric.azimuth), Double.valueOf(topocentricDataCalculateTopocentric.range), Double.valueOf(satellitePositionCalculateSatellitePosition.altitude), new SimpleDateFormat("HH:mm:ss", locale).format(new Date()));
                    i6 = i10;
                    dVar = dVar3;
                    addSatelliteGroundTrack(tleData, satelliteFrequency.name, jCurrentTimeMillis, true);
                    addVisibilityCircle(dVar2, true);
                    i7 = i11;
                } else {
                    i6 = i10;
                    dVar = dVar3;
                    try {
                        dVar.h(C.c.b(this, R.drawable.ic_satellite));
                    } catch (Exception unused2) {
                        Log.w(TAG, "Custom satellite icon not found, using default");
                    }
                    dVar.f8675b = "⚪ " + satelliteFrequency.name;
                    dVar.f8676c = String.format(Locale.US, "Not currently visible\nPosition: %.4f°, %.4f°\nElevation: %.1f° (below horizon)\nAltitude: %.0f km", Double.valueOf(satellitePositionCalculateSatellitePosition.latitude), Double.valueOf(satellitePositionCalculateSatellitePosition.longitude), Double.valueOf(topocentricDataCalculateTopocentric.elevation), Double.valueOf(satellitePositionCalculateSatellitePosition.altitude));
                    addSatelliteGroundTrack(tleData, satelliteFrequency.name, jCurrentTimeMillis, false);
                    i7 = i9;
                }
                this.mapView.getOverlays().add(dVar);
                this.satelliteMarkers.add(dVar);
                StringBuilder sb = new StringBuilder("Added ");
                sb.append(satelliteFrequency.name);
                sb.append(" to map - ");
                sb.append(z4 ? "VISIBLE" : "not visible");
                sb.append(" at ");
                sb.append(String.format("%.1f°", Double.valueOf(topocentricDataCalculateTopocentric.elevation)));
                Log.d(TAG, sb.toString());
                i8 = i6;
            }
            it4 = it;
        }
        int i12 = i7;
        if (arrayList.isEmpty()) {
            str = TAG;
            i5 = i8;
        } else {
            arrayList.add(new k4.d(this.userLatitude, this.userLongitude));
            Iterator it5 = arrayList.iterator();
            double dMax = -1.7976931348623157E308d;
            double dMin = Double.MAX_VALUE;
            double dMin2 = Double.MAX_VALUE;
            double dMax2 = -1.7976931348623157E308d;
            while (it5.hasNext()) {
                k4.d dVar4 = (k4.d) it5.next();
                dMin = Math.min(dMin, dVar4.f8265k);
                dMax = Math.max(dMax, dVar4.f8265k);
                dMin2 = Math.min(dMin2, dVar4.f8264j);
                dMax2 = Math.max(dMax2, dVar4.f8264j);
            }
            double d6 = (dMax - dMin) * 0.1d;
            double d7 = (dMax2 - dMin2) * 0.1d;
            double d8 = dMax + d6;
            double d9 = dMax2 + d7;
            double d10 = dMin - d6;
            double d11 = dMin2 - d7;
            e4.a.g().getClass();
            MapView mapView = this.mapView;
            double maxZoomLevel = mapView.getMaxZoomLevel();
            t tVar = MapView.f9022V;
            int width = mapView.getWidth() - 100;
            int height = mapView.getHeight();
            str = TAG;
            int i13 = height - 100;
            tVar.getClass();
            double dH = t.h(d9, true) - t.h(d11, true);
            if (dH < 0.0d) {
                dH += 1.0d;
            }
            if (dH == 0.0d) {
                i5 = i8;
                dLog = Double.MIN_VALUE;
            } else {
                i5 = i8;
                dLog = Math.log((width / dH) / t.f8314a) / Math.log(2.0d);
            }
            double dI = t.i(d10, true) - t.i(d8, true);
            if (dI <= 0.0d) {
                d5 = d9;
                dLog2 = Double.MIN_VALUE;
            } else {
                d5 = d9;
                dLog2 = Math.log((i13 / dI) / t.f8314a) / Math.log(2.0d);
            }
            if (dLog == Double.MIN_VALUE) {
                dLog = dLog2;
            } else if (dLog2 != Double.MIN_VALUE) {
                dLog = Math.min(dLog2, dLog);
            }
            if (dLog != Double.MIN_VALUE && dLog <= maxZoomLevel) {
                maxZoomLevel = dLog;
            }
            double dMin3 = Math.min(mapView.getMaxZoomLevel(), Math.max(maxZoomLevel, mapView.getMinZoomLevel()));
            double d12 = (d8 + d10) / 2.0d;
            double d13 = (d5 + d11) / 2.0d;
            if (d5 < d11) {
                d13 += 180.0d;
            }
            MapView.getTileSystem().getClass();
            k4.d dVar5 = new k4.d(d12, t.c(d13));
            l lVar = new l(dMin3, new Rect(0, 0, mapView.getWidth(), mapView.getHeight()), dVar5, 0L, 0L, mapView.getMapOrientation(), mapView.I, mapView.f9031J, MapView.getTileSystem(), mapView.getMapCenterOffsetX(), mapView.getMapCenterOffsetY());
            Point point = new Point();
            double d14 = (d5 + d11) / 2.0d;
            if (d5 < d11) {
                d14 += 180.0d;
            }
            MapView.getTileSystem().getClass();
            double dC = t.c(d14);
            double dMax3 = Math.max(d8, d10);
            boolean z5 = lVar.f8486l;
            t tVar2 = lVar.f8491r;
            tVar2.getClass();
            double d15 = lVar.n;
            point.x = t.j(lVar.g(t.e(dC, d15, z5), z5));
            boolean z6 = lVar.f8487m;
            tVar2.getClass();
            int iJ = t.j(lVar.h(t.f(dMax3, d15, z6), z6));
            point.y = iJ;
            double dMin4 = Math.min(d8, d10);
            boolean z7 = lVar.f8486l;
            tVar2.getClass();
            point.x = t.j(lVar.g(t.e(dC, d15, z7), z7));
            boolean z8 = lVar.f8487m;
            tVar2.getClass();
            int iJ2 = t.j(lVar.h(t.f(dMin4, d15, z8), z8));
            point.y = iJ2;
            int height2 = ((mapView.getHeight() - iJ2) - iJ) / 2;
            if (height2 != 0) {
                lVar.b(0L, height2);
                lVar.d(mapView.getWidth() / 2, mapView.getHeight() / 2, dVar5, false);
            }
            ((l4.f) mapView.getController()).a(dVar5, Double.valueOf(dMin3));
        }
        TextView textView = this.statusText;
        Locale locale2 = Locale.US;
        StringBuilder sb2 = new StringBuilder("🛰️ ");
        sb2.append(i12);
        sb2.append(" visible • ");
        int i14 = i5;
        sb2.append(i14);
        sb2.append(" total satellites");
        textView.setText(sb2.toString());
        updateTimeDisplay();
        this.mapView.invalidate();
        StringBuilder sb3 = new StringBuilder("Map updated with ");
        sb3.append(i14);
        sb3.append(" satellites (");
        sb3.append(i12);
        h.q(sb3, " visible)", str);
    }

    private void updateTimeDisplay() {
        this.timeText.setText("Updated: " + new SimpleDateFormat("HH:mm:ss", Locale.US).format(new Date()));
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e4.a.g().f6223a = "Amateur Radio Satellite Tracker/1.0";
        setContentView(R.layout.activity_fullscreen_map);
        AbstractC0464a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.n(true);
            supportActionBar.p("Live Satellite Map");
        }
        Intent intent = getIntent();
        this.userLatitude = intent.getDoubleExtra("user_lat", 0.0d);
        this.userLongitude = intent.getDoubleExtra("user_lon", 0.0d);
        this.executorService = Executors.newSingleThreadExecutor();
        Log.d(TAG, "Fullscreen map initialized - will fetch data from API");
        initializeComponents();
        setupMap();
        fetchSatelliteDataAndStartUpdates();
    }

    @Override // f.AbstractActivityC0472i, androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        stopRealtimeUpdates();
        ExecutorService executorService = this.executorService;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public void onPause() {
        super.onPause();
        MapView mapView = this.mapView;
        if (mapView != null) {
            mapView.c();
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public void onResume() {
        super.onResume();
        MapView mapView = this.mapView;
        if (mapView != null) {
            mapView.d();
        }
    }
}
