package k3;

import android.content.Context;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;
import f.C0467d;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class V implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8058c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8059d;

    public /* synthetic */ V(LaunchActivity launchActivity, int i5) {
        this.f8058c = i5;
        this.f8059d = launchActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LaunchActivity launchActivity = this.f8059d;
        switch (this.f8058c) {
            case 0:
                Context context = LaunchActivity.f5853D1;
                launchActivity.getClass();
                L.h hVar = new L.h(launchActivity, R.style.Base_Theme_Material3_Dark_Dialog);
                C0467d c0467d = (C0467d) hVar.f1522d;
                c0467d.f6292d = "Firmware Update";
                c0467d.f6294f = "Are you sure you want to update the device firmware? Do not power off during update.";
                hVar.e("Update", new DialogInterfaceOnClickListenerC0711t(launchActivity, 4));
                hVar.c("Cancel", null);
                hVar.f();
                break;
            case 1:
                Context context2 = LaunchActivity.f5853D1;
                launchActivity.getClass();
                try {
                    Log.d("Download", "Starting download of latest version...");
                    launchActivity.P(launchActivity.f5937k);
                    break;
                } catch (Exception e5) {
                    Log.e("Download", "Error downloading latest version", e5);
                    return;
                }
            case 2:
                ((Vibrator) launchActivity.getSystemService("vibrator")).vibrate(100L);
                Context context3 = LaunchActivity.f5853D1;
                L.h hVar2 = new L.h(launchActivity, R.style.Base_Theme_Material3_Dark_Dialog);
                C0467d c0467d2 = (C0467d) hVar2.f1522d;
                c0467d2.f6292d = "Select Mode";
                String strY = h4.c.y(launchActivity);
                ArrayList arrayList = new ArrayList();
                if (!LaunchActivity.f5855F1) {
                    arrayList.add("Analog - FM");
                    arrayList.add("Digital - DMR");
                }
                arrayList.add("AmSAT");
                arrayList.add("Activate new ROIP Session");
                int i5 = launchActivity.f5947o;
                if (launchActivity.f5886M == 1) {
                    arrayList.add("Change Talkgroup (Existing Network)");
                    if (strY != null && strY.toLowerCase().contains("brandmeister")) {
                        arrayList.add("Brandmeister Multi-RX");
                        if (i5 != 1 && LaunchActivity.f5854E1) {
                            arrayList.add("Switch to Last Heard TG:" + i5);
                        }
                    }
                }
                String[] strArr = (String[]) arrayList.toArray(new String[0]);
                i3.k kVar = new i3.k(launchActivity, strArr, i5, 3);
                c0467d2.f6301p = strArr;
                c0467d2.f6303r = kVar;
                hVar2.c("Cancel", null);
                hVar2.b().show();
                break;
            default:
                launchActivity.settingsClicked(null);
                break;
        }
    }
}
