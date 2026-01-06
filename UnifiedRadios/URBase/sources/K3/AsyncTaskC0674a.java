package k3;

import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: k3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class AsyncTaskC0674a extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f8100a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f8101b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f8102c;

    public AsyncTaskC0674a(String str, String str2, String str3) {
        this.f8100a = str;
        this.f8101b = str2;
        this.f8102c = str3;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) throws IOException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(((String[]) objArr)[0]).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Cache-Control", "no-cache, no-store, must-revalidate");
            httpURLConnection.setRequestProperty("Pragma", "no-cache");
            httpURLConnection.setRequestProperty("Expires", "0");
            httpURLConnection.setUseCaches(false);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    Log.d("Unified - Settings", "Settings update response code: " + httpURLConnection.getResponseCode());
                    Log.d("Unified - Settings", "Settings update response: " + sb.toString());
                    Log.d("Unified - Settings", "Sent settings - MARS: " + this.f8100a + ", TX Disable: " + this.f8101b + ", Metric: " + this.f8102c);
                    httpURLConnection.disconnect();
                    return sb.toString();
                }
                sb.append(line);
                sb.append("\n");
            }
        } catch (Exception e5) {
            Log.e("Unified - Settings", "Error sending settings update: " + e5.getMessage());
            e5.printStackTrace();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        String str = (String) obj;
        if (str != null) {
            Log.d("Unified - Settings", "Settings update succeeded: ".concat(str));
        } else {
            Log.e("Unified - Settings", "Settings update failed");
        }
    }
}
