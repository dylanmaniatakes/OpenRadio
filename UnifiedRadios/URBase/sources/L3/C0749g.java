package l3;

import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: l3.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0749g {

    /* renamed from: a, reason: collision with root package name */
    public String f8404a;

    /* renamed from: b, reason: collision with root package name */
    public double f8405b;

    /* renamed from: c, reason: collision with root package name */
    public double f8406c;

    /* renamed from: d, reason: collision with root package name */
    public String f8407d;

    /* renamed from: e, reason: collision with root package name */
    public String f8408e;

    /* renamed from: f, reason: collision with root package name */
    public String f8409f;
    public String g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public String f8410i;

    /* renamed from: j, reason: collision with root package name */
    public String f8411j;

    /* renamed from: k, reason: collision with root package name */
    public JSONArray f8412k;

    public static C0749g a(JSONObject jSONObject) {
        C0749g c0749g = new C0749g();
        c0749g.f8404a = jSONObject.optString("callsign", "");
        c0749g.f8405b = jSONObject.optDouble("latitude", 0.0d);
        c0749g.f8406c = jSONObject.optDouble("longitude", 0.0d);
        c0749g.f8407d = jSONObject.optString("status", "offline");
        c0749g.f8408e = jSONObject.optString("computed_status", "offline");
        c0749g.f8409f = jSONObject.optString("last_seen", "Unknown");
        c0749g.g = jSONObject.optString("primary_role", null);
        c0749g.h = jSONObject.optString("organization", null);
        c0749g.f8410i = jSONObject.optString("vehicle_type", null);
        c0749g.f8411j = jSONObject.optString("supply_days", null);
        c0749g.f8412k = jSONObject.optJSONArray("specialized_skills");
        return c0749g;
    }

    public final String b() {
        if ("emergency".equals(this.f8407d)) {
            return "🚨 EMERGENCY";
        }
        if ("online".equals(this.f8408e)) {
            return "✅ Online - " + this.f8409f;
        }
        return "⚫ Offline - " + this.f8409f;
    }

    public final boolean c() {
        return (this.f8405b == 0.0d || this.f8406c == 0.0d) ? false : true;
    }
}
