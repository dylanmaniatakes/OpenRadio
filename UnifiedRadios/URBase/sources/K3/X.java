package k3;

import android.widget.Toast;
import com.unified.ur1.primary.LaunchActivity;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class X implements o3.r, Callback {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8096c;

    public /* synthetic */ X(LaunchActivity launchActivity) {
        this.f8096c = launchActivity;
    }

    @Override // o3.r
    public void l() {
        Toast.makeText(this.f8096c, "Talkgroup selection cancelled", 0).show();
    }

    @Override // o3.r
    public void n(o3.v vVar, String str, String str2, o3.s sVar) throws Throwable {
        LaunchActivity.A(this.f8096c, vVar, str2, sVar);
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        this.f8096c.runOnUiThread(new RunnableC0707q0(iOException, 1));
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        LaunchActivity launchActivity = this.f8096c;
        try {
            ResponseBody responseBodyBody = response.body();
            try {
                if (!response.isSuccessful() || responseBodyBody == null) {
                    throw new IOException("Server error: " + response.code());
                }
                JSONObject jSONObject = new JSONObject(responseBodyBody.string());
                launchActivity.runOnUiThread(new RunnableC0703o0(jSONObject.optString("status"), 1, jSONObject.optString("message")));
                responseBodyBody.close();
            } finally {
            }
        } catch (Exception e5) {
            launchActivity.runOnUiThread(new RunnableC0705p0(e5, 1));
        }
    }
}
