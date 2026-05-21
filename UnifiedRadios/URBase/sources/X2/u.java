package X2;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: d, reason: collision with root package name */
    public static final long f2837d = TimeUnit.DAYS.toMillis(7);

    /* renamed from: a, reason: collision with root package name */
    public final String f2838a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2839b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2840c;

    public u(String str, String str2, long j5) {
        this.f2838a = str;
        this.f2839b = str2;
        this.f2840c = j5;
    }

    public static String a(String str, String str2, long j5) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j5);
            return jSONObject.toString();
        } catch (JSONException e5) {
            Log.w("FirebaseMessaging", "Failed to encode token: " + e5);
            return null;
        }
    }

    public static u b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new u(str, null, 0L);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new u(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
        } catch (JSONException e5) {
            Log.w("FirebaseMessaging", "Failed to parse token: " + e5);
            return null;
        }
    }
}
