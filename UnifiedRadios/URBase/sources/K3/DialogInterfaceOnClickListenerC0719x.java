package k3;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;
import f.C0467d;

/* renamed from: k3.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class DialogInterfaceOnClickListenerC0719x implements DialogInterface.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8231c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8232d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ EditText f8233e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ EditText f8234f;
    public final /* synthetic */ EditText g;
    public final /* synthetic */ EditText h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ EditText f8235i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Spinner f8236j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Spinner f8237k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Spinner f8238l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Spinner f8239m;
    public final /* synthetic */ Spinner n;

    public /* synthetic */ DialogInterfaceOnClickListenerC0719x(LaunchActivity launchActivity, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, Spinner spinner, Spinner spinner2, Spinner spinner3, Spinner spinner4, Spinner spinner5, int i5) {
        this.f8231c = i5;
        this.f8232d = launchActivity;
        this.f8233e = editText;
        this.f8234f = editText2;
        this.g = editText3;
        this.h = editText4;
        this.f8235i = editText5;
        this.f8236j = spinner;
        this.f8237k = spinner2;
        this.f8238l = spinner3;
        this.f8239m = spinner4;
        this.n = spinner5;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) throws Throwable {
        String str;
        ProgressDialog progressDialog;
        LaunchActivity launchActivity;
        LaunchActivity launchActivity2;
        switch (this.f8231c) {
            case 0:
                Context context = LaunchActivity.f5853D1;
                LaunchActivity launchActivity3 = this.f8232d;
                launchActivity3.getClass();
                L.h hVar = new L.h(launchActivity3, R.style.Base_Theme_Material3_Dark_Dialog);
                C0467d c0467d = (C0467d) hVar.f1522d;
                c0467d.f6292d = "Choose Below";
                DialogInterfaceOnClickListenerC0719x dialogInterfaceOnClickListenerC0719x = new DialogInterfaceOnClickListenerC0719x(launchActivity3, this.f8233e, this.f8234f, this.g, this.h, this.f8235i, this.f8236j, this.f8237k, this.f8238l, this.f8239m, this.n, 1);
                c0467d.f6301p = new String[]{"Program Radio", "Save to Memories"};
                c0467d.f6303r = dialogInterfaceOnClickListenerC0719x;
                hVar.c("Cancel", null);
                hVar.b().show();
                break;
            default:
                Context context2 = LaunchActivity.f5853D1;
                LaunchActivity launchActivity4 = this.f8232d;
                launchActivity4.getClass();
                EditText editText = this.f8233e;
                EditText editText2 = this.f8234f;
                EditText editText3 = this.g;
                EditText editText4 = this.h;
                EditText editText5 = this.f8235i;
                Spinner spinner = this.f8236j;
                Spinner spinner2 = this.f8237k;
                Spinner spinner3 = this.f8238l;
                Spinner spinner4 = this.f8239m;
                Spinner spinner5 = this.n;
                if (i5 == 0) {
                    Toast.makeText(launchActivity4, "Tuning Radio!", 0).show();
                    try {
                        boolean zIsSocketConnected = launchActivity4.f5915b1.isSocketConnected();
                        long jT = LaunchActivity.T(editText.getText().toString());
                        long jT2 = LaunchActivity.T(editText2.getText().toString());
                        int i6 = Integer.parseInt(editText3.getText().toString());
                        if (i6 > 9999999) {
                            str = "DMR";
                            i6 = Integer.parseInt(String.valueOf(i6).substring(0, 7));
                        } else {
                            str = "DMR";
                        }
                        int i7 = Integer.parseInt(editText4.getText().toString());
                        LaunchActivity.R0(i6, i7);
                        h4.c.t0(LaunchActivity.f5853D1, jT);
                        h4.c.x0(LaunchActivity.f5853D1, jT2);
                        h4.c.c0(LaunchActivity.f5853D1, i6);
                        h4.c.w0(LaunchActivity.f5853D1, i7);
                        h4.c.C(LaunchActivity.f5853D1).edit().putString("group_list", editText5.getText().toString()).apply();
                        h4.c.m0(LaunchActivity.f5853D1, spinner.getSelectedItemPosition());
                        h4.c.C(LaunchActivity.f5853D1).edit().putInt("contact_type", spinner2.getSelectedItemPosition()).apply();
                        h4.c.N(LaunchActivity.f5853D1, spinner3.getSelectedItemPosition());
                        h4.c.Z(LaunchActivity.f5853D1, spinner4.getSelectedItemPosition());
                        h4.c.k0(LaunchActivity.f5853D1, spinner4.getSelectedItemPosition());
                        h4.c.M(LaunchActivity.f5853D1, spinner5.getSelectedItemPosition());
                        if (!zIsSocketConnected) {
                            if (launchActivity4.f5965u != null) {
                                new L0.s(launchActivity4.f5916c, 20, LaunchActivity.f5853D1).A();
                                TextView textView = (TextView) launchActivity4.findViewById(R.id.CallerID);
                                launchActivity4.f5973x = textView;
                                textView.setVisibility(0);
                                String str2 = str;
                                launchActivity4.f5970w = str2;
                                h4.c.p0(LaunchActivity.f5853D1, str2);
                                h4.c.a0(LaunchActivity.f5853D1, String.format("%.5f", Double.valueOf(jT / 1000000.0d)));
                                h4.c.b0(LaunchActivity.f5853D1, "DMR Digital");
                                launchActivity4.M0(jT);
                                ((TextView) launchActivity4.findViewById(R.id.activeMemoryName)).setText("DMR Digital");
                                launchActivity4.onResume();
                                break;
                            }
                        } else {
                            y1.f.t();
                            Thread.sleep(3000L);
                            Log.d("Unified - Main Activity", "Disconnecting from ROIP before programming repeater...");
                            if (!launchActivity4.isFinishing() && !launchActivity4.isDestroyed()) {
                                ProgressDialog progressDialog2 = new ProgressDialog(launchActivity4);
                                progressDialog2.setMessage("Disconnecting from network...");
                                progressDialog2.setCancelable(false);
                                try {
                                    progressDialog2.show();
                                    progressDialog = progressDialog2;
                                } catch (WindowManager.BadTokenException e5) {
                                    Log.e("Unified - Main Activity", "Failed to show progress dialog - invalid window token", e5);
                                    progressDialog = null;
                                }
                                new Thread(new RunnableC0706q(launchActivity4, progressDialog, jT, 2)).start();
                                break;
                            }
                            Log.w("Unified - Main Activity", "Activity is finishing/destroyed, cannot show progress dialog");
                            break;
                        }
                    } catch (Exception e6) {
                        Toast.makeText(LaunchActivity.f5853D1, "" + e6.getMessage(), 0).show();
                    }
                } else if (i5 == 1) {
                    Toast.makeText(launchActivity4, "Opening Memory Save Dialog", 0).show();
                    try {
                        long jT3 = LaunchActivity.T(editText.getText().toString());
                        long jT4 = LaunchActivity.T(editText2.getText().toString());
                        int i8 = Integer.parseInt(editText3.getText().toString());
                        if (i8 > 9999999) {
                            try {
                                launchActivity2 = launchActivity4;
                                try {
                                    i8 = Integer.parseInt(String.valueOf(i8).substring(0, 7));
                                } catch (Exception e7) {
                                    e = e7;
                                    launchActivity = launchActivity2;
                                    Toast.makeText(LaunchActivity.f5853D1, "" + e.getMessage(), 0).show();
                                    launchActivity.A0();
                                    return;
                                }
                            } catch (Exception e8) {
                                e = e8;
                                launchActivity2 = launchActivity4;
                                launchActivity = launchActivity2;
                                Toast.makeText(LaunchActivity.f5853D1, "" + e.getMessage(), 0).show();
                                launchActivity.A0();
                                return;
                            }
                        } else {
                            launchActivity2 = launchActivity4;
                        }
                        int i9 = Integer.parseInt(editText4.getText().toString());
                        LaunchActivity.R0(i8, i9);
                        h4.c.t0(LaunchActivity.f5853D1, jT3);
                        h4.c.x0(LaunchActivity.f5853D1, jT4);
                        h4.c.c0(LaunchActivity.f5853D1, i8);
                        h4.c.w0(LaunchActivity.f5853D1, i9);
                        h4.c.C(LaunchActivity.f5853D1).edit().putString("group_list", editText5.getText().toString()).apply();
                        h4.c.m0(LaunchActivity.f5853D1, spinner.getSelectedItemPosition());
                        h4.c.C(LaunchActivity.f5853D1).edit().putInt("contact_type", spinner2.getSelectedItemPosition()).apply();
                        h4.c.N(LaunchActivity.f5853D1, spinner3.getSelectedItemPosition());
                        h4.c.Z(LaunchActivity.f5853D1, spinner4.getSelectedItemPosition());
                        h4.c.k0(LaunchActivity.f5853D1, spinner4.getSelectedItemPosition());
                        h4.c.M(LaunchActivity.f5853D1, spinner5.getSelectedItemPosition());
                        launchActivity = launchActivity2;
                        try {
                            if (launchActivity.f5965u != null) {
                                new L0.s(launchActivity.f5916c, 20, LaunchActivity.f5853D1).A();
                                TextView textView2 = (TextView) launchActivity.findViewById(R.id.CallerID);
                                launchActivity.f5973x = textView2;
                                textView2.setVisibility(0);
                                launchActivity.M0(jT3);
                                launchActivity.f5970w = "DMR";
                                h4.c.p0(LaunchActivity.f5853D1, "DMR");
                                h4.c.a0(LaunchActivity.f5853D1, String.format("%.5f", Double.valueOf(jT3 / 1000000.0d)));
                                h4.c.b0(LaunchActivity.f5853D1, "DMR Digital");
                                ((TextView) launchActivity.findViewById(R.id.activeMemoryName)).setText("DMR Digital");
                            }
                        } catch (Exception e9) {
                            e = e9;
                            Toast.makeText(LaunchActivity.f5853D1, "" + e.getMessage(), 0).show();
                            launchActivity.A0();
                            return;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        launchActivity = launchActivity4;
                    }
                    launchActivity.A0();
                }
                break;
        }
    }
}
