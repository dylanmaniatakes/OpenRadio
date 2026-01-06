package k3;

import com.unified.ur1.primary.LaunchActivity;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class U implements Callback {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8056c;

    public /* synthetic */ U(LaunchActivity launchActivity) {
        this.f8056c = launchActivity;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        this.f8056c.runOnUiThread(new RunnableC0707q0(iOException, 0));
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        LaunchActivity launchActivity = this.f8056c;
        try {
            ResponseBody responseBodyBody = response.body();
            try {
                if (!response.isSuccessful() || responseBodyBody == null) {
                    throw new IOException("Unexpected response: " + response);
                }
                JSONObject jSONObject = new JSONObject(responseBodyBody.string());
                launchActivity.runOnUiThread(new RunnableC0703o0(jSONObject.optString("status"), 0, jSONObject.optString("message")));
                responseBodyBody.close();
            } finally {
            }
        } catch (Exception e5) {
            launchActivity.runOnUiThread(new RunnableC0705p0(e5, 0));
        }
    }
}
