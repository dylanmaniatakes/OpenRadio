package k3;

import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.unified.ur1.R;
import com.unified.ur1.adapters.MemoryChannelActivity;
import com.unified.ur1.adapters.RepeaterDirectoryActivity;
import com.unified.ur1.adapters.RepeaterMapActivity;
import com.unified.ur1.primary.AppSettings;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.ROIP.DMRBridge;
import g0.AbstractC0535a;

/* renamed from: k3.d0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceOnClickListenerC0681d0 implements DialogInterface.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8119c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f8120d;

    public /* synthetic */ DialogInterfaceOnClickListenerC0681d0(int i5, Object obj) {
        this.f8119c = i5;
        this.f8120d = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) {
        Object obj = this.f8120d;
        switch (this.f8119c) {
            case 0:
                LaunchActivity launchActivity = (LaunchActivity) obj;
                launchActivity.f5961s1 = null;
                launchActivity.f5869D = false;
                launchActivity.P(launchActivity.f5937k);
                break;
            case 1:
                LaunchActivity launchActivity2 = (LaunchActivity) obj;
                launchActivity2.f5961s1 = null;
                launchActivity2.f5869D = false;
                dialogInterface.cancel();
                break;
            case 2:
                Context context = LaunchActivity.f5853D1;
                LaunchActivity launchActivity3 = (LaunchActivity) obj;
                long j5 = launchActivity3.getSharedPreferences("app_updates", 0).getLong("current_download_id", -1L);
                if (j5 != -1) {
                    ((DownloadManager) launchActivity3.getSystemService("download")).remove(j5);
                    launchActivity3.L();
                    Toast.makeText(launchActivity3, "Download cancelled", 0).show();
                }
                launchActivity3.hideProgressDialog();
                break;
            case 3:
                LaunchActivity launchActivity4 = (LaunchActivity) obj;
                try {
                    int iL = h4.c.l(launchActivity4);
                    Toast.makeText(launchActivity4, "Resyncing ROIP stream...", 0).show();
                    DMRBridge dMRBridge = launchActivity4.f5915b1;
                    if (dMRBridge != null) {
                        dMRBridge.subscribeTalkgroup(iL);
                        Log.d("Unified - Main Activity", "ROIP stream resynced for talkgroup: " + iL);
                        new Handler(Looper.getMainLooper()).postDelayed(new C0.e(25, this), 1000L);
                    } else {
                        Log.e("Unified - Main Activity", "DMRBridge is null, cannot resync ROIP stream");
                        Toast.makeText(launchActivity4, "Error: ROIP bridge not available", 0).show();
                    }
                    break;
                } catch (Exception e5) {
                    Log.e("Unified - Main Activity", "Error resyncing ROIP stream", e5);
                    Toast.makeText(launchActivity4, "Error resyncing ROIP stream: " + e5.getMessage(), 1).show();
                    return;
                }
            case 4:
                LaunchActivity launchActivity5 = (LaunchActivity) obj;
                if (i5 == 0) {
                    String strH = h4.c.h(LaunchActivity.f5853D1);
                    AbstractC0535a.v("Callsign = ", strH, "Unified - Main Activity");
                    if (strH != null && !strH.isEmpty() && !strH.equals("NOCALL") && !strH.equals("null")) {
                        Toast.makeText(launchActivity5, "Opening Cloud Memory Channels...", 0).show();
                        launchActivity5.startActivity(new Intent(launchActivity5, (Class<?>) MemoryChannelActivity.class));
                        break;
                    } else {
                        SharedPreferences sharedPreferences = launchActivity5.getSharedPreferences("app_settings", 0);
                        String string = sharedPreferences.getString("auth_code_1", null);
                        String string2 = sharedPreferences.getString("auth_code_2", null);
                        if (string == null || string2 == null) {
                            String string3 = Settings.Secure.getString(launchActivity5.getContentResolver(), "android_id");
                            string = (string3 == null || string3.length() < 8) ? (string3 == null || string3.length() >= 8) ? LaunchActivity.U() : String.format("%8s", string3).replace(' ', '0') : string3.substring(string3.length() - 8);
                            string2 = LaunchActivity.U();
                            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                            editorEdit.putString("auth_code_1", string);
                            editorEdit.putString("auth_code_2", string2);
                            editorEdit.apply();
                        }
                        Dialog dialog = new Dialog(launchActivity5, R.style.Base_Theme_Material3_Dark_Dialog);
                        dialog.setContentView(R.layout.dialog_validation);
                        TextView textView = (TextView) dialog.findViewById(R.id.accessCodeText);
                        TextView textView2 = (TextView) dialog.findViewById(R.id.validationCodeText);
                        textView.setText(string);
                        textView2.setText(string2);
                        ((Button) dialog.findViewById(R.id.validateButton)).setOnClickListener(new com.google.android.material.datepicker.l(4, this));
                        ((Button) dialog.findViewById(R.id.valclosebutton)).setOnClickListener(new i3.u(dialog, 2));
                        dialog.show();
                        new Handler(Looper.getMainLooper()).postDelayed(new g3.k(this, 12, strH), 200L);
                        break;
                    }
                } else if (i5 == 1) {
                    Toast.makeText(launchActivity5, "Opening Unified Repeater Directory...", 0).show();
                    launchActivity5.startActivity(new Intent(launchActivity5, (Class<?>) RepeaterDirectoryActivity.class));
                    break;
                } else if (i5 == 2) {
                    Toast.makeText(launchActivity5, "Opening Unified Repeater Map...", 0).show();
                    launchActivity5.startActivity(new Intent(launchActivity5, (Class<?>) RepeaterMapActivity.class));
                    break;
                }
                break;
            default:
                C0676b c0676b = (C0676b) obj;
                AppSettings appSettings = c0676b.f8104b;
                int i6 = AppSettings.f5842e;
                appSettings.n(true);
                h4.c.d0(c0676b.f8104b, String.valueOf(1));
                Log.w("Unified - Settings", "MARS capability has been enabled by user");
                break;
        }
    }
}
