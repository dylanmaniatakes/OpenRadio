package o3;

import org.json.JSONObject;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final String f8950a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8951b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8952c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8953d;

    /* renamed from: e, reason: collision with root package name */
    public final String f8954e;

    /* renamed from: f, reason: collision with root package name */
    public final String f8955f;
    public final String g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public final String f8956i;

    /* renamed from: j, reason: collision with root package name */
    public final String f8957j;

    public s(JSONObject jSONObject) {
        this.f8950a = jSONObject.optString("server_id");
        jSONObject.optString("mode");
        jSONObject.optString("network");
        this.f8951b = jSONObject.optString("server");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("server_info");
        if (jSONObjectOptJSONObject != null) {
            this.f8952c = jSONObjectOptJSONObject.optString("hostname");
            this.f8953d = jSONObjectOptJSONObject.optInt("port");
            this.f8954e = jSONObjectOptJSONObject.optString("password");
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("location");
        if (jSONObjectOptJSONObject2 != null) {
            this.f8955f = jSONObjectOptJSONObject2.optString("city");
            this.g = jSONObjectOptJSONObject2.optString("state");
            this.h = jSONObjectOptJSONObject2.optString("country");
            jSONObjectOptJSONObject2.optString("country_code");
            jSONObjectOptJSONObject2.optDouble("latitude", 0.0d);
            jSONObjectOptJSONObject2.optDouble("longitude", 0.0d);
        }
        this.f8956i = jSONObject.optString("distance");
        this.f8957j = jSONObject.optString("comment");
    }

    public final String toString() {
        return this.f8951b + " - " + this.f8955f + ", " + this.h;
    }
}
