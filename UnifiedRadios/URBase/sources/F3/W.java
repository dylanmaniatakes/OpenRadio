package f3;

import D0.l;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.unified.ur1.R;
import com.unified.ur1.radioteams.RadioTeamsManagerActivity;
import f.DialogC0469f;
import f3.z0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class W implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6649c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6650d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f6651e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ EditText f6652f;
    public final /* synthetic */ Dialog g;

    public /* synthetic */ W(RadioTeamsManagerActivity radioTeamsManagerActivity, EditText editText, CheckBox checkBox, AlertDialog alertDialog) {
        this.f6649c = 3;
        this.f6650d = radioTeamsManagerActivity;
        this.f6652f = editText;
        this.f6651e = checkBox;
        this.g = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Dialog dialog = this.g;
        Object obj = this.f6651e;
        EditText editText = this.f6652f;
        Object obj2 = this.f6650d;
        switch (this.f6649c) {
            case 0:
                final f0 f0Var = (f0) obj2;
                f0Var.getClass();
                final String string = editText.getText().toString();
                String string2 = PreferenceManager.getDefaultSharedPreferences(f0Var.f6710b).getString("user_callsign", null);
                final int i5 = 1;
                final m0 m0Var = (m0) obj;
                final DialogC0469f dialogC0469f = (DialogC0469f) dialog;
                if (string2 != null) {
                    f0Var.f6711c.execute(new V(f0Var, m0Var, string2, i5, string, dialogC0469f));
                    break;
                } else {
                    f0Var.c(new InterfaceC0512d0() { // from class: f3.O
                        @Override // f3.InterfaceC0512d0
                        public final void a(String str) {
                            f0 f0Var2 = f0Var;
                            if (str == null) {
                                f0Var2.getClass();
                                return;
                            }
                            f0Var2.d(str);
                            f0Var2.f6711c.execute(new V(f0Var2, m0Var, str, i5, string, dialogC0469f));
                        }
                    });
                    break;
                }
            case 1:
                final f0 f0Var2 = (f0) obj2;
                f0Var2.getClass();
                final String string3 = editText.getText().toString();
                String string4 = PreferenceManager.getDefaultSharedPreferences(f0Var2.f6710b).getString("user_callsign", null);
                final int i6 = -1;
                final m0 m0Var2 = (m0) obj;
                final DialogC0469f dialogC0469f2 = (DialogC0469f) dialog;
                if (string4 != null) {
                    f0Var2.f6711c.execute(new V(f0Var2, m0Var2, string4, i6, string3, dialogC0469f2));
                    break;
                } else {
                    f0Var2.c(new InterfaceC0512d0() { // from class: f3.O
                        @Override // f3.InterfaceC0512d0
                        public final void a(String str) {
                            f0 f0Var22 = f0Var2;
                            if (str == null) {
                                f0Var22.getClass();
                                return;
                            }
                            f0Var22.d(str);
                            f0Var22.f6711c.execute(new V(f0Var22, m0Var2, str, i6, string3, dialogC0469f2));
                        }
                    });
                    break;
                }
            case 2:
                final f0 f0Var3 = (f0) obj2;
                f0Var3.getClass();
                final String string5 = editText.getText().toString();
                boolean zIsEmpty = string5.trim().isEmpty();
                Context context = f0Var3.f6710b;
                if (!zIsEmpty) {
                    String string6 = PreferenceManager.getDefaultSharedPreferences(context).getString("user_callsign", null);
                    final m0 m0Var3 = (m0) obj;
                    final DialogC0469f dialogC0469f3 = (DialogC0469f) dialog;
                    if (string6 != null) {
                        f0Var3.f6711c.execute(new U(f0Var3, m0Var3, string6, string5, dialogC0469f3));
                        break;
                    } else {
                        f0Var3.c(new InterfaceC0512d0() { // from class: f3.c0
                            @Override // f3.InterfaceC0512d0
                            public final void a(String str) {
                                f0 f0Var4 = f0Var3;
                                if (str == null) {
                                    f0Var4.getClass();
                                    return;
                                }
                                f0Var4.d(str);
                                f0Var4.f6711c.execute(new U(f0Var4, m0Var3, str, string5, dialogC0469f3));
                            }
                        });
                        break;
                    }
                } else {
                    Toast.makeText(context, "Please enter a note first", 0).show();
                    break;
                }
            default:
                int i7 = RadioTeamsManagerActivity.f6026l;
                final RadioTeamsManagerActivity radioTeamsManagerActivity = (RadioTeamsManagerActivity) obj2;
                radioTeamsManagerActivity.getClass();
                final String strTrim = editText.getText().toString().trim();
                final String strH = h4.c.h(radioTeamsManagerActivity);
                final boolean zIsChecked = ((CheckBox) obj).isChecked();
                Log.d("RadioTeamsManager", "Add team clicked - TeamID: " + strTrim + ", Callsign: " + strH + ", AutoConnect: " + zIsChecked);
                if (!strTrim.isEmpty() && !strH.isEmpty()) {
                    Log.d("RadioTeamsManager", "=== VALIDATING AND ADDING TEAM ===");
                    Log.d("RadioTeamsManager", "TeamID: " + strTrim + ", Callsign: " + strH + ", AutoConnect: " + zIsChecked);
                    final AlertDialog alertDialog = (AlertDialog) dialog;
                    final ProgressBar progressBar = (ProgressBar) alertDialog.findViewById(R.id.progressBar);
                    final Button button = alertDialog.getButton(-1);
                    if (progressBar != null) {
                        progressBar.setVisibility(0);
                        Log.d("RadioTeamsManager", "Progress bar shown");
                    }
                    button.setEnabled(false);
                    radioTeamsManagerActivity.f6032j.execute(new Runnable() { // from class: l3.h
                        @Override // java.lang.Runnable
                        public final void run() throws JSONException {
                            String str = strTrim;
                            String str2 = strH;
                            ProgressBar progressBar2 = progressBar;
                            Button button2 = button;
                            boolean z4 = zIsChecked;
                            AlertDialog alertDialog2 = alertDialog;
                            int i8 = RadioTeamsManagerActivity.f6026l;
                            RadioTeamsManagerActivity radioTeamsManagerActivity2 = radioTeamsManagerActivity;
                            radioTeamsManagerActivity2.getClass();
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("team_id", str);
                                jSONObject.put("callsign", str2);
                                Log.d("RadioTeamsManager", "Subscribe request: " + jSONObject.toString());
                                String strL = RadioTeamsManagerActivity.l("https://ur1.unifiedradios.com/api-teams/subscribe.php", jSONObject);
                                Log.d("RadioTeamsManager", "Subscribe response: ".concat(strL));
                                radioTeamsManagerActivity2.f6033k.post(new z0(radioTeamsManagerActivity2, progressBar2, button2, new JSONObject(strL), str, str2, z4, alertDialog2));
                            } catch (Exception e5) {
                                Log.e("RadioTeamsManager", "Error subscribing to team", e5);
                                radioTeamsManagerActivity2.f6033k.post(new l(radioTeamsManagerActivity2, progressBar2, button2, e5, 6));
                            }
                        }
                    });
                    break;
                } else {
                    Log.w("RadioTeamsManager", "Empty team ID or callsign");
                    Toast.makeText(radioTeamsManagerActivity, "Please enter both Team ID and Callsign", 0).show();
                    break;
                }
                break;
        }
    }

    public /* synthetic */ W(f0 f0Var, m0 m0Var, EditText editText, DialogC0469f dialogC0469f, int i5) {
        this.f6649c = i5;
        this.f6650d = f0Var;
        this.f6651e = m0Var;
        this.f6652f = editText;
        this.g = dialogC0469f;
    }
}
