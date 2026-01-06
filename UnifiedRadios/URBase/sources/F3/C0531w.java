package f3;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.os.Handler;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: f3.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0531w {

    /* renamed from: a, reason: collision with root package name */
    public Context f6815a;

    /* renamed from: b, reason: collision with root package name */
    public SharedPreferences f6816b;

    /* renamed from: c, reason: collision with root package name */
    public OkHttpClient f6817c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f6818d;

    public static double a(double d5, double d6, double d7, double d8) {
        double radians = Math.toRadians(d7 - d5);
        double radians2 = Math.toRadians(d8 - d6);
        double d9 = radians / 2.0d;
        double d10 = radians2 / 2.0d;
        double dSin = (Math.sin(d10) * Math.sin(d10) * Math.cos(Math.toRadians(d7)) * Math.cos(Math.toRadians(d5))) + (Math.sin(d9) * Math.sin(d9));
        return Math.atan2(Math.sqrt(dSin), Math.sqrt(1.0d - dSin)) * 2.0d * 6371000.0d;
    }

    public static C0530v b(double d5, double d6, int i5) {
        Math.sqrt(0.0066943799901413165d);
        double radians = Math.toRadians(d5);
        double radians2 = Math.toRadians(d6) - Math.toRadians(((i5 - 1) * 6) - 177);
        double dSqrt = 6378137.0d / Math.sqrt(1.0d - (Math.pow(Math.sin(radians), 2.0d) * 0.0066943799901413165d));
        double dPow = Math.pow(Math.tan(radians), 2.0d);
        double dPow2 = Math.pow(Math.cos(radians), 2.0d) * 0.006739496742276434d;
        double dCos = radians2 * Math.cos(radians);
        double dSin = (((Math.sin(radians * 4.0d) * 2.6390465943376213E-6d) + ((0.9983242984527954d * radians) - (Math.sin(radians * 2.0d) * 0.002514607060518705d))) - (Math.sin(radians * 6.0d) * 3.4180460865957878E-9d)) * 6378137.0d;
        double d7 = dPow * dPow;
        double dPow3 = ((((Math.pow(dCos, 5.0d) * (((72.0d * dPow2) + ((5.0d - (18.0d * dPow)) + d7)) - 0.39089081105203316d)) / 120.0d) + ((Math.pow(dCos, 3.0d) * ((1.0d - dPow) + dPow2)) / 6.0d) + dCos) * dSqrt * 0.9996d) + 500000.0d;
        double dPow4 = Math.pow(dCos, 6.0d);
        double dPow5 = (((((dPow4 * (((dPow2 * 600.0d) + ((61.0d - (dPow * 58.0d)) + d7)) - 2.224033924951223d)) / 720.0d) + ((Math.pow(dCos, 4.0d) * (((dPow2 * 4.0d) * dPow2) + ((9.0d * dPow2) + (5.0d - dPow)))) / 24.0d) + ((dCos * dCos) / 2.0d)) * Math.tan(radians) * dSqrt) + dSin) * 0.9996d;
        if (d5 < 0.0d) {
            dPow5 += 1.0E7d;
        }
        C0530v c0530v = new C0530v();
        c0530v.f6811a = dPow3;
        c0530v.f6812b = dPow5;
        return c0530v;
    }

    public static String c(double d5, double d6) {
        double d7 = d5 + 90.0d;
        try {
            char cFloor = (char) (Math.floor(r12 / 20.0d) + 65.0d);
            char cFloor2 = (char) (Math.floor(d7 / 10.0d) + 65.0d);
            char cFloor3 = (char) (Math.floor((r12 % 20.0d) / 2.0d) + 48.0d);
            char cFloor4 = (char) (Math.floor(d7 % 10.0d) + 48.0d);
            double d8 = (d6 + 180.0d) / 2.0d;
            double dFloor = d8 - Math.floor(d8);
            double dFloor2 = d7 - Math.floor(d7);
            return String.format("%c%c%c%c%c%c", Character.valueOf(cFloor), Character.valueOf(cFloor2), Character.valueOf(cFloor3), Character.valueOf(cFloor4), Character.valueOf((char) (Math.floor(dFloor * 24.0d) + 97.0d)), Character.valueOf((char) (Math.floor(dFloor2 * 24.0d) + 97.0d)));
        } catch (Exception e5) {
            Log.e("LocationService", "Error converting to Maidenhead Grid", e5);
            return "Grid Error";
        }
    }

    public static String d(double d5, double d6) {
        try {
            Log.d("LocationService", String.format("Converting to USNG: %.6f, %.6f", Double.valueOf(d5), Double.valueOf(d6)));
            if (d5 >= -80.0d && d5 <= 84.0d && d6 >= -180.0d && d6 <= 180.0d) {
                int iFloor = ((int) Math.floor((180.0d + d6) / 6.0d)) + 1;
                char cCharAt = ' ';
                if (d5 >= 56.0d && d5 < 64.0d && d6 >= 3.0d && d6 < 12.0d) {
                    iFloor = 32;
                }
                if (d5 >= 72.0d && d5 < 84.0d) {
                    if (d6 >= 0.0d && d6 < 9.0d) {
                        iFloor = 31;
                    } else if (d6 >= 9.0d && d6 < 21.0d) {
                        iFloor = 33;
                    } else if (d6 >= 21.0d && d6 < 33.0d) {
                        iFloor = 35;
                    } else if (d6 >= 33.0d && d6 < 42.0d) {
                        iFloor = 37;
                    }
                }
                Log.d("LocationService", String.format("Step 1 - UTM Zone: %d", Integer.valueOf(iFloor)));
                if (d5 >= -80.0d && d5 <= 84.0d) {
                    cCharAt = "CDEFGHJKLMNPQRSTUVWX".charAt((int) Math.floor((80.0d + d5) / 8.0d));
                }
                Log.d("LocationService", String.format("Step 2 - Latitude Band: %c", Character.valueOf(cCharAt)));
                C0530v c0530vB = b(d5, d6, iFloor);
                double d7 = c0530vB.f6812b;
                double d8 = c0530vB.f6811a;
                Log.d("LocationService", String.format("Step 3 - UTM: E=%.2f, N=%.2f", Double.valueOf(d8), Double.valueOf(d7)));
                String strI = i(c0530vB.f6811a, c0530vB.f6812b, iFloor);
                Log.d("LocationService", "Step 4 - Grid Square: " + strI);
                int iRound = (((int) Math.round(d8)) % 100000) / 100;
                int iRound2 = (((int) Math.round(d7)) % 100000) / 100;
                Log.d("LocationService", String.format("Step 5 - 100m Precision Coords: E=%d, N=%d", Integer.valueOf(iRound), Integer.valueOf(iRound2)));
                String str = String.format(Locale.US, "%02d%c %s %03d %03d", Integer.valueOf(iFloor), Character.valueOf(cCharAt), strI, Integer.valueOf(iRound), Integer.valueOf(iRound2));
                Log.d("LocationService", "Final USNG: ".concat(str));
                return str;
            }
            return "Outside USNG coverage area";
        } catch (Exception e5) {
            Log.e("LocationService", "Error converting to USNG", e5);
            return "USNG conversion failed";
        }
    }

    public static String h(double d5, boolean z4) {
        if (d5 < 0.0d) {
            return "";
        }
        if (z4) {
            return Math.round(d5) + "m";
        }
        return Math.round(d5 * 3.28084d) + "ft";
    }

    public static String i(double d5, double d6, int i5) {
        String str = new String[]{"ABCDEFGH", "JKLMNPQR", "STUVWXYZ"}[(i5 - 1) % 3];
        String str2 = i5 % 2 == 0 ? "FGHJKLMNPQRSTUVABCDE" : "ABCDEFGHJKLMNPQRSTUV";
        int iFloor = ((int) Math.floor(d5 / 100000.0d)) - 1;
        int iFloor2 = ((int) Math.floor(d6 / 100000.0d)) % 20;
        return "" + str.charAt(iFloor) + str2.charAt(iFloor2);
    }

    public final void e(JSONObject jSONObject, double d5, double d6, C0529u c0529u) throws JSONException {
        int i5 = 2;
        int i6 = 0;
        try {
            boolean z4 = h4.c.C(this.f6815a).getInt("metricEnable", 0) == 1;
            JSONArray jSONArray = jSONObject.getJSONArray("elements");
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            int i7 = 0;
            while (i7 < jSONArray.length()) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i7);
                String strOptString = jSONObject2.optString("type");
                if ("node".equals(strOptString)) {
                    long j5 = jSONObject2.getLong("id");
                    double d7 = jSONObject2.getDouble("lat");
                    double d8 = jSONObject2.getDouble("lon");
                    Long lValueOf = Long.valueOf(j5);
                    double[] dArr = new double[i5];
                    dArr[i6] = d7;
                    dArr[1] = d8;
                    map2.put(lValueOf, dArr);
                } else if ("way".equals(strOptString) && jSONObject2.has("tags")) {
                    String strOptString2 = jSONObject2.getJSONObject("tags").optString("name");
                    if (!strOptString2.isEmpty() && jSONObject2.has("nodes")) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("nodes");
                        ArrayList arrayList = new ArrayList();
                        for (int i8 = i6; i8 < jSONArray2.length(); i8++) {
                            long j6 = jSONArray2.getLong(i8);
                            ((List) map.computeIfAbsent(Long.valueOf(j6), new C0528t())).add(strOptString2);
                            if (map2.containsKey(Long.valueOf(j6))) {
                                arrayList.add((double[]) map2.get(Long.valueOf(j6)));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            map3.put(strOptString2, arrayList);
                        }
                    }
                }
                i7++;
                i5 = 2;
                i6 = 0;
            }
            double d9 = Double.MAX_VALUE;
            String strJoin = null;
            for (Map.Entry entry : map.entrySet()) {
                HashSet hashSet = new HashSet((Collection) entry.getValue());
                if (hashSet.size() >= 2) {
                    Long l5 = (Long) entry.getKey();
                    l5.getClass();
                    double[] dArr2 = (double[]) map2.get(l5);
                    if (dArr2 != null) {
                        double dA = a(d5, d6, dArr2[0], dArr2[1]);
                        if (dA < d9) {
                            ArrayList arrayList2 = new ArrayList(hashSet);
                            Collections.sort(arrayList2);
                            strJoin = String.join(" & ", arrayList2);
                            d9 = dA;
                        }
                    }
                }
            }
            if (strJoin == null) {
                g(map3, d5, d6, c0529u);
                return;
            }
            c0529u.h = strJoin + " (" + h(d9, z4) + " away)";
            c0529u.f6803i = d9;
        } catch (Exception e5) {
            Log.e("LocationService", "Error parsing intersection data", e5);
            c0529u.h = "Intersection parsing failed";
            c0529u.f6803i = -1.0d;
        }
    }

    public final void f(double d5, double d6, C0529u c0529u) {
        try {
            Response responseExecute = this.f6817c.newCall(new Request.Builder().url("https://overpass-api.de/api/interpreter").post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), "data=".concat(String.format(Locale.US, "[out:json][timeout:15];(  way[highway][name](%f,%f,%f,%f);  node(w)->.intersections;  way[highway][name](bn.intersections););out geom;", Double.valueOf(d5 - 0.003d), Double.valueOf(d6 - 0.003d), Double.valueOf(d5 + 0.003d), Double.valueOf(0.003d + d6))))).addHeader("User-Agent", "UnifiedRadios/1.0").addHeader("Content-Type", "application/x-www-form-urlencoded").build()).execute();
            try {
                if (responseExecute.isSuccessful() && responseExecute.body() != null) {
                    e(new JSONObject(responseExecute.body().string()), d5, d6, c0529u);
                }
                responseExecute.close();
            } finally {
            }
        } catch (Exception e5) {
            Log.e("LocationService", "Error finding closest intersection", e5);
            c0529u.h = "Intersection data unavailable";
            c0529u.f6803i = 0.0d;
        }
    }

    public final void g(HashMap map, double d5, double d6, C0529u c0529u) {
        boolean z4 = h4.c.C(this.f6815a).getInt("metricEnable", 0) == 1;
        double d7 = Double.MAX_VALUE;
        String str = null;
        for (Map.Entry entry : map.entrySet()) {
            for (double[] dArr : (List) entry.getValue()) {
                double dA = a(d5, d6, dArr[0], dArr[1]);
                if (dA < d7) {
                    str = (String) entry.getKey();
                    d7 = dA;
                }
            }
        }
        if (str != null) {
            c0529u.h = "Near " + str + " (" + h(d7, z4) + " away)";
            c0529u.f6803i = d7;
            return;
        }
        String str2 = c0529u.f6799c;
        if (str2 == null || str2.isEmpty()) {
            c0529u.h = "Location data unavailable";
            c0529u.f6803i = -1.0d;
        } else {
            c0529u.h = "On " + c0529u.f6799c;
            c0529u.f6803i = 0.0d;
        }
    }

    public final void j(C0529u c0529u) {
        SharedPreferences.Editor editorEdit = this.f6816b.edit();
        editorEdit.putString("current_address", c0529u.f6797a);
        editorEdit.putString("street_number", c0529u.f6798b);
        editorEdit.putString("street_name", c0529u.f6799c);
        editorEdit.putString("city", c0529u.f6800d);
        editorEdit.putString("state", c0529u.f6801e);
        editorEdit.putString("zip_code", c0529u.f6802f);
        editorEdit.putString("country", c0529u.g);
        editorEdit.putString("closest_intersection", c0529u.h);
        editorEdit.putFloat("intersection_distance", (float) c0529u.f6803i);
        editorEdit.putFloat("last_latitude", (float) c0529u.f6804j);
        editorEdit.putFloat("last_longitude", (float) c0529u.f6805k);
        editorEdit.putString("usng_coordinates", c0529u.f6806l);
        editorEdit.putString("maidenhead_grid", c0529u.f6807m);
        editorEdit.apply();
        Log.d("LocationService", "Location info saved to SharedPreferences");
    }

    public final boolean k(double d5, double d6, C0529u c0529u) throws IOException {
        if (!Geocoder.isPresent()) {
            Log.w("LocationService", "Geocoder not present on this device");
            return false;
        }
        try {
            List<Address> fromLocation = new Geocoder(this.f6815a, Locale.getDefault()).getFromLocation(d5, d6, 1);
            if (fromLocation != null && !fromLocation.isEmpty()) {
                Address address = fromLocation.get(0);
                c0529u.f6798b = address.getSubThoroughfare();
                c0529u.f6799c = address.getThoroughfare();
                c0529u.f6800d = address.getLocality();
                c0529u.f6801e = address.getAdminArea();
                c0529u.f6802f = address.getPostalCode();
                c0529u.g = address.getCountryName();
                StringBuilder sb = new StringBuilder();
                String str = c0529u.f6798b;
                if (str != null) {
                    sb.append(str);
                    sb.append(" ");
                }
                String str2 = c0529u.f6799c;
                if (str2 != null) {
                    sb.append(str2);
                    sb.append(", ");
                }
                String str3 = c0529u.f6800d;
                if (str3 != null) {
                    sb.append(str3);
                    sb.append(", ");
                }
                String str4 = c0529u.f6801e;
                if (str4 != null) {
                    sb.append(str4);
                    sb.append(" ");
                }
                String str5 = c0529u.f6802f;
                if (str5 != null) {
                    sb.append(str5);
                }
                c0529u.f6797a = sb.toString().replaceAll(", $", "").trim();
                return !r10.isEmpty();
            }
        } catch (Exception e5) {
            Log.e("LocationService", "Android Geocoder failed", e5);
        }
        return false;
    }

    public final boolean l(double d5, double d6, C0529u c0529u) {
        try {
            Response responseExecute = this.f6817c.newCall(new Request.Builder().url(String.format(Locale.US, "https://nominatim.openstreetmap.org/reverse?format=json&lat=%.6f&lon=%.6f&zoom=18&addressdetails=1", Double.valueOf(d5), Double.valueOf(d6))).addHeader("User-Agent", "UnifiedRadios/1.0 (Android)").addHeader("Accept", "application/json").build()).execute();
            try {
                if (!responseExecute.isSuccessful()) {
                    throw new IOException("Nominatim API error: " + responseExecute.code() + " " + responseExecute.message());
                }
                String strString = responseExecute.body() != null ? responseExecute.body().string() : null;
                if (strString == null) {
                    throw new IOException("Empty response from Nominatim");
                }
                JSONObject jSONObject = new JSONObject(strString);
                if (!jSONObject.has("address")) {
                    responseExecute.close();
                    return false;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("address");
                c0529u.f6798b = jSONObject2.optString("house_number", null);
                c0529u.f6799c = jSONObject2.optString("road", null);
                c0529u.f6800d = jSONObject2.optString("city", jSONObject2.optString("town", jSONObject2.optString("village", null)));
                c0529u.f6801e = jSONObject2.optString("state", null);
                c0529u.f6802f = jSONObject2.optString("postcode", null);
                c0529u.g = jSONObject2.optString("country", null);
                String strOptString = jSONObject.optString("display_name", "");
                c0529u.f6797a = strOptString;
                boolean z4 = !strOptString.isEmpty();
                responseExecute.close();
                return z4;
            } finally {
            }
        } catch (Exception e5) {
            Log.e("LocationService", "Nominatim Geocoder failed", e5);
            return false;
        }
    }
}
