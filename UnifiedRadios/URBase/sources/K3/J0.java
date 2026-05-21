package k3;

import android.util.Log;
import com.unified.ur1.primary.OptionsActivity;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes.dex */
public final /* synthetic */ class J0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7977j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f7978k;

    public /* synthetic */ J0() {
        this.f7977j = 1;
        this.f7978k = "Component Initialization";
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        String str = this.f7978k;
        switch (this.f7977j) {
            case 0:
                int i5 = OptionsActivity.f5981H;
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestProperty("Cache-Control", "no-cache, no-store, must-revalidate");
                    httpURLConnection.setRequestProperty("Pragma", "no-cache");
                    httpURLConnection.setRequestProperty("Expires", "0");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(8000);
                    httpURLConnection.setReadTimeout(10000);
                    Log.d("Unified - Settings", "Response code: " + httpURLConnection.getResponseCode());
                    httpURLConnection.disconnect();
                    break;
                } catch (Exception e5) {
                    Log.e("Unified - Settings", "Error sending request: " + e5.getMessage());
                    e5.printStackTrace();
                    return;
                }
            case 1:
                int i6 = OptionsActivity.f5981H;
                Log.w("Unified - Settings", "Potential ANR detected in: " + str);
                break;
            default:
                int i7 = OptionsActivity.f5981H;
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection2.setRequestProperty("Cache-Control", "no-cache, no-store, must-revalidate");
                    httpURLConnection2.setRequestProperty("Pragma", "no-cache");
                    httpURLConnection2.setRequestProperty("Expires", "0");
                    httpURLConnection2.setRequestMethod("GET");
                    httpURLConnection2.setConnectTimeout(8000);
                    httpURLConnection2.setReadTimeout(10000);
                    Log.d("Unified - Settings", "Response code: " + httpURLConnection2.getResponseCode());
                    httpURLConnection2.disconnect();
                    break;
                } catch (Exception e6) {
                    Log.e("Unified - Settings", "Error sending request: " + e6.getMessage());
                    e6.printStackTrace();
                }
        }
    }

    public /* synthetic */ J0(String str, int i5) {
        this.f7977j = i5;
        this.f7978k = str;
    }
}
