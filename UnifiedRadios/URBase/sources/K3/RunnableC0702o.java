package k3;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: k3.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0702o implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8176j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8177k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f8178l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f8179m;
    public final /* synthetic */ Object n;

    public /* synthetic */ RunnableC0702o(LaunchActivity launchActivity, boolean z4, Object obj, Object obj2, int i5) {
        this.f8176j = i5;
        this.f8177k = launchActivity;
        this.f8178l = z4;
        this.f8179m = obj;
        this.n = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() throws JSONException {
        Object obj = this.n;
        Object obj2 = this.f8179m;
        boolean z4 = this.f8178l;
        LaunchActivity launchActivity = this.f8177k;
        switch (this.f8176j) {
            case 0:
                Context context = LaunchActivity.f5853D1;
                launchActivity.getClass();
                JSONObject jSONObject = (JSONObject) obj2;
                List list = (List) obj;
                if (z4) {
                    try {
                        if (jSONObject.has("success") && jSONObject.getBoolean("success")) {
                            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                            if (jSONObjectOptJSONObject != null) {
                                String strOptString = jSONObjectOptJSONObject.optString("callsign", "");
                                jSONObjectOptJSONObject.optString("operation", "");
                                if (jSONObjectOptJSONObject.has("talkgroups_configured")) {
                                    JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray("talkgroups_configured");
                                    if (jSONArray.length() > 0) {
                                        StringBuilder sb = new StringBuilder();
                                        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                                            JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                                            if (i5 > 0) {
                                                sb.append(", ");
                                            }
                                            sb.append(jSONObject2.optString("talkgroup", ""));
                                        }
                                        launchActivity.D0("✅ TGs " + sb.toString() + " configured (" + strOptString + ")");
                                        break;
                                    } else {
                                        launchActivity.D0("✅ TGs " + TextUtils.join(", ", list) + " configured (" + strOptString + ")");
                                        break;
                                    }
                                } else {
                                    launchActivity.D0("✅ TGs " + TextUtils.join(", ", list) + " configured (" + strOptString + ")");
                                    break;
                                }
                            } else {
                                launchActivity.D0("✅ Successfully subscribed to TGs: " + TextUtils.join(", ", list));
                                break;
                            }
                        }
                    } catch (JSONException e5) {
                        Log.e("Unified - Main Activity", "Error parsing UR1 Multi-RX response", e5);
                        launchActivity.D0("⚠️ TG subscription status unknown for: " + TextUtils.join(", ", list));
                        return;
                    }
                }
                String strOptString2 = jSONObject.optString("error", "Unknown error");
                launchActivity.D0("❌ Failed to subscribe to TGs: " + TextUtils.join(", ", list) + " - " + strOptString2);
                break;
            default:
                if (z4) {
                    Context context2 = LaunchActivity.f5853D1;
                    launchActivity.getClass();
                    try {
                        if (launchActivity.f5915b1 == null || !DMRBridge.f6068o) {
                            Log.w("Unified - Main Activity", "Cannot apply AGC settings - DMR Bridge not available");
                        } else {
                            boolean z5 = launchActivity.getSharedPreferences("agc_settings", 0).getBoolean("KEY_AGC_ENABLED", false);
                            float f5 = launchActivity.getSharedPreferences("agc_settings", 0).getInt("KEY_INPUT_VOLUME", 50) / 100.0f;
                            Log.i("Unified - Main Activity", "Applying saved AGC settings on connection:");
                            Log.i("Unified - Main Activity", "  - AGC Enabled: " + z5);
                            Log.i("Unified - Main Activity", "  - Input Volume: " + (100.0f * f5) + "%");
                            launchActivity.f5915b1.setAGCEnabled(z5);
                            launchActivity.f5915b1.inputvolume(f5);
                            Log.i("Unified - Main Activity", "AGC Status after applying settings: " + launchActivity.f5915b1.getAGCStatus());
                            Log.i("Unified - Main Activity", "AGC settings applied successfully on ROIP connection");
                        }
                    } catch (Exception e6) {
                        Log.e("Unified - Main Activity", "Error applying AGC settings on connection", e6);
                    }
                    launchActivity.Z();
                    TextView textView = (TextView) obj2;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    TextView textView2 = (TextView) obj;
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                    CardView cardView = launchActivity.f5874F0;
                    if (cardView != null) {
                        cardView.clearAnimation();
                        launchActivity.f5874F0.setVisibility(0);
                        launchActivity.f5874F0.setAlpha(BitmapDescriptorFactory.HUE_RED);
                        launchActivity.f5874F0.animate().alpha(1.0f).setDuration(300L).start();
                        TextView textView3 = (TextView) launchActivity.f5874F0.findViewById(R.id.ROIP_Connection);
                        if (textView3 != null) {
                            textView3.setVisibility(0);
                            textView3.setText("ROIP Connected");
                            CardView cardView2 = (CardView) launchActivity.findViewById(R.id.roip_disconnect);
                            if (cardView2 != null) {
                                cardView2.setVisibility(8);
                            }
                        }
                        if (LaunchActivity.f5854E1) {
                            TextView textView4 = (TextView) launchActivity.findViewById(R.id.activeFrequency);
                            textView4.setText("Multi-RX");
                            textView4.setTextSize(1, 60.0f);
                            ((TextView) launchActivity.findViewById(R.id.network)).setText(h4.c.y(launchActivity) + " - TGs: " + launchActivity.getSharedPreferences("AppPrefs", 0).getString("saved_talkgroups", "").replace("[", "").replace("]", "").trim());
                            break;
                        }
                    }
                } else {
                    CardView cardView3 = launchActivity.f5874F0;
                    if (cardView3 != null) {
                        cardView3.clearAnimation();
                        launchActivity.f5874F0.animate().alpha(BitmapDescriptorFactory.HUE_RED).setDuration(300L).withEndAction(new RunnableC0696l(launchActivity, 28)).start();
                        break;
                    } else {
                        Log.d("LaunchActivity", "roipdisconnect called # 2");
                        launchActivity.n0();
                        break;
                    }
                }
                break;
        }
    }
}
