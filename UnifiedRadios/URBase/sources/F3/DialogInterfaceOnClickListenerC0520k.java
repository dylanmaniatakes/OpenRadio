package f3;

import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;
import com.unified.ur1.adapters.LastHeardActivity;
import com.unified.ur1.adapters.SoundCustomizationActivity;
import com.unified.ur1.inbox.ComposeMessageActivity;
import com.unified.ur1.primary.OptionsActivity;
import com.unified.ur1.radioteams.RadioTeamsActivity;
import java.io.IOException;

/* renamed from: f3.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class DialogInterfaceOnClickListenerC0520k implements DialogInterface.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6733c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6734d;

    public /* synthetic */ DialogInterfaceOnClickListenerC0520k(int i5, Object obj) {
        this.f6733c = i5;
        this.f6734d = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) throws IOException {
        int i6 = 0;
        Object obj = this.f6734d;
        switch (this.f6733c) {
            case 0:
                LastHeardActivity lastHeardActivity = (LastHeardActivity) obj;
                lastHeardActivity.f5667e.clear();
                lastHeardActivity.f5666d.notifyDataSetChanged();
                lastHeardActivity.getSharedPreferences("last_heard_prefs", 0).edit().remove("last_heard_data").apply();
                Toast.makeText(lastHeardActivity, "History cleared", 0).show();
                Log.d("LastHeardActivity", "Last heard history cleared");
                break;
            case 1:
                ((InterfaceC0512d0) obj).a(null);
                break;
            case 2:
                int i7 = SoundCustomizationActivity.f5721f;
                SoundCustomizationActivity soundCustomizationActivity = (SoundCustomizationActivity) obj;
                soundCustomizationActivity.getClass();
                soundCustomizationActivity.o("ResetAllSoundSettings", new s0(soundCustomizationActivity, i6));
                break;
            case 3:
                int i8 = ComposeMessageActivity.f5790C;
                ComposeMessageActivity composeMessageActivity = (ComposeMessageActivity) obj;
                if (i5 == 0) {
                    composeMessageActivity.getClass();
                    if (C.h.a(composeMessageActivity, "android.permission.CAMERA") == 0) {
                        composeMessageActivity.p();
                        break;
                    } else {
                        Log.d("ComposeMessageActivity", "Camera permission not granted, requesting...");
                        B.e.d(composeMessageActivity, new String[]{"android.permission.CAMERA"}, 1003);
                        break;
                    }
                } else if (i5 == 1) {
                    composeMessageActivity.o();
                    break;
                } else {
                    composeMessageActivity.getClass();
                    break;
                }
            case 4:
                int i9 = OptionsActivity.f5981H;
                OptionsActivity optionsActivity = (OptionsActivity) obj;
                optionsActivity.getClass();
                dialogInterface.dismiss();
                optionsActivity.N();
                break;
            default:
                int i10 = RadioTeamsActivity.f6010u;
                ((RadioTeamsActivity) obj).finish();
                break;
        }
    }
}
