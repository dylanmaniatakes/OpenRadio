package o3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements Q0.k, Q0.j {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x f8940c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f8941d;

    public /* synthetic */ l(x xVar, String str) {
        this.f8940c = xVar;
        this.f8941d = str;
    }

    @Override // Q0.k
    public void a(JSONObject jSONObject) throws JSONException {
        String str = this.f8941d;
        x xVar = this.f8940c;
        xVar.f8977A.setVisibility(8);
        try {
            if (!jSONObject.getBoolean("success")) {
                if (x.f(str)) {
                    xVar.f8994l.clear();
                    xVar.f8994l.add(xVar.b(str));
                    xVar.h.notifyDataSetChanged();
                    xVar.m();
                    return;
                }
                return;
            }
            JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("talkgroups");
            xVar.f8994l.clear();
            boolean z4 = false;
            for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                String strOptString = jSONObject2.optString("tg_id");
                String strOptString2 = jSONObject2.optString("network");
                String strOptString3 = jSONObject2.optString("talkgroup");
                xVar.f8994l.add(new v(strOptString, strOptString2, strOptString3, jSONObject2.optString("description"), jSONObject2.optString("full_description")));
                if (strOptString3.equals(str.trim())) {
                    z4 = true;
                }
            }
            if (!z4 && x.f(str)) {
                xVar.f8994l.add(0, xVar.b(str));
            }
            xVar.h.notifyDataSetChanged();
            xVar.m();
        } catch (JSONException unused) {
            if (x.f(str)) {
                xVar.f8994l.clear();
                xVar.f8994l.add(xVar.b(str));
                xVar.h.notifyDataSetChanged();
                xVar.m();
            }
        }
    }

    @Override // Q0.j
    public void b(Q0.l lVar) {
        x xVar = this.f8940c;
        xVar.f8977A.setVisibility(8);
        String str = this.f8941d;
        if (x.f(str)) {
            xVar.f8994l.clear();
            xVar.f8994l.add(xVar.b(str));
            xVar.h.notifyDataSetChanged();
            xVar.m();
        }
    }
}
