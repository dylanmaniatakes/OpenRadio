package o3;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import com.unified.ur1.rfmodule.ROIP.DMRActivity;

/* loaded from: classes.dex */
public final class e implements AdapterView.OnItemSelectedListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8921c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DMRActivity f8922d;

    public /* synthetic */ e(DMRActivity dMRActivity, int i5) {
        this.f8921c = i5;
        this.f8922d = dMRActivity;
    }

    private final void a(AdapterView adapterView) {
    }

    private final void b(AdapterView adapterView) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i5, long j5) {
        switch (this.f8921c) {
            case 0:
                DMRActivity dMRActivity = this.f8922d;
                if (dMRActivity.f6065p) {
                    int i6 = i5 + 1;
                    dMRActivity.f6064o.setColorCode(i6);
                    Log.d("DMRActivity", "Color code set to " + i6);
                    break;
                }
                break;
            default:
                DMRActivity dMRActivity2 = this.f8922d;
                if (dMRActivity2.f6065p) {
                    int i7 = i5 + 1;
                    dMRActivity2.f6064o.setTimeSlot(i7);
                    Log.d("DMRActivity", "Time slot set to " + i7);
                    break;
                }
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i5 = this.f8921c;
    }
}
