package e3;

import D.m;
import android.util.Log;
import android.widget.Toast;
import com.unified.ur1.OnTheAir.UnifiedOnTheAirActivity;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: e3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0448b implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6201j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ UnifiedOnTheAirActivity f6202k;

    public /* synthetic */ RunnableC0448b(UnifiedOnTheAirActivity unifiedOnTheAirActivity, int i5) {
        this.f6201j = i5;
        this.f6202k = unifiedOnTheAirActivity;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        UnifiedOnTheAirActivity unifiedOnTheAirActivity = this.f6202k;
        int i5 = 0;
        switch (this.f6201j) {
            case 0:
                int i6 = UnifiedOnTheAirActivity.f5557u;
                unifiedOnTheAirActivity.getClass();
                Toast.makeText(unifiedOnTheAirActivity, "Error loading user data", 0).show();
                break;
            case 1:
                int i7 = UnifiedOnTheAirActivity.f5557u;
                unifiedOnTheAirActivity.getClass();
                Toast.makeText(unifiedOnTheAirActivity, "Please register your device through the Unified Radios Portal to Use Messages", 0).show();
                break;
            default:
                int i8 = UnifiedOnTheAirActivity.f5557u;
                unifiedOnTheAirActivity.getClass();
                try {
                    JSONObject jSONObject = new JSONObject(UnifiedOnTheAirActivity.o());
                    if (jSONObject.getBoolean("success")) {
                        JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("users");
                        ArrayList arrayList = new ArrayList();
                        for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                            arrayList.add(C0453g.a(jSONArray.getJSONObject(i9)));
                        }
                        unifiedOnTheAirActivity.f5568p.post(new m(unifiedOnTheAirActivity, 14, arrayList));
                        break;
                    }
                } catch (Exception e5) {
                    Log.e("UnifiedOnTheAir", "Error loading unified users", e5);
                    unifiedOnTheAirActivity.f5568p.post(new RunnableC0448b(unifiedOnTheAirActivity, i5));
                }
                break;
        }
    }
}
