package l3;

import org.json.JSONObject;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public String f8423a;

    /* renamed from: b, reason: collision with root package name */
    public String f8424b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8425c;

    /* renamed from: d, reason: collision with root package name */
    public long f8426d;

    public static k a(JSONObject jSONObject) {
        k kVar = new k();
        kVar.f8423a = jSONObject.optString("team_id", "");
        kVar.f8424b = jSONObject.optString("callsign", "");
        kVar.f8425c = jSONObject.optBoolean("auto_connect", false);
        kVar.f8426d = jSONObject.optLong("last_checked", 0L);
        return kVar;
    }
}
