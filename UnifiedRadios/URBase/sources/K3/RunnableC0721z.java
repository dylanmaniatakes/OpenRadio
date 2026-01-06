package k3;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.primary.OptionsActivity;
import f.AbstractActivityC0472i;
import f3.C0511d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* renamed from: k3.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0721z implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8251j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f8252k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f8253l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f8254m;
    public final /* synthetic */ Object n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f8255o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f8256p;

    public /* synthetic */ RunnableC0721z(AbstractActivityC0472i abstractActivityC0472i, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i5) {
        this.f8251j = i5;
        this.f8252k = abstractActivityC0472i;
        this.f8253l = obj;
        this.f8254m = obj2;
        this.n = obj3;
        this.f8255o = obj4;
        this.f8256p = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        Spinner spinner;
        Switch r7;
        Object obj = this.f8253l;
        Object obj2 = this.f8256p;
        Object obj3 = this.f8255o;
        Object obj4 = this.n;
        Object obj5 = this.f8254m;
        Object obj6 = this.f8252k;
        switch (this.f8251j) {
            case 0:
                Context context = LaunchActivity.f5853D1;
                LaunchActivity launchActivity = (LaunchActivity) obj6;
                launchActivity.getClass();
                Uri.Builder builderBuildUpon = Uri.parse("https://ur1.unifiedradios.com/telemetry.php?").buildUpon();
                String str = (String) obj;
                String str2 = (String) obj5;
                String str3 = (String) obj4;
                if (LaunchActivity.f5855F1) {
                    builderBuildUpon.appendQueryParameter("cloud_auth", str).appendQueryParameter("device_manufacturer", "ComJoTRadios").appendQueryParameter("device_model", "CJ_26").appendQueryParameter("os_version", str2).appendQueryParameter("os_uid", str3).appendQueryParameter("app_version", "0.0.8-beta.13").appendQueryParameter("lat", String.valueOf(launchActivity.f5945n0)).appendQueryParameter("lng", String.valueOf(launchActivity.f5948o0));
                } else {
                    builderBuildUpon.appendQueryParameter("cloud_auth", str).appendQueryParameter("device_manufacturer", (String) obj3).appendQueryParameter("device_model", (String) obj2).appendQueryParameter("os_version", str2).appendQueryParameter("os_uid", str3).appendQueryParameter("app_version", "0.0.8-beta.13").appendQueryParameter("lat", String.valueOf(launchActivity.f5945n0)).appendQueryParameter("lng", String.valueOf(launchActivity.f5948o0));
                }
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(((HttpURLConnection) new URL(builderBuildUpon.build().toString()).openConnection()).getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            launchActivity.runOnUiThread(new g3.k(launchActivity, 7, new JSONObject(sb.toString())));
                            break;
                        } else {
                            sb.append(line);
                        }
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                    launchActivity.runOnUiThread(new RunnableC0672A(launchActivity, 6));
                    return;
                }
            case 1:
                int i5 = OptionsActivity.f5981H;
                if (!((OptionsActivity) obj6).isFinishing()) {
                    C0511d c0511d = (C0511d) obj;
                    if (c0511d != null && (r7 = (Switch) obj5) != null) {
                        r7.setChecked(Integer.parseInt(c0511d.f6684b) == 1);
                        LinearLayout linearLayout = (LinearLayout) obj4;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(8);
                        }
                    }
                    C0511d c0511d2 = (C0511d) obj3;
                    if (c0511d2 != null && (spinner = (Spinner) obj2) != null) {
                        spinner.setSelection(Integer.parseInt(c0511d2.f6684b));
                        break;
                    }
                }
                break;
            default:
                if (!((OptionsActivity) ((f3.E0) obj6).I).isFinishing() && ((Dialog) obj5).isShowing()) {
                    LinearLayout linearLayout2 = (LinearLayout) obj4;
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                    LinearLayout linearLayout3 = (LinearLayout) obj3;
                    if (linearLayout3 != null) {
                        linearLayout3.setVisibility(0);
                    }
                    TextView textView = (TextView) obj2;
                    String str4 = (String) obj;
                    if (textView != null) {
                        textView.setText("Error loading solar data: " + str4);
                    }
                    Log.e("Unified - Settings", "Error loading solar conditions: " + str4);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ RunnableC0721z(f3.E0 e02, Dialog dialog, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, String str) {
        this.f8251j = 2;
        this.f8252k = e02;
        this.f8254m = dialog;
        this.n = linearLayout;
        this.f8255o = linearLayout2;
        this.f8256p = textView;
        this.f8253l = str;
    }
}
