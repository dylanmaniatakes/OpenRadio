package f3;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import f.DialogC0469f;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class V implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ f0 f6644j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ m0 f6645k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f6646l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f6647m;
    public final /* synthetic */ String n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ DialogC0469f f6648o;

    public /* synthetic */ V(f0 f0Var, m0 m0Var, String str, int i5, String str2, DialogC0469f dialogC0469f) {
        this.f6644j = f0Var;
        this.f6645k = m0Var;
        this.f6646l = str;
        this.f6647m = i5;
        this.n = str2;
        this.f6648o = dialogC0469f;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        final m0 m0Var = this.f6645k;
        String str = this.f6646l;
        final int i5 = this.f6647m;
        String str2 = this.n;
        final DialogC0469f dialogC0469f = this.f6648o;
        final f0 f0Var = this.f6644j;
        Context context = f0Var.f6710b;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://ur1.unifiedradios.com/repeater_pull.php").openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            String str3 = String.format("callsign=%s&submitted_by=%s&vote=%d&note=%s", m0Var.f6745a, str, Integer.valueOf(i5), str2);
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
                            ((Activity) context).runOnUiThread(new Runnable() { // from class: f3.X
                                @Override // java.lang.Runnable
                                public final void run() {
                                    f0 f0Var2 = f0Var;
                                    Context context2 = f0Var2.f6710b;
                                    if (!z4) {
                                        Toast.makeText(context2, "Error submitting feedback: " + jSONObject.optString("message", "Unknown error"), 1).show();
                                    } else {
                                        Toast.makeText(context2, "Feedback submitted successfully", 0).show();
                                        dialogC0469f.dismiss();
                                        m0Var.f6750f += i5;
                                        f0Var2.notifyDataSetChanged();
                                    }
                                }
                            });
                            bufferedReader.close();
                            return;
                        }
                        sb.append(line.trim());
                    }
                } finally {
                }
            } finally {
            }
        } catch (Exception e5) {
            e5.printStackTrace();
            ((Activity) context).runOnUiThread(new Y(f0Var, e5, 0));
        }
    }
}
