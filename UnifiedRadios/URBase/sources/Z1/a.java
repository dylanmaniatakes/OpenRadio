package Z1;

import android.content.Context;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.google.android.material.chip.Chip;
import com.unified.ur1.OnTheAir.UnifiedOnTheAirActivity;
import com.unified.ur1.adapters.SoundCustomizationActivity;
import com.unified.ur1.inbox.ComposeMessageActivity;
import com.unified.ur1.primary.LaunchActivity;
import f3.D0;
import f3.E0;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3075a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3076b;

    public /* synthetic */ a(int i5, Object obj) {
        this.f3075a = i5;
        this.f3076b = obj;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
        Object obj = this.f3076b;
        switch (this.f3075a) {
            case 0:
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = ((Chip) obj).f5262k;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z4);
                    break;
                }
                break;
            case 1:
                UnifiedOnTheAirActivity unifiedOnTheAirActivity = (UnifiedOnTheAirActivity) obj;
                unifiedOnTheAirActivity.f5570r = z4;
                unifiedOnTheAirActivity.k();
                unifiedOnTheAirActivity.q();
                break;
            case 2:
                E0 e02 = (E0) obj;
                Context context = (Context) e02.f6571i;
                try {
                    h4.c.l0(context, z4);
                    Toast.makeText(context, z4 ? "PTT sound effects enabled" : "PTT sound effects disabled", 0).show();
                    Log.d("SoundCustomizationManager", "PTT sound enabled set to: " + z4);
                    D0 d02 = (D0) e02.I;
                    if (d02 != null) {
                        Log.d("SoundCustomizationActivity", "Sound settings changed - auto-saving immediately");
                        ((SoundCustomizationActivity) d02).m();
                    }
                } catch (Exception e5) {
                    Log.e("SoundCustomizationManager", "Error setting PTT sound enabled", e5);
                }
                LinearLayout linearLayout = e02.f6565a;
                if (linearLayout != null) {
                    linearLayout.setVisibility(z4 ? 0 : 8);
                    break;
                }
                break;
            case 3:
                ComposeMessageActivity composeMessageActivity = (ComposeMessageActivity) obj;
                LinearLayout linearLayout2 = composeMessageActivity.f5805r;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(z4 ? 0 : 8);
                }
                if (!z4) {
                    Toast.makeText(composeMessageActivity, "Standard encryption mode", 0).show();
                    break;
                } else {
                    Toast.makeText(composeMessageActivity, "High encryption mode enabled", 0).show();
                    break;
                }
            default:
                Context context2 = LaunchActivity.f5853D1;
                Log.d("PTTDebug", "Switch changed to: " + z4);
                ImageButton imageButton = (ImageButton) obj;
                if (z4) {
                    imageButton.setVisibility(8);
                    Log.d("PTTDebug", "Setting button to GONE");
                } else {
                    imageButton.setVisibility(0);
                    Log.d("PTTDebug", "Setting button to VISIBLE");
                }
                Log.d("PTTDebug", "Button visibility after change: " + imageButton.getVisibility());
                break;
        }
    }
}
