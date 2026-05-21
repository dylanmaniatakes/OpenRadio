package k3;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class r implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8194j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8195k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f8196l;

    public /* synthetic */ r(LaunchActivity launchActivity, String str, int i5) {
        this.f8194j = i5;
        this.f8195k = launchActivity;
        this.f8196l = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.StringBuilder] */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        int responseCode;
        StringBuilder sb;
        ?? r22 = this.f8196l;
        LaunchActivity launchActivity = this.f8195k;
        switch (this.f8194j) {
            case 0:
                Context context = LaunchActivity.f5853D1;
                launchActivity.getClass();
                try {
                    String str = "https://ur1.unifiedradios.com/messages/messagesV2.php?cloud_auth=" + LaunchActivity.I1 + "&callsign=" + r22 + "?offset=0&limit=1";
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    Response responseExecute = builder.connectTimeout(5L, timeUnit).readTimeout(5L, timeUnit).build().newCall(new Request.Builder().url(str).build()).execute();
                    if (!responseExecute.isSuccessful() || responseExecute.body() == null) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(responseExecute.body().string());
                    if (jSONObject.has("unread_count")) {
                        launchActivity.runOnUiThread(new RunnableC0709s(launchActivity, jSONObject.getInt("unread_count"), 4));
                        return;
                    }
                    return;
                } catch (Exception e5) {
                    Log.e("Unified - Main Activity", "Error refreshing badge from API", e5);
                    return;
                }
            case 1:
                Context context2 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                BufferedReader bufferedReader = null;
                try {
                    try {
                        Log.d("Unified - Main Activity", "Initiating network request...");
                        r22 = (HttpURLConnection) new URL(r22).openConnection();
                        try {
                            r22.setRequestMethod("GET");
                            r22.setConnectTimeout(10000);
                            r22.setReadTimeout(15000);
                            r22.setRequestProperty("Cache-Control", "no-cache, no-store, must-revalidate");
                            r22.setRequestProperty("Pragma", "no-cache");
                            r22.setRequestProperty("Expires", "0");
                            r22.setRequestProperty("User-Agent", "UnifiedRadios/0.0.8-beta.13");
                            r22.setUseCaches(false);
                            responseCode = r22.getResponseCode();
                            Log.d("Unified - Main Activity", "HTTP Response Code: " + responseCode);
                        } catch (Exception e6) {
                            e = e6;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e7) {
                    e = e7;
                    r22 = 0;
                } catch (Throwable th2) {
                    th = th2;
                    r22 = 0;
                }
                if (responseCode != 200) {
                    throw new Exception("Server returned HTTP " + responseCode);
                }
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(r22.getInputStream()));
                try {
                    sb = new StringBuilder();
                } catch (Exception e8) {
                    e = e8;
                    bufferedReader = bufferedReader2;
                    Log.e("Unified - Main Activity", "Network validation failed", e);
                    launchActivity.runOnUiThread(new RunnableC0717w(launchActivity, e, 1));
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (r22 == 0) {
                        return;
                    }
                    r22.disconnect();
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (r22 == 0) {
                        throw th;
                    }
                    r22.disconnect();
                    throw th;
                }
                while (true) {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        String string = sb.toString();
                        Log.d("Unified - Main Activity", "Server response received: " + string);
                        launchActivity.runOnUiThread(new r(launchActivity, string, 2));
                        try {
                            bufferedReader2.close();
                        } catch (Exception unused3) {
                        }
                        r22.disconnect();
                        return;
                    }
                    sb.append(line);
                }
            case 2:
                Context context3 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                try {
                    JSONObject jSONObject2 = new JSONObject((String) r22);
                    String lowerCase = jSONObject2.optString("status", "").toLowerCase();
                    Log.i("Unified - Main Activity", "Validation status: " + lowerCase);
                    if (!"success".equals(lowerCase)) {
                        String strOptString = jSONObject2.optString("message", "Unknown validation error");
                        Log.e("Unified - Main Activity", "Validation failed: " + strOptString);
                        launchActivity.x0("Validation failed: " + strOptString);
                        return;
                    }
                    if (!jSONObject2.has("callsign") || jSONObject2.isNull("callsign")) {
                        Log.w("Unified - Main Activity", "Device validated but not linked to account");
                        launchActivity.P0("local_id", String.valueOf(888));
                        launchActivity.x0("Device cannot be validated.\nPlease visit my.unifiedradios.com to link your device to an account.");
                        return;
                    }
                    launchActivity.f5900U = jSONObject2.getString("callsign");
                    String strOptString2 = jSONObject2.optString("radio_id", "Unknown");
                    Log.i("Unified - Main Activity", "Device validated - Callsign: " + launchActivity.f5900U + ", Radio ID: " + strOptString2);
                    h4.c.L(launchActivity, launchActivity.f5900U);
                    launchActivity.P0("callsign", launchActivity.f5900U);
                    launchActivity.P0("local_id", String.valueOf(launchActivity.f5871E));
                    launchActivity.C0("Device validated successfully!\nCallsign: " + launchActivity.f5900U + "\nDMR ID: " + strOptString2);
                    ((TextView) launchActivity.findViewById(R.id.validate)).setVisibility(8);
                    LinearLayout linearLayout = (LinearLayout) launchActivity.findViewById(R.id.buttonbar);
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0696l(launchActivity, 29), 2000L);
                    launchActivity.onResume();
                    return;
                } catch (JSONException e9) {
                    Log.e("Unified - Main Activity", "Failed to parse server response", e9);
                    launchActivity.x0("Invalid response from validation server.\nPlease try again later.");
                    return;
                }
            case 3:
                Context context4 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                launchActivity.D0("✓ Disconnected from all talkgroups (" + r22 + ")");
                return;
            default:
                Context context5 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                launchActivity.D0("✗ " + r22);
                return;
        }
    }
}
