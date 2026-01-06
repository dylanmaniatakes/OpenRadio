package j3;

import L0.m;
import android.util.Log;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.unified.ur1.SatelliteTracker.h;
import h1.C0558b;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;

/* renamed from: j3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0605c {

    /* renamed from: e, reason: collision with root package name */
    public final C0558b f7609e;

    /* renamed from: f, reason: collision with root package name */
    public final C0604b f7610f;

    /* renamed from: b, reason: collision with root package name */
    public double f7606b = 0.0d;

    /* renamed from: c, reason: collision with root package name */
    public double f7607c = 0.0d;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7608d = false;

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f7605a = Executors.newFixedThreadPool(3);

    public C0605c() {
        C0604b c0604b = new C0604b();
        c0604b.f7582a = 0.0d;
        c0604b.f7583b = 0;
        c0604b.f7584c = 0;
        c0604b.f7585d = 0;
        c0604b.f7586e = "---";
        c0604b.f7587f = "---";
        c0604b.g = "---";
        c0604b.h = "---";
        c0604b.f7588i = "---";
        c0604b.f7589j = "---";
        c0604b.f7590k = "---";
        c0604b.f7591l = "---";
        c0604b.f7592m = "---";
        c0604b.n = "---";
        c0604b.f7593o = "---";
        c0604b.f7594p = "---";
        c0604b.f7595q = "---";
        c0604b.f7596r = "---";
        c0604b.f7597s = "---";
        c0604b.f7598t = "---";
        c0604b.f7599u = "---";
        c0604b.f7600v = "---";
        c0604b.f7601w = "---";
        c0604b.f7602x = "---";
        c0604b.f7603y = "---";
        c0604b.f7604z = "---";
        c0604b.f7578A = 1013.25d;
        c0604b.f7579B = 15.0d;
        c0604b.f7580C = "---";
        c0604b.f7581D = "None";
        this.f7610f = c0604b;
        this.f7609e = new C0558b(4);
    }

    public static String c(double d5) {
        return d5 >= 0.001d ? "X".concat(String.format("%.1f", Double.valueOf(d5 / 0.001d))) : d5 >= 1.0E-4d ? "M".concat(String.format("%.1f", Double.valueOf(d5 / 1.0E-4d))) : d5 >= 1.0E-5d ? "C".concat(String.format("%.1f", Double.valueOf(d5 / 1.0E-5d))) : d5 >= 1.0E-6d ? "B".concat(String.format("%.1f", Double.valueOf(d5 / 1.0E-6d))) : "A".concat(String.format("%.1f", Double.valueOf(d5 / 1.0E-7d)));
    }

    public static String i(String str) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setRequestProperty("User-Agent", "UnifiedRadios SolarData Client");
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != 200) {
            throw new Exception(h.a(responseCode, "HTTP error: "));
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                httpURLConnection.disconnect();
                return sb.toString();
            }
            sb.append(line);
        }
    }

    public static String j(int i5) {
        return i5 >= 4 ? "Strong Tropo" : i5 >= 3 ? "Moderate Tropo" : i5 >= 2 ? "Weak Tropo" : i5 >= 1 ? "Tropo Enhanced" : i5 >= 0 ? "Line of Sight" : "Rain Scatter";
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 864
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.C0605c.a():void");
    }

    public final String b(int i5, double d5, double d6, int i6, boolean z4, boolean z5, boolean z6, boolean z7) {
        int i7 = d5 > 1030.0d ? 4 : d5 > 1020.0d ? 3 : d5 > 1013.0d ? 1 : d5 < 995.0d ? -1 : 0;
        if (z6) {
            i7 += 2;
        }
        if (z4) {
            i7 = d6 > 25.0d ? i7 + 2 : i7 + 1;
        }
        if (z5) {
            i7++;
        }
        if (z7 && d6 > 18.0d) {
            i7++;
        }
        if (i5 < 500) {
            i7++;
        } else if (i5 > 1000) {
            i7--;
        }
        if (i6 > 4) {
            i7--;
        }
        String lowerCase = this.f7610f.f7580C.toLowerCase();
        if (lowerCase.contains("clear") && d5 > 1015.0d) {
            i7++;
        }
        if (lowerCase.contains("fog") || lowerCase.contains("mist")) {
            i7 += 2;
        }
        if (lowerCase.contains("storm") || lowerCase.contains("rain")) {
            i7--;
        }
        return i7 >= 6 ? "Strong Tropo" : i7 >= 4 ? "Moderate Tropo" : i7 >= 2 ? "Weak Tropo" : i7 >= 1 ? "Tropo Enhanced" : i7 >= 0 ? "Normal" : "Below Normal";
    }

    public final void d() {
        C0604b c0604b = this.f7610f;
        try {
            JSONArray jSONArray = new JSONArray(i("https://services.swpc.noaa.gov/json/planetary_k_index_1m.json"));
            if (jSONArray.length() > 0) {
                int i5 = jSONArray.getJSONObject(jSONArray.length() - 1).getInt("kp_index");
                c0604b.f7585d = i5;
                c0604b.f7584c = (i5 < 0 || i5 >= 10) ? 10 : new int[]{0, 3, 7, 15, 27, 48, 80, 132, 207, 400}[i5];
                Log.d("SolarDataManager", "K-Index: " + c0604b.f7585d + ", A-Index: " + c0604b.f7584c);
            }
        } catch (Exception e5) {
            Log.e("SolarDataManager", "Error fetching K-index data", e5);
            c0604b.f7585d = 2;
            c0604b.f7584c = 10;
        }
    }

    public final void e() {
        C0604b c0604b = this.f7610f;
        try {
            JSONArray jSONArray = new JSONArray(i("https://services.swpc.noaa.gov/json/f107_cm_flux.json"));
            if (jSONArray.length() > 0) {
                c0604b.f7582a = jSONArray.getJSONObject(jSONArray.length() - 1).getDouble("f107");
                Log.d("SolarDataManager", "Solar Flux: " + c0604b.f7582a);
            }
        } catch (Exception e5) {
            Log.e("SolarDataManager", "Error fetching solar flux data", e5);
            c0604b.f7582a = 150.0d;
        }
    }

    public final void f() {
        try {
            Object obj = new Object();
            boolean[] zArr = {false};
            this.f7609e.e(this.f7606b, this.f7607c, new m(this, obj, zArr, 8));
            synchronized (obj) {
                try {
                    if (!zArr[0]) {
                        obj.wait(DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM);
                    }
                } finally {
                }
            }
        } catch (Exception e5) {
            Log.e("SolarDataManager", "Error in weather sync", e5);
        }
    }

    public final void g() {
        C0604b c0604b = this.f7610f;
        try {
            JSONArray jSONArray = new JSONArray(i("https://services.swpc.noaa.gov/json/goes/primary/xrays-1-day.json"));
            if (jSONArray.length() > 0) {
                c0604b.f7586e = c(jSONArray.getJSONObject(jSONArray.length() - 1).getDouble("flux"));
                Log.d("SolarDataManager", "X-Ray Background: " + c0604b.f7586e);
            }
        } catch (Exception e5) {
            Log.e("SolarDataManager", "Error fetching X-ray data", e5);
            c0604b.f7586e = "B1.0";
        }
    }

    public final boolean h() {
        Calendar calendar = Calendar.getInstance();
        if (!this.f7608d) {
            calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
            int i5 = calendar.get(11);
            return i5 >= 6 && i5 <= 18;
        }
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        double d5 = (this.f7607c / 15.0d) + calendar.get(11);
        while (d5 < 0.0d) {
            d5 += 24.0d;
        }
        while (d5 >= 24.0d) {
            d5 -= 24.0d;
        }
        return d5 >= 6.0d && d5 <= 18.0d;
    }
}
