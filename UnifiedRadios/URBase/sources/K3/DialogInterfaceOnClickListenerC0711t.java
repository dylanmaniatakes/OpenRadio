package k3;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import com.unified.ur1.primary.LaunchActivity;
import f.C0467d;

/* renamed from: k3.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class DialogInterfaceOnClickListenerC0711t implements DialogInterface.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8205c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8206d;

    public /* synthetic */ DialogInterfaceOnClickListenerC0711t(LaunchActivity launchActivity, int i5) {
        this.f8205c = i5;
        this.f8206d = launchActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) {
        LaunchActivity launchActivity = this.f8206d;
        switch (this.f8205c) {
            case 0:
                Context context = LaunchActivity.f5853D1;
                launchActivity.getClass();
                ProgressDialog progressDialog = new ProgressDialog(launchActivity);
                launchActivity.f5977y0 = progressDialog;
                progressDialog.setTitle("Firmware Update");
                launchActivity.f5977y0.setMessage("Updating firmware, please wait...");
                launchActivity.f5977y0.setProgressStyle(1);
                launchActivity.f5977y0.setMax(100);
                launchActivity.f5977y0.setCancelable(false);
                launchActivity.f5977y0.show();
                try {
                    new Thread(new m3.o(0, new L0.m(new B0.l(22, launchActivity)))).start();
                    break;
                } catch (Exception e5) {
                    ProgressDialog progressDialog2 = launchActivity.f5977y0;
                    if (progressDialog2 != null && progressDialog2.isShowing()) {
                        try {
                            launchActivity.f5977y0.dismiss();
                        } catch (Exception e6) {
                            Log.e("Unified - Main Activity", "Error dismissing progress dialog", e6);
                        }
                        launchActivity.f5977y0 = null;
                    }
                    String str = "Failed to start update: " + e5.getMessage();
                    L.h hVar = new L.h(launchActivity);
                    C0467d c0467d = (C0467d) hVar.f1522d;
                    c0467d.f6292d = "Update Failed";
                    c0467d.f6294f = com.unified.ur1.SatelliteTracker.h.s("Error: ", str);
                    hVar.e("OK", null);
                    hVar.f();
                    return;
                }
            case 1:
                Context context2 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                launchActivity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                break;
            case 2:
                Context context3 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                intent.setData(Uri.parse("package:" + launchActivity.getPackageName()));
                launchActivity.startActivityForResult(intent, 1001);
                break;
            case 3:
                Context context4 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                Toast.makeText(launchActivity, "Installation cancelled", 0).show();
                launchActivity.f5967u1 = null;
                dialogInterface.dismiss();
                break;
            case 4:
                Context context5 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                ProgressDialog progressDialog3 = new ProgressDialog(launchActivity);
                launchActivity.f5977y0 = progressDialog3;
                progressDialog3.setTitle("Firmware Update");
                launchActivity.f5977y0.setMessage("Updating firmware, please wait...");
                launchActivity.f5977y0.setProgressStyle(1);
                launchActivity.f5977y0.setMax(100);
                launchActivity.f5977y0.setCancelable(false);
                launchActivity.f5977y0.show();
                new Thread(new m3.o(0, new L0.m(new Z(launchActivity)))).start();
                break;
            default:
                Context context6 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                Toast.makeText(launchActivity, "You can install the update later from your Downloads folder", 1).show();
                dialogInterface.dismiss();
                break;
        }
    }
}
