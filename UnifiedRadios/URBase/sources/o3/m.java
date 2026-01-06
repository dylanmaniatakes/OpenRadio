package o3;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements Q0.k, Q0.j {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8942c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x f8943d;

    public /* synthetic */ m(x xVar, int i5) {
        this.f8942c = i5;
        this.f8943d = xVar;
    }

    @Override // Q0.k
    public void a(JSONObject jSONObject) throws JSONException {
        int i5;
        switch (this.f8942c) {
            case 0:
                x xVar = this.f8943d;
                xVar.getClass();
                try {
                    if (jSONObject.getBoolean("success")) {
                        JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("networks");
                        xVar.f8992j.clear();
                        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                            xVar.f8992j.add(jSONArray.getString(i6));
                        }
                        xVar.j();
                        break;
                    } else {
                        xVar.k("Failed to load networks");
                        break;
                    }
                } catch (JSONException unused) {
                    xVar.k("Error parsing network data");
                    return;
                }
            case 1:
                x xVar2 = this.f8943d;
                xVar2.getClass();
                try {
                    if (jSONObject.getBoolean("success")) {
                        JSONArray jSONArray2 = jSONObject.getJSONObject("data").getJSONArray("talkgroups");
                        xVar2.f8993k.clear();
                        xVar2.f8994l.clear();
                        for (int i7 = 0; i7 < jSONArray2.length(); i7++) {
                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i7);
                            v vVar = new v(jSONObject2.optString("tg_id"), jSONObject2.optString("network"), jSONObject2.optString("talkgroup"), jSONObject2.optString("description"), jSONObject2.optString("full_description"));
                            xVar2.f8993k.add(vVar);
                            xVar2.f8994l.add(vVar);
                        }
                        xVar2.h.notifyDataSetChanged();
                        xVar2.m();
                        break;
                    } else {
                        xVar2.k("Failed to load talkgroups");
                        break;
                    }
                } catch (JSONException unused2) {
                    xVar2.k("Error parsing talkgroup data");
                    return;
                }
            default:
                x xVar3 = this.f8943d;
                xVar3.getClass();
                try {
                    if (jSONObject.getBoolean("success")) {
                        JSONArray jSONArray3 = jSONObject.getJSONObject("data").getJSONArray("servers");
                        xVar3.f8995m.clear();
                        xVar3.n.clear();
                        while (i5 < jSONArray3.length()) {
                            s sVar = new s(jSONArray3.getJSONObject(i5));
                            xVar3.f8995m.add(sVar);
                            xVar3.n.add(sVar);
                            String str = xVar3.f8983G;
                            i5 = (str == null || !(sVar.f8950a.equals(str) || sVar.f8951b.equals(xVar3.f8983G) || sVar.f8952c.equals(xVar3.f8983G))) ? i5 + 1 : 0;
                            xVar3.f8990f = sVar;
                            Log.d("ROIP", "Auto-selected server: " + sVar.f8951b);
                            xVar3.f8984H = 3;
                            xVar3.n();
                            xVar3.h();
                            break;
                        }
                        if (xVar3.f8990f == null) {
                            xVar3.f8991i.notifyDataSetChanged();
                            xVar3.m();
                            break;
                        } else {
                            xVar3.f8991i.notifyDataSetChanged();
                            xVar3.m();
                            break;
                        }
                    } else {
                        xVar3.k("Failed to load servers");
                        break;
                    }
                } catch (JSONException e5) {
                    xVar3.k("Error parsing server data: " + e5.getMessage());
                }
                break;
        }
    }

    @Override // Q0.j
    public void b(Q0.l lVar) {
        this.f8943d.k("Network error");
    }
}
