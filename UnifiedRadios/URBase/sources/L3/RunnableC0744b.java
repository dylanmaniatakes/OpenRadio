package l3;

import android.util.Log;
import com.unified.ur1.radioteams.RadioTeamsActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: l3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0744b implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8395j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ RadioTeamsActivity f8396k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f8397l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8398m;
    public final /* synthetic */ String n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0748f f8399o;

    public /* synthetic */ RunnableC0744b(RadioTeamsActivity radioTeamsActivity, String str, String str2, String str3, InterfaceC0748f interfaceC0748f, int i5) {
        this.f8395j = i5;
        this.f8396k = radioTeamsActivity;
        this.f8397l = str;
        this.f8398m = str2;
        this.n = str3;
        this.f8399o = interfaceC0748f;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        String str = this.n;
        String str2 = this.f8398m;
        String str3 = this.f8397l;
        switch (this.f8395j) {
            case 0:
                int i5 = RadioTeamsActivity.f6010u;
                this.f8396k.s(str3, str2, str);
                this.f8399o.m();
                break;
            default:
                InterfaceC0748f interfaceC0748f = this.f8399o;
                int i6 = RadioTeamsActivity.f6010u;
                RadioTeamsActivity radioTeamsActivity = this.f8396k;
                radioTeamsActivity.getClass();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "login");
                    jSONObject.put("team_id", str3);
                    jSONObject.put("callsign", str2);
                    jSONObject.put("cloud_auth", str);
                    Log.d("RadioTeamsActivity", "Sending login request: " + jSONObject.toString());
                    String strP = radioTeamsActivity.p("POST", null, jSONObject);
                    Log.d("RadioTeamsActivity", "Login response: " + strP);
                    JSONObject jSONObject2 = new JSONObject(strP);
                    if (jSONObject2.getBoolean("success")) {
                        String string = jSONObject2.getJSONObject("data").getString("session_token");
                        String string2 = jSONObject2.getJSONObject("data").getString("team_id");
                        String string3 = jSONObject2.getJSONObject("data").getString("callsign");
                        Log.d("RadioTeamsActivity", "Login successful, received token: " + string.substring(0, 8) + "...");
                        radioTeamsActivity.f6024s.post(new RunnableC0744b(radioTeamsActivity, string, string2, string3, interfaceC0748f, 0));
                    } else {
                        String string4 = jSONObject2.getString("message");
                        Log.e("RadioTeamsActivity", "Login failed: " + string4);
                        radioTeamsActivity.f6024s.post(new g3.k(interfaceC0748f, 16, string4));
                    }
                    break;
                } catch (Exception e5) {
                    Log.e("RadioTeamsActivity", "Login error", e5);
                    radioTeamsActivity.f6024s.post(new g3.k(interfaceC0748f, 17, e5));
                    return;
                }
        }
    }
}
