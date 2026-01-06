package f3;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import e1.RunnableC0433a;
import f.DialogC0469f;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import k3.RunnableC0721z;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class U implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6639j = 2;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f6640k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f6641l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f6642m;
    public final /* synthetic */ Object n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f6643o;

    public /* synthetic */ U(LaunchActivity launchActivity, String str, String str2, String str3, String str4, String str5) {
        this.f6640k = launchActivity;
        this.f6642m = str;
        this.n = str2;
        this.f6641l = str3;
        this.f6643o = str4;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() throws InterruptedException, IOException {
        Object obj = this.n;
        Object obj2 = this.f6642m;
        Object obj3 = this.f6643o;
        Object obj4 = this.f6641l;
        Object obj5 = this.f6640k;
        switch (this.f6639j) {
            case 0:
                final m0 m0Var = (m0) obj4;
                String str = (String) obj2;
                final String str2 = (String) obj;
                final DialogC0469f dialogC0469f = (DialogC0469f) obj3;
                final f0 f0Var = (f0) obj5;
                Context context = f0Var.f6710b;
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://ur1.unifiedradios.com/repeater_pull.php").openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setConnectTimeout(3000);
                    httpURLConnection.setReadTimeout(3000);
                    String str3 = "callsign=" + m0Var.f6745a + "&submitted_by=" + str + "&note=" + str2;
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    try {
                        byte[] bytes = str3.getBytes("utf-8");
                        outputStream.write(bytes, 0, bytes.length);
                        outputStream.close();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    final JSONObject jSONObject = new JSONObject(sb.toString());
                                    final boolean z4 = jSONObject.getBoolean("success");
                                    ((Activity) context).runOnUiThread(new Runnable() { // from class: f3.Z
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            f0 f0Var2 = f0Var;
                                            Context context2 = f0Var2.f6710b;
                                            if (!z4) {
                                                Toast.makeText(context2, "Error submitting note: " + jSONObject.optString("message", "Unknown error"), 1).show();
                                                return;
                                            }
                                            Toast.makeText(context2, "Note submitted successfully", 0).show();
                                            dialogC0469f.dismiss();
                                            StringBuilder sb2 = new StringBuilder();
                                            m0 m0Var2 = m0Var;
                                            sb2.append(m0Var2.f6753k);
                                            sb2.append(m0Var2.f6753k.isEmpty() ? "" : "\n");
                                            sb2.append(str2);
                                            m0Var2.f6753k = sb2.toString();
                                            f0Var2.notifyDataSetChanged();
                                        }
                                    });
                                    bufferedReader.close();
                                    return;
                                }
                                sb.append(line.trim());
                            }
                        } catch (Throwable th) {
                            try {
                                bufferedReader.close();
                                throw th;
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                                throw th;
                            }
                        }
                    } finally {
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                    ((Activity) context).runOnUiThread(new Y(f0Var, e5, 1));
                    return;
                }
            case 1:
                DMRBridge dMRBridge = (DMRBridge) obj2;
                ProgressDialog progressDialog = (ProgressDialog) obj;
                m0 m0Var2 = (m0) obj4;
                Context context2 = (Context) obj3;
                f0 f0Var2 = (f0) obj5;
                f0Var2.getClass();
                try {
                    dMRBridge.s();
                    dMRBridge.g();
                    for (int i5 = 0; dMRBridge.isSocketConnected() && i5 < 6000; i5 += 200) {
                        Thread.sleep(200);
                    }
                    if (dMRBridge.isSocketConnected()) {
                        Log.w("Unified - RepeaterDir", "ROIP disconnect timeout - forcing cleanup");
                        dMRBridge.i();
                        dMRBridge.h();
                    }
                    Log.d("Unified - RepeaterDir", "ROIP disconnect completed");
                    Handler handler = new Handler(Looper.getMainLooper());
                    new Thread(new RunnableC0433a(1)).start();
                    handler.postDelayed(new RunnableC0506a0(f0Var2, progressDialog, m0Var2, context2, 0), DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
                    return;
                } catch (Exception e6) {
                    Log.e("Unified - RepeaterDir", "Error during ROIP disconnect", e6);
                    ((Activity) f0Var2.f6710b).runOnUiThread(new D0.f(f0Var2, progressDialog, e6, 6));
                    return;
                }
            default:
                Context context3 = LaunchActivity.f5853D1;
                LaunchActivity launchActivity = (LaunchActivity) obj5;
                LocationManager locationManager = (LocationManager) launchActivity.getSystemService("location");
                if (C.h.a(launchActivity, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                    B.e.d(launchActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1001);
                    return;
                }
                if (locationManager.getLastKnownLocation("gps") == null) {
                    Location location = new Location("dummy");
                    location.setLatitude(0.0d);
                    location.setLongitude(0.0d);
                }
                String str4 = LaunchActivity.I1;
                SharedPreferences sharedPreferences = launchActivity.getSharedPreferences("app_settings", 0);
                sharedPreferences.getFloat("last_latitude", BitmapDescriptorFactory.HUE_RED);
                sharedPreferences.getFloat("last_longitude", BitmapDescriptorFactory.HUE_RED);
                new Thread(new RunnableC0721z(launchActivity, str4, (String) obj4, (String) obj3, (String) obj2, (String) obj, 0)).start();
                return;
        }
    }

    public /* synthetic */ U(f0 f0Var, DMRBridge dMRBridge, ProgressDialog progressDialog, m0 m0Var, Context context) {
        this.f6640k = f0Var;
        this.f6642m = dMRBridge;
        this.n = progressDialog;
        this.f6641l = m0Var;
        this.f6643o = context;
    }

    public /* synthetic */ U(f0 f0Var, m0 m0Var, String str, String str2, DialogC0469f dialogC0469f) {
        this.f6640k = f0Var;
        this.f6641l = m0Var;
        this.f6642m = str;
        this.n = str2;
        this.f6643o = dialogC0469f;
    }
}
