package e3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: e3.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0453g {

    /* renamed from: a, reason: collision with root package name */
    public long f6213a;

    /* renamed from: b, reason: collision with root package name */
    public String f6214b;

    /* renamed from: c, reason: collision with root package name */
    public String f6215c;

    /* renamed from: d, reason: collision with root package name */
    public String f6216d;

    /* renamed from: e, reason: collision with root package name */
    public String f6217e;

    /* renamed from: f, reason: collision with root package name */
    public String f6218f;
    public double g;
    public double h;

    /* renamed from: i, reason: collision with root package name */
    public long f6219i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6220j;

    public static C0453g a(JSONObject jSONObject) throws ParseException {
        C0453g c0453g = new C0453g();
        c0453g.f6213a = jSONObject.optLong("unified_id", 0L);
        jSONObject.optString("cloud_auth", "");
        c0453g.f6214b = jSONObject.optString("device_manufacturer", "");
        c0453g.f6215c = jSONObject.optString("device_model", "");
        c0453g.f6216d = jSONObject.optString("os_version", "");
        jSONObject.optString("os_uid", "");
        c0453g.f6217e = jSONObject.optString("app_version", "");
        jSONObject.optString("rom_version", "");
        jSONObject.optString("rf_version", "");
        c0453g.f6218f = jSONObject.optString("callsign", "");
        c0453g.g = jSONObject.optDouble("lat", 0.0d);
        c0453g.h = jSONObject.optDouble("lng", 0.0d);
        jSONObject.optString("ip", "");
        h(jSONObject.optString("unified_created", ""));
        c0453g.f6219i = h(jSONObject.optString("unified_updated", ""));
        "Yes".equals(jSONObject.optString("tamper", "No"));
        jSONObject.optString("dmr_essid", "10");
        c0453g.f6220j = "On".equals(jSONObject.optString("is_private", "Off"));
        jSONObject.optString("aprs", "0");
        "On".equals(jSONObject.optString("tx_full", "Off"));
        "On".equals(jSONObject.optString("tx_disable", "Off"));
        "On".equals(jSONObject.optString("metric", "Off"));
        "On".equals(jSONObject.optString("early_access", "Off"));
        "On".equals(jSONObject.optString("dev_access", "Off"));
        jSONObject.optString("device_nickname", "");
        "On".equals(jSONObject.optString("aprs_ambiguity", "Off"));
        return c0453g;
    }

    public static long h(String str) throws ParseException {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(str);
            if (date != null) {
                return date.getTime();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public final String b() {
        if (this.f6219i == 0) {
            return "Unknown";
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f6219i;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long minutes = timeUnit.toMinutes(jCurrentTimeMillis);
        long hours = timeUnit.toHours(jCurrentTimeMillis);
        long days = timeUnit.toDays(jCurrentTimeMillis);
        if (minutes < 1) {
            return "Just now";
        }
        if (minutes < 60) {
            return minutes + " minutes ago";
        }
        if (hours < 24) {
            return hours + " hours ago";
        }
        return days + " days ago";
    }

    public final String c() {
        return f() ? "🟢 Online Now" : e() ? "🟡 Online" : "⚫ Offline";
    }

    public final boolean d() {
        return (this.g == 0.0d || this.h == 0.0d) ? false : true;
    }

    public final boolean e() {
        return System.currentTimeMillis() - this.f6219i < TimeUnit.MINUTES.toMillis(30L);
    }

    public final boolean f() {
        return System.currentTimeMillis() - this.f6219i < TimeUnit.MINUTES.toMillis(5L);
    }

    public final boolean g(String str) {
        if (!d()) {
            return false;
        }
        str.getClass();
        switch (str) {
            case "canada":
                double d5 = this.g;
                if (d5 >= 42.0d && d5 <= 83.0d) {
                    double d6 = this.h;
                    if (d6 >= -141.0d && d6 <= -52.0d) {
                        return true;
                    }
                }
                return false;
            case "usa":
                double d7 = this.g;
                if (d7 >= 24.0d && d7 <= 49.0d) {
                    double d8 = this.h;
                    if (d8 >= -125.0d && d8 <= -66.0d) {
                        return true;
                    }
                }
                return false;
            case "international":
                return (g("usa") || g("canada")) ? false : true;
            default:
                return true;
        }
    }
}
