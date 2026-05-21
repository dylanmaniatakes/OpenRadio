package k3;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import f.C0467d;
import java.util.HashMap;

/* renamed from: k3.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class DialogInterfaceOnClickListenerC0720y implements DialogInterface.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8241c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8242d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ EditText f8243e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ EditText f8244f;
    public final /* synthetic */ Spinner g;
    public final /* synthetic */ Spinner h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ SeekBar f8245i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Spinner f8246j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Spinner f8247k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Spinner f8248l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Spinner f8249m;

    public /* synthetic */ DialogInterfaceOnClickListenerC0720y(LaunchActivity launchActivity, EditText editText, EditText editText2, Spinner spinner, Spinner spinner2, SeekBar seekBar, Spinner spinner3, Spinner spinner4, Spinner spinner5, Spinner spinner6, int i5) {
        this.f8241c = i5;
        this.f8242d = launchActivity;
        this.f8243e = editText;
        this.f8244f = editText2;
        this.g = spinner;
        this.h = spinner2;
        this.f8245i = seekBar;
        this.f8246j = spinner3;
        this.f8247k = spinner4;
        this.f8248l = spinner5;
        this.f8249m = spinner6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v17, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v6, types: [int] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) throws Throwable {
        String str;
        String str2;
        long jT;
        ?? r4;
        CharSequence charSequence;
        switch (this.f8241c) {
            case 0:
                Context context = LaunchActivity.f5853D1;
                LaunchActivity launchActivity = this.f8242d;
                if (launchActivity.isFinishing() || launchActivity.isDestroyed()) {
                    Log.w("Unified - Main Activity", "Activity is finishing/destroyed, cannot show mode dialog");
                    break;
                } else {
                    L.h hVar = new L.h(launchActivity, R.style.Base_Theme_Material3_Dark_Dialog);
                    C0467d c0467d = (C0467d) hVar.f1522d;
                    c0467d.f6292d = "Choose Below";
                    DialogInterfaceOnClickListenerC0720y dialogInterfaceOnClickListenerC0720y = new DialogInterfaceOnClickListenerC0720y(launchActivity, this.f8243e, this.f8244f, this.g, this.h, this.f8245i, this.f8246j, this.f8247k, this.f8248l, this.f8249m, 1);
                    c0467d.f6301p = new String[]{"Program Radio", "Save to Memories"};
                    c0467d.f6303r = dialogInterfaceOnClickListenerC0720y;
                    hVar.c("Cancel", null);
                    try {
                        hVar.b().show();
                        break;
                    } catch (WindowManager.BadTokenException e5) {
                        Log.e("Unified - Main Activity", "Failed to show mode selection dialog - invalid window token", e5);
                        if (launchActivity.isFinishing() || launchActivity.isDestroyed()) {
                            return;
                        }
                        Toast.makeText(launchActivity, "Cannot show dialog - please try again", 0).show();
                        return;
                    }
                }
                break;
            default:
                LaunchActivity launchActivity2 = this.f8242d;
                HashMap map = launchActivity2.f5975x1;
                EditText editText = this.f8243e;
                EditText editText2 = this.f8244f;
                Spinner spinner = this.g;
                Spinner spinner2 = this.h;
                SeekBar seekBar = this.f8245i;
                Spinner spinner3 = this.f8246j;
                Spinner spinner4 = this.f8247k;
                Spinner spinner5 = this.f8248l;
                Spinner spinner6 = this.f8249m;
                if (i5 == 0) {
                    try {
                        String string = editText.getText().toString();
                        String string2 = editText2.getText().toString();
                        long jT2 = LaunchActivity.T(string);
                        long jT3 = LaunchActivity.T(string2);
                        int selectedItemPosition = spinner.getSelectedItemPosition();
                        int selectedItemPosition2 = spinner2.getSelectedItemPosition();
                        ?? progress = seekBar.getProgress();
                        int selectedItemPosition3 = spinner3.getSelectedItemPosition();
                        int selectedItemPosition4 = spinner4.getSelectedItemPosition();
                        String str3 = (String) spinner5.getSelectedItem();
                        String str4 = (String) spinner6.getSelectedItem();
                        int iIntValue = ((Integer) map.get(str3)).intValue();
                        int iIntValue2 = ((Integer) map.get(str4)).intValue();
                        h4.c.t0(LaunchActivity.f5853D1, jT2);
                        h4.c.x0(LaunchActivity.f5853D1, jT3);
                        h4.c.C(LaunchActivity.f5853D1).edit().putInt("band", selectedItemPosition).apply();
                        h4.c.m0(LaunchActivity.f5853D1, selectedItemPosition2);
                        h4.c.C(LaunchActivity.f5853D1).edit().putInt("squelch", progress).apply();
                        h4.c.v0(LaunchActivity.f5853D1, selectedItemPosition3);
                        h4.c.u0(LaunchActivity.f5853D1, iIntValue);
                        h4.c.z0(LaunchActivity.f5853D1, selectedItemPosition4);
                        h4.c.y0(LaunchActivity.f5853D1, iIntValue2);
                        h4.c.C(LaunchActivity.f5853D1).edit().putInt("power_save", 1).apply();
                        h4.c.C(LaunchActivity.f5853D1).edit().putInt("monitor", 2).apply();
                        h4.c.C(LaunchActivity.f5853D1).edit().putInt("relay", 2).apply();
                        try {
                            Log.d("Unified - Main Activity", "=== Starting Repeater Programming Process ===");
                            DMRBridge dMRBridgeJ = DMRBridge.j(launchActivity2);
                            boolean zIsSocketConnected = dMRBridgeJ.isSocketConnected();
                            Log.d("Unified - Main Activity", "Current ROIP status: ".concat(zIsSocketConnected ? "Connected" : "Disconnected"));
                            if (zIsSocketConnected) {
                                y1.f.t();
                                Thread.sleep(3000L);
                                Log.d("Unified - Main Activity", "Disconnecting from ROIP before programming repeater...");
                                if (!launchActivity2.isFinishing() && !launchActivity2.isDestroyed()) {
                                    ProgressDialog progressDialog = new ProgressDialog(launchActivity2);
                                    progressDialog.setMessage("Disconnecting from network...");
                                    progressDialog.setCancelable(false);
                                    try {
                                        progressDialog.show();
                                    } catch (WindowManager.BadTokenException e6) {
                                        Log.e("Unified - Main Activity", "Failed to show progress dialog - invalid window token", e6);
                                        progressDialog = null;
                                    }
                                    new Thread(new RunnableC0698m(launchActivity2, dMRBridgeJ, progressDialog, jT2, 2)).start();
                                    break;
                                }
                                Log.w("Unified - Main Activity", "Activity is finishing/destroyed, cannot show progress dialog");
                                break;
                            } else {
                                Log.d("Unified - Main Activity", "No ROIP connection, proceeding with repeater programming");
                                if (launchActivity2.f5965u != null) {
                                    new L0.s(launchActivity2.f5916c, 20, launchActivity2).y();
                                    TextView textView = (TextView) launchActivity2.findViewById(R.id.CallerID);
                                    launchActivity2.f5973x = textView;
                                    textView.setVisibility(4);
                                    TextView textView2 = (TextView) launchActivity2.findViewById(R.id.activeFrequency);
                                    String str5 = String.format("%.5f", Double.valueOf(jT2 / 1000000.0d));
                                    textView2.setText(str5);
                                    ((TextView) launchActivity2.findViewById(R.id.activeMemoryName)).setText("FM Analog");
                                    launchActivity2.f5970w = "FM";
                                    String str6 = launchActivity2.f5900U;
                                    try {
                                        if (str6 == null && str6.isEmpty()) {
                                            CharSequence charSequence2 = "";
                                            launchActivity2.f5940l0.setText(charSequence2);
                                            progress = charSequence2;
                                        } else {
                                            progress = "";
                                            launchActivity2.f5940l0.setText(" " + launchActivity2.f5900U + " ");
                                        }
                                        h4.c.b0(launchActivity2, "FM Analog");
                                        h4.c.p0(launchActivity2, "FM");
                                        h4.c.a0(launchActivity2, str5);
                                        launchActivity2.H0(str5);
                                        launchActivity2.onResume();
                                        break;
                                    } catch (Exception e7) {
                                        e = e7;
                                        str = progress;
                                        try {
                                            Log.e("Unified - Main Activity", "Error starting repeater programming process", e);
                                            if (!launchActivity2.isFinishing() || launchActivity2.isDestroyed()) {
                                                return;
                                            }
                                            Toast.makeText(launchActivity2, "Error programming repeater: " + e.getMessage(), 1).show();
                                            return;
                                        } catch (Exception e8) {
                                            e = e8;
                                            if (launchActivity2.isFinishing() || launchActivity2.isDestroyed()) {
                                                return;
                                            }
                                            Toast.makeText(launchActivity2, str + e.getMessage(), 0).show();
                                        }
                                    }
                                }
                            }
                        } catch (Exception e9) {
                            e = e9;
                            str = "";
                            Log.e("Unified - Main Activity", "Error starting repeater programming process", e);
                            if (launchActivity2.isFinishing()) {
                                return;
                            } else {
                                return;
                            }
                        }
                    } catch (Exception e10) {
                        e = e10;
                        str = "";
                    }
                } else if (i5 == 1) {
                    if (!launchActivity2.isFinishing() && !launchActivity2.isDestroyed()) {
                        Toast.makeText(launchActivity2, "Opening Memory Save Dialog", 0).show();
                    }
                    try {
                        String string3 = editText.getText().toString();
                        String string4 = editText2.getText().toString();
                        jT = LaunchActivity.T(string3);
                        long jT4 = LaunchActivity.T(string4);
                        int selectedItemPosition5 = spinner.getSelectedItemPosition();
                        int selectedItemPosition6 = spinner2.getSelectedItemPosition();
                        int progress2 = seekBar.getProgress();
                        int selectedItemPosition7 = spinner3.getSelectedItemPosition();
                        int selectedItemPosition8 = spinner4.getSelectedItemPosition();
                        String str7 = (String) spinner5.getSelectedItem();
                        String str8 = (String) spinner6.getSelectedItem();
                        int iIntValue3 = ((Integer) map.get(str7)).intValue();
                        int iIntValue4 = ((Integer) map.get(str8)).intValue();
                        h4.c.t0(LaunchActivity.f5853D1, jT);
                        h4.c.x0(LaunchActivity.f5853D1, jT4);
                        h4.c.C(LaunchActivity.f5853D1).edit().putInt("band", selectedItemPosition5).apply();
                        h4.c.m0(LaunchActivity.f5853D1, selectedItemPosition6);
                        h4.c.C(LaunchActivity.f5853D1).edit().putInt("squelch", progress2).apply();
                        h4.c.v0(LaunchActivity.f5853D1, selectedItemPosition7);
                        h4.c.u0(LaunchActivity.f5853D1, iIntValue3);
                        h4.c.z0(LaunchActivity.f5853D1, selectedItemPosition8);
                        h4.c.y0(LaunchActivity.f5853D1, iIntValue4);
                        h4.c.C(LaunchActivity.f5853D1).edit().putInt("power_save", 1).apply();
                        r4 = 2;
                        h4.c.C(LaunchActivity.f5853D1).edit().putInt("monitor", 2).apply();
                        h4.c.C(LaunchActivity.f5853D1).edit().putInt("relay", 2).apply();
                    } catch (Exception e11) {
                        e = e11;
                        str2 = "";
                    }
                    try {
                        if (launchActivity2.f5965u != null) {
                            new L0.s(launchActivity2.f5916c, 20, launchActivity2).y();
                            TextView textView3 = (TextView) launchActivity2.findViewById(R.id.CallerID);
                            launchActivity2.f5973x = textView3;
                            textView3.setVisibility(4);
                            TextView textView4 = (TextView) launchActivity2.findViewById(R.id.activeFrequency);
                            String str9 = String.format("%.5f", Double.valueOf(jT / 1000000.0d));
                            textView4.setText(str9);
                            ((TextView) launchActivity2.findViewById(R.id.activeMemoryName)).setText("FM Analog");
                            launchActivity2.f5970w = "FM";
                            String str10 = launchActivity2.f5900U;
                            if (str10 == null && str10.isEmpty()) {
                                CharSequence charSequence3 = "";
                                launchActivity2.f5940l0.setText(charSequence3);
                                charSequence = charSequence3;
                            } else {
                                charSequence = "";
                                launchActivity2.f5940l0.setText(" " + launchActivity2.f5900U + " ");
                            }
                            h4.c.b0(launchActivity2, "FM Analog");
                            h4.c.p0(launchActivity2, "FM");
                            h4.c.a0(launchActivity2, str9);
                            launchActivity2.H0(str9);
                            r4 = charSequence;
                        } else {
                            r4 = "";
                        }
                        launchActivity2.A0();
                        break;
                    } catch (Exception e12) {
                        e = e12;
                        str2 = r4;
                        if (launchActivity2.isFinishing() || launchActivity2.isDestroyed()) {
                            return;
                        }
                        Toast.makeText(launchActivity2, str2 + e.getMessage(), 0).show();
                        return;
                    }
                }
                break;
        }
    }
}
