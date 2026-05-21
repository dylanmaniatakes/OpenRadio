package k3;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.unified.ur1.primary.OptionsActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class S0 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8018a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OptionsActivity f8019b;

    public /* synthetic */ S0(OptionsActivity optionsActivity, int i5) {
        this.f8018a = i5;
        this.f8019b = optionsActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        OptionsActivity optionsActivity = this.f8019b;
        switch (this.f8018a) {
            case 0:
                int i5 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    SharedPreferences.Editor editorEdit = optionsActivity.getSharedPreferences("radioteams_settings", 0).edit();
                    editorEdit.putBoolean("KEY_RADIOTEAMS_ENABLED", z4);
                    editorEdit.apply();
                    Toast.makeText(optionsActivity, z4 ? "RadioTeams integration enabled" : "RadioTeams integration disabled", 0).show();
                    Log.d("Unified - Settings", "RadioTeams enabled set to: " + z4);
                    break;
                } catch (Exception e5) {
                    Log.e("Unified - Settings", "Error setting RadioTeams enabled", e5);
                    return;
                }
            case 1:
                int i6 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    h4.c.A0(optionsActivity, z4);
                    Toast.makeText(optionsActivity, z4 ? "Unified Messaging enabled" : "Unified Messaging disabled", 0).show();
                    Log.d("Unified - Settings", "Unified Messaging enabled set to: " + z4);
                    break;
                } catch (Exception e6) {
                    Log.e("Unified - Settings", "Error setting Unified Messaging enabled", e6);
                    return;
                }
            case 2:
                int i7 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    h4.c.h0(optionsActivity, z4);
                    Toast.makeText(optionsActivity, z4 ? "New message sounds enabled" : "New message sounds disabled", 0).show();
                    Log.d("Unified - Settings", "New message sound enabled set to: " + z4);
                    break;
                } catch (Exception e7) {
                    Log.e("Unified - Settings", "Error setting new message sound enabled", e7);
                    return;
                }
            case 3:
                int i8 = OptionsActivity.f5981H;
                optionsActivity.F();
                Toast.makeText(optionsActivity, z4 ? "Transmission disabled - RX only mode" : "Transmission enabled", 0).show();
                break;
            default:
                int i9 = OptionsActivity.f5981H;
                optionsActivity.D();
                Toast.makeText(optionsActivity, z4 ? "Metric units enabled" : "Imperial units enabled", 0).show();
                break;
        }
    }
}
