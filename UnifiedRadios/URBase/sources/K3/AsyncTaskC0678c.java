package k3;

import android.os.AsyncTask;
import android.util.Log;
import com.unified.ur1.primary.AppSettings;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* renamed from: k3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class AsyncTaskC0678c extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8108a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppSettings f8109b;

    public /* synthetic */ AsyncTaskC0678c(AppSettings appSettings, int i5) {
        this.f8108a = i5;
        this.f8109b = appSettings;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) throws IOException {
        switch (this.f8108a) {
            case 0:
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(((String[]) objArr)[0]).openConnection();
                    httpURLConnection.setRequestProperty("Cache-Control", "no-cache, no-store, must-revalidate");
                    httpURLConnection.setRequestProperty("Pragma", "no-cache");
                    httpURLConnection.setRequestProperty("Expires", "0");
                    httpURLConnection.setUseCaches(false);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            return new JSONObject(sb.toString());
                        }
                        sb.append(line);
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                    return null;
                }
            default:
                try {
                    String string = this.f8109b.getSharedPreferences("app_settings", 0).getString("auth_code_1", null);
                    if (string == null) {
                        Log.e("Unified - Settings", "Auth code not found in SharedPreferences");
                        return null;
                    }
                    String str = String.format("https://ur1.unifiedradios.com/telemetry.php?cloud_auth=%s&_t=%d", string, Long.valueOf(System.currentTimeMillis()));
                    Log.d("Unified - Settings", "Making fresh server request to: ".concat(str));
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection2.setConnectTimeout(5000);
                    httpURLConnection2.setReadTimeout(5000);
                    httpURLConnection2.setRequestProperty("Cache-Control", "no-cache, no-store, must-revalidate");
                    httpURLConnection2.setRequestProperty("Pragma", "no-cache");
                    httpURLConnection2.setRequestProperty("Expires", "0");
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setRequestMethod("GET");
                    try {
                        int responseCode = httpURLConnection2.getResponseCode();
                        Log.d("Unified - Settings", "Server response code: " + responseCode);
                        if (responseCode != 200) {
                            Log.w("Unified - Settings", "Server returned error code: " + responseCode);
                            httpURLConnection2.disconnect();
                            return null;
                        }
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
                        StringBuilder sb2 = new StringBuilder();
                        while (true) {
                            String line2 = bufferedReader2.readLine();
                            if (line2 == null) {
                                bufferedReader2.close();
                                String strTrim = sb2.toString().trim();
                                Log.d("Unified - Settings", "Fresh server response received: " + strTrim);
                                httpURLConnection2.disconnect();
                                return strTrim;
                            }
                            sb2.append(line2);
                            sb2.append("\n");
                        }
                    } finally {
                        httpURLConnection2.disconnect();
                    }
                } catch (Exception e6) {
                    Log.e("Unified - Settings", "Error making fresh network request: " + e6.getMessage());
                    e6.printStackTrace();
                    return null;
                }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00e4  */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onPostExecute(java.lang.Object r15) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.AsyncTaskC0678c.onPostExecute(java.lang.Object):void");
    }
}
