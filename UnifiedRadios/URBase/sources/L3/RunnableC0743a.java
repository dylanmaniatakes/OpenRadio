package l3;

import android.util.Log;
import android.widget.Toast;
import com.unified.ur1.radioteams.RadioTeamsActivity;
import e1.RunnableC0433a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: l3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0743a implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8393j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ RadioTeamsActivity f8394k;

    public /* synthetic */ RunnableC0743a(RadioTeamsActivity radioTeamsActivity, int i5) {
        this.f8393j = i5;
        this.f8394k = radioTeamsActivity;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        int i5 = 1;
        RadioTeamsActivity radioTeamsActivity = this.f8394k;
        switch (this.f8393j) {
            case 0:
                int i6 = RadioTeamsActivity.f6010u;
                radioTeamsActivity.getClass();
                try {
                    JSONObject jSONObject = new JSONObject(radioTeamsActivity.p("GET", "get_profile", null));
                    if (jSONObject.getBoolean("success")) {
                        radioTeamsActivity.n = jSONObject.getJSONObject("data");
                        radioTeamsActivity.f6024s.post(new RunnableC0433a(3));
                    } else {
                        radioTeamsActivity.f6024s.post(new RunnableC0743a(radioTeamsActivity, i5));
                    }
                    break;
                } catch (Exception e5) {
                    Log.e("RadioTeamsActivity", "Error loading user profile", e5);
                    radioTeamsActivity.f6024s.post(new RunnableC0743a(radioTeamsActivity, 2));
                    return;
                }
            case 1:
                int i7 = RadioTeamsActivity.f6010u;
                radioTeamsActivity.v();
                break;
            case 2:
                int i8 = RadioTeamsActivity.f6010u;
                radioTeamsActivity.v();
                break;
            case 3:
                int i9 = RadioTeamsActivity.f6010u;
                radioTeamsActivity.getClass();
                Toast.makeText(radioTeamsActivity, "Failed to save profile", 0).show();
                break;
            default:
                int i10 = RadioTeamsActivity.f6010u;
                radioTeamsActivity.getClass();
                try {
                    JSONObject jSONObject2 = new JSONObject(radioTeamsActivity.p("GET", "get_team_members", null));
                    if (jSONObject2.getBoolean("success")) {
                        JSONArray jSONArray = jSONObject2.getJSONObject("data").getJSONArray("members");
                        ArrayList arrayList = new ArrayList();
                        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                            arrayList.add(C0749g.a(jSONArray.getJSONObject(i11)));
                        }
                        radioTeamsActivity.f6024s.post(new g3.k(radioTeamsActivity, 15, arrayList));
                        break;
                    }
                } catch (Exception e6) {
                    Log.e("RadioTeamsActivity", "Error loading team members", e6);
                }
                break;
        }
    }
}
