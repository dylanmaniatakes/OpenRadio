package k3;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: k3.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0704p implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8183j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8184k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ List f8185l;

    public /* synthetic */ RunnableC0704p(LaunchActivity launchActivity, ArrayList arrayList, int i5) {
        this.f8183j = i5;
        this.f8184k = launchActivity;
        this.f8185l = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        BufferedReader bufferedReader;
        StringBuilder sb;
        LaunchActivity launchActivity = this.f8184k;
        List list = this.f8185l;
        switch (this.f8183j) {
            case 0:
                Context context = LaunchActivity.f5853D1;
                launchActivity.getClass();
                launchActivity.D0("⚠️ Error processing response for TGs: " + TextUtils.join(", ", list));
                return;
            case 1:
                Context context2 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                launchActivity.getApplicationContext().getSharedPreferences("AppSettings", 0).getString("CloudAuth", "");
                try {
                    Log.i("Unified - Main Activity", "Calling upon Brandmeister gods to allow access to their divine network via Multi-RX for talkgroups=" + list);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    StringBuilder sb2 = new StringBuilder();
                    String string = launchActivity.getSharedPreferences("app_settings", 0).getString("auth_code_1", null);
                    sb2.append("https://ur1.unifiedradios.com/bm_tg.php?cloud_auth=");
                    sb2.append(string);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        int iIntValue = ((Integer) it.next()).intValue();
                        sb2.append("&tg[]=");
                        sb2.append(iIntValue);
                    }
                    sb2.append("&_t=");
                    sb2.append(jCurrentTimeMillis);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(sb2.toString()).openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setRequestProperty("User-Agent", "DMRBridge/1.0");
                    httpURLConnection.setRequestProperty("Accept", "application/json, text/plain, */*");
                    int responseCode = httpURLConnection.getResponseCode();
                    Log.d("Unified - Main Activity", "UR1 Multi-RX API response code: " + responseCode);
                    if (responseCode == 200) {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
                        try {
                            StringBuilder sb3 = new StringBuilder();
                            while (true) {
                                String line = bufferedReader2.readLine();
                                if (line == null) {
                                    String string2 = sb3.toString();
                                    Log.i("Unified - Main Activity", "UR1 Multi-RX API response: " + string2);
                                    launchActivity.g0(string2, (ArrayList) list, true);
                                    Log.i("Unified - Main Activity", "Successfully called UR1 Multi-RX API for TGs " + list);
                                    h4.c.f0(launchActivity, true);
                                    launchActivity.runOnUiThread(new RunnableC0704p(launchActivity, (ArrayList) list, 2));
                                    bufferedReader2.close();
                                    return;
                                }
                                sb3.append(line.trim());
                            }
                        } finally {
                            try {
                                bufferedReader2.close();
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        }
                    } else {
                        Log.e("Unified - Main Activity", "UR1 Multi-RX API call failed with response code: " + responseCode);
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream(), "utf-8"));
                            try {
                                sb = new StringBuilder();
                            } finally {
                            }
                        } catch (Exception e5) {
                            Log.e("Unified - Main Activity", "Failed to read error response", e5);
                            launchActivity.D0("Failed to set TGs " + list + " (HTTP " + responseCode + ")");
                        }
                        while (true) {
                            String line2 = bufferedReader.readLine();
                            if (line2 == null) {
                                String string3 = sb.toString();
                                Log.e("Unified - Main Activity", "UR1 Multi-RX API error response: " + string3);
                                launchActivity.g0(string3, (ArrayList) list, false);
                                bufferedReader.close();
                                httpURLConnection.disconnect();
                                return;
                            }
                            sb.append(line2);
                        }
                    }
                } catch (Exception e6) {
                    Log.e("Unified - Main Activity", "Exception calling UR1 Multi-RX API", e6);
                    return;
                }
                Log.e("Unified - Main Activity", "Exception calling UR1 Multi-RX API", e6);
                return;
            default:
                Context context3 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                try {
                    TextView textView = (TextView) launchActivity.findViewById(R.id.activeFrequency);
                    textView.setText("Multi-RX");
                    textView.setTextSize(1, 60.0f);
                    ((TextView) launchActivity.findViewById(R.id.network)).setText(h4.c.y(launchActivity) + " - " + list);
                    return;
                } catch (Exception unused) {
                    return;
                }
        }
    }
}
