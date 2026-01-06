package com.unified.ur1.SatelliteTracker;

import D.n;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.unified.ur1.R;
import f.AbstractActivityC0472i;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import m4.i;
import m4.j;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public class SatelliteTrackerActivity extends AbstractActivityC0472i implements LocationListener {
    private static final long CACHE_DURATION = 10000;
    private static final int LOCATION_PERMISSION_REQUEST = 1001;
    private static final long MIN_CALCULATION_INTERVAL = 5000;
    private static final String TAG = "SatelliteTracker";
    private static final String TLE_URL = "https://ur1.unifiedradios.com/satellite.php?cloud_auth=c2cb03a0";
    private CurrentSatelliteAdapter currentAdapter;
    private RecyclerView currentSatellitesRecycler;
    private ExecutorService executorService;
    private Button fullscreenMapButton;
    private TextView lastUpdateText;
    private LocationManager locationManager;
    private TextView locationText;
    private Handler mainHandler;
    private CardView mapContainer;
    private d4.b mapController;
    private Handler mapUpdateHandler;
    private Runnable mapUpdateRunnable;
    private MapView mapView;
    private UpcomingPassAdapter passAdapter;
    private ProgressDialog progressDialog;
    private TextView statusText;
    private RecyclerView upcomingPassesRecycler;
    private Button updateButton;
    private List<m4.d> satelliteMarkers = new ArrayList();
    private List<j> satelliteTracks = new ArrayList();
    private double userLatitude = 0.0d;
    private double userLongitude = 0.0d;
    private boolean hasLocation = false;
    private Map<String, TleData> tleDatabase = new HashMap();
    private Map<String, SatelliteFrequency> frequencyDatabase = new HashMap();
    private List<CurrentSatellite> currentSatellites = new ArrayList();
    private List<SatellitePass> upcomingPasses = new ArrayList();
    private boolean isMapUpdating = false;
    private boolean isCalculating = false;
    private long lastCalculationTime = 0;
    private Map<String, SatellitePosition> positionCache = new HashMap();
    private long cacheTime = 0;
    private final Date tempDate = new Date();
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
    private boolean isInitialLoad = true;
    private int totalSatellitesToProcess = 0;
    private int processedSatellites = 0;

    public static class CurrentSatellite {
        public SatelliteFrequency frequency;
        public String name;
        public SatellitePosition position;
        public TopocentricData topocentric;

        public CurrentSatellite(String str, SatellitePosition satellitePosition, TopocentricData topocentricData, SatelliteFrequency satelliteFrequency) {
            this.name = str;
            this.position = satellitePosition;
            this.topocentric = topocentricData;
            this.frequency = satelliteFrequency;
        }
    }

    public static class SatelliteFrequency {
        public String[] downlink;
        public String name;
        public String status;
        public String type;
        public String[] uplink;

        public SatelliteFrequency(String str, String[] strArr, String[] strArr2, String str2, String str3) {
            this.name = str;
            this.uplink = strArr;
            this.downlink = strArr2;
            this.type = str2;
            this.status = str3;
        }
    }

    public static class SatellitePass {
        public double aosAzimuth;
        public long duration;
        public long endTime;
        public SatelliteFrequency frequency;
        public double losAzimuth;
        public long maxElevationTime;
        public String noradId;
        public String quality;
        public String satelliteName;
        public long startTime;
        public double maxElevation = 0.0d;
        public List<SatellitePosition> trackPoints = new ArrayList();

        public SatellitePass(String str, String str2, long j5) {
            this.satelliteName = str;
            this.noradId = str2;
            this.startTime = j5;
        }
    }

    public static class SatellitePosition {
        public double altitude;
        public double latitude;
        public double longitude;
        public long timestamp;

        public SatellitePosition(double d5, double d6, double d7, long j5) {
            this.latitude = d5;
            this.longitude = d6;
            this.altitude = d7;
            this.timestamp = j5;
        }
    }

    public static class TleData {
        public String line1;
        public String line2;
        public String name;
        public String noradId;

        public TleData(String str, String str2, String str3, String str4) {
            this.name = str;
            this.line1 = str2;
            this.line2 = str3;
            this.noradId = str4;
        }

        public boolean isValid() {
            String str;
            return this.line1.length() >= 69 && this.line2.length() >= 69 && this.line1.startsWith("1") && this.line2.startsWith("2") && (str = this.noradId) != null && !str.isEmpty();
        }
    }

    public static class TopocentricData {
        public double azimuth;
        public double elevation;
        public double range;

        public TopocentricData(double d5, double d6, double d7) {
            this.azimuth = d5;
            this.elevation = d6;
            this.range = d7;
        }
    }

    private void addFrequency(String str, String str2, String[] strArr, String[] strArr2, String str3, String str4) {
        this.frequencyDatabase.put(str, new SatelliteFrequency(str2, strArr, strArr2, str3, str4));
    }

    private void addUserLocationCircle() {
        if (!this.hasLocation || this.mapView == null) {
            return;
        }
        try {
            i iVar = new i();
            ArrayList arrayList = new ArrayList();
            double degrees = Math.toDegrees(0.15696123057604772d);
            for (int i5 = 0; i5 <= 360; i5 += 10) {
                double radians = Math.toRadians(i5);
                arrayList.add(new k4.d((Math.sin(radians) * degrees) + this.userLatitude, ((Math.cos(radians) * degrees) / Math.cos(Math.toRadians(this.userLatitude))) + this.userLongitude));
            }
            iVar.f(arrayList);
            iVar.g.setColor(Color.argb(100, 0, 150, 255));
            iVar.g.setStrokeWidth(2.0f);
            iVar.h.setColor(Color.argb(30, 0, 150, 255));
            this.mapView.getOverlays().add(iVar);
        } catch (Exception e5) {
            Log.w(TAG, "Error adding user location circle: " + e5.getMessage());
        }
    }

    private void addUserLocationMarker() {
        if (!this.hasLocation || this.mapView == null || isFinishing() || isDestroyed()) {
            return;
        }
        try {
            if (this.mapView.getRepository() == null) {
                Log.w(TAG, "MapView not ready for user location marker");
                return;
            }
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
            } catch (Exception e5) {
                Log.w(TAG, "Failed to load user location icon, using default", e5);
            }
            dVar.f8675b = "Your Location";
            dVar.f8676c = String.format(Locale.US, "%.4f°, %.4f°", Double.valueOf(this.userLatitude), Double.valueOf(this.userLongitude));
            this.mapView.getOverlays().add(dVar);
            this.mapView.invalidate();
        } catch (Exception e6) {
            Log.e(TAG, "Error adding user location marker", e6);
        }
    }

    private double calculateGMST(long j5) {
        double d5 = ((j5 / 86400.0d) + 2440587.5d) - 2451545.0d;
        double d6 = d5 / 36525.0d;
        double radians = Math.toRadians(((((3.87933E-4d * d6) * d6) + ((d5 * 360.98564736629d) + 280.46061837d)) - (((d6 * d6) * d6) / 3.871E7d)) % 360.0d);
        return radians < 0.0d ? radians + 6.283185307179586d : radians;
    }

    private List<SatellitePass> calculatePasses(TleData tleData, String str, long j5, long j6) throws NumberFormatException {
        ArrayList arrayList = new ArrayList();
        SatelliteFrequency satelliteFrequency = this.frequencyDatabase.get(str);
        if (satelliteFrequency == null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        SatellitePass satellitePass = null;
        boolean z4 = false;
        for (long j7 = j5; j7 <= j6; j7 += 60) {
            SatellitePosition satellitePositionCalculateSatellitePosition = calculateSatellitePosition(tleData, j7);
            if (satellitePositionCalculateSatellitePosition != null) {
                TopocentricData topocentricDataCalculateTopocentric = calculateTopocentric(satellitePositionCalculateSatellitePosition, this.userLatitude, this.userLongitude);
                double d5 = topocentricDataCalculateTopocentric.elevation;
                boolean z5 = d5 > 0.0d;
                if (z5 && !z4) {
                    satellitePass = new SatellitePass(satelliteFrequency.name, str, j7);
                    satellitePass.aosAzimuth = topocentricDataCalculateTopocentric.azimuth;
                    satellitePass.maxElevation = topocentricDataCalculateTopocentric.elevation;
                    satellitePass.maxElevationTime = j7;
                    arrayList2.clear();
                    arrayList2.add(satellitePositionCalculateSatellitePosition);
                } else if (z5 && z4) {
                    if (d5 > satellitePass.maxElevation) {
                        satellitePass.maxElevation = d5;
                        satellitePass.maxElevationTime = j7;
                    }
                    arrayList2.add(satellitePositionCalculateSatellitePosition);
                    satellitePass.endTime = j7;
                    satellitePass.losAzimuth = topocentricDataCalculateTopocentric.azimuth;
                } else if (!z5 && z4 && satellitePass != null) {
                    satellitePass.duration = satellitePass.endTime - satellitePass.startTime;
                    satellitePass.trackPoints = new ArrayList(arrayList2);
                    satellitePass.frequency = satelliteFrequency;
                    satellitePass.quality = getPassQuality(satellitePass.maxElevation);
                    if (satellitePass.duration >= 120) {
                        arrayList.add(satellitePass);
                    }
                    satellitePass = null;
                }
                z4 = z5;
            }
        }
        if (satellitePass != null && arrayList2.size() > 0) {
            satellitePass.duration = satellitePass.endTime - satellitePass.startTime;
            satellitePass.trackPoints = new ArrayList(arrayList2);
            satellitePass.frequency = satelliteFrequency;
            satellitePass.quality = getPassQuality(satellitePass.maxElevation);
            if (satellitePass.duration >= 120) {
                arrayList.add(satellitePass);
            }
        }
        return arrayList;
    }

    private double calculateRefraction(double d5) {
        if (d5 < -2.0d) {
            return 0.0d;
        }
        return Math.min(0.0167d / Math.tan(Math.toRadians(d5)), 2.0d);
    }

    private List<k4.d> calculateTrajectory(TleData tleData, long j5) {
        ArrayList arrayList = new ArrayList();
        long j6 = j5 + 1800;
        for (long j7 = j5 - 1800; j7 <= j6; j7 += 60) {
            try {
                SatellitePosition satellitePositionCalculateSatellitePosition = calculateSatellitePosition(tleData, j7);
                if (satellitePositionCalculateSatellitePosition != null && Math.abs(satellitePositionCalculateSatellitePosition.latitude) <= 90.0d && Math.abs(satellitePositionCalculateSatellitePosition.longitude) <= 180.0d) {
                    arrayList.add(new k4.d(satellitePositionCalculateSatellitePosition.latitude, satellitePositionCalculateSatellitePosition.longitude));
                }
            } catch (Exception e5) {
                Log.w(TAG, "Error calculating trajectory for " + tleData.name + ": " + e5.getMessage());
                return arrayList;
            }
        }
        return arrayList.size() > 2 ? smoothTrajectory(arrayList) : arrayList;
    }

    private Drawable createColoredMarker(int i5) {
        try {
            Drawable drawableB = C.c.b(this, R.drawable.ic_satellite);
            if (drawableB != null) {
                drawableB.setColorFilter(i5, PorterDuff.Mode.SRC_IN);
                return drawableB;
            }
        } catch (Exception unused) {
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i5);
        gradientDrawable.setSize(24, 24);
        gradientDrawable.setStroke(2, -1);
        return gradientDrawable;
    }

    private String fetchTleData() throws IOException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(TLE_URL).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setRequestProperty("User-Agent", "Amateur Radio Satellite Tracker Android/1.0");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                Log.e(TAG, "HTTP error: " + responseCode);
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return sb.toString();
                }
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e5) {
            Log.e(TAG, "Network error fetching TLE data", e5);
            return null;
        }
    }

    private long getEpochTime(int i5, double d5) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.set(i5, 0, 1, 0, 0, 0);
        calendar.set(14, 0);
        return (calendar.getTimeInMillis() / 1000) + ((long) ((d5 - 1.0d) * 86400.0d)) + ((long) ((d5 - Math.floor(d5)) * 86400.0d));
    }

    private String getNextPassInfo(String str) {
        long nextPassTime = getNextPassTime(str);
        if (nextPassTime <= 0) {
            return "";
        }
        long jCurrentTimeMillis = nextPassTime - (System.currentTimeMillis() / 1000);
        if (jCurrentTimeMillis <= 0) {
            return "";
        }
        Locale locale = Locale.US;
        return "\nNext pass: " + (jCurrentTimeMillis / 3600) + "h " + ((jCurrentTimeMillis % 3600) / 60) + "m";
    }

    private String getNoradIdForSatellite(String str) {
        for (Map.Entry<String, SatelliteFrequency> entry : this.frequencyDatabase.entrySet()) {
            if (entry.getValue().name.equals(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private String getPassQuality(double d5) {
        return d5 >= 70.0d ? "Excellent" : d5 >= 50.0d ? "Very Good" : d5 >= 30.0d ? "Good" : d5 >= 15.0d ? "Fair" : d5 >= 5.0d ? "Marginal" : "Poor";
    }

    private void hideProgressDialog() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.progressDialog.dismiss();
    }

    private void initializeComponents() {
        try {
            this.statusText = (TextView) findViewById(R.id.status_text);
            this.locationText = (TextView) findViewById(R.id.location_text);
            this.lastUpdateText = (TextView) findViewById(R.id.last_update_text);
            this.updateButton = (Button) findViewById(R.id.update_button);
            this.mapContainer = (CardView) findViewById(R.id.map_container);
            this.fullscreenMapButton = (Button) findViewById(R.id.fullscreen_map_button);
            if (this.statusText == null) {
                Log.e(TAG, "status_text not found in layout!");
            }
            if (this.locationText == null) {
                Log.e(TAG, "location_text not found in layout!");
            }
            if (this.updateButton == null) {
                Log.e(TAG, "update_button not found in layout!");
            }
            Button button = this.updateButton;
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.unified.ur1.SatelliteTracker.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f5579c.lambda$initializeComponents$1(view);
                    }
                });
            }
            TextView textView = this.statusText;
            if (textView != null) {
                textView.setText("Initializing Amateur Radio Satellite Tracker...");
            }
            Log.d(TAG, "Components initialized successfully");
        } catch (Exception e5) {
            Log.e(TAG, "Error initializing components: " + e5.getMessage(), e5);
            TextView textView2 = (TextView) findViewById(R.id.status_text);
            if (textView2 != null) {
                textView2.setText("Initialization error: " + e5.getMessage());
            }
        }
    }

    private void initializeFrequencyDatabase() {
        addFrequency("7530", "AO-7", new String[]{"145.850-145.950 MHz (Mode A)", "432.180-432.120 MHz (Mode B)"}, new String[]{"29.400-29.500 MHz (Mode A)", "145.920-145.980 MHz (Mode B)"}, "Linear Transponder", "Semi-operational");
        addFrequency("24278", "FO-29", new String[]{"145.900-146.000 MHz"}, new String[]{"435.800-435.900 MHz"}, "Linear Transponder", "Active");
        addFrequency("44909", "RS-44", new String[]{"145.935-145.995 MHz"}, new String[]{"435.610-435.670 MHz"}, "Linear Transponder", "Active");
        addFrequency("27607", "SO-50", new String[]{"145.850 MHz FM"}, new String[]{"436.795 MHz FM"}, "FM Repeater", "Active");
        addFrequency("25544", "ISS", new String[]{"145.200 MHz FM", "145.825 MHz (APRS)"}, new String[]{"145.800 MHz FM", "145.825 MHz (APRS)"}, "International Space Station", "Active");
        addFrequency("40906", "IO-86", new String[]{"435.880 MHz FM"}, new String[]{"145.880 MHz FM"}, "FM Repeater", "Active");
        addFrequency("43017", "AO-91", new String[]{"435.250 MHz FM"}, new String[]{"145.960 MHz FM"}, "FM Repeater", "Active");
        addFrequency("43137", "AO-92", new String[]{"435.350 MHz FM"}, new String[]{"145.880 MHz FM"}, "FM Repeater", "Active");
        addFrequency("39444", "FO-99", new String[]{"145.850-145.900 MHz"}, new String[]{"435.880-435.930 MHz"}, "Linear Transponder", "Active");
        addFrequency("43700", "PO-101", new String[]{"145.900-145.950 MHz"}, new String[]{"435.300-435.350 MHz"}, "Linear Transponder", "Active");
        Log.d(TAG, "Initialized frequency database with " + this.frequencyDatabase.size() + " satellites");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeComponents$1(View view) {
        if (this.isCalculating) {
            return;
        }
        updateSatelliteData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(Exception exc) {
        Toast.makeText(this, "Failed to start Satellite Tracker: " + exc.getMessage(), 1).show();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLocationChanged$2() {
        try {
            ((l4.f) this.mapController).c(new k4.d(this.userLatitude, this.userLongitude));
            this.mapView.getOverlays().clear();
            this.satelliteMarkers.clear();
            this.satelliteTracks.clear();
            addUserLocationMarker();
        } catch (Exception e5) {
            Log.e(TAG, "Error updating map on location change", e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSatelliteCalculations$10() {
        this.currentAdapter.setCalculatingState("Computing satellite passes...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$updateSatelliteCalculations$11(SatellitePass satellitePass, SatellitePass satellitePass2) {
        return Long.compare(satellitePass.startTime, satellitePass2.startTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSatelliteCalculations$12(List list, List list2) {
        Log.d(TAG, "Updating adapter with " + list.size() + " visible satellites");
        this.currentSatellites.clear();
        this.currentSatellites.addAll(list);
        this.currentAdapter.updateSatellites(list);
        if (!list2.isEmpty()) {
            this.upcomingPasses.clear();
            this.upcomingPasses.addAll(list2);
            this.passAdapter.updatePasses(list2);
        }
        if (list.isEmpty()) {
            this.currentAdapter.setEmptyState("No satellites currently visible from your location");
            this.statusText.setText("No visible satellites");
        } else {
            TextView textView = this.statusText;
            Locale locale = Locale.US;
            textView.setText(list.size() + " visible • " + this.upcomingPasses.size() + " upcoming passes");
        }
        if (this.mapView != null && !list.isEmpty()) {
            updateMapMarkers();
        }
        this.isCalculating = false;
        Log.d(TAG, "Calculation complete. Found " + list.size() + " visible satellites");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSatelliteCalculations$13(Exception exc) {
        this.currentAdapter.setEmptyState("Error calculating positions: " + exc.getMessage());
        this.isCalculating = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSatelliteCalculations$14(long j5) throws InterruptedException {
        try {
            long j6 = j5 / 1000;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (String str : this.frequencyDatabase.keySet()) {
                TleData tleData = this.tleDatabase.get(str);
                if (tleData != null) {
                    int i5 = this.processedSatellites + 1;
                    this.processedSatellites = i5;
                    if (i5 % 3 == 0) {
                        this.mainHandler.post(new n(i5, 1, this));
                    }
                    SatellitePosition satellitePositionCalculateSatellitePosition = calculateSatellitePosition(tleData, j6);
                    if (satellitePositionCalculateSatellitePosition != null) {
                        TopocentricData topocentricDataCalculateTopocentric = calculateTopocentric(satellitePositionCalculateSatellitePosition, this.userLatitude, this.userLongitude);
                        if (topocentricDataCalculateTopocentric.elevation > 0.0d) {
                            SatelliteFrequency satelliteFrequency = this.frequencyDatabase.get(str);
                            arrayList.add(new CurrentSatellite(satelliteFrequency.name, satellitePositionCalculateSatellitePosition, topocentricDataCalculateTopocentric, satelliteFrequency));
                            Log.d(TAG, "Found visible satellite: " + satelliteFrequency.name + " at elevation " + topocentricDataCalculateTopocentric.elevation + "°");
                        }
                    }
                    if (this.processedSatellites % 5 == 0) {
                        Thread.sleep(10L);
                    }
                }
            }
            if (this.upcomingPasses.isEmpty() || j5 - this.lastCalculationTime > 300000) {
                this.mainHandler.post(new f(this, 9));
                long j7 = j6 + 86400;
                for (String str2 : this.frequencyDatabase.keySet()) {
                    TleData tleData2 = this.tleDatabase.get(str2);
                    if (tleData2 != null) {
                        arrayList2.addAll(calculatePasses(tleData2, str2, j6, j7));
                    }
                }
                arrayList2.sort(new L.a(1));
            }
            this.mainHandler.post(new D0.f(this, arrayList, arrayList2, 4));
        } catch (Exception e5) {
            Log.e(TAG, "Error in satellite calculations", e5);
            this.mainHandler.post(new e(this, e5, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSatelliteCalculations$9(int i5) {
        CurrentSatelliteAdapter currentSatelliteAdapter = this.currentAdapter;
        Locale locale = Locale.US;
        currentSatelliteAdapter.setCalculatingState("Processing satellite " + i5 + " of " + this.totalSatellitesToProcess + "...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSatelliteData$3() {
        this.currentAdapter.setLoadingState("Connecting to satellite server...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSatelliteData$4() {
        this.currentAdapter.setLoadingState("Parsing orbital elements...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSatelliteData$5() {
        TextView textView = this.statusText;
        Locale locale = Locale.US;
        textView.setText("Loaded " + this.tleDatabase.size() + " satellites");
        this.tempDate.setTime(System.currentTimeMillis());
        this.lastUpdateText.setText("Last update: " + this.timeFormat.format(this.tempDate));
        if (this.hasLocation) {
            this.currentAdapter.setCalculatingState("Computing satellite positions...");
            updateSatelliteCalculations();
        } else {
            this.currentAdapter.setEmptyState("Location required for satellite tracking");
        }
        this.updateButton.setEnabled(true);
        this.updateButton.setText("Update Data");
        this.isCalculating = false;
        this.isInitialLoad = false;
        Toast.makeText(this, "Successfully loaded " + this.tleDatabase.size() + " satellites", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSatelliteData$6() {
        this.currentAdapter.setEmptyState("Failed to fetch satellite data");
        this.statusText.setText("Failed to fetch TLE data");
        this.updateButton.setEnabled(true);
        this.updateButton.setText("Retry Update");
        this.isCalculating = false;
        Toast.makeText(this, "Failed to fetch satellite data - check internet connection", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSatelliteData$7(Exception exc) {
        this.currentAdapter.setEmptyState("Error loading data: " + exc.getMessage());
        this.statusText.setText("Error: " + exc.getMessage());
        this.updateButton.setEnabled(true);
        this.updateButton.setText("Retry Update");
        this.isCalculating = false;
        Toast.makeText(this, "Error loading satellite data: " + exc.getMessage(), 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSatelliteData$8() throws InterruptedException {
        try {
            this.mainHandler.post(new f(this, 2));
            String strFetchTleData = fetchTleData();
            if (strFetchTleData != null) {
                this.mainHandler.post(new f(this, 3));
                parseTleData(strFetchTleData);
                Thread.sleep(300L);
                this.mainHandler.post(new f(this, 4));
            } else {
                this.mainHandler.post(new f(this, 5));
            }
        } catch (Exception e5) {
            Log.e(TAG, "Error updating satellite data", e5);
            this.mainHandler.post(new e(this, e5, 1));
        }
    }

    private void parseTleData(String str) {
        this.tleDatabase.clear();
        String[] strArrSplit = str.split("\n");
        for (int i5 = 0; i5 < strArrSplit.length - 2; i5 += 3) {
            try {
                String strTrim = strArrSplit[i5].trim();
                String strTrim2 = strArrSplit[i5 + 1].trim();
                String strTrim3 = strArrSplit[i5 + 2].trim();
                if (strTrim2.length() >= 69 && strTrim3.length() >= 69 && strTrim2.startsWith("1") && strTrim3.startsWith("2")) {
                    String strTrim4 = strTrim2.substring(2, 7).trim();
                    TleData tleData = new TleData(strTrim, strTrim2, strTrim3, strTrim4);
                    if (tleData.isValid()) {
                        this.tleDatabase.put(strTrim4, tleData);
                    }
                }
            } catch (Exception unused) {
            }
        }
        Log.i(TAG, "Parsed " + this.tleDatabase.size() + " satellites");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performInitialDataLoad() {
        if (this.tleDatabase.isEmpty()) {
            this.currentAdapter.setLoadingState("Initializing satellite tracker...");
            updateSatelliteData();
        } else {
            this.currentAdapter.setCalculatingState("Recalculating positions...");
            updateSatelliteCalculations();
        }
    }

    private void requestLocationPermission() {
        if (C.h.a(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            B.e.d(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1001);
        } else {
            startLocationUpdates();
        }
    }

    private void setupMap() {
        MapView mapView = (MapView) findViewById(R.id.map_view);
        this.mapView = mapView;
        if (mapView == null) {
            Log.e(TAG, "MapView not found in layout!");
            return;
        }
        mapView.setTileSource(i4.f.f7375a);
        this.mapView.setMultiTouchControls(true);
        this.mapView.getZoomController().c(3);
        d4.b controller = this.mapView.getController();
        this.mapController = controller;
        ((l4.f) controller).d(8.0d);
        if (!this.hasLocation) {
            ((l4.f) this.mapController).c(new k4.d(39.8283d, -98.5795d));
        } else {
            ((l4.f) this.mapController).c(new k4.d(this.userLatitude, this.userLongitude));
            addUserLocationMarker();
        }
    }

    private void setupRecyclerViews() {
        try {
            this.currentSatellitesRecycler = (RecyclerView) findViewById(R.id.current_satellites_recycler);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.upcoming_passes_recycler);
            this.upcomingPassesRecycler = recyclerView;
            if (this.currentSatellitesRecycler == null) {
                Log.e(TAG, "currentSatellitesRecycler is null! Check if R.id.current_satellites_recycler exists in your layout");
                return;
            }
            if (recyclerView == null) {
                Log.e(TAG, "upcomingPassesRecycler is null! Check if R.id.upcoming_passes_recycler exists in your layout");
                return;
            }
            this.currentAdapter = new CurrentSatelliteAdapter(this.currentSatellites);
            this.passAdapter = new UpcomingPassAdapter(this.upcomingPasses);
            this.currentSatellitesRecycler.setLayoutManager(new LinearLayoutManager(1));
            this.currentSatellitesRecycler.setAdapter(this.currentAdapter);
            this.upcomingPassesRecycler.setLayoutManager(new LinearLayoutManager(1));
            this.upcomingPassesRecycler.setAdapter(this.passAdapter);
            this.currentSatellitesRecycler.setNestedScrollingEnabled(false);
            this.upcomingPassesRecycler.setNestedScrollingEnabled(false);
            Log.d(TAG, "RecyclerViews setup successfully");
        } catch (Exception e5) {
            Log.e(TAG, "Error setting up RecyclerViews: " + e5.getMessage(), e5);
            TextView textView = this.statusText;
            if (textView != null) {
                textView.setText("Error initializing interface: " + e5.getMessage());
            }
            Toast.makeText(this, "Failed to initialize satellite tracker interface", 1).show();
        }
    }

    private void showProgressDialog(String str, String str2) {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
        ProgressDialog progressDialog2 = new ProgressDialog(this);
        this.progressDialog = progressDialog2;
        progressDialog2.setTitle(str);
        this.progressDialog.setMessage(str2);
        this.progressDialog.setProgressStyle(0);
        this.progressDialog.setCancelable(false);
        this.progressDialog.show();
    }

    private List<k4.d> smoothTrajectory(List<k4.d> list) {
        if (list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(list.get(0));
        for (int i5 = 1; i5 < list.size(); i5++) {
            k4.d dVar = list.get(i5);
            if (Math.abs(dVar.f8264j - list.get(i5 - 1).f8264j) > 180.0d && arrayList.size() > 1) {
                arrayList = new ArrayList();
            }
            arrayList.add(dVar);
        }
        return arrayList;
    }

    private double solveKeplerEquation(double d5, double d6) {
        double d7 = d5;
        for (int i5 = 0; i5 < 10; i5++) {
            double dSin = ((d7 - (Math.sin(d7) * d6)) - d5) / (1.0d - (Math.cos(d7) * d6));
            d7 -= dSin;
            if (Math.abs(dSin) < 1.0E-6d) {
                break;
            }
        }
        return d7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAutoRefresh() {
        final Handler handler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() { // from class: com.unified.ur1.SatelliteTracker.SatelliteTrackerActivity.2
            @Override // java.lang.Runnable
            public void run() {
                if (SatelliteTrackerActivity.this.hasLocation && SatelliteTrackerActivity.this.tleDatabase.size() > 0 && !SatelliteTrackerActivity.this.isCalculating && !SatelliteTrackerActivity.this.isFinishing() && !SatelliteTrackerActivity.this.isDestroyed()) {
                    try {
                        SatelliteTrackerActivity.this.updateSatelliteCalculations();
                    } catch (Exception e5) {
                        Log.e(SatelliteTrackerActivity.TAG, "Error in auto refresh", e5);
                    }
                }
                if (SatelliteTrackerActivity.this.isFinishing() || SatelliteTrackerActivity.this.isDestroyed()) {
                    return;
                }
                handler.postDelayed(this, 120000L);
            }
        };
        if (isFinishing() || isDestroyed()) {
            return;
        }
        handler.postDelayed(runnable, 120000L);
    }

    private void startLocationUpdates() {
        LocationManager locationManager = (LocationManager) getSystemService("location");
        this.locationManager = locationManager;
        if (locationManager == null || C.h.a(this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            return;
        }
        this.locationManager.requestLocationUpdates("gps", 30000L, 500.0f, this);
        this.locationManager.requestLocationUpdates("network", 30000L, 500.0f, this);
        Location lastKnownLocation = this.locationManager.getLastKnownLocation("gps");
        if (lastKnownLocation == null) {
            lastKnownLocation = this.locationManager.getLastKnownLocation("network");
        }
        if (lastKnownLocation != null) {
            onLocationChanged(lastKnownLocation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRealtimeMapUpdates() {
        if (this.mapUpdateHandler == null) {
            this.mapUpdateHandler = new Handler(Looper.getMainLooper());
        }
        this.mapUpdateRunnable = new Runnable() { // from class: com.unified.ur1.SatelliteTracker.SatelliteTrackerActivity.1
            @Override // java.lang.Runnable
            public void run() {
                if (SatelliteTrackerActivity.this.hasLocation && SatelliteTrackerActivity.this.tleDatabase.size() > 0 && SatelliteTrackerActivity.this.mapView != null && !SatelliteTrackerActivity.this.isCalculating && !SatelliteTrackerActivity.this.isFinishing() && !SatelliteTrackerActivity.this.isDestroyed()) {
                    try {
                        SatelliteTrackerActivity.this.updateMapMarkers();
                    } catch (Exception e5) {
                        Log.e(SatelliteTrackerActivity.TAG, "Error updating map markers", e5);
                    }
                }
                if (SatelliteTrackerActivity.this.mapUpdateHandler == null || SatelliteTrackerActivity.this.isFinishing() || SatelliteTrackerActivity.this.isDestroyed()) {
                    return;
                }
                SatelliteTrackerActivity.this.mapUpdateHandler.postDelayed(this, 60000L);
            }
        };
        this.isMapUpdating = true;
        if (isFinishing() || isDestroyed()) {
            return;
        }
        this.mapUpdateHandler.postDelayed(this.mapUpdateRunnable, 60000L);
    }

    private void stopRealtimeMapUpdates() {
        Runnable runnable;
        Handler handler = this.mapUpdateHandler;
        if (handler != null && (runnable = this.mapUpdateRunnable) != null) {
            handler.removeCallbacks(runnable);
        }
        this.isMapUpdating = false;
        Log.d(TAG, "Stopped realtime map updates");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMapMarkers() {
        TleData tleData;
        if (this.mapView == null || this.currentSatellites.isEmpty() || isFinishing() || isDestroyed()) {
            return;
        }
        Iterator<m4.d> it = this.satelliteMarkers.iterator();
        while (it.hasNext()) {
            this.mapView.getOverlays().remove(it.next());
        }
        Iterator<j> it2 = this.satelliteTracks.iterator();
        while (it2.hasNext()) {
            this.mapView.getOverlays().remove(it2.next());
        }
        this.satelliteMarkers.clear();
        this.satelliteTracks.clear();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        for (CurrentSatellite currentSatellite : this.currentSatellites) {
            if (currentSatellite != null && currentSatellite.position != null && (tleData = this.tleDatabase.get(getNoradIdForSatellite(currentSatellite.name))) != null) {
                List<k4.d> listCalculateTrajectory = calculateTrajectory(tleData, jCurrentTimeMillis);
                if (!listCalculateTrajectory.isEmpty()) {
                    j jVar = new j();
                    jVar.f(listCalculateTrajectory);
                    jVar.g.setColor(Color.argb(150, 255, 165, 0));
                    jVar.g.setStrokeWidth(3.0f);
                    this.mapView.getOverlays().add(jVar);
                    this.satelliteTracks.add(jVar);
                }
                SatellitePosition satellitePosition = currentSatellite.position;
                double d5 = satellitePosition.latitude;
                double d6 = satellitePosition.longitude;
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
                dVar.h = 0.5f;
                dVar.h(createColoredMarker(-65536));
                String nextPassInfo = getNextPassInfo(currentSatellite.name);
                dVar.f8675b = h.e(new StringBuilder("🔴 "), currentSatellite.name, " - LIVE");
                dVar.f8676c = String.format(Locale.US, "CURRENTLY VISIBLE\nElevation: %.1f° | Azimuth: %.1f°\nRange: %.0f km%s", Double.valueOf(currentSatellite.topocentric.elevation), Double.valueOf(currentSatellite.topocentric.azimuth), Double.valueOf(currentSatellite.topocentric.range), nextPassInfo);
                this.mapView.getOverlays().add(dVar);
                this.satelliteMarkers.add(dVar);
            }
        }
        addUserLocationCircle();
        Log.d(TAG, "Added " + this.satelliteMarkers.size() + " satellite markers and " + this.satelliteTracks.size() + " trajectory lines to map");
        this.mapView.invalidate();
    }

    private void updateProgressDialog(String str) {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.progressDialog.setMessage(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSatelliteCalculations() {
        if (!this.hasLocation || this.tleDatabase.isEmpty() || this.executorService == null) {
            this.currentAdapter.setEmptyState("Location or satellite data not available");
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.isCalculating || jCurrentTimeMillis - this.lastCalculationTime < 5000) {
            return;
        }
        this.isCalculating = true;
        this.lastCalculationTime = jCurrentTimeMillis;
        this.totalSatellitesToProcess = 0;
        Iterator<String> it = this.frequencyDatabase.keySet().iterator();
        while (it.hasNext()) {
            if (this.tleDatabase.containsKey(it.next())) {
                this.totalSatellitesToProcess++;
            }
        }
        CurrentSatelliteAdapter currentSatelliteAdapter = this.currentAdapter;
        Locale locale = Locale.US;
        currentSatelliteAdapter.setCalculatingState("Processing " + this.totalSatellitesToProcess + " satellites...");
        this.processedSatellites = 0;
        this.executorService.execute(new Runnable() { // from class: com.unified.ur1.SatelliteTracker.g
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f5585j.lambda$updateSatelliteCalculations$14(jCurrentTimeMillis);
            }
        });
    }

    private void updateSatelliteData() {
        if (this.executorService == null || this.isCalculating) {
            return;
        }
        this.isCalculating = true;
        this.updateButton.setEnabled(false);
        this.updateButton.setText("Updating...");
        this.currentAdapter.setLoadingState("Downloading satellite data...");
        this.passAdapter.setLoadingState("Please wait...");
        this.executorService.execute(new f(this, 1));
    }

    public SatellitePosition calculateSatellitePosition(TleData tleData, long j5) throws NumberFormatException {
        try {
            double d5 = Double.parseDouble(tleData.line2.substring(8, 16).trim());
            double d6 = Double.parseDouble(tleData.line2.substring(17, 25).trim());
            double d7 = Double.parseDouble("0." + tleData.line2.substring(26, 33).replace(" ", ""));
            double d8 = Double.parseDouble(tleData.line2.substring(34, 42).trim());
            double d9 = Double.parseDouble(tleData.line2.substring(43, 51).trim());
            double d10 = Double.parseDouble(tleData.line2.substring(52, 63).trim());
            double epochTime = (((((((j5 * 1000) - (getEpochTime(Integer.parseInt(tleData.line1.substring(18, 20)) < 57 ? r0 + 2000 : r0 + 1900, Double.parseDouble(tleData.line1.substring(20, 32))) * 1000)) / 60000.0d) * d10) / 1440.0d) * 360.0d) + d9) % 360.0d;
            if (epochTime < 0.0d) {
                epochTime += 360.0d;
            }
            double d11 = ((d10 * 2.0d) * 3.141592653589793d) / 86400.0d;
            double dPow = Math.pow(398600.4418d / (d11 * d11), 0.3333333333333333d) - 6371.0d;
            double dSolveKeplerEquation = solveKeplerEquation(Math.toRadians(epochTime), d7) / 2.0d;
            double dAtan2 = Math.atan2(Math.sqrt(d7 + 1.0d) * Math.sin(dSolveKeplerEquation), Math.sqrt(1.0d - d7) * Math.cos(dSolveKeplerEquation)) * 2.0d;
            Math.toDegrees(dAtan2);
            double radians = Math.toRadians(d5);
            double radians2 = Math.toRadians(d6);
            double radians3 = Math.toRadians(d8) + dAtan2;
            double dCalculateGMST = radians2 + calculateGMST(j5);
            double degrees = Math.toDegrees(Math.asin(Math.sin(radians) * Math.sin(radians3)));
            double degrees2 = Math.toDegrees(dCalculateGMST + Math.atan2(Math.cos(radians) * Math.sin(radians3), Math.cos(radians3)));
            while (degrees2 > 180.0d) {
                degrees2 -= 360.0d;
            }
            double d12 = degrees2;
            while (d12 < -180.0d) {
                d12 += 360.0d;
            }
            if (!Double.isNaN(degrees)) {
                try {
                    if (!Double.isNaN(d12) && !Double.isNaN(dPow)) {
                        if (Math.abs(degrees) > 90.0d || Math.abs(d12) > 180.0d) {
                            return null;
                        }
                        return new SatellitePosition(degrees, d12, Math.max(200.0d, dPow), j5);
                    }
                } catch (Exception e5) {
                    e = e5;
                    Log.w(TAG, "Error calculating position for " + tleData.name + ": " + e.getMessage());
                    return null;
                }
            }
            return null;
        } catch (Exception e6) {
            e = e6;
        }
    }

    public TopocentricData calculateTopocentric(SatellitePosition satellitePosition, double d5, double d6) {
        double radians = Math.toRadians(d5);
        double radians2 = Math.toRadians(d6);
        double radians3 = Math.toRadians(satellitePosition.latitude);
        double radians4 = Math.toRadians(satellitePosition.longitude);
        double dCos = Math.cos(radians2) * Math.cos(radians) * 6378.137d;
        double dSin = Math.sin(radians2) * Math.cos(radians) * 6378.137d;
        double dSin2 = Math.sin(radians) * 6378.137d;
        double d7 = satellitePosition.altitude + 6378.137d;
        double dCos2 = Math.cos(radians4) * Math.cos(radians3) * d7;
        double dSin3 = Math.sin(radians4) * Math.cos(radians3) * d7;
        double dSin4 = Math.sin(radians3) * d7;
        double d8 = dCos2 - dCos;
        double d9 = dSin3 - dSin;
        double d10 = dSin4 - dSin2;
        double dSqrt = Math.sqrt((d10 * d10) + (d9 * d9) + (d8 * d8));
        double degrees = Math.toDegrees(Math.asin(d10 / dSqrt));
        double degrees2 = Math.toDegrees(Math.atan2(d9, d8));
        if (degrees2 < 0.0d) {
            degrees2 += 360.0d;
        }
        double d11 = degrees2;
        if (degrees > -2.0d && degrees < 90.0d) {
            degrees += calculateRefraction(degrees);
        }
        return new TopocentricData(d11, Math.max(degrees, -90.0d), dSqrt);
    }

    public long getNextPassTime(String str) {
        for (SatellitePass satellitePass : this.upcomingPasses) {
            if (satellitePass.satelliteName.equals(str)) {
                long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                long j5 = satellitePass.startTime;
                if (j5 > jCurrentTimeMillis) {
                    return j5;
                }
            }
        }
        return -1L;
    }

    public boolean isSatelliteVisible(String str) {
        for (CurrentSatellite currentSatellite : this.currentSatellites) {
            if (currentSatellite.name.equals(str) && currentSatellite.topocentric.elevation > 0.0d) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            e4.a.g().f6223a = "Amateur Radio Satellite Tracker/1.0";
            this.executorService = Executors.newFixedThreadPool(2);
            this.mainHandler = new Handler(Looper.getMainLooper());
            setContentView(R.layout.activity_satellite_tracker);
            initializeComponents();
            initializeFrequencyDatabase();
            if (this.statusText != null) {
                setupRecyclerViews();
                setupMap();
                requestLocationPermission();
                this.mainHandler.postDelayed(new f(this, 6), 1000L);
                this.mainHandler.postDelayed(new f(this, 7), 2000L);
                this.mainHandler.postDelayed(new f(this, 8), 5000L);
            } else {
                Log.e(TAG, "Critical components failed to initialize, cannot continue");
                finish();
            }
        } catch (Exception e5) {
            Log.e(TAG, "Fatal error in onCreate: " + e5.getMessage(), e5);
            runOnUiThread(new e(this, e5, 2));
        }
    }

    @Override // f.AbstractActivityC0472i, androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        hideProgressDialog();
        ExecutorService executorService = this.executorService;
        if (executorService != null) {
            executorService.shutdown();
        }
        LocationManager locationManager = this.locationManager;
        if (locationManager != null) {
            locationManager.removeUpdates(this);
        }
        stopRealtimeMapUpdates();
        MapView mapView = this.mapView;
        if (mapView != null) {
            mapView.b();
        }
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        this.userLatitude = location.getLatitude();
        this.userLongitude = location.getLongitude();
        this.hasLocation = true;
        this.locationText.setText("Location: ".concat(String.format(Locale.US, "%.4f°, %.4f°", Double.valueOf(this.userLatitude), Double.valueOf(this.userLongitude))));
        if (this.mapView != null) {
            runOnUiThread(new f(this, 0));
        }
        this.positionCache.clear();
        this.cacheTime = 0L;
        if (this.tleDatabase.size() > 0) {
            updateSatelliteCalculations();
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public void onPause() {
        super.onPause();
        MapView mapView = this.mapView;
        if (mapView != null) {
            mapView.c();
        }
        stopRealtimeMapUpdates();
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i5, strArr, iArr);
        if (i5 == 1001) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, "Location permission required for satellite tracking", 1).show();
            } else {
                startLocationUpdates();
            }
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public void onResume() {
        super.onResume();
        MapView mapView = this.mapView;
        if (mapView != null) {
            mapView.d();
        }
        if (this.isMapUpdating) {
            return;
        }
        startRealtimeMapUpdates();
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i5, Bundle bundle) {
    }
}
